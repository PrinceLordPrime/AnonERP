/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logical;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author DynamicSP
 */
public class Conversions {
//    private static SimpleDateFormat iso8601formatter = new SimpleDateFormat("MM,dd,yyyy");
    public Date toDate(String charDate) throws ParseException {
        //System.out.println("Date : "+charDate);
        
        System.out.println("Char Date Here : "+charDate);
        
        if(charDate==null){
            Date date1= null;
            return date1;
        }
        
        
        
        String MM=charDate.substring(5, 7);
        String dd=charDate.substring(8,10);
        String yyyy=charDate.substring(0, 4);
        
//        System.out.println(mm+","+dd+","+yyyy);
        
        //String string = (mm+","+dd+","+yyyy) ;//"Jan,02,2010";
        
        String string = (yyyy+"-"+MM+"-"+dd) ;//"Jan,02,2010";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        
//        Date date = iso8601formatter.parse(string);
        Date date = format.parse(string);
//        System.out.println(""+date);
        return date;
    }
    public Date toReturnedDate(String charDate) throws ParseException {
         if(charDate==null){
            Date date1= null;
            return date1;
        }
        String MM=charDate.substring(4, 7);
        String dd=charDate.substring(8,10);
        String yyyy=charDate.substring(24, 28);
        
        String string = (yyyy+"-"+MM+"-"+dd) ;//"Jan,02,2010";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        Date date = format.parse(string);
        return date;
    }
    public Date toReturnedDate1(String charDate) throws ParseException {
         if(charDate==null){
            Date date1= null;
            return date1;
        }
        String MM=charDate.substring(5, 7);
        String dd=charDate.substring(8,10);
        String yyyy=charDate.substring(0, 4);
        
        String string = (yyyy+"-"+MM+"-"+dd) ;//"Jan,02,2010";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        Date date = format.parse(string);
        return date;
    }
    public java.util.Date getPresentDate() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        Calendar cal = Calendar.getInstance();
        String string=format.format(cal.getTime()).toString(); 
        //System.out.println("string"+string);
        java.util.Date date = format.parse(string);
        return date;
    }
    public String toDateString(String charDate) throws ParseException {
//        System.out.println("Date : "+charDate);
        String string="";
        if(charDate==null){
            return ""; 
        }else{
            String MM=charDate.substring(4, 7);
            String dd=charDate.substring(8,10);
            String yyyy=charDate.substring(24, 28);

    //        System.out.println("mm"+mm +"dd"+dd+"yyyy"+yyyy);
            string = (yyyy+"-"+MM+"-"+dd) ;//"Jan,02,2010";
            //System.out.println("string"+string);
        }
        return string;
    }
    public String toDateString1(String charDate) throws ParseException {
//        System.out.println("Date : "+charDate);
        String string="0";
        if(charDate=="0"){
            return "0"; 
        }else{
            String MM=charDate.substring(4, 7);
            String dd=charDate.substring(8,10);
            String yyyy=charDate.substring(24, 28);

    //        System.out.println("mm"+mm +"dd"+dd+"yyyy"+yyyy);
            string = (yyyy+"-"+MM+"-"+dd) ;//"Jan,02,2010";
            //System.out.println("string"+string);
        }
        return string;
    }
    public ArrayList<String> toDateList(String date) {
        ArrayList<String> s = new ArrayList<String>();
        
        //System.out.println("Date : "+date);
        //System.out.println("date.substring(0, 3) :"+date.substring(0, 4));
        //System.out.println("date.substring(5,6):"+date.substring(5,7));
        //System.out.println("date.substring(8, 9) :"+date.substring(8, 10));
        
        s.add(0,date.substring(0, 4));
        s.add(1,date.substring(5,7));
        s.add(2,date.substring(8, 10));
        
        return s;
    }
    public float toFloat(String s){
        float sP=0.0f;
        return sP;
    }
    public String[] getStringList(int i, int i0) {
        String[] y;
        int upperLimit=i;
        int lowerLimit=i0;
        int indexSize=lowerLimit-upperLimit;
        y =new String[indexSize];
        for(int i3=1;i3<indexSize+1;i3++){
            y[i]=String.valueOf(upperLimit);
            upperLimit=upperLimit+1;
        }
        return y;
    }
    
}
