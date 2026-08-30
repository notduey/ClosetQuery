package dev.notduey.closetquery.retrieval;

import ai.djl.huggingface.tokenizers.HuggingFaceTokenizer;
import ai.djl.huggingface.tokenizers.Encoding;
import ai.onnxruntime.OrtEnvironment;
import ai.onnxruntime.OrtException;
import ai.onnxruntime.OrtSession;
import ai.onnxruntime.OnnxTensor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Loads and runs the local BGE embedding model used for semantic retrieval.
 *
 * <p>The model runs locally through ONNX Runtime on the CPU. Text is first
 * tokenized with the matching Hugging Face tokenizer, passed through the
 * model, pooled into a single embedding vector, and L2-normalized before
 * being used for similarity search.</p>
 *
 * <p>This class also owns the ONNX session, so it implements
 * {@link AutoCloseable} to make sure the native model resources are released
 * when the application shuts down.</p>
 */
public class EmbeddingModel implements AutoCloseable {

    private static final Path MODEL_PATH =
        Path.of("models/bge-small-en-v1.5/model.onnx"); // local ONNX model file

    private static final Path TOKENIZER_PATH =
        Path.of("models/bge-small-en-v1.5/tokenizer.json"); // Hugging Face tokenizer config file

    private final OrtEnvironment env;
    private final OrtSession session;
    private final HuggingFaceTokenizer tokenizer;

    /**
     * Loads the local ONNX model and its matching tokenizer.
     *
     * @throws OrtException if the ONNX model cannot be loaded
     * @throws IOException if the tokenizer configuration cannot be loaded
     */
    public EmbeddingModel() throws OrtException, IOException {
        env = OrtEnvironment.getEnvironment(); // shared ONNX Runtime environment

        session = env.createSession(
            MODEL_PATH.toString(),
            new OrtSession.SessionOptions()
        ); // load BGE model into ONNX inference session

        tokenizer = HuggingFaceTokenizer.newInstance(
            TOKENIZER_PATH
        ); // load the tokenizer expected by BGE model
    }

    /**
     * Closes the ONNX inference session and releases its native resources.
     *
     * @throws OrtException if the session cannot be closed cleanly
     */
    @Override
    public void close() throws OrtException {
        session.close(); // close native ONNX session and resources
    }

    /**
     * Converts text into a normalized embedding vector for semantic retrieval.
     *
     * <p>The text is tokenized, converted into the tensor inputs expected by
     * BGE, and passed through the ONNX model. The final hidden state of the
     * tokenizer-added [CLS] token is used as the sentence embedding.</p>
     *
     * <p>The resulting vector is L2-normalized so semantic similarity is based
     * on vector direction rather than magnitude. This also lets cosine
     * similarity be calculated with a simple dot product later.</p>
     *
     * @param text text to embed
     * @return normalized embedding vector
     * @throws OrtException if model inference fails
     */
    public float[] embed(String text) throws OrtException {
        Encoding encoding = tokenizer.encode(text); // tokenize raw text for embedding

        // long[] as ONNX model tensors are 64-bit integers
        long[] ids = encoding.getIds(); // return numerical IDs corresponding to tokens
        long[] attentionMask = encoding.getAttentionMask(); // return attention mask
        long[] typeIds = encoding.getTypeIds(); // return type IDs

        // Neural networks expect inputs with shape [batchSize, sequenceLength]
        // Add batch dimension [sequenceLength] -> [1, sequenceLength]
        long[][] batchedIds = { ids };
        long[][] batchedAttentionMask = { attentionMask };
        long[][] batchedTypeIds = { typeIds };

        // Convert arrays into ONNX tensors the model can consume
        try (
            OnnxTensor idsTensor = OnnxTensor.createTensor(env, batchedIds);

            OnnxTensor attentionMaskTensor = OnnxTensor.createTensor(env, batchedAttentionMask);

            OnnxTensor typeIdsTensor = OnnxTensor.createTensor(env, batchedTypeIds);
        ) {
            // Map each ONNX input name to its corresponding tensor
            // Names must match input names defined in ONNX model
            Map<String, OnnxTensor> inputs = new HashMap<>();

            inputs.put("input_ids", idsTensor);
            inputs.put("attention_mask", attentionMaskTensor);
            inputs.put("token_type_ids", typeIdsTensor);

            // Execute model inference using the input tensors
            try (
                OrtSession.Result result = session.run(inputs) // run neural network
            ) {
                // Get model's first output tensor and cast it to OnnxTensor
                OnnxTensor outputTensor = (OnnxTensor) result.get(0);

                // Extract token embeddings as [batchSize][sequenceLength][hiddenSize]
                float[][][] lastHiddenState = (float[][][]) outputTensor.getValue();

                // CLS pooling uses tokenizer-added [CLS] token's final hidden state as sentence embedding
                // clone [CLS] vector so normalization doesn't modify model output
                float[] embedding = lastHiddenState[0][0].clone();

                // Sementic similarity compares embedding vectors by direction, not magnitude
                // Normalization also makes cosine similarity equivalent to a dot product
                normalize(embedding);

                return embedding;
            }
        }
    }

