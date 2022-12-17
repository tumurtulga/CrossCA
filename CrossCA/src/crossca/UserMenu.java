/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author deece
 */
public class UserMenu {

    public void userMenuFunction() {

        boolean quit = false;
        while (!quit) {
            try {
                Scanner sc = new Scanner(System.in);
                userMenuList();
                int input = sc.nextInt();
                switch (input) {
                    case 1:
                        modifyUser();
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Bad Input!!! Must be an integer");
            }

        }
    }

    public void userMenuList() {
        System.out.println("-------------------------");
        System.out.println("------LOGIN AS AN USER---");
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("1. MODIFY USER");
        System.out.println("2. SOLVE LINEAR EQUATIONS");
        System.out.println("3. LOG-OUT");
        System.out.println("Your choice: ");
    }

    private void modifyUser() {
        
    }
    

}
