package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Owner;
import presentationlayer.ownerscreens.OwnerMainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnerMainController {

    private final Owner ownerModel;
    private final OwnerMainScreen ownerMainView;

    private final Mediator mediator;

    public OwnerMainController(Owner ownerModel, OwnerMainScreen ownerMainView, Mediator mediator) {
        this.ownerModel = ownerModel;
        this.ownerMainView = ownerMainView;
        this.mediator = mediator;

        ownerMainView.renderUsername(ownerModel.getUserName().toUpperCase());

        ownerMainView.addLogoutButtonListener(new OwnerLogoutListener());
        ownerMainView.addSeeOwnersPetsButton(new OwnerSeePetsListener());
        ownerMainView.addNewPetButtonListener(new OwnerNewPetListener());

    }

    public void showView() {
        ownerMainView.showScreen();
    }

    public void closeView() {
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
            closeView();
            mediator.navigateToNewPetScreen();
        }
    }

    class OwnerSeePetsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToSeeOwnerPetsScreen();
        }
    }

    class OwnerLogoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToLoginChoiceScreen();
        }
    }

}
