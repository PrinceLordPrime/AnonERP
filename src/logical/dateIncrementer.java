/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logical;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Shan
 */
public class dateIncrementer {
    
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
//        System.out.println("Day max ------------>>"+cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
    public static Date incrDateWeakly(Date date)
    {
        Calendar cal = Calendar.getInstance();
        //System.out.println("date.getDay()"+date.getDay());
        cal.setTime(date);
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH)/2;
        cal.add(Calendar.DATE, (days/2)); //minus number would decrement the days
        return cal.getTime();
    }
    public static Date incrDateBiMonthly(Date date)
    {
        Date d = date;
        for(int i=0;i<2;i++){
            d=incrDateMonthly(d);
        }
        return d;
        /*
        Calendar cal = Calendar.getInstance();
        //System.out.println("date.getDay()"+date.getDay());
        cal.setTime(date);
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH)/2;
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
        */
    }
    public static Date decrementDateBiMonthly(Date date, int monthsCount)
    {
        Date d = date;
        for(int i=0;i<monthsCount;i++){
            d=incrDateMonthly(d);
        }
        return d;
        /*
        Calendar cal = Calendar.getInstance();
        //System.out.println("date.getDay()"+date.getDay());
        cal.setTime(date);
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH)/2;
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
        */
    }
    public static Date incrDateMonthly(Date date)
    {
        Calendar cal = Calendar.getInstance();
        //System.out.println("date.getDay()"+date.getDay());
        cal.setTime(date);
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
    public static Date incrDateYearly(Date date)
    {
        
        /*
        Calendar cal = Calendar.getInstance();
        //System.out.println("date.getDay()"+date.getDay());
        cal.setTime(date);
        int days = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
                */
        Date d = date;
        for(int i=0;i<12;i++){
            d=incrDateMonthly(d);
        }
        return d;
//        return cal.getTime();
    }
    public static Date incrDateSemiYearly(Date date)
    {
        Date d1 = date;
        for(int j=0;j<6;j++){
            d1=incrDateMonthly(d1);
        }
        return d1;
        /*
        Calendar cal = Calendar.getInstance();
        //System.out.println("date.getDay()"+date.getDay());
        cal.setTime(date);
        int days = cal.getActualMaximum(Calendar.DAY_OF_YEAR)/2;
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
                */
    }
    public static Date incrDateQuaterYearly(Date date)
    {
        Date d = date;
        for(int i=0;i<3;i++){
            d=incrDateMonthly(d);
        }
        return d;
        /*
        Calendar cal = Calendar.getInstance();
        //System.out.println("date.getDay()"+date.getDay());
        cal.setTime(date);
        int days = cal.getActualMaximum(Calendar.DAY_OF_YEAR)/2;
        cal.add(Calendar.DATE, (days/2)); //minus number would decrement the days
        return cal.getTime();
                */
    }
}
