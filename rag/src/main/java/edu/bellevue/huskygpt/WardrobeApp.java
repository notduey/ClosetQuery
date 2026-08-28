package edu.bellevue.huskygpt;

import ai.onnxruntime.OrtException;

import edu.bellevue.huskygpt.database.PieceRepository;
import edu.bellevue.huskygpt.llm.LlmClient;
import edu.bellevue.huskygpt.llm.PromptBuilder;
import edu.bellevue.huskygpt.model.Piece;
import edu.bellevue.huskygpt.retrieval.EmbeddingModel;
import edu.bellevue.huskygpt.retrieval.RetrievalResult;
import edu.bellevue.huskygpt.retrieval.SemanticRetriever;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Runs terminal interface for queryinf and managing wardrobe
 */
public class WardrobeApp {

    private final PieceRepository repository;
    private final EmbeddingModel model;
    private final LlmClient llmClient;
    private final Scanner scanner;

    private SemanticRetriever retriever; // not final as new retriever is created on add/delete

    public WardrobeApp(
        PieceRepository repository,
        EmbeddingModel model,
        LlmClient llmClient
    ) throws SQLException, OrtException {
        this.repository = repository;
        this.model = model;
        this.llmClient = llmClient;
        this.scanner = new Scanner(System.in);

        refreshRetriever();
    }

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();

            String choice = readMenuChoice();;

