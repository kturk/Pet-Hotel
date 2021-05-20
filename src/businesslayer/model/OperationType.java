package businesslayer.model;

public enum OperationType {
    NAILS("Nails",30,20,0.5,0.5),
    BATH("Bath",30,20,0.5,0.5),
    VACCINATIONS("Vaccinations",30,20,0.5,0.5),
    DENTAL_CARE("Dental Care",30,20,0.5,0.5),
    SHAVE("Shave",30,20,0.5,0.5);

    private final String label;
    private final int priceForDog;
    private final int priceForCat;
    private final double timeForDog;
    private final double timeForCat;

    OperationType(String label, int priceForDog, int priceForCat, double timeForDog, double timeForCat) {
        this.label = label;
        this.priceForDog = priceForDog;
        this.priceForCat = priceForCat;
        this.timeForDog = timeForDog;
        this.timeForCat = timeForCat;
    }

    public String getLabel() {
        return label;
    }

    public int getPriceForDog() {
        return priceForDog;
    }

    public int getPriceForCat() {
        return priceForCat;
    }

    public double getTimeForDog() {
        return timeForDog;
    }

    public double getTimeForCat() {
        return timeForCat;
    }
}
