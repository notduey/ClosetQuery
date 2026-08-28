package edu.bellevue.huskygpt.retrieval;

import edu.bellevue.huskygpt.model.Piece;

/**
 * Represents a wardrobe piece and its precomputed semantic embedding
 */
public record IndexedPiece(Piece piece, float[] embedding) {
}