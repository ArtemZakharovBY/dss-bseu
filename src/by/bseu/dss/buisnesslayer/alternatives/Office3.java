package by.bseu.dss.buisnesslayer.alternatives;

import java.util.Objects;

public class Office3 {
    private Office1 office1;
    private double office3ToOffice1;
    private Office2 office2;
    private double office3ToOffice2;
    private final double OFFICE3_TO_OFFICE3 = 1;
    private double valuesSum;
    private double lambda;

    public Office3(){}

    public Office3(Office1 office1, Office2 office2){
        this.office1 = office1;
        this.office2 = office2;
    }

    public Office1 getOffice1() {
        return office1;
    }

    public void setOffice1(Office1 office1) {
        this.office1 = office1;
    }

    public double getOffice3ToOffice1() {
        return Math.round(1 / office1.getOffice1ToOffice3() * 100) / 100.00;
    }

    public Office2 getOffice2() {
        return office2;
    }

    public void setOffice2(Office2 office2) {
        this.office2 = office2;
    }

    public double getOffice3ToOffice2() {
        return Math.round(1 / office2.getOffice2ToOffice3() * 100) / 100.00;
    }

    public double getOFFICE3_TO_OFFICE3() {
        return OFFICE3_TO_OFFICE3;
    }

    public double getValuesSum() {
        return getOffice3ToOffice1() + getOffice3ToOffice2() + getOFFICE3_TO_OFFICE3();
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
        Office3 office3 = (Office3) o;
        return Double.compare(office3.office3ToOffice1, office3ToOffice1) == 0 &&
                Double.compare(office3.office3ToOffice2, office3ToOffice2) == 0 &&
                Double.compare(office3.OFFICE3_TO_OFFICE3, OFFICE3_TO_OFFICE3) == 0 &&
                Double.compare(office3.valuesSum, valuesSum) == 0 &&
                Double.compare(office3.lambda, lambda) == 0 &&
                Objects.equals(office1, office3.office1) &&
                Objects.equals(office2, office3.office2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(office1, office3ToOffice1, office2, office3ToOffice2, OFFICE3_TO_OFFICE3, valuesSum, lambda);
    }
}
