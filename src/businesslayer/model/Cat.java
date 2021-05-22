package businesslayer.model;

public class Cat extends Pet{
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public double getCompletedCost() {
        double completedCost = 0;

        for(OperationType o : getCompletedOperations()){
            completedCost += o.getPriceForCat();
        }
        return completedCost;
    }

    @Override
    public double getEstimatedCost() {
        double estimatedCost = getCompletedCost();

        for(OperationType o : getTodoOperations()){
            estimatedCost += o.getPriceForCat();
        }
        return estimatedCost;
    }

    @Override
    public String toString() {
        return "Cat -->      " + super.toString();
    }
}
