package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Admin;
import businesslayer.model.User;
import presentationlayer.AdminMainScreen;
import presentationlayer.OwnerMainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {

    private final User userModel;
    private final AdminMainScreen adminMainView;
    private final OwnerMainScreen ownerMainView;

    private final Mediator mediator;

    public MainController(User userModel, AdminMainScreen adminMainScreen, OwnerMainScreen ownerMainView, Mediator mediator) {
        this.userModel = userModel;
        this.adminMainView = adminMainScreen;
        this.ownerMainView = ownerMainView;
        this.mediator = mediator;

        adminMainView.renderUsername(userModel.getUserName().toUpperCase());
        ownerMainView.renderUsername(userModel.getUserName().toUpperCase());

        adminMainScreen.addLogoutButtonListener(new AdminLogoutListener());

        ownerMainView.addLogoutButtonListener(new OwnerLogoutListener());
        ownerMainView.addNewPetButtonListener(new OwnerNewPetListener());

    }

    public void showAdminView() {
        adminMainView.showScreen();
    }

    public void closeAdminView() {
        adminMainView.closeScreen();
    }

    public void showOwnerView() {
        ownerMainView.showScreen();
    }

    public void closeOwnerView() {
        ownerMainView.closeScreen();
    }

//    class LogoutListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//
//            String userType = mediator.getUserType();
//
//            if(userType == "Admin"){
//                closeAdminView();
//            }
//            else if(userType == "Owner"){
//                closeOwnerView();
//            }
//
//            mediator.navigateToLoginScreen();
//        }
//    }

    class OwnerNewPetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeOwnerView();
            mediator.navigateToNewPetScreen();
        }
    }

    class OwnerLogoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeOwnerView();
            mediator.navigateToLoginScreen();
        }
    }




    class AdminLogoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeAdminView();
            mediator.navigateToLoginScreen();
        }
    }
}
