package businesslayer.model;

public class Dog extends Pet{
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
        return estimatedCost;
    }

    @Override
    public String toString() {
        return "Dog -->     " + super.toString();
    }
}
