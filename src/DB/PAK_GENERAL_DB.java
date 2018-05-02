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
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import logical.Conversions;

/**
 *
 * @author Shan
 */
public class PAK_GENERAL_DB extends PAK_GLOBAL_DB{
    public String getNoOfPcsInCtn(Connection conn, String seek) {
        String cat="0";
        
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PMAST WHERE CODE="+seek;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("NOOFPCS");
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
    
    public String getCalculatedTdo(Connection conn, Date string, String pCode, String totalQty) throws ParseException {
        
        String s= "0";
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String cat[] = new String[8];
            String Sql = "select distinct TONO,SRNO,ODATE,CDATE,STPCS,ENDPCS,UNITD,SCHRS from SCHEMERS WHERE PCODE ='"+pCode+"'ORDER BY TONO ASC";
            result=statement.executeQuery(Sql);
            while(result.next()){
                cat[0] = result.getString("TONO");cat[1] = result.getString("SRNO");cat[2] = result.getString("ODATE");
                cat[3] = result.getString("CDATE");cat[4] = result.getString("STPCS");cat[5] = result.getString("ENDPCS");cat[6] = result.getString("UNITD");cat[7] = result.getString("SCHRS");
                System.out.println(cat[0]+" , "+cat[1]+" , "+cat[2]+" , "+cat[3]+" , "+cat[4]+" , "+cat[5]+" , "+string);
                Calendar dateo = Calendar.getInstance();
                Calendar datec = Calendar.getInstance();
                Calendar dateoc = Calendar.getInstance();
                dateo.setTime(dateField.toDate(cat[2]));
                datec.setTime(dateField.toDate(cat[3]));
                dateoc.setTime(string);
                
                if( dateoc.getTimeInMillis()>=dateo.getTimeInMillis()&&dateoc.getTimeInMillis()<=datec.getTimeInMillis()){
                    if( Float.parseFloat(totalQty)>=Float.parseFloat(cat[4])&&Float.parseFloat(totalQty)<=Float.parseFloat(cat[5])){
                        float f =(Float.parseFloat(totalQty)/Float.parseFloat(cat[6]));
                        int i= (int)f;Integer a = new Integer(cat[7]);int r = a.intValue()*i;s=r+"";
                    }
                }
            }
         
            System.out.println("getCalculatedTdo");
        } catch (SQLException ex) {
            System.out.println("ex ==>"+ex);
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return s;
    }
    Conversions dateField=new Conversions();
    public String getCalculatedBns(Connection conn, Date string, String pCode, String totalQty) throws ParseException {
        String s= "0";
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String cat[] = new String[8];
            String Sql = "select distinct TONO,SRNO,ODATE,CDATE,STPCS,ENDPCS,UNITD,SCHRS from SCHEMEQTY WHERE PCODE ='"+pCode+"'ORDER BY TONO ASC";
            result=statement.executeQuery(Sql);
            while(result.next()){
                cat[0] = result.getString("TONO");cat[1] = result.getString("SRNO");
                cat[2] = result.getString("ODATE");cat[3] = result.getString("CDATE");
                cat[4] = result.getString("STPCS");cat[5] = result.getString("ENDPCS");
                cat[6] = result.getString("UNITD");cat[7] = result.getString("SCHRS");
                System.out.println(cat[0]+" , "+cat[1]+" , "+cat[2]+" , "+cat[3]+" , "+cat[4]+" , "+cat[5]+" , "+string);
                Calendar dateo = Calendar.getInstance();Calendar datec = Calendar.getInstance();Calendar dateoc = Calendar.getInstance();
                dateo.setTime(dateField.toDate(cat[2]));datec.setTime(dateField.toDate(cat[3]));dateoc.setTime(string);
                if( dateoc.getTimeInMillis()>=dateo.getTimeInMillis()&&dateoc.getTimeInMillis()<=datec.getTimeInMillis()){
                    if( Float.parseFloat(totalQty)>=Float.parseFloat(cat[4])&&Float.parseFloat(totalQty)<=Float.parseFloat(cat[5])){
                        float f =(Float.parseFloat(totalQty)/Float.parseFloat(cat[6]));int i= (int)f;Integer a = new Integer(cat[7]);int r = a.intValue()*i;s=r+"";
                        System.out.println("getCalculatedBns"+f);
                    }
                }
            }
         
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return s;
    }
    public String getCalculatedSplPer(Connection conn, Date string, String totalQty) throws ParseException {
        String s= "0";
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String cat[] = new String[8];
            String Sql = "select distinct SLABNO,SRNO,FROMDATE,TODATE,FROMAMOUNT,TOAMOUNT,SLABPER from SLAB ORDER BY SLABNO ASC";
            result=statement.executeQuery(Sql);
            System.out.println("St");
            while(result.next()){
                cat[0] = result.getString("SLABNO");cat[1] = result.getString("SRNO");
                cat[2] = result.getString("FROMDATE");cat[3] = result.getString("TODATE");
                cat[4] = result.getString("FROMAMOUNT");cat[5] = result.getString("TOAMOUNT");
                cat[7] = result.getString("SLABPER");
                System.out.println(cat[0]+" , "+cat[1]+" , "+cat[2]+" , "+cat[3]+" , "+cat[4]+" , "+cat[5]+" , "+string);
                Calendar dateo = Calendar.getInstance();Calendar datec = Calendar.getInstance();Calendar dateoc = Calendar.getInstance();
                dateo.setTime(dateField.toDate(cat[2]));datec.setTime(dateField.toDate(cat[3]));dateoc.setTime(string);
                if( dateoc.getTimeInMillis()>=dateo.getTimeInMillis()&&dateoc.getTimeInMillis()<=datec.getTimeInMillis()){
                    if(!totalQty.equals(null)){
                        if( Float.parseFloat(totalQty)>=Float.parseFloat(cat[4])&&Float.parseFloat(totalQty)<=Float.parseFloat(cat[5])){
                            float f =(Float.parseFloat(cat[7]));///Float.parseFloat(cat[6]));int i= (int)f;Integer a = new Integer(cat[7]);int r = a.intValue()*i;s=r+"";
                            System.out.println("SLABPER "+f);
                            s=f+"";                                                                                                                                                                                                                                        break;
                        }
                    }
                }
            }
        
            System.out.println("getCalculatedSplPer");
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NullPointerException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return s;
    }
    public String get_access_from_grant(Connection conn, String code, String text) {
        String  cat=null;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from ROLEGRANTS WHERE CODE='"+code+"' AND ROLE ='"+text+"'";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                cat = result.getString("YN");
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
        //System.out.println("==cat : " + cat);
        return cat;
    }
public String get_role_from_userLogin(Connection conn, String code) {
        String  cat=null;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from USERLOGIN WHERE USERID='"+code+"'";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                cat = result.getString("FULLACC");
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
        //System.out.println("==cat : " + cat);
        return cat;
    }

    public boolean isDSRPresent(Connection conn, String toDateString, String text, String text0) {
        boolean var = false;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            System.out.println("toDateString : "+toDateString);
            System.out.println("smCode : "+text);
            System.out.println("vanCode : "+text0);
            String Sql = " select * from DSRCOUNTER WHERE DDATE=TO_DATE('"+toDateString+"' ,'MM/DD/YY') AND SMCODE ='"+text+"' AND VANCODE ='"+text0+"'";
            result=statement.executeQuery(Sql);
            if(result.next()){
                System.out.println(" -V- Found DSR");
                var=true;
            }else{
                System.out.println(" -X- Not Found DSR");
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
    public boolean isDSRPresentSmain(Connection conn, String toDateString, String text, String text0) {
        boolean var = false;
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            System.out.println("toDateString : "+toDateString);
            System.out.println("smCode : "+text);
            System.out.println("vanCode : "+text0);
            String Sql = " select * from SMAIN WHERE DDATE=TO_DATE('"+toDateString+"' ,'MM/DD/YY') AND DCODE ='"+text+"' AND VANREC ='"+text0+"'";
            result=statement.executeQuery(Sql);
            if(result.next()){
                System.out.println(" -V- Found DSR SMAIN");
                var=true;
            }else{
                System.out.println(" -X- Not Found DSR SMAIN");
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
    public boolean isDSRPresentISmain(Connection conn, String toDateString, String text, String text0) {
        boolean var = false;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            System.out.println("toDateString : "+toDateString);
            System.out.println("smCode : "+text);
            System.out.println("vanCode : "+text0);
            String Sql = " select * from ISMAIN WHERE ODATE=TO_DATE('"+toDateString+"' ,'MM/DD/YY') AND DCODE ='"+text+"' AND VANCODE ='"+text0+"'";
            result=statement.executeQuery(Sql);
            if(result.next()){
                System.out.println(" -V- Found DSR ISMAIN");
                var=true;
            }else{
                System.out.println(" -X- Not Found DSR ISMAIN");
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
    public int find_max_in_DSR_code(Connection conn) {
        int max = 0;
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from DSRCOUNTER";
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
    public boolean insertDSP(Connection conn, String code, String toDateString, String text, String text0) {
        boolean var = false;
        try
        {//DSRCOUNTER 
            java.sql.Statement statement = conn.createStatement();
            String Sql = "INSERT INTO DSRCOUNTER(CODE ,DDATE ,SMCODE ,VANCODE) VALUES ('"+Integer.parseInt(code)+ "',"
                    +" TO_DATE('"+toDateString+"' ,'MM/DD/YY'),'"+Integer.parseInt(text)+ "','" + Integer.parseInt(text0)+ "')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
//            System.out.println("Error Log :"+e);
            var = false;
        }
        return var;
    }

    public boolean deleteDSP(Connection conn, String toDateString, String text, String text0) {
        boolean var = false;
        try
        {
            java.sql.Statement statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM DSRCOUNTER WHERE DDATE=TO_DATE('"+toDateString+"' ,'MM/DD/YY') AND SMCODE ='"+text+"' AND VANCODE ='"+text0+"'";
            statement.executeUpdate(Sql);
            System.out.println(" -V- Deleted");
            var = true;
        }
        catch(SQLException e)
        {
            System.out.println(""+e);
                var = false;
        }

        return var;
    }
    
    public String getIL(Connection conn, String toDateString, String text, String text0) {
        String cat="0";
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from VANLOAD WHERE DDATE= TO_DATE('" + toDateString +"' , 'MM/DD/YY') AND VANREC = "+text0+"AND DCODE = "+text;

            result=statement.executeQuery(Sql);

            if(result.next()){
                String cat1 = result.getString("TOTALLOAD"),cat2 = result.getString("RETURNWEIGHT");
                cat=(Float.parseFloat(cat1)+Float.parseFloat(cat2))+"";
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

     public String get_clbal_from_custbal(Connection conn, String code) {
        String  cat="0";
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select BALANCE from CUSTBALANCE WHERE CUSTOMER='"+code+"'";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                cat = result.getString("BALANCE");
            }else{
                cat="0";
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
//        System.out.println("==cat : " + cat);
        return cat;
    }
     public String getTL(Connection conn, String toDateString, String text, String text0) {
        String cat="0";
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from VANLOAD WHERE DDATE= TO_DATE('" + toDateString +"' , 'MM/DD/YY')AND VANREC = "+text0+" AND DCODE = "+text;

            result=statement.executeQuery(Sql);

            if(result.next()){
                cat = result.getString("TOTALLOAD");
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

    public String getNetTotalStock(Connection conn, String pCode) {
        String cat="0";
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            if(pCode!=null){
                statement = conn.createStatement();
                String Sql = "select * from AVAILABLESTOCK WHERE CODE = "+pCode;

                result=statement.executeQuery(Sql);

                if(result.next()){
                    cat = result.getString("NETTOTALSTOCK");
                }else{
                    cat="0";
                }
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
}
