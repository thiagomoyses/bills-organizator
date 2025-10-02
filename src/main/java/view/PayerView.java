package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PayerView extends JPanel {

    private JTable payerTable;
    private DefaultTableModel tableModel;

    public PayerView() {
        setLayout(new BorderLayout());

        // Define column names
        String[] columnNames = {"ID", "Name", "Email"};

        // Create table model with column names and 0 rows
        tableModel = new DefaultTableModel(columnNames, 0);

        // Create JTable with the model
        payerTable = new JTable(tableModel);
        payerTable.setFillsViewportHeight(true);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(payerTable);

        // Add scroll pane to the panel
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to set data in the table
    public void setPayersData(Object[][] data) {
        tableModel.setRowCount(0);
        for (Object[] row : data) {
            tableModel.addRow(row);
        }
    }

}
