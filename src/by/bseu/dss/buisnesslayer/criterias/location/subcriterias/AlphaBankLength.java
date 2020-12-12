package by.bseu.dss.buisnesslayer.criterias.location.subcriterias;

import by.bseu.dss.buisnesslayer.criterias.location.Location;

import java.util.Objects;

public class AlphaBankLength extends Location {
    private String name;
    private final double BANK_LENGTH_TO_BANK_LENGTH = 1;
    private double lBankLengthToDistrict;
    private double lBankLengthToMetro;
    private double lambdaSub;

    public AlphaBankLength(){}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public double getBANK_LENGTH_TO_BANK_LENGTH() {
        return BANK_LENGTH_TO_BANK_LENGTH;
    }

    public double getLBankLengthToDistrict() {
        return lBankLengthToDistrict;
    }

    public double getLBankLengthToMetro() {
        return lBankLengthToMetro;
    }

    public void setLBankLengthToDistrict(double lBankLengthToDistrict) {
        this.lBankLengthToDistrict = lBankLengthToDistrict;
    }

    public void setLBankLengthToMetro(double lBankLengthToMetro) {
        this.lBankLengthToMetro = lBankLengthToMetro;
    }

    public void setLambdaSub(double lambdaSub) {
        this.lambdaSub = lambdaSub;
    }

    @Override
    public double getValuesSum() {
        return getBANK_LENGTH_TO_BANK_LENGTH() + getLBankLengthToDistrict() + getLBankLengthToMetro();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AlphaBankLength that = (AlphaBankLength) o;
        return Double.compare(that.BANK_LENGTH_TO_BANK_LENGTH, BANK_LENGTH_TO_BANK_LENGTH) == 0 &&
                Double.compare(that.lBankLengthToDistrict, lBankLengthToDistrict) == 0 &&
                Double.compare(that.lBankLengthToMetro, lBankLengthToMetro) == 0 &&
                Double.compare(that.lambdaSub, lambdaSub) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), BANK_LENGTH_TO_BANK_LENGTH, lBankLengthToDistrict,
                lBankLengthToMetro, lambdaSub);
    }
}
