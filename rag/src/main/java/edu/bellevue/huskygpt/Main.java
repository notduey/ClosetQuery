package edu.bellevue.huskygpt;

import edu.bellevue.huskygpt.database.DatabaseInitializer;
import edu.bellevue.huskygpt.database.DatabaseSeeder;
import edu.bellevue.huskygpt.model.Piece;

import edu.bellevue.huskygpt.database.PieceRepository;
import edu.bellevue.huskygpt.retrieval.PieceTextFormatter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // make sure required db tables exist
        DatabaseInitializer.initialize();

        // seed with sample data
        DatabaseSeeder.seed();

        // get db rows as Piece objects
        List<Piece> pieces = PieceRepository.getAllPieces();

        // print all pieces
        for (Piece p : pieces) {
            String retrievalText = PieceTextFormatter.format(p); // convert piece to embedding text

            System.out.println(retrievalText);
            System.out.println();
        }
    }
}

// Run after compiling:
// java -cp target/classes:$HOME/.m2/repository/org/xerial/sqlite-jdbc/3.53.2.1/sqlite-jdbc-3.53.2.1.jar edu.bellevue.huskygpt.Main