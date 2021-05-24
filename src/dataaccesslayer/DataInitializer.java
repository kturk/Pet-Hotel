package dataaccesslayer;

import businesslayer.creator.*;
import businesslayer.model.*;

public class DataInitializer implements IDataInitializer {

    private PetCreator dogCreator = new DogCreator();
    private PetCreator catCreator = new CatCreator();
    private UserCreator adminCreator = new AdminCreator();
    private UserCreator ownerCreator = new OwnerCreator();

    @Override
    public HotelAdmin getInitialAdmin() {
        HotelAdmin hotelAdmin = (HotelAdmin) adminCreator.createUser("admin", "admin123");


        Owner owner1 = (Owner) ownerCreator.createUser("tugkantuglular", "tugkan123");
        owner1.addNewPet(catCreator.createPet("Bella", 3, 8));
        owner1.addNewPet(dogCreator.createPet("Cooper", 6, 12));

        Owner owner2 = (Owner) ownerCreator.createUser("dilekozturk", "dilek123");
        owner2.addNewPet(catCreator.createPet("Kitty", 1, 3));

        Owner owner3 = (Owner) ownerCreator.createUser("serhatcaner", "serhat123");
        owner3.addNewPet(dogCreator.createPet("Lola", 3, 7));
        owner3.addNewPet(dogCreator.createPet("Moly", 4, 7));
        owner3.addNewPet(dogCreator.createPet("Duke", 3, 7));

        Owner owner4 = (Owner) ownerCreator.createUser("canertanguler", "caner123");
        owner4.addNewPet(catCreator.createPet("Lucy", 5, 5));
        owner4.addNewPet(dogCreator.createPet("Zeus", 4, 12));

        Owner owner5 = (Owner) ownerCreator.createUser("kemalturk", "kemal123");
        owner5.addNewPet(catCreator.createPet("Zagreus", 2, 10));
        owner5.addNewPet(dogCreator.createPet("Cerberus", 6, 3));

        Owner owner6 = (Owner) ownerCreator.createUser("serapsahin", "serap123");
        owner6.addNewPet(catCreator.createPet("Pepper", 3, 15));
        owner6.addNewPet(catCreator.createPet("Millie", 3, 15));


        hotelAdmin.addOwner(owner1); hotelAdmin.addOwner(owner2); hotelAdmin.addOwner(owner3);
        hotelAdmin.addOwner(owner4); hotelAdmin.addOwner(owner5); hotelAdmin.addOwner(owner6);

        return hotelAdmin;
    }
}
