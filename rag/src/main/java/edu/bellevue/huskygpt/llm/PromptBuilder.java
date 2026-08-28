package edu.bellevue.huskygpt.llm;

import edu.bellevue.huskygpt.retrieval.PieceTextFormatter;
import edu.bellevue.huskygpt.retrieval.RetrievalResult;

import java.util.List;

/**
 * Builds a (grounded) prompt from retrieved wardrobe information
 */
public class PromptBuilder {

    public static String build(
        String question,
        List<RetrievalResult> results
    ) {
        // Incrementally build llm prompt
        StringBuilder prompt = new StringBuilder();

        prompt.append("""
                Answer the question using only the retrieved wardrobe information below.
                Do not use outside knowledge.
                If the question is not related to the wardrobe, say that no information is available.
                If the retrieved information does not contain enough information to answer,
                say that no information is available.

                Retrieved wardrobe information:
                """);

        for (int i = 0; i < results.size(); i++) {
            RetrievalResult result = results.get(i);

            prompt.append(i + 1) // result rank
                .append(". ")
                .append(PieceTextFormatter.format(result.piece())) // append formatted piece text
                .append("\n");
        }

        prompt.append("\nQuestion: ")
            .append(question);

        return prompt.toString();
    }
}