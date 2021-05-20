package presentationlayer;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SeeStatusOfPets extends JFrame{

    private JPanel panel;

    private JLabel petTypeLabel;
    private JComboBox<String> petTypeDropdown;

    private JLabel petNameLabel;
    private JTextField petNameField;

    private JLabel petAgeLabel;
    private JTextField petAgeField;


    private JButton submitButton;
    private JButton backButton;


    private JLabel userPetsLabel;
    private JList petList;
    JScrollPane scrollPane;


    public SeeStatusOfPets() {
        super("Add New Pet");
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
        String[] petStrings = {"Cat", "Dog"};

        petTypeLabel = new JLabel("Pet Type:");
        petTypeDropdown = new JComboBox<String>(petStrings);

        petNameLabel = new JLabel("Pet Name:");
        petNameField = new JTextField(10);

        petAgeLabel = new JLabel("Pet Name:");
        petAgeField = new JTextField(10);

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

        submitButton.setBounds(30,120,110,25);

        userPetsLabel.setBounds(0, 160, 400, 25);
        userPetsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scrollPane.setBounds(30,190, 340,220);

        backButton.setBounds(20,430,110,25);

    }

    private void addComponents() {
        panel.add(petTypeLabel);
        panel.add(petTypeDropdown);
        panel.add(petNameLabel);
        panel.add(petNameField);
        panel.add(petAgeLabel);
        panel.add(petAgeField);

        panel.add(submitButton);
        panel.add(backButton);

        scrollPane.setViewportView(petList);

        panel.add(scrollPane);
        panel.add(userPetsLabel);


//        addKeyListener();
    }

    private void addKeyListener(){
        petAgeField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = petAgeField.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    petAgeField.setEditable(true);
//                    label.setText("");
                } else {
                    petAgeField.setEditable(false);
//                    label.setText("* Enter only numeric digits(0-9)");
                }
            }
        });
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

