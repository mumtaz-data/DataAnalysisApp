package com.dataanalysisapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n📚 Library Data Analysis App");
            System.out.println("1. Display Statistics in Console");
            System.out.println("2. Show Bar Chart (Books, Members, Borrow Records)");
            System.out.println("3. Show Pie Chart (Most Borrowed Book)");
            System.out.println("4. Show Line Chart (Monthly Borrow Trend)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> DataAnalyzer.displayStatistics();
                case 2 -> ChartGenerator.generateBarChart();
                case 3 -> ChartGenerator.generatePieChart();
                case 4 -> ChartGenerator.generateLineChart();
                case 0 -> System.out.println("Exiting application. Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
