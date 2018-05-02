/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.frames.mainpkg;

/**
 *
 * @author Shan
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("==UP OUT"+i);
            for (int j = 0; j < 10; j++) {
                if(j==2){
                    System.out.println("up in"+j);
                    break ;
                }
                System.out.println("down in"+j);
            }
            System.out.println("==DOWN OUT"+i);
        }   
    }
    
}
