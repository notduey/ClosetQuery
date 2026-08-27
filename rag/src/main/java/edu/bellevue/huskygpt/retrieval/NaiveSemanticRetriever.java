package edu.bellevue.huskygpt.retrieval;

import edu.bellevue.huskygpt.model.Piece;

import ai.onnxruntime.OrtException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Reference implementation of semantic retrieval
 * 
 * Re-embeds every wardrobe piece for each query to make the retrieval process explicit
 * The main semantic retrieval used in final version will use a pre-cached version
 */
public class NaiveSemanticRetriever {

    private final EmbeddingModel model;

    public NaiveSemanticRetriever(EmbeddingModel model) {
        this.model = model;
    }

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