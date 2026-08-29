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

    public int addPiece(Piece piece) throws SQLException {
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

    public List<Piece> getAllPieces() throws SQLException {
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
                pieces.add(mapPiece(resultSet));
            }
        }

        return pieces;
    }

    public Piece getPieceById(int id) throws SQLException {
        String sql = "SELECT * FROM pieces WHERE id = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    return null;
                }

                return mapPiece(resultSet);
            }
        }
    }

    public List<Piece> getMostWornPieces(int limit, String category) throws SQLException {
        validateLimit(limit);

        String sql;

        // Determine SQL query based on category
        if (category == null) {
            sql = """
                SELECT *
                FROM pieces
                ORDER BY times_worn DESC, id ASC
                LIMIT ?
                """;
        } else {
            sql = """
                SELECT *
                FROM pieces
                WHERE category = ? 
                ORDER BY times_worn DESC, id ASC
                LIMIT ?
                """;
        }

        List<Piece> pieces = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            if (category == null) { // only limit
                statement.setInt(1, limit);
            } else { // category and limit
                statement.setString(1, category);
                statement.setInt(2, limit);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    pieces.add(mapPiece(resultSet));
                }
            }
        }

        return pieces;
    }

    public List<Piece> getLeastWornPieces(int limit, String category) throws SQLException {
        validateLimit(limit);

        String sql;

        if (category == null) {
            sql = """
                SELECT *
                FROM pieces
                ORDER BY times_worn ASC, id ASC
                LIMIT ?
                """;
        } else {
            sql = """
                SELECT *
                FROM pieces
                WHERE category = ? 
                ORDER BY times_worn ASC, id ASC
                LIMIT ?
                """;
        }

        List<Piece> pieces = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            if (category == null) {
                statement.setInt(1, limit);
            } else {
                statement.setString(1, category);
                statement.setInt(2, limit);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    pieces.add(mapPiece(resultSet));
                }
            }
        }

        return pieces;
    }

    public List<Piece> getNeverWornPieces(String category) throws SQLException {
        String sql;

        if (category == null) {
            sql = """
                SELECT *
                FROM pieces
                WHERE times_worn = 0
                ORDER BY id ASC
                """;
        } else {
            sql = """
                SELECT *
                FROM pieces
                WHERE times_worn = 0
                    AND category = ?
                ORDER BY id ASC
                """;
        }

        List<Piece> pieces = new ArrayList<>();

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            if (category != null) { // add category if exists
                statement.setString(1, category);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    pieces.add(mapPiece(resultSet));
                }
            }
        }

        return pieces;
    }

    public List<Piece> getMostRecentlyWornPieces(int limit, String category) throws SQLException {
        validateLimit(limit);

        String sql;

        if (category == null) {  // id ASC tiebreaker
            sql = """
                SELECT *
                FROM pieces
                ORDER BY 
                    last_worn DESC,
                    id ASC
                LIMIT ?
                """;
        } else {
            sql = """
                SELECT *
                FROM pieces
                WHERE category = ?
                ORDER BY 
                    last_worn DESC,
                    id ASC
                LIMIT ?
                """;
        }

        List<Piece> pieces = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            if (category == null) { // only limit
                statement.setInt(1, limit);
            } else { // category and limit
                statement.setString(1, category);
                statement.setInt(2, limit);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    pieces.add(mapPiece(resultSet));
                }
            }
        }

        return pieces;
    }

    public List<Piece> getLeastRecentlyWornPieces(int limit, String category) throws SQLException {
        validateLimit(limit);

        String sql;

        if (category == null) {  // never worn pieces first then ordered by last worn
            sql = """
                SELECT *
                FROM pieces
                ORDER BY 
                    last_worn IS NOT NULL,
                    last_worn ASC,
                    id ASC
                LIMIT ?
                """;
        } else {
            sql = """
                SELECT *
                FROM pieces
                WHERE category = ?
                ORDER BY 
                    last_worn IS NOT NULL,
                    last_worn ASC,
                    id ASC
                LIMIT ?
                """;
        }

        List<Piece> pieces = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            if (category == null) { // only limit
                statement.setInt(1, limit);
            } else { // category and limit
                statement.setString(1, category);
                statement.setInt(2, limit);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    pieces.add(mapPiece(resultSet));
                }
            }
        }

        return pieces;
    }

    public List<Piece> getRecentlyAddedPieces(int limit, String category) throws SQLException {
        validateLimit(limit);

        String sql;

        if (category == null) {  // id DESC as newer pieces have higher ids
            sql = """
                SELECT *
                FROM pieces
                ORDER BY date_added DESC, id DESC
                LIMIT ?
                """;
        } else {
            sql = """
                SELECT *
                FROM pieces
                WHERE category = ?
                ORDER BY date_added DESC, id ASC
                LIMIT ?
                """;
        }

        List<Piece> pieces = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            if (category == null) {
                statement.setInt(1, limit);
            } else {
                statement.setString(1, category);
                statement.setInt(2, limit);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    pieces.add(mapPiece(resultSet));
                }
            }
        }

        return pieces;
    }

    public List<Piece> getPiecesByCategory(String category) throws SQLException {
        String sql = """
            SELECT *
            FROM pieces
            WHERE category = ?
            ORDER BY id ASC
            """;

        List<Piece> pieces = new ArrayList<>();

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, category);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    pieces.add(mapPiece(resultSet));
                }
            }
        }

        return pieces;
    }

    public int countPiecesByCategory(String category) throws SQLException {
        String sql = """
                SELECT COUNT(*) AS total
                FROM pieces
                WHERE category = ?
                """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, category);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("total");
                }
            }
        }

        return 0;
    }

    private Piece mapPiece(ResultSet resultSet) throws SQLException {
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

    private void validateLimit(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException(
                    "Limit must be greater than 0."
            );
        }
    }

}