/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

import java.util.Arrays;
import java.util.List;

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
        eliminator = new int[2][2];
    }
    
    

    public ThreeVariables(int[] x_coeff, int[] y_coeff, int[] z_coeff, int[] eq) {
        xCof = new int[]{x_coeff[0], x_coeff[1], x_coeff[2]};
        yCof = new int[]{y_coeff[0], y_coeff[1], y_coeff[2]};
        zCof = new int[]{z_coeff[0], z_coeff[1], z_coeff[2]};
        equals = new int[]{eq[0], eq[1], eq[2]};
        eliminator = new int[3][3];
    }
    
    public int[] solveSimultaneous() {
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
}
