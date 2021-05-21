package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.HotelAdmin;
import presentationlayer.hoteladminscreens.HotelAdminMainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelAdminMainController {

    private final HotelAdmin hotelAdminModel;
    private final HotelAdminMainScreen adminMainView;

    private final Mediator mediator;

    public HotelAdminMainController(HotelAdmin hotelAdminModel, HotelAdminMainScreen hotelAdminMainScreen, Mediator mediator) {
        this.hotelAdminModel = hotelAdminModel;
        this.adminMainView = hotelAdminMainScreen;
        this.mediator = mediator;

        adminMainView.renderUsername(hotelAdminModel.getUserName().toUpperCase());

        hotelAdminMainScreen.addSeeAllPetsButtonListener(new AdminSeeAllPetsListener());
        hotelAdminMainScreen.addLogoutButtonListener(new AdminLogoutListener());


    }

    public void showView() {
        adminMainView.showScreen();
    }

    public void closeView() {
        adminMainView.closeScreen();
    }


    class AdminSeeAllPetsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToSeeAllPetsScreen();
        }
    }

    class AdminLogoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToLoginChoiceScreen();
        }
    }
}