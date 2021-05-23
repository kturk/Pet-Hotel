package businesslayer.command;

import businesslayer.model.Pet;

public class DentalCareCommand implements Command{

    private final Pet pet;

    public DentalCareCommand(Pet pet) {
        this.pet = pet;
    }

    @Override
    public void execute() {
        pet.dentalCare();
    }

    @Override
    public void undo() {
        pet.undoDentalCare();
    }
}
