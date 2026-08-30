package dev.notduey.closetquery.retrieval;

import dev.notduey.closetquery.model.Piece;

/**
 * Converts a {@link Piece} into text used for semantic embedding and retrieval.
 *
 * <p>The formatter focuses on descriptive fields that help represent the
 * meaning of a piece in natural language. Exact fields like date added,
 * last worn, and times worn are intentionally left out because those are
 * better handled through structured SQLite retrieval.</p>
 */
public class PieceTextFormatter {

    /**
     * Builds a compact natural-language description of a wardrobe piece.
     *
     * <p>The output is designed for the embedding model, so descriptive fields
     * are phrased as readable text instead of just dumping raw database values.</p>
     *
     * @param piece piece to convert into semantic retrieval text
     * @return formatted text ready to be embedded
     */
    public static String format(Piece piece) {

        // Embedding models are trained primarily on natural language
        // date_added, last_worn, and times_worn are better handled through structured retrieval
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