package businesslayer;

import businesslayer.controller.*;
import businesslayer.controller.hoteladmincontrollers.MakeOperationsController;
import businesslayer.controller.hoteladmincontrollers.SeeAllPetsController;
import businesslayer.controller.ownercontrollers.ManageOperationsForPetController;
import businesslayer.controller.ownercontrollers.NewPetController;
import businesslayer.controller.ownercontrollers.SeeOwnerPetsController;
import businesslayer.model.*;
import presentationlayer.*;
import presentationlayer.hoteladminscreens.HotelAdminMainScreen;
import presentationlayer.hoteladminscreens.MakeOperationsScreen;
import presentationlayer.hoteladminscreens.SeeAllPetsScreen;
import presentationlayer.ownerscreens.ManageOperationsForPetScreen;
import presentationlayer.ownerscreens.NewPetScreen;
import presentationlayer.ownerscreens.OwnerMainScreen;
import presentationlayer.ownerscreens.SeeOwnerPetsScreen;

public class Mediator {

    private Owner loggedUser;
    private HotelAdmin admin;
    private PetCreator dogCreator;
    private PetCreator catCreator;
    private UserCreator adminCreator;
    private UserCreator ownerCreator;

    public Mediator() {

        dogCreator = new DogCreator();
        catCreator = new CatCreator();
        ownerCreator = new OwnerCreator();
        adminCreator = new AdminCreator();

        HotelAdmin admin1 = (HotelAdmin) adminCreator.createUser("admin", "123");
        Owner owner1 = (Owner) ownerCreator.createUser("owner", "123");
        owner1.addNewPet(new Cat("a",22));
        this.admin = admin1;
        this.admin.addOwner(owner1);

    }

    public void start(){
        navigateToLoginChoiceScreen();
    }

    public void setLoggedUser(Owner loggedUser){
        this.loggedUser = loggedUser;
    }

    public void navigateToLoginChoiceScreen() {
        LoginController loginController = new LoginController(admin, new LoginScreen(), new LoginChoiceScreen(),this);
        loginController.showLoginChoiceView();
    }

    public void navigateToOwnerMainScreen() {
        OwnerMainController ownerMainController = new OwnerMainController(loggedUser, new OwnerMainScreen(), this);
        ownerMainController.showView();
    }

    public void navigateToHotelAdminMainScreen() {
        HotelAdminMainController hotelAdminMainController = new HotelAdminMainController(admin, new HotelAdminMainScreen(), this);
        hotelAdminMainController.showView();
    }

    public void navigateToNewPetScreen() {
        NewPetController newPetController = new NewPetController(loggedUser, new NewPetScreen(),this);
        newPetController.showView();

    }

    public void navigateToSeeOwnerPetsScreen() {
        SeeOwnerPetsController seeOwnerPetsController = new SeeOwnerPetsController(loggedUser, new SeeOwnerPetsScreen(), this);
        seeOwnerPetsController.showView();
    }

    public void navigateToManageOperationsForPetScreen(Pet pet) {
        ManageOperationsForPetController manageOperationsForPetController = new ManageOperationsForPetController(pet, new ManageOperationsForPetScreen(), this);
        manageOperationsForPetController.showView();
    }

    public void navigateToSeeAllPetsScreen() {
        SeeAllPetsController seeAllPetsController = new SeeAllPetsController(admin, new SeeAllPetsScreen(), this);
        seeAllPetsController.showView();
    }

    public void navigateToMakeOperationsScreen(Pet pet) {
        MakeOperationsController makeOperationsController = new MakeOperationsController(pet, new MakeOperationsScreen(), this);
        makeOperationsController.showView();
    }
}
