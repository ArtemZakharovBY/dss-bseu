package by.bseu.dss.buisnesslayer.criterias.office.subcriterias;

import by.bseu.dss.buisnesslayer.criterias.office.Office;

import java.util.Objects;

public class InternetSpeed extends Office {
    private String name;
    private final double SPEED_TO_SPEED = 1;
    private double speedToRepairing;
    private double speedToPrice;
    private double lambdaSub;

    public InternetSpeed(){}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public double getSPEED_TO_SPEED() {
        return SPEED_TO_SPEED;
    }

    public double getSpeedToRepairing() {
        return speedToRepairing;
    }

    public void setSpeedToRepairing(double speedToRepairing) {
        this.speedToRepairing = speedToRepairing;
    }

    public double getSpeedToPrice() {
        return speedToPrice;
    }

    public void setSpeedToPrice(double speedToPrice) {
        this.speedToPrice = speedToPrice;
    }

    public void setLambdaSub(double lambdaSub) {
        this.lambdaSub = lambdaSub;
    }

    @Override
    public double getValuesSum() {
        return getSPEED_TO_SPEED() + getSpeedToRepairing() + getSpeedToPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InternetSpeed that = (InternetSpeed) o;
        return Double.compare(that.SPEED_TO_SPEED, SPEED_TO_SPEED) == 0 &&
                Double.compare(that.speedToRepairing, speedToRepairing) == 0 &&
                Double.compare(that.speedToPrice, speedToPrice) == 0 &&
                Double.compare(that.lambdaSub, lambdaSub) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), SPEED_TO_SPEED, speedToRepairing, speedToPrice, lambdaSub);
    }
}
