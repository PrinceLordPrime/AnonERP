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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logical.Conversions;

/**
 *
 * @author Shan
 */
public class PAK_INSTRTN_DB extends PAK_GLOBAL_DB{
    public boolean insert_purchase_products_in_table(Connection conn,String seqno,String duedate,String description,String dueamount,String rcdate,String rcamount,String docno){
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
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
    /*
    public String get_perqty_wrt_perdtl_code_seek(Connection conn, String a, String b, String c) {
        
        String cat=null;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from RETURNDTL WHERE PCODE="+a+"AND SEQNO="+c+" AND DOCNO ="+b;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = (Float.parseFloat(result.getString("SALEQTY"))+Float.parseFloat(result.getString("DAMAGE"))+Float.parseFloat(result.getString("FREE")))+"";
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }*/
    public String check_product_line_item_presence_with_seek(Connection conn,String string, String seqNoText,String seekText,int pc) {
        String cat="false"; 
        java.sql.Statement statement[]=new java.sql.Statement[find_max_in_purchase_products(conn, string)+pc];
        ResultSet result = null;
        try {
            statement[Integer.parseInt(seqNoText)] =  conn.createStatement();
            
            String Sql = null;
            Sql = "select * from RETURNDTL WHERE (DOCNO='"+string+"') AND (SEQNO='"+seqNoText+"') ";

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
                    cat= result.getString("PCODE")+" "+result.getString("SALEQTY");
                }
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
                try{
                if(statement[Integer.parseInt(seqNoText)]!=null)statement[Integer.parseInt(seqNoText)].close();
                if(result!=null)result.close();
            }catch(SQLException e){}
            
        }
        
        
        return cat;
    }
    public boolean update_clqty_in_pmast(Connection conn, String clqty,String code) {
        boolean var = false;
            java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
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
        }finally{
            if(statement!=null)try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(PAK_INSTRTN_DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return var;
    }
    public ArrayList<String> get_last_purchase(Connection conn) throws SQLException {
        java.sql.Statement statement = null;
        ArrayList<String> cat = null;
       try{ 
         statement = conn.createStatement();
        int max=find_max_in_purchase_code(conn);
        String Sql = "select * from  RETURNMAIN WHERE DOCNO="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
         cat = new ArrayList<String>();
        
        if(result.next()){
            cat=getPurchase(result);
        }else{
            cat=null;
        }
       }
       catch(SQLException e)
        {
            //System.out.println("SQLException:"+e);
                cat = null;
        }finally{
            if(statement!=null)try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(PAK_INSTRTN_DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cat;
    }
    Conversions ccc =new Conversions();
    public String[][] search_sales(Connection conn, String distrec) throws SQLException {
	java.sql.Statement statement = null;
        String returned[][] = null;
	ResultSet resultset = null;
        try{
        returned = new String[find_count_in_purchase(conn)][14];
        statement = conn.createStatement();
	String Sql = "Select * from  RETURNMAIN";
	resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {
            returned[i][0]=resultset.getString("DOCNO");
            returned[i][1]=resultset.getString("REFNO");
            try {
                returned[i][2]=ccc.toDateString(ccc.toDate(resultset.getString("ODATE"))+"");//resultset.getString("DOCDATE");
            } catch (ParseException ex) {
                Logger.getLogger(PAK_SELLERLEDGER_DB.class.getName()).log(Level.SEVERE, null, ex);
            }
            returned[i][3]=find_cust_rec_name_by_code(conn, resultset.getString("CUSTCODE"));//get Name
            returned[i][4]=find_sm_name_by_code(conn, resultset.getString("DCODE"));//get Name
//            returned[i][5]=resultset.getString("TGROSSAMT");
//            returned[i][6]=resultset.getString("TDISCRS");
//            returned[i][7]=resultset.getString("TTAXRS");
            returned[i][5]=resultset.getString("TNETAMOUNT");
            returned[i][6]=resultset.getString("SPLRS");
            returned[i][7]=resultset.getString("OTHEREXP");
            returned[i][8]=resultset.getString("NETPAYABLE");
            returned[i][9]=resultset.getString("PAID");
            returned[i][10]=resultset.getString("REMAINING");
            i++;
        }
        }
        catch(SQLException e)
        {
            //System.out.println("SQLException:"+e);
        }finally{
            if(statement!=null)try {
                statement.close();
            } catch (SQLException ex) {}
            if(resultset!=null)try {
                resultset.close();
            } catch (SQLException ex) {}
        }
        return returned;
    }
    public String find_cust_rec_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = null;
        ResultSet result = null;
        String cat=null;
        try{
            statement = conn.createStatement();
            String Sql = "select * from CLIENTS WHERE NAME='"+name+"'";

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("CODE");
            }else{
                cat=null;
            }
        }
        catch(SQLException e)
        {
            //System.out.println("SQLException:"+e);
               
        }finally{
             try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}
            

        }
        return cat;
    }
    public String find_cust_rec_name_by_code(Connection conn, String code) throws SQLException {
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        String cat=null;
        try{
        String Sql = "select * from CLIENTS WHERE CODE='"+code+"'";
        statement = conn.createStatement();

        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);

        if(result.next()){
            cat = result.getString("NAME");
        }else{
            cat=null;
        }
         }
        catch(SQLException e)
        {
            //System.out.println("SQLException:"+e);
               
        }finally{
             try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}
        }
        
        return cat;
    }
    public ArrayList<String> next_purchase(Connection conn, String code){
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
        java.sql.Statement statement =  null;
        ResultSet result = null;
       try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM  RETURNMAIN WHERE DOCNO > "+Integer.parseInt(code)+" ORDER BY DOCNO";            
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
                if(statement!=null)statement.close();
                if(result!=null)result.close();
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
            
            Sql="SELECT * FROM  RETURNMAIN WHERE DOCNO <"+Integer.parseInt(code)+" ORDER BY DOCNO DESC ";
            
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
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}
             
       }
        return cat;
    }

     public ArrayList<String> get_first_purchase(Connection conn)throws SQLException {
       
         java.sql.Statement statement = null;
            ResultSet result = null;
            ArrayList<String> cat=null;
         try{
            statement = conn.createStatement();
        
            int min=0;
            min=find_min_in_purchase_code(conn);
            if(min!=0){
                String Sql;
                Sql = "select * from  RETURNMAIN WHERE DOCNO="+min;//+"AND CREDITAMOUNT > "+Integer.parseInt("0");
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
             }

        catch(SQLException e)
        {
            //System.out.println("SQLException:"+e);
               
        }
     
        finally{
             try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
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
                Sql = "Select MIN(DOCNO))as ID from  RETURNMAIN ";
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
        finally{
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}
            
        }
        return min;
    }
    public boolean delete_purchase(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
            String Sql=null;
            java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();

            Sql = "DELETE FROM  RETURNMAIN WHERE DOCNO = "+code;
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }
        finally{
            try{
                if(statement!=null)statement.close();
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

            Sql = "DELETE FROM RETURNDTL WHERE DOCNO = '"+docno+"'";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }
        finally{
            try{
                if(statement!=null)statement.close();
                
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

            Sql = "DELETE FROM RETURNDTL WHERE DOCNO = '"+docno+"' AND SEQNO = '"+seqno+"'";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }
        finally{
                try{
                if(statement!=null)statement.close();
            }catch(SQLException e){}
        }
        return var;
    }
    public ArrayList<String> find_purchase_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = null;
        ResultSet result = null;
        ArrayList<String> cat =null;
        try{
        statement = conn.createStatement();
        String Sql = "select * from  RETURNMAIN WHERE DOCNO="+code;

        result=statement.executeQuery(Sql);
//        //System.out.println("Result : " + result);

        if(result.next()){
            cat=getPurchase(result);
        }else{
            cat=null;
        }
        }catch(SQLException e){}
        finally{
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}
            
        }
        return cat;
    }
    public boolean update_purchase(Connection conn,  String odate,String  docno,String  refno,String  supcode,String  splper,String  splrs,
            String  otherexp,String  tnetamount,String  remaning,String  paid,
            String  remarks,String netpayable,String dealerCode){
        boolean var = false;
            java.sql.Statement statement = null;
        try
        {
             statement = conn.createStatement();
            String Sql;
             Sql="UPDATE  RETURNMAIN SET  REFNO = '"+refno+"', CUSTCODE = '"+supcode+
                     "',REMARKS= '"+remarks+"',ODATE= DATE('" + odate +
                     "' , 'MM/DD/YY') ,SPLRS= '"+splrs+"',OTHEREXP = '"+otherexp+
                     "',TNETAMOUNT = '"+tnetamount+"',REMAINING = '"+remaning+"',PAID = '"+paid+"',NETPAYABLE = '"+netpayable+
                     "',DCODE = '"+dealerCode+"' WHERE DOCNO ="+docno;
             statement.executeUpdate(Sql);

            
            var = true;
        }catch(SQLException e){var = false;}

        finally{
            
                try{
                if(statement!=null)statement.close();
                
            }catch(SQLException e){}
            
            }
        
        
        return var;
    }
    
    public int find_max_in_purchase_products(Connection conn, String name) {
        int count = 1;
            java.sql.Statement statement = null;
            ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = " SELECT MAX(SEQNO) AS Count FROM RETURNDTL WHERE  DOCNO = '"+name+"'";
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
        finally{
            
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}
            
        }
        return count;
    }
    public boolean insert_purchase_in_table(Connection conn,  String odate,String  docno,String  refno,String  supcode,
            String  splper,String  splrs,String  otherexp,String  tnetamount,String  remaning,String  paid,String  remarks,String netpayable,
            String dealerCode){
        boolean var = false;
            java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO  RETURNMAIN(ODATE,DOCNO,REFNO,CUSTCODE,SPLRS,OTHEREXP"
                    + ",TNETAMOUNT,REMAINING,PAID,REMARKS,NETPAYABLE,DCODE) "
                    + "VALUES (DATE('"+odate+"' ,'MM/DD/YY'),'" 
                    + Integer.parseInt(docno)+ "','" +refno+ "',"
                    + "'"+Integer.parseInt(supcode)+"','"+Float.parseFloat(splrs)+"',"
                    + "'"+Float.parseFloat(otherexp)+"','"+Float.parseFloat(tnetamount)+"',"
                    + "'"+Float.parseFloat(remaning)+"','"+Float.parseFloat(paid)+"','"+remarks+"','"+Float.parseFloat(netpayable)+"','" + Integer.parseInt(dealerCode)+ "')";
             
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            System.out.println("Error Log :"+e);
            var = false;
        }
        
        finally{
            {
                try{
                if(statement!=null)statement.close();
                
            }catch(SQLException e){}
            
        }
        
        return var;
    }
    }
    public ArrayList<String> find_all_sm_name_by_code(Connection conn) throws SQLException, SQLException {
        java.sql.Statement statement = null;
        ArrayList<String> cat = null;
	ResultSet resultset = null;
        try{
            statement = conn.createStatement();
            cat = new ArrayList();

           String Sql = "Select * from EMPREC ORDER BY lower(NAME) ASC";
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {           
//                System.out.println("IS NULL"+i);
                    cat.add(i,resultset.getString("NAME"));
                    i++;
            }
        
        }catch(SQLException e){}
        finally{
                try{
                if(statement!=null)statement.close();
                if(resultset!=null)resultset.close();
            }catch(SQLException e){}
            
        }
        
        return cat;
    }
    public ArrayList<String> find_all_supp_name_by_code(Connection conn) throws SQLException {
        
        java.sql.Statement statement = null;
        ArrayList<String> cat =null;
	ResultSet resultset = null ;
        try{
            cat = new ArrayList();
            statement = conn.createStatement();
            String Sql = "Select NAME from CLIENTS ORDER BY lower(NAME) ASC";
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {           
//                System.out.println("Is Null"+resultset.getString("NAME"));
                cat.add(i,resultset.getString("NAME"));
                i++;
            }
        
        }catch(SQLException e){}
        finally{
                try{
                if(statement!=null)statement.close();
                if(resultset!=null)resultset.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public String find_sm_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = null;
        ResultSet result = null;
        String cat=null;
        try{
        statement = conn.createStatement();
        String Sql = "select * from EMPREC WHERE CODE="+code;

        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);

        if(result.next()){
            cat = result.getString("NAME");
        }else{
            cat=null;
        }
        
        }catch(SQLException e){}
        finally{
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){} 
        }
        return cat;
    }
    public String find_supp_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CLIENTS WHERE CODE="+code;
        ResultSet result = null;
        String cat=null;
        try{
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("NAME");
            }else{
                cat=null;
            }
        }catch(SQLException e){}
        finally{
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){} 
        }
        return cat;
    }
    public String find_sm_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        String cat=null;
        String Sql = "select * from EMPREC WHERE NAME='"+name+"'";
        try{
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("CODE");
            }else{
                cat=null;
            }
        
        }catch(SQLException e){}
        finally{
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){} 
        }
        return cat;
    }
    
    public String find_supp_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        String Sql = "select * from CLIENTS WHERE NAME='"+name+"'";
        String cat=null;
        try{
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("CODE");
            }else{
                cat=null;
            }
        }catch(SQLException e){}
        finally{
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){} 
        }
        return cat;
    }
    public ArrayList<String>[] search_products(Connection conn, String asset_rec) throws SQLException {
        ArrayList<String> returned[] = new ArrayList[find_count_in_purchase_products(conn,asset_rec)];
	java.sql.Statement statement = conn.createStatement();
	ResultSet resultset = null;
        String Sql = "SELECT * FROM RETURNDTL WHERE  DOCNO = '"+asset_rec+"' ORDER BY SEQNO ASC";
	try{
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next()){returned[i]=getPurchaseProducts(resultset);i++;}
        }catch(SQLException e){}
        finally{
                try{
                if(statement!=null)statement.close();
                if(resultset!=null)resultset.close();
            }catch(SQLException e){} 
        }
        return returned;
    }
     public int find_count_in_purchase_products(Connection conn, String name) {
        int count = 0;
        java.sql.Statement statement =null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = " SELECT COUNT(SEQNO) AS Count FROM RETURNDTL WHERE  DOCNO = '"+name+"'";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("Count");
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
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}   
        }
        return count;
    }
     public int find_count_in_purchase(Connection conn) {
        int count = 0;
            java.sql.Statement statement = null;
            ResultSet result = null;
        try
        {
             statement = conn.createStatement();
            String Sql = " SELECT COUNT(DOCNO) AS Count FROM  RETURNMAIN";
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
        finally{
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}  
        }
        return count;
    }
     public boolean update_purchase_products_in_table_new(Connection conn, String docno, String seqno, String pcode, String saleqty, String salerate, String damage, String dmgrate, String expiryqty, String expiryrate, String netamount, String expirydate){
        boolean var = false;
                java.sql.Statement statement = null;
        try
        {//DOCNO,SEQNO,PCODE,SALEQTY,SALERATE,DAMAGE,DMGRATE,EXPIRYQTY,EXPIRYRATE,NETAMOUNT,EXPIRYDATE
                statement = conn.createStatement();
                String Sql;
                 Sql="UPDATE RETURNDTL SET SEQNO= '"+seqno+"', PCODE = '"+pcode+"', SALEQTY = '"+saleqty+
                         "',SALERATE = '"+salerate+"',DAMAGE= '"+damage+"',DMGRATE= '"+dmgrate+"',EXPIRYQTY = '"+expiryqty+
                         "',"+ "NETAMOUNT = '"+netamount+"',EXPIRYRATE = '"+expiryrate+"' ,EXPIRYDATE= DATE('" + expirydate +"' , 'MM/DD/YY')WHERE DOCNO ="+docno +"AND SEQNO="+seqno;
                 statement.executeQuery(Sql);


                var = true;
        }
        catch(SQLException e)
        {
                System.out.println("SQLException:"+e);
                var = false;
        }
        
         finally{
                try{
                if(statement!=null)statement.close();
               
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
            System.out.println("(DOCNO="+string+") AND (SEQNO="+seqNoText+")");
            String Sql = "select * from RETURNDTL ";
            result=statement[Integer.parseInt(seqNoText)].executeQuery(Sql);
            Sql = "select * from RETURNDTL WHERE (DOCNO='"+string+"') AND (SEQNO='"+seqNoText+"') ";

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
         finally{
                try{
                if(statement[Integer.parseInt(seqNoText)]!=null)statement[Integer.parseInt(seqNoText)].close();
                if(result!=null)result.close();
            }catch(SQLException e){}
            
        }
        return cat;
    }
    public int find_max_in_purchase_code(Connection conn) {
        int max = 0;
            java.sql.Statement statement = null;
            ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(DOCNO))as ID from  RETURNMAIN";
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
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}  
        }
        return max;
    }
    public boolean insert_purchase_products_in_table(Connection conn,String docno,String seqno,String pcode,String perqty,
            String perrate,String damage,String discper,String taxper,String expQty,
            String netamount,
            String dmg){
        boolean var = false;
            java.sql.Statement statement =null;
        try
        {
            statement = conn.createStatement();
//            if(!check_product_line_item_presence(conn, docno, seqno)){
//DOCNO,SEQNO,PCODE,SALEQTY,SALERATE,DAMAGE,DMGRATE,DISCRS,EXPIRYQTY,TAXRS,NETAMOUNT,
            //UNITTYPE,SIDEA,SIDEB,TOTALSIZE,RETURNQTY
            String Sql = "INSERT INTO RETURNDTL(DOCNO,SEQNO,PCODE,SALEQTY,SALERATE,DAMAGE,"
                    + "DMGRATE,EXPIRYQTY,EXPIRYRATE,NETAMOUNT,EXPIRYDATE) VALUES ('"+ Integer.parseInt(docno)+"','" + Integer.parseInt(seqno)+ "','"
                    +Float.parseFloat(pcode)+"','"+Float.parseFloat(perqty)+"','"+Float.parseFloat(perrate)+"','"
                    +Float.parseFloat(damage)+"','"+Float.parseFloat(discper)
                    + "','"+Float.parseFloat(expQty)
                    + "','"+Float.parseFloat(taxper)+"','"
                    +Float.parseFloat(netamount)+"',"
                    +"DATE('" + dmg +"' , 'MM/DD/YY'))";
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
                if(statement!=null)statement.close();
            }catch(SQLException e){}  
        }
        
        return var;
    }
    
    
    
    private ArrayList<String> getPurchaseProducts(ResultSet result) {
        ArrayList<String>  cat=new <String>ArrayList();
        try {
//           DOCNO,SEQNO,PCODE,SALEQTY,SALERATE,DAMAGE,DMGRATE,EXPIRYQTY,EXPIRYRATE,NETAMOUNT,EXPIRYDATE
            String code = result.getString("DOCNO");
                String c = result.getString("SEQNO");
                String co = result.getString("PCODE");
                String ad2 = result.getString("SALEQTY");
                String add = result.getString("SALERATE");
                String d = result.getString("DAMAGE");
                String d1 = result.getString("DMGRATE");
                String n1 = result.getString("EXPIRYQTY");
                String add1 = result.getString("EXPIRYRATE");
                String np2 = result.getString("NETAMOUNT");
                String np3 = result.getString("EXPIRYDATE");
                
                cat.add(0,code );
                cat.add(1,c );
                cat.add(2,co );
                cat.add(3,ad2 );
                cat.add(4,add );
                cat.add(5,d );
                cat.add(6,d1 );
                cat.add(7,n1 );
                cat.add(8,add1 );
                cat.add(9,np2 );
                cat.add(10,np3 );
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    private ArrayList<String> getPurchase(ResultSet result) {
        ArrayList<String>  cat=new <String>ArrayList();
        try {//ODATE,DOCNO,REFNO,CUSTCODE,SPLRS,OTHEREXP,TNETAMOUNT,REMAINING,PAID,REMARKS,NETPAYABLE,DCODE
                String code = result.getString("ODATE");
                String c = result.getString("DOCNO");
                String co = result.getString("REFNO");
                String ad2 = result.getString("CUSTCODE");
                String d1 = result.getString("SPLRS");
                String am = result.getString("OTHEREXP");
                String add1 = result.getString("TNETAMOUNT");
                String d2 = result.getString("REMAINING");
                String am1 = result.getString("PAID");
                String rem = result.getString("REMARKS");
                String np = result.getString("NETPAYABLE");
                String np1 = result.getString("DCODE");
                
                cat.add(0,code );
                cat.add(1,c );
                cat.add(2,co );
                cat.add(3,ad2 );
                cat.add(4,d1 );
                cat.add(5,am );
                cat.add(6,add1 );
                cat.add(7,d2 );
                cat.add(8,am1 );
                cat.add(9,rem );
                cat.add(10,np );
                cat.add(11,np1 );            
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    public String get_clbal_from_clints(Connection conn, String code) {
        String  cat=null;
            java.sql.Statement statement = null;
            ResultSet result = null;
        try {
            statement = conn.createStatement();
            String Sql = "select CLBAL from CLIENTS WHERE CODE='"+code+"'";
            
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
         finally{
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}
            
        }
        
        System.out.println("==cat : " + cat);
        return cat;
    }
    public String get_empCustCredit_from_empRec(Connection conn, String code) {
        String  cat=null;
            java.sql.Statement statement =null;
            ResultSet result = null;
        try {
             statement = conn.createStatement();
            String Sql = "select EMPCUSTCREDIT from EMPREC WHERE CODE='"+code+"'";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                cat = result.getString("EMPCUSTCREDIT");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         finally{
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}
            
        }
        
        System.out.println("==cat : " + cat);
        return cat;
    }
    public String[] get_clbal_previousBal_from_clints(Connection conn, String code) {
        String cat[] = new String[2];
            java.sql.Statement statement = null;
            ResultSet result = null;
        try {
             statement = conn.createStatement();
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
        }
        
         finally{
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}
            
        }
        
        
        System.out.println("==cat : " + cat);
        return cat;
    }

    public boolean update_clbal_in_clints(Connection conn, String string, String text) {
        boolean var = false;
            java.sql.Statement statement =null;
        try
        {
             statement = conn.createStatement();
            String Sql;
            
            Sql="UPDATE CLIENTS SET  CLBAL = '"+string+"'WHERE CODE ="+text;
            statement.executeUpdate(Sql);
            
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }
        
         finally{
                try{
                if(statement!=null)statement.close();
               
            }catch(SQLException e){}
            
        }

        return var;  
    }
    public boolean update_empCustCredit_in_empRec(Connection conn, String string, String text) {
        boolean var = false;
            java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="UPDATE EMPREC SET  EMPCUSTCREDIT = '"+string+"'WHERE CODE ="+text;
            statement.executeUpdate(Sql);
            
            var = true;
        }
        catch(SQLException e)
        {
                var = false;
        }
        
         finally{
                try{
                if(statement!=null)statement.close();
               
            }catch(SQLException e){}
            
        }

        return var;  
    }

    public String[] get_invNo_clientCode_remaining(Connection conn, String string) {
        String cat[] = new String[3];
            java.sql.Statement statement = null;
            ResultSet result = null;
        try {
            statement = conn.createStatement();
            String Sql = "select * from  RETURNMAIN WHERE DOCNO ="+string;

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
        
         finally{
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}
            
        }
        
        return cat;
    }
    public String[] get_invNo_empRec_remaining(Connection conn, String string) {
        String cat[] = new String[3];
            java.sql.Statement statement = null;
            ResultSet result = null;
        try {
             statement = conn.createStatement();
            String Sql = "select * from  RETURNMAIN WHERE DOCNO ="+string;

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
        }
        
         finally{
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}
            
        }
        
        return cat;
    }

    public boolean check_availableInstalment(Connection conn,String string) {
        boolean b=false;
            java.sql.Statement statement = null;
            ResultSet result = null;
         try {
            statement = conn.createStatement();
            String Sql = "select * from RDTL WHERE DOCNO ="+string;

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
        }finally{
            try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}  
        }
        return b;
    }
    public String[] get_pQty_saleQty(Connection conn,String string, String seqNoText) {
       String cat[] = new String[4];
            java.sql.Statement statement = null;
            ResultSet result = null;
        try {
            statement = conn.createStatement();
            String Sql = "select * from RETURNDTL WHERE (DOCNO='"+string+"') AND (SEQNO='"+seqNoText+"') ";

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                cat[0]=result.getString("PCODE");
                cat[1]=result.getString("SALEQTY");
                cat[2]=result.getString("DAMAGE");
//                cat[3]=result.getString("FREE");
            }else{
                cat=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         finally{
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}
            
        }
        
        System.out.println("==cat : " + cat);
        return cat;
    }

    
