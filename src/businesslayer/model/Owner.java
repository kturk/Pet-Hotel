package businesslayer.model;

import java.util.ArrayList;
import java.util.List;

public class Owner extends User{

    private List<Pet> petList;

    public Owner(String userName, String password) {
        super(userName, password);
        petList = new ArrayList<Pet>();
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public void addNewPet(Pet pet){
        this.petList.add(pet);
    }

    public void removePet(Pet pet){
        this.petList.remove(pet);
    }
}
