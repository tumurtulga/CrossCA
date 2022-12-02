/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crossca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rae10
 */

    public class DatabaseWriter {

    String dbName = "crossca";
    String DB_URL = "jdbc:mysql://localhost/" + dbName;
    String USER = "root";
    String PASS = "root";

    public boolean databaseSetup() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", USER, PASS);
            Statement stmt = conn.createStatement();

            stmt.execute("CREATE SCHEMA IF NOT EXISTS " + dbName + ";");
            stmt.execute("USE crossca;");
            /*
                     fullname VARCHAR(30)
                     surname  VARCHAR(30)  
                     username VARCHAR(30)
                     user_id INT
                     usertype VARCHAR(30)
                     usertype_id INT
                     log in/out time
                     user activities VARCHAR(30)
                     tracking id INT
                   
             */
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS userData ("
                    + "fullname VARCHAR(45),"
                    + "surname  VARCHAR(45),"
                    + "username VARCHAR(45),"
                    + "user_id INT(10) NOT NULL PRIMARY KEY,"
                    + "usertype VARCHAR(45),"
                    + "usertype_id INT(10) NOT NULL);"
            );
            
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS usertype ("
                    
                    + "usertype VARCHAR(45),"
                    + "usertype_id INT(10) NOT NULL);"
            );
            
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS tracking ("
                    
                    + "log_in_time DATETIME,"
                    + "log_out_time DATETIME,"
                    + "user_activities VARCHAR(30),"
                    + "tracking_id INT(10) NOT NULL,"
                    + "user_id INT(10) NOT NULL);"   
            );
            return true;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;

    }
}