            switch (choice) {
                case "1" -> askQuestion();
                case "2" -> addPiece();
                case "3" -> removePiece();
                case "4" -> listPieces();
                case "0" -> running = false; // exit
            }
        }

        scanner.close();
        System.out.println("Closing wardrobe...");
    }

    private String readMenuChoice() {
        // while choice not 0-4 keep asking
        while (true) {
            String choice = scanner.nextLine().trim();

            if (choice.equals("0")
                    || choice.equals("1")
                    || choice.equals("2")
                    || choice.equals("3")
                    || choice.equals("4")) {
                return choice;
            }

            System.out.print(
                    "Invalid choice. Choose 1-4 or 0 to exit: "
            );
        }
    }

    private void printMenu() {
        System.out.println(
            """

            Welcome to your wardrobe!
            -------------------------
            1. Ask AI
            2. Add piece
            3. Remove piece
            4. List pieces
            0. Exit
            """
        );
        System.out.print("Choose an option: ");
    }

    private void askQuestion() {
        System.out.println();
        System.out.println("Ask a wardrobe question, or enter 0 to return to the menu.");
        System.out.println("----------------------------------------------------------");

        while (true) {
            System.out.print("Question (0 to return): ");
            String question = scanner.nextLine().trim();

            if (question.equals("0")) {
                System.out.println("Returning to menu...");
                return; // return to menu
            }

            if (question.isBlank()) {
                System.out.println("Question cannot be empty.");
                continue; // ask again
            }

            try {
                List<RetrievalResult> results = retriever.retrieve(question, 3);

                String prompt = PromptBuilder.build(question, results);

                String answer = llmClient.generate(prompt);

                System.out.println("\nAnswer: " + answer);

            } catch (Exception e) {
                System.out.println("Failed to generate answer: " + e.getMessage());
            }
        }
    }

    private void addPiece() {
        System.out.println("Add Piece or enter 0 to return to menu at any time.");

        try {
            boolean existing = readYesNoCancel(
                "Is this an existing wardrobe piece? (y/n): "
            );

            String brand = readRequired("Brand (required): ");
            String name = readRequired("Name (required): ");

            String category = readChoice(
                "Category",
                "Top",
                "Bottom",
                "Outerwear",
                "Full-body",
                "Footwear",
                "Undergarment",
                "Accessory"
            );

            String size = readOptional("Size: ");

            String color = readChoice(
                "Color",
                "Black",
                "White",
                "Gray",
                "Brown",
                "Beige",
                "Red",
                "Orange",
                "Yellow",
                "Green",
                "Blue",
                "Purple",
                "Pink",
                "Gold",
                "Silver",
                "Multi"
            );

            String colorway = readOptional("Colorway: ");

            String season = readChoice(
                "Season",
                "Spring/Summer",
                "Fall/Winter",
                "All-Season"
            );

            String occasion = readChoice(
                "Occasion",
               "Casual",
                "Everyday",
                "Special Occasion"
            );

            String fit = readChoice(
                "Fit",
                "Oversized",
                "Regular",
                "Slim"
            );

            String materials = readOptional("Materials: ");
            String notes = readOptional("Notes: ");

            int id;

            // Existing piece
            if (existing) {
                String lastWorn = readOptional("Last worn (YYYY-MM-DD): ");
                int timesWorn = readNonNegativeInt("Times worn: ");

                Piece piece = Piece.existing(
                        brand,
                        name,
                        category,
                        size,
                        color,
                        colorway,
                        season,
                        occasion,
                        fit,
                        materials,
                        notes,
                        lastWorn,
                        timesWorn
                );

                id = repository.addExistingPiece(piece);

            } else {
                Piece piece = new Piece(
                        brand,
                        name,
                        category,
                        size,
                        color,
                        colorway,
                        season,
                        occasion,
                        fit,
                        materials,
                        notes
                );

                id = repository.addPiece(piece);
            }

            refreshRetriever(); // database changed, rebuild semantic index

            System.out.println("Piece added with ID " + id + ".");

        } catch (OperationCancelledException e) {
            System.out.println("Returning to menu...");
        } catch (Exception e) {
            System.out.println(
                    "Could not add piece: " + e.getMessage()
            );
        }
    }

    private String readRequired(String prompt) {
        while (true) {
            System.out.print(prompt);

            String value = scanner.nextLine().trim();

            if (value.equals("0")) {
                throw new OperationCancelledException();
            }

            if (!value.isBlank()) {
                return value;
            }

            System.out.println("This field is required. Enter 0 to return to menu.");
        }
    }

    private String readOptional(String prompt) {
        System.out.print(prompt);

        String value = scanner.nextLine().trim();

        if (value.equals("0")) {
            throw new OperationCancelledException();
        }

        return value.isBlank() ? null : value; // null if empty, else return value
    }

    private int readNonNegativeInt(String prompt) {
        while (true) {
            System.out.print(prompt);

            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);

                if (value >= 0) {
                    return value;
                }

            } catch (NumberFormatException ignored) { // if input not a number
            }

            System.out.println("Enter a non-negative whole number.");
        }
    }

    private int readPositiveIntOrCancel(String prompt) {
        while (true) {
            System.out.print(prompt);

            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                throw new OperationCancelledException();
            }

            try {
                int value = Integer.parseInt(input);

                if (value > 0) {
                    return value;
                }

            } catch (NumberFormatException ignored) {
            }

            System.out.print(
                    "Enter a valid piece ID or 0 to return: "
            );
        }
    }

    private String readChoice(String label, String... options) {
            System.out.println(label + ":");

            // iterate and display options
            for (int i = 0; i < options.length; i++) {
                System.out.printf("%d. %s%n", i + 1, options[i]);
            }

            System.out.println("0. Return to menu");
            System.out.print("Choose: ");

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                throw new OperationCancelledException();
            }

            try {
                int choice = Integer.parseInt(input);

                if (choice >= 1 && choice <= options.length) {
                    return options[choice - 1];
                }

            } catch (NumberFormatException ignored) {
            }

            System.out.print(
                "Enter a number from 1-" + options.length + " or 0 to return: "
            );
        }
    }

    private void removePiece() {
        try {
            List<Piece> pieces = repository.getAllPieces();

            if (pieces.isEmpty()) {
                System.out.println("No pieces in wardrobe to remove.");
                return;
            }

            printPieces(pieces);
            System.out.println();
            
            int id = readPositiveIntOrCancel(
                    "Enter piece ID to remove (0 to return): "
            );

            Piece piece = repository.getPieceById(id);

            if (piece == null) {
                System.out.println("No piece found with ID " + id + ".");
                return;
            }

            boolean confirmed = readYesNoCancel(
                    "Remove " + piece.getBrand() + " " + piece.getName() + "? (y/n, 0 to return): "
            );

            if (!confirmed) {
                System.out.println("Removal cancelled.");
                return;
            }

            int deletedRows = repository.removePiece(id);

            if (deletedRows == 1) {
                refreshRetriever();
                System.out.println("Piece removed.");
            } else {
                System.out.println("Piece could not be removed.");
            }

        } catch (OperationCancelledException e) {
            System.out.println("Returning to menu...");
        } catch (Exception e) {
            System.out.println(
                    "Error removing piece: " + e.getMessage()
            );
        }
    }

    private void listPieces() {
        try {
            List<Piece> pieces = repository.getAllPieces();

            if (pieces.isEmpty()) {
                System.out.println(
                        "Your wardrobe is empty. Add some pieces first!"
                );
            } else {
                printPieces(pieces);
            }

            System.out.println();
            System.out.print("Enter 0 to return to menu: ");

            while (!scanner.nextLine().trim().equals("0")) {
                System.out.print("Enter 0 to return to menu: ");
            }

            System.out.println("Returning to menu...");

        } catch (SQLException e) {
            System.out.println(
                    "Failed to list pieces: " + e.getMessage()
            );
        }
    }

    private boolean readYesNoCancel(String prompt) {
        System.out.print(prompt);

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                throw new OperationCancelledException();
            }

            if (input.equalsIgnoreCase("y")) {
                return true;
            }

            if (input.equalsIgnoreCase("n")) {
                return false;
            }

            System.out.print("Enter y, n, or 0 to return: ");
        }
    }

    private void printPieces(List<Piece> pieces) {
        System.out.println("\nYour Collection:");
        System.out.println("----------------");

        for (Piece p : pieces) {
            System.out.printf(
                "%-3s %-20s %s%n",
                p.getId() + ".",
                p.getBrand(),
                p.getName()
            );
        }
    }

    private void refreshRetriever() throws SQLException, OrtException {
        List<Piece> pieces = repository.getAllPieces();

        retriever = new SemanticRetriever(model, pieces);
    }

    private static class OperationCancelledException extends RuntimeException {
    }
}