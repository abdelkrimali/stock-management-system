/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbase;

import stock.Tools;
import java.awt.Image;
import java.io.File;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Go {
    static String filename=null;
    static String path;
    static ImageIcon format=null;
    static  byte[]datta;
    static JLabel label;
    private static String url;
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    
    public static void seturl()
    {
       // url="jdbc:sqlite:C:\\Users\\Alilo\\Documents\\NetBeansProjects\\stock\\stock.db";
        url="jdbc:sqlite:stock.db";
       // url="jdbc:mysql://localhost/"+dbname+"?user=root&password=mypass";
    }
    public static void setconnection()
    {
        try
        {
           con=null;
         
            seturl();
            con=DriverManager.getConnection(url);
           System.out.println("Opened database successfully");
            
        }
        catch(SQLException ex)
        {
           
        }
    }
    
    public static boolean chekuserandpass(String user,String password){
        try
        {
            setconnection();
            String select="select * from utilisateur where "
                    +"username='"+user+"'"
                    +" and password='"+password+"'";
             stmt=con.createStatement();
             rs=stmt.executeQuery(select);
            while(rs.next()){
                return true;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally{
            try {
                stmt.close();
                rs.close();
                
            } catch (Exception e) {
            }
        }
        return false; 
    }
    public static boolean runNonQuery(String sqlstatement){
        try{
            setconnection();
             stmt=con.createStatement();
            stmt.execute(sqlstatement);
            con.close();
            return true;
            
        }catch(SQLException ex){
            //ex.printStackTrace();
            Tools.msgBox(ex.getMessage());
            
        }finally
        {
            try {
                stmt.close();
                
            } catch (Exception e) {
            }
        }
        
        return false;
       
    }
    public static String GetAutoNumber(String tablename, String colomnname){
        try{
            setconnection();
             stmt=con.createStatement();
            String select="select max("+colomnname+")+1 as autonumber "
                    +" from "+tablename;
             rs=stmt.executeQuery(select);
            String num="";
            while(rs.next()){
                num=rs.getString("autonumber");
            }
            if(num==null ||"".equals(num))
            {
                return "1";
            }
            else
            {
                return num ;
            } 
        }
        catch(SQLException ex){
            Tools.msgBox(ex.getMessage());
            ex.printStackTrace();
            return "0";
        }
        finally{
            try {
                stmt.close();
                rs.close();
            } catch (Exception e) {
            }
        }
    }
     public static void fillToJtable(String tablename_or_selectstatement,JTable table){
        try
        {
            setconnection();
             stmt=con.createStatement();
            
            String strselect;
            if("select ".equals(tablename_or_selectstatement.substring(0, 7).toLowerCase())){
                strselect=tablename_or_selectstatement;
                
            }
            else{
                strselect="select * from "+tablename_or_selectstatement;
                
            }
            rs=stmt.executeQuery(strselect);
            ResultSetMetaData rsmd=rs.getMetaData();
            int c=rsmd.getColumnCount();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            Vector row=new Vector();
            model.setRowCount(0);
            while(rs.next())
            {
                row=new Vector(c);
                for(int i=1;i<=c;i++)
                {
                    row.add(rs.getString(i));
                }
                model.addRow(row);
            }
            if(table.getColumnCount()!=c){
                Tools.msgBox("JTable Culomns Count Not Equal To Query Columns Count\nJTable Culomns :"+table.getColumnCount()+"\nQuery Columns :"+c);
            }
            con.close();
        }
        catch(SQLException ex)
        {
            Tools.msgBox(ex.getMessage());
        }
        finally{
            try {
                stmt.close();
                rs.close();
            } catch (Exception e) {
            }
        }
    }
         public static void fillCombo(String tablename,String columnname,JComboBox combo)
    {
        try{
            setconnection();
             stmt=con.createStatement();
           
            String strselect="select "+columnname+" from "+tablename;
            rs=stmt.executeQuery(strselect);
            rs.last();
            int c=rs.getRow();
            rs.beforeFirst();
            String values[]=new String[c];
            int i=0;
            while(rs.next())
            {
                values[i]=rs.getString(1);
                i++;  
            }
            con.close();
            combo.setModel(new DefaultComboBoxModel(values));
        }
        catch(SQLException ex)
        {
            Tools.msgBox(ex.getMessage());
        }
        finally{
            try {
                stmt.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void afficheimg(JLabel label)
    {
          try
         {
        JFileChooser fc=new JFileChooser();
        FileNameExtensionFilter filter=new FileNameExtensionFilter("Image Files","jpg","png");
        fc.setFileFilter(filter);
        fc.showDialog(null, "Select Image");
        File f=fc.getSelectedFile();
        filename=f.getAbsolutePath();
        filename.replace("\\","/");
        path=filename;
            Image img=ImageIO.read(fc.getSelectedFile());
            label.setIcon(new ImageIcon(img));
        }catch(Exception ex)
        {
            Tools.msgBox("Veuillez Coisir une image  ");
        }
    }
    public static String getpath()
    {
        return path;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
