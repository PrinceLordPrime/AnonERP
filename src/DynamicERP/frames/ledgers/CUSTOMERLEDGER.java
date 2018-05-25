/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.frames.ledgers;

import DB.PAK_CUSTLEG_DB;
import DB.PAK_DB;
import DB.PAK_GLOBAL_DB;
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
public class CUSTOMERLEDGER extends javax.swing.JFrame {

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
    
    public CUSTOMERLEDGER() {
        initComponents();
        try {
            cdate.setDate(c.getPresentDate());
            odate.setDate(c.getPresentDate());
        } catch (ParseException ex) {
            Logger.getLogger(CUSTOMERLEDGER.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
                connAA = dataAA.connect_database();
            
            }catch (SQLException e) {
                System.out.println("Exception ===> "+e);
            }  
        jpanspecifications.setBorder(BorderFactory.createTitledBorder("Specifation Panel For Customer Ledgers:"));
        jpansummery.setBorder(BorderFactory.createTitledBorder("Summary For Selective Customers As Per Spacifications:"));
        jScrollPane1.setBorder(BorderFactory.createTitledBorder("Statements"));
        
        String[][] s=new String[][]{{"0","0","0","0","0","0","0"}};
        initTable(s);
        
        PAK_DB data = new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            custR.setModel(buildAllComboBoxModel());
            if(setSelectedComboItem(custCode,custR,((!custCode.getText().isEmpty())?data.find_cust_name_by_code(conn, custCode.getText()):""))){

            }else{
                custCode.setText(getCode(custR.getSelectedItem().toString()));
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CUSTOMERLEDGER.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CUSTOMERLEDGER.class.getName()).log(Level.SEVERE, null, ex);
        }
        custCode.requestFocus();
        custCode.selectAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanspecifications = new javax.swing.JPanel();
        odate = new com.toedter.calendar.JDateChooser();
        cdate = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        custCode = new javax.swing.JTextField();
        custR = new javax.swing.JComboBox();
        add = new javax.swing.JTextField();
        cell = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jpansummery = new javax.swing.JPanel();
        clbal = new javax.swing.JTextField();
        oppbal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totDebit = new javax.swing.JTextField();
        totCredit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(238, 100, 0, 0));

