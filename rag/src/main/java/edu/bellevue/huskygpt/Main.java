package edu.bellevue.huskygpt;

import edu.bellevue.huskygpt.database.DatabaseInitializer;
import edu.bellevue.huskygpt.database.DatabaseSeeder;

import edu.bellevue.huskygpt.model.Piece;
import edu.bellevue.huskygpt.database.PieceRepository;
import edu.bellevue.huskygpt.retrieval.NaiveSemanticRetriever;
import edu.bellevue.huskygpt.retrieval.RetrievalResult;
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
        //     String retrievalText = PieceTextFormatter.format(p); // convert piece to formatted text

        //     System.out.println(retrievalText);
        //     System.out.println();
        // }

        try (EmbeddingModel model = new EmbeddingModel()) {
            PieceRepository repository = new PieceRepository();

            // Get all pieces from db
            List<Piece> pieces = repository.getAllPieces();

            // Create retriever
            NaiveSemanticRetriever retriever = new NaiveSemanticRetriever(model);

            // Get top 3 pieces with highest similarity score
            List<RetrievalResult> results = retriever.retrieve(
                "What should I wear in hot weather?",
                pieces,
                10);

            // for each result display similarity score and piece
            for (RetrievalResult result : results) {
                Piece piece = result.piece();

                System.out.printf(
                    "%.4f - %s %s%n",
                    result.similarityScore(),
                    piece.getBrand(),
                    piece.getName()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Run after compiling:
// mvn exec:java

// Results from running code above:
// 0.6153 - COS Relaxed Linen Shirt
// 0.6093 - Uniqlo AIRism Oversized T-Shirt
// 0.5923 - Vintage Wool Cardigan
// 0.5870 - Stussy 8-Ball Knit Sweater
// 0.5836 - Patagonia Nano Puff Jacket
// 0.5684 - Carhartt WIP Detroit Jacket
// 0.5526 - Adidas Track Pants
// 0.5461 - Nike Air Max 1
// 0.5112 - Dr. Martens 1461 Leather Shoes
// 0.4816 - Levi's 501 Original Fit Jeans