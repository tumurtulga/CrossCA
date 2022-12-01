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

    private final int[] x_Cof;
    private final int[] y_Cof;
    private final int[] z_Cof;
    private final int[] equals;
    private final double[][] eliminator;
    private double x_Var;
    private double y_Var;
    private double z_Var;

    public ThreeVariables(int[] x_coeff, int[] y_coeff, int[] z_coeff, int[] eq) {
        x_Cof = new int[]{x_coeff[0], x_coeff[1], x_coeff[2]};
        y_Cof = new int[]{y_coeff[0], y_coeff[1], y_coeff[2]};
        z_Cof = new int[]{z_coeff[0], z_coeff[1], z_coeff[2]};
        equals = new int[]{eq[0], eq[1], eq[2]};
        eliminator = new double[3][3];
    }

    public double[] solveSimultaneous() {
        List<Integer> stooge;
        stooge = Arrays.asList(
                Math.abs(z_Cof[0]),
                Math.abs(z_Cof[1]),
                Math.abs(z_Cof[2])
        );

        Function l_c_m = new Function(stooge);
        int lcm = l_c_m.getLCM();

        // STEP 1:
        eliminator[0][0] = (lcm * x_Cof[0]) / z_Cof[0];
        eliminator[0][1] = (lcm * y_Cof[0]) / z_Cof[0];
        eliminator[0][2] = (lcm * equals[0]) / z_Cof[0];

        eliminator[1][0] = (lcm * x_Cof[1]) / z_Cof[1];
        eliminator[1][1] = (lcm * y_Cof[1]) / z_Cof[1];
        eliminator[1][2] = (lcm * equals[1]) / z_Cof[1];

        eliminator[2][0] = (lcm * x_Cof[2]) / z_Cof[2];
        eliminator[2][1] = (lcm * y_Cof[2]) / z_Cof[2];
        eliminator[2][2] = (lcm * equals[2]) / z_Cof[2];

        // STEP 2:
        double[] new_x = {
            eliminator[0][0] - eliminator[1][0],
            eliminator[1][0] - eliminator[2][0]
        };
        double[] new_y = {
            eliminator[0][1] - eliminator[1][1],
            eliminator[1][1] - eliminator[2][1]
        };
        double[] new_eq = {
            eliminator[0][2] - eliminator[1][2],
            eliminator[1][2] - eliminator[2][2]
        };

        try {
            // STEP 3:
            double[] partial_solution;
            partial_solution = (new TwoVariables(new_x, new_y, new_eq)).solveSimultaneous();

            x_Var = partial_solution[0];
            y_Var = partial_solution[1];
            // STEP 4:
            z_Var = (double) (equals[0] - x_Cof[0] * x_Var - y_Cof[0] * y_Var) / z_Cof[0];
        } catch (ArithmeticException e) {
            throw e;
        }
        return new double[]{x_Var, y_Var, z_Var};
    }
}
