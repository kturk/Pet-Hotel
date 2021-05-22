package businesslayer.model;

public class Dog extends Pet{

    private final static double PRICEFORDAY = 40;

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public double getCompletedCost() {
        double completedCost = 0;

        for(OperationType o : getCompletedOperations()){
            completedCost += o.getPriceForDog();
        }
        return completedCost;
    }

    @Override
    public double getEstimatedCost() {
        double estimatedCost = getCompletedCost();

        for(OperationType o : getTodoOperations()){
            estimatedCost += o.getPriceForDog();
        }
//        estimatedCost += getTotalRentCost();
        return estimatedCost;
    }

    @Override
    public double getTotalRentCost() {
        return PRICEFORDAY * getNumOfDays();
    }

    @Override
    public String toString() {
        return "Dog         " + super.toString();
    }
}
