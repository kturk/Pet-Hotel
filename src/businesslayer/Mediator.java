package businesslayer;

import businesslayer.controller.LoginController;
import businesslayer.controller.MainController;
import businesslayer.model.Admin;
import businesslayer.model.Owner;
import businesslayer.model.User;
import presentationlayer.AdminMainScreen;
import presentationlayer.LoginScreen;
import presentationlayer.OwnerMainScreen;

import java.util.ArrayList;
import java.util.List;

public class Mediator {

    private List<User> userList;
    private User loggedUser;

    public Mediator() {
        this.userList = new ArrayList<User>();

        User admin1 = new Admin("admin", "123");
        User owner1 = new Owner("owner", "123");

        this.userList.add(admin1);
        this.userList.add(owner1);

    }

    public void start(){
        navigateToLoginScreen();
    }

    public void navigateToLoginScreen() {
        LoginController loginController = new LoginController(userList, new LoginScreen(), this);
        loginController.showView();
    }

    public void setLoggedUser(User loggedUser){
        this.loggedUser = loggedUser;
    }

    public String getUserType(){
        if(loggedUser instanceof Admin)
            return "Admin";
        else if(loggedUser instanceof Owner)
            return "Owner";
        else
            return null;
    }

    public void navigateToMainScreen() {
        System.out.println(loggedUser.getUserName());
        MainController mainController = new MainController(loggedUser, new AdminMainScreen(), new OwnerMainScreen(),this);

        if(loggedUser instanceof Admin)
            mainController.showAdminView();
        else if(loggedUser instanceof Owner)
            mainController.showOwnerView();

    }

}