    /**
     * L2-normalizes an embedding vector in place.
     *
     * <p>After normalization the vector has a magnitude of 1, which simplifies
     * cosine-similarity calculations during retrieval.</p>
     *
     * @param vector embedding vector to normalize
     */
    private void normalize(float[] vector) {
        double sumSquare = 0.0; // sum of squares

        for (float value : vector) {
            sumSquare += value * value;
        }

        double magnitude = Math.sqrt(sumSquare); // sqrt of sum of squares (L2 norm/vector length)

        if (magnitude == 0.0) {
            return; // avoid division by zero
        }

        // Scale each vector to length 1 by dividing by L2 norm
        for (int i = 0; i < vector.length; i++) {
            vector[i] /= (float) magnitude;
        }
    }

    /**
     * Calculates cosine similarity between two normalized embedding vectors.
     *
     * <p>Because embeddings are normalized when they are created, cosine
     * similarity is equivalent to their dot product here.</p>
     *
     * @param v1 first embedding vector
     * @param v2 second embedding vector
     * @return similarity score between the two vectors
     * @throws IllegalArgumentException if the vectors have different dimensions
     */
    public static float cosineSimilarity(float[] v1, float[] v2) {
        if (v1.length != v2.length) {
            throw new IllegalArgumentException("Embedding vector dimensions must match.");
        }

        float similarity = 0.0f;

        for (int i = 0; i < v1.length; i++) {
            similarity += v1[i] * v2[i]; // dot product of normalized vectors
        }

        return similarity;
    }

    /**
     * Prints tokenization details for a piece of text.
     *
     * <p>This was mainly used while verifying that the tokenizer produced the
     * IDs and attention masks expected by the embedding model.</p>
     *
     * @param text text to tokenize and inspect
     */
    public void testTokenization(String text) {
        var encoding = tokenizer.encode(text); // tokenize text into model-compatible IDs

        long[] ids = encoding.getIds(); // return numerical IDs corresponding to tokens
        long[] attentionMask = encoding.getAttentionMask(); // return attention mask

        System.out.println("Token count: " + ids.length);

        // print up to 10 first token IDs and attention mask values
        System.out.print("First Token IDs: ");
        for (int i = 0; i < Math.min(ids.length, 10); i++) {
            System.out.print(ids[i] + " ");
        }

        System.out.println();

        System.out.print("First attention mask values: ");
        for (int i = 0; i < Math.min(attentionMask.length, 10); i++) {
            System.out.print(attentionMask[i] + " ");
        }

        System.out.println();
    }

    /**
     * Prints the input names and shapes expected by the ONNX model.
     *
     * <p>This is a small inspection helper that was useful while wiring the Java
     * tensors to the model's required input names.</p>
     *
     * @throws OrtException if the model input metadata cannot be read
     */
    public void printModelInputs() throws OrtException {
        session.getInputInfo().forEach((name, info) -> {
            System.out.println(name + " -> " + info); // inspect model input names and shapes
        });
   }
}