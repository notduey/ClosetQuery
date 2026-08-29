package edu.bellevue.huskygpt.retrieval;

import edu.bellevue.huskygpt.model.Piece;

/**
 * Converts Piece objects into semantic text for embedding-based retrieval.
 */
public class PieceTextFormatter {

    // Embedding models are trained primarily on natural language
    // date_added, last_worn, and times_worn will be handled through structured retrieval
    public static String format(Piece piece) {
        StringBuilder text = new StringBuilder(); // build retrieval text in increments


        if (piece.getBrand() != null) {
            text.append(piece.getBrand()).append(" ");
        }

        text.append(piece.getName())
            .append(". ");

        // Combine broad color and colorway if present
        text.append(piece.getColor()).append(" color");
        if (piece.getColorway() != null) {
            text.append(", \"")
                .append(piece.getColorway())
                .append("\" colorway");
        }
        text.append(". ");

        text.append("Category: ")
            .append(piece.getCategory())
            .append(". ");

        // Remaining fields
        if (piece.getSize() != null) {
            text.append("Size: ")
                .append(piece.getSize())
                .append(". ");
        }

        if (piece.getFit() != null) {
            text.append(piece.getFit())
                .append(" fit. ");
        }

        if (piece.getMaterials() != null) {
            text.append("Made from ")
                .append(piece.getMaterials())
                .append(". ");
        }

        if (piece.getSeason() != null) {
            text.append("Suitable for ")
                .append(piece.getSeason())
                .append(" use. ");
        }

        if (piece.getOccasion() != null) {
            text.append("Occasion: ")
                .append(piece.getOccasion())
                .append(". ");
        }

        if (piece.getNotes() != null) {
            text.append("Notes: ")
                .append(piece.getNotes())
                .append(". ");
        }

        return text.toString().trim(); // remove leading/trailing whitespace
    }
}