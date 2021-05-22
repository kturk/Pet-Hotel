package presentationlayer;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class RegisterScreen extends JFrame{

    private JTextField usernameField;
    private JLabel usernameLabel;

    private JPasswordField passwordField;
    private JLabel passwordLabel;

    private JPasswordField passwordConfirmationField;
    private JLabel passwordConformationLabel;

    private JButton registerButton;

    private JButton backButton;

    private JPanel loginPanel;

    public RegisterScreen() {
        super("Register Screen");
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
        usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField(10);

        passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField(10);

        passwordConformationLabel = new JLabel("Password Again: ");
        passwordConfirmationField = new JPasswordField(10);

        registerButton = new JButton("Register");
        backButton = new JButton("Back");
    }

    private void locateComponents() {
        usernameLabel.setBounds(20,20,100,25);
        usernameField.setBounds(130, 20, 150, 25);
        passwordLabel.setBounds(20,60,100,25);
        passwordField.setBounds(130, 60, 150, 25);
        passwordConformationLabel.setBounds(20,100,100,25);
        passwordConfirmationField.setBounds(130, 100, 150, 25);
        registerButton.setBounds(170, 140, 110, 25);
        backButton.setBounds(15, 180, 110, 25);
    }

    private void addComponents() {
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(passwordConformationLabel);
        loginPanel.add(passwordConfirmationField);
        loginPanel.add(registerButton);
        loginPanel.add(backButton);
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JPasswordField getPasswordConfirmationField() {
        return passwordConfirmationField;
    }

    public void addRegisterButtonListener(ActionListener actionListener) {
        registerButton.addActionListener(actionListener);
    }

    public boolean checkEmptyFieldExist() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String passwordConformation = new String(passwordConfirmationField.getPassword());
        return(username.length() == 0 || password.length() == 0 || passwordConformation.length() == 0);
    }

    public void addBackButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void showWarning(String warningMessage) {
        JOptionPane.showMessageDialog(this, warningMessage);
    }

    public void closeScreen(){
        dispose();
    }

    public void showScreen(){
        setVisible(true);
    }
}
