/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.frames.salesOrder;


import DB.PAK_DB;
import DB.PAK_GLOBAL_DB;
import DB.PAK_PAYSELLER_DB;
import DB.PAK_RECOVERY_DB;
import DB.PAK_ORDER_DB;
import DB.PAK_ORDER_DB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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
import static DynamicERP.dialoge.viewforms.dialogeClass.createJasperView;
import DynamicERP.frames.mainpkg.MAIN;
import DynamicERP.frames.purchase.PURCHASE;
import DynamicERP.frames.sales.SALES;
import static DynamicERP.frames.salesOrder.PakSalesOrderFieldPanel.round;
import java.awt.Point;
import java.util.Enumeration;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Shan
 */
public class SALESORDER extends 
        javax.swing.JFrame {
    Conversions dateField=new Conversions();

    /**
     * Creates new form PURCHASE
     */PAK_GLOBAL_DB dataAA =new PAK_GLOBAL_DB();
    Connection connAA;
    
    public SALESORDER() {
        initComponents();
        styleComboBox(suppName);
        styleComboBox(dName);
        
        maximize();
        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioCancel);
        buttonGroup.add(radioDelivered);
        buttonGroup.add(radioPending);
        try {
            connAA = dataAA.connect_database();

        }catch (SQLException e) {
            System.out.println("Exception ===> "+e);
        }    
        panel.setBorder(BorderFactory.createTitledBorder("Sales Invoice Properties: "));
        purchaseScrollPane.setBorder(BorderFactory.createTitledBorder("Products Sales Adjustments in invoice: "));
        jpanspl.setBorder(BorderFactory.createTitledBorder("Invoice Details & SPL Adjustments: "));
        saveUpdateBtnVisible("all", false);
        textFieldsEditable(false);
//      initTable();
//      initScrollPanel();
        initPanel();
        try {
            setLastRec();
        } catch (ParseException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLastInvoice();
    }
 public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        link9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
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
        print2 = new javax.swing.JButton();
        btnclients = new javax.swing.JLabel();
        btnclients1 = new javax.swing.JLabel();
        purchaseScrollPane = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        invNo = new javax.swing.JTextField();
        refNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        custCode = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        suppName = new javax.swing.JComboBox();
        oDate = new com.toedter.calendar.JDateChooser();
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
        btnexit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        radioDelivered = new javax.swing.JRadioButton();
        radioPending = new javax.swing.JRadioButton();
        radioCancel = new javax.swing.JRadioButton();
        dlDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        remarks = new javax.swing.JTextField();
        pan_history = new javax.swing.JPanel();
        histogram = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        custHistory = new javax.swing.JTable();

        jLabel9.setBackground(new java.awt.Color(0, 102, 102));
        jLabel9.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Sales Record Managements");
        jLabel9.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DynamicSP Purchase Record Managements (http://dspak.com)");
        setAutoRequestFocus(false);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(940, 660));
        setModalExclusionType(null);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setPreferredSize(new java.awt.Dimension(1024, 50));

        jLabel12.setBackground(new java.awt.Color(0, 102, 102));
        jLabel12.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Sales Orders Management");
        jLabel12.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout sumPanelLayout = new javax.swing.GroupLayout(sumPanel);
        sumPanel.setLayout(sumPanelLayout);
        sumPanelLayout.setHorizontalGroup(
            sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sumPanelLayout.createSequentialGroup()
                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(sumPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Builty2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Builty3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(6, 6, 6)
                        .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sumPanelLayout.createSequentialGroup()
                                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(taxPer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(avediscper, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(taxRs, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Builty20)))
                            .addComponent(Builty19)))
                    .addGroup(sumPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Builty1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Builty8, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(sumPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linvNo)
                            .addComponent(netAmt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(grossAmt))))
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
                    .addComponent(netAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Builty8))
                .addGap(0, 0, 0)
                .addGroup(sumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(linvNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        javax.swing.GroupLayout splPanelLayout = new javax.swing.GroupLayout(splPanel);
        splPanel.setLayout(splPanelLayout);
        splPanelLayout.setHorizontalGroup(
            splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(splPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Builty15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Builty4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Builty18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Builty12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Builty11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paid)
                    .addComponent(remaining)
                    .addComponent(netpayable)
                    .addGroup(splPanelLayout.createSequentialGroup()
                        .addComponent(splPer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(splRs))
                    .addGroup(splPanelLayout.createSequentialGroup()
                        .addGroup(splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(splPanelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(Builty17))
                            .addComponent(otherExp, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(splPanelLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(Builty21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        splPanelLayout.setVerticalGroup(
            splPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, splPanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        print2.setText("Print");
        print2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print2ActionPerformed(evt);
            }
        });

        btnclients.setForeground(new java.awt.Color(0, 102, 102));
        btnclients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/Clients 24.png"))); // NOI18N
        btnclients.setText("Clients Record");
        btnclients.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnclients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnclientsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnclientsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnclientsMouseExited(evt);
            }
        });

        btnclients1.setForeground(new java.awt.Color(0, 102, 102));
        btnclients1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/salesinv 24.png"))); // NOI18N
        btnclients1.setText("Dileveries / Invoice Record");
        btnclients1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnclients1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnclients1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnclients1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnclients1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpansplLayout = new javax.swing.GroupLayout(jpanspl);
        jpanspl.setLayout(jpansplLayout);
        jpansplLayout.setHorizontalGroup(
            jpansplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpansplLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpansplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sumPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpansplLayout.createSequentialGroup()
                        .addComponent(print2)
                        .addGap(18, 18, 18)
                        .addComponent(btnclients, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpansplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpansplLayout.createSequentialGroup()
                        .addComponent(splPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jpansplLayout.createSequentialGroup()
                        .addComponent(btnclients1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(57, 57, 57))))
        );
        jpansplLayout.setVerticalGroup(
            jpansplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpansplLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpansplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(splPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sumPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpansplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(print2)
                    .addComponent(btnclients)
                    .addComponent(btnclients1))
                .addContainerGap())
        );

        purchaseScrollPane.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        purchaseScrollPane.setFocusCycleRoot(true);
        purchaseScrollPane.setMaximumSize(new java.awt.Dimension(1280, 450));

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
        btnLast.setMnemonic('L');
        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnNext.setMnemonic('N');
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrior.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnPrior.setMnemonic('P');
        btnPrior.setText("Prior");
        btnPrior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPriorActionPerformed(evt);
            }
        });

        btnFirst.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 51));
        jLabel3.setText("(Auto Genrated)");

        radioDelivered.setText("Delivered");
        radioDelivered.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                radioDeliveredMouseEntered(evt);
            }
        });
        radioDelivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDeliveredActionPerformed(evt);
            }
        });

        radioPending.setText("Pending");
        radioPending.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioPendingStateChanged(evt);
            }
        });
        radioPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPendingActionPerformed(evt);
            }
        });
        radioPending.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                radioPendingPropertyChange(evt);
            }
        });

        radioCancel.setText("Canceled");
        radioCancel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioCancelStateChanged(evt);
            }
        });
        radioCancel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                radioCancelFocusGained(evt);
            }
        });
        radioCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioCancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                radioCancelMouseEntered(evt);
            }
        });
        radioCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCancelActionPerformed(evt);
            }
        });

        jLabel6.setText("Dl Date:");

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
                        .addGap(1, 1, 1)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrior, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(dcode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(invNo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, 0)
                                        .addComponent(dlDate, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(custCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(328, 328, 328)
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, 0)
                                        .addComponent(refNo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(remarks))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(radioDelivered)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioPending)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(suppName, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addComponent(oDate, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(oDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnexit)
                    .addComponent(btnDel)
                    .addComponent(btnView)
                    .addComponent(btnSearch)
                    .addComponent(btnEdit)
                    .addComponent(btnAdd))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(btnFirst)
                        .addGap(0, 0, 0)
                        .addComponent(btnPrior)
                        .addGap(0, 0, 0)
                        .addComponent(btnNext)
                        .addGap(0, 0, 0)
                        .addComponent(btnLast))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(invNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(dlDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suppName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(custCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(refNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, 0)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11))
                            .addComponent(dName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioDelivered)
                        .addComponent(radioPending)
                        .addComponent(radioCancel))
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave)
                        .addComponent(btnUpdate)
                        .addComponent(btnCancel)
                        .addComponent(btnSearchNow)
                        .addComponent(btnAddRow)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        histogram.setSelected(true);
        histogram.setText("Display History");

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

        javax.swing.GroupLayout pan_historyLayout = new javax.swing.GroupLayout(pan_history);
        pan_history.setLayout(pan_historyLayout);
        pan_historyLayout.setHorizontalGroup(
            pan_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_historyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(histogram))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pan_historyLayout.setVerticalGroup(
            pan_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_historyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(histogram)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(purchaseScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pan_history, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanspl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanspl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(purchaseScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pan_history, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1191, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1171, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addGap(1, 1, 1)
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
        switch (getSelectedButtonText(buttonGroup)) 
        {
           case "Delivered":
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "You can not edit the delivered o\", rder", "InfoBox: ", JOptionPane.WARNING_MESSAGE);
               break;
           case "Pending":
                forBackBtnEnable(false);
                recEditBtnEnable(false);

                textFieldsEditable(true);
                saveUpdateBtnVisible("update", true);

                sellers1=(String)suppName.getSelectedItem();
                refNo1=refNo.getText();
                remarks1=remarks.getText();
               break;
           case "Canceled":
                forBackBtnEnable(false);
                recEditBtnEnable(false);

                textFieldsEditable(true);
                saveUpdateBtnVisible("update", true);

                sellers1=(String)suppName.getSelectedItem();
                refNo1=refNo.getText();
                remarks1=remarks.getText();
               break;
        }
////System.out.println("At EDIT Max PC:"+productCount);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        forBackBtnEnable(false);
        recEditBtnEnable(false);
        saveUpdateBtnVisible("save", true);
        textFieldsEditable(true);
        setNullTextFields();
        
        inetializePrductPanel();
        try {
            oDate.setDate(dateField.getPresentDate());
        } catch (ParseException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        switch (getSelectedButtonText(buttonGroup)) 
        {
            case "Delivered":
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "You can not Delete Delivered order", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Pending":
                PAK_ORDER_DB data =new PAK_ORDER_DB();
                Connection conn;
                try {
                    conn = data.connect_database();
                    if(data.check_delivered_presence(conn,invNo.getText())){
                        delete();
                    }else{
                        JFrame j2=new JFrame();
                        j2.setAlwaysOnTop(true);
                        JOptionPane.showMessageDialog(j2, "You can not Delete Partialy Delivered order", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Canceled":
                delete();
                break;
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
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
            dialogeClass.createViewSalesOrderWin();
        } catch (SQLException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(isSaved){
            invNo.setText(dialogeClass.codeSalesOrder);
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
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
        PAK_ORDER_DB data =new PAK_ORDER_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            ArrayList<String> next = new ArrayList<String>();
            next=data.next_purchase(conn,invNo.getText());
            if(next!=null){
                setTextinPurchase(next, dateField);
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Next not found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPriorActionPerformed
        // SELECT LAG(p.FirstName) OVER (ORDER BY p.BusinessEntityID) PreviousValue,p.FirstName FROM Person.Person p
        PAK_ORDER_DB data =new PAK_ORDER_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            ArrayList<String> prior = new ArrayList<String>();
            prior=data.prior_purchase(conn,invNo.getText());
            if(prior!=null){
                setTextinPurchase(prior, dateField);
            }else{
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Prior not found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }

            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
        ////System.out.println("At PRIOR Max PC:"+productCount);
        ////System.out.println("At PRIOR Max PC:"+productCount);
        ////System.out.println("At PRIOR Max PC:"+productCount);
        ////System.out.println("At PRIOR Max PC:"+productCount);
    }//GEN-LAST:event_btnPriorActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        try {
            setFirstRec();
        } catch (ParseException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
        editableProductPanel(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateSumSplPanel();
        boolean tf=false;
        PAK_ORDER_DB data =new PAK_ORDER_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            String stat = data.get_status(conn, invNo.getText());
                try {
                    /*
                    String[] s = data.get_invNo_clientCode_remaining(conn,invNo.getText() + "");
                    int a=0;
                    if(s[0].equalsIgnoreCase(invNo.getText())&&s[1].equalsIgnoreCase(custCode.getText())&&s[2].equalsIgnoreCase(remaining.getText())){
                        a=3;
                    }else if(s[0].equalsIgnoreCase(invNo.getText())&&s[1].equalsIgnoreCase(custCode.getText())){
                        a=1;
                    }else if(s[0].equalsIgnoreCase(invNo.getText())){
                        a=2;
                    }
                    switch(a){
                    case 3:
                        //do nothing
                        break;
                    case 1:
                        //============================CLIENTS CLBAL===================================
                        PAK_ORDER_DB data5 =new PAK_ORDER_DB();
                        Connection conn5;
                        try {
                            conn5=data5.connect_database();
                            String purchaseProduct = data5.get_clbal_from_clints(conn5,custCode.getText());
                            if(purchaseProduct!=null){
                                BigDecimal b=null;
                                b =(new BigDecimal(purchaseProduct).add(new BigDecimal(s[2]))).subtract(new BigDecimal(remaining.getText()));

                                if(b!=null){
                                    data5.update_clbal_in_clints(conn5,b+"",custCode.getText());
                                }

                        conn5.close();
                            }
                        }catch(Exception e){
                            System.out.println("Exceptiojn"+e);
                        }
                        //=========================================================================  
                        break;
                    case 2:
                        //============================CLIENTS CLBAL===================================
                        PAK_ORDER_DB data6 =new PAK_ORDER_DB();
                        Connection conn6;
                        try {
                            conn6=data6.connect_database();
                            
                             String purchaseProduct = data6.get_clbal_from_clints(conn6,s[1]);
                             if(purchaseProduct!=null){
                                BigDecimal b1=null;
                                b1 =new BigDecimal(purchaseProduct).add(new BigDecimal(s[2]));
                                if(b1!=null){
                                    data6.update_clbal_in_clints(conn6,b1+"",s[1]);
                                }
                            }
                            purchaseProduct = data6.get_clbal_from_clints(conn6,custCode.getText());
                            if(purchaseProduct!=null){
                                BigDecimal b=null;
                                b =new BigDecimal(purchaseProduct).subtract(new BigDecimal(remaining.getText()));

                                if(b!=null){
                                    data6.update_clbal_in_clints(conn6,b+"",custCode.getText());
                                }
                            }  
                           
                            
                        conn6.close();
                        }catch(Exception e){
                            System.out.println("Exceptiojn"+e);
                        }
                        //=========================================================================
                        break;
                    }
                    System.out.println("===a:"+a);
                    */
                    String status = null; 
                    switch (getSelectedButtonText(buttonGroup)) 
                     {
                        case "Delivered":
                            status="D";
                            break;
                        case "Pending":
                            status="P";
                            break;
                        case "Canceled":
                            status="C";
                            break;
                     }
//                    System.out.println("dateField.toDateString(dlDate.getDate().toString()) :"+
//                            ((dlDate.getDate()!=null)?dateField.toDateString(dlDate.getDate().toString()):null));
                    tf=data.update_purchase(conn
                            , dateField.toDateString(oDate.getDate().toString())
                            , ((dlDate.getDate()!=null)?dateField.toDateString(dlDate.getDate().toString()):""),
                            invNo.getText()+"",refNo.getText(),
                            custCode.getText(),
                            grossAmt.getText(),
                            splPer.getText(),
                            splRs.getText(),
                            otherExp.getText(),
                            avediscper.getText(),
                            discount.getText(),
                            taxPer.getText(),
                            taxRs.getText(),
                            netAmt.getText(),
                            remaining.getText(),
                            paid.getText(),
                            remarks.getText(),
                            netpayable.getText(),
                            dcode.getText(),
                            status);
                    System.out.println("update_purchase: "+tf);
                
                } catch (ParseException ex) {
                    Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
                }
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
        ///==========================================================================
        
        
            for(int i=1;i<=productCount;i++){
                //System.out.println("-> "+i+" : productCount->"+productCount);
                if(purchaseProducts[i]!=null&&purchaseProducts[i].isDisplayable()){
                    if(!purchaseProducts[i].getSeekText().isEmpty()){
                        boolean isPresent=false;

                        PAK_ORDER_DB data1 =new PAK_ORDER_DB();
                        Connection conn1;
                        try {
                            conn1 = data1.connect_database();
//                            if(getSelectedButtonText(buttonGroup).equalsIgnoreCase("Delivered")){
//                                if(data.find_max_in_purchase_products(conn1, invNo.getText())<=productCount){
                                    //System.out.println("IF");
                                    isPresent=data1.check_product_line_item_presence_new(conn1, invNo.getText(),purchaseProducts[i].getSeqNoText(),productCount);
/*
                                    if(isPresent) {
                                        String isPresent1 = data1.check_product_line_item_presence_with_seek(conn1, invNo.getText(), purchaseProducts[i].getSeqNoText(), purchaseProducts[i].getSeekText(), productCount);

                                        if(isPresent1.equals("true")){
                                        // if PCODE present RTN TRUE or not PCODE + DELIVERED 
                                            System.out.println("true"+isPresent1);
    //                                        /*
                                            ///==========================================================================
                                            String a = purchaseProducts[i].getSeekText();
                                            String b = purchaseProducts[i].getTotalQtyText();
                                            String f =  invNo.getText();
                                            String e = data1.get_delivered_wrt_perdtl_code_seek(conn1, a,f);
                                            System.out.println("e: " + e);
                                            System.out.println("e: " + a);
                                            System.out.println("e: " + f);
                                            BigDecimal d1 = new BigDecimal("0.0");
                                            if (e != null) {
                                                d1 = new BigDecimal(Float.parseFloat(e)).subtract(new BigDecimal(Float.parseFloat(b)));
                                            }

                                            String c = data1.get_clqty_wrt_pmast_code(conn1, a);
                                            BigDecimal d = new BigDecimal("0.0");
                                            if (c != null) {
                                                d = (new BigDecimal(Float.parseFloat(c))).add(d1);
                                            }
                                            boolean bool = data1.update_clqty_in_pmast(conn1, d + "", a);
                                            ///===============================
    //                                        
                                        }else{
                                            System.out.println("false=============="+isPresent1);
                                            String s=isPresent1.substring(isPresent1.indexOf(" ")+1, isPresent1.length()); 
                                            String s1=isPresent1.substring(0,isPresent1.indexOf(" ")); 
                                            System.out.println("Code======================"+s1+"=");
                                            System.out.println("Perqty ========================="+s+"=");   

//                                            /*
                                            ///==========================================================================
                                            String a = s1;
                                            String b = s;
                                            String f =  invNo.getText();
                                            String e = data1.get_clqty_wrt_pmast_code(conn1, s1);
                                            System.out.println("e: " + e);
                                            System.out.println("e: " + a);
                                            System.out.println("e: " + f);
                                            BigDecimal d1 = new BigDecimal("0.0");
                                            if (e != null) {
                                                d1 = new BigDecimal(Float.parseFloat(e)).add(new BigDecimal(Float.parseFloat(b)));
                                            }

                                            boolean bool = data1.update_clqty_in_pmast(conn1, d1 + "", a);

                                             a = purchaseProducts[i].getSeekText();
                                             b = purchaseProducts[i].getTotalQtyText();
                                            String c = data.get_clqty_wrt_pmast_code(conn1, a);
                                            BigDecimal d = new BigDecimal("0.0");
                                            if (c != null) {
                                                d = new BigDecimal(Float.parseFloat(c)).subtract(new BigDecimal(Float.parseFloat(b)));
                                            }
                                            bool = data1.update_clqty_in_pmast(conn1, d + "", a);

                                            ///===============================
//                                            

                                        }
                                    } else {
                                        
                                        
                                    }
                            */
//                                }else{
//                                    isPresent=false;
//                                }
//                            }
                            data1.close_database(conn1);
                        } catch (SQLException ex) {
                            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //System.out.println("isPresent->"+isPresent);
                        if(isPresent){
                            System.out.println(invNo.getText()+""+" UPDATE-> "+purchaseProducts[i].getSeqNoText());

                            
                            PAK_ORDER_DB data2 =new PAK_ORDER_DB();
                            Connection conn2;
                            try {
                                conn2 = data2.connect_database();
                                /*String pNameNumber=null;
                                switch (purchaseProducts[i].getpType().getSelectedItem().toString()) 
                                {
                                   case "SFT":
                                       pNameNumber="1";
                                       break;
                                   case "RFT":
                                       pNameNumber="2";
                                       break;
                                   case "PER PIECE":
                                       pNameNumber="3";
                                       break;
                                   case "CUSTOME":
                                       pNameNumber="4";
                                       break;
                                }*/
                                switch (getSelectedButtonText(buttonGroup)) 
                                {
                                   case "Delivered":
                                       tf=data2.update_purchase_products_in_table_new(conn2,
                                        invNo.getText(),purchaseProducts[i].getSeqNoText(),
                                        purchaseProducts[i].getSeekText(),
                                        purchaseProducts[i].getTotalQtyText(),
                                        purchaseProducts[i].getRateText(),
                                        purchaseProducts[i].getGrossAmtText(),
                                        purchaseProducts[i].getDiscPerText(),
                                        purchaseProducts[i].getDiscRsText(),
                                        purchaseProducts[i].getTaxPerText(),
                                        purchaseProducts[i].getTaxRsText(),
                                        purchaseProducts[i].getNetAmtText(),
                                        "0.0",//qty
                                        purchaseProducts[i].getTotalQty().getText(),//delev
                                        "0.0",//held
                                        purchaseProducts[i].getDmg().getText(),
                                        purchaseProducts[i].getFree().getText(),
                                        purchaseProducts[i].getCustSize().getText());

                                       break;
                                   case "Pending":
                                       String deliv = data2.get_delivered_wrt_seqno(conn2, purchaseProducts[i].getSeqNoText(), invNo.getText());
                                       if(deliv!=null){
                                           tf=data2.update_purchase_products_in_table_new(conn2,
                                        invNo.getText(),purchaseProducts[i].getSeqNoText(),
                                        purchaseProducts[i].getSeekText(),
                                        purchaseProducts[i].getTotalQtyText(),
                                        purchaseProducts[i].getRateText(),
                                        purchaseProducts[i].getGrossAmtText(),
                                        purchaseProducts[i].getDiscPerText(),
                                        purchaseProducts[i].getDiscRsText(),
                                        purchaseProducts[i].getTaxPerText(),
                                        purchaseProducts[i].getTaxRsText(),
                                        purchaseProducts[i].getNetAmtText(),
                                        "0.0",//rtnqty
                                        Float.parseFloat(deliv)+"",//delev
                                        Float.parseFloat(purchaseProducts[i].getTotalQtyText())-Float.parseFloat(deliv)+"",//held
                                        purchaseProducts[i].getDmg().getText(),
                                        purchaseProducts[i].getFree().getText(),
                                        purchaseProducts[i].getCustSize().getText());
                                       }
                                       break;
                                   case "Canceled":
                                       tf=data2.update_purchase_products_in_table_new(conn2,
                                        invNo.getText(),
                                        purchaseProducts[i].getSeqNoText(),
                                        purchaseProducts[i].getSeekText(),
                                        purchaseProducts[i].getTotalQtyText(),
                                        purchaseProducts[i].getRateText(),
                                        purchaseProducts[i].getGrossAmtText(),
                                        purchaseProducts[i].getDiscPerText(),
                                        purchaseProducts[i].getDiscRsText(),
                                        purchaseProducts[i].getTaxPerText(),
                                        purchaseProducts[i].getTaxRsText(),
                                        purchaseProducts[i].getNetAmtText(),
                                        purchaseProducts[i].getTotalQty().getText(),//qty
                                        "0.0",//delev
                                        "0.0",//held
                                        purchaseProducts[i].getDmg().getText(),
                                        purchaseProducts[i].getFree().getText(),
                                        purchaseProducts[i].getCustSize().getText());
                                       break;
                                }
                                System.out.println("update_purchase_products_in_table_new: "+tf);
                                
                                data2.close_database(conn2);
                            } catch (SQLException ex) {
                                Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }else {
                            //System.out.println(invNo.getText()+""+" INSERT-> "+purchaseProducts[i].getSeqNoText());

                            PAK_ORDER_DB data3 =new PAK_ORDER_DB();
                            Connection conn3;
                            try {
                                conn3 = data3.connect_database();
                                String pNameNumber=null;
                                /*switch (purchaseProducts[i].getpType().getSelectedItem().toString()) 
                                {
                                   case "SFT":
                                       pNameNumber="1";
                                       break;
                                   case "RFT":
                                       pNameNumber="2";
                                       break;
                                   case "PER PIECE":
                                       pNameNumber="3";
                                       break;
                                   case "CUSTOME":
                                       pNameNumber="4";
                                       break;
                                }*/
//                                 status = null; 
                            switch (getSelectedButtonText(buttonGroup)) 
                             {
                                case "Delivered":
                                    tf=data.insert_purchase_products_in_table(conn3,
                                    invNo.getText(),purchaseProducts[i].getSeqNoText(),purchaseProducts[i].getSeekText(),purchaseProducts[i].getTotalQtyText(),
                                    purchaseProducts[i].getRateText(),purchaseProducts[i].getGrossAmtText(),purchaseProducts[i].getDiscPerText(),
                                    purchaseProducts[i].getDiscRsText(),purchaseProducts[i].getTaxPerText(),purchaseProducts[i].getTaxRsText(),
                                    purchaseProducts[i].getNetAmtText(),"0.0",purchaseProducts[i].getTotalQty().getText(),"0.0",
                                    purchaseProducts[i].getDmg().getText(),
                                    purchaseProducts[i].getFree().getText(),
                                    purchaseProducts[i].getCustSize().getText());
                                    break;
                                case "Pending":
                                    tf=data.insert_purchase_products_in_table(conn3,invNo.getText(),purchaseProducts[i].getSeqNoText(),
                                    purchaseProducts[i].getSeekText(),purchaseProducts[i].getTotalQtyText(),purchaseProducts[i].getRateText(),
                                    purchaseProducts[i].getGrossAmtText(),purchaseProducts[i].getDiscPerText(),purchaseProducts[i].getDiscRsText(),
                                    purchaseProducts[i].getTaxPerText(),purchaseProducts[i].getTaxRsText(),purchaseProducts[i].getNetAmtText(),
                                    "0.0","0.0",purchaseProducts[i].getTotalQty().getText(),
                                    purchaseProducts[i].getDmg().getText(),
                                    purchaseProducts[i].getFree().getText(),purchaseProducts[i].getCustSize().getText());
                                    break;
                                case "Canceled":
                                    tf=data.insert_purchase_products_in_table(conn3,invNo.getText(),purchaseProducts[i].getSeqNoText(),
                                    purchaseProducts[i].getSeekText(),purchaseProducts[i].getTotalQtyText(),purchaseProducts[i].getRateText(),
                                    purchaseProducts[i].getGrossAmtText(),purchaseProducts[i].getDiscPerText(),purchaseProducts[i].getDiscRsText(),
                                    purchaseProducts[i].getTaxPerText(),purchaseProducts[i].getTaxRsText(),purchaseProducts[i].getNetAmtText(),
                                    purchaseProducts[i].getTotalQty().getText(),
                                    "0.0","0.0",
                                    purchaseProducts[i].getDmg().getText(),
                                    purchaseProducts[i].getFree().getText(),purchaseProducts[i].getCustSize().getText());
                                    break;
                             }
                                
                                
                                
                            /*    
                            String a = purchaseProducts[i].getSeekText();
                            String b = purchaseProducts[i].getTotalQtyText();
                            String c = data3.get_clqty_wrt_pmast_code(conn3, a);
                            BigDecimal d = new BigDecimal("0.0");
                            if (c != null) {
                                d = new BigDecimal(Float.parseFloat(c)).subtract(new BigDecimal(Float.parseFloat(b)));
                            }
                            boolean bool = data3.update_clqty_in_pmast(conn3, d + "", a);
                                */
                                data3.close_database(conn3);
                            } catch (SQLException ex) {
                                Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }else{
                        JFrame j=new JFrame();
                        j.setAlwaysOnTop(true);
                        JOptionPane.showMessageDialog(j, "Empty Seek Value will not be updatd \n Nor will be deleted", "InfoBox: ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
         /*   
        //======================sellers legers==================
            PAK_CUSTLEG_DB data1 =new PAK_CUSTLEG_DB();
            Connection conn1;
             try {
                conn1 = data1.connect_database();
                try {
                    String s="Order From "+sellers1+" Ref # "+refNo1+" Remarks: "+remarks1;
                    
                    if(data1.check_product_line_item_description_presence_new(conn1, invNo.getText(),s )){
                        
                    }
                    tf=data1.update_cust_ledger(conn1,
                            custCode.getText(),
                            dateField.toDateString(oDate.getDate().toString()),
"Order From "+suppName.getSelectedItem()+" Ref # "+refNo.getText()+" Remarks: "+remarks.getText(),
                            paid.getText(),
                            netpayable.getText(),
                            invNo.getText(),
                            s);
                    System.out.println("update_cust_ledger"+tf);
                } catch (ParseException ex) {
                    Logger.getLogger(PURCHASE.class.getName()).log(Level.SEVERE, null, ex);
                }
                data1.close_database(conn1);
            } catch (SQLException ex) {
                Logger.getLogger(PURCHASE.class.getName()).log(Level.SEVERE, null, ex);
            }
        //======================cust legers==================
            */
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
        int max=0,codeInt=0;        
        if(!(custCode.getText().toString().equalsIgnoreCase(""))){
            PAK_ORDER_DB data =new PAK_ORDER_DB();
            Connection conn;
            try {
                conn = data.connect_database();
                boolean tf=false;

                ///Max
                max=data.find_max_in_purchase_code(conn);
                
                //System.out.println("Max:"+max);
                if(max==0){
                    codeInt=1;
                }else{
                    codeInt=max+1;
                }
                ///Max                 String.valueOf(codeInt)
                /*
            //============================CLIENTS CLBAL===================================
                String purchaseProduct = data.get_clbal_from_clints(conn,custCode.getText());
                if(purchaseProduct!=null){
                    BigDecimal b=null;
                    b = new BigDecimal(purchaseProduct).subtract(new BigDecimal(remaining.getText()));
                    if(b!=null){
                        data.update_clbal_in_clints(conn,b+"",custCode.getText());
                    }
                }
                //========================================================================= 
                */
                
                String status = null; 
                switch (getSelectedButtonText(buttonGroup)) 
                 {
                    case "Delivered":
                        status="D";
                        break;
                    case "Pending":
                        status="P";
                        break;
                    case "Canceled":
                        status="C";
                        break;
                 }
                tf=data.insert_purchase_in_table(conn, dateField.toDateString(oDate.getDate().toString()),
                        ((dlDate.getDate()!=null)?dateField.toDateString(dlDate.getDate().toString()):""), 
                        codeInt+"",refNo.getText(),custCode.getText(),grossAmt.getText(),splPer.getText(),
                        splRs.getText(),otherExp.getText(),avediscper.getText(),discount.getText(),taxPer.getText(),
                        taxRs.getText(),netAmt.getText(),remaining.getText(),paid.getText(),remarks.getText(),
                        netpayable.getText(),dcode.getText(),status);
                
                System.out.println("insert_purchase_in_table : "+tf);
                    for(int i=1;i<=productCount;i++){
                        if(purchaseProducts[i].isDisplayable()&& !purchaseProducts[i].getSeekText().isEmpty()){
                            /*String pNameNumber = null; 
                            switch (purchaseProducts[i].getpType().getSelectedItem().toString()) 
                             {
                                case "SFT":
                                    pNameNumber="1";
                                    break;
                                case "RFT":
                                    pNameNumber="2";
                                    break;
                                case "PER PIECE":
                                    pNameNumber="3";
                                    break;
                                case "CUSTOME":
                                    pNameNumber="4";
                                    break;
                             }*/
                            status = null; 
                            switch (getSelectedButtonText(buttonGroup)) 
                             {
                                case "Delivered":
                                    tf=data.insert_purchase_products_in_table(conn,
                                    codeInt+"",
                                    purchaseProducts[i].getSeqNoText(),
                                    purchaseProducts[i].getSeekText(),
                                    purchaseProducts[i].getTotalQtyText(),
                                    purchaseProducts[i].getRateText(),
                                    purchaseProducts[i].getGrossAmtText(),
                                    purchaseProducts[i].getDiscPerText(),
                                    purchaseProducts[i].getDiscRsText(),
                                    purchaseProducts[i].getTaxPerText(),
                                    purchaseProducts[i].getTaxRsText(),
                                    purchaseProducts[i].getNetAmtText(),"0.0",
                                    purchaseProducts[i].getTotalQty().getText(),"0.0",
                                    purchaseProducts[i].getDmg().getText(),
                                    purchaseProducts[i].getFree().getText(),
                                    purchaseProducts[i].getCustSize().getText());
                                    break;
                                case "Pending":
                                    tf=data.insert_purchase_products_in_table(conn,
                                    codeInt+"",
                                    purchaseProducts[i].getSeqNoText(),
                                    purchaseProducts[i].getSeekText(),
                                    purchaseProducts[i].getTotalQtyText(),
                                    purchaseProducts[i].getRateText(),
                                    purchaseProducts[i].getGrossAmtText(),
                                    purchaseProducts[i].getDiscPerText(),
                                    purchaseProducts[i].getDiscRsText(),
                                    purchaseProducts[i].getTaxPerText(),
                                    purchaseProducts[i].getTaxRsText(),
                                    purchaseProducts[i].getNetAmtText(),
                                    "0.0",
                                    "0.0",
                                    purchaseProducts[i].getTotalQty().getText(),
                                    purchaseProducts[i].getDmg().getText(),
                                    purchaseProducts[i].getFree().getText(),
                                    purchaseProducts[i].getCustSize().getText());
                                    break;
                                case "Canceled":
                                    tf=data.insert_purchase_products_in_table(conn,
                                    codeInt+"",
                                    purchaseProducts[i].getSeqNoText(),
                                    purchaseProducts[i].getSeekText(),
                                    purchaseProducts[i].getTotalQtyText(),
                                    purchaseProducts[i].getRateText(),
                                    purchaseProducts[i].getGrossAmtText(),
                                    purchaseProducts[i].getDiscPerText(),
                                    purchaseProducts[i].getDiscRsText(),
                                    purchaseProducts[i].getTaxPerText(),
                                    purchaseProducts[i].getTaxRsText(),
                                    purchaseProducts[i].getNetAmtText(),
                                    purchaseProducts[i].getTotalQty().getText(),
                                    "0.0",
                                    "0.0",
                                    purchaseProducts[i].getDmg().getText(),
                                    purchaseProducts[i].getFree().getText(),
                                    purchaseProducts[i].getCustSize().getText());
                                    break;
                             }
                            System.out.println("insert_purchase_products_in_table : "+tf);
                            String a = purchaseProducts[i].getSeekText();
                            String b = purchaseProducts[i].getTotalQtyText();
                            /*
                            if(status.equals("D")){
                                String c = data.get_clqty_wrt_pmast_code(conn, a);
                                BigDecimal d = new BigDecimal("0.0");
                                if (c != null) {
                                    d = new BigDecimal(Float.parseFloat(c)).subtract(new BigDecimal(Float.parseFloat(b)));
                                }
                               data.update_clqty_in_pmast(conn, d + "", a);
                            }
                                */
                        }
                    }
//                tf=insert_purchase_products_in_table(conn,docno,seqno,pcode,perqty,perrate,grossamount,discper,discrs,taxper,taxrs,netamount);
                if(tf){
                    invNo.setText(String.valueOf(codeInt));
                    invNo.setEditable(false);
                    forBackBtnEnable(true);
                    recEditBtnEnable(true);
                    recEditActionBtnVisible(false);
                    setLastInvoice();
                    textFieldsEditable(false);
                    editableProductPanel(false);
                    saveUpdateBtnVisible("all", false);
                    loadProductsPanel(invNo.getText());
                }
                ////System.out.println("Is Inserted :"+ tf);
                data.close_database(conn);
            } catch (SQLException ex) {
                Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
             try {
                //======================CUST legers==================
                PAK_CUSTLEG_DB data1 =new PAK_CUSTLEG_DB();
                Connection conn1;
                conn1 = data1.connect_database();
                    try {

                        data1.insert_cust_ledger(conn1,
                                custCode.getText(),
                                dateField.toDateString(oDate.getDate().toString()),
        "Order From "+suppName.getSelectedItem()+" Ref # "+refNo.getText()+" Remarks: "+remarks.getText(),
                                paid.getText(),
                                netpayable.getText(),
                                codeInt+"");

                    } catch (ParseException ex) {
                        Logger.getLogger(PURCHASE.class.getName()).log(Level.SEVERE, null, ex);
                    }
                data1.close_database(conn1);
                //======================CUST legers==================
            } catch (SQLException ex) {
                Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
        }else{
            JFrame j=new JFrame();
            j.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(j, "Enter Customer Code And Others \n OR Press Cancel to Contine  ", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
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
            updateComboBox(custCode, suppName,"supp");
        } catch (Exception ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_custCodeKeyReleased

    private void suppNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppNameActionPerformed
        //System.out.println("suppName.getSelectedItem().toString()"+suppName.getSelectedItem().toString());
        custCode.setText(getCode(suppName.getSelectedItem().toString(),"supp"));
    }//GEN-LAST:event_suppNameActionPerformed

    private void suppNamePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_suppNamePopupMenuWillBecomeVisible
        PAK_ORDER_DB data =new PAK_ORDER_DB();
        Connection conn;
        try {
            conn = data.connect_database();        
            suppName.setModel(buildAllComboBoxModel("supp"));
            if(setSelectedComboItem(custCode,suppName,((!custCode.getText().isEmpty())?data.find_supp_name_by_code(conn, custCode.getText()):""))){
                
            }else{
                custCode.setText(getCode(suppName.getSelectedItem().toString(),"supp"));
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
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
        PAK_ORDER_DB data =new PAK_ORDER_DB();
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
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
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
try {
            
        String s= "D:\\MPROREP\\Orderinv.jasper";
        
        Map parametersMap = new HashMap();
        
            parametersMap.put("userdocno",Integer.parseInt(invNo.getText()));
            
        JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, parametersMap, connAA);
          JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);
                    
                    
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_print2ActionPerformed

    private void btnAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRowActionPerformed
        addRow();
        //System.out.println("At ADD ROW Max PC:"+productCount);
    }//GEN-LAST:event_btnAddRowActionPerformed

    private void refNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refNoActionPerformed
    ButtonModel b;//=buttonGroup.getSelection();
    private void radioCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCancelActionPerformed
            PAK_ORDER_DB data =new PAK_ORDER_DB();
            Connection conn;
            try {
                conn = data.connect_database();
                if(data.check_delivered_presence(conn,invNo.getText())){
                    buttonGroup.setSelected(radioCancel.getModel(), true);
                }else{
                    JFrame j2=new JFrame();
                    j2.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j2, "You can not change status", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                    buttonGroup.setSelected(radioCancel.getModel(), false);
                    buttonGroup.setSelected(b,true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_radioCancelActionPerformed

    private void radioCancelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioCancelStateChanged
        
    }//GEN-LAST:event_radioCancelStateChanged

    private void radioCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioCancelMouseClicked
  
    }//GEN-LAST:event_radioCancelMouseClicked

    private void radioPendingStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioPendingStateChanged
        
    }//GEN-LAST:event_radioPendingStateChanged

    private void radioPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPendingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioPendingActionPerformed

    private void radioPendingPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_radioPendingPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_radioPendingPropertyChange

    private void radioCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioCancelMouseEntered
        b=buttonGroup.getSelection();
    }//GEN-LAST:event_radioCancelMouseEntered

    private void radioCancelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radioCancelFocusGained
        
    }//GEN-LAST:event_radioCancelFocusGained

    private void radioDeliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDeliveredActionPerformed
        PAK_ORDER_DB data =new PAK_ORDER_DB();
            Connection conn;
            try {
                conn = data.connect_database();
                if(invNo.getText().equals("")||invNo.getText()==null){
                    buttonGroup.setSelected(radioDelivered.getModel(), false);
                    buttonGroup.setSelected(b,true);
                }else{
                    JFrame j2=new JFrame();
                    j2.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j2, "If you want to change status as delivered.....! \n then go to sales invoice and generate new Invoice.  \n ", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                    buttonGroup.setSelected(radioDelivered.getModel(), false);
                    buttonGroup.setSelected(b,true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_radioDeliveredActionPerformed

    private void radioDeliveredMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioDeliveredMouseEntered
                                                 
        b=buttonGroup.getSelection();
    }//GEN-LAST:event_radioDeliveredMouseEntered

    private void btnclientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclientsMouseClicked
           try {
            DynamicERP.dialoge.newdataentry.dialogeClass.createCustRecWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnclientsMouseClicked

    private void btnclientsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclientsMouseEntered
        btnclients.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    }//GEN-LAST:event_btnclientsMouseEntered

    private void btnclientsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclientsMouseExited
        btnclients.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
    }//GEN-LAST:event_btnclientsMouseExited

    private void btnclients1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclients1MouseClicked
    this.dispose();
            SALES a = new SALES();
            a.setVisible(true);

    }//GEN-LAST:event_btnclients1MouseClicked

    private void btnclients1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclients1MouseEntered
        btnclients1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    }//GEN-LAST:event_btnclients1MouseEntered

    private void btnclients1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclients1MouseExited
        btnclients1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
    }//GEN-LAST:event_btnclients1MouseExited

    private void custCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_custCodeKeyPressed
                if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try 
            {
                dialogeClass.createViewCustRecWin();
            } catch (SQLException ex) {
                Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(DynamicERP.dialoge.viewforms.ViewForm11.isSaved){
                custCode.setText(dialogeClass.codeCustRec);
            }else{
            }
        }
        try {
            updateComboBox(custCode, suppName,"supp");
        } catch (Exception ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_custCodeKeyPressed

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
            java.util.logging.Logger.getLogger(SALESORDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SALESORDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SALESORDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SALESORDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new SALESORDER().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Builty1;
    private javax.swing.JLabel Builty11;
    private javax.swing.JLabel Builty12;
    private javax.swing.JLabel Builty15;
    private javax.swing.JLabel Builty17;
    private javax.swing.JLabel Builty18;
    private javax.swing.JLabel Builty19;
    private javax.swing.JLabel Builty2;
    private javax.swing.JLabel Builty20;
    private javax.swing.JLabel Builty21;
    private javax.swing.JLabel Builty3;
    private javax.swing.JLabel Builty4;
    private javax.swing.JLabel Builty8;
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
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel btnclients;
    private javax.swing.JLabel btnclients1;
    private javax.swing.JButton btnexit;
    private javax.swing.JTextField custCode;
    private javax.swing.JTable custHistory;
    private javax.swing.JComboBox dName;
    private javax.swing.JTextField dcode;
    private javax.swing.JTextField discount;
    private com.toedter.calendar.JDateChooser dlDate;
    private javax.swing.JTextField grossAmt;
    private javax.swing.JCheckBox histogram;
    private javax.swing.JTextField invNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpanspl;
    private javax.swing.JLabel link9;
    private javax.swing.JTextField linvNo;
    private javax.swing.JTextField netAmt;
    private javax.swing.JTextField netpayable;
    private com.toedter.calendar.JDateChooser oDate;
    private javax.swing.JTextField otherExp;
    private javax.swing.JTextField paid;
    private javax.swing.JPanel pan_history;
    private javax.swing.JPanel panel;
    private javax.swing.JButton print2;
    private javax.swing.JScrollPane purchaseScrollPane;
    private javax.swing.JRadioButton radioCancel;
    private javax.swing.JRadioButton radioDelivered;
    private javax.swing.JRadioButton radioPending;
    private javax.swing.JTextField refNo;
    private javax.swing.JTextField remaining;
    private javax.swing.JTextField remarks;
    private javax.swing.JPanel splPanel;
    private javax.swing.JTextField splPer;
    private javax.swing.JTextField splRs;
    private javax.swing.JPanel sumPanel;
    private javax.swing.JComboBox suppName;
    private javax.swing.JTextField taxPer;
    private javax.swing.JTextField taxRs;
    // End of variables declaration//GEN-END:variables
    // Start of variables declaration                   
    protected ButtonGroup buttonGroup;
    // End of variables declaration                   

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
    private static PakSalesOrderFieldPanel[] purchaseProducts = new PakSalesOrderFieldPanel[500];
    private static SaleOrderHeaderPanel purchaseHeaderPanel= new SaleOrderHeaderPanel();
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
        /*
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 23; j++){
                row[i][j]=""+k++;
            }
        }
                
        */
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
int i;
    private void addRow() {
        productCount++;
        purchaseProducts[productCount]=new PakSalesOrderFieldPanel();
        purchaseProducts[productCount].setName(productCount+"");
        purchaseProducts[productCount].setSeqNoText(productCount+"");
        for (i = 0; i < 22; i++) {
            switch(i)
            {
                case 1:case 3:case 4: case 6:case 5:case 7:case 8:case 9:case 10:case 11:case 13:case 12:case 14://case 15:case 16:case 17:case 18:case 19:case 20:
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
        purchaseProducts[productCount].getTotalQty().addKeyListener(new KeyAdapter(){
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
        purchaseProducts[productCount].getSeek().addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e) {/*System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());*/                    JTextField t= (JTextField) e.getSource();
               
//                System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());
                updateSumSplPanel();
                setBalQty(e);if(histogram.isSelected()){
                String col[]={"Inv No","Date","Qty","Rate","Disc %"};
                updateTableView(col,purchaseProducts[Integer.parseInt(t.getParent().getName())].getSeek().getText());
                }
            }
        });
        purchaseProducts[productCount].getSeek().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent ce) { /*System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());*/                    JTextField t = (JTextField) ce.getSource();
                if(t.getText()!=null){
                if(histogram.isSelected()){
                String col[]={"Inv No","Date","Qty","Rate","Disc %"};
                updateTableView(col,purchaseProducts[Integer.parseInt(t.getParent().getName())].getSeek().getText());
                }
                }
            }
        });

        purchaseProducts[productCount].getpName().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {                                                                               /*System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());System.out.print("T:"+purchaseProducts[productCount].getGrossAmt().getText());*/                    JComboBox t= (JComboBox) ae.getSource();
                updateSumSplPanel();
                if(histogram.isSelected()){
                String col[]={"Inv No","Date","Qty","Rate","Disc %"};
                updateTableView(col,purchaseProducts[Integer.parseInt(t.getParent().getName())].getSeek().getText());
                }
            }
        });


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
        purchaseProducts[productCount].getjLabel2().addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JLabel label = (JLabel)e.getSource();
                if(label.isEnabled()){
                    PAK_ORDER_DB data =new PAK_ORDER_DB();
                    Connection conn;
                    try {
                        conn = data.connect_database();
                        if(!invNo.getText().equalsIgnoreCase("")){
                            if(data.check_one_delivered_wrt_seqNo(conn,invNo.getText(),purchaseProducts[Integer.parseInt(label.getParent().getName())].getSeqNoText())){
                                if(JOptionPane.showConfirmDialog(j,
                                "Are you sure ! \nOn selecting \"Yes\" this will Delete the Row...\n\n Deleted Row can not be restored  . . .", "Confermation Diloge",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ //ConfermationDiloge()){
                                    btnCancel.setVisible(false);
                                    btnexit.setVisible(false);
                                    removeRow(Integer.parseInt(label.getParent().getName()));
                                    deletePurchaseProduct(invNo.getText(), label.getParent().getName(), purchaseProducts[Integer.parseInt(label.getParent().getName())].getTotalQtyText(), purchaseProducts[Integer.parseInt(label.getParent().getName())].getSeekText(),purchaseProducts[Integer.parseInt(label.getParent().getName())].getSeqNoText());
                                    updateSumSplPanel();
                                }
                            }else{
                                JFrame j2=new JFrame();
                                j2.setAlwaysOnTop(true);
                                JOptionPane.showMessageDialog(j2, "You can not Delete this Item", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                             if(JOptionPane.showConfirmDialog(j,
                                "Are you sure ! \nOn selecting \"Yes\" this will Delete the Row...\n\n Deleted Row can not be restored  . . .", "Confermation Diloge",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                                    removeRow(Integer.parseInt(label.getParent().getName()));
                             }
                        }
                    }catch(SQLException ex){
                    }
                }
            }
        });
        initializePanelListner(purchaseProducts[productCount]);
        purchasePanel.add(purchaseProducts[productCount]);
    }
    private void setBalQty(KeyEvent e) {
//        try {
//            PAK_DB data =new PAK_DB();
//            Connection conn;
//            conn = data.connect_database();
//            ArrayList<String> temp;
//            JTextField f = (JTextField) e.getSource();
//            if(!f.getText().equals("")){
//                temp=data.find_product_rec_by_code(conn, f.getText());
//                if(temp!=null){
//                    for(int i=0;i<temp.size();i++){
//                        if(i==9){//||i==6||i==10){
//                            balQty.setText(temp.get(i));
//                        }
//                    }
//                }
//            }
//            data.close_database(conn);
//        } catch (SQLException ex) {
//            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    private void setBalQty(ActionEvent e) {
//        try {
//            PAK_DB data =new PAK_DB();
//            Connection conn;
//            conn = data.connect_database();
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
//                String s12 =data.find_product_code_by_name(conn, item);
//                if(s12!=null){
//                    temp=data.find_product_rec_by_code(conn, s12);
//                    if(temp!=null){
//                        for(int i=0;i<temp.size();i++){
//                            if(i==9){//||i==6||i==10){
//                                balQty.setText(temp.get(i));
//                            }
//                        }
//                    }
//                }
//            }
//            data.close_database(conn);
//        } catch (SQLException ex) {
//            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    private String getSubName(String p) {
        String s=p.substring(0, p.indexOf("|")-1);  
        return s;
    }
    private void setBalQty(PopupMenuEvent e) {
        try {
            PAK_DB data =new PAK_DB();
            Connection conn;
            conn = data.connect_database();
            ArrayList<String> temp;
            JComboBox f = (JComboBox) e.getSource();
            System.out.println("");
            System.out.println("****************");
            System.out.println("PopupMenuEvent"+f.getSelectedItem());
            System.out.println("****************");
//            if(!f.getSelectedItem().equals("")){
//                temp=data.find_product_rec_by_code(conn, f.getSelectedItem());
//                if(temp!=null){
//                    for(int i=0;i<temp.size();i++){
//                        if(i==9){//||i==6||i==10){
//                            balQty.setText(temp.get(i));
//                        }
//                    }
//                }
//            }
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void addRow(int tempProductCount) {
        productCount=tempProductCount;
        addRow();
    }
    /*
    private void addNextRow() {
        
        PAK_ORDER_DB data =new PAK_ORDER_DB();
        Connection conn;
        try {
            conn = data.connect_database();
                
                //System.out.println("productCount <Before>"+productCount);
                int max=data.find_max_in_purchase_products(conn, invNo.getText());
                int pCount=productCount;
                //System.out.println("max -> "+max+" : pCount->"+pCount);
                int index=0;
                if(max > pCount){
                    productCount=max;
                }else{
                    productCount=pCount;
                }
                index++;
                productCount++;
                //System.out.println("productCount <After>"+productCount);
                purchaseProducts[productCount]=new PakSalesOrderFieldPanel();
                purchaseProducts[productCount].setName(productCount+"");
                purchaseProducts[productCount].setSeqNoText(productCount+"");
                purchaseProducts[productCount].getjLabel2().addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e) {
                        JLabel label = (JLabel)e.getSource();
                        removeRow(Integer.parseInt(label.getParent().getName()));
                        deletePurchaseProduct(invNo.getText(),label.getParent().getName());
                    }
                });
                initializePanelListner(purchaseProducts[productCount]);
                purchasePanel.add(purchaseProducts[productCount]);
                
//                productCount=data.find_count_in_purchase_products(conn, invNo.getText());
            
             data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    private void deletePurchaseProduct(String s,String s1,String s2,String s3,String s4) {
        /*
        invNo.getText(),=S
    label.getParent().getName(),
    purchaseProducts[Integer.parseInt(label.getParent().getName())].getTotalQtyText()
    , purchaseProducts[Integer.parseInt(label.getParent().getName())].getSeekText()
    ,purchaseProducts[Integer.parseInt(label.getParent().getName())].getSeqNoText()
    
    */
        PAK_ORDER_DB data =new PAK_ORDER_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            if(data.check_product_line_item_presence_new(conn,s,s4,productCount)){
                String a = s3;
                String b = s2;
                String b1 = s;
                /*
                String c = data.get_clqty_wrt_pmast_code(conn, a);
                BigDecimal d = new BigDecimal("0.0");
                if (c != null) {
                    d = new BigDecimal(Float.parseFloat(c)).add(new BigDecimal(Float.parseFloat(b)));
                }
                System.out.println("Seek" + s1);
                System.out.println("Code" + b1);
                System.out.println("CLQTY" + d);
                System.out.println("TQTY" + b);
                System.out.println("CLQTY" + c);
                boolean bool = data.update_clqty_in_pmast(conn, d + "", a);
                */
                data.delete_purchase_product(conn, s, s1);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
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
        btnAddRow.setVisible(visibleProperty);
        
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
        oDate.setEnabled(b);
        dlDate.setEnabled(b);
        refNo.setEditable(b);
        custCode.setEditable(b);
        suppName.setEnabled(b);
        remarks.setEnabled(b);
        splPer.setEditable(b);
        splRs.setEditable(b);
        otherExp.setEditable(b);
        paid.setEditable(b);
        dcode.setEditable(b);
        dName.setEnabled(b);
        radioCancel.setEnabled(b);
        radioDelivered.setEnabled(b);
        radioPending.setEnabled(b);
        textFieldsNotEditable(false);
        editableProductPanel(b); 
        
    }

    private void setNullTextFields() {
        invNo.setText("");
        oDate.setDate(null);
        dlDate.setDate(null);
        refNo.setText("");
        custCode.setText("");
        try {
            buildOneComboBoxModel("", "supp");//suppName.setText("");
        } catch (Exception ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
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
        splRs.setText("0.00");
        otherExp.setText("0.00");
        paid.setText("0.00");
        netpayable.setText("0.00");
       buttonGroup.setSelected(radioPending.getModel(), true);
        dcode.setText("");
        try {
            buildOneComboBoxModel("", "sm");//suppName.setText("");
        } catch (Exception ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
        inetializePrductPanel();
    }

    private void updateComboBox(JTextField textField,JComboBox comboBox,String c) throws Exception {
        comboBox.setModel(buildOneComboBoxModel(textField.getText(),c));
    }
    public static DefaultComboBoxModel buildAllComboBoxModel(String c) throws Exception {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        PAK_ORDER_DB data =new PAK_ORDER_DB();
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
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comboBoxModel;
    }
    public DefaultComboBoxModel buildOneComboBoxModel(String name,String c) throws Exception {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        PAK_ORDER_DB data =new PAK_ORDER_DB();
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
                }
            comboBoxModel.addElement(s);
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comboBoxModel;
    }

    private String getCode(String name,String c) {
        String s="";
        PAK_ORDER_DB data =new PAK_ORDER_DB();
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
                }  
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    private void setFirstRec() throws ParseException {
        PAK_ORDER_DB data =new PAK_ORDER_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            ArrayList<String> stock= data.get_first_purchase(conn);
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
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setTextinPurchase(ArrayList<String> stock, Conversions dateField) {
        try {
            oDate.setDate(dateField.toDate(stock.get(0)));
            invNo.setText(stock.get(1));
            loadProductsPanel(invNo.getText());
            refNo.setText(stock.get(2));
            custCode.setText(stock.get(3));
            try {
                suppName.setModel(buildOneComboBoxModel(custCode.getText(),"supp"));
            } catch (Exception ex) {
                Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
            }
            grossAmt.setText(stock.get(4));
            splPer.setText(stock.get(5));
            splRs.setText(stock.get(6));
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
            switch (stock.get(18)) 
             {
                case "D":
                    buttonGroup.setSelected(radioDelivered.getModel(), true);
                    break;
                case "P":
                    buttonGroup.setSelected(radioPending.getModel(), true);
                    break;
                case "C":
                    buttonGroup.setSelected(radioCancel.getModel(), true);
                    break;
             }
           dlDate.setDate(dateField.toDate(stock.get(19)));
            try {
                dName.setModel(buildOneComboBoxModel(dcode.getText(),"sm"));
            } catch (Exception ex) {
                Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
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
        PAK_ORDER_DB data =new PAK_ORDER_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            ArrayList<String> stock = data.get_last_purchase(conn);
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
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setLastInvoice() {
        PAK_ORDER_DB data =new PAK_ORDER_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            int max=data.find_max_in_purchase_code(conn);
            if(max==0){
                linvNo.setText(null);
            }else{
                linvNo.setText(max+"");
            }
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
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
         PAK_ORDER_DB data5 =new PAK_ORDER_DB();
        Connection conn5;
        try {
            conn5=data5.connect_database();
            for(int i=1;i<=productCount;i++){
                //System.out.println("-> "+i+" : productCount->"+productCount);
                if(purchaseProducts[i]!=null&&purchaseProducts[i].isDisplayable()){
                    if(data5.check_one_delivered_wrt_seqNo(conn5,invNo.getText(),purchaseProducts[i].getSeqNoText())){
                        purchaseProducts[i].textFieldsEditableProducts(b);
                    }else{
                        purchaseProducts[i].textFieldsEditableProducts1(b);
                    }
                    
                }
            }
        conn5.close();
        }catch(Exception e){
            System.out.println("Exceptiojn"+e);
        }
    }

    private void loadProductsPanel(String text) {
        inetializePrductPanel();
        PAK_ORDER_DB data =new PAK_ORDER_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            ArrayList<String> name[]=data.search_products(conn,text);
            removeRow(productCount);
            productCount--;
            int lastSeqNo=0;
            for(int i=0;i<name.length;i++){
                //System.out.println("name["+i+"].get(1)"+name[i].get(1));
                addRow(Integer.parseInt(name[i].get(1))-1);
                for(int j=0;j<17;j++){
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
                            purchaseProducts[productCount].setTotalQty(name[i].get(j));
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
//                            purchaseProducts[productCount].getTotalSize().setText(name[i].get(j));
                            break;
                        case 12:
//                            purchaseProducts[productCount].getTotalSize().setText(name[i].get(j));
                            break;
                        case 13:
//                            purchaseProducts[productCount].getTotalSize().setText(name[i].get(j));
                            break;
                        case 14:
                            purchaseProducts[productCount].getCustSize().setText(name[i].get(j));
                            purchaseProducts[productCount].setAllFieldData();
                            break;
                        case 15:
                            purchaseProducts[productCount].getDmg().setText(name[i].get(j));
                            break;
                        case 16:
                            purchaseProducts[productCount].getFree().setText(name[i].get(j));
                            break;
                    }
                }
            }
            updateSumSplPanel();
            productCount=lastSeqNo;
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
        }
        editableProductPanel(false);
    }

    private void updateSumSplPanel() {
        String sumGrossAmt="";
        String sumTaxRs="";
        String sumDiscRs="";
        String sumNetAmt="";
        
        Float sumGrossAmt1=0.0f;
        Float sumTaxRs1=0.0f;
        Float sumDiscRs1=0.0f;
        Float sumNetAmt1=0.0f;
        
        BigDecimal sumGrossAmt2= new BigDecimal(0.0);
        BigDecimal sumTaxRs2=new BigDecimal(sumTaxRs1+"");
        BigDecimal sumDiscRs2=new BigDecimal(sumGrossAmt1+"");
        BigDecimal sumNetAmt2=new BigDecimal(sumNetAmt1+"");
        
        for(int i=1;i<=productCount;i++){
            if(purchaseProducts[i]!=null&&purchaseProducts[i].isDisplayable() ){
                //sumGrossAmt1=sumGrossAmt1+Float.parseFloat(purchaseProducts[i].getGrossAmtText());
                sumGrossAmt2=sumGrossAmt2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getGrossAmtText())));
                //sumTaxRs1=sumTaxRs1+Float.parseFloat(purchaseProducts[i].getTaxRsText());
                sumTaxRs2=sumTaxRs2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getTaxRsText())));
                //sumDiscRs1=sumDiscRs1+Float.parseFloat(purchaseProducts[i].getDiscRsText());
                sumDiscRs2=sumDiscRs2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getDiscRsText())));
                //sumNetAmt1=sumNetAmt1+Float.parseFloat(purchaseProducts[i].getNetAmtText());
                sumNetAmt2=sumNetAmt2.add(BigDecimal.valueOf(Float.parseFloat(purchaseProducts[i].getNetAmtText())));
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
        
        try{
//           netAmt.setText(round((Float.parseFloat(sumNetAmt)),2)+"");
           netAmt.setText(sumNetAmt);
           
//           grossAmt.setText(round((Float.parseFloat(sumGrossAmt)),2)+"");
           grossAmt.setText(sumGrossAmt);
           
//           taxRs.setText(round((Float.parseFloat(sumTaxRs)),2)+"");
           taxRs.setText(sumTaxRs);
           
//           discount.setText(round((Float.parseFloat(sumDiscRs)),2)+"");
           discount.setText(sumDiscRs);
           
//           taxPer.setText(round((Float.parseFloat(sumTaxRs)*100/Float.parseFloat(sumGrossAmt)),3)+"");
           BigDecimal temp = sumTaxRs2.multiply(BigDecimal.valueOf(Float.parseFloat("100.0")));
           BigDecimal result=new BigDecimal("0.0");
           if(!(sumGrossAmt2.compareTo(BigDecimal.ZERO) == 0)){
               result = temp.divide(sumGrossAmt2,3,BigDecimal.ROUND_HALF_UP);
           }
           taxPer.setText(round((result),3)+"");
           
           
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
           //splPer.setText(round((Float.parseFloat(splRs.getText())*100)/Float.parseFloat(netAmt.getText()),3)+"");
           BigDecimal splRsBD = BigDecimal.valueOf(Float.parseFloat(splRs.getText()));
            BigDecimal netAmtBD = BigDecimal.valueOf(Float.parseFloat(netAmt.getText()));
            BigDecimal temp1 = splRsBD.multiply(new BigDecimal("100.0"));
            BigDecimal result1 = temp1.divide(netAmtBD,3,BigDecimal.ROUND_HALF_UP);
            splPer.setText(round((result1),3)+"");
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

    private void frmNetPayable() {
        try{
//           netpayable.setText(round((Float.parseFloat(netAmt.getText())-Float.parseFloat(splRs.getText()))+Float.parseFloat(otherExp.getText()),3)+"");
            BigDecimal splRsBD = BigDecimal.valueOf(Float.parseFloat(splRs.getText()));
            BigDecimal netAmtBD = BigDecimal.valueOf(Float.parseFloat(netAmt.getText()));
            BigDecimal otherExpBD = BigDecimal.valueOf(Float.parseFloat(otherExp.getText()));
            BigDecimal temp1 = netAmtBD.subtract(splRsBD);
            BigDecimal result1 = temp1.add(otherExpBD);
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
        PAK_ORDER_DB data =new PAK_ORDER_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            ArrayList<String> s=data.find_purchase_by_code(conn, text);
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
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
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


    private void delete() {
        JFrame j=new JFrame();
        j.setAlwaysOnTop(true);
        if(JOptionPane.showConfirmDialog(j,
        "Are you sure ! \nOn selecting \"Yes\" this will Delete the tasks?", "Confermation Diloge",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ //ConfermationDiloge()){
            PAK_ORDER_DB data =new PAK_ORDER_DB();
            PAK_RECOVERY_DB data1 =new PAK_RECOVERY_DB();
            Connection conn;
            try {
                conn = data.connect_database();
                /*
                //============================CLIENTS CLBAL===================================
                String purchaseProduct = data.get_clbal_from_clints(conn,custCode.getText());
                if(purchaseProduct!=null){
                    BigDecimal b=null;
                    b = new BigDecimal(purchaseProduct).add(new BigDecimal(remaining.getText()));
                    if(b!=null){
                        data.update_clbal_in_clints(conn,b+"",custCode.getText());
                    }
                }
                //========================================================================= 
                */
                boolean tf=false;
                if(invNo.getText()==null){
                }else{
                    for(int i=1;i<productCount;i++){
                        if(purchaseProducts[i] != null && purchaseProducts[i].isDisplayable()&& purchaseProducts[i].getSeekText()!=null){
                            String a = purchaseProducts[i].getSeekText();
                            String b = purchaseProducts[i].getTotalQtyText();
                            /*
                            String c = data.get_clqty_wrt_pmast_code(conn, a);
                            BigDecimal d = new BigDecimal("0.0");
                            if (c != null) {
                                d = new BigDecimal(Float.parseFloat(c)).add(new BigDecimal(Float.parseFloat(b)));
                            }
                            boolean bool = data.update_clqty_in_pmast(conn, d + "", a);
                            */
                        }
                    }
                    System.out.println("SMAIN DELL"+data.delete_purchase(conn,invNo.getText()));
                    System.out.println("SDTL DELL"+data.delete_purchase_products_in_purchase(conn,invNo.getText()));
                    System.out.println("RMAIN DELL"+data1.delete_purchase(conn,invNo.getText()));
                    System.out.println("RDTL DELL"+data1.delete_purchase_products_in_purchase(conn,invNo.getText()));
                    /*
                    //======================sellers legers==================

                        PAK_CUSTLEG_DB data4 = new PAK_CUSTLEG_DB();
                        Connection conn1;
                        conn1 = data4.connect_database();
                        String s="Order From "+suppName.getSelectedItem()+" Ref # "+refNo.getText()+" Remarks: "+remarks.getText();
                    
                        tf=data4.delete_all_custleg(conn, invNo.getText());

                        data4.close_database(conn1);

                    //======================sellers legers==================
                    */
                        setNullTextFields();
                    setLastRec();
                    setLastInvoice();
                }
                data.close_database(conn);
            } catch (SQLException ex) {
                Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (ParseException ex) {
                Logger.getLogger(SALESORDER.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{

        }
    }

    
    private void updateTableView(String c[],String s) {
        String r[][]=null;//searchLike(searchField.getText());
/*DOCNO,SALEQTY,SALERATE,DISCPER,TOTALSIZE,RETURNQTY,
        */
        PAK_ORDER_DB data =new PAK_ORDER_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            boolean tf=false;
            r=data.search_history(conn, s,custCode.getText());
            System.out.println("Is Inserted :"+ tf);
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(r==null){
            JOptionPane.showMessageDialog(null, "No Row Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }else{
            initTable(c,r);   
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
            if(gci(j)!=14){
                JTextField j1=(JTextField) j.getParent().getComponent(gci(j)+1); j1.requestFocus();j1.selectAll();
            }else{
                perkdf(e);
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