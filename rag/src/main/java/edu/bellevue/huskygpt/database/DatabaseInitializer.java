package edu.bellevue.huskygpt.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Initializes SQLite database schema required to store wardrobe entries
 */
public class DatabaseInitializer {

    public static void initialize() {
        // Main wardrobe pieces table
        // Better to leave columns nullable, as default values that create unecessary noise in db
        // A default value like "No Brand" is embedded as literal content, not flagged like NULL
        // NULL fulfills the same purpose of "No Brand" and is less verbose

        String sql = """
                CREATE TABLE IF NOT EXISTS pieces (
                        id INTEGER PRIMARY KEY,

                        brand TEXT,
                        name TEXT NOT NULL,

                        category TEXT NOT NULL CHECK(
                            category IN (
                            'Top',
                            'Bottom',
                            'Outerwear',
                            'Full-body',
                            'Footwear',
                            'Undergarment',
                            'Accessory'
                            )
                        ),

                        size TEXT,

                        color TEXT NOT NULL CHECK(
                            color IN (
                                'Black',
                                'White',
                                'Gray',
                                'Brown',
                                'Beige',
                                'Red',
                                'Orange',
                                'Yellow',
                                'Green',
                                'Blue',
                                'Purple',
                                'Pink',
                                'Gold',
                                'Silver',
                                'Multi'
                            )
                        ),

                        colorway TEXT,

                        season TEXT CHECK(
                            season IN (
                            'Spring/Summer',
                            'Fall/Winter',
                            'All-Season'
                            )
                        ),

                        occasion TEXT CHECK(
                            occasion IN (
                            'Casual',
                            'Everyday',
                            'Special Occasion'
                            )
                        ),

                        fit TEXT CHECK(
                            fit IN (
                            'Oversized',
                            'Regular',
                            'Slim'
                            )
                        ),

                        materials TEXT,
                        notes TEXT,

                        date_added TEXT NOT NULL DEFAULT CURRENT_DATE,
                        last_worn TEXT,

                        times_worn INTEGER NOT NULL DEFAULT 0
                            CHECK (times_worn >= 0)
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