/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

import Database.Login;

/**
 * @author Mirae Yu
 * @author Tumurtulga Batjargal
 */
public class CrossCA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {

        /*
        2x −3y −2 = 0
        3x + 8y −3 = 0
        
        x+y+z= 2
        2x + 3y + 5z = 11 
        x − 5y + 6z = 29
         */
        Login lg = new Login();
        lg.login();
    }
}
