/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.frames.sales;

import DB.PAK_DB;
import DB.PAK_GENERAL_DB;
import DB.PAK_GLOBAL_DB;
import DB.PAK_SALE_DB;
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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.table.DefaultTableModel;
import logical.Conversions;
import logical.dateIncrementer;
import newpackage.ButtonTextFieldCellTest;
import static DynamicERP.dialoge.viewforms.ViewFormId11.isSaved;
import DynamicERP.dialoge.viewforms.dialogeClass;
import static DynamicERP.frames.sales.PakSalesFieldPanel1.round;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import DynamicERP.frames.purchase.PURCHASE;
import DynamicERP.frames.relationalforms.RECOVERY;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.JTableHeader;
import logical.EcLogger;

/**
 *
 * @author Shan
 */
public class SALES extends 
        javax.swing.JFrame {
    Conversions dateField=new Conversions();//dateField.toReturnedDate(odDate.getDate()+"")  dateField.toDateString(odDate.getDate().toString()),
    dateIncrementer dateField1=new dateIncrementer();

    /**
     * Creates new form PURCHASE
     */PAK_GLOBAL_DB dataAA =new PAK_GLOBAL_DB();
    Connection connAA;
    
    public SALES() {
        initComponents();
        styleComboBox(custName);
        styleComboBox(dName);
        styleComboBox(vanName);
        styleComboBox(obName);
        
        radioQty.add(radioCatinQty);//radioCatinQty.setSelected(true);
        radioQty.add(radioSubCatinQty);radioQty.add(radioProSchQty);
        
        radioRs.add(radioProinRS);//radioProinRS.setSelected(true);
        radioRs.add(radioCatinRS);radioRs.add(RadioSubCatinRS);
        
        maximize();
//        btnShowOrder.setVisible(false);
            try {
                connAA = dataAA.connect_database();
            
            }catch (SQLException e) {
                //System.out.println("Exception ===> "+e);
            }    
        panel.setBorder(BorderFactory.createTitledBorder("Sales Invoice Properties: "));
        purchaseScrollPane.setBorder(BorderFactory.createTitledBorder("Products Sales Adjustments in invoice: "));
        splPanel.setBorder(BorderFactory.createTitledBorder(""));        
        pan_history.setBorder(BorderFactory.createTitledBorder("Product History As per Clients: "));
        tbcustom.setBorder(BorderFactory.createTitledBorder("Custom Requirments: "));
        pan_print.setBorder(BorderFactory.createTitledBorder(""));
        adjustments.setBorder(BorderFactory.createTitledBorder("Scheme Adjustments"));
        saveUpdateBtnVisible("all", false);
        textFieldsEditable(false);
        initPanel();
        
        purchaseScrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getValue());  
            }
        });
        
        /*
        purchaseScrollPane.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getValue());  
            }
        });
        AdjustmentListener listener = new MyAdjustmentListener();
        purchaseScrollPane.getHorizontalScrollBar().addAdjustmentListener(listener);
        purchaseScrollPane.getVerticalScrollBar().addAdjustmentListener(listener);
        */
        try {setLastRec();} catch (ParseException ex) {Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);}setLastInvoice();khaliTable();
        purchaseScrollPane.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
        public void adjustmentValueChanged(AdjustmentEvent e) {
            e.getAdjustable().setValue(e.getAdjustable().getValue());  
        }
    }); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioQty = new javax.swing.ButtonGroup();
        radioRs = new javax.swing.ButtonGroup();
        btnShowOrder = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        link9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        splPanel = new javax.swing.JPanel();
        fmrsumrs = new javax.swing.JTextField();
        fmrsum = new javax.swing.JTextField();
        Builty14 = new javax.swing.JLabel();
        Builty3 = new javax.swing.JLabel();
        taxPer = new javax.swing.JTextField();
        taxRs = new javax.swing.JTextField();
        discount = new javax.swing.JTextField();
        avediscper = new javax.swing.JTextField();
        Builty2 = new javax.swing.JLabel();
        Builty19 = new javax.swing.JLabel();
        Builty20 = new javax.swing.JLabel();
        grossAmt = new javax.swing.JTextField();
        tosum = new javax.swing.JTextField();
        netAmt = new javax.swing.JTextField();
        Builty8 = new javax.swing.JLabel();
        Builty13 = new javax.swing.JLabel();
        Builty1 = new javax.swing.JLabel();
        splFmrRs = new javax.swing.JTextField();
        splFmrPer = new javax.swing.JTextField();
        Builty16 = new javax.swing.JLabel();
        Builty11 = new javax.swing.JLabel();
        splPer = new javax.swing.JTextField();
        splRs = new javax.swing.JTextField();
        Builty21 = new javax.swing.JLabel();
        Builty17 = new javax.swing.JLabel();
        otherExp = new javax.swing.JTextField();
        Builty12 = new javax.swing.JLabel();
        netpayable = new javax.swing.JTextField();
        paid = new javax.swing.JTextField();
        remaining = new javax.swing.JTextField();
        Builty4 = new javax.swing.JLabel();
        Builty15 = new javax.swing.JLabel();
        Builty18 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        invNo = new javax.swing.JTextField();
        refNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        custCode = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        custName = new javax.swing.JComboBox();
        dlDate = new com.toedter.calendar.JDateChooser();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrior = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSearchNow = new javax.swing.JButton();
        btnAddRow = new javax.swing.JButton();
        dName = new javax.swing.JComboBox();
        dcode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        vanCode = new javax.swing.JTextField();
        vanName = new javax.swing.JComboBox();
        odDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        obName = new javax.swing.JComboBox();
        obCode = new javax.swing.JTextField();
        netTotalStock = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        remarks = new javax.swing.JTextField();
        pan_print = new javax.swing.JPanel();
        btnexit = new javax.swing.JButton();
        print2 = new javax.swing.JButton();
        issueLoad = new javax.swing.JTextField();
        totalLoad = new javax.swing.JTextField();
        Builty22 = new javax.swing.JLabel();
        Builty23 = new javax.swing.JLabel();
        Builty24 = new javax.swing.JLabel();
        preBal = new javax.swing.JTextField();
        Builty26 = new javax.swing.JLabel();
        netBal = new javax.swing.JTextField();
        adjustments = new javax.swing.JPanel();
        cbSlab = new javax.swing.JCheckBox();
        pan_schemeinQty = new javax.swing.JPanel();
        cbQty = new javax.swing.JCheckBox();
        radioCatinQty = new javax.swing.JRadioButton();
        radioProSchQty = new javax.swing.JRadioButton();
        radioSubCatinQty = new javax.swing.JRadioButton();
        pan_schemeinRS = new javax.swing.JPanel();
        cbRs = new javax.swing.JCheckBox();
        RadioSubCatinRS = new javax.swing.JRadioButton();
        radioProinRS = new javax.swing.JRadioButton();
        radioCatinRS = new javax.swing.JRadioButton();
        purchaseScrollPane = new javax.swing.JScrollPane();
        tbpancustom = new javax.swing.JTabbedPane();
        tbcustom = new javax.swing.JPanel();
        cbInvByCust = new javax.swing.JCheckBox();
        pan_history = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        custHistory = new javax.swing.JTable();
        cbHistory = new javax.swing.JCheckBox();
        linvNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        expiryDtl = new javax.swing.JTable();

        btnShowOrder.setText("Show Order");
        btnShowOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowOrderActionPerformed(evt);
            }
        });

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
        jLabel9.setText("Sales Record Managements");
        jLabel9.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(435, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap(435, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(link9, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(link9)
                .addContainerGap())
        );

        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1282, 663));

        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 700));

        fmrsumrs.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        fmrsumrs.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fmrsumrs.setText("0.0");
        fmrsumrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmrsumrsActionPerformed(evt);
            }
        });
        fmrsumrs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fmrsumrsKeyReleased(evt);
            }
        });

        fmrsum.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        fmrsum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fmrsum.setText("0.0");
        fmrsum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmrsumActionPerformed(evt);
            }
        });
        fmrsum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fmrsumKeyReleased(evt);
            }
        });

        Builty14.setText("FMR");

        Builty3.setText("Tax");

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

        Builty2.setText("Discount");

        Builty19.setText("%age");

        Builty20.setText("In Rupees");

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

        tosum.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        tosum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tosum.setText("0.0");
        tosum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tosumActionPerformed(evt);
            }
        });
        tosum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tosumKeyReleased(evt);
            }
        });

        netAmt.setEditable(false);
        netAmt.setBackground(new java.awt.Color(0, 204, 102));
        netAmt.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        netAmt.setForeground(new java.awt.Color(255, 255, 255));
        netAmt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        netAmt.setText("0.0");
        netAmt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                netAmtCaretUpdate(evt);
            }
        });
        netAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netAmtActionPerformed(evt);
            }
        });

        Builty8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Builty8.setText("After To & Tax:");

        Builty13.setText("Trade Offer");

        Builty1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Builty1.setText("Gross Amount:");

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                splFmrRsKeyTyped(evt);
            }
        });

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

        Builty16.setText("SPL FMR");

        Builty11.setText("SPL Disc");

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

        Builty21.setText("In Rupees");

        Builty17.setText("%age");

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

        Builty15.setText("Paid");

        Builty18.setText("Net Payable");

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout splPanelLayout = new javax.swing.GroupLayout(splPanel);
        splPanel.setLayout(splPanelLayout);
        splPanelLayout.setHorizontalGroup(
            splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(splPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Builty14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Builty3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Builty2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(6, 6, 6)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Builty19)
                    .addGroup(splPanelLayout.createSequentialGroup()
                        .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fmrsum, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(taxPer, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(avediscper, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(taxRs, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Builty20)
                            .addComponent(fmrsumrs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Builty8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Builty13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Builty1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(netAmt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tosum, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grossAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(splPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Builty17)
                        .addGap(20, 20, 20)
                        .addComponent(Builty21)
                        .addGap(30, 30, 30))
                    .addGroup(splPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, splPanelLayout.createSequentialGroup()
                                .addComponent(Builty12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(otherExp))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, splPanelLayout.createSequentialGroup()
                                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Builty11)
                                    .addComponent(Builty16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(splPer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(splFmrPer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(splFmrRs)
                                    .addComponent(splRs, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(remaining, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(paid, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(netpayable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(splPanelLayout.createSequentialGroup()
                        .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Builty18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Builty4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Builty15, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(104, 104, 104)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        splPanelLayout.setVerticalGroup(
            splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(splPanelLayout.createSequentialGroup()
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(splPanelLayout.createSequentialGroup()
                        .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Builty19)
                            .addComponent(Builty20))
                        .addGap(1, 1, 1)
                        .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(avediscper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Builty2)
                            .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Builty3)
                            .addComponent(taxPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(taxRs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Builty14)
                            .addComponent(fmrsum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fmrsumrs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(splPanelLayout.createSequentialGroup()
                        .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Builty1)
                            .addComponent(grossAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Builty13)
                            .addComponent(tosum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(netAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Builty8)))
                    .addGroup(splPanelLayout.createSequentialGroup()
                        .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Builty17)
                            .addComponent(Builty21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(splPanelLayout.createSequentialGroup()
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
                                    .addComponent(Builty4)))
                            .addGroup(splPanelLayout.createSequentialGroup()
                                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Builty11)
                                    .addComponent(splPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(splRs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Builty16)
                                    .addComponent(splFmrPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(splFmrRs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Builty12)
                                    .addComponent(otherExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator11, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jLabel1.setText("Invoice No:");

        jLabel2.setText("Ref No:");

        invNo.setEditable(false);
        invNo.setBackground(new java.awt.Color(204, 255, 204));
        invNo.setPreferredSize(new java.awt.Dimension(0, 25));
        invNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invNoActionPerformed(evt);
            }
        });

        refNo.setText(" ");
        refNo.setPreferredSize(new java.awt.Dimension(0, 25));
        refNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refNoActionPerformed(evt);
            }
        });

        jLabel5.setText(" Dlivery Dt:");

        custCode.setPreferredSize(new java.awt.Dimension(0, 25));
        custCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custCodeActionPerformed(evt);
            }
        });
        custCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                custCodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                custCodeKeyReleased(evt);
            }
        });

        jLabel7.setText("Remarks:");

        jLabel8.setText("Customer:");

        custName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        custName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        custName.setPreferredSize(new java.awt.Dimension(0, 25));
        custName.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                custNamePopupMenuWillBecomeVisible(evt);
            }
        });
        custName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custNameActionPerformed(evt);
            }
        });

        dlDate.setPreferredSize(new java.awt.Dimension(0, 25));

        btnAdd.setBackground(new java.awt.Color(0, 102, 51));
        btnAdd.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setMnemonic('A');
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

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

        btnDel.setBackground(new java.awt.Color(255, 102, 102));
        btnDel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnDel.setMnemonic('D');
        btnDel.setText("Delete");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
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

        btnSave.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnSave.setMnemonic('S');
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
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

        btnAddRow.setMnemonic('A');
        btnAddRow.setText("Add Row");
        btnAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRowActionPerformed(evt);
            }
        });

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

        jLabel12.setText("Van:");

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

        odDate.setPreferredSize(new java.awt.Dimension(0, 25));

        jLabel6.setText("Order Date:");

        jLabel13.setText("Booker:");

        obName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        obName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        obName.setPreferredSize(new java.awt.Dimension(0, 25));
        obName.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                obNamePopupMenuWillBecomeVisible(evt);
            }
        });
        obName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obNameActionPerformed(evt);
            }
        });

        obCode.setPreferredSize(new java.awt.Dimension(0, 25));
        obCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obCodeActionPerformed(evt);
            }
        });
        obCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                obCodeKeyReleased(evt);
            }
        });

        netTotalStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netTotalStockActionPerformed(evt);
            }
        });

        jLabel14.setText("NTS:");

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
                        .addComponent(btnFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invNo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refNo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(custCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(obCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vanCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(custName, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(odDate, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                            .addComponent(dlDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(obName, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(dcode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(btnAddRow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnSearchNow)
                                .addGap(0, 0, 0)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(vanName, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(netTotalStock))
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNext)
                            .addComponent(btnPrior)
                            .addComponent(btnFirst))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(custName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(custCode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(refNo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(invNo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(btnLast)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(odDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dcode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)
                                .addComponent(obName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(obCode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addComponent(jLabel5)
                            .addComponent(dName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(vanName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vanCode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(netTotalStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dlDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(remarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnUpdate)
                            .addComponent(btnCancel)
                            .addComponent(btnSearchNow)
                            .addComponent(btnAddRow))))
                .addContainerGap())
        );

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

        print2.setText("Print");
        print2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print2ActionPerformed(evt);
            }
        });

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

        Builty22.setText("total Load:");

        Builty23.setText("Issue Load:");

        Builty24.setText("Pre Bal:");

        preBal.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        preBal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        preBal.setText("0.0");
        preBal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preBalActionPerformed(evt);
            }
        });
        preBal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                preBalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                preBalKeyTyped(evt);
            }
        });

        Builty26.setText("NetBal:");

        netBal.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        netBal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        netBal.setText("0.0");
        netBal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netBalActionPerformed(evt);
            }
        });
        netBal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                netBalKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pan_printLayout = new javax.swing.GroupLayout(pan_print);
        pan_print.setLayout(pan_printLayout);
        pan_printLayout.setHorizontalGroup(
            pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_printLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_printLayout.createSequentialGroup()
                        .addGroup(pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_printLayout.createSequentialGroup()
                                .addComponent(Builty26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(netBal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pan_printLayout.createSequentialGroup()
                                .addComponent(Builty24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(preBal, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pan_printLayout.createSequentialGroup()
                        .addComponent(print2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_printLayout.createSequentialGroup()
                        .addGroup(pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Builty23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Builty22, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, 0)
                        .addGroup(pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalLoad)
                            .addComponent(issueLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnexit))
                .addContainerGap())
        );
        pan_printLayout.setVerticalGroup(
            pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_printLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Builty24, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(preBal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_printLayout.createSequentialGroup()
                        .addGroup(pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Builty26)
                            .addComponent(netBal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_printLayout.createSequentialGroup()
                        .addGroup(pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Builty22)
                            .addComponent(totalLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Builty23)
                            .addComponent(issueLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(pan_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(print2)
                    .addComponent(btnexit))
                .addContainerGap())
        );

        adjustments.setBackground(new java.awt.Color(204, 204, 255));
        adjustments.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbSlab.setText("Slabe %");
        cbSlab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSlabActionPerformed(evt);
            }
        });

        cbQty.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbQty.setText("Auto Scheme in QTY");
        cbQty.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbQtyStateChanged(evt);
            }
        });
        cbQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbQtyActionPerformed(evt);
            }
        });

        radioCatinQty.setText("Category Wise");

        radioProSchQty.setText("Product Wise");

        radioSubCatinQty.setText("Sub Category Wise");

        javax.swing.GroupLayout pan_schemeinQtyLayout = new javax.swing.GroupLayout(pan_schemeinQty);
        pan_schemeinQty.setLayout(pan_schemeinQtyLayout);
        pan_schemeinQtyLayout.setHorizontalGroup(
            pan_schemeinQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_schemeinQtyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_schemeinQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_schemeinQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(radioProSchQty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioCatinQty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioSubCatinQty, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(cbQty))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pan_schemeinQtyLayout.setVerticalGroup(
            pan_schemeinQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_schemeinQtyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbQty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioProSchQty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioCatinQty, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(radioSubCatinQty)
                .addContainerGap())
        );

        cbRs.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbRs.setText("Auto Scheme in RS");
        cbRs.setToolTipText("");
        cbRs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbRsStateChanged(evt);
            }
        });
        cbRs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRsActionPerformed(evt);
            }
        });

        RadioSubCatinRS.setText("Sub Category wise");

        radioProinRS.setText("Product Wise");

        radioCatinRS.setText("Category Wise");
        radioCatinRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCatinRSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pan_schemeinRSLayout = new javax.swing.GroupLayout(pan_schemeinRS);
        pan_schemeinRS.setLayout(pan_schemeinRSLayout);
        pan_schemeinRSLayout.setHorizontalGroup(
            pan_schemeinRSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_schemeinRSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_schemeinRSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RadioSubCatinRS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbRs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioCatinRS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioProinRS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pan_schemeinRSLayout.setVerticalGroup(
            pan_schemeinRSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_schemeinRSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbRs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioProinRS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioCatinRS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RadioSubCatinRS)
                .addContainerGap())
        );

        javax.swing.GroupLayout adjustmentsLayout = new javax.swing.GroupLayout(adjustments);
        adjustments.setLayout(adjustmentsLayout);
        adjustmentsLayout.setHorizontalGroup(
            adjustmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adjustmentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adjustmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pan_schemeinRS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pan_schemeinQty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSlab, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adjustmentsLayout.setVerticalGroup(
            adjustmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adjustmentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbSlab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pan_schemeinRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan_schemeinQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        purchaseScrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        purchaseScrollPane.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        purchaseScrollPane.setFocusCycleRoot(true);
        purchaseScrollPane.setMaximumSize(new java.awt.Dimension(1280, 550));

        cbInvByCust.setText("View Invoices As Per Customer");
        cbInvByCust.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbInvByCustStateChanged(evt);
            }
        });
        cbInvByCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInvByCustActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tbcustomLayout = new javax.swing.GroupLayout(tbcustom);
        tbcustom.setLayout(tbcustomLayout);
        tbcustomLayout.setHorizontalGroup(
            tbcustomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbcustomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbInvByCust)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        tbcustomLayout.setVerticalGroup(
            tbcustomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbcustomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbInvByCust)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        tbpancustom.addTab("Custom Requirments", tbcustom);

        custHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(custHistory);

        cbHistory.setText("Display History");
        cbHistory.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbHistoryStateChanged(evt);
            }
        });
        cbHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHistoryActionPerformed(evt);
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

        javax.swing.GroupLayout pan_historyLayout = new javax.swing.GroupLayout(pan_history);
        pan_history.setLayout(pan_historyLayout);
        pan_historyLayout.setHorizontalGroup(
            pan_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_historyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pan_historyLayout.createSequentialGroup()
                        .addComponent(cbHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(linvNo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pan_historyLayout.setVerticalGroup(
            pan_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_historyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbHistory)
                    .addComponent(jLabel10)
                    .addComponent(linvNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbpancustom.addTab("Customer History", pan_history);

        expiryDtl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(expiryDtl);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbpancustom.addTab("Balances", jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbpancustom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(splPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pan_print, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(purchaseScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(adjustments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tbpancustom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(purchaseScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adjustments, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(splPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pan_print, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JTextField getInvNo() {
        return invNo;
    }

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
        s=invNo.getText();PAK_SALE_DB data= new PAK_SALE_DB();
        
        try{
            
            if(data.chech_qty(connAA,invNo.getText())){
                    forBackBtnEnable(false); recEditBtnEnable(false);textFieldsEditable(true);saveUpdateBtnVisible("update", true);sellers1=(String)custName.getSelectedItem();refNo1=refNo.getText();remarks1=remarks.getText();

            }else{
                JFrame j=new JFrame();j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j,
                        "You can't Edit or Delete this invoice Due to Entry Of Sales Return."
                                + "\nFor Edit or Delete First Go to the Return Page & Set text '0' in Sale Return",
                        "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(Exception ex){
            //System.out.println("ex : "+ex);
        }
        //IF NOT PRESENT THEN MESSAGE --> "You can not edit the delivered stock because it is generated from Sales Order"
    }//GEN-LAST:event_btnEditActionPerformed
    String s;
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        s=invNo.getText();forBackBtnEnable(false);
        recEditBtnEnable(false);
        saveUpdateBtnVisible("save", true);
        textFieldsEditable(true);
        setNullTextFields();
//        btnShowOrder.setVisible(true);
        inetializePrductPanel();
        try {
            dlDate.setDate(dateField1.addDays(dateField.getPresentDate(),1));
            odDate.setDate(dateField.getPresentDate());
        } catch (ParseException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnAddRow.setVisible(true);
    /*    route.setEditable(true);
        route.setText("");
        route.requestFocus();
        code.setText("");*/
        ////System.out.println("At ADD Max PC:"+productCount);
    /*    route.setEditable(true);
        route.setText("");
        route.requestFocus();
        code.setText("");*/
        ////System.out.println("At ADD Max PC:"+productCount);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        //if inv no present in customer leger then perform 
        PAK_SALE_DB data= new PAK_SALE_DB();
        
        try{
            if(data.chech_qty(connAA,invNo.getText())){
//            if(data.chech_order_or_sale(connAA,invNo.getText())){
                JFrame j=new JFrame();j.setAlwaysOnTop(true);
                if(JOptionPane.showConfirmDialog(j,
                "Are you sure ! \nOn selecting \"Yes\" this will Delete the tasks?", "Confermation Diloge",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ //ConfermationDiloge()){
//                    PAK_RECOVERY_DB data1 =new PAK_RECOVERY_DB();
                    try{
                        
                        boolean tf=false;
                        if(invNo.getText()==null){
                        }else{
//                            System.out.println("SMAIN DELL"+
                                    data.delete_purchase(connAA,invNo.getText());
//                            );
//                            System.out.println("SDTL DELL"+
                                    data.delete_purchase_products_in_purchase(connAA,invNo.getText());
//                            );
//                            System.out.println("RMAIN DELL"+
//                                    data1.delete_purchase(connAA,invNo.getText());
//                            );
//                            System.out.println("RDTL DELL"+
//                                    data1.delete_purchase_products_in_purchase(connAA,invNo.getText());
//                                    );
                            
                            PAK_GENERAL_DB data12 =new PAK_GENERAL_DB();
                            
                            try {
                            if((!data12.isDSRPresentSmain(connAA,dateField.toDateString(dlDate.getDate().toString()),dcode.getText(),vanCode.getText()))&&(!data12.isDSRPresentISmain(connAA,dateField.toDateString(dlDate.getDate().toString()),dcode.getText(),vanCode.getText()))){
                            data12.deleteDSP(connAA,dateField.toDateString(dlDate.getDate().toString()),dcode.getText(),vanCode.getText());
                            }
                            } catch (ParseException ex) {
                            Logger.getLogger(PURCHASE.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            setNullTextFields();setLastRec();setLastInvoice();
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{

                }
//            }else{
//                JFrame j=new JFrame();j.setAlwaysOnTop(true);
//                JOptionPane.showMessageDialog(j,
//                        "You can not Delete the delivered stock because it is generated from Sales Order",
//                        "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
//            }
            }else{
                JFrame j=new JFrame();j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j,
                        "You can't Edit or Delete this invoice Due to Entry Of Sales Return."
                                + "\nFor Edit or Delete First Go to the Return Page & Set text '0' in Sale Return",
                        "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(Exception ex){
            //System.out.println("ex : "+ex);
        }
        //IF NOT PRESENT THEN MESSAGE --> "You can not edit the delivered stock because it is generated from Sales Order"

    }//GEN-LAST:event_btnDelActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        s=invNo.getText();
        forBackBtnEnable(false);
        recEditBtnEnable(false);
        saveUpdateBtnVisible("search", true);
        textFieldsEditable(false);
        invNo.setEditable(true);
        setNullTextFields();
        invNo.setText("");
        invNo.requestFocus();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
//       /*        
        try {
//            dialogeClass.createViewSalesWin();
            dialogeClass.createViewSalesWin();
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(isSaved){
            invNo.setText(dialogeClass.codeSales);
            findRecords(invNo.getText());
        }else{
                        JFrame j=new JFrame();
                                j.setAlwaysOnTop(true);
                                JOptionPane.showMessageDialog(j, "Not Saved", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }
//                */
//                */
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        try {
            if(cbInvByCust.isSelected()){
                setLastRecWRTcust();
            }else{
                setLastRec();
            }
        } catch (ParseException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLastActionPerformed
    boolean b12c;
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if(cbInvByCust.isSelected()){
            setNextWRTcust();
        }else{
            setNext();
        }
        
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPriorActionPerformed
        if(cbInvByCust.isSelected()){
            findPriorWRTcust();
        }else{
            findPrior();
        }
    }//GEN-LAST:event_btnPriorActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        try {
            if(cbInvByCust.isSelected()){
                setFirstRecWRTcust();
            }else{
                setFirstRecWRTinvoice();
            }
        } catch (ParseException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        ////System.out.println("At FIRST Max PC:"+productCount);
        ////System.out.println("At FIRST Max PC:"+productCount);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        saveUpdateBtnVisible("all", false);
        forBackBtnEnable(true);
        recEditBtnEnable(true);
        textFieldsEditable(false);
//        btnShowOrder.setVisible(false);
        findRecords(s);
        editableProductPanel(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateSumSplPanel();
        boolean tf=false;
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
                try {
                    String s12;
                    if(b12c){s12=fmrsumrs.getText();}else{s12="0";}
                    tf=data.update_purchase(connAA
                            , dateField.toDateString(odDate.getDate().toString()),
                            invNo.getText()+"",refNo.getText(),
                            custCode.getText(),
                            grossAmt.getText(),
                            s12,
                            splRs.getText(),otherExp.getText(),avediscper.getText(),discount.getText(),
                            taxPer.getText(),taxRs.getText(),netAmt.getText(),remaining.getText(),paid.getText(),
                            remarks.getText(),netpayable.getText(),dcode.getText(),tosum.getText(),splFmrPer.getText(),vanCode.getText(),obCode.getText(),dateField.toDateString(dlDate.getDate().toString()));
                    //System.out.println("update_purchase: "+tf);
                
                } catch (ParseException ex) {
                    Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        } catch (Exception ex) {
            //System.out.println(""+ex);
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        ///==========================================================================
        
        ///==========================================================================
        
        
            for(int i=1;i<=productCount;i++){
                //System.out.println("-> "+i+" : productCount->"+productCount);
                if(purchaseProducts[i]!=null&&purchaseProducts[i].isDisplayable()){
                    if(!purchaseProducts[i].getSeekText().isEmpty()){
                        boolean isPresent=false;

                        PAK_SALE_DB data1 =new PAK_SALE_DB();
                        
                        try {

                            if(data.find_max_in_purchase_products(connAA, invNo.getText())<=productCount){
                                //System.out.println("IF");
                                isPresent=data1.check_product_line_item_presence_new(connAA, invNo.getText(),purchaseProducts[i].getSeqNoText(),productCount);
                                
                                
                            }else{
                                isPresent=false;
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //System.out.println("isPresent->"+isPresent);
                        if(isPresent){
                            System.out.println(invNo.getText()+""+" UPDATE-> "+purchaseProducts[i].getSeqNoText());
                            PAK_SALE_DB data2 =new PAK_SALE_DB();
                            
                            try {
                                
                                tf=data2.update_purchase_products_in_table_new(connAA,
                                        invNo.getText(),purchaseProducts[i].getSeqNoText(),
                                        purchaseProducts[i].getSeekText(),
                                        purchaseProducts[i].getTotalQtyText(),
                                        purchaseProducts[i].getRateText(),
                                        purchaseProducts[i].getGrossAmtText(),
                                        purchaseProducts[i].getDiscPerText(),
                                        purchaseProducts[i].getTdo().getText(),
                                        purchaseProducts[i].getTaxPerText(),
                                        purchaseProducts[i].getFmr().getText(),
                                        purchaseProducts[i].getNetAmtText(),
                                        purchaseProducts[i].getDamage().getText(),
                                        purchaseProducts[i].getFree().getText(),
                                       (purchaseProducts[i].getDate().getSelectedItem()!=null?purchaseProducts[i].getDate().getSelectedItem().toString():""),
                                        "");

                                //System.out.println("update_purchase_products_in_table_new: "+tf);
                                
                            } catch (Exception ex) {
                                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }else {
                            //System.out.println(invNo.getText()+""+" INSERT-> "+purchaseProducts[i].getSeqNoText());

                            PAK_SALE_DB data3 =new PAK_SALE_DB();
                            
                            try {
                                
                                tf=data3.insert_purchase_products_in_table_old(connAA, 
                                        invNo.getText(),
                                        purchaseProducts[i].getSeqNoText(),
                                        purchaseProducts[i].getSeekText(),
                                        purchaseProducts[i].getTotalQtyText(),
                                        purchaseProducts[i].getRateText(),
                                        purchaseProducts[i].getGrossAmtText(),
                                        purchaseProducts[i].getDiscPerText(),
                                        purchaseProducts[i].getTdo().getText(),
                                        purchaseProducts[i].getTaxPerText(),
                                        purchaseProducts[i].getFmr().getText(),
                                        purchaseProducts[i].getNetAmtText(),
                                        "",
                                        purchaseProducts[i].getDate().getSelectedItem().toString(),
                                        purchaseProducts[i].getDamage().getText(),
                                        purchaseProducts[i].getFree().getText(),
                                    "0.0");
                                //System.out.println("insert_purchase_products_in_table: "+tf);
                                
                                
                                
                            String a = purchaseProducts[i].getSeekText();
String b = (new BigDecimal(Float.parseFloat(purchaseProducts[i].getTotalQtyText())).add(new BigDecimal(Float.parseFloat(purchaseProducts[i].getDamage().getText()))).add(new BigDecimal(Float.parseFloat(purchaseProducts[i].getFree().getText()))))+"";
                            String c = data3.get_clqty_wrt_pmast_code(connAA, a);
                            BigDecimal d = new BigDecimal("0.0");
                            if (c != null) {
                                d = new BigDecimal(Float.parseFloat(c)).subtract(new BigDecimal(Float.parseFloat(b)));
                            }
                            boolean bool = data3.update_clqty_in_pmast(connAA, d + "", a);
                                
                            } catch (Exception ex) {
                                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
                            }
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
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Not Edited", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
            loadProductsPanel(invNo.getText());
        ////System.out.println("At UPDATE Max PC:"+productCount);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(btnAddRow.isVisible()){
            saveSale();
        }else{
             JFrame j=new JFrame();
            if(JOptionPane.showConfirmDialog(j,
                "Are you sure to save this record?\n After saving you can not edit or delete this record\n"
                        + "due to generated from Sales Order page", "Confermation Diloge",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                saveSale();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

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
            updateComboBox(custCode, custName,"supp");
            
            PAK_GENERAL_DB data1 =new PAK_GENERAL_DB();
            try {
                
                netBal.setText(data1.get_clbal_from_custbal(connAA,custCode.getText()));
                
            }catch (Exception ex) {
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_custCodeKeyReleased

    private void custNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custNameActionPerformed
        //System.out.println("custName.getSelectedItem().toString()"+custName.getSelectedItem().toString());
        custCode.setText(getCode(custName.getSelectedItem().toString(),"supp"));
        
        PAK_GENERAL_DB data1 =new PAK_GENERAL_DB();
        try {
            
            netBal.setText(data1.get_clbal_from_custbal(connAA,custCode.getText()));
            
        }catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_custNameActionPerformed

    private void custNamePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_custNamePopupMenuWillBecomeVisible
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
                    
            custName.setModel(buildAllComboBoxModel("supp",connAA));
            if(setSelectedComboItem(custCode,custName,((!custCode.getText().isEmpty())?data.find_supp_name_by_code(connAA, custCode.getText()):""))){
                
            }else{
                custCode.setText(getCode(custName.getSelectedItem().toString(),"supp"));
            }
            PAK_GENERAL_DB data1 =new PAK_GENERAL_DB();
            try {
                netBal.setText(data1.get_clbal_from_custbal(connAA,custCode.getText()));
                
            }catch (Exception ex) {
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_custNamePopupMenuWillBecomeVisible

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
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
                    
            dName.setModel(buildAllComboBoxModel("sm",connAA));
            if(setSelectedComboItem(dcode,dName,((!dcode.getText().isEmpty())?data.find_sm_name_by_code(connAA, dcode.getText()):""))){
                
            }else{
                dcode.setText(getCode(dName.getSelectedItem().toString(),"sm"));
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dcodeKeyReleased

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
            //System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_print2ActionPerformed

    private void btnAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRowActionPerformed
        addRow();
        //System.out.println("At ADD ROW Max PC:"+productCount);
    }//GEN-LAST:event_btnAddRowActionPerformed

    private void refNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refNoActionPerformed

    private void btnShowOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowOrderActionPerformed
        /*PAK_ORDER_DB data =new PAK_ORDER_DB();
        
        try {
            
            if(!(custCode.getText().equals("")||custCode.getText()==null)){
                ArrayList<String> name[]=data.get_pending_orders(connAA,custCode.getText() );
                if (name!=null){
                    inetializePrductPanel();
                    removeRow(productCount);
                    productCount--;
                    int lastSeqNo=0;
                    
                    String ordNo="Sales Against Order Nos : ";
                    
                    for(int i=0;i<name.length;i++){
                        addRow(Integer.parseInt((i)+""));
                        for(int j=0;j<16;j++){
                            switch(j)
                            {
                                case 0:
                                    purchaseProducts[productCount].getOrdDocNo().setText(name[i].get(j));
                                    if(i==0){
                                        ordNo = ordNo+name[i].get(j);
                                    }else{
                                        ordNo = ordNo+" , "+name[i].get(j);
                                    }
                                    
                                    break;
                                case 1:
                                    purchaseProducts[productCount].setSeqNoText((i+1)+"");
                                    purchaseProducts[productCount].getOrdSeqNo().setText(name[i].get(j));
                                    lastSeqNo=Integer.parseInt((i+1)+"");
                                    break;
                                case 2:
                                    purchaseProducts[productCount].setSeek(name[i].get(j));
                                    String temp = purchaseProducts[productCount].getSeekText();
                                    purchaseProducts[productCount].setpName(temp);
                                    break;
                                case 3:
//                                    purchaseProducts[productCount].setTotalQty(name[i].get(j));
                                    break;
                                case 4:
                                    purchaseProducts[productCount].setRate(name[i].get(j));
                                    break;
                                case 5:
                                    purchaseProducts[productCount].setGrossAmt(name[i].get(j));
                                    break;
                                case 6:
                                    purchaseProducts[productCount].setDiscPer(name[i].get(j));
                                    break;
                                case 7:
                                    purchaseProducts[productCount].setDiscRs(name[i].get(j));
                                    break;
                                case 8:
                                    purchaseProducts[productCount].setTaxPer(name[i].get(j));
                                    break;
                                case 9:
                                    purchaseProducts[productCount].setTaxRs(name[i].get(j));
                                    break;
                                case 10:
                                    purchaseProducts[productCount].setNetAmt(name[i].get(j));
                                    break;
                                case 11:
//                                    purchaseProducts[productCount].getTotalSize().setText(name[i].get(j));
                                    break;
                                case 12:
//                                    purchaseProducts[productCount].getTotalSize().setText(name[i].get(j));
                                    break;
                                case 13:
                                    //System.out.println("==AA "+name[i].get(j));
                                    purchaseProducts[productCount].setTotalQty(name[i].get(j));
                                    purchaseProducts[productCount].frmDiscRs();
                                    purchaseProducts[productCount].frmTaxRs();
                                    purchaseProducts[productCount].frmNetAmount();
                                    break;
                                case 14:
//                                    purchaseProducts[productCount].getCustomeSize().setText(name[i].get(j));
//                                    DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
//                                    comboBoxModel.addElement(name[i].get(j));
//                                    purchaseProducts[productCount].getpName2().setModel(comboBoxModel);
                                    break;
                                case 15:
//                                    purchaseProducts[productCount].getCustomeSize().setText(name[i].get(j));
                                    DefaultComboBoxModel comboBoxModel1 = new DefaultComboBoxModel();
                                    comboBoxModel1.addElement(name[i].get(j));
                                    purchaseProducts[productCount].getDate().setModel(comboBoxModel1);
                                    break;
                            }
                           updateSumSplPanel();
                           if(Float.parseFloat(purchaseProducts[productCount].getOrdDocNo().getText())!=0){

                            }else{
                               if(Float.parseFloat(purchaseProducts[productCount].getOrdSeqNo().getText())!=0){

                                }else{
                                   purchaseProducts[productCount].textFieldsEditableProducts1(true);
                                }
                            }
                        }
                        remarks.setText(ordNo);
                        btnAddRow.setVisible(false);
                        //System.out.println("");
                    }
                    productCount=lastSeqNo;
                    editableProductPanel1(true); 
                }else{
                    JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "Not Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_btnShowOrderActionPerformed

    private void custCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_custCodeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try 
            {
                dialogeClass.createViewCustRecWin();
            } catch (Exception ex) {
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(DynamicERP.dialoge.viewforms.ViewForm11.isSaved){
                custCode.setText(dialogeClass.codeCustRec);
            }else{
            }
        }
        try {
            updateComboBox(custCode, custName,"supp");
        } catch (Exception ex) {
            Logger.getLogger(RECOVERY.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_custCodeKeyPressed

    private void tosumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tosumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tosumActionPerformed

    private void tosumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tosumKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tosumKeyReleased

    private void fmrsumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmrsumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fmrsumActionPerformed

    private void fmrsumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fmrsumKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fmrsumKeyReleased

    private void fmrsumrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmrsumrsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fmrsumrsActionPerformed

    private void fmrsumrsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fmrsumrsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fmrsumrsKeyReleased

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

    private void splFmrRsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_splFmrRsKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_splFmrRsKeyTyped

    private void vanCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vanCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vanCodeActionPerformed

    private void vanCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vanCodeKeyReleased
        try {
            updateComboBox(vanCode, vanName,"van");
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_vanCodeKeyReleased

    private void vanNamePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_vanNamePopupMenuWillBecomeVisible
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            vanName.setModel(buildAllComboBoxModel("van",connAA));
            if(setSelectedComboItem(vanCode,vanName,((!vanCode.getText().isEmpty())?data.find_van_name_by_code(connAA, vanCode.getText()):""))){

            }else{
                vanCode.setText(getCode(vanName.getSelectedItem().toString(),"van"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_vanNamePopupMenuWillBecomeVisible

    private void vanNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vanNameActionPerformed
        // TODO add your handling code here:
        vanCode.setText(getCode(vanName.getSelectedItem().toString(),"van"));
    }//GEN-LAST:event_vanNameActionPerformed

    private void obNamePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_obNamePopupMenuWillBecomeVisible
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            obName.setModel(buildAllComboBoxModel("sm",connAA));
            if(setSelectedComboItem(obCode,obName,((!obCode.getText().isEmpty())?data.find_sm_name_by_code(connAA, obCode.getText()):""))){
            }else{
                obCode.setText(getCode(obName.getSelectedItem().toString(),"sm"));
            }

            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_obNamePopupMenuWillBecomeVisible

    private void obNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obNameActionPerformed
        // TODO add your handling code here:
        obCode.setText(getCode(obName.getSelectedItem().toString(),"sm"));
    }//GEN-LAST:event_obNameActionPerformed

    private void obCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obCodeActionPerformed

    private void obCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_obCodeKeyReleased
        try {
            updateComboBox(obCode, obName,"sm");
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_obCodeKeyReleased

    private void cbSlabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSlabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSlabActionPerformed

    private void netAmtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_netAmtCaretUpdate
        
        // TODO add your handling code here:
    }//GEN-LAST:event_netAmtCaretUpdate

    private void cbHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbHistoryActionPerformed

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

    private void radioCatinRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCatinRSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioCatinRSActionPerformed

    private void cbQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbQtyActionPerformed

    private void cbRsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRsActionPerformed
        
    }//GEN-LAST:event_cbRsActionPerformed

    private void cbRsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbRsStateChanged
        if(!cbRs.isSelected()){radioRs.clearSelection();
            RadioSubCatinRS.setEnabled(false);
            radioCatinRS.setEnabled(false);
            radioProinRS.setEnabled(false);
        }else{
            RadioSubCatinRS.setEnabled(true);
            radioCatinRS.setEnabled(true);
            radioProinRS.setEnabled(true);
        }//
    }//GEN-LAST:event_cbRsStateChanged

    private void cbQtyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbQtyStateChanged
        //if(!cbQty.isSelected()){radioQty.clearSelection();}//
        if(!cbQty.isSelected()){radioQty.clearSelection();
            radioSubCatinQty.setEnabled(false);
            radioCatinQty.setEnabled(false);
            radioProSchQty.setEnabled(false);
        }else{
            radioSubCatinQty.setEnabled(true);
            radioCatinQty.setEnabled(true);
            radioProSchQty.setEnabled(true);
        }//
    }//GEN-LAST:event_cbQtyStateChanged

    private void cbHistoryStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbHistoryStateChanged
        if(!cbHistory.isSelected()){khaliTable();}
    }//GEN-LAST:event_cbHistoryStateChanged

    private void preBalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preBalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preBalActionPerformed

    private void preBalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_preBalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_preBalKeyReleased

    private void preBalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_preBalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_preBalKeyTyped

    private void netBalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netBalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_netBalActionPerformed

    private void netBalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_netBalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_netBalKeyReleased

    private void netTotalStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netTotalStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_netTotalStockActionPerformed

    private void remarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remarksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remarksActionPerformed

    private void remarksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_remarksKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {ffs();}
    }//GEN-LAST:event_remarksKeyReleased

    private void cbInvByCustStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbInvByCustStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbInvByCustStateChanged

    private void cbInvByCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInvByCustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbInvByCustActionPerformed
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
            java.util.logging.Logger.getLogger(SALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SALES().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Builty1;
    private javax.swing.JLabel Builty11;
    private javax.swing.JLabel Builty12;
    private javax.swing.JLabel Builty13;
    private javax.swing.JLabel Builty14;
    private javax.swing.JLabel Builty15;
    private javax.swing.JLabel Builty16;
    private javax.swing.JLabel Builty17;
    private javax.swing.JLabel Builty18;
    private javax.swing.JLabel Builty19;
    private javax.swing.JLabel Builty2;
    private javax.swing.JLabel Builty20;
    private javax.swing.JLabel Builty21;
    private javax.swing.JLabel Builty22;
    private javax.swing.JLabel Builty23;
    private javax.swing.JLabel Builty24;
    private javax.swing.JLabel Builty26;
    private javax.swing.JLabel Builty3;
    private javax.swing.JLabel Builty4;
    private javax.swing.JLabel Builty8;
    private javax.swing.JRadioButton RadioSubCatinRS;
    private javax.swing.JPanel adjustments;
    private javax.swing.JTextField avediscper;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddRow;
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
    private javax.swing.JButton btnShowOrder;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnexit;
    private javax.swing.JCheckBox cbHistory;
    private javax.swing.JCheckBox cbInvByCust;
    private javax.swing.JCheckBox cbQty;
    private javax.swing.JCheckBox cbRs;
    private javax.swing.JCheckBox cbSlab;
    private javax.swing.JTextField custCode;
    private javax.swing.JTable custHistory;
    private javax.swing.JComboBox custName;
    private javax.swing.JComboBox dName;
    private javax.swing.JTextField dcode;
    private javax.swing.JTextField discount;
    private com.toedter.calendar.JDateChooser dlDate;
    private javax.swing.JTable expiryDtl;
    private javax.swing.JTextField fmrsum;
    private javax.swing.JTextField fmrsumrs;
    private javax.swing.JTextField grossAmt;
    private javax.swing.JTextField invNo;
    private javax.swing.JTextField issueLoad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel link9;
    private javax.swing.JTextField linvNo;
    private javax.swing.JTextField netAmt;
    private javax.swing.JTextField netBal;
    private javax.swing.JTextField netTotalStock;
    private javax.swing.JTextField netpayable;
    private javax.swing.JTextField obCode;
    private javax.swing.JComboBox obName;
    private com.toedter.calendar.JDateChooser odDate;
    private javax.swing.JTextField otherExp;
    private javax.swing.JTextField paid;
    private javax.swing.JPanel pan_history;
    private javax.swing.JPanel pan_print;
    private javax.swing.JPanel pan_schemeinQty;
    private javax.swing.JPanel pan_schemeinRS;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField preBal;
    private javax.swing.JButton print2;
    private javax.swing.JScrollPane purchaseScrollPane;
    private javax.swing.JRadioButton radioCatinQty;
    private javax.swing.JRadioButton radioCatinRS;
    private javax.swing.JRadioButton radioProSchQty;
    private javax.swing.JRadioButton radioProinRS;
    private javax.swing.ButtonGroup radioQty;
    private javax.swing.ButtonGroup radioRs;
    private javax.swing.JRadioButton radioSubCatinQty;
    private javax.swing.JTextField refNo;
    private javax.swing.JTextField remaining;
    private javax.swing.JTextField remarks;
    private javax.swing.JTextField splFmrPer;
    private javax.swing.JTextField splFmrRs;
    private javax.swing.JPanel splPanel;
    private javax.swing.JTextField splPer;
    private javax.swing.JTextField splRs;
    private javax.swing.JTextField taxPer;
    private javax.swing.JTextField taxRs;
    private javax.swing.JPanel tbcustom;
    private javax.swing.JTabbedPane tbpancustom;
    private javax.swing.JTextField tosum;
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
    private static PakSalesFieldPanel1[] purchaseProducts = new PakSalesFieldPanel1[500];
    private static SaleHeaderPanel purchaseHeaderPanel= new SaleHeaderPanel();
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
        String lineL[] = new String[2];
        try {
            File fin = new File("out.txt");
            FileInputStream fis = new FileInputStream(fin);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = null;int i=0;
            while ((line = br.readLine()) != null) {lineL[i] = line;i++;}br.close();
        } catch (IOException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        EcLogger ec = new EcLogger();
        System.out.println(" ec.classDeLoade(lineL[0]) : "+ec.classDeLoade(lineL[0]));
        if(has_access(ec.classDeLoade(lineL[0]),"202")){
            purchaseHeaderPanel.getFmr().setVisible(true);
            purchaseHeaderPanel.getFmrPer().setVisible(true);
            purchaseHeaderPanel.getFmrRs().setVisible(true);
            b12c=true;
        }else{
            purchaseHeaderPanel.getFmr().setVisible(false);
            purchaseHeaderPanel.getFmrPer().setVisible(false);
            purchaseHeaderPanel.getFmrRs().setVisible(false);
            b12c=false;
        }    
        
        addRow();
            
        purchaseScrollPane.getViewport().setView(purchasePanel);
    }
   private boolean has_access(String string,String roleGrant) {
        boolean s1=false;
        PAK_GENERAL_DB data =new PAK_GENERAL_DB();
        
        try {
            
            String next = data.get_role_from_userLogin(connAA,string);
            if(next!=null){
                String grant = data.get_access_from_grant(connAA,roleGrant,next);
                if((1==(grant.compareTo("y")))||(1==(grant.compareTo("Y")))){
                    s1=true;
                }else{
                    s1=false;
                }
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Next not found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s1;
    }
    
   int i;
    private void addRow() {
        productCount++;
        purchaseProducts[productCount]=new PakSalesFieldPanel1();
        purchaseProducts[productCount].setName(productCount+"");
        purchaseProducts[productCount].setSeqNoText(productCount+"");
        for (i = 0; i < 22; i++) {
            switch(i)
            {
                case 1:case 2:case 3: case 6:case 7:case 8:case 9:case 10:case 11:case 13:case 12:case 14:case 15:case 16:case 17:case 18:case 19:case 20:
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
                case 4:
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
                splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
                
            }
        });
//        purchaseProducts[productCount].getSeek().addKeyListener(new KeyAdapter(){
//            public void keyReleased(KeyEvent e) {
////                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
//                updateSumSplPanel();
//                setBalQty(e);
//            }
//        });
        purchaseProducts[productCount].getSeek().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {                                                                                   /*System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());*/                    JTextField t1 = (JTextField) e.getSource();
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
                setBalQty(e);
                if(cbHistory.isSelected()){
                    String col[]={"Inv No","Date","Qty","Rate","Disc %"};
                    updateTableView(col,purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText());
                
                    String col1[]={"Expiry Date","Bstch","Qty"};
                    updateTableView1(col1,purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText());
                
                }
                
                String pp = updateCustTypeDisc(custCode.getText(),purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText());
                purchaseProducts[Integer.parseInt(t1.getParent().getName())].getDiscPer().setText(pp);
                
                netTotalStock.setText(setNetTotalStock(purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText(),connAA));
                
                splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
                
                applySchemes(purchaseProducts[Integer.parseInt(t1.getParent().getName())],t1);
            }
        });//seekInputMethodTextChanged
        purchaseProducts[productCount].getSeek().addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent ce) {                                                                                    /*System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());*/                    JTextField t1 = (JTextField) ce.getSource();
                if(t1.getText()!=null){
                    if(cbHistory.isSelected()){String col[]={"Inv No","Date","Qty","Rate","Disc %"};
                    updateTableView(col,purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText());
                    String col1[]={"Expiry Date","Bstch","Qty"};
                    updateTableView1(col1,purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText());
                    }String pp = updateCustTypeDisc(custCode.getText(),purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText());
                    purchaseProducts[Integer.parseInt(t1.getParent().getName())].getDiscPer().setText(pp);
                    
                    if(!btnFirst.isEnabled()){
                        splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
                    }
                    //splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
                    
//                    purchaseProducts[Integer.parseInt(t1.getParent().getName())].getTdo().setText(setTdo(purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText(),purchaseProducts[Integer.parseInt(t1.getParent().getName())].getTotalQtyText()));
//                    purchaseProducts[Integer.parseInt(t1.getParent().getName())].getFree().setText(setBns(purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText(),purchaseProducts[Integer.parseInt(t1.getParent().getName())].getTotalQtyText()));
                }
            }
        });
        purchaseProducts[productCount].getRate().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
                splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
            }
        });
        purchaseProducts[productCount].getTotalQty().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {                                                                                       /*System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());*/                    JTextField t1= (JTextField) e.getSource();
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
                
                splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
                    
                applySchemes(purchaseProducts[Integer.parseInt(t1.getParent().getName())],t1);
            }

        });
        purchaseProducts[productCount].getCtn().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {                                                                                       /*System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());*/                    JTextField t1= (JTextField) e.getSource();
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
                splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
                    
                applySchemes(purchaseProducts[Integer.parseInt(t1.getParent().getName())],t1);
            }
        });
        purchaseProducts[productCount].getPcs().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {                                                                                       /*System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());*/                    JTextField t1= (JTextField) e.getSource();
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
                
                splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
                    
                applySchemes(purchaseProducts[Integer.parseInt(t1.getParent().getName())],t1);
            }
        });
        purchaseProducts[productCount].getTdo().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
                splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
            }
        });
        purchaseProducts[productCount].getFmr().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
                splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
            }
        });
        purchaseProducts[productCount].getFmrrs().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
                splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
            }
        });
        purchaseProducts[productCount].getTaxPer().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
                splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
            }
        });
        purchaseProducts[productCount].getPcs().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
            }
        });
        purchaseProducts[productCount].getCtn().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
            }
        });
        purchaseProducts[productCount].getTaxRs().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
                splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
            }
        });
        purchaseProducts[productCount].getDiscPer().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
                splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
            }
        });
        purchaseProducts[productCount].getDiscRs().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
                splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
            }
        });
