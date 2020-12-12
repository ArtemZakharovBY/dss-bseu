package by.bseu.dss.buisnesslayer.criterias.office.subcriterias;

import java.util.Scanner;

public class OfficeSubCriteriasMethods {

    public static InternetSpeed makeSubInternetSpeed(){
        Scanner scan = new Scanner(System.in);

        InternetSpeed internetSpeed = new InternetSpeed();
        //Giving a mark to "Internet speed" (Office criteria)
        System.out.println
                ("Write a mark to subcriteria \"Internet speed - Repairing year\" of criteria \"Office\": ");
        internetSpeed.setSpeedToRepairing(scan.nextDouble());
        System.out.println
                ("Write a mark to subcriteria \"Internet speed - Sharing price\" of criteria \"Office\": ");
        internetSpeed.setSpeedToPrice(scan.nextDouble());

        return internetSpeed;
    }

    public static RepairingYear makeSubRepairingYear(InternetSpeed internetSpeed){
        Scanner scan = new Scanner(System.in);

        RepairingYear repairingYear = new RepairingYear(internetSpeed);
        //Giving a mark to "Repairing year" (Office criteria)
        System.out.println
                ("Write a mark to subcriteria \"Repairing year - Sharing price\" of criteria \"Office\": ");
        repairingYear.setRepairingToPrice(scan.nextDouble());

        return repairingYear;
    }

    public static SharingPrice makeSubSharingPrice(InternetSpeed internetSpeed, RepairingYear repairingYear){
        Scanner scan = new Scanner(System.in);

        SharingPrice sharingPrice = new SharingPrice(internetSpeed, repairingYear);
        //Giving a mark to "Sharing price is all automatically" (Location criteria)

        return sharingPrice;
    }

    public static void makeOfficeSubMatrix(InternetSpeed internetSpeed, RepairingYear repairingYear,
                                             SharingPrice sharingPrice){

        double[][] matrix = {{internetSpeed.getSPEED_TO_SPEED(), internetSpeed.getSpeedToRepairing(),
        internetSpeed.getSpeedToPrice()}, {repairingYear.getRepairingToSpeed(),
        repairingYear.getREPAIRING_TO_REPAIRING(), repairingYear.getRepairingToPrice()},
        {sharingPrice.getPriceToSpeed(), sharingPrice.getPriceToRepairing(), sharingPrice.getPRICE_TO_PRICE()}};

        System.out.println("Matrix of subcriterias of \"Office\" criteria: ");
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double sumOfficeSubValues(InternetSpeed internetSpeed, RepairingYear repairingYear,
                                              SharingPrice sharingPrice){

        double result = internetSpeed.getValuesSum() + repairingYear.getValuesSum() +
                sharingPrice.getValuesSum();

        return result;
    }

    public static double lambdaSubOfficeInternetSpeed(InternetSpeed internetSpeed, double holeSum){

        return internetSpeed.getValuesSum() / holeSum;
    }

    public static double lambdaSubOfficeRepairingYear(RepairingYear repairingYear, double holeSum){

        return repairingYear.getValuesSum() / holeSum;
    }

    public static double lambdaSubOfficeSharingPrice(SharingPrice sharingPrice, double holeSum){

        return sharingPrice.getValuesSum() / holeSum;
    }

    public static double[] lambdaOfficeSubBag(double lambda1, double lambda2, double lambda3){

        double[] lmdBag = {lambda1, lambda2, lambda3};

        return lmdBag;
    }

    public static void setLmdToOfficeSubCriterias(InternetSpeed internetSpeed, RepairingYear repairingYear,
            SharingPrice sharingPrice, double[] lmdBag){
        internetSpeed.setLambda(lmdBag[0]);
        repairingYear.setLambda(lmdBag[1]);
        sharingPrice.setLambda(lmdBag[2]);
    }

    public static void outputOfficeLmbdSubBag(double[] bag) {

        double sum = 0;
        for (double lambda : bag) {

            sum += lambda;
        }

        System.out.println("Lambda \"Internet speed\": " + bag[0] + "\nLambda \"Repairing year\": " + bag[1]
                + "\nLambda \"Sharing price\": " + bag[2] + "\nSummary: " + sum + "\n");
    }
}
