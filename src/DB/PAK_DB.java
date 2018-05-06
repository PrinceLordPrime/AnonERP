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
//"jdbc:oracle:thin:dsp/dynamic001@BlackPearl:1521:dspak"); 

public class PAK_DB extends PAK_GLOBAL_DB {
	       
//	public Connection connect_database() throws SQLException
//	{
//		Connection conn = null;
//		try
//		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:pak/dynamic001@COBRA:1521:DSPSHAN");
//		}
//		catch(ClassNotFoundException e)
//		{
//			JOptionPane.showMessageDialog(null, "Failed to Connect the Database" , "Database Connection Error", JOptionPane.ERROR_MESSAGE);
//			e.printStackTrace();
//		}
//		return conn;
//	}
	public boolean insert_dsp_client_in_table(Connection conn, String Code,String Name, String cell, String add1 ,String add2,String NTN) throws SQLException
	{
		boolean var = false;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO DSPCLIENT(CODE,NAME,ADD1,ADD2,CONTACT,NTN) VALUES ("+ Integer.parseInt(Code)+ ",'" + Name+ "','" + add1 + "','" + add2 + "','" + cell + "','" + NTN + "')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
		return var;
	}
        
    public boolean insert_com_rec_in_table(Connection conn, String Code,String Name) throws SQLException
	{
		boolean var = false;
		
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO COMPANY(CODE,NAME) VALUES ("+ Integer.parseInt(Code)+ ",'" + Name +"')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
		return var;
	}
//	public void close_database(Connection conn) throws SQLException
//	{
//		conn.close();
//	}

    public boolean insert_asset_rec_in_table(Connection conn, String Code, String Name,String num, String com, String value, String qty,String clqty, String assetType) {

        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO ASSETREC(CODE,ASSETNAME,ASSETNUMBER,ASSETCOMPANY,VALUE,QTY,CLQTY,ASSETCODE) VALUES ("+ Integer.parseInt(Code)+ ",'" + Name+"','"+num+"','"+com+"',"+value+","+qty+","+clqty+","+ Integer.parseInt(assetType)+ ")";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }

    public boolean insert_cash_dep_in_table(Connection conn, String Code, String date, String amount,String mName, String vanCode, String finCode, String desc) {
        
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO CASHDEPOSIT(CODE,AMOUNT,SMCODE,ODATE,VANCODE,FINCODE,DESCR) VALUES ("+ Integer.parseInt(Code)+ "," + Integer.parseInt(amount)+ "," +  Integer.parseInt(mName)+ ", DATE('" + date + "' , 'MM/DD/YY'),"+ Integer.parseInt(vanCode)+ ","+ Integer.parseInt(finCode)+",'"+desc+"' )";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }

    public boolean insert_dist_rec_in_table(Connection conn, String Code, String Dist) {
       boolean var = false;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO DISTRICT(CODE,DISTRICT) VALUES ("+ Integer.parseInt(Code)+ ",'" +Dist+ "')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }

    public boolean insert_exp_rec_in_table(Connection conn, String Code, String Exp) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO EXPENCE(CODE,EXPENCE) VALUES ("+ Integer.parseInt(Code)+ ",'" +Exp+ "')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }

     public boolean insert_exp_dep_rec_in_table(Connection conn, String Code, String exp, String sm, String date, String amount, String van, String fin) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO EXPENCEDEP(CODE,EXPCODE,SMCODE,ODATE,AMOUNT,VANCODE,FINCODE) VALUES ("+ Integer.parseInt(Code)+ ",'" + Integer.parseInt(exp)+ "','" + Integer.parseInt(sm) + "'," + " DATE('" + date + "' , 'MM/DD/YY') " + ",'" + Integer.parseInt(amount)+ "','" + Integer.parseInt(van)+ "','" + Integer.parseInt(fin)+ "')";
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
    public boolean insert_finance_rec_in_table(Connection conn, String Code, String finName, String des, String c) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO FINANCE(CODE,FINNAME,OTHERDESC,CLBAL) VALUES ("+ Integer.parseInt(Code)+ ",'" + finName+ "','" + des+ "' ,"+ Integer.parseInt(c)+ ")";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }

    public boolean insert_route_rec_in_table(Connection conn, String Code, String route) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO ROUTE(CODE,ROUTEDESC) VALUES ("+ Integer.parseInt(Code)+ ",'" + route+ "')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }
    public boolean insert_purchase_in_table(Connection conn,  String odate,String  docno,String  refno,String  supcode,
            String  tgrossamt,String  fmesum,String  splrs,String  otherexp,String  avdiscper,String  tdiscrs,String  avtaxper,
            String  ttaxrs,String  tnetamount,String  remaning,String  paid,String  remarks,String netpayable,String dealerCode,String splfmr){
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO PERMAIN(ODATE,DOCNO,REFNO,SUPCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"
                    + "TDISCRS,AVTAXPER,TTAXRS,TNETAMOUNT,REMAINING,PAID,REMARKS,"
                    + "NETPAYABLE,SPLFMR) "
                    + "VALUES (DATE('"+odate+"' ,'MM/DD/YY'),'" 
                    + Integer.parseInt(docno)+ "','" + refno+ "',"
                    + "'"+Integer.parseInt(supcode)+"','"+Float.parseFloat(tgrossamt)+"','"+Float.parseFloat(fmesum)+"','"+Float.parseFloat(splrs)+"',"
                    + "'"+Float.parseFloat(otherexp)+"','"+Float.parseFloat(avdiscper)+"','"+Float.parseFloat(tdiscrs)
                    + "','"+Float.parseFloat(avtaxper)+"','"+Float.parseFloat(ttaxrs)+"','"+Float.parseFloat(tnetamount)+"',"
                    + "'"+Float.parseFloat(remaning)+"','"+Float.parseFloat(paid)+"','"+remarks+"','"+Float.parseFloat(netpayable)+"','"+Float.parseFloat(splfmr)+"')";
             
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

    public boolean insert_purchase_products_in_table(Connection conn,String docno,String seqno,String pcode,String perqty,
            String perrate,String grossamount,String discper,String discrs,String taxper,String taxrs,
            String netamount,
            String dmg,
            String free,
            String returnqty,
            String custom,
            String expiryDate){
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO PERDTL(DOCNO,SEQNO,PCODE,PERQTY,PERRATE,GROSSAMOUNT,TDO,DISCPER,FMR,"+
                    "TAXPER,NETAMOUNT,DMG,FREE,RETURNQTY,CUSTOM,EXPIRYDATE) VALUES ('"+ Integer.parseInt(docno)+"','" + Integer.parseInt(seqno)+ "','"+Float.parseFloat(pcode)+"','"+Float.parseFloat(perqty)+"','"+Float.parseFloat(perrate)+"','"+Float.parseFloat(grossamount)+"','"+Float.parseFloat(discper)+"','"+Float.parseFloat(discrs)+ "','"+Float.parseFloat(taxper)+"','"+Float.parseFloat(taxrs)+"','"+Float.parseFloat(netamount)+"','"+Float.parseFloat(dmg)+"','"+Float.parseFloat(free)+"','"+Float.parseFloat(returnqty)+"','"+custom+"',DATE('"+expiryDate+"' ,'MM/DD/YY'))";
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

    public boolean insert_van_rec_in_table(Connection conn, String Code, String name, String num,String capacity) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO VANREC(CODE,VANNAME,VANNUMBER,CAPACITY) VALUES ("+ Integer.parseInt(Code)+ ",'" + name+ "','" + num+ "','" + capacity+ "')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }

    public boolean insert_zone_rec_in_table(Connection conn, String Code, String zone) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO ZONE(CODE,ZONE) VALUES ("+ Integer.parseInt(Code)+ ",'" + zone+ "')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }

    public boolean insert_sub_cat_rec_in_table(Connection conn, String Code, String subCat) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO SUBCAT(CODE,SUBCAT) VALUES ("+ Integer.parseInt(Code)+ ",'" + subCat+ "')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }

    public boolean insert_supp_rec_in_table(Connection conn, String Code,String name, String add1, String add2, String cell, String dist,String fName,String c) {
         boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO SUPP(CODE,NAME,ADD1,CNIC,CONTACT,REFRANCE,FNAME,CLBAL) VALUES ("+ Integer.parseInt(Code)+ ",'" + name+ "','" + add1+  "','" + add2+  "','" + cell+ "','" + dist+  "','" + fName+  "'," + Integer.parseInt(c)+  ")";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }

    public boolean insert_supp_cat_rec_in_table(Connection conn, String Code, String subCat) {
         boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO SUBCAT(CODE,SUBCAT) VALUES ("+ Integer.parseInt(Code)+ ",'" +subCat+ "')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }

    public boolean insert_cust_type_in_table(Connection conn, String Code, String type) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO CUSTTYPE(CODE,TYPE) VALUES ("+ Integer.parseInt(Code)+ ",'" +type+ "')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }
    public boolean insert_cash_type_in_table(Connection conn, String Code, String type) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO CASHTYPE(CODE,NAME) VALUES ("+ Integer.parseInt(Code)+ ",'" +type+ "')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }

