package businesslayer;

import businesslayer.controller.*;
import businesslayer.controller.hoteladmincontrollers.SeeAllPetsController;
import businesslayer.controller.ownercontrollers.ManageOperationsForPetController;
import businesslayer.controller.ownercontrollers.NewPetController;
import businesslayer.controller.ownercontrollers.SeeOwnerPetsController;
import businesslayer.model.HotelAdmin;
import businesslayer.model.Owner;
import businesslayer.model.Pet;
import businesslayer.model.User;
import presentationlayer.*;
import presentationlayer.hoteladminscreens.HotelAdminMainScreen;
import presentationlayer.hoteladminscreens.SeeAllPetsScreen;
import presentationlayer.ownerscreens.ManageOperationsForPetScreen;
import presentationlayer.ownerscreens.NewPetScreen;
import presentationlayer.ownerscreens.OwnerMainScreen;
import presentationlayer.ownerscreens.SeeOwnerPetsScreen;

import java.util.ArrayList;
import java.util.List;

public class Mediator {

//    private List<User> userList;
    private Owner loggedUser;
    private HotelAdmin admin;
    private PetCreator dogCreator;
    private PetCreator catCreator;
    private UserCreator adminCreator;
    private UserCreator ownerCreator;

    public Mediator() {
//        this.userList = new ArrayList<User>();

        dogCreator = new DogCreator();
        catCreator = new CatCreator();
        ownerCreator = new OwnerCreator();
        adminCreator = new AdminCreator();

        User admin1 = adminCreator.createUser("admin", "123");
        User owner1 = ownerCreator.createUser("owner", "123");
//        this.admin = admin1;
//        this.userList.add(admin1);
//        this.userList.add(owner1);
    }

    public void start(){
        navigateToLoginScreen();
    }

    public void navigateToLoginScreen() {
//        List<User> allUsers =  ((HotelAdmin) admin).getOwnerList();
        // TODO new login screen (because we cannot have admin and users in the same list)
//        LoginController loginController = new LoginController(userList, new LoginScreen(), this);
//        loginController.showView();
    }

    public void setLoggedUser(Owner loggedUser){
        this.loggedUser = loggedUser;
    }

    public String getUserType(){
        if(loggedUser instanceof HotelAdmin)
            return "Admin";
        else if(loggedUser instanceof Owner)
            return "Owner";
        else
            return null;
    }

    public void navigateToMainScreen() {
        System.out.println(loggedUser.getUserName());
        MainController mainController = new MainController(loggedUser, new HotelAdminMainScreen(), new OwnerMainScreen(),this);

        if(loggedUser instanceof HotelAdmin)
            mainController.showAdminView();
        else if(loggedUser instanceof Owner)
            mainController.showOwnerView();

    }

    public void navigateToNewPetScreen() {
        NewPetController newPetController = new NewPetController(loggedUser, admin, new NewPetScreen(),this);
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
}
