package by.bseu.dss.buisnesslayer.criterias.comfort.subcriterias;

import by.bseu.dss.buisnesslayer.criterias.comfort.Comfort;

import java.util.Objects;

public class WorkerComfortSquare extends Comfort {
    private String name;
    private ClientsComfortSquare clientsComfortSquare;
    private double workerComfortToClientsComfort;
    private HoleOfficeSquare holeOfficeSquare;
    private double workerComfortToOfficeSquare;
    private final double WORKER_COMFORT_TO_WORKER_COMFORT = 1;
    private double lambdaSub;

    public WorkerComfortSquare(){}

    public WorkerComfortSquare(ClientsComfortSquare clientsComfortSquare, HoleOfficeSquare holeOfficeSquare){
        this.clientsComfortSquare = clientsComfortSquare;
        this.holeOfficeSquare = holeOfficeSquare;
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

    public double getWorkerComfortToClientsComfort() {
        return Math.round(1 / clientsComfortSquare.getCComfortToWorker() * 100)/100.00;
    }

    public HoleOfficeSquare getHoleOfficeSquare() {
        return holeOfficeSquare;
    }

    public double getWorkerComfortToOfficeSquare() {
        return Math.round(1 / holeOfficeSquare.getHoleSquareToWorkerComfort() * 100)/100.00;
    }

    public double getWORKER_COMFORT_TO_WORKER_COMFORT() {
        return WORKER_COMFORT_TO_WORKER_COMFORT;
    }

    public void setLambdaSub(double lambdaSub) {
        this.lambdaSub = lambdaSub;
    }

    @Override
    public double getValuesSum() {
        return getWORKER_COMFORT_TO_WORKER_COMFORT() +
                getWorkerComfortToClientsComfort() + getWorkerComfortToOfficeSquare();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WorkerComfortSquare that = (WorkerComfortSquare) o;
        return Double.compare(that.workerComfortToClientsComfort, workerComfortToClientsComfort) == 0 &&
                Double.compare(that.workerComfortToOfficeSquare, workerComfortToOfficeSquare) == 0 &&
                Double.compare(that.WORKER_COMFORT_TO_WORKER_COMFORT, WORKER_COMFORT_TO_WORKER_COMFORT) == 0 &&
                Double.compare(that.lambdaSub, lambdaSub) == 0 &&
                Objects.equals(clientsComfortSquare, that.clientsComfortSquare) &&
                Objects.equals(holeOfficeSquare, that.holeOfficeSquare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), clientsComfortSquare, workerComfortToClientsComfort,
                holeOfficeSquare, workerComfortToOfficeSquare, WORKER_COMFORT_TO_WORKER_COMFORT, lambdaSub);
    }
}
