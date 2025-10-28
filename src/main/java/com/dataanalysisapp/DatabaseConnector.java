package com.dataanalysisapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    // Local database connection details
    private static final String URL = "jdbc:mysql://localhost:3307/data_analysis_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Lightlife20010";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to your local database successfully!");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Test the connection
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.close(); // Close after testing
                System.out.println("✅ Connection closed successfully.");
            } catch (SQLException e) {
                System.out.println("❌ Error closing the connection: " + e.getMessage());
            }
        }
    }
}
