/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shan
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JTable t = new MyTable();
        String col[] = {"Seq#","PCode","BCode","ProductName","PurPCS","PurCTN","PurQTY","PurDMG","PurRate","GrossAmount","Disc%","DiscRS","Tax%","TaxRS","TOPcs","UCHRS","SCHRS","FMR%","FMRRS","TaxRS","Expiry","Batch","NetAmount"};
        String row[][] =new String[][]{{"Seq#","PCode","BCode","ProductName","PurPCS","PurCTN","PurQTY","PurDMG","PurRate","GrossAmount","Disc%","DiscRS","Tax%","TaxRS","TOPcs","UCHRS","SCHRS","FMR%","FMRRS","TaxRS","Expiry","Batch","NetAmount"},
                                       {"Seq#","PCode","BCode","ProductName","PurPCS","PurCTN","PurQTY","PurDMG","PurRate","GrossAmount","Disc%","DiscRS","Tax%","TaxRS","TOPcs","UCHRS","SCHRS","FMR%","FMRRS","TaxRS","Expiry","Batch","NetAmount"},
                                       {"Seq#","PCode","BCode","ProductName","PurPCS","PurCTN","PurQTY","PurDMG","PurRate","GrossAmount","Disc%","DiscRS","Tax%","TaxRS","TOPcs","UCHRS","SCHRS","FMR%","FMRRS","TaxRS","Expiry","Batch","NetAmount"},
                                       {"Seq#","PCode","BCode","ProductName","PurPCS","PurCTN","PurQTY","PurDMG","PurRate","GrossAmount","Disc%","DiscRS","Tax%","TaxRS","TOPcs","UCHRS","SCHRS","FMR%","FMRRS","TaxRS","Expiry","Batch","NetAmount"}};
        DefaultTableModel model = new DefaultTableModel(row,col);
        t.setModel(model);
        JFrame j=new JFrame();
        
        j.add(t);
        j.setExtendedState(JFrame.MAXIMIZED_BOTH);;
        j.setVisible(true);
        
    }
    
}
