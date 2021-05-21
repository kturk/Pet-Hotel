package businesslayer.model;

import java.util.ArrayList;
import java.util.List;

public class HotelAdmin extends User{

    private List<Owner> ownerList;

    public HotelAdmin(String userName, String password) {
        super(userName, password);
        this.ownerList = new ArrayList<Owner>();
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void addOwner(Owner owner) {
        ownerList.add(owner);
    }

    public List<Pet> getAllPets() {
        List<Pet> allPets = new ArrayList<Pet>();
        for (Owner o : ownerList) {
            allPets.addAll(o.getPetList());
        }
        return allPets;
    }
}
