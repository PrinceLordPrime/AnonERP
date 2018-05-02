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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logical.Conversions;

/**
 *
 * @author Shan
 */
public class PAK_ORDER_DB extends PAK_GLOBAL_DB{
    public boolean insert_purchase_products_in_table(Connection conn,String seqno,String duedate,String description,String dueamount,String rcdate,String rcamount,String docno){
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "INSERT INTO RDTL(SEQNO,DUEDATE,DESCRIPTION,DUEAMOUNT,RCDATE,RCAMOUNT,DOCNO) VALUES ("
                    + Integer.parseInt(seqno)+ ", TO_DATE('"+duedate+"' ,'MM/DD/YY')" 
                    + ",'" +description
                    + "'," + Float.parseFloat(dueamount)+ ","
                    + "TO_DATE('"+rcdate+"' ,'MM/DD/YY'),"+Float.parseFloat(rcamount)+","
                    +Integer.parseInt(docno)+")";
                   
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
    public String get_clqty_wrt_pmast_code(Connection conn, String seek) {
        String cat=null;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from PMAST WHERE CODE="+seek;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("CLQTY");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
    public String get_delivered_wrt_perdtl_code_seek(Connection conn, String a, String b) {
        String cat=null;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from ORDERDTL WHERE PCODE="+a+" AND DOCNO ="+b;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("DELIVERED");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    public String get_delivered_wrt_seqno(Connection conn, String seqno, String docno) {
        String cat=null;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from ORDERDTL WHERE SEQNO="+seqno+" AND DOCNO ="+docno;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("DELIVERED");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    public String check_product_line_item_presence_with_seek(Connection conn,String string, String seqNoText,String seekText,int pc) {
        String cat="false"; 
        java.sql.Statement statement[]=new java.sql.Statement[find_max_in_purchase_products(conn, string)+pc];
        ResultSet result = null;
        try {
            statement[Integer.parseInt(seqNoText)] =  conn.createStatement();
            
            String Sql = null;
            Sql = "select * from ORDERDTL WHERE (DOCNO='"+string+"') AND (SEQNO='"+seqNoText+"') ";

            result=statement[Integer.parseInt(seqNoText)].executeQuery(Sql);
            while(result.next()){
                System.out.println(seqNoText+"SEQNO->"+result.getString("SEQNO"));
                System.out.println(seqNoText+"PCODE->"+result.getString("PCODE"));
//                if((!seekText.equals(result.getString("PCODE")))&&(seqNoText.toString().equals(result.getString("SEQNO").toString()))){
//                    return "true";
//                }else{
//                    cat= result.getString("PCODE");
//                }
                
                if(seekText.equals(result.getString("PCODE"))){
                    return "true";
                }else{
                    cat= result.getString("PCODE")+" "+result.getString("DELIVERED");
                }
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    public boolean update_clqty_in_pmast(Connection conn, String clqty,String code) {
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql;
            
            Sql="UPDATE PMAST SET CLQTY = "+Float.parseFloat(clqty)+" WHERE CODE="+code;
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
    public ArrayList<String> get_last_purchase(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_purchase_code(conn);
        String Sql = "select * from ORDERMAIN WHERE DOCNO="+max;

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
        String returned[][] = new String[find_count_in_purchase(conn)][14];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from ORDERMAIN";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {
                returned[i][0]=resultset.getString("DOCNO");
                returned[i][1]=resultset.getString("REFNO");
//                returned[i][2]=resultset.getString("ODATE");
                try {
                    returned[i][2]=ccc.toDateString(ccc.toDate(resultset.getString("ODATE"))+"");//resultset.getString("DOCDATE");
                } catch (ParseException ex) {
                    Logger.getLogger(PAK_SELLERLEDGER_DB.class.getName()).log(Level.SEVERE, null, ex);
                }
                returned[i][3]=find_cust_rec_name_by_code(conn, resultset.getString("CUSTCODE"));//get Name
                returned[i][4]=find_sm_name_by_code(conn, resultset.getString("DCODE"));//get Name
                returned[i][5]=resultset.getString("TGROSSAMT");
                returned[i][6]=resultset.getString("TDISCRS");
                returned[i][7]=resultset.getString("TTAXRS");
                returned[i][8]=resultset.getString("TNETAMOUNT");
                returned[i][9]=resultset.getString("SPLRS");
                returned[i][10]=resultset.getString("OTHEREXP");
                returned[i][11]=resultset.getString("NETPAYABLE");
                returned[i][12]=resultset.getString("PAID");
                returned[i][13]=resultset.getString("REMAINING");
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
    public String find_cust_rec_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CLIENTS WHERE CODE='"+code+"'";

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
    public ArrayList<String> next_purchase(Connection conn, String code){
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM ORDERMAIN WHERE DOCNO > "+Integer.parseInt(code)+" ORDER BY DOCNO";            
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
            
            Sql="SELECT * FROM ORDERMAIN WHERE DOCNO <"+Integer.parseInt(code)+" ORDER BY DOCNO DESC ";
            
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
            Sql = "select * from ORDERMAIN WHERE DOCNO="+min;//+"AND CREDITAMOUNT > "+Integer.parseInt("0");
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
                Sql = "Select MIN(TO_NUMBER(DOCNO))as ID from ORDERMAIN ";
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

            Sql = "DELETE FROM ORDERMAIN WHERE DOCNO = "+code;
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

            Sql = "DELETE FROM ORDERDTL WHERE DOCNO = '"+docno+"'";
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

            Sql = "DELETE FROM ORDERDTL WHERE DOCNO = '"+docno+"' AND SEQNO = '"+seqno+"'";
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
        String Sql = "select * from ORDERMAIN WHERE DOCNO="+code;

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
    public boolean update_purchase(Connection conn,  String odate,String dldate,String  docno,String  refno,String  supcode,String  tgrossamt,String  splper,String  splrs,String  otherexp,String  avdiscper,String  tdiscrs,String  avtaxper,String  ttaxrs,String  tnetamount,String  remaning,String  paid,String  remarks,String netpayable,String dealerCode,String status){
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql;
//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,SPLPER,SPLRS,OTHEREXP,AVDISCPER,TDISCRS,AVTAXPER,TTAXRS,TNETAMOUNT,REMAINING,
//PAID,REMARKS,NETPAYABLE,DCODE
             Sql="UPDATE ORDERMAIN SET AVDISCPER= '"+avdiscper+"', REFNO = '"+refno+"', CUSTCODE = '"+supcode+
                     "',TGROSSAMT = '"+tgrossamt+"',REMARKS= '"+remarks+"',ODATE= TO_DATE('" + odate +
                     "' , 'MM/DD/YY') ,DLDATE= TO_DATE('" + dldate +
                     "' , 'MM/DD/YY') ,SPLPER= '"+splper+"',SPLRS= '"+splrs+"',OTHEREXP = '"+otherexp+
                     "',TDISCRS = '"+tdiscrs+"',AVTAXPER = '"+avtaxper+"',TTAXRS = '"+ttaxrs+"',TNETAMOUNT = '"+
                     tnetamount+"',REMAINING = '"+remaning+"',PAID = '"+paid+"',NETPAYABLE = '"+netpayable+
                     "',DCODE = '"+dealerCode+
                     "',STATUS = '"+status+"' WHERE DOCNO ="+docno;
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
            String Sql = " SELECT MAX(SEQNO) AS Count FROM ORDERDTL WHERE  DOCNO = '"+name+"'";
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
    public boolean insert_purchase_in_table(Connection conn,  String odate, String dldate,String  docno,String  refno,String  supcode,
            String  tgrossamt,String  splper,String  splrs,String  otherexp,String  avdiscper,String  tdiscrs,String  avtaxper,
            String  ttaxrs,String  tnetamount,String  remaning,String  paid,String  remarks,String netpayable,String dealerCode,String status){
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "INSERT INTO ORDERMAIN(ODATE,DLDATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,SPLPER,SPLRS,OTHEREXP,AVDISCPER,"
                    + "TDISCRS,AVTAXPER,TTAXRS,TNETAMOUNT,REMAINING,PAID,REMARKS,NETPAYABLE,DCODE,STATUS) "
                    + "VALUES (TO_DATE('"+odate+"' ,'MM/DD/YY'), TO_DATE('"+dldate+"' ,'MM/DD/YY'),'" 
                    + Integer.parseInt(docno)+ "','" +refno+ "',"
                    + "'"+Integer.parseInt(supcode)+"','"+Float.parseFloat(tgrossamt)+"','"+Float.parseFloat(splper)+"','"+Float.parseFloat(splrs)+"',"
                    + "'"+Float.parseFloat(otherexp)+"','"+Float.parseFloat(avdiscper)+"','"+Float.parseFloat(tdiscrs)
                    + "','"+Float.parseFloat(avtaxper)+"','"+Float.parseFloat(ttaxrs)+"','"+Float.parseFloat(tnetamount)+"',"
                    + "'"+Float.parseFloat(remaning)+"','"+Float.parseFloat(paid)+"','"+remarks+"','"+Float.parseFloat(netpayable)+"','" + Integer.parseInt(dealerCode)+"','"+status+ "')";
             
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
    public boolean insert_instalments_in_table(Connection conn,String docno,String pcode,String numinst,String pcycle,String reqdate,String instamount,String lastpament,String recamount,String remamount){
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "INSERT INTO RMAIN(DOCNO,PCODE,NUMINST,PCYCLE,REQDATE,INSTAMOUNT,LASTPAMENT,RECAMOUNT,REMAMOUNT) VALUES ('"
                    +Integer.parseInt(docno)+ "','" + Integer.parseInt(pcode)+ "',"
                    + "'"+Integer.parseInt(numinst)+"','"+pcycle+"',"+" TO_DATE('"+reqdate+"' ,'MM/DD/YY'),'" 
                    +Float.parseFloat(instamount)+"','"+Float.parseFloat(lastpament)+"',"
                    + "'"+Float.parseFloat(recamount)+"','"+Float.parseFloat(remamount)+ "')";
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
//         SELECT * FROM ORDERDTL WHERE  DOCNO = 90002 ORDER BY SEQNO ASC
	String Sql = "SELECT * FROM ORDERDTL WHERE  DOCNO = '"+asset_rec+"' ORDER BY SEQNO ASC";
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
            String Sql = " SELECT COUNT(SEQNO) AS Count FROM ORDERDTL WHERE  DOCNO = '"+name+"'";
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
            String Sql = " SELECT COUNT(DOCNO) AS Count FROM ORDERMAIN";
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
     public boolean update_purchase_products_in_table_new(Connection conn, String   docno, String seqno, String pcode, String perqty, String perrate,String grossamount, String discper, String discrs, String taxper, String taxrs, String netamount,String returnqty, String delivered,
             String held,
             String dmg,
             String free,
             String customSize){
        boolean var = false;
        try
        {
//            if(check_product_line_item_presence_new(conn, docno, seqno)){
                java.sql.Statement statement = conn.createStatement();
                String Sql;
                 Sql="UPDATE ORDERDTL SET SEQNO= '"+seqno+"', PCODE = '"+pcode+"', SALEQTY = '"+perqty+"',SALERATE = '"+perrate+"',GROSSAMOUNT= '"+grossamount+"',DISCPER= '"+discper+"',DISCRS= '"+discrs+"',TAXPER = '"+taxper+"',TAXRS = '"+taxrs+"',"+ "NETAMOUNT = '"+netamount+"',"+ "RETURNQTY = '"+returnqty+"'," + "DELIVERED = '"+delivered+"',"+ "HELD = '"+held+"',"+ "DMG = '"+dmg+"',"+ "FREE = '"+free+"',"+ "CUSTOMSIZE = '"+customSize+"'"+ " WHERE DOCNO ="+docno +"AND SEQNO="+seqno;
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
            String Sql = "select * from ORDERDTL ";
            result=statement[Integer.parseInt(seqNoText)].executeQuery(Sql);
            Sql = "select * from ORDERDTL WHERE (DOCNO='"+string+"') AND (SEQNO='"+seqNoText+"') ";

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
    public int find_max_in_purchase_code(Connection conn) {
        int max = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(DOCNO))as ID from ORDERMAIN";
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
    public boolean insert_purchase_products_in_table(Connection conn,String docno,String seqno,String pcode,String perqty,
            String perrate,String grossamount,String discper,String discrs,String taxper,String taxrs,
            String netamount , String returnqty,String delivered,
            String held, 
            String dmg, 
            String free, 
            String customSize){
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
//            if(!check_product_line_item_presence(conn, docno, seqno)){
//DOCNO,SEQNO,PCODE,SALEQTY,SALERATE,GROSSAMOUNT,DISCPER,DISCRS,TAXPER,TAXRS,NETAMOUNT,
            //UNITTYPE,SIDEA,SIDEB,TOTALSIZE,RETURNQTY
            String Sql = "INSERT INTO ORDERDTL(DOCNO,SEQNO,PCODE,SALEQTY,SALERATE,GROSSAMOUNT,"
                    + "DISCPER,DISCRS,TAXPER,TAXRS,NETAMOUNT,RETURNQTY,DELIVERED,HELD,DMG,FREE,CUSTOMSIZE) VALUES ('"
                    + Integer.parseInt(docno)+"','" + Integer.parseInt(seqno)+ "','"
                    +Float.parseFloat(pcode)+"','"+Float.parseFloat(perqty)+"','"+Float.parseFloat(perrate)+"','"
                    +Float.parseFloat(grossamount)+"','"+Float.parseFloat(discper)+"','"+Float.parseFloat(discrs)
                    + "','"+Float.parseFloat(taxper)+"','"+Float.parseFloat(taxrs)+"','"+Float.parseFloat(netamount)+"',"
                    +"'"+Float.parseFloat(returnqty)+"','"+Float.parseFloat(delivered)+"','"+Float.parseFloat(held)+"','"+Float.parseFloat(dmg)+"','"+Float.parseFloat(free)+"','"+customSize+"')";
            statement.executeUpdate(Sql);
//            }
            var = true;
        }
        catch(SQLException e)
        {
            System.out.println("Error Log :"+e);
            var = false;
        }
        return var;
    }
    private ArrayList<String> getPurchaseProducts(ResultSet result) {
        ArrayList<String>  cat=new <String>ArrayList();
        try {
//            DOCNO,SEQNO,PCODE,SALEQTY,SALERATE,GROSSAMOUNT,DISCPER,DISCRS,TAXPER,TAXRS,NETAMOUNT
            String code = result.getString("DOCNO");
                String c = result.getString("SEQNO");
                String co = result.getString("PCODE");
                String ad2 = result.getString("SALEQTY");
                String add = result.getString("SALERATE");
                String d = result.getString("GROSSAMOUNT");
                String d1 = result.getString("DISCPER");
                String am = result.getString("DISCRS");
                String n1 = result.getString("TAXPER");
                String co2 = result.getString("TAXRS");
                String add1 = result.getString("NETAMOUNT");
                String add6 = result.getString("RETURNQTY");
                String add7 = result.getString("DELIVERED");
                String add8 = result.getString("HELD");
                String add81 = result.getString("CUSTOMSIZE");                String add82 = result.getString("DMG");

                String add83 = result.getString("FREE");
                /*
                Date add813 = result.getDate("EXPIRYDATE");
                String myDateString="";
                if(add813!=null){
                
                    SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-mm-dd");
                    Date myDate = null;
                    try {
                        myDate = newDateFormat.parse(add813+"");
                    } catch (ParseException ex) {
                        Logger.getLogger(PAK_ORDER_DB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    newDateFormat.applyPattern("MM/DD/YY");
                    myDateString = newDateFormat.format(myDate);
                }*/
                cat.add(0,code );
                cat.add(1,c );
                cat.add(2,co );
                cat.add(3,ad2 );
                cat.add(4,add );
                cat.add(5,d );
                cat.add(6,d1 );
                cat.add(7,am );
                cat.add(8,n1 );
                cat.add(9,co2 );
                cat.add(10,add1 );
                cat.add(11,add6 );
                cat.add(12,add7 );
                cat.add(13,add8 );
                cat.add(14,add81 );
                cat.add(15,add82 );
                cat.add(16,add83 );
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    private ArrayList<String> getPurchase(ResultSet result) {
        ArrayList<String>  cat=new <String>ArrayList();
        try {
                String code = result.getString("ODATE");
                String c = result.getString("DOCNO");
                String co = result.getString("REFNO");
                String ad2 = result.getString("CUSTCODE");
                String add = result.getString("TGROSSAMT");
                String d = result.getString("SPLPER");
                String d1 = result.getString("SPLRS");
                String am = result.getString("OTHEREXP");
                String n1 = result.getString("AVDISCPER");
                String c1 = result.getString("TDISCRS");
                String co1 = result.getString("AVTAXPER");
                String co2 = result.getString("TTAXRS");
                String add1 = result.getString("TNETAMOUNT");
                String d2 = result.getString("REMAINING");
                String am1 = result.getString("PAID");
                String rem = result.getString("REMARKS");
                String np = result.getString("NETPAYABLE");
                String np1 = result.getString("DCODE");
                String np12 = result.getString("STATUS");
                String np123 = result.getString("DLDATE");
                cat.add(0,code );
                cat.add(1,c );
                cat.add(2,co );
                cat.add(3,ad2 );
                cat.add(4,add );
                cat.add(5,d );
                cat.add(6,d1 );
                cat.add(7,am );
                cat.add(8,n1 );
                cat.add(9,c1 );
                cat.add(10,co1 );
                cat.add(11,co2 );
                cat.add(12,add1 );
                cat.add(13,d2 );
                cat.add(14,am1 );
                cat.add(15,rem );
                cat.add(16,np );
                cat.add(17,np1 );            
                cat.add(18,np12 );            
                cat.add(19,np123 );            
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
            Logger.getLogger(PAK_ORDER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }

    public String get_clbal_from_clints(Connection conn, String code) {
        String  cat=null;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select CLBAL from CLIENTS WHERE CODE='"+code+"'";
            
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
    public String[] get_clbal_previousBal_from_clints(Connection conn, String code) {
        String cat[] = new String[2];
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select CLBAL,PREVIOUSBAL from CLIENTS WHERE CODE='"+code+"'";
            
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                cat[0] = result.getString("CLBAL");
                cat[1] = result.getString("PREVIOUSBAL");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("==cat : " + cat);
        return cat;
    }

    public boolean update_clbal_in_clints(Connection conn, String string, String text) {
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql;
            
            Sql="UPDATE CLIENTS SET  CLBAL = '"+string+"'WHERE CODE ="+text;
            statement.executeUpdate(Sql);
            
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }

        return var;  
    }

    public String[] get_invNo_clientCode_paid(Connection conn, String string) {
        String cat[] = new String[3];
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from ORDERMAIN WHERE DOCNO ="+string;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat[0] = result.getString("DOCNO");
                cat[1] = result.getString("CUSTCODE");
                cat[2] = result.getString("PAID");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    public String[] get_invNo_clientCode_remaining(Connection conn, String string) {
        String cat[] = new String[3];
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from ORDERMAIN WHERE DOCNO ="+string;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat[0] = result.getString("DOCNO");
                cat[1] = result.getString("CUSTCODE");
                cat[2] = result.getString("REMAINING");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    public String get_status(Connection conn, String string) {
        String cat =null;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from ORDERMAIN WHERE DOCNO ="+string;

            ResultSet result = null;
            result=statement.executeQuery(Sql);

            if(result.next()){
                cat = result.getString("STATUS");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }

    public boolean check_availableInstalment(Connection conn,String string) {
        boolean b=false;
         try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from RDTL WHERE DOCNO ="+string;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                b=true;
                return b;
                
            }else{
                b=false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    public boolean check_delivered_presence(Connection conn, String docno) {
        boolean var = true;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql=null;
             ResultSet result = null;
            Sql = "Select * FROM ORDERDTL WHERE DOCNO = '"+docno+"'";
            result = statement.executeQuery(Sql);
            
            while(result.next()){
                float zero=0;
                float d=Float.parseFloat(result.getString("DELIVERED"));
                if(d!=zero){
                    return false;
                }
            }
        }
        catch(SQLException e)
        {
            JFrame j=new JFrame();
            j.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(j, "check_delivered_presence , SQLException : "+e, "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }

        return var;
    }
    public boolean check_one_delivered_wrt_seqNo(Connection conn, String docno, String seqno) {
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql=null;
             ResultSet result = null;
            Sql = "Select * FROM ORDERDTL WHERE DOCNO = '"+docno+"' AND SEQNO="+seqno;
            result = statement.executeQuery(Sql);
            
            if(result.next()){
                float zero=0;
                float d=Float.parseFloat(result.getString("DELIVERED"));
                if(d==zero){
                    return true;
                }
            }else{
                return true;
            }
        }
        catch(SQLException e)
        {
            JFrame j=new JFrame();
            j.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(j, "check_delivered_presence , SQLException : "+e, "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }

        return var;
    }

    public ArrayList<String>[] get_pending_orders(Connection conn,String custCode) {
        ArrayList<String> returned1[]=null;
        try {
            String asset_rec ="P";
            String returned[] = new String[find_count_in_purchase_products_status_custCode(conn,asset_rec,custCode)];
            
            java.sql.Statement statement = conn.createStatement();
            ResultSet resultset =null;
            java.sql.Statement statement1 = conn.createStatement();
            ResultSet resultset1 =null;
            
            String Sql = "SELECT DOCNO FROM ORDERMAIN WHERE  STATUS = '"+asset_rec+"' AND  CUSTCODE ='"+custCode+"'";
            resultset = statement.executeQuery(Sql);
             int i=0;
            while(resultset.next())
            {
                returned[i]=resultset.getString("DOCNO");
                i++;
            }
            
            returned1 = new ArrayList[find_count_in_purchase_products_held(conn,returned)];
            
            int ij=0;
            for (int j = 0; j < returned.length; j++) {
                String Sql1 = "SELECT * FROM ORDERDTL WHERE  HELD <> 0 AND  DOCNO ='"+returned[j]+"'";
                resultset1 = statement1.executeQuery(Sql1);
                while(resultset1.next())
                {
                    returned1[ij]=getPurchaseProducts(resultset1);
                    ij++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_ORDER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returned1;
    }

    private int find_count_in_purchase_products_status_custCode(Connection conn, String asset_rec, String custCode) {
        int count = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = " SELECT COUNT(DOCNO) AS Count FROM ORDERMAIN WHERE   STATUS = '"+asset_rec+"' AND  CUSTCODE ='"+custCode+"'";
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

    private int find_count_in_purchase_products_held(Connection conn, String[] returned) {
        int count = 0;
        try
        {
            for (int i = 0; i < returned.length; i++) {
                String returned1 = returned[i];
                java.sql.Statement statement = conn.createStatement();
                String Sql = " SELECT COUNT(DOCNO) AS Count FROM ORDERDTL WHERE  HELD <> 0 AND  DOCNO ='"+returned1+"'";
                ResultSet result = null;
                result=statement.executeQuery(Sql);
                result.next();
                String temp=result.getString("Count");
                int temp1=0;
                if(temp==null){
//                    count=0;
                }else{
                     temp1 = Integer.parseInt(temp);
                }
                count=count+temp1;
            }
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            count = 0;
        }
        return count;
    }

    public boolean check_update_delivered_held(Connection conn, String docno, String seqno,String saleqty) {
        boolean f=false;
        try {
            java.sql.Statement statement = conn.createStatement();
            ResultSet result = null;
            String Sql=null;
            
            java.sql.Statement statement1 = conn.createStatement();
            String Sql1=null;
            
            Sql = "Select * FROM ORDERDTL WHERE DOCNO = '"+docno+"' AND SEQNO="+seqno;
            result = statement.executeQuery(Sql);
            
            if(result.next()){
                float saleqtyF=Float.parseFloat(saleqty);
                float delivered=Float.parseFloat(result.getString("DELIVERED"));
                float held=Float.parseFloat(result.getString("HELD"));
                float resDelivered=delivered+saleqtyF;
                float resHeld=held-saleqtyF;
                System.out.println("delivered"+delivered);
                System.out.println("saleqtyF"+saleqtyF);
                System.out.println("held"+held);
                Sql1="UPDATE ORDERDTL SET DELIVERED = '"+(resDelivered+"")+"',"
                         + "HELD = '"+(resHeld+"")+"'"
                         + " WHERE DOCNO ="+docno +"AND SEQNO="+seqno;
                 statement1.executeQuery(Sql1);
                 f=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_ORDER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }
    
    
    public String[][] search_history(Connection conn, String text,String bff) {
        String returned[][] = new String[find_count_in_order_dtl(conn,text)][5];
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "Select * from ORDERDTL where ROWNUM <= 30 AND  PCODE='"+text+"' ORDER BY DOCNO DESC";
//            String Sql = "Select * from ORDERDTL where PCODE='"+text+"' ORDER BY DOCNO DESC LIMIT 2";
            ResultSet resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {
                if(hasBff(conn,bff,resultset.getString("DOCNO"))){
                    //DOCNO,SALEQTY,SALERATE,DISCPER,TOTALSIZE,RETURNQTY
                    returned[i][0]=resultset.getString("DOCNO");
                    returned[i][1]=find_date_by_code(conn,resultset.getString("DOCNO"));
                    returned[i][2]=resultset.getString("SALEQTY");
                    returned[i][3]=resultset.getString("SALERATE");
                    returned[i][4]=resultset.getString("DISCPER");
                    //System.out.println("Code: " + resultset.getString("CODE")+"\n TYPE: " + resultset.getString("DISTRICT"));
                    i++;
                }
            }
        } catch (SQLException ex) {
            System.out.println(""+ex);
            Logger.getLogger(PAK_SALE_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returned;
    }

    public int find_count_in_order_dtl(Connection conn, String name) {
        int count = 0;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql = " SELECT COUNT(SEQNO) AS Count FROM ORDERDTL WHERE  PCODE = '"+name+"'";
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

    private String find_date_by_code(Connection conn, String string) {
        String cat="";
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from ORDERMAIN WHERE DOCNO="+string;
            
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                //cat = result.getString("ODATE");
                cat = ccc.toDateString(ccc.toDate(result.getString("ODATE"))+"");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            System.out.println(""+ex);
            Logger.getLogger(PAK_SALE_DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PAK_ORDER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    private String find_docNo_by_code(Connection conn, String string) {
        String cat="";
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from ORDERMAIN WHERE DOCNO="+string;
            
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                //cat = result.getString("ODATE");
                cat =result.getString("REFNO");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            System.out.println(""+ex);
            Logger.getLogger(PAK_SALE_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    private boolean hasBff(Connection conn ,String bff,String doc) {
        boolean isPresent=false;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from ORDERMAIN WHERE CUSTCODE='"+bff+"' AND DOCNO ='"+doc+"'";
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            if(result.next()){
                isPresent=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,SPLPER,SPLRS,OTHEREXP,AVDISCPER,"
//                    + "TDISCRS,AVTAXPER,TTAXRS,TNETAMOUNT,REMAINING,PAID,REMARKS,NETPAYABLE,DCODE
        return isPresent;
    }

}
