/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logical.Conversions;
import logical.dateIncrementer;

/**
 *
 * @author Shan
 */
public class dateChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conversions v = new Conversions();
        try {
            String d= "Wed Jan 28 00:09:00 PKT 2012";
            System.out.println("Actual ::           "+v.toReturnedDate(d));
            System.out.println("Daily :: "+dateIncrementer.addDays(v.toReturnedDate(d),1));
            System.out.println("");
            System.out.println("Monthly ::     "+dateIncrementer.incrDateMonthly(v.toReturnedDate(d)));
            System.out.println("BiMonthly ::   "+dateIncrementer.incrDateBiMonthly(v.toReturnedDate(d)));
            System.out.println("Weakly  ::   "+dateIncrementer.incrDateWeakly(v.toReturnedDate(d)));
            System.out.println("");
            System.out.println("Yearly ::           "+dateIncrementer.incrDateYearly(v.toReturnedDate(d)));
            System.out.println("Semi Yearly ::      "+dateIncrementer.incrDateSemiYearly(v.toReturnedDate(d)));
            System.out.println("Quater Yearly ::    "+dateIncrementer.incrDateQuaterYearly(v.toReturnedDate(d)));
            
        } catch (ParseException ex) {
            Logger.getLogger(dateChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
