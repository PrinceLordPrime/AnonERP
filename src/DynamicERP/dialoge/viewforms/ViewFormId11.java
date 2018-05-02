/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.dialoge.viewforms;

import DB.PAK_DB;
import DB.PAK_INSTRTN_DB;
import DB.PAK_ISSUE_SALERTN_DB;
import DB.PAK_ISSUE_SALE_DB;
import DB.PAK_ORDER_DB;
import DB.PAK_QUOTATION_DB;
import DB.PAK_SALERTN_DB;
import DB.PAK_SALE_DB;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import DynamicERP.frames.newdataentry.FIRMREC;//disposeViewAssetWin;
import static DynamicERP.dialoge.viewforms.dialogeClass.*;
import java.awt.Dimension;
import javax.swing.table.JTableHeader;


/**
 *
 * @author DynamicSP
 */
public class ViewFormId11 extends javax.swing.JFrame implements KeyListener {

   public String getSearchFieldText() {
        return searchField.getText();
    }

    /**
     * Creates new form ViewFormccc
     */
    int i;
    public String r1[][]=null;
    public String type=null;
    
    public ViewFormId11(String col[],String string) {
        this.setAlwaysOnTop(true);
        i=0;
        if(!string.equalsIgnoreCase("")){
            type=string;
            
            initComponents();

            searchField.addKeyListener(this);

            updateTableView(col);

            originalTableModel = (Vector) ((DefaultTableModel) jTable1.getModel()).getDataVector().clone();

            searchField.getDocument().addDocumentListener(new DocumentListener() {    
                @Override
                public void insertUpdate(DocumentEvent de) {
                    System.out.println("insertUpdate");
    //                updateTableView(col);
                    search();
                }

                @Override
                public void removeUpdate(DocumentEvent de) {
                    System.out.println("removeUpdate");
                    search();
                }

                @Override
                public void changedUpdate(DocumentEvent de) {
                    System.out.println("changedUpdate");
                }

                private void search() {
                    if(!searchField.getText().equalsIgnoreCase("")){
                        searchTableContents(searchField.getText());
                    }else{
                        updateTableView(col);
                    }
                }
            });

    //        initTable(null,null);
        }else{
            System.out.println("Form type not found");
        }
    }
    public void searchTableContents(String searchString) {
        DefaultTableModel currtableModel = (DefaultTableModel) jTable1.getModel();
        //To empty the table before search
        currtableModel.setRowCount(0);
        //To search for contents from original table content
        for (Object column : originalTableModel) {
            System.out.println("column : "+column.toString());
            Vector columnVector = (Vector) column;
            for (Object rows : columnVector) {
                String _s123;
                _s123 = (rows==null?"zzz":(String) rows.toString());
                if (_s123.toLowerCase().contains(searchString)) {
                    //content found so adding to table
                    currtableModel.addRow(columnVector);
                    break;
                }
            }
        }
        selectionModel = jTable1.getSelectionModel();
        selectionModel.setSelectionInterval(0, 0);
        
    }
    private void updateTableView(String c[]) {
        String r[][]=null;//searchLike(searchField.getText());
        
        PAK_DB data =new PAK_DB();
        PAK_SALE_DB data1 =new PAK_SALE_DB();
        PAK_SALERTN_DB data2 =new PAK_SALERTN_DB();
        PAK_QUOTATION_DB data3 =new PAK_QUOTATION_DB();
        PAK_ORDER_DB   data4 =new PAK_ORDER_DB();
        PAK_INSTRTN_DB data5 =new PAK_INSTRTN_DB();
        PAK_ISSUE_SALE_DB data6 =new PAK_ISSUE_SALE_DB();
        PAK_ISSUE_SALERTN_DB data7 =new PAK_ISSUE_SALERTN_DB();
        
        Connection conn;
        try {
            conn = data.connect_database();
            boolean tf=false;
            switch(type.toLowerCase()) {
                case "asset":  
                        r=data.search_asset_rec(conn, getSearchFieldText());
                         break;
                case "cashtype":  
                        r=data.search_cash_type(conn, getSearchFieldText());
                         break;
                case "cashdep":  
                        r=data.search_cash_dep(conn, getSearchFieldText());
                         break;
                case "exprec":  
                        r=data.search_exp_rec(conn, getSearchFieldText());
                         break;
                case "recovery":  
                        r=data.search_recovery(conn, getSearchFieldText());
                         break;
                case "credit":  
                        r=data.search_credit(conn, getSearchFieldText());
                         break;
                case "custrec":  
                        r=data.search_cust_rec(conn, getSearchFieldText());
                         break;
                case "emprec":  
                        r=data.search_emp_rec(conn, getSearchFieldText());
                         break;
                case "productrec":  
                        r=data.search_product_rec(conn, getSearchFieldText());
                         break;
                case "catrec":  
                        r=data.search_cat_rec(conn, getSearchFieldText());
                         break;
                case "zonerec":  
                        r=data.search_zone_rec(conn, getSearchFieldText());
                         break;
                case "subcatrec":  
                        r=data.search_sub_cat_rec(conn, getSearchFieldText());
                         break;
                case "sttyperec":  
                        r=data.search_st_type_rec(conn, getSearchFieldText());
                         break;
                case "stloc":  
                        r=data.search_stloc_rec(conn, getSearchFieldText());
                         break;
                case "comp":  
                        r=data.search_com_rec(conn, getSearchFieldText());
                         break;
                case "custtype":  
                        r=data.search_custtype(conn, getSearchFieldText());
                         break;
                case "distrec":  
                        r=data.search_distrec(conn, getSearchFieldText());
                         break;
                case "expence":  
                        r=data.search_expence(conn, getSearchFieldText());
                         break;
                case "postrec":  
                        r=data.search_postrec(conn, getSearchFieldText());
                         break;
                case "routerec":  
                        r=data.search_routerec(conn, getSearchFieldText());
                         break;
                case "purchase":  
                        r=data.search_purchase(conn, getSearchFieldText());
                         break;
                case "sales":  
                        r=data1.search_sales(conn, getSearchFieldText());
                         break;
                case "issales":
                        r=data6.search_sales(conn, getSearchFieldText());
                         break;
                case "instrtn":  
//                        r=data.search_sales(conn, getSearchFieldText());
                        r=data5.search_sales(conn, getSearchFieldText());
                         break;
                case "salesorder":  
//                        r=data.search_sales(conn, getSearchFieldText());
                        r=data4.search_sales(conn, getSearchFieldText());
                         break;
                case "quotation":  
//                        r=data.search_sales(conn, getSearchFieldText());
                        r=data3.search_sales(conn, getSearchFieldText());
                         break;
                case "salesrtn":  
//                        r=data.search_sales(conn, getSearchFieldText());
                        r=data2.search_sales(conn, getSearchFieldText());
                         break;
                case "issuertn":  
//                        r=data.search_sales(conn, getSearchFieldText());
                        r=data6.search_sales(conn, getSearchFieldText());
                         break;
                case "finrec":  
                        r=data.search_finrec(conn, getSearchFieldText());
                         break;
                case "vanrec":  
                        r=data.search_vanrec(conn, getSearchFieldText());
                         break;
                case "firmrec":  
                        r=data.search_firmrec(conn, getSearchFieldText());
                         break;
                case "suprec":  
                        r=data.search_suprec(conn, getSearchFieldText());
                         break;
                default: 
                             break;
            }
            System.out.println("Is Inserted :"+ tf);
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(FIRMREC.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(r==null){
            JOptionPane.showMessageDialog(null, "No Row Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }else{
            initTable(c,r);
            
        }    //populateTable(s[][]);
    }

    private String[][] searchLike(String asset_rec) {
            String rows[][]=null;
            boolean tf=false;
            PAK_DB data =new PAK_DB();
            Connection conn;
            try {
                conn = data.connect_database();
                rows=data.search_asset_rec(conn,asset_rec);
                System.out.println("Found something ? :"+ rows);
                data.close_database(conn);
            } catch (SQLException ex) {
                Logger.getLogger(FIRMREC.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(rows==null){
                
            }else{
                
            }
            return rows;
    }
     private void initTable(String colNames[],String rowData[][]) {
        String col[] = colNames;
        String row[][] =rowData;
        model = new DefaultTableModel(row,col);

        jTable1=new JTable(model){
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {                
                    return false;               
            };
        };
        jTable1.getAutoscrolls();
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setRowHeight(30);
        JTableHeader header = jTable1.getTableHeader();
        
        header.setPreferredSize(new Dimension(100, 30));
        jTable1.setShowHorizontalLines(false);
        jTable1.setEnabled(true);
        jTable1.enableInputMethods(false);
        jTable1.setShowVerticalLines(false);
        jTable1.setShowGrid(false);
        jTable1.setRowSelectionAllowed(true);
        
        selectionModel = jTable1.getSelectionModel();
        selectionModel.setSelectionInterval(0, 0);
        jTable1.getKeyListeners();
        jTable1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    save();
                    disposeWin();
                }
            }
        });
        jTable1.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        jTable1.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                save();
                disposeWin();
            }
        });
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(50);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane1.setViewportView(jTable1);
        
       
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setName("frame90"); // NOI18N
        setType(java.awt.Window.Type.POPUP);

        jLabel1.setText("Search:");

        searchField.setBackground(new java.awt.Color(102, 102, 0));
        searchField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                searchFieldInputMethodTextChanged(evt);
            }
        });

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Find");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ok");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(513, 513, 513)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(425, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(372, 372, 372))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dontSave();
        disposeWin();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void searchFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_searchFieldInputMethodTextChanged
