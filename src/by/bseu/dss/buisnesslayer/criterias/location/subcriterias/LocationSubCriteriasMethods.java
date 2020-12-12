package by.bseu.dss.buisnesslayer.criterias.location.subcriterias;

import java.util.Scanner;

public class LocationSubCriteriasMethods {

    public static AlphaBankLength makeSubBankLength(){
        Scanner scan = new Scanner(System.in);

        AlphaBankLength alphaBankLength = new AlphaBankLength();
        //Giving a mark to "Alpha bank length" (Location criteria)
        System.out.println
                ("Write a mark to subcriteria \"Alpha bank length - District\" of criteria \"Location\": ");
        alphaBankLength.setLBankLengthToDistrict(scan.nextDouble());
        System.out.println
                ("Write a mark to subcriteria \"Alpha bank length - Metro length\" of criteria \"Location\": ");
        alphaBankLength.setLBankLengthToMetro(scan.nextDouble());

        return alphaBankLength;
    }

    public static District makeSubDistrict(AlphaBankLength alphaBankLength){
        Scanner scan = new Scanner(System.in);

        District district = new District(alphaBankLength);
        //Giving a mark to "District" (Location criteria)
        System.out.println
                ("Write a mark to subcriteria \"District - Metro length\" of criteria \"Location\": ");
        district.setLDistrictToMetro(scan.nextDouble());

        return district;
    }

    public static MetroLength makeSubMetro(AlphaBankLength alphaBankLength, District district){
        Scanner scan = new Scanner(System.in);

        MetroLength metroLength = new MetroLength(alphaBankLength, district);
        //Giving a mark to "Metro length" is all automatically

        return metroLength;
    }

    public static void makeLocationSubMatrix(AlphaBankLength alphaBankLength, District district,
                                            MetroLength metroLength){

        double[][] matrix = {{alphaBankLength.getBANK_LENGTH_TO_BANK_LENGTH(),
             alphaBankLength.getLBankLengthToDistrict(), alphaBankLength.getLBankLengthToMetro()},
             {district.getLDistrictToBankLength(), district.getDISTRICT_TO_DISTRICT(), district.getLDistrictToMetro()},
             {metroLength.getLMetroToBankLength(), metroLength.getLMetroToDistrict(), metroLength.getMETRO_TO_METRO()}};

        System.out.println("Matrix of subcriterias of \"Location\" criteria: ");
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double sumLocationSubValues(AlphaBankLength alphaBankLength, District district,
                                             MetroLength metroLength){

        double result = alphaBankLength.getValuesSum() + district.getValuesSum() +
                metroLength.getValuesSum();

        return result;
    }

    public static double lambdaSubLocationBankLength(AlphaBankLength alphaBankLength, double holeSum){

        return alphaBankLength.getValuesSum() / holeSum;
    }

    public static double lambdaSubLocationDistrict(District district, double holeSum){

        return district.getValuesSum() / holeSum;
    }

    public static double lambdaSubLocationMetroLength(MetroLength metroLength, double holeSum){

        return metroLength.getValuesSum() / holeSum;
    }

    public static double[] lambdaLocationSubBag(double lambda1, double lambda2, double lambda3){

        double[] lmdBag = {lambda1, lambda2, lambda3};

        return lmdBag;
    }

    public static void setLmdToLocationSubcriterias(AlphaBankLength alphaBankLength, District district,
                                                   MetroLength metroLength, double[] lmdBag){
        alphaBankLength.setLambda(lmdBag[0]);
        district.setLambda(lmdBag[1]);
        metroLength.setLambda(lmdBag[2]);
    }

    public static void outputLocationSubLmdBag(double[] bag) {

        double sum = 0;
        for (double lambda : bag) {

            sum += lambda;
        }

        System.out.println("Lambda \"Alpha bank length\": " + bag[0] + "\nLambda \"District\": " + bag[1]
                + "\nLambda \"Metro length\": " + bag[2] + "\nSummary: " + sum + "\n");
    }
}
