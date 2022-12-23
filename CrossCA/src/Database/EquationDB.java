/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Mirae Yu
 * @author Tumurtulga Batjargal
 */

public class EquationDB extends ConnectionDB {

    /*
    creating a table in sql dabatase
    Once table is created, this is not necessarily needed.
     */
    
    public void createEquationTable() {
        try {
            Connection con = DriverManager.getConnection(db_url, db_username, db_password);
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS equation_data("
                    + "id int NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                    + "username varchar(255) FOREIGN KEY REFERENCES user_data (username), "
                    + "equation varchar(255), "
                    + "solution varchar(255), "
                    + "data date NOT NULL );"
            );
            create.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
