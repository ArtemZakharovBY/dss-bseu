package by.bseu.dss.buisnesslayer.criterias.building.subcriterias;

import by.bseu.dss.buisnesslayer.criterias.building.Building;

import java.util.Objects;

public class OutsideAppearance extends Building {
    private String name;
    private BuildingType buildingType;
    private double bAppearanceToType;
    private FloorNumber floorNumber;
    private double bAppearanceToFloor;
    private final double B_APPEARANCE_TO_APPEARANCE = 1;
    private double lambdaSub;


    public OutsideAppearance(){}

    public OutsideAppearance(BuildingType buildingType, FloorNumber floorNumber) {
        this.buildingType = buildingType;
        this.floorNumber = floorNumber;
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

    public double getBAppearanceToType() {
        return Math.round(1/ buildingType.getBTypeToAppearance() * 100) / 100.00;
    }

    public FloorNumber getFloorNumber() {
        return floorNumber;
    }

    public double getBAppearanceToFloor() {
        return Math.round(1 / floorNumber.getBFloorToAppearance() * 100) / 100.00;
    }

    public double getB_APPEARANCE_TO_APPEARANCE() {
        return B_APPEARANCE_TO_APPEARANCE;
    }

    public void setLambdaSub(double lambdaSub) {
        this.lambdaSub = lambdaSub;
    }

    @Override
    public double getValuesSum() {
        return getBAppearanceToType() + getBAppearanceToFloor() + getBUILDING_TO_BUILDING();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OutsideAppearance that = (OutsideAppearance) o;
        return Double.compare(that.bAppearanceToType, bAppearanceToType) == 0 &&
                Double.compare(that.bAppearanceToFloor, bAppearanceToFloor) == 0 &&
                Double.compare(that.B_APPEARANCE_TO_APPEARANCE, B_APPEARANCE_TO_APPEARANCE) == 0 &&
                Objects.equals(buildingType, that.buildingType) &&
                Objects.equals(floorNumber, that.floorNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), buildingType, bAppearanceToType, floorNumber, bAppearanceToFloor,
                B_APPEARANCE_TO_APPEARANCE);
    }

    @Override
    public String toString() {
        return  "Criteria: Building" +
                "\nAppearance to type: " + bAppearanceToType +
                "\nAppearance to floor"  + bAppearanceToFloor +
                "\nAPPEARANCE_TO_APPEARANCE: " + B_APPEARANCE_TO_APPEARANCE;
    }
}
