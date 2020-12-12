package by.bseu.dss.buisnesslayer.criterias.comfort.subcriterias;

import by.bseu.dss.buisnesslayer.criterias.comfort.Comfort;

import java.util.Objects;

public class HoleOfficeSquare extends Comfort {
    private String name;
    private ClientsComfortSquare clientsComfortSquare;
    private double holeSquareToClientsComfort;
    private final double OFFICE_SQUARE_TO_SQUARE = 1;
    private double holeSquareToWorkerComfort;
    private double lambdaSub;

    public HoleOfficeSquare(){}

    public HoleOfficeSquare(ClientsComfortSquare clientsComfortSquare){
        this.clientsComfortSquare = clientsComfortSquare;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public ClientsComfortSquare getClientsComfortSquare() {
        return clientsComfortSquare;
    }

    public double getHoleSquareToClientsComfort() {
        return Math.round(1 / clientsComfortSquare.getCComfortToSquare() * 100)/100.00;
    }

    public double getOFFICE_SQUARE_TO_SQUARE() {
        return OFFICE_SQUARE_TO_SQUARE;
    }

    public double getHoleSquareToWorkerComfort() {
        return holeSquareToWorkerComfort;
    }

    public void setClientsComfortSquare(ClientsComfortSquare clientsComfortSquare) {
        this.clientsComfortSquare = clientsComfortSquare;
    }

    public void setHoleSquareToWorkerComfort(double holeSquareToWorkerComfort) {
        this.holeSquareToWorkerComfort = holeSquareToWorkerComfort;
    }

    public void setLambdaSub(double lambdaSub) {
        this.lambdaSub = lambdaSub;
    }

    @Override
    public double getValuesSum() {
        return getHoleSquareToClientsComfort() + getHoleSquareToWorkerComfort() + getOFFICE_SQUARE_TO_SQUARE();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HoleOfficeSquare that = (HoleOfficeSquare) o;
        return Double.compare(that.holeSquareToClientsComfort, holeSquareToClientsComfort) == 0 &&
                Double.compare(that.OFFICE_SQUARE_TO_SQUARE, OFFICE_SQUARE_TO_SQUARE) == 0 &&
                Double.compare(that.holeSquareToWorkerComfort, holeSquareToWorkerComfort) == 0 &&
                Double.compare(that.lambdaSub, lambdaSub) == 0 &&
                Objects.equals(clientsComfortSquare, that.clientsComfortSquare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), clientsComfortSquare, holeSquareToClientsComfort, OFFICE_SQUARE_TO_SQUARE,
                holeSquareToWorkerComfort, lambdaSub);
    }
}
