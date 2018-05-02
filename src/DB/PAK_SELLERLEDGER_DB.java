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

/**
 *
 * @author Shan
 */
public class PAK_SELLERLEDGER_DB extends PAK_GLOBAL_DB{
  
//    public Connection connect_database() throws SQLException
//    {
//            Connection conn = null;
//            try
//            {
//                    Class.forName("oracle.jdbc.driver.OracleDriver");
//                    conn = DriverManager.getConnection("jdbc:oracle:thin:pak/dynamic001@COBRA:1521:DSPSHAN");
//            }
//            catch(ClassNotFoundException e)
//            {
//                    JOptionPane.showMessageDialog(null, "Failed to Connect the Database" , "Database Connection Error", JOptionPane.ERROR_MESSAGE);
//                    e.printStackTrace();
//            }
//            return conn;
//    }
//    public void close_database(Connection conn) throws SQLException
//    {
//            conn.close();
//    }


    //======================================================================================================================================================
    //======================================================================================================================================================
    //======================================================================================================================================================
    
    
    
    public String[][] search_custleg(Connection conn, String asset_rec,String ddate,String cdate,String bal) throws SQLException {
//        int s = find_count_in_purchase_products(conn, asset_rec);
//        String returned[][] = new String[s][6];
	java.sql.Statement statement = conn.createStatement();
        String Sql = "SELECT * FROM SUPPLEG WHERE  SELLER = '"+asset_rec+"' AND DOCDATE BETWEEN TO_DATE('"+ddate+"' ,'MM/DD/YY') AND TO_DATE('"+cdate+"' ,'MM/DD/YY') ORDER BY DOCDATE ASC" ;
	ResultSet resultset = statement.executeQuery(Sql);
        
       
        int s =  find_count_in_result(conn,asset_rec,ddate,cdate);
        System.out.println("s"+s);
        String returned[][] = new String[s+1][7];
	
        int i=0;
        float a=0.0f;
        float b=0.0f;
        float c=0.0f;
        float d=0.0f;
//        float l=0.0f;
        if(i==0){
            returned[i][1]="0";
            returned[i][2]=ddate;
            returned[i][3]="Opening Balance";
            returned[i][4]= "0.0";
            returned[i][5] = "0.0";
            returned[i][6] = bal;
            returned[i][0]= (i)+"";
            i++;
        }
        d=Float.parseFloat(bal);
                
        while(resultset.next())
        {
            if(i==0){
                
            }else if(i<=s){
                System.out.println("i"+i);
                returned[i][1]=resultset.getString("DOCNO");
                try {
                    returned[i][2]=ccc.toDateString(ccc.toDate(resultset.getString("DOCDATE"))+"");//resultset.getString("DOCDATE");
                } catch (ParseException ex) {
                    Logger.getLogger(PAK_SELLERLEDGER_DB.class.getName()).log(Level.SEVERE, null, ex);
                }
                returned[i][3]=resultset.getString("DESCRIPTION");
                returned[i][4]= resultset.getString("DEBIT");
                returned[i][5] = resultset.getString("CREDIT");
                returned[i][0]= (i)+"";
                b=Float.parseFloat(returned[i][4]);
                c=Float.parseFloat(returned[i][5]);
                d=(d+b)-c;
                returned[i][6]= round(d,3)+"";
            }
            i++;
        }  
        return returned;
    }
    Conversions ccc =new Conversions();
    
    public int find_count_in_purchase_products(Connection conn, String name) {
        int count = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = " SELECT COUNT(SELLER) AS Count FROM SUPPLEG WHERE SELLER = '"+name+"'";
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("Count");
//            System.out.println("Count:"+temp);
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
    
    
//   private ArrayList<String> getCustomerLeger(ResultSet result) {
//     
//        try {
////            SELLER,DOCDATE,DESCRIPTION,DEBIT,CREDIT
//            
//                cat.add(0,code );
//                cat.add(1,c );
//                cat.add(2,co );
//                cat.add(3,ad2 );
//                cat.add(4,add );
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return cat;
//    }

    private int find_count_in_result(Connection conn, String asset_rec,String ddate,String cdate) {
        int count=0;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql1 = "SELECT COUNT(SELLER) AS Count FROM SUPPLEG WHERE  SELLER = '"+asset_rec+"' AND DOCDATE BETWEEN TO_DATE('"+ddate+"' ,'MM/DD/YY') AND TO_DATE('"+cdate+"' ,'MM/DD/YY')" ;
            ResultSet resultset1 = statement.executeQuery(Sql1);
            resultset1.next();
            String temp=resultset1.getString("Count");
            if(temp==null){
                count=0;
            }else{
                count = Integer.parseInt(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_SELLERLEDGER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public String get_sum_opngBal(Connection conn, String text, String toDateString) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "SELECT * FROM SUPPLEG WHERE  SELLER = '"+text+"' AND DOCDATE < TO_DATE('"+toDateString+"' ,'MM/DD/YY')" ;
	ResultSet resultset = statement.executeQuery(Sql);
        
        String returned="";
        String dS="";
        String cS="";
        BigDecimal dBD=new BigDecimal("0.0");
        BigDecimal cBD=new BigDecimal("0.0");
        BigDecimal tBD=new BigDecimal("0.0");
        while(resultset.next())
        {
            dS= resultset.getString("DEBIT");
            cS = resultset.getString("CREDIT");
            
            dBD=dBD.add(new BigDecimal(Float.parseFloat(dS))); 
            cBD=cBD.add(new BigDecimal(Float.parseFloat(cS))); 
        }  
        tBD=dBD.subtract(cBD);
        returned=tBD+"";
        return returned;
    }
}
