package by.bseu.dss.buisnesslayer.alternatives.altmethods;

import by.bseu.dss.buisnesslayer.alternatives.Office1;
import by.bseu.dss.buisnesslayer.alternatives.Office2;
import by.bseu.dss.buisnesslayer.alternatives.Office3;

import java.util.Scanner;

public class AlternativeLogic {

    public static Office1 makeOffice1(){
        Scanner scan = new Scanner(System.in);

        Office1 office1 = new Office1();
        //Giving a mark to "Office1" line
        System.out.println("Write a mark to alternative \"Office1 - Office2\": ");
        office1.setOffice1ToOffice2(scan.nextDouble());
        System.out.println("Write a mark to alternative \"Office1 - Office3\": ");
        office1.setOffice1ToOffice3(scan.nextDouble());

        return office1;
    }

    public static Office2 makeOffice2(Office1 office1){
        Scanner scan = new Scanner(System.in);

        Office2 office2 = new Office2(office1);
        //Giving a mark to "Office2" line
        System.out.println("Write a mark to alternative \"Office2 - Office3\": ");
        office2.setOffice2ToOffice3(scan.nextDouble());

        return office2;
    }

    public static Office3 makeOffice3(Office1 office1, Office2 office2){
        Scanner scan = new Scanner(System.in);

        Office3 office3 = new Office3(office1, office2);
        //Giving a mark to "Office3" line is all automatically

        return office3;
    }

    public static void matrixPairComparison(Office1 office1, Office2 office2, Office3 office3){

        double[][] matrix = {{office1.getOFFICE1_TO_OFFICE1(), office1.getOffice1ToOffice2(),
        office1.getOffice1ToOffice3()}, {office2.getOffice2ToOffice1(), office2.getOFFICE2_TO_OFFICE2(),
        office2.getOffice2ToOffice3()}, {office3.getOffice3ToOffice1(), office3.getOffice3ToOffice2(),
        office3.getOFFICE3_TO_OFFICE3()}};

        System.out.println("Matrix of pairwise comparison: ");
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double sumAllValuesAlt(Office1 office1, Office2 office2, Office3 office3){
        double result = office1.getValuesSum() + office2.getValuesSum() + office3.getValuesSum();

        return result;
    }

    public static double lambdaOffice1(Office1 office1, double holeSum){

        return office1.getValuesSum() / holeSum;
    }

    public static double lambdaOffice2(Office2 office2, double holeSum){

        return office2.getValuesSum() / holeSum;
    }

    public static double lambdaOffice3(Office3 office3, double holeSum){

        return office3.getValuesSum() / holeSum;
    }

    public static double[] lambdaBagAlt(double lambda1, double lambda2, double lambda3){
        double[] lmdBag = {lambda1, lambda2, lambda3};

        return lmdBag;
    }

    public static void setLmdToAlt(Office1 office1, Office2 office2, Office3 office3, double[] lmdBag){
        office1.setLambda(lmdBag[0]);
        office2.setLambda(lmdBag[1]);
        office3.setLambda(lmdBag[2]);

    }

    public static void outputLmdBagAlt(double[] bag){

        double sum = 0;
        for (double lambda: bag) {

            sum += lambda;
        }

        System.out.println("Lambda \"Office1\": " + bag[0] + "\nLambda \"Office2\": " + bag[1]
                + "\nLambda \"Office3\": " + bag[2] + "\nSummary: " + sum + "\n");
    }

    public static double[][] convertToArr(double[] arr1, double[] arr2, double[] arr3, double[] arr4, double[] arr5,
                                        double[] arr6, double[] arr7, double[] arr8, double[] arr9, double[] arr10,
                                        double[] arr11, double[] arr12){

        double[] temp = new double[36];
        System.arraycopy(arr1, 0, temp, 0, arr1.length);
        System.arraycopy(arr2, 0, temp, arr2.length, arr2.length);
        System.arraycopy(arr3, 0, temp, arr3.length * 2, arr3.length);
        System.arraycopy(arr4, 0, temp, arr4.length * 3, arr4.length);
        System.arraycopy(arr5, 0, temp, arr5.length * 4, arr5.length);
        System.arraycopy(arr6, 0, temp, arr6.length * 5, arr6.length);
        System.arraycopy(arr7, 0, temp, arr7.length * 6, arr7.length);
        System.arraycopy(arr8, 0, temp, arr8.length * 7, arr8.length);
        System.arraycopy(arr9, 0, temp, arr9.length * 8, arr9.length);
        System.arraycopy(arr10, 0, temp, arr10.length * 9, arr10.length);
        System.arraycopy(arr11, 0, temp, arr11.length * 10, arr11.length);
        System.arraycopy(arr12, 0, temp, arr12.length * 11, arr12.length);

        for (int i = 0; i < temp.length; i++) {
            temp[i] = Math.round(temp[i] * 100) / 100.000;
        }

        double[][] result = new double[12][3];
        int q = 0;
            for (int j = 0; j < result.length; j++) {

                for (int k = 0; k < result[j].length; k++) {

                    result[j][k] = temp[q];
                    q++;
                }
            }

        return result;
    }

    public static void outputAltMat(double[][] matrix){

        String output = "Office1 Office2 Office3\n";
        System.out.print(output);
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static double[] allLmbdSub(double[] build, double[] comfort, double[] location, double[] office){

        double[] result = new double[12];
        System.arraycopy(build, 0, result, 0, build.length);
        System.arraycopy(comfort, 0, result, comfort.length, comfort.length);
        System.arraycopy(location, 0, result, comfort.length + build.length, location.length);
        System.arraycopy(office, 0, result, location.length + comfort.length + build.length,
                office.length);

        for (int i = 0; i < result.length; i++) {
            result[i] = Math.round(result[i] * 100) / 100.000;
        }

        return result;
    }

    public static double[][] readyMark(double[][] matrix, double[] array){

        int q = 0;
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (q == i){

                    matrix[i][j] *= array[q];
                }
            }
            q++;
        }

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                matrix[i][j] = Math.round(matrix[i][j] * 100) / 100.000;
            }
        }
        return matrix;
    }

    public static void readyChoice(double[][] result){

        double res1 = 0;
        double res2 = 0;
        double res3 = 0;

        for (int i = 0; i < result.length; i++) {

            for (int j = 0; j < result[i].length; j++) {

                if (j == 0){
                    res1 += result[i][j];
                } else if (j == 1){
                    res2 += result[i][j];
                } else if (j == 2){
                    res3 += result[i][j];
                }
            }
        }
        System.out.println("\nOffice1: " + res1 + "\nOffice2: " + res2 + "\nOffice3: " + res3);
    }
}
