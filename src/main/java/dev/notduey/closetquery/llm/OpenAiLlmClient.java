package dev.notduey.closetquery.llm;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Sends prompts to the OpenAI Responses API and returns generated text.
 *
 * <p>This client uses Java's built-in {@link HttpClient} instead of an
 * OpenAI-specific SDK. Jackson is only used to build and parse the JSON
 * request and response bodies.</p>
 *
 * <p>The API key is loaded from the OPENAI_API_KEY environment variable so
 * credentials never need to be stored directly in the source code.</p>
 */
public class OpenAiLlmClient implements LlmClient {

    // Models: developers.openai.com/api/docs/models
    private static final String MODEL = "gpt-5.6-luna"; // 5.6 luna: fast and cost effective

    // Define API endpoint the client will send requests to
    private static final URI RESPONSES_URI =
        URI.create("https://api.openai.com/v1/responses");

    // Jackson mapper for converting between Java objects and JSON
    private final ObjectMapper objectMapper;

    private final String apiKey;
    private final HttpClient httpClient;

    /**
     * Creates the OpenAI client and loads the API key from the environment.
     *
     * @throws IllegalStateException if OPENAI_API_KEY is missing or empty
     */
    public OpenAiLlmClient() {
        // Get API key from environment
        apiKey = System.getenv("OPENAI_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("OPENAI_API_KEY environment variable not set.");
        }

        // JSON mapper
        objectMapper = new ObjectMapper();

        // HTTP client for sending API requests
        httpClient = HttpClient.newHttpClient();
    }

    /**
     * Sends a prompt to the configured OpenAI model and extracts the generated
     * text from the API response.
     *
     * <p>The prompt is serialized into the Responses API request format, sent as
     * an HTTP POST request, and then parsed back from JSON. Non-successful HTTP
     * responses are treated as errors instead of trying to continue with an
     * incomplete response.</p>
     *
     * @param prompt prompt to send to the model
     * @return generated output text from the response
     * @throws Exception if the request cannot be sent, parsed, or does not
     *                   contain output text
     */
    @Override // implement LlmClient generation method
    public String generate(String prompt) throws Exception {
        // Create Java object representing JSON body of API request
        ResponseRequest requestData = new ResponseRequest(
            MODEL,
            prompt, // prompt from PromptBuilder
            new Reasoning("none"), // reasoning settings
            200 // limit of output tokens
        );

        // Serialize/convert request object to JSON string
        String requestBody = objectMapper.writeValueAsString(requestData);

        // Build API request
        HttpRequest request = HttpRequest.newBuilder()
            .uri(RESPONSES_URI) // API endpoint
            .header("Authorization", "Bearer " + apiKey) // bearer-token authentication
            .header("Content-Type", "application/json") // request body is JSON
            .POST(HttpRequest.BodyPublishers.ofString(requestBody)) // send requestBody as POST request
            .build(); // finish immutable request object

        // Send API request
        HttpResponse<String> response = httpClient.send(
            request,
            HttpResponse.BodyHandlers.ofString() // convert HTTP response body to Java string
        );

        // Treat only 2xx status codes as successful responses
        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new IllegalStateException(
                "OpenAI request failed with status "
                    + response.statusCode()
                    + ": "
                    + response.body()
            );
        }

        // Deserialize JSON into JsonNode
        JsonNode root = objectMapper.readTree(response.body());

        // Parse JSON response
        // Iterate through output text
        for (JsonNode output : root.path("output")) {
            //Iterate through output text in each output
            for (JsonNode content : output.path("content")) {
                // Find content type "output_text" and return its text
                if ("output_text".equals(content.path("type").asString())) {
                    return content.path("text").asString(); // return output text
                }
            }
        }

        throw new IllegalStateException("OpenAI response contained no output text.");
    }

    /**
     * Reasoning configuration included in the API request.
     */
    private record Reasoning(String effort) {
    }

    /**
     * Represents the JSON request body sent to the Responses API.
     *
     * @param model model used for generation
     * @param input prompt sent to the model
     * @param reasoning reasoning configuration
     * @param max_output_tokens maximum number of tokens the model may generate
     */
    private record ResponseRequest(
        String model,
        String input,
        Reasoning reasoning,
        int max_output_tokens) {
    }
    
}