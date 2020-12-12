package by.bseu.dss.buisnesslayer.criterias.comfort.subcriterias;

import by.bseu.dss.buisnesslayer.criterias.comfort.Comfort;

import java.util.Objects;

public class ClientsComfortSquare extends Comfort {
    private String name;
    private final double C_COMFORT_TO_COMFORT = 1;
    private double cComfortToSquare;
    private double cComfortToWorker;
    private double lambdaSub;

    public ClientsComfortSquare(){}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public double getC_COMFORT_TO_COMFORT() {
        return C_COMFORT_TO_COMFORT;
    }

    public double getCComfortToSquare() {
        return cComfortToSquare;
    }

    public void setCComfortToSquare(double cComfortToSquare) {
        this.cComfortToSquare = cComfortToSquare;
    }

    public double getCComfortToWorker() {
        return cComfortToWorker;
    }

    public void setCComfortToWorker(double cComfortToWorker) {
        this.cComfortToWorker = cComfortToWorker;
    }

    public void setLambdaSub(double lambdaSub) {
        this.lambdaSub = lambdaSub;
    }

    @Override
    public double getValuesSum() {
        return getC_COMFORT_TO_COMFORT() + getCComfortToSquare() + getCComfortToWorker();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClientsComfortSquare that = (ClientsComfortSquare) o;
        return  Double.compare(that.C_COMFORT_TO_COMFORT, C_COMFORT_TO_COMFORT) == 0 &&
                Double.compare(that.cComfortToSquare, cComfortToSquare) == 0 &&
                Double.compare(that.cComfortToWorker, cComfortToWorker) == 0 &&
                Double.compare(that.lambdaSub, lambdaSub) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), C_COMFORT_TO_COMFORT, cComfortToSquare, cComfortToWorker, lambdaSub);
    }

    @Override
    public String toString() {
        return "Criteria: Comfort" +
                "C_COMFORT_TO_COMFORT=" + C_COMFORT_TO_COMFORT +
                ", cComfortToSquare=" + cComfortToSquare +
                ", cComfortToWorker=" + cComfortToWorker +
                ", lambdaSub=" + lambdaSub +
                '}';
    }
}
