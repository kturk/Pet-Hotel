package businesslayer.controller.ownercontrollers;

import businesslayer.creator.CatCreator;
import businesslayer.creator.DogCreator;
import businesslayer.Mediator;
import businesslayer.creator.PetCreator;
import businesslayer.model.Owner;
import businesslayer.model.Pet;
import presentationlayer.ownerscreens.NewPetScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPetController {

    private final Owner ownerModel;
    private final NewPetScreen newPetView;
    private final Mediator mediator;

    private final PetCreator dogCreator;
    private final PetCreator catCreator;

    public NewPetController(
            Owner ownerModel, NewPetScreen newPetView, Mediator mediator)
    {
        this.ownerModel = ownerModel;
        this.newPetView = newPetView;
        this.mediator = mediator;

        this.dogCreator = new DogCreator();
        this.catCreator = new CatCreator();

        newPetView.addSubmitButtonListener(new RegisterNewPetButtonListener());
        newPetView.addBackButtonListener(new BackButtonListener());

        newPetView.setList(ownerModel.getPetList().toArray());
    }

    public void showView() {
        newPetView.showScreen();
    }

    public void closeView() {
        newPetView.closeScreen();
    }


    class RegisterNewPetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                if(!newPetView.checkEmptyFieldExist()){
                    String petType = newPetView.getPetTypeDropdown().getSelectedItem().toString();
                    String petName = newPetView.getPetNameField().getText();
                    int petAge = Integer.parseInt(newPetView.getPetAgeField().getText());
                    int numOfDays = Integer.parseInt(newPetView.getNumOfDaysField().getText());
                    if(petType.equals("Cat")){
                        Pet cat = catCreator.createPet(petName, petAge, numOfDays);
                        ownerModel.addNewPet(cat);

                    }
                    else if(petType.equals("Dog")){
                        Pet dog = dogCreator.createPet(petName, petAge, numOfDays);
                        ownerModel.addNewPet(dog);
                    }
                    newPetView.setList(ownerModel.getPetList().toArray());
                    mediator.writeXML();
                }
                else{
                    newPetView.showError("Please enter all the fields!");
                }
            }
            catch (NumberFormatException exception){
                newPetView.showError("Please enter a number for Pet Name and Pet Age!");
            }


        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToOwnerMainScreen();
        }
    }
}
