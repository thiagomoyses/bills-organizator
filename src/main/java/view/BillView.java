package view;

import javax.swing.*;
import java.awt.*;

public class BillView extends JPanel {
    public BillView() {
        setLayout(new BorderLayout());
        add(new JLabel("Tela de Bills", SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
