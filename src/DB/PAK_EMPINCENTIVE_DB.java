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
public class PAK_EMPINCENTIVE_DB extends PAK_GLOBAL_DB{

    public String[][] search_empIncentive(Connection conn) throws SQLException {
        //post product productname
        int cctv = fcip(conn);
        String returned[][] = new String[fcipro(conn)+1][cctv+3];
        java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from PMAST ORDER BY CODE ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        returned[0][0]="";
        returned[0][1]="";
        returned[0][2]="";
        int i=1;
        while(resultset.next())
        {   
            java.sql.Statement statement1 = conn.createStatement();
            String Sql1 = "Select * from POST ORDER BY CODE ASC";
            ResultSet resultset1 = statement1.executeQuery(Sql1);

            returned[i][0]=resultset.getString("CODE");
            returned[i][1]=resultset.getString("PNAME");
            returned[i][2]=resultset.getString("PSIZE");
            int j=3;
            while(resultset1.next())
            {
                System.out.println("resultset1.getString(\"CODE\")"+resultset1.getString("CODE"));
                System.out.println("resultset.getString(\"CODE\")"+resultset.getString("CODE"));
                returned[i][j]=get_incetive(conn,resultset1.getString("CODE"),resultset.getString("CODE"));
                System.out.println("returned["+i+"]["+j+"]"+returned[i][j]);
                returned[0][j]=resultset1.getString("CODE");
                j++;
            }
            i++;
        }
        return returned;
    }
    public String[][] search_custType_Incentive(Connection conn) throws SQLException {
        //post product productname
        int cctv = fcic(conn);
        String returned[][] = new String[fcipro(conn)+1][cctv+3];
        java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from PMAST ORDER BY CODE ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        returned[0][0]="";
        returned[0][1]="";
        returned[0][2]="";
        int i=1;
        while(resultset.next())
        {   
            java.sql.Statement statement1 = conn.createStatement();
            String Sql1 = "Select * from POST ORDER BY CODE ASC";
            ResultSet resultset1 = statement1.executeQuery(Sql1);

            returned[i][0]=resultset.getString("CODE");
            returned[i][1]=resultset.getString("PNAME");
            returned[i][2]=resultset.getString("PSIZE");
            int j=3;
            while(resultset1.next())
            {
                System.out.println("resultset1.getString(\"CODE\")"+resultset1.getString("CODE"));
                System.out.println("resultset.getString(\"CODE\")"+resultset.getString("CODE"));
                returned[i][j]=get_incetive(conn,resultset1.getString("CODE"),resultset.getString("CODE"));
                System.out.println("returned["+i+"]["+j+"]"+returned[i][j]);
                returned[0][j]=resultset1.getString("CODE");
                j++;
            }
            i++;
        }
        return returned;
    }/*
    public static String[][] getCpv(String[][] a, String[][] b) {
        String[][] result = new String[a.length + b.length][];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }*/
    private int fcipro(Connection conn) {
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

    private int fcip(Connection conn) {
        int count = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "Select COUNT(CODE))as Count from POST";
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
    private int fcic(Connection conn) {
        int count = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "Select COUNT(CODE))as Count from CUSTTYPE";
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

    private String get_pname_pmast_wrt_code(Connection conn, String seek) {
        String cat=null;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from PMAST WHERE CODE="+seek;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("PNAME");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
/*
    private String[][] get_pn(Connection conn,int i, String returned1,String returned2) {
        String returned[][] = new String[fcipro(conn)][fcip(conn)+2];
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "Select * from POST ORDER BY CODE ASC";
            ResultSet resultset = statement.executeQuery(Sql);
                returned[i][0]=returned1;
                returned[i][1]=returned2;
            int j=2;
            while(resultset.next())
            {
                System.out.println("resultset.getString(\"CODE\")"+resultset.getString("CODE"));
                returned[i][j]=get_incetive(conn,resultset.getString("CODE"),returned1);
                System.out.println("returned["+i+"]["+j+"]"+returned[i][j]);
                j++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_EMPINCENTIVE_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returned;
    }
*/
    private String get_incetive(Connection conn, String string, String returned1) {
        String cat="0";
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from CUSTTYPEDISC WHERE PMAST="+returned1+" AND CUSTTYPE ="+string;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){//CUSTTYPEDISC , CUSTTYPE,PMAST,DISC
                cat = result.getString("DISC");
            }else{
                cat="0";
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }

    public String[] get_all_post_name(Connection conn) {
        String cat[]=new String[fcip(conn)+3];
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from POST ORDER BY CODE ASC";

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat[0] ="PCode";
            cat[1] ="PName";
            cat[2] ="Packing/Size";
            int i = 3 ;
            while(result.next()){
                cat[i] = result.getString("POST");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    public String[] get_all_custType_name(Connection conn) {
        String cat[]=new String[fcic(conn)+3];
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from CUSTTYPE ORDER BY CODE ASC";

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat[0] ="PCode";
            cat[1] ="PName";
            cat[2] ="Packing/Size";
            int i = 3 ;
            while(result.next()){
                cat[i] = result.getString("TYPE");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }

    public boolean isPresent(Connection conn, String prCod, String pCod) {
        boolean tf=false;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "SELECT * FROM EMPINCENTIVE WHERE  PMAST= '"+prCod+"' AND POSTCODE= '"+pCod+"'" ;
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
    public boolean isCustPresent(Connection conn, String prCod, String pCod) {
        boolean tf=false;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "SELECT * FROM CUSTTYPEDISC WHERE  PMAST= '"+prCod+"' AND CUSTTYPE= '"+pCod+"'" ;
            ResultSet resultset = statement.executeQuery(Sql);
            
            if(resultset.next())//CUSTTYPEDISC , CUSTTYPE,PMAST,DISC
            {
                return tf=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_EMPTARGET_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tf;
    }

    public boolean update(Connection conn, String pr, String p, String v) {
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql;
            
            Sql="UPDATE EMPINCENTIVE SET INCENTIVE = "+Float.parseFloat(v)+" WHERE  PMAST= '"+pr+"' AND POSTCODE= '"+p+"'" ;
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
    public boolean updateCustTypeDisc(Connection conn, String pr, String p, String v) {
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql;
            
            Sql="UPDATE CUSTTYPEDISC SET DISC = "+Float.parseFloat(v)+" WHERE  PMAST= '"+pr+"' AND CUSTTYPE= '"+p+"'" ;
            int r = statement.executeUpdate(Sql);
            if(r!=0){//CUSTTYPEDISC , CUSTTYPE,PMAST,DISC
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
/*
    public int find_max_in_empIncentive_code(Connection conn) {
        int max = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "Select MAX(CODE))as ID from  EMPINCENTIVE";
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
    public int find_max_in_custTypeDisc_code(Connection conn) {
        int max = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "Select MAX(CUSTTYPE))as ID from  CUSTTYPEDISC";
            ResultSet result = null;//CUSTTYPEDISC , CUSTTYPE,PMAST,DISC
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
*/
    public boolean insert(Connection conn, String pr, String p, String v) {
        boolean var = false;
        try
        {//CUSTTYPEDISC , CUSTTYPE,PMAST,DISC
            java.sql.Statement statement = conn.createStatement();
            String Sql = "INSERT INTO EMPINCENTIVE (POSTCODE,PMAST,INCENTIVE) "
                    + "VALUES ('"
                    + Integer.parseInt(p)+ "','" 
                    + Integer.parseInt(pr)+ "','" 
                    + Float.parseFloat(v)+ "')";
             
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
    public boolean insertCustType(Connection conn, String pr, String p, String v) {
        boolean var = false;
        try
        {//CUSTTYPEDISC , CUSTTYPE,PMAST,DISC
            java.sql.Statement statement = conn.createStatement();
            String Sql = "INSERT INTO CUSTTYPEDISC (CUSTTYPE,PMAST,DISC) "
                    + "VALUES ('"
                    + Integer.parseInt(p)+ "','" 
                    + Integer.parseInt(pr)+ "','" 
                    + Float.parseFloat(v)+ "')";
             
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
}
