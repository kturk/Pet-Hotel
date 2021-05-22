package dataaccesslayer;

import businesslayer.*;
import businesslayer.model.*;

import java.util.ArrayList;
import java.util.List;

public class DataInitializer implements IDataInitializer {

    private PetCreator dogCreator = new DogCreator();
    private PetCreator catCreator = new CatCreator();
    private UserCreator adminCreator = new AdminCreator();
    private UserCreator ownerCreator = new OwnerCreator();

    @Override
    public HotelAdmin getInitialAdmin() {
        HotelAdmin hotelAdmin = (HotelAdmin) adminCreator.createUser("admin", "123");
        Owner owner1 = (Owner) ownerCreator.createUser("owner", "123");
        owner1.addNewPet(new Cat("kedy",22));
        owner1.addNewPet(new Dog("kopke", 20));
        Owner owner2 = (Owner) ownerCreator.createUser("owner2", "123");
        owner2.addNewPet(new Cat("kedy2",11));
        owner2.addNewPet(new Dog("kopke2", 10));

        hotelAdmin.addOwner(owner1); hotelAdmin.addOwner(owner2);

        return hotelAdmin;
    }
}
