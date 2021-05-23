package businesslayer.model;

public class Dog extends Pet{

    private final static double PRICE_FOR_DAY = 40;
    private final static double EXPENSE_FOR_DAY = 10;

    public Dog() {
        super();
    }

    public Dog(String name, int age, int numOfDays) {
        super(name, age, numOfDays);
    }

    @Override
    public double getCompletedOperationCost() {
        double completedCost = 0;

        for(OperationType o : getCompletedOperations()){
            completedCost += o.getPriceForDog();
        }
        return completedCost;
    }

    @Override
    public double getEstimatedOperationCost() {
        double estimatedCost = getCompletedOperationCost();

        for(OperationType o : getTodoOperations()){
            estimatedCost += o.getPriceForDog();
        }
        return estimatedCost;
    }

    @Override
    public double getCompletedOperationExpense() {
        double completedExpense = 0;

        for(OperationType o : getCompletedOperations()){
            completedExpense += o.getExpenseForDog();
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
        return "Dog         " + super.toString();
    }
}
