/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alilo
 */
public class NewClass {
    private static String url;
    private static Connection con;
    
    public static void seturl()
    {
        url="jdbc:sqlite:stock.db";
       // url="jdbc:mysql://localhost/"+dbname+"?user=root&password=mypass";
    }
    public static void setconnection()
    {
        try
        {
            seturl();
            con=DriverManager.getConnection(url);
           System.out.println("Opened database successfully");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
   
    
     
   
    public static void main( String args[] ) {
        setconnection();
    }
    
}
