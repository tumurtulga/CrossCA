/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crossca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mirae Yu 
 * @author Tumurtulga Batjargal
 */
public class DBReader implements DataInputInterface {

    String db_name = "crossca";
    String db_url = "jdbc:mysql://localhost/" + db_name;
    String db_username = "root";
    String db_password = "root";

    @Override
    public ArrayList<String> inputData() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        try {
            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
            PreparedStatement statement = conn.prepareStatement("SELECT username, firstname, lastname FROM userdata");
            ResultSet result = statement.executeQuery();
            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                System.out.print(result.getString("firstname"));
                System.out.print(" ");
                System.out.println(result.getString("lastname"));
                
                array.add(result.getString("lastname"));
            }
       
            return array;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
