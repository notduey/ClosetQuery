package edu.bellevue.huskygpt.llm;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

/**
 * Classifies wardrobe questions into supported retrieval types
 */
public class QueryRouter {

    private final LlmClient llmClient;
    private final ObjectMapper objectMapper;

    public QueryRouter(LlmClient llmClient) {
        this.llmClient = llmClient;
        this.objectMapper = new ObjectMapper();
    }

    public QueryIntent classify(String question) throws Exception {
        String classificationPrompt = buildClassificationPrompt(question);

        String response = llmClient.generate(classificationPrompt);

        return parseIntent(response);
    }

    private String buildClassificationPrompt(String question) {
        return """
            Classify the wardrobe question into exactly one retrieval type.

            Allowed retrieval types:
            SEMANTIC
            MOST_WORN
            LEAST_WORN
            NEVER_WORN
            MOST_RECENTLY_WORN
            LEAST_RECENTLY_WORN
            RECENTLY_ADDED
            LIST_CATEGORY
            COUNT_CATEGORY

            Category must be one of:
            Top
            Bottom
            Outerwear
            Full-body
            Footwear
            Undergarment
            Accessory

            If no category is explicitly implied, use null.
            Use LIST_CATEGORY when user asks to list/show all pieces in a category.
            Use COUNT_CATEGORY when user asks how many pieces they have in a category.

            Use SEMANTIC for descriptive or recommendation questions that
            are not primarily asking about wear counts or dates.

            Set limit to 1 when the question clearly asks for a single piece, otherwise use 3.

            Return only valid JSON in this exact structure:
            {
                "type": "SEMANTIC",
                "category": null,
                "limit": 3
            }

            Question:
            """ + question; // null means search all (does not restrict to one category)
    }

    private QueryIntent parseIntent(String response) throws Exception {
        JsonNode root = objectMapper.readTree(response);

        // Convert JSON "type" string to corresponding QueryIntent (RetrievalType) enum
        QueryIntent.RetrievalType type = QueryIntent.RetrievalType.valueOf(
            root.path("type").asString()
        );

        JsonNode categoryNode = root.path("category");

        String category = categoryNode.isNull() ? null : categoryNode.asString(); // category optional

        int limit = root.path("limit").asInt(3);

        return new QueryIntent(
            type,
            category,
            limit
        );
    }
}
