/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.frames.IssueRtn;

import DSPREP.test.AutoCompletion;
import DB.PAK_DB;
import DB.PAK_GENERAL_DB;
import DB.PAK_GLOBAL_DB;
import DB.PAK_ISSUE_SALERTN_DB;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ViewportLayout;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import logical.Conversions;
import logical.dateIncrementer;
import newpackage.ButtonTextFieldCellTest;
import static DynamicERP.dialoge.viewforms.ViewFormId11.isSaved;
import DynamicERP.dialoge.viewforms.dialogeClass;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import DynamicERP.dialoge.viewforms.ViewFormId11;
import DynamicERP.frames.purchase.PURCHASE;
import static DynamicERP.frames.salesRtn.PakSalesRtnFieldPanel.round;
import java.awt.Container;
import java.math.BigInteger;
import javax.swing.JScrollPane;

/**
 *
 * @author Shan
 */
public class ISSUERTN extends 
        javax.swing.JFrame {
    Conversions dateField=new Conversions();

    /**
     * Creates new form PURCHASE
     */PAK_GLOBAL_DB dataAA =new PAK_GLOBAL_DB();
    Connection connAA;
    
    public ISSUERTN() {
        initComponents();
        styleComboBox(suppName);
        styleComboBox(dName);
        styleComboBox(vanName);
        AutoCompletion.enable(suppName);
        AutoCompletion.enable(dName);
        //AutoCompletion.enable(vanName);
        vanName.setEditable( true );
        final JTextField tf = (JTextField)vanName.getEditor().getEditorComponent();
        //
        // Add keylistener to JTextField!
        //
        tf.addKeyListener(new KeyAdapter(){
            public void keyTyped( KeyEvent e)
            {
                System.err.println("==> tf.getText() : "+tf.getText());
//                StringSearchable searchable = new StringSearchable(vanName.get);
//                AutocompleteJComboBox combo = new AutocompleteJComboBox(searchable);
            }});
        
        maximize();
        
            try {
                connAA = dataAA.connect_database();
            
            }catch (SQLException e) {
                System.out.println("Exception ===> "+e);
            }    
        panel.setBorder(BorderFactory.createTitledBorder("Sales Invoice Properties: "));
        purchaseScrollPane.setBorder(BorderFactory.createTitledBorder("Products Sales Adjustments in invoice: "));
        jpanspl.setBorder(BorderFactory.createTitledBorder("Invoice Details & SPL Adjustments: "));
        adjustments.setBorder(BorderFactory.createTitledBorder("Scheme Adjustments"));
        pan_print.setBorder(BorderFactory.createTitledBorder(""));
  
        saveUpdateBtnVisible("all", false);
        textFieldsEditable(false);
//      initTable();
//      initScrollPanel();
        initPanel();
        try {
            setLastRec();
        } catch (ParseException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLastInvoice();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        suppName = new javax.swing.JComboBox();
        custCode = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        link9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        invNo = new javax.swing.JTextField();
        refNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        oDate = new com.toedter.calendar.JDateChooser();
        btnEdit = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrior = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSearchNow = new javax.swing.JButton();
        dName = new javax.swing.JComboBox();
        dcode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        print2 = new javax.swing.JButton();
        vanName = new javax.swing.JComboBox();
        vanCode = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnIsRtn = new javax.swing.JButton();
        remarks = new javax.swing.JTextField();
        purchaseScrollPane = new javax.swing.JScrollPane();
        pan_print = new javax.swing.JPanel();
        btnexit = new javax.swing.JButton();
        Builty23 = new javax.swing.JLabel();
        issueLoad = new javax.swing.JTextField();
        Builty22 = new javax.swing.JLabel();
        totalLoad = new javax.swing.JTextField();
        jpanspl = new javax.swing.JPanel();
        sumPanel = new javax.swing.JPanel();
        taxPer = new javax.swing.JTextField();
        Builty3 = new javax.swing.JLabel();
        taxRs = new javax.swing.JTextField();
        netAmt = new javax.swing.JTextField();
        Builty8 = new javax.swing.JLabel();
        Builty2 = new javax.swing.JLabel();
        avediscper = new javax.swing.JTextField();
        discount = new javax.swing.JTextField();
        Builty19 = new javax.swing.JLabel();
        Builty20 = new javax.swing.JLabel();
        Builty1 = new javax.swing.JLabel();
        grossAmt = new javax.swing.JTextField();
        linvNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fmrsum = new javax.swing.JTextField();
        fmrsumrs = new javax.swing.JTextField();
        Builty5 = new javax.swing.JLabel();
        tdosum = new javax.swing.JTextField();
        Builty6 = new javax.swing.JLabel();
        splPanel = new javax.swing.JPanel();
        splPer = new javax.swing.JTextField();
        Builty11 = new javax.swing.JLabel();
        splRs = new javax.swing.JTextField();
        Builty17 = new javax.swing.JLabel();
        Builty21 = new javax.swing.JLabel();
        paid = new javax.swing.JTextField();
        Builty15 = new javax.swing.JLabel();
        netpayable = new javax.swing.JTextField();
        Builty18 = new javax.swing.JLabel();
        otherExp = new javax.swing.JTextField();
        Builty12 = new javax.swing.JLabel();
        remaining = new javax.swing.JTextField();
        Builty4 = new javax.swing.JLabel();
        splFmrPer = new javax.swing.JTextField();
        Builty13 = new javax.swing.JLabel();
        splFmrRs = new javax.swing.JTextField();
        adjustments = new javax.swing.JPanel();
        cbSchRs = new javax.swing.JCheckBox();
        cbSchQty = new javax.swing.JCheckBox();

        suppName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        suppName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        suppName.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                suppNamePopupMenuWillBecomeVisible(evt);
            }
        });
        suppName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppNameActionPerformed(evt);
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

        jLabel8.setText("Customer:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DynamicSP Purchase Record Managements (http://dspak.com)");
        setAutoRequestFocus(false);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setModalExclusionType(null);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setPreferredSize(new java.awt.Dimension(1024, 50));

        jLabel9.setBackground(new java.awt.Color(0, 102, 102));
        jLabel9.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Stock Return From Employee");
        jLabel9.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        link9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        link9.setForeground(new java.awt.Color(255, 255, 255));
        link9.setText("http://dspak.com | https://ds-pak.com | https://facebook.com/dspak | https://dailymotion.com/dspak");
        link9.setToolTipText("");
        link9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        link9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                link9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                link9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                link9MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                link9MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(314, Short.MAX_VALUE)
                .addComponent(link9, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(link9)
                .addContainerGap())
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(1300, 900));

        jLabel1.setText("Invoice No:");

        jLabel2.setText("Ref No:");

        invNo.setEditable(false);
        invNo.setBackground(new java.awt.Color(204, 255, 204));
        invNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invNoActionPerformed(evt);
            }
        });

        refNo.setText(" ");
        refNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refNoActionPerformed(evt);
            }
        });

        jLabel5.setText(" Date:");

        jLabel7.setText("Remarks:");

        btnEdit.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnEdit.setMnemonic('E');
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSearch.setMnemonic('S');
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnView.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnView.setMnemonic('V');
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/R2_24.png"))); // NOI18N
        btnLast.setMnemonic('L');
        btnLast.setText("Last");
        btnLast.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/R1_24.png"))); // NOI18N
        btnNext.setMnemonic('N');
        btnNext.setText("Next");
        btnNext.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrior.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnPrior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/L1_24.png"))); // NOI18N
        btnPrior.setMnemonic('P');
        btnPrior.setText("Prior");
        btnPrior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPriorActionPerformed(evt);
            }
        });

        btnFirst.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/L2_24.png"))); // NOI18N
        btnFirst.setMnemonic('F');
        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnUpdate.setMnemonic('U');
        btnUpdate.setText("update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCancel.setMnemonic('C');
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSearchNow.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnSearchNow.setMnemonic('S');
        btnSearchNow.setText("Search Now");
        btnSearchNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchNowActionPerformed(evt);
            }
        });

        dName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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

        jLabel11.setText("Dealer:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 51));
        jLabel3.setText("(Auto)");

        print2.setText("Print");
        print2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print2ActionPerformed(evt);
            }
        });

        vanName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vanNameKeyTyped(evt);
            }
        });

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

        btnIsRtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnIsRtn.setMnemonic('U');
        btnIsRtn.setText("Full Retrun");
        btnIsRtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIsRtnActionPerformed(evt);
            }
        });

        remarks.setText(" ");
        remarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remarksActionPerformed(evt);
            }
        });
        remarks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                remarksKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(print2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnIsRtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnSearchNow)
                                .addGap(0, 0, 0)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dcode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(vanCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dName, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(vanName, 0, 246, Short.MAX_VALUE))
                                        .addGap(10, 10, 10)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(oDate, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                            .addComponent(refNo))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(remarks)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(btnFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invNo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(btnFirst)
                    .addComponent(btnPrior)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(oDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(refNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnView)))
                        .addGap(5, 5, 5))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(dName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(vanName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vanCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(5, 5, 5)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(remarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel)
                    .addComponent(btnSearchNow)
                    .addComponent(btnIsRtn)
                    .addComponent(print2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        purchaseScrollPane.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        purchaseScrollPane.setFocusCycleRoot(true);
        purchaseScrollPane.setMaximumSize(new java.awt.Dimension(950, 32767));

        btnexit.setBackground(new java.awt.Color(0, 102, 102));
        btnexit.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnexit.setForeground(new java.awt.Color(255, 255, 255));
        btnexit.setMnemonic('X');
        btnexit.setText("Exit Sale Menu");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        Builty23.setText("Issue Load:");

        issueLoad.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        issueLoad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        issueLoad.setText("0.0");
        issueLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueLoadActionPerformed(evt);
            }
        });
        issueLoad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                issueLoadKeyReleased(evt);
            }
        });

        Builty22.setText("total Load:");

        totalLoad.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        totalLoad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalLoad.setText("0.0");
        totalLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalLoadActionPerformed(evt);
            }
        });
        totalLoad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                totalLoadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                totalLoadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pan_printLayout = new javax.swing.GroupLayout(pan_print);
        pan_print.setLayout(pan_printLayout);
        pan_printLayout.setHorizontalGroup(
            pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_printLayout.createSequentialGroup()
                .addGap(488, 488, 488)
                .addComponent(Builty23)
                .addGap(0, 0, 0)
                .addComponent(issueLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Builty22)
                .addGap(0, 0, 0)
                .addComponent(totalLoad)
                .addGap(239, 239, 239)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pan_printLayout.setVerticalGroup(
            pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_printLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Builty23)
                        .addComponent(issueLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Builty22)
                        .addComponent(totalLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnexit))
                .addContainerGap())
        );

        sumPanel.setBackground(new java.awt.Color(204, 204, 255));
        sumPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        taxPer.setEditable(false);
        taxPer.setBackground(new java.awt.Color(255, 153, 153));
        taxPer.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        taxPer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        taxPer.setText("0.0");
        taxPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxPerActionPerformed(evt);
            }
        });

        Builty3.setText("Tax");

        taxRs.setEditable(false);
        taxRs.setBackground(new java.awt.Color(255, 153, 153));
        taxRs.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        taxRs.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        taxRs.setText("0.0");
        taxRs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxRsActionPerformed(evt);
            }
        });

        netAmt.setEditable(false);
        netAmt.setBackground(new java.awt.Color(0, 204, 102));
        netAmt.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        netAmt.setForeground(new java.awt.Color(255, 255, 255));
        netAmt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        netAmt.setText("0.0");
        netAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netAmtActionPerformed(evt);
            }
        });

        Builty8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Builty8.setText("Pro Net Amount:");

        Builty2.setText("Discount");

        avediscper.setEditable(false);
        avediscper.setBackground(new java.awt.Color(204, 255, 204));
        avediscper.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        avediscper.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        avediscper.setText("0.0");
        avediscper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avediscperActionPerformed(evt);
            }
        });

        discount.setEditable(false);
        discount.setBackground(new java.awt.Color(204, 255, 204));
        discount.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        discount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        discount.setText("0.0");
        discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountActionPerformed(evt);
            }
        });

        Builty19.setText("%age");

        Builty20.setText("In Rupees");

        Builty1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Builty1.setText("Gross Amount:");

        grossAmt.setEditable(false);
        grossAmt.setBackground(new java.awt.Color(0, 153, 153));
        grossAmt.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        grossAmt.setForeground(new java.awt.Color(255, 255, 255));
        grossAmt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        grossAmt.setText("0.0");
        grossAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grossAmtActionPerformed(evt);
            }
        });

        linvNo.setEditable(false);
        linvNo.setBackground(new java.awt.Color(0, 102, 102));
        linvNo.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        linvNo.setForeground(new java.awt.Color(255, 255, 255));
        linvNo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        linvNo.setText("0");
        linvNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linvNoActionPerformed(evt);
            }
        });

        jLabel10.setText("Last Invoice No:");

        fmrsum.setEditable(false);
        fmrsum.setBackground(new java.awt.Color(0, 204, 102));
        fmrsum.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        fmrsum.setForeground(new java.awt.Color(255, 255, 255));
        fmrsum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fmrsum.setText("0.0");
        fmrsum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmrsumActionPerformed(evt);
            }
        });

        fmrsumrs.setEditable(false);
        fmrsumrs.setBackground(new java.awt.Color(0, 204, 102));
        fmrsumrs.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        fmrsumrs.setForeground(new java.awt.Color(255, 255, 255));
        fmrsumrs.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fmrsumrs.setText("0.0");
        fmrsumrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmrsumrsActionPerformed(evt);
            }
        });

        Builty5.setText("Fmr");

        tdosum.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        tdosum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tdosum.setText("0.0");
        tdosum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdosumActionPerformed(evt);
            }
        });
        tdosum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tdosumKeyReleased(evt);
            }
        });

        Builty6.setText("TO");

        javax.swing.GroupLayout sumPanelLayout = new javax.swing.GroupLayout(sumPanel);
        sumPanel.setLayout(sumPanelLayout);
        sumPanelLayout.setHorizontalGroup(
            sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sumPanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Builty19)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, sumPanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(Builty20)))
                .addGap(36, 39, Short.MAX_VALUE))
            .addGroup(sumPanelLayout.createSequentialGroup()
                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sumPanelLayout.createSequentialGroup()
                        .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sumPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Builty6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Builty8, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(sumPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Builty2)
                                    .addComponent(Builty3)
                                    .addComponent(Builty5))
                                .addGap(6, 6, 6)
                                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fmrsum, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(taxPer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                    .addComponent(avediscper, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))))
                        .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fmrsumrs)
                            .addComponent(discount)
                            .addComponent(tdosum, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linvNo)
                            .addComponent(taxRs)
                            .addComponent(netAmt)))
                    .addGroup(sumPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(Builty1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grossAmt)))
                .addContainerGap())
        );
        sumPanelLayout.setVerticalGroup(
            sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sumPanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Builty1)
                    .addComponent(grossAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Builty19)
                    .addComponent(Builty20))
                .addGap(1, 1, 1)
                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avediscper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Builty2)
                    .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Builty3)
                    .addComponent(taxPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taxRs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fmrsum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fmrsumrs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Builty5))
                .addGap(0, 0, 0)
                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(netAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Builty8))
                .addGap(0, 0, 0)
                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(linvNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Builty6)
                    .addComponent(tdosum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        splPanel.setBackground(new java.awt.Color(204, 204, 255));
        splPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        splPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                splPanelKeyReleased(evt);
            }
        });

        splPer.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        splPer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        splPer.setText("0.0");
        splPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                splPerActionPerformed(evt);
            }
        });
        splPer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                splPerKeyReleased(evt);
            }
        });

        Builty11.setText("SPL Disc");

        splRs.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        splRs.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        splRs.setText("0.0");
        splRs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                splRsActionPerformed(evt);
            }
        });
        splRs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                splRsKeyReleased(evt);
            }
        });

        Builty17.setText("%age");

        Builty21.setText("In Rupees");

        paid.setEditable(false);
        paid.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        paid.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        paid.setText("0.0");
        paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidActionPerformed(evt);
            }
        });
        paid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paidKeyReleased(evt);
            }
        });

        Builty15.setText("Paid");

        netpayable.setEditable(false);
        netpayable.setBackground(new java.awt.Color(0, 204, 102));
        netpayable.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        netpayable.setForeground(new java.awt.Color(255, 255, 255));
        netpayable.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        netpayable.setText("0.0");
        netpayable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netpayableActionPerformed(evt);
            }
        });

        Builty18.setText("Net Payable");

        otherExp.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        otherExp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        otherExp.setText("0.0");
        otherExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherExpActionPerformed(evt);
            }
        });
        otherExp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                otherExpKeyReleased(evt);
            }
        });

        Builty12.setText("Oth Exp");

        remaining.setEditable(false);
        remaining.setBackground(new java.awt.Color(204, 255, 204));
        remaining.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        remaining.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        remaining.setText("0.0");
        remaining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remainingActionPerformed(evt);
            }
        });

        Builty4.setText("Remaining");

        splFmrPer.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        splFmrPer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        splFmrPer.setText("0.0");
        splFmrPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                splFmrPerActionPerformed(evt);
            }
        });
        splFmrPer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                splFmrPerKeyReleased(evt);
            }
        });

        Builty13.setText("SPL FMR");

        splFmrRs.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        splFmrRs.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        splFmrRs.setText("0.0");
        splFmrRs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                splFmrRsActionPerformed(evt);
            }
        });
        splFmrRs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                splFmrRsKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout splPanelLayout = new javax.swing.GroupLayout(splPanel);
        splPanel.setLayout(splPanelLayout);
        splPanelLayout.setHorizontalGroup(
            splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(splPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Builty18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Builty12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Builty13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Builty11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Builty4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(netpayable)
                    .addComponent(otherExp)
                    .addComponent(remaining)
                    .addGroup(splPanelLayout.createSequentialGroup()
                        .addComponent(splFmrPer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(splFmrRs))
                    .addGroup(splPanelLayout.createSequentialGroup()
                        .addComponent(splPer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(splRs))
                    .addComponent(paid))
                .addContainerGap())
            .addGroup(splPanelLayout.createSequentialGroup()
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(splPanelLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(Builty21))
                    .addGroup(splPanelLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(Builty17)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, splPanelLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(Builty15)
                .addGap(152, 152, 152))
        );
        splPanelLayout.setVerticalGroup(
            splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, splPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Builty17)
                    .addComponent(Builty21))
                .addGap(1, 1, 1)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Builty11)
                    .addComponent(splPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(splRs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Builty13)
                    .addComponent(splFmrPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(splFmrRs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Builty12)
                    .addComponent(otherExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Builty18)
                    .addComponent(netpayable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Builty15)
                    .addComponent(paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remaining, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Builty4))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpansplLayout = new javax.swing.GroupLayout(jpanspl);
        jpanspl.setLayout(jpansplLayout);
        jpansplLayout.setHorizontalGroup(
            jpansplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpansplLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sumPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(splPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpansplLayout.setVerticalGroup(
            jpansplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpansplLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpansplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sumPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(splPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cbSchRs.setText("Auto Scheme in RS");
        cbSchRs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSchRsActionPerformed(evt);
            }
        });

        cbSchQty.setText("Auto Scheme in Qty");
        cbSchQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSchQtyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adjustmentsLayout = new javax.swing.GroupLayout(adjustments);
        adjustments.setLayout(adjustmentsLayout);
        adjustmentsLayout.setHorizontalGroup(
            adjustmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adjustmentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adjustmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSchRs)
                    .addComponent(cbSchQty))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adjustmentsLayout.setVerticalGroup(
            adjustmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adjustmentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbSchRs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSchQty)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(purchaseScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adjustments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pan_print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanspl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanspl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan_print, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(purchaseScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                    .addComponent(adjustments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void splPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_splPerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_splPerActionPerformed

    private void otherExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherExpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otherExpActionPerformed

    private void splRsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_splRsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_splRsActionPerformed

    private void paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paidActionPerformed
    String sellers1;
    String refNo1;
    String remarks1;
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        //if inv no present in customer leger then perform 
        PAK_ISSUE_SALERTN_DB data= new PAK_ISSUE_SALERTN_DB();
        forBackBtnEnable(false);
        recEditBtnEnable(false);
        textFieldsEditable(true);
        saveUpdateBtnVisible("update", true);
        sellers1=(String)suppName.getSelectedItem();
        refNo1=refNo.getText();
        remarks1=remarks.getText();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
        forBackBtnEnable(false);recEditBtnEnable(false);saveUpdateBtnVisible("search", true);textFieldsEditable(false);
        invNo.setEditable(true);setNullTextFields();invNo.setText("");invNo.requestFocus();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
//       /*        
        try {
//            dialogeClass.createViewSalesWin();
            dialogeClass.createViewIssueRtnWin();
        } catch (SQLException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(isSaved){
            invNo.setText(dialogeClass.codeIssueRtn);
            findRecords(invNo.getText());
        }else{
            //            JFrame j=new JFrame();
            //                    j.setAlwaysOnTop(true);
            //                    JOptionPane.showMessageDialog(j, "Not Saved", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }
//                */
//                */
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        try {
            setLastRec();
        } catch (ParseException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
        PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
        ArrayList<String> next = new ArrayList<String>();
        next=data.next_purchase(connAA,invNo.getText());
        if(next!=null){
            setTextinPurchase(next, dateField);
        }else{
            JFrame j=new JFrame();
            j.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(j, "Next not found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPriorActionPerformed
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
        PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
        ArrayList<String> prior = new ArrayList<String>();
        prior=data.prior_purchase(connAA,invNo.getText());
        if(prior!=null){
            setTextinPurchase(prior, dateField);
        }else{
            JFrame j=new JFrame();
            j.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(j, "Prior not found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPriorActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        long startTime = System.currentTimeMillis();
        try {
            setFirstRec();
        } catch (ParseException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
        long finishTime = System.currentTimeMillis();

        JFrame j=new JFrame();
        j.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(j, "That took: "+(finishTime-startTime)+ " ms", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        
        ////System.out.println("At FIRST Max PC:"+productCount);
        ////System.out.println("At FIRST Max PC:"+productCount);
        ////System.out.println("At FIRST Max PC:"+productCount);
        ////System.out.println("At FIRST Max PC:"+productCount);
        ////System.out.println("At FIRST Max PC:"+productCount);
        ////System.out.println("At FIRST Max PC:"+productCount);
        ////System.out.println("At FIRST Max PC:"+productCount);
        ////System.out.println("At FIRST Max PC:"+productCount);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        saveUpdateBtnVisible("all", false);
        forBackBtnEnable(true);
        recEditBtnEnable(true);
        textFieldsEditable(false);
        try {                                             
            setFirstRec();
        } catch (ParseException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
        editableProductPanel(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateSumSplPanel();
        boolean tf=false;
        PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
        try {
            
            tf=data.update_purchase(connAA
                    , dateField.toDateString(oDate.getDate().toString()),
                    invNo.getText()+"",refNo.getText(),
                    custCode.getText(),grossAmt.getText(),
                    fmrsumrs.getText(),
                    splRs.getText(),otherExp.getText(),avediscper.getText(),discount.getText(),taxPer.getText(),taxRs.getText(),
                    netAmt.getText(),remaining.getText(),paid.getText(),remarks.getText(),netpayable.getText(),dcode.getText(),tdosum.getText(),vanCode.getText());
            System.out.println("update_purchase: "+tf);
            
        } catch (ParseException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
            for(int i=1;i<=productCount;i++){
                //System.out.println("-> "+i+" : productCount->"+productCount);
                if(purchaseProducts[i]!=null&&purchaseProducts[i].isDisplayable()){
                    if(!purchaseProducts[i].getSeekText().isEmpty()){
                        boolean isPresent=false;

                        PAK_ISSUE_SALERTN_DB data1 =new PAK_ISSUE_SALERTN_DB();
                        if(data.find_max_in_purchase_products(connAA, invNo.getText())<=productCount){
                            //System.out.println("IF");
                            isPresent=data1.check_product_line_item_presence_new(connAA, invNo.getText(),purchaseProducts[i].getSeqNoText(),productCount);
                            
                            
                        }else{
                            isPresent=false;
                        }
                        //System.out.println("isPresent->"+isPresent);
                        if(isPresent){
                            System.out.println(invNo.getText()+""+" UPDATE-> "+purchaseProducts[i].getSeqNoText());

                            
                            PAK_ISSUE_SALERTN_DB data2 =new PAK_ISSUE_SALERTN_DB();
                            tf=data2.update_purchase_products_in_table_new(connAA,
                                    invNo.getText(),purchaseProducts[i].getSeqNoText(),
                                    purchaseProducts[i].getSeekText(),
                                    purchaseProducts[i].getTotalQty1().getText(),
                                    purchaseProducts[i].getRateText(),
                                    purchaseProducts[i].getGrossAmtText(),
                                    purchaseProducts[i].getDiscPerText(),
                                    purchaseProducts[i].getTdo().getText(),
                                    purchaseProducts[i].getTaxPerText(),
                                    purchaseProducts[i].getFmr().getText(),
                                    purchaseProducts[i].getNetAmtText(),
                                    purchaseProducts[i].getReturnQty().getText(),
                                    purchaseProducts[i].getDamage().getText(),
                                    purchaseProducts[i].getFree().getText(),
                                    "",
                                    (purchaseProducts[i].getDate().getSelectedItem()!=null?purchaseProducts[i].getDate().getSelectedItem().toString():""));
                            System.out.println("update_purchase_products_in_table_new: "+tf);
                        }else {
                            //System.out.println(invNo.getText()+""+" INSERT-> "+purchaseProducts[i].getSeqNoText());

                            PAK_ISSUE_SALERTN_DB data3 =new PAK_ISSUE_SALERTN_DB();
                            tf=data3.insert_purchase_products_in_table(connAA,
                                    invNo.getText(),
                                    purchaseProducts[i].getSeqNoText(),
                                    purchaseProducts[i].getSeekText(),
                                    purchaseProducts[i].getTotalQty1().getText(),
                                    purchaseProducts[i].getRateText(),
                                    purchaseProducts[i].getGrossAmtText(),
                                    purchaseProducts[i].getDiscPerText(),
                                    purchaseProducts[i].getTdo().getText(),
                                    purchaseProducts[i].getTaxPerText(),
                                    purchaseProducts[i].getFmr().getText(),
                                    purchaseProducts[i].getNetAmtText(),
                                    purchaseProducts[i].getReturnQty().getText(),
                                    purchaseProducts[i].getDamage().getText(),
                                    purchaseProducts[i].getFree().getText(),
                                    purchaseProducts[i].getCustomSize().getText());
                            System.out.println("insert_purchase_products_in_table: "+tf);
                        }
                    }else{
                        JFrame j=new JFrame();
                        j.setAlwaysOnTop(true);
                        JOptionPane.showMessageDialog(j, "Empty Seek Value will not be updatd \n Nor will be deleted", "InfoBox: ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
          
            if(tf){
                btnexit.setVisible(true);
                saveUpdateBtnVisible("all", false);
                forBackBtnEnable(true);
                recEditBtnEnable(true);
                recEditActionBtnVisible(false);
                textFieldsEditable(false);
                editableProductPanel(false);
//                updateSumSplPanel();
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Not Edited", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
            loadProductsPanel(invNo.getText());
        ////System.out.println("At UPDATE Max PC:"+productCount);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchNowActionPerformed
        findRecords(invNo.getText());
    }//GEN-LAST:event_btnSearchNowActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void invNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invNoActionPerformed

    private void custCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_custCodeKeyReleased
        try {
            updateComboBox(custCode, suppName,"supp");
        } catch (Exception ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_custCodeKeyReleased

    private void suppNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppNameActionPerformed
        //System.out.println("suppName.getSelectedItem().toString()"+suppName.getSelectedItem().toString());
        custCode.setText(getCode(suppName.getSelectedItem().toString(),"supp"));
    }//GEN-LAST:event_suppNameActionPerformed

    private void suppNamePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_suppNamePopupMenuWillBecomeVisible
        PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
        try {
            suppName.setModel(buildAllComboBoxModel("supp",connAA));
            if(setSelectedComboItem(custCode,suppName,((!custCode.getText().isEmpty())?data.find_supp_name_by_code(connAA, custCode.getText()):""))){
                
            }else{
                custCode.setText(getCode(suppName.getSelectedItem().toString(),"supp"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_suppNamePopupMenuWillBecomeVisible

    private void custCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custCodeActionPerformed

    private void discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discountActionPerformed

    private void avediscperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avediscperActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_avediscperActionPerformed

    private void remainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remainingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remainingActionPerformed

    private void netAmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netAmtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_netAmtActionPerformed

    private void taxRsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxRsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taxRsActionPerformed

    private void taxPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxPerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taxPerActionPerformed

    private void grossAmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grossAmtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grossAmtActionPerformed

    private void linvNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linvNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_linvNoActionPerformed

    private void netpayableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netpayableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_netpayableActionPerformed

    private void dNamePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_dNamePopupMenuWillBecomeVisible
        PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
        try {
            dName.setModel(buildAllComboBoxModel("sm",connAA));
            if(setSelectedComboItem(dcode,dName,((!dcode.getText().isEmpty())?data.find_sm_name_by_code(connAA, dcode.getText()):""))){
                
            }else{
                dcode.setText(getCode(dName.getSelectedItem().toString(),"sm"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dcodeKeyReleased

    private void splPanelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_splPanelKeyReleased

    }//GEN-LAST:event_splPanelKeyReleased

    private void paidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidKeyReleased
        frmRemaning();
    }//GEN-LAST:event_paidKeyReleased

    private void splPerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_splPerKeyReleased
        frmSplRs();
        frmNetPayable();
        frmRemaning();
    }//GEN-LAST:event_splPerKeyReleased

    private void splRsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_splRsKeyReleased
        frmSplPer();
        frmNetPayable();
        frmRemaning();
    }//GEN-LAST:event_splRsKeyReleased

    private void otherExpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_otherExpKeyReleased
        frmNetPayable();
        frmRemaning();
    }//GEN-LAST:event_otherExpKeyReleased

    private void link9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_link9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_link9MouseClicked

    private void link9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_link9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_link9MouseEntered

    private void link9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_link9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_link9MouseExited

    private void link9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_link9MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_link9MouseReleased

    private void print2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print2ActionPerformed
        try{ 
        
                    String s= "D:\\Oracle DMS software\\PakMarketing\\src\\oracledms\\reports\\sales.jrxml";
                    
            
                    
                    Map parametersMap = new HashMap();  
                    parametersMap.put("USER_DOCNO",1);
                    
                    JasperReport jr = JasperCompileManager.compileReport(s);
                    JasperPrint print = JasperFillManager.fillReport(jr,parametersMap,connAA);
                    JasperViewer.viewReport(print);
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_print2ActionPerformed

    private void refNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refNoActionPerformed

    private void tdosumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdosumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tdosumActionPerformed

    private void tdosumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tdosumKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tdosumKeyReleased

    private void splFmrPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_splFmrPerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_splFmrPerActionPerformed

    private void splFmrPerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_splFmrPerKeyReleased
        frmSplFmrRs();
        frmNetPayable();
        frmRemaning();
    }//GEN-LAST:event_splFmrPerKeyReleased

    private void splFmrRsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_splFmrRsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_splFmrRsActionPerformed

    private void splFmrRsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_splFmrRsKeyReleased
        frmSplFmrPer();
        frmNetPayable();
        frmRemaning();
    }//GEN-LAST:event_splFmrRsKeyReleased

    private void fmrsumrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmrsumrsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fmrsumrsActionPerformed

    private void fmrsumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmrsumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fmrsumActionPerformed

    private void vanNamePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_vanNamePopupMenuWillBecomeVisible
        PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
        
        try {
                    
            vanName.setModel(buildAllComboBoxModel("van",connAA));
            if(setSelectedComboItem(vanCode,vanName,((!vanCode.getText().isEmpty())?data.find_van_name_by_code(connAA, vanCode.getText()):""))){
                
            }else{
                vanCode.setText(getCode(vanName.getSelectedItem().toString(),"van"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_vanCodeKeyReleased

    private void btnIsRtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIsRtnActionPerformed
        for(int i=1;i<=productCount;i++){
//            System.out.println("-> "+i+" : productCount->"+productCount);
            if(purchaseProducts[i]!=null&&purchaseProducts[i].isDisplayable()){
                if(!purchaseProducts[i].getSeekText().isEmpty()){
                    purchaseProducts[i].getReturnQty().setText(purchaseProducts[i].getTotalQty1().getText());
                    purchaseProducts[i].frmQKR();
                    updateSumSplPanel();
                }else{
                    JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "Empty Seek found Skipping this item ", "InfoBox: ", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnIsRtnActionPerformed

    private void cbSchRsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSchRsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSchRsActionPerformed

    private void cbSchQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSchQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSchQtyActionPerformed

    private void vanNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vanNameKeyTyped
//        JTextField j = (JTextField) evt.getSource();
//        System.out.println("==> j.getText() :"+j.getText());
    }//GEN-LAST:event_vanNameKeyTyped

    private void issueLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueLoadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_issueLoadActionPerformed

    private void issueLoadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_issueLoadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_issueLoadKeyReleased

    private void totalLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalLoadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalLoadActionPerformed

    private void totalLoadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalLoadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_totalLoadKeyReleased

    private void totalLoadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalLoadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_totalLoadKeyTyped

    private void remarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remarksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remarksActionPerformed

    private void remarksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_remarksKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {ffs();}
    }//GEN-LAST:event_remarksKeyReleased
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
            java.util.logging.Logger.getLogger(ISSUERTN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ISSUERTN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ISSUERTN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ISSUERTN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ISSUERTN().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Builty1;
    private javax.swing.JLabel Builty11;
    private javax.swing.JLabel Builty12;
    private javax.swing.JLabel Builty13;
    private javax.swing.JLabel Builty15;
    private javax.swing.JLabel Builty17;
    private javax.swing.JLabel Builty18;
    private javax.swing.JLabel Builty19;
    private javax.swing.JLabel Builty2;
    private javax.swing.JLabel Builty20;
    private javax.swing.JLabel Builty21;
    private javax.swing.JLabel Builty22;
    private javax.swing.JLabel Builty23;
    private javax.swing.JLabel Builty3;
    private javax.swing.JLabel Builty4;
    private javax.swing.JLabel Builty5;
    private javax.swing.JLabel Builty6;
    private javax.swing.JLabel Builty8;
    private javax.swing.JPanel adjustments;
    private javax.swing.JTextField avediscper;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnIsRtn;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrior;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchNow;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnexit;
    private javax.swing.JCheckBox cbSchQty;
    private javax.swing.JCheckBox cbSchRs;
    private javax.swing.JTextField custCode;
    private javax.swing.JComboBox dName;
    private javax.swing.JTextField dcode;
    private javax.swing.JTextField discount;
    private javax.swing.JTextField fmrsum;
    private javax.swing.JTextField fmrsumrs;
    private javax.swing.JTextField grossAmt;
    private javax.swing.JTextField invNo;
    private javax.swing.JTextField issueLoad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpanspl;
    private javax.swing.JLabel link9;
    private javax.swing.JTextField linvNo;
    private javax.swing.JTextField netAmt;
    private javax.swing.JTextField netpayable;
    private com.toedter.calendar.JDateChooser oDate;
    private javax.swing.JTextField otherExp;
    private javax.swing.JTextField paid;
    private javax.swing.JPanel pan_print;
    private javax.swing.JPanel panel;
    private javax.swing.JButton print2;
    private javax.swing.JScrollPane purchaseScrollPane;
    private javax.swing.JTextField refNo;
    private javax.swing.JTextField remaining;
    private javax.swing.JTextField remarks;
    private javax.swing.JTextField splFmrPer;
    private javax.swing.JTextField splFmrRs;
    private javax.swing.JPanel splPanel;
    private javax.swing.JTextField splPer;
    private javax.swing.JTextField splRs;
    private javax.swing.JPanel sumPanel;
    private javax.swing.JComboBox suppName;
    private javax.swing.JTextField taxPer;
    private javax.swing.JTextField taxRs;
    private javax.swing.JTextField tdosum;
    private javax.swing.JTextField totalLoad;
    private javax.swing.JTextField vanCode;
    private javax.swing.JComboBox vanName;
    // End of variables declaration//GEN-END:variables

    public JTextField getAvediscper() {
        return avediscper;
    }

    public void setAvediscper(JTextField avediscper) {
        this.avediscper = avediscper;
    }

    public JTextField getDiscount() {
        return discount;
    }

    public void setDiscount(JTextField discount) {
        this.discount = discount;
    }

    public JTextField getGrossAmt() {
        return grossAmt;
    }

    public void setGrossAmt(JTextField grossAmt) {
        this.grossAmt = grossAmt;
    }

    public JTextField getNetAmt() {
        return netAmt;
    }

    public void setNetAmt(JTextField netAmt) {
        this.netAmt = netAmt;
    }

    public JTextField getNetpayable() {
        return netpayable;
    }

    public void setNetpayable(JTextField netpayable) {
        this.netpayable = netpayable;
    }

    public JTextField getRemaining() {
        return remaining;
    }

    public void setRemaining(JTextField remaining) {
        this.remaining = remaining;
    }

    public JPanel getSplPanel() {
        return splPanel;
    }

    public void setSplPanel(JPanel splPanel) {
        this.splPanel = splPanel;
    }

    public JTextField getSplPer() {
        return splPer;
    }

    public void setSplPer(JTextField splPer) {
        this.splPer = splPer;
    }

    public JTextField getSplRs() {
        return splRs;
    }

    public void setSplRs(JTextField splRs) {
        this.splRs = splRs;
    }

    public JTextField getTaxPer() {
        return taxPer;
    }

    public void setTaxPer(JTextField taxPer) {
        this.taxPer = taxPer;
    }

    public JTextField getTaxRs() {
        return taxRs;
    }

    public void setTaxRs(JTextField taxRs) {
        this.taxRs = taxRs;
    }
    

    // Start of my variables declaration   
    
    private JTable jTable1;
    DefaultTableModel model;
    Vector originalTableModel;
    ListSelectionModel selectionModel ;
    
    private static int productCount=0;
    private static PakIssueRtnFieldPanel[] purchaseProducts = new PakIssueRtnFieldPanel[500];
    private static IssueRtnHeaderPanel purchaseHeaderPanel= new IssueRtnHeaderPanel();
    private static JPanel purchasePanel;// = new JPanel();
    // End of my variables declaration                   
    
    
    
    
    private void initTable() {
//        String col[] = {"Seq#","PCode","BCode","ProductName","PurPCS","PurCTN","PurQTY","PurDMG","PurRate","GrossAmount","Disc%","DiscRS","Tax%","TaxRS","TOPcs","UCHRS","SCHRS","FMR%","FMRRS","TaxRS","Expiry","Batch","NetAmount"};
        String col[] = {"Seq#","PCode","BCode"};
        int k=0; 
        Object row[][] = new Object[][] { { "1", new ButtonTextFieldCellTest.ButtonTextFieldCell(), new ButtonTextFieldCellTest.ButtonTextFieldCell() },
            { "2", new ButtonTextFieldCellTest.ButtonTextFieldCell(), new ButtonTextFieldCellTest.ButtonTextFieldCell() },
            { "3", new ButtonTextFieldCellTest.ButtonTextFieldCell(), new ButtonTextFieldCellTest.ButtonTextFieldCell() },
            { "4", new ButtonTextFieldCellTest.ButtonTextFieldCell(), new ButtonTextFieldCellTest.ButtonTextFieldCell() } };
//        String row[][] =new String[3][23];
       
//        row=new String[][]{{"Seq#","PCode","BCode","ProductName","PurPCS","PurCTN","PurQTY","PurDMG","PurRate","GrossAmount","Disc%","DiscRS","Tax%","TaxRS","TOPcs","UCHRS","SCHRS","FMR%","FMRRS","TaxRS","Expiry","Batch","NetAmount"},
//                                       {"1Seq#","1PCode","1BCode","ProductName","PurPCS","PurCTN","PurQTY","PurDMG","PurRate","GrossAmount","Disc%","DiscRS","Tax%","TaxRS","TOPcs","UCHRS","SCHRS","FMR%","FMRRS","TaxRS","Expiry","Batch","NetAmount"},
//                                       {"2Seq#","2PCode","2BCode","ProductName","PurPCS","PurCTN","PurQTY","PurDMG","PurRate","GrossAmount","Disc%","DiscRS","Tax%","TaxRS","TOPcs","UCHRS","SCHRS","FMR%","FMRRS","TaxRS","Expiry","Batch","NetAmount"}};
        model = new DefaultTableModel(row,col);
        jTable1=new JTable(model);
        jTable1.setRowHeight(30);
        jTable1.setRowHeight(0,30);
        jTable1.setPreferredSize(new Dimension(purchaseScrollPane.getWidth(), 35));
        purchaseScrollPane.setViewportView(jTable1);
    }
    JInternalFrame f=new JInternalFrame();
    javax.swing.JPanel panel1[] = new javax.swing.JPanel[2];
    JTextField J[][] = new JTextField[2][23];
    private void initScrollPanel() {
        
        f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.PAGE_AXIS));
//        f.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
//        f.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        for(int j = 0;j < 2;j++)
        {
            initializePanelListner(panel1[j]);
            for(int i = 0;i < 23;i++)
            {
                J[j][i] = new JTextField(4);
                J[j][i].setBounds(150, 350 + i * 25, 20, 20);
                panel1[j].add(J[j][i]);
                panel1[j].setAlignmentX(Component.CENTER_ALIGNMENT);
            }
            f.add(panel1[j]);
        }
        
//        purchaseScrollPane.
        purchaseScrollPane.setViewportView(f);
    }

    private void initializePanelListner(final JPanel p) {
//        p=new JPanel();
        p.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent me) {
                
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                p.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent me) {
//                java.awt.Point p1 = new java.awt.Point(me.getLocationOnScreen());
//                SwingUtilities.convertPointFromScreen(p1, me.getComponent());
//                if(me.getComponent().contains(p1)) {return;}
                p.setBackground(null);
            }
        });
    }
   private void initPanel() {
        purchasePanel = new JPanel();
        purchasePanel.setLayout(new BoxLayout(purchasePanel, BoxLayout.PAGE_AXIS));
        purchasePanel.add(purchaseHeaderPanel);
        addRow();
            
        purchaseScrollPane.getViewport().setView(purchasePanel);
    }
   private void perkd(KeyEvent e) {
        if(e.getSource() instanceof JTextField){
            JTextField j = (JTextField) e.getSource();
            for (int i = Integer.parseInt(j.getParent().getName()); i < (Integer.parseInt(j.getParent().getName())+10); i++) {
                if(purchaseProducts[i+1]!=null&&purchaseProducts[i+1].isDisplayable())
                {
                    JTextField j1= (JTextField) purchaseProducts[i+1].getComponent(gci(j));
                    j1.requestFocus();
                    j1.selectAll();
                    break;
                }
            }
        }
    }
   private void perkdf(KeyEvent e) {
        if(e.getSource() instanceof JTextField){
            JTextField j = (JTextField) e.getSource();
            boolean b=false;
            for (int i = Integer.parseInt(j.getParent().getName()); i < (Integer.parseInt(j.getParent().getName())+10); i++) {
                if(purchaseProducts[i+1]!=null&&purchaseProducts[i+1].isDisplayable())
                {
                    JTextField j1= (JTextField) purchaseProducts[i+1].getComponent(2);
                    j1.requestFocus();j1.selectAll();b=false;break;
                }else{b=true;}
            }
            if(b&&purchaseProducts[productCount].getSeek().isEditable()){
                    /*JOptionPane.showMessageDialog(j, "Info","InfoBox: ", JOptionPane.INFORMATION_MESSAGE);*/
                addRow();purchaseProducts[productCount].getSeek().requestFocus();
            }
        }
    }
   private void perke(KeyEvent e) {
        if(e.getSource() instanceof JTextField){
            JTextField j = (JTextField) e.getSource();
            if(gci(j)!=20){
                JTextField j1=(JTextField) j.getParent().getComponent(gci(j)+1); j1.requestFocus();j1.selectAll();
            }else{
                perkdf(e);
            }
        }
    }
   private void perku(KeyEvent e) {
        if(e.getSource() instanceof JTextField){
            JTextField j = (JTextField) e.getSource();
            for (int i = Integer.parseInt(j.getParent().getName()); (i > (Integer.parseInt(j.getParent().getName())-10)&&i>0); i--) {
                if(purchaseProducts[i-1]!=null&&purchaseProducts[i-1].isDisplayable())
                {
                    JTextField j1= (JTextField) purchaseProducts[i-1].getComponent(gci(j));
                    j1.requestFocus();
                    j1.selectAll();
                    break;
                }
            }
        }
    }
    int i;
    private void addRow() {
        productCount++;
        purchaseProducts[productCount]=new PakIssueRtnFieldPanel();
        purchaseProducts[productCount].setName(productCount+"");
        purchaseProducts[productCount].setSeqNoText(productCount+"");
        for (i = 0; i < 22; i++) {
            switch(i)
            {
                case 1:case 4:case 3: case 6:case 5:case 7:case 8:case 9:case 10:case 11:case 13:case 12:case 14:case 15:case 16:case 17:case 18:case 19:case 20:
                purchaseProducts[productCount].getComponent(i).addKeyListener(new KeyAdapter(){
                    public void keyReleased(KeyEvent e) {
                        int keyCode = e.getKeyCode();
                        switch( keyCode ) { 
                            case KeyEvent.VK_UP:
                                perku(e);
                                break;
                            case KeyEvent.VK_DOWN:
                                perkd(e);
                                break;
                            case KeyEvent.VK_ENTER:
                                //if(i!=4){
                                    perke(e);
//                                }
                                break;
                        }
                    }
                });
                break;
                case 2:
                    purchaseProducts[productCount].getComponent(i).addKeyListener(new KeyAdapter(){
                        public void keyReleased(KeyEvent e) {
                            int keyCode = e.getKeyCode();
                            switch( keyCode ) { 
                                case KeyEvent.VK_UP:
                                    perku(e);
                                    break;
                                case KeyEvent.VK_DOWN:
                                    perkd(e);
                                    break;
                            }
                        }
                    });
                    break;
            }
        }
        purchaseProducts[productCount].getGrossAmt().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
            }
        });
        purchaseProducts[productCount].getRate().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
            }
        });
        purchaseProducts[productCount].getFmr().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
            }
        });
        purchaseProducts[productCount].getFmrrs().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
            }
        });
        purchaseProducts[productCount].getTdo().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
            }
        });
        purchaseProducts[productCount].getSeek().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
                setBalQty(e);
            }
        });
        
        purchaseProducts[productCount].getRate().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
            }
        });
        purchaseProducts[productCount].getTotalQty().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {                                                                                   /*System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());*/                                                                                                       
                JTextField t1 = (JTextField) e.getSource();            
                updateSumSplPanel();
                applySchemes(t1);
            }
        });
        purchaseProducts[productCount].getTaxPer().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
            }
        });
        purchaseProducts[productCount].getTaxRs().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
            }
        });
        purchaseProducts[productCount].getDiscPer().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
            }
        });
        purchaseProducts[productCount].getDiscRs().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
            }
        });
        purchaseProducts[productCount].getReturnQty().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
                JTextField t1 = (JTextField) e.getSource(); 
                updateSumSplPanel();
                applySchemes(t1);
            }
        });
       
        //seekInputMethodTextChanged
        /*
        purchaseProducts[productCount].getpName().addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent pme) {
                updateSumSplPanel();
                setBalQty(pme);
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent pme) {
                updateSumSplPanel();
                setBalQty(pme);
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent pme) {
                updateSumSplPanel();
                setBalQty(pme);
            }

        });
        */
        purchaseProducts[productCount].getjLabel2().addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JLabel label = (JLabel)e.getSource();
                if(label.isEnabled()){
                    if(JOptionPane.showConfirmDialog(j,
                    "Are you sure ! \nOn selecting \"Yes\" this will Delete the Row...\n\n Deleted Row can not be restored  . . .", "Confermation Diloge",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ //ConfermationDiloge()){
                        btnCancel.setVisible(false);
                        btnexit.setVisible(false);
                        removeRow(Integer.parseInt(label.getParent().getName()));
                        deletePurchaseProduct(invNo.getText(), label.getParent().getName(), purchaseProducts[Integer.parseInt(label.getParent().getName())].getTotalQtyText(), purchaseProducts[Integer.parseInt(label.getParent().getName())].getSeekText(),purchaseProducts[Integer.parseInt(label.getParent().getName())].getSeqNoText());
                        updateSumSplPanel();
                    }
                }
            }
        });
        initializePanelListner(purchaseProducts[productCount]);
        purchasePanel.add(purchaseProducts[productCount]);
    }
    private void applySchemes(JTextField t1) {
        if(cbSchRs.isSelected()){purchaseProducts[Integer.parseInt(t1.getParent().getName())].getTdo().setText(setTdo(purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText(),purchaseProducts[Integer.parseInt(t1.getParent().getName())].getTotalQtyText()));purchaseProducts[Integer.parseInt(t1.getParent().getName())].frmNetAmount();}
        if(cbSchQty.isSelected()){purchaseProducts[Integer.parseInt(t1.getParent().getName())].getFree().setText(setBns(purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText(),purchaseProducts[Integer.parseInt(t1.getParent().getName())].getTotalQtyText()));purchaseProducts[Integer.parseInt(t1.getParent().getName())].frmNetAmount();}
    }
    private void setBalQty(KeyEvent e) {
//        try {
//            PAK_DB data =new PAK_DB();
//            
//            
//            ArrayList<String> temp;
//            JTextField f = (JTextField) e.getSource();
//            if(!f.getText().equals("")){
//                temp=data.find_product_rec_by_code(connAA, f.getText());
//                if(temp!=null){
//                    for(int i=0;i<temp.size();i++){
//                        if(i==9){//||i==6||i==10){
//                            balQty.setText(temp.get(i));
//                        }
//                    }
//                }
//            }
//            data.close_database(connAA);
//        } catch (SQLException ex) {
//            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    private void setBalQty(ActionEvent e) {
//        try {
//            PAK_DB data =new PAK_DB();
//            
//            
//            ArrayList<String> temp;
//            JComboBox f = (JComboBox) e.getSource();
//            System.out.println("");
//            System.out.println("================================");
//            System.out.println("f.getSelectedItem()"+f.getSelectedItem());
//            String item;
//            item = getSubName(f.getSelectedItem()+"");
//            System.out.println("item:"+item);
//            System.out.println("================================");
//            if(!f.getSelectedItem().equals("")){
//                String s12 =data.find_product_code_by_name(connAA, item);
//                if(s12!=null){
//                    temp=data.find_product_rec_by_code(connAA, s12);
//                    if(temp!=null){
//                        for(int i=0;i<temp.size();i++){
//                            if(i==9){//||i==6||i==10){
//                                balQty.setText(temp.get(i));
//                            }
//                        }
//                    }
//                }
//            }
//            data.close_database(connAA);
//        } catch (SQLException ex) {
//            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
//        }
   }
    private String getSubName(String p) {
        String s=p.substring(0, p.indexOf("|")-1);  
        return s;
    }
    private void setBalQty(PopupMenuEvent e) {
        PAK_DB data =new PAK_DB();
        ArrayList<String> temp;
        JComboBox f = (JComboBox) e.getSource();
        System.out.println("");
        System.out.println("****************");
        System.out.println("PopupMenuEvent"+f.getSelectedItem());
        System.out.println("****************");
    }
    private void addRow(int tempProductCount) {
        
        productCount=tempProductCount;
        addRow();
    }
    
    private void deletePurchaseProduct(String s,String s1,String s2,String s3,String s4) {
        PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
        
        try {
            
            String rs[] = data.get_pQty_saleQty( connAA, s,s4);     
            if(data.check_product_line_item_presence_new(connAA,s,s4,productCount)){
               
                data.delete_purchase_product(connAA, s, s1);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void removeRow(int productIndex) {
        //System.out.println("purchaseProducts["+productIndex+"] : "+purchaseProducts[productIndex].getName());
        purchasePanel.remove(purchaseProducts[productIndex]);
        purchasePanel.revalidate();
        purchasePanel.repaint();
    }

    private void forBackBtnEnable(boolean b) {
       btnFirst.setEnabled(b);
       btnLast.setEnabled(b);
       btnPrior.setEnabled(b);
       btnNext.setEnabled(b);
    }

    private void recEditBtnEnable(boolean b) {
//        btnDel.setEnabled(b);
        btnSearch.setEnabled(b);
        btnView.setEnabled(b);
        btnEdit.setEnabled(b);
    }

    private void saveUpdateBtnVisible(String s, boolean visibleProperty) {
        switch (s.toLowerCase()) {
            case "save":
                break;
            case "update":
                btnUpdate.setVisible(visibleProperty);
                btnIsRtn.setVisible(visibleProperty);
                break;
            case "search":
                btnSearchNow.setVisible(visibleProperty);
                break;
            case "all":
                btnSearchNow.setVisible(visibleProperty);
                btnUpdate.setVisible(visibleProperty);
                btnIsRtn.setVisible(visibleProperty);
                break;
        }
        btnCancel.setVisible(visibleProperty);
        
    }

    private void textFieldsNotEditable(boolean b) {
        invNo.setEditable(b);
        avediscper.setEditable(b);
        remaining.setEditable(b);
        discount.setEditable(b);
        grossAmt.setEditable(b);
        taxPer.setEditable(b);
        taxRs.setEditable(b);
        netAmt.setEditable(b);
        netpayable.setEditable(b);
        linvNo.setEditable(b);
        fmrsum.setEditable(b);
        fmrsumrs.setEditable(b);
    }
    public static boolean addClicked=false;
    private void textFieldsEditable(boolean b) {
        oDate.setEnabled(b);
        refNo.setEditable(b);
        remarks.setEnabled(b);
        splPer.setEditable(b);
        tdosum.setEditable(b);
        splRs.setEditable(b);
        otherExp.setEditable(b);
        paid.setEditable(b);
        vanName.setEnabled(b);
        vanCode.setEditable(b);
        if(addClicked){
            custCode.setEditable(true);
            suppName.setEnabled(true);
            dcode.setEditable(true);
            dName.setEnabled(true);
        }else{
            custCode.setEditable(false);
            suppName.setEnabled(false);
            dcode.setEditable(false);
            dName.setEnabled(false);
        }
        textFieldsNotEditable(false);
        editableProductPanel(b); 
        
    }
    
    private void setNullTextFields() {
        invNo.setText("");
        oDate.setDate(null);
        refNo.setText("");
        custCode.setText("");
        try {
            buildOneComboBoxModel("", "supp");//suppName.setText("");
        } catch (Exception ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
        remarks.setText("No Remarks");
        avediscper.setText("0.00");
        remaining.setText("0.00");
        discount.setText("0.00");
        grossAmt.setText("0.00");
        taxPer.setText("0.00");
        taxRs.setText("0.00");
        netAmt.setText("0.00");
        splPer.setText("0.00");
        fmrsum.setText("0.00");
        fmrsumrs.setText("0.00");
        tdosum.setText("0.00");
        splRs.setText("0.00");
        otherExp.setText("0.00");
        paid.setText("0.00");
        netpayable.setText("0.00");
        dcode.setText("");
        try {
            buildOneComboBoxModel("", "sm");//suppName.setText("");
        } catch (Exception ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
        inetializePrductPanel();
    }

    private void updateComboBox(JTextField textField,JComboBox comboBox,String c) throws Exception {
        comboBox.setModel(buildOneComboBoxModel(textField.getText(),c));
    }
    public static DefaultComboBoxModel buildAllComboBoxModel(String c,Connection cc) throws Exception {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
        
        ArrayList<String> elements = new <String> ArrayList() ;
        try {
            
            boolean tf=false;
             switch (c) {
                case "sm":
                    elements=data.find_all_sm_name_by_code(cc);
                    break;
                case "supp":
                    elements=data.find_all_supp_name_by_code(cc);
                    break;
                case "van":
                    elements=data.find_all_van_name_by_code(cc);
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
            
        } catch (SQLException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comboBoxModel;
    }
    public DefaultComboBoxModel buildOneComboBoxModel(String name,String c) throws Exception {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
        
        String s="*** NOT SELECTED ***";
        try {
            
            switch (c) {
                    case "sm":
                        if(!name.equals("")){
                            s=data.find_sm_name_by_code(connAA,name);
                            
                        }else{
                            comboBoxModel.addElement(name);
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                    case "supp":
                        if(!name.equals("")){
                            s=data.find_supp_name_by_code(connAA,name);
                        }else{
                            comboBoxModel.addElement(name);
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                    case "van":
                        if(!name.equals("")){
                            s=data.find_van_name_by_code(connAA,name);
                        }else{
                            comboBoxModel.addElement(name);
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                }
            comboBoxModel.addElement(s);
            
        } catch (SQLException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comboBoxModel;
    }

    private String getCode(String name,String c) {
        String s="";
        PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
        
        try {
            
            
            switch (c) {
                    case "sm":
                        if(!name.equals("")){
                            s=data.find_sm_code_by_name(connAA,name);
                        }else{
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                    case "supp":
                        if(!name.equals("")){
                            s=data.find_supp_code_by_name(connAA,name);
                        }else{
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                    case "van":
                        if(!name.equals("")){
                            s=data.find_van_code_by_name(connAA,name);
                        }else{
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                }  
            
        } catch (SQLException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    private void setFirstRec() throws ParseException {
        PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
       try {
            ArrayList<String> stock= data.get_first_purchase(connAA);
            if(stock==null){
                setNullTextFields();
                JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "No data Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }else{
                    setTextinPurchase(stock,dateField);
//                add.setText(stock.get(2));//from join 
//                cont.setText(stock.get(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setTextinPurchase(ArrayList<String> stock, Conversions dateField) {
        try {
            oDate.setDate(dateField.toDate(stock.get(0)));
            invNo.setText(stock.get(1));
            refNo.setText(stock.get(2));
            custCode.setText(stock.get(3));
            try {
                suppName.setModel(buildOneComboBoxModel(custCode.getText(),"supp"));
            } catch (Exception ex) {
                Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
            }
            grossAmt.setText(stock.get(4));
            fmrsumrs.setText(stock.get(5));
            
            splRs.setText(stock.get(6));
            frmSplPer();
            otherExp.setText(stock.get(7));
            avediscper.setText(stock.get(8));
            discount.setText(stock.get(9));
            taxPer.setText(stock.get(10));
            taxRs.setText(stock.get(11));
            netAmt.setText(stock.get(12));
            remaining.setText(stock.get(13));
            paid.setText(stock.get(14));
            remarks.setText(stock.get(15));
            netpayable.setText(stock.get(16));
            dcode.setText(stock.get(17));
            tdosum.setText(stock.get(18));
            splFmrPer.setText(stock.get(19));
            vanCode.setText(stock.get(20));
            try {
                vanName.setModel(buildOneComboBoxModel(vanCode.getText(),"van"));
            } catch (Exception ex) {
                Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
            }
            frmSplFmrRs();
             try {
                dName.setModel(buildOneComboBoxModel(dcode.getText(),"sm"));
            } catch (Exception ex) {
                Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
            }
            loadProductsPanel(invNo.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void recEditActionBtnVisible(boolean b) {
        btnUpdate.setVisible(b);
        btnIsRtn.setVisible(b);
        btnSearchNow.setVisible(b);
        btnCancel.setVisible(b);
    }

    private void styleComboBox(JComboBox combo) {
        combo.setRenderer(new DefaultListCellRenderer() {
            public void paint(Graphics g) {
                super.paint(g);
            }
        });
    }

    private void setLastRec() throws ParseException {
        PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
        try {
            ArrayList<String> stock = data.get_last_purchase(connAA);
            if(stock==null){
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Welcome Enter First Record", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                btnCancel.setVisible(false);
                editableProductPanel(true);
            }else{
                setTextinPurchase(stock, dateField);
                editableProductPanel(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setLastInvoice() {
        PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
        int max=data.find_max_in_purchase_code(connAA);
        if(max==0){
            linvNo.setText(null);
        }else{
            linvNo.setText(max+"");
        }
    }

    private void inetializePrductPanel() {
        editableProductPanel(true);
        purchasePanel.removeAll();
        purchasePanel.revalidate();
        purchasePanel.repaint();
        productCount=0;
        purchasePanel.add(purchaseHeaderPanel);
        addRow();
    }

    private void editableProductPanel(boolean b) {
        for(int i=1;i<=productCount;i++){
           if(purchaseProducts[i]!=null){
               purchaseProducts[i].textFieldsEditableProducts(b);
           }
           
        }
    }

    private void loadProductsPanel(String text) {
        try {
            inetializePrductPanel();
            PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
            ArrayList<String> name[]=data.search_products(connAA,text);
            removeRow(productCount);
            productCount--;
            int lastSeqNo=0;
            for(int i=0;i<name.length;i++){
                addRow(Integer.parseInt(name[i].get(1))-1);
                for(int j=0;j<16;j++){
                    switch(j)
                    {
                        case 0:
                            // Invoice No. is to just match with PERMAIN
                            break;
                        case 1:
                            purchaseProducts[productCount].setSeqNoText(name[i].get(j));
                            lastSeqNo=Integer.parseInt(name[i].get(j));
                            break;
                        case 2:
                            purchaseProducts[productCount].setSeek(name[i].get(j));
                            String temp = purchaseProducts[productCount].getSeekText();
                            purchaseProducts[productCount].setpName(temp);
                            break;
                        case 3:
                            purchaseProducts[productCount].getTotalQty1().setText(name[i].get(j));
                            purchaseProducts[productCount].frmCtn(purchaseProducts[productCount].getNoOfPcsInCtn());
                            purchaseProducts[productCount].frmPcs(purchaseProducts[productCount].getNoOfPcsInCtn());
                            break;
                        case 4:
                            purchaseProducts[productCount].setRate(name[i].get(j));
                            break;
                        case 5:
                            purchaseProducts[productCount].setGrossAmt(name[i].get(j));
                            break;
                        case 6:
                            purchaseProducts[productCount].setDiscPer(name[i].get(j));
                            purchaseProducts[productCount].frmDiscRs();
                            
                            break;
                        case 7:
                            purchaseProducts[productCount].getTdo().setText(name[i].get(j));
                            break;
                        case 8:
                            purchaseProducts[productCount].setTaxPer(name[i].get(j));
                            purchaseProducts[productCount].frmTaxRs();
                            break;
                        case 9:
                            purchaseProducts[productCount].getFmr().setText(name[i].get(j));
                            purchaseProducts[productCount].frmFmrRs();
                            break;
                        case 10:
                            purchaseProducts[productCount].setNetAmt(name[i].get(j));
                            break;
                        case 11:
                            purchaseProducts[productCount].getReturnQty().setText(name[i].get(j));
                            String qty1=purchaseProducts[productCount].getTotalQty1().getText();
                            String qty=purchaseProducts[productCount].getReturnQty().getText();
//                            System.out.println("QTY "+qty);System.out.println("name[i].get(j) "+name[i].get(j));System.out.println("QTY "+qty1);
                            BigDecimal d3 = new BigDecimal((qty1!=null)?qty1:"0");
                            BigDecimal d4 = new BigDecimal((!qty.isEmpty())?qty:"0");
                            purchaseProducts[productCount].getTotalQty().setText(round(d3.subtract(d4),3)+"");
                            break;
                        case 12:
//                            purchaseProducts[productCount].getCustomSize().setText(name[i].get(j));
//                            purchaseProducts[productCount].setAllFieldData();
                            break;
                        case 13:
                            purchaseProducts[productCount].getDamage().setText(name[i].get(j));
                            break;
                        case 14:
                            purchaseProducts[productCount].getFree().setText(name[i].get(j));
                            break;
                        case 15:
                            DefaultComboBoxModel comboBoxModel1 = new DefaultComboBoxModel();
                            comboBoxModel1.addElement(name[i].get(j));
                            purchaseProducts[productCount].getDate().setModel(comboBoxModel1);
                            break;
                    }
                }
            }
            PAK_GENERAL_DB data1 =new PAK_GENERAL_DB();
            try {
                issueLoad.setText(data1.getIL(connAA,dateField.toDateString(oDate.getDate().toString()),dcode.getText(),vanCode.getText()));
                totalLoad.setText(data1.getTL(connAA,dateField.toDateString(oDate.getDate().toString()),dcode.getText(),vanCode.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateSumSplPanel();
            productCount=lastSeqNo;
            editableProductPanel(false);
        } catch (SQLException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void updateSumSplPanel() {
        String sumGrossAmt="";
        String sumTaxRs="";
        String sumDiscRs="";
        String sumNetAmt="";
        String sumfmrRs="";
        String sumtdo="";
        
        Float sumGrossAmt1=0.0f;
        Float sumTaxRs1=0.0f;
        Float sumDiscRs1=0.0f;
        Float sumNetAmt1=0.0f;
        Float sumfmr1=0.0f;
        Float sumtdo1=0.0f;
        
        BigDecimal sumGrossAmt2= new BigDecimal(0.0);
        BigDecimal sumTaxRs2=new BigDecimal(sumTaxRs1+"");
        BigDecimal sumDiscRs2=new BigDecimal(sumGrossAmt1+"");
        BigDecimal sumNetAmt2=new BigDecimal(sumNetAmt1+"");
        BigDecimal sumfmr2rs=new BigDecimal(sumfmr1+"");
        BigDecimal sumtdo2=new BigDecimal(sumtdo1+"");
        
        for(int i=1;i<=productCount;i++){
            //System.out.println("-> "+i+" : productCount->"+productCount);
            if(purchaseProducts[i]!=null&&purchaseProducts[i].isDisplayable() ){
//                System.out.println("GrossAmt:"+purchaseProducts[i].getGrossAmtText());
//                System.out.print(" TaxRs:"+purchaseProducts[i].getTaxRsText());
//                System.out.print(" DiscRs:"+purchaseProducts[i].getDiscRsText());
//                System.out.print(" NetAmt:"+purchaseProducts[i].getNetAmtText());
                
                //sumGrossAmt1=sumGrossAmt1+Float.parseFloat(purchaseProducts[i].getGrossAmtText());
                sumGrossAmt2=sumGrossAmt2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getGrossAmtText())));
                //sumTaxRs1=sumTaxRs1+Float.parseFloat(purchaseProducts[i].getTaxRsText());
                sumTaxRs2=sumTaxRs2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getTaxRsText())));

                sumfmr2rs=sumfmr2rs.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getFmrrs().getText())));
                //sumDiscRs1=sumDiscRs1+Float.parseFloat(purchaseProducts[i].getDiscRsText());
                sumDiscRs2=sumDiscRs2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getDiscRsText())));
                //sumNetAmt1=sumNetAmt1+Float.parseFloat(purchaseProducts[i].getNetAmtText());
//                sumNetAmt2=(sumNetAmt2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getNetAmtText())))).subtract(new BigDecimal(-Float.parseFloat(purchaseProducts[i].getFmr().getText()));
                sumNetAmt2=sumNetAmt2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getNetAmtText())));
                
//                float gAmount = Float.parseFloat(purchaseProducts[i].getGrossAmt().getText());
//                float fmr = Float.parseFloat(purchaseProducts[i].getFmr().getText());
//                sumfmr2rs=sumfmr2rs.add(BigDecimal.valueOf((gAmount*fmr)/100));
                
                sumtdo2=sumtdo2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getTdo().getText())));
                
                sumTaxRs1=sumTaxRs1+Float.parseFloat(purchaseProducts[i].getTaxRsText());
            }
        }
        
        System.out.print("Sum is "+sumGrossAmt1);
//        sumGrossAmt=sumGrossAmt1+"";
//        sumTaxRs=sumTaxRs1+"";
//        sumDiscRs=sumDiscRs1+"";
//        sumNetAmt=sumNetAmt1+"";
        sumGrossAmt=round(sumGrossAmt2,3)+"";
        sumTaxRs=round(sumTaxRs2,3)+"";
        sumDiscRs=round(sumDiscRs2,3)+"";
        sumNetAmt=round(sumNetAmt2,3)+"";
        sumfmrRs=round(sumfmr2rs,3)+"";
        sumtdo=round(sumtdo2,3)+"";
        
        try{
           netAmt.setText(sumNetAmt);
           fmrsumrs.setText(sumfmrRs);
           tdosum.setText(sumtdo);
           
           grossAmt.setText(sumGrossAmt);
           
           taxRs.setText(sumTaxRs);
           
           discount.setText(sumDiscRs);
           
           BigDecimal temp = sumTaxRs2.multiply(BigDecimal.valueOf(Float.parseFloat("100.0")));
           BigDecimal result=new BigDecimal("0.0");
           if(!(sumGrossAmt2.compareTo(BigDecimal.ZERO) == 0)){
               result = temp.divide(sumGrossAmt2,3,BigDecimal.ROUND_HALF_UP);
           }
           taxPer.setText(round((result),3)+"");
           
           BigDecimal temp3 = sumfmr2rs.multiply(BigDecimal.valueOf(Float.parseFloat("100.0")));
           BigDecimal result2=new BigDecimal("0.0");
           if(!(sumGrossAmt2.compareTo(BigDecimal.ZERO) == 0)){
               result2 = temp3.divide(sumGrossAmt2,3,BigDecimal.ROUND_HALF_UP);
           }
           fmrsum.setText(round((result2),3)+"");
           
//           fmrsumrs.setText(round((sumfmr2rs),3)+"");
           
           
//           avediscper.setText(round((Float.parseFloat(sumDiscRs)*100/Float.parseFloat(sumGrossAmt)),3)+"");
           BigDecimal temp1 = sumDiscRs2.multiply(BigDecimal.valueOf(Float.parseFloat("100.0")));
           BigDecimal result1=new BigDecimal("0.0");
           if(!(sumGrossAmt2.compareTo(BigDecimal.ZERO) == 0)){
                result1 = temp1.divide(sumGrossAmt2,3,BigDecimal.ROUND_HALF_UP);
            }
           avediscper.setText(round((result1),3)+"");
           
//           netAmt.setText(Double.parseDouble(sumNetAmt)+"");
//           grossAmt.setText((Double.parseDouble(sumGrossAmt))+"");
//           taxRs.setText((Double.parseDouble(sumTaxRs))+"");
//           discount.setText((Double.parseDouble(sumDiscRs))+"");
//           taxPer.setText(((Double.parseDouble(sumTaxRs)*100) / Double.parseDouble(sumGrossAmt))+"");
//           avediscper.setText((Double.parseDouble(sumDiscRs)*100/Double.parseDouble(sumGrossAmt))+"");
           
//           frmSplRs();
           frmSplFmrRs();
           frmNetPayable();
           frmRemaning();
        }catch(NumberFormatException ex){
            if(ex.getMessage()!=null ){//&& !ex.getMessage().equals("")
                if(ex.getMessage().matches("empty String")){
                }else{
                    JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "Invalid Input", "InfoBox: ", JOptionPane.ERROR_MESSAGE);
        //                //System.out.println("Number Format is InCorrect: "+ex.getMessage());
                }
            }
        }
    }

    private void frmSplPer() {
        try{
            BigDecimal splRsBD = BigDecimal.valueOf(Float.parseFloat(splRs.getText()));
            BigDecimal netAmtBD = BigDecimal.valueOf(Float.parseFloat(netAmt.getText()));
            BigDecimal temp1 = splRsBD.multiply(new BigDecimal("100.0"));
            if (netAmtBD.compareTo(new BigDecimal("0"))==0) {
                splPer.setText(new BigDecimal("0")+"");
            }else{
                BigDecimal result1 = temp1.divide(netAmtBD,3,BigDecimal.ROUND_HALF_UP);
                splPer.setText(round((result1),3)+"");
            }
        }catch(NumberFormatException ex){
            if(ex.getMessage().matches("empty String")){
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Invalid Input", "InfoBox: ", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void frmSplFmrPer() {
        try{
           //splPer.setText(round((Float.parseFloat(splRs.getText())*100)/Float.parseFloat(netAmt.getText()),3)+"");
           BigDecimal splRsBD = BigDecimal.valueOf(Float.parseFloat(splFmrRs.getText()));
            BigDecimal netAmtBD = BigDecimal.valueOf(Float.parseFloat(netAmt.getText()));
            BigDecimal temp1 = splRsBD.multiply(new BigDecimal("100.0"));
            BigDecimal result1 = temp1.divide(netAmtBD,3,BigDecimal.ROUND_HALF_UP);
            splFmrPer.setText(round((result1),3)+"");
        }catch(NumberFormatException ex){
            if(ex.getMessage().matches("empty String")){
//                //System.out.println("Do Nothing: "+ex);
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Invalid Input", "InfoBox: ", JOptionPane.ERROR_MESSAGE);
                
//                //System.out.println("Number Format is InCorrect: "+ex.getMessage());
            }
        }
    }
    private void frmSplRs() {
         try{
//            splRs.setText(round((Float.parseFloat(splPer.getText())*Float.parseFloat(netAmt.getText())/100),3)+"");
            BigDecimal splPerBD = BigDecimal.valueOf(Float.parseFloat(splPer.getText()));
            BigDecimal netAmtBD = BigDecimal.valueOf(Float.parseFloat(netAmt.getText()));
            BigDecimal temp1 = splPerBD.multiply(netAmtBD);
            BigDecimal result1 = temp1.divide(BigDecimal.valueOf(Float.parseFloat("100.0")),3,BigDecimal.ROUND_HALF_UP);
            splRs.setText(round((result1),3)+"");
        }catch(NumberFormatException ex){
            if(ex.getMessage().matches("empty String")){
//                //System.out.println("Do Nothing: "+ex);
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Invalid Input", "InfoBox: ", JOptionPane.ERROR_MESSAGE);
                
//                //System.out.println("Number Format is InCorrect: "+ex.getMessage());
            }
        }
    }
    
   public static final int gci(Component component) {
    if (component != null && component.getParent() != null) {
      Container c = component.getParent();
      for (int i = 0; i < c.getComponentCount(); i++) {
        if (c.getComponent(i) == component)
          return i;
      }
    }

    return -1;
  }
    private void frmSplFmrRs() {
         try{
//            splRs.setText(round((Float.parseFloat(splPer.getText())*Float.parseFloat(netAmt.getText())/100),3)+"");
            BigDecimal splPerBD = BigDecimal.valueOf(Float.parseFloat(splFmrPer.getText()));
            BigDecimal netAmtBD = BigDecimal.valueOf(Float.parseFloat(netAmt.getText()));
            BigDecimal temp1 = splPerBD.multiply(netAmtBD);
            BigDecimal result1 = temp1.divide(BigDecimal.valueOf(Float.parseFloat("100.0")),3,BigDecimal.ROUND_HALF_UP);
            splFmrRs.setText(round((result1),3)+"");
        }catch(NumberFormatException ex){
           
        }
    }


    private void frmNetPayable() {
        try{
//           netpayable.setText(round((Float.parseFloat(netAmt.getText())-Float.parseFloat(splRs.getText()))+Float.parseFloat(otherExp.getText()),3)+"");
            BigDecimal splRsBD = BigDecimal.valueOf(Float.parseFloat(splRs.getText()));
            BigDecimal netAmtBD = BigDecimal.valueOf(Float.parseFloat(netAmt.getText()));
            BigDecimal otherExpBD = BigDecimal.valueOf(Float.parseFloat(otherExp.getText()));
            BigDecimal temp1 = netAmtBD.subtract(splRsBD);
            BigDecimal result1 = temp1.add(otherExpBD);
            result1=result1.subtract(BigDecimal.valueOf(Float.parseFloat(splFmrRs.getText())));
            netpayable.setText(round((result1),3)+"");
        }catch(NumberFormatException ex){
            if(ex.getMessage().matches("empty String")){
//                //System.out.println("Do Nothing: "+ex);
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Invalid Input", "InfoBox: ", JOptionPane.ERROR_MESSAGE);
//                //System.out.println("Number Format is InCorrect: "+ex.getMessage());
            }
        }
    }

    private void frmRemaning() {
        try{
//           remaining.setText(round((Float.parseFloat(netpayable.getText())-Float.parseFloat(paid.getText())),3)+"");
            BigDecimal paidBD = BigDecimal.valueOf(Float.parseFloat(paid.getText()));
            BigDecimal netpayableBD = BigDecimal.valueOf(Float.parseFloat(netpayable.getText()));
            BigDecimal temp1 = netpayableBD.subtract(paidBD);
            remaining.setText(round((temp1),3)+"");
        }catch(NumberFormatException ex){
            if(ex.getMessage().matches("empty String")){
//                //System.out.println("Do Nothing: "+ex);
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Invalid Input", "InfoBox: ", JOptionPane.ERROR_MESSAGE);
//                //System.out.println("Number Format is InCorrect: "+ex.getMessage());
            }
        }
    }

   private void findRecords(String text) {
        PAK_ISSUE_SALERTN_DB data =new PAK_ISSUE_SALERTN_DB();
        try {
            ArrayList<String> s=data.find_purchase_by_code(connAA, text);
            if (s!=null){
                saveUpdateBtnVisible("all", false);
                setTextinPurchase(s, dateField);
                textFieldsEditable(false);
                forBackBtnEnable(true);
                recEditBtnEnable(true);
                recEditActionBtnVisible(false);
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Not Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
            System.out.println("Asset Found is findRecords:"+ s);
        } catch (SQLException ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private GraphicsEnvironment setEnvironment() {
        return getLocal();
    }

    private GraphicsEnvironment getLocal() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment();
    }

    private void boundsSize() {
        this.setMaximizedBounds(setEnvironment().getMaximumWindowBounds());
    }

    private void extend() {
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
    }

    private void maximize() {
        boundsSize();
        extend();
    }

    private int getIndex(String get) {
        int s=0;
        switch (get) {
            case "1":
                s=0;
//                s="Monthly";
                break;
            case "2":
                s=1;
//                s="Bi Monthly";
                break;
            case "3":
                s=2;
//                s="Quaterly";
                break;
            case "6":
                s=3;
//                s="Semi Anually";
                break;
            case "12":
                s=4;
//                s="Anually";
                break;
        }
        return s;
    }
    private String setTdo(String pCode,String totalQty) {
        String s="0";
            PAK_GENERAL_DB data =new PAK_GENERAL_DB();
            try {
                s=data.getCalculatedTdo(connAA,dateField.toReturnedDate(oDate.getDate()+""),pCode,totalQty);
            } catch (Exception ex) {
                Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
            }
        return s;
    }
    private String setBns(String pCode,String totalQty) {
        String s="0";
        PAK_GENERAL_DB data =new PAK_GENERAL_DB();
        try {
            s=data.getCalculatedBns(connAA,dateField.toReturnedDate(oDate.getDate()+""),pCode,totalQty);
        } catch (Exception ex) {
            Logger.getLogger(ISSUERTN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    private void ffs() {
        for(int i=1;i<=productCount;i++){
            if(purchaseProducts[i].isDisplayable()){
                purchaseProducts[i].getSeek().requestFocus();
                purchaseProducts[i].getSeek().selectAll();
                break;
            }
        }

    }
    
}