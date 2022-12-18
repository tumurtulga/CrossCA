/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Mirae Yu
 * @author Tumurtulga Batjargal
 */
public class UserDB extends ConnectionDB {
    
    User user;

    public UserDB(User user) {
        this.user = user;
    }
    
    private static void menuUserList() {
        System.out.println("-------------------------");
        System.out.println("------LOGIN AS AN USER---");
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("1. MODIFY USER");
        System.out.println("2. SOLVE LINEAR EQUATIONS");
        System.out.println("3. LOG-OUT");
        System.out.println("Your choice: ");
    }

    public void menuUserChoice() {
        menuUserList();
        boolean quit = false;
        while (!quit) {
            try {
                Scanner sc = new Scanner(System.in);
                int input = sc.nextInt();
                switch (input) {
                    case 1:
                        modifyUser();
                        break;
                    case 2:
                        solveLinearEquition();
                        break;
                    default:
                        quit = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Bad Input!!! Must be an integer");
            }

        }

    }
    
    private void modifyUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new username: ");
        String name = sc.nextLine();
        System.out.println("Enter new password: ");
        String pass = sc.nextLine();
        System.out.println("Enter new firstname: ");
        String fname = sc.nextLine();
        System.out.println("Enter new lastname");
        String lname = sc.nextLine();
        
        try {
            Connection con = DriverManager.getConnection(db_url, db_username, db_password);
            PreparedStatement modify = con.prepareStatement(""
                    + "UPDATE user_data SET "
                    + "username = '" + name + "'"
                    + "password = '" + pass + "'"
                    + "firstname = '" + fname + "'"
                    + "lastname = '" + lname + "'"
                    + "WHERE id = '" + user.getID() + "'"          
            );
            modify.execute("USE crossca");
            modify.executeUpdate();
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void createUserTable() throws ClassNotFoundException {
        try {
            Connection con = DriverManager.getConnection(db_url, db_username, db_password);
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS user_data ("
                    + "id int NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                    + "username varchar(255), "
                    + "password varchar(255),"
                    + "firstname varchar(255),"
                    + "lastname varchar(255));"
            );
            create.execute("USE crossca");
            create.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

}
