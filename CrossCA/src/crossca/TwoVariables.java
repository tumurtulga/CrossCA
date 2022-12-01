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

    private final int[] x_Cof;
    private final int[] y_Cof;
    private final int[] equals;
    private final int[][] eliminator;
    private int x_Var;
    private int y_Var;

    public TwoVariables(int[] x_coeff, int[] y_coeff, int[] eq) {
        x_Cof = new int[]{x_coeff[0], x_coeff[1]};
        y_Cof = new int[]{y_coeff[0], y_coeff[1]};
        equals = new int[]{eq[0], eq[1]};
        eliminator = new int[2][2];
    }

    public int[] solveSimultaneous() {
        // STEP 2:
        eliminator[0][0] = y_Cof[1] * x_Cof[0];
        eliminator[0][1] = y_Cof[1] * equals[0];
        // STEP 3:
        eliminator[1][0] = y_Cof[0] * x_Cof[1];
        eliminator[1][1] = y_Cof[0] * equals[1];

        try {
            // STEPS 4, 5:
            x_Var = (int) (eliminator[0][1] - eliminator[1][1]) / (eliminator[0][0] - eliminator[1][0]);
            // STEP 6:
            y_Var = (int) (equals[0] - x_Cof[0] * x_Var) / y_Cof[0];
        } catch (ArithmeticException e) {
            throw e;
        }
        return new int[]{x_Var, x_Var};
    }

}
