import view.BillView;
import view.PayerView;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;

    public App() {
        setTitle("Bills Organizator");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create card and container panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create views
        JPanel payerView = new PayerView();
        JPanel billView  = new BillView();

        // Add views to card layout panel
        mainPanel.add(payerView, "PAYER");
        mainPanel.add(billView, "BILL");

        // Buttons to switch views
        JButton bttPayers = new JButton("Payers");
        JButton bttBills = new JButton("Bills");

        // Action listeners for buttons
        bttPayers.addActionListener(e -> cardLayout.show(mainPanel, "PAYER"));
        bttBills.addActionListener(e -> cardLayout.show(mainPanel, "BILL"));

        // Panel for buttons
        JPanel optionPanel = new JPanel(new GridLayout(1, 2));
        optionPanel.add(bttPayers);
        optionPanel.add(bttBills);

        // Add panels to frame
        add(optionPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }
}
