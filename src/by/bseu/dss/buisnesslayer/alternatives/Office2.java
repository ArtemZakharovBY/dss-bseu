package by.bseu.dss.buisnesslayer.alternatives;

import java.util.Objects;

public class Office2 {
    private Office1 office1;
    private double office2ToOffice1;
    private final double OFFICE2_TO_OFFICE2 = 1;
    private double office2ToOffice3;
    private double valuesSum;
    private double lambda;

    public Office2(){}

    public Office2(Office1 office1){
        this.office1 = office1;
    }

    public Office1 getOffice1() {
        return office1;
    }

    public double getOffice2ToOffice1() {
        return Math.round(1 / office1.getOffice1ToOffice2() * 100) / 100.00;
    }

    public double getOFFICE2_TO_OFFICE2() {
        return OFFICE2_TO_OFFICE2;
    }

    public double getOffice2ToOffice3() {
        return office2ToOffice3;
    }

    public void setOffice2ToOffice3(double office2ToOffice3) {
        this.office2ToOffice3 = office2ToOffice3;
    }

    public double getValuesSum() {
        return getOffice2ToOffice1() + getOFFICE2_TO_OFFICE2() + getOffice2ToOffice3();
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
        Office2 office2 = (Office2) o;
        return Double.compare(office2.office2ToOffice1, office2ToOffice1) == 0 &&
                Double.compare(office2.OFFICE2_TO_OFFICE2, OFFICE2_TO_OFFICE2) == 0 &&
                Double.compare(office2.office2ToOffice3, office2ToOffice3) == 0 &&
                Double.compare(office2.valuesSum, valuesSum) == 0 &&
                Double.compare(office2.lambda, lambda) == 0 &&
                Objects.equals(office1, office2.office1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(office1, office2ToOffice1, OFFICE2_TO_OFFICE2, office2ToOffice3, valuesSum, lambda);
    }
}
