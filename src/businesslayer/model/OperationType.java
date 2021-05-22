package businesslayer.model;

import javax.xml.bind.annotation.*;

@XmlType(name = "OperationType")
@XmlEnum
public enum OperationType {
    NAILS("Nails",30,20,0.5,0.5),
    BATH("Bath",30,20,0.5,0.5),
    VACCINATION("Vaccination",30,20,0.5,0.5),
    DENTAL_CARE("Dental Care",30,20,0.5,0.5),
    SHAVE("Shave",30,20,0.5,0.5);

    private final String label;
    private final double priceForDog;
    private final double priceForCat;
    private final double timeForDog;
    private final double timeForCat;

    private OperationType(String label, double priceForDog, double priceForCat, double timeForDog, double timeForCat) {
        this.label = label;
        this.priceForDog = priceForDog;
        this.priceForCat = priceForCat;
        this.timeForDog = timeForDog;
        this.timeForCat = timeForCat;
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

    public double getTimeForDog() {
        return timeForDog;
    }

    public double getTimeForCat() {
        return timeForCat;
    }
}
