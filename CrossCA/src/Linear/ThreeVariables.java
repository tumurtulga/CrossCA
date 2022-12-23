/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Linear;

import java.util.Arrays;
import java.util.List;

/**
 * @author Mirae Yu
 * @author Tumurtulga Batjargal
 */
public class ThreeVariables {

    private final double[] xCof;
    private final double[] yCof;
    private final double[] zCof;
    private final double[] equals;
    private final double[][] eliminator;
    private List<String> equations;

    public ThreeVariables(String input) {
        equations = Arrays.asList(input.split(", "));
        equations.replaceAll(String::trim);
        equations.replaceAll(s -> s.replaceAll(" ", ""));
        xCof = new double[3];
        yCof = new double[3];
        zCof = new double[3];
        equals = new double[3];
        eliminator = new double[3][3];
    }

    public ThreeVariables(double[] x_coeff, double[] y_coeff, double[] z_coeff, double[] eq) {
        xCof = new double[]{x_coeff[0], x_coeff[1], x_coeff[2]};
        yCof = new double[]{y_coeff[0], y_coeff[1], y_coeff[2]};
        zCof = new double[]{z_coeff[0], z_coeff[1], z_coeff[2]};
        equals = new double[]{eq[0], eq[1], eq[2]};
        eliminator = new double[3][3];
    }

    public double[] solveThree() {

        double xVar = 0;
        double yVar = 0;
        double zVar = 0;
        String splitter = "";

        splitter = equations.get(0).split("x")[0];
        splitter = identifier(splitter);
        xCof[0] = Double.parseDouble(splitter);

        splitter = equations.get(0).split("x")[1].split("y")[0];
        splitter = identifier(splitter);
        yCof[0] = Double.parseDouble(splitter);

        splitter = equations.get(0).split("x")[1].split("y")[1].split("z")[0];
        splitter = identifier(splitter);
        zCof[0] = Double.parseDouble(splitter);

        splitter = equations.get(1).split("x")[0];
        splitter = identifier(splitter);
        xCof[1] = Double.parseDouble(splitter);

        splitter = equations.get(1).split("x")[1].split("y")[0];
        splitter = identifier(splitter);
        yCof[1] = Double.parseDouble(splitter);

        splitter = equations.get(1).split("x")[1].split("y")[1].split("z")[0];
        splitter = identifier(splitter);
        zCof[1] = Double.parseDouble(splitter);

        splitter = equations.get(2).split("x")[0];
        splitter = identifier(splitter);
        xCof[2] = Double.parseDouble(splitter);

        splitter = equations.get(2).split("x")[1].split("y")[0];
        splitter = identifier(splitter);
        yCof[2] = Double.parseDouble(splitter);

        splitter = equations.get(2).split("x")[1].split("y")[1].split("z")[0];
        splitter = identifier(splitter);
        zCof[2] = Double.parseDouble(splitter);

        splitter = equations.get(0).split("=")[1];
        splitter = identifier(splitter);
        equals[0] = Double.parseDouble(splitter);

        splitter = equations.get(1).split("=")[1];
        splitter = identifier(splitter);
        equals[1] = Double.parseDouble(splitter);

        splitter = equations.get(2).split("=")[1];
        splitter = identifier(splitter);
        equals[2] = Double.parseDouble(splitter);
        
        List<Double> stooge;
        stooge = Arrays.asList(Math.abs(zCof[0]), Math.abs(zCof[1]), Math.abs(zCof[2]));

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
            partial_solution = (new TwoVariables(new_x, new_y, new_eq)).solve();

            xVar = partial_solution[0];
            yVar = partial_solution[1];
            // STEP 4:
            zVar = (int) (equals[0] - xCof[0] * xVar - yCof[0] * yVar) / zCof[0];

        } catch (ArithmeticException e) {
            throw e;
        }
        return new double[]{xVar, yVar, zVar};

    }

    public String identifier(String str) {
        if (str.equals("") || str.equals("+")) {
            return "1";
        } else if (str.equals("-")) {
            return "-1";
        } else {
            return str;
        }
    }
}
