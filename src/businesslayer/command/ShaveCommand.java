package businesslayer.command;

import businesslayer.model.Pet;

public class ShaveCommand implements Command{

    private final Pet pet;

    public ShaveCommand(Pet pet) {
        this.pet = pet;
    }

    @Override
    public void execute() {
        pet.shave();
    }
}
