package presentationlayer.ownerscreens;

import javax.swing.*;
import java.awt.event.ActionListener;

public class OwnerMainScreen extends JFrame{

    private JPanel buttonsPanel;

    private JLabel userLabel;

    private JButton newPetButton;
    private JButton seeOwnersPetsButton;
    private JButton messagesButton;
    private JButton logoutButton;


    public OwnerMainScreen() {
        super("Owner Main Screen");
        screenInitializer();
    }

    private void screenInitializer() {
        setSize(400,400);
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
        buttonsPanel = new JPanel();
    }

    private void locatePanels() {
        buttonsPanel.setLayout(null);
    }

    private void addPanels() {
        add(buttonsPanel);
    }

    private void initializeComponents() {

        userLabel = new JLabel("User: ");

        newPetButton = new JButton("Register New Pet");
        seeOwnersPetsButton = new JButton("See My Pets");
        messagesButton = new JButton("Messages with Pet Hotel");
        logoutButton = new JButton("Logout");
    }

    private void locateComponents() {

        userLabel.setBounds(75, 30, 250 ,25);

        newPetButton.setBounds(75,80,250,25);
        seeOwnersPetsButton.setBounds(75,120,250,25);
        messagesButton.setBounds(75,160,250,25);
//        4.setBounds(75,200,250,25);
//        5.setBounds(75,240,250,25);
        logoutButton.setBounds(75,280,250,25);
    }

    private void addComponents() {
        buttonsPanel.add(userLabel);

        buttonsPanel.add(newPetButton);
        buttonsPanel.add(seeOwnersPetsButton);
        buttonsPanel.add(messagesButton);
        buttonsPanel.add(logoutButton);
    }

    public void renderUsername(String username) {
        userLabel.setText("User: " + username);
    }

    public void addNewPetButtonListener(ActionListener actionListener) {
        newPetButton.addActionListener(actionListener);
    }

    public void addSeeOwnersPetsButtonListener(ActionListener actionListener) {
        seeOwnersPetsButton.addActionListener(actionListener);
    }

    public void addMessagesButtonListener(ActionListener actionListener) {
        messagesButton.addActionListener(actionListener);
    }

    public void addLogoutButtonListener(ActionListener actionListener) {
        logoutButton.addActionListener(actionListener);
    }

    public void closeScreen(){
        dispose();
    }

    public void showScreen(){
        setVisible(true);
    }
}
