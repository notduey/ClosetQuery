package edu.bellevue.huskygpt.llm;

/**
 * Defines how the application sends prompt to language model
 */
public interface LlmClient {
    String generate(String prompt) throws Exception;
}