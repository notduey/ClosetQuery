package dev.notduey.closetquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Provides a reusable SQLite database connection for the rest of the app.
 *
 * <p>Keeps the database URL in one place so other classes do not need to
 * worry about how the connection is created.</p>
 */
public class DatabaseConnection {

    private static final String DB_URL = "jdbc:sqlite:data/wardrobe.db"; // db path relative to working directory
        // private static final --> constant variable internally used by class itself
        // sqlite --> database type
        // wardrobe.db --> database file

    /**
     * Opens a connection to the wardrobe SQLite database.
     *
     * @return an active database connection
     * @throws SQLException if the connection cannot be created
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL); // connect db with matching JDBC driver
    }
}