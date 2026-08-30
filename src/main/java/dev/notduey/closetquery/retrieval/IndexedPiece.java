package dev.notduey.closetquery.retrieval;

import dev.notduey.closetquery.model.Piece;

/**
 * Represents a wardrobe piece and its precomputed semantic embedding
 */
public record IndexedPiece(Piece piece, float[] embedding) {
}