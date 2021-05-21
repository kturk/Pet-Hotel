package businesslayer.controller.ownercontrollers;

import businesslayer.Mediator;
import businesslayer.model.OperationType;
import businesslayer.model.Pet;
import presentationlayer.ownerscreens.ManageOperationsForPetScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ManageOperationsForPetController {

    private final Pet petModel;

    private final ManageOperationsForPetScreen manageOperationsForPetView;

    private final Mediator mediator;

    public ManageOperationsForPetController(Pet petModel, ManageOperationsForPetScreen manageOperationsForPetView, Mediator mediator) {
        this.petModel = petModel;
        this.manageOperationsForPetView = manageOperationsForPetView;
        this.mediator = mediator;

        this.manageOperationsForPetView.addAddOperationButtonListener(new AddButtonListener());
        this.manageOperationsForPetView.addDeleteOperationButtonListener(new DeleteButtonListener());
        this.manageOperationsForPetView.addBackButtonListener(new BackButtonListener());

        this.manageOperationsForPetView.setPetName(petModel.getName());
        this.manageOperationsForPetView.setOperationTypeDropDownList(Arrays.asList(OperationType.values()));

        setTodoOperationsList();
        setDoneOperationsList();

        //manageOperationsForPetView.setList(petModel.getPetList().toArray());

    }

    private void setTodoOperationsList() {
        manageOperationsForPetView.setTodoList(petModel.getTodoOperations().toArray());
    }

    private void setDoneOperationsList() {
        manageOperationsForPetView.setCompletedList(petModel.getCompletedOperations().toArray());
    }

    public void showView() {
        manageOperationsForPetView.showScreen();
    }

    public void closeView() {
        manageOperationsForPetView.closeScreen();
    }



    class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            OperationType selectedOperation = (OperationType) manageOperationsForPetView.getPetTypeDropdown().getSelectedItem();
            System.out.println(selectedOperation.getLabel());
            petModel.addTodoOperation(selectedOperation);
            setTodoOperationsList();
        }
    }

    class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            OperationType selectedOperation = (OperationType) manageOperationsForPetView.getTodoList().getSelectedValue();
            System.out.println(selectedOperation);
            petModel.removeTodoOperation(selectedOperation);
            setTodoOperationsList();
        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToOwnerMainScreen();
        }
    }


}
