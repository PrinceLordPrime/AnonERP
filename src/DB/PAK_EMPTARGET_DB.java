/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logical.Conversions;
import static DynamicERP.frames.sales.PakSalesFieldPanel1.round;
//import mondrian.olap.Category;

/**
 *
 * @author Shan
 */
public class PAK_EMPTARGET_DB extends PAK_GLOBAL_DB{
    public String[][] search_productRec(Connection conn,String date,String empCode) throws SQLException {
        String returned[][] = new String[find_count_in_productRec_code(conn)][4];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from PMAST ORDER BY CODE ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {
                returned[i][0]=resultset.getString("CODE");
                returned[i][1]=resultset.getString("PNAME");
                returned[i][2]=resultset.getString("PSIZE");
                
                returned[i][3]=get_proQty_from_empTarget(conn,date,empCode,returned[i][0]);
                

                i++;
        }
        return returned;
    }
    private int find_count_in_productRec_code(Connection conn) {
        int count = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "Select COUNT(CODE))as Count from PMAST ";
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("Count");
            //System.out.println("Count:"+temp);
            if(temp==null){
                count=0;
            }else{
                 count = Integer.parseInt(temp);
            }
           
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            count = 0;
        }
        return count;
    }

    private String get_proQty_from_empTarget(Connection conn, String date, String empCode, String returned1) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "SELECT * FROM EMPTARGET WHERE  PROCODE= '"+returned1+"' AND EMPCODE= '"+empCode+"' AND TDATE = DATE('"+date+"' ,'MM/DD/YY')" ;
	ResultSet resultset = statement.executeQuery(Sql);
        
        String returned="0";
        if(resultset.next())
        {
            returned= resultset.getString("PROQTY");
        }
        return returned;
    }

    public boolean isMatched(Connection conn, String date, String empCode, String returned1) {
        boolean tf=false;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "SELECT * FROM EMPTARGET WHERE  PROCODE= '"+returned1+"' AND EMPCODE= '"+empCode+"' AND TDATE = DATE('"+date+"' ,'MM/DD/YY')" ;
            ResultSet resultset = statement.executeQuery(Sql);
            
            if(resultset.next())
            {
                return tf=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_EMPTARGET_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tf;
    }

    public boolean update(Connection conn, String date, String empCode, String code, String proqty) {
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql;
            
            Sql="UPDATE EMPTARGET SET PROQTY = "+Integer.parseInt(proqty)+" WHERE  PROCODE= '"+code+"' AND EMPCODE= '"+empCode+"' AND TDATE = DATE('"+date+"' ,'MM/DD/YY')" ;
            int r = statement.executeUpdate(Sql);
            if(r!=0){
                var = true;
            }
            
        }
        catch(SQLException e)
        {
            //System.out.println("SQLException:"+e);
                var = false;
        }

        return var;
    }

    public boolean insert(Connection conn,String id, String date, String empCode, String code, String proqty) {
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "INSERT INTO EMPTARGET (CODE,EMPCODE,PROCODE,PROQTY,TDATE) "
                    + "VALUES ('"
                    + Integer.parseInt(id)+ "','" 
                    + Integer.parseInt(empCode)+ "','" 
                    + Integer.parseInt(code)+ "','" 
                    + Integer.parseInt(proqty)+ "'," 
                    + "DATE('"+date+"' ,'MM/DD/YY'))";
             
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            System.out.println("Error Log :"+e);
            var = false;
        }
        return var;
    }

    public int find_max_in_empTarget_code(Connection conn) {
        int max = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "Select MAX(CODE))as ID from  EMPTARGET";
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("temp"+temp);
            if(temp==null){
                max=0;
            }else{
                 max = Integer.parseInt(temp);
            }
           
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            max = 0;
        }
        return max;
    }
}
