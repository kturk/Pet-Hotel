package businesslayer.creator;

import businesslayer.model.Pet;

public interface PetCreator {

    Pet createPet(String name, int age, int numOfDays);
}
