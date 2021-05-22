package presentationlayer.hoteladminscreens;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionListener;

public class AdminMessagesScreen extends JFrame{

    private JPanel panel;

    private JLabel ownersLabel;
    private JList owners;
    private JScrollPane scrollPane;

    private JButton selectButton;
    private JButton backButton;

//    private JLabel userPetsLabel;
//    private JList petList;



    public AdminMessagesScreen() {
        super("Messages with Pet Hotel");
        screenInitializer();

    }

    private void screenInitializer() {
        setSize(400,500);
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
        ownersLabel = new JLabel("Pet Owners");
        owners = new JList();
        scrollPane = new JScrollPane();

        selectButton = new JButton("Select");
        backButton = new JButton("Back");

//        userPetsLabel = new JLabel("My Pets");
    }

    private void locateComponents() {
        ownersLabel.setBounds(0, 5, 400, 25);
        ownersLabel.setHorizontalAlignment(SwingConstants.CENTER);

        scrollPane.setBounds(30,40, 340,300);

        selectButton.setBounds(145,350,110,25);
        backButton.setBounds(20,430,110,25);
    }

    private void addComponents() {
        panel.add(ownersLabel);

        scrollPane.setViewportView(owners);
        panel.add(scrollPane);

        panel.add(selectButton);
        panel.add(backButton);
    }

    public JList getOwners() {
        return owners;
    }

    public void setOwners(Object[] ownerList) {
        owners.setListData(ownerList);
    }

    public void addSelectButtonListener(ActionListener actionListener) {
        selectButton.addActionListener(actionListener);
    }

    public void addBackButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
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

