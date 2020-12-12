package by.bseu.dss.buisnesslayer.criterias.methods;

import by.bseu.dss.buisnesslayer.criterias.building.Building;
import by.bseu.dss.buisnesslayer.criterias.comfort.Comfort;
import by.bseu.dss.buisnesslayer.criterias.location.Location;
import by.bseu.dss.buisnesslayer.criterias.office.Office;

import java.util.Scanner;

public class CriteriasMethods {

    public static Building makeBuilding(){
        Scanner scan = new Scanner(System.in);

        Building building = new Building();
        //Giving a mark to "Building" line
        System.out.println("Write a mark to \"Building-Comfort\" criteria: ");
        building.setBuildingToComfort(scan.nextDouble());
        System.out.println("Write a mark to \"Building-Location\" criteria: ");
        building.setBuildingToLocation(scan.nextDouble());
        System.out.println("Write a mark to \"Building-Office\" criteria: ");
        building.setBuildingToOffice(scan.nextDouble());

        return building;
    }

    public static Comfort makeComfort(Building building){
        Scanner scan = new Scanner(System.in);

        Comfort comfort = new Comfort(building);
        //Giving a mark to "Comfort" line
        System.out.println("Write a mark to \"Comfort-Location\" criteria: ");
        comfort.setComfortToLocation(scan.nextDouble());
        System.out.println("Write a mark to \"Comfort-Office\" criteria: ");
        comfort.setComfortToOffice(scan.nextDouble());

        return comfort;
    }

    public static Location makeLocation(Building building, Comfort comfort){
        Scanner scan = new Scanner(System.in);

        Location location = new Location(building, comfort);
        //Giving a mark to "Location" line
        System.out.println("Write a mark to \"Location-Office\" criteria: ");
        location.setLocationToOffice(scan.nextDouble());

        return location;
    }

    public static Office makeOffice(Building building, Comfort comfort, Location location){
        Scanner scan = new Scanner(System.in);

        //Giving a mark to "Office" line is automatically
        Office office = new Office(building, comfort, location);
        System.out.println();

        return office;
    }


    public static void matrixPairComparison(Building building, Comfort comfort, Location location, Office office){

        double[][] matrix = {{building.getBUILDING_TO_BUILDING(), building.getBuildingToComfort(),
                building.getBuildingToLocation(), building.getBuildingToOffice()},
                {comfort.getComfortToBuilding(), comfort.getCOMFORT_TO_COMFORT(), comfort.getComfortToLocation(),
                        comfort.getComfortToOffice()},
                {location.getLocationToBuilding(), location.getLocationToComfort(), location.getLOCATION_TO_LOCATION(),
                        location.getLocationToOffice()},
                {office.getOfficeToBuilding(), office.getOfficeToComfort(), office.getOfficeToLocation(),
                        office.getOFFICE_TO_OFFICE()}};

        System.out.println("Matrix of pairwise comparison: ");
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double sumAllValues(Building building, Comfort comfort, Location location, Office office){
        double result = building.getValuesSum() + comfort.getValuesSum() +
                location.getValuesSum() + office.getValuesSum();

        return result;
    }

    public static double lambdaBuilding(Building building, double holeSum){

        return building.getValuesSum() / holeSum;
    }

    public static double lambdaComfort(Comfort comfort, double holeSum){

        return comfort.getValuesSum() / holeSum;
    }

    public static double lambdaLocation(Location location, double holeSum){

        return location.getValuesSum() / holeSum;
    }

    public static double lambdaOffice(Office office, double holeSum){

        return office.getValuesSum() / holeSum;
    }

    public static double[] lambdaBag(double lambda1, double lambda2, double lambda3, double lambda4){
        double[] lmdBag = {lambda1, lambda2, lambda3, lambda4};

        return lmdBag;
    }

    public static void setLmdToCriteria(Building building, Comfort comfort, Location location, Office office,
                                        double[] lmdBag){
        building.setLambda(lmdBag[0]);
        comfort.setLambda(lmdBag[1]);
        location.setLambda(lmdBag[2]);
        office.setLambda(lmdBag[3]);
    }

    public static void outputLmdBag(double[] bag){

        double sum = 0;
        for (double lambda: bag) {

            sum += lambda;
        }

        System.out.println("Lambda \"Building\": " + bag[0] + "\nLambda \"Comfort\": " + bag[1]
        + "\nLambda \"Location\": " + bag[2] + "\nLambda \"Office\": " + bag[3] + "\nSummary: " + sum + "\n");
    }
}
