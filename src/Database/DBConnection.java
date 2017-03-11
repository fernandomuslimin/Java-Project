/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * 
 * @author Fernando M 
 */
public class DBConnection {
    private static Connection koneksi;
    
    public static Connection getConnection(){
        
        if(koneksi == null){
            try {
                String url = "jdbc:mysql://localhost:3306/librarysystem?zeroDateTimeBehavior=convertToNull";
                String username = "root";
                String password = "";

                Class.forName("com.mysql.jdbc.Driver");
                koneksi = DriverManager.getConnection(url,username,password);
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Database Connection Failed!");
                e.printStackTrace();
            }           
        }
        return koneksi;
    }    
}
