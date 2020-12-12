package by.bseu.dss.buisnesslayer.criterias.building.subcriterias;

import by.bseu.dss.buisnesslayer.criterias.building.Building;

import java.util.Objects;

public class FloorNumber extends Building {
    private String name;
    private BuildingType buildingType;
    private double bFloorToType;
    private final double B_FLOOR_TO_FLOOR = 1;
    private double bFloorToAppearance;
    private double lambdaSub;

    public FloorNumber(){}

    public FloorNumber(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public FloorNumber(double buildingToComfort, double buildingToLocation, double buildingToOffice,
                       double bFloorToAppearance){
        this.bFloorToAppearance = bFloorToAppearance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public double getBFloorToType() {
        return Math.round(1 / buildingType.getBTypeToFloor() * 100) / 100.00;
    }

    public double getB_FLOOR_TO_FLOOR() {
        return B_FLOOR_TO_FLOOR;
    }

    public double getBFloorToAppearance() {
        return bFloorToAppearance;
    }

    public void setBFloorToAppearance(double bFloorToAppearance) {
        this.bFloorToAppearance = bFloorToAppearance;
    }

    public void setLambdaSub(double lambdaSub) {
        this.lambdaSub = lambdaSub;
    }

    @Override
    public double getValuesSum() {
        return getBFloorToType() + getB_FLOOR_TO_FLOOR() + getBFloorToAppearance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FloorNumber that = (FloorNumber) o;
        return Double.compare(that.bFloorToType, bFloorToType) == 0 &&
                Double.compare(that.B_FLOOR_TO_FLOOR, B_FLOOR_TO_FLOOR) == 0 &&
                Double.compare(that.bFloorToAppearance, bFloorToAppearance) == 0 &&
                Objects.equals(buildingType, that.buildingType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), buildingType, bFloorToType, B_FLOOR_TO_FLOOR, bFloorToAppearance);
    }

    @Override
    public String toString() {
        return  "Criteria: Building" +
                "\nFloor to type: " + bFloorToType +
                "\nFLOOR_TO_FLOOR: " + B_FLOOR_TO_FLOOR +
                "\nFloor to appearance: " + bFloorToAppearance;
    }
}
