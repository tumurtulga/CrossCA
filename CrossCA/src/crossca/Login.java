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
public class Login extends ConnectionDB {

    public void loginUser() throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(db_url, db_username, db_password);
            System.out.println("Enter your username: ");
            String name = sc.next();
            System.out.println("Enter your password: ");
            String pass = sc.next();

            PreparedStatement login = con.prepareStatement("SELECT username, password FROM user_data WHERE "
                    + "username='" + name + "' && password='" + pass + "' UNION SELECT username, password FROM admin_data WHERE "
                    + "username='" + name + "' && password='" + pass + "' ");
            login.execute("USE crossca");

            ResultSet rs = login.executeQuery();

            while (rs.next()) {
                String dbusername = rs.getString("username");
                String dbpassword = rs.getString("password");
                if (name.equals(dbusername) && pass.equals(dbpassword)) {
                    if(dbusername.matches("CCT")) {
                        System.out.println("Admin succesfullly logged-in!\n----");
                        AdminDB ad = new AdminDB();
                        ad.menuAdminChoice();
                    } else {
                        System.out.println("User succesfully logged-in!\n----");
                        UserDB ud = new UserDB();
                        ud.menuUserChoice();
                    }
                } else {
                    System.out.println("Incorrect Username or Password\n----");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
