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

/**
 *
 * @author Shan
 */
public class PAK_PAYSELLER_DB extends PAK_GLOBAL_DB{
    public ArrayList<String> get_last_purchase(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_purchase_code(conn);
        String Sql = "select * from PAYMAIN WHERE DOCNO="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            cat=getPurchase(result);
        }else{
            cat=null;
        }
        return cat;
    }
     Conversions ccc =new Conversions();
    public String[][] search_sales(Connection conn, String distrec) throws SQLException {
//        /*
        String returned[][] = new String[find_count_in_purchase(conn)][6];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from PAYMAIN";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {
                returned[i][0]=resultset.getString("DOCNO");
                returned[i][1]=resultset.getString("ODATE");
                try {
                    returned[i][1]=ccc.toDateString(ccc.toDate(resultset.getString("ODATE"))+"");//resultset.getString("DOCDATE");
                } catch (ParseException ex) {
                    Logger.getLogger(PAK_SELLERLEDGER_DB.class.getName()).log(Level.SEVERE, null, ex);
                }
                returned[i][2]=resultset.getString("REFNO");
                returned[i][3]=resultset.getString("DESCR");
                returned[i][4]=resultset.getString("TD");
                returned[i][5]=resultset.getString("TC");
                //System.out.println("Code: " + resultset.getString("CODE")+"\n POST: " + resultset.getString("ROUTEDESC"));
                i++;
        }
        return returned;
//        */
    }
        public String find_cust_rec_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CLIENTS WHERE NAME='"+name+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("CODE");
        }else{
            cat=null;
        }
        return cat;
    }
    public ArrayList<String> next_purchase(Connection conn, String code){
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM PAYMAIN WHERE DOCNO > "+Integer.parseInt(code)+" ORDER BY DOCNO";            
            ResultSet result = null;
            result=statement.executeQuery(Sql);
//            //System.out.println("Result : " + result);
            
            if(result.next()){
               cat=getPurchase(result);
            }else{
                //cat.add(null);
                cat=null;
            }
        }
        catch(SQLException e)
        {
            //System.out.println("SQLException:"+e);
        }

        return cat;
    }
    public ArrayList<String> prior_purchase(Connection conn, String code) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM PAYMAIN WHERE DOCNO <"+Integer.parseInt(code)+" ORDER BY DOCNO DESC ";
            
            ResultSet result = null;
            result=statement.executeQuery(Sql);
//            //System.out.println("Result : " + result);
            
            if(result.next()){
                cat=getPurchase(result);
            }else{
                cat=null;
            }
        }
        catch(SQLException e)
        {
            //System.out.println("SQLException:"+e);
        }

        return cat;
    }

     public ArrayList<String> get_first_purchase(Connection conn)throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        
        ArrayList<String> cat;
        int min=0;
        min=find_min_in_purchase_code(conn);
        if(min!=0){
            String Sql;
            Sql = "select * from PAYMAIN WHERE DOCNO="+min;//+"AND CREDITAMOUNT > "+Integer.parseInt("0");
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
           cat = new ArrayList<String>();
           
            if(result.next()){
                cat=getPurchase(result);
            }else{
                cat.add(null);
            }
        }else{
            cat=null;
        }
        return cat;
        
    }
     public int find_min_in_purchase_code(Connection conn) {
        int min = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql;
                Sql = "Select MIN(DOCNO))as ID from PAYMAIN ";
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp == null){
                min=0;
            }else{
                 min = Integer.parseInt(temp);
            }
           
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            min = 0;
        }
        return min;
    }
    public boolean delete_purchase(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM PAYMAIN WHERE DOCNO = "+code;
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }

        return var;
    }
    public boolean delete_purchase_products_in_purchase(Connection conn ,String docno) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM PAYDTL WHERE DOCNO = '"+docno+"'";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }

        return var;
    }

    public boolean delete_purchase_product(Connection conn ,String docno,String seqno) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM PAYDTL WHERE DOCNO = '"+docno+"' AND SEQNO = '"+seqno+"'";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }
        return var;
    }
    public boolean delete_all_suppleg(Connection conn ,String docno
    ) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM SUPPLEG WHERE DOCNO = '"+docno+"'";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }
        return var;
    }
    public boolean delete_all_suppleg_wrt_descr(Connection conn ,String docno,String docno1) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM SUPPLEG WHERE DOCNO = '"+docno+"' AND DESCR  = '"+docno1+"'";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }
        return var;
    }
    public boolean delete_suppleg(Connection conn ,String docno,String seqno) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql=null;
