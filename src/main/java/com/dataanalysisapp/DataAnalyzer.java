package com.dataanalysisapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAnalyzer {

    // 1. Display overall statistics
    public static void displayStatistics() {
        System.out.println("📊 Library Data Statistics\n");

        System.out.println("Total Books: " + getTotalBooks());
        System.out.println("Total Members: " + getTotalMembers());
        System.out.println("Total Borrow Records: " + getTotalBorrowRecords());
        System.out.println("Most Borrowed Book: " + getMostBorrowedBook());
        System.out.println("Most Active Member: " + getMostActiveMember());
    }

    // 2. Count total books
    public static int getTotalBooks() {
        String sql = "SELECT COUNT(*) AS total FROM books";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) return rs.getInt("total");
        } catch (SQLException e) {
            System.out.println("❌ Error fetching total books: " + e.getMessage());
        }
        return 0;
    }

    // 3. Count total members
    public static int getTotalMembers() {
        String sql = "SELECT COUNT(*) AS total FROM members";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) return rs.getInt("total");
        } catch (SQLException e) {
            System.out.println("❌ Error fetching total members: " + e.getMessage());
        }
        return 0;
    }

    // 4. Count total borrow records
    public static int getTotalBorrowRecords() {
        String sql = "SELECT COUNT(*) AS total FROM borrow_records";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) return rs.getInt("total");
        } catch (SQLException e) {
            System.out.println("❌ Error fetching total borrow records: " + e.getMessage());
        }
        return 0;
    }

    // 5. Most borrowed book
    public static String getMostBorrowedBook() {
        String sql = "SELECT b.title, COUNT(*) AS borrow_count " +
                "FROM borrow_records br " +
                "JOIN books b ON br.book_id = b.book_id " +
                "GROUP BY br.book_id " +
                "ORDER BY borrow_count DESC " +
                "LIMIT 1";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("title") + " (" + rs.getInt("borrow_count") + " borrows)";
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching most borrowed book: " + e.getMessage());
        }
        return "N/A";
    }

    // 6. Most active member
    public static String getMostActiveMember() {
        String sql = "SELECT m.first_name, m.last_name, COUNT(*) AS borrow_count " +
                "FROM borrow_records br " +
                "JOIN members m ON br.member_id = m.member_id " +
                "GROUP BY br.member_id " +
                "ORDER BY borrow_count DESC " +
                "LIMIT 1";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("first_name") + " " + rs.getString("last_name") +
                        " (" + rs.getInt("borrow_count") + " borrows)";
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching most active member: " + e.getMessage());
        }
        return "N/A";
    }

    // Main method for testing
    public static void main(String[] args) {
        displayStatistics();
    }
}
