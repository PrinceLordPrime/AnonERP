/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.REPORTPARAMETER;

import DB.PAK_DB;
import DB.PAK_GLOBAL_DB;
import DB.PAK_SALE_DB;
import static DynamicERP.dialoge.viewforms.dialogeClass.createJasperView;
import DynamicERP.frames.newdataentry.FIRMREC;
import DynamicERP.frames.relationalforms.CUSTREC;
import DynamicERP.frames.relationalforms.EMPREC;
import static DynamicERP.frames.relationalforms.EXPDEP.buildAllComboBoxModel;
import static DynamicERP.frames.relationalforms.EXPDEP.buildOneComboBoxModel;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
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
public class STKLoadSheet extends javax.swing.JFrame {

    /**
     * Creates new form ExpiryTill
     */
        Conversions c = new Conversions();
        Conversions dateField=new Conversions();//dateField.toReturnedDate(odDate.getDate()+"")  dateField.toDateString(odDate.getDate().toString()),
    dateIncrementer dateField1=new dateIncrementer();


    PAK_GLOBAL_DB dataAA =new PAK_GLOBAL_DB();
    Connection connAA;
    
    ArrayList<String> MM=new ArrayList<String>();
    Conversions f=new Conversions(); 
   
    public STKLoadSheet() {
        initComponents();
        
                 try {
                connAA = dataAA.connect_database();
            
            }catch (SQLException e) {
                System.out.println("Exception ===> "+e);
            }
         parameterpan.setBorder(BorderFactory.createTitledBorder("Select Parameter From Here:"));
         useablepan.setBorder(BorderFactory.createTitledBorder("Execute Reports:"));
            try {
                fromdate.setDate(dateField.getPresentDate());
                todate.setDate(dateField.getPresentDate());
            } catch (ParseException ex) {
                Logger.getLogger(STKLoadSheet.class.getName()).log(Level.SEVERE, null, ex);
            }
        smNameD.requestFocus();

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
        parameterpan = new javax.swing.JPanel();
        fromdate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        todate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        suppCat = new javax.swing.JLabel();
        smName = new javax.swing.JTextField();
        smNameD = new javax.swing.JComboBox();
        suppCat5 = new javax.swing.JLabel();
        vanCode = new javax.swing.JTextField();
        vanName = new javax.swing.JComboBox();
        useablepan = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        exit_rep = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(200, 200, 0, 0));
        setMinimumSize(new java.awt.Dimension(450, 450));
        setPreferredSize(new java.awt.Dimension(450, 450));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel12.setBackground(new java.awt.Color(0, 102, 102));
        jLabel12.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Load Sheet Parameter");
        jLabel12.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 400));

        fromdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fromdateKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("From:");

        todate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                todateKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("To Date:");

        suppCat.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        suppCat.setForeground(new java.awt.Color(0, 102, 102));
        suppCat.setText("Employee:");

        smName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smNameActionPerformed(evt);
            }
        });
        smName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                smNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                smNameKeyReleased(evt);
            }
        });

        smNameD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        smNameD.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                smNameDPopupMenuWillBecomeVisible(evt);
            }
        });
        smNameD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smNameDActionPerformed(evt);
            }
        });
        smNameD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                smNameDKeyPressed(evt);
            }
        });

        suppCat5.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        suppCat5.setForeground(new java.awt.Color(0, 102, 102));
        suppCat5.setText("Van:");

        vanCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vanCodeActionPerformed(evt);
            }
        });
        vanCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vanCodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vanCodeKeyReleased(evt);
            }
        });

        vanName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
        vanName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vanNameKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout parameterpanLayout = new javax.swing.GroupLayout(parameterpan);
        parameterpan.setLayout(parameterpanLayout);
        parameterpanLayout.setHorizontalGroup(
            parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parameterpanLayout.createSequentialGroup()
                .addGroup(parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parameterpanLayout.createSequentialGroup()
                        .addGroup(parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(parameterpanLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel4))
                            .addGroup(parameterpanLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(todate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fromdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(parameterpanLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(parameterpanLayout.createSequentialGroup()
                                .addComponent(suppCat5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vanCode, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(parameterpanLayout.createSequentialGroup()
                                .addComponent(suppCat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(smName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(smNameD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vanName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        parameterpanLayout.setVerticalGroup(
            parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parameterpanLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(fromdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(todate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(smNameD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(smName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppCat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(parameterpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(suppCat5)
                    .addComponent(vanCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vanName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        exit_rep.setText("Exit After Report Execution");
        exit_rep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_repActionPerformed(evt);
            }
        });

        jButton5.setText("Date Wise");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Saleman & Date Wise");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Van & Date Wise");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Saleman, Van & Date Wise");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout useablepanLayout = new javax.swing.GroupLayout(useablepan);
        useablepan.setLayout(useablepanLayout);
        useablepanLayout.setHorizontalGroup(
            useablepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(useablepanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(useablepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(useablepanLayout.createSequentialGroup()
                        .addComponent(exit_rep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(useablepanLayout.createSequentialGroup()
                        .addGroup(useablepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(useablepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        useablepanLayout.setVerticalGroup(
            useablepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, useablepanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(useablepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(useablepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(useablepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit_rep)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(useablepan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(parameterpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(parameterpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(useablepan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   DynamicERP.dialoge.newdataentry.dialogeClass.disposeLoadSheetWin();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void exit_repActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_repActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exit_repActionPerformed

    private void fromdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromdateKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromdateKeyPressed

    private void todateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_todateKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_todateKeyPressed

    private void smNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_smNameActionPerformed

    private void smNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_smNameKeyPressed


    }//GEN-LAST:event_smNameKeyPressed

    private void smNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_smNameKeyReleased
        try {
            updateComboBox(smName, smNameD,"sm");
        } catch (Exception ex) {
            Logger.getLogger(EMPREC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_smNameKeyReleased

    private void smNameDPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_smNameDPopupMenuWillBecomeVisible
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();        
            smNameD.setModel(buildAllComboBoxModel("sm"));
            if(setSelectedComboItem(smName,smNameD,((!smName.getText().isEmpty())?data.find_sm_name_by_code(conn, smName.getText()):""))){
                
            }else{
                smName.setText(getCode(smNameD.getSelectedItem().toString(),"sm"));
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CUSTREC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CUSTREC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_smNameDPopupMenuWillBecomeVisible

    private void smNameDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smNameDActionPerformed
        System.out.println("smNameD.getSelectedItem().toString()"+smNameD.getSelectedItem().toString());
        smName.setText(getCode(smNameD.getSelectedItem().toString(),"sm"));
    }//GEN-LAST:event_smNameDActionPerformed

    private void smNameDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_smNameDKeyPressed
        //            code here
    }//GEN-LAST:event_smNameDKeyPressed

    private void vanCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vanCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vanCodeActionPerformed

    private void vanCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vanCodeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_vanCodeKeyPressed

    private void vanCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vanCodeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_vanCodeKeyReleased

    private void vanNamePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_vanNamePopupMenuWillBecomeVisible
        PAK_DB data =new PAK_DB();
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
            Logger.getLogger(CUSTREC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CUSTREC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_vanNamePopupMenuWillBecomeVisible

    private void vanNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vanNameActionPerformed
        System.out.println("vanName.getSelectedItem().toString()"+vanName.getSelectedItem().toString());
        vanCode.setText(getCode(vanName.getSelectedItem().toString(),"van"));
    }//GEN-LAST:event_vanNameActionPerformed

    private void vanNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vanNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_vanNameKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            try {
            String s= "D:\\DynamicERP\\DSP001\\LOADSHEET.jasper";
                    Map parametersMap = new HashMap();
                    
            parametersMap.put("fromdate",c.toDateString(dateIncrementer.addDays(fromdate.getDate(), 0).toString()));
            parametersMap.put("todate",c.toDateString(dateIncrementer.addDays(todate.getDate(), 0).toString()));
            
       JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, parametersMap, connAA);
        JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
                {
        if(exit_rep.isSelected()) {
        DynamicERP.dialoge.newdataentry.dialogeClass.disposeLoadSheetWin();
        } else {}}
            createJasperView(jasperViewer);
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }

 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
            try {
            String s= "D:\\DynamicERP\\DSP001\\LOADSHEET_SM.jasper";
                    Map parametersMap = new HashMap();
                    
            parametersMap.put("fromdate",c.toDateString(dateIncrementer.addDays(fromdate.getDate(), 0).toString()));
            parametersMap.put("todate",c.toDateString(dateIncrementer.addDays(todate.getDate(), 0).toString()));
            parametersMap.put("saleman",Integer.parseInt(smName.getText()));
          
       JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, parametersMap, connAA);
        JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
                {
        if(exit_rep.isSelected()) {
        DynamicERP.dialoge.newdataentry.dialogeClass.disposeLoadSheetWin();
        } else {}}
            createJasperView(jasperViewer);
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            try {
            String s= "D:\\DynamicERP\\DSP001\\LOADSHEET_Van.jasper";
                    Map parametersMap = new HashMap();
                    
            parametersMap.put("fromdate",c.toDateString(dateIncrementer.addDays(fromdate.getDate(), 0).toString()));
            parametersMap.put("todate",c.toDateString(dateIncrementer.addDays(todate.getDate(), 0).toString()));
            parametersMap.put("van",Integer.parseInt(vanCode.getText()));
            
       JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, parametersMap, connAA);
        JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
                {
        if(exit_rep.isSelected()) {
        DynamicERP.dialoge.newdataentry.dialogeClass.disposeLoadSheetWin();
        } else {}}
            createJasperView(jasperViewer);
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
            try {
            String s= "D:\\DynamicERP\\DSP001\\LOADSHEET_SMVAN.jasper";
                    Map parametersMap = new HashMap();
                    
            parametersMap.put("fromdate",c.toDateString(dateIncrementer.addDays(fromdate.getDate(), 0).toString()));
            parametersMap.put("todate",c.toDateString(dateIncrementer.addDays(todate.getDate(), 0).toString()));
            parametersMap.put("saleman",Integer.parseInt(smName.getText()));
            parametersMap.put("van",Integer.parseInt(vanCode.getText()));
            
       JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, parametersMap, connAA);
        JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
                {
        if(exit_rep.isSelected()) {
        DynamicERP.dialoge.newdataentry.dialogeClass.disposeLoadSheetWin();
        } else {}}
            createJasperView(jasperViewer);
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(STKLoadSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(STKLoadSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(STKLoadSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(STKLoadSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new STKLoadSheet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox exit_rep;
    private com.toedter.calendar.JDateChooser fromdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel parameterpan;
    private javax.swing.JTextField smName;
    private javax.swing.JComboBox smNameD;
    private javax.swing.JLabel suppCat;
    private javax.swing.JLabel suppCat5;
    private com.toedter.calendar.JDateChooser todate;
    private javax.swing.JPanel useablepan;
    private javax.swing.JTextField vanCode;
    private javax.swing.JComboBox vanName;
    // End of variables declaration//GEN-END:variables

     private String getCode(String name,String c) {
        String s="";
        PAK_DB data =new PAK_DB();
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
                    case "exp":
                        if(!name.equals("")){
                            s=data.find_exp_code_by_name(conn,name.trim());
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
                    case "fin":
                        if(!name.equals("")){
                            s=data.find_fin_code_by_name(conn,name.trim());
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
