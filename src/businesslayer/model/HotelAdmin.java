package businesslayer.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "HotelAdmin")
@XmlAccessorType(XmlAccessType.FIELD)
public class HotelAdmin extends User{

    @XmlElementWrapper(name = "Owners")
    @XmlElement(name = "Owner")
    private List<Owner> ownerList;

    public HotelAdmin() {
        super();
        this.ownerList = new ArrayList<Owner>();
    }

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
