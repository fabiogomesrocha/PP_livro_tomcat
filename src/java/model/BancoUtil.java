/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 10361
 */
public class BancoUtil {
    public Connection con(){
        String mariadb = "jdbc:mariadb://localhost:3306/livro";
        String user = "root";
        String passwd = "";
        Connection con = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(mariadb, user, passwd);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BancoUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BancoUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}
