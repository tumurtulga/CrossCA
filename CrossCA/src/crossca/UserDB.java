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
import java.util.Scanner;

/**
 * @author Mirae Yu
 * @author Tumurtulga Batjargal
 */
public class UserDB extends ConnectionDB {

    public void loginUser() throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        String dbusername = "";
        String dbpassword = "";
        
        try {
            Connection con = DriverManager.getConnection(db_url, db_username, db_password);
            System.out.println("Enter your username: ");
            String name = sc.next();
            System.out.println("Enter your password: ");
            String pass = sc.next();

            PreparedStatement login = con.prepareStatement("SELECT * FROM user_data WHERE "
                    + "username='" + name + "' && password='" + pass + "'");
            login.execute("USE crossca");

            ResultSet rs = login.executeQuery();

            while (rs.next()) {
                dbusername = rs.getString("username");
                dbpassword = rs.getString("password");
                if (name.equals(dbusername) && pass.equals(dbpassword)) {
                    System.out.println("Succesful Login!\n----");
                  
                } else {
                    System.out.println("Incorrect Username or Password\n----");
                }
            }

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
