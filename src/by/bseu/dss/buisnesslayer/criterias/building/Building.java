package by.bseu.dss.buisnesslayer.criterias.building;

import java.util.Objects;

public class Building {
    private String name;
    private final double BUILDING_TO_BUILDING = 1;
    private double buildingToComfort;
    private double buildingToLocation;
    private double buildingToOffice;
    private double valuesSum;
    private double lambda;

    public Building(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBUILDING_TO_BUILDING() {
        return BUILDING_TO_BUILDING;
    }

    public double getBuildingToComfort() {
        return buildingToComfort;
    }

    public void setBuildingToComfort(double buildingToComfort) {
        this.buildingToComfort = buildingToComfort;
    }

    public double getBuildingToLocation() {
        return buildingToLocation;
    }

    public void setBuildingToLocation(double buildingToLocation) {
        this.buildingToLocation = buildingToLocation;
    }

    public double getBuildingToOffice() {
        return buildingToOffice;
    }

    public void setBuildingToOffice(double buildingToOffice) {
        this.buildingToOffice = buildingToOffice;
    }

    public double getValuesSum() {
        return getBuildingToComfort() + getBuildingToOffice() + getBuildingToLocation() + getBUILDING_TO_BUILDING();
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda(double lambda) {
        this.lambda = lambda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return Double.compare(building.BUILDING_TO_BUILDING, BUILDING_TO_BUILDING) == 0 &&
                Double.compare(building.buildingToComfort, buildingToComfort) == 0 &&
                Double.compare(building.buildingToLocation, buildingToLocation) == 0 &&
                Double.compare(building.buildingToOffice, buildingToOffice) == 0 &&
                Double.compare(building.valuesSum, valuesSum) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(BUILDING_TO_BUILDING, buildingToComfort, buildingToLocation, buildingToOffice, valuesSum);
    }

    @Override
    public String toString() {
        return  "BUILDING_TO_BUILDING: " + BUILDING_TO_BUILDING +
                "\nBuilding to comfort: " + buildingToComfort +
                "\nBuilding to location: " + buildingToLocation +
                "\nBuilding to office: " + buildingToOffice +
                "\nSummary: " + getValuesSum();
    }
}