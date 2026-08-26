package edu.bellevue.huskygpt;

import edu.bellevue.huskygpt.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connected to the SQLite database successfully.");
        } catch (SQLException e) {
            System.out.println("Connection failed:");
            e.printStackTrace(); // print exception details and stack trace
        }
        // connection implements AutoCloseable, so connection.close() is called when try block ends
    }
}