package by.bseu.dss.buisnesslayer.criterias.location.subcriterias;

import by.bseu.dss.buisnesslayer.criterias.location.Location;

import java.util.Objects;

public class MetroLength extends Location {
    private String name;
    private AlphaBankLength alphaBankLength;
    private double lMetroToBankLength;
    private District district;
    private double lMetroToDistrict;
    private final double METRO_TO_METRO = 1;
    private double lambdaSub;

    public MetroLength(){}

    public MetroLength(AlphaBankLength alphaBankLength, District district){
        this.alphaBankLength = alphaBankLength;
        this.district = district;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public AlphaBankLength getAlphaBankLength() {
        return alphaBankLength;
    }

    public double getLMetroToBankLength() {
        return Math.round(1 / alphaBankLength.getLBankLengthToMetro() * 100) / 100.00;
    }

    public District getDistrict() {
        return district;
    }

    public double getLMetroToDistrict() {
        return Math.round(1 / district.getLDistrictToMetro() * 100) / 100.00;
    }

    public double getMETRO_TO_METRO() {
        return METRO_TO_METRO;
    }

    public void setLambdaSub(double lambdaSub) {
        this.lambdaSub = lambdaSub;
    }

    @Override
    public double getValuesSum() {
        return getLMetroToBankLength() + getLMetroToDistrict() + getMETRO_TO_METRO();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MetroLength that = (MetroLength) o;
        return Double.compare(that.lMetroToBankLength, lMetroToBankLength) == 0 &&
                Double.compare(that.lMetroToDistrict, lMetroToDistrict) == 0 &&
                Double.compare(that.METRO_TO_METRO, METRO_TO_METRO) == 0 &&
                Double.compare(that.lambdaSub, lambdaSub) == 0 &&
                Objects.equals(alphaBankLength, that.alphaBankLength) &&
                Objects.equals(district, that.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), alphaBankLength, lMetroToBankLength, district,
                lMetroToDistrict, METRO_TO_METRO, lambdaSub);
    }
}
