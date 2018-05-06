/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shan
 */
public class PAK_GLOBAL_DB{
    //public String userName = "dbo";
    
    public boolean chech_order_or_sale(Connection conn,String docno) {
        boolean cat=false;
        ResultSet result = null;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from CUSTLEG WHERE DOCNO='"+docno+"'";
            result=statement.executeQuery(Sql);
            if(result.next()){
                return cat=true;
            }
        }catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {result.close();} catch (SQLException ex) {Logger.getLogger(PAK_ISSUE_SALE_DB.class.getName()).log(Level.SEVERE, null, ex);}
        }
        return cat;
    }
    public Connection connect_database() throws SQLException
	{
//            Connection conn34 = null;
//            try
//            {
//                    Class.forName("oracle.jdbc.driver.OracleDriver");
//                    conn34 = DriverManager.getConnection("jdbc:oracle:thin:dsp001/dynamic001@DESKTOP-EAI1O31:1521:DSPAK");
//            }
//            catch(ClassNotFoundException e)
//            {
//                    JOptionPane.showMessageDialog(null, "Failed to Connect the Database" , "Database Connection Error", JOptionPane.ERROR_MESSAGE);
//                    e.printStackTrace();
//            }
//            return conn34;
            Connection conn = null;
            try
            {
                String Database = "mysql";
                if("mysql".equals(Database)){
                    try {Class.forName("com.mysql.jdbc.Driver");} catch(ClassNotFoundException ex){JOptionPane.showMessageDialog(null, "My SQL Driver Exception" , "My SQL Connection Error", JOptionPane.ERROR_MESSAGE); ex.printStackTrace(); }
                    String Url = "jdbc:mysql://127.0.0.1:3306/my_db";
                    String Username = "root";
                    String Password = "";

                    //String db_driver   = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                    //try { Class.forName(db_driver); } catch(ClassNotFoundException e) { JOptionPane.showMessageDialog(null, "Failed to Connect the My SQL" , "My SQL Database Connection Error", JOptionPane.ERROR_MESSAGE); e.printStackTrace();  }
                    conn = DriverManager.getConnection(Url,Username,Password);
                    System.out.println("Connection Successful");
                } else if("sqlserver".equals(Database)) {
                    String db_url      = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=my_db";
                    String db_driver   = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                    String db_username = "root";
                    String db_password = "";
                    try { Class.forName(db_driver); } catch(ClassNotFoundException e) { JOptionPane.showMessageDialog(null, "Failed to Connect the SQL Server" , "SQL Server Database Connection Error", JOptionPane.ERROR_MESSAGE); e.printStackTrace();  }
                    conn = DriverManager.getConnection(db_url,db_username,db_password);  
                }
                       
            }
            catch(SQLException e)
            {
                    JOptionPane.showMessageDialog(null, "Failed to Connect the Database" , "Database Connection Error", JOptionPane.ERROR_MESSAGE);
                    //e.printStackTrace();
                    return null;
            }   
            return conn;
	}
	public void close_database(Connection conn) throws SQLException
	{
            conn.close();
	}
}
