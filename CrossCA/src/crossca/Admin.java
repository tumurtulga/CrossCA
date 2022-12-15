/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Mirae Yu
 * @author Tumurtulga Batjargal
 */
public class Admin {
    
    public void loginAdmin() {
        try {
            Connection con = getConnection();
            PreparedStatement insert = con.prepareStatement("INSERT INTO admin_data (username, password) VALUES ('"+username+"', '"+password+"')");
            insert.execute("USE crossca");
            insert.executeUpdate();
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();

        }
        System.out.println("Enter your username: ");
        System.out.println("Enter your password: ");
    }
    
    public void insertAdmin() throws ClassNotFoundException{
        final String username = "CCT";
        final String password = "Dublin";
        try {
            Connection con = getConnection();
            PreparedStatement insert = con.prepareStatement("INSERT INTO admin_data (username, password) VALUES ('"+username+"', '"+password+"')");
            insert.execute("USE crossca");
            insert.executeUpdate();
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();

        }
        
    }
        
    

    public void createAdmin() throws ClassNotFoundException {
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

    public void AdminMenu(int input) {
        switch (input) {
            case 1:
                System.out.println("Access an user list");
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;

        }

    }

}
