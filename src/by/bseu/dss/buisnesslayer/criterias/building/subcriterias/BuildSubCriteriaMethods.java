package by.bseu.dss.buisnesslayer.criterias.building.subcriterias;

import java.util.Scanner;

public class BuildSubCriteriaMethods {

    public static BuildingType makeSubBuildingType(){
        Scanner scan = new Scanner(System.in);

        BuildingType buildingType = new BuildingType();
        //Giving a mark to "Building type" (Building criteria)
        System.out.println("Write a mark to subcriteria \"Building type - floor number\" of criteria \"Building\": ");
        buildingType.setBTypeTOFloor(scan.nextDouble());
        System.out.println
                ("Write a mark to subcriteria \"Building type - outside appearance\" of criteria \"Building\": ");
        buildingType.setBTypeToAppearance(scan.nextDouble());

        return buildingType;
    }

    public static FloorNumber makeSubFloorNumber(BuildingType buildingType){
        Scanner scan = new Scanner(System.in);

        FloorNumber floorNumber = new FloorNumber(buildingType);
        //Giving a mark to "Floor number" (Building criteria)
        System.out.println
                ("Write a mark to subcriteria \"Floor number - outside appearance\" of criteria \"Building\": ");
        floorNumber.setBFloorToAppearance(scan.nextDouble());

        return floorNumber;
    }

    public static OutsideAppearance makeSubAppearance(BuildingType buildingType, FloorNumber floorNumber){
        //Giving all mark is automatically
        System.out.println();

        return new OutsideAppearance(buildingType, floorNumber);
    }

    public static void makeBuildSubMatrix
            (BuildingType buildingType, FloorNumber floorNumber, OutsideAppearance outsideAppearance){

        double[][] matrix = {{buildingType.getBUILDING_TO_BUILDING(), buildingType.getBTypeToFloor(),
        buildingType.getBTypeToAppearance()}, {floorNumber.getBFloorToType(), floorNumber.getB_FLOOR_TO_FLOOR(),
        floorNumber.getBFloorToAppearance()}, {outsideAppearance.getBAppearanceToType(),
        outsideAppearance.getBAppearanceToFloor(), outsideAppearance.getB_APPEARANCE_TO_APPEARANCE()}};

        System.out.println("Matrix of subcriterias of \"Building\" criteria: ");
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double sumBuildSubAllValues
            (BuildingType buildingType, FloorNumber floorNumber, OutsideAppearance outsideAppearance){

        double result = buildingType.getValuesSum() + floorNumber.getValuesSum() + outsideAppearance.getValuesSum();

        return result;
    }

    public static double lambdaSubBuildType(BuildingType buildingType, double holeSum){

        return buildingType.getValuesSum() / holeSum;
    }

    public static double lambdaSubBuildFloor(FloorNumber floorNumber, double holeSum){

        return floorNumber.getValuesSum() / holeSum;
    }

    public static double lambdaSubBuildAppearance(OutsideAppearance outsideAppearance, double holeSum){

        return outsideAppearance.getValuesSum() / holeSum;
    }

    public static double[] lambdaBuildSubBag(double lambda1, double lambda2, double lambda3){

        double[] lmdBag = {lambda1, lambda2, lambda3};

        return lmdBag;
    }

    public static void setLmdToBuildSubcriterias(BuildingType buildingType, FloorNumber floorNumber,
                                        OutsideAppearance outsideAppearance, double[] lmdBag){
        buildingType.setLambda(lmdBag[0]);
        floorNumber.setLambda(lmdBag[1]);
        outsideAppearance.setLambda(lmdBag[2]);
    }

    public static void outputBuildSubLmdBag(double[] bag){

        double sum = 0;
        for (double lambda: bag) {

            sum += lambda;
        }

        System.out.println("Lambda \"Building type\": " + bag[0] + "\nLambda \"Floor number\": " + bag[1]
                + "\nLambda \"Outside appearance\": " + bag[2] + "\nSummary: " + sum + "\n");
    }
}
