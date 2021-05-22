package presentationlayer;

import javax.swing.*;
import java.awt.event.ActionListener;


public class LoginChoiceScreen extends JFrame{

    private JLabel choiceLabel;
    private JButton adminButton;
    private JButton ownerButton;

    private JPanel loginPanel;

    public LoginChoiceScreen() {
        super("Login Screen");
        screenInitializer();
    }

    private void screenInitializer() {
        setSize(300,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initializePanels();
        locatePanels();
        addPanels();

        initializeComponents();
        locateComponents();
        addComponents();
        setLocationRelativeTo(null);
    }

    private void initializePanels() {
        loginPanel = new JPanel();
    }

    private void locatePanels() {
        loginPanel.setLayout(null);
    }

    private void addPanels() {
        add(loginPanel);
    }

    private void initializeComponents() {
        choiceLabel = new JLabel("Which role you would like to login with?");
        adminButton = new JButton("Hotel Admin");
        ownerButton = new JButton("Pet Owner");
    }

    private void locateComponents() {
        choiceLabel.setBounds(0,20,300,25);
        choiceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        adminButton.setBounds(95, 70, 110, 25);
        ownerButton.setBounds(95, 115, 110, 25);

    }

    private void addComponents() {
        loginPanel.add(choiceLabel);
        loginPanel.add(ownerButton);
        loginPanel.add(adminButton);
    }

    public void addAdminButtonListener(ActionListener actionListener) {
        adminButton.addActionListener(actionListener);
    }

    public void addOwnerButtonListener(ActionListener actionListener) {
        ownerButton.addActionListener(actionListener);
    }

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public void closeScreen(){
        dispose();
    }

    public void showScreen(){
        setVisible(true);
    }
}
