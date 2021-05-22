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
    private double hotelExpenses;

    public HotelAdmin() {
        super();
        this.ownerList = new ArrayList<Owner>();
        this.hotelExpenses = 0;
    }

    public HotelAdmin(String userName, String password) {
        super(userName, password);
        this.ownerList = new ArrayList<Owner>();
        this.hotelExpenses = 0;
    }

    public double getHotelExpenses() {
        return hotelExpenses;
    }

    public void setHotelExpenses(double hotelExpenses) {
        this.hotelExpenses = hotelExpenses;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void addOwner(Owner owner) {
        ownerList.add(owner);
    }

    public Double getTotalDailyRentingIncome() {
        Double totalDailyRentingIncome = 0.0;
        for(Owner owner : ownerList) {
            totalDailyRentingIncome += owner.getTotalDailyRentingPrice();
        }
        return totalDailyRentingIncome;
    }

    public Double getTotalOperationsIncome() {
        Double totalOperationsIncome = 0.0;
        for(Owner owner : ownerList){
            totalOperationsIncome += owner.getTotalOperationsPrice();
        }
        return totalOperationsIncome;
    }

    public List<Pet> getAllPets() {
        List<Pet> allPets = new ArrayList<Pet>();
        for (Owner o : ownerList) {
            allPets.addAll(o.getPetList());
        }
        return allPets;
    }
}
