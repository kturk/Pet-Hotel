package businesslayer.model;

public class Dog extends Pet{
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Dog -->     " + super.toString();
    }
}
