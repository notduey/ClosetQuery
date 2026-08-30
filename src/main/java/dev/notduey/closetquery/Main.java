package dev.notduey.closetquery;

import dev.notduey.closetquery.database.DatabaseInitializer;
import dev.notduey.closetquery.database.DatabaseSeeder;
import dev.notduey.closetquery.database.PieceRepository;
import dev.notduey.closetquery.llm.LlmClient;
import dev.notduey.closetquery.llm.OpenAiLlmClient;
import dev.notduey.closetquery.retrieval.EmbeddingModel;

/**
 * Entry point for ClosetQuery.
 *
 * <p>Initializes the SQLite database, embedding model, repository,
 * LLM client, and terminal application before starting the main
 * application loop.</p>
 */
public class Main {

    /**
     * Starts ClosetQuery and initializes the resources needed by the app.
     *
     * @param args command-line arguments; currently unused
     */
    public static void main(String[] args) {
        try {
            // Initialize repository
            DatabaseInitializer.initialize();

            // DatabaseSeeder.seed(); // uncomment to reseed database

            // Initialize embedding model
            try (EmbeddingModel model = new EmbeddingModel()) {
                
                // Initialize database
                PieceRepository repository = new PieceRepository();

                // Initialize llm
                LlmClient llmClient = new OpenAiLlmClient();

                // Initialize app
                WardrobeApp app = new WardrobeApp(
                    repository,
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