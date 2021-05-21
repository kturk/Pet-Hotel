package businesslayer.command;

import businesslayer.model.Pet;

public class BathCommand implements Command{

    private Pet pet;

    public BathCommand(Pet pet) {
        this.pet = pet;
    }

    @Override
    public void execute() {
        pet.bath();
    }
}
