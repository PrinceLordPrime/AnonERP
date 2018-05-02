/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.REPORTPARAMETER;

import DB.PAK_DB;
import DB.PAK_GLOBAL_DB;
import static DynamicERP.dialoge.viewforms.dialogeClass.createJasperView;
import DynamicERP.frames.newdataentry.FIRMREC;
import DynamicERP.frames.relationalforms.CUSTREC;
import DynamicERP.frames.relationalforms.EMPREC;
import static DynamicERP.frames.relationalforms.PRODUCTREC.buildAllComboBoxModel;
import static DynamicERP.frames.relationalforms.PRODUCTREC.buildOneComboBoxModel;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logical.Conversions;
import logical.dateIncrementer;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author DynamicSP
 */
public class ExpiryTill extends javax.swing.JFrame {

    /**
     * Creates new form ExpiryTill
     */
        Conversions c = new Conversions();

    PAK_GLOBAL_DB dataAA =new PAK_GLOBAL_DB();
    Connection connAA;
    
    ArrayList<String> MM=new ArrayList<String>();
    Conversions f=new Conversions(); 
   
    public ExpiryTill() {
        initComponents();
        
                 try {
                connAA = dataAA.connect_database();
            
            }catch (SQLException e) {
                System.out.println("Exception ===> "+e);
            }
         parameterpan.setBorder(BorderFactory.createTitledBorder("Select Parameter From Here:"));
         reppan.setBorder(BorderFactory.createTitledBorder("Execute Expired Stock Report:"));
         useablepan.setBorder(BorderFactory.createTitledBorder("Execute Useable stock Report:"));
         

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        reppan = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        exit_rep = new javax.swing.JCheckBox();
        parameterpan = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        company = new javax.swing.JTextField();
        companyname = new javax.swing.JComboBox();
        expiry = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        useablepan = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(200, 200, 0, 0));
        setMinimumSize(new java.awt.Dimension(450, 370));
        setPreferredSize(new java.awt.Dimension(450, 257));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel12.setBackground(new java.awt.Color(0, 102, 102));
        jLabel12.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Stock Report Parameter");
        jLabel12.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 270));

        jButton3.setText("Company & Expiry Wise");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("All ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        exit_rep.setText("Exit After Report Execution");
        exit_rep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_repActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reppanLayout = new javax.swing.GroupLayout(reppan);
        reppan.setLayout(reppanLayout);
        reppanLayout.setHorizontalGroup(
            reppanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reppanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reppanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exit_rep)
                    .addGroup(reppanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        reppanLayout.setVerticalGroup(
            reppanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reppanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit_rep)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Company: ");

        company.setBackground(new java.awt.Color(153, 204, 255));
        company.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        company.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        company.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                companyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                companyKeyReleased(evt);
            }
        });

        companyname.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        companyname.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        companyname.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                companynamePopupMenuWillBecomeVisible(evt);
            }
        });
        companyname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companynameActionPerformed(evt);
            }
        });

        expiry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                expiryKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Expiry Date:");

        javax.swing.GroupLayout parameterpanLayout = new javax.swing.GroupLayout(parameterpan);
        parameterpan.setLayout(parameterpanLayout);
        parameterpanLayout.setHorizontalGroup(
            parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parameterpanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(parameterpanLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(expiry, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(parameterpanLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(company, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(companyname, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        parameterpanLayout.setVerticalGroup(
            parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parameterpanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(company, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(expiry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setText("All Companies");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Company & Expiry Wise");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout useablepanLayout = new javax.swing.GroupLayout(useablepan);
        useablepan.setLayout(useablepanLayout);
        useablepanLayout.setHorizontalGroup(
            useablepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(useablepanLayout.createSequentialGroup()
                .addGroup(useablepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        useablepanLayout.setVerticalGroup(
            useablepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(useablepanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(parameterpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(reppan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(useablepan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(parameterpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reppan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(useablepan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void companynamePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_companynamePopupMenuWillBecomeVisible
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            companyname.setModel(buildAllComboBoxModel("com"));
            if(setSelectedComboItem(company,companyname,((!company.getText().isEmpty())?data.find_com_name_by_code(conn, company.getText()):""))){

            }else{
                company.setText(getCode(companyname.getSelectedItem().toString(),"com"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CUSTREC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CUSTREC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_companynamePopupMenuWillBecomeVisible

    private void companynameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companynameActionPerformed
        System.out.println("compName.getSelectedItem().toString()"+companyname.getSelectedItem().toString());
        company.setText(getCode(companyname.getSelectedItem().toString(),"com"));
    }//GEN-LAST:event_companynameActionPerformed

    private void companyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_companyKeyPressed

    }//GEN-LAST:event_companyKeyPressed

    private void companyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_companyKeyReleased
        try {
            updateComboBox(company, companyname,"com");
        } catch (Exception ex) {
            Logger.getLogger(EMPREC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_companyKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            try {
            String s= "D:\\DynamicERP\\DSP001\\expiredStockAll.jasper";
                    Map parametersMap = new HashMap();
            parametersMap.put("expirydate",c.toDateString(dateIncrementer.addDays(expiry.getDate(), 0).toString()));
            
       JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, parametersMap, connAA);
        JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
                {
        if(exit_rep.isSelected()) {
        DynamicERP.dialoge.newdataentry.dialogeClass.disposeExpiryTillWin();
        } else {}}
            createJasperView(jasperViewer);
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }

 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   DynamicERP.dialoge.newdataentry.dialogeClass.disposeExpiryTillWin();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void exit_repActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_repActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exit_repActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            try {
            String s= "D:\\DynamicERP\\DSP001\\expiredStkComp.jasper";
                    Map parametersMap = new HashMap();
            parametersMap.put("expirydate",c.toDateString(dateIncrementer.addDays(expiry.getDate(), 0).toString()));
            parametersMap.put("Company",Integer.parseInt(company.getText()));
            
       JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, parametersMap, connAA);
        JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
                {
        if(exit_rep.isSelected()) {
        DynamicERP.dialoge.newdataentry.dialogeClass.disposeExpiryTillWin();
        } else {}}
            createJasperView(jasperViewer);
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void expiryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expiryKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_expiryKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            try {
            String s= "D:\\DynamicERP\\DSP001\\stockrepuseable.jasper";
                    Map parametersMap = new HashMap();
            parametersMap.put("expirydate",c.toDateString(dateIncrementer.addDays(expiry.getDate(), 0).toString()));
            
       JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, parametersMap, connAA);
        JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
                {
        if(exit_rep.isSelected()) {
        DynamicERP.dialoge.newdataentry.dialogeClass.disposeExpiryTillWin();
        } else {}}
            createJasperView(jasperViewer);
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            try {
            String s= "D:\\DynamicERP\\DSP001\\stockrepuseableComp.jasper";
                    Map parametersMap = new HashMap();
            parametersMap.put("expirydate",c.toDateString(dateIncrementer.addDays(expiry.getDate(), 0).toString()));
            parametersMap.put("Company",Integer.parseInt(company.getText()));
            
       JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, parametersMap, connAA);
        JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
                {
        if(exit_rep.isSelected()) {
        DynamicERP.dialoge.newdataentry.dialogeClass.disposeExpiryTillWin();
        } else {}}
            createJasperView(jasperViewer);
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExpiryTill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpiryTill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpiryTill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpiryTill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpiryTill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField company;
    private javax.swing.JComboBox companyname;
    private javax.swing.JCheckBox exit_rep;
    private com.toedter.calendar.JDateChooser expiry;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel parameterpan;
    private javax.swing.JPanel reppan;
    private javax.swing.JPanel useablepan;
    // End of variables declaration//GEN-END:variables

    private String getCode(String name,String c) {
        String s="";
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
              switch (c) {
                    case "loc":
                        if(!name.equals("")){
                            s=data.find_loc_code_by_name(conn,name.trim());
                        }else{
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                    case "cat":
                        if(!name.equals("")){
                            s=data.find_cat_code_by_name(conn,name.trim());
                        }else{
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                    case "com":
                        if(!name.equals("")){
                            s=data.find_com_code_by_name(conn,name.trim());
                        }else{
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                    case "sttype":
                        if(!name.equals("")){
                            s=data.find_st_type_code_by_name(conn,name.trim());
                        }else{
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                    case "line":
                        if(!name.equals("")){
                            s=data.find_subCat_code_by_name(conn,name.trim());
                        }else{
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                }
            
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(FIRMREC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
     public boolean setSelectedComboItem(JTextField textField,JComboBox comboBox, String value)    {
        boolean tf=false;
        String item;
        if(value!=null){
            for (int i = 0; i < comboBox.getItemCount(); i++)
            {
                item = (String)comboBox.getItemAt(i);
                if (!item.isEmpty())
                {
                    if (item.equals(value))
                    {
                        comboBox.setSelectedIndex(i);
                        tf=true;
                        break;
                    }
                }else{
                    System.out.println(">>>> Message: Item is empty. . . ");
                    JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "First Add Items in : "+comboBox.getName(), "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                }
            }   
        }else{
            System.out.println(">>>> Message: Value could not be  Selected . . . ");
            comboBox.setSelectedIndex(0);
        }
        return tf;
    }
     private void updateComboBox(JTextField textField,JComboBox comboBox,String c) throws Exception {
        comboBox.setModel(buildOneComboBoxModel(textField.getText(),c));
    }


}
