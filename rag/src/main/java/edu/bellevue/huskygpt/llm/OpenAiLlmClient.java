package edu.bellevue.huskygpt.llm;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Sends prompts to OpenAI Responses API
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

    @Override // override LlmClieant  method
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
            .build(); // finish immmutable request object

        // Send API request
        HttpResponse<String> response = httpClient.send(
            request,
            HttpResponse.BodyHandlers.ofString() // convert HTTP response body to Java string
        );

        // Successful response status codes are generally 2xx
        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new IllegalStateException(
                "OpenAI request failed with status "
                    + response.statusCode()
                    + ": "
                    + response.body()
            );
        }

        // Parse JSON into JsonNode
        JsonNode root = objectMapper.readTree(response.body());

        // Iterate through output text
        for (JsonNode output : root.path("output")) {
            //Iterate through output text in each output
            for (JsonNode content : output.path("content")) {
                // Find content with type "output_text" and return its text
                if ("output_text".equals(content.path("type").asString())) {
                    return content.path("text").asString(); // return output text
                }
            }
        }

        throw new IllegalStateException("OpenAI response contained no output text.");
    }

    // Represents reasoning settings sent in API request
    private record Reasoning(String effort) {
    }

    // Represents JSON body send to API
    private record ResponseRequest(
        String model,
        String input,
        Reasoning reasoning,
        int max_output_tokens) {
    }
    
}