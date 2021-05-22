package presentationlayer.hoteladminscreens;

import javax.swing.*;
import java.awt.event.ActionListener;

public class StatisticsScreen extends JFrame{

    private JPanel panel;

    private JLabel newExpensesLabel;
    private JTextArea expensesTextField;

    private JButton setExpenseButton;
    private JButton backButton;

    private JLabel expensesLabel;
    private JLabel totalDailyIncomeLabel;
    private JLabel totalOperationsIncomeLabel;
    private JLabel totalProfitLabel;

    private JLabel expenses;
    private JLabel totalDailyIncome;
    private JLabel totalOperationsIncome;
    private JLabel totalProfit;


    public StatisticsScreen() {
        super("Statistics");
        screenInitializer();

    }

    private void screenInitializer() {
        setSize(400,320);
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
        newExpensesLabel = new JLabel("New Expenses: ");
        expensesTextField = new JTextArea();
        setExpenseButton = new JButton("Set Expenses");
        backButton = new JButton("Back");

        expensesLabel = new JLabel("Expenses: ");
        totalDailyIncomeLabel = new JLabel("Total Daily Rent Income: ");
        totalOperationsIncomeLabel = new JLabel("Total Operations Income: ");
        totalProfitLabel = new JLabel("Total Profit: ");

        expenses = new JLabel("0");
        totalDailyIncome = new JLabel("0");
        totalOperationsIncome = new JLabel("0");
        totalProfit = new JLabel("0");

    }

    private void locateComponents() {

        newExpensesLabel.setBounds(20, 20, 90, 25);
        expensesTextField.setBounds(120, 20, 50, 25);
        setExpenseButton.setBounds(200,20,130,25);

        expensesLabel.setBounds(20, 80, 160, 25);
        totalDailyIncomeLabel.setBounds(20, 110, 160, 25);
        totalOperationsIncomeLabel.setBounds(20, 140, 160, 25);
        totalProfitLabel.setBounds(20, 190, 160, 25);


        expenses.setBounds(200, 80, 160, 25);
        totalDailyIncome.setBounds(200, 110, 160, 25);
        totalOperationsIncome.setBounds(200, 140, 160, 25);
        totalProfit.setBounds(200, 190, 160, 25);


        backButton.setBounds(20,250,110,25);
    }

    private void addComponents() {
        panel.add(newExpensesLabel);
        panel.add(expensesTextField);
        panel.add(setExpenseButton);
        panel.add(backButton);

        panel.add(expensesLabel);
        panel.add(totalDailyIncomeLabel);
        panel.add(totalOperationsIncomeLabel);
        panel.add(totalProfitLabel);

        panel.add(expenses);
        panel.add(totalDailyIncome);
        panel.add(totalOperationsIncome);
        panel.add(totalProfit);

//        addKeyListener();
    }

    public void setExpenses(double price) {
        expenses.setText(Double.toString(price));
    }

    public void setTotalDailyIncome(double price) {
        totalDailyIncome.setText(Double.toString(price));
    }

    public void setTotalOperationsIncome(double price) {
        totalOperationsIncome.setText(Double.toString(price));
    }

    public void setTotalProfit(double price) {
        totalProfit.setText(Double.toString(price));
    }

    public JTextArea getExpensesTextField() {
        return expensesTextField;
    }

    public void addSetExpenseButtonListener(ActionListener actionListener) {
        setExpenseButton.addActionListener(actionListener);
    }

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
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

