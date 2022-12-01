/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author deece
 */
public class CrossCA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        DBWriter dataOutput = new DBWriter();
        System.out.println(dataOutput.outputSetup());
        
        /*
            * Simultaneous Equations with 2 unknowns
        */
        char[] operator = new char[]{'+', '+'};
        double[] result2D;
        double[] x_coeff = new double[]{2, 3};
        double[] y_coeff = new double[]{-3, 8};
        double[] equals = new double[]{2, 3};

        if (y_coeff[0] < 0) {
            operator[0] = '-';
        }
        if (y_coeff[1] < 0) {
            operator[1] = '-';
        }

        System.out.println("Solving simultaneously the equations with 2 variables:");
        //Print as an equation
        System.out.printf("%40s%.2fx %s %.2fy = %.2f%n", "", x_coeff[0],
                operator[0], Math.abs(y_coeff[0]), equals[0]);
        System.out.printf("%40s%.2fx %s %.2fy = %.2f%n", "", x_coeff[1],
                operator[1], Math.abs(y_coeff[1]), equals[1]);
        System.out.printf("%n%30s%n%40s", "Answer:", "(x, y)  =  ");

        try {
            TwoVariables sim2unk;
            sim2unk = new TwoVariables(x_coeff, y_coeff, equals);
            result2D = sim2unk.solveSimultaneous();

            System.out.printf("(%.4f, %.4f)%n", result2D[0], result2D[1]);

        } catch (ArithmeticException e) {
            System.out.printf("(%s, %s)%n", "?", "?");
        }

        System.out.println("\n\n");

        /*
        * Simultaneous Equations with 3 unknowns
         */
        
        int[] x_coefff;
        int[] y_coefff;
        int[] z_coefff;
        int[] equalss;

        char[][] operators = new char[3][2];
        for (char[] op : operators) {
            Arrays.fill(op, '+');
        }

        double[] result3D;
        x_coefff = new int[]{1, 2, 1};
        y_coefff = new int[]{1, 3, -5};
        z_coefff = new int[]{1, 5, 6};
        equalss = new int[]{2, 11, -29};

        for (int i = 0; i < 3; i++) {
            if (y_coefff[i] < 0) {
                operators[i][0] = '-';
            }
            if (z_coefff[i] < 0) {
                operators[i][1] = '-';
            }
        }

        System.out.println("Solving simultaneously the equations with 3 variables:");
        //Print as an equation
        System.out.printf(
                "%40dx %s %dy %s %dz = %d%n", x_coefff[0], operators[0][0],
                Math.abs(y_coefff[0]), operators[0][1], Math.abs(z_coefff[0]), equalss[0]
        );
        System.out.printf(
                "%40dx %s %dy %s %dz = %d%n", x_coefff[1], operators[1][0],
                Math.abs(y_coefff[1]), operators[1][1], Math.abs(z_coefff[1]), equalss[1]
        );
        System.out.printf(
                "%40dx %s %dy %s %dz = %d%n", x_coefff[2], operators[2][0],
                Math.abs(y_coefff[2]), operators[2][1], Math.abs(z_coefff[2]), equalss[2]
        );
        System.out.printf("%n%30s%n%40s", "Answer:", "(x, y, z)  =  ");

        try {
            ThreeVariables sim3unk;
            sim3unk = new ThreeVariables(x_coefff, y_coefff, z_coefff, equalss);
            result3D = sim3unk.solveSimultaneous();

            System.out.printf("(%.4f, %.4f, %.4f)%n", result3D[0], result3D[1], result3D[2]);

        } catch (ArithmeticException e) {
            System.out.printf("(%s, %s, %s)%n", "?", "?", "?");
        }
        System.out.println();
        System.out.println("Getting variables from the user;");
        System.out.println("Getting variables from the user;");

        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();

    }

}
