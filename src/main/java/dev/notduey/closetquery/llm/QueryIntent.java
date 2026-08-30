package dev.notduey.closetquery.llm;

/**
 * Represents how wardrobe question should be retrieved
 */
public record QueryIntent(
    RetrievalType type,
    String category,
    int limit
) {
    // Fixed set of retrieval types for wardrobe queries
    public enum RetrievalType {
        SEMANTIC,
        MOST_WORN,
        LEAST_WORN,
        NEVER_WORN,
        MOST_RECENTLY_WORN,
        LEAST_RECENTLY_WORN,
        RECENTLY_ADDED,
        LIST_CATEGORY,
        COUNT_CATEGORY
    }
}