//        purchaseProducts[productCount].getpName().addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//               updateSumSplPanel();
//               setBalQty(ae);
//            }
//        });
//        
//        purchaseProducts[productCount].getpName().addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent arg0) {                                                                                                                 /*System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());*/                    JComboBox t1= (JComboBox) arg0.getSource();
//                System.out.println(" ==> t1.getName()"+t1.getParent().getName());
//            
//                splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
//                
//                purchaseProducts[Integer.parseInt(t1.getParent().getName())].getTdo().setText(setTdo(purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText(),purchaseProducts[Integer.parseInt(t1.getParent().getName())].getTotalQtyText()));//setting the tdo wrt "Auto Scheme in RS" CheckBox 
//                purchaseProducts[Integer.parseInt(t1.getParent().getName())].getFree().setText(setBns(purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText(),purchaseProducts[Integer.parseInt(t1.getParent().getName())].getTotalQtyText()));//setting the tdo wrt "Auto Scheme in Qty" CheckBox 
//            }
//        });
        purchaseProducts[productCount].getpName().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {                                                                                       /*System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());*/                    JComboBox t1= (JComboBox) ae.getSource();
                updateSumSplPanel();
                setBalQty(ae);
                if(cbHistory.isSelected()){String col[]={"Inv No","Date","Qty","Rate","Disc %"};
                updateTableView(col,purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText());
                String col1[]={"Expiry Date","Bstch","Qty"};
                updateTableView1(col,purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText());
                }String pp = updateCustTypeDisc(custCode.getText(),purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText());
                
                
                purchaseProducts[Integer.parseInt(t1.getParent().getName())].getDiscPer().setText(pp);
//                purchaseProducts[Integer.parseInt(t1.getParent().getName())].getTdo().setText(setTdo(purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText(),purchaseProducts[Integer.parseInt(t1.getParent().getName())].getTotalQtyText()));//setting the tdo wrt "Auto Scheme in RS" CheckBox 
//                purchaseProducts[Integer.parseInt(t1.getParent().getName())].getFree().setText(setBns(purchaseProducts[Integer.parseInt(t1.getParent().getName())].getSeek().getText(),purchaseProducts[Integer.parseInt(t1.getParent().getName())].getTotalQtyText()));//setting the tdo wrt "Auto Scheme in Qty" CheckBox 
            }
        });

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
                        String b = (new BigDecimal(Float.parseFloat(purchaseProducts[Integer.parseInt(label.getParent().getName())].getTotalQtyText())).add(new BigDecimal(Float.parseFloat(purchaseProducts[Integer.parseInt(label.getParent().getName())].getDamage().getText()))).add(new BigDecimal(Float.parseFloat(purchaseProducts[Integer.parseInt(label.getParent().getName())].getFree().getText()))))+"";
                        deletePurchaseProduct(invNo.getText(), label.getParent().getName(), b, purchaseProducts[Integer.parseInt(label.getParent().getName())].getSeekText(),purchaseProducts[Integer.parseInt(label.getParent().getName())].getSeqNoText());
                        updateSumSplPanel();
                    }
                }
            }
        });
        initializePanelListner(purchaseProducts[productCount]);
        purchasePanel.add(purchaseProducts[productCount]);
    }
    private void applySchemes(PakSalesFieldPanel1 scheme,JTextField t1) {
        if(cbRs.isSelected()){if(radioProinRS.isSelected()){scheme.getTdo().setText(setTdo(scheme.getSeek().getText(),scheme.getTotalQtyText()));scheme.frmNetAmount();}}
        if(cbQty.isSelected()){if(radioProSchQty.isSelected()){scheme.getFree().setText(setBns(scheme.getSeek().getText(),scheme.getTotalQtyText()));purchaseProducts[Integer.parseInt(t1.getParent().getName())].frmNetAmount();}}
    }
    private String setTdo(String pCode,String totalQty) {
        String s="0";
            PAK_GENERAL_DB data =new PAK_GENERAL_DB();
            
            try {
                
                s=data.getCalculatedTdo(connAA,dateField.toReturnedDate(odDate.getDate()+""),pCode,totalQty);
                //System.out.println("getCalculatedTdo"+s);
            } catch (Exception ex) {
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
            }
        return s;
    }
    private String setBns(String pCode,String totalQty) {
        String s="0";
            PAK_GENERAL_DB data =new PAK_GENERAL_DB();
            
            try {
                
                s=data.getCalculatedBns(connAA,dateField.toReturnedDate(odDate.getDate()+""),pCode,totalQty);
                //System.out.println("getCalculatedBns"+s);
            } catch (Exception ex) {
                //System.out.println(""+ex);
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
            }
        return s;
    }
    
    private String setSplDiscPer(String totalQty) {
        String s="0";
        if(cbSlab.isSelected()){
            PAK_GENERAL_DB data =new PAK_GENERAL_DB();
            
            try {
                
                s=data.getCalculatedSplPer(connAA,dateField.toReturnedDate(odDate.getDate()+""),totalQty);
            } catch (Exception ex) {
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return s;
    }
    private String updateCustTypeDisc(String c, String p) {
            String ss="";
            PAK_DB data =new PAK_DB();
            
            try {
                
                    ss=data.get_discPer(connAA,c,p);
                
            } catch (Exception ex) {
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
            }
            return ss;
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
//            
//        } catch (Exception ex) {
//            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
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
//            
//        } catch (Exception ex) {
//            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    private String getSubName(String p) {
        String s=p.substring(0, p.indexOf("|")-1);  
        return s;
    }
    private void setBalQty(PopupMenuEvent e) {
        try {
            PAK_DB data =new PAK_DB();
            
            
            ArrayList<String> temp;
            JComboBox f = (JComboBox) e.getSource();
//            System.out.println("");
//            System.out.println("****************");
//            System.out.println("PopupMenuEvent"+f.getSelectedItem());
//            System.out.println("****************");
//            if(!f.getSelectedItem().equals("")){
//                temp=data.find_product_rec_by_code(connAA, f.getSelectedItem());
//                if(temp!=null){
//                    for(int i=0;i<temp.size();i++){
//                        if(i==9){//||i==6||i==10){
//                            balQty.setText(temp.get(i));
//                        }
//                    }
//                }
//            }
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void addRow(int tempProductCount) {
        productCount=tempProductCount;
        addRow();
    }
   
    private void perkd(KeyEvent e) {
        if(e.getSource() instanceof JTextField){
            JTextField j = (JTextField) e.getSource();
            boolean b=false;
            for (int i = Integer.parseInt(j.getParent().getName()); i < (Integer.parseInt(j.getParent().getName())+10); i++) {
                if(purchaseProducts[i+1]!=null&&purchaseProducts[i+1].isDisplayable())
                {
                    JTextField j1= (JTextField) purchaseProducts[i+1].getComponent(gci(j));
                    j1.requestFocus();j1.selectAll();b=false;break;
                }else{b=true;}
            }
            if(b&&j.isEditable()){
                    /*JOptionPane.showMessageDialog(j, "Info","InfoBox: ", JOptionPane.INFORMATION_MESSAGE);*/addRow();purchaseProducts[productCount].getSeek().requestFocus();
            }
        }
    }
    
    public static final int gci(Component component) {
        if (component != null && component.getParent() != null) {
          Container c = component.getParent();for (int i = 0; i < c.getComponentCount(); i++) {if (c.getComponent(i) == component)return i;}
        }return -1;
    }
   private void perku(KeyEvent e) {
        if(e.getSource() instanceof JTextField){
            JTextField j = (JTextField) e.getSource();
            for (int i = Integer.parseInt(j.getParent().getName()); (i > (Integer.parseInt(j.getParent().getName())-10)&&i>0); i--) {
                if(purchaseProducts[i-1]!=null&&purchaseProducts[i-1].isDisplayable())
                {
                    JTextField j1= (JTextField) purchaseProducts[i-1].getComponent(gci(j));
                    j1.requestFocus();j1.selectAll();
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
                    JTextField j1= (JTextField) purchaseProducts[i+1].getComponent(4);
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
    private void deletePurchaseProduct(String s,String s1,String s2,String s3,String s4) {
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            String rs[] = data.get_pQty_saleQty( connAA, s,s4);
            if(data.check_product_line_item_presence_new(connAA,s,s4,productCount)){
                String a = s3;
                String b = s2;
                String b1 = s;
                String c = data.get_clqty_wrt_pmast_code(connAA, rs[0]);
                BigDecimal d = new BigDecimal("0.0");
                if (c != null) {
                    d = new BigDecimal(Float.parseFloat(c)).add(new BigDecimal(Float.parseFloat(rs[1])).add(new BigDecimal(Float.parseFloat(rs[2])).add(new BigDecimal(Float.parseFloat(rs[3])))));
                }
                //System.out.println("Seek" + s1);
                //System.out.println("Code" + b1);
                //System.out.println("CLQTY" + d);
                //System.out.println("TQTY" + b);
                //System.out.println("CLQTY" + c);
                boolean bool = data.update_clqty_in_pmast(connAA, d + "", rs[0]);
                
                data.delete_purchase_product(connAA, s, s1);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
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
        btnAdd.setEnabled(b);
        btnDel.setEnabled(b);
        btnSearch.setEnabled(b);
        btnView.setEnabled(b);
        btnEdit.setEnabled(b);
    }

    private void saveUpdateBtnVisible(String s, boolean visibleProperty) {
        switch (s.toLowerCase()) {
            case "save":
                btnSave.setVisible(visibleProperty);
                break;
            case "update":
                btnUpdate.setVisible(visibleProperty);
                break;
            case "search":
                btnSearchNow.setVisible(visibleProperty);
                break;
            case "all":
                btnSearchNow.setVisible(visibleProperty);
                btnSave.setVisible(visibleProperty);
                btnUpdate.setVisible(visibleProperty);
                break;
        }
        btnCancel.setVisible(visibleProperty);
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            //if(data.chech_order_or_sale(connAA,invNo.getText())){
                btnAddRow.setVisible(visibleProperty);
            /*}else{
                btnAddRow.setVisible(false);
            }*/
        }   catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    }
    private void textFieldsEditable(boolean b) {
        dlDate.setEnabled(b);
        odDate.setEnabled(b);
        refNo.setEditable(b);
        custCode.setEditable(b);
        custName.setEnabled(b);
        vanCode.setEditable(b);
        vanName.setEnabled(b);
        obCode.setEditable(b);
        obName.setEnabled(b);
        remarks.setEnabled(b);
        splPer.setEditable(b);
        splRs.setEditable(b);
        otherExp.setEditable(b);
        paid.setEditable(b);
        dcode.setEditable(b);
        dName.setEnabled(b);
        tosum.setEditable(b);
        if(b12c){
            fmrsum.setEditable(b);
        }
        splFmrPer.setEditable(b);
        splFmrRs.setEditable(b);
        if(b12c){
        fmrsumrs.setEditable(b);
        }textFieldsNotEditable(false);
        editableProductPanel(b); 
        
    }

    private void setNullTextFields() {
        invNo.setText("");
        dlDate.setDate(null);
        odDate.setDate(null);
        refNo.setText("");
        custCode.setText("");
        try {
            buildOneComboBoxModel("", "supp");//suppName.setText("");
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        vanCode.setText("");
        try {
            buildOneComboBoxModel("", "van");//suppName.setText("");
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        remarks.setText("No Remarks");
        avediscper.setText("0.00");
        totalLoad.setText("0.00");
        issueLoad.setText("0.00");
        
        
        PAK_GENERAL_DB data1 =new PAK_GENERAL_DB();
        try {
            
            preBal.setText(data1.get_clbal_from_custbal(connAA,custCode.getText()));
            
        }
        catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        netBal.setText("0.00");        
        remaining.setText("0.00");
        discount.setText("0.00");
        grossAmt.setText("0.00");
        taxPer.setText("0.00");
        taxRs.setText("0.00");
        netAmt.setText("0.00");
        splPer.setText("0.00");
        splFmrPer.setText("0.00");
        splFmrRs.setText("0.00");
        splRs.setText("0.00");
        if(b12c){
            fmrsum.setText("0.00");
        fmrsumrs.setText("0.00");}
        otherExp.setText("0.00");
        paid.setText("0.00");
        netpayable.setText("0.00");
        dcode.setText("");
        try {
            buildOneComboBoxModel("", "sm");//suppName.setText("");
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        inetializePrductPanel();
    }

    private void updateComboBox(JTextField textField,JComboBox comboBox,String c) throws Exception {
        comboBox.setModel(buildOneComboBoxModel(textField.getText(),c));
    }
    public static DefaultComboBoxModel buildAllComboBoxModel(String c,Connection cc) throws Exception {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        PAK_SALE_DB data =new PAK_SALE_DB();
        
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
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comboBoxModel;
    }
    public DefaultComboBoxModel buildOneComboBoxModel(String name,String c) throws Exception {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        PAK_SALE_DB data =new PAK_SALE_DB();
        
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
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comboBoxModel;
    }

    private String getCode(String name,String c) {
        String s="";
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            
            switch (c) {
                    case "sm":
                        if(!name.equals("")){
                            s=data.find_sm_code_by_name(connAA,name.trim());
                        }else{
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                    case "supp":
                        if(!name.equals("")){
                            s=data.find_supp_code_by_name(connAA,name.trim());
                        }else{
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                    case "van":
                        if(!name.equals("")){
                            s=data.find_van_code_by_name(connAA,name.trim());
                        }else{
            //                JFrame j=new JFrame();
//                    j.setAlwaysOnTop(true);
//                    JOptionPane.showMessageDialog(j, "Emter Id Found");
                        }
                        break;
                }  
            
        } catch (SQLException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    private void setFirstRecWRTinvoice() throws ParseException {
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            ArrayList<String> stock= data.get_first_purchase(connAA);
            if(stock==null){
                setNullTextFields();
                JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "No data Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }else{
                setTextinPurchase(stock,dateField);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setFirstRecWRTcust() throws ParseException {
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            ArrayList<String> stock= data.get_first_cust_purchase(connAA,custCode.getText());
            if(stock==null){
                setNullTextFields();
                JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "No data Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }else{
                setTextinPurchase(stock,dateField);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setTextinPurchase(ArrayList<String> stock, Conversions dateField) {
        try {
            odDate.setDate(dateField.toDate(stock.get(0)));
            invNo.setText(stock.get(1));
            refNo.setText(stock.get(2));
            custCode.setText(stock.get(3));
            try {
                custName.setModel(buildOneComboBoxModel(custCode.getText(),"supp"));
            } catch (Exception ex) {
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
            }
            grossAmt.setText(stock.get(4));
            if(b12c){fmrsumrs.setText(stock.get(5));}
            splRs.setText(stock.get(6));
            frmSplPer();
            otherExp.setText(stock.get(7));
            avediscper.setText(stock.get(8));
            discount.setText(stock.get(9));
            taxPer.setText(stock.get(10));
            taxRs.setText(stock.get(11));
            netAmt.setText(stock.get(12));
            
            //splPer.setText(setSplDiscPer(netAmt.getText()));frmSplRs();
            
            remaining.setText(stock.get(13));
            paid.setText(stock.get(14));
            remarks.setText(stock.get(15));
            netpayable.setText(stock.get(16));
            dcode.setText(stock.get(17));
            tosum.setText(stock.get(18));
            splFmrPer.setText(stock.get(19));
            vanCode.setText(stock.get(20));
            try {
                vanName.setModel(buildOneComboBoxModel(vanCode.getText(),"van"));
            } catch (Exception ex) {
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
            }
            obCode.setText(stock.get(21));
            dlDate.setDate(dateField.toDate(stock.get(22)));
            try {
                obName.setModel(buildOneComboBoxModel(obCode.getText(),"sm"));
            } catch (Exception ex) {
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
            }
            frmSplFmrRs();
             try {
                dName.setModel(buildOneComboBoxModel(dcode.getText(),"sm"));
            } catch (Exception ex) {
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
            }
            loadProductsPanel(invNo.getText());
             
        } catch (ParseException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void recEditActionBtnVisible(boolean b) {
        btnSave.setVisible(b);
        btnUpdate.setVisible(b);
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
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            ArrayList<String> stock = data.get_last_purchase(connAA);
            if(stock==null){
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Welcome Enter First Record", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                btnAdd.doClick();
                btnCancel.setVisible(false);
                editableProductPanel(true);
            }else{
                setTextinPurchase(stock, dateField);
                editableProductPanel(false);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setLastRecWRTcust() throws ParseException {
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            ArrayList<String> stock = data.get_last_cust_purchase(connAA,custCode.getText());
            if(stock==null){
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Welcome Enter First Record", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                btnAdd.doClick();
                btnCancel.setVisible(false);
                editableProductPanel(true);
            }else{
                setTextinPurchase(stock, dateField);
                editableProductPanel(false);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setLastInvoice() {
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            int max=data.find_max_in_purchase_code(connAA);
            if(max==0){
                linvNo.setText(null);
            }else{
                linvNo.setText(max+"");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void inetializePrductPanel() {
        editableProductPanel(true);
        purchasePanel.removeAll();
//        purchasePanel.revalidate();
//        purchasePanel.repaint();
//        purchasePanel.removeAll();
        purchasePanel.validate();
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
    private void editableProductPanel1(boolean b) {
        for(int i=1;i<=productCount;i++){
           if(purchaseProducts[i]!=null){
               purchaseProducts[i].textFieldsEditableProducts1(b);
           }
           
        }
    }

    private void loadProductsPanel(String text) {
        inetializePrductPanel();
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            ArrayList<String> name[]=data.search_products(connAA,text);
            removeRow(productCount);
            productCount--;
            int lastSeqNo=0;
            for(int i=0;i<name.length;i++){
                //System.out.println("name["+i+"].get(1)"+name[i].get(1));
                String temp; 
                addRow(Integer.parseInt(name[i].get(1))-1);
                for(int j=0;j<16;j++){
                    switch(j)
                    {
                        case 0:
                            break;
                        case 1:
                            purchaseProducts[productCount].setSeqNoText(name[i].get(j));
                            lastSeqNo=Integer.parseInt(name[i].get(j));
                            break;
                        case 2:
                            purchaseProducts[productCount].setSeek(name[i].get(j));
                            temp = purchaseProducts[productCount].getSeekText();
                            purchaseProducts[productCount].setpName(temp);
                            break;
                        case 3:
                            purchaseProducts[productCount].setTotalQty(name[i].get(j));
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
//                            purchaseProducts[productCount].getCustomeSize().setText(name[i].get(j));
                            break;
                        case 12:
//                            purchaseProducts[productCount].getCustomeSize().setText(name[i].get(j));
//                            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
//                            comboBoxModel.addElement(name[i].get(j));
//                            purchaseProducts[productCount].getpName2().setModel(comboBoxModel);
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
                    if(Float.parseFloat(purchaseProducts[productCount].getOrdDocNo().getText())!=0){
                    
                    }else{
                       if(Float.parseFloat(purchaseProducts[productCount].getOrdSeqNo().getText())!=0){
                    
                        }else{
                           purchaseProducts[productCount].textFieldsEditableProducts1(true);
                        }
                    }
                    purchaseProducts[productCount].setAllFieldData();
                }
                updateSumSplPanel();
                productCount=lastSeqNo;
            }
            
            PAK_GENERAL_DB data1 =new PAK_GENERAL_DB();
            try {
                issueLoad.setText(data1.getIL(connAA,dateField.toDateString(dlDate.getDate().toString()),dcode.getText(),vanCode.getText()));
                totalLoad.setText(data1.getTL(connAA,dateField.toDateString(dlDate.getDate().toString()),dcode.getText(),vanCode.getText()));
                netBal.setText(data1.get_clbal_from_custbal(connAA,custCode.getText()));
                preBal.setText((Float.parseFloat(netBal.getText())+Float.parseFloat(remaining.getText()))+""); 
            } catch (ParseException ex) {
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        editableProductPanel(false);
    }

    private void updateSumSplPanel() {
        
        Float zero=0.0f;
        
        BigDecimal sumGrossAmt2=new BigDecimal(zero+"");
        BigDecimal sumTaxRs2=new BigDecimal(zero+"");
        BigDecimal sumDiscRs2=new BigDecimal(zero+"");
        BigDecimal sumTo2=new BigDecimal(zero+"");
        BigDecimal sumfmr2rs=new BigDecimal(zero+"");
        BigDecimal sumNetAmt2=new BigDecimal(zero+"");
        
        for(int i=1;i<=productCount;i++){
            if(purchaseProducts[i]!=null&&purchaseProducts[i].isDisplayable() ){
                sumGrossAmt2=sumGrossAmt2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getGrossAmtText())));
                
                sumTaxRs2=sumTaxRs2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getTaxRsText())));
                
                sumDiscRs2=sumDiscRs2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getDiscRsText())));
                
                sumNetAmt2=sumNetAmt2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getNetAmtText())));
                
                sumfmr2rs=sumfmr2rs.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getFmrrs().getText())));
                
                sumTo2=sumTo2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getTdo().getText())));
                
            }
        }
        try{
           netAmt.setText(round(sumNetAmt2,3)+"");
           
           grossAmt.setText(round(sumGrossAmt2,3)+"");
           
           taxRs.setText(round(sumTaxRs2,3)+"");
           
           discount.setText(round(sumDiscRs2,3)+"");
           
           fmrsumrs.setText(round(sumfmr2rs,3)+"");
           
           tosum.setText(round(sumTo2,3)+"");
           
           BigDecimal result=new BigDecimal("0.0");
           if(!(sumGrossAmt2.compareTo(BigDecimal.ZERO) == 0)){
               result = (sumTaxRs2.multiply(BigDecimal.valueOf(Float.parseFloat("100.0")))).divide(sumGrossAmt2,3,BigDecimal.ROUND_HALF_UP);
           }
           taxPer.setText(round((result),3)+"");
           
           BigDecimal result2=new BigDecimal("0.0");
           if(!(sumGrossAmt2.compareTo(BigDecimal.ZERO) == 0)){result2 = (sumfmr2rs.multiply(BigDecimal.valueOf(Float.parseFloat("100.0")))).divide(sumGrossAmt2,3,BigDecimal.ROUND_HALF_UP);}
           fmrsum.setText(round((result2),3)+"");
           
           BigDecimal result1=new BigDecimal("0.0");
           if(!(sumGrossAmt2.compareTo(BigDecimal.ZERO) == 0)){result1 = (sumDiscRs2.multiply(BigDecimal.valueOf(Float.parseFloat("100.0")))).divide(sumGrossAmt2,3,BigDecimal.ROUND_HALF_UP);}
           avediscper.setText(round((result1),3)+"");

           frmSplFmrRs();//
           frmNetPayable();
           frmRemaning();
        }catch(NumberFormatException ex){
            if(ex.getMessage()!=null ){
                if(ex.getMessage().matches("empty String")){
                }else{
                    JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "Invalid Input", "InfoBox: ", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void frmSplPer() {
        try{
            if ((BigDecimal.valueOf(Float.parseFloat(netAmt.getText()))).compareTo(new BigDecimal("0"))==0) {
                splPer.setText(new BigDecimal("0")+"");
            }else{
                splPer.setText(round((((BigDecimal.valueOf(Float.parseFloat(splRs.getText()))).multiply(new BigDecimal("100.0"))).divide((BigDecimal.valueOf(Float.parseFloat(netAmt.getText()))),3,BigDecimal.ROUND_HALF_UP)),3)+"");
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

    private void frmSplRs() {
         try{
            splRs.setText(round((((BigDecimal.valueOf(Float.parseFloat(splPer.getText()))).multiply(BigDecimal.valueOf(Float.parseFloat(netAmt.getText())))).divide(BigDecimal.valueOf(Float.parseFloat("100.0")),3,BigDecimal.ROUND_HALF_UP)),3)+"");
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

    private void frmSplFmrRs() {
         try{
            splFmrRs.setText(round((((BigDecimal.valueOf(Float.parseFloat(splFmrPer.getText()))).multiply(BigDecimal.valueOf(Float.parseFloat(netAmt.getText())))).divide(BigDecimal.valueOf(Float.parseFloat("100.0")),3,BigDecimal.ROUND_HALF_UP)),3)+"");
        }catch(NumberFormatException ex){
           
        }
    }
    private void frmSplFmrPer() {
        try{
            splFmrPer.setText(round(((BigDecimal.valueOf(Float.parseFloat(splFmrRs.getText())).multiply(new BigDecimal("100.0"))).divide((BigDecimal.valueOf(Float.parseFloat(netAmt.getText()))),3,BigDecimal.ROUND_HALF_UP)),3)+"");
        }catch(NumberFormatException ex){
           
        }
    }
    private void frmNetPayable() {
        try{          
            netpayable.setText(round(((((BigDecimal.valueOf(Float.parseFloat(netAmt.getText()))).subtract(BigDecimal.valueOf(Float.parseFloat(splRs.getText())))).add(BigDecimal.valueOf(Float.parseFloat(otherExp.getText())))).subtract(BigDecimal.valueOf(Float.parseFloat(splFmrRs.getText())))),3)+"");
        }catch(NumberFormatException ex){
            if(ex.getMessage().matches("empty String")){
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Invalid Input", "InfoBox: ", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void frmRemaning() {
        try{
            remaining.setText(round(((BigDecimal.valueOf(Float.parseFloat(netpayable.getText()))).subtract(BigDecimal.valueOf(Float.parseFloat(paid.getText())))),3)+"");
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
        PAK_SALE_DB data =new PAK_SALE_DB();
        
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
            //System.out.println("Asset Found is findRecords:"+ s);
            
        } catch (SQLException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
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

    private void saveSale() {
        int max=0,codeInt=0;        
        if(!(custCode.getText().toString().equalsIgnoreCase(""))){
            PAK_SALE_DB data =new PAK_SALE_DB();
            try {
                boolean tf=false;
                max=data.find_max_in_purchase_code(connAA);
                if(max==0){
                    codeInt=1;
                }else{
                    codeInt=max+1;
                }
                String s12;
                if(b12c){s12=fmrsumrs.getText();}else{s12="0";}
                    
                tf=data.insert_purchase_in_table(connAA, dateField.toDateString(odDate.getDate().toString()), 
                    codeInt+"",refNo.getText(),custCode.getText(),grossAmt.getText(),s12,
                    splRs.getText(),otherExp.getText(),avediscper.getText(),discount.getText(),taxPer.getText(),
                    taxRs.getText(),netAmt.getText(),remaining.getText(),paid.getText(),remarks.getText(),
                    netpayable.getText(),dcode.getText(),tosum.getText(),splFmrPer.getText(),vanCode.getText(),obCode.getText(),dateField.toDateString(dlDate.getDate().toString()));
                if(tf=true){
                } 
                for(int i=1;i<=productCount;i++){
                        if(purchaseProducts[i].isDisplayable()&& !purchaseProducts[i].getSeekText().isEmpty()){
                            /*
                            if(Float.parseFloat(purchaseProducts[i].getOrdDocNo().getText())==0){
                            }else{
                               if(Float.parseFloat(purchaseProducts[i].getOrdSeqNo().getText())==0){
                                }else{
                                    PAK_ORDER_DB data1a;
                                    data1a = new PAK_ORDER_DB();
                                    Connection connAAa;
                                    try {
                                        connAAa = data1a.connect_database();

                                        tf=data1a.check_update_delivered_held(connAAa,
                                                purchaseProducts[i].getOrdDocNo().getText(),
                                                purchaseProducts[i].getOrdSeqNo().getText(),
                                                purchaseProducts[i].getTotalQty().getText());

                                        data1a.close_database(connAAa);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                            */
                            tf=data.insert_purchase_products_in_table_old(connAA,
                                codeInt+"",
                                purchaseProducts[i].getSeqNoText(),
                                purchaseProducts[i].getSeekText(),
                                purchaseProducts[i].getTotalQtyText(),
                                purchaseProducts[i].getRateText(),
                                purchaseProducts[i].getGrossAmtText(),
                                purchaseProducts[i].getDiscPerText(),
                                purchaseProducts[i].getTdo().getText(),
                                purchaseProducts[i].getTaxPerText(),
                                purchaseProducts[i].getFmr().getText(),
                                purchaseProducts[i].getNetAmtText(),
                                "",
                                purchaseProducts[i].getDate().getSelectedItem().toString(),
                                purchaseProducts[i].getDamage().getText(),
                                purchaseProducts[i].getFree().getText(),
                                "0.0");
                            String a = purchaseProducts[i].getSeekText();
String b =(new BigDecimal(Float.parseFloat(purchaseProducts[i].getTotalQtyText())).add(new BigDecimal(Float.parseFloat(purchaseProducts[i].getDamage().getText()))).add(new BigDecimal(Float.parseFloat(purchaseProducts[i].getFree().getText()))))+"";
                            String c = data.get_clqty_wrt_pmast_code(connAA, a);
                            BigDecimal d = new BigDecimal("0.0");
                            if (c != null) {
                                d = new BigDecimal(Float.parseFloat(c)).subtract(new BigDecimal(Float.parseFloat(b)));
                            }
                            boolean bool = data.update_clqty_in_pmast(connAA, d + "", a);
                        }
                    }
                    if(tf){
                        PAK_GENERAL_DB data12 =new PAK_GENERAL_DB();
                        
                            try {
                                int codeIntDsr;
                                if(!data12.isDSRPresent(connAA,dateField.toDateString(dlDate.getDate().toString()),dcode.getText(),vanCode.getText())){
                                    max=data12.find_max_in_DSR_code(connAA);
                                    if(max==0){
                                        codeIntDsr=1;
                                    }else{
                                        codeIntDsr=max+1;
                                    }
                                    data12.insertDSP(connAA,codeIntDsr+"",dateField.toDateString(dlDate.getDate().toString()),dcode.getText(),vanCode.getText());
                                }
                        } catch (ParseException ex) {
                                Logger.getLogger(PURCHASE.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                    }
                    if(tf){
                        if(cbQty.isSelected()){
                            if(radioCatinQty.isSelected()){
                                data.setCategorySchemeQty(connAA,codeInt+"");
                            }
                            if(radioSubCatinQty.isSelected()){
                                data.setCategorySchemeQty(connAA,codeInt+"");
                            }
                        }
                    }
                if(tf){
                    invNo.setText(String.valueOf(codeInt));
                    invNo.setEditable(false);
//                    btnShowOrder.setVisible(false);
                    forBackBtnEnable(true);
                    recEditBtnEnable(true);
                    recEditActionBtnVisible(false);
                    setLastInvoice();
                    textFieldsEditable(false);
                    editableProductPanel(false);
                    saveUpdateBtnVisible("all", false);
                    loadProductsPanel(codeInt+"");
                }
                
            } catch (Exception ex) {
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else{
            JFrame j=new JFrame();
            j.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(j, "Enter Custromer No And Others \n OR Press Cancel to Contine  ", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void updateTableView(String c[],String s) {
        String r[][]=null;//searchLike(searchField.getText());
/*DOCNO,SALEQTY,SALERATE,DISCPER,TOTALSIZE,RETURNQTY,
        */
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            boolean tf=false;
            r=data.search_history(connAA, s,custCode.getText());
            //System.out.println("Is Inserted :"+ tf);
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(r==null){
//            JOptionPane.showMessageDialog(null, "No Row Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }else{
            initTable(c,r);   
        }
    }
    
    private void updateTableView1(String c[],String s) {
        String r[][]=null;
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            boolean tf=false;
            r=data.search_history1(connAA, s);
            //System.out.println("Is Inserted :"+ tf);
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(r==null){
//            JOptionPane.showMessageDialog(null, "No Row Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }else{
            //System.out.println("098087689765789087654678909875643245678");
            initTable1(c,r);   
        }
    }
    private void initTable(String colNames[],String rowData[][]) {
        String col[] = colNames;//{"File","Path"};
        String row[][] =rowData;
        model = new DefaultTableModel(row,col);

        custHistory=new JTable(model){
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {                
                    return false;               
            };
        };
        custHistory.getAutoscrolls();
//        custHistory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        custHistory.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
//        custHistory.setBackground(Color.WHITE);
        custHistory.setRowHeight(30);
//        custHistory.set
        JTableHeader header = custHistory.getTableHeader();
        
        header.setPreferredSize(new Dimension(100, 30));
        custHistory.setShowHorizontalLines(false);
        custHistory.setEnabled(true);
//        custHistory.setBackground(Color.darkGray);
//        custHistory.setForeground(Color.white);
        custHistory.enableInputMethods(false);
        custHistory.setShowVerticalLines(false);
        custHistory.setShowGrid(false);
        custHistory.setRowSelectionAllowed(true);
        
        
        selectionModel = custHistory.getSelectionModel();
        selectionModel.setSelectionInterval(0, 0);
        
        custHistory.getKeyListeners();
        custHistory.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                }
            }
        });
        custHistory.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        custHistory.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            }
        });
        custHistory.getColumnModel().getColumn(0).setPreferredWidth(120);
        custHistory.getColumnModel().getColumn(1).setPreferredWidth(120);
        jScrollPane3.setViewportView(custHistory);
    }
    private void initTable1(String colNames[],String rowData[][]) {
        String col[] = colNames;//{"File","Path"};
        String row[][] =rowData;
        model = new DefaultTableModel(row,col);

        expiryDtl=new JTable(model){
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {                
                    return false;               
            };
        };
        expiryDtl.getAutoscrolls();
//        expiryDtl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        expiryDtl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
//        expiryDtl.setBackground(Color.WHITE);
        expiryDtl.setRowHeight(30);
//        expiryDtl.set
        JTableHeader header = expiryDtl.getTableHeader();
        
        header.setPreferredSize(new Dimension(100, 30));
        expiryDtl.setShowHorizontalLines(false);
        expiryDtl.setEnabled(true);
//        expiryDtl.setBackground(Color.darkGray);
//        expiryDtl.setForeground(Color.white);
        expiryDtl.enableInputMethods(false);
        expiryDtl.setShowVerticalLines(false);
        expiryDtl.setShowGrid(false);
        expiryDtl.setRowSelectionAllowed(true);
        
        
        selectionModel = expiryDtl.getSelectionModel();
        selectionModel.setSelectionInterval(0, 0);
        
        expiryDtl.getKeyListeners();
        expiryDtl.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                }
            }
        });
        expiryDtl.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        expiryDtl.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            }
        });
        expiryDtl.getColumnModel().getColumn(0).setPreferredWidth(120);
        expiryDtl.getColumnModel().getColumn(1).setPreferredWidth(120);
        jScrollPane4.setViewportView(expiryDtl);
    }

    private void khaliTable() {
        String colNames[]={"Inv No","Date","Qty","Rate","Disc %"};String rowData[][]={};initTable(colNames, rowData);
        String col1[]={"Expiry Date","Bstch","Qty"};String row1[][]={};initTable1(col1, row1);
        
    }
    public static String setNetTotalStock(String pCode,Connection cc) {
        String s="0";
            PAK_GENERAL_DB data =new PAK_GENERAL_DB();
            
            try {
                
                if(pCode!=null){s=data.getNetTotalStock(cc,pCode);}
            } catch (Exception ex) {
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
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

    private void findPrior() {
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            ArrayList<String> prior = new ArrayList<String>();
            prior=data.prior_purchase(connAA,invNo.getText());
            if(prior!=null){
                setTextinPurchase(prior, dateField);
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Prior not found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void findPriorWRTcust() {
        PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            ArrayList<String> prior = new ArrayList<String>();
            prior=data.prior_cust_purchase(connAA,invNo.getText(),custCode.getText());
            if(prior!=null){
                setTextinPurchase(prior, dateField);
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Prior not found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setNext() {
            PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            ArrayList<String> next = new ArrayList<String>();
            next=data.next_purchase(connAA,invNo.getText());
            if(next!=null){
                setTextinPurchase(next, dateField);
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Next not found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setNextWRTcust() {
            PAK_SALE_DB data =new PAK_SALE_DB();
        
        try {
            
            ArrayList<String> next = new ArrayList<String>();
            next=data.next_cust_purchase(connAA,invNo.getText(),custCode.getText());
            if(next!=null){
                setTextinPurchase(next, dateField);
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Next not found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
