package edu.bellevue.huskygpt;

import edu.bellevue.huskygpt.database.DatabaseInitializer;
import edu.bellevue.huskygpt.database.PieceRepository;
import edu.bellevue.huskygpt.model.Piece;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // make sure required db tables exist
        DatabaseInitializer.initialize();

        // create one in-memory piece
        Piece piece = new Piece(
            "Stussy",
            "8-Ball Knit Sweater",
            "Top",
            "XS",
            "Beige",
            "Cream Ivory",
            "Fall/Winter",
            "Reserved",
            "Regular",
            "Acrylic, Nylon, Wool, Mohair",
            "Heavy brushed mohair knitted sweater with 8 ball on back"
        );

        List<Piece> pieces = PieceRepository.getAllPieces(); // get db rows as Piece objects

        // print all pieces
        for (Piece p : pieces) {
            System.out.println(p.getId() + " | " + p.getBrand() + " | " + p.getName());
        }
    }
}

// Run after compiling:
// java -cp target/classes:$HOME/.m2/repository/org/xerial/sqlite-jdbc/3.53.2.1/sqlite-jdbc-3.53.2.1.jar edu.bellevue.huskygpt.Main