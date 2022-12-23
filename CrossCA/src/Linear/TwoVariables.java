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

public class TwoVariables {

    private final double[] xCof;
    private final double[] yCof;
    private final double[] equals;
    private final double[][] eliminator;
    private List<String> equations;
    private double x_variable;
    private double y_variable;

    public TwoVariables(String input) {
        equations = Arrays.asList(input.split(", "));
        equations.replaceAll(String::trim);
        equations.replaceAll(s -> s.replaceAll(" ", ""));
        xCof = new double[2];
        yCof = new double[2];
        equals = new double[2];
        eliminator = new double[2][2];
    }

    public TwoVariables(double[] xCoff, double[] yCoff, double[] eq) {
        xCof = new double[]{xCoff[0], xCoff[1]};
        yCof = new double[]{yCoff[0], yCoff[1]};
        equals = new double[]{eq[0], eq[1]};
        eliminator = new double[2][2];
    }

//    public TwoVariables(double[] xCof, double[] yCof, double[] equals, double[][] eliminator) {
//        this.xCof = xCof;
//        this.yCof = yCof;
//        this.equals = equals;
//        this.eliminator = eliminator;
//    }

    public double[] solveTwo() {

        double xVar = 0;
        double yVar = 0;
        String splitter = "";

        splitter = equations.get(0).split("x")[0];
        splitter = identifier(splitter);
        xCof[0] = Double.parseDouble(splitter);

        splitter = equations.get(0).split("x")[1].split("y")[0];
        splitter = identifier(splitter);
        yCof[0] = Double.parseDouble(splitter);

        splitter = equations.get(1).split("x")[0];
        splitter = identifier(splitter);
        xCof[1] = Double.parseDouble(splitter);

        splitter = equations.get(1).split("x")[1].split("y")[0];
        splitter = identifier(splitter);
        yCof[1] = Double.parseDouble(splitter);

        String t1 = equations.get(0).split("x")[1].split("y")[1].split("=")[0];
        double t2 = Double.parseDouble(equations.get(0).split("x")[1].split("y")[1].split("=")[1]);

        double k1 = 0;
        double k2 = 0;
        if (t2 == 0 && t1.length() > 0) {
            equals[0] = -Double.parseDouble(equations.get(0).split("=")[1]);
            equals[1] = -Double.parseDouble(equations.get(1).split("=")[1]);
        } else {
            equals[0] = Double.parseDouble(equations.get(0).split("=")[1]);
            equals[1] = Double.parseDouble(equations.get(1).split("=")[1]);
        }

        eliminator[0][0] = yCof[1] * xCof[0];
        eliminator[0][1] = yCof[1] * equals[0];

        eliminator[1][0] = yCof[0] * xCof[1];
        eliminator[1][1] = yCof[0] * equals[1];

        xVar = (eliminator[0][1] - eliminator[1][1]) / (eliminator[0][0] - eliminator[1][0]);
        yVar = (equals[0] - xCof[0] * xVar) / yCof[0];

        return new double[]{xVar, yVar};

    }
    
    public double[] solve(){
        
        eliminator[0][0] = yCof[1] * xCof[0];
        eliminator[0][1] = yCof[1] * equals[0];

        eliminator[1][0] = yCof[0] * xCof[1];
        eliminator[1][1] = yCof[0] * equals[1];

        x_variable = (eliminator[0][1] - eliminator[1][1]) / (eliminator[0][0] - eliminator[1][0]);
        y_variable = (equals[0] - xCof[0] * x_variable) / yCof[0];

        return new double[]{x_variable, y_variable};
    }
    
    public String identifier (String str) {
        if (str.equals("") || str.equals("+")) {
            return "1";
        } else if (str.equals("-")) {
            return "-1";
        } else {
            return str;
        }

    }

}
