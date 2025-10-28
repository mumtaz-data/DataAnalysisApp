package com.dataanalysisapp;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.util.Map;

public class ChartGenerator {

    public static void generateBarChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(DataAnalyzer.getTotalBooks(), "Count", "Books");
        dataset.addValue(DataAnalyzer.getTotalMembers(), "Count", "Members");
        dataset.addValue(DataAnalyzer.getTotalBorrowRecords(), "Count", "Borrow Records");

        JFreeChart barChart = ChartFactory.createBarChart(
                "Library Statistics",
                "Category",
                "Count",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        displayChart(barChart, "Library Statistics - Bar Chart");
    }

    public static void generatePieChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        String mostBorrowedBook = DataAnalyzer.getMostBorrowedBook();
        int mostBorrowedCount = extractBorrowCount(mostBorrowedBook);
        int remaining = DataAnalyzer.getTotalBorrowRecords() - mostBorrowedCount;

        dataset.setValue(mostBorrowedBook, mostBorrowedCount);
        dataset.setValue("Other Books", remaining);

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Most Borrowed Book vs Others",
                dataset,
                true, true, false
        );

        displayChart(pieChart, "Library Statistics - Pie Chart");
    }

    public static void generateLineChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Map<String, Integer> monthlyBorrows = DataAnalyzer.getMonthlyBorrowCounts();
        for (String month : monthlyBorrows.keySet()) {
            dataset.addValue(monthlyBorrows.get(month), "Borrows", month);
        }

        JFreeChart lineChart = ChartFactory.createLineChart(
                "Monthly Borrow Trend",
                "Month",
                "Borrows",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        displayChart(lineChart, "Library Statistics - Line Chart");
    }

    private static int extractBorrowCount(String str) {
        try {
            String num = str.substring(str.indexOf("(") + 1, str.indexOf(" borrows)"));
            return Integer.parseInt(num);
        } catch (Exception e) {
            return 0;
        }
    }

    private static void displayChart(JFreeChart chart, String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        ChartPanel chartPanel = new ChartPanel(chart);
        frame.setContentPane(chartPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        generateBarChart();
        generatePieChart();
        generateLineChart();
    }
}
