package presentationlayer.ownerscreens;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PetInvoiceScreen extends JFrame{

    private JPanel panel;

    private JLabel petNameLabel;
    private JLabel petName;

    private JButton backButton;
    private JButton checkoutButton;

    private JLabel completedOperationsPriceLabel;
    private JLabel totalRentPriceLabel;
    private JLabel totalPriceLabel;

    private JLabel completedOperationsPrice;
    private JLabel totalRentPrice;
    private JLabel totalPrice;

    private JLabel unfinishedOperationsLabel;
    private JList unfinishedOperationsList;
    private JScrollPane scrollPane;


    public PetInvoiceScreen() {
        super("Pet Invoice");
        screenInitializer();

    }

    private void screenInitializer() {
        setSize(470,320);
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
        backButton = new JButton("Back");
        checkoutButton = new JButton("Checkout");

        petNameLabel = new JLabel("Pet: ");
        petName = new JLabel();

        completedOperationsPriceLabel = new JLabel("Total Operations Price: ");
        totalRentPriceLabel = new JLabel("Total Daily Rent Price: ");
        totalPriceLabel = new JLabel("Total Price: ");

        completedOperationsPrice = new JLabel("0");
        totalRentPrice = new JLabel("0");
        totalPrice = new JLabel("0");

        unfinishedOperationsLabel = new JLabel("Unfinished Operations");
        unfinishedOperationsList = new JList();
        scrollPane = new JScrollPane();
    }

    private void locateComponents() {
        petNameLabel.setBounds(20, 30, 160, 25);
        petName.setBounds(200, 30, 160, 25);

        completedOperationsPriceLabel.setBounds(20, 80, 160, 25);
        totalRentPriceLabel.setBounds(20, 110, 160, 25);
        totalPriceLabel.setBounds(20, 140, 160, 25);

        completedOperationsPrice.setBounds(200, 80, 40, 25);
        totalRentPrice.setBounds(200, 110, 40, 25);
        totalPrice.setBounds(200, 140, 40, 25);

        unfinishedOperationsLabel.setBounds(260,30, 160,25);
        unfinishedOperationsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scrollPane.setBounds(260, 60, 160, 120);

        backButton.setBounds(20,250,110,25);
        checkoutButton.setBounds(150,250,110,25);
    }

    private void addComponents() {
        panel.add(backButton);
        panel.add(checkoutButton);

        panel.add(petNameLabel);
        panel.add(petName);

        panel.add(completedOperationsPriceLabel);
        panel.add(totalRentPriceLabel);
        panel.add(totalPriceLabel);

        panel.add(completedOperationsPrice);
        panel.add(totalRentPrice);
        panel.add(totalPrice);

        panel.add(unfinishedOperationsLabel);
        scrollPane.setViewportView(unfinishedOperationsList);
        panel.add(scrollPane);
    }

    public void setCompletedOperationsPrice(double price) {
        completedOperationsPrice.setText(Double.toString(price));
    }

    public void setTotalRentPrice(double price) {
        totalRentPrice.setText(Double.toString(price));
    }

    public void setTotalPrice(double price) {
        totalPrice.setText(Double.toString(price));
    }

    public void setPetName(String name) {
        petName.setText(name);
    }

    public void addCheckoutButtonListener(ActionListener actionListener) {
        checkoutButton.addActionListener(actionListener);
    }

    public void setUnfinishedOperationsList(Object[] itemList) {
        unfinishedOperationsList.setListData(itemList);
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

