package businesslayer.controller;

import businesslayer.Mediator;
import businesslayer.model.Cat;
import businesslayer.model.Dog;
import businesslayer.model.User;
import presentationlayer.NewPetScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPetController {

    private final User ownerModel;
    private final User adminModel;

    private final NewPetScreen newPetView;

    private final Mediator mediator;

    public NewPetController(User ownerModel, User adminModel, NewPetScreen newPetView, Mediator mediator) {
        this.ownerModel = ownerModel;
        this.adminModel = adminModel;
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
            System.out.println(ownerModel.getPetList());

            String petType = newPetView.getPetTypeDropdown().getSelectedItem().toString();
            System.out.println(petType);
            String petName = newPetView.getPetNameField().getText();
            int petAge = Integer.parseInt(newPetView.getPetAgeField().getText());
            if(petType == "Cat"){
                Cat cat = new Cat(petName, petAge);
                ownerModel.addNewPet(cat);
                adminModel.addNewPet(cat);

            }
            else if(petType == "Dog"){
                Dog dog = new Dog(petName, petAge);
                ownerModel.addNewPet(dog);
                adminModel.addNewPet(dog);
            }
            newPetView.setList(ownerModel.getPetList().toArray());

        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToMainScreen();
        }
    }


}
