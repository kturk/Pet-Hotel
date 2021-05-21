package businesslayer.command;

import businesslayer.model.OperationType;
import businesslayer.model.Pet;

public class CommandFactory {

    Pet pet;

    public CommandFactory(Pet pet) {
        this.pet = pet;
    }

    public Command getCommand(OperationType operationType){
        switch (operationType) {

            case NAILS:
                return new CutNailsCommand(pet);
            case BATH:
                return new BathCommand(pet);
            case SHAVE:
                return new ShaveCommand(pet);
            case DENTAL_CARE:
                return new DentalCareCommand(pet);
            case VACCINATION:
                return new VaccinationCommand(pet);
            default:
                return null;
        }
    }
}
