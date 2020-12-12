package by.bseu.dss.buisnesslayer.criterias.office.subcriterias;

import by.bseu.dss.buisnesslayer.criterias.office.Office;

import java.util.Objects;

public class RepairingYear extends Office {
    private String name;
    private InternetSpeed internetSpeed;
    private double repairingToSpeed;
    private final double REPAIRING_TO_REPAIRING = 1;
    private double repairingToPrice;
    private double lambdaSub;

    public RepairingYear(){}

    public RepairingYear(InternetSpeed internetSpeed){
        this.internetSpeed = internetSpeed;
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

    public double getRepairingToSpeed() {
        return Math.round(1 / internetSpeed.getSpeedToRepairing() * 100) / 100.00;
    }

    public double getREPAIRING_TO_REPAIRING() {
        return REPAIRING_TO_REPAIRING;
    }

    public double getRepairingToPrice() {
        return repairingToPrice;
    }

    public void setRepairingToPrice(double repairingToPrice) {
        this.repairingToPrice = repairingToPrice;
    }

    public void setLambdaSub(double lambdaSub) {
        this.lambdaSub = lambdaSub;
    }

    @Override
    public double getValuesSum() {
        return getRepairingToSpeed() + getREPAIRING_TO_REPAIRING() + getRepairingToPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RepairingYear that = (RepairingYear) o;
        return Double.compare(that.repairingToSpeed, repairingToSpeed) == 0 &&
                Double.compare(that.REPAIRING_TO_REPAIRING, REPAIRING_TO_REPAIRING) == 0 &&
                Double.compare(that.repairingToPrice, repairingToPrice) == 0 &&
                Double.compare(that.lambdaSub, lambdaSub) == 0 &&
                Objects.equals(internetSpeed, that.internetSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), internetSpeed, repairingToSpeed, REPAIRING_TO_REPAIRING,
                repairingToPrice, lambdaSub);
    }


}
