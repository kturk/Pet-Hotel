package presentationlayer.ownerscreens;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewPetScreen extends JFrame{

    private JPanel panel;

    private JLabel petTypeLabel;
    private JComboBox<String> petTypeDropdown;

    private JLabel petNameLabel;
    private JTextField petNameField;

    private JLabel petAgeLabel;
    private JTextField petAgeField;

    private JLabel numOfDaysLabel;
    private JTextField numOfDaysField;

    private JButton submitButton;
    private JButton backButton;


    private JLabel userPetsLabel;
    private JList petList;
    private JScrollPane scrollPane;


    public NewPetScreen() {
        super("Add New Pet");
        screenInitializer();

    }

    private void screenInitializer() {
        setSize(400,550);
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
        String[] petStrings = {"Cat", "Dog"};

        petTypeLabel = new JLabel("Pet Type:");
        petTypeDropdown = new JComboBox<String>(petStrings);

        petNameLabel = new JLabel("Pet Name:");
        petNameField = new JTextField(10);

        petAgeLabel = new JLabel("Pet Age:");
        petAgeField = new JTextField(10);

        numOfDaysLabel = new JLabel("Days:");
        numOfDaysField = new JTextField(10);


        submitButton = new JButton("Register Pet");
        backButton = new JButton("Back");

        petList = new JList();
        scrollPane = new JScrollPane();
        userPetsLabel = new JLabel("My Pets");

    }

    private void locateComponents() {

        petTypeLabel.setBounds(30, 30, 100,25);
        petTypeDropdown.setBounds(150, 30, 150,25);

        petNameLabel.setBounds(30, 60, 100, 25);
        petNameField.setBounds(150, 60,150,25);

        petAgeLabel.setBounds(30, 90,100,25);
        petAgeField.setBounds(150, 90,150,25);

        numOfDaysLabel.setBounds(30, 120,100,25);
        numOfDaysField.setBounds(150, 120,150,25);

        submitButton.setBounds(30,150,110,25);

        userPetsLabel.setBounds(0, 190, 400, 25);
        userPetsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scrollPane.setBounds(30,220, 340,220);

        backButton.setBounds(20,480,110,25);

    }

    private void addComponents() {
        panel.add(petTypeLabel);
        panel.add(petTypeDropdown);
        panel.add(petNameLabel);
        panel.add(petNameField);
        panel.add(numOfDaysLabel);
        panel.add(numOfDaysField);
        panel.add(petAgeLabel);
        panel.add(petAgeField);

        panel.add(submitButton);
        panel.add(backButton);

        scrollPane.setViewportView(petList);

        panel.add(scrollPane);
        panel.add(userPetsLabel);

    }


    public JComboBox<String> getPetTypeDropdown() {
        return petTypeDropdown;
    }

    public JTextField getPetNameField() {
        return petNameField;
    }

    public JTextField getPetAgeField() {
        return petAgeField;
    }

    public JTextField getNumOfDaysField() {
        return numOfDaysField;
    }

    public void addSubmitButtonListener(ActionListener actionListener) {
        submitButton.addActionListener(actionListener);
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

