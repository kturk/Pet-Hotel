package presentationlayer.hoteladminscreens;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SeeAllPetsScreen extends JFrame{

    private JPanel panel;

    private JButton selectButton;
    private JButton backButton;

    private JLabel petsLabel;
    private JList petList;
    private JScrollPane scrollPane;


    public SeeAllPetsScreen() {
        super("All Pets");
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
        selectButton = new JButton("Operations");
        backButton = new JButton("Back");

        petList = new JList();
        scrollPane = new JScrollPane();
        petsLabel = new JLabel("All Pets");
    }

    private void locateComponents() {
        selectButton.setBounds(30,300,110,25);

        petsLabel.setBounds(0, 30, 400, 25);
        petsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scrollPane.setBounds(30,60, 340,220);

        backButton.setBounds(20,430,110,25);
    }

    private void addComponents() {
        panel.add(selectButton);
        panel.add(backButton);

        scrollPane.setViewportView(petList);

        panel.add(scrollPane);
        panel.add(petsLabel);
//        addKeyListener();
    }

    public void addSelectButtonListener(ActionListener actionListener) {
        selectButton.addActionListener(actionListener);
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

