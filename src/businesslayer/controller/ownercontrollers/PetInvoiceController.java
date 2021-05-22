package businesslayer.controller.ownercontrollers;

import businesslayer.Mediator;
import businesslayer.model.Owner;
import businesslayer.model.Pet;
import presentationlayer.ownerscreens.PetInvoiceScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetInvoiceController {

    private final Owner ownerModel;
    private final Pet petModel;
    private final PetInvoiceScreen petInvoiceView;

    private final Mediator mediator;

    public PetInvoiceController(
            Owner ownerModel, Pet petModel, PetInvoiceScreen petInvoiceView, Mediator mediator)
    {
        this.ownerModel = ownerModel;
        this.petModel = petModel;
        this.petInvoiceView = petInvoiceView;
        this.mediator = mediator;

        petInvoiceView.setPetName(petModel.getName());

        petInvoiceView.setUnfinishedOperationsList(petModel.getTodoOperations().toArray());
        petInvoiceView.addCheckoutButtonListener(new CheckoutButtonListener());
        petInvoiceView.addBackButtonListener(new BackButtonListener());

        setPrices();
    }

    public void showView() {
        petInvoiceView.showScreen();
    }

    public void closeView() {
        petInvoiceView.closeScreen();
    }

    public void setPrices() {
        double totalOperationsPrice = petModel.getCompletedOperationCost();
        double totalDailyRentPrice = petModel.getTotalRentCost();
        double totalPrice = totalOperationsPrice + totalDailyRentPrice;

        petInvoiceView.setCompletedOperationsPrice(totalOperationsPrice);
        petInvoiceView.setTotalRentPrice(totalDailyRentPrice);
        petInvoiceView.setTotalPrice(totalPrice);
    }


    class CheckoutButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ownerModel.removePet(petModel);
            closeView();
            mediator.writeXML();
            mediator.navigateToSeeOwnerPetsScreen();
        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToSeeOwnerPetsScreen();
        }
    }
}
