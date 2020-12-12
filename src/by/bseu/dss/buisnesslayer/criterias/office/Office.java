package by.bseu.dss.buisnesslayer.criterias.office;

import by.bseu.dss.buisnesslayer.criterias.building.Building;
import by.bseu.dss.buisnesslayer.criterias.comfort.Comfort;
import by.bseu.dss.buisnesslayer.criterias.location.Location;

import java.util.Objects;

public class Office {
    private String name;
    private Building building;
    private double officeToBuilding;
    private Comfort comfort;
    private double officeToComfort;
    private Location location;
    private double officeToLocation;
    private final double OFFICE_TO_OFFICE = 1;
    private double valuesSum;
    private double lambda;

    public Office(){}

    public Office(Building building, Comfort comfort, Location location) {
        this.building = building;
        this.comfort = comfort;
        this.location = location;
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

    public double getOfficeToBuilding() {
        return Math.round(1/building.getBuildingToOffice()*100)/100.00;
    }

    public Comfort getComfort() {
        return comfort;
    }

    public double getOfficeToComfort() {
        return Math.round(1/comfort.getComfortToOffice()*100)/100.00;
    }

    public Location getLocation() {
        return location;
    }

    public double getOfficeToLocation() {
        return Math.round(1/location.getLocationToOffice()*100)/100.00;
    }

    public double getOFFICE_TO_OFFICE() {
        return OFFICE_TO_OFFICE;
    }

    public double getValuesSum() {
        return getOfficeToBuilding() + getOfficeToLocation() + getOFFICE_TO_OFFICE() + getOfficeToComfort();
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
        Office office = (Office) o;
        return Double.compare(office.officeToBuilding, officeToBuilding) == 0 &&
                Double.compare(office.officeToComfort, officeToComfort) == 0 &&
                Double.compare(office.officeToLocation, officeToLocation) == 0 &&
                Double.compare(office.OFFICE_TO_OFFICE, OFFICE_TO_OFFICE) == 0 &&
                Double.compare(office.valuesSum, valuesSum) == 0 &&
                Objects.equals(building, office.building) &&
                Objects.equals(comfort, office.comfort) &&
                Objects.equals(location, office.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, officeToBuilding, comfort, officeToComfort, location, officeToLocation, OFFICE_TO_OFFICE, valuesSum);
    }

    @Override
    public String toString() {
        return  "Office to building: " + getOfficeToBuilding() +
                "\nOffice to comfort: " + getOfficeToComfort() +
                "\nOffice to location: " + getOfficeToLocation() +
                "\nOFFICE_TO_OFFICE: " + OFFICE_TO_OFFICE +
                "\nSummary: " + getValuesSum();
    }
}
