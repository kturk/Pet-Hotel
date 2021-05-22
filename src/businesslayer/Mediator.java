package businesslayer;

import businesslayer.controller.*;
import businesslayer.controller.hoteladmincontrollers.*;
import businesslayer.controller.ownercontrollers.*;
import businesslayer.model.*;
import dataaccesslayer.DataHandler;
import dataaccesslayer.IDataHandler;
import presentationlayer.*;
import presentationlayer.hoteladminscreens.*;
import presentationlayer.ownerscreens.*;

public class Mediator {

    private Owner loggedUser;
    private HotelAdmin admin;

    private final IDataHandler dataHandler;

    public Mediator() {
        this.dataHandler = new DataHandler("testXML.xml");
        this.readXML();
    }

    public void readXML() {
        this.admin = dataHandler.readXML();
    }

    public void writeXML() {
        dataHandler.writeXML(this.admin);
    }

    public void start(){
        navigateToLoginChoiceScreen();
    }

    public void setLoggedUser(Owner loggedUser){
        this.loggedUser = loggedUser;
    }

    public void navigateToLoginChoiceScreen() {
        AuthenticationController authenticationController = new AuthenticationController(
                admin, new LoginScreen(), new LoginChoiceScreen(), new RegisterScreen(), this);

        authenticationController.showLoginChoiceView();
    }

    public void navigateToOwnerMainScreen() {
        OwnerMainController ownerMainController = new OwnerMainController(
                loggedUser, new OwnerMainScreen(), this);

        ownerMainController.showView();
    }

    public void navigateToHotelAdminMainScreen() {
        HotelAdminMainController hotelAdminMainController = new HotelAdminMainController(
                admin, new HotelAdminMainScreen(), this);

        hotelAdminMainController.showView();
    }

    public void navigateToNewPetScreen() {
        NewPetController newPetController = new NewPetController(
                loggedUser, new NewPetScreen(),this);

        newPetController.showView();

    }

    public void navigateToSeeOwnerPetsScreen() {
        SeeOwnerPetsController seeOwnerPetsController = new SeeOwnerPetsController(
                loggedUser, new SeeOwnerPetsScreen(), this);

        seeOwnerPetsController.showView();
    }

    public void navigateToManageOperationsForPetScreen(Pet pet) {
        ManageOperationsForPetController manageOperationsForPetController = new ManageOperationsForPetController(
                pet, new ManageOperationsForPetScreen(), this);

        manageOperationsForPetController.showView();
    }

    public void navigateToSeeAllPetsScreen() {
        SeeAllPetsController seeAllPetsController = new SeeAllPetsController(
                admin, new SeeAllPetsScreen(), this);

        seeAllPetsController.showView();
    }

    public void navigateToMakeOperationsScreen(Pet pet) {
        MakeOperationsController makeOperationsController = new MakeOperationsController(
                pet, new MakeOperationsScreen(), this);

        makeOperationsController.showView();
    }

    public void navigateToOwnerMessagesScreen() {
        OwnerMessagesController ownerMessagesController = new OwnerMessagesController(
                loggedUser, new OwnerMessagesScreen(), this);

        ownerMessagesController.showView();
    }

    public void navigateToAdminMessagesScreen() {
        AdminMessagesController adminMessagesController = new AdminMessagesController(
                admin, new AdminMessagesScreen(), this);

        adminMessagesController.showView();
    }

    public void navigateToChatWithOwnerScreen(Owner owner) {
        ChatWithOwnerController chatWithOwnerController = new ChatWithOwnerController(
                owner, new ChatWithOwnerScreen(), this);

        chatWithOwnerController.showView();
    }

    public void navigateToStatisticsScreen() {
        StatisticsController statisticsController = new StatisticsController(
                admin, new StatisticsScreen(), this);

        statisticsController.showView();
    }

    public void navigateToPetInvoiceScreen(Pet pet) {
        PetInvoiceController petInvoiceController = new PetInvoiceController(
                loggedUser, pet, new PetInvoiceScreen(), this);

        petInvoiceController.showView();
    }
}
