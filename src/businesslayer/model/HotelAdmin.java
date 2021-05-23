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
    private double extraExpenses;

    public HotelAdmin() {
        super();
        this.ownerList = new ArrayList<Owner>();
        this.extraExpenses = 0;
    }

    public HotelAdmin(String userName, String password) {
        super(userName, password);
        this.ownerList = new ArrayList<Owner>();
        this.extraExpenses = 0;
    }

    public double getExtraExpenses() {
        return extraExpenses;
    }

    public void addExtraExpense(double expense) {
        extraExpenses += expense;
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

    public Double getTotalDailyRentingExpense() {
        Double totalDailyRentingExpense = 0.0;
        for(Owner owner : ownerList) {
            totalDailyRentingExpense += owner.getTotalDailyRentingExpense();
        }
        return totalDailyRentingExpense;
    }

    public Double getTotalOperationsExpense() {
        Double totalOperationsExpense = 0.0;
        for(Owner owner : ownerList) {
            totalOperationsExpense += owner.getTotalOperationsExpense();
        }
        return totalOperationsExpense;
    }

    public List<Pet> getAllPets() {
        List<Pet> allPets = new ArrayList<Pet>();
        for (Owner o : ownerList) {
            allPets.addAll(o.getPetList());
        }
        return allPets;
    }

    public boolean containsOwner(Owner owner) {
        return ownerList.contains(owner);
    }
}
