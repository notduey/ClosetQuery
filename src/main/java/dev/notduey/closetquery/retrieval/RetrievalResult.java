package dev.notduey.closetquery.retrieval;

import dev.notduey.closetquery.model.Piece;

/**
 * Represents a wardrobe piece by semantic retrieval and its similarity score
 */
public record RetrievalResult(Piece piece, float similarityScore) {
// a record class is a data class designed primarily to store immutable set of data values
}