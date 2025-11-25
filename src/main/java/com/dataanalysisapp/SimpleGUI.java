package com.dataanalysisapp;

import javax.swing.*;
import java.awt.*;

    public class SimpleGUI extends JFrame {

        private JLabel statusLabel = new JLabel("Status: Not Connected");

        public SimpleGUI() {
            setTitle("Library Data Analysis App");
            setSize(500, 400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Layout
            setLayout(new BorderLayout(10, 10));

            // Top status bar
            JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            statusPanel.add(statusLabel);
            add(statusPanel, BorderLayout.NORTH);

            // Center buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));

            JButton connectBtn = new JButton("Connect to Database");
            JButton statsBtn = new JButton("Show Statistics");
            JButton barBtn = new JButton("Show Bar Chart");
            JButton pieBtn = new JButton("Show Pie Chart");
            JButton lineBtn = new JButton("Show Line Chart");

            buttonPanel.add(connectBtn);
            buttonPanel.add(statsBtn);
            buttonPanel.add(barBtn);
            buttonPanel.add(pieBtn);
            buttonPanel.add(lineBtn);

            add(buttonPanel, BorderLayout.CENTER);

            // Button Actions

            connectBtn.addActionListener(e -> {
                if (DatabaseConnector.getConnection() != null) {
                    statusLabel.setText("Status: Connected");
                    JOptionPane.showMessageDialog(this, "Connected to database!");
                } else {
                    statusLabel.setText("Status: Connection Failed");
                    JOptionPane.showMessageDialog(this, "Connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            statsBtn.addActionListener(e -> {
                String stats =
                        "📊 Library Data Statistics\n\n" +
                                "Total Books: " + DataAnalyzer.getTotalBooks() + "\n" +
                                "Total Members: " + DataAnalyzer.getTotalMembers() + "\n" +
                                "Total Borrow Records: " + DataAnalyzer.getTotalBorrowRecords() + "\n" +
                                "Most Borrowed Book: " + DataAnalyzer.getMostBorrowedBook() + "\n" +
                                "Most Active Member: " + DataAnalyzer.getMostActiveMember() + "\n";

                JTextArea textArea = new JTextArea(stats);
                textArea.setEditable(false);
                JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Statistics", JOptionPane.INFORMATION_MESSAGE);
            });

            barBtn.addActionListener(e -> ChartGenerator.generateBarChart());
            pieBtn.addActionListener(e -> ChartGenerator.generatePieChart());
            lineBtn.addActionListener(e -> ChartGenerator.generateLineChart());
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                SimpleGUI gui = new SimpleGUI();
                gui.setVisible(true);
            });
        }
    }

