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
 *
 * @author deece
 */
public class Registration extends DBConnection {

    public void registerUser() {
        Scanner sc = new Scanner(System.in);
        String dbusername = "";
        try {
            Connection con = DriverManager.getConnection(db_url, db_username, db_password);
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

}
