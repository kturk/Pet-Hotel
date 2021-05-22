package businesslayer.controller.ownercontrollers;

import businesslayer.Mediator;
import businesslayer.model.Owner;
import presentationlayer.ownerscreens.OwnerMainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnerMainController {

    private final OwnerMainScreen ownerMainView;
    private final Mediator mediator;

    public OwnerMainController(
            Owner ownerModel, OwnerMainScreen ownerMainView, Mediator mediator)
    {
        this.ownerMainView = ownerMainView;
        this.mediator = mediator;

        ownerMainView.renderUsername(ownerModel.getUserName().toUpperCase());

        ownerMainView.addLogoutButtonListener(new OwnerLogoutListener());
        ownerMainView.addSeeOwnersPetsButtonListener(new OwnerSeePetsListener());
        ownerMainView.addMessagesButtonListener(new OwnerMessagesListener());
        ownerMainView.addNewPetButtonListener(new OwnerNewPetListener());
    }

    public void showView() {
        ownerMainView.showScreen();
    }

    public void closeView() {
        ownerMainView.closeScreen();
    }


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

    class OwnerMessagesListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToOwnerMessagesScreen();
        }
    }

    class OwnerLogoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToLoginChoiceScreen();
        }
    }
}
