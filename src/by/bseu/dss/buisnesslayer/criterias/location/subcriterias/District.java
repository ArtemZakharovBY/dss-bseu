package by.bseu.dss.buisnesslayer.criterias.location.subcriterias;

import by.bseu.dss.buisnesslayer.criterias.location.Location;

import java.util.Objects;

public class District extends Location {
    private String name;
    private AlphaBankLength alphaBankLength;
    private double lDistrictToBankLength;
    private final double DISTRICT_TO_DISTRICT = 1;
    private double lDistrictToMetro;
    private double lambdaSub;

    public District(){}

    public District(AlphaBankLength alphaBankLength){
        this.alphaBankLength = alphaBankLength;
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

    public double getLDistrictToBankLength() {
        return Math.round(1 / alphaBankLength.getLBankLengthToDistrict() * 100) / 100.00;
    }

    public double getDISTRICT_TO_DISTRICT() {
        return DISTRICT_TO_DISTRICT;
    }

    public double getLDistrictToMetro() {
        return lDistrictToMetro;
    }

    public void setLDistrictToMetro(double lDistrictToMetro) {
        this.lDistrictToMetro = lDistrictToMetro;
    }

    public void setLambdaSub(double lambdaSub) {
        this.lambdaSub = lambdaSub;
    }

    @Override
    public double getValuesSum() {
        return getLDistrictToBankLength() + getDISTRICT_TO_DISTRICT() + getLDistrictToMetro();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        District district = (District) o;
        return Double.compare(district.lDistrictToBankLength, lDistrictToBankLength) == 0 &&
                Double.compare(district.DISTRICT_TO_DISTRICT, DISTRICT_TO_DISTRICT) == 0 &&
                Double.compare(district.lDistrictToMetro, lDistrictToMetro) == 0 &&
                Double.compare(district.lambdaSub, lambdaSub) == 0 &&
                Objects.equals(alphaBankLength, district.alphaBankLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), alphaBankLength, lDistrictToBankLength, DISTRICT_TO_DISTRICT,
                lDistrictToMetro, lambdaSub);
    }
}
