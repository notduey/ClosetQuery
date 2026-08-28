package edu.bellevue.huskygpt.retrieval;

import ai.onnxruntime.OrtException;
import edu.bellevue.huskygpt.model.Piece;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Performs semantic retrieval using precomputed piece embeddings
 */
public class SemanticRetriever {

    private final EmbeddingModel model;
    private final List<IndexedPiece> index;

    public SemanticRetriever( EmbeddingModel model, List<Piece> pieces) throws OrtException {
        this.model = model;
        this.index = new ArrayList<>();

        // Pre-embed pieces
        for (Piece p : pieces) {
            String pieceText = PieceTextFormatter.format(p); // format piece
            float[] embedding = model.embed(pieceText); // embed piece

            index.add(new IndexedPiece(p, embedding));
        }
    }

    public List<RetrievalResult> retrieve(
        String query, // user query
        int k // top-k results
    ) throws OrtException {
        
        float[] queryEmbedding = model.embed(query); // embed user query
        List<RetrievalResult> results = new ArrayList<>();

        // Compute cosine similarity between query embeddind and precomputed embeddings
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