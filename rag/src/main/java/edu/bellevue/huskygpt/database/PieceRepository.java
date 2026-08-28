package edu.bellevue.huskygpt.database;

import edu.bellevue.huskygpt.model.Piece;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles insertion and retrieval of wardrobe pieces from SQLite database
 */
public class PieceRepository {

    public static int addPiece(Piece piece) throws SQLException {
        String sql = """
                INSERT INTO pieces (
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
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                RETURNING id
                """; // placeholders (?) keep values separate from SQL structure

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            // SQL handles id and date_added, last_worn, times_worn with default values
            statement.setString(1, piece.getBrand()); // first ? = piece brand
            statement.setString(2, piece.getName()); // second ? = piece name
            statement.setString(3, piece.getCategory());
            statement.setString(4, piece.getSize());
            statement.setString(5, piece.getColor());
            statement.setString(6, piece.getColorway());
            statement.setString(7, piece.getSeason());
            statement.setString(8, piece.getOccasion());
            statement.setString(9, piece.getFit());
            statement.setString(10, piece.getMaterials());
            statement.setString(11, piece.getNotes());

            try (ResultSet resultSet = statement.executeQuery()) { // executeQuery to return id
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }
        }

        throw new SQLException("Piece inserted but no id returned");
    }

        public int addExistingPiece(Piece piece) throws SQLException {
        String sql = """
                INSERT INTO pieces (
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
                    last_worn,
                    times_worn
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                RETURNING id
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, piece.getBrand());
            statement.setString(2, piece.getName());
            statement.setString(3, piece.getCategory());
            statement.setString(4, piece.getSize());
            statement.setString(5, piece.getColor());
            statement.setString(6, piece.getColorway());
            statement.setString(7, piece.getSeason());
            statement.setString(8, piece.getOccasion());
            statement.setString(9, piece.getFit());
            statement.setString(10, piece.getMaterials());
            statement.setString(11, piece.getNotes());
            statement.setString(12, piece.getLastWorn());
            statement.setInt(13, piece.getTimesWorn());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }
        }

        throw new SQLException("Piece inserted but no id returned");
    }

    public int removePiece(int id) throws SQLException {
        String sql = "DELETE FROM pieces WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);

            return statement.executeUpdate();
        }
    }

    public static List<Piece> getAllPieces() throws SQLException {
        String sql = """
            SELECT
                id,
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
                date_added,
                last_worn,
                times_worn
            FROM pieces
            """;

        List<Piece> pieces = new ArrayList<>(); // stores Piece objects returned from db

        try (Connection connection = DatabaseConnection.getConnection();

            // statement here is valid, but using prepared statement for data-access code is good practice
             PreparedStatement statement = connection.prepareStatement(sql); 
             ResultSet resultSet = statement.executeQuery() // run SQL query
        ) {
            // resultSet has a cursor that starts before the first row
            while (resultSet.next()) { // move cursor to next returned row

                Piece piece = Piece.fromDatabase(
                    resultSet.getInt("id"),
                    resultSet.getString("brand"),
                    resultSet.getString("name"),
                    resultSet.getString("category"),
                    resultSet.getString("size"),
                    resultSet.getString("color"),
                    resultSet.getString("colorway"),
                    resultSet.getString("season"),
                    resultSet.getString("occasion"),
                    resultSet.getString("fit"),
                    resultSet.getString("materials"),
                    resultSet.getString("notes"),
                    resultSet.getString("date_added"),
                    resultSet.getString("last_worn"),
                    resultSet.getInt("times_worn")
                ); // convert current ResultSet row into Piece object

                pieces.add(piece); // add Piece to pieces list
            }
        }

        return pieces;
    }

    public Piece getPieceById(int id) throws SQLException {
        String sql = "SELECT * FROM pieces WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    return null; // no row found with given id
                }

                return Piece.fromDatabase(
                    resultSet.getInt("id"),
                    resultSet.getString("brand"),
                    resultSet.getString("name"),
                    resultSet.getString("category"),
                    resultSet.getString("size"),
                    resultSet.getString("color"),
                    resultSet.getString("colorway"),
                    resultSet.getString("season"),
                    resultSet.getString("occasion"),
                    resultSet.getString("fit"),
                    resultSet.getString("materials"),
                    resultSet.getString("notes"),
                    resultSet.getString("date_added"),
                    resultSet.getString("last_worn"),
                    resultSet.getInt("times_worn")
                );
            }
        }
    }
}