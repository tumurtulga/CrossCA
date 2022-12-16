/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

import static crossca.AdminDB.getConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Mirae Yu
 * @author Tumurtulga Batjargal
 */
public class UserDB {

    public void loginUser() throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        String dbusername = "";
        String dbpassword = "";
        try {
            System.out.println("Enter your username: ");
            String name = sc.next();
            System.out.println("Enter your password: ");
            String pass = sc.next();

            Connection con = getConnection();

            PreparedStatement login = con.prepareStatement("SELECT * FROM user_data WHERE "
                    + "username='" + name + "' && password='" + pass + "'");
            login.execute("USE crossca");

            ResultSet rs = login.executeQuery();

            while (rs.next()) {
                dbusername = rs.getString("username");
                dbpassword = rs.getString("password");
                if (name.equals(dbusername) && pass.equals(dbpassword)) {
                    System.out.println("Succesful Login!\n----");
                    System.out.println("-------------------------");
                    System.out.println("------LOGIN AS AN USER---");
                    System.out.println("-------------------------");
                    System.out.println();
                    System.out.println("1. MODIFY USER");
                    System.out.println("2. SOLVE LINEAR EQUATIONS");
                    System.out.println("3. LOG-OUT");
                    System.out.println("Your choice: ");
                    int input = sc.nextInt();
                    switch (input) {
                        case 1:
                            System.out.println(login.execute());
                            break;
                        case 2:
                          
                            break;
                        default:
                            
                            break;

                    }

                } else {
                    System.out.println("Incorrect Username or Password\n----");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void modifyUser() throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        String dbusername = "";
        String dbpassword = "";
        String dbfirstname = "";
        String dblastname = "";
        try {
            Connection con = getConnection();
            PreparedStatement show = con.prepareStatement("SELECT * FROM user_data WHERE username= '" + name + "'");
        }

    }

    public void insertUser() throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        String dbusername = "";
        try {
            Connection con = getConnection();
            System.out.println("Enter your username: ");
            String name = sc.next();
            PreparedStatement check = con.prepareStatement("SELECT username FROM user_data WHERE "
                    + "username= '" + name + "'");
            check.execute("USE crossca");
            ResultSet rs = check.executeQuery();
            while (rs.next()) {
                dbusername = rs.getString("username");
            }
            if (name.equals(dbusername)) {
                System.out.println("User already exists\n----");
            } else {
                System.out.println("Enter your password: ");
                String pass = sc.next();
                System.out.println("Enter your firstname: ");
                String fname = sc.next();
                System.out.println("Enter your lastname: ");
                String lname = sc.next();
                PreparedStatement insert = con.prepareStatement("INSERT INTO user_data ("
                        + "username, password, firstname, lastname) VALUES ("
                        + "'" + name + "', '" + pass + "', '" + fname + "', '" + lname + "');");
                insert.execute("USE crossca");
                insert.executeUpdate();
                System.out.println("User successfully created\n----");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public void createUserTable() throws ClassNotFoundException {
        try {
            Connection con = getConnection();
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

    public static Connection getConnection() throws ClassNotFoundException {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String db_url = "jdbc:mysql://localhost/";
            String db_username = "root";
            String db_password = "root";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);

            return conn;

        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }
    }

    private static void menuUser() {
        
        
        
        
    }

    public void menuUserChoice() {
        menuUser();

    }
}
