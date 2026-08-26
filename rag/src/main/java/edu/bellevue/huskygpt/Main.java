package edu.bellevue.huskygpt;

import edu.bellevue.huskygpt.database.DatabaseInitializer;
import edu.bellevue.huskygpt.database.PieceRepository;

public class Main {
    public static void main(String[] args) {
        DatabaseInitializer.initialize(); // make sure required db tables exist

        PieceRepository.addPiece("Jillian Toggle Boot", "FRYE"); // insert initial piece using JDBC

        PieceRepository.printAllPieces();
    }
}

// Run after compiling:
// java -cp target/classes:$HOME/.m2/repository/org/xerial/sqlite-jdbc/3.53.2.1/sqlite-jdbc-3.53.2.1.jar edu.bellevue.huskygpt.Main