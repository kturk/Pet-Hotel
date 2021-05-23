package presentationlayer.hoteladminscreens;

import javax.swing.*;
import java.awt.event.ActionListener;

public class HotelAdminMainScreen extends JFrame{

    private JPanel buttonsPanel;

    private JLabel userLabel;

    private JButton seeAllPetsButton;
    private JButton messagesButton;
    private JButton statisticsButton;

    private JButton logoutButton;

    public HotelAdminMainScreen() {
        super("Admin Main Screen");
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

        seeAllPetsButton = new JButton("See All Pets");
        statisticsButton = new JButton("Statistics");
        messagesButton = new JButton("Messages");
        logoutButton = new JButton("Logout");
    }

    private void locateComponents() {

        userLabel.setBounds(75, 30, 250 ,25);

        seeAllPetsButton.setBounds(75,80,250,25);
        statisticsButton.setBounds(75,120,250,25);
        messagesButton.setBounds(75,160,250,25);
        logoutButton.setBounds(75,280,250,25);
    }

    private void addComponents() {
        buttonsPanel.add(userLabel);

        buttonsPanel.add(seeAllPetsButton);
        buttonsPanel.add(statisticsButton);
        buttonsPanel.add(messagesButton);
        buttonsPanel.add(logoutButton);
    }

    public void renderUsername(String username) {
        userLabel.setText("User: " + username);
    }


    public void addSeeAllPetsButtonListener(ActionListener actionListener) {
        seeAllPetsButton.addActionListener(actionListener);
    }

    public void addStatisticsButtonListener(ActionListener actionListener) {
        statisticsButton.addActionListener(actionListener);
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
