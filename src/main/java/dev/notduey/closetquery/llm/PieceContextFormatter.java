package dev.notduey.closetquery.llm;

import dev.notduey.closetquery.model.Piece;

/**
 * Converts a {@link Piece} into factual text that can be given to the LLM.
 *
 * <p>This formatter includes the full set of useful wardrobe details,
 * including wear history, since the generation step may need exact facts
 * that are not useful for semantic similarity.</p>
 */
public class PieceContextFormatter {

    /**
     * Builds a compact factual description of a wardrobe piece.
     *
     * <p>Optional fields are only included when values exist so the prompt
     * stays cleaner and does not fill missing data with unnecessary text.</p>
     *
     * @param piece piece to convert into LLM context
     * @return factual text representation of the piece
     */
    public static String format(Piece piece) {
        StringBuilder text = new StringBuilder();

        if (piece.getBrand() != null) {
            text.append(piece.getBrand()).append(" ");
        }

        text.append(piece.getName()).append(". ");

        text.append("Category: ")
            .append(piece.getCategory())
            .append(". ");

        text.append("Color: ")
            .append(piece.getColor())
            .append(". ");

        if (piece.getColorway() != null) {
            text.append("Colorway: ")
                .append(piece.getColorway())
                .append(". ");
        }

        if (piece.getSize() != null) {
            text.append("Size: ")
                .append(piece.getSize())
                .append(". ");
        }

        if (piece.getSeason() != null) {
            text.append("Season: ")
                .append(piece.getSeason())
                .append(". ");
        }

        if (piece.getOccasion() != null) {
            text.append("Occasion: ")
                .append(piece.getOccasion())
                .append(". ");
        }

        if (piece.getFit() != null) {
            text.append("Fit: ")
                .append(piece.getFit())
                .append(". ");
        }

        if (piece.getMaterials() != null) {
            text.append("Materials: ")
                .append(piece.getMaterials())
                .append(". ");
        }

        if (piece.getNotes() != null) {
            text.append("Notes: ")
                .append(piece.getNotes())
                .append(". ");
        }

        text.append("Date added: ")
            .append(piece.getDateAdded())
            .append(". ");

        if (piece.getLastWorn() != null) {
            text.append("Last worn: ")
                .append(piece.getLastWorn())
                .append(". ");
        } else {
            text.append("Last worn: Never or unknown. "); // rephrase if null
        }

        text.append("Times worn: ")
            .append(piece.getTimesWorn())
            .append(".");

        return text.toString().trim();
    }
}