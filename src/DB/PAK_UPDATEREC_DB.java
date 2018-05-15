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
public class PAK_UPDATEREC_DB extends PAK_GLOBAL_DB{
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
    
    
    Conversions ccc =new Conversions();
    public String[][] search_sailPaid(Connection conn, String dCode,String ddate,String vanCode) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "SELECT * FROM SMAIN WHERE  DCODE = '"+dCode+"' AND DDATE = DATE('"+ddate+"' ,'MM/DD/YY') AND VANREC = '"+vanCode+"' ORDER BY DOCNO ASC" ;
        ResultSet resultset = statement.executeQuery(Sql);int s =  find_count_in_result(conn,dCode,ddate,vanCode);
        String returned[][] = new String[s][5];int i=0;
       while(resultset.next()){
            returned[i][0]=resultset.getString("DOCNO");returned[i][1]=resultset.getString("CUSTCODE");
            returned[i][2]=find_cust_name_by_code(conn,returned[i][1]);
            returned[i][3]=resultset.getString("NETPAYABLE");returned[i][4] =resultset.getString("PAID");
//            System.out.println("---->"+returned[i][0]+" , "+returned[i][1]+" , "+returned[i][3]+" , "+returned[i][4]);
            i++;
        }  
        return returned;
    }
    public String[][] search_sailManPaid(Connection conn, String dCode,String ddate,String vanCode) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "SELECT DOCNO,CUSTCODE,DCODE,VANREC,OBCODE,to_char(DDATE,'MM/DD/YY') as DDATE FROM SMAIN WHERE  DCODE = '"+dCode+"' AND DDATE = DATE('"+ddate+"' ,'MM/DD/YY') AND VANREC = '"+vanCode+"' ORDER BY DOCNO ASC" ;
        ResultSet resultset = statement.executeQuery(Sql);int s =  find_count_in_result(conn,dCode,ddate,vanCode);
        String returned[][] = new String[s][9];int i=0;
        while(resultset.next()){
            returned[i][0]=resultset.getString("DOCNO");returned[i][1]=resultset.getString("CUSTCODE");
            returned[i][2]=find_cust_name_by_code(conn,returned[i][1]);
            returned[i][3]=resultset.getString("DCODE");
            returned[i][4]=resultset.getString("VANREC");returned[i][5]=find_van_name_by_code(conn,returned[i][4]);
            returned[i][6]=resultset.getString("OBCODE");returned[i][7]=find_ob_name_by_code(conn,returned[i][6]);
            returned[i][8]=resultset.getString("DDATE");
            i++;
        }  
        return returned;
    }
    public String[][] search_route_recovery(Connection conn, String rCode) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        /*
        DOCCODE,CUSTCODE,SM1CODE,SM2CODE,CASHTPCD,REMARKS,RDATE,AMOUNT,FREIGHT,CREDITAMOUNT
        */
        String Sql = "SELECT * FROM CUSTBALANCE WHERE  ROUTECODE = '"+rCode+"'ORDER BY CUSTOMER ASC" ;
        ResultSet resultset = statement.executeQuery(Sql);int s =  find_count_in_custBal(conn, rCode);
        String returned[][] = new String[s][4];int i=0;
        while(resultset.next()){
            returned[i][0]=resultset.getString("CUSTOMER");
            returned[i][1]=find_cust_name_by_code(conn,returned[i][0]);
            returned[i][2]=resultset.getString("BALANCE");
            returned[i][3]="0";
            
            i++;
        }  
        return returned;
    }
    /*
    public String[][] search_productRec(Connection conn, String code, String pname, String psize, String saleprice,
            String costprice, String catcode, String companycode, String sttypecode, String clqty, String clvalue,
            String subcat, String remarks, String dangerlevel, String minlevel, String reorderlevel, String noofpcs,
            String weight, String taxper, String discper, String fmrper, String retailprice) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
    */
    public String[][] search_productRec(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
/*
        CODE,PNAME,PSIZE,COSTPRICE,SALEPRICE,RETAILPRICE, NOOFPCS, WEIGHT,DISCPER,TAXPER,
        CATCODE,COMPANYCODE,STTYPECODE,CLQTY,CLVALUE,SUBCAT,REMARKS,DANGERLEVELMINLEVEL,REORDERLEVEL,FMRPER,      
        */
        String Sql = "SELECT *FROM PMAST WHERE  COMPANYCODE = '"+code+"' ORDER BY CODE ASC" ;
        ResultSet resultset = statement.executeQuery(Sql);
        int s =  find_count_in_products(conn, code);
        String returned[][] = new String[s][10];int i=0;
        while(resultset.next()){
            returned[i][0]=resultset.getString("CODE");
            returned[i][1]=resultset.getString("PNAME");
            returned[i][2]=resultset.getString("PSIZE");
            returned[i][3]=resultset.getString("COSTPRICE");
            returned[i][4]=resultset.getString("SALEPRICE");
            returned[i][5]=resultset.getString("RETAILPRICE");
            returned[i][6]=resultset.getString("NOOFPCS");
            returned[i][7]=resultset.getString("WEIGHT");
            returned[i][8]=resultset.getString("DISCPER");
            returned[i][9]=resultset.getString("TAXPER");
            i++;
        }  
        return returned;
    }
    
    
    
    public boolean check_product_line_item_description_presence_new(Connection conn,String docno, String seqNoText) {
        boolean cat=false;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from CUSTLEG WHERE DOCNO='"+docno+"' AND DESCR  LIKE '"+seqNoText+"%'";
            ResultSet result = null;
            result=statement.executeQuery(Sql);
//            System.out.println("seqNoText ==:::=== "+seqNoText);
            while(result.next()){
//                System.out.println("result.getString(\"SEQNO\").toString())==>>"+result.getString("DESCR").toString());
//                System.out.println("seqNoText ==> "+seqNoText);
                String s = result.getString("DESCR").toString();
                
                
                if(seqNoText.equals(s)){
//                    System.out.println("MATCHED======with====="+seqNoText);
                    cat = true;
                    return cat;
                }else{
                    cat = false;
                }
            }
        }catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
    public boolean check_product_line_item_description_presence_in_custleg(Connection conn,String docno, String seqNoText) {
        boolean cat=false;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from CUSTLEG WHERE DOCNO='"+docno+"' AND DESCR  = '"+seqNoText+"'";
            ResultSet result = null;
            result=statement.executeQuery(Sql);
//            System.out.println("seqNoText ==:::=== "+seqNoText);
            while(result.next()){
//                System.out.println("result.getString(\"SEQNO\").toString())==>>"+result.getString("DESCR").toString());
//                System.out.println("seqNoText ==> "+seqNoText);
                String s = result.getString("DESCR").toString();
                
                
                if(seqNoText.equals(s)){
//                    System.out.println("MATCHED======with====="+seqNoText);
                    cat = true;
                    return cat;
                }else{
                    cat = false;
                }
            }
        }catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
    public boolean delete_all_custleg_wrt_descr(Connection conn ,String docno,String docno1) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM CUSTLEG WHERE DOCNO = '"+docno+"' AND DESCR  = '"+docno1+"'";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }
        return var;
    }
    public boolean delete_all_custleg_wrt_custCode(Connection conn ,String docno,String docno1) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM CUSTLEG WHERE DOCNO = '"+docno+"' AND CUSTCODE  = '"+docno1+"'";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }
        return var;
    }
    public boolean delete_all_custleg(Connection conn ,String docno) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM CUSTLEG WHERE DOCNO = '"+docno+"'";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }
        return var;
    }
    public boolean update_cust_ledger(Connection conn,String  custcode,String docdate) {
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql="UPDATE SMAIN SET  PAID = '"+docdate+"' WHERE DOCNO ="+custcode;
            System.err.println(""+docdate+" , "+custcode);
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
    public boolean update_sm_van_ob_date_Code(Connection conn,String  custcode,String docdate,String  vanCode,String obCode,String  ddate) {
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql="UPDATE SMAIN SET  DCODE = '"+docdate+"',VANREC = '"+vanCode+"',OBCODE = '"+obCode+"',DDATE = DATE('"+ddate+"','MM/DD/YY') WHERE DOCNO ="+custcode;
            System.err.println(""+docdate+" , "+custcode);
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
    public int find_max_all_in_recovery_credit_rec_code(Connection conn) {
        int max = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql;
            Sql = "Select MAX(DOCCODE))as ID from RECOVERY";
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
    public boolean insert_Recovery(Connection conn,String  custcode,String bal,String  recAmt,String date,String empCode) {
        boolean var = false;
		try
		{
//              ************ ***********************************************************                                                                     
                    java.sql.Statement statement = conn.createStatement();//                                                             ************ +  "',DATE('" + date+ " ', 'yyyy/mm/dd ')," + **********                                                                     
                    String Sql = "INSERT INTO RECOVERY(DOCCODE,CUSTCODE,SM1CODE,SM2CODE,CASHTPCD,RDATE,AMOUNT,"
                            + "FREIGHT,CREDITAMOUNT) VALUES ("+
                            (find_max_all_in_recovery_credit_rec_code(conn)+1)+ "," 
                            + Integer.parseInt(custcode) + "," +
                            Integer.parseInt(empCode) +  "," +
                            Integer.parseInt(empCode) +  "," +
                            1 +  ","+ 
                            " DATE('" + date + "' , 'MM/DD/YY')," +
                            Integer.parseInt(recAmt) +  "," +
                            Integer.parseInt("0") +  "," +
                            Integer.parseInt("0") +")";
                    statement.executeUpdate(Sql);
                    var = true;
		}
		catch(SQLException e)
		{
                    System.out.println("Error Log insert_recovery_in_table:"+e);
                    var = false;
		}
		return var;
    }
    
    
    
    
    public boolean update_pro_Code(Connection conn,String Code, String Pname, String Psize, String Costprice, String Saleprice, String Retailprice, String  Noofpcs, String  Weight, String Discper, String Taxper) {
        boolean var = false;
        try
        {
//CODE,PNAME,  ,,,RETAILPRICE, NOOFPCS, WEIGHT,DISCPER,TAXPER,
            java.sql.Statement statement = conn.createStatement();
            String Sql="UPDATE PMAST SET  "
                    + "PSIZE = '"+Psize+"',"
                    + "COSTPRICE = '"+Costprice+"',"
                    + "SALEPRICE = '"+Saleprice+"', "
                    + "RETAILPRICE = '"+Retailprice+"', "
                    + "NOOFPCS = '"+Noofpcs+"', "
                    + "WEIGHT = '"+Weight+"', "
                    + "DISCPER = '"+Discper+"', "
                    + "TAXPER = '"+Taxper+"'"
                    + "WHERE CODE ="+Code;
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
    public int find_count_in_purchase_products(Connection conn, String name) {
        int count = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = " SELECT COUNT(CUSTCODE) AS Count FROM CUSTLEG WHERE CUSTCODE = '"+name+"'";
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
    
    public int find_count_in_products(Connection conn, String name) {
        int count = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = " SELECT COUNT(CODE) AS Count FROM PMAST WHERE COMPANYCODE = '"+name+"'";
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
////            CUSTCODE,DOCDATE,DESCR,DEBIT,CREDIT
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

    private int find_count_in_result(Connection conn, String smCode,String ddate,String vanCode) {
        int count=0;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql1 = "SELECT COUNT(DOCNO) AS Count FROM SMAIN WHERE  DCODE = '"+smCode+"' AND DDATE = DATE('"+ddate+"' ,'MM/DD/YY') AND VANREC = '"+vanCode+"' ORDER BY DOCNO ASC" ;
            ResultSet resultset1 = statement.executeQuery(Sql1);
            resultset1.next();
            String temp=resultset1.getString("Count");
            if(temp==null){
                count=0;
            }else{
                count = Integer.parseInt(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_UPDATEREC_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    private int find_count_in_custBal(Connection conn, String rCode) {
        int count=0;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql1 = "SELECT COUNT(CUSTOMER) AS Count FROM CUSTBALANCE WHERE  ROUTECODE = '"+rCode+"' ORDER BY CUSTOMER ASC" ;
            ResultSet resultset1 = statement.executeQuery(Sql1);
            resultset1.next();
            String temp=resultset1.getString("Count");
            if(temp==null){
                count=0;
            }else{
                count = Integer.parseInt(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_UPDATEREC_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    public String find_cust_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CLIENTS WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("NAME");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_cust_bal_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CUSTBALANCE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("NAME");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_van_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from VANREC WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("VANNAME");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_ob_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from EMPREC WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("NAME");
        }else{
            cat=null;
        }
        return cat;
    }
    public String get_sum_opngBal(Connection conn, String text, String toDateString) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "SELECT * FROM CUSTLEG WHERE  CUSTCODE = '"+text+"' AND DOCDATE < DATE('"+toDateString+"' ,'MM/DD/YY')" ;
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
    public String check_product_line_item_presence_with_seek(Connection conn,String string, String seqNoText,String seekText,int pc) {
        String cat="false"; 
        java.sql.Statement statement[]=new java.sql.Statement[find_max_in_purchase_products(conn, string)+pc];
        ResultSet result = null;
        try {
            statement[Integer.parseInt(seqNoText)] =  conn.createStatement();
            
            String Sql = null;
            Sql = "select * from RDTL WHERE (DOCNO='"+string+"') AND (SEQNO='"+seqNoText+"') ";

            result=statement[Integer.parseInt(seqNoText)].executeQuery(Sql);
            while(result.next()){
//                System.out.println(seqNoText+"SEQNO->"+result.getString("SEQNO"));
//                System.out.println(seqNoText+"PCODE->"+result.getString("PCODE"));

                if(seekText.equals(result.getString("PCODE"))){
                    return "true";
                }else{
                    cat= result.getString("PCODE")+" "+result.getString("SALEQTY");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    public String get_description_rdtl(Connection conn,String invNo, String seqNoText,int pc) {
        String cat="false"; 
        java.sql.Statement statement[]=new java.sql.Statement[find_max_in_purchase_products(conn, invNo)+pc];
        ResultSet result = null;
        try {
            statement[Integer.parseInt(seqNoText)] =  conn.createStatement();
            
            String Sql = null;
            Sql = "select * from RDTL WHERE (DOCNO='"+invNo+"') AND (SEQNO='"+seqNoText+"') ";

            result=statement[Integer.parseInt(seqNoText)].executeQuery(Sql);
            if(result.next()){
//                System.out.println(seqNoText+"SEQNO->"+result.getString("SEQNO"));
//                System.out.println(seqNoText+"DESCR->"+result.getString("DESCRIPTION"));
                cat= result.getString("DESCRIPTION");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    public int find_max_in_purchase_products(Connection conn, String name) {
        int count = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = " SELECT MAX(SEQNO) AS Count FROM RDTL WHERE  DOCNO = '"+name+"'";
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("Count");
            System.out.println("MAX:"+temp);
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
    public boolean insert_cust_ledger(Connection conn,String  custcode,String docdate,String descr,String debit,String credit,String docno) {
        boolean var = false;
        if(docdate=="0"){
            
        }
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "INSERT INTO CUSTLEG(CUSTCODE,DOCDATE,DESCR,DEBIT,CREDIT,DOCNO) VALUES ("+
                    Integer.parseInt(custcode)+ ",DATE('"+docdate+"' ,'MM/DD/YY'),'" + descr +  "'," + Float.parseFloat(debit) +  "," +Float.parseFloat(credit) +  "," + Integer.parseInt(docno)  + ")";
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
