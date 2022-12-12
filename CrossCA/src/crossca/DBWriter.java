/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crossca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public boolean outputSetup() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

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
    public boolean outputData(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        try {
            String q = "INSERT into table1(username, password, fullname, lastname) values (?, ?, ?, ?)";
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(q);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter username : ");
            String username = br.readLine();

            System.out.println("Enter password : ");
            String password = br.readLine();

            System.out.println("Enter firstname : ");
            String firstname = br.readLine();

            System.out.println("Enter lastname : ");
            String lastname = br.readLine();

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, firstname);
            stmt.setString(4, lastname);

            stmt.executeUpdate();

            stmt.execute(
                    String.format("INSERT INTO userData (id, username, firstname, lastname) "
                            + "VALUES (\"%s\", %d, \"%s\", \"%s\", \"%s\") ;",
                            user.id, user.userName, user.firstName, user.lastName)
            );
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
