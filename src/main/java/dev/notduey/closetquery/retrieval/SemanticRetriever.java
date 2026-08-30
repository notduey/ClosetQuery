package dev.notduey.closetquery.retrieval;

import ai.onnxruntime.OrtException;
import dev.notduey.closetquery.model.Piece;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Performs semantic retrieval using cached embeddings for each wardrobe piece.
 *
 * <p>Piece embeddings are generated once when the retriever is created and
 * stored in memory. For each user query, only the query itself needs to be
 * embedded before comparing it against the cached piece embeddings.</p>
 *
 * <p>This avoids repeatedly running the embedding model on the full wardrobe
 * for every question.</p>
 */
public class SemanticRetriever {

    private final EmbeddingModel model;
    private final List<IndexedPiece> index;

    /**
     * Builds the semantic index for the current wardrobe.
     *
     * <p>Each Piece is first converted into semantic text, embedded with the local
     * model, and stored together with its embedding for later similarity search.</p>
     *
     * @param model embedding model used to generate vectors
     * @param pieces wardrobe pieces to add to the semantic index
     * @throws OrtException if an embedding cannot be generated
     */
    public SemanticRetriever(EmbeddingModel model, List<Piece> pieces) throws OrtException {
        this.model = model;
        this.index = new ArrayList<>();

        // Pre-embed pieces
        for (Piece p : pieces) {
            String pieceText = PieceTextFormatter.format(p); // format piece
            float[] embedding = model.embed(pieceText); // embed piece

            index.add(new IndexedPiece(p, embedding));
        }
    }

    /**
     * Finds the wardrobe pieces most semantically similar to a user query.
     *
     * <p>The query is embedded once and compared against every cached piece
     * embedding using cosine similarity. Results are sorted from highest to
     * lowest similarity before returning the top matches.</p>
     *
     * @param query user question or description to search for
     * @param k maximum number of results to return
     * @return top matching pieces along with their similarity scores
     * @throws OrtException if the query embedding cannot be generated
     */
    public List<RetrievalResult> retrieve(
        String query, // user query
        int k // top-k results
    ) throws OrtException {

        // Validate k
        if (k <= 0) {
            throw new IllegalArgumentException("k must be greater than 0.");
        }
        
        float[] queryEmbedding = model.embed(query); // embed user query
        List<RetrievalResult> results = new ArrayList<>();

        // Compute cosine similarity between query embedding and precomputed embeddings
        for (IndexedPiece p : index) {
            float similarity = EmbeddingModel.cosineSimilarity(queryEmbedding, p.embedding());

            results.add(new RetrievalResult(p.piece(), similarity));
        }

        // sort results by similarity score (descending)
        results.sort(
            Comparator.comparing(RetrievalResult::similarityScore).reversed()
        );
    
        // return top (at most) k results
        return results.subList(0, Math.min(k, results.size()));
    }
}