package businesslayer.controller.ownercontrollers;

import businesslayer.Mediator;
import businesslayer.model.OperationType;
import businesslayer.model.Pet;
import presentationlayer.ownerscreens.ManageOperationsForPetScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        updateOperationTypeList();
        setTodoOperationsList();
        setDoneOperationsList();

    }

    // Deleting selected operation types from operations dropdown menu
    private void updateOperationTypeList(){

        manageOperationsForPetView.deleteAllOperationTypes();

        List<OperationType> modifiedOperationTypes = new ArrayList<OperationType>();
        modifiedOperationTypes.addAll(Arrays.asList(OperationType.values()));

        List<OperationType> selectedOperationTypes = new ArrayList<OperationType>();

        selectedOperationTypes.addAll(petModel.getTodoOperations());
        selectedOperationTypes.addAll(petModel.getCompletedOperations());

        modifiedOperationTypes.removeAll(selectedOperationTypes);

        setCompletedPrice();
        setEstimatedPrice();

        this.manageOperationsForPetView.setOperationTypeDropDownList(modifiedOperationTypes);

    }

    private void setTodoOperationsList() {
        manageOperationsForPetView.setTodoList(petModel.getTodoOperations().toArray());
    }

    private void setDoneOperationsList() {
        manageOperationsForPetView.setCompletedList(petModel.getCompletedOperations().toArray());
    }

    private void setPrices() {

    }

    private void setCompletedPrice() {
        manageOperationsForPetView.setCompletedPrice(petModel.getCompletedCost());
    }

    private void setEstimatedPrice() {
        manageOperationsForPetView.setEstimatedPrice(petModel.getEstimatedCost());
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
            updateOperationTypeList();
            setEstimatedPrice();
            mediator.writeXML();
        }
    }

    class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            OperationType selectedOperation = (OperationType) manageOperationsForPetView.getTodoList().getSelectedValue();
            System.out.println(selectedOperation);
            petModel.removeTodoOperation(selectedOperation);
            setTodoOperationsList();
            updateOperationTypeList();
            setEstimatedPrice();
            mediator.writeXML();
        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToSeeOwnerPetsScreen();
        }
    }


}
