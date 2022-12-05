z/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

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
    float[][] M = new float[xVar][yVar];

    public TwoVariables() {
        this.xCof = new int[]{};
        this.yCof = new int[]{};
        this.equals = new int[]{};
        this.eliminator = new int[][]{};
         
    }
      
    public TwoVariables(int[] x_coeff, int[] y_coeff, int[] eq) {
        xCof = new int[]{x_coeff[0], x_coeff[1]};
        yCof = new int[]{y_coeff[0], y_coeff[1]};
        equals = new int[]{eq[0], eq[1]};
        eliminator = new int[2][2];
    }

//    public TwoVariables(int[] xCof, int[] yCof, int[] equals, int[][] eliminator) {
//        this.xCof = xCof;
//        this.yCof = yCof;
//        this.equals = equals;
//        this.eliminator = eliminator;
//    }

    public void solveSimultaneous() {
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i <= xCof.length; i++) {
            xCof[i]=sc.nextInt();
            
            System.out.println("asd: " + xCof[i]);
            
        
//        System.out.println("Enter the x1 values: ");
//        xCof[0] = sc.nextInt();
//        System.out.println("Enter the y1 values: ");
//        yCof[0] = sc.nextInt();
//        System.out.println("Enter the x2 values: ");
//        xCof[1] = sc.nextInt();
//        System.out.println("Enter the x2 values: ");
//        yCof[1] = sc.nextInt();
//        
        
//        yCof[1] = sc.nextInt();
//        for(int i = 0; i < this.xCof.length; i++){
//            for(int j = 0; j < this.yCof.length; j++) {
//            }
//            
//        }
        
        
        
//        yCof[1] = sc.nextInt();
//        System.out.println("Enter the equals values: ");
//        equals[0] = sc.nextInt();
//        equals[1] = sc.nextInt();
                
        // STEP 2:
        eliminator[0][0] = yCof[1] * xCof[0];
        
            System.out.println("el; " + eliminator[0][0]);
        eliminator[0][1] = yCof[1] * equals[0];
        // STEP 3:
        eliminator[1][0] = yCof[0] * xCof[1];
        eliminator[1][1] = yCof[0] * equals[1];

        try {
            // STEPS 4, 5:
            xVar = (int) (eliminator[0][1] - eliminator[1][1]) / (eliminator[0][0] - eliminator[1][0]);
            // STEP 6:
            yVar = (int) (equals[0] - xCof[0] * xVar) / yCof[0];
            
//            result = int[]{xVar, yVar};
        } catch (ArithmeticException e) {
            throw e;
        }
//        return new int[]{xVar, yVar};
    }

}
