package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.HotelAdmin;
import businesslayer.model.Owner;
import presentationlayer.LoginChoiceScreen;
import presentationlayer.LoginScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class LoginController {

    private final HotelAdmin hotelAdmin;
    private final LoginScreen loginView;
    private final LoginChoiceScreen loginChoiceView;

    private final Mediator mediator;

    private String userType;

    public LoginController(
            HotelAdmin hotelAdmin, LoginScreen loginView, LoginChoiceScreen loginChoiceView, Mediator mediator)
    {
        this.hotelAdmin = hotelAdmin;
        this.loginView = loginView;
        this.loginChoiceView = loginChoiceView;
        this.mediator = mediator;

        loginView.addButtonListener(new LoginListener());
        loginView.addBackButtonListener(new LoginBackButtonListener());

        loginChoiceView.addOwnerButtonListener(new OwnerButtonListener());
        loginChoiceView.addAdminButtonListener(new HotelAdminButtonListener());
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

//            if(loggedInUser != null){
//                closeLoginView();
//                mediator.setLoggedUser(loggedInUser);
//                mediator.navigateToMainScreen();
//            }
//            else{
//                loginView.showError("Wrong username or password.");
//            }
        }
    }

    class HotelAdminButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeLoginChoiceView();
            setUserType("ADMIN");
            showLoginView();
        }
    }

    class OwnerButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeLoginChoiceView();
            setUserType("OWNER");
            showLoginView();
        }
    }

    class LoginBackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeLoginView();
            mediator.navigateToLoginChoiceScreen();
        }
    }
}
