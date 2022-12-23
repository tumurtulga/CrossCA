/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 * @author Mirae Yu
 * @author Tumurtulga Batjargal
 */

public class Equation {
    
    int id;
    String equation;
    String solution;
    User user;
    Date date;

    public Equation(int id, String equation, String solution, User user, Date date) {
        this.id = id;
        this.equation = equation;
        this.solution = solution;
        this.user = user;
        this.date = date;
    }
    
}
