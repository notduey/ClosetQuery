package dev.notduey.closetquery.llm;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

/**
 * Classifies wardrobe questions into the retrieval paths ClosetQuery supports.
 *
 * <p>The LLM is only responsible for interpreting the user's intent and
 * returning a small structured result. It does not generate SQL or choose
 * arbitrary database operations.</p>
 *
 * <p>This keeps the natural-language flexibility of an LLM while still
 * letting Java control which retrieval types are actually allowed.</p>
 */
public class QueryRouter {

    private final LlmClient llmClient;
    private final ObjectMapper objectMapper;

    /**
     * Creates a query router using the configured LLM client.
     *
     * @param llmClient client used to classify natural-language questions
     */
    public QueryRouter(LlmClient llmClient) {
        this.llmClient = llmClient;
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Classifies a wardrobe question into a supported retrieval intent.
     *
     * <p>The question is first turned into a classification prompt, sent to the
     * LLM, and then parsed into a {@link QueryIntent} that the rest of the app can
     * use for retrieval.</p>
     *
     * @param question wardrobe question to classify
     * @return structured retrieval intent
     * @throws Exception if the LLM request or JSON parsing fails
     */
    public QueryIntent classify(String question) throws Exception {
        String classificationPrompt = buildClassificationPrompt(question);

        String response = llmClient.generate(classificationPrompt);

        return parseIntent(response);
    }

    /**
     * Builds the prompt that tells the LLM how to route a question.
     *
     * <p>The prompt limits the model to predefined retrieval types, supported
     * wardrobe categories, and a small result limit so its output stays predictable
     * and easy for Java to handle.</p>
     *
     * @param question original wardrobe question
     * @return classification prompt sent to the LLM
     */
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

    /**
     * Converts the LLM's JSON response into a QueryIntent.
     *
     * <p>The retrieval type is converted into the corresponding enum so unsupported
     * values fail instead of being silently accepted.</p>
     *
     * @param response JSON classification returned by the LLM
     * @return parsed query intent
     * @throws Exception if the response cannot be parsed or contains an invalid type
     */
    private QueryIntent parseIntent(String response) throws Exception {
        JsonNode root = objectMapper.readTree(response);

        // Convert JSON "type" string to corresponding QueryIntent (RetrievalType) enum
        QueryIntent.RetrievalType type = QueryIntent.RetrievalType.valueOf(
            root.path("type").asString()
        );

        JsonNode categoryNode = root.path("category");

        String category = categoryNode.isNull() ? null : categoryNode.asString(); // category optional

        int limit = root.path("limit").asInt(3);

        // ensure limit 1 or 3, default 3
        if (limit != 1 && limit != 3) {
            limit = 3;
        }

        return new QueryIntent(
            type,
            category,
            limit
        );
    }
}
