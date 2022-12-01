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
public class DBWriter implements DataOutputInterface {

    String dbName = "mainca";
    String DB_URL = "jdbc:mysql://localhost/" + dbName;
    String USER = "root";
    String PASS = "root";

    @Override
    public boolean outputSetup() throws ClassNotFoundException, InstantiationException, IllegalAccessException{

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        try {

            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            System.out.println("CREATE SCHEME IF NOT EXISTS " + dbName + ";");
            stmt.execute("CREATE SCHEMA IF NOT EXISTS " + dbName + ";");
            stmt.execute("USE mainca;");
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
                    "CREATE TABLE IF NOT EXISTS maincaData ("
                    + "fullname VARCHAR(45),"
                    + "surname  VARCHAR(45),"
                    + "username VARCHAR(45),"
                    + "user_id INT(10) NOT NULL PRIMARY KEY);"
            //+ "usertype VARCHAR(45),"
            //+ "usertype_id INT,"
            );

            /*stmt.execute(
                    "CREATE TABLE IF NOT EXISTS userData ("
                    
                    + "usertype VARCHAR(45),"
                    + "usertype_id INT,"
            );*/
            return true;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean outputData(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.execute("USE mainca;");

            stmt.execute(
                    String.format("INSERT INTO userData (id, username, firstname, lastname) "
                            + "VALUES (\"%s\", %d, \"%s\", \"%s\", \"%s\") ;",
                            user.id, user.userName, user.firstName, user.lastName)
            );
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
