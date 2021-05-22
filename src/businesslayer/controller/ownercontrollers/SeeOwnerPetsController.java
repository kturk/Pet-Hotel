package businesslayer.controller.ownercontrollers;

import businesslayer.Mediator;
import businesslayer.model.Owner;
import businesslayer.model.Pet;
import presentationlayer.ownerscreens.SeeOwnerPetsScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeeOwnerPetsController {

    private final SeeOwnerPetsScreen seeOwnerPetsView;

    private final Mediator mediator;

    public SeeOwnerPetsController(
            Owner ownerModel, SeeOwnerPetsScreen seeOwnerPetsView, Mediator mediator)
    {
        this.seeOwnerPetsView = seeOwnerPetsView;
        this.mediator = mediator;

        seeOwnerPetsView.addSelectButtonListener(new SelectButtonListener());
        seeOwnerPetsView.addBackButtonListener(new BackButtonListener());
        seeOwnerPetsView.addCheckoutButtonListener(new CheckoutButtonListener());

        seeOwnerPetsView.setList(ownerModel.getPetList().toArray());
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

    class CheckoutButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Pet selectedPet = (Pet) seeOwnerPetsView.getPetList().getSelectedValue();
            closeView();
            mediator.navigateToPetInvoiceScreen(selectedPet);
        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToOwnerMainScreen();
        }
    }
}
