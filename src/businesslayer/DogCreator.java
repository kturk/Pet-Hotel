package businesslayer;

import businesslayer.model.Dog;
import businesslayer.model.Pet;

public class DogCreator implements PetCreator{

    @Override
    public Pet createPet(String name, int age, int numOfDays) {
        return new Dog(name, age, numOfDays);
    }
}