        jButton1.setText("Execute");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        custCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custCodeActionPerformed(evt);
            }
        });
        custCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                custCodeKeyReleased(evt);
            }
        });

        custR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        custR.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                custRPopupMenuWillBecomeVisible(evt);
            }
        });
        custR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custRActionPerformed(evt);
            }
        });

        add.setEditable(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        cell.setEditable(false);

        jLabel3.setText("Contact:");

        jLabel2.setText("Address:");

        jLabel7.setText("Customer:");

        jLabel8.setText("From Date:");

        jLabel5.setText("To Date:");

        jButton3.setText("Prnt");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanspecificationsLayout = new javax.swing.GroupLayout(jpanspecifications);
        jpanspecifications.setLayout(jpanspecificationsLayout);
        jpanspecificationsLayout.setHorizontalGroup(
            jpanspecificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanspecificationsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanspecificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanspecificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanspecificationsLayout.createSequentialGroup()
                        .addComponent(custCode, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(custR, 0, 421, Short.MAX_VALUE))
                    .addComponent(add)
                    .addComponent(cell))
                .addGap(18, 18, 18)
                .addGroup(jpanspecificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanspecificationsLayout.createSequentialGroup()
                        .addGroup(jpanspecificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanspecificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cdate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(odate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpanspecificationsLayout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpanspecificationsLayout.setVerticalGroup(
            jpanspecificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanspecificationsLayout.createSequentialGroup()
                .addGroup(jpanspecificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanspecificationsLayout.createSequentialGroup()
                        .addGroup(jpanspecificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(odate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, 0)
                        .addGroup(jpanspecificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpanspecificationsLayout.createSequentialGroup()
                        .addGroup(jpanspecificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(custR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(custCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, 0)
                        .addGroup(jpanspecificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(1, 1, 1)
                        .addGroup(jpanspecificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanspecificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)
                                .addComponent(jButton3))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(0, 0, 0))
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
        jLabel4.setText("Customer's Ledger");
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

        clbal.setEditable(false);
        clbal.setText("0.0");

        oppbal.setEditable(false);
        oppbal.setText("0.0");
        oppbal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oppbalActionPerformed(evt);
            }
        });

        jLabel6.setText("Closing Balance");

        jLabel9.setText("Opening Balance");

        totDebit.setEditable(false);
        totDebit.setText("0.0");
        totDebit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totDebitActionPerformed(evt);
            }
        });

        totCredit.setEditable(false);
        totCredit.setText("0.0");

        jLabel10.setText("Total Credit");

        jLabel11.setText("Total Debit");

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpansummeryLayout = new javax.swing.GroupLayout(jpansummery);
        jpansummery.setLayout(jpansummeryLayout);
        jpansummeryLayout.setHorizontalGroup(
            jpansummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpansummeryLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpansummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpansummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clbal, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(oppbal))
                .addGap(83, 83, 83)
                .addGroup(jpansummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpansummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totCredit)
                    .addComponent(totDebit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jpansummeryLayout.setVerticalGroup(
            jpansummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpansummeryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpansummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpansummeryLayout.createSequentialGroup()
                        .addGroup(jpansummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(totDebit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpansummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jpansummeryLayout.createSequentialGroup()
                        .addGroup(jpansummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(oppbal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpansummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clbal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jpansummery, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanspecifications, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanspecifications, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpansummery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void oppbalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oppbalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oppbalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PAK_CUSTLEG_DB data = new PAK_CUSTLEG_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            String[][] r = null;
            String opngBal = "";
            try {
                opngBal = data.get_sum_opngBal(conn, custCode.getText(), c.toDateString(dateIncrementer.addDays(odate.getDate(), 0).toString()));
                oppbal.setText(opngBal);
                r = data.search_custleg(conn, custCode.getText(), c.toDateString(dateIncrementer.addDays(odate.getDate(), 0).toString()), c.toDateString(dateIncrementer.addDays(cdate.getDate(), 0).toString()),oppbal.getText());
            } catch (ParseException ex) {
                Logger.getLogger(CUSTOMERLEDGER.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (r == null) { 
                JOptionPane.showMessageDialog(null, "No Row Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            } else {
                initTable(r);
            }
            clbal.setText(round(((new BigDecimal(oppbal.getText()).add(new BigDecimal(totDebit.getText()))).subtract(new BigDecimal(totCredit.getText()))),3)+"");
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(CUSTOMERLEDGER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void custCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custCodeActionPerformed

    private void custCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_custCodeKeyReleased
        try {
            updateComboBox(custCode, custR);
        } catch (Exception ex) {
            Logger.getLogger(CUSTOMERLEDGER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_custCodeKeyReleased

    private void custRPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_custRPopupMenuWillBecomeVisible
        PAK_DB data = new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            custR.setModel(buildAllComboBoxModel());
            if(setSelectedComboItem(custCode,custR,((!custCode.getText().isEmpty())?data.find_cust_name_by_code(conn, custCode.getText()):""))){

            }else{
                custCode.setText(getCode(custR.getSelectedItem().toString()));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CUSTOMERLEDGER.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CUSTOMERLEDGER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_custRPopupMenuWillBecomeVisible

    private void custRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custRActionPerformed
        System.out.println("sm2C.getSelectedItem().toString()"+custR.getSelectedItem().toString());
        custCode.setText(getCode(custR.getSelectedItem().toString()));
    }//GEN-LAST:event_custRActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void totDebitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totDebitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totDebitActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        DynamicERP.dialoge.newdataentry.dialogeClass.disposeCustLegWin();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            tryExecute();
            String s= "D:\\Oracle DMS software\\MarblePRO\\src\\MarblePRO\\reports\\legers\\legers.jrxml";
            Map parametersMap = new HashMap();
            parametersMap.put("get_d_date",c.toDateString(dateIncrementer.addDays(odate.getDate(), 0).toString()));
            parametersMap.put("get_c_date",c.toDateString(dateIncrementer.addDays(cdate.getDate(), 0).toString()));
            parametersMap.put("get_cust_code",Integer.parseInt(custCode.getText()));
            parametersMap.put("op_bal",new Double(oppbal.getText()));
            parametersMap.put("cl_bal",new Double(clbal.getText()));
            JasperReport jr = JasperCompileManager.compileReport(s);
            JasperPrint print = JasperFillManager.fillReport(jr,parametersMap,connAA);
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(CUSTOMERLEDGER.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CUSTOMERLEDGER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(CUSTOMERLEDGER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CUSTOMERLEDGER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CUSTOMERLEDGER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CUSTOMERLEDGER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CUSTOMERLEDGER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField add;
    private com.toedter.calendar.JDateChooser cdate;
    private javax.swing.JTextField cell;
    private javax.swing.JTextField clbal;
    private javax.swing.JTextField custCode;
    private javax.swing.JComboBox custR;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpanspecifications;
    private javax.swing.JPanel jpansummery;
    private com.toedter.calendar.JDateChooser odate;
    private javax.swing.JTextField oppbal;
    private javax.swing.JTextField totCredit;
    private javax.swing.JTextField totDebit;
    // End of variables declaration//GEN-END:variables

    // Start of my variables declaration                   
    DefaultTableModel model;
    Vector originalTableModel;
    ListSelectionModel selectionModel;
    // End of my variables declaration                   

    private void initTable(String[][] rowData) {
        String col[] = {"Sr. #", "Doc. #", "Date", "Desc", "Debit", "Credit", "Balance"};
        String row[][] = rowData;
        System.out.println("Row: " + row.length);
        System.out.println("Cells count: " + row.length * row[0].length);
        System.out.println("Colums: " + row[0].length);
       //  4 = Debit
        //  5 = Credit
        BigDecimal d = new BigDecimal("0.0");
        BigDecimal c = new BigDecimal("0.0");;

        for (int rowT = 0; rowT < row.length; rowT++) {
            for (int colT = 0; colT < row[0].length; colT++) {
                if (colT == 4) {
                    d = d.add(new BigDecimal(Float.parseFloat(row[rowT][colT])));
                } else if (colT == 5) {
                    c = c.add(new BigDecimal(Float.parseFloat(row[rowT][colT])));
                }
            }
        }
        totDebit.setText(round(d,3) + "");
        totCredit.setText(round(c,3) + "");
        model = new DefaultTableModel(row, col);

        jTable1 = new JTable(model) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        ;
        };
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

        selectionModel = jTable1.getSelectionModel();
        selectionModel.setSelectionInterval(0, 0);

        jScrollPane1.setViewportView(jTable1);
    }
    public boolean setSelectedComboItem(JTextField textField,JComboBox comboBox, String value)
    {
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
    private String getCode(String name) {
        String s="";
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            if(!name.equals("")){
                s=data.find_cust_rec_add_by_name(conn,name.trim());
                add.setText(s);
                s=data.find_cust_rec_cell_by_name(conn,name.trim());
                cell.setText(s);
                s=data.find_cust_rec_code_by_name(conn,name.trim());
            }else{
            } 
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(FIRMREC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    private void updateComboBox(JTextField textField,JComboBox comboBox) throws Exception {
        comboBox.setModel(buildOneComboBoxModel(textField.getText()));
    }
    public static DefaultComboBoxModel buildAllComboBoxModel() throws Exception {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        PAK_DB data =new PAK_DB();
        Connection conn;
        ArrayList<String> elements = new <String> ArrayList() ;
        conn = data.connect_database();
        boolean tf=false;
        elements=data.find_all_cust_rec_name_by_code(conn);
        for (String element : elements) {
            comboBoxModel.addElement(element);
        }
        System.out.println("Is Inserted :"+ tf);
        data.close_database(conn);
        return comboBoxModel;
    }
     public DefaultComboBoxModel buildOneComboBoxModel(String id) throws Exception {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        PAK_DB data =new PAK_DB();
        Connection conn;
        String element=null;
        conn = data.connect_database();
        if(!id.equals("")){
            element=data.find_cust_rec_name_by_code(conn,id);
            comboBoxModel.addElement(element);
            System.out.println("Add 2");
            element=data.find_cust_rec_add_by_code(conn,id);
            add.setText(element);
            element=data.find_cust_rec_cell_by_code(conn,id);
            System.out.println("cell 2");
            cell.setText(element);
        }
        data.close_database(conn);
        return comboBoxModel;
    }

    private void styleComboBox(JComboBox combo) {
       combo.setRenderer(new DefaultListCellRenderer() {
           public void paint(Graphics g) {
               super.paint(g);
           }
       });
    }

    private void tryExecute() {
        jButton1.doClick();
    }
}
