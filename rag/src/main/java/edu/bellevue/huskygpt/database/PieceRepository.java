package edu.bellevue.huskygpt.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Handles creation and retrieval of wardrobe pieces from SQLite database
 */
public class PieceRepository {

    public static void addPiece(String name, String brand) {
        String sql = """
                INSERT INTO pieces (name, brand)
                VALUES (?, ?);
                """; // placeholders (?) keep values separate from SQL structure

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, name); // first ? = piece name
            statement.setString(2, brand); // second ? = piece brand

            int rowsAffected = statement.executeUpdate(); // INSERT returns rows affected
            System.out.println(rowsAffected + " piece(s) inserted.");
        } catch (SQLException e) {
            System.out.println("Error inserting piece:");
            e.printStackTrace();
        }
    }

    public static void printAllPieces() {
        String sql = "SELECT * FROM pieces";

        try (Connection connection = DatabaseConnection.getConnection();

            // statement here is valid, but using prepared statement for data-access code is good practice
             PreparedStatement statement = connection.prepareStatement(sql); 
             ResultSet resultSet = statement.executeQuery() // run SQL query
        ) {
            // resultSet has a cursor that starts before the first row
            while (resultSet.next()) { // move cursor to next returned row

                int id = resultSet.getInt("id"); // get value of "id" column as int
                String name = resultSet.getString("name"); // get "name" column value
                String brand = resultSet.getString("brand"); // get "brand" column value

                System.out.println(id + " | " + name + " | " + brand);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving pieces:");
            e.printStackTrace();
        }
    }
}