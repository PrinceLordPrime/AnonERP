/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.frames.mainpkg;


import DB.PAK_DB;
import DB.PAK_GLOBAL_DB;
import DynamicERP.REPORTPARAMETER.STOCKREPCOMPCAT;
import java.awt.Color;
import DynamicERP.frames.newdataentry.FIRMREC;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.tree.TreePath;
import DynamicERP.frames.ledgers.CUSTOMERLEDGER;
import DynamicERP.frames.purchase.PURCHASE;
import DynamicERP.frames.sales.SALES;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import DynamicERP.dialoge.newdataentry.dialogeClass;
import static DynamicERP.dialoge.viewforms.dialogeClass.createJasperView;
import DynamicERP.frames.IssueRtn.ISSUERTN;
import DynamicERP.frames.instRtn.INSTRTN;
import DynamicERP.frames.issueSales.ISSALES;
import DynamicERP.frames.ledgers.FINANCELEDGER;
import DynamicERP.frames.ledgers.SELLERSLEDGER;
import DynamicERP.frames.quotation.QUOTATION;
import DynamicERP.frames.recordUpdates.INVOICESETTINGS;
import DynamicERP.frames.recordUpdates.PROREC;
import DynamicERP.frames.recordUpdates.ROUTERECOVERY;
import DynamicERP.frames.salesOrder.SALESORDER;
import DynamicERP.frames.salesRtn.SALESRTN;
import DynamicERP.frames.satelment.SATELMET;
import DynamicERP.frames.schProCat.SCHEMEPROCAT;
import DynamicERP.frames.schProCatPro.SCHPROCATPRO;
import DynamicERP.frames.schProSubCat.SCHEMEPROSUBCAT;
import DynamicERP.frames.schProSubCatPro.SCHPROSBCATPRO;
import DynamicERP.frames.schems.SCHEMERS;
import DynamicERP.frames.schemsQty.SCHEMEQTY;
import DynamicERP.frames.schemsQtyPro.SCHQTYPRO;
import DynamicERP.frames.slab.SLABPER;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Shan
 */
public class MAIN extends javax.swing.JFrame {
    /**
     * Creates new form MAIN
     */
    private MAIN() {
    
    }
    private static MAIN instance = null;
    public static MAIN getInstance(){
        if(instance!=null){
            return instance;
        }else{
            instance=new MAIN("string");
        }
        return instance;
    }
    PAK_GLOBAL_DB dataAA =new PAK_GLOBAL_DB();
    Connection connAA;
    public MAIN(String s) {
        initComponents();
          setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("clean.png")));
          
          maximize();
          
          
        //-------------------text bottom of image---------------
            ico_product.setHorizontalTextPosition(JLabel.CENTER);
            ico_product.setVerticalTextPosition(JLabel.BOTTOM);
            ico_purinv.setHorizontalTextPosition(JLabel.CENTER);
            ico_purinv.setVerticalTextPosition(JLabel.BOTTOM);
            ico_salesinv.setHorizontalTextPosition(JLabel.CENTER);
            ico_salesinv.setVerticalTextPosition(JLabel.BOTTOM);
        //-------------------text bottom of image---------------
            
            
            try {
                connAA = dataAA.connect_database();
            
            }catch (SQLException e) {
                System.out.println("Exception ===> "+e);
            }    
        PAK_DB data =new PAK_DB();
        Connection conn;
        try {
            conn = data.connect_database();
            ArrayList<String> stock = data.get_first_dsp(conn);
            if(stock!=null){
                //CODE,NAME,ADD1,ADD2,CONTACT,NTN
                tfclient.setText(stock.get(1));
                add1.setText(stock.get(2));
                add2.setText(stock.get(3));
                cell.setText(stock.get(4));
                ntn.setText(stock.get(5));
            }else{
                
                JFrame j=new JFrame();
                    j.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(j, "No data Found", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Empty DB");
            }
            data.close_database(conn);
        } catch (SQLException ex) {
            Logger.getLogger(FIRMREC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        imgreal.setBorder(BorderFactory.createTitledBorder(""));
        imghome.setBorder(BorderFactory.createTitledBorder(""));
        tfclient.setBorder(BorderFactory.createTitledBorder(""));
        jpanfooter.setBorder(BorderFactory.createTitledBorder(""));
        jPanel1.setBorder(BorderFactory.createTitledBorder("Your Info:"));
        tftooltip.setBorder(BorderFactory.createTitledBorder("Mini Tutor..."));
        pan_menu.setBorder(BorderFactory.createTitledBorder(""));
        
        
        MouseListener ml = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            int selRow = DMS_PAN.getRowForLocation(e.getX(), e.getY());
            TreePath selPath = DMS_PAN.getPathForLocation(e.getX(), e.getY());
            if(selRow != -1) {
                if(e.getClickCount() == 1) {

                }
                else if(e.getClickCount() == 2) {
                    System.out.println("doubleclick");
                }
            }
        }
    };
    DMS_PAN.addMouseListener(ml);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator25 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator37 = new javax.swing.JSeparator();
        jSeparator38 = new javax.swing.JSeparator();
        jSeparator42 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DMS_PAN = new javax.swing.JTree();
        btnexit = new javax.swing.JButton();
        pan_menu = new javax.swing.JPanel();
        DSPLOGO = new javax.swing.JLabel();
        ico_purinv = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        btnclients = new javax.swing.JLabel();
        ico_salesinv = new javax.swing.JLabel();
        btncustbalance = new javax.swing.JLabel();
        btncustomerledger = new javax.swing.JLabel();
        btnrecoveries = new javax.swing.JLabel();
        btnfinanceledger = new javax.swing.JLabel();
        ico_product = new javax.swing.JLabel();
        btnexp = new javax.swing.JLabel();
        btnvoccreation = new javax.swing.JLabel();
        btnemploye = new javax.swing.JLabel();
        btnfinanceledger1 = new javax.swing.JLabel();
        btnvoccreation1 = new javax.swing.JLabel();
        btnexp1 = new javax.swing.JLabel();
        btnemploye1 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        tfclient = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        add1 = new javax.swing.JTextField();
        add2 = new javax.swing.JTextField();
        cell = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ntn = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dspwelcome = new javax.swing.JTextField();
        imghome = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tftooltip = new javax.swing.JTextArea();
        jpanfooter = new javax.swing.JPanel();
        link9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmpro = new javax.swing.JMenu();
        jmitemtype1 = new javax.swing.JMenuItem();
        jmitemtype = new javax.swing.JMenuItem();
        jmitemtype2 = new javax.swing.JMenuItem();
        jmitemtype3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        imitemproducts = new javax.swing.JMenuItem();
        imitemproducts1 = new javax.swing.JMenuItem();
        jSeparator27 = new javax.swing.JPopupMenu.Separator();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        jmitemtype5 = new javax.swing.JMenuItem();
        jmitemtype4 = new javax.swing.JMenuItem();
        jmitemtype6 = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        jmitemtype7 = new javax.swing.JMenuItem();
        jmitemtype8 = new javax.swing.JMenuItem();
        jSeparator54 = new javax.swing.JPopupMenu.Separator();
        subcatcheme = new javax.swing.JMenuItem();
        jmitemtype17 = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        jmitemtype9 = new javax.swing.JMenuItem();
        jSeparator30 = new javax.swing.JPopupMenu.Separator();
        jSeparator29 = new javax.swing.JPopupMenu.Separator();
        jSeparator28 = new javax.swing.JPopupMenu.Separator();
        jmitemtype10 = new javax.swing.JMenuItem();
        jmitempur = new javax.swing.JMenu();
        jmpurchase = new javax.swing.JMenuItem();
        jSeparator43 = new javax.swing.JPopupMenu.Separator();
        jmitemcusttype = new javax.swing.JMenuItem();
        jmiteminvoice = new javax.swing.JMenuItem();
        jSeparator57 = new javax.swing.JPopupMenu.Separator();
        jmitemcusttype1 = new javax.swing.JMenuItem();
        jSeparator56 = new javax.swing.JPopupMenu.Separator();
        jmiteminvoice1 = new javax.swing.JMenuItem();
        jSeparator32 = new javax.swing.JPopupMenu.Separator();
        jSeparator35 = new javax.swing.JPopupMenu.Separator();
        jSeparator36 = new javax.swing.JPopupMenu.Separator();
        jmiteminvoice7 = new javax.swing.JMenuItem();
        jmiteminvoice9 = new javax.swing.JMenuItem();
        jSeparator60 = new javax.swing.JPopupMenu.Separator();
        jmiteminvoice8 = new javax.swing.JMenuItem();
        jmiteminvoice10 = new javax.swing.JMenuItem();
        jSeparator55 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        jmitemtype22 = new javax.swing.JMenuItem();
        jmitemtype18 = new javax.swing.JMenuItem();
        jmitemtype19 = new javax.swing.JMenuItem();
        jmitemtype20 = new javax.swing.JMenuItem();
        jmitemtype21 = new javax.swing.JMenuItem();
        jSeparator66 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        jmitemtype12 = new javax.swing.JMenuItem();
        jmitemtype11 = new javax.swing.JMenuItem();
        jmitemtype13 = new javax.swing.JMenuItem();
        jmitemtype14 = new javax.swing.JMenuItem();
        jSeparator61 = new javax.swing.JPopupMenu.Separator();
        jmitemtype16 = new javax.swing.JMenuItem();
        jmitemtype15 = new javax.swing.JMenuItem();
        jSeparator62 = new javax.swing.JPopupMenu.Separator();
        jSeparator58 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jmitemtype23 = new javax.swing.JMenuItem();
        jSeparator59 = new javax.swing.JPopupMenu.Separator();
        jmitemtype26 = new javax.swing.JMenuItem();
        jmitemtype27 = new javax.swing.JMenuItem();
        jmitemtype24 = new javax.swing.JMenuItem();
        jSeparator63 = new javax.swing.JPopupMenu.Separator();
        jmitemtype25 = new javax.swing.JMenuItem();
        jmitemtype28 = new javax.swing.JMenuItem();
        jSeparator64 = new javax.swing.JPopupMenu.Separator();
        jmitemtype29 = new javax.swing.JMenuItem();
        jSeparator65 = new javax.swing.JPopupMenu.Separator();
        jmreprots1 = new javax.swing.JMenu();
        jmitemcustrec = new javax.swing.JMenuItem();
        jmiteminvoice4 = new javax.swing.JMenuItem();
        jmiteminvoice3 = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jSeparator22 = new javax.swing.JPopupMenu.Separator();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem40 = new javax.swing.JMenuItem();
        jSeparator45 = new javax.swing.JPopupMenu.Separator();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        jSeparator31 = new javax.swing.JPopupMenu.Separator();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenuItem42 = new javax.swing.JMenuItem();
        jmroute = new javax.swing.JMenu();
        jmitememployee4 = new javax.swing.JMenuItem();
        jmitememployee6 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmitemcusttype2 = new javax.swing.JMenuItem();
        jmitemcusttype4 = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jmitemcusttype3 = new javax.swing.JMenuItem();
        jmitemcustrec2 = new javax.swing.JMenuItem();
        jSeparator26 = new javax.swing.JPopupMenu.Separator();
        jSeparator24 = new javax.swing.JPopupMenu.Separator();
        jSeparator33 = new javax.swing.JPopupMenu.Separator();
        jmitemcustlist = new javax.swing.JMenuItem();
        jmitemcustbal = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        jmitemcustledger = new javax.swing.JMenuItem();
        jmclients1 = new javax.swing.JMenu();
        jmitemcustrec3 = new javax.swing.JMenuItem();
        jSeparator48 = new javax.swing.JPopupMenu.Separator();
        jSeparator47 = new javax.swing.JPopupMenu.Separator();
        jSeparator34 = new javax.swing.JPopupMenu.Separator();
        jmitemcustlist1 = new javax.swing.JMenuItem();
        jmitemcustbal1 = new javax.swing.JMenuItem();
        jmitemcustbal2 = new javax.swing.JMenuItem();
        jmitemcustbal3 = new javax.swing.JMenuItem();
        jmitemcustbal4 = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jmitemcustledger2 = new javax.swing.JMenuItem();
        jmhr = new javax.swing.JMenu();
        jmitempost = new javax.swing.JMenuItem();
        jmitememployee = new javax.swing.JMenuItem();
        jSeparator44 = new javax.swing.JPopupMenu.Separator();
        jmitemexpcode = new javax.swing.JMenuItem();
        jmitemexprec = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jmitememployee1 = new javax.swing.JMenuItem();
        jmitememployee2 = new javax.swing.JMenuItem();
        jSeparator51 = new javax.swing.JPopupMenu.Separator();
        jSeparator52 = new javax.swing.JPopupMenu.Separator();
        jSeparator53 = new javax.swing.JPopupMenu.Separator();
        jmitememployee7 = new javax.swing.JMenuItem();
        jmitememployee8 = new javax.swing.JMenuItem();
        jmhr1 = new javax.swing.JMenu();
        jmitempost1 = new javax.swing.JMenuItem();
        jmitememployee3 = new javax.swing.JMenuItem();
        jSeparator46 = new javax.swing.JPopupMenu.Separator();
        jmitemexprec1 = new javax.swing.JMenuItem();
        jmitemexpcode1 = new javax.swing.JMenuItem();
        jmitememployee9 = new javax.swing.JMenuItem();
        jSeparator50 = new javax.swing.JPopupMenu.Separator();
        jSeparator49 = new javax.swing.JPopupMenu.Separator();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jmitememployee5 = new javax.swing.JMenuItem();
        jmfinance = new javax.swing.JMenu();
        jmitembalancesheet = new javax.swing.JMenuItem();
        jSeparator40 = new javax.swing.JPopupMenu.Separator();
        jmitemrecoveries = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jmitemfinac = new javax.swing.JMenuItem();
        jmitemvoc = new javax.swing.JMenuItem();
        jmitempaytoseller = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jmitemcomledger = new javax.swing.JMenuItem();
        jmitemcomledger1 = new javax.swing.JMenuItem();
        jmitemcustledger1 = new javax.swing.JMenuItem();
        jSeparator39 = new javax.swing.JPopupMenu.Separator();
        jmitempayac = new javax.swing.JMenuItem();
        jmitemrcable = new javax.swing.JMenuItem();
        jSeparator41 = new javax.swing.JPopupMenu.Separator();
        jmitemrcable1 = new javax.swing.JMenuItem();
        jmitempayac1 = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        jmitemfinac1 = new javax.swing.JMenuItem();
        jmexit = new javax.swing.JMenu();
        DSP_ADMIN = new javax.swing.JMenuItem();
        jmitemexit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Welcome to DynamicSP ERP");
        setMaximumSize(new java.awt.Dimension(1600, 1200));
        setMinimumSize(new java.awt.Dimension(1024, 660));
        setPreferredSize(new java.awt.Dimension(1024, 590));

        jPanel9.setBackground(new java.awt.Color(153, 204, 255));

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DMS_PAN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("DynamicSP ERP");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Product Managements");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Products Category");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Products Sub Category");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Products Type");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Products Record");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Invoices Managements");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Purchase Invoice");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Sales Invoices");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Sellers & Pruchasers");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Customers Type");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Sellers Records");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Clients Records");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("HR Managements");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Employee Desiginations");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Employee Records");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Expence Accounts");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Finance Managements");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Financial Accouts");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Voucher Creation");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Expences Entries");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Client Recoveries");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Customers Ledger");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Customers Balances");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Payments To Sellers");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Sellers Ledger");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Recieveables");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Payables");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Balance Sheet & ROI's");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Balance Sheet");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        DMS_PAN.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        DMS_PAN.setName("DynamicSP"); // NOI18N
        DMS_PAN.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent evt) {
                DMS_PANTreeCollapsed(evt);
            }
            public void treeExpanded(javax.swing.event.TreeExpansionEvent evt) {
            }
        });
        DMS_PAN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DMS_PANMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DMS_PANMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DMS_PANMouseExited(evt);
            }
        });
        DMS_PAN.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                DMS_PANValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(DMS_PAN);
        DMS_PAN.getAccessibleContext().setAccessibleName("");
        DMS_PAN.getAccessibleContext().setAccessibleDescription("");
        DMS_PAN.getAccessibleContext().setAccessibleParent(DMS_PAN);

        btnexit.setBackground(java.awt.Color.red);
        btnexit.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        btnexit.setForeground(new java.awt.Color(255, 255, 255));
        btnexit.setText("Exit Anon ERP");
        btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnexitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnexitMouseExited(evt);
            }
        });
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(btnexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnexit))
        );

        pan_menu.setBackground(new java.awt.Color(0, 102, 102));
        pan_menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DSPLOGO.setForeground(new java.awt.Color(255, 255, 255));
        DSPLOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/DynamicSP logo.png"))); // NOI18N
        DSPLOGO.setToolTipText("");

        ico_purinv.setForeground(new java.awt.Color(255, 255, 255));
        ico_purinv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ico_purinv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/purchase invoice 72.png"))); // NOI18N
        ico_purinv.setText("Purchase Invoices");
        ico_purinv.setToolTipText("Purchase Invoices");
        ico_purinv.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ico_purinv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ico_purinvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ico_purinvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ico_purinvMouseExited(evt);
            }
        });

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnclients.setForeground(new java.awt.Color(255, 255, 255));
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

        ico_salesinv.setForeground(new java.awt.Color(255, 255, 255));
        ico_salesinv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ico_salesinv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/saleinv 72.png"))); // NOI18N
        ico_salesinv.setText("Sale Invoices");
        ico_salesinv.setToolTipText("Sales Invoices");
        ico_salesinv.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ico_salesinv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ico_salesinvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ico_salesinvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ico_salesinvMouseExited(evt);
            }
        });

        btncustbalance.setForeground(new java.awt.Color(255, 255, 255));
        btncustbalance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/receivables 24.png"))); // NOI18N
        btncustbalance.setText("Customer Balances");
        btncustbalance.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btncustbalance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncustbalanceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncustbalanceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncustbalanceMouseExited(evt);
            }
        });

        btncustomerledger.setBackground(new java.awt.Color(51, 0, 0));
        btncustomerledger.setForeground(new java.awt.Color(255, 255, 255));
        btncustomerledger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/custleger 24.png"))); // NOI18N
        btncustomerledger.setText("Customer Ledger");
        btncustomerledger.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btncustomerledger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncustomerledgerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncustomerledgerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncustomerledgerMouseExited(evt);
            }
        });

        btnrecoveries.setForeground(new java.awt.Color(255, 255, 255));
        btnrecoveries.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/ledger 24.png"))); // NOI18N
        btnrecoveries.setText("Recoveries");
        btnrecoveries.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnrecoveries.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnrecoveriesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnrecoveriesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnrecoveriesMouseExited(evt);
            }
        });

        btnfinanceledger.setForeground(new java.awt.Color(255, 255, 255));
        btnfinanceledger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/financeledger 24.png"))); // NOI18N
        btnfinanceledger.setText("Finance Ledger");
        btnfinanceledger.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnfinanceledger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnfinanceledgerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnfinanceledgerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnfinanceledgerMouseExited(evt);
            }
        });

        ico_product.setForeground(new java.awt.Color(255, 255, 255));
        ico_product.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ico_product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/pro 72.png"))); // NOI18N
        ico_product.setText("Product Specifications");
        ico_product.setToolTipText("Product Managements");
        ico_product.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ico_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ico_productMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ico_productMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ico_productMouseExited(evt);
            }
        });

        btnexp.setForeground(new java.awt.Color(255, 255, 255));
        btnexp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/expence 24.png"))); // NOI18N
        btnexp.setText("Expence Enteries");
        btnexp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnexp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnexpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnexpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnexpMouseExited(evt);
            }
        });

        btnvoccreation.setBackground(new java.awt.Color(51, 0, 0));
        btnvoccreation.setForeground(new java.awt.Color(255, 255, 255));
        btnvoccreation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/pay to sellers 24.png"))); // NOI18N
        btnvoccreation.setText("Voucer Creations");
        btnvoccreation.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnvoccreation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnvoccreationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnvoccreationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnvoccreationMouseExited(evt);
            }
        });

        btnemploye.setForeground(new java.awt.Color(255, 255, 255));
        btnemploye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/dealer 24.png"))); // NOI18N
        btnemploye.setText("Employee Record");
        btnemploye.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnemploye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnemployeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnemployeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnemployeMouseExited(evt);
            }
        });

        btnfinanceledger1.setForeground(new java.awt.Color(255, 255, 255));
        btnfinanceledger1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/seller ledger 24.png"))); // NOI18N
        btnfinanceledger1.setText("Sellers Ledger");
        btnfinanceledger1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnfinanceledger1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnfinanceledger1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnfinanceledger1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnfinanceledger1MouseExited(evt);
            }
        });

        btnvoccreation1.setBackground(new java.awt.Color(51, 0, 0));
        btnvoccreation1.setForeground(new java.awt.Color(255, 255, 255));
        btnvoccreation1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/Payables 24.png"))); // NOI18N
        btnvoccreation1.setText("Sellers Balances");
        btnvoccreation1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnvoccreation1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnvoccreation1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnvoccreation1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnvoccreation1MouseExited(evt);
            }
        });

        btnexp1.setForeground(new java.awt.Color(255, 255, 255));
        btnexp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/pay to sellers 24.png"))); // NOI18N
        btnexp1.setText("Pay to Sellers");
        btnexp1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnexp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnexp1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnexp1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnexp1MouseExited(evt);
            }
        });

        btnemploye1.setForeground(new java.awt.Color(255, 255, 255));
        btnemploye1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/seller 24.png"))); // NOI18N
        btnemploye1.setText("Sellers Record");
        btnemploye1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnemploye1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnemploye1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnemploye1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnemploye1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pan_menuLayout = new javax.swing.GroupLayout(pan_menu);
        pan_menu.setLayout(pan_menuLayout);
        pan_menuLayout.setHorizontalGroup(
            pan_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_menuLayout.createSequentialGroup()
                .addComponent(ico_product, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnvoccreation, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnemploye, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnfinanceledger, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ico_purinv, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(pan_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnvoccreation1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnemploye1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnfinanceledger1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexp1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ico_salesinv, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncustomerledger, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnrecoveries, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclients, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncustbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DSPLOGO)
                .addContainerGap())
        );
        pan_menuLayout.setVerticalGroup(
            pan_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_menuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pan_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator11, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(ico_salesinv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pan_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pan_menuLayout.createSequentialGroup()
                            .addComponent(btnemploye1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnexp1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnvoccreation1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnfinanceledger1))
                        .addGroup(pan_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DSPLOGO)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pan_menuLayout.createSequentialGroup()
                                .addGroup(pan_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pan_menuLayout.createSequentialGroup()
                                        .addComponent(btnemploye)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnexp)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnvoccreation)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnfinanceledger))
                                    .addGroup(pan_menuLayout.createSequentialGroup()
                                        .addComponent(btnclients)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnrecoveries)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btncustbalance)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btncustomerledger)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator9, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(ico_purinv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ico_product, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(6, 6, 6))
        );

        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(350, 359));

        jPanel2.setVerifyInputWhenFocusTarget(false);

        tfclient.setEditable(false);
        tfclient.setBackground(new java.awt.Color(0, 204, 153));
        tfclient.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        tfclient.setForeground(new java.awt.Color(0, 102, 102));
        tfclient.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfclient.setText("ANON Matrix ERP");
        tfclient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfclientActionPerformed(evt);
            }
        });

        jPanel1.setMaximumSize(new java.awt.Dimension(300, 200));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("add2:");

        add1.setEnabled(false);
        add1.setMaximumSize(new java.awt.Dimension(300, 2147483647));
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        add1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                add1KeyPressed(evt);
            }
        });

        add2.setEnabled(false);
        add2.setMaximumSize(new java.awt.Dimension(300, 2147483647));
        add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add2ActionPerformed(evt);
            }
        });
        add2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                add2KeyPressed(evt);
            }
        });

        cell.setEnabled(false);
        cell.setMaximumSize(new java.awt.Dimension(300, 2147483647));
        cell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cellKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Cell #");

        ntn.setEnabled(false);
        ntn.setMaximumSize(new java.awt.Dimension(300, 2147483647));
        ntn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ntnKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("NTN #");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("add1:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ntn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ntn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        dspwelcome.setEditable(false);
        dspwelcome.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        dspwelcome.setForeground(new java.awt.Color(0, 102, 102));
        dspwelcome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dspwelcome.setText("Welcome : Anon Matrix ERP");
        dspwelcome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dspwelcomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dspwelcomeMouseExited(evt);
            }
        });
        dspwelcome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dspwelcomeActionPerformed(evt);
            }
        });

        imghome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imghome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/DynamicSP ERP.jpg"))); // NOI18N
        imghome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tftooltip.setEditable(false);
        tftooltip.setBackground(new java.awt.Color(240, 240, 240));
        tftooltip.setColumns(20);
        tftooltip.setFont(new java.awt.Font("Book Antiqua", 2, 24)); // NOI18N
        tftooltip.setForeground(new java.awt.Color(0, 102, 102));
        tftooltip.setLineWrap(true);
        tftooltip.setRows(5);
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
        tftooltip.setWrapStyleWord(true);
        tftooltip.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tftooltip.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tftooltipCaretUpdate(evt);
            }
        });
        jScrollPane3.setViewportView(tftooltip);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(imghome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)))
                    .addComponent(tfclient)
                    .addComponent(dspwelcome, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(2, 2, 2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(dspwelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfclient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(imghome)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );

        jScrollPane2.setViewportView(jPanel2);
        jPanel2.getAccessibleContext().setAccessibleName("");

        jpanfooter.setBackground(new java.awt.Color(102, 204, 255));

        link9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        link9.setForeground(new java.awt.Color(0, 102, 102));
        link9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        link9.setText("Uzair Ahmed | Muhammad Shahab Ul Hassan");
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

        javax.swing.GroupLayout jpanfooterLayout = new javax.swing.GroupLayout(jpanfooter);
        jpanfooter.setLayout(jpanfooterLayout);
        jpanfooterLayout.setHorizontalGroup(
            jpanfooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanfooterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(link9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanfooterLayout.setVerticalGroup(
            jpanfooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanfooterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(link9)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 153));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jmpro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/pro 24.png"))); // NOI18N
        jmpro.setMnemonic('p');
        jmpro.setText("Products Managements");
        jmpro.setActionCommand("New");
        jmpro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmproMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmproMouseExited(evt);
            }
        });

        jmitemtype1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/type 24.png"))); // NOI18N
        jmitemtype1.setText("Company Record");
        jmitemtype1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype1MouseExited(evt);
            }
        });
        jmitemtype1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype1stocktype(evt);
            }
        });
        jmpro.add(jmitemtype1);

        jmitemtype.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype.setText("Product Type");
        jmitemtype.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtypeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtypeMouseExited(evt);
            }
        });
        jmitemtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocktype(evt);
            }
        });
        jmpro.add(jmitemtype);

        jmitemtype2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/type 24.png"))); // NOI18N
        jmitemtype2.setText("Category Record");
        jmitemtype2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype2MouseExited(evt);
            }
        });
        jmitemtype2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype2stocktype(evt);
            }
        });
        jmpro.add(jmitemtype2);

        jmitemtype3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype3.setText("Sub Category Record");
        jmitemtype3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype3MouseExited(evt);
            }
        });
        jmitemtype3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype3stocktype(evt);
            }
        });
        jmpro.add(jmitemtype3);
        jmpro.add(jSeparator2);

        imitemproducts.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        imitemproducts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        imitemproducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/product 24.png"))); // NOI18N
        imitemproducts.setText("Product Record");
        imitemproducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imitemproductsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imitemproductsMouseExited(evt);
            }
        });
        imitemproducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imitemproductsActionPerformed(evt);
            }
        });
        jmpro.add(imitemproducts);

        imitemproducts1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        imitemproducts1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        imitemproducts1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/product 24.png"))); // NOI18N
        imitemproducts1.setText("Product Record Update");
        imitemproducts1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imitemproducts1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imitemproducts1MouseExited(evt);
            }
        });
        imitemproducts1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imitemproducts1ActionPerformed(evt);
            }
        });
        jmpro.add(imitemproducts1);
        jmpro.add(jSeparator27);
        jmpro.add(jSeparator8);
        jmpro.add(jSeparator16);

        jmitemtype5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype5.setText("Trade Offers in PCs...");
        jmitemtype5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype5MouseExited(evt);
            }
        });
        jmitemtype5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype5stocktype(evt);
            }
        });
        jmpro.add(jmitemtype5);

        jmitemtype4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype4.setText("Trade Offers in RS...");
        jmitemtype4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype4MouseExited(evt);
            }
        });
        jmitemtype4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype4stocktype(evt);
            }
        });
        jmpro.add(jmitemtype4);

        jmitemtype6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype6.setText("Invoices Slabe %age");
        jmitemtype6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype6MouseExited(evt);
            }
        });
        jmitemtype6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype6stocktype(evt);
            }
        });
        jmpro.add(jmitemtype6);
        jmpro.add(jSeparator19);

        jmitemtype7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype7.setText("Category Trade Offers...");
        jmitemtype7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype7MouseExited(evt);
            }
        });
        jmitemtype7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype7stocktype(evt);
            }
        });
        jmpro.add(jmitemtype7);

        jmitemtype8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype8.setText("Category Trade Offer in PCs...");
        jmitemtype8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype8MouseExited(evt);
            }
        });
        jmitemtype8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype8stocktype(evt);
            }
        });
        jmpro.add(jmitemtype8);
        jmpro.add(jSeparator54);

        subcatcheme.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        subcatcheme.setText("SUB Category Trade Offers...");
        subcatcheme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                subcatchemeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                subcatchemeMouseExited(evt);
            }
        });
        subcatcheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subcatchemestocktype(evt);
            }
        });
        jmpro.add(subcatcheme);

        jmitemtype17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype17.setText("SUB Category Trade Offer in PCs...");
        jmitemtype17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype17MouseExited(evt);
            }
        });
        jmitemtype17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype17stocktype(evt);
            }
        });
        jmpro.add(jmitemtype17);
        jmpro.add(jSeparator20);

        jmitemtype9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype9.setText("Trade offer 2nd Product...");
        jmitemtype9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype9MouseExited(evt);
            }
        });
        jmitemtype9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype9stocktype(evt);
            }
        });
        jmpro.add(jmitemtype9);
        jmpro.add(jSeparator30);
        jmpro.add(jSeparator29);
        jmpro.add(jSeparator28);

        jmitemtype10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype10.setText("Product List");
        jmitemtype10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype10MouseExited(evt);
            }
        });
        jmitemtype10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype10stocktype(evt);
            }
        });
        jmpro.add(jmitemtype10);

        jMenuBar1.add(jmpro);

        jmitempur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/salesinv 24.png"))); // NOI18N
        jmitempur.setMnemonic('s');
        jmitempur.setText("Stock Management (In - Out)");
        jmitempur.setActionCommand("New");
        jmitempur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitempurMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitempurMouseExited(evt);
            }
        });

        jmpurchase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jmpurchase.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmpurchase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/purchase invoice 24.png"))); // NOI18N
        jmpurchase.setText("Purchase Invoice");
        jmpurchase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmpurchaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmpurchaseMouseExited(evt);
            }
        });
        jmpurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpurchaseActionPerformed(evt);
            }
        });
        jmitempur.add(jmpurchase);
        jmitempur.add(jSeparator43);

        jmitemcusttype.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcusttype.setText("Stock Issue");
        jmitemcusttype.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcusttypeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcusttypeMouseExited(evt);
            }
        });
        jmitemcusttype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcusttypecusttype(evt);
            }
        });
        jmitempur.add(jmitemcusttype);

        jmiteminvoice.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmiteminvoice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmiteminvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/salesinv 24.png"))); // NOI18N
        jmiteminvoice.setText("Invoices / Deliveries ");
        jmiteminvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmiteminvoiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmiteminvoiceMouseExited(evt);
            }
        });
        jmiteminvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiteminvoiceActionPerformed(evt);
            }
        });
        jmitempur.add(jmiteminvoice);
        jmitempur.add(jSeparator57);

        jmitemcusttype1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jmitemcusttype1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcusttype1.setText("Stock & Claims Settlements");
        jmitemcusttype1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcusttype1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcusttype1MouseExited(evt);
            }
        });
        jmitemcusttype1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcusttype1custtype(evt);
            }
        });
        jmitempur.add(jmitemcusttype1);
        jmitempur.add(jSeparator56);

        jmiteminvoice1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmiteminvoice1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmiteminvoice1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/salesinv 24.png"))); // NOI18N
        jmiteminvoice1.setText("Invoice Settings");
        jmiteminvoice1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmiteminvoice1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmiteminvoice1MouseExited(evt);
            }
        });
        jmiteminvoice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiteminvoice1ActionPerformed(evt);
            }
        });
        jmitempur.add(jmiteminvoice1);
        jmitempur.add(jSeparator32);
        jmitempur.add(jSeparator35);
        jmitempur.add(jSeparator36);

        jmiteminvoice7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmiteminvoice7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/salesinv 24.png"))); // NOI18N
        jmiteminvoice7.setText("Stock Load Sheet");
        jmiteminvoice7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmiteminvoice7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmiteminvoice7MouseExited(evt);
            }
        });
        jmiteminvoice7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiteminvoice7ActionPerformed(evt);
            }
        });
        jmitempur.add(jmiteminvoice7);

        jmiteminvoice9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmiteminvoice9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/salesinv 24.png"))); // NOI18N
        jmiteminvoice9.setText("Manual Load (Invoice Range)");
        jmiteminvoice9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmiteminvoice9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmiteminvoice9MouseExited(evt);
            }
        });
        jmiteminvoice9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiteminvoice9ActionPerformed(evt);
            }
        });
        jmitempur.add(jmiteminvoice9);
        jmitempur.add(jSeparator60);

        jmiteminvoice8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmiteminvoice8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/salesinv 24.png"))); // NOI18N
        jmiteminvoice8.setText("Invoices Print");
        jmiteminvoice8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmiteminvoice8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmiteminvoice8MouseExited(evt);
            }
        });
        jmiteminvoice8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiteminvoice8ActionPerformed(evt);
            }
        });
        jmitempur.add(jmiteminvoice8);

        jmiteminvoice10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmiteminvoice10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/salesinv 24.png"))); // NOI18N
        jmiteminvoice10.setText("Invoices Range Print");
        jmiteminvoice10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmiteminvoice10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmiteminvoice10MouseExited(evt);
            }
        });
        jmiteminvoice10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiteminvoice10ActionPerformed(evt);
            }
        });
        jmitempur.add(jmiteminvoice10);
        jmitempur.add(jSeparator55);

        jMenu3.setText("Stock Reports");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jmitemtype22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype22.setText("Stock Report All ");
        jmitemtype22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype22MouseExited(evt);
            }
        });
        jmitemtype22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype22stocktype(evt);
            }
        });
        jMenu3.add(jmitemtype22);

        jmitemtype18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype18.setText("Stock Report All (Type wise)");
        jmitemtype18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype18MouseExited(evt);
            }
        });
        jmitemtype18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype18stocktype(evt);
            }
        });
        jMenu3.add(jmitemtype18);

        jmitemtype19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype19.setText("Stock Report All (Company wise)");
        jmitemtype19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype19MouseExited(evt);
            }
        });
        jmitemtype19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype19stocktype(evt);
            }
        });
        jMenu3.add(jmitemtype19);

        jmitemtype20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype20.setText("Stock Report All (Type, Comp & Cat)");
        jmitemtype20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype20MouseExited(evt);
            }
        });
        jmitemtype20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype20stocktype(evt);
            }
        });
        jMenu3.add(jmitemtype20);

        jmitemtype21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype21.setText("Stock Report All (Category wise)");
        jmitemtype21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype21MouseExited(evt);
            }
        });
        jmitemtype21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype21stocktype(evt);
            }
        });
        jMenu3.add(jmitemtype21);
        jMenu3.add(jSeparator66);

        jmitempur.add(jMenu3);

        jMenu1.setText("Stock Reports (Expiry & Batch Wise)");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jmitemtype12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype12.setText("Sub Category Wise Stock Report");
        jmitemtype12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype12MouseExited(evt);
            }
        });
        jmitemtype12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype12stocktype(evt);
            }
        });
        jMenu1.add(jmitemtype12);

        jmitemtype11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype11.setText("Expired & Useable Stock Reports");
        jmitemtype11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype11MouseExited(evt);
            }
        });
        jmitemtype11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype11stocktype(evt);
            }
        });
        jMenu1.add(jmitemtype11);

        jmitemtype13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype13.setText("Selective Company & Category Wise");
        jmitemtype13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype13MouseExited(evt);
            }
        });
        jmitemtype13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype13stocktype(evt);
            }
        });
        jMenu1.add(jmitemtype13);

        jmitemtype14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype14.setText("Stock Report All (Expiry & Batch wise)");
        jmitemtype14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype14MouseExited(evt);
            }
        });
        jmitemtype14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype14stocktype(evt);
            }
        });
        jMenu1.add(jmitemtype14);
        jMenu1.add(jSeparator61);

        jmitemtype16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype16.setText("Date Wise Stock Report All");
        jmitemtype16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype16MouseExited(evt);
            }
        });
        jmitemtype16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype16stocktype(evt);
            }
        });
        jMenu1.add(jmitemtype16);

        jmitemtype15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype15.setText("Company & Date Wise Stock Report");
        jmitemtype15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype15MouseExited(evt);
            }
        });
        jmitemtype15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype15stocktype(evt);
            }
        });
        jMenu1.add(jmitemtype15);
        jMenu1.add(jSeparator62);

        jmitempur.add(jMenu1);
        jmitempur.add(jSeparator58);

        jMenu2.setText("Sales Reports");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jmitemtype23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype23.setText("Sales Report (Date Wise)");
        jmitemtype23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype23MouseExited(evt);
            }
        });
        jmitemtype23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype23stocktype(evt);
            }
        });
        jMenu2.add(jmitemtype23);
        jMenu2.add(jSeparator59);

        jmitemtype26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype26.setText("Sales Report (Date & Cat. Wise)");
        jmitemtype26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype26MouseExited(evt);
            }
        });
        jmitemtype26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype26stocktype(evt);
            }
        });
        jMenu2.add(jmitemtype26);

        jmitemtype27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype27.setText("Sales Report (Date & Type Wise)");
        jmitemtype27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype27MouseExited(evt);
            }
        });
        jmitemtype27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype27stocktype(evt);
            }
        });
        jMenu2.add(jmitemtype27);

        jmitemtype24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype24.setText("Sales Report (Date & Comp. Wise)");
        jmitemtype24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype24MouseExited(evt);
            }
        });
        jmitemtype24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype24stocktype(evt);
            }
        });
        jMenu2.add(jmitemtype24);
        jMenu2.add(jSeparator63);

        jmitemtype25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype25.setText("Sales Report (Date, Comp. & Cat. Wise)");
        jmitemtype25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype25MouseExited(evt);
            }
        });
        jmitemtype25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype25stocktype(evt);
            }
        });
        jMenu2.add(jmitemtype25);

        jmitemtype28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype28.setText("Sales Report (Type, Comp. & Cat. Wise)");
        jmitemtype28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype28MouseExited(evt);
            }
        });
        jmitemtype28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype28stocktype(evt);
            }
        });
        jMenu2.add(jmitemtype28);
        jMenu2.add(jSeparator64);

        jmitemtype29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemtype29.setText("Sales Report (Date, Type & Comp Wise)");
        jmitemtype29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemtype29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemtype29MouseExited(evt);
            }
        });
        jmitemtype29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemtype29stocktype(evt);
            }
        });
        jMenu2.add(jmitemtype29);

        jmitempur.add(jMenu2);
        jmitempur.add(jSeparator65);

        jMenuBar1.add(jmitempur);

        jmreprots1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/custleger 24.png"))); // NOI18N
        jmreprots1.setMnemonic('e');
        jmreprots1.setText("Settlements");
        jmreprots1.setActionCommand("New");

        jmitemcustrec.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemcustrec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcustrec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/salesinv 24.png"))); // NOI18N
        jmitemcustrec.setText("Issue Adjustments");
        jmitemcustrec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcustrecMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcustrecMouseExited(evt);
            }
        });
        jmitemcustrec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcustrecActionPerformed(evt);
            }
        });
        jmreprots1.add(jmitemcustrec);

        jmiteminvoice4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmiteminvoice4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmiteminvoice4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/salesinv 24.png"))); // NOI18N
        jmiteminvoice4.setText("Manual Sales Return");
        jmiteminvoice4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmiteminvoice4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmiteminvoice4MouseExited(evt);
            }
        });
        jmiteminvoice4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiteminvoice4ActionPerformed(evt);
            }
        });
        jmreprots1.add(jmiteminvoice4);

        jmiteminvoice3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jmiteminvoice3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmiteminvoice3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/salesinv 24.png"))); // NOI18N
        jmiteminvoice3.setText("Sales Return From Invoice");
        jmiteminvoice3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmiteminvoice3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmiteminvoice3MouseExited(evt);
            }
        });
        jmiteminvoice3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiteminvoice3ActionPerformed(evt);
            }
        });
        jmreprots1.add(jmiteminvoice3);
        jmreprots1.add(jSeparator21);

        jMenuItem39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem39.setText("Route Recovery");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39EXPCODE(evt);
            }
        });
        jmreprots1.add(jMenuItem39);

        jMenuItem37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem37.setText("Recovery & Credits");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37EXPCODE(evt);
            }
        });
        jmreprots1.add(jMenuItem37);

        jMenuItem36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem36.setText("Cash & Credit Entries");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36EXPCODE(evt);
            }
        });
        jmreprots1.add(jMenuItem36);
        jmreprots1.add(jSeparator22);

        jMenuItem38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem38.setText("Expences");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38EXPCODE(evt);
            }
        });
        jmreprots1.add(jMenuItem38);

        jMenuItem40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem40.setText("Cash Deposits");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40EXPCODE(evt);
            }
        });
        jmreprots1.add(jMenuItem40);
        jmreprots1.add(jSeparator45);
        jmreprots1.add(jSeparator23);
        jmreprots1.add(jSeparator31);

        jMenuItem41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem41.setText("Settelement Sheet");
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41EXPCODE(evt);
            }
        });
        jmreprots1.add(jMenuItem41);

        jMenuItem42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem42.setText("Settelement Sheet All ");
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42EXPCODE(evt);
            }
        });
        jmreprots1.add(jMenuItem42);

        jMenuBar1.add(jmreprots1);

        jmroute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/Clients 24.png"))); // NOI18N
        jmroute.setText("Clients Record");
        jmroute.setActionCommand("New");
        jmroute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmrouteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmrouteMouseExited(evt);
            }
        });

        jmitememployee4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitememployee4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/dealer 24.png"))); // NOI18N
        jmitememployee4.setText("Customers Zone");
        jmitememployee4.setActionCommand("Employe");
        jmitememployee4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitememployee4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitememployee4MouseExited(evt);
            }
        });
        jmitememployee4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitememployee4ActionPerformed(evt);
            }
        });
        jmroute.add(jmitememployee4);

        jmitememployee6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitememployee6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/dealer 24.png"))); // NOI18N
        jmitememployee6.setText("Customer Route");
        jmitememployee6.setActionCommand("Employe");
        jmitememployee6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitememployee6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitememployee6MouseExited(evt);
            }
        });
        jmitememployee6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitememployee6ActionPerformed(evt);
            }
        });
        jmroute.add(jmitememployee6);
        jmroute.add(jSeparator1);

        jmitemcusttype2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemcusttype2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcusttype2.setText("Customer Types");
        jmitemcusttype2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcusttype2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcusttype2MouseExited(evt);
            }
        });
        jmitemcusttype2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custtype(evt);
            }
        });
        jmroute.add(jmitemcusttype2);

        jmitemcusttype4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemcusttype4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcusttype4.setText("Customer Type Discounts");
        jmitemcusttype4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcusttype4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcusttype4MouseExited(evt);
            }
        });
        jmitemcusttype4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcusttype4custtype(evt);
            }
        });
        jmroute.add(jmitemcusttype4);
        jmroute.add(jSeparator13);

        jmitemcusttype3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemcusttype3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcusttype3.setText("Client Area");
        jmitemcusttype3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcusttype3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcusttype3MouseExited(evt);
            }
        });
        jmitemcusttype3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcusttype3custtype(evt);
            }
        });
        jmroute.add(jmitemcusttype3);

        jmitemcustrec2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemcustrec2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcustrec2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/Clients 24.png"))); // NOI18N
        jmitemcustrec2.setText("Customer Records");
        jmitemcustrec2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcustrec2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcustrec2MouseExited(evt);
            }
        });
        jmitemcustrec2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcustrec2ActionPerformed(evt);
            }
        });
        jmroute.add(jmitemcustrec2);
        jmroute.add(jSeparator26);
        jmroute.add(jSeparator24);
        jmroute.add(jSeparator33);

        jmitemcustlist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcustlist.setText("Customers List");
        jmitemcustlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcustlistMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcustlistMouseExited(evt);
            }
        });
        jmitemcustlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcustlistActionPerformed(evt);
            }
        });
        jmroute.add(jmitemcustlist);

        jmitemcustbal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemcustbal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcustbal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/receivables 24.png"))); // NOI18N
        jmitemcustbal.setText("Customer Balances");
        jmitemcustbal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcustbalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcustbalMouseExited(evt);
            }
        });
        jmitemcustbal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcustbalActionPerformed(evt);
            }
        });
        jmroute.add(jmitemcustbal);
        jmroute.add(jSeparator14);

        jmitemcustledger.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemcustledger.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcustledger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/custleger 24.png"))); // NOI18N
        jmitemcustledger.setText("Customer Ledger");
        jmitemcustledger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcustledgerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcustledgerMouseExited(evt);
            }
        });
        jmitemcustledger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcustledgerActionPerformed(evt);
            }
        });
        jmroute.add(jmitemcustledger);

        jMenuBar1.add(jmroute);

        jmclients1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/seller 24.png"))); // NOI18N
        jmclients1.setText("Sellers Record");
        jmclients1.setActionCommand("New");
        jmclients1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmclients1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmclients1MouseExited(evt);
            }
        });

        jmitemcustrec3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmitemcustrec3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcustrec3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/seller 24.png"))); // NOI18N
        jmitemcustrec3.setText("Sellers Records");
        jmitemcustrec3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcustrec3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcustrec3MouseExited(evt);
            }
        });
        jmitemcustrec3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcustrec3ActionPerformed(evt);
            }
        });
        jmclients1.add(jmitemcustrec3);
        jmclients1.add(jSeparator48);
        jmclients1.add(jSeparator47);
        jmclients1.add(jSeparator34);

        jmitemcustlist1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcustlist1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/prolist 24.png"))); // NOI18N
        jmitemcustlist1.setText("Sellers List");
        jmitemcustlist1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmitemcustlist1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcustlist1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcustlist1MouseExited(evt);
            }
        });
        jmitemcustlist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcustlist1ActionPerformed(evt);
            }
        });
        jmclients1.add(jmitemcustlist1);

        jmitemcustbal1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcustbal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/Payables 24.png"))); // NOI18N
        jmitemcustbal1.setText("Sellers Balances");
        jmitemcustbal1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcustbal1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcustbal1MouseExited(evt);
            }
        });
        jmitemcustbal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcustbal1ActionPerformed(evt);
            }
        });
        jmclients1.add(jmitemcustbal1);

        jmitemcustbal2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcustbal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/Payables 24.png"))); // NOI18N
        jmitemcustbal2.setText("Sellers Payables");
        jmitemcustbal2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcustbal2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcustbal2MouseExited(evt);
            }
        });
        jmitemcustbal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcustbal2ActionPerformed(evt);
            }
        });
        jmclients1.add(jmitemcustbal2);

        jmitemcustbal3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcustbal3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/Payables 24.png"))); // NOI18N
        jmitemcustbal3.setText("Sellers Receivables");
        jmitemcustbal3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcustbal3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcustbal3MouseExited(evt);
            }
        });
        jmitemcustbal3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcustbal3ActionPerformed(evt);
            }
        });
        jmclients1.add(jmitemcustbal3);

        jmitemcustbal4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcustbal4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/Payables 24.png"))); // NOI18N
        jmitemcustbal4.setText("Sellers Balances (Only Balance)");
        jmitemcustbal4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcustbal4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcustbal4MouseExited(evt);
            }
        });
        jmitemcustbal4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcustbal4ActionPerformed(evt);
            }
        });
        jmclients1.add(jmitemcustbal4);
        jmclients1.add(jSeparator15);

        jmitemcustledger2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemcustledger2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcustledger2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/seller ledger 24.png"))); // NOI18N
        jmitemcustledger2.setText("Sellers Ledger");
        jmitemcustledger2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcustledger2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcustledger2MouseExited(evt);
            }
        });
        jmitemcustledger2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcustledger2ActionPerformed(evt);
            }
        });
        jmclients1.add(jmitemcustledger2);

        jMenuBar1.add(jmclients1);

        jmhr.setText("HR Management");
        jmhr.setActionCommand("New");
        jmhr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmhrMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmhrMouseExited(evt);
            }
        });

        jmitempost.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jmitempost.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitempost.setText("Designation - Post");
        jmitempost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitempostMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitempostMouseExited(evt);
            }
        });
        jmitempost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitempostpost(evt);
            }
        });
        jmhr.add(jmitempost);

        jmitememployee.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jmitememployee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitememployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/dealer 24.png"))); // NOI18N
        jmitememployee.setText("Employee Records");
        jmitememployee.setActionCommand("Employe");
        jmitememployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitememployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitememployeeMouseExited(evt);
            }
        });
        jmitememployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitememployeeActionPerformed(evt);
            }
        });
        jmhr.add(jmitememployee);
        jmhr.add(jSeparator44);

        jmitemexpcode.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemexpcode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemexpcode.setText("Expences Code");
        jmitemexpcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemexpcodeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemexpcodeMouseExited(evt);
            }
        });
        jmitemexpcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Assets(evt);
            }
        });
        jmhr.add(jmitemexpcode);

        jmitemexprec.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemexprec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemexprec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/expence 24.png"))); // NOI18N
        jmitemexprec.setText("Expence Records");
        jmitemexprec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemexprecMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemexprecMouseExited(evt);
            }
        });
        jmitemexprec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXPCODE(evt);
            }
        });
        jmhr.add(jmitemexprec);
        jmhr.add(jSeparator5);

        jmitememployee1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitememployee1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/dealer 24.png"))); // NOI18N
        jmitememployee1.setText("Employee Targets");
        jmitememployee1.setActionCommand("Employe");
        jmitememployee1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitememployee1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitememployee1MouseExited(evt);
            }
        });
        jmitememployee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitememployee1ActionPerformed(evt);
            }
        });
        jmhr.add(jmitememployee1);

        jmitememployee2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitememployee2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/dealer 24.png"))); // NOI18N
        jmitememployee2.setText("Employee Incentives");
        jmitememployee2.setActionCommand("Employe");
        jmitememployee2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitememployee2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitememployee2MouseExited(evt);
            }
        });
        jmitememployee2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitememployee2ActionPerformed(evt);
            }
        });
        jmhr.add(jmitememployee2);
        jmhr.add(jSeparator51);
        jmhr.add(jSeparator52);
        jmhr.add(jSeparator53);

        jmitememployee7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitememployee7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/dealer 24.png"))); // NOI18N
        jmitememployee7.setText("Employee List");
        jmitememployee7.setActionCommand("Employe");
        jmitememployee7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitememployee7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitememployee7MouseExited(evt);
            }
        });
        jmitememployee7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitememployee7ActionPerformed(evt);
            }
        });
        jmhr.add(jmitememployee7);

        jmitememployee8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitememployee8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/dealer 24.png"))); // NOI18N
        jmitememployee8.setText("Expences Report");
        jmitememployee8.setActionCommand("Employe");
        jmitememployee8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitememployee8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitememployee8MouseExited(evt);
            }
        });
        jmitememployee8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitememployee8ActionPerformed(evt);
            }
        });
        jmhr.add(jmitememployee8);

        jMenuBar1.add(jmhr);

        jmhr1.setText("Assets & Others");
        jmhr1.setActionCommand("New");
        jmhr1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmhr1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmhr1MouseExited(evt);
            }
        });

        jmitempost1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitempost1.setText("Asset Type");
        jmitempost1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitempost1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitempost1MouseExited(evt);
            }
        });
        jmitempost1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitempost1post(evt);
            }
        });
        jmhr1.add(jmitempost1);

        jmitememployee3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitememployee3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/dealer 24.png"))); // NOI18N
        jmitememployee3.setText("Asset Record");
        jmitememployee3.setActionCommand("Employe");
        jmitememployee3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitememployee3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitememployee3MouseExited(evt);
            }
        });
        jmitememployee3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitememployee3ActionPerformed(evt);
            }
        });
        jmhr1.add(jmitememployee3);
        jmhr1.add(jSeparator46);

        jmitemexprec1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemexprec1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/expence 24.png"))); // NOI18N
        jmitemexprec1.setText("Cash Types");
        jmitemexprec1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemexprec1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemexprec1MouseExited(evt);
            }
        });
        jmitemexprec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemexprec1EXPCODE(evt);
            }
        });
        jmhr1.add(jmitemexprec1);

        jmitemexpcode1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemexpcode1.setText("Van Record");
        jmitemexpcode1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemexpcode1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemexpcode1MouseExited(evt);
            }
        });
        jmitemexpcode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemexpcode1Assets(evt);
            }
        });
        jmhr1.add(jmitemexpcode1);

        jmitememployee9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitememployee9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/dealer 24.png"))); // NOI18N
        jmitememployee9.setText("Stock & Claims Settlement Type");
        jmitememployee9.setActionCommand("Employe");
        jmitememployee9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitememployee9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitememployee9MouseExited(evt);
            }
        });
        jmitememployee9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitememployee9ActionPerformed(evt);
            }
        });
        jmhr1.add(jmitememployee9);
        jmhr1.add(jSeparator50);
        jmhr1.add(jSeparator49);
        jmhr1.add(jSeparator10);

        jmitememployee5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitememployee5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/dealer 24.png"))); // NOI18N
        jmitememployee5.setText("Asset Report");
        jmitememployee5.setActionCommand("Employe");
        jmitememployee5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitememployee5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitememployee5MouseExited(evt);
            }
        });
        jmitememployee5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitememployee5ActionPerformed(evt);
            }
        });
        jmhr1.add(jmitememployee5);

        jMenuBar1.add(jmhr1);

        jmfinance.setText("Finance  ");
        jmfinance.setActionCommand("New");
        jmfinance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmfinanceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmfinanceMouseExited(evt);
            }
        });

        jmitembalancesheet.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jmitembalancesheet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitembalancesheet.setText("Balance Sheet");
        jmitembalancesheet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitembalancesheetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitembalancesheetMouseExited(evt);
            }
        });
        jmfinance.add(jmitembalancesheet);
        jmfinance.add(jSeparator40);

        jmitemrecoveries.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jmitemrecoveries.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemrecoveries.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/ledger 24.png"))); // NOI18N
        jmitemrecoveries.setText("Client Recoveries");
        jmitemrecoveries.setToolTipText("");
        jmitemrecoveries.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemrecoveriesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemrecoveriesMouseExited(evt);
            }
        });
        jmitemrecoveries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemrecoveriesActionPerformed(evt);
            }
        });
        jmfinance.add(jmitemrecoveries);
        jmfinance.add(jSeparator3);

        jmitemfinac.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jmitemfinac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemfinac.setText("Financial Accounts");
        jmitemfinac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemfinacMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemfinacMouseExited(evt);
            }
        });
        jmitemfinac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemfinacActionPerformed(evt);
            }
        });
        jmfinance.add(jmitemfinac);

        jmitemvoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemvoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemvoc.setText("Voucher Creations");
        jmitemvoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemvocMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemvocMouseExited(evt);
            }
        });
        jmitemvoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemvocActionPerformed(evt);
            }
        });
        jmfinance.add(jmitemvoc);

        jmitempaytoseller.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitempaytoseller.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitempaytoseller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/pay to sellers 24.png"))); // NOI18N
        jmitempaytoseller.setText("Payment To Sellers");
        jmitempaytoseller.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitempaytosellerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitempaytosellerMouseExited(evt);
            }
        });
        jmitempaytoseller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitempaytosellerActionPerformed(evt);
            }
        });
        jmfinance.add(jmitempaytoseller);
        jmfinance.add(jSeparator17);

        jmitemcomledger.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemcomledger.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcomledger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/seller ledger 24.png"))); // NOI18N
        jmitemcomledger.setText("Sellers Ledgers");
        jmitemcomledger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcomledgerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcomledgerMouseExited(evt);
            }
        });
        jmitemcomledger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcomledgerActionPerformed(evt);
            }
        });
        jmfinance.add(jmitemcomledger);

        jmitemcomledger1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemcomledger1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcomledger1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/financeledger 24.png"))); // NOI18N
        jmitemcomledger1.setMnemonic('l');
        jmitemcomledger1.setText("Finance Ledgers");
        jmitemcomledger1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcomledger1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcomledger1MouseExited(evt);
            }
        });
        jmitemcomledger1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcomledger1ActionPerformed(evt);
            }
        });
        jmfinance.add(jmitemcomledger1);

        jmitemcustledger1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemcustledger1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemcustledger1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/custleger 24.png"))); // NOI18N
        jmitemcustledger1.setText("Customer Ledger");
        jmitemcustledger1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemcustledger1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemcustledger1MouseExited(evt);
            }
        });
        jmitemcustledger1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemcustledger1ActionPerformed(evt);
            }
        });
        jmfinance.add(jmitemcustledger1);
        jmfinance.add(jSeparator39);

        jmitempayac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitempayac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/Payables 24.png"))); // NOI18N
        jmitempayac.setText("Customers Payables Accounts");
        jmitempayac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitempayacMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitempayacMouseExited(evt);
            }
        });
        jmitempayac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitempayacActionPerformed(evt);
            }
        });
        jmfinance.add(jmitempayac);

        jmitemrcable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemrcable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/receivables 24.png"))); // NOI18N
        jmitemrcable.setText("Customers Receiveable Accounts");
        jmitemrcable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemrcableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemrcableMouseExited(evt);
            }
        });
        jmitemrcable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemrcableActionPerformed(evt);
            }
        });
        jmfinance.add(jmitemrcable);
        jmfinance.add(jSeparator41);

        jmitemrcable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemrcable1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/receivables 24.png"))); // NOI18N
        jmitemrcable1.setText("Sellers Receiveable Accounts");
        jmitemrcable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemrcable1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemrcable1MouseExited(evt);
            }
        });
        jmitemrcable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemrcable1ActionPerformed(evt);
            }
        });
        jmfinance.add(jmitemrcable1);

        jmitempayac1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitempayac1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/Payables 24.png"))); // NOI18N
        jmitempayac1.setText("Sellers Payables Accounts");
        jmitempayac1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitempayac1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitempayac1MouseExited(evt);
            }
        });
        jmitempayac1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitempayac1ActionPerformed(evt);
            }
        });
        jmfinance.add(jmitempayac1);
        jmfinance.add(jSeparator18);

        jmitemfinac1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmitemfinac1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oracledms/frames/resources/prolist 24.png"))); // NOI18N
        jmitemfinac1.setText("Financial Accounts List");
        jmitemfinac1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemfinac1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemfinac1MouseExited(evt);
            }
        });
        jmitemfinac1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemfinac1ActionPerformed(evt);
            }
        });
        jmfinance.add(jmitemfinac1);

        jMenuBar1.add(jmfinance);

        jmexit.setText("DynamicSP ERP");
        jmexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmexitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmexitMouseExited(evt);
            }
        });
        jmexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_DMS(evt);
            }
        });

        DSP_ADMIN.setText("DSP ADMIN");
        DSP_ADMIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DSP_ADMINMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DSP_ADMINMouseExited(evt);
            }
        });
        DSP_ADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DSP_ADMINEXIT(evt);
            }
        });
        jmexit.add(DSP_ADMIN);

        jmitemexit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmitemexit.setText("EXIT DynamicSP FMS");
        jmitemexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmitemexitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmitemexitMouseExited(evt);
            }
        });
        jmitemexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXIT(evt);
            }
        });
        jmexit.add(jmitemexit);

        jMenuBar1.add(jmexit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pan_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanfooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1))
            .addComponent(jSeparator4)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pan_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanfooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Welcome to RealSYS");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Exit_DMS(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit_DMS
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Exit_DMS

    private void EXIT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXIT
        // TODO add your handling code here:
          if(JOptionPane.showConfirmDialog(new javax.swing.JFrame(),
            "Are you sure To Exit DynamicSP ERP...! \n\n click on \"Yes\" to Exit", "Confermation Diloge",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){        // TODO add your handling code here:

        this.setVisible(false);
        this.dispose();}
                         
    }//GEN-LAST:event_EXIT

    private void btnexitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexitMouseEntered
            tftooltip.setText("If you Want to Exit DynamicSP ERP Then Click Here");

    }//GEN-LAST:event_btnexitMouseEntered

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        if(JOptionPane.showConfirmDialog(new javax.swing.JFrame(),
            "Are you sure To Exit DynamicSP ERP...! \n\n click on \"Yes\" to Exit", "Confermation Diloge",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){        // TODO add your handling code here:

        this.setVisible(false);
        this.dispose();}
    }//GEN-LAST:event_btnexitActionPerformed

    private void DMS_PANTreeCollapsed(javax.swing.event.TreeExpansionEvent evt) {//GEN-FIRST:event_DMS_PANTreeCollapsed
        // TODO add your handling code here:
    }//GEN-LAST:event_DMS_PANTreeCollapsed

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

    private void dspwelcomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dspwelcomeActionPerformed
        
    }//GEN-LAST:event_dspwelcomeActionPerformed

    private void DMS_PANValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_DMS_PANValueChanged
      
    }//GEN-LAST:event_DMS_PANValueChanged

    private void DMS_PANMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DMS_PANMouseClicked
           // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            TreePath tp = DMS_PAN.getPathForLocation(evt.getX(), evt.getY());
            if(tp!=null){
                String node =tp.getLastPathComponent().toString();
                switch (node) {
                    case "Scociety - Projects Records":
                        try {
                            dialogeClass.createScocityWin();
                        } catch (SQLException ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Line Numbers":
                        try {
                            dialogeClass.createLineWin();
                        } catch (SQLException ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Block Mangements":
                        try {
                            dialogeClass.createAssetTypeWin();
                        } catch (SQLException ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Products Category":
                        try {
                            dialogeClass.createCatRecWin();
                        } catch (SQLException ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Products Type":
                        try {
                            dialogeClass.createStTypeRecWin();
                        } catch (SQLException ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Products Record":
                        try {
                            dialogeClass.createProductRecWin();
                        } catch (Exception ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Purchase Invoice":
                        PURCHASE pur = new PURCHASE();
                        pur.setVisible(true);
                        break;
                    case "Sales Invoices":
                        SALES sal =new SALES();
                        sal.setVisible(true);
                        break;
                    case "Customers Type":
                        try {
                            dialogeClass.createCustTypeWin();
                        } catch (SQLException ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Sellers Records":
                       try {
                            dialogeClass.createSellerWin();
                        } catch (SQLException ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Clients Records":
                        try {
                            dialogeClass.createCustRecWin();
                        } catch (SQLException ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Employee Desiginations":
                        try {
                            dialogeClass.createPostRecWin();
                        } catch (SQLException ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Employee Records":
                        try {
                            dialogeClass.createEmpRecWin();
                        } catch (SQLException ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Expence Accounts":
                        try {
                            dialogeClass.createExpenceWin();
                        } catch (SQLException ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Financial Accouts":
                        try {
                            dialogeClass.createFinanRecWin();
                        } catch (SQLException ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Voucher Creation":
                        try {
                            dialogeClass.createVouchersWin();
                        } catch (Exception ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Payments To Sellers":
                        try {
                            dialogeClass.createPaysellerWin();
                        } catch (Exception ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Expences Entries":
                        try {
                            dialogeClass.createExpDepWin();
                        } catch (SQLException ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Client Recoveries":
                        try {
                            dialogeClass.createRecoveryWin();
                        } catch (SQLException ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                }
            }else{
                System.out.println("TreePath : <WARNING> Found Null");
            }
        }
        
    }//GEN-LAST:event_DMS_PANMouseClicked

    private void EXPCODE(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXPCODE
        try {
            dialogeClass.createExpDepWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {  
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EXPCODE

    private void Assets(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Assets
        try {
            dialogeClass.createExpenceWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Assets

    private void custtype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custtype
        // TODO add your handling code here:
        try {
            dialogeClass.createCustTypeWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_custtype

    private void jmitempostpost(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitempostpost
        try {
            dialogeClass.createPostRecWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitempostpost

    private void jmitemcustrec2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcustrec2ActionPerformed
        // TODO add your handling code here:
        try {
            dialogeClass.createCustRecWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitemcustrec2ActionPerformed

    private void jmitemcusttypecusttype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcusttypecusttype
        ISSALES a = new ISSALES();
        a.setVisible(true);
    }//GEN-LAST:event_jmitemcusttypecusttype

    private void jmitemcustrecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcustrecActionPerformed
        ISSUERTN a = new ISSUERTN();
        a.setVisible(true);
     }//GEN-LAST:event_jmitemcustrecActionPerformed

    private void jmitememployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitememployeeActionPerformed
        try {
            // TODO add your handling code here:
            try {
                dialogeClass.createEmpRecWin();
            } catch (SQLException ex) {
                Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitememployeeActionPerformed

    private void jmitemfinacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemfinacActionPerformed
        try {
            dialogeClass.createFinanRecWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitemfinacActionPerformed

    private void tfclientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfclientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfclientActionPerformed

    private void jmpurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpurchaseActionPerformed
        PURCHASE a = new PURCHASE();
        a.setVisible(true);
    }//GEN-LAST:event_jmpurchaseActionPerformed

    private void jmiteminvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiteminvoiceActionPerformed
        SALES a = new SALES();
        a.setVisible(true);
    }//GEN-LAST:event_jmiteminvoiceActionPerformed

    private void dspwelcomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dspwelcomeMouseEntered
            tftooltip.setText("Welcome Anon Matrix | +92312 - 591 8292 | ");       
    }//GEN-LAST:event_dspwelcomeMouseEntered

    private void DMS_PANMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DMS_PANMouseEntered
         tftooltip.setText("This is the menu for Quick Link to the software Pages");
    }//GEN-LAST:event_DMS_PANMouseEntered

    private void DMS_PANMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DMS_PANMouseExited
          tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_DMS_PANMouseExited

    private void btnexitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexitMouseExited
           tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_btnexitMouseExited

    private void jmitempurMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitempurMouseExited
                             
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitempurMouseExited

    private void jmiteminvoiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoiceMouseExited
                                   
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmiteminvoiceMouseExited

    private void jmitemcusttypeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcusttypeMouseExited
                                  
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcusttypeMouseExited

    private void jmitemcustrecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustrecMouseExited
                                  
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcustrecMouseExited

    private void jmitemcusttype2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcusttype2MouseExited
                                     
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcusttype2MouseExited

    private void jmrouteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmrouteMouseExited
                                    
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmrouteMouseExited

    private void jmitemcustrec2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustrec2MouseExited
                                     
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcustrec2MouseExited

    private void jmitemcustlistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustlistMouseExited
                                   
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcustlistMouseExited

    private void jmitemcustbalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustbalMouseExited
                                  
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcustbalMouseExited

    private void jmitemcustledgerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustledgerMouseExited
                                
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcustledgerMouseExited

    private void jmhrMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmhrMouseExited
                                    
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmhrMouseExited

    private void jmitempostMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitempostMouseExited
                               
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitempostMouseExited

    private void jmitememployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployeeMouseExited
                                
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitememployeeMouseExited

    private void jmitemexpcodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemexpcodeMouseExited
                                    
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemexpcodeMouseExited

    private void jmitemexprecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemexprecMouseExited
                                    
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemexprecMouseExited

    private void jmexitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmexitMouseExited
                                     
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmexitMouseExited

    private void jmitemexitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemexitMouseExited
                                     
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemexitMouseExited

    private void jmitembalancesheetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitembalancesheetMouseExited
                                     
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitembalancesheetMouseExited

    private void jmitemrecoveriesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemrecoveriesMouseExited
                                    
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemrecoveriesMouseExited

    private void jmitemfinacMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemfinacMouseExited
                                   
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemfinacMouseExited

    private void jmitemvocMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemvocMouseExited
                                     
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemvocMouseExited

    private void jmitempaytosellerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitempaytosellerMouseExited
                                     
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitempaytosellerMouseExited

    private void jmitemcomledgerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcomledgerMouseExited
                                   
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcomledgerMouseExited

    private void jmitempayacMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitempayacMouseExited
                                    
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitempayacMouseExited

    private void jmitemrcableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemrcableMouseExited
                                    
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemrcableMouseExited

    private void dspwelcomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dspwelcomeMouseExited
    tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_dspwelcomeMouseExited

    private void jmitemrecoveriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemrecoveriesActionPerformed
        try {
            dialogeClass.createRecoveryWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitemrecoveriesActionPerformed

    private void jmpurchaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmpurchaseMouseEntered
     tftooltip.setText("Click Here for Check & Enter Purchase Invoices & Records...");
    }//GEN-LAST:event_jmpurchaseMouseEntered

    private void jmpurchaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmpurchaseMouseExited
    tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmpurchaseMouseExited

    private void jmitempurMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitempurMouseEntered
     tftooltip.setText("This is the Menu For Enter & Check Records For Sellers & Purchase...");
    }//GEN-LAST:event_jmitempurMouseEntered

    private void jmitemcusttypeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcusttypeMouseEntered
     tftooltip.setText("Click Here for Check & Enter Custiomers Type...");
    }//GEN-LAST:event_jmitemcusttypeMouseEntered

    private void jmitemcustrecMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustrecMouseEntered
     tftooltip.setText("Click Here for Check & Enter Customers Records...");
    }//GEN-LAST:event_jmitemcustrecMouseEntered

    private void jmrouteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmrouteMouseEntered
    tftooltip.setText("This is the Menu For Enter & Check Records For Clients, Ledgers & Their Balances...");
    }//GEN-LAST:event_jmrouteMouseEntered

    private void jmitemcusttype2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcusttype2MouseEntered
     tftooltip.setText("Click Here for Check & Enter Customers Type...");
    }//GEN-LAST:event_jmitemcusttype2MouseEntered

    private void jmitemcustrec2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustrec2MouseEntered
     tftooltip.setText("Click Here for Check & Enter Customers Records...");
    }//GEN-LAST:event_jmitemcustrec2MouseEntered

    private void jmitemcustlistMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustlistMouseEntered
     tftooltip.setText("Click Here for Check Different Types of Customers List...");
    }//GEN-LAST:event_jmitemcustlistMouseEntered

    private void jmitemcustbalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustbalMouseEntered
     tftooltip.setText("Click Here for Check Different Types of Customers Balances...");
    }//GEN-LAST:event_jmitemcustbalMouseEntered

    private void jmitemcustledgerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustledgerMouseEntered
     tftooltip.setText("Click Here for Check Different Types of Customers Ledgers...");
    }//GEN-LAST:event_jmitemcustledgerMouseEntered

    private void jmhrMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmhrMouseEntered
    tftooltip.setText("This is the Menu For Enter & Check Records For Employee, Dealers & Thier Expences...");
    }//GEN-LAST:event_jmhrMouseEntered

    private void jmitempostMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitempostMouseEntered
     tftooltip.setText("Click Here for Check & Enter Employee Desiginations or Post Records...");
    }//GEN-LAST:event_jmitempostMouseEntered

    private void jmitememployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployeeMouseEntered
     tftooltip.setText("Click Here for Check & Enter Employee & Dealers Records...");
    }//GEN-LAST:event_jmitememployeeMouseEntered

    private void jmitemexpcodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemexpcodeMouseEntered
     tftooltip.setText("Click Here for Check & Genrate Expences Accounts (Mean Which type of expences you will do)...");
    }//GEN-LAST:event_jmitemexpcodeMouseEntered

    private void jmitemexprecMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemexprecMouseEntered
     tftooltip.setText("Click Here for Check & Enter Expences...");
    }//GEN-LAST:event_jmitemexprecMouseEntered

    private void jmitembalancesheetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitembalancesheetMouseEntered
     tftooltip.setText("Click Here for Check Balance Sheet or ROI Statements...");
    }//GEN-LAST:event_jmitembalancesheetMouseEntered

    private void jmitemrecoveriesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemrecoveriesMouseEntered
     tftooltip.setText("Click Here for Check & Enter Recoveries of installment Amounts...");
    }//GEN-LAST:event_jmitemrecoveriesMouseEntered

    private void jmitemfinacMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemfinacMouseEntered
     tftooltip.setText("Click Here for Check & Enter Custom Finance Account...");
    }//GEN-LAST:event_jmitemfinacMouseEntered

    private void jmitemvocMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemvocMouseEntered
     tftooltip.setText("Click Here for Enter Debits or Credits for your Financial Account or Sellers...");
    }//GEN-LAST:event_jmitemvocMouseEntered

    private void jmitempaytosellerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitempaytosellerMouseEntered
     tftooltip.setText("Click Here for Check & Enter Payment which you give to the sellers...");
    }//GEN-LAST:event_jmitempaytosellerMouseEntered

    private void jmitemcomledgerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcomledgerMouseEntered
     tftooltip.setText("Click Here for Check Different types of Sellers Ledger...");
    }//GEN-LAST:event_jmitemcomledgerMouseEntered

    private void jmitempayacMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitempayacMouseEntered
         tftooltip.setText("Click Here for Check Customers Payable Accounts...");
    }//GEN-LAST:event_jmitempayacMouseEntered

    private void jmitemrcableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemrcableMouseEntered
     tftooltip.setText("Click Here for Check Customers Recieveable Accounts ...");
    }//GEN-LAST:event_jmitemrcableMouseEntered

    private void jmfinanceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmfinanceMouseEntered
    tftooltip.setText("This is the Menu For Enter & Check Records For Finance, Recoveries, & Custom Finance Manamgements...");
    }//GEN-LAST:event_jmfinanceMouseEntered

    private void jmfinanceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmfinanceMouseExited
    tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmfinanceMouseExited

    private void jmexitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmexitMouseEntered
            tftooltip.setText("This is The Menu For DynamicSP Options.....  (',')");
    }//GEN-LAST:event_jmexitMouseEntered

    private void jmitemexitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemexitMouseEntered
            tftooltip.setText("If you Want to Exit DynamicSP ERP Then Click Here");
    }//GEN-LAST:event_jmitemexitMouseEntered

    private void jmitemvocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemvocActionPerformed
        try {
            dialogeClass.createVouchersWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }//GEN-LAST:event_jmitemvocActionPerformed

    private void jmitempaytosellerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitempaytosellerActionPerformed
        try {
            dialogeClass.createPaysellerWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitempaytosellerActionPerformed

    private void jmitemcustledgerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcustledgerActionPerformed
                CUSTOMERLEDGER a = new CUSTOMERLEDGER();
                a.setVisible(true); 
    }//GEN-LAST:event_jmitemcustledgerActionPerformed

    private void jmitemcustbalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcustbalActionPerformed
try {
            
            String s= "D:\\DynamicERP\\DSP001\\custbal.jasper";
        JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
          JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);
                    
                    
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
      }
            
            }//GEN-LAST:event_jmitemcustbalActionPerformed

    private void cellKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cellKeyPressed
     
    }//GEN-LAST:event_cellKeyPressed

    private void ntnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ntnKeyPressed
      

    }//GEN-LAST:event_ntnKeyPressed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add1ActionPerformed

    private void add1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add1KeyPressed
//       
    }//GEN-LAST:event_add1KeyPressed

    private void add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add2ActionPerformed

    private void add2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add2KeyPressed
        
    }//GEN-LAST:event_add2KeyPressed

    private void jmitemcomledger1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcomledger1MouseEntered
        tftooltip.setText("Click Here for Check Finance Ledgers");
    }//GEN-LAST:event_jmitemcomledger1MouseEntered

    private void jmitemcomledger1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcomledger1MouseExited
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcomledger1MouseExited

    private void jmitemcomledger1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcomledger1ActionPerformed
            FINANCELEDGER a = new FINANCELEDGER();
            a.setVisible(true);
    }//GEN-LAST:event_jmitemcomledger1ActionPerformed

    private void jmitemcustledger1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustledger1MouseEntered
        tftooltip.setText("Click Here for Check Customers Ledgers");
    }//GEN-LAST:event_jmitemcustledger1MouseEntered

    private void jmitemcustledger1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustledger1MouseExited
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcustledger1MouseExited

    private void jmitemcustledger1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcustledger1ActionPerformed
            CUSTOMERLEDGER a = new CUSTOMERLEDGER();
            a.setVisible(true);
    }//GEN-LAST:event_jmitemcustledger1ActionPerformed

    private void jmitemcustlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcustlistActionPerformed
         try {
            
                    String s= "D:\\MPROREP\\custrec.jasper";
 
//                    JasperReport jr = JasperCompileManager.compileReport(s);
//                    JasperPrint print = JasperFillManager.fillReport(s,null,connAA);
//                    JasperViewer.viewReport(print);
                    
//        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(s);
        JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
            
                      JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);
                    
                    
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jmitemcustlistActionPerformed

    private void jmitemcomledgerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcomledgerActionPerformed
            SELLERSLEDGER a = new SELLERSLEDGER();
            a.setVisible(true);
            
            
                 }//GEN-LAST:event_jmitemcomledgerActionPerformed

    private void jmitempayacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitempayacActionPerformed
try {
            
        String s= "D:\\MPROREP\\custpayable.jasper";
//        String s= "D:\\DynamicSP PRO\\ERP\\src\\MPROREP\\final\\custpayable.jasper";
    
        JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
          JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);
                    
                    
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
            
        }
    }//GEN-LAST:event_jmitempayacActionPerformed

    private void jmiteminvoiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoiceMouseEntered
        tftooltip.setText("Click Here for Check & Enter Invoices Against Customers");
    }//GEN-LAST:event_jmiteminvoiceMouseEntered

    private void jmitemrcableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemrcableActionPerformed
try {
            
        String s= "D:\\MPROREP\\custrcable.jasper";
        JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
          JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);
                    
                    
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
            
        }
     }//GEN-LAST:event_jmitemrcableActionPerformed

    private void jmitemrcable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemrcable1MouseEntered
     tftooltip.setText("Click Here for Check Sellers Recieveable Accounts ...");
    }//GEN-LAST:event_jmitemrcable1MouseEntered

    private void jmitemrcable1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemrcable1MouseExited
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemrcable1MouseExited

    private void jmitemrcable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemrcable1ActionPerformed
try {
            
        String s= "D:\\DynamicERP\\DSP001\\sellerbal_rcable.jasper";
        JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
          JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);     
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jmitemrcable1ActionPerformed

    private void jmitempayac1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitempayac1MouseEntered
     tftooltip.setText("Click Here for Check Sellers Payables Accounts...");
    }//GEN-LAST:event_jmitempayac1MouseEntered

    private void jmitempayac1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitempayac1MouseExited
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitempayac1MouseExited

    private void jmitempayac1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitempayac1ActionPerformed
try {
            
        String s= "D:\\DynamicERP\\DSP001\\sellerbal_payable.jasper";
        JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
          JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);     
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jmitempayac1ActionPerformed

    private void jmitemcustrec3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustrec3MouseEntered
     tftooltip.setText("Click Here for Check Different Types of Sellers Record...");
    }//GEN-LAST:event_jmitemcustrec3MouseEntered

    private void jmitemcustrec3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustrec3MouseExited
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcustrec3MouseExited

    private void jmitemcustrec3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcustrec3ActionPerformed
        try {
            dialogeClass.createSellerWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitemcustrec3ActionPerformed

    private void jmitemcustlist1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustlist1MouseEntered
     tftooltip.setText("Click Here for Check Different Types of Sellers List...");
    }//GEN-LAST:event_jmitemcustlist1MouseEntered

    private void jmitemcustlist1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustlist1MouseExited
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcustlist1MouseExited

    private void jmitemcustlist1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcustlist1ActionPerformed
try {
            
        String s= "D:\\MPROREP\\sellerrec.jasper";
        JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
          JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);        
                    
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jmitemcustlist1ActionPerformed

    private void jmitemcustbal1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustbal1MouseEntered
     tftooltip.setText("Click Here for Check Different Types of Sellers Balances...");
    }//GEN-LAST:event_jmitemcustbal1MouseEntered

    private void jmitemcustbal1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustbal1MouseExited
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcustbal1MouseExited

    private void jmitemcustbal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcustbal1ActionPerformed
try {
            
        String s= "D:\\DynamicERP\\DSP001\\sellerbal.jasper";
        JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
          JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);     
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jmitemcustbal1ActionPerformed

    private void jmitemcustledger2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustledger2MouseEntered
     tftooltip.setText("Click Here for Check Different Types of Sellers Ledgers...");
    }//GEN-LAST:event_jmitemcustledger2MouseEntered

    private void jmitemcustledger2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustledger2MouseExited
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcustledger2MouseExited

    private void jmitemcustledger2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcustledger2ActionPerformed
            SELLERSLEDGER a = new SELLERSLEDGER();
            a.setVisible(true);
    }//GEN-LAST:event_jmitemcustledger2ActionPerformed

    private void jmclients1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmclients1MouseEntered
    tftooltip.setText("This is the Menu For Enter & Check Records For Sellers, Ledgers & Their Balances...");
    }//GEN-LAST:event_jmclients1MouseEntered

    private void jmclients1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmclients1MouseExited
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmclients1MouseExited

    private void jmitemcustlist1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustlist1MouseClicked
     tftooltip.setText("Click Here for Check Different Types of Customers List...");
    }//GEN-LAST:event_jmitemcustlist1MouseClicked

    private void jmitemfinac1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemfinac1MouseEntered
     tftooltip.setText("Click Here for Check & Enter Custom Finance Account...");
    }//GEN-LAST:event_jmitemfinac1MouseEntered

    private void jmitemfinac1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemfinac1MouseExited
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemfinac1MouseExited

    private void jmitemfinac1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemfinac1ActionPerformed
try {
            
        String s= "D:\\MPROREP\\financerec.jasper";
        JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
          JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);      
                    
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jmitemfinac1ActionPerformed

    private void jmiteminvoice3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoice3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiteminvoice3MouseEntered

    private void jmiteminvoice3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoice3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiteminvoice3MouseExited

    private void jmiteminvoice3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiteminvoice3ActionPerformed
        SALESRTN a = new SALESRTN();
        a.setVisible(true);
    }//GEN-LAST:event_jmiteminvoice3ActionPerformed

    private void jmproMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmproMouseExited
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmproMouseExited

    private void jmproMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmproMouseEntered
        tftooltip.setText("This is the Menu For Enter & Check Records For Products & Relevent Records...");
    }//GEN-LAST:event_jmproMouseEntered

    private void imitemproductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imitemproductsActionPerformed
        // TODO add your handling code here:

        try {
            dialogeClass.createProductRecWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_imitemproductsActionPerformed

    private void imitemproductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imitemproductsMouseExited
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_imitemproductsMouseExited

    private void imitemproductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imitemproductsMouseEntered
        tftooltip.setText("Click Here for Check & Enter Products Record...");
    }//GEN-LAST:event_imitemproductsMouseEntered

    private void stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocktype
        try {
            dialogeClass.createStTypeRecWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_stocktype

    private void jmitemtypeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtypeMouseExited
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemtypeMouseExited

    private void jmitemtypeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtypeMouseEntered
        tftooltip.setText("Click Here for Check & Enter Products Type Records...Mean Which Type of Products you Have");
    }//GEN-LAST:event_jmitemtypeMouseEntered

    private void jmitemtype1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype1MouseEntered
        tftooltip.setText("Click Here for Check & Enter Brand or Company Record");
    }//GEN-LAST:event_jmitemtype1MouseEntered

    private void jmitemtype1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype1MouseExited
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
     }//GEN-LAST:event_jmitemtype1MouseExited

    private void jmitemtype1stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype1stocktype
        try {
            dialogeClass.createScocityWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_jmitemtype1stocktype

    private void jmiteminvoice4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoice4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiteminvoice4MouseEntered

    private void jmiteminvoice4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoice4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiteminvoice4MouseExited

    private void jmiteminvoice4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiteminvoice4ActionPerformed
        INSTRTN a = new INSTRTN();
        a.setVisible(true);
    }//GEN-LAST:event_jmiteminvoice4ActionPerformed

    private void jmitemtype2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype2MouseEntered

    private void jmitemtype2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype2MouseExited

    private void jmitemtype2stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype2stocktype
        try {
            dialogeClass.createCatRecWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitemtype2stocktype

    private void jmitemtype3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype3MouseEntered

    private void jmitemtype3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype3MouseExited

    private void jmitemtype3stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype3stocktype
        try {
            dialogeClass.createLineWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitemtype3stocktype

    private void jmitemcusttype3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcusttype3MouseEntered
     tftooltip.setText("Click Here for Check & Enter Customers Area or District Record...");
    }//GEN-LAST:event_jmitemcusttype3MouseEntered

    private void jmitemcusttype3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcusttype3MouseExited
                                     
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcusttype3MouseExited

    private void jmitemcusttype3custtype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcusttype3custtype
        try {
            dialogeClass.createDistRecWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitemcusttype3custtype

    private void btnemployeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnemployeMouseExited
        btnemploye.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_btnemployeMouseExited

    private void btnemployeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnemployeMouseEntered
        btnemploye.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check & Enter Employee Records");
    }//GEN-LAST:event_btnemployeMouseEntered

    private void btnemployeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnemployeMouseClicked
        try {
            // TODO add your handling code here:
            try {
                dialogeClass.createEmpRecWin();
            } catch (SQLException ex) {
                Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnemployeMouseClicked

    private void btnvoccreationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnvoccreationMouseExited
        btnvoccreation.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_btnvoccreationMouseExited

    private void btnvoccreationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnvoccreationMouseEntered
        btnvoccreation.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check & Enter Payments Against Financial Accounts");
    }//GEN-LAST:event_btnvoccreationMouseEntered

    private void btnvoccreationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnvoccreationMouseClicked
        try {
            dialogeClass.createVouchersWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnvoccreationMouseClicked

    private void btnexpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexpMouseExited
        btnexp.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_btnexpMouseExited

    private void btnexpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexpMouseEntered
        btnexp.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check & Enter Expences");
    }//GEN-LAST:event_btnexpMouseEntered

    private void btnexpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexpMouseClicked

        try {
            dialogeClass.createExpDepWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnexpMouseClicked

    private void ico_productMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ico_productMouseExited
        ico_product.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_ico_productMouseExited

    private void ico_productMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ico_productMouseEntered
        ico_product.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check & Enter Products Records");
    }//GEN-LAST:event_ico_productMouseEntered

    private void ico_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ico_productMouseClicked
        try {
            dialogeClass.createProductRecWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ico_productMouseClicked

    private void btnfinanceledgerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfinanceledgerMouseExited
        btnfinanceledger.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_btnfinanceledgerMouseExited

    private void btnfinanceledgerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfinanceledgerMouseEntered
        btnfinanceledger.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check Finance Ledgers");
    }//GEN-LAST:event_btnfinanceledgerMouseEntered

    private void btnfinanceledgerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfinanceledgerMouseClicked
        FINANCELEDGER a = new FINANCELEDGER();
        a.setVisible(true);
    }//GEN-LAST:event_btnfinanceledgerMouseClicked

    private void btnrecoveriesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrecoveriesMouseExited
        btnrecoveries.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_btnrecoveriesMouseExited

    private void btnrecoveriesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrecoveriesMouseEntered
        btnrecoveries.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check & Enter Client Recoveries");
    }//GEN-LAST:event_btnrecoveriesMouseEntered

    private void btnrecoveriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrecoveriesMouseClicked
        try {
            dialogeClass.createRecoveryWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnrecoveriesMouseClicked

    private void btncustomerledgerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncustomerledgerMouseExited
        btncustomerledger.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_btncustomerledgerMouseExited

    private void btncustomerledgerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncustomerledgerMouseEntered
        btncustomerledger.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check Customers Ledgers");
    }//GEN-LAST:event_btncustomerledgerMouseEntered

    private void btncustomerledgerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncustomerledgerMouseClicked
        CUSTOMERLEDGER a = new CUSTOMERLEDGER();
        a.setVisible(true);
    }//GEN-LAST:event_btncustomerledgerMouseClicked

    private void btncustbalanceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncustbalanceMouseExited
        btncustbalance.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_btncustbalanceMouseExited

    private void btncustbalanceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncustbalanceMouseEntered
        btncustbalance.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check Payables & Receivables against customers");
    }//GEN-LAST:event_btncustbalanceMouseEntered

    private void btncustbalanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncustbalanceMouseClicked
        try {

            String s= "D:\\DynamicERP\\DSP001\\custbal.jasper";
            JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
            JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);

        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_btncustbalanceMouseClicked

    private void ico_salesinvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ico_salesinvMouseExited
        ico_salesinv.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_ico_salesinvMouseExited

    private void ico_salesinvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ico_salesinvMouseEntered
        ico_salesinv.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check & Enter Invoices Against Customers");
    }//GEN-LAST:event_ico_salesinvMouseEntered

    private void ico_salesinvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ico_salesinvMouseClicked
        SALES a = new SALES();
        a.setVisible(true);
    }//GEN-LAST:event_ico_salesinvMouseClicked

    private void btnclientsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclientsMouseExited
        btnclients.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_btnclientsMouseExited

    private void btnclientsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclientsMouseEntered
        btnclients.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check & Enter Clients Record");
    }//GEN-LAST:event_btnclientsMouseEntered

    private void btnclientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclientsMouseClicked
        try {
            dialogeClass.createCustRecWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnclientsMouseClicked

    private void ico_purinvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ico_purinvMouseExited
        ico_purinv.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_ico_purinvMouseExited

    private void ico_purinvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ico_purinvMouseEntered
        ico_purinv.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check & Enter Purchase invoices");
    }//GEN-LAST:event_ico_purinvMouseEntered

    private void ico_purinvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ico_purinvMouseClicked
        PURCHASE a = new PURCHASE();
        a.setVisible(true);
        
    }//GEN-LAST:event_ico_purinvMouseClicked

    private void btnfinanceledger1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfinanceledger1MouseClicked
            SELLERSLEDGER a = new SELLERSLEDGER();
            a.setVisible(true);
    }//GEN-LAST:event_btnfinanceledger1MouseClicked

    private void btnfinanceledger1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfinanceledger1MouseEntered
        btnfinanceledger1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check Seller or Company Ledgers");
    }//GEN-LAST:event_btnfinanceledger1MouseEntered

    private void btnfinanceledger1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfinanceledger1MouseExited
        btnfinanceledger1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
     }//GEN-LAST:event_btnfinanceledger1MouseExited

    private void btnvoccreation1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnvoccreation1MouseClicked
try {
            
        String s= "D:\\DynamicERP\\DSP001\\sellerbal.jasper";
        JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
          JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);     
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        
        }    }//GEN-LAST:event_btnvoccreation1MouseClicked

    private void btnvoccreation1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnvoccreation1MouseEntered
        btnvoccreation1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check Payables & Receivables against Sellers or Company");
    }//GEN-LAST:event_btnvoccreation1MouseEntered

    private void btnvoccreation1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnvoccreation1MouseExited
        btnvoccreation1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
     }//GEN-LAST:event_btnvoccreation1MouseExited

    private void btnexp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexp1MouseClicked
        try {
            dialogeClass.createPaysellerWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnexp1MouseClicked

    private void btnexp1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexp1MouseEntered
    btnexp1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check & Enter Payments to the Sellers or Company");
        }//GEN-LAST:event_btnexp1MouseEntered

    private void btnexp1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexp1MouseExited
        btnexp1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_btnexp1MouseExited

    private void btnemploye1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnemploye1MouseClicked
        try {
            dialogeClass.createSellerWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnemploye1MouseClicked

    private void btnemploye1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnemploye1MouseEntered
        btnemploye1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        tftooltip.setText("Click Here for Check & Enter Sellers Records");
    }//GEN-LAST:event_btnemploye1MouseEntered

    private void btnemploye1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnemploye1MouseExited
        btnemploye1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_btnemploye1MouseExited

    private void jmitememployee1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee1MouseEntered
     tftooltip.setText("Click Here for Check & Enter Employee Tardgets...");
    }//GEN-LAST:event_jmitememployee1MouseEntered

    private void jmitememployee1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee1MouseExited
                                     
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitememployee1MouseExited

    private void jmitememployee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitememployee1ActionPerformed
        try {
            dialogeClass.createEmpTargetWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitememployee1ActionPerformed

    private void jmitememployee2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee2MouseEntered
     tftooltip.setText("Click Here for Check & Enter Employee Incentives on Sale...");
    }//GEN-LAST:event_jmitememployee2MouseEntered

    private void jmitememployee2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee2MouseExited
                                     
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitememployee2MouseExited

    private void jmitememployee2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitememployee2ActionPerformed
        try {
            dialogeClass.createEmpincentive();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_jmitememployee2ActionPerformed

    private void jmitemcusttype4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcusttype4MouseEntered
     tftooltip.setText("Click Here for Check & Enter Customers Type Auto Discounts...");
    }//GEN-LAST:event_jmitemcusttype4MouseEntered

    private void jmitemcusttype4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcusttype4MouseExited
                                     
        tftooltip.setText("Move cursor to the Item For show Tooltip Here");
    }//GEN-LAST:event_jmitemcusttype4MouseExited

    private void jmitemcusttype4custtype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcusttype4custtype
        try {
            dialogeClass.createTypeDISC();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
     }//GEN-LAST:event_jmitemcusttype4custtype

    private void tftooltipCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tftooltipCaretUpdate

    }//GEN-LAST:event_tftooltipCaretUpdate

    private void DSP_ADMINMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DSP_ADMINMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DSP_ADMINMouseEntered

    private void DSP_ADMINMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DSP_ADMINMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DSP_ADMINMouseExited

    private void DSP_ADMINEXIT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DSP_ADMINEXIT
        
        
        AdminLogin admin = new AdminLogin();
        admin.setVisible(true);
        
        /*
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        String password = new String(pf.getPassword());
      
        if (okCxl == JOptionPane.OK_OPTION) 
        {
            String pass="Dynamic001";
            if(password.equals(pass))
            {
              System.err.println("You entered: " + password);
              ADMINPAGE admin = new ADMINPAGE();
              admin.setVisible(true);
            }
            else
            {
                JFrame j=new JFrame();
                j.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(j, "Wrong Password", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        */
    }//GEN-LAST:event_DSP_ADMINEXIT

    private void jmitemtype4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype4MouseEntered

    private void jmitemtype4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype4MouseExited

    private void jmitemtype4stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype4stocktype
            SCHEMERS a = new SCHEMERS();
            a.setVisible(true);
    }//GEN-LAST:event_jmitemtype4stocktype

    private void jmitemtype5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype5MouseEntered

    private void jmitemtype5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype5MouseExited

    private void jmitemtype5stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype5stocktype
        // TODO add your handling code here:
        SCHEMEQTY s=new SCHEMEQTY();
        s.setVisible(true);
    }//GEN-LAST:event_jmitemtype5stocktype

    private void jmitemtype6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype6MouseEntered

    private void jmitemtype6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype6MouseExited

    private void jmitemtype6stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype6stocktype
            SLABPER a = new SLABPER();
            a.setVisible(true);
    }//GEN-LAST:event_jmitemtype6stocktype

    private void jmitemtype7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype7MouseEntered

    private void jmitemtype7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype7MouseExited

    private void jmitemtype7stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype7stocktype
            SCHEMEPROCAT a = new SCHEMEPROCAT();
            a.setVisible(true);
    }//GEN-LAST:event_jmitemtype7stocktype

    private void jmitemtype8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype8MouseEntered

    private void jmitemtype8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype8MouseExited

    private void jmitemtype8stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype8stocktype
            SCHPROCATPRO a = new SCHPROCATPRO();
            a.setVisible(true);
    }//GEN-LAST:event_jmitemtype8stocktype

    private void jmitemtype9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype9MouseEntered

    private void jmitemtype9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype9MouseExited

    private void jmitemtype9stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype9stocktype
            SCHQTYPRO a = new SCHQTYPRO();
            a.setVisible(true);
    }//GEN-LAST:event_jmitemtype9stocktype

    private void jMenuItem36EXPCODE(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36EXPCODE
        try {
            dialogeClass.createCashCreditWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem36EXPCODE

    private void jMenuItem37EXPCODE(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37EXPCODE
        try {
            dialogeClass.createRecoveryWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem37EXPCODE

    private void jMenuItem38EXPCODE(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38EXPCODE
        try {
            dialogeClass.createExpDepWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {  
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem38EXPCODE

    private void jMenuItem40EXPCODE(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40EXPCODE

            try {
                dialogeClass.createcashdepositWin();
            } catch (SQLException ex) {
                Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
            }
        
      }//GEN-LAST:event_jMenuItem40EXPCODE

    private void jMenuItem41EXPCODE(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41EXPCODE
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem41EXPCODE

    private void jMenuItem42EXPCODE(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42EXPCODE
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem42EXPCODE

    private void jmitempost1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitempost1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitempost1MouseEntered

    private void jmitempost1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitempost1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitempost1MouseExited

    private void jmitempost1post(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitempost1post
        try {
            dialogeClass.createAssetTypeWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitempost1post

    private void jmitememployee3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee3MouseEntered

    private void jmitememployee3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee3MouseExited

    private void jmitememployee3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitememployee3ActionPerformed
        try {
            dialogeClass.createAssetWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitememployee3ActionPerformed

    private void jmitemexpcode1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemexpcode1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemexpcode1MouseEntered

    private void jmitemexpcode1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemexpcode1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemexpcode1MouseExited

    private void jmitemexpcode1Assets(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemexpcode1Assets
        try {
            dialogeClass.createVANWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }//GEN-LAST:event_jmitemexpcode1Assets

    private void jmitemexprec1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemexprec1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemexprec1MouseEntered

    private void jmitemexprec1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemexprec1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemexprec1MouseExited

    private void jmitemexprec1EXPCODE(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemexprec1EXPCODE
        try {
            dialogeClass.createCashTYPEWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitemexprec1EXPCODE

    private void jmitememployee4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee4MouseEntered

    private void jmitememployee4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee4MouseExited

    private void jmitememployee4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitememployee4ActionPerformed
        try {
            dialogeClass.createZONEWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitememployee4ActionPerformed

    private void jmitememployee5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee5MouseEntered

    private void jmitememployee5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee5MouseExited

    private void jmitememployee5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitememployee5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee5ActionPerformed

    private void jmhr1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmhr1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmhr1MouseEntered

    private void jmhr1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmhr1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmhr1MouseExited

    private void jmitememployee6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee6MouseEntered

    private void jmitememployee6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee6MouseExited

    private void jmitememployee6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitememployee6ActionPerformed
        try {
            dialogeClass.createRouteWin();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitememployee6ActionPerformed

    private void jmitemtype10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype10MouseEntered

    private void jmitemtype10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype10MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype10MouseExited

    private void jmitemtype10stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype10stocktype
//        try {
//
//            String s= "D:\\DynamicERP\\DSP001\\stockrepexpbatch.jasper";
//            JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
//            JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
//            createJasperView(jasperViewer);
//
//        } catch (Exception e) {
//            System.out.println("Exception ===> "+e);
//        }
    }//GEN-LAST:event_jmitemtype10stocktype

    private void jmiteminvoice7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoice7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiteminvoice7MouseEntered

    private void jmiteminvoice7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoice7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiteminvoice7MouseExited

    private void jmiteminvoice7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiteminvoice7ActionPerformed
        try {
            dialogeClass.createLoadSheetWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jmiteminvoice7ActionPerformed

    private void jmiteminvoice9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoice9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiteminvoice9MouseEntered

    private void jmiteminvoice9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoice9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiteminvoice9MouseExited

    private void jmiteminvoice9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiteminvoice9ActionPerformed
        try {
            dialogeClass.createLoadSheet_BWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }//GEN-LAST:event_jmiteminvoice9ActionPerformed

    private void jmitememployee7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee7MouseEntered

    private void jmitememployee7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee7MouseExited

    private void jmitememployee7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitememployee7ActionPerformed
        try {

            String s= "D:\\DynamicERP\\DSP001\\emplist.jasper";
            JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
            JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);

        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jmitememployee7ActionPerformed

    private void jmitememployee8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee8MouseEntered

    private void jmitememployee8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee8MouseExited

    private void jmitememployee8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitememployee8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee8ActionPerformed

    private void jmitemtype11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype11MouseEntered

    private void jmitemtype11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype11MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype11MouseExited

    private void jmitemtype11stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype11stocktype
        try {
            dialogeClass.createExpiryTillWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {  
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitemtype11stocktype

    private void jmitemtype12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype12MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype12MouseEntered

    private void jmitemtype12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype12MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype12MouseExited

    private void jmitemtype12stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype12stocktype
        try {
            dialogeClass.createStockSubCatWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jmitemtype12stocktype

    private void jmitemtype13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype13MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype13MouseEntered

    private void jmitemtype13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype13MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype13MouseExited

    private void jmitemtype13stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype13stocktype
        try {
            dialogeClass.createStockParameterWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {  
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitemtype13stocktype

    private void jmitemtype14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype14MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype14MouseEntered

    private void jmitemtype14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype14MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype14MouseExited

    private void jmitemtype14stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype14stocktype
            try {

            String s= "D:\\DynamicERP\\DSP001\\stockrepexpbatch.jasper";
            JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
            JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);


        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }

               
     }//GEN-LAST:event_jmitemtype14stocktype

    private void jmitemtype15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype15MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype15MouseEntered

    private void jmitemtype15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype15MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype15MouseExited

    private void jmitemtype15stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype15stocktype
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype15stocktype

    private void jmitemtype16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype16MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype16MouseEntered

    private void jmitemtype16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype16MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype16MouseExited

    private void jmitemtype16stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype16stocktype
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype16stocktype

    private void jmitemtype17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype17MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype17MouseEntered

    private void jmitemtype17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype17MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype17MouseExited

    private void jmitemtype17stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype17stocktype
            SCHPROSBCATPRO a = new SCHPROSBCATPRO();
            a.setVisible(true);
    }//GEN-LAST:event_jmitemtype17stocktype

    private void subcatchemeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subcatchemeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_subcatchemeMouseEntered

    private void subcatchemeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subcatchemeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_subcatchemeMouseExited

    private void subcatchemestocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subcatchemestocktype
            SCHEMEPROSUBCAT a = new SCHEMEPROSUBCAT();
            a.setVisible(true);
    }//GEN-LAST:event_subcatchemestocktype

    private void imitemproducts1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imitemproducts1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_imitemproducts1MouseEntered

    private void imitemproducts1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imitemproducts1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_imitemproducts1MouseExited

    private void imitemproducts1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imitemproducts1ActionPerformed
            PROREC a = new PROREC();
            a.setVisible(true);

    }//GEN-LAST:event_imitemproducts1ActionPerformed

    private void jMenuItem39EXPCODE(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39EXPCODE
            ROUTERECOVERY a = new ROUTERECOVERY();
            a.setVisible(true);
    }//GEN-LAST:event_jMenuItem39EXPCODE

    private void jmiteminvoice1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoice1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiteminvoice1MouseEntered

    private void jmiteminvoice1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoice1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiteminvoice1MouseExited

    private void jmiteminvoice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiteminvoice1ActionPerformed
            INVOICESETTINGS a = new INVOICESETTINGS();
            a.setVisible(true);
    }//GEN-LAST:event_jmiteminvoice1ActionPerformed

    private void jmitememployee9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee9MouseEntered

    private void jmitememployee9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitememployee9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitememployee9MouseExited

    private void jmitememployee9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitememployee9ActionPerformed
        try {
            dialogeClass.createSettlementType();
        } catch (Exception ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitememployee9ActionPerformed

    private void jmitemcusttype1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcusttype1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemcusttype1MouseEntered

    private void jmitemcusttype1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcusttype1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemcusttype1MouseExited

    private void jmitemcusttype1custtype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcusttype1custtype
        SATELMET a = new SATELMET();
        a.setVisible(true);
    }//GEN-LAST:event_jmitemcusttype1custtype

    private void jmitemtype18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype18MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype18MouseEntered

    private void jmitemtype18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype18MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype18MouseExited

    private void jmitemtype18stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype18stocktype
        try {
            dialogeClass.createNStockTypeWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitemtype18stocktype

    private void jmitemtype19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype19MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype19MouseEntered

    private void jmitemtype19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype19MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype19MouseExited

    private void jmitemtype19stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype19stocktype
        try {
            dialogeClass.createNstockRepCompWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitemtype19stocktype

    private void jmitemtype20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype20MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype20MouseEntered

    private void jmitemtype20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype20MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype20MouseExited

    private void jmitemtype20stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype20stocktype
        try {
            dialogeClass.createNStockTypeCompCatWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmitemtype20stocktype

    private void jmitemtype21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype21MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype21MouseEntered

    private void jmitemtype21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype21MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype21MouseExited

    private void jmitemtype21stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype21stocktype
        try {
            dialogeClass.createNStockCatWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
     }//GEN-LAST:event_jmitemtype21stocktype

    private void jmitemtype22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype22MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype22MouseEntered

    private void jmitemtype22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype22MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype22MouseExited

    private void jmitemtype22stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype22stocktype
            try {

            String s= "D:\\DynamicERP\\DSP001\\NstockRepAll.jasper";
            JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
            JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);


        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jmitemtype22stocktype

    private void jmiteminvoice10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoice10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiteminvoice10MouseEntered

    private void jmiteminvoice10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoice10MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiteminvoice10MouseExited

    private void jmiteminvoice10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiteminvoice10ActionPerformed
        try {
            dialogeClass.createInvPrint_BWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }//GEN-LAST:event_jmiteminvoice10ActionPerformed

    private void jmiteminvoice8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoice8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiteminvoice8MouseEntered

    private void jmiteminvoice8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiteminvoice8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiteminvoice8MouseExited

    private void jmiteminvoice8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiteminvoice8ActionPerformed
        try {
            dialogeClass.createInvPrintWin();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jmiteminvoice8ActionPerformed

    private void jmitemtype23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype23MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype23MouseEntered

    private void jmitemtype23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype23MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype23MouseExited

    private void jmitemtype23stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype23stocktype
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype23stocktype

    private void jmitemtype24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype24MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype24MouseEntered

    private void jmitemtype24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype24MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype24MouseExited

    private void jmitemtype24stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype24stocktype
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype24stocktype

    private void jmitemtype25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype25MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype25MouseEntered

    private void jmitemtype25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype25MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype25MouseExited

    private void jmitemtype25stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype25stocktype
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype25stocktype

    private void jmitemtype26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype26MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype26MouseEntered

    private void jmitemtype26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype26MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype26MouseExited

    private void jmitemtype26stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype26stocktype
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype26stocktype

    private void jmitemtype27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype27MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype27MouseEntered

    private void jmitemtype27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype27MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype27MouseExited

    private void jmitemtype27stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype27stocktype
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype27stocktype

    private void jmitemtype28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype28MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype28MouseEntered

    private void jmitemtype28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype28MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype28MouseExited

    private void jmitemtype28stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype28stocktype
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype28stocktype

    private void jmitemtype29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype29MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype29MouseEntered

    private void jmitemtype29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemtype29MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype29MouseExited

    private void jmitemtype29stocktype(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemtype29stocktype
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemtype29stocktype

    private void jmitemcustbal2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustbal2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemcustbal2MouseEntered

    private void jmitemcustbal2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustbal2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemcustbal2MouseExited

    private void jmitemcustbal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcustbal2ActionPerformed
try {
            
        String s= "D:\\DynamicERP\\DSP001\\sellerbal_payable.jasper";
        JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
          JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);     
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jmitemcustbal2ActionPerformed

    private void jmitemcustbal3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustbal3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemcustbal3MouseEntered

    private void jmitemcustbal3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustbal3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemcustbal3MouseExited

    private void jmitemcustbal3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcustbal3ActionPerformed
try {
            
        String s= "D:\\DynamicERP\\DSP001\\sellerbal_rcable.jasper";
        JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
          JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);     
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jmitemcustbal3ActionPerformed

    private void jmitemcustbal4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustbal4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemcustbal4MouseEntered

    private void jmitemcustbal4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmitemcustbal4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemcustbal4MouseExited

    private void jmitemcustbal4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemcustbal4ActionPerformed
try {
            
        String s= "D:\\DynamicERP\\DSP001\\sellerbal_nozero.jasper";
        JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(s, null, connAA);
          JasperViewer jasperViewer =  new JasperViewer(jasperPrint, false);
            createJasperView(jasperViewer);     
        } catch (Exception e) {
            System.out.println("Exception ===> "+e);
        }
    }//GEN-LAST:event_jmitemcustbal4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main (String args[]) {
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
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MAIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree DMS_PAN;
    private javax.swing.JLabel DSPLOGO;
    private javax.swing.JMenuItem DSP_ADMIN;
    private javax.swing.JTextField add1;
    private javax.swing.JTextField add2;
    private javax.swing.JLabel btnclients;
    private javax.swing.JLabel btncustbalance;
    private javax.swing.JLabel btncustomerledger;
    private javax.swing.JLabel btnemploye;
    private javax.swing.JLabel btnemploye1;
    private javax.swing.JButton btnexit;
    private javax.swing.JLabel btnexp;
    private javax.swing.JLabel btnexp1;
    private javax.swing.JLabel btnfinanceledger;
    private javax.swing.JLabel btnfinanceledger1;
    private javax.swing.JLabel btnrecoveries;
    private javax.swing.JLabel btnvoccreation;
    private javax.swing.JLabel btnvoccreation1;
    private javax.swing.JTextField cell;
    private javax.swing.JTextField dspwelcome;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel ico_product;
    private javax.swing.JLabel ico_purinv;
    private javax.swing.JLabel ico_salesinv;
    private javax.swing.JLabel imghome;
    private javax.swing.JMenuItem imitemproducts;
    private javax.swing.JMenuItem imitemproducts1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator20;
    private javax.swing.JPopupMenu.Separator jSeparator21;
    private javax.swing.JPopupMenu.Separator jSeparator22;
    private javax.swing.JPopupMenu.Separator jSeparator23;
    private javax.swing.JPopupMenu.Separator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JPopupMenu.Separator jSeparator26;
    private javax.swing.JPopupMenu.Separator jSeparator27;
    private javax.swing.JPopupMenu.Separator jSeparator28;
    private javax.swing.JPopupMenu.Separator jSeparator29;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator30;
    private javax.swing.JPopupMenu.Separator jSeparator31;
    private javax.swing.JPopupMenu.Separator jSeparator32;
    private javax.swing.JPopupMenu.Separator jSeparator33;
    private javax.swing.JPopupMenu.Separator jSeparator34;
    private javax.swing.JPopupMenu.Separator jSeparator35;
    private javax.swing.JPopupMenu.Separator jSeparator36;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator38;
    private javax.swing.JPopupMenu.Separator jSeparator39;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator40;
    private javax.swing.JPopupMenu.Separator jSeparator41;
    private javax.swing.JSeparator jSeparator42;
    private javax.swing.JPopupMenu.Separator jSeparator43;
    private javax.swing.JPopupMenu.Separator jSeparator44;
    private javax.swing.JPopupMenu.Separator jSeparator45;
    private javax.swing.JPopupMenu.Separator jSeparator46;
    private javax.swing.JPopupMenu.Separator jSeparator47;
    private javax.swing.JPopupMenu.Separator jSeparator48;
    private javax.swing.JPopupMenu.Separator jSeparator49;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator50;
    private javax.swing.JPopupMenu.Separator jSeparator51;
    private javax.swing.JPopupMenu.Separator jSeparator52;
    private javax.swing.JPopupMenu.Separator jSeparator53;
    private javax.swing.JPopupMenu.Separator jSeparator54;
    private javax.swing.JPopupMenu.Separator jSeparator55;
    private javax.swing.JPopupMenu.Separator jSeparator56;
    private javax.swing.JPopupMenu.Separator jSeparator57;
    private javax.swing.JPopupMenu.Separator jSeparator58;
    private javax.swing.JPopupMenu.Separator jSeparator59;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator60;
    private javax.swing.JPopupMenu.Separator jSeparator61;
    private javax.swing.JPopupMenu.Separator jSeparator62;
    private javax.swing.JPopupMenu.Separator jSeparator63;
    private javax.swing.JPopupMenu.Separator jSeparator64;
    private javax.swing.JPopupMenu.Separator jSeparator65;
    private javax.swing.JPopupMenu.Separator jSeparator66;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JMenu jmclients1;
    private javax.swing.JMenu jmexit;
    private javax.swing.JMenu jmfinance;
    private javax.swing.JMenu jmhr;
    private javax.swing.JMenu jmhr1;
    private javax.swing.JMenuItem jmitembalancesheet;
    private javax.swing.JMenuItem jmitemcomledger;
    private javax.swing.JMenuItem jmitemcomledger1;
    private javax.swing.JMenuItem jmitemcustbal;
    private javax.swing.JMenuItem jmitemcustbal1;
    private javax.swing.JMenuItem jmitemcustbal2;
    private javax.swing.JMenuItem jmitemcustbal3;
    private javax.swing.JMenuItem jmitemcustbal4;
    private javax.swing.JMenuItem jmitemcustledger;
    private javax.swing.JMenuItem jmitemcustledger1;
    private javax.swing.JMenuItem jmitemcustledger2;
    private javax.swing.JMenuItem jmitemcustlist;
    private javax.swing.JMenuItem jmitemcustlist1;
    private javax.swing.JMenuItem jmitemcustrec;
    private javax.swing.JMenuItem jmitemcustrec2;
    private javax.swing.JMenuItem jmitemcustrec3;
    private javax.swing.JMenuItem jmitemcusttype;
    private javax.swing.JMenuItem jmitemcusttype1;
    private javax.swing.JMenuItem jmitemcusttype2;
    private javax.swing.JMenuItem jmitemcusttype3;
    private javax.swing.JMenuItem jmitemcusttype4;
    private javax.swing.JMenuItem jmitememployee;
    private javax.swing.JMenuItem jmitememployee1;
    private javax.swing.JMenuItem jmitememployee2;
    private javax.swing.JMenuItem jmitememployee3;
    private javax.swing.JMenuItem jmitememployee4;
    private javax.swing.JMenuItem jmitememployee5;
    private javax.swing.JMenuItem jmitememployee6;
    private javax.swing.JMenuItem jmitememployee7;
    private javax.swing.JMenuItem jmitememployee8;
    private javax.swing.JMenuItem jmitememployee9;
    private javax.swing.JMenuItem jmitemexit;
    private javax.swing.JMenuItem jmitemexpcode;
    private javax.swing.JMenuItem jmitemexpcode1;
    private javax.swing.JMenuItem jmitemexprec;
    private javax.swing.JMenuItem jmitemexprec1;
    private javax.swing.JMenuItem jmitemfinac;
    private javax.swing.JMenuItem jmitemfinac1;
    private javax.swing.JMenuItem jmiteminvoice;
    private javax.swing.JMenuItem jmiteminvoice1;
    private javax.swing.JMenuItem jmiteminvoice10;
    private javax.swing.JMenuItem jmiteminvoice3;
    private javax.swing.JMenuItem jmiteminvoice4;
    private javax.swing.JMenuItem jmiteminvoice7;
    private javax.swing.JMenuItem jmiteminvoice8;
    private javax.swing.JMenuItem jmiteminvoice9;
    private javax.swing.JMenuItem jmitempayac;
    private javax.swing.JMenuItem jmitempayac1;
    private javax.swing.JMenuItem jmitempaytoseller;
    private javax.swing.JMenuItem jmitempost;
    private javax.swing.JMenuItem jmitempost1;
    private javax.swing.JMenu jmitempur;
    private javax.swing.JMenuItem jmitemrcable;
    private javax.swing.JMenuItem jmitemrcable1;
    private javax.swing.JMenuItem jmitemrecoveries;
    private javax.swing.JMenuItem jmitemtype;
    private javax.swing.JMenuItem jmitemtype1;
    private javax.swing.JMenuItem jmitemtype10;
    private javax.swing.JMenuItem jmitemtype11;
    private javax.swing.JMenuItem jmitemtype12;
    private javax.swing.JMenuItem jmitemtype13;
    private javax.swing.JMenuItem jmitemtype14;
    private javax.swing.JMenuItem jmitemtype15;
    private javax.swing.JMenuItem jmitemtype16;
    private javax.swing.JMenuItem jmitemtype17;
    private javax.swing.JMenuItem jmitemtype18;
    private javax.swing.JMenuItem jmitemtype19;
    private javax.swing.JMenuItem jmitemtype2;
    private javax.swing.JMenuItem jmitemtype20;
    private javax.swing.JMenuItem jmitemtype21;
    private javax.swing.JMenuItem jmitemtype22;
    private javax.swing.JMenuItem jmitemtype23;
    private javax.swing.JMenuItem jmitemtype24;
    private javax.swing.JMenuItem jmitemtype25;
    private javax.swing.JMenuItem jmitemtype26;
    private javax.swing.JMenuItem jmitemtype27;
    private javax.swing.JMenuItem jmitemtype28;
    private javax.swing.JMenuItem jmitemtype29;
    private javax.swing.JMenuItem jmitemtype3;
    private javax.swing.JMenuItem jmitemtype4;
    private javax.swing.JMenuItem jmitemtype5;
    private javax.swing.JMenuItem jmitemtype6;
    private javax.swing.JMenuItem jmitemtype7;
    private javax.swing.JMenuItem jmitemtype8;
    private javax.swing.JMenuItem jmitemtype9;
    private javax.swing.JMenuItem jmitemvoc;
    private javax.swing.JMenu jmpro;
    private javax.swing.JMenuItem jmpurchase;
    private javax.swing.JMenu jmreprots1;
    private javax.swing.JMenu jmroute;
    private javax.swing.JPanel jpanfooter;
    private javax.swing.JLabel link9;
    private javax.swing.JTextField ntn;
    private javax.swing.JPanel pan_menu;
    private javax.swing.JMenuItem subcatcheme;
    private javax.swing.JTextField tfclient;
    private javax.swing.JTextArea tftooltip;
    // End of variables declaration//GEN-END:variables

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
    
}
