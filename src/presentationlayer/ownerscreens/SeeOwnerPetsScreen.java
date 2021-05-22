package presentationlayer.ownerscreens;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SeeOwnerPetsScreen extends JFrame{

    private JPanel panel;

    private JButton selectButton;
    private JButton checkoutButton;

    private JButton backButton;

    private JLabel userPetsLabel;
    private JList petList;
    private JScrollPane scrollPane;


    public SeeOwnerPetsScreen() {
        super("My Pets");
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
        selectButton = new JButton("Select");
        checkoutButton = new JButton("Checkout");
        backButton = new JButton("Back");

        petList = new JList();
        scrollPane = new JScrollPane();
        userPetsLabel = new JLabel("My Pets");
    }

    private void locateComponents() {
        selectButton.setBounds(30,300,110,25);
        checkoutButton.setBounds(260, 300, 110,25);

        userPetsLabel.setBounds(0, 30, 400, 25);
        userPetsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scrollPane.setBounds(30,60, 340,220);

        backButton.setBounds(20,430,110,25);
    }

    private void addComponents() {
        panel.add(selectButton);
        panel.add(checkoutButton);
        panel.add(backButton);

        scrollPane.setViewportView(petList);

        panel.add(scrollPane);
        panel.add(userPetsLabel);
//        addKeyListener();
    }

    public void addSelectButtonListener(ActionListener actionListener) {
        selectButton.addActionListener(actionListener);
    }

    public void addCheckoutButtonListener(ActionListener actionListener) {
        checkoutButton.addActionListener(actionListener);
    }

    public JList getPetList() {
        return petList;
    }

    public void setList(Object[] itemList) {
        petList.setListData(itemList);
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

