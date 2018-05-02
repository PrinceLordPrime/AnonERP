package extras;

import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author UzairYousafZai
 */
public class NewClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float  f=999999f;
        float  f1=99999f;
        float  f2=f*f1;
        System.out.println("f:"+f);
        System.out.println("f1:"+f1);
        System.out.println("f2:"+f2);
        
        BigDecimal bd = BigDecimal.valueOf(f);
        BigDecimal bd1 = BigDecimal.valueOf(f1);
        BigDecimal bd2 = bd.multiply(bd1);
        System.out.println("bd:"+bd);
        System.out.println("bd1:"+bd1);
        System.out.println("bd2:"+bd2);
    }
    
}
