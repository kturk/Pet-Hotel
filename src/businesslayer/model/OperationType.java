package businesslayer.model;

import javax.xml.bind.annotation.*;

@XmlType(name = "OperationType")
@XmlEnum
public enum OperationType {
    NAILS("Nails",20,30, 2, 3),
    BATH("Bath",40,60, 4, 5),
    VACCINATION("Vaccination",70,50, 15, 10),
    DENTAL_CARE("Dental Care",30,20, 8, 6),
    SHAVE("Shave",70,60, 10, 8);

    private final String label;
    private final double priceForDog;
    private final double priceForCat;
    private final double expenseForDog;
    private final double expenseForCat;

    private OperationType(String label, double priceForDog, double priceForCat, double expenseForDog, double expenseForCat) {
        this.label = label;
        this.priceForDog = priceForDog;
        this.priceForCat = priceForCat;
        this.expenseForDog = expenseForDog;
        this.expenseForCat = expenseForCat;
    }

    public String getLabel() {
        return label;
    }

    public double getPriceForDog() {
        return priceForDog;
    }

    public double getPriceForCat() {
        return priceForCat;
    }

    public double getExpenseForDog() {
        return expenseForDog;
    }

    public double getExpenseForCat() {
        return expenseForCat;
    }
}
