/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.frames.extra;

import DynamicERP.dialoge.viewforms.dialogeClass;
import DB.PAK_DB;
import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import DynamicERP.frames.newdataentry.COMPANY;
import DynamicERP.frames.newdataentry.FIRMREC;
import static DynamicERP.dialoge.viewforms.ViewFormccc.isSaved;

/**
 *
 * @author UzairYousafZai
 */
public class ZONEREC extends javax.swing.JFrame {

    /**
     * Creates new form ZONEREC
     */
    public ZONEREC() {
        initComponents();
        code.setEditable(false);
        zone.setEditable(false);
        this.setResizable(false);
        recEditActionBtnVisible(false);
        
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            ArrayList<String> stock = data.get_first_zone(conn);
            if(stock!=null){
                code.setText(stock.get(0));
                zone.setText(stock.get(1));
            }else{
                zone.setEditable(true);
                zone.requestFocus();
                recEditBtnEnable(false);
                forBackBtnEnable(false);
                btnSave.setVisible(true);
                JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "No data Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Empty DB");
            }
                    
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(FIRMREC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zone = new javax.swing.JTextField();
        code = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        btnPrior = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnSearchNow = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBounds(new java.awt.Rectangle(250, 180, 0, 0));
        setUndecorated(true);
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setText("Code:");

        jLabel2.setText("zone:");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Zone's Records");
        jLabel4.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnView.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnPrior.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnPrior.setText("Prior");
        btnPrior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPriorActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(255, 102, 102));
        btnDel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnDel.setText("Delete");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 102, 102));
        jButton9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Exit");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 102, 51));
        btnAdd.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnSearchNow.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnSearchNow.setText("Search Now");
        btnSearchNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchNowActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnUpdate.setText("update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnFirst.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPrior, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearchNow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(code)
                            .addComponent(zone, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(zone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnFirst)
                                .addComponent(btnPrior)
                                .addComponent(btnNext)
                                .addComponent(btnLast)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(btnSearchNow)
                            .addComponent(btnCancel)
                            .addComponent(btnSave)
                            .addComponent(btnUpdate))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
//        /*
        try {
            dialogeClass.createViewZoneRecWin();
        } catch (SQLException ex) {
            Logger.getLogger(COMPANY.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(isSaved){
            code.setText(dialogeClass.codeZoneRec);
            zone.setText(dialogeClass.zoneRec);
        }else{
            //            JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Not Saved", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }
//        */
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnPriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPriorActionPerformed
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            ArrayList<String> prior = new ArrayList<String>();
            prior=data.prior_zone(conn,code.getText(),zone.getText());
            if(prior!=null){
                code.setText(prior.get(0));
                zone.setText(prior.get(1));
            }else{
                JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "Prior not found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }

            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(FIRMREC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPriorActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        forBackBtnEnable(false);
        recEditBtnEnable(false);
        btnSearchNow.setVisible(true);
        btnCancel.setVisible(true);
        code.setEditable(true);
        zone.setEditable(false);
        zone.setText("");
        code.setText("");
        code.requestFocus();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            ArrayList<String> next = new ArrayList<String>();
            next=data.next_zone(conn,code.getText(),zone.getText());
            if(!(next==null)){
                code.setText(next.get(0));
                zone.setText(next.get(1));
            }else{
                JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "Next not found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }

            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(FIRMREC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
javax.swing.JFrame j=new javax.swing.JFrame(); j.setAlwaysOnTop(true);if(JOptionPane.showConfirmDialog(j,
            "Are you sure ! \nOn selecting \"Yes\" this will Delete the tasks?", "Confermation Diloge",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ //ConfermationDiloge()){
        zone.getText();
        code.getText();
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            boolean tf=false;
            if(code.getText()==null||zone.getText()==null){

            }else{
                if(data.chech_zone(conn,code.getText())){
                    tf=data.delete_zone(conn,code.getText(),zone.getText());
                }else{
                    JFrame j1=new JFrame();
                    j1.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j1, "Zone Present in Customer Record", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if(tf){
                zone.setText("");
                code.setText("");
                setLastRec();
            }
            System.out.println("Is Inserted :"+ tf);
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(FIRMREC.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{

        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
               DynamicERP.dialoge.newdataentry.dialogeClass.disposeZONEWin();

    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        forBackBtnEnable(false);
        recEditBtnEnable(false);
        btnSave.setVisible(true);
        btnSave.setEnabled(true);
        btnCancel.setVisible(true);
        zone.setEditable(true);
        zone.setText("");
        zone.requestFocus();

        code.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        setLastRec();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(!(zone.getText().toString().equalsIgnoreCase(""))){
            PAK_DB data =new PAK_DB();
            Connection conn;
            try {
                conn = data.connect_database();
                boolean tf=false;

                ///Max
                int max=0,codeInt=0;
                max=data.find_max_in_zone_code(conn);
                System.out.println("Max:"+max);
                if(max==0){
                    codeInt=1;
                }else{
                    codeInt=max+1;
                }
                ///Max                 String.valueOf(codeInt)

                tf=data.insert_zone_rec_in_table(conn,String.valueOf(codeInt),zone.getText());

                if(tf){
                    code.setText(String.valueOf(codeInt));
                    zone.setEditable(false);
                    forBackBtnEnable(true);
                    recEditBtnEnable(true);
                    recEditActionBtnVisible(false);
                }
                System.out.println("Is Inserted :"+ tf);
                data.close_database(conn);
            } catch (SQLException ex) {
                Logger.getLogger(FIRMREC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "Enter Name OR Press Cancel to Contine  ", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSearchNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchNowActionPerformed
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            String s=data.find_zone_rec_by_code(conn, code.getText());
            if (s!=null){
                zone.setText(s);
                code.setEditable(false);
                forBackBtnEnable(true);
                recEditBtnEnable(true);
                recEditActionBtnVisible(false);
            }else{
                JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "Not Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
            System.out.println("Asset Found is :"+ s);
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(FIRMREC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchNowActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        forBackBtnEnable(false);
        recEditBtnEnable(false);
        zone.setEditable(true);
        btnSave.setEnabled(false);
        btnUpdate.setVisible(true);
        btnCancel.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            boolean tf=false;
            tf=data.update_zone(conn,code.getText(),zone.getText());
            if(tf){
                zone.setEditable(false);
                forBackBtnEnable(true);
                recEditBtnEnable(true);
                recEditActionBtnVisible(false);

            }else{
                JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "Not Edited", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }

            System.out.println("Is Inserted :"+ tf);
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(FIRMREC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        setFirstRec();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        recEditActionBtnVisible(false);
        forBackBtnEnable(true);
        recEditBtnEnable(true);
        code.setEditable(false);
        zone.setEditable(false);
        setFirstRec();
    }//GEN-LAST:event_btnCancelActionPerformed
    private void enableFields(javax.swing.JFrame aThis, boolean b) {
        Component[] c = new Component[this.getContentPane().getComponentCount()];
        c=aThis.getContentPane().getComponents();
        for(int i=0;i<aThis.getContentPane().getComponentCount();i++){
            System.out.println("Component Class:"+c[i].getClass());
            if(c[i].getClass().toString().contains("javax.swing.JTextField")||c[i].getClass().toString().contains("javax.swing.JComboBox")){
                System.out.println("true");
                c[i].setEnabled(b);
            }
        }
    }
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
            java.util.logging.Logger.getLogger(ZONEREC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ZONEREC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ZONEREC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ZONEREC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ZONEREC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrior;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchNow;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JTextField code;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField zone;
    // End of variables declaration//GEN-END:variables
    private void setFirstRec() {
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            ArrayList<String> stock = data.get_first_zone(conn);
            if(stock==null){
                code.setText("");
                zone.setText("");
                JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "No data Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }else{
                code.setText(stock.get(0));
                zone.setText(stock.get(1));
            }
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(FIRMREC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setLastRec() {
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            ArrayList<String> stock = data.get_last_zone(conn);
            if(stock.get(0)==null){
                code.setText("");
                zone.setText("");
            }else{
                code.setText(stock.get(0));
                zone.setText(stock.get(1));
            }
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(FIRMREC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void forBackBtnEnable(boolean b) {
       btnFirst.setEnabled(b);
       btnLast.setEnabled(b);
       btnPrior.setEnabled(b);
       btnNext.setEnabled(b);
    }

    private void recEditBtnEnable(boolean b) {
        btnAdd.setEnabled(b);
        btnDel.setEnabled(b);
        btnSearch.setEnabled(b);
        btnView.setEnabled(b);
        btnEdit.setEnabled(b);
    }

    private void recEditActionBtnVisible(boolean b) {
        btnSave.setVisible(b);
        btnUpdate.setVisible(b);
        btnSearchNow.setVisible(b);
        btnCancel.setVisible(b);
    }
}
