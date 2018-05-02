/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.frames.recordUpdates;

import DB.PAK_UPDATEREC_DB;
import DB.PAK_DB;
import DB.PAK_GLOBAL_DB;
import DB.PAK_SALE_DB;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import logical.Conversions;
import logical.dateIncrementer;
import DynamicERP.frames.newdataentry.FIRMREC;
import static DynamicERP.frames.sales.PakSalesFieldPanel1.round;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Shan
 */
public class SAILPAID extends javax.swing.JFrame {

    Conversions c = new Conversions();

    /**
     * Creates new form NewJFrame
     */ PAK_GLOBAL_DB dataAA =new PAK_GLOBAL_DB();
    Connection connAA;
    /*
    try {
                connAA = dataAA.connect_database();
            
            }catch (SQLException e) {
                System.out.println("Exception ===> "+e);
            }
    */
    
    public SAILPAID() {
        initComponents();
        try {
            dlDate.setDate(c.getPresentDate());
        } catch (ParseException ex) {
            Logger.getLogger(SAILPAID.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
                connAA = dataAA.connect_database();
            
            }catch (SQLException e) {
                System.out.println("Exception ===> "+e);
            }  
        pan1.setBorder(BorderFactory.createTitledBorder("Panel"));
        jScrollPane1.setBorder(BorderFactory.createTitledBorder("Scroll Pane1"));
        
        String[][] s=new String[][]{{"0","0","0","0","0"}};
        initTable(s);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pan1 = new javax.swing.JPanel();
        dlDate = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        vanName = new javax.swing.JComboBox();
        vanCode = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dName = new javax.swing.JComboBox();
        dcode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(238, 100, 0, 0));

        jButton1.setText("Execute");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Date:");

        vanName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vanName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        vanName.setPreferredSize(new java.awt.Dimension(0, 25));
        vanName.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                vanNamePopupMenuWillBecomeVisible(evt);
            }
        });
        vanName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vanNameActionPerformed(evt);
            }
        });

        vanCode.setPreferredSize(new java.awt.Dimension(0, 25));
        vanCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vanCodeActionPerformed(evt);
            }
        });
        vanCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vanCodeKeyReleased(evt);
            }
        });

        jLabel12.setText("Van:");

        dName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dName.setPreferredSize(new java.awt.Dimension(0, 25));
        dName.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                dNamePopupMenuWillBecomeVisible(evt);
            }
        });
        dName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dNameActionPerformed(evt);
            }
        });

        dcode.setPreferredSize(new java.awt.Dimension(0, 25));
        dcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dcodeActionPerformed(evt);
            }
        });
        dcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dcodeKeyReleased(evt);
            }
        });

        jLabel11.setText("SalesMan:");

        jButton4.setText("Cash Auto Recieve");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pan1Layout = new javax.swing.GroupLayout(pan1);
        pan1.setLayout(pan1Layout);
        pan1Layout.setHorizontalGroup(
            pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan1Layout.createSequentialGroup()
                .addGroup(pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pan1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dName, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vanCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vanName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addGroup(pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pan1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dlDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pan1Layout.setVerticalGroup(
            pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan1Layout.createSequentialGroup()
                .addGroup(pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dlDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dcode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(0, 0, 0)
                .addGroup(pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(vanName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vanCode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)))
            .addGroup(pan1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)))
        );

        jScrollPane1.setName(""); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CustCode", "Date", "Desc", "Debit", "Credit", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cash & Credit Entries");
        jLabel4.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(pan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DynamicERP.dialoge.newdataentry.dialogeClass.disposeCashCreditWin();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PAK_UPDATEREC_DB data = new PAK_UPDATEREC_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            String[][] r = null;try {
                r = data.search_sailPaid(conn, dcode.getText(), c.toDateString(dateIncrementer.addDays(dlDate.getDate(), 0).toString()),vanCode.getText());
            } catch (ParseException ex) {
                Logger.getLogger(SAILPAID.class.getName()).log(Level.SEVERE, null, ex);
            }if (r == null) {
                JOptionPane.showMessageDialog(null, "No Row Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            } else {initTable(r);}data.close_database(conn);
        } catch (SQLException ex) {Logger.getLogger(SAILPAID.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void vanNamePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_vanNamePopupMenuWillBecomeVisible
        PAK_SALE_DB data =new PAK_SALE_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            vanName.setModel(buildAllComboBoxModel("van"));
            if(setSelectedComboItem(vanCode,vanName,((!vanCode.getText().isEmpty())?data.find_van_name_by_code(conn, vanCode.getText()):""))){

            }else{
                vanCode.setText(getCode(vanName.getSelectedItem().toString(),"van"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SAILPAID.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SAILPAID.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_vanNamePopupMenuWillBecomeVisible

    private void vanNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vanNameActionPerformed
        // TODO add your handling code here:
        vanCode.setText(getCode(vanName.getSelectedItem().toString(),"van"));
    }//GEN-LAST:event_vanNameActionPerformed

    private void vanCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vanCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vanCodeActionPerformed

    private void vanCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vanCodeKeyReleased
        try {
            updateComboBox(vanCode, vanName,"van");
        } catch (Exception ex) {
            Logger.getLogger(SAILPAID.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_vanCodeKeyReleased

    private void dNamePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_dNamePopupMenuWillBecomeVisible
        PAK_SALE_DB data =new PAK_SALE_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            dName.setModel(buildAllComboBoxModel("sm"));
            if(setSelectedComboItem(dcode,dName,((!dcode.getText().isEmpty())?data.find_sm_name_by_code(conn, dcode.getText()):""))){

            }else{
                dcode.setText(getCode(dName.getSelectedItem().toString(),"sm"));
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SAILPAID.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SAILPAID.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dNamePopupMenuWillBecomeVisible

    private void dNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dNameActionPerformed
        //System.out.println("dName.getSelectedItem().toString()"+dName.getSelectedItem().toString());
        dcode.setText(getCode(dName.getSelectedItem().toString(),"sm"));
    }//GEN-LAST:event_dNameActionPerformed

    private void dcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dcodeActionPerformed

    private void dcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcodeKeyReleased
        try {
            updateComboBox(dcode, dName,"sm");
        } catch (Exception ex) {
            Logger.getLogger(SAILPAID.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dcodeKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String[][] rowData = new String[jTable1.getRowCount()][jTable1.getColumnCount()];
        for (int j = 0; j < jTable1.getRowCount(); j++) {
            for (int i = 0; i < jTable1.getColumnCount(); i++) {
                rowData[j][i] = (String) jTable1.getValueAt(j, i);
            }
        }
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            System.out.println(rowData[i][0]+" , "+rowData[i][1]+" , "+rowData[i][2]+" , "+rowData[i][3]+" , "+rowData[i][4]);
            PAK_UPDATEREC_DB data = new PAK_UPDATEREC_DB();
            Connection conn;
            try {
                conn = data.connect_database();
                data.update_cust_ledger(conn, rowData[i][0], rowData[i][4]);
                data.close_database(conn);
            } catch (SQLException ex) {
                Logger.getLogger(SAILPAID.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String[][] g = new String[jTable1.getRowCount()][jTable1.getColumnCount()];
        for (int j = 0; j < jTable1.getRowCount(); j++) {
            for (int i = 0; i < jTable1.getColumnCount(); i++) {
                g[j][i] = (String) jTable1.getValueAt(j, i);
            }
        }
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            jTable1.setValueAt(g[i][3], i, 4);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(SAILPAID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SAILPAID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SAILPAID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SAILPAID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SAILPAID().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox dName;
    private javax.swing.JTextField dcode;
    private com.toedter.calendar.JDateChooser dlDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pan1;
    private javax.swing.JTextField vanCode;
    private javax.swing.JComboBox vanName;
    // End of variables declaration//GEN-END:variables

    // Start of my variables declaration                   
    DefaultTableModel model;
    Vector originalTableModel;
    ListSelectionModel selectionModel;
    // End of my variables declaration                   

    private void initTable(String[][] rowData) {
        String col[] = { "Doc. #", "Cust Code", "Name", "Net Payable", "Paid"};
        String row[][] = rowData;
        if(!rowData.equals(null)){
//            for (int rowT = 0; rowT < row.length; rowT++) {
//                for (int colT = 0; colT < row[0].length; colT++) {
//                    if (colT == 4) {
//                        d = d.add(new BigDecimal(Float.parseFloat(row[rowT][colT])));
//                    } else if (colT == 5) {
//                        c = c.add(new BigDecimal(Float.parseFloat(row[rowT][colT])));
//                    }
//                }
//            }
            model = new DefaultTableModel(row, col);

        jTable1=new JTable(model){private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int col) {switch (col) {case 0:case 1:case 2:case 3:return false;default:return true;}}};
            jTable1.getAutoscrolls();
            jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            jTable1.setBackground(Color.WHITE);
            jTable1.setRowHeight(20);
            jTable1.setShowHorizontalLines(false);
            jTable1.setEnabled(true);
            jTable1.setBackground(Color.darkGray);
            jTable1.setForeground(Color.white);
            jTable1.enableInputMethods(false);
            jTable1.setShowVerticalLines(false);
            jTable1.setShowGrid(false);
            jTable1.setRowSelectionAllowed(true);

            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
            selectionModel = jTable1.getSelectionModel();
            selectionModel.setSelectionInterval(0, 0);

            jScrollPane1.setViewportView(jTable1);
        }
    }
    private void updateComboBox(JTextField textField,JComboBox comboBox,String c) throws Exception {
        comboBox.setModel(buildOneComboBoxModel(textField.getText(),c));
    }
    public static DefaultComboBoxModel buildAllComboBoxModel(String c) throws Exception {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        PAK_SALE_DB data =new PAK_SALE_DB();
        Connection conn;
        ArrayList<String> elements = new <String> ArrayList() ;
        try {
            conn = data.connect_database();
            boolean tf=false;
             switch (c) {
                case "sm":
                    elements=data.find_all_sm_name_by_code(conn);
                    break;
                case "supp":
                    elements=data.find_all_supp_name_by_code(conn);
                    break;
                case "van":
                    elements=data.find_all_van_name_by_code(conn);
                    break;
            }if(elements!=null){    
                for(String s : elements){
                    comboBoxModel.addElement(s);
                }
            }else{
                JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "Not Edited", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
            ////System.out.println("Is Inserted :"+ tf);
            
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SAILPAID.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comboBoxModel;
    }
    public DefaultComboBoxModel buildOneComboBoxModel(String name,String c) throws Exception {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        PAK_SALE_DB data =new PAK_SALE_DB();
        Connection conn;
        String s="*** NOT SELECTED ***";
        try {
            conn = data.connect_database();
            switch (c) {
                    case "sm":
                        if(!name.equals("")){
                            s=data.find_sm_name_by_code(conn,name);
                            
                        }else{
                            comboBoxModel.addElement(name);
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                    case "supp":
                        if(!name.equals("")){
                            s=data.find_supp_name_by_code(conn,name);
                        }else{
                            comboBoxModel.addElement(name);
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                    case "van":
                        if(!name.equals("")){
                            s=data.find_van_name_by_code(conn,name);
                        }else{
                            comboBoxModel.addElement(name);
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                }
            comboBoxModel.addElement(s);
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SAILPAID.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comboBoxModel;
    }

    private String getCode(String name,String c) {
        String s="";
        PAK_SALE_DB data =new PAK_SALE_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            
            switch (c) {
                    case "sm":
                        if(!name.equals("")){
                            s=data.find_sm_code_by_name(conn,name.trim());
                        }else{
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                    case "supp":
                        if(!name.equals("")){
                            s=data.find_supp_code_by_name(conn,name.trim());
                        }else{
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                    case "van":
                        if(!name.equals("")){
                            s=data.find_van_code_by_name(conn,name.trim());
                        }else{
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                }  
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SAILPAID.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
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
                    //System.out.println(">>>> Message: Item is empty. . . ");
                    JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "First Add Items in : "+comboBox.getName(), "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                }
            }   
        }else{
            //System.out.println(">>>> Message: Value could not be  Selected . . . ");
            comboBox.setSelectedIndex(0);
        }
        return tf;
    }
}
