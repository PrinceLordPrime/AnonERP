/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADMIN;

import DynamicERP.dialoge.newdataentry.dialogeClass;
import DynamicERP.frames.mainpkg.MAIN;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

/**
 *
 * @author DynamicSP
 */
public class ADMINPAGE extends javax.swing.JFrame {

    /**
     * Creates new form ADMIN
     */
    public ADMINPAGE() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
         
        Tabbed_Menu.setBorder(BorderFactory.createTitledBorder(""));
        displaypan.setBorder(BorderFactory.createTitledBorder(""));
         //-----------------text bottom code----------------------
        roleAccess.setHorizontalTextPosition(AbstractButton.CENTER);
        roleAccess.setVerticalTextPosition(AbstractButton.BOTTOM);
        userID.setHorizontalTextPosition(AbstractButton.CENTER);
        userID.setVerticalTextPosition(AbstractButton.BOTTOM);
        userRole.setHorizontalTextPosition(AbstractButton.CENTER);
        userRole.setVerticalTextPosition(AbstractButton.BOTTOM);
        
         //-----------------text bottom code End----------------------
       
    }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displaypan = new javax.swing.JPanel();
        Tabbed_Menu = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        roleAccess = new javax.swing.JLabel();
        userRole = new javax.swing.JLabel();
        userID = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout displaypanLayout = new javax.swing.GroupLayout(displaypan);
        displaypan.setLayout(displaypanLayout);
        displaypanLayout.setHorizontalGroup(
            displaypanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        displaypanLayout.setVerticalGroup(
            displaypanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        roleAccess.setForeground(new java.awt.Color(255, 255, 255));
        roleAccess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roleAccess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/lmsmal.png"))); // NOI18N
        roleAccess.setText("Role Access");
        roleAccess.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        roleAccess.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        roleAccess.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        roleAccess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roleAccessMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                roleAccessMouseEntered(evt);
            }
        });

        userRole.setForeground(new java.awt.Color(255, 255, 255));
        userRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/lmsmal.png"))); // NOI18N
        userRole.setText("User Role");
        userRole.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        userRole.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userRole.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        userRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userRoleMouseClicked(evt);
            }
        });

        userID.setForeground(new java.awt.Color(255, 255, 255));
        userID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/lmsmal.png"))); // NOI18N
        userID.setText("User ID");
        userID.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        userID.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userID.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        userID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userIDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userRole, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roleAccess, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(380, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userRole, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roleAccess, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        Tabbed_Menu.addTab("User Control", jPanel2);

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Will Be updated Soooooooooooooooooooooooooooon");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel1)
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(47, 47, 47))
        );

        Tabbed_Menu.addTab("Tools", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displaypan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Tabbed_Menu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Tabbed_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displaypan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roleAccessMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roleAccessMouseEntered
             // TODO add your handling code here:
    }//GEN-LAST:event_roleAccessMouseEntered

    private void userRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userRoleMouseClicked
        
        try {
            dialogeClass.createRoleWin();
        } catch (Exception ex) {  
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
            
        }     }//GEN-LAST:event_userRoleMouseClicked

    private void userIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userIDMouseClicked
        
        try {
            dialogeClass.createUserIDWin();
        } catch (Exception ex) {  
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }//GEN-LAST:event_userIDMouseClicked

    private void roleAccessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roleAccessMouseClicked
        USERRIGHTS ad = new USERRIGHTS();
        ad.setVisible(true);
    }//GEN-LAST:event_roleAccessMouseClicked

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
            java.util.logging.Logger.getLogger(ADMINPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADMINPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADMINPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADMINPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new ADMINPAGE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabbed_Menu;
    private javax.swing.JPanel displaypan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel roleAccess;
    private javax.swing.JLabel userID;
    private javax.swing.JLabel userRole;
    // End of variables declaration//GEN-END:variables
}
