/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

/**
 *
 * @author deece
 */
public class TwoVariables {

    private final double[] x_Cof;
    private final double[] y_Cof;
    private final double[] equals;
    private final double[][] eliminator;
    private double x_Var;
    private double y_Var;

    public TwoVariables(double[] x_coeff, double[] y_coeff, double[] eq) {
        x_Cof = new double[]{x_coeff[0], x_coeff[1]};
        y_Cof = new double[]{y_coeff[0], y_coeff[1]};
        equals = new double[]{eq[0], eq[1]};
        eliminator = new double[2][2];
    }

    public double[] solveSimultaneous() {
        // STEP 2:
        eliminator[0][0] = y_Cof[1] * x_Cof[0];
        eliminator[0][1] = y_Cof[1] * equals[0];
        // STEP 3:
        eliminator[1][0] = y_Cof[0] * x_Cof[1];
        eliminator[1][1] = y_Cof[0] * equals[1];

        try {
            // STEPS 4, 5:
            x_Var = (double) (eliminator[0][1] - eliminator[1][1]) / (eliminator[0][0] - eliminator[1][0]);
            // STEP 6:
            y_Var = (double) (equals[0] - x_Cof[0] * x_Var) / y_Cof[0];
        } catch (ArithmeticException e) {
            throw e;
        }
        return new double[]{x_Var, y_Var};
    }

}
