/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author deece
 */
public abstract class DBConnection {

    final String db_url = "jdbc:mysql://localhost/";
    final String db_username = "root";
    final String db_password = "root";

}