//            String s ="Seq # "+seqno+" Ref #";
            Sql = "DELETE FROM SUPPLEG WHERE DOCNO = '"+docno+"' AND DESCR  = '"+seqno+"'"; 
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }
        return var;
    }
    public ArrayList<String> find_purchase_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from PAYMAIN WHERE DOCNO="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
//        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();

        if(result.next()){
            cat=getPurchase(result);
        }else{
            cat=null;
        }
        return cat;
    }
    public boolean update_purchase(Connection conn, String docno,String odate,String refno,String descr,String td,String tc){
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql;
//            DOCNO,ODATE,REFNO,DESCR,TD,TC
             Sql="UPDATE PAYMAIN SET  REFNO = '"+refno+"', ODATE= DATE('" + odate +
                     "' , 'MM/DD/YY') ,DESCR= '"+descr+"',TD= '"+td+"',TC = '"+tc+"' WHERE DOCNO ="+docno;
             statement.executeUpdate(Sql);

            
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("SQLException:"+e);
                var = false;
        }

        return var;
    }
    public int find_max_in_purchase_products(Connection conn, String name) {
        int count = 1;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = " SELECT MAX(SEQNO) AS Count FROM PAYDTL WHERE  DOCNO = '"+name+"'";
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("Count");
            System.out.println("MAX:"+temp);
            if(temp==null){
                count=1;
            }else{
                 count = Integer.parseInt(temp);
            }
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            count = 1;
        }
        return count;
    }
     public boolean insert_suppleg_ledger(Connection conn,String  custcode,String docdate,String descr,String debit,String credit,String docno) {
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
                String Sql = "INSERT INTO SUPPLEG(CUSTCODE,DOCDATE,DESCR,DEBIT,CREDIT,DOCNO) VALUES ("+
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
     public boolean update_suppleg_ledger(Connection conn,String  custcode,String docdate,String descr,String debit,String credit,String docno,String docno1) {
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql="UPDATE SUPPLEG SET  CUSTCODE = '"+custcode+"', DOCDATE= DATE('" + docdate +
                     "' , 'MM/DD/YY') ,DESCR= '"+descr+"',DEBIT= '"+debit+"',CREDIT = '"+credit+"' WHERE DOCNO ="+docno+" AND DESCR  = '"+docno1+"'";
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
    public boolean insert_purchase_in_table(Connection conn,String docno,String odate,String refno,String descr,String td,String tc){
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            
            String Sql = "INSERT INTO PAYMAIN(DOCNO,ODATE,REFNO,DESCR,TD,TC) VALUES ("
                    + Integer.parseInt(docno)+
                    ",DATE('"+odate+"' ,'MM/DD/YY')," 
                    + "'" + refno+ "',"
                    + "'"+descr+"',"+Float.parseFloat(td)+","+Float.parseFloat(tc)+ ")";
             
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
    public ArrayList<String> find_all_sm_name_by_code(Connection conn) throws SQLException, SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from EMPREC ORDER BY lower(NAME) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("NAME"));
                //System.out.println("NAME: " + resultset.getString("NAME").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_supp_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from CLIENTS ORDER BY lower(NAME) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("NAME"));
                //System.out.println("NAME: " + resultset.getString("NAME").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public String find_sm_name_by_code(Connection conn, String code) throws SQLException {
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
    public String find_supp_name_by_code(Connection conn, String code) throws SQLException {
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
    public String find_sm_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from EMPREC WHERE NAME='"+name+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("CODE");
        }else{
            cat=null;
        }
        return cat;
    }
    
    public String find_supp_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CLIENTS WHERE NAME='"+name+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("CODE");
        }else{
            cat=null;
        }
        return cat;
    }
    public ArrayList<String>[] search_products(Connection conn, String asset_rec) throws SQLException {
        ArrayList<String> returned[] = new ArrayList[find_count_in_purchase_products(conn,asset_rec)];
	java.sql.Statement statement = conn.createStatement();
//         SELECT * FROM PAYDTL WHERE  DOCNO = 90002 ORDER BY SEQNO ASC
	String Sql = "SELECT * FROM PAYDTL WHERE  DOCNO = '"+asset_rec+"' ORDER BY SEQNO ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {
            returned[i]=getPurchaseProducts(resultset);
            i++;
        }  
        return returned;
    }
     public int find_count_in_purchase_products(Connection conn, String name) {
        int count = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = " SELECT COUNT(SEQNO) AS Count FROM PAYDTL WHERE  DOCNO = '"+name+"'";
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
     public int find_count_in_purchase(Connection conn) {
        int count = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = " SELECT COUNT(DOCNO) AS Count FROM PAYMAIN";
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
     public boolean update_purchase_products_in_table_new(Connection conn, String docno,String accode,String type,String amount,String seqno,String credit){
        boolean var = false;
        try
        {
// docno, accode, type, amount, seqno){
//            DOCNO,ACCODE,TYPE,AMOUNT,SEQNO
                java.sql.Statement statement = conn.createStatement();
                String Sql;
                 Sql="UPDATE PAYDTL SET SEQNO= '"+seqno+"', DEBIT = '"+amount+"', TYPE = '"+type+"', ACCODE = '"+accode+"', CREDIT= '"+credit+
                         "' WHERE DOCNO ="+docno +"AND SEQNO="+seqno;
                 statement.executeQuery(Sql);


                var = true;
//            }else{
//                System.out.println("------------------------------TO BE INSERTED");
//                var = true;
//            }
        }
        catch(SQLException e)
        {
                System.out.println("SQLException:"+e);
                var = false;
        }

        return var;
    }
    public boolean check_product_line_item_presence_new(Connection conn,String string, String seqNoText,int pc) {
        boolean cat=false; 
        java.sql.Statement statement[]=new java.sql.Statement[find_max_in_purchase_products(conn, string)+pc];
        ResultSet result = null;
        try {
            statement[Integer.parseInt(seqNoText)] =  conn.createStatement();
            System.out.println("(DOCNO="+string+") AND (SEQNO="+seqNoText+")");
            String Sql = "select * from PAYDTL ";
            result=statement[Integer.parseInt(seqNoText)].executeQuery(Sql);
            Sql = "select * from PAYDTL WHERE (DOCNO='"+string+"') AND (SEQNO='"+seqNoText+"') ";

            result=statement[Integer.parseInt(seqNoText)].executeQuery(Sql);
            while(result.next()){
                System.out.println(seqNoText+"SEQNO->"+result.getString("SEQNO"));
                if(seqNoText.toString().equals(result.getString("SEQNO").toString())){
                    System.out.println("MATCHED");;
                    cat = true;
                    return cat;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    public boolean check_product_line_item_description_presence_new(Connection conn,String docno, String seqNoText) {
        boolean cat=false;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from SUPPLEG WHERE DOCNO='"+docno+"' AND DESCR  LIKE '"+seqNoText+"%'";
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            System.out.println("seqNoText ==:::=== "+seqNoText);
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
    public int find_max_in_purchase_code(Connection conn) {
        int max = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "Select MAX(DOCNO))as ID from PAYMAIN";
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
    public boolean insert_purchase_products_in_table(Connection conn,String docno,String accode,String type,String amount,String seqno,String  credit){
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            
            String Sql = "INSERT INTO PAYDTL(DOCNO,ACCODE,TYPE,DEBIT,SEQNO,CREDIT) VALUES ('"
                    + Integer.parseInt(docno)+"','" + Integer.parseInt(accode)+ "','"
                    +type+"','"+Float.parseFloat(amount)+"','"+Integer.parseInt(seqno)+"','"+Float.parseFloat(credit)+"')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }
        return var;
    }
    private ArrayList<String> getPurchaseProducts(ResultSet result) {
        ArrayList<String>  cat=new <String>ArrayList();
        try {
//            DOCNO,ACCODE,TYPE,AMOUNT,SEQNO
            String code = result.getString("DOCNO");
                String c = result.getString("ACCODE");
                String co = result.getString("TYPE");
                String ad2 = result.getString("DEBIT");
                String add = result.getString("SEQNO");
                String add1 = result.getString("CREDIT");
                cat.add(0,code );
                cat.add(1,c );
                cat.add(2,co );
                cat.add(3,ad2 );
                cat.add(4,add );
                cat.add(5,add1 );
            
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    private ArrayList<String> getPurchase(ResultSet result) {
        ArrayList<String>  cat=new <String>ArrayList();
        try {
//                DOCNO,ODATE,REFNO,DESCR,TD,TC
                String code = result.getString("DOCNO");
                String c = result.getString("ODATE");
                String co = result.getString("REFNO");
                String ad2 = result.getString("DESCR");
                String add = result.getString("TD");
                String d = result.getString("TC");
                cat.add(0,code );
                cat.add(1,c );
                cat.add(2,co );
                cat.add(3,ad2 );
                cat.add(4,add );
                cat.add(5,d );
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    private ArrayList<String> getInstalments(ResultSet result) {
        ArrayList<String>  cat=new <String>ArrayList();
        try {
                String code = result.getString("REQDATE");
                String c = result.getString("INSTAMOUNT");
                String co = result.getString("PCYCLE");
                String co1 = result.getString("NUMINST");
                String ad2 = result.getString("REMAMOUNT");
                String add = result.getString("RECAMOUNT");
                String d = result.getString("LASTPAMENT");
                cat.add(0,code );
                cat.add(1,c );
                cat.add(2,co );
                cat.add(3,co1 );
                cat.add(4,ad2 );
                cat.add(5,add );
                cat.add(6,d );
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
    public boolean find_recovery_presence(Connection conn,String s) {
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = " select * from RMAIN WHERE DOCNO="+s;
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            if(result.next()){
                var=true;
            }else{
                var=false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return var;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //======================================================================================================================================================
    //======================================================================================================================================================
    //======================================================================================================================================================
    
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

    public ArrayList<String> find_installment_by_code(Connection conn, String text) {
        ArrayList<String> cat=null;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from RMAIN WHERE DOCNO="+text;
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            cat = new ArrayList<String>();
            
            if(result.next()){
//                cat=getPurchase(result);
                cat=getInstalments(result);
            }else{
                cat=null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
    public String find_product_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from SUPP WHERE NAME='"+name+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("CODE");
        }else{
            cat=null;
        }
        return cat;
    }

    public String find_product_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from SUPP WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("NAME");
            System.out.println("result.getString(\"NAME\")"+result.getString("NAME"));
        }else{
            cat=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_product_name_size_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from SUPP ORDER BY lower(NAME) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("NAME"));
                //System.out.println("NAME: " + resultset.getString("PNAME").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public String find_product_rec_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select NAME from SUPP WHERE CODE='"+code+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String  cat=null;

        if(result.next()){
                cat = result.getString("NAME");
        }else{
            cat=null;
        }
        return cat;
    }

    private ArrayList<String> getRecords(ResultSet result) {
        ArrayList<String> cat=null;
        try {
            cat = new ArrayList<String>();
            
            if(result.next()){
                String code = result.getString("CODE");
                String assetName = result.getString("NAME");
                String assetName1 = result.getString("OTHERDESC");
                cat.add(0,code);
                cat.add(1,assetName);
                cat.add(2,assetName1);
            }else{
                cat.add(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }

    public String get_clbal_from_supp(Connection conn, String code) {
        String  cat=null;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select CLBAL from SUPP WHERE CODE='"+code+"'";
            
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                cat = result.getString("CLBAL");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("==cat : " + cat);
        return cat;
    }

    public boolean update_clbal_in_supp(Connection conn, String b, String docno) {
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql;
            
            Sql="UPDATE SUPP SET  CLBAL = '"+b+"'WHERE CODE ="+docno;
            statement.executeUpdate(Sql);
            
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }

        return var;    
    }

    public String[] get_accode_type_debit_credit(Connection conn1a, String s4, String s5) {
        String cat[] = new String[4];
        try {
            java.sql.Statement statement = conn1a.createStatement();
            String Sql = "select ACCODE,TYPE,DEBIT,CREDIT from PAYDTL WHERE DOCNO ="+s4+" AND SEQNO ="+s5;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){//DOCNO,,,AMOUNT,SEQNO
                cat[0] = result.getString("ACCODE");
                cat[1] = result.getString("TYPE");
                cat[2] = result.getString("DEBIT");
                cat[3] = result.getString("CREDIT");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
}
