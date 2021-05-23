package presentationlayer;

import javax.swing.*;
import java.awt.event.ActionListener;


public class LoginChoiceScreen extends JFrame{

    private JLabel loginLabel;
    private JLabel registerLabel;

    private JButton adminButton;
    private JButton ownerButton;

    private JButton registerButton;

    private JPanel loginPanel;

    public LoginChoiceScreen() {
        super("Login Choice Screen");
        screenInitializer();
    }

    private void screenInitializer() {
        setSize(400,250);
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
        loginLabel = new JLabel("Login");
        registerLabel = new JLabel("Register");
        adminButton = new JButton("Hotel Admin");
        ownerButton = new JButton("Pet Owner");
        registerButton = new JButton("Register Owner");
    }

    private void locateComponents() {
        loginLabel.setBounds(30,20,110,25);
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

        registerLabel.setBounds(240, 20, 130,25);
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        adminButton.setBounds(30, 60, 110, 25);
        ownerButton.setBounds(30, 105, 110, 25);
        registerButton.setBounds(240,60,130,25);

    }

    private void addComponents() {
        loginPanel.add(loginLabel);
        loginPanel.add(registerLabel);
        loginPanel.add(ownerButton);
        loginPanel.add(adminButton);
        loginPanel.add(registerButton);
    }

    public void addAdminButtonListener(ActionListener actionListener) {
        adminButton.addActionListener(actionListener);
    }

    public void addOwnerButtonListener(ActionListener actionListener) {
        ownerButton.addActionListener(actionListener);
    }

    public void addRegisterButtonListener(ActionListener actionListener) {
        registerButton.addActionListener(actionListener);
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
