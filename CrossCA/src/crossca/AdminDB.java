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
public class AdminDB {

    public void loginAdmin() throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        String dbusername = "";
        String dbpassword = "";
        try {
            System.out.println("Enter your username: ");
            String name = sc.next();
            System.out.println("Enter your password: ");
            String pass = sc.next();

            Connection con = getConnection();

            PreparedStatement login = con.prepareStatement("SELECT * FROM admin_data WHERE "
                    + "username='" + name + "' && password='" + pass + "'");
            login.execute("USE crossca");

            ResultSet rs = login.executeQuery();

            while (rs.next()) {
                dbusername = rs.getString("username");
                dbpassword = rs.getString("password");

                if (name.equals(dbusername) && pass.equals(dbpassword)) {
                    System.out.println("Succesful Login!\n----");
                    menuAdminChoice();
                } else {
                    System.out.println("Incorrect Username or Password\n----");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void insertAdminData() throws ClassNotFoundException {
        String username = "CCT";
        String password = "Dublin";
        try {
            Connection con = getConnection();
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
            Connection con = getConnection();
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

    private static void menuAdmin() {
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

    public void menuAdminChoice() {
        menuAdmin();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;

        }

    }

}
