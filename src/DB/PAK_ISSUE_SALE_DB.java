/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import logical.Conversions;

/**
 *
 * @author Shan
 */
public class PAK_ISSUE_SALE_DB extends PAK_GLOBAL_DB{
    public boolean insert_purchase_products_in_table(Connection conn,String seqno,String duedate,String description,String dueamount,String rcdate,String rcamount,String docno){
        boolean var = false;
        java.sql.Statement statement =null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO RDTL(SEQNO,DUEDATE,DESCRIPTION,DUEAMOUNT,RCDATE,RCAMOUNT,DOCNO) VALUES ("
                    + Integer.parseInt(seqno)+ ", DATE('"+duedate+"' ,'MM/DD/YY')" 
                    + ",'" +description
                    + "'," + Float.parseFloat(dueamount)+ ","
                    + "DATE('"+rcdate+"' ,'MM/DD/YY'),"+Float.parseFloat(rcamount)+","
                    +Integer.parseInt(docno)+")";
                   
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }
    public String get_clqty_wrt_pmast_code(Connection conn, String seek) {
        String cat=null;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PMAST WHERE CODE="+seek;

            result=statement.executeQuery(Sql);
            
            //System.out.println("Result : " + result);

            if(result.next()){
               
               cat = result.getString("CLQTY");
               
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            System.out.println("ex : "+ex);
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    
    public String get_perqty_wrt_perdtl_code_seek(Connection conn, String a, String b,String c) {
        String cat=null;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from ISDTL WHERE PCODE="+a+"AND SEQNO="+c+"AND DOCNO ="+b;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = (Float.parseFloat(result.getString("SALEQTY"))+Float.parseFloat(result.getString("DMG"))+Float.parseFloat(result.getString("FREE")))+"";
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public String check_product_line_item_presence_with_seek(Connection conn,String string, String seqNoText,String seekText,int pc) {
        String cat="false"; 
        java.sql.Statement statement[]=new java.sql.Statement[find_max_in_purchase_products(conn, string)+pc];
        ResultSet result = null;
        try {
            statement[Integer.parseInt(seqNoText)] =  conn.createStatement();
            try {
                String Sql = null;
                Sql = "select * from ISDTL WHERE (DOCNO='"+string+"') AND (SEQNO='"+seqNoText+"') ";

                result=statement[Integer.parseInt(seqNoText)].executeQuery(Sql);

                while(result.next()){
                    System.out.println(seqNoText+"SEQNO->"+result.getString("SEQNO"));
                    System.out.println(seqNoText+"PCODE->"+result.getString("PCODE"));

                    if(seekText.equals(result.getString("PCODE"))){
                        return "true";
                    }else{
                        cat= result.getString("PCODE")+" "+(Float.parseFloat(result.getString("SALEQTY"))+Float.parseFloat(result.getString("DMG"))+Float.parseFloat(result.getString("FREE")))+"";
                    }


                }
            } catch (SQLException ex) {} finally{
                try{
                    if (statement[Integer.parseInt(seqNoText)] != null) statement[Integer.parseInt(seqNoText)].close();
                }catch(SQLException e){}
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public boolean update_clqty_in_pmast(Connection conn, String clqty,String code) {
        boolean var = false;
        java.sql.Statement statement=null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
//            System.out.println("=========="+clqty);
//            System.out.println("=========="+code);
            Sql="UPDATE PMAST SET CLQTY = "+Float.parseFloat(clqty)+" WHERE CODE="+code;
            
//            System.out.println("=========="+Sql);
            int r = statement.executeUpdate(Sql);
//            System.out.println("=========="+r);
            if(r!=0){
                var = true;
            }
            
        }
        catch(SQLException e)
        {
            System.out.println("SQLException:"+e);
                var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return var;
    }
    public ArrayList<String> get_last_purchase(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat = null;
        try{
            int max=find_max_in_purchase_code(conn);
            String Sql = "select * from ISMAIN WHERE DOCNO="+max;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();
            if(result.next()){
                cat=getPurchase(result);
            }else{
                cat=null;
            }
        }catch(SQLException ex){
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public ArrayList<String> get_last_sm_purchase(Connection conn,String sm) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat =null;         
        try{
            int max=find_max_in_sm_purchase_code(conn,sm);
            String Sql = "select * from ISMAIN WHERE DOCNO="+max;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                cat=getPurchase(result);
            }else{
                cat=null;
            }
        }catch(SQLException ex){}finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        
        return cat;
    }
    Conversions ccc =new Conversions();
    public String[][] search_sales(Connection conn, String distrec) throws SQLException {
//        /*
        ResultSet result =null;
        java.sql.Statement statement = null;
        String returned[][] = new String[find_count_in_purchase(conn)][14];
        try{
            statement = conn.createStatement();
            String Sql = "Select * from ISMAIN";
            result = statement.executeQuery(Sql);
            int i=0;
            while(result.next())
            {
                    returned[i][0]=result.getString("DOCNO");
                    returned[i][1]=result.getString("REFNO");
    //                returned[i][2]=result.getString("ODATE");
                    try {
                        returned[i][2]=ccc.toDateString(ccc.toDate(result.getString("ODATE"))+"");//resultset.getString("DOCDATE");
                    } catch (ParseException ex) {
                        Logger.getLogger(PAK_SELLERLEDGER_DB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    returned[i][3]=find_cust_rec_name_by_code(conn, result.getString("CUSTCODE"));//get Name
                    returned[i][4]=find_sm_name_by_code(conn, result.getString("DCODE"));//get Name
                    returned[i][5]=result.getString("TGROSSAMT");
                    returned[i][6]=result.getString("TDISCRS");
                    returned[i][7]=result.getString("TTAXRS");
                    returned[i][8]=result.getString("TNETAMOUNT");
                    returned[i][9]=result.getString("SPLRS");
                    returned[i][10]=result.getString("OTHEREXP");
                    returned[i][11]=result.getString("NETPAYABLE");
                    returned[i][12]=result.getString("PAID");
                    returned[i][13]=result.getString("REMAINING");
                    //System.out.println("Code: " + result.getString("CODE")+"\n POST: " + result.getString("ROUTEDESC"));
                    i++;
            }
        }catch(Exception ex){
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return returned;
//        */
    }
    public String find_cust_rec_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        String cat=null;
        try{
            String Sql = "select * from CLIENTS WHERE NAME='"+name+"'";
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("CODE");
            }else{
                cat=null;
            }
        }catch(SQLException ex){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public String find_cust_rec_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        String cat = null;
        try{
            String Sql = "select * from CLIENTS WHERE CODE='"+code+"'";
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("NAME");
            }else{
                cat=null;
            }
        }catch(SQLException ex){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public ArrayList<String> next_purchase(Connection conn, String code){
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
    ResultSet result = null;
    java.sql.Statement statement = null;
       try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM ISMAIN WHERE DOCNO > "+Integer.parseInt(code)+" ORDER BY DOCNO";            
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
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }

        return cat;
    }
    public ArrayList<String> next_sm_purchase(Connection conn, String code,String sm){
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
        ResultSet result = null;
       java.sql.Statement statement = null;
       try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM ISMAIN WHERE DOCNO > "+Integer.parseInt(code)+" AND DCODE ="+sm+" ORDER BY DOCNO";            
            result=statement.executeQuery(Sql);
            
            if(result.next()){
               cat=getPurchase(result);
            }else{
                cat=null;
            }
        }
        catch(SQLException e)
        {
            //System.out.println("SQLException:"+e);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }

        return cat;
    }
    public ArrayList<String> prior_purchase(Connection conn, String code) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
        ResultSet result = null;
        java.sql.Statement statement = null;
       try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM ISMAIN WHERE DOCNO <"+Integer.parseInt(code)+" ORDER BY DOCNO DESC ";
            
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
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }

        return cat;
    }
    public ArrayList<String> prior_sm_purchase(Connection conn, String code,String sm) {
        ArrayList<String> cat = new ArrayList<String>();
        ResultSet result = null;
       java.sql.Statement statement = null;
       try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM ISMAIN WHERE DOCNO <"+Integer.parseInt(code)+" AND DCODE ='"+ sm +"' ORDER BY DOCNO DESC";
            
            result=statement.executeQuery(Sql);
            
            if(result.next()){
                cat=getPurchase(result);
            }else{
                cat=null;
            }
        }
        catch(SQLException e)
        {
            //System.out.println("SQLException:"+e);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }

        return cat;
    }

     public ArrayList<String> get_first_purchase(Connection conn)throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat=null;
        
        try{
            int min=0;
            min=find_min_in_purchase_code(conn);
            if(min!=0){
                String Sql;
                Sql = "select * from ISMAIN WHERE DOCNO="+min;//+"AND CREDITAMOUNT > "+Integer.parseInt("0");
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
        }catch(SQLException ex){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
        
    }
    public ArrayList<String> get_first_sm_purchase(Connection conn,String custCode)throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ArrayList<String> cat=null;
        ResultSet result = null;
        
        try{
            int min=0;
            min=find_min_in_cust_purchase_code(conn,custCode);
            if(min!=0){
                String Sql;
                Sql = "select * from ISMAIN WHERE DOCNO="+min;//+"AND CREDITAMOUNT > "+Integer.parseInt("0");
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
        }catch(SQLException ex){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
        
    }
     public int find_min_in_purchase_code(Connection conn) {
        int min = 0;
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
                Sql = "Select MIN(TO_NUMBER(DOCNO))as ID from ISMAIN ";
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
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return min;
    }
     public int find_min_in_cust_purchase_code(Connection conn,String custCode) {
        int min = 0;
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
                Sql = "Select MIN(TO_NUMBER(DOCNO))as ID from ISMAIN WHERE DCODE="+custCode;
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
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return min;
    }
    public boolean delete_purchase(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        java.sql.Statement statement =null;
        try
        {
            statement= conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM ISMAIN WHERE DOCNO = "+code;
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return var;
    }
    public boolean delete_purchase_products_in_purchase(Connection conn ,String docno) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM ISDTL WHERE DOCNO = '"+docno+"'";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return var;
    }

    public boolean delete_purchase_product(Connection conn ,String docno,String seqno) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM ISDTL WHERE DOCNO = '"+docno+"' AND SEQNO = '"+seqno+"'";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }
    public ArrayList<String> find_purchase_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat = null;
        
        try{
            String Sql = "select * from ISMAIN WHERE DOCNO="+code;

            result=statement.executeQuery(Sql);
    //        //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                cat=getPurchase(result);
            }else{
                cat=null;
            }
        }catch(SQLException ex){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public boolean update_purchase(Connection conn,  String odate,String  docno,String  refno,String  supcode,String  tgrossamt,String  splper,String  splrs,String  otherexp,String  avdiscper,String  tdiscrs,String  avtaxper,String  ttaxrs,String  tnetamount,String  remaning,String  paid,String  remarks,String netpayable,String dealerCode,String splfmr,String van){
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,TDISCRS,AVTAXPER,TTAXRS,TNETAMOUNT,REMAINING,
//PAID,REMARKS,NETPAYABLE,DCODE
             Sql="UPDATE ISMAIN SET AVDISCPER= '"+avdiscper+"', REFNO = '"+refno+"'"
                     + ",TGROSSAMT = '"+tgrossamt+"',REMARKS= '"+remarks+"',ODATE= DATE('" + odate +
                     "' , 'MM/DD/YY') ,FMRSUM= '"+splper+"',SPLRS= '"+splrs+"',OTHEREXP = '"+otherexp+
                     "',TDISCRS = '"+tdiscrs+"',AVTAXPER = '"+avtaxper+"',TTAXRS = '"+ttaxrs+"',TNETAMOUNT = '"+
                     tnetamount+"',REMAINING = '"+remaning+"',PAID = '"+paid+"',NETPAYABLE = '"+netpayable+
                     "',DCODE = '"+dealerCode+"',SPLFMR= '"+splfmr+"',VANCODE= '"+van+"' WHERE DOCNO ="+docno;
             statement.executeUpdate(Sql);

            
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("SQLException:"+e);
                var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return var;
    }
    public int find_max_in_purchase_products(Connection conn, String name) {
        int count = 1;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = " SELECT MAX(SEQNO) AS Count FROM ISDTL WHERE  DOCNO = '"+name+"'";
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
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return count;
    }
    public boolean insert_purchase_in_table(Connection conn,  String odate,String  docno,String  refno,String  supcode,
            String  tgrossamt,String  splper,String  splrs,String  otherexp,String  avdiscper,String  tdiscrs,String  avtaxper,
            String  ttaxrs,String  tnetamount,String  remaning,String  paid,String  remarks,String netpayable,String dealerCode,String splfmr,String van){
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO ISMAIN(ODATE,DOCNO,REFNO,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"
                    + "TDISCRS,AVTAXPER,TTAXRS,TNETAMOUNT,REMAINING,PAID,REMARKS,NETPAYABLE,DCODE,SPLFMR,VANCODE) "
                    + "VALUES ( DATE('"+odate+"' ,'MM/DD/YY'),"+ 
                    Integer.parseInt(docno)+ ",'" +
                    refno+ "','"+
                    Float.parseFloat(tgrossamt)+"','"+
                    Float.parseFloat(splper)+"','"+
                    Float.parseFloat(splrs)+"','"+
                    Float.parseFloat(otherexp)+"','"+
                    Float.parseFloat(avdiscper)+"','"+
                    Float.parseFloat(tdiscrs)+ "','"+
                    Float.parseFloat(avtaxper)+"','"+
                    Float.parseFloat(ttaxrs)+"','"+
                    Float.parseFloat(tnetamount)+"','"+
                    Float.parseFloat(remaning)+"','"+
                    Float.parseFloat(paid)+"','"+
                    remarks+"','"+
                    Float.parseFloat(netpayable)+"'," + 
                    Integer.parseInt(dealerCode)+ ",'"+
                    Float.parseFloat(splfmr)+"',"+ 
                    Integer.parseInt(van)+ ")";
             
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }
    public boolean insert_instalments_in_table(Connection conn,String docno,String pcode,String numinst,String pcycle,String reqdate,String instamount,String lastpament,String recamount,String remamount){
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO RMAIN(DOCNO,PCODE,NUMINST,PCYCLE,REQDATE,INSTAMOUNT,LASTPAMENT,RECAMOUNT,REMAMOUNT) VALUES ('"
                    +Integer.parseInt(docno)+ "','" + Integer.parseInt(pcode)+ "',"
                    + "'"+Integer.parseInt(numinst)+"','"+pcycle+"',"+" DATE('"+reqdate+"' ,'MM/DD/YY'),'" 
                    +Float.parseFloat(instamount)+"','"+Float.parseFloat(lastpament)+"',"
                    + "'"+Float.parseFloat(recamount)+"','"+Float.parseFloat(remamount)+ "')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
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
                i++;
        }
        return cat;
    }
    public ArrayList<String> find_all_supp_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result =null;
        ArrayList<String> cat = null;
        try{

            cat = new ArrayList();

            String Sql = "Select * from CLIENTS ORDER BY lower(NAME) ASC";
            result = statement.executeQuery(Sql);
            int i=0;
            while(result.next())
            {           
                    cat.add(i,result.getString("NAME"));
                    //System.out.println("NAME: " + result.getString("NAME").toString());
                    i++;
                    //returned=null;
            }
        }catch(SQLException ex){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public ArrayList<String> find_all_van_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat = null;
        
        try{
            cat = new ArrayList();

            String Sql = "Select * from VANREC ORDER BY lower(VANNAME) ASC";
            result = statement.executeQuery(Sql);
            int i=0;
            while(result.next())
            {           
                    cat.add(i,result.getString("VANNAME"));
                    //System.out.println("NAME: " + result.getString("NAME").toString());
                    i++;
                    //returned=null;
            }
        }catch(SQLException ex){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public String find_sm_name_by_code(Connection conn, String code) throws SQLException {
        ResultSet result = null;
        java.sql.Statement statement = conn.createStatement();
        String cat=null;
        
        try{
            String Sql = "select * from EMPREC WHERE CODE="+code;
            result=statement.executeQuery(Sql);
            if(result.next()){
                cat = result.getString("NAME");
            }else{
                cat=null;
            }
        }catch(SQLException ex){
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public String find_van_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        String cat=null;
        try{
            String Sql = "select * from VANREC WHERE CODE="+code;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("VANNAME");
            }else{
                cat=null;
            }
        }catch(SQLException ex){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public String find_supp_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        String cat= null;
        
        try{
            String Sql = "select * from CLIENTS WHERE CODE="+code;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("NAME");
            }else{
                cat=null;
            }
        }catch(SQLException ex){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public String find_sm_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        String cat = null;
        
        try{
            String Sql = "select * from EMPREC WHERE NAME='"+name+"'";

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("CODE");
            }else{
                cat=null;
            }
        }catch(SQLException ex){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    
    public String find_supp_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        String cat =null;
        try{
            String Sql = "select * from CLIENTS WHERE NAME='"+name+"'";

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("CODE");
            }else{
                cat=null;
            }
        }catch(SQLException ex){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public String find_van_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        String cat= null;
        try{
            String Sql = "select * from VANREC WHERE VANNAME='"+name+"'";

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("CODE");
            }else{
                cat=null;
            }
        }catch(SQLException ex){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public ArrayList<String>[] search_products(Connection conn, String asset_rec) throws SQLException {
        ArrayList<String> returned[] = new ArrayList[find_count_in_purchase_products(conn,asset_rec)];
	ResultSet result = null;
        java.sql.Statement statement = conn.createStatement();
        
        try{
//         SELECT * FROM ISDTL WHERE  DOCNO = 90002 ORDER BY SEQNO ASC
            String Sql = "SELECT * FROM ISDTL WHERE  DOCNO = '"+asset_rec+"' ORDER BY SEQNO ASC";
            result = statement.executeQuery(Sql);
            int i=0;
            while(result.next())
            {         
                returned[i]=getPurchaseProducts(result);
                i++;
            }  
        }catch(SQLException ex){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return returned;
    }
     public int find_count_in_purchase_products(Connection conn, String name) {
        int count = 0;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = " SELECT COUNT(SEQNO) AS Count FROM ISDTL WHERE  DOCNO = '"+name+"'";
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
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return count;
    }
     public int find_count_in_purchase(Connection conn) {
        int count = 0;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = " SELECT COUNT(DOCNO) AS Count FROM ISMAIN";
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
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return count;
    }
     private String getCPP(Connection conn, String pcode) {
        String cat="0";
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PMAST WHERE CODE="+pcode;

            result=statement.executeQuery(Sql);

            if(result.next()){
                cat = result.getString("COSTPRICE");
            }else{
                cat="0";
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
     public boolean update_purchase_products_in_table_new(Connection conn, String   docno, String seqno, String pcode,
             String perqty, String perrate,
            String grossamount, String discper, String discrs, String taxper, String taxrs,
            String netamount,
            String dmg,
            String free,
            String customSize,
            String expDate){
        boolean var = false;
        java.sql.Statement statement =null;
        try
        {
//            if(check_product_line_item_presence_new(conn, docno, seqno)){
                statement= conn.createStatement();
                String Sql;
                System.out.println("MM/DD/YY"+expDate);
                 Sql="UPDATE ISDTL SET SEQNO= '"+seqno+"', PCODE = '"+pcode+"', SALEQTY = '"+perqty+
                         "',SALERATE = '"+perrate+"',GROSSAMOUNT= '"+grossamount+"',DISCPER= '"+discper+"',TDO= '"+discrs+"',TAXPER = '"+taxper+
                         "',FMR = '"+taxrs+"',"
                         + "NETAMOUNT = '"+netamount+"',"
                         + "DMG = '"+dmg+"',"
                         + "FREE = '"+free+"',"
                         + "CUSTOMSIZE = '"+customSize+"',"
                         + "COSTPRICE = '"+getCPP(conn,pcode)+"',"
                         + "EXPIRYDATE = DATE('"+expDate+"','MM/DD/YY')"
                         + " WHERE DOCNO ="+docno +"AND SEQNO="+seqno;
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
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return var;
    }
    public boolean check_product_line_item_presence_new(Connection conn,String string, String seqNoText,int pc) {
        boolean cat=false; 
        java.sql.Statement statement[]=new java.sql.Statement[find_max_in_purchase_products(conn, string)+pc];
        ResultSet result = null;
        try {
            statement[Integer.parseInt(seqNoText)] =  conn.createStatement();
            try {
                System.out.println("(DOCNO="+string+") AND (SEQNO="+seqNoText+")");
                String Sql = "select * from ISDTL ";
                result=statement[Integer.parseInt(seqNoText)].executeQuery(Sql);
                Sql = "select * from ISDTL WHERE (DOCNO='"+string+"') AND (SEQNO='"+seqNoText+"') ";

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
            }finally{
                try{
                    if (statement[Integer.parseInt(seqNoText)] != null) statement[Integer.parseInt(seqNoText)].close();
                }catch(SQLException e){}
            }

        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public int find_max_in_purchase_code(Connection conn) {
        int max = 0;
    ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(DOCNO))as ID from ISMAIN";
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
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return max;
    }
    public int find_max_in_sm_purchase_code(Connection conn,String sm) {
        int max = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(DOCNO))as ID from ISMAIN WHERE DCODE = "+sm;
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("temp"+temp);
            if(temp==null){
                max=0;
            }else{
                 max = Integer.parseInt(temp);
            }
           
            result.close();
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            max = 0;
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return max;
    }
    public boolean insert_purchase_products_in_table(Connection conn,String docno,String seqno,String pcode,String perqty,
            String perrate,String grossamount,String discper,String discrs,String taxper,String taxrs,
            String netamount,
            String customSize,
            String expDate,
            String dmg,
            String free,
            String Size){
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
//            if(!check_product_line_item_presence(conn, docno, seqno)){
//DOCNO,SEQNO,PCODE,SALEQTY,SALERATE,GROSSAMOUNT,DISCPER,TDO,TAXPER,FMR,NETAMOUNT,
            //UNITTYPE,SIDEA,SIDEB,TOTALSIZE,RETURNQTY
            String Sql = "INSERT INTO ISDTL(DOCNO,SEQNO,PCODE,SALEQTY,SALERATE,GROSSAMOUNT,DISCPER,TDO,TAXPER,"
                    + "FMR,NETAMOUNT,RETURNQTY,DMG,FREE,CUSTOMSIZE,EXPIRYDATE,COSTPRICE) VALUES ('"+ Integer.parseInt(docno)+"','" + Integer.parseInt(seqno)+ "','"
                    +Float.parseFloat(pcode)+"','"+Float.parseFloat(perqty)+"','"+Float.parseFloat(perrate)+"','"
                    +Float.parseFloat(grossamount)+"','"+Float.parseFloat(discper)+"','"+Float.parseFloat(discrs)
                    + "','"+Float.parseFloat(taxper)+"','"+Float.parseFloat(taxrs)+"','"+Float.parseFloat(netamount)+"',"
                    + "'"+Size+"',"
                    + "'"+dmg+"',"
                    + "'"+free+"',"
                    + "'"+customSize+"',"
                    + "DATE('"+expDate+"','MM/DD/YY'),"
                    + "'"+getCPP(conn,pcode)+"')";
            //,,,,
            statement.executeUpdate(Sql);
//            }
            var = true;
        }
        catch(SQLException e)
        {
            System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }
    private ArrayList<String> getPurchaseProducts(ResultSet result) {
        ArrayList<String>  cat=new <String>ArrayList();
        try {
//            DOCNO,SEQNO,PCODE,SALEQTY,SALERATE,GROSSAMOUNT,DISCPER,TDO,TAXPER,FMR,NETAMOUNT
            String code = result.getString("DOCNO");
                String c = result.getString("SEQNO");
                String co = result.getString("PCODE");
                String ad2 = result.getString("SALEQTY");
                String add = result.getString("SALERATE");
                String d = result.getString("GROSSAMOUNT");
                String d1 = result.getString("DISCPER");
                String am = result.getString("TDO");
                String n1 = result.getString("TAXPER");
                String co2 = result.getString("FMR");
                String add1 = result.getString("NETAMOUNT");
                String add6 = result.getString("RETURNQTY");
                String add61 = result.getString("CUSTOMSIZE");
                String add62 = result.getString("DMG");
                String add63 = result.getString("FREE");
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
                }
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
                cat.add(12,add61 );
                cat.add(13,add62 );
                cat.add(14,add63 );
                cat.add(15,myDateString );
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
                String d = result.getString("FMRSUM");
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
                String np2 = result.getString("SPLFMR");
                String np3 = result.getString("VANCODE");
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
                cat.add(18,np2 );            
                cat.add(19,np3 );            
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
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = " select * from RMAIN WHERE DOCNO="+s;
            result=statement.executeQuery(Sql);
            if(result.next()){
                var=true;
            }else{
                var=false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
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
        ResultSet result = null;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from RMAIN WHERE DOCNO="+text;
            result=statement.executeQuery(Sql);
            cat = new ArrayList<String>();
            
            if(result.next()){
//                cat=getPurchase(result);
                cat=getInstalments(result);
            }else{
                cat=null;
            }   
        } catch (SQLException ex) {
            Logger.getLogger(PAK_ISSUE_SALE_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{if (result != null) result.close();}catch(SQLException e){}
        }
        return cat;
    }

    public String get_clbal_from_clints(Connection conn, String code) {
        String  cat=null;
        ResultSet result = null;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select EMPCREDIT from EMPREC WHERE CODE='"+code+"'";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                cat = result.getString("EMPCREDIT");
            }else{
                cat=null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{if (result != null) result.close();}catch(SQLException e){}
        }
        System.out.println("==cat : " + cat);
        return cat;
    }
    public String[] get_clbal_previousBal_from_clints(Connection conn, String code) {
        String cat[] = new String[2];
        ResultSet result = null;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select CLBAL,PREVIOUSBAL from CLIENTS WHERE CODE='"+code+"'";
            
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
        }finally{
            try{if (result != null) result.close();}catch(SQLException e){}
        }
        System.out.println("==cat : " + cat);
        return cat;
    }

    public boolean update_clbal_in_clints(Connection conn, String string, String text) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="UPDATE EMPREC SET  EMPCREDIT = '"+string+"'WHERE CODE ="+text;
            statement.executeUpdate(Sql);
            
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }finally{
            try{if (statement != null) statement.close();}catch(SQLException e){}
        }

        return var;  
    }

    public String[] get_invNo_clientCode_remaining(Connection conn, String string) {
        String cat[] = new String[3];
        ResultSet result = null;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from ISMAIN WHERE DOCNO ="+string;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat[0] = result.getString("DOCNO");
                cat[1] = result.getString("DCODE");
                cat[2] = result.getString("REMAINING");
            }else{
                cat=null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{if (result != null) result.close();}catch(SQLException e){}
        }
        return cat;
    }

    public boolean check_availableInstalment(Connection conn,String string) {
        boolean b=false;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from RDTL WHERE DOCNO ="+string;

            result=statement.executeQuery(Sql);
            
            if(result.next()){
                b=true;
                return b;
                
            }else{
                b=false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{if (statement != null) statement.close();if (result != null) result.close();}catch(SQLException e){}
        }
        return b;
    }
    
    public String[] get_pQty_saleQty(Connection conn,String string, String seqNoText) {
       String cat[] = new String[4];
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from ISDTL WHERE (DOCNO='"+string+"') AND (SEQNO='"+seqNoText+"') ";

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                cat[0]=result.getString("PCODE");
                cat[1]=result.getString("SALEQTY");
                cat[2]=result.getString("DMG");
                cat[3]=result.getString("FREE");
            }else{
                cat=null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
                if (result != null) result.close();
            }catch(SQLException e){}
        }
        System.out.println("==cat : " + cat);
        return cat;
        
    }
    public boolean chech_order_or_sale(Connection conn,String docno) {
        boolean cat=false;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from CUSTLEG WHERE DOCNO='"+docno+"'";
            result=statement.executeQuery(Sql);
            if(result.next()){
                return cat=true;
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
                if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public boolean chech_qty(Connection conn, String docno) {
        boolean cat=true;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from ISDTL WHERE DOCNO='"+docno+"'";
            result=statement.executeQuery(Sql);
            while(result.next()){
                String s = result.getString("RETURNQTY");
                if(Float.parseFloat(s)!=0){
                    System.out.println("cat =0 :"+s);  
                    cat=false;break;
                }else{
                    System.out.println("cat !=0 :"+s);  
                    cat=true;
                }
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public String[][] search_history(Connection conn, String text,String bff) {
        String returned[][] = new String[find_count_in_order_dtl(conn,text)][9];
        ResultSet result =null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select * from ISDTL where ROWNUM <= 30 AND  PCODE='"+text+"' ORDER BY DOCNO DESC";
//            String Sql = "Select * from SDTL where PCODE='"+text+"' ORDER BY DOCNO DESC LIMIT 2";
            result = statement.executeQuery(Sql);
            int i=0;
            while(result.next())
            {
                if(hasBff(conn,bff,result.getString("DOCNO"))){
                    //DOCNO,SALEQTY,SALERATE,DISCPER,TOTALSIZE,RETURNQTY
                    returned[i][0]=result.getString("DOCNO");
                    returned[i][1]=find_date_by_code(conn,result.getString("DOCNO"));
//                    returned[i[3]=result.getString("CUSTOMSIZE");
                    returned[i][2]=result.getString("SALEQTY");
                    returned[i][3]=result.getString("SALERATE");
//                    returned[[4]=result.getString("TOTALSIZE");
                    returned[i][4]=result.getString("DISCPER");
                    //System.out.println("Code: " + result.getString("CODE")+"\n TYPE: " + result.getString("DISTRICT"));
                    i++;
                }
            }
        } catch (SQLException ex) {
            System.out.println(""+ex);
            Logger.getLogger(PAK_SALE_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_history1(Connection conn, String text,String bff) {
        String returned[][] = new String[find_count_in_issue(conn,text)][9];
            ResultSet result=null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select * from CURRENTSTOCK WHERE CODE='"+text+"' ORDER BY CODE DESC";
//            String Sql = "Select * from SDTL where PCODE='"+text+"' ORDER BY DOCNO DESC LIMIT 2";
            
            result = statement.executeQuery(Sql);
            int i=0;
            while(result.next())
            {
                    returned[i][0]=result.getString("EXPIRYDATE");
                    returned[i][1]=result.getString("BATCH");
                    returned[i][2]=result.getString("PURQTY");
                    i++;
            }
        } catch (SQLException ex) {
            System.out.println(""+ex);
            Logger.getLogger(PAK_SALE_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public int find_count_in_order_dtl(Connection conn, String name) {
        int count = 0;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = " SELECT COUNT(SEQNO) AS Count FROM ISDTL WHERE  PCODE = '"+name+"'";
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
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return count;
    }
    public int find_count_in_issue(Connection conn, String name) {
        int count = 0;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = " SELECT COUNT(CODE) AS Count FROM CURRENTSTOCK WHERE  CODE = '"+name+"'";
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
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return count;
    }
    private String find_date_by_code(Connection conn, String string) {
        String cat="";
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from ISMAIN WHERE DOCNO="+string;
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
//                cat = result.getString("ODATE");
                cat = ccc.toDateString(ccc.toDate(result.getString("ODATE"))+"");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            System.out.println(""+ex);
            Logger.getLogger(PAK_SALE_DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PAK_SALE_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    private boolean hasBff(Connection conn ,String bff,String doc) {
        boolean isPresent=false;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from ISMAIN WHERE DCODE='"+bff+"' AND DOCNO ='"+doc+"'";
            result=statement.executeQuery(Sql);
            if(result.next()){
                isPresent=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"
//                    + "TDISCRS,AVTAXPER,TTAXRS,TNETAMOUNT,REMAINING,PAID,REMARKS,NETPAYABLE,DCODE
        return isPresent;
    }

    
}
