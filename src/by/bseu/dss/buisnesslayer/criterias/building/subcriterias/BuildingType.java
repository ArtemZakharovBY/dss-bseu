package by.bseu.dss.buisnesslayer.criterias.building.subcriterias;

import by.bseu.dss.buisnesslayer.criterias.building.Building;

import java.util.Objects;

public class BuildingType extends Building {
    private String name;
    private final double B_TYPE_TO_TYPE = 1;
    private double bTypeToFloor;
    private double bTypeToAppearance;
    private double lambdaSub;

    public BuildingType(){}

    public BuildingType(double bTypeToFloor, double bTypeToAppearance) {
        this.bTypeToFloor = bTypeToFloor;
        this.bTypeToAppearance = bTypeToAppearance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public double getB_TYPE_TO_TYPE() {
        return B_TYPE_TO_TYPE;
    }

    public double getBTypeToFloor() {
        return bTypeToFloor;
    }

    public void setBTypeTOFloor(double bTypeToFloor) {
        this.bTypeToFloor = bTypeToFloor;
    }

    public double getBTypeToAppearance() {
        return bTypeToAppearance;
    }

    public void setBTypeToAppearance(double bTypeToAppearance) {
        this.bTypeToAppearance = bTypeToAppearance;
    }

    public void setLambdaSub(double lambdaSub) {
        this.lambdaSub = lambdaSub;
    }

    @Override
    public double getValuesSum() {
        return getB_TYPE_TO_TYPE() + getBTypeToFloor() + getBTypeToAppearance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BuildingType that = (BuildingType) o;
        return Double.compare(that.B_TYPE_TO_TYPE, B_TYPE_TO_TYPE) == 0 &&
                Double.compare(that.bTypeToFloor, bTypeToFloor) == 0 &&
                Double.compare(that.bTypeToAppearance, bTypeToAppearance) == 0 &&
                Double.compare(that.lambdaSub, lambdaSub) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), B_TYPE_TO_TYPE, bTypeToFloor, bTypeToAppearance, lambdaSub);
    }

    @Override
    public String toString() {
        return "Criteria: Building" +
                "\nTYPE_TO_TYPE: " + B_TYPE_TO_TYPE +
                "\nType to floor: " + bTypeToFloor +
                "\nType to appearance: " + bTypeToAppearance;
    }
}
