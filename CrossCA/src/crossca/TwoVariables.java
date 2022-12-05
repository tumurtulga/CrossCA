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
public class TwoVariables {

    private final int[] xCof;
    private final int[] yCof;
    private final int[] equals;
    private final int[][] eliminator;
    private int xVar;
    private int yVar;

    public TwoVariables() {
        xCof = new int[2];
        yCof = new int[2];
        equals = new int[2];
        eliminator = new int[2][2];

    }

    public TwoVariables(int[] x_coeff, int[] y_coeff, int[] eq) {
        xCof = new int[]{x_coeff[0], x_coeff[1]};
        yCof = new int[]{y_coeff[0], y_coeff[1]};
        equals = new int[]{eq[0], eq[1]};
        eliminator = new int[2][2];
    }

    public TwoVariables(int[] xCof, int[] yCof, int[] equals, int[][] eliminator) {
        this.xCof = xCof;
        this.yCof = yCof;
        this.equals = equals;
        this.eliminator = eliminator;
    }

    public int[] solveSimultaneous() {

        // STEP 2:
        eliminator[0][0] = yCof[1] * xCof[0];
        eliminator[0][1] = yCof[1] * equals[0];
        // STEP 3:
        eliminator[1][0] = yCof[0] * xCof[1];
        eliminator[1][1] = yCof[0] * equals[1];

        try {
            // STEPS 4, 5:
            xVar = (int) (eliminator[0][1] - eliminator[1][1]) / (eliminator[0][0] - eliminator[1][0]);
            // STEP 6:
            yVar = (int) (equals[0] - xCof[0] * xVar) / yCof[0];

        } catch (ArithmeticException e) {
            throw e;
        }

        return new int[]{xVar, yVar};
    }

    public int[] userInput() {

        Scanner sc = new Scanner(System.in);
        
        char[] operator = new char[]{'+', '+'};
        
        for (int i = 0; i <= 1; i++) {
            System.out.println("Enter the value of x" + (i + 1) + ": ");
            int x = sc.nextInt();
            this.xCof[i] = x;
        }
        for (int j = 0; j <= 1; j++) {
            System.out.println("Enter the value of y" + (j + 1) + ": ");
            int x = sc.nextInt();
            this.yCof[j] = x;
        }
        for (int k = 0; k <= 1; k++) {
            System.out.println("Enter the value of constant" + (k + 1) + ": ");
            int x = sc.nextInt();
            this.equals[k] = x;
        }
        
        if (yCof[0] < 0) {
            operator[0] = '-';
        }
        if (yCof[1] < 0) {
            operator[1] = '-';
        }
        
        solveSimultaneous();

        System.out.println("Solving simultaneously equations with 2 variables:");
        System.out.printf("%40dx %s %dy = %d%n", xCof[0], operator[0], Math.abs(yCof[0]), equals[0]);
        System.out.printf("%40dx %s %dy = %d%n", xCof[1], operator[1], Math.abs(yCof[1]), equals[1]);
        System.out.printf("%n%30s%n%40s", "Answer:", "(x, y)  =  ");
        System.out.printf("%d %s %d", xVar, ", ", yVar);
        System.out.println();
        
        return new int[]{xVar, yVar};

    }
    
}
