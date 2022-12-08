/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

import java.util.Scanner;

/**
 *
 * @author deece
 */
public class User {
    
    int id;
    String userName;
    String firstName;
    String lastName;

    public User(int id, String userName, String firstName, String lastName) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        
        Scanner mykb = new Scanner(System.in);
        
        System.out.println("Please enter your userName. ");
        
        userName = mykb.nextLine();
        
        
        
        
        
        
    }
    
    
}
