package businesslayer.controller.hoteladmincontrollers;

import businesslayer.Mediator;
import businesslayer.model.HotelAdmin;
import presentationlayer.hoteladminscreens.HotelAdminMainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelAdminMainController {

    private final HotelAdminMainScreen adminMainView;
    private final Mediator mediator;

    public HotelAdminMainController(
            HotelAdmin hotelAdminModel, HotelAdminMainScreen hotelAdminMainScreen, Mediator mediator)
    {
        this.adminMainView = hotelAdminMainScreen;
        this.mediator = mediator;

        adminMainView.renderUsername(hotelAdminModel.getUserName().toUpperCase());

        hotelAdminMainScreen.addSeeAllPetsButtonListener(new AdminSeeAllPetsButtonListener());
        hotelAdminMainScreen.addStatisticsButtonListener(new StatisticsButtonListener());
        hotelAdminMainScreen.addMessagesButtonListener(new AdminMessagesButtonListener());
        hotelAdminMainScreen.addLogoutButtonListener(new AdminLogoutButtonListener());
    }

    public void showView() {
        adminMainView.showScreen();
    }

    public void closeView() {
        adminMainView.closeScreen();
    }


    class AdminSeeAllPetsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToSeeAllPetsScreen();
        }
    }

    class StatisticsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToStatisticsScreen();
        }
    }

    class AdminMessagesButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToAdminMessagesScreen();
        }
    }

    class AdminLogoutButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToLoginChoiceScreen();
        }
    }
}
