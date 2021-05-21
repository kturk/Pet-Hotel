package businesslayer.command;

import businesslayer.model.Pet;

public class VaccinationCommand implements Command{

    private Pet pet;

    public VaccinationCommand(Pet pet) {
        this.pet = pet;
    }

    @Override
    public void execute() {
        pet.vaccination();
    }
}
