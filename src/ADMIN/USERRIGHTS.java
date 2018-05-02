/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADMIN;

import DB.PAK_DB;
import static ADMIN.USERLOGINID.buildOneComboBoxModel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author DynamicSP
 */
public class USERRIGHTS extends javax.swing.JFrame {

    /**
     * Creates new form USERRIGHTS
     */
    public USERRIGHTS() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
           recoverypan.setBorder(BorderFactory.createTitledBorder("Recovery in Installment Rights:"));
           Salepan.setBorder(BorderFactory.createTitledBorder("Sales Page Rights(Sales, Issue and Adjustments):")); 
           purchsePan.setBorder(BorderFactory.createTitledBorder("Purchase Rights:")); 
           setFirstRole();
           setAllRoleGrants(roleCode.getText());
           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPasswordField1 = new javax.swing.JPasswordField();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        recoverypan = new javax.swing.JPanel();
        Salepan = new javax.swing.JPanel();
        disc = new javax.swing.JCheckBox();
        tax = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        purchsePan = new javax.swing.JPanel();
        discPur = new javax.swing.JCheckBox();
        fmrInSales = new javax.swing.JCheckBox();
        roleName = new javax.swing.JComboBox();
        roleCode = new javax.swing.JTextField();
        suppCat = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("User Rights");
        jLabel4.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jLabel5.setBackground(new java.awt.Color(0, 153, 153));
        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("http://dspak.com | https://ds-pak.com | https://facebook.com/dspak");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout recoverypanLayout = new javax.swing.GroupLayout(recoverypan);
        recoverypan.setLayout(recoverypanLayout);
        recoverypanLayout.setHorizontalGroup(
            recoverypanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );
        recoverypanLayout.setVerticalGroup(
            recoverypanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        disc.setText("101. Discount Before TO else After");
        disc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discActionPerformed(evt);
            }
        });

        tax.setText("102. Tax Before TO else After");
        tax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SalepanLayout = new javax.swing.GroupLayout(Salepan);
        Salepan.setLayout(SalepanLayout);
        SalepanLayout.setHorizontalGroup(
            SalepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalepanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SalepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(disc)
                    .addComponent(tax))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        SalepanLayout.setVerticalGroup(
            SalepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalepanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(disc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tax)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jButton1.setText("Update Rights");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        discPur.setText("201. Discount Before TO else After");
        discPur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discPurActionPerformed(evt);
            }
        });

        fmrInSales.setText("202. Fmr in Sales");
        fmrInSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmrInSalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout purchsePanLayout = new javax.swing.GroupLayout(purchsePan);
        purchsePan.setLayout(purchsePanLayout);
        purchsePanLayout.setHorizontalGroup(
            purchsePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purchsePanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(purchsePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(discPur)
                    .addComponent(fmrInSales))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        purchsePanLayout.setVerticalGroup(
            purchsePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purchsePanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(discPur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fmrInSales)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(purchsePan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(recoverypan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Salepan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Salepan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recoverypan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purchsePan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        roleName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleName.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                roleNamePopupMenuWillBecomeVisible(evt);
            }
        });
        roleName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleNameActionPerformed(evt);
            }
        });
        roleName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                roleNameKeyPressed(evt);
            }
        });

        roleCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleCodeActionPerformed(evt);
            }
        });
        roleCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                roleCodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                roleCodeKeyReleased(evt);
            }
        });

        suppCat.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        suppCat.setForeground(new java.awt.Color(0, 102, 102));
        suppCat.setText("User Roll");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(suppCat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roleCode, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roleName, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suppCat)
                    .addComponent(roleCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void discActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discActionPerformed

    private void taxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taxActionPerformed

    private void roleNamePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_roleNamePopupMenuWillBecomeVisible
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            roleName.setModel(buildAllComboBoxModel());
            if(setSelectedComboItem(roleCode,roleName,((!roleCode.getText().isEmpty())?data.find_role_name_by_code(conn, roleCode.getText()):""))){
            }else{
                roleCode.setText(getCode(roleName.getSelectedItem().toString()));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(USERRIGHTS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(USERRIGHTS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_roleNamePopupMenuWillBecomeVisible
    public boolean setSelectedComboItem(JTextField textField,JComboBox comboBox, String value)
    {
        boolean tf=false;
        String item;
        if(!value.isEmpty()){
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
    private void roleNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleNameActionPerformed
        System.out.println("postName.getSelectedItem().toString()"+roleName.getSelectedItem().toString());
        roleCode.setText(getCode(roleName.getSelectedItem().toString()));
        setAllRoleGrants(roleCode.getText());
    }//GEN-LAST:event_roleNameActionPerformed

    private void roleNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roleNameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_SPACE) {

        }

    }//GEN-LAST:event_roleNameKeyPressed

    private void roleCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleCodeActionPerformed

    private void roleCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roleCodeKeyPressed

    }//GEN-LAST:event_roleCodeKeyPressed

    private void roleCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roleCodeKeyReleased
        try {
            updateComboBox(roleCode, roleName);
        } catch (Exception ex) {
            Logger.getLogger(USERRIGHTS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_roleCodeKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            boolean b=false;
            for (int i = 100; i <=203 ; i++) {
                switch(i){
                 
                    case 101:
                        b=data.update_role_grant(conn,roleCode.getText(),"101",disc.isSelected(),"Discount Before TO else After");
                        break;
                    case 102:
                        b=data.update_role_grant(conn,roleCode.getText(),"102",tax.isSelected(),"Tax Before TO else After");
                        break;
                    case 201:
                        b=data.update_role_grant(conn,roleCode.getText(),"201",discPur.isSelected(),"Discount Before TO else After");
                        break;
                    case 202:
                        b=data.update_role_grant(conn,roleCode.getText(),"202",discPur.isSelected(),"Fmr in Sales");
                        break;
                }
            } 
            System.out.println("update_role_grant"+b);
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(USERRIGHTS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(USERRIGHTS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void discPurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discPurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discPurActionPerformed

    private void fmrInSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmrInSalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fmrInSalesActionPerformed

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
            java.util.logging.Logger.getLogger(USERRIGHTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(USERRIGHTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(USERRIGHTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(USERRIGHTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new USERRIGHTS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Salepan;
    private javax.swing.JCheckBox disc;
    private javax.swing.JCheckBox discPur;
    private javax.swing.JCheckBox fmrInSales;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel purchsePan;
    private javax.swing.JPanel recoverypan;
    private javax.swing.JTextField roleCode;
    private javax.swing.JComboBox roleName;
    private javax.swing.JLabel suppCat;
    private javax.swing.JCheckBox tax;
    // End of variables declaration//GEN-END:variables
    private void updateComboBox(JTextField textField,JComboBox comboBox) throws Exception {
        comboBox.setModel(buildOneComboBoxModel(textField.getText()));
    }
    public static DefaultComboBoxModel buildAllComboBoxModel() throws Exception {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        PAK_DB data =new PAK_DB();
        Connection conn;
        ArrayList<String> elements = new <String> ArrayList() ;
        try {
            conn = data.connect_database();
            boolean tf=false;

            elements=data.find_all_role_name_by_code(conn);
            if(elements!=null){    
                for(String s : elements){
                    comboBoxModel.addElement(s);
                }
            }else{
                JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "Not Edited", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
            System.out.println("Is Inserted :"+ tf);
            data.close_database(conn);
        } catch (SQLException ex) {
        }
        return comboBoxModel;
    }
    public static DefaultComboBoxModel buildOneComboBoxModel(String id) throws Exception {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        PAK_DB data =new PAK_DB();
        Connection conn;
        String element;
        try {
            conn = data.connect_database();
            if(!id.equals("")){
                element=data.find_role_name_by_code(conn,id);
                comboBoxModel.addElement(element);
            }else{
//                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
            }
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(USERRIGHTS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comboBoxModel;
    }

    private void styleComboBox(JComboBox combo) {
        combo.setRenderer(new DefaultListCellRenderer() {
        public void paint(Graphics g) {
            super.paint(g);
        }
    });
    }
    private void styleComboBoxNone(JComboBox combo) {
        combo.setRenderer(new DefaultListCellRenderer() {
        public void paint(Graphics g) {
        }
    });
    }

    private String getCode(String name) {
        String s="";
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            if(!name.equals("")){
                s=data.find_role_code_by_name(conn,name.trim());
            }else{
//                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
            }
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(USERRIGHTS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    private void setFirstRole() {
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            ArrayList<String> stock = data.get_first_role(conn);
            if(stock==null){
//                code.setText("");
//                Role.setText("");
                JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "No data Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }else{
                roleCode.setText(stock.get(0));
                try {
                    roleName.setModel(buildOneComboBoxModel(stock.get(0)));
                } catch (Exception ex) {
                    Logger.getLogger(USERLOGINID.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            data.close_database(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(USERRIGHTS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setAllRoleGrants(String role) {
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            ArrayList<String> name[] = data.search_role_grants(conn, role);
            for (int i = 0; i < name.length; i++) {
                System.out.println(""+i);
                System.out.println(", "+name[i].get(0));
                ArrayList<String> name1 = name[i];
                switch(Integer.parseInt(name1.get(0))){

                    case 101:
                        if((1==(name1.get(3).compareTo("y")))||(1==(name1.get(3).compareTo("Y")))){
                           disc.setSelected(true);
                        }else if((1==(name1.get(3).compareTo("n")))||(1==(name1.get(3).compareTo("N")))){
                           disc.setSelected(false);
                        }
                    break;
                    case 102:
                        if((1==(name1.get(3).compareTo("y")))||(1==(name1.get(3).compareTo("Y")))){
                           tax.setSelected(true);
                        }else if((1==(name1.get(3).compareTo("n")))||(1==(name1.get(3).compareTo("N")))){
                           tax.setSelected(false);
                        }
                    break;
                    case 201:
                        if((1==(name1.get(3).compareTo("y")))||(1==(name1.get(3).compareTo("Y")))){
                           discPur.setSelected(true);
                        }else if((1==(name1.get(3).compareTo("n")))||(1==(name1.get(3).compareTo("N")))){
                           discPur.setSelected(false);
                        }
                    case 202:
                        if((1==(name1.get(3).compareTo("y")))||(1==(name1.get(3).compareTo("Y")))){
                           fmrInSales.setSelected(true);
                        }else if((1==(name1.get(3).compareTo("n")))||(1==(name1.get(3).compareTo("N")))){
                           fmrInSales.setSelected(false);
                        }
                    break;
                }
            }
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(USERRIGHTS.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
}