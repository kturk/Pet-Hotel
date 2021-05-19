package businesslayer;

import businesslayer.model.Pet;

public interface PetCreator {

    public Pet createPet(String name, int age);
}
