package by.bseu.dss.buisnesslayer.criterias.office.subcriterias;

import by.bseu.dss.buisnesslayer.criterias.office.Office;

import java.util.Objects;

public class SharingPrice extends Office {
    private String name;
    private InternetSpeed internetSpeed;
    private double priceToSpeed;
    private RepairingYear repairingYear;
    private double priceToRepairing;
    private final double PRICE_TO_PRICE = 1;
    private double lambdaSub;

    public SharingPrice(){}

    public SharingPrice(InternetSpeed internetSpeed, RepairingYear repairingYear){
        this.internetSpeed = internetSpeed;
        this.repairingYear = repairingYear;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public InternetSpeed getInternetSpeed() {
        return internetSpeed;
    }

    public double getPriceToSpeed() {
        return Math.round(1 / internetSpeed.getSpeedToPrice() * 100) / 100.00;
    }

    public RepairingYear getRepairingYear() {
        return repairingYear;
    }

    public double getPriceToRepairing() {
        return Math.round(1 / repairingYear.getRepairingToPrice() * 100) / 100.00;
    }

    public double getPRICE_TO_PRICE() {
        return PRICE_TO_PRICE;
    }

    public void setLambdaSub(double lambdaSub) {
        this.lambdaSub = lambdaSub;
    }

    @Override
    public double getValuesSum() {
        return getPriceToSpeed() + getPriceToRepairing() + getPRICE_TO_PRICE();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SharingPrice that = (SharingPrice) o;
        return Double.compare(that.priceToSpeed, priceToSpeed) == 0 &&
                Double.compare(that.priceToRepairing, priceToRepairing) == 0 &&
                Double.compare(that.PRICE_TO_PRICE, PRICE_TO_PRICE) == 0 &&
                Double.compare(that.lambdaSub, lambdaSub) == 0 &&
                Objects.equals(internetSpeed, that.internetSpeed) &&
                Objects.equals(repairingYear, that.repairingYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), internetSpeed, priceToSpeed, repairingYear, priceToRepairing,
                PRICE_TO_PRICE, lambdaSub);
    }
}
