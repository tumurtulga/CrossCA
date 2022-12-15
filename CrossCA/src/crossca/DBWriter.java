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
 * @author Mirae Yu 
 * @author Tumurtulga Batjargal
 */
public class DBWriter implements DataOutputInterface {

    String db_name = "crossca";
    String db_url = "jdbc:mysql://localhost/";
    String db_username = "root";
    String db_password = "root";

    @Override
    public boolean outputSetup() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        try {

            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);

            Statement create = conn.createStatement();
            create.execute("CREATE SCHEMA IF NOT EXISTS " + db_name + ";");
            create.execute("USE crossca");

            create.execute(
                    "CREATE TABLE IF NOT EXISTS user_data ("
                    + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                    + "username varchar(254),"
                    + "password varchar(254),"
                    + "fullname varchar(254),"
                    + "lastname varchar(254));"
            );
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
