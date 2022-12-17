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

/**
 *
 * @author deece
 */
public class EquationDB extends ConnectionDB {
    
    public void createEquationTable() {
         try {
            Connection con = DriverManager.getConnection(db_url, db_username, db_password);
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS equation_data("
                    + "username varchar(255), "
                    + "equation varchar(255), "
                    + "solution varchar(255), "
                    + "data date, "
                    + "time datetime);"
            );
            create.execute("USE crossca");
            create.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    
    
}
