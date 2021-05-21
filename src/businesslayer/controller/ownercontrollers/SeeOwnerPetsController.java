package businesslayer.controller.ownercontrollers;

import businesslayer.Mediator;
import businesslayer.model.Pet;
import businesslayer.model.User;
import presentationlayer.ownerscreens.SeeOwnerPetsScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeeOwnerPetsController {

    private final User ownerModel;
    private final SeeOwnerPetsScreen seeOwnerPetsView;

    private final Mediator mediator;

    public SeeOwnerPetsController(User ownerModel, SeeOwnerPetsScreen seeOwnerPetsView, Mediator mediator) {
        this.ownerModel = ownerModel;
        this.seeOwnerPetsView = seeOwnerPetsView;
        this.mediator = mediator;

        seeOwnerPetsView.addSelectButtonListener(new SelectButtonListener());
        seeOwnerPetsView.addBackButtonListener(new BackButtonListener());

        seeOwnerPetsView.setList(this.ownerModel.getPetList().toArray());

    }

    public void showView() {
        seeOwnerPetsView.showScreen();
    }

    public void closeView() {
        seeOwnerPetsView.closeScreen();
    }



    class SelectButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Pet selectedPet = (Pet) seeOwnerPetsView.getPetList().getSelectedValue();
            closeView();
            mediator.navigateToManageOperationsForPetScreen(selectedPet);
        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToMainScreen();
        }
    }


}
