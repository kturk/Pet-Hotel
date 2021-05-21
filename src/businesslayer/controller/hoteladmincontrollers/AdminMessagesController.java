package businesslayer.controller.hoteladmincontrollers;

import businesslayer.Mediator;
import businesslayer.model.ChatMessage;
import businesslayer.model.HotelAdmin;
import businesslayer.model.Owner;
import presentationlayer.hoteladminscreens.AdminMessagesScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMessagesController {

    private HotelAdmin adminModel;

    private final AdminMessagesScreen adminMessagesView;

    private final Mediator mediator;

    public AdminMessagesController(HotelAdmin adminModel, AdminMessagesScreen adminMessagesView, Mediator mediator) {
        this.adminModel = adminModel;
        this.adminMessagesView = adminMessagesView;
        this.mediator = mediator;

        this.adminMessagesView.setOwners(adminModel.getOwnerList().toArray());

        adminMessagesView.addSelectButtonListener(new SelectButtonListener());
        adminMessagesView.addBackButtonListener(new BackButtonListener());
    }

    public void showView() {
        adminMessagesView.showScreen();
    }

    public void closeView() {
        adminMessagesView.closeScreen();
    }


    class SelectButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Owner selectedOwner = (Owner) adminMessagesView.getOwners().getSelectedValue();
            if (selectedOwner != null) {
                closeView();
                mediator.navigateToChatWithOwnerScreen(selectedOwner);
            }
            else
                adminMessagesView.showError("Please select a pet owner from the list");
        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToHotelAdminMainScreen();
        }
    }
}
