package edu.bellevue.huskygpt.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Initializes SQLite database schema required to store wardrobe entries
 */
public class DatabaseInitializer {

    public static void initialize() {
        String sql = """
                CREATE TABLE IF NOT EXISTS pieces (
                    id INTEGER PRIMARY KEY,
                    name TEXT NOT NULL,
                    brand TEXT NOT NULL
                );
                """; // fixed SQL statement to create initial table
        
        try (
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement() // statement to execute fixed SQL
        ) {
            statement.executeUpdate(sql); // execute schema-changing SQL
            System.out.println("Database initialized successfully.");
        } catch (SQLException e) {
            System.out.println("Database initialization failed:");
            e.printStackTrace(); // print SQL error details
        }
    }
}