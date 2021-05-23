package businesslayer.controller.hoteladmincontrollers;

import businesslayer.Mediator;
import businesslayer.model.HotelAdmin;
import presentationlayer.hoteladminscreens.StatisticsScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsController {

    private final HotelAdmin hotelAdminModel;
    private final StatisticsScreen statisticsView;

    private final Mediator mediator;

    public StatisticsController(HotelAdmin hotelAdminModel, StatisticsScreen statisticsView, Mediator mediator) {
        this.hotelAdminModel = hotelAdminModel;
        this.statisticsView = statisticsView;
        this.mediator = mediator;

        statisticsView.addSetExpenseButtonListener(new SetExpenseButtonListener());
        statisticsView.addBackButtonListener(new BackButtonListener());

        setPrices();
    }

    public void showView() {
        statisticsView.showScreen();
    }

    public void closeView() {
        statisticsView.closeScreen();
    }

    public void setPrices() {
        Double extraExpenses = hotelAdminModel.getExtraExpenses();
        Double totalDailyIncome = hotelAdminModel.getTotalDailyRentingIncome();
        Double totalOperationsIncome = hotelAdminModel.getTotalOperationsIncome();
        Double totalDailyExpense = hotelAdminModel.getTotalDailyRentingExpense();
        Double totalOperationsExpense = hotelAdminModel.getTotalOperationsExpense();
        Double totalProfit =
                totalDailyIncome + totalOperationsIncome - totalDailyExpense - totalOperationsExpense - extraExpenses;

        statisticsView.setExpenses(extraExpenses);
        statisticsView.setTotalDailyIncome(totalDailyIncome);
        statisticsView.setTotalOperationsIncome(totalOperationsIncome);
        statisticsView.setTotalDailyExpense(totalDailyExpense);
        statisticsView.setTotalOperationsExpense(totalOperationsExpense);
        statisticsView.setTotalProfit(totalProfit);
    }


    class SetExpenseButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String newExpense = statisticsView.getExpensesTextField().getText();

            try {
                Double expense = Double.parseDouble(newExpense);
                hotelAdminModel.addExtraExpense(expense);
                setPrices();
                statisticsView.clearExpensesTextField();
            }
            catch (NumberFormatException exception){
                statisticsView.showError("Please enter a number!");
            }
        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToHotelAdminMainScreen();
        }
    }


}
