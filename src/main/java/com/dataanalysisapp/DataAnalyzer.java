package com.dataanalysisapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataAnalyzer {

    // Display overall statistics
    public static void displayStatistics() {
        System.out.println("📊 Library Data Statistics\n");

        System.out.println("Total Books: " + getTotalBooks());
        System.out.println("Total Members: " + getTotalMembers());
        System.out.println("Total Borrow Records: " + getTotalBorrowRecords());
        System.out.println("Most Borrowed Book: " + getMostBorrowedBook());
        System.out.println("Most Active Member: " + getMostActiveMember());
    }

    public static int getTotalBooks() {
        String sql = "SELECT COUNT(*) AS total FROM books";
        return executeCountQuery(sql, "total", "books");
    }

    public static int getTotalMembers() {
        String sql = "SELECT COUNT(*) AS total FROM members";
        return executeCountQuery(sql, "total", "members");
    }

    public static int getTotalBorrowRecords() {
        String sql = "SELECT COUNT(*) AS total FROM borrow_records";
        return executeCountQuery(sql, "total", "borrow_records");
    }

    private static int executeCountQuery(String sql, String column, String table) {
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) return rs.getInt(column);
        } catch (SQLException e) {
            System.out.println("❌ Error fetching " + table + ": " + e.getMessage());
        }
        return 0;
    }

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

    // Get monthly borrow counts for line chart
    public static Map<String, Integer> getMonthlyBorrowCounts() {
        Map<String, Integer> monthlyBorrows = new LinkedHashMap<>();
        String sql = "SELECT DATE_FORMAT(borrow_date, '%Y-%m') AS month, COUNT(*) AS total " +
                "FROM borrow_records " +
                "GROUP BY month " +
                "ORDER BY month";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                monthlyBorrows.put(rs.getString("month"), rs.getInt("total"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching monthly borrow counts: " + e.getMessage());
        }
        return monthlyBorrows;
    }

    public static void main(String[] args) {
        displayStatistics();
    }
}
