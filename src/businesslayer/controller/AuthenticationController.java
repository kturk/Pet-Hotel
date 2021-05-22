package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.OwnerCreator;
import businesslayer.UserCreator;
import businesslayer.model.HotelAdmin;
import businesslayer.model.Owner;
import presentationlayer.LoginChoiceScreen;
import presentationlayer.LoginScreen;
import presentationlayer.RegisterScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class AuthenticationController {

    private final HotelAdmin hotelAdmin;
    private final LoginScreen loginView;
    private final LoginChoiceScreen loginChoiceView;
    private final RegisterScreen registerView;

    private final Mediator mediator;

    private String userType;

    private UserCreator ownerCreator;

    public AuthenticationController(
            HotelAdmin hotelAdmin, LoginScreen loginView, LoginChoiceScreen loginChoiceView, RegisterScreen registerView, Mediator mediator)
    {
        this.hotelAdmin = hotelAdmin;
        this.loginView = loginView;
        this.loginChoiceView = loginChoiceView;
        this.registerView = registerView;
        this.mediator = mediator;
        this.ownerCreator = new OwnerCreator();

        loginView.addButtonListener(new LoginListener());
        loginView.addBackButtonListener(new LoginBackButtonListener());

        loginChoiceView.addOwnerButtonListener(new OwnerButtonListener());
        loginChoiceView.addAdminButtonListener(new HotelAdminButtonListener());
        loginChoiceView.addRegisterButtonListener(new RegisterOwnerButtonListener());

        registerView.addRegisterButtonListener(new RegisterButtonListener());
        registerView.addBackButtonListener(new RegisterBackButtonListener());
    }

    public void showLoginView() {
        loginView.showScreen();
    }

    public void closeLoginView() {
        loginView.closeScreen();
    }

    public void showLoginChoiceView() {
        loginChoiceView.showScreen();
    }

    public void closeLoginChoiceView() {
        loginChoiceView.closeScreen();
    }

    public void showRegisterView() {
        registerView.showScreen();
    }

    public void closeRegisterView() {
        registerView.closeScreen();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    private Owner checkCredentialsForOwner(String username, String password) {
        List<Owner> ownerList = hotelAdmin.getOwnerList();
        for(Owner userModel : ownerList){
            if(userModel.getUserName().equals(username) && userModel.getPassword().equals(password)){
                return userModel;
            }
        }
        return null;
    }

    private HotelAdmin checkCredentialsForHotelAdmin(String username, String password) {
        if(hotelAdmin.getUserName().equals(username) && hotelAdmin.getPassword().equals(password)){
            return hotelAdmin;
        }
        return null;
    }

    private boolean checkPasswordMatch(String password, String passwordConfirmation) {
        if(password.equals(passwordConfirmation)){
            return true;
        }
        return false;
    }

    public boolean checkUsernameExist(String username) {

        if(hotelAdmin.getUserName().equals(username)){
            return true;
        }

        for(Owner owner : hotelAdmin.getOwnerList()){
            if(owner.getUserName().equals(username)){
                return true;
            }
        }
        return false;
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Map<String, String> credentials = loginView.getCredentials();

            if(getUserType().equals("OWNER")) {
                Owner loggedInUser = checkCredentialsForOwner(credentials.get("username"), credentials.get("password"));

                if(loggedInUser != null){
                    mediator.setLoggedUser(loggedInUser);
                    closeLoginView();
                    mediator.navigateToOwnerMainScreen();
                }
                else{
                    loginView.showError("Wrong username or password.");
                }
            }

            else if(getUserType().equals("ADMIN")) {
                HotelAdmin loggedInAdmin = checkCredentialsForHotelAdmin(credentials.get("username"), credentials.get("password"));

                if(loggedInAdmin != null){
                    mediator.setLoggedUser(null);
                    closeLoginView();
                    mediator.navigateToHotelAdminMainScreen();
                }
                else{
                    loginView.showError("Wrong username or password.");
                }
            }
        }
    }

    class HotelAdminButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeLoginChoiceView();
            setUserType("ADMIN");
            loginView.setScreenTitle("Hotel Admin");
            showLoginView();
        }
    }

    class OwnerButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeLoginChoiceView();
            setUserType("OWNER");
            loginView.setScreenTitle("Owner");
            showLoginView();
        }
    }

    class RegisterOwnerButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeLoginChoiceView();
            showRegisterView();
        }
    }

    class LoginBackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeLoginView();
            mediator.navigateToLoginChoiceScreen();
        }
    }

    class RegisterBackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeRegisterView();
            mediator.navigateToLoginChoiceScreen();
        }
    }

    class RegisterButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = registerView.getUsernameField().getText();
            String password = new String(registerView.getPasswordField().getPassword());
            String passwordConfirmation = new String(registerView.getPasswordConfirmationField().getPassword());

            boolean validation = checkPasswordMatch(password, passwordConfirmation);

            if(registerView.checkEmptyFieldExist()){
                registerView.showWarning("Fill all the fields!");
            }
            else{
                if(validation){
                    if(!checkUsernameExist(username)){
                        Owner newOwner = (Owner) ownerCreator.createUser(username, password);
                        hotelAdmin.addOwner(newOwner);
                        registerView.showWarning("Register successful!");
                        closeRegisterView();
                        mediator.navigateToLoginChoiceScreen();
                        mediator.writeXML();
                    }
                    else{
                        registerView.showWarning("Username already exist!");
                    }
                }
                else{
                    registerView.showWarning("Passwords do not match!");
                }
            }

        }
    }
}