    public boolean insert_emp_rec_in_table(Connection conn, String Code, String name, String cnic, String cell,
        String add1, String add2,String acType, String postCode,String salary,String nok,String relation,
        String nokcell,String datejoining,String dateleaving) throws SQLException {
        boolean var = false;
        java.sql.Statement statement = conn.createStatement();
        try{
            System.out.println("Code"+Code);System.out.println("name"+name);System.out.println("cnic"+cnic);
            System.out.println("cell"+cell);System.out.println("add1"+add1);System.out.println("add2"+add2);
            System.out.println("acType"+acType);System.out.println("salary"+salary);System.out.println("nok"+nok);
            System.out.println("nokcell"+nokcell);System.out.println("datejoining"+datejoining);
            System.out.println("dateleaving"+dateleaving);
            System.out.println("relation"+relation);
            String Sql = "INSERT INTO EMPREC(CODE,NAME,CNIC,CONTACT,ADD1,ADD2,ACTIVETYPE,POST,SALARY,NOK,RELATION,NOKCELL,DATEJOINING,DATELEAVING) VALUES ("+ Integer.parseInt(Code)+ ",'" + name+ "','" + cnic + "','" + cell + "','" + add1 + "','" + add2 + "','" + acType + "'," + Integer.parseInt(postCode) + ","+Float.parseFloat(salary)+",'" + nok + "','" + relation + "','" + nokcell + "', DATE('" + datejoining + "' , 'MM/DD/YY'),DATE('" + dateleaving + "' , 'MM/DD/YY'))";
            statement.executeUpdate(Sql);
            var = true;
        }catch(SQLException e)
        {
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }


    public boolean insert_cust_rec_in_table(Connection conn, String Code, String name, String add1, String cnic, String contact, String preBal, String custType, String relation, String ref, String c,String ct,String ppt,String zone,String route,String odate) {
       boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO CLIENTS(CODE,NAME,ADD1,CNIC,CONTACT,PREVIOUSBAL,AREACODE,REMARKS,REFFERENCE,CLBAL,ACTYPE,CUSTTYPE,ZONECODE,ROUTECODE,DATEOFJOINING) VALUES ("+
                    Integer.parseInt(Code)+ ",'" + name +  "','" + add1 +  "','" + cnic +  "','" +contact +  "'," + Integer.parseInt(preBal)  +",'" + 
                    custType + "','" +  relation + "','" +   ref + "',"+ Integer.parseInt(c)+ ",'" +ct + "','" +ppt + "'," + Integer.parseInt(zone)  +","+ Integer.parseInt(route)+ ",DATE('"+odate+"' ,'MM/DD/YY'))";
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
    public boolean insert_user_rec_in_table(Connection conn, String id, String name, String pass, String access) {
       boolean var = false;
		
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
                    String Sql = "INSERT INTO USERLOGIN(USERID,USERNAME,USERPASS,FULLACC) VALUES ("+ Integer.parseInt(id)+ ",'" + name+ "','" + pass + "','" + access + "')";
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

    public boolean insert_recovery_in_table(Connection conn, String code,String cust,String sm1, String sm2 ,String cashType, String remarks, String date,String amount,String freight,String compCode,String zero) {
        boolean var = false;
		
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
                    String Sql = "INSERT INTO RECOVERY(DOCCODE,CUSTCODE,SM1CODE,SM2CODE,CASHTPCD,REMARKS,RDATE,AMOUNT,FREIGHT,CREDITAMOUNT,COMPCODE) VALUES ("+
Integer.parseInt(code)+ "," + Integer.parseInt(cust) + "," +Integer.parseInt(sm1) +  "," + Integer.parseInt(sm2) +  "," + Integer.parseInt(cashType) +  ",'" + remarks +  "', DATE('" + date + "' , 'MM/DD/YY')," + Integer.parseInt(amount) +  "," + Integer.parseInt(freight) +  "," + Integer.parseInt(zero) +",'" + compCode +  "')";
                    statement.executeUpdate(Sql);
                    var = true;
		}
		catch(SQLException e)
		{
                    System.out.println("Error Log insert_recovery_in_table:"+e);
                    var = false;
		}finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
		return var;
    }

    public boolean insert_credit_in_table(Connection conn, String code1,String cust1,String sm3,String sm4,String cashType1,String remarks1,String date1,String amount1,String freight1,String zero) {
        boolean var = false;
		
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
                    String Sql = "INSERT INTO RECOVERY(DOCCODE,CUSTCODE,SM1CODE,SM2CODE,CASHTPCD,REMARKS,RDATE,AMOUNT,FREIGHT,CREDITAMOUNT) VALUES ("+ Integer.parseInt(code1)+ "," + Integer.parseInt(cust1) + "," +Integer.parseInt(sm3) +  "," + Integer.parseInt(sm4) +  "," + Integer.parseInt(cashType1) +  ",'" + remarks1 +  "','" + date1 +  "'," + zero +  "," + Integer.parseInt(freight1) +  "," + Integer.parseInt(amount1) +")";
                    statement.executeUpdate(Sql);
                    var = true;
		}
		catch(SQLException e)
		{
                    //System.out.println("Error Log :"+e);
                    var = false;
		}finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
		return var;
    }

    public boolean insert_asset_type_in_table(Connection conn, String code, String loc) {
        boolean var = false;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO ASSETTYPE(CODE,TYPE) VALUES ("+ Integer.parseInt(code)+ ",'" + loc +"')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }

    public boolean insert_cat_in_table(Connection conn, String code, String cat) {
         boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO PCAT(CCODE,PDESC) VALUES ("+ Integer.parseInt(code)+ ",'" + cat +"')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }

    public boolean insert_sales_man_in_table(Connection conn, String code,String name,String cnic,String contact,String add1,String add2) {
         boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO SAlEMAN(CODE,NAME,CNIC,CONTACT,ADD1,ADD2) VALUES ("+ Integer.parseInt(code)+ ",'" + name +"','" +cnic +"','" + contact +"','" + add1 +"','" + add2 +"')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;        
    }

    public boolean insert_stock_type_in_table(Connection conn, String code, String name) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO STOCKTYPE(CODE,NAME) VALUES ("+ Integer.parseInt(code)+ ",'" + name +"')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var; 
    }
//String.valueOf(codeInt),                                         name.getText(),    size.getText(), salesPrice.getText(), costPrice.getText(),  block.getText(), cat.getText(), socity.getText(),stTypeCode.getText(),"0","0.0",lineNo.getText(),remarks.getText());
    public boolean insert_product_rec_in_table(Connection conn, String code, String name, String size, String sailprice, String costprice , String cat, String socity,String sttypecode,String clqty,String clvalue,String linecode,String remarks, String dangerlevel, String minlevel, String reorderlevel, String noofpcs, String weight, String taxper, String discper, String fmrper,String retailprice) {
        boolean var = false;
		
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
                    //                                                                                                                                                                                                                           CODE,PNAME,PSIZE,SALEPRICE,COSTPRICE,BLOCKCODE,                                                                                    CATCODE,COMPANYCODE,STTYPECODE,CLQTY,CLVALUE,SUBCAT,REMARKS
//                    
                                                                                                                                                                                                //CODE                                  ,PNAME  ,PSIZE,S                ALEPRICE,                           COSTPRICE,                      BLOCKCODE,          CATCODE,            COMPANYCODE          ,STTYPECODE,                                        CLQTY,                      CLVALUE,                            SUBCAT,       REMARKS
                    String Sql = "INSERT INTO PMAST(CODE,PNAME,PSIZE,SALEPRICE,COSTPRICE,CATCODE,COMPANYCODE,STTYPECODE,CLQTY,CLVALUE,SUBCAT,REMARKS,DANGERLEVEL,MINLEVEL,REORDERLEVEL,NOOFPCS,WEIGHT,TAXPER,DISCPER,FMRPER,RETAILPRICE) VALUES ("+ Integer.parseInt(code) + ",'" +name +  "','" + size +  "'," + Float.parseFloat(sailprice) +  "," + Float.parseFloat(costprice)+ ",'" + cat+"',"+ Integer.parseInt(socity)+","+ Integer.parseInt(sttypecode)+"," + Float.parseFloat(clqty) +  "," + Float.parseFloat(clvalue) +  ","+ Integer.parseInt(linecode)+",'"+ remarks+"'"
                            + "," + Float.parseFloat(dangerlevel) +  "," + Float.parseFloat(minlevel) +  "," + Float.parseFloat(reorderlevel) +  ""
                            + "," + Float.parseFloat(noofpcs) +  "," + Float.parseFloat(weight) +  "," + Float.parseFloat(taxper) +  ""
                            + "," + Float.parseFloat(discper) +  "," + Float.parseFloat(fmrper) +  "," + Float.parseFloat(retailprice) +  ")";
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
        public ArrayList<String> get_first_st_type(Connection conn) throws SQLException
	{
            java.sql.Statement statement = conn.createStatement();
            ResultSet result = null;
            ArrayList<String> cat = new ArrayList<String>();
            try{
                int min=find_min_in_st_type_code(conn);

                String Sql = "select * from STOCKTYPE WHERE CODE="+min;

                result=statement.executeQuery(Sql);
                //System.out.println("Result : " + result);
                cat = new ArrayList<String>();

                if(result.next()){
                    String code = result.getString("CODE");
                    String assetName = result.getString("NAME");
                    cat.add(0,code);
                    cat.add(1,assetName);
                }else{
                    cat=null;
                }
            }catch(Exception e){}
            finally{
                try{
                    if (statement != null) statement.close();
                    if (result != null) result.close();
                }catch(SQLException e){}
            }
            return cat;
	}
        
    public ArrayList<String> get_first_cat(Connection conn) throws SQLException
    {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat = new ArrayList<String>();
        
        try{
            int min=find_min_in_cat_code(conn);
            String Sql = "select * from PCAT WHERE CCODE="+min;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                String code = result.getString("CCODE");
                String assetName = result.getString("PDESC");
                cat.add(0,code);
                cat.add(1,assetName);
            }else{
                cat=null;
            }
        }catch(Exception e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public ArrayList<String> get_first_customer(Connection conn) throws SQLException{
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat = new ArrayList<String>();
        try{
            int min=find_min_in_cust_rec_code(conn);
            String Sql = "select * from CLIENTS WHERE CODE="+min;

            result=statement.executeQuery(Sql);
            cat = new ArrayList<String>();

            if(result.next()){
                cat = setCustRec(result);
            }else{
                cat=null;
            }
        }catch(Exception ex){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public ArrayList<String> get_first_zone(Connection conn) throws SQLException{
       java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat =null;
        try{
            int min=find_min_in_zone_code(conn);
            String Sql = "select * from ZONE WHERE CODE="+min;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                String code = result.getString("CODE");
                String assetName = result.getString("ZONE");
                cat.add(code);
                cat.add(assetName);
            }else{
                cat=null;
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }

        return cat;
    }
    public ArrayList<String> get_first_dist(Connection conn)throws SQLException {
       java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat = null;
        try{
            int min=find_min_in_dist_code(conn);
            String Sql = "select * from DISTRICT WHERE CODE="+min;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat=new ArrayList<String>();
                String code = result.getString("CODE");
                String assetName = result.getString("DISTRICT");
                if(code!=null||assetName!=null){
                    cat.add(code);
                    cat.add(assetName);
                }else{
                    cat=null;
                }
            }else{
                cat=null;
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public ArrayList<String> get_first_com(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat = null;
        
        try{
            int min=find_min_in_com_code(conn);
            String Sql = "select * from COMPANY WHERE CODE="+min;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat=new ArrayList<String>();
                String code = result.getString("CODE");
                String assetName = result.getString("NAME");
                if(code!=null||assetName!=null){
                    cat.add(code);
                    cat.add(assetName);
                }else{
                    cat=null;
                }
            }else{
                cat=null;
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public ArrayList<String> get_first_asset(Connection conn)  throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat = null;
        try{
            int min=find_min_in_asset_code(conn);
            String Sql = "select * from ASSETREC WHERE CODE="+min;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                String code1 = result.getString("CODE");
                String assetName = result.getString("ASSETNAME");
                String code2 = result.getString("ASSETNUMBER");
                String assetName1 = result.getString("ASSETCOMPANY");//VALUE,QTY,CLQTY,ASSETCODE
                String assetName3 = result.getString("VALUE");
                String code23 = result.getString("QTY");
                String assetName13 = result.getString("CLQTY");
                String assetName14 = result.getString("ASSETCODE");
                cat.add(0,code1);
                cat.add(1,assetName);
                cat.add(2,code2);
                cat.add(3,assetName1);
                cat.add(4,assetName3);
                cat.add(5,code23);
                cat.add(6,assetName13);
                cat.add(7,assetName14);
            }else{
                cat.add(null);
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public ArrayList<String> get_first_cash(Connection conn) throws SQLException{
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat = null;
        
        try{
            String Sql = "select * " +
                            "from CASHDEPOSIT";

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                String code = result.getString("CODE");
                String smCode = result.getString("SMCODE");
                String date = result.getString("ODATE");
                String amount = result.getString("AMOUNT");
                cat.add(code);
                cat.add(smCode);
                cat.add(date);
                cat.add(amount);
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public ArrayList<String> get_first_finance(Connection conn) throws SQLException{
        java.sql.Statement statement = conn.createStatement();
        ArrayList<String> cat=null;
        ResultSet result = null;
        try{
            int min=0;
            min=find_min_in_fin_rec_code(conn);
            if(min!=0){
                String Sql = "select * from FINANCE WHERE CODE="+min;

                result=statement.executeQuery(Sql);
                //System.out.println("Result : " + result);
               cat = new ArrayList<String>();

                if(result.next()){
                    String code = result.getString("CODE");
                    String assetName = result.getString("FINNAME");
                    String assetName1 = result.getString("OTHERDESC");
                    cat.add(code);
                    cat.add(assetName);
                    cat.add(assetName1);
                }else{
                    cat.add(null);
                }
            }else{
                cat=null;
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public ArrayList<String> get_first_loc(Connection conn)throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int min=find_min_in_loc_code(conn);
        ArrayList<String> cat = null;
        ResultSet result = null;
        try{
            String Sql = "select * from ASSETTYPE WHERE CODE="+min;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                String code = result.getString("CODE");
                String assetName = result.getString("TYPE");
                cat.add(code);
                cat.add(assetName);
            }else{
                cat=null;
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;

    }

    public ArrayList<String> get_first_route(Connection conn)  throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat = null;
        
        try{
            int min=find_min_in_route_code(conn);
            String Sql = "select * from ROUTE WHERE CODE="+min;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                String code = result.getString("CODE");
                String assetName = result.getString("ROUTEDESC");
                cat.add(0,code);
                cat.add(1,assetName);
            }else{
                cat=null;
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public ArrayList<String> get_first_cmobrec(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ArrayList<String> cat = null;
        ResultSet result = null;
        try{
            String Sql = "select * " +
                            "from SALEMAN";

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            result.next();

            String code = result.getString("CODE");
            String n = result.getString("NAME");
            String c = result.getString("CNIC");
            String co = result.getString("CONTACT");
            String ad = result.getString("ADD1");
            String add = result.getString("ADD2");
            cat.add(code);
            cat.add(n);
            cat.add(c);
            cat.add(co);
            cat.add(ad);
            cat.add(add);
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public ArrayList<String> get_first_dsp(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ArrayList<String> cat=null;
        ResultSet result = null;
        
        try{
            int min=0;
            min=find_min_in_dsp_client_code(conn);
            if(min!=0){
                String Sql = "select * from DSPCLIENT WHERE CODE="+min;

                result=statement.executeQuery(Sql);
               cat = new ArrayList<String>();

                if(result.next()){
                    String a = result.getString("CODE");
                    String b = result.getString("NAME");
                    String c = result.getString("ADD1");
                    String d = result.getString("ADD2");
                    String e = result.getString("CONTACT");
                    String f = result.getString("NTN");
                    cat.add(0,a);
                    cat.add(1,b);
                    cat.add(2,c);
                    cat.add(3,d);
                    cat.add(4,e);
                    cat.add(5,f);
                }else{
                    cat.add(null);
                }
            }else{
                cat=null;
            }
        }catch(SQLException e){System.out.println("SQL Exception Occured in Retrieveing Data");}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    
    public ArrayList<String> get_first_van_rec(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ArrayList<String> cat=null;
        ResultSet result = null;
        try{
            int min=0;
            min=find_min_in_van_rec_code(conn);
            if(min!=0){
                String Sql = "select * from VANREC WHERE CODE="+min;

                result=statement.executeQuery(Sql);
                //System.out.println("Result : " + result);
               cat = new ArrayList<String>();

                if(result.next()){
                    String code = result.getString("CODE");
                    String assetName = result.getString("VANNAME");
                    String assetName1 = result.getString("VANNUMBER");
                    String assetName2 = result.getString("CAPACITY");
                    cat.add(code);
                    cat.add(assetName);
                    cat.add(assetName1);
                    cat.add(assetName2);
                }else{
                    cat.add(null);
                }
            }else{
                cat=null;
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public ArrayList<String> get_first_emp_rec(Connection conn)throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat=null;
        try{
            int min=0;
            min=find_min_in_emp_rec_code(conn);
            if(min!=0){
                String Sql = "select * from EMPREC WHERE CODE="+min;

                result=statement.executeQuery(Sql);
                System.out.println("Result rrr1 : " + result);
               cat = new ArrayList<String>();

                if(result.next()){
                   cat = get_emp_rec(result);
                System.out.println("result rrr2: "+cat);
                   return cat;
                }
            }else{
                cat=null;
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public ArrayList<String> get_first_recovery(Connection conn,boolean isCredit)throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat=null;
        try{
            int min=0;
            min=find_min_in_recovery_credit_rec_code(conn,isCredit);
            if(min!=0){
                String Sql;
                Sql = "select * from RECOVERY WHERE DOCCODE="+min;//+"AND CREDITAMOUNT > "+Integer.parseInt("0");
                result=statement.executeQuery(Sql);
                //System.out.println("Result : " + result);
               cat = new ArrayList<String>();

                if(result.next()){
                    String code = result.getString("DOCCODE");
                    String n = result.getString("CUSTCODE");
                    String c = result.getString("SM1CODE");
                    String co = result.getString("SM2CODE");
                    String ad = result.getString("CASHTPCD");
                    String add = result.getString("REMARKS");
                    String d = result.getString("RDATE");
                    String am = result.getString("AMOUNT");
                    String fr = result.getString("FREIGHT");
                    String cr = result.getString("CREDITAMOUNT");
                    String cr1 = result.getString("COMPCODE");
                    cat.add(0,code);
                    cat.add(1,n);
                    cat.add(2,c);
                    cat.add(3,co);
                    cat.add(4,ad);
                    cat.add(5,add);
                    cat.add(6,d);
                    cat.add(7,am);
                    cat.add(8,fr);
                    cat.add(9,cr);
                    cat.add(10,cr1);
                }else{
                    cat.add(null);
                }
            }else{
                cat=null;
            }
        }catch(SQLException e){}
        finally{
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
        ArrayList<String> cat = null;
        try{
            int min=0;
            min=find_min_in_purchase_code(conn);
            if(min!=0){
                String Sql;
                Sql = "select * from PERMAIN WHERE DOCNO="+min;//+"AND CREDITAMOUNT > "+Integer.parseInt("0");
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
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
        
    }

    public ArrayList<String> get_first_prod_rec(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ArrayList<String> cat=null;
        ResultSet result = null;
        try{
            int min=0;
            min=find_min_in_product_rec_code(conn);
            if(min!=0){
                String Sql = "select * from PMAST WHERE CODE="+min;

                result=statement.executeQuery(Sql);
                //System.out.println("Result : " + result);
               cat = new ArrayList<String>();

                if(result.next()){
                    cat = getRecords(result);
            }else{
                    cat=null;
                }
            }else{
                cat=null;
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public ArrayList<String> get_first_custtype(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat = null;
        try{
            int min=find_min_in_cust_type_code(conn);

            String Sql = "select * from CUSTTYPE WHERE CODE="+min;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat=new ArrayList<String>();
                String code = result.getString("CODE");
                String assetName = result.getString("TYPE");
                if(code!=null||assetName!=null){
                    cat.add(code);
                    cat.add(assetName);
                }else{
                    cat=null;
                }
            }else{
                cat=null;
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public ArrayList<String> get_first_cashtype(Connection conn) throws SQLException, SQLException, SQLException, SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        
        int min=find_min_in_cust_type_code(conn);
        String Sql = "select * from CASHTYPE WHERE CODE="+min;

        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = null;
        try{
            if(result.next()){
                cat=new ArrayList<String>();
                String code = result.getString("CODE");
                String assetName = result.getString("NAME");
                if(code!=null||assetName!=null){
                    cat.add(code);
                    cat.add(assetName);
                }else{
                    cat=null;
                }
            }else{
                cat=null;
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public ArrayList<String> get_first_user(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * " +
                        "from USERLOGIN";
        ArrayList<String> cat = null;

        ResultSet result = null;
        try{
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            result.next();

            String code = result.getString("USERID");
            String n = result.getString("USERNAME");
            String c = result.getString("USERPASS");
            cat.add(code);
            cat.add(n);
            cat.add(c);
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public int find_max_in_asset_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from ASSETREC";
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
    public int find_max_in_com_code(Connection conn) {
        int max = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from COMPANY";
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
    public int find_min_in_asset_code(Connection conn) {
        int min = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from ASSETREC";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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

    public boolean delete_asset(Connection conn ,String code, String asset) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM ASSETREC WHERE CODE = "+code;
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

    public boolean update_asset(Connection conn, String code,String name,String num,String com,String value,String qty,String clqty,String asset) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
//                    VALUE,QTY,CLQTY,ASSETCODE
            Sql="UPDATE ASSETREC SET ASSETNAME = '"+name+"',ASSETNUMBER = '"+num+"',ASSETCOMPANY = '"+com+"'"
                    + ",VALUE = '"+value+"',QTY = '"+qty+"',CLQTY = '"+clqty+"',ASSETCODE = '"+asset+"'WHERE CODE="+code;
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

    public ArrayList<String> prior_asset(Connection conn, String code, String text0) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM ASSETREC WHERE CODE <"+Integer.parseInt(code)+" ORDER BY lower(CODE) DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String code1 = result.getString("CODE");
                String assetName = result.getString("ASSETNAME");
                String code2 = result.getString("ASSETNUMBER");
                String assetName1 = result.getString("ASSETCOMPANY");//VALUE,QTY,CLQTY,ASSETCODE
                String assetName3 = result.getString("VALUE");
                String code23 = result.getString("QTY");
                String assetName13 = result.getString("CLQTY");
                String assetName14 = result.getString("ASSETCODE");
                cat.add(0,code1);
                cat.add(1,assetName);
                cat.add(2,code2);
                cat.add(3,assetName1);
                cat.add(4,assetName3);
                cat.add(5,code23);
                cat.add(6,assetName13);
                cat.add(7,assetName14);
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

    public ArrayList<String> next_asset(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM ASSETREC WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";
//            Sql="SELECT * "+
//                    "from   ASSETREC"+
//                    "lag(CODE) over (order by CODE)"+
//                    "lead(CODE) over (order by CODE)";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String code1 = result.getString("CODE");
                String assetName = result.getString("ASSETNAME");
                String code2 = result.getString("ASSETNUMBER");
                String assetName1 = result.getString("ASSETCOMPANY");//VALUE,QTY,CLQTY,ASSETCODE
                String assetName3 = result.getString("VALUE");
                String code23 = result.getString("QTY");
                String assetName13 = result.getString("CLQTY");
                String assetName14 = result.getString("ASSETCODE");
                cat.add(0,code1);
                cat.add(1,assetName);
                cat.add(2,code2);
                cat.add(3,assetName1);
                cat.add(4,assetName3);
                cat.add(5,code23);
                cat.add(6,assetName13);
                cat.add(7,assetName14);
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

    public ArrayList<String> get_last_asset(Connection conn)throws SQLException{
        ResultSet result = null;
        java.sql.Statement statement = conn.createStatement();
        ArrayList<String> cat = null;
        
        try{
            int max=find_max_in_asset_code(conn);
            String Sql = "select * from ASSETREC WHERE CODE="+max;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                String code1 = result.getString("CODE");
                String assetName = result.getString("ASSETNAME");
                String code2 = result.getString("ASSETNUMBER");
                String assetName1 = result.getString("ASSETCOMPANY");//VALUE,QTY,CLQTY,ASSETCODE
                String assetName3 = result.getString("VALUE");
                String code23 = result.getString("QTY");
                String assetName13 = result.getString("CLQTY");
                String assetName14 = result.getString("ASSETCODE");
                cat.add(0,code1);
                cat.add(1,assetName);
                cat.add(2,code2);
                cat.add(3,assetName1);
                cat.add(4,assetName3);
                cat.add(5,code23);
                cat.add(6,assetName13);
                cat.add(7,assetName14);
            }else{
                cat.add(null);
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public String[][] search_asset_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_asset_code(conn)][4];
	java.sql.Statement statement = conn.createStatement();
	ResultSet result = null;
	try{
            String Sql = "Select * from ASSETREC where UPPER(ASSETNAME) like UPPER('" + asset_rec + "%')";
            result = statement.executeQuery(Sql);
            int i=0;
            while(result.next())
            {           
                    returned[i][0]=result.getString("CODE");
                    returned[i][1]=result.getString("ASSETNAME");
                    returned[i][2]=result.getString("ASSETNUMBER");
                    returned[i][3]=result.getString("ASSETCOMPANY");
                    i++;
                    //returned=null;
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_cash_type(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_cash_type_code(conn)][2];
	ResultSet result = null;
	java.sql.Statement statement = conn.createStatement();
        try{
            String Sql = "Select * from CASHTYPE where UPPER(NAME) like UPPER('" + asset_rec + "%')";
            result = statement.executeQuery(Sql);
            int i=0;
            while(result.next())
            {           
                    returned[i][0]=result.getString("CODE");
                    returned[i][1]=result.getString("NAME");
                    i++;
                    //returned=null;
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    Conversions ccc =new Conversions();
    
    public String[][] search_exp_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_exp_rec_code(conn)][4];
	ResultSet result = null;
	java.sql.Statement statement = conn.createStatement();
        try{
            String Sql = "Select * from EXPENCEDEP where UPPER(SMCODE) like UPPER('" + asset_rec + "%')";
            result = statement.executeQuery(Sql);
            int i=0;
            while(result.next())
            {           
                    returned[i][0]=result.getString("CODE");
                    returned[i][1]=find_sm_name_by_code(conn, result.getString("SMCODE"));
                try {
                    //                returned[i][2]=result.getString("ODATE");
                    returned[i][2]=ccc.toDateString(ccc.toDate(result.getString("ODATE"))+"");
                } catch (ParseException ex) {
                    Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
                }
                    returned[i][3]=result.getString("AMOUNT");
                    //System.out.println("Code: " + result.getString("CODE"));
                    //System.out.println("SMCODE: " + result.getString("SMCODE"));
                    //System.out.println("ODATE: " + result.getString("ODATE"));
                    //System.out.println("AMOUNT: " + result.getString("AMOUNT"));
                    i++;
                    //returned=null;
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public ArrayList<String>[] search_products(Connection conn, String asset_rec) throws SQLException {
            java.sql.Statement statement = null;
        ArrayList<String> returned[] = new ArrayList[find_count_in_purchase_products(conn,asset_rec)];
	ResultSet result = null;
        try{
            statement = conn.createStatement();
    //         SELECT * FROM PERDTL WHERE  DOCNO = 90002 ORDER BY SEQNO ASC
            String Sql = "SELECT * FROM PERDTL WHERE  DOCNO = '"+asset_rec+"' ORDER BY SEQNO ASC";
            result = statement.executeQuery(Sql);
            int i=0;
            while(result.next())
            {         
                returned[i]=getPurchaseProducts(result);
                i++;
            }  
        }catch(SQLException e){}
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
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = " SELECT COUNT(SEQNO) AS Count FROM PERDTL WHERE  DOCNO = '"+name+"'";
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
    public int find_max_in_purchase_products(Connection conn, String name) {
            ResultSet result = null;
        int count = 1;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = " SELECT MAX(SEQNO) AS Count FROM PERDTL WHERE  DOCNO = '"+name+"'";
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
    public String[][] search_recovery(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_recovery(conn)][6];
	java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        String Sql=null;
        try{
        if(!asset_rec.equals("")){
                Sql = "Select * from RECOVERY where UPPER(CUSTCODE) like UPPER('" + asset_rec + "%')";
            }else{
                Sql = "Select * from RECOVERY where AMOUNT <> "+Integer.parseInt("0");
                result = statement.executeQuery(Sql);
                int i=0;
                while(result.next())
                {           
                        returned[i][0]=result.getString("DOCCODE");
                        returned[i][1]=find_cust_name_by_code(conn,result.getString("CUSTCODE"));
                        try {
                            returned[i][3]=ccc.toDateString(ccc.toDate(result.getString("RDATE"))+"");//resultset.getString("DOCDATE");
                        } catch (ParseException ex) {
                            Logger.getLogger(PAK_SELLERLEDGER_DB.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                        returned[i][4]=find_sm_name_by_code(conn, result.getString("SM1CODE"));
                        returned[i][5]=result.getString("AMOUNT");
                        i++;
                        //returned=null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_credit(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_credit(conn)][6];
	java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        String Sql=null;
        try{
            if(!asset_rec.equals("")){
                Sql = "Select * from RECOVERY where CUSTCODE like " + find_cust_code_by_name(conn,asset_rec)+ "%)";
            }else{
                Sql = "Select * from RECOVERY where CREDITAMOUNT <> "+Integer.parseInt("0");
            }
            result = statement.executeQuery(Sql);
            int i=0;
            while(result.next())
            {           
                returned[i][0]=result.getString("DOCCODE");
                returned[i][1]=find_cust_name_by_code(conn,result.getString("CUSTCODE"));
                 try {
                    returned[i][3]=ccc.toDateString(ccc.toDate(result.getString("RDATE"))+"");//resultset.getString("DOCDATE");
                } catch (ParseException ex) {
                    Logger.getLogger(PAK_SELLERLEDGER_DB.class.getName()).log(Level.SEVERE, null, ex);
                }
                returned[i][4]=find_sm_name_by_code(conn, result.getString("SM1CODE"));
                returned[i][5]=result.getString("CREDITAMOUNT");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String get_clbal_from_custbal(Connection conn, String code) {
        String  cat="0";
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select BALANCE from CUSTBALANCE WHERE CUSTOMER='"+code+"'";
            
            result=statement.executeQuery(Sql);
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
        return cat;
    }
    
    public String[][] search_cust_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_cust_rec_code(conn)][7];
	ResultSet result =null;
	java.sql.Statement statement = conn.createStatement();
        try{
            String Sql = "Select * from CLIENTS where UPPER(NAME) like UPPER('" + asset_rec + "%')";
            result = statement.executeQuery(Sql);
            int i=0;
            while(result.next())
            {   
                returned[i][0]=result.getString("CODE");
                returned[i][1]=result.getString("NAME");
                returned[i][2]=result.getString("CONTACT");
                returned[i][3]=result.getString("ADD1");
                returned[i][4]=result.getString("ROUTECODE");
                returned[i][5]=find_route_name_by_code(conn, result.getString("ROUTECODE"));
                returned[i][6]=get_clbal_from_custbal(conn,result.getString("CLBAL"));
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_emp_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_emp_rec_code(conn)][6];
	ResultSet result = null;
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from EMPREC where UPPER(NAME) like UPPER('" + asset_rec + "%')";
	try{
            result = statement.executeQuery(Sql);
            int i=0;
            while(result.next())
            {           
                    returned[i][0]=result.getString("CODE");
                    returned[i][1]=result.getString("NAME");
                    returned[i][2]=find_post_name_by_code(conn, result.getString("POST"));
                    returned[i][3]=result.getString("CONTACT");
                    returned[i][4]=result.getString("ADD1");
                    returned[i][5]=result.getString("ACTIVETYPE");
                    i++;
                    //returned=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_scheme_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_scheme_rec_code(conn,asset_rec)][5];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select distinct TONO,PCODE,UNITD,ODATE,CDATE from SCHEMERS where TONO like '" + asset_rec + "%'";
	ResultSet resultset =null;
        try{
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {           
                try {
                    returned[i][0]=resultset.getString("TONO");
                    returned[i][1]=find_product_name_by_code(conn,resultset.getString("PCODE"));
                    returned[i][2]=resultset.getString("UNITD");
                    returned[i][3]=ccc.toDateString(ccc.toDate(resultset.getString("ODATE"))+"");
                    returned[i][4]=ccc.toDateString(ccc.toDate(resultset.getString("CDATE"))+"");
                    i++;
                } catch (ParseException ex) {
                    Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_schemeqty_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_schemeqty_rec_code(conn,asset_rec)][5];
	ResultSet resultset = null;
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select distinct TONO,PCODE,UNITD,ODATE,CDATE from SCHEMEQTY where TONO like '" + asset_rec + "%'";
	try{
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {           
                try {
                    returned[i][0]=resultset.getString("TONO");
                    returned[i][1]=find_product_name_by_code(conn,resultset.getString("PCODE"));
                    returned[i][2]=resultset.getString("UNITD");
                    returned[i][3]=ccc.toDateString(ccc.toDate(resultset.getString("ODATE"))+"");
                    returned[i][4]=ccc.toDateString(ccc.toDate(resultset.getString("CDATE"))+"");
                    i++;
                } catch (ParseException ex) {
                    Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_schemeqtypro_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_schemeqtypro_rec_code(conn,asset_rec)][5];
	java.sql.Statement statement = conn.createStatement();
	ResultSet result = null;	
        try{
            String Sql = "Select distinct TONO,PCODE,UNITD,ODATE,CDATE from SCHQTYPRO where TONO like '" + asset_rec + "%'";
            result = statement.executeQuery(Sql);int i=0;
            while(result.next())
            {           
                try {
                    returned[i][0]=result.getString("TONO");
                    returned[i][1]=find_product_name_by_code(conn,result.getString("PCODE"));
                    returned[i][2]=result.getString("UNITD");
                    returned[i][3]=ccc.toDateString(ccc.toDate(result.getString("ODATE"))+"");
                    returned[i][4]=ccc.toDateString(ccc.toDate(result.getString("CDATE"))+"");
                    i++;
                } catch (ParseException ex) {
                    Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    public String[][] search_schprocatpro_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_schprocatpro_rec_code(conn,asset_rec)][5];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select distinct TONO,PCODE,UNITD,ODATE,CDATE from SCHPROCATPRO where TONO like '" + asset_rec + "%'";
	ResultSet resultset = null;
	try{
            resultset = statement.executeQuery(Sql);

            int i=0;
            while(resultset.next())
            {           
                try {
                    returned[i][0]=resultset.getString("TONO");
                    returned[i][1]=find_product_name_by_code(conn,resultset.getString("PCODE"));
                    returned[i][2]=resultset.getString("UNITD");
                    returned[i][3]=ccc.toDateString(ccc.toDate(resultset.getString("ODATE"))+"");
                    returned[i][4]=ccc.toDateString(ccc.toDate(resultset.getString("CDATE"))+"");
                    i++;
                } catch (ParseException ex) {
                    Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_schemeprocat_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_schemeprocat_rec_code(conn,asset_rec)][5];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select distinct TONO,PCODE,UNITD,ODATE,CDATE from SCHEMEPROCAT where TONO like '" + asset_rec + "%'";
	ResultSet resultset = null;
        try{
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {           
                try {
                    returned[i][0]=resultset.getString("TONO");
                    returned[i][1]=find_product_name_by_code(conn,resultset.getString("PCODE"));
                    returned[i][2]=resultset.getString("UNITD");
                    returned[i][3]=ccc.toDateString(ccc.toDate(resultset.getString("ODATE"))+"");
                    returned[i][4]=ccc.toDateString(ccc.toDate(resultset.getString("CDATE"))+"");
                    i++;
                } catch (ParseException ex) {
                    Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_slab_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_slab_rec_code(conn,asset_rec)][3];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select distinct SLABNO,FROMDATE,TODATE from SLAB where SLABNO like '" + asset_rec + "%'";
	ResultSet resultset = null;
        try{
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {           
                try {
                    returned[i][0]=resultset.getString("SLABNO");
                    returned[i][1]=ccc.toDateString(ccc.toDate(resultset.getString("FROMDATE"))+"");
                    returned[i][2]=ccc.toDateString(ccc.toDate(resultset.getString("TODATE"))+"");
                    i++;
                } catch (ParseException ex) {
                    Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_product_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_product_rec_code(conn)][10];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from PMAST where UPPER(PNAME) like UPPER('" + asset_rec + "%')";
	ResultSet resultset = null;
	try{
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {           

                    returned[i][0]=resultset.getString("CODE");
                    returned[i][1]=find_st_type_by_code(conn, resultset.getString("STTYPECODE"));
                    returned[i][2]=find_cat_name_by_code(conn, resultset.getString("CATCODE"));
                    returned[i][3]=resultset.getString("PNAME");
                    returned[i][4]=resultset.getString("PSIZE");
                    returned[i][5]=find_subCat_Name_by_code(conn, resultset.getString("SUBCAT"));
    //                returned[i][6]=find_loc_name_by_code(conn, result.getString("BLOCKCODE"));
                    returned[i][7]=find_com_name_by_code(conn, resultset.getString("COMPANYCODE"));
                    returned[i][8]=resultset.getString("SALEPRICE");
                    returned[i][9]=resultset.getString("COSTPRICE");
                    i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_cat_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_cat_rec(conn)][2];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from PCAT where UPPER(PDESC) like UPPER('" + asset_rec + "%')";
	ResultSet resultset = null;
	try{
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {           
                    returned[i][0]=resultset.getString("CCODE");
                    returned[i][1]=resultset.getString("PDESC");
                    i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_zone_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_zone_rec(conn)][2];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from ZONE where UPPER(ZONE) like UPPER('" + asset_rec + "%')";
	ResultSet resultset = null;
        try{
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {           
                    returned[i][0]=resultset.getString("CODE");
                    returned[i][1]=resultset.getString("ZONE");
                    i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_sub_cat_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_sub_cat_rec(conn)][2];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from SUBCAT where UPPER(SUBCAT) like UPPER('" + asset_rec + "%')";
	ResultSet resultset = null;
        try{
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {           
                    returned[i][0]=resultset.getString("CODE");
                    returned[i][1]=resultset.getString("SUBCAT");
                    //System.out.println("Code: " + result.getString("CODE"));
                    //System.out.println("ASSETNAME: " + result.getString("SUBCAT"));
                    i++;
                    //returned=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_st_type_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_st_type_rec_code(conn)][2];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from STOCKTYPE where UPPER(NAME) like UPPER('" + asset_rec + "%')";
	ResultSet resultset = null;
        try{
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {           
                    returned[i][0]=resultset.getString("CODE");
                    returned[i][1]=resultset.getString("NAME");
                    //System.out.println("Code: " + result.getString("CODE"));
                    //System.out.println("NAME: " + result.getString("NAME"));
                    i++;
                    //returned=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_stloc_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_stloc_code(conn)][2];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from ASSETTYPE where UPPER(TYPE) like UPPER('" + asset_rec + "%')";
	ResultSet resultset = null;
	try{
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {           
                    returned[i][0]=resultset.getString("CODE");
                    returned[i][1]=resultset.getString("TYPE");
                    //System.out.println("Code: " + result.getString("CODE"));
                    //System.out.println("LOCATION: " + result.getString("LOCATION"));
                    i++;
                    //returned=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_custtype(Connection conn, String custtype) throws SQLException {
        String returned[][] = new String[find_count_in_custtype_code(conn)][2];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from CUSTTYPE where UPPER(TYPE) like UPPER('" + custtype + "%')";
	ResultSet resultset = statement.executeQuery(Sql);
	try{
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {
                    returned[i][0]=resultset.getString("CODE");
                    returned[i][1]=resultset.getString("TYPE");
                    //System.out.println("Code: " + result.getString("CODE")+"\n TYPE: " + result.getString("TYPE"));
                    i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_distrec(Connection conn, String distrec) throws SQLException {
        String returned[][] = new String[find_count_in_distrec_code(conn)][2];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from DISTRICT where UPPER(DISTRICT) like UPPER('" + distrec + "%')";
	ResultSet resultset = statement.executeQuery(Sql);
	try{
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {
                    returned[i][0]=resultset.getString("CODE");
                    returned[i][1]=resultset.getString("DISTRICT");
                    //System.out.println("Code: " + result.getString("CODE")+"\n TYPE: " + result.getString("DISTRICT"));
                    i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_expence(Connection conn, String distrec) throws SQLException {
        String returned[][] = new String[find_count_in_expence_code(conn)][2];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from EXPENCE where UPPER(EXPENCE) like UPPER('" + distrec + "%')";
	ResultSet resultset = null;
	try{
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {
                    returned[i][0]=resultset.getString("CODE");
                    returned[i][1]=resultset.getString("EXPENCE");
                    //System.out.println("Code: " + result.getString("CODE")+"\n TYPE: " + result.getString("EXPENCE"));
                    i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_postrec(Connection conn, String distrec) throws SQLException {
        String returned[][] = new String[find_count_in_postrec_code(conn)][2];
	java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
	
        try{
            String Sql = "Select * from POST where UPPER(POST) like UPPER('" + distrec + "%')";
            result = statement.executeQuery(Sql);
            int i=0;
            while(result.next())
            {
                    returned[i][0]=result.getString("CODE");
                    returned[i][1]=result.getString("POST");
                    //System.out.println("Code: " + result.getString("CODE")+"\n POST: " + result.getString("POST"));
                    i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_routerec(Connection conn, String distrec) throws SQLException {
        java.sql.Statement statement = null;
        String returned[][] = new String[find_count_in_routerec_code(conn)][2];
        ResultSet resultset = null;
	
        try{
            statement = conn.createStatement();
            String Sql = "Select * from ROUTE where UPPER(ROUTEDESC) like UPPER('" + distrec + "%')";
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {
                    returned[i][0]=resultset.getString("CODE");
                    returned[i][1]=resultset.getString("ROUTEDESC");
                    //System.out.println("Code: " + result.getString("CODE")+"\n POST: " + result.getString("ROUTEDESC"));
                    i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_purchase(Connection conn, String distrec) throws SQLException {
//        /*
        String returned[][] = new String[find_count_in_routerec_code(conn)][14];
            java.sql.Statement statement = null;
            ResultSet resultset = null;
	
        try{
            statement = conn.createStatement();
            String Sql = "Select * from PERMAIN";
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
                    returned[i][3]=find_supp_name_by_code(conn, resultset.getString("SUPCODE"));//get Name
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
                    //System.out.println("Code: " + result.getString("CODE")+"\n POST: " + result.getString("ROUTEDESC"));
                    i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
//        */
    }
    public String[][] search_sales(Connection conn, String distrec) throws SQLException {
//        /*
        String returned[][] = new String[find_count_in_routerec_code(conn)][14];
        java.sql.Statement statement = null;
        ResultSet resultset = null;
	try{
            statement = conn.createStatement();
            String Sql = "Select * from SMAIN";
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {
                    returned[i][0]=resultset.getString("DOCNO");
                    returned[i][1]=resultset.getString("REFNO");
    //                returned[i][2]=result.getString("ODATE");
                    try {
                        returned[i][2]=ccc.toDateString(ccc.toDate(resultset.getString("ODATE"))+"");//resultset.getString("DOCDATE");
                    } catch (ParseException ex) {
                        Logger.getLogger(PAK_SELLERLEDGER_DB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    returned[i][3]=find_cust_rec_code_by_name(conn, resultset.getString("CUSTCODE"));//get Name
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
                    i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }    
        return returned;
//        */
    }
    public String[][] search_finrec(Connection conn, String distrec) throws SQLException {
        String returned[][] = new String[find_count_in_finrec_code(conn)][3];
		
	java.sql.Statement statement = null;
        ResultSet resultset = null;
	try{
            statement = conn.createStatement();
            String Sql = "Select * from FINANCE where UPPER(FINNAME) like UPPER('" + distrec + "%')";
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {
                    returned[i][0]=resultset.getString("CODE");
                    returned[i][1]=resultset.getString("FINNAME");
                    returned[i][2]=resultset.getString("OTHERDESC");

                    i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        } 
        return returned;
    }
    public String[][] search_vanrec(Connection conn, String distrec) throws SQLException {
        String returned[][] = new String[find_count_in_vanrec_code(conn)][4];
		
	java.sql.Statement statement = null;
        ResultSet resultset = null;
	try{
            statement = conn.createStatement();
            String Sql = "Select * from VANREC where UPPER(VANNAME) like UPPER('" + distrec + "%')";
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {
                    returned[i][0]=resultset.getString("CODE");
                    returned[i][1]=resultset.getString("VANNAME");
                    returned[i][2]=resultset.getString("VANNUMBER");
                    returned[i][3]=resultset.getString("CAPACITY");

                    i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    public String[][] search_firmrec(Connection conn, String distrec) throws SQLException {
        String returned[][] = new String[find_count_in_firmrec_code(conn)][6];
		
	java.sql.Statement statement = null;
        ResultSet resultset = null;
	try{
            statement = conn.createStatement();
            String Sql = "Select * from DSPCLIENT where UPPER(NAME) like UPPER('" + distrec + "%')";
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {
                    returned[i][0]=resultset.getString("CODE");
                    returned[i][1]=resultset.getString("NAME");
                    returned[i][2]=resultset.getString("ADD1");
                    returned[i][3]=resultset.getString("ADD2");
                    returned[i][4]=resultset.getString("CONTACT");
                    returned[i][5]=resultset.getString("NTN");


                    i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }
    
    public String[][] search_suprec(Connection conn, String distrec) throws SQLException {
        String returned[][] = new String[find_count_in_suprec(conn)][7];
		
	java.sql.Statement statement = null;
        ResultSet resultset = null;
	try{
            statement = conn.createStatement();
            String Sql = "Select * from SUPP where UPPER(NAME) like UPPER('" + distrec + "%')";
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {
                    returned[i][0]=resultset.getString("CODE");
                    returned[i][1]=resultset.getString("NAME");
                    returned[i][2]=resultset.getString("FNAME");
                    returned[i][3]=resultset.getString("ADD1");
                    returned[i][4]=resultset.getString("CONTACT");
                    returned[i][5]=resultset.getString("CNIC");
                    returned[i][6]=resultset.getString("REFRANCE");
                    i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }    
        return returned;
    }

    private int find_count_in_asset_code(Connection conn) {
        int count = 0;
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from ASSETREC";
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
    private int find_count_in_cash_type_code(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from CASHTYPE";
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
    private int find_count_in_exp_rec_code(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from EXPENCEDEP";
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
    private int find_count_in_all_recovery_credit(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(DOCCODE))as Count from RECOVERY";
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
    private int find_count_in_recovery(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(DOCCODE))as Count from RECOVERY Where AMOUNT <> "+Integer.parseInt("0");
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
    private int find_count_in_credit(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(DOCCODE))as Count from RECOVERY Where CREDITAMOUNT <> "+Integer.parseInt("0");
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
    private int find_count_in_cat_rec(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CCODE))as Count from PCAT";
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
    private int find_count_in_zone_rec(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from ZONE";
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
    private int find_count_in_sub_cat_rec(Connection conn) {
        int count = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from SUBCAT";
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
    private int find_count_in_firmrec_code(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from DSPCLIENT";
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
    private int find_count_in_cust_rec_code(Connection conn) {
        int count = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from CLIENTS";
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
    private int find_count_in_product_rec_code(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from PMAST";
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
    private int find_count_in_emp_rec_code(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from EMPREC";
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
    private int find_count_in_scheme_rec_code(Connection conn,String asset_rec) {
        ResultSet result = null;
        int count = 0;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(TONO))as Count from SCHEMERS";
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
    private int find_count_in_slab_rec_code(Connection conn,String asset_rec) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(SLABNO))as Count from SLAB";
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
    private int find_count_in_schemeprocat_rec_code(Connection conn,String asset_rec) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(TONO))as Count from SCHEMEPROCAT";
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
    private int find_count_in_schprocatpro_rec_code(Connection conn,String asset_rec) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(TONO))as Count from SCHEMERPOCATPRO";
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
    private int find_count_in_schemeqtypro_rec_code(Connection conn,String asset_rec) {
        int count = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(TONO))as Count from SCHQTYPRO";
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
    private int find_count_in_schemeqty_rec_code(Connection conn,String asset_rec) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(TONO))as Count from SCHEMEQTY";
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
    private int find_count_in_st_type_rec_code(Connection conn) {
        int count = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from STOCKTYPE";
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
    private int find_count_in_stloc_code(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from ASSETTYPE";
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
        //System.out.println("Returened Count"+count);
        return count;
    }
    private int find_count_in_custtype_code(Connection conn) {
        int count = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from CUSTTYPE";
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
    private int find_count_in_distrec_code(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from DISTRICT";
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
    private int find_count_in_expence_code(Connection conn) {
        int count = 0;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from EXPENCE";
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
    private int find_count_in_postrec_code(Connection conn) {
        int count = 0;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from POST";
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
    private int find_count_in_routerec_code(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
            ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(DOCNO))as Count from PERMAIN";
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
    private int find_count_in_finrec_code(Connection conn) {
        int count = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from FINANCE";
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
    private int find_count_in_vanrec_code(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from VANREC";
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
    private int find_count_in_suprec(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from SUPP";
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

    public ArrayList<String> find_asset_rec_by_code(Connection conn, String code)throws SQLException{
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_asset_code(conn);
        String Sql = "select * from ASSETREC WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new <String>ArrayList();

        if(result.next()){
            cat.add(0,result.getString("ASSETNAME"));
            cat.add(1,result.getString("ASSETNUMBER"));
            cat.add(2,result.getString("ASSETCOMPANY"));//VALUE,QTY,CLQTY,ASSETCODE
            cat.add(3,result.getString("VALUE"));
            cat.add(4,result.getString("QTY"));
            cat.add(5,result.getString("CLQTY"));
            cat.add(6,result.getString("ASSETCODE"));
        }else{
            cat=null;
        }
        return cat;
    }

    public int find_min_in_com_code(Connection conn) {
        int min = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from COMPANY";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
                min=0;
            }else{
                 min = Integer.parseInt(temp);
            }
           
        }
        catch(SQLException e)
        {
            min = 0;
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return min;
    }
    public int find_min_in_dist_code(Connection conn) {
        int min = 0;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from DISTRICT";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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

    public String find_comp_rec_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from COMPANY WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat = new String();

        if(result.next()){
            String assetName = result.getString("NAME");
            cat=assetName;
        }else{
            cat=null;
        }
        return cat;
    }

    public boolean delete_comp(Connection conn, String code, String name) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM COMPANY WHERE CODE = "+Integer.parseInt(code);
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

    public ArrayList<String> get_last_comp(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_com_code(conn);
        String Sql = "select * from COMPANY WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();

        if(result.next()){
            String code = result.getString("CODE");
            String comp = result.getString("NAME");
            cat.add(code);
            cat.add(comp);
        }else{
            cat.add(null);
        }
        return cat;
    }

    public ArrayList<String> next_comp(Connection conn, String code, String name) {
            ResultSet result = null;
        ArrayList<String> cat = new ArrayList<String>();
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM COMPANY WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String code1 = result.getString("CODE");
                String assetName = result.getString("NAME");
                cat.add(0,code1);
                cat.add(1,assetName);
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

    public ArrayList<String> prior_comp(Connection conn, String code, String name) {
        ArrayList<String> cat = new ArrayList<String>();
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM COMPANY WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String code1 = result.getString("CODE");
                String assetName = result.getString("NAME");
                cat.add(code1);
                cat.add(assetName);
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

    public boolean update_comp(Connection conn, String code, String name) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE COMPANY SET NAME = '"+name+"'WHERE CODE="+code+"";
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

    public String[][] search_com_rec(Connection conn, String searchFieldText) throws SQLException {
        String returned[][] = new String[find_count_in_comp_code(conn)][2];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from COMPANY where UPPER(NAME) like UPPER('" + searchFieldText + "%')";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {
//            if(result.getString("CODE")==null){
           
                returned[i][0]=resultset.getString("CODE");
                returned[i][1]=resultset.getString("NAME");
                //System.out.println("Code: " + result.getString("CODE"));
                //System.out.println("NAME: " + result.getString("NAME"));
                i++;
            /*}else{
                //returned=null;
            }*/
        }
        return returned;
    }

    private int find_count_in_comp_code(Connection conn) {
        int count = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from COMPANY";
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

    public boolean update_cash_dep(Connection conn, String code, String smcode, String amount,String date, String vancode, String fincode, String desc) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE CASHDEPOSIT SET AMOUNT = '"+amount+"', SMCODE = '"+smcode+"', ODATE = DATE('" + date + "' , 'MM/DD/YY'), VANCODE = '"+vancode+"', FINCODE = '"+fincode+"' , DESCR = '"+desc +"' WHERE CODE="+code+"";// VANCODE FINCODE
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

    public ArrayList<String> get_first_dep_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int min=find_min_in_cash_dep(conn);
        ArrayList<String> cat=null;
        if(min!=0){
            String Sql = "select * from CASHDEPOSIT WHERE CODE="+min;
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                String code = result.getString("CODE");
                String smCode = result.getString("SMCODE");
                String date = result.getString("ODATE");
                String amount = result.getString("AMOUNT");
                String amount1 = result.getString("VANCODE");
                String amount2 = result.getString("FINCODE");
                String amount23 = result.getString("DESCR");
                cat.add(code);
                cat.add(smCode);
                cat.add(date);
                cat.add(amount);
                cat.add(amount1);
                cat.add(amount2);
                cat.add(amount23);
            }else{
                cat.add(null);
            }
        }else{
            //JOptionPane.showMessageDialog(null, "No Record Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return cat;
    }

    public ArrayList<String> prior_cash_dep(Connection conn, String code) {
        ArrayList<String> cat = new ArrayList<String>();
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM CASHDEPOSIT WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String code1 = result.getString("CODE");
                String assetName = result.getString("SMCODE");
                String date = result.getString("ODATE");
                String amount = result.getString("AMOUNT");
                String amount1 = result.getString("VANCODE");
                String amount2 = result.getString("FINCODE");
                String amount3 = result.getString("DESCR");
                cat.add(code1);
                cat.add(assetName);
                cat.add(date);
                cat.add(amount);
                cat.add(amount1);
                cat.add(amount2);
                cat.add(amount3);
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

    public ArrayList<String> next_cash_dep(Connection conn, String code) {
        ArrayList<String> cat = new ArrayList<String>();
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM CASHDEPOSIT WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String code1 = result.getString("CODE");
                String assetName = result.getString("SMCODE");
                String date = result.getString("ODATE");
                String amount = result.getString("AMOUNT");
                String amount1 = result.getString("VANCODE");
                String amount2 = result.getString("FINCODE");
                String amount3 = result.getString("DESCR");
                cat.add(0,code1);
                cat.add(1,assetName);
                cat.add(2,date);
                cat.add(3,amount);
                cat.add(4,amount1);
                cat.add(5,amount2);
                cat.add(6,amount3);
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

    public boolean delete_cash_dep(Connection conn, String code) {
         boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM CASHDEPOSIT WHERE CODE = "+code;
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

    public String[] find_cash_dep_by_code(Connection conn, String code) throws SQLException {
         java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_cash_dep(conn);
        String cat[]=new String[7];
        if(max!=0){

            String Sql = "select * from CASHDEPOSIT WHERE CODE="+code;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            if(result.next()){
                cat[1] = result.getString("CODE");
                cat[0] = result.getString("SMCODE");
                cat[2] = result.getString("ODATE");
                cat[3] = result.getString("AMOUNT");
                cat[4] = result.getString("VANCODE");
                cat[5] = result.getString("FINCODE");
                cat[6] = result.getString("DESCR");

            }else{
                cat=null;
            }
        }else{
            cat=null;
        }
        return cat;
    }

    public ArrayList<String> get_last_cash_dep(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_cash_dep(conn);
        String Sql = "select * from CASHDEPOSIT WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();

        if(result.next()){
            String code = result.getString("CODE");
            String smCode = result.getString("SMCODE");
            String date = result.getString("ODATE");
            String amount = result.getString("AMOUNT");
            String amount1 = result.getString("VANCODE");
            String amount2 = result.getString("FINCODE");
            String amount23 = result.getString("DESCR");
            cat.add(code);
            cat.add(smCode);
            cat.add(date);
            cat.add(amount);
            cat.add(amount1);
            cat.add(amount2);
            cat.add(amount23);
        }else{
            cat.add(null);
        }
        return cat;
    }

    public int find_max_in_cash_dep(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from CASHDEPOSIT";
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
        //System.out.println("MAx:"+max);
        return max;
    }

    public int find_min_in_cash_dep(Connection conn) {
        int min = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from CASHDEPOSIT";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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

    public String[][] search_cash_dep(Connection conn, String searchFieldText) throws SQLException {
        String returned[][] = new String[find_count_in_cash_dep(conn)][4];
	java.sql.Statement statement = conn.createStatement();
            ResultSet resultset = null;
        try{
            if(!searchFieldText.equals("")){
            }else{
                String Sql = "Select * from CASHDEPOSIT ";

                resultset = statement.executeQuery(Sql);
                int i=0;
                while(resultset.next())
                {
                    returned[i][0]=resultset.getString("CODE");
                    returned[i][1]=find_sm_name_by_code(conn, resultset.getString("SMCODE"));
                    returned[i][2]=resultset.getString("AMOUNT");
                    try {
                        returned[i][3]=ccc.toDateString(ccc.toDate(resultset.getString("ODATE"))+"");//resultset.getString("DOCDATE");
                    } catch (ParseException ex) {
                        Logger.getLogger(PAK_SELLERLEDGER_DB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (resultset != null) resultset.close();
            }catch(SQLException e){}
        }
        return returned;
    }

    private int find_count_in_cash_dep(Connection conn) {
        int count = 0;
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(SMCODE))as Count from CASHDEPOSIT";
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

    public ArrayList<String> get_last_dist(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        int max=find_max_in_dist_code(conn);
            ArrayList<String> cat = null;
        String Sql = "select * from DISTRICT WHERE CODE="+max;
        try{
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                String code = result.getString("CODE");
                String comp = result.getString("DISTRICT");
                cat.add(code);
                cat.add(comp);
            }else{
                cat.add(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_PAYSELLER_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result!= null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }	

    public boolean delete_dist(Connection conn ,String code, String dist) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM DISTRICT WHERE CODE = "+code;
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

    public boolean update_dist(Connection conn, String code,String dist) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE DISTRICT SET DISTRICT = '"+dist+"'WHERE CODE="+code+"";
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

    public ArrayList<String> prior_dist(Connection conn, String code, String text0) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM DISTRICT WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String code1 = result.getString("CODE");
                String assetName = result.getString("DISTRICT");
                cat.add(code1);
                cat.add(assetName);
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

    public ArrayList<String> next_dist(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM DISTRICT WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String code1 = result.getString("CODE");
                String assetName = result.getString("DISTRICT");
                cat.add(0,code1);
                cat.add(1,assetName);
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

    public String find_dist_rec_by_code(Connection conn, String code) throws SQLException {
         java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from DISTRICT WHERE CODE="+code;
        String cat = null;

        ResultSet result = null;
        try{
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new String();

            if(result.next()){
                String assetName = result.getString("DISTRICT");
                cat=assetName;
            }else{
                cat=null;
            }
        }
        catch(SQLException e)
        {
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public int find_max_in_dist_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from DISTRICT";
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
    public ArrayList<String> get_last_loc(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_loc_code(conn);
        String Sql = "select * from ASSETTYPE WHERE CODE="+max;
        ArrayList<String> cat = null;
        ResultSet result = null;
        try{
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                String code = result.getString("CODE");
                String comp = result.getString("TYPE");
                cat.add(code);
                cat.add(comp);
            }else{
                cat.add(null);
            }
        }catch(SQLException e)
        {
            max = 0;
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }	

    public boolean delete_loc(Connection conn ,String code, String dist) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM ASSETTYPE WHERE CODE = "+code;
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

    public boolean update_asset_type(Connection conn, String code,String loc) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE ASSETTYPE SET TYPE = '"+loc+"'WHERE CODE="+code+"";
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

    public ArrayList<String> prior_loc(Connection conn, String code, String text0) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
        ArrayList<String> cat = new ArrayList<String>();
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM ASSETTYPE WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String code1 = result.getString("CODE");
                String assetName = result.getString("TYPE");
                cat.add(code1);
                cat.add(assetName);
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

    public ArrayList<String> next_loc(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM ASSETTYPE WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String code1 = result.getString("CODE");
                String assetName = result.getString("TYPE");
                cat.add(0,code1);
                cat.add(1,assetName);
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

    public String find_loc_rec_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ASSETTYPE WHERE CODE="+code;
        ResultSet result = null;
        String cat = null;
        try{
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new String();

            if(result.next()){
                String assetName = result.getString("TYPE");
                cat=assetName;
            }else{
                cat=null;
            }
        }catch(SQLException e)
        {
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public int find_max_in_loc_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from ASSETTYPE";
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

    public int find_min_in_loc_code(Connection conn) {
        int min = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from ASSETTYPE";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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
    public ArrayList<String> get_last_cat(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        ResultSet result = null;
        ArrayList<String> cat =null;
        try{
            int max=find_max_in_cat_code(conn);
            String Sql = "select * from PCAT WHERE CCODE="+max;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                String code = result.getString("CCODE");
                String comp = result.getString("PDESC");
                cat.add(code);
                cat.add(comp);
            }else{
                cat.add(null);
            }
        }catch(Exception ex){       
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }	

    public boolean delete_cat(Connection conn ,String code, String dist) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM PCAT WHERE CCODE = "+code;
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

    public boolean update_cat(Connection conn, String code,String loc) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE PCAT SET PDESC = '"+loc+"'WHERE CCODE="+code+"";
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

    public ArrayList<String> prior_cat(Connection conn, String code, String text0) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM PCAT WHERE CCODE <"+Integer.parseInt(code)+" ORDER BY CCODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String code1 = result.getString("CCODE");
                String assetName = result.getString("PDESC");
                cat.add(code1);
                cat.add(assetName);
            }else{
                cat=null;
            }
        }
        catch(SQLException e)
        {
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }

        return cat;
    }

    public ArrayList<String> next_cat(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM PCAT WHERE CCODE > "+Integer.parseInt(code)+" ORDER BY CCODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String code1 = result.getString("CCODE");
                String assetName = result.getString("PDESC");
                cat.add(0,code1);
                cat.add(1,assetName);
            }else{
                //cat.add(null);
                cat=null;
            }
        }
        catch(SQLException e)
        {
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }

        return cat;
    }

    public String find_cat_rec_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from PCAT WHERE CCODE="+code;
        ResultSet result = null;
        String cat = null;
        try{
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new String();

            if(result.next()){
                String assetName = result.getString("PDESC");
                cat=assetName;
            }else{
                cat=null;
            }
        }catch(SQLException e)
        {}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }

    public int find_max_in_cat_code(Connection conn) {
        int max = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CCODE))as ID from PCAT";
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

    public int find_min_in_cat_code(Connection conn) {
        int min = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CCODE))as ID from PCAT";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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
    public ArrayList<String> get_last_route(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_route_code(conn);
        String Sql = "select * from ROUTE WHERE CODE="+max;
        ArrayList<String> cat = null;
        ResultSet result = null;
        try{
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                String code = result.getString("CODE");
                String comp = result.getString("ROUTEDESC");
                cat.add(code);
                cat.add(comp);
            }else{
                cat.add(null);
            }
        }catch(SQLException e){}
        finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }	

    public boolean delete_route(Connection conn ,String code, String dist) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM ROUTE WHERE CODE = "+code;
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
    public boolean delete_purchase(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM PERMAIN WHERE DOCNO = "+code;
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

            Sql = "DELETE FROM PERDTL WHERE DOCNO = '"+docno+"' AND SEQNO = '"+seqno+"'";
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

            Sql = "DELETE FROM PERDTL WHERE DOCNO = '"+docno+"'";
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

    public boolean update_route(Connection conn, String code,String route) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE ROUTE SET ROUTEDESC = '"+route.trim()+"'WHERE CODE="+code+"";
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
    public boolean update_purchase(Connection conn,  String odate,String  docno,String  refno,String  supcode,String  tgrossamt,String  fmrsum,String  splrs,String  otherexp,String  avdiscper,String  tdiscrs,String  avtaxper,String  ttaxrs,String  tnetamount,String  remaning,String  paid,String  remarks,String netpayable,String dealerCode,String splfmr){
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
             Sql="UPDATE PERMAIN SET AVDISCPER= '"+avdiscper+"', REFNO = '"+refno+"', SUPCODE = '"+supcode+
                     "',TGROSSAMT = '"+tgrossamt+"',REMARKS= '"+remarks+"',ODATE= DATE('" + odate +
                     "' , 'MM/DD/YY') ,FMRSUM= '"+fmrsum+"',SPLRS= '"+splrs+"',OTHEREXP = '"+otherexp+
                     "',TDISCRS = '"+tdiscrs+"',AVTAXPER = '"+avtaxper+"',TTAXRS = '"+ttaxrs+"',TNETAMOUNT = '"+
                     tnetamount+"',REMAINING = '"+remaning+"',PAID = '"+paid+"',NETPAYABLE = '"+netpayable+"',SPLFMR= '"+splfmr+
                     "' WHERE DOCNO ="+docno;
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
    
    public boolean update_purchase_products_in_table_new(Connection conn, String   docno, String seqno, String pcode, String perqty, String perrate,
            String grossamount, String discper, String discrs, String taxper, String taxrs,
            String netamount,
            String dmg,
            String free,
            String returnqty,
            String custome,
            String expDate){
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
                String Sql;
                 Sql="UPDATE PERDTL SET SEQNO= '"+seqno+"', PCODE = '"+pcode+"', PERQTY = '"+perqty+
                         "',PERRATE = '"+perrate+"',GROSSAMOUNT= '"+grossamount+"',TDO= '"+discper+"',DISCPER= '"+discrs+"',FMR = '"+taxper+
                         "',TAXPER = '"+taxrs+"',"
                         + "NETAMOUNT = '"+netamount+"',"
                         + "DMG = '"+dmg+"',"
                         + "FREE = '"+free+"',"
                         + "RETURNQTY = '"+returnqty+"',"
                         + "CUSTOM = '"+custome+"',"
                         + "EXPIRYDATE= DATE('" + expDate +"' , 'MM/DD/YY')"
                         + "WHERE DOCNO ="+docno +"AND SEQNO="+seqno;
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

    public ArrayList<String> prior_route(Connection conn, String code) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM ROUTE WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
//            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("ROUTEDESC");
                cat.add(0,a);
                cat.add(1,b);
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
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM PERMAIN WHERE DOCNO <"+Integer.parseInt(code)+" ORDER BY DOCNO DESC ";
            
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

    public ArrayList<String> next_route(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM ROUTE WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
//            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("ROUTEDESC");
                cat.add(0,a);
                cat.add(1,b);
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
    public ArrayList<String> next_purchase(Connection conn, String code){
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM PERMAIN WHERE DOCNO > "+Integer.parseInt(code)+" ORDER BY DOCNO";            
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

    public String find_route_rec_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ROUTE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
//        //System.out.println("Result : " + result);
        String cat = new String();

        if(result.next()){
            String assetName = result.getString("ROUTEDESC");
            cat=assetName;
        }else{
            cat=null;
        }
        return cat;
    }
    public ArrayList<String> find_purchase_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from PERMAIN WHERE DOCNO="+code;

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

    public int find_max_in_route_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from ROUTE";
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
    public int find_max_in_purchase_code(Connection conn) {
        int max = 0;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(DOCNO))as ID from PERMAIN";
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

    public int find_min_in_route_code(Connection conn) {
        int min = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from ROUTE";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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
    
    public ArrayList<String> get_last_zone(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_zone_code(conn);
        String Sql = "select * from ZONE WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
//        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String code = result.getString("CODE");
            String comp = result.getString("ZONE");
            cat.add(code);
            cat.add(comp);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public boolean chech_route(Connection conn, String docno) {
        boolean cat=false;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from CLIENTS WHERE ROUTECODE='"+docno+"'";
            result=statement.executeQuery(Sql);
            if(result.next()){
                return cat=false;
            }else{  
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
    public boolean chech_role(Connection conn, String docno) {
        boolean cat=false;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from USERLOGIN WHERE FULLACC='"+docno+"'";
            result=statement.executeQuery(Sql);
            if(result.next()){
                return cat=false;
            }else{  
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
    public boolean chech_van_in_smain(Connection conn, String docno) {
        boolean cat=false;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from SMAIN WHERE VANREC='"+docno+"'";
            result=statement.executeQuery(Sql);
            if(result.next()){
                return cat=false;
            }else{  
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
    public boolean chech_van_in_issmain(Connection conn, String docno) {
        boolean cat=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from ISMAIN WHERE VANCODE='"+docno+"'";
            result=statement.executeQuery(Sql);
            if(result.next()){
                return cat=false;
            }else{  
                return cat=true;
            }
        }catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
    public boolean chech_cashtype_in_recovery(Connection conn, String docno) {
        boolean cat=false;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from RECOVERY WHERE CASHTPCD='"+docno+"'";
            result=statement.executeQuery(Sql);
            if(result.next()){
                return cat=false;
            }else{  
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
    public boolean chech_zone(Connection conn, String docno) {
        boolean cat=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from CLIENTS WHERE ZONECODE='"+docno+"'";
            result=statement.executeQuery(Sql);
            if(result.next()){
                return cat=false;
            }else{
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
    public boolean delete_zone(Connection conn ,String code, String dist) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM ZONE WHERE CODE = "+code;
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

    public boolean update_zone(Connection conn, String code,String route) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE ZONE SET ZONE = '"+route+"'WHERE CODE="+code+"";
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

    public ArrayList<String> prior_zone(Connection conn, String code, String text0) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM ZONE WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
//            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("ZONE");
                cat.add(a);
                cat.add(b);
            }else{
                cat=null;
            }
        }
        catch(SQLException e)
        {
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }

        return cat;
    }

    public ArrayList<String> next_zone(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM ZONE WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
//            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("ZONE");
                cat.add(0,a);
                cat.add(1,b);
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

    public String find_zone_rec_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ZONE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
//        //System.out.println("Result : " + result);
        String cat = new String();

        if(result.next()){
            String assetName = result.getString("ZONE");
            cat=assetName;
        }else{
            cat=null;
        }
        return cat;
    }

    public int find_max_in_zone_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from ZONE";
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

    public int find_min_in_zone_code(Connection conn) {
        int min = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from ZONE";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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
    

    public String[] find_supp_rec_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from SUPP WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
//        //System.out.println("Result : " + result);
        String cat[] = new String[6];

        if(result.next()){
             cat[0]= result.getString("NAME");
             cat[1]= result.getString("ADD1");
             cat[2]= result.getString("CNIC");
             cat[3]= result.getString("CONTACT");
             cat[4]= result.getString("REFRANCE");
             cat[5]= result.getString("FNAME");
            
        }else{
            cat=null;
        }
        return cat;
    }

    public int find_max_in_supp_rec_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from SUPP";
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

    public ArrayList<String> get_last_cust_type(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_cust_type_code(conn);
        String Sql = "select * from CUSTTYPE WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
//        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String code = result.getString("CODE");
            String comp = result.getString("TYPE");
            cat.add(code);
            cat.add(comp);
        }else{
            cat.add(null);
        }
        return cat;
    }	
    public ArrayList<String> get_last_cash_type(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_cash_type_code(conn);
        String Sql = "select * from CASHTYPE WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
//        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String code = result.getString("CODE");
            String comp = result.getString("NAME");
            cat.add(code);
            cat.add(comp);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public boolean delete_cust_type(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM CUSTTYPE WHERE CODE = "+code;
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
    public boolean delete_cash_type(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM CASHTYPE WHERE CODE = "+code;
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

    public boolean update_cash_type(Connection conn, String code,String route) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE CASHTYPE SET NAME = '"+route+"'WHERE CODE="+code+"";
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
    public boolean update_cust_type(Connection conn, String code,String route) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE CUSTTYPE SET TYPE = '"+route+"'WHERE CODE="+code+"";
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

    public ArrayList<String> prior_cust_type(Connection conn, String code, String text0) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM CUSTTYPE WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("TYPE");
                cat.add(a);
                cat.add(b);
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
    public ArrayList<String> prior_cash_type(Connection conn, String code, String text0) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM CASHTYPE WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("NAME");
                cat.add(a);
                cat.add(b);
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

    public ArrayList<String> next_cust_type(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM CUSTTYPE WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("TYPE");
                cat.add(0,a);
                cat.add(1,b);
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
    public ArrayList<String> next_cash_type(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM CASHTYPE WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("NAME");
                cat.add(0,a);
                cat.add(1,b);
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

    public String find_cust_type_rec_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CUSTTYPE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat = new String();

        if(result.next()){
            String assetName = result.getString("TYPE");
            cat=assetName;
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_cash_type_name_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CASHTYPE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat = new String();

        if(result.next()){
            String assetName = result.getString("NAME");
            cat=assetName;
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_ast_name_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ASSETTYPE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat = new String();

        if(result.next()){
            String assetName = result.getString("TYPE");
            cat=assetName;
        }else{
            cat=null;
        }
        return cat;
    }

    public int find_max_in_cust_type_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from CUSTTYPE";
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
    public int find_max_in_cash_type_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from CASHTYPE";
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

    public int find_min_in_cust_type_code(Connection conn) {
        int min = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from CUSTTYPE";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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
    
    public ArrayList<String> get_last_st_type(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_st_type_code(conn);
        String Sql = "select * from STOCKTYPE WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String code = result.getString("CODE");
            String comp = result.getString("NAME");
            cat.add(code);
            cat.add(comp);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public boolean delete_st_type(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM STOCKTYPE WHERE CODE = "+code;
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

    public boolean update_st_type(Connection conn, String code,String route) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE STOCKTYPE SET NAME = '"+route+"'WHERE CODE="+code+"";
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

    public ArrayList<String> prior_st_type(Connection conn, String code, String text0) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM STOCKTYPE WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("NAME");
                cat.add(a);
                cat.add(b);
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
            }catch(SQLException e){}
        }

        return cat;
    }

    public ArrayList<String> next_st_type(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM STOCKTYPE WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("NAME");
                cat.add(0,a);
                cat.add(1,b);
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

    public String find_st_type_rec_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from STOCKTYPE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat = new String();

        if(result.next()){
            String assetName = result.getString("NAME");
            cat=assetName;
        }else{
            cat=null;
        }
        return cat;
    }

    public int find_max_in_st_type_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from STOCKTYPE";
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

    public int find_min_in_st_type_code(Connection conn) {
        int min = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from STOCKTYPE";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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
        
    public ArrayList<String> get_last_subCat(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_subCat_code(conn);
        String Sql = "select * from SUBCAT WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String code = result.getString("CODE");
            String comp = result.getString("SUBCAT");
            cat.add(code);
            cat.add(comp);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public boolean delete_subCat(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM SUBCAT WHERE CODE = "+code;
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

    public boolean update_subCat(Connection conn, String code,String route) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE SUBCAT SET SUBCAT = '"+route+"'WHERE CODE="+code+"";
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

    public ArrayList<String> prior_subCat(Connection conn, String code, String text0) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM SUBCAT WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("SUBCAT");
                cat.add(a);
                cat.add(b);
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

    public ArrayList<String> next_subCat(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM SUBCAT WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("SUBCAT");
                cat.add(0,a);
                cat.add(1,b);
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

    public String find_subCat_rec_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from SUBCAT WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat = new String();

        if(result.next()){
            String assetName = result.getString("SUBCAT");
            cat=assetName;
        }else{
            cat=null;
        }
        return cat;
    }

    public int find_max_in_subCat_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from SUBCAT";
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

    public int find_min_in_subCat_code(Connection conn) {
        int min = 0;
        ResultSet result = null;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from SUBCAT";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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
    public ArrayList<String> get_first_subCat(Connection conn) throws SQLException{
       java.sql.Statement statement = conn.createStatement();
        
        ArrayList<String> cat;
        int min=0;
        min=find_min_in_subCat_code(conn);
        if(min!=0){
            String Sql = "select * from SUBCAT WHERE CODE="+min;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
           cat = new ArrayList<String>();

            if(result.next()){
                String code = result.getString("CODE");
                String assetName = result.getString("SUBCAT");
                cat.add(code);
                cat.add(assetName);
            }else{
                cat.add(null);
            }
        }else{
            cat=null;
        }
        return cat;
    }
    public ArrayList<String> get_last_exp(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_exp_code(conn);
        String Sql = "select * from EXPENCE WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String code = result.getString("CODE");
            String comp = result.getString("EXPENCE");
            cat.add(code);
            cat.add(comp);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public boolean delete_exp(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM EXPENCE WHERE CODE = "+code;
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

    public boolean update_exp(Connection conn, String code,String route) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE EXPENCE SET EXPENCE = '"+route+"'WHERE CODE="+code+"";
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

    public ArrayList<String> prior_exp(Connection conn, String code, String text0) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM EXPENCE WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("EXPENCE");
                cat.add(a);
                cat.add(b);
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

    public ArrayList<String> next_exp(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM EXPENCE WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("EXPENCE");
                cat.add(0,a);
                cat.add(1,b);
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

    public String find_exp_rec_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from EXPENCE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat = new String();

        if(result.next()){
            String assetName = result.getString("EXPENCE");
            cat=assetName;
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_name_rec_by_id(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from USERLOGIN WHERE USERID="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat = new String();

        if(result.next()){
            String assetName = result.getString("USERNAME");
            cat=assetName;
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_name_role_rec_by_id(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from USERLOGIN WHERE USERID="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat = new String();

        if(result.next()){
            String assetName = result.getString("USERNAME");
            String role = result.getString("FULLACC");
            if(role.equals("1")||role.equals("2")||role.equals("3")){cat=assetName;}else{cat=null;}
        }else{
            cat=null;
        }
        return cat;
    }

    public int find_max_in_exp_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from EXPENCE";
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

    public int find_min_in_exp_code(Connection conn) {
        int min = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from EXPENCE";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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
    public ArrayList<String> get_first_exp(Connection conn) throws SQLException{
       java.sql.Statement statement = conn.createStatement();
        
        ArrayList<String> cat;
        int min=0;
        min=find_min_in_exp_code(conn);
        if(min!=0){
            String Sql = "select * from EXPENCE WHERE CODE="+min;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
           cat = new ArrayList<String>();

            if(result.next()){
                String code = result.getString("CODE");
                String assetName = result.getString("EXPENCE");
                cat.add(code);
                cat.add(assetName);
            }else{
                cat.add(null);
            }
        }else{
            cat=null;
        }
        return cat;
    }
    
    public int find_min_in_supp_rec_code(Connection conn) {
        int min = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from SUPP";
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
    public ArrayList<String> get_first_sup_rec(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int min=find_min_in_supp_rec_code(conn);
        ArrayList<String> cat ;
        if(min!=0){
            String Sql = "select * from SUPP WHERE CODE="+min;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            cat = new ArrayList<String>();

            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("NAME");
                String c = result.getString("ADD1");
                String d = result.getString("CNIC");
                String e = result.getString("CONTACT");
                String f = result.getString("REFRANCE");
                String g = result.getString("FNAME");
                cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
                cat.add(4,e);
                cat.add(5,f);
                cat.add(6,g);
            }else{
                cat.add(null);
            }
        }else{
            cat=null;
        }
        return cat;
    }
    public ArrayList<String> get_last_supp_rec(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_supp_rec_code(conn);
        String Sql = "select * from SUPP WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String a = result.getString("CODE");
            String b = result.getString("NAME");
            String c = result.getString("ADD1");
            String d = result.getString("CNIC");
            String e = result.getString("CONTACT");
            String f = result.getString("REFRANCE");
            String g = result.getString("FNAME");
            cat.add(0,a);
            cat.add(1,b);
            cat.add(2,c);
            cat.add(3,d);
            cat.add(4,e);
            cat.add(5,f);
            cat.add(6,g);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public boolean delete_supp_rec(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM SUPP WHERE CODE = "+code;
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

    public boolean update_supp_rec(Connection conn, String code,String name,String add1,String add2,String contact,String dist, String fname) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE SUPP SET NAME = '"+name+"',ADD1 = '"+add1+"',CNIC = '"+add2+"',CONTACT = '"+contact+"',REFRANCE = '"+dist+"',FNAME = '"+fname+"' WHERE TO_NUMBER(CODE)="+Integer.parseInt(code);
            statement.executeUpdate(Sql);
            var = true;
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

    public ArrayList<String> prior_supp_rec(Connection conn, String code) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM SUPP WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("NAME");
                String c = result.getString("ADD1");
                String d = result.getString("CNIC");
                String e = result.getString("CONTACT");
                String f = result.getString("REFRANCE");
                String g = result.getString("FNAME");
                cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
                cat.add(4,e);
                cat.add(5,f);
                cat.add(6,g);
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

    public ArrayList<String> next_supp_rec(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM SUPP WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("NAME");
                String c = result.getString("ADD1");
                String d = result.getString("CNIC");
                String e = result.getString("CONTACT");
                String f = result.getString("REFRANCE");
                String g = result.getString("FNAME");
                cat.add(0,a);                //cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
                cat.add(4,e);
                cat.add(5,f);
                cat.add(6,g);
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
    public int find_min_in_dsp_client_code(Connection conn) {
        int min = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from DSPCLIENT";
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
//    public ArrayList<String> get_first_sup_rec(Connection conn) throws SQLException {
//        java.sql.Statement statement = conn.createStatement();
//        int min=find_min_in_dsp_client_code(conn);
//        ArrayList<String> cat ;
//        if(min!=0){
//            String Sql = "select * from DSPCLIENT WHERE CODE="+min;
//
//            ResultSet result = null;
//            result=statement.executeQuery(Sql);
//            //System.out.println("Result : " + result);
//            cat = new ArrayList<String>();
//
//            if(result.next()){
//                String a = result.getString("CODE");
//                String b = result.getString("NAME");
//                String c = result.getString("ADD1");
//                String d = result.getString("ADD2");
//                String e = result.getString("CONTACT");
//                String f = result.getString("NTN");
//                cat.add(0,a);
//                cat.add(1,b);
//                cat.add(2,c);
//                cat.add(3,d);
//                cat.add(4,e);
//                cat.add(5,f);
//            }else{
//                cat.add(null);
//            }
//        }else{
//            cat=null;
//        }
//        return cat;
//    }
    public ArrayList<String> get_last_dsp_client(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_dsp_client_code(conn);
        String Sql = "select * from DSPCLIENT WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String a = result.getString("CODE");
            String b = result.getString("NAME");
            String c = result.getString("ADD1");
            String d = result.getString("ADD2");
            String e = result.getString("CONTACT");
            String f = result.getString("NTN");
            cat.add(0,a);
            cat.add(1,b);
            cat.add(2,c);
            cat.add(3,d);
            cat.add(4,e);
            cat.add(5,f);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public boolean delete_dsp_client(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM DSPCLIENT WHERE CODE = "+code;
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

    public boolean update_van_rec(Connection conn, String code,String van,String num,String capacity) {
    boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

                Sql="UPDATE VANREC SET VANNAME = '"+van+"',VANNUMBER = '"+num+"', CAPACITY = '"+Float.parseFloat(capacity)+"'WHERE TO_NUMBER(CODE)="+Integer.parseInt(code);
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
    public boolean update_dsp_client(Connection conn, String code,String name,String contact,String add1,String add2,String ntn) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE DSPCLIENT SET NAME = '"+name+"',ADD1 = '"+add1+"',ADD2 = '"+add2+"',CONTACT = '"+contact+"',NTN = '"+ntn+"' WHERE TO_NUMBER(CODE)="+Integer.parseInt(code);
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

    public ArrayList<String> prior_dsp_client(Connection conn, String code) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM DSPCLIENT WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("NAME");
                String c = result.getString("ADD1");
                String d = result.getString("ADD2");
                String e = result.getString("CONTACT");
                String f = result.getString("NTN");
                cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
                cat.add(4,e);
                cat.add(5,f);
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

    public ArrayList<String> next_dsp_client(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM DSPCLIENT WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("NAME");
                String c = result.getString("ADD1");
                String d = result.getString("ADD2");
                String e = result.getString("CONTACT");
                String f = result.getString("NTN");
                cat.add(0,a);                //cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
                cat.add(4,e);
                cat.add(5,f);
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

    public int find_max_in_dsp_client_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from DSPCLIENT";
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

    public String[] find_dsp_client_rec_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from DSPCLIENT WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String[] cat = new String[5];

        if(result.next()){
            cat[0] = result.getString("NAME");
            cat[1] = result.getString("ADD1");
            cat[2] = result.getString("ADD2");
            cat[3] = result.getString("CONTACT");
            cat[4] = result.getString("NTN");
        }else{
            cat=null;
        }
        return cat;
    }
    public ArrayList<String> get_last_post(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_post_code(conn);
        String Sql = "select * from POST WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String code = result.getString("CODE");
            String comp = result.getString("POST");
            cat.add(code);
            cat.add(comp);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public boolean delete_post(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM POST WHERE CODE = "+code;
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

    public boolean update_post(Connection conn, String code,String route) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE POST SET POST = '"+route+"'WHERE CODE="+code+"";
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

    public ArrayList<String> prior_post(Connection conn, String code, String text0) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM POST WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("POST");
                cat.add(a);
                cat.add(b);
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
            }catch(SQLException e){}
        }

        return cat;
    }

    public ArrayList<String> next_post(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM POST WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("POST");
                cat.add(0,a);
                cat.add(1,b);
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

    public String find_post_rec_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from POST WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat = new String();

        if(result.next()){
            String assetName = result.getString("POST");
            cat=assetName;
        }else{
            cat=null;
        }
        return cat;
    }

    public int find_max_in_post_code(Connection conn) {
        int max = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from POST";
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

    public int find_min_in_post_code(Connection conn) {
        int min = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from POST";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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
    public ArrayList<String> get_first_post(Connection conn) throws SQLException{
       java.sql.Statement statement = conn.createStatement();
        
        ArrayList<String> cat;
        int min=0;
        min=find_min_in_post_code(conn);
        if(min!=0){
            String Sql = "select * from POST WHERE CODE="+min;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
           cat = new ArrayList<String>();

            if(result.next()){
                String code = result.getString("CODE");
                String assetName = result.getString("POST");
                cat.add(code);
                cat.add(assetName);
            }else{
                cat.add(null);
            }
        }else{
            cat=null;
        }
        return cat;
    }

    public boolean insert_post_rec_in_table(Connection conn, String Code, String post) {
        
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO POST(CODE,POST) VALUES ("+ Integer.parseInt(Code)+ ",'" + post+"')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            //System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }
    
    public int find_min_in_van_rec_code(Connection conn) {
        int min = 0;
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from VANREC";
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
    public ArrayList<String> get_last_van_rec(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_van_rec_code(conn);
        String Sql = "select * from VANREC WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String a = result.getString("CODE");
            String b = result.getString("VANNAME");
            String c = result.getString("VANNUMBER");
            String d = result.getString("CAPACITY");
            cat.add(0,a);
            cat.add(1,b);
            cat.add(2,c);
            cat.add(3,d);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public boolean delete_van_rec(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean van = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM VANREC WHERE CODE = "+code;
            statement.executeUpdate(Sql);
            van = true;
        }
        catch(SQLException e)
        {
                van = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return van;
    }

    public ArrayList<String> prior_van_rec(Connection conn, String code) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM VANREC WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("VANNAME");
                String c = result.getString("VANNUMBER");
                String d = result.getString("CAPACITY");
                cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
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

    public ArrayList<String> next_van_rec(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM VANREC WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("VANNAME");
                String c = result.getString("VANNUMBER");
                String d = result.getString("CAPACITY");
                cat.add(0,a);                //cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
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

    public int find_max_in_van_rec_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from VANREC";
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

    public String[] find_van_rec_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from VANREC WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String[] cat = new String[3];

        if(result.next()){
            cat[0] = result.getString("VANNAME");
            cat[1] = result.getString("VANNUMBER");
            cat[2] = result.getString("CAPACITY");
        }else{
            cat=null;
        }
        return cat;
    }
    
    public int find_min_in_fin_rec_code(Connection conn) {
        int min = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from FINANCE";
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
    public ArrayList<String> get_last_fin_rec(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_fin_rec_code(conn);
        String Sql = "select * from FINANCE WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String a = result.getString("CODE");
            String b = result.getString("FINNAME");
            String c = result.getString("OTHERDESC");
            cat.add(0,a);
            cat.add(1,b);
            cat.add(2,c);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public boolean delete_fin_rec(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean van = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM FINANCE WHERE CODE = "+code;
            statement.executeUpdate(Sql);
            van = true;
        }
        catch(SQLException e)
        {
                van = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return van;
    }

    public ArrayList<String> prior_fin_rec(Connection conn, String code) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM FINANCE WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("FINNAME");
                String c = result.getString("OTHERDESC");
                cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
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

    public ArrayList<String> next_fin_rec(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM FINANCE WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("FINNAME");
                String c = result.getString("OTHERDESC");
                cat.add(0,a);                //cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
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

    public int find_max_in_fin_rec_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from FINANCE";
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

    public String[] find_fin_rec_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from FINANCE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String[] cat = new String[5];

        if(result.next()){
            cat[0] = result.getString("FINNAME");
            cat[1] = result.getString("OTHERDESC");
        }else{
            cat=null;
        }
        return cat;
    }

    public boolean update_fin_rec(Connection conn, String code, String finance, String desc) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE FINANCE SET FINNAME = '"+finance+"', OTHERDESC = '"+desc+"'WHERE CODE="+code;
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
    
    public int find_min_in_recovery_credit_rec_code(Connection conn,boolean isCredit) {
        int min = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            if(isCredit){
                Sql = "Select MIN(TO_NUMBER(DOCCODE))as ID from (select * from RECOVERY WHERE CREDITAMOUNT > "+Integer.parseInt("0")+")";
            }else{
                Sql = "Select MIN(TO_NUMBER(DOCCODE))as ID from (select * from RECOVERY WHERE AMOUNT > "+Integer.parseInt("0")+")";
            }
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
            }catch(SQLException e){}
        }
        return min;
    }
    public int find_min_in_purchase_code(Connection conn) {
        int min = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
                Sql = "Select MIN(TO_NUMBER(DOCNO))as ID from PERMAIN ";
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
    public ArrayList<String> get_last_recovery_credit_rec(Connection conn,boolean isCredit) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_recovery_credit_rec_code(conn,isCredit);
        String Sql = "select * from RECOVERY WHERE DOCCODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String a = result.getString("DOCCODE");
            String b = result.getString("CUSTCODE");
            String c = result.getString("SM1CODE");
            String d = result.getString("SM2CODE");
            String e = result.getString("CASHTPCD");
            String f = result.getString("REMARKS");
            String g = result.getString("RDATE");
            String h = result.getString("AMOUNT");
            String i = result.getString("FREIGHT");
            String j = result.getString("CREDITAMOUNT");
            String j1 = result.getString("COMPCODE");
            cat.add(0,a);
            cat.add(1,b);
            cat.add(2,c);
            cat.add(3,d);
            cat.add(4,e);
            cat.add(5,f);
            cat.add(6,g);
            cat.add(7,h);
            cat.add(8,i);
            cat.add(9,j);
            cat.add(10,j1);
        }else{
            cat=null;
        }
        return cat;
    }	
    public ArrayList<String> get_last_purchase(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_purchase_code(conn);
        String Sql = "select * from PERMAIN WHERE DOCNO="+max;

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

    public boolean delete_recovery_credit_rec(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean van = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM RECOVERY WHERE DOCCODE = "+code;
            statement.executeUpdate(Sql);
            van = true;
        }
        catch(SQLException e)
        {
                van = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return van;
    }

    public ArrayList<String> prior_recovery_credit_rec(Connection conn, String code,boolean isCredit) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            if(isCredit){
                Sql="SELECT * FROM RECOVERY WHERE DOCCODE <"+Integer.parseInt(code)+"AND CREDITAMOUNT>"+Integer.parseInt("0")+" ORDER BY DOCCODE DESC ";
            }else{
                Sql="SELECT * FROM RECOVERY WHERE DOCCODE <"+Integer.parseInt(code)+"AND AMOUNT>"+Integer.parseInt("0")+" ORDER BY DOCCODE DESC ";
            }
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("DOCCODE");
                String b = result.getString("CUSTCODE");
                String c = result.getString("SM1CODE");
                String d = result.getString("SM2CODE");
                String e = result.getString("CASHTPCD");
                String f = result.getString("REMARKS");
                String g = result.getString("RDATE");
                String h = result.getString("AMOUNT");
                String i = result.getString("FREIGHT");
                String j = result.getString("CREDITAMOUNT");
                String j1 = result.getString("COMPCODE");
                cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
                cat.add(4,e);
                cat.add(5,f);
                cat.add(6,g);
                cat.add(7,h);
                cat.add(8,i);
                cat.add(9,j);
                cat.add(10,j1);
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

    public ArrayList<String> next_recovery_credit_rec(Connection conn, String code,boolean isCredit) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            if(isCredit){
                Sql="SELECT * FROM RECOVERY WHERE DOCCODE > "+Integer.parseInt(code)+"AND CREDITAMOUNT>"+Integer.parseInt("0")+" ORDER BY DOCCODE ";            
            }else{
                Sql="SELECT * FROM RECOVERY WHERE DOCCODE > "+Integer.parseInt(code)+"AND AMOUNT>"+Integer.parseInt("0")+" ORDER BY DOCCODE ";            
            }
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("DOCCODE");
                String b = result.getString("CUSTCODE");
                String c = result.getString("SM1CODE");
                String d = result.getString("SM2CODE");
                String e = result.getString("CASHTPCD");
                String f = result.getString("REMARKS");
                String g = result.getString("RDATE");
                String h = result.getString("AMOUNT");
                String i = result.getString("FREIGHT");
                String j = result.getString("CREDITAMOUNT");
                String j1 = result.getString("COMPCODE");
                cat.add(0,a);               
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
                cat.add(4,e);
                cat.add(5,f);                
                cat.add(6,g);
                cat.add(7,h);
                cat.add(8,i);
                cat.add(9,j);
                cat.add(10,j1);
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

    public int find_max_in_recovery_credit_rec_code(Connection conn,boolean isCredit) {
        int max = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            if(isCredit){
                Sql = "Select MAX(TO_NUMBER(DOCCODE))as ID from (select * from RECOVERY WHERE CREDITAMOUNT > "+Integer.parseInt("0")+")";
            }else{
                Sql = "Select MAX(TO_NUMBER(DOCCODE))as ID from (select * from RECOVERY WHERE AMOUNT > "+Integer.parseInt("0")+")";
            }
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
    public int find_max_all_in_recovery_credit_rec_code(Connection conn,boolean isCredit) {
        int max = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            Sql = "Select MAX(TO_NUMBER(DOCCODE))as ID from RECOVERY";
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

    public ArrayList<String> find_recovery_credit_rec_by_code(Connection conn, String code,boolean isCredit) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
         String Sql;
        if(isCredit){
            Sql = "select * from (select * from RECOVERY WHERE CREDITAMOUNT > "+Integer.parseInt("0")+") WHERE DOCCODE="+code;
        }else{
            Sql = "select * from (select * from RECOVERY WHERE AMOUNT > "+Integer.parseInt("0")+") WHERE DOCCODE="+code;
        }
        
        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();

        if(result.next()){
            String a = result.getString("DOCCODE");
                String b = result.getString("CUSTCODE");
                String c = result.getString("SM1CODE");
                String d = result.getString("SM2CODE");
                String e = result.getString("CASHTPCD");
                String f = result.getString("REMARKS");
                String g = result.getString("RDATE");
                String h = result.getString("AMOUNT");
                String i = result.getString("FREIGHT");
                String j = result.getString("CREDITAMOUNT");
                String j1 = result.getString("COMPCODE");
                cat.add(0,a);               
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
                cat.add(4,e);
                cat.add(5,f);                
                cat.add(6,g);
                cat.add(7,h);
                cat.add(8,i);
                cat.add(9,j);
                cat.add(10,j1);
        }else{
            cat=null;
        }
        return cat;
    }

    public boolean update_recovery_credit_rec(Connection conn, String code, String cust, String sm1, String sm2,String cash, String remarks, String date, String amount,String fright,String creditAmount,String comp) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE RECOVERY SET CUSTCODE = '"+cust+"', SM1CODE = '"+sm1+"', SM2CODE = '"+sm2+"',CASHTPCD = '"+cash+"',COMPCODE = '"+comp+"',REMARKS= '"+remarks+"',RDATE= DATE('" + date + "' , 'MM/DD/YY') ,AMOUNT= '"+amount+"',FREIGHT= '"+fright+"',CREDITAMOUNT = '"+creditAmount+"' WHERE DOCCODE="+code;
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
    public int find_min_in_cust_rec_code(Connection conn) {
        int min = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from CLIENTS";
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
   
    public ArrayList<String> get_last_cust_rec(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_cust_rec_code(conn);
        String Sql = "select * from CLIENTS WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            cat = setCustRec(result);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public boolean delete_cust_rec(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean van = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM CLIENTS WHERE CODE = "+code;
            statement.executeUpdate(Sql);
            van = true;
        }
        catch(SQLException e)
        {
                van = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return van;
    }

    public ArrayList<String> prior_cust_rec(Connection conn, String code) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM CLIENTS WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                cat = setCustRec(result);
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

    public ArrayList<String> next_cust_rec(Connection conn, String code) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM CLIENTS WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
               cat = setCustRec(result);
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

    public int find_max_in_cust_rec_code(Connection conn) {
        int max = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from CLIENTS";
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

    public ArrayList<String> find_cust_rec_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CLIENTS WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new <String>ArrayList();

        if(result.next()){
            cat = setCustRec(result);
        }else{
            cat=null;
        }
        return cat;
    }

    public boolean update_cust_rec(Connection conn, String Code, String name, String add1, String add2, String contact, String preBal, String custType, String relation, String ref, String ref1, String ref2,String ccp,String zone,String route,String odate) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            //Sql="UPDATE CLIENTS SET NAME = '"+cust+"', ADD1 = '"+sm1+"', ADD2 = '"+sm2+"',CONTACT = '"+cash+"',PREVIOUSBAL= '"+remarks+"',CREDITLIM= '"+date+"',CUSTTYPE= '"+amount+"',DISTCODE= '"+fright+"',ROUTECODE = '"+creditAmount+"' WHERE CODE="+code;
            //name +  "','" + add1 +  "','" + add2 +  "','" +contact +  "','" + Integer.parseInt(preBal) +  "','" + Integer.parseInt(CreditLim) +  "','" + custType +  "','" + Integer.parseInt(distCode) +  "','" + Integer.parseInt(routeCode) +  "','" + Integer.parseInt(zoneCode) + "','" + comp + "','" +  + "','" + expDate + "')";
            Sql="UPDATE CLIENTS SET NAME = '"+name+"', ADD1 = '"+add1+"', CNIC = '"+add2+"',CONTACT = '"+contact+"',PREVIOUSBAL= "+
                    Integer.parseInt(preBal)+",AREACODE= '"+custType+"',REMARKS = '"+relation+"',REFFERENCE = '"+ref+"',CLBAL = '"+ref1+"',ACTYPE = '"+ref2+"',CUSTTYPE = '"+ccp+"' ,ZONECODE = '"+zone+"',ROUTECODE = '"+route+"',DATEOFJOINING= DATE('" + odate +"' , 'MM/DD/YY')  WHERE CODE="+Code;
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
            System.out.println(""+e);
                var = false;
        }finally{
            try{
		if (statement != null) statement.close();
	    }catch(SQLException e){}
        }

        return var;
    }
    public ArrayList<String> get_last_exp_dep(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_exp_dep_code(conn);
        String Sql = "select * from EXPENCEDEP WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String a = result.getString("CODE");
            String b = result.getString("EXPCODE");
            String c = result.getString("SMCODE");
            String d = result.getString("ODATE");
            String e = result.getString("AMOUNT");
            String f = result.getString("VANCODE");
            String g = result.getString("FINCODE");
            cat.add(0,a);
            cat.add(1,b);
            cat.add(2,c);
            cat.add(3,d);
            cat.add(4,e);
            cat.add(5,f);
            cat.add(6,g);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public boolean delete_exp_dep(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM EXPENCEDEP WHERE CODE = "+code;
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

    public boolean update_exp_dep(Connection conn, String Code, String exp, String sm, String date, String amount, String van, String fin) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            Sql="UPDATE EXPENCEDEP SET EXPCODE = '"+exp+"',SMCODE = '"+sm+"',ODATE = DATE('"+date+"' , 'MM/DD/YY') ,AMOUNT = '"+amount+"',VANCODE = '"+van+"',FINCODE = '"+fin+"' WHERE CODE="+Code;
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

    public ArrayList<String> prior_exp_dep(Connection conn, String code) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM EXPENCEDEP WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("EXPCODE");
                String c = result.getString("SMCODE");
                String d = result.getString("ODATE");
                String e = result.getString("AMOUNT");
            String f = result.getString("VANCODE");
            String g = result.getString("FINCODE");
                cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
                cat.add(4,e);
                cat.add(5,f);
                cat.add(6,g);
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

    public ArrayList<String> next_exp_dep(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM EXPENCEDEP WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
               String a = result.getString("CODE");
                String b = result.getString("EXPCODE");
                String c = result.getString("SMCODE");
                String d = result.getString("ODATE");
                String e = result.getString("AMOUNT");
            String f = result.getString("VANCODE");
            String g = result.getString("FINCODE");
                cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
                cat.add(4,e);
                cat.add(5,f);
                cat.add(6,g);
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

    public  ArrayList<String> find_exp_dep_rec_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from EXPENCEDEP WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String a = result.getString("EXPCODE");
            String b = result.getString("SMCODE");
            String c = result.getString("ODATE");
            String d = result.getString("AMOUNT");
            String e = result.getString("VANCODE");
            String f = result.getString("FINCODE");
            cat.add(0,a);
            cat.add(1,b);
            cat.add(2,c);
            cat.add(3,d);
            cat.add(4,e);
            cat.add(5,f);
        }else{
            cat=null;
        }
        return cat;
    }

    public int find_max_in_exp_dep_code(Connection conn) {
        int max = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from EXPENCEDEP";
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

    public int find_min_in_exp_dep_code(Connection conn) {
        int min = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from EXPENCEDEP";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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
    public ArrayList<String> get_first_exp_dep(Connection conn) throws SQLException{
       java.sql.Statement statement = conn.createStatement();
        
        ArrayList<String> cat;
        int min=0;
        min=find_min_in_exp_dep_code(conn);
        if(min!=0){
            String Sql = "select * from EXPENCEDEP WHERE CODE="+min;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
           cat = new ArrayList<String>();

            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("EXPCODE");
                String c = result.getString("SMCODE");
                String d = result.getString("ODATE");
                String e = result.getString("AMOUNT");
            String f = result.getString("VANCODE");
            String g = result.getString("FINCODE");
                cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
                cat.add(4,e);
                cat.add(5,f);
                cat.add(6,g);
            }else{
                cat.add(null);
            }
        }else{
            cat=null;
        }
        return cat;
    }
    
    public int find_min_in_product_rec_code(Connection conn) {
        int min = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from PMAST";
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
    public ArrayList<String> get_last_product_rec(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_product_rec_code(conn);
        String Sql = "select * from PMAST WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            cat = getRecords(result);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public boolean delete_product_rec(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean van = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM PMAST WHERE CODE = "+code;
            statement.executeUpdate(Sql);
            van = true;
        }
        catch(SQLException e)
        {
                van = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return van;
    }

    public ArrayList<String> prior_product_rec(Connection conn, String code) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM PMAST WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                cat=getRecords(result);
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

    public ArrayList<String> next_product_rec(Connection conn, String code) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM PMAST WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                cat = getRecords(result);
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

    public int find_max_in_product_rec_code(Connection conn) {
        int max = 0;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from PMAST";
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

    public ArrayList<String> find_product_rec_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from PMAST WHERE CODE='"+code+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String>  cat= new <String>ArrayList();

        if(result.next()){
                cat = getRecords(result);
        }else{
            cat=null;
        }
        return cat;
    }
    public ArrayList<String> find_product_rec_by_bar_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from PMAST WHERE BARCODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String>  cat= new <String>ArrayList();

        if(result.next()){
                cat = getRecords(result);
        }else{
            cat=null;
        }
        return cat;
    }

    public boolean update_product_rec(Connection conn, String code, String name, String size, String sailprice, String costprice, String cat, String socity,String sttypecode,String clqty,String clvalue,String linecode,String remarks, String dangerlevel, String minlevel, String reorderlevel, String noofpcs, String weight, String taxper, String discper, String fmrper,String retailprice) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            //,DANGERLEVEL,MINLEVEL,REORDERLEVEL,NOOFPCS,WEIGHT,TAXPER,DISCPER,FMRPER,RETAILPRICE
            Sql="UPDATE PMAST SET PNAME = '"+name+"', PSIZE = '"+size+"',SALEPRICE = "+Float.parseFloat(sailprice)+",COSTPRICE= "+
                Float.parseFloat(costprice)+",CATCODE = "+Integer.parseInt(cat)+",COMPANYCODE = "+
                Integer.parseInt(socity)+",STTYPECODE= "+Integer.parseInt(sttypecode)+",CLQTY = "+Float.parseFloat(clqty)+",CLVALUE = "+
                Float.parseFloat(clvalue)+",SUBCAT = "+Integer.parseInt(linecode)+",REMARKS = '"+remarks+"',DANGERLEVEL = "+Float.parseFloat(dangerlevel)+","
                    + "MINLEVEL = "+Float.parseFloat(minlevel)+",REORDERLEVEL = "+Float.parseFloat(reorderlevel)+","
                    + "NOOFPCS = "+Float.parseFloat(noofpcs)+",WEIGHT = "+Float.parseFloat(weight)+",TAXPER = "+Float.parseFloat(taxper)+","
                    + "DISCPER = "+Float.parseFloat(discper)+",FMRPER = "+Float.parseFloat(fmrper)+",RETAILPRICE = "+Float.parseFloat(retailprice)+" WHERE CODE="+code;
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
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return var;
    }
        
    public int find_min_in_emp_rec_code(Connection conn) {
        int min = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from EMPREC";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
//            System.out.println("MIN"+temp);
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
    public ArrayList<String> get_last_emp_rec(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_emp_rec_code(conn);
        String Sql = "select * from EMPREC WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            cat = get_emp_rec(result);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public boolean delete_emp_rec(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean van = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM EMPREC WHERE CODE = "+code;
            statement.executeUpdate(Sql);
            van = true;
        }
        catch(SQLException e)
        {
                van = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return van;
    }

    public ArrayList<String> prior_emp_rec(Connection conn, String code) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM EMPREC WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
             
              cat = get_emp_rec(result);

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

    public ArrayList<String> next_emp_rec(Connection conn, String code) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM EMPREC WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
               cat = get_emp_rec(result);    
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

    public int find_max_in_emp_rec_code(Connection conn) {
        int max = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from EMPREC";
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

    public String[] find_emp_rec_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from EMPREC WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String[] cat = new String[14];

        if(result.next()){
            cat[0] = result.getString("CODE");
            cat[1] = result.getString("NAME");
            cat[2] = result.getString("POST");
            cat[3] = result.getString("CNIC");
            cat[4] = result.getString("CONTACT");
            cat[5] = result.getString("ADD1");
            cat[6] = result.getString("ADD2");
            cat[7] = result.getString("ACTIVETYPE");//,,,,
            cat[8] = result.getString("SALARY");
            cat[9] = result.getString("NOK");
            cat[10] = result.getString("RELATION");
            cat[11] = result.getString("NOKCELL");
            cat[12] = result.getString("DATEJOINING");
            cat[13] = result.getString("DATELEAVING");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_post_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from POST WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("POST");
        }else{
            cat=null;
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
        String Sql = "select * from SUPP WHERE CODE="+code;

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
    public String find_fin_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from FINANCE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("FINNAME");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_seek_name_by_code(Connection conn, String code) throws SQLException {
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
    public String find_cashtype_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CASHTYPE WHERE CODE="+code;

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
    public String find_exp_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from EXPENCE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("EXPENCE");
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
    public String find_loc_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ASSETTYPE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("TYPE");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_cat_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from PCAT WHERE CCODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("PDESC");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_com_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from COMPANY WHERE CODE="+code;

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
    public String find_st_type_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from STOCKTYPE WHERE CODE="+code;

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
    public String find_subCat_Name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from SUBCAT WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("SUBCAT");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_route_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ROUTE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("ROUTEDESC");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_cust_type_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CUSTTYPE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("TYPE");
        }else{
            cat=null;
        }
        return cat;
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
    public String find_cust_rec_name_by_code(Connection conn, String code) throws SQLException {
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
    public String find_cust_add_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from DSPCLIENT WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("ADD1");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_cust_rec_add_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CLIENTS WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("ADD1");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_supp_add_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from SUPP WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("ADD1");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_cust_cell_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from DSPCLIENT WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("CONTACT");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_cust_rec_cell_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CLIENTS WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("CONTACT");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_supp_cell_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from SUPP WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("CONTACT");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_dist_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from DISTRICT WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("DISTRICT");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_rt_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ROUTE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("ROUTEDESC");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_zone_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ZONE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("ZONE");
        }else{
            cat=null;
        }
        return cat;
    }
    
    public String find_post_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from POST WHERE POST='"+name+"'";

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
    public String find_ast_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ASSETTYPE WHERE TYPE='"+name+"'";

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
//        String Sql = "select * from CLIENTS WHERE NAME='"+name+"'";
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
    public String find_fin_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
//        String Sql = "select * from CLIENTS WHERE NAME='"+name+"'";
        String Sql = "select * from FINANCE WHERE FINNAME='"+name+"'";

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
    public String find_product_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from PMAST WHERE PNAME='"+name+"'";

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
    public String find_cashtypec_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CASHTYPE WHERE NAME='"+name+"'";

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
    public String find_loc_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ASSETTYPE WHERE TYPE='"+name+"'";

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
    public String find_cat_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from PCAT WHERE PDESC='"+name+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("CCODE");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_com_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from COMPANY WHERE NAME='"+name+"'";

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
    public String find_st_type_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from STOCKTYPE WHERE NAME='"+name+"'";

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
    public String find_subCat_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from SUBCAT WHERE SUBCAT='"+name+"'";

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
    public String find_route_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ROUTE WHERE ROUTEDESC='"+name+"'";

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
    public String find_cust_type_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CUSTTYPE WHERE TYPE='"+name+"'";

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
    public String find_cust_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from DSPCLIENT WHERE NAME='"+name+"'";

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
    public String find_cust_rec_add_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CLIENTS WHERE NAME='"+name+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("ADD1");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_cust_rec_cell_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from CLIENTS WHERE NAME='"+name+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("CONTACT");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_cust_code_by_name_like(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from DSPCLIENT WHERE NAME LIKE "+name+"%";

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
    public String find_cust_add_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from DSPCLIENT WHERE NAME='"+name+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("ADD1");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_supp_add_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from SUPP WHERE NAME='"+name+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("ADD1");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_fin_desc_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from FINANCE WHERE FINNAME='"+name+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("OTHERDESC");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_cust_cell_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from DSPCLIENT WHERE NAME='"+name+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("CONTACT");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_supp_cell_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from SUPP WHERE NAME='"+name+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("CONTACT");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_dist_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from DISTRICT WHERE DISTRICT='"+name+"'";

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
    public String find_zone_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ZONE WHERE ZONE='"+name+"'";

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
    public String find_exp_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from EXPENCE WHERE EXPENCE='"+name+"'";

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
    public String find_van_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from VANREC WHERE VANNAME='"+name+"'";

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
    public ArrayList<String> find_all_post_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from POST ORDER BY LOWER(POST) ASC ";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("POST"));
                //System.out.println("POST: " + result.getString("POST").toString());
                i++;
                //returned=null;
        }
        return cat;
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
                //System.out.println("NAME: " + result.getString("NAME").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_ast_name_by_code(Connection conn) throws SQLException, SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from ASSETTYPE ORDER BY lower(TYPE) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("TYPE"));
                //System.out.println("NAME: " + result.getString("NAME").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_cashtype_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from CASHTYPE ORDER BY lower(NAME) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("NAME"));
                //System.out.println("NAME: " + result.getString("NAME").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    
    public ArrayList<String> find_all_supp_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from SUPP ORDER BY lower(NAME) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("NAME"));
                //System.out.println("NAME: " + result.getString("NAME").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_fin_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from FINANCE ORDER BY lower(FINNAME) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("FINNAME"));
                //System.out.println("NAME: " + result.getString("NAME").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_product_name_size_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select PNAME,PSIZE from PMAST ORDER BY lower(PNAME) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("PNAME")+" | "+resultset.getString("PSIZE"));
                //System.out.println("NAME: " + result.getString("PNAME").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_loc_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from ASSETTYPE ORDER BY CODE ASC ";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("TYPE"));
                //System.out.println("ASSETTYPE: " + result.getString("ASSETTYPE").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_route_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from ROUTE ORDER BY lower(ROUTEDESC) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("ROUTEDESC"));
                //System.out.println("ROUTEDESC: " + result.getString("ROUTEDESC").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_cust_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from DSPCLIENT ORDER BY lower(NAME) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("NAME"));
                //System.out.println("NAME: " + result.getString("NAME").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_cust_rec_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from CLIENTS ORDER BY lower(NAME) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("NAME"));
                //System.out.println("NAME: " + result.getString("NAME").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_cust_type_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from CUSTTYPE ORDER BY lower(TYPE) ASC";
//       String Sql = "Select * from CUSTTYPE ";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("TYPE"));
                //System.out.println("TYPE: " + result.getString("TYPE").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public String[][] find_all_cust_name_add_cell_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        String[][] cat = new String[find_max_in_cust_rec_code(conn)][3];

       String Sql = "Select * from CLIENTS";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat[i][0]=resultset.getString("NAME");
                cat[i][1]=resultset.getString("ADD1");
                cat[i][2]=resultset.getString("CONTACT");
                //System.out.println("NAME: " + result.getString("NAME").toString());
                //System.out.println("ADD1: " + result.getString("ADD1").toString());
                //System.out.println("CONTACT: " + result.getString("CONTACT").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_dist_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from DISTRICT ORDER BY lower(DISTRICT) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("DISTRICT"));
                //System.out.println("DISTRICT: " + result.getString("DISTRICT").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public boolean compare(Connection conn,String id,String pass) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        boolean cat = false;

       String Sql = "Select * from USERLOGIN WHERE USERID ="+id;
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        String p="";
        if(resultset.next())
        {       
                p=resultset.getString("USERPASS").toString();
                if(p.equals(pass)){
                    return true;
                }
        }
        return cat;
    }
    public ArrayList<String> find_all_zone_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from ZONE ORDER BY lower(ZONE) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("ZONE"));
                //System.out.println("ZONE: " + result.getString("ZONE").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_cat_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from PCAT ORDER BY lower(PDESC) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("PDESC"));
                //System.out.println("PDESC: " + result.getString("PDESC").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_com_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from COMPANY ORDER BY CODE ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("NAME"));
                System.out.println("NAME: " + resultset.getString("NAME").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_st_type_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from STOCKTYPE ORDER BY lower(NAME) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("NAME"));
                //System.out.println("NAME: " + result.getString("NAME").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_subCat_type_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from SUBCAT ORDER BY CODE ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("SUBCAT"));
                //System.out.println("NAME: " + result.getString("NAME").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_exp_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from EXPENCE ORDER BY lower(EXPENCE) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("EXPENCE"));
                //System.out.println("EXPENCE: " + result.getString("EXPENCE").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public ArrayList<String> find_all_van_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from VANREC ORDER BY lower(VANNAME) ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("VANNAME"));
                //System.out.println("EXPENCE: " + result.getString("EXPENCE").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    public boolean update_emp_rec(Connection conn, String Code, String name, String cnic, String cell, String add1, String add2,String actType,String post,String nok,String relation,String nokcell,String datejoining,String dateleaving) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            Sql="UPDATE EMPREC SET NAME = '"+name+"', CNIC = '"+cnic+"', CONTACT = '"+cell+"',ADD1 = '"+add1+"',ADD2= '"+add2+"',"
                    + "ACTIVETYPE= '"+actType+"',"
                    + "NOK= '"+nok+"',"
                    + "RELATION= '"+relation+"',"
                    + "NOKCELL= '"+nokcell+"',"
                    + "DATEJOINING = DATE('"+datejoining+"' , 'MM/DD/YY') ,"
                    + "DATELEAVING = DATE('"+dateleaving+"' , 'MM/DD/YY') ,"
                    + "POST= '"+post+"' WHERE CODE="+Code;
            int r = statement.executeUpdate(Sql);
            //System.out.println("rr"+r);
            if(r!=0){
                var = true;
            }
            
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

    private ArrayList<String> getRecords(ResultSet result) {
        ArrayList<String>  cat=new <String>ArrayList();
        try {
            String a = result.getString("CODE");
            String c = result.getString("PNAME");
            String d = result.getString("PSIZE");
            String e = result.getString("SALEPRICE");
            String g = result.getString("COSTPRICE");
//            String m = result.getString("BLOCKCODE");//CODE,PNAME,PSIZE,SALEPRICE,COSTPRICE,BLOCKCODE,CATCODE,COMPANYCODE,STTYPECODE,CLQTY,CLVALUE,SUBCAT,REMARKS
            String n = result.getString("CATCODE");
            String o = result.getString("COMPANYCODE");
            String s = result.getString("STTYPECODE");
            String t = result.getString("CLQTY");
            String u = result.getString("CLVALUE");
            String v = result.getString("SUBCAT");
            String w = result.getString("REMARKS");
            String w1 = result.getString("MINLEVEL");
            String w2 = result.getString("DANGERLEVEL");
            String w3 = result.getString("REORDERLEVEL");
            String w4 = result.getString("RETAILPRICE");
            String w5 = result.getString("WEIGHT");
            String w6 = result.getString("TAXPER");
            String w7 = result.getString("DISCPER");
            String w8 = result.getString("FMRPER");
            String w9 = result.getString("NOOFPCS");
            cat.add(0,a);
            cat.add(1,c);
            cat.add(2,d);
            cat.add(3,e);
            cat.add(4,g);
            cat.add(5,n);
            cat.add(6,o);
            cat.add(7,s);
            cat.add(8,t);
            cat.add(9,u);
            cat.add(10,v);
            cat.add(11,w);
            cat.add(12,w1);
            cat.add(13,w2);
            cat.add(14,w3);
            cat.add(15,w4);
            cat.add(16,w5);
            cat.add(17,w6);
            cat.add(18,w7);
            cat.add(19,w8);
            cat.add(20,w9);
            
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
                String ad2 = result.getString("SUPCODE");
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
            
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    private ArrayList<String> getPurchaseProducts(ResultSet result) {
        ArrayList<String>  cat=new <String>ArrayList();
        try {
//            DOCNO,SEQNO,PCODE,PERQTY,PERRATE,GROSSAMOUNT,TDO,DISCPER,FMR,TAXPER,NETAMOUNT
            String code = result.getString("DOCNO");
                String c = result.getString("SEQNO");
                String co = result.getString("PCODE");
                String ad2 = result.getString("PERQTY");
                String add = result.getString("PERRATE");
                String d = result.getString("GROSSAMOUNT");
                String d1 = result.getString("TDO");
                String am = result.getString("DISCPER");
                String n1 = result.getString("FMR");
                String co2 = result.getString("TAXPER");
                String add1 = result.getString("NETAMOUNT");
                String add6 = result.getString("RETURNQTY");
                String add61 = result.getString("DMG");
                String add62 = result.getString("FREE");
                String add63 = result.getString("CUSTOM");
                String add64 = result.getString("EXPIRYDATE");
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
                cat.add(15,add64 );
            
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }

    private ArrayList<String> setCustRec(ResultSet result) {
        ArrayList<String> cat = new ArrayList<String>();
        try {
            String a = result.getString("CODE");
            String b = result.getString("NAME");
            String c = result.getString("ADD1");
            String d = result.getString("CNIC");
            String e = result.getString("CONTACT");
            String f = result.getString("PREVIOUSBAL");
            String h = result.getString("AREACODE");
            String n = result.getString("REMARKS");
            String o = result.getString("REFFERENCE");
            String o1 = result.getString("ACTYPE");
            String o2 = result.getString("CUSTTYPE");
            String o3 = result.getString("ZONECODE");
            String o4 = result.getString("ROUTECODE");
            String o5 = result.getString("DATEOFJOINING");
            cat.add(0,a);
            cat.add(1,b);
            cat.add(2,c);
            cat.add(3,d);
            cat.add(4,e);
            cat.add(5,f);
            cat.add(6,h);
            cat.add(7,n);
            cat.add(8,o);
            cat.add(9,o1);
            cat.add(10,o2);
            cat.add(11,o3);
            cat.add(12,o4);
            cat.add(13,o5);
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }

    public String find_product_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from PMAST WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("PNAME");
            System.out.println("result.getString(\"PNAME\")"+result.getString("PNAME"));
        }else{
            cat=null;
        }
        return cat;
    }

    public String find_product_rate_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        
        String Sql = "select * from PMAST WHERE PNAME='"+name+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("COSTPRICE");
        }else{
            cat=null;
        }
        return cat;
    }
    public String find_product_weight_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        
        String Sql = "select * from DMS.PMAST WHERE PNAME='"+name+"'";

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("OILWEIGHT");
        }else{
            cat=null;
        }
        return cat;
    }
    public boolean check_product_line_item_presence_new(Connection conn,String string, String seqNoText,int pc) {
        boolean cat=false; 
        java.sql.Statement statement[]=new java.sql.Statement[find_max_in_purchase_products(conn, string)+pc];
        ResultSet result = null;
        try {
            statement[Integer.parseInt(seqNoText)] =  conn.createStatement();
            System.out.println("(DOCNO="+string+") AND (SEQNO="+seqNoText+")");
            String Sql = "select * from PERDTL ";
            result=statement[Integer.parseInt(seqNoText)].executeQuery(Sql);
            Sql = "select * from PERDTL WHERE (DOCNO='"+string+"') AND (SEQNO='"+seqNoText+"') ";

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
        }finally{
            try{
		if (statement[Integer.parseInt(seqNoText)] != null) statement[Integer.parseInt(seqNoText)].close();
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
            
            String Sql = null;
            Sql = "select * from PERDTL WHERE (DOCNO='"+string+"') AND (SEQNO='"+seqNoText+"') ";

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
                    cat= result.getString("PCODE")+" "+(Float.parseFloat(result.getString("PERQTY"))+Float.parseFloat(result.getString("DMG"))+Float.parseFloat(result.getString("FREE")))+"";
                }
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement[Integer.parseInt(seqNoText)] != null) statement[Integer.parseInt(seqNoText)].close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }
/*
    public boolean check_block_code_presence_in_pmast(Connection conn,String code) {
        boolean isPresent=false;
        try {
            java.sql.Statement statement = conn.createStatement();
            String Sql = "select * from PMAST WHERE BLOCKCODE='"+code+"'";
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            if(result.next()){
                isPresent=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isPresent;
    */
    public boolean check_catrec_code_presence_in_pmast(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PMAST WHERE CATCODE='"+code+"'";
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            if(result.next()){
                isPresent=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return isPresent;
    }
    public boolean check_clients_code_presence_in_clients(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from CLIENTS WHERE AREACODE='"+code+"'";
            ResultSet result = null;
            result=statement.executeQuery(Sql);
            if(result.next()){
                isPresent=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return isPresent;
    }
    public boolean check_expence_dep_code_presence_in_expence(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from EXPENCEDEP WHERE EXPCODE='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_ac_code_presence_in_vocdtl(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from VOCDTL WHERE ACCODE	='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_line_code_presence_in_pmast(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PMAST WHERE SUBCAT='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_post_code_presence_in_emprec(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from EMPREC WHERE POST='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_socity_code_presence_in_pmast(Connection conn,String code) {
        boolean isPresent=false;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PMAST WHERE COMPANYCODE='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_sttype_code_presence_in_pmast(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PMAST WHERE STTYPECODE='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_p_code_presence_in_perdtl(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PERDTL WHERE PCODE='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_p_code_presence_in_sdtl(Connection conn,String code) {
        boolean isPresent=false;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from SDTL WHERE PCODE='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_p_code_presence_in_paymain(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PAYMAIN WHERE PCODE='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_cust_code_presence_in_smain(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from SMAIN WHERE CUSTCODE='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_cust_code_presence_in_recovery(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from RECOVERY WHERE CUSTCODE='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_d_code_presence_in_permain(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PERMAIN WHERE DCODE='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_d_code_presence_in_smain(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from SMAIN WHERE DCODE='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_smcode_code_presence_in_expdep(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from EXPENCEDEP WHERE SMCODE='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_smcode_code_presence_in_cashdeposit(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from CASHDEPOSIT WHERE SMCODE='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_sup_code_presence_in_permain(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PERMAIN WHERE SUPCODE='"+code+"'";
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
        }
        return isPresent;
    }
    public boolean check_ac_code_presence_in_paydtl(Connection conn,String code) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PAYDTL WHERE ACCODE='"+code+"'";
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
        }
        return isPresent;
    }

    public String get_clqty_wrt_pmast_code(Connection conn, String seek) {
        String cat=null;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
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
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
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
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return var;
    }

    public String get_perqty_wrt_perdtl_code_seek(Connection conn, String a, String b,String c) {
        String cat=null;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PERDTL WHERE PCODE="+a+" AND SEQNO ="+c+" AND DOCNO ="+b;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = (Float.parseFloat(result.getString("PERQTY"))+Float.parseFloat(result.getString("DMG"))+Float.parseFloat(result.getString("FREE")))+"";
            }else{
                cat=null;
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

    public String[] get_invNo_suppCode_remaining(Connection conn, String string) {
        String cat[] = new String[3];
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PERMAIN WHERE DOCNO ="+string;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat[0] = result.getString("DOCNO");
                cat[1] = result.getString("SUPCODE");
                cat[2] = result.getString("REMAINING");
            }else{
                cat=null;
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

    public String[] get_invNo_freight_debit_credit(Connection conn, String string) {
        String cat[] = new String[4];
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from RECOVERY WHERE DOCCODE ="+string;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat[0] = result.getString("CUSTCODE");
                cat[1] = result.getString("AMOUNT");
                cat[2] = result.getString("FREIGHT");
                cat[3] = result.getString("CREDITAMOUNT");
            }else{
                cat=null;
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
    public String[] get_invNo_freight_debit_credit_sm(Connection conn, String string) {
        String cat[] = new String[4];
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from RECOVERY WHERE DOCCODE ="+string;

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat[0] = result.getString("SM1CODE");
                cat[1] = result.getString("AMOUNT");
                cat[2] = result.getString("FREIGHT");
                cat[3] = result.getString("CREDITAMOUNT");
            }else{
                cat=null;
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
    public String[] get_pQty_saleQty(Connection conn,String string, String seqNoText) {
       String cat[] = new String[4];
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PERDTL WHERE (DOCNO='"+string+"') AND (SEQNO='"+seqNoText+"') ";

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                cat[0]=result.getString("PCODE");
                cat[1]=result.getString("PERQTY");
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
        //System.out.println("==cat : " + cat);
        return cat;
    }

    public String get_clbal_from_clints(Connection conn, String code) {
        String  cat=null;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
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
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        //System.out.println("==cat : " + cat);
        return cat;
    }
    public String get_empCustCredit_from_empRec(Connection conn, String code) {
        String  cat=null;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
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
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        //System.out.println("==cat : " + cat);
        return cat;
    }
    public boolean update_clbal_in_clints(Connection conn, String string, String text) {
        boolean var = false;
        
        java.sql.Statement statement = null;
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
        }finally{
            try{
		if (statement != null) statement.close();
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
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return var;  
    }
    private ArrayList<String> get_emp_rec(ResultSet result) throws SQLException {
        ArrayList<String> cat=new <String>ArrayList();
        try{
            String a = result.getString("CODE");
            String b = result.getString("NAME");
            String c = result.getString("CNIC");
            String d = result.getString("CONTACT");
            String e = result.getString("ADD1");
            String f = result.getString("ADD2");
            String g = result.getString("ACTIVETYPE");
            String h = result.getString("POST");
            String i = result.getString("SALARY");
            String j = result.getString("NOK");
            String k = result.getString("RELATION");
            String l = result.getString("NOKCELL");
            String m = result.getString("DATEJOINING");
            String n = result.getString("DATELEAVING");
            System.out.println("a"+a);//CODE,NAME,CNIC,CONTACT,ADD1,ADD2,ACTIVETYPE,POST,SALARY,NOK,RELATION,NOKCELL,DATEJOINING,DATELEAVING
            System.out.println("b"+b);
            System.out.println("c"+c);
            System.out.println("d"+d);
            System.out.println("e"+e);
            System.out.println("f"+f);
            System.out.println("g"+g);
            System.out.println("h"+h);
            System.out.println("i"+i);
            System.out.println("j"+j);
            System.out.println("k"+k);
            System.out.println("l"+l);
            System.out.println("m"+m);
            System.out.println("n"+n);
            cat.add(0,a);
            cat.add(1,b);
            cat.add(2,c);
            cat.add(3,d);
            cat.add(4,e);
            cat.add(5,f);
            cat.add(6,g);
            cat.add(7,h);
            cat.add(8,i);
            cat.add(9,j);
            cat.add(10,k);
            cat.add(11,l);
            cat.add(12,m);
            cat.add(13,n);
        }catch(SQLException e){
            System.out.println(" get_emp_rec "+e);// null exception
        }
        return cat;
    }

    public String[][] search_history(Connection conn, String text,String bff) {
        String returned[][] = new String[find_count_in_order_dtl(conn,text)][5];
        java.sql.Statement statement = null;
        ResultSet resultset = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select * from PERDTL where ROWNUM <= 30 AND  PCODE='"+text+"' ORDER BY DOCNO DESC";
//            String Sql = "Select * from PERDTL where PCODE='"+text+"' ORDER BY DOCNO DESC LIMIT 2";
            resultset = statement.executeQuery(Sql);
            int i=0;
            while(resultset.next())
            {   if(hasBff(conn,bff,resultset.getString("DOCNO"))){
                    //DOCNO,SALEQTY,SALERATE,TDO,TOTALSIZE,RETURNQTY
                    returned[i][0]=resultset.getString("DOCNO");
                    returned[i][1]=find_date_by_code(conn,resultset.getString("DOCNO"));
    //                returned[i][3]=result.getString("TOTALSIZE");
                    returned[i][2]=resultset.getString("PERRATE");
//                    returned[i][4]=result.getString("TOTALSIZE");
                    returned[i][3]=resultset.getString("PERQTY");
                    returned[i][4]=resultset.getString("DISCPER");
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
            String Sql = " SELECT COUNT(SEQNO) AS Count FROM PERDTL WHERE  PCODE = '"+name+"'";
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
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from PERMAIN WHERE DOCNO="+string;
            
            result=statement.executeQuery(Sql);
            
            if(result.next()){
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
            String Sql = "select * from PERMAIN WHERE SUPCODE='"+bff+"' AND DOCNO ='"+doc+"'";
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
        }
//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"//ODATE,DOCNO,REFNO,CUSTCODE,TGROSSAMT,FMRSUM,SPLRS,OTHEREXP,AVDISCPER,"
//                    + "TDISCRS,AVTAXPER,TTAXRS,TNETAMOUNT,REMAINING,PAID,REMARKS,NETPAYABLE,DCODE
        return isPresent;
    }

    public String get_password(Connection conn, String text) {
            String cat = "false";
        
        ResultSet resultset = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();


            String Sql = "Select * from USERLOGIN WHERE USERID ="+text;
            resultset = statement.executeQuery(Sql);
            int i=0;
            String p="";
            if(resultset.next())
            {
                cat=resultset.getString("USERPASS");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
            return cat;
    }

    
    
    
    
    
    
    public int find_min_in_role_code(Connection conn) {
        int min = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from ROLE";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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
    public ArrayList<String> get_first_role(Connection conn)throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int min=find_min_in_role_code(conn);
        String Sql = "select * from ROLE WHERE CODE="+min;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();

        if(result.next()){
            String code = result.getString("CODE");
            String assetName = result.getString("ROLE");
            cat.add(code);
            cat.add(assetName);
        }else{
            cat=null;
        }
        return cat;

    }





    
    
    
    
    
    
    
    
    
    
    public String find_role_name_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ROLE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat;

        if(result.next()){
            cat = result.getString("ROLE");
        }else{
            cat=null;
        }
        return cat;
    }

    public int find_max_in_user_rec_code(Connection conn) {
        int max = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(USERID))as ID from USERLOGIN";
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


    public ArrayList<String> get_last_user_rec(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_user_rec_code(conn);
        String Sql = "select * from USERLOGIN WHERE USERID="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){//,,,
            String a = result.getString("USERID");
            String b = result.getString("USERNAME");
            String c = result.getString("USERPASS");
            String d = result.getString("FULLACC");
            cat.add(0,a);
            cat.add(1,b);
            cat.add(2,c);
            cat.add(3,d);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    public ArrayList<String> find_all_role_name_by_code(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select * from ROLE ORDER BY LOWER(ROLE) ASC ";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                cat.add(i,resultset.getString("ROLE"));
                //System.out.println("POST: " + result.getString("POST").toString());
                i++;
                //returned=null;
        }
        return cat;
    }
    
    public String find_role_code_by_name(Connection conn, String name) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ROLE WHERE ROLE='"+name+"'";

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
 
    public String[] find_user_rec_by_code(Connection conn, String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from USERLOGIN WHERE USERID="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String[] cat = new String[17];

        if(result.next()){//USERID,USERNAME,USERPASS,FULLACC
            cat[0] = result.getString("USERID");
            cat[1] = result.getString("USERNAME");
            cat[2] = result.getString("USERPASS");
            cat[3] = result.getString("FULLACC");
        }else{
            cat=null;
        }
        return cat;
    }
    public boolean update_role(Connection conn, String code,String loc) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

                Sql="UPDATE ROLE SET ROLE = '"+loc+"'WHERE CODE="+code+"";
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
       
    public boolean update_role_grant(Connection conn, String textRole, String stringGrantCode, boolean selected,String james) {
        /*System.out.println("textRole "+textRole);
        System.out.println("stringGrantCode "+stringGrantCode);
        System.out.println("selected "+selected);
        System.out.println("name "+james);*/
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql, s;
            if(selected){s="Y";}else{s="N";}
            if(isGrantCodePresent(conn,textRole,stringGrantCode)){
                Sql="UPDATE ROLEGRANTS SET YN = '"+s+"' WHERE CODE="+stringGrantCode+" AND ROLE='"+textRole+"'";
            }else{
                Sql = "INSERT INTO ROLEGRANTS(CODE,ACCESSNAME,ROLE,YN)VALUES ("
                        + Integer.parseInt(stringGrantCode)+ ",'" + james +"',"+ Integer.parseInt(textRole)+ ",'"+ s +"')";
            }
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
 
    public ArrayList<String>[] search_role_grants(Connection conn, String asset_rec) throws SQLException {
        ArrayList<String> returned[] = new ArrayList[find_count_in_role_grants(conn,asset_rec)];//ppp
	java.sql.Statement statement = conn.createStatement();
//         SELECT * FROM PERDTL WHERE  DOCNO = 90002 ORDER BY SEQNO ASC
	String Sql = "SELECT * FROM ROLEGRANTS WHERE ROLE = '"+asset_rec+"' ORDER BY CODE ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {         
            returned[i]=getRoleGrants(resultset);
            i++;
        }  
        return returned;
    }
   
    public int find_count_in_role_grants(Connection conn, String name) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = " SELECT COUNT(CODE) AS Count FROM ROLEGRANTS WHERE ROLE = '"+name+"'";
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
 
    private ArrayList<String> getRoleGrants(ResultSet result) {
        ArrayList<String>  cat=new <String>ArrayList();
        try {
            String code = result.getString("CODE");
            String c = result.getString("ACCESSNAME");
            String co = result.getString("ROLE");
            String ad2 = result.getString("YN");
            cat.add(0,code );
            cat.add(1,c );
            cat.add(2,co );
            cat.add(3,ad2 );
            
        } catch (SQLException ex) {
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }

    public int find_max_in_role_code(Connection conn) {
        int max = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from ROLE";
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
    
    
    public ArrayList<String> prior_role(Connection conn, String code, String text0) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
        ResultSet result = null;
       ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM ROLE WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String code1 = result.getString("CODE");
                String assetName = result.getString("ROLE");
                cat.add(code1);
                cat.add(assetName);
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


    public boolean insert_role_in_table(Connection conn, String code, String loc) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO ROLE(CODE,ROLE) VALUES ("+ Integer.parseInt(code)+ ",'" + loc +"')";
            statement.executeUpdate(Sql);
            Sql = "SELECT distinct CODE,ACCESSNAME,ROLE,YN FROM ROLEGRANTS WHERE ROLE = 2";//(CODE,ACCESSNAME,ROLE,YN)
            result = statement.executeQuery(Sql);
            while (result.next()) {
                String next = result.getString("CODE");
                String next1 = result.getString("ACCESSNAME");
                String next2 = result.getString("ROLE");
                String next3 = result.getString("YN");
                Sql = "INSERT INTO ROLEGRANTS(CODE,ACCESSNAME,ROLE,YN)VALUES ("
                        + Integer.parseInt(next)+ ",'" + next1 +"',"+ Integer.parseInt(code)+ ",'"+ next3 +"')";                     
                statement = conn.createStatement();
                statement.executeUpdate(Sql);
//                System.out.println(next+" , "+next1+" , "+next2+" , "+next3);               
            }
            var = true;
        }
        catch(SQLException e)
        {
//            System.out.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return var;
    }

    public ArrayList<String> next_role(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM ROLE WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){
                String code1 = result.getString("CODE");
                String assetName = result.getString("ROLE");
                cat.add(0,code1);
                cat.add(1,assetName);
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

    public boolean delete_role(Connection conn ,String code, String dist) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM ROLE WHERE CODE = "+code;
            statement.executeUpdate(Sql);
            
            Sql = "DELETE FROM ROLEGRANTS WHERE ROLE = "+code;
            statement.executeQuery(Sql);
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
    public ArrayList<String> get_last_role(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_role_code(conn);
        String Sql = "select * from ROLE WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String code = result.getString("CODE");
            String comp = result.getString("ROLE");
            cat.add(code);
            cat.add(comp);
        }else{
            cat.add(null);
        }
        return cat;
    }	
 
    public String find_role_rec_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from ROLE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        String cat = new String();

        if(result.next()){
            String assetName = result.getString("ROLE");
            cat=assetName;
        }else{
            cat=null;
        }
        return cat;
    }
     public ArrayList<String> get_first_user_rec(Connection conn)throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        
        ArrayList<String> cat;
        int min=0;
        min=find_min_in_user_rec_code(conn);
        if(min!=0){
                String Sql = "select * from USERLOGIN WHERE USERID="+min;

            ResultSet result = null;
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
           cat = new ArrayList<String>();
            //,,,
            if(result.next()){
               String a = result.getString("USERID");
                String b = result.getString("USERNAME");
                String c = result.getString("USERPASS");
                String d = result.getString("FULLACC");
                cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
            }else{
                cat.add(null);
            }
        }else{
            cat=null;
        }
        return cat;
    }
     
    
     public int find_min_in_user_rec_code(Connection conn) {
        int min = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(USERID))as ID from USERLOGIN";
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
     
    public ArrayList<String> prior_user_rec(Connection conn, String code) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM USERLOGIN WHERE USERID <"+Integer.parseInt(code)+" ORDER BY USERID DESC ";
            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){//,,,
             
              String a = result.getString("USERID");
                String b = result.getString("USERNAME");
                String c = result.getString("USERPASS");
                String d = result.getString("FULLACC");
                cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
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
    
    public boolean delete_user_rec(Connection conn ,String code) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean van = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM USERLOGIN WHERE USERID = "+code;
            statement.executeUpdate(Sql);
            van = true;
        }
        catch(SQLException e)
        {
                van = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }

        return van;
    }

    public boolean update_user(Connection conn, String userid, String username, String userpass, String fullacc) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
           
            String Sql="UPDATE USERLOGIN SET USERNAME = '"+username+"', USERPASS = '"+userpass+"', FULLACC = '"+fullacc+"' WHERE USERID="+userid;
            int r = statement.executeUpdate(Sql);
            //System.out.println("rr"+r);
            if(r!=0){
                var = true;
            }
            
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
    
    public ArrayList<String> next_user_rec(Connection conn, String code) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM USERLOGIN WHERE USERID > "+Integer.parseInt(code)+" ORDER BY USERID";            
            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);
            
            if(result.next()){//USERID,USERNAME,USERPASS,FULLACC
               String a = result.getString("USERID");
                String b = result.getString("USERNAME");
                String c = result.getString("USERPASS");
                String d = result.getString("FULLACC");
                cat.add(0,a);
                cat.add(1,b);
                cat.add(2,c);
                cat.add(3,d);
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
    
    public String[][] search_user_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_user_rec_code(conn)][4];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from USERLOGIN where UPPER(USERNAME) like UPPER('" + asset_rec + "%')";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           //,,,
                returned[i][0]=resultset.getString("USERID");
                returned[i][1]=resultset.getString("USERNAME");
                returned[i][2]=resultset.getString("USERPASS");
                returned[i][3]=find_role_name_by_code(conn, resultset.getString("FULLACC"));
                i++;
                //returned=null;
        }
        return returned;
    }
    
    private int find_count_in_user_rec_code(Connection conn) {
        int count = 0;
        
        ResultSet result = null;//USERID,USERNAME,USERPASS,FULLACC
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(USERID))as Count from USERLOGIN";
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
    
    public String[][] search_role_rec(Connection conn, String asset_rec) throws SQLException {
        String returned[][] = new String[find_count_in_role_code(conn)][2];
	java.sql.Statement statement = conn.createStatement();
	String Sql = "Select * from ROLE where UPPER(ROLE) like UPPER('" + asset_rec + "%')";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                returned[i][0]=resultset.getString("CODE");
                returned[i][1]=resultset.getString("ROLE");
                //System.out.println("Code: " + result.getString("CODE"));
                //System.out.println("LOCATION: " + result.getString("LOCATION"));
                i++;
                //returned=null;
        }
        return returned;
    }
 
    private int find_count_in_role_code(Connection conn) {
        int count = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select COUNT(TO_NUMBER(CODE))as Count from ROLE";
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
        //System.out.println("Returened Count"+count);
        return count;
    }

    public String get_discPer(Connection conn, String c, String p) {
        String cat = "0" ;
        
        ResultSet result = null;
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();

            String Sql = "select * from CUSTTYPEDISC WHERE CUSTTYPE='"+c+"' AND PMAST='"+p+"'";

            result=statement.executeQuery(Sql);
            //System.out.println("Result : " + result);

            if(result.next()){
                cat = result.getString("DISC");
//                cat = "9999";

            }else{
                cat="0";
            }
        } catch (SQLException ex) {
            cat="0";
            Logger.getLogger(PAK_DB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
		if (statement != null) statement.close();
		if (result != null) result.close();
            }catch(SQLException e){}
        }
        return cat;
    }       
    Conversions dateField=new Conversions();
//dateField.toReturnedDate(odDate.getDate()+"") 
// dateField.toDateString(odDate.getDate().toString()),
    public ArrayList<String> find_all_date_by_product_code(Connection conn, String text) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();

       String Sql = "Select to_char(EXPIRYDATE,'MM/DD/YY') As EXPIRYDATE,NETTOTALSTOCK from CURRENTSTOCK WHERE CODE = '"+text+"' ORDER BY EXPIRYDATE ASC";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                if(Float.parseFloat(resultset.getString("NETTOTALSTOCK"))>0){
                    cat.add(resultset.getString("EXPIRYDATE"));
                    System.out.print(" , "+resultset.getString("EXPIRYDATE"));
                    i++;
                };
        }
        return cat;
    }
    
    public String find_product_ExpDate_by_code(Connection conn, String text) throws SQLException {
        java.sql.Statement statement = conn.createStatement();

        String cat = "";

       String Sql = "Select to_char(EXPIRYDATE,'MM/DD/YY') As EXPIRYDATE,NETTOTALSTOCK from CURRENTSTOCK WHERE CODE = '"+text+"'";// AND EXPIRYDATE is not null
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
            if(Float.parseFloat(resultset.getString("NETTOTALSTOCK"))>0){
                if(resultset.getString("EXPIRYDATE")!=null&&!resultset.getString("EXPIRYDATE").isEmpty()){
                    cat=resultset.getString("EXPIRYDATE");
//                    RETURNMAIN.print(" =======>>> "+result.getString("EXPIRYDATE"));
                    i++;
                    break;
                }
            }
        }
        resultset.close();statement.close();
        return cat;
    }

    public ArrayList<String> find_all_custome_by_product_code(Connection conn, String c1, String c2) throws SQLException {
         java.sql.Statement statement = conn.createStatement();

        ArrayList<String> cat = new ArrayList();
//        RETURNMAIN.println("DDDDaaatttteee"+c2);
//        if(c2=="000"){c2="";}
       String Sql = "Select * from CURRENTSTOCK WHERE CODE = '"+c1+"' AND ((EXPIRYDATE = EXPIRYDATE AND EXPIRYDATE is NULL) OR EXPIRYDATE = DATE('"+c2+"' , 'MM/DD/YY'))";
	ResultSet resultset = statement.executeQuery(Sql);
        int i=0;
        while(resultset.next())
        {           
                if(Float.parseFloat(resultset.getString("NETTOTALSTOCK"))>0){
                    cat.add(resultset.getString("BATCH"));
//                    RETURNMAIN.print(" , "+result.getString("BATCH"));
                    i++;
                };
        }
        return cat;
    }
    
    
    
    
    public boolean delete_satelment(Connection conn ,String code, String dist) {
//        DELETE FROM emp WHERE empno = my_empno
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql=null;

            Sql = "DELETE FROM SATELMENTTYPE WHERE CODE = "+code;
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

    public boolean update_satelment(Connection conn, String code,String route) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="UPDATE SATELMENTTYPE SET TYPE = '"+route+"'WHERE CODE="+code+"";
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

    public ArrayList<String> prior_satelment(Connection conn, String code, String text0) {
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
       ArrayList<String> cat = new ArrayList<String>();
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;
            
            Sql="SELECT * FROM SATELMENTTYPE WHERE CODE <"+Integer.parseInt(code)+" ORDER BY CODE DESC ";
            
            result=statement.executeQuery(Sql);
//            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("TYPE");
                cat.add(a);
                cat.add(b);
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

    public ArrayList<String> next_satelment(Connection conn, String code, String text0) {
        ArrayList<String> cat = new ArrayList<String>();
        //cat.add(null);
       
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql;

            Sql="SELECT * FROM SATELMENTTYPE WHERE CODE > "+Integer.parseInt(code)+" ORDER BY CODE";            
            result=statement.executeQuery(Sql);
//            //System.out.println("Result : " + result);
            
            if(result.next()){
                String a = result.getString("CODE");
                String b = result.getString("TYPE");
                cat.add(0,a);
                cat.add(1,b);
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

    public String find_satelment_rec_by_code(Connection conn,String code) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        String Sql = "select * from SATELMENTTYPE WHERE CODE="+code;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
//        //System.out.println("Result : " + result);
        String cat = new String();

        if(result.next()){
            String assetName = result.getString("TYPE");
            cat=assetName;
        }else{
            cat=null;
        }
        return cat;
    }

    public int find_max_in_satelment_code(Connection conn) {
        int max = 0;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MAX(TO_NUMBER(CODE))as ID from SATELMENTTYPE";
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

    public int find_min_in_satelment_code(Connection conn) {
        int min = 0;
        
        java.sql.Statement statement = null;
            ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "Select MIN(TO_NUMBER(CODE))as ID from SATELMENTTYPE";
            result=statement.executeQuery(Sql);
            result.next();
            String temp=result.getString("ID");
            //System.out.println("MIN"+temp);
            if(temp==null){
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
   public boolean insert_satelment_rec_in_table(Connection conn, String Code, String zone) {
        boolean var = false;
        
        java.sql.Statement statement = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "INSERT INTO SATELMENTTYPE(CODE,TYPE) VALUES ("+ Integer.parseInt(Code)+ ",'" + zone+ "')";
            statement.executeUpdate(Sql);
            var = true;
        }
        catch(SQLException e)
        {
//            RETURNMAIN.println("Error Log :"+e);
            var = false;
        }finally{
            try{
		if (statement != null) statement.close();
            }catch(SQLException e){}
        }
        return var;
    }
    public ArrayList<String> get_first_satelment(Connection conn) throws SQLException{
       java.sql.Statement statement = conn.createStatement();
        int min=find_min_in_satelment_code(conn);
        String Sql = "select * from SATELMENTTYPE WHERE CODE="+min;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();

        if(result.next()){
            String code = result.getString("CODE");
            String assetName = result.getString("TYPE");
            cat.add(code);
            cat.add(assetName);
        }else{
            cat=null;
        }
        return cat;

    }
    public boolean chech_satelment(Connection conn, String docno) {
        boolean cat=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from SATELMENTMAIN WHERE SATELMENTTYPE='"+docno+"'";
            result=statement.executeQuery(Sql);
            if(result.next()){
                return cat=false;
            }else{
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
    public ArrayList<String> get_last_satelment(Connection conn) throws SQLException {
        java.sql.Statement statement = conn.createStatement();
        int max=find_max_in_satelment_code(conn);
        String Sql = "select * from SATELMENTTYPE WHERE CODE="+max;

        ResultSet result = null;
        result=statement.executeQuery(Sql);
//        //System.out.println("Result : " + result);
        ArrayList<String> cat = new ArrayList<String>();
        
        if(result.next()){
            String code = result.getString("CODE");
            String comp = result.getString("TYPE");
            cat.add(code);
            cat.add(comp);
        }else{
            cat.add(null);
        }
        return cat;
    }	

    private boolean isGrantCodePresent(Connection conn, String textRole, String stringGrantCode) {
        boolean isPresent=false;
        
        java.sql.Statement statement = null;
        ResultSet result = null;
        try
        {
            statement = conn.createStatement();
            String Sql = "select * from ROLEGRANTS WHERE CODE='"+stringGrantCode+"' AND  ROLE='"+textRole+"'";
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
        }
        System.err.println("isPresent"+isPresent);
        return isPresent;
    }
    
    
}