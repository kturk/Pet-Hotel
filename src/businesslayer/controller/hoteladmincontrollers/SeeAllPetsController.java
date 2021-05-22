package businesslayer.controller.hoteladmincontrollers;

import businesslayer.Mediator;
import businesslayer.model.HotelAdmin;
import businesslayer.model.Pet;
import presentationlayer.hoteladminscreens.SeeAllPetsScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeeAllPetsController {

    private final SeeAllPetsScreen seeAllPetsView;

    private final Mediator mediator;

    public SeeAllPetsController(
            HotelAdmin hotelAdminModel, SeeAllPetsScreen seeAllPetsView, Mediator mediator)
    {
        this.seeAllPetsView = seeAllPetsView;
        this.mediator = mediator;

        seeAllPetsView.addSelectButtonListener(new SelectButtonListener());
        seeAllPetsView.addBackButtonListener(new BackButtonListener());

        seeAllPetsView.setList(hotelAdminModel.getAllPets().toArray());

    }

    public void showView() {
        seeAllPetsView.showScreen();
    }

    public void closeView() {
        seeAllPetsView.closeScreen();
    }


    class SelectButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Pet selectedPet = (Pet) seeAllPetsView.getPetList().getSelectedValue();
            closeView();
            mediator.navigateToMakeOperationsScreen(selectedPet);
        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToHotelAdminMainScreen();
        }
    }
}
