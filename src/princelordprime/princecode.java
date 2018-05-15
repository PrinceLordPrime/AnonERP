/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princelordprime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Muhammad Shahab
 */
public class princecode {
    
    public String get_correct_date(Date dated){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String input_date = sdf.format(dated);
        //System.out.println(input_date);
        return input_date;
    }
    
}