//             searchField.requestFocus();
//        searchField.setCaretPosition(searchField.getDocument().getLength());
//        searchField.setCaretPosition(searchField.getText().getLength());
//        searchField.setCaretPosition(searchField.getText().length());
    }//GEN-LAST:event_searchFieldInputMethodTextChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        save();
        disposeWin();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        searchField.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(ViewFormccc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewFormccc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewFormccc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewFormccc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewFormccc(null,null).setVisible(true);
            }
        });
    }
    // Variables declaration modefiable  
    private JTable jTable1;
    DefaultTableModel model;
    Vector originalTableModel;
    ListSelectionModel selectionModel ;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println("keyTyped");
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode()==38){
            if(i>=0){
                i--;
                selectionModel.setSelectionInterval(0, i);
            }
        }else if(ke.getKeyCode()==40){
            if(i<=jTable1.getRowCount()-2){
                i++;
                selectionModel.setSelectionInterval(0, i);
            }
        }
        if(ke.getKeyCode()== KeyEvent.VK_ENTER){
            save();
            disposeWin();
        }

    }
    
    @Override
    public void keyReleased(KeyEvent ke) {
        System.out.println("keyReleased");
    }
    public static boolean isSaved;
    private void save() {
        String[] s=new String[2];
        s=getFirstTwoColums();
        switch(type.toLowerCase()) {
                case "asset":  
                    code1=s[0];
                    asset=s[1];
                    num1=jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
                    com1=jTable1.getValueAt(jTable1.getSelectedRow(),3).toString();
                    break;
                case "custrec":  
                    codeCustRec=s[0];
//                    nameCustRec=s[1];
//                    cellCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
//                    add1CustRec=jTable1.getValueAt(jTable1.getSelectedRow(),3).toString();
//                    routeCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),4).toString();
//                    custTypeCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),5).toString();
//                    distCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),6).toString();
                    break;
                case "cashdep":  
                    codeCashDep=s[0];
//                    nameCustRec=s[1];
//                    cellCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
//                    add1CustRec=jTable1.getValueAt(jTable1.getSelectedRow(),3).toString();
//                    routeCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),4).toString();
//                    custTypeCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),5).toString();
//                    distCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),6).toString();
                    break;
                case "recovery":  
                    codeRecovery=s[0];
//                    nameCustRec=s[1];
//                    cellCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
//                    add1CustRec=jTable1.getValueAt(jTable1.getSelectedRow(),3).toString();
//                    routeCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),4).toString();
//                    custTypeCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),5).toString();
//                    distCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),6).toString();
                    break;
                case "credit":  
                    codeCredit=s[0];
//                    nameCustRec=s[1];
//                    cellCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
//                    add1CustRec=jTable1.getValueAt(jTable1.getSelectedRow(),3).toString();
//                    routeCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),4).toString();
//                    custTypeCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),5).toString();
//                    distCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),6).toString();
                    break;
                case "productrec":  
                    codeProductRec=s[0];
//                    nameCustRec=s[1];
//                    cellCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
//                    add1CustRec=jTable1.getValueAt(jTable1.getSelectedRow(),3).toString();
//                    routeCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),4).toString();
//                    custTypeCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),5).toString();
//                    distCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),6).toString();
                    break;
                case "emprec":  
                    codeEmpRec=s[0];
//                    nameCustRec=s[1];
//                    cellCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
//                    add1CustRec=jTable1.getValueAt(jTable1.getSelectedRow(),3).toString();
//                    routeCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),4).toString();
//                    custTypeCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),5).toString();
//                    distCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),6).toString();
                    break;
                case "exprec":  
                    codeExpRec=s[0];
//                    nameCustRec=s[1];
//                    cellCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
//                    add1CustRec=jTable1.getValueAt(jTable1.getSelectedRow(),3).toString();
//                    routeCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),4).toString();
//                    custTypeCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),5).toString();
//                    distCustRec=jTable1.getValueAt(jTable1.getSelectedRow(),6).toString();
                    break;
                case "catrec":  
                    codeCatRec=s[0];
                    catRec=s[1];
                    break;
                case "cashtype":  
                    codeCashType=s[0];
                    nameCashType=s[1];
                    break;
                case "zonerec":  
                    codeZoneRec=s[0];
                    zoneRec=s[1];
                    break;
                case "subcatrec":  
                    codeSubCatRec=s[0];
                    subCatRec=s[1];
                    break;
                case "sttyperec":  
                    codeStTypeRec=s[0];
                    stTypeRec=s[1];
                    break;
                case "stloc":  
                    codeStLoc=s[0];
                    stLoc=s[1];
                    break;
                case "comp":  
                    codeComp=s[0];
                    nameComp=s[1];
                    
                    break;
                case "custtype": 
                    codeCustType=s[0];
                    nameCustType=s[1];
                    break;
                case "distrec": 
                    codeDistRec=s[0];
                    distRec=s[1];
                    break;
                case "expence": 
                    codeExpence=s[0];
                    expence=s[1];
                    break;
                case "postrec": 
                    codePostRec=s[0];
                    postRec=s[1];
                    break;
                case "routerec": 
                    codeRouteRec=s[0];
                    routeRec=s[1];
                    break;
                case "purchase": 
                    codePurchase=s[0];
                    break;
                case "sales": 
                    codeSales=s[0];
                    break;
                case "issales": 
                    codeIsSales=s[0];
                    break;
                case "instrtn": 
                    codeInstRtn=s[0];
                    break;
                case "salesorder": 
                    codeSalesOrder=s[0];
                    break;
                case "quotation": 
                    codeQuotation=s[0];
                    break;
                case "salesrtn": 
                    codeSalesRtn=s[0];
                    break;
                case "issuertn": 
                    codeIssueRtn=s[0];
                    break;
                case "finrec": 
                    codeFinRec=s[0];
                    finRec=s[1];
                    finRecDesc=jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
                    break;
                case "vanrec": 
                    codeVanRec=s[0];
                    vanRec=s[1];
                    vanRecDesc=jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
                    vanCapacity=jTable1.getValueAt(jTable1.getSelectedRow(),3).toString();
                    break;
                case "firmrec": 
                    codeFirmRec=s[0];
                    firmName=s[1];
                    firmAdd1=jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
                    firmAdd2=jTable1.getValueAt(jTable1.getSelectedRow(),3).toString();
                    firmCell=jTable1.getValueAt(jTable1.getSelectedRow(),4).toString();
                    firmNtn=jTable1.getValueAt(jTable1.getSelectedRow(),5).toString();
                    break;
                case "suprec": 
                    codeSupRec=s[0];
//                    supName=s[1];
//                    supCell=jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
//                    supAdd1=jTable1.getValueAt(jTable1.getSelectedRow(),3).toString();
//                    supAdd2=jTable1.getValueAt(jTable1.getSelectedRow(),4).toString();
//                    supDist=jTable1.getValueAt(jTable1.getSelectedRow(),5).toString();
                    break;
                default: 
                    break;
            }
        isSaved=true;
    }
    private void disposeWin() {
        switch(type.toLowerCase()) {
            case "asset":  
                disposeViewAssetWin();
                break;
            case "cashdep":  
                disposeCashDepWin();
                break;
            case "productrec":  
                disposeProductRecWin();
                break;
            case "recovery":  
                disposeRecoveryWin();
                break;
            case "credit":  
                disposeCreditWin();
                break;
            case "exprec":  
                disposeExpRecWin();
                break;
            case "emprec":  
                disposeEmpRecWin();
                break;
            case "catrec":  
                disposeViewCatRecWin();
                break;
            case "cashtype":  
                disposeViewCashTypeWin();
                break;
            case "zonerec":  
                disposeViewZoneRecWin();
                break;
            case "subcatrec":  
                disposeViewSubCatRecWin();
                break;
            case "sttyperec":  
                disposeViewStTypeRecWin();
                break;
            case "stloc":  
                disposeViewStLocWin();
                break;
            case "comp":  
                disposeViewCompWin();
                break;
            case "custtype":  
                disposeViewCustTypeWin();
                break;
            case "distrec":  
                disposeViewDistRecWin();
                break;
            case "expence":  
                disposeViewExpenceWin();
                break;
            case "postrec":  
                disposeViewPostRecWin();
                break;
            case "routerec":  
                disposeViewRouteRecWin();
                break;
            case "purchase":  
                disposeViewPurchaseWin();
                break;
            case "sales":  
                disposeViewSalesWin();
                break;
            case "issales":  
                disposeViewIsSalesWin();
                break;
            case "instrtn":  
                disposeViewInstRtnWin();
                break;
            case "salesorder":  
                disposeViewSalesOrderWin();
                break;
            case "quotation":  
                disposeViewQuotationWin();
                break;
            case "salesrtn":  
                disposeViewSalesRtnWin();
                break;
            case "issuertn":  
                disposeViewIssueRtnWin();
                break;
            case "finrec":  
                disposeViewFinRecWin();
                break;
            case "vanrec":  
                disposeViewVanRecWin();
                break;
            case "firmrec":  
                disposeViewFirmRecWin();
                break;
            case "suprec":  
                disposeViewSupRecWin();
                break;
            case "custrec":  
                disposeCustRecWin();
                break;
            default:
                break;
        }
    }

    private void dontSave() {
        isSaved=false;
    }

    private String[] getFirstTwoColums() {
        String[] s = new String[2];
        s[0]=jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
        s[1]=(jTable1.getValueAt(jTable1.getSelectedRow(),1)==null?" ":jTable1.getValueAt(jTable1.getSelectedRow(),1).toString());
        return s;
    }
}
