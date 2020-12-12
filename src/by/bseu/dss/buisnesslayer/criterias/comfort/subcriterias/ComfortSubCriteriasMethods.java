package by.bseu.dss.buisnesslayer.criterias.comfort.subcriterias;

import java.util.Scanner;

public class ComfortSubCriteriasMethods {

    public static ClientsComfortSquare makeSubClientsComfort(){
        Scanner scan = new Scanner(System.in);

        ClientsComfortSquare clientsComfortSquare = new ClientsComfortSquare();
        //Giving a mark to "Clients comfort" (Comfort criteria)
        System.out.println
                ("Write a mark to subcriteria \"Clients comfort - Hole office square\" of criteria \"Comfort\": ");
        clientsComfortSquare.setCComfortToSquare(scan.nextDouble());
        System.out.println
                ("Write a mark to subcriteria \"Clients comfort - Worker comfort square\" of criteria \"Comfort\": ");
        clientsComfortSquare.setCComfortToWorker(scan.nextDouble());

        return clientsComfortSquare;
    }

    public static HoleOfficeSquare makeSubHoleOfficeSquare(ClientsComfortSquare clientsComfortSquare){
        Scanner scan = new Scanner(System.in);

        HoleOfficeSquare holeOfficeSquare = new HoleOfficeSquare(clientsComfortSquare);
        //Giving a mark to "Hole office square" (Comfort criteria)
        System.out.println
                ("Write a mark to subcriteria \"Hole office square - Worker comfort square\" of criteria \"Comfort\": ");
        holeOfficeSquare.setHoleSquareToWorkerComfort(scan.nextDouble());

        return holeOfficeSquare;
    }

    public static WorkerComfortSquare makeSubWorkerComfortSquare(ClientsComfortSquare clientsComfortSquare,
                                                                 HoleOfficeSquare holeOfficeSquare){
        Scanner scan = new Scanner(System.in);

        WorkerComfortSquare workerComfortSquare = new WorkerComfortSquare(clientsComfortSquare, holeOfficeSquare);
        //Giving a mark to "Worker comfort square" is all automatically
        System.out.println();

        return workerComfortSquare;
    }

    public static void makeComfortSubMatrix(ClientsComfortSquare clientsComfortSquare,
                                            HoleOfficeSquare holeOfficeSquare, WorkerComfortSquare workerComfortSquare){

        double[][] matrix = {{clientsComfortSquare.getC_COMFORT_TO_COMFORT(),
                clientsComfortSquare.getCComfortToSquare(), clientsComfortSquare.getCComfortToWorker()},
                {holeOfficeSquare.getHoleSquareToClientsComfort(), holeOfficeSquare.getOFFICE_SQUARE_TO_SQUARE(),
                holeOfficeSquare.getHoleSquareToWorkerComfort()},
                {workerComfortSquare.getWorkerComfortToClientsComfort(),
                 workerComfortSquare.getWorkerComfortToOfficeSquare(),
                 workerComfortSquare.getWORKER_COMFORT_TO_WORKER_COMFORT()}};

        System.out.println("Matrix of subcriterias of \"Comfort\" criteria: ");
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double sumComfortSubValues(ClientsComfortSquare clientsComfortSquare,
                                            HoleOfficeSquare holeOfficeSquare, WorkerComfortSquare workerComfortSquare){

        double result = clientsComfortSquare.getValuesSum() + holeOfficeSquare.getValuesSum() +
                workerComfortSquare.getValuesSum();

        return result;
    }

    public static double lambdaSubComfortClients(ClientsComfortSquare clientsComfortSquare, double holeSum){

        return clientsComfortSquare.getValuesSum() / holeSum;
    }

    public static double lambdaSubComfortHoleOffice(HoleOfficeSquare holeOfficeSquare, double holeSum){

        return holeOfficeSquare.getValuesSum() / holeSum;
    }

    public static double lambdaSubComfortWorkerComf(WorkerComfortSquare workerComfortSquare, double holeSum){

        return workerComfortSquare.getValuesSum() / holeSum;
    }

    public static double[] lambdaComfortSubBag(double lambda1, double lambda2, double lambda3){

        double[] lmdBag = {lambda1, lambda2, lambda3};

        return lmdBag;
    }

    public static void setLmdToComfortSubcriterias(ClientsComfortSquare clientsComfortSquare,
                           HoleOfficeSquare holeOfficeSquare, WorkerComfortSquare workerComfortSquare, double[] lmdBag){
        clientsComfortSquare.setLambda(lmdBag[0]);
        holeOfficeSquare.setLambda(lmdBag[1]);
        workerComfortSquare.setLambda(lmdBag[2]);
    }

    public static void outputComfortSubLmdBag(double[] bag){

        double sum = 0;
        for (double lambda: bag) {

            sum += lambda;
        }

        System.out.println("Lambda \"Clients comfort square\": " + bag[0] + "\nLambda \"Hole office square\": " + bag[1]
                + "\nLambda \"Worker comfort square\": " + bag[2] + "\nSummary: " + sum + "\n");
    }


}
