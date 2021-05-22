package presentationlayer.hoteladminscreens;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionListener;

public class ChatWithOwnerScreen extends JFrame{

    private JPanel panel;

    private JLabel ownerNameLabel;
    private JLabel ownerName;

    private JTextPane chatScreen;
    private JScrollPane scrollPane;

    private JTextField newMessageField;

    private JButton sendButton;
    private JButton backButton;


    public ChatWithOwnerScreen() {
        super("Messages with Pet Owner");
        screenInitializer();
    }

    private void screenInitializer() {
        setSize(600,600);
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
        panel = new JPanel();
    }

    private void locatePanels() {
        panel.setLayout(null);
    }

    private void addPanels() {
        add(panel);
    }

    private void initializeComponents() {

        ownerNameLabel = new JLabel("Owner Username: ");
        ownerName = new JLabel();

        chatScreen = new JTextPane();
        scrollPane = new JScrollPane();

        newMessageField = new JTextField();

        sendButton = new JButton("Send");
        backButton = new JButton("Back");
    }

    private void locateComponents() {

        ownerNameLabel.setBounds(30,20, 110, 25);
        ownerName.setBounds(160,20, 110,25);

        scrollPane.setBounds(30,50, 540,380);
        newMessageField.setBounds(30, 450, 450, 50);

        sendButton.setBounds(490,450,80,50);
        backButton.setBounds(20,520,110,25);
    }

    private void addComponents() {
        chatScreen.setEditable(false);
        scrollPane.setViewportView(chatScreen);
        panel.add(ownerNameLabel);
        panel.add(ownerName);
        panel.add(scrollPane);
        panel.add(newMessageField);

        panel.add(sendButton);
        panel.add(backButton);
    }

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public JTextField getNewMessageField() {
        return newMessageField;
    }

    public void setOwnerName(String name){
        ownerName.setText(name);
    }

    public void setNewMessageField(String newMessage) {
        this.newMessageField.setText(newMessage);
    }

    public void setChatScreenDocument(StyledDocument doc){
        chatScreen.setStyledDocument(doc);
    }

    public void addSendButtonListener(ActionListener actionListener) {
        sendButton.addActionListener(actionListener);
    }

    public void addBackButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void closeScreen(){
        dispose();
    }

    public void showScreen(){
        setVisible(true);
    }
}

