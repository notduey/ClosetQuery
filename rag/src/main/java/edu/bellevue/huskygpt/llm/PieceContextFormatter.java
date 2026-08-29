package edu.bellevue.huskygpt.llm;

import edu.bellevue.huskygpt.model.Piece;

/**
 * Converts a Piece object into factual text for LLM context
 */
public class PieceContextFormatter {
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