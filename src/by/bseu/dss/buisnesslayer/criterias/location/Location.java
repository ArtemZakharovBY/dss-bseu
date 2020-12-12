package by.bseu.dss.buisnesslayer.criterias.location;

import by.bseu.dss.buisnesslayer.criterias.building.Building;
import by.bseu.dss.buisnesslayer.criterias.comfort.Comfort;

import java.util.Objects;

public class Location {
    private String name;
    private Building building;
    private double locationToBuilding;
    private final double LOCATION_TO_LOCATION = 1;
    private Comfort comfort;
    private double locationToComfort;
    private double locationToOffice;
    private double valuesSum;
    private double lambda;

    public Location(){}

    public Location(Building building, Comfort comfort){
        this.building = building;
        this.comfort = comfort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Building getBuilding() {
        return building;
    }

    public double getLocationToBuilding() {
        return Math.round(1/building.getBuildingToLocation()*100)/100.00;
    }

    public double getLOCATION_TO_LOCATION() {
        return LOCATION_TO_LOCATION;
    }

    public Comfort getComfort() {
        return comfort;
    }

    public double getLocationToComfort() {
        return Math.round(1/comfort.getComfortToLocation()*100)/100.00;
    }

    public double getLocationToOffice() {
        return locationToOffice;
    }

    public void setLocationToOffice(double locationToOffice) {
        this.locationToOffice = locationToOffice;
    }

    public double getValuesSum() {
        return getLocationToBuilding() + getLocationToOffice() + getLOCATION_TO_LOCATION() + getLocationToComfort();
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
        Location location = (Location) o;
        return Double.compare(location.locationToBuilding, locationToBuilding) == 0 &&
                Double.compare(location.LOCATION_TO_LOCATION, LOCATION_TO_LOCATION) == 0 &&
                Double.compare(location.locationToComfort, locationToComfort) == 0 &&
                Double.compare(location.locationToOffice, locationToOffice) == 0 &&
                Double.compare(location.valuesSum, valuesSum) == 0 &&
                Objects.equals(building, location.building) &&
                Objects.equals(comfort, location.comfort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, locationToBuilding, LOCATION_TO_LOCATION, comfort, locationToComfort, locationToOffice, valuesSum);
    }

    @Override
    public String toString() {
        return  "\nLocation to building: " + getLocationToBuilding() +
                "\nLocation to comfort: " + getLocationToComfort() +
                "\nLOCATION_TO_LOCATION: " + LOCATION_TO_LOCATION +
                "\nLocation to office: " + locationToOffice +
                "\nSummary: " + getValuesSum();
    }
}
