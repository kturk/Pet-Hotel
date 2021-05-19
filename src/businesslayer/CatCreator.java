package businesslayer;

import businesslayer.model.Cat;
import businesslayer.model.Pet;

public class CatCreator implements PetCreator{

    @Override
    public Pet createPet(String name, int age) {
        return new Cat(name, age);
    }
}