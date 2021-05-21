package presentationlayer.ownerscreens;

import businesslayer.model.OperationType;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ManageOperationsForPetScreen extends JFrame{

    private JPanel panel;

    private JLabel petNameLabel;

    private JLabel operationTypeLabel;
    private JComboBox<OperationType> operationTypeDropDown;

    private JButton addOperationButton;
    private JButton deleteOperationButton;
    private JButton backButton;

    private JLabel todoOperationsLabel;
    private JList todoOperations;
    JScrollPane todoScrollPane;

    private JLabel completedOperationsLabel;
    private JList completedOperations;
    JScrollPane completedScrollPane;


    public ManageOperationsForPetScreen() {
        super("Add Operations for Pet");
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

        petNameLabel = new JLabel();

        operationTypeLabel = new JLabel("Operation Type:");
        operationTypeDropDown = new JComboBox<OperationType>();

        addOperationButton = new JButton("Add");
        deleteOperationButton = new JButton("Delete");
        backButton = new JButton("Back");

        todoOperations = new JList();
        todoScrollPane = new JScrollPane();
        todoOperationsLabel = new JLabel("Upcoming Operations");

        completedOperations = new JList();
        completedScrollPane = new JScrollPane();
        completedOperationsLabel = new JLabel("Completed Operations");
    }

    private void locateComponents() {
        petNameLabel.setBounds(30, 30, 100, 25);

        operationTypeLabel.setBounds(30, 60, 100,25);
        operationTypeDropDown.setBounds(150, 60, 150,25);

        addOperationButton.setBounds(325,60,110,25);

        todoOperationsLabel.setBounds(0, 100, 600, 25);
        todoOperationsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        todoScrollPane.setBounds(30,130, 540,150);

        deleteOperationButton.setBounds(245, 300, 110, 25);

        completedOperationsLabel.setBounds(0, 340, 600, 25);
        completedOperationsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        completedScrollPane.setBounds(30,370, 540,150);

        backButton.setBounds(20,530,110,25);

    }

    private void addComponents() {
        panel.add(operationTypeLabel);
        panel.add(operationTypeDropDown);
        panel.add(petNameLabel);

        panel.add(addOperationButton);
        panel.add(deleteOperationButton);
        panel.add(backButton);

        todoScrollPane.setViewportView(todoOperations);
        completedScrollPane.setViewportView(completedOperations);

        panel.add(todoScrollPane);
        panel.add(todoOperationsLabel);

        panel.add(completedScrollPane);
        panel.add(completedOperationsLabel);



//        addKeyListener();
    }


    public JComboBox<OperationType> getPetTypeDropdown() {
        return operationTypeDropDown;
    }

    public JList getTodoList() {
        return todoOperations;
    }

    public void setTodoList(Object[] itemList) {
        todoOperations.setListData(itemList);
    }

    public void setCompletedList(Object[] itemList) {
        completedOperations.setListData(itemList);
    }

    public void setPetName(String name) {
        petNameLabel.setText("Pet Name: " + name);
    }

    public void setOperationTypeDropDownList(List<OperationType> operations) {
        for (OperationType o : operations){
            operationTypeDropDown.addItem(o);
        }
    }

    public void deleteAllOperationTypes() {
        operationTypeDropDown.removeAllItems();
    }

    public void addAddOperationButtonListener(ActionListener actionListener) {
        addOperationButton.addActionListener(actionListener);
    }

    public void addDeleteOperationButtonListener(ActionListener actionListener) {
        deleteOperationButton.addActionListener(actionListener);
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

