package businesslayer.controller.hoteladmincontrollers;

import businesslayer.Mediator;
import businesslayer.command.Command;
import businesslayer.command.CommandFactory;
import businesslayer.model.OperationType;
import businesslayer.model.Pet;
import presentationlayer.hoteladminscreens.MakeOperationsScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeOperationsController {

    private final Pet petModel;
    private final MakeOperationsScreen makeOperationsView;
    private final Mediator mediator;

    private final CommandFactory commandFactory;

    public MakeOperationsController(Pet petModel, MakeOperationsScreen makeOperationsView, Mediator mediator) {
        this.petModel = petModel;
        this.makeOperationsView = makeOperationsView;
        this.mediator = mediator;
        this.commandFactory = new CommandFactory(petModel);

        makeOperationsView.addCompleteButtonListener(new CompleteButtonListener());
        makeOperationsView.addBackButtonListener(new BackButtonListener());

        updateOperationsList();

//        seeAllPetsView.setList(((HotelAdmin) hotelAdminModel).getAllPets().toArray());

    }

    private void updateOperationsList() {
        makeOperationsView.setTodoOperations(petModel.getTodoOperations().toArray());
        makeOperationsView.setCompletedOperations(petModel.getCompletedOperations().toArray());
    }


    public void showView() {
        makeOperationsView.showScreen();
    }

    public void closeView() {
        makeOperationsView.closeScreen();
    }



    class CompleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            OperationType selectedOperation = (OperationType) makeOperationsView.getTodoOperations().getSelectedValue();
            Command command = commandFactory.getCommand(selectedOperation);
            command.execute();
            updateOperationsList();
        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToHotelAdminMainScreen();
        }
    }


}
