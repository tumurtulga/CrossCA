/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author deece
 */
public class ThreeVariables {

    private final int[] xCof;
    private final int[] yCof;
    private final int[] zCof;
    private final int[] equals;
    private final int[][] eliminator;
    private int xVar;
    private int yVar;
    private int zVar;

    public ThreeVariables() {
        xCof = new int[3];
        yCof = new int[3];
        zCof = new int[3];
        equals = new int[3];
        eliminator = new int[3][3];
    }

    public ThreeVariables(int[] x_coeff, int[] y_coeff, int[] z_coeff, int[] eq) {
        xCof = new int[]{x_coeff[0], x_coeff[1], x_coeff[2]};
        yCof = new int[]{y_coeff[0], y_coeff[1], y_coeff[2]};
        zCof = new int[]{z_coeff[0], z_coeff[1], z_coeff[2]};
        equals = new int[]{eq[0], eq[1], eq[2]};
        eliminator = new int[3][3];
    }

    public int[] solve3Simultaneous() {
        List<Integer> stooge;
        stooge = Arrays.asList(
                Math.abs(zCof[0]),
                Math.abs(zCof[1]),
                Math.abs(zCof[2])
        );

        Function l_c_m = new Function(stooge);
        int lcm = l_c_m.getLCM();

        // STEP 1:
        eliminator[0][0] = (lcm * xCof[0]) / zCof[0];
        eliminator[0][1] = (lcm * yCof[0]) / zCof[0];
        eliminator[0][2] = (lcm * equals[0]) / zCof[0];

        eliminator[1][0] = (lcm * xCof[1]) / zCof[1];
        eliminator[1][1] = (lcm * yCof[1]) / zCof[1];
        eliminator[1][2] = (lcm * equals[1]) / zCof[1];

        eliminator[2][0] = (lcm * xCof[2]) / zCof[2];
        eliminator[2][1] = (lcm * yCof[2]) / zCof[2];
        eliminator[2][2] = (lcm * equals[2]) / zCof[2];

        // STEP 2:
        int[] new_x = {
            eliminator[0][0] - eliminator[1][0],
            eliminator[1][0] - eliminator[2][0]
        };
        int[] new_y = {
            eliminator[0][1] - eliminator[1][1],
            eliminator[1][1] - eliminator[2][1]
        };
        int[] new_eq = {
            eliminator[0][2] - eliminator[1][2],
            eliminator[1][2] - eliminator[2][2]
        };

        try {
            // STEP 3:
            int[] partial_solution;
            partial_solution = (new TwoVariables(new_x, new_y, new_eq)).solveSimultaneous();

            xVar = partial_solution[0];
            yVar = partial_solution[1];
            // STEP 4:
            zVar = (int) (equals[0] - xCof[0] * xVar - yCof[0] * yVar) / zCof[0];
            
        } catch (ArithmeticException e) {
            throw e;
        }
        return new int[]{xVar, yVar, zVar};
        
    }

    public int[] userInput() {

        Scanner sc = new Scanner(System.in);
        char[][] operators = new char[3][2];
        for (char[] op : operators) {
            Arrays.fill(op, '+');
        }

        for (int i = 0; i <= 2; i++) {
            System.out.println("Enter the value of x" + (i + 1) + ": ");
            int x = sc.nextInt();
            this.xCof[i] = x;
        }
        for (int j = 0; j <= 2; j++) {
            System.out.println("Enter the value of y" + (j + 1) + ": ");
            int x = sc.nextInt();
            this.yCof[j] = x;
        }
        for (int z = 0; z <= 2; z++) {
            System.out.println("Enter the value of z" + (z + 1) + ": ");
            int x = sc.nextInt();
            this.zCof[z] = x;
        }
        for (int k = 0; k <= 2; k++) {
            System.out.println("Enter the value of constant" + (k + 1) + ": ");
            int x = sc.nextInt();
            this.equals[k] = x;
        }
        
        for (int i = 0; i < 3; i++) {
            if (yCof[i] < 0) {
                operators[i][0] = '-';
            }
            if (zCof[i] < 0) {
                operators[i][1] = '-';
            }
        }
        
        solve3Simultaneous();

        System.out.println("Solving simultaneously the equations with 3 variables:");
        System.out.printf("%40dx %s %dy %s %dz = %d%n", xCof[0], operators[0][0], Math.abs(yCof[0]), operators[0][1], Math.abs(zCof[0]), equals[0]);
        System.out.printf("%40dx %s %dy %s %dz = %d%n", xCof[1], operators[1][0], Math.abs(yCof[1]), operators[1][1], Math.abs(zCof[1]), equals[1]);
        System.out.printf("%40dx %s %dy %s %dz = %d%n", xCof[2], operators[2][0], Math.abs(yCof[2]), operators[2][1], Math.abs(zCof[2]), equals[2]);
        System.out.printf("%n%30s%n%40s", "Answer:", "(x, y, z)  =  ");
        System.out.printf("%d %s %d %s %d", xVar, ", ", yVar, ", ", zVar);
        System.out.println();
        
        return new int[]{xVar, yVar, zVar};
    }
}
