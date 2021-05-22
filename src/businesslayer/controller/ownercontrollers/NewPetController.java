package businesslayer.controller.ownercontrollers;

import businesslayer.Mediator;
import businesslayer.model.Cat;
import businesslayer.model.Dog;
import businesslayer.model.Owner;
import presentationlayer.ownerscreens.NewPetScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPetController {

    private final Owner ownerModel;
    private final NewPetScreen newPetView;
    private final Mediator mediator;

    public NewPetController(
            Owner ownerModel, NewPetScreen newPetView, Mediator mediator)
    {
        this.ownerModel = ownerModel;
        this.newPetView = newPetView;
        this.mediator = mediator;

        newPetView.addSubmitButtonListener(new SubmitButtonListener());
        newPetView.addBackButtonListener(new BackButtonListener());

        newPetView.setList(ownerModel.getPetList().toArray());
    }

    public void showView() {
        newPetView.showScreen();
    }

    public void closeView() {
        newPetView.closeScreen();
    }


    class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String petType = newPetView.getPetTypeDropdown().getSelectedItem().toString();
            String petName = newPetView.getPetNameField().getText();
            int petAge = Integer.parseInt(newPetView.getPetAgeField().getText());
            int numOfDays = Integer.parseInt(newPetView.getNumOfDaysField().getText());
            if(petType.equals("Cat")){
                Cat cat = new Cat(petName, petAge, numOfDays);
                ownerModel.addNewPet(cat);

            }
            else if(petType.equals("Dog")){
                Dog dog = new Dog(petName, petAge, numOfDays);
                ownerModel.addNewPet(dog);
            }
            newPetView.setList(ownerModel.getPetList().toArray());
            mediator.writeXML();
        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToOwnerMainScreen();
        }
    }
}
