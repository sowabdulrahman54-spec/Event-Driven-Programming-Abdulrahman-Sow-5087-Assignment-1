package src;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SowGUI extends JFrame implements ActionListener {

    // Member components
    private final JLabel headerLabel;
    private final JButton btnModifyText;
    private final JButton btnModifyBg;
    private final JPanel mainContainer;

    public SowGUI() {
        // Window Configuration
        super("Java Swing Assignment");
        this.setSize(new Dimension(800, 800));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Load Window Icon
        loadWindowIcon("asset/Download Tan Leather Chair with Gold Trim Displayed on Transparent Background for free.jpg");

        // Main Panel Setup
        mainContainer = new JPanel();
        mainContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));
        mainContainer.setBackground(new Color(240, 240, 240));

        // Primary Header Label
        headerLabel = new JLabel("Welcome to Java Swing First Individual Assignment by Abdul Rahman Sow");
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
        headerLabel.setForeground(new Color(30, 30, 30));

        // Control Buttons
        btnModifyText = new JButton("Change Text");
        btnModifyBg = new JButton("Change Background");

        btnModifyText.setFocusable(false);
        btnModifyBg.setFocusable(false);

        // Register Action Listeners
        btnModifyText.addActionListener(this);
        btnModifyBg.addActionListener(this);

        // Secondary Panel to keep buttons grouped on a lower row
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        controlPanel.setOpaque(false);
        controlPanel.add(btnModifyText);
        controlPanel.add(btnModifyBg);

        // Assemble Layout
        mainContainer.add(headerLabel);
        mainContainer.add(controlPanel);
        this.add(mainContainer);
    }

    // Helper method for icon handling
    private void loadWindowIcon(String path) {
        try {
            ImageIcon windowIcon = new ImageIcon(path);
            Image scaledIcon = windowIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
            this.setIconImage(scaledIcon);
        } catch (Exception ex) {
            System.err.println("Could not load icon file: " + ex.getMessage());
        }
    }

    // Single Event Handler for both buttons
    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        if (source == btnModifyText) {
            headerLabel.setText("Text updated! Event Driven Programming in Java Swing.");
        } else if (source == btnModifyBg) {
            mainContainer.setBackground(new Color(250, 220, 0));
        }
    }

    // Execution Entry Point
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SowGUI application = new SowGUI();
            application.setVisible(true);
        });
    }
}
