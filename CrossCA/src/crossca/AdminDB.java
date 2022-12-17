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
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author Mirae Yu
 * @author Tumurtulga Batjargal
 */
public class AdminDB extends DBConnection {

    public void deleteUser() throws ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        String dbusername = "";
        System.out.println("Enter your username: ");
        String name = sc.next();
        try {
            Connection con = DriverManager.getConnection(db_url, db_username, db_password);
            if (name.equals(dbusername)) {
                PreparedStatement delete = con.prepareStatement("DELETE FROM user_data WHERE username = '" + name + "' ");
                delete.execute("USE crossca");
                delete.executeUpdate();
            } else {
                System.out.println("User does not exist");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void userList() throws ClassNotFoundException {
        try {
            Connection con = DriverManager.getConnection(db_url, db_username, db_password);
            PreparedStatement list = con.prepareStatement("SELECT * FROM user_data");
            list.execute("USE crossca");
            ResultSet rs = list.executeQuery();
            while (rs.next()) {
                String dbusername = rs.getString("username");
                String dbpassword = rs.getString("password");
                String dbfirstname = rs.getString("firstname");
                String dblastname = rs.getString("lastname");

                System.out.format("| %-15s | %-15s | %-15s | %-15s |%n", dbusername, dbpassword, dbfirstname, dblastname);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loginAdmin() throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        String dbusername = "";
        String dbpassword = "";
        try {
            Connection con = DriverManager.getConnection(db_url, db_username, db_password);
            System.out.println("Enter your username: ");
            String name = sc.next();
            System.out.println("Enter your password: ");
            String pass = sc.next();

            PreparedStatement login = con.prepareStatement("SELECT * FROM admin_data WHERE "
                    + "username='" + name + "' && password='" + pass + "'");
            login.execute("USE crossca");

            ResultSet rs = login.executeQuery();

            while (rs.next()) {
                dbusername = rs.getString("username");
                dbpassword = rs.getString("password");
            }

            if (name.equals(dbusername) && pass.equals(dbpassword)) {
                System.out.println("Succesful Login!\n----");
                menuAdminChoice();
            } else {
                System.out.println("Incorrect Username or Password\n----");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void insertAdminData() throws ClassNotFoundException {
        String username = "CCT";
        String password = "Dublin";
        try {
            Connection con = DriverManager.getConnection(db_url, db_username, db_password);
            PreparedStatement insert = con.prepareStatement("INSERT INTO admin_data (username, password) VALUES ("
                    + "'" + username + "', '" + password + "')");
            insert.execute("USE crossca");
            insert.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public void createAdminTable() throws ClassNotFoundException {
        try {
            Connection con = DriverManager.getConnection(db_url, db_username, db_password);
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS admin_data ("
                    + "id int NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                    + "username varchar(255), "
                    + "password varchar(255)); "
            );
            create.execute("USE crossca");
            create.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private static void menuAdminList() {
        System.out.println("-------------------------");
        System.out.println("------LOGIN AS AN ADMIN--");
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("1. CREATE USER");
        System.out.println("2. MODIFY USER");
        System.out.println("3. ACCESS USER LIST");
        System.out.println("4. REMOVE USER");
        System.out.println("5. LOG-OUT");
        System.out.println("Your choice: ");

    }

    public void menuAdminChoice() throws ClassNotFoundException {
        menuAdminList();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                userList();
                break;
            case 4:
                deleteUser();
                break;
            default:
                break;

        }

    }

}
