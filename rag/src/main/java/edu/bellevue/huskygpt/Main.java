package edu.bellevue.huskygpt;

import edu.bellevue.huskygpt.database.DatabaseInitializer;
import edu.bellevue.huskygpt.database.DatabaseSeeder;

import edu.bellevue.huskygpt.model.Piece;
import edu.bellevue.huskygpt.database.PieceRepository;

import edu.bellevue.huskygpt.retrieval.EmbeddingModel;
import edu.bellevue.huskygpt.retrieval.SemanticRetriever;
import edu.bellevue.huskygpt.retrieval.RetrievalResult;

import edu.bellevue.huskygpt.llm.PromptBuilder;

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
            SemanticRetriever retriever = new SemanticRetriever(model, pieces);
            
            // Perform retrieval
            List<RetrievalResult> results = retriever.retrieve(
                "What should I wear when hiking in snowy mountains?",
                3
            );

            // // For each result display similarity score and piece
            // for (RetrievalResult result : results) {
            //     Piece piece = result.piece();

            //     System.out.printf(
            //         "%.4f - %s %s%n",
            //         result.similarityScore(),
            //         piece.getBrand(),
            //         piece.getName()
            //     );
            // }

            // Build prompt
            String prompt = PromptBuilder.build(
                "What should I wear when hiking in snowy mountains?",
                results
            );
            System.out.println(prompt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Run after compiling:
// mvn exec:java

// Results from running query "What should I wear when hiking in snowy mountains?":
/*
Answer the question using only the retrieved wardrobe information below.
Do not use outside knowledge.
If the question is not related to the wardrobe, say that no information is available.
If the retrieved information does not contain enough information to answer,
say that no information is available.

Retrieved wardrobe information:
1. Patagonia Nano Puff Jacket. Black color. Category: Outerwear. Size: M. Regular fit. Made from Recycled polyester. Suitable for Fall/Winter use. Occasion: Casual. Notes: Lightweight insulated jacket for cool weather and layering.
2. Vintage Wool Cardigan. Gray color. Category: Top. Size: L. Oversized fit. Made from Wool blend. Suitable for Fall/Winter use. Occasion: Casual. Notes: Warm oversized cardigan useful for layering.
3. Adidas Track Pants. Black color. Category: Bottom. Size: M. Slim fit. Made from Polyester. Suitable for All-Season use. Occasion: Casual. Notes: Lightweight athletic pants for casual wear.

Question: What should I wear when hiking in snowy mountains?
*/