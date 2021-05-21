package presentationlayer.hoteladminscreens;

import javax.swing.*;
import java.awt.event.ActionListener;


public class MakeOperationsScreen extends JFrame {

    private JPanel panel;
    private JLabel todoOperationsLabel;
    private JLabel completedOperationsLabel;

    private JList todoOperations;
    private JList completedOperations;
    private JButton completeButton;
//    private JButton unfollowButton;

    private JButton backButton;

    public MakeOperationsScreen() {
        super("Operations");
        screenInitializer();
    }

    private void screenInitializer() {
        setSize(400,450);
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
        todoOperationsLabel = new JLabel("Waiting Operations");
        completedOperationsLabel = new JLabel("Completed Operations");
        todoOperations = new JList();
        completedOperations = new JList();
        completeButton = new JButton(">>");
//        unfollowButton = new JButton("Unfollow");
        backButton = new JButton("Back");
    }

    private void locateComponents() {
        todoOperationsLabel.setBounds(50,10,110,25);
        todoOperationsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        completedOperationsLabel.setBounds(240,10,110,25);
        completedOperationsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        todoOperations.setBounds(30,40, 150,250);
        completedOperations.setBounds(220,40,150,250);
//        unfollowButton.setBounds(240,300,110, 25);
        completeButton.setBounds(50,300,110,25);

        backButton.setBounds(20,360,110,25);

    }

    private void addComponents() {
        panel.add(todoOperationsLabel);
        panel.add(completedOperationsLabel);
        panel.add(todoOperations);
        panel.add(completedOperations);
        panel.add(completeButton);
//        panel.add(unfollowButton);
        panel.add(backButton);
    }

    public void setTodoOperations(Object[] itemList) {
        todoOperations.setListData(itemList);
    }

    public void setCompletedOperations(Object[] itemList) {
        completedOperations.setListData(itemList);
    }

    public JList getTodoOperations() {
        return todoOperations;
    }

    public JList getCompletedOperations() {
        return completedOperations;
    }

    public void addFollowButtonListener(ActionListener actionListener) {
        completeButton.addActionListener(actionListener);
    }

//    public void addUnfollowButtonListener(ActionListener actionListener) {
//        unfollowButton.addActionListener(actionListener);
//    }

    public void setBackButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void showScreen(){
        setVisible(true);
    }

    public void closeScreen(){
        dispose();
    }

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}