package edu.bellevue.huskygpt.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:sqlite:data/wardrobe.db"; //  JDBC url
        // sqlite: --> database type
        // wardrobe.db --> database file
        // private static final --> constant variable internally used by class itself

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL); // connect db with matching JDBC driver
    }
}