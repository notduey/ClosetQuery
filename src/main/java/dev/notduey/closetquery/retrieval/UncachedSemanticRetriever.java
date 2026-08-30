package dev.notduey.closetquery.retrieval;

import ai.onnxruntime.OrtException;
import dev.notduey.closetquery.model.Piece;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Reference implementation of semantic retrieval before embedding caching
 * was introduced.
 *
 * <p>This version recomputes embeddings for every wardrobe piece on each
 * query. It is retained to document the initial implementation and show why
 * the cached {@link SemanticRetriever} is more efficient.</p>
 */
public class UncachedSemanticRetriever {

    private final EmbeddingModel model;

    /**
     * Creates the uncached retriever using the local embedding model.
     *
     * @param model embedding model used for query and piece embeddings
     */
    public UncachedSemanticRetriever(EmbeddingModel model) {
        this.model = model;
    }

    /**
     * Performs semantic retrieval without caching wardrobe embeddings.
     *
     * <p>The query is embedded once, but every wardrobe piece is formatted and
     * embedded again for every search. This makes the method useful as a reference
     * implementation for comparing against the cached {@link SemanticRetriever}.</p>
     *
     * @param query user question or search text
     * @param pieces wardrobe pieces to search through
     * @param k maximum number of results to return
     * @return top matching pieces with their similarity scores
     * @throws OrtException if any embedding operation fails
     */
    public List<RetrievalResult> retrieve(
        String query, // user query
        List<Piece> pieces, // list of all wardrobe Piece objects
        int k // top-k results
    ) throws OrtException {

        float[] queryEmbedding = model.embed(query); // embed user query
        List<RetrievalResult> results = new ArrayList<>();

        // Inefficient as every query recomputes embedding for all pieces instead of caching them
        // If wardrobe has 100 pieces and user sends 10 queries, this takes 10 * 100 = 1000 embeddings
        for (Piece p : pieces) {
            String pieceText = PieceTextFormatter.format(p); // format piece
            float[] pieceEmbedding = model.embed(pieceText); // embed piece

            float similarity = EmbeddingModel.cosineSimilarity(pieceEmbedding, queryEmbedding);

            results.add(new RetrievalResult(p, similarity)); // add piece and similarity to results
        }

        // sort results by similarity score (descending)
        results.sort(
            Comparator.comparing(RetrievalResult::similarityScore).reversed()
        ); // RetrievalResult::similarityScore means for each RetrievalResult, gets its similarityScore

        // return top (at most) k results
        return results.subList(0, Math.min(k, results.size()));
    }
}