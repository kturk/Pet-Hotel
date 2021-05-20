package businesslayer.command;

import businesslayer.model.Pet;

public class CutNailsCommand implements Command{

    private Pet pet;

    public CutNailsCommand(Pet pet) {
        this.pet = pet;
    }

    @Override
    public void execute() {
        pet.cutNails();
    }
}
