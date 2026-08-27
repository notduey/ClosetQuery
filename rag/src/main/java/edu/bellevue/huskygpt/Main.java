package edu.bellevue.huskygpt;

import edu.bellevue.huskygpt.database.DatabaseInitializer;
import edu.bellevue.huskygpt.database.DatabaseSeeder;
import edu.bellevue.huskygpt.model.Piece;

import edu.bellevue.huskygpt.database.PieceRepository;
import edu.bellevue.huskygpt.retrieval.PieceTextFormatter;

import edu.bellevue.huskygpt.retrieval.EmbeddingModel;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // // make sure required db tables exist
        // DatabaseInitializer.initialize();

        // // seed with sample data
        // DatabaseSeeder.seed();

        // // get db rows as Piece objects
        // List<Piece> pieces = PieceRepository.getAllPieces();

        // // print all pieces
        // for (Piece p : pieces) {
        //     String retrievalText = PieceTextFormatter.format(p); // convert piece to embedding text

        //     System.out.println(retrievalText);
        //     System.out.println();
        // }

        try (EmbeddingModel model = new EmbeddingModel()) {
            float[] reference = model.embed(
                "A lightweight insulated jacket for cold weather."
            );

            float[] similar = model.embed(
                "A warm jacket suitable for cool temperatures."
            );

            float[] unrelated = model.embed(
                "A breathable linen shirt for tropical climates."
            );

            float selfScore = EmbeddingModel.cosineSimilarity(similar, similar);
            float similarityScore = EmbeddingModel.cosineSimilarity(reference, similar);
            float unrelatedScore = EmbeddingModel.cosineSimilarity(reference, unrelated);

            System.out.println("Self similarity: " + selfScore); // should be ~1
            System.out.println("Similarity score: " + similarityScore); // should be higher than unrelated
            System.out.println("Unrelated score: " + unrelatedScore);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Run after compiling:
// mvn exec:java