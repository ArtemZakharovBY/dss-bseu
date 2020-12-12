package by.bseu.dss.buisnesslayer.criterias.comfort;

import by.bseu.dss.buisnesslayer.criterias.building.Building;

import java.util.Objects;

public class Comfort {
    private String name;
    private final double COMFORT_TO_COMFORT = 1;
    private Building building;
    private double comfortToBuilding;
    private double comfortToLocation;
    private double comfortToOffice;
    private double valuesSum;
    private double lambda;

    public Comfort(){}

    public Comfort(Building building){
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCOMFORT_TO_COMFORT() {
        return COMFORT_TO_COMFORT;
    }

    public Building getBuilding() {
        return building;
    }

    public double getComfortToLocation() {
        return comfortToLocation;
    }

    public void setComfortToLocation(double comfortToLocation) {
        this.comfortToLocation = comfortToLocation;
    }

    public double getComfortToOffice() {
        return comfortToOffice;
    }

    public void setComfortToOffice(double comfortToOffice) {
        this.comfortToOffice = comfortToOffice;
    }

    public double getComfortToBuilding() {
        return Math.round(1/building.getBuildingToComfort()*100)/100.00;
    }

    public double getValuesSum() {
        return getComfortToBuilding() + getComfortToOffice() + getComfortToLocation() + getCOMFORT_TO_COMFORT();
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
        Comfort comfort = (Comfort) o;
        return Double.compare(comfort.COMFORT_TO_COMFORT, COMFORT_TO_COMFORT) == 0 &&
                Double.compare(comfort.comfortToBuilding, comfortToBuilding) == 0 &&
                Double.compare(comfort.comfortToLocation, comfortToLocation) == 0 &&
                Double.compare(comfort.comfortToOffice, comfortToOffice) == 0 &&
                Double.compare(comfort.valuesSum, valuesSum) == 0 &&
                Objects.equals(building, comfort.building);
    }

    @Override
    public int hashCode() {
        return Objects.hash(COMFORT_TO_COMFORT, building, comfortToBuilding, comfortToLocation, comfortToOffice, valuesSum);
    }

    @Override
    public String toString() {
        return  "\nComfort to building: " + getComfortToBuilding() +
                "\nCOMFORT_TO_COMFORT: " + COMFORT_TO_COMFORT +
                "\ncomfort to location: " + comfortToLocation +
                "\nComfort to office: " + comfortToOffice +
                "\nSummary: " + getValuesSum();
    }
}
