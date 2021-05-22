package presentationlayer.ownerscreens;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;

public class OwnerMessagesScreen extends JFrame{

    private JPanel panel;

    private JTextPane chatScreen;
    private JScrollPane scrollPane;

    private JTextField newMessageField;

    private JButton sendButton;
    private JButton backButton;

//    private JLabel userPetsLabel;
//    private JList petList;



    public OwnerMessagesScreen() {
        super("Messages with Pet Hotel");
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
        chatScreen = new JTextPane();
        scrollPane = new JScrollPane();

        newMessageField = new JTextField();

        sendButton = new JButton("Send");
        backButton = new JButton("Back");

//        userPetsLabel = new JLabel("My Pets");
    }

    private void locateComponents() {
        scrollPane.setBounds(30,30, 540,380);
        newMessageField.setBounds(30, 430, 450, 50);

        sendButton.setBounds(490,430,80,50);
        backButton.setBounds(20,500,110,25);
    }

    private void addComponents() {
        chatScreen.setEditable(false);
        scrollPane.setViewportView(chatScreen);
        panel.add(scrollPane);
        panel.add(newMessageField);

        panel.add(sendButton);
        panel.add(backButton);
    }

    public JTextField getNewMessageField() {
        return newMessageField;
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