public String[][] search_history(Connection conn, String text,String bff) {
        String returned[][] = new String[find_count_in_order_dtl(conn,text)][5];
            java.sql.Statement statement = null;
            ResultSet resultset = null;
        try {
            String Sql = "Select * from RETURNDTL where ROWNUM <= 30 AND  PCODE='"+text+"' ORDER BY DOCNO DESC";
            statement = conn.createStatement();
//            String Sql = "Select * from PERDTL where PCODE='"+text+"' ORDER BY DOCNO DESC LIMIT 2";
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {   if(hasBff(conn,bff,resultset.getString("DOCNO"))){
                    returned[i][0]=resultset.getString("DOCNO");
                    returned[i][1]=find_date_by_code(conn,resultset.getString("DOCNO"));
                    returned[i][2]=resultset.getString("SALEQTY");
                    returned[i][3]=resultset.getString("SALERATE");
                    returned[i][4]=resultset.getString("DMGRATE");
                    //System.out.println("Code: " + resultset.getString("CODE")+"\n TYPE: " + resultset.getString("DISTRICT"));
                    i++;
                }
            }
        } catch (SQLException ex) {
            System.out.println(""+ex);
            Logger.getLogger(PAK_SALE_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         finally{
                try{
                if(statement!=null)statement.close();
                if(resultset!=null)resultset.close();
            }catch(SQLException e){}
            
        }
        
        return returned;
    }
    public int find_count_in_order_dtl(Connection conn, String name) {
        int count = 0;
            java.sql.Statement statement = null;
            ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = " SELECT COUNT(SEQNO) AS Count FROM RETURNDTL WHERE  PCODE = '"+name+"'";
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
        
         finally{
                try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}
            
        }
        
        return count;
    }

    private String find_date_by_code(Connection conn, String string) {
        String cat="";try {java.sql.Statement statement = conn.createStatement();String Sql = "select * from RETURNMAIN  WHERE DOCNO="+string;
            ResultSet result = null;result=statement.executeQuery(Sql);if(result.next()){
            cat = ccc.toDateString(ccc.toDate(result.getString("ODATE"))+"");}else{cat=null;}
        } catch (SQLException ex) {Logger.getLogger(PAK_SALE_DB.class.getName()).log(Level.SEVERE, null, ex);} catch (ParseException ex) {
            Logger.getLogger(PAK_SALE_DB.class.getName()).log(Level.SEVERE, null, ex);}
        return cat;
    }
    private String find_refNo_by_code(Connection conn, String string) {
        String cat="";
        java.sql.Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            String Sql = "select * from RETURNMAIN  WHERE DOCNO="+string;
            result=statement.executeQuery(Sql);if(result.next()){
            cat = result.getString("REFNO");}else{cat=null;}
        } catch (SQLException ex) {Logger.getLogger(PAK_SALE_DB.class.getName()).log(Level.SEVERE, null, ex);}
        finally{
            try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}  
        }
        return cat;
    }
    private boolean hasBff(Connection conn ,String bff,String doc) {
        boolean isPresent=false;
        java.sql.Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            String Sql = "select * from RETURNMAIN WHERE CUSTCODE='"+bff+"' AND DOCNO ='"+doc+"'";
            result = null;result=statement.executeQuery(Sql);if(result.next()){isPresent=true;}
        }catch (SQLException ex) {Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);}
        finally{
            try{
                if(statement!=null)statement.close();
                if(result!=null)result.close();
            }catch(SQLException e){}  
        }
        return isPresent;
    }
}
