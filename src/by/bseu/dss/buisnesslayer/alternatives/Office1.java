package by.bseu.dss.buisnesslayer.alternatives;

import java.util.Objects;

public class Office1 {
    private final double OFFICE1_TO_OFFICE1 = 1;
    private double office1ToOffice2;
    private double office1ToOffice3;
    private double valuesSum;
    private double lambda;

    public Office1(){}

    public double getOFFICE1_TO_OFFICE1() {
        return OFFICE1_TO_OFFICE1;
    }

    public double getOffice1ToOffice2() {
        return office1ToOffice2;
    }

    public void setOffice1ToOffice2(double office1ToOffice2) {
        this.office1ToOffice2 = office1ToOffice2;
    }

    public double getOffice1ToOffice3() {
        return office1ToOffice3;
    }

    public void setOffice1ToOffice3(double office1ToOffice3) {
        this.office1ToOffice3 = office1ToOffice3;
    }

    public double getValuesSum() {
        return getOFFICE1_TO_OFFICE1() + getOffice1ToOffice2() + getOffice1ToOffice3();
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
        Office1 office1 = (Office1) o;
        return Double.compare(office1.OFFICE1_TO_OFFICE1, OFFICE1_TO_OFFICE1) == 0 &&
                Double.compare(office1.office1ToOffice2, office1ToOffice2) == 0 &&
                Double.compare(office1.office1ToOffice3, office1ToOffice3) == 0 &&
                Double.compare(office1.valuesSum, valuesSum) == 0 &&
                Double.compare(office1.lambda, lambda) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(OFFICE1_TO_OFFICE1, office1ToOffice2, office1ToOffice3, valuesSum, lambda);
    }
}
