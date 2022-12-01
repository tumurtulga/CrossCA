/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crossca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rae10
 */
public class DBReader implements DataInputInterface {

    String dbName = "mainca";
    String DB_URL = "jdbc:mysql://localhost/" + dbName;
    String USER = "root";
    String PASS = "root";

    @Override
    public List<User> inputData() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.execute("USE mainca;");

            /*
            name VARCHAR(30)
            id INTEGER PRIMARY KEY
            birth VARCHAR(30)
            admission VARCHAR(30)
            medicalInfo TEXT(1000)
             */
            ResultSet rs = stmt.executeQuery("SELECT * from userData;");
            List<User> userList = new ArrayList<>();
            rs.next();
            rs.next();

//            String name = rs.getString("name");
            int id = rs.getInt("id");
            String userName = rs.getString("username");
            String firstName = rs.getString("firstname");
            String lastName = rs.getString("lastname");

            User p1 = new User(id, userName, firstName, lastName);
            userList.add(p1);

            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
