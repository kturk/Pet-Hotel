package businesslayer.model;

public class Cat extends Pet{

    private final static double PRICE_FOR_DAY = 30;
    private final static double EXPENSE_FOR_DAY = 8;

    public Cat() {
        super();
    }

    public Cat(String name, int age, int numOfDays) {
        super(name, age, numOfDays);
    }

    @Override
    public double getCompletedOperationCost() {
        double completedCost = 0;

        for(OperationType o : getCompletedOperations()){
            completedCost += o.getPriceForCat();
        }
        return completedCost;
    }

    @Override
    public double getEstimatedOperationCost() {
        double estimatedCost = getCompletedOperationCost();

        for(OperationType o : getTodoOperations()){
            estimatedCost += o.getPriceForCat();
        }
        return estimatedCost;
    }

    @Override
    public double getCompletedOperationExpense() {
        double completedExpense = 0;

        for(OperationType o : getCompletedOperations()){
            completedExpense += o.getExpenseForCat();
        }
        return completedExpense;
    }

    @Override
    public double getTotalRentCost() {
        return PRICE_FOR_DAY * getNumOfDays();
    }

    @Override
    public double getTotalRentExpense() {
        return EXPENSE_FOR_DAY * getNumOfDays();
    }

    @Override
    public String toString() {
        return "Cat          " + super.toString();
    }
}
