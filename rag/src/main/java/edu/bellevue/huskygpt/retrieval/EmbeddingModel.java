package edu.bellevue.huskygpt.retrieval;

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
 * Loads and manages local BGE embedding model used for semantic retrieval
 */
public class EmbeddingModel implements AutoCloseable{

    private static final Path MODEL_PATH =
        Path.of("models/bge-small-en-v1.5/model.onnx"); // local ONNX model file

    private static final Path TOKENIZER_PATH =
        Path.of("models/bge-small-en-v1.5/tokenizer.json"); // Hugging Face tokenizer config file

    private final OrtEnvironment env;
    private final OrtSession session;
    private final HuggingFaceTokenizer tokenizer;

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

    @Override
    public void close() throws OrtException {
        session.close(); // close native ONNX session and resources
    }

    /**
     * Embeds (formatted) text for semantic retrieval
     */
    public float[] embed(String text) throws OrtException {
        Encoding encoding = tokenizer.encode(text); // tokenize raw text for embedding

        // long[] as ONNX model tensors are 64-bit integers
        long[] ids = encoding.getIds(); // return numerical IDs corresponding to tokens
        long[] attentionMask = encoding.getAttentionMask(); // return attention mask
        long[] typeIds = encoding.getTypeIds(); /// return type IDs

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

                // Sementic similarity compares embedding vectors on direction, not magnitude
                // Normalization also makes cosine similarity equivalent to a dot product
                normalize(embedding);

                return embedding;
            }
        }
    }

    /**
     * Private helper function to perform L2 normalization
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
     * Test function that calculates cosine similarity between two embedding vectors
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
     * Test function to tokenize text and print tokens and attention mask values.
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
    * Test function to print model input names and shapes
    */
    public void printModelInputs() throws OrtException {
        session.getInputInfo().forEach((name, info) -> {
            System.out.println(name + " -> " + info); // inspect model input names and shapes
        });
   }
}