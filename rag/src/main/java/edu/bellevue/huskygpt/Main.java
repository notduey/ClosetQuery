package edu.bellevue.huskygpt;

import edu.bellevue.huskygpt.database.PieceRepository;
import edu.bellevue.huskygpt.llm.LlmClient;
import edu.bellevue.huskygpt.llm.OpenAiLlmClient;
import edu.bellevue.huskygpt.llm.PromptBuilder;
import edu.bellevue.huskygpt.model.Piece;
import edu.bellevue.huskygpt.retrieval.EmbeddingModel;
import edu.bellevue.huskygpt.retrieval.RetrievalResult;
import edu.bellevue.huskygpt.retrieval.SemanticRetriever;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String question = "What red dress should I wear?";

        try (EmbeddingModel model = new EmbeddingModel()) {

            // Load wardrobe data from SQLite
            PieceRepository repository = new PieceRepository();
            List<Piece> pieces = repository.getAllPieces();

            // Process data and build semantic index once
            SemanticRetriever retriever =
                new SemanticRetriever(model, pieces);

            // R - Retrieve top relevant results
            List<RetrievalResult> results = retriever.retrieve(question, 3);

            System.out.println("Retrieved:");
            for (RetrievalResult result : results) {
                System.out.printf(
                    ".f - %s %s%n",
                    result.similarityScore(),
                    result.piece().getBrand(),
                    result.piece().getName()
                );
            }
            System.out.println();

            // A - Augment user's question with retrieved information
            String prompt = PromptBuilder.build(question, results); // build prompt

            // G - Generate a (grounded) answer from external LLM
            LlmClient llmClient = new OpenAiLlmClient();
            String answer = llmClient.generate(prompt);

            System.out.println("Question");
            System.out.println(question);
            System.out.println("\nAnswer:");
            System.out.println(answer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Run after compiling:
// mvn exec:java

// Export and verify API key:
// export OPENAI_API_KEY="..."
// if [ -n "$OPENAI_API_KEY" ]; then echo "API key detected"s