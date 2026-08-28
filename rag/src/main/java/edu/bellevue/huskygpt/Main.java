package edu.bellevue.huskygpt;

import edu.bellevue.huskygpt.retrieval.EmbeddingModel;
import edu.bellevue.huskygpt.database.PieceRepository;
import edu.bellevue.huskygpt.database.DatabaseInitializer;
import edu.bellevue.huskygpt.database.DatabaseSeeder;
import edu.bellevue.huskygpt.llm.LlmClient;
import edu.bellevue.huskygpt.llm.OpenAiLlmClient;

public class Main {
    public static void main(String[] args) {

        try {
            // Initialize database if it doesn't exist
            // Run Main twice if you want to reset the database
            DatabaseInitializer.initialize();
            // DatabaseSeeder.seed(); // uncomment to reseed database

            // Initialize embedding model
            try (EmbeddingModel model = new EmbeddingModel()) {
                
                // Initialize database
                PieceRepository Repository = new PieceRepository();

                // Initialize llm
                LlmClient llmClient = new OpenAiLlmClient();

                // Initialize app
                WardrobeApp app = new WardrobeApp(
                    Repository,
                    model,
                    llmClient);

                app.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            System.out.println("Application failed to start:");
            e.printStackTrace();
        }
    }
}

// Run after compiling:
// mvn exec:java

// Export and verify API key:
// export OPENAI_API_KEY="..."

// Check if API key is set:
// if [ -n "$OPENAI_API_KEY" ]; then echo "API key detected"s