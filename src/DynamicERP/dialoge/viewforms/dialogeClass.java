/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.dialoge.viewforms;

import DB.PAK_DB;
import java.awt.Dialog;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import DynamicERP.dialoge.viewforms.ViewForm.*;
import DynamicERP.dialoge.viewforms.ViewFormId.*;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author DynamicSP
 */
public class dialogeClass {
    
    //***************************************AssetRec***************************************
    // Start
    private static JDialog dialogAssetRec=new JDialog();
    public static String code1="",asset="",num1="",com1="";
    public static void createViewAssetWin() throws SQLException{  
        String assetCol[]={"Code","Asset","Number","Company"};
        ViewForm v=new ViewForm(assetCol,"asset");
    
        dialogAssetRec = styleDilog(dialogAssetRec,v);
    }
     public static void disposeViewAssetWin(){  
        dialogAssetRec.dispose();
    }
    //AssetRec End
    //***************************************SchemeRs***************************************
    // Start
    private static JDialog dialogSchemeRs=new JDialog();
    public static String toRs="";//,SchemeRs="",num1="",com1="";
    public static void createViewSchemeRsWin() throws SQLException{  
        String assetCol[]={"To#","Product","UnitDivisor","Opening Date","Clossing Date"};
        ViewForm1 v=new ViewForm1(assetCol,"scheme");
    
        dialogSchemeRs = styleDilog1(dialogSchemeRs,v);
    }
     public static void disposeSchemeRsWin(){  
        dialogSchemeRs.dispose();
    }
    //SchemeRs End
    //***************************************SchemeQty***************************************
    // Start
    private static JDialog dialogSchemeQty=new JDialog();
    public static String toQty="";//,SchemeQty="",num1="",com1="";
    public static void createViewSchemeQtyWin() throws SQLException{  
        String assetCol[]={"To#","Product","UnitDivisor","Opening Date","Clossing Date"};
        ViewForm1 v=new ViewForm1(assetCol,"schemeqty");
    
        dialogSchemeQty = styleDilog1(dialogSchemeQty,v);
    }
     public static void disposeSchemeQtyWin(){  
        dialogSchemeQty.dispose();
    }
    //SchemeQty End
    //***************************************SchemeQtyPro***************************************
    // Start
    private static JDialog dialogSchemeQtyPro=new JDialog();
    public static String toQtyPro="";//,SchemeQtyPro="",num1="",com1="";
    public static void createViewSchemeQtyProWin() throws SQLException{  
        String assetCol[]={"To#","Product","UnitDivisor","Opening Date","Clossing Date"};
        ViewForm1 v=new ViewForm1(assetCol,"schemeqtypro");
        dialogSchemeQtyPro = styleDilog1(dialogSchemeQtyPro,v);
    }
     public static void disposeSchemeQtyProWin(){  
        dialogSchemeQtyPro.dispose();
    }
    //SchemeQtyPro End
    //***************************************SchProCatPro***************************************
    // Start
    private static JDialog dialogSchProCatPro=new JDialog();
    public static String toProCatPro="";//,SchProCatPro="",num1="",com1="";
    public static void createViewSchProCatProWin() throws SQLException{  
        String assetCol[]={"To#","Product","UnitDivisor","Opening Date","Clossing Date"};
        ViewForm1 v=new ViewForm1(assetCol,"schprocatpro");
        dialogSchProCatPro = styleDilog1(dialogSchProCatPro,v);
    }
     public static void disposeSchProCatProWin(){  
        dialogSchProCatPro.dispose();
    }
    //SchProCatPro End
    //***************************************SchemeProCat***************************************
    // Start
    private static JDialog dialogSchemeProCat=new JDialog();
    public static String toSchemeProCat="";//,SchemeProCat="",num1="",com1="";
    public static void createViewSchemeProCatWin() throws SQLException{  
        String assetCol[]={"To#","Product","UnitDivisor","Opening Date","Clossing Date"};
        ViewForm1 v=new ViewForm1(assetCol,"schemeprocat");
        dialogSchemeProCat = styleDilog1(dialogSchemeProCat,v);
    }
    public static void disposeSchemeProCatWin(){  
        dialogSchemeProCat.dispose();
    }
    //SchemeProCat End
    
    //***************************************Slab***************************************
    // Start
    private static JDialog dialogSlab=new JDialog();
    public static String toSlab="";//,Slab="",num1="",com1="";
    public static void createViewSlabWin() throws SQLException{  
        String assetCol[]={"Slab#","From Date","To Date"};
        ViewForm v=new ViewForm(assetCol,"slab");
        dialogSlab = styleDilog(dialogSlab,v);
    }
    public static void disposeSlabWin(){  
        dialogSlab.dispose();
    }
    //Slab End
    //***************************************Role***************************************
    // Start
    private static JDialog dialogRole=new JDialog();
    public static String codeRole="",role="";
    public static void createViewRoleWin() throws SQLException{  
        String assetCol[]={"Code","Role Name"};
        ViewForm v=new ViewForm(assetCol,"role");
        dialogRole = styleDilog(dialogRole,v);
    }
     public static void disposeViewRoleWin(){  
        dialogRole.dispose();
    }
    //stLoc End
    //***************************************CustRec***************************************
    // Start
    private static JDialog dialogCustRec=new JDialog();
    public static String codeCustRec="",nameCustRec="",cellCustRec="",add1CustRec="",custTypeCustRec="",distCustRec="";
    public static void createViewCustRecWin() throws SQLException{  
        String assetCol[]={"Code","Name","Cell","Address","Route","Route Name","Pre Bal"};
        ViewForm11 v=new ViewForm11(assetCol,"custrec");
        dialogCustRec = styleDilog11(dialogCustRec,v);
    }
     public static void disposeCustRecWin(){  
        dialogCustRec.dispose();
    }
    //CustRec End
    //***************************************ProductRec***************************************
    // Start
    private static JDialog dialogProductRec=new JDialog();
    public static String codeProductRec="";public static String rateProductRec="";
    public static void createViewProductRecWin() throws SQLException{  
        String assetCol[]={"Code","Product Type","Category","Name","Size","Line No","Block","Project/Society",
            "Sale Price","Cost Price"};
        ViewForm11 v=new ViewForm11(assetCol,"productrec");
        dialogProductRec = styleDilog11(dialogProductRec,v);
    }
     public static void disposeProductRecWin(){  
        dialogProductRec.dispose();
    }
    //ProductRec End
    //CustRec End
    //***************************************CashDep***************************************
    // Start
    private static JDialog dialogCashDep=new JDialog();
    public static String codeCashDep="";
    public static void createViewCashDepWin() throws SQLException{  
        String assetCol[]={"Code","Employee","Amount","Date"};
        ViewFormId v1=new ViewFormId(assetCol,"cashdep");
        dialogCashDep = styleDilogId(dialogCashDep,v1);
    }
     public static void disposeCashDepWin(){  
        dialogCashDep.dispose();
    }
    //CashDep End
    //***************************************Recovery***************************************
    // Start
    private static JDialog dialogRecovery=new JDialog();
    public static String codeRecovery="";
    public static void createViewRecoveryWin() throws SQLException{  
        String assetCol[]={"Doc Code","Cust Name","Address","Date","SM1","Amount"};
        ViewFormId v=new ViewFormId(assetCol,"recovery");
        dialogRecovery = styleDilogId(dialogRecovery,v);
    }
     public static void disposeRecoveryWin(){  
        dialogRecovery.dispose();
    }
    //Recovery End
    //***************************************Credit***************************************
    // Start
    private static JDialog dialogCredit=new JDialog();
    public static String codeCredit="";
    public static void createViewCreditWin() throws SQLException{  
        String assetCol[]={"Doc Code","Cust Name","Address","Date","SM1","Credit Amount"};
        ViewForm v=new ViewForm(assetCol,"credit");
        dialogCredit = styleDilog(dialogCredit,v);
    }
     public static void disposeCreditWin(){  
        dialogCredit.dispose();
    }
    //Credit End
    //***************************************EmpRec***************************************
    // Start
    private static JDialog dialogEmpRec=new JDialog();
    public static String codeEmpRec="";
    public static void createViewEmpRecWin() throws SQLException{  
        String assetCol[]={"Code","Name","Post","Cell","Address","ActiveType"};
        ViewForm1 v=new ViewForm1(assetCol,"emprec");
        dialogEmpRec = styleDilog1(dialogEmpRec,v);
    }
     public static void disposeEmpRecWin(){  
        dialogEmpRec.dispose();
    }
    //EmpRec End
    //***************************************ExpRec***************************************
    // Start
    private static JDialog dialogExpRec=new JDialog();
    private static JDialog dialogJasperViewerExpRec=new JDialog();
    public static String codeExpRec="";
    public static void createViewExpRecWin() throws SQLException{  
        String assetCol[]={"Doc No","Employee","Date","Amount"};
        ViewFormId1 v=new ViewFormId1(assetCol,"exprec");
        dialogExpRec = styleDilogId1(dialogExpRec,v);
    }
    public static void createJasperView(JasperViewer v) throws SQLException{
        dialogJasperViewerExpRec = styleDilogId1(dialogJasperViewerExpRec,v);
    }
     public static void disposeExpRecWin(){  
        dialogExpRec.dispose();
    }
    //ExpRec End
    //***************************************ROUTEREC***************************************
    // Start
    private static JDialog dialogRouteRec=new JDialog();
    public static String codeRouteRec="",routeRec="";
    public static void createViewRouteRecWin() throws SQLException{  
        String assetCol[]={"Code","Route Rec"};
        ViewForm v=new ViewForm(assetCol,"routerec");
        dialogRouteRec = styleDilog(dialogRouteRec,v);
    }
     public static void disposeViewRouteRecWin(){  
        dialogRouteRec.dispose();
    }
    //RouteRec End
    //***************************************Purchase***************************************
    // Start
    private static JDialog dialogPurchase=new JDialog();
    public static String codePurchase="",Purchase="";
    public static void createViewPurchaseWin() throws SQLException{  
        String assetCol[]={"Invoice #","Ref #","Order Date","Seller Name","Dealer Name","Gross Amount","Discount Rs","Tax Rs","Net Amount","Spl Discount","Other Expance","Net Payable","Paid","Remaining"};
        ViewFormId11 v1=new ViewFormId11(assetCol,"purchase");
        dialogPurchase = styleDilogId11(dialogPurchase,v1);
    }
     public static void disposeViewPurchaseWin(){  
        dialogPurchase.dispose();
    }
    //Purchase End
    //***************************************Sales***************************************
    // Start
    private static JDialog dialogSales=new JDialog();
    public static String codeSales="",Sales="";
    public static void createViewSalesWin() throws SQLException{  
        String assetCol[]={"Invoice #","Ref #","Order Date","Customer Name","Dealer Name","Gross Amount","Discount Rs","Tax Rs","Net Amount","Spl Discount","Other Expance","Net Payable","Paid","Remaining"};
        ViewFormId11 v1=new ViewFormId11(assetCol,"sales");
        dialogSales = styleDilogId11(dialogSales,v1);
    }
     public static void disposeViewSalesWin(){  
        dialogSales.dispose();
    }
    //Sales End
    //***************************************IsSales***************************************
    // Start
    private static JDialog dialogIsSales=new JDialog();
    public static String codeIsSales="",IsSales="";
    public static void createViewIsSalesWin() throws SQLException{  
        String assetCol[]={"Invoice #","Ref #","Order Date","Customer Name","Dealer Name","Gross Amount","Discount Rs","Tax Rs","Net Amount","Spl Discount","Other Expance","Net Payable","Paid","Remaining"};
        ViewFormId11 v1=new ViewFormId11(assetCol,"issales");
        dialogIsSales = styleDilogId11(dialogIsSales,v1);
    }
     public static void disposeViewIsSalesWin(){  
        dialogIsSales.dispose();
    }
    //IsSales End
    //***************************************InstRtn***************************************
    // Start
    private static JDialog dialogInstRtn=new JDialog();
    public static String codeInstRtn="",InstRtn="";
    public static void createViewInstRtnWin() throws SQLException{  
        //DOCNO,REFNO,ODATE,CUSTCODE,DCODE,TNETAMOUNT,SPLRS,OTHEREXP,NETPAYABLE,PAID,REMAINING
        String assetCol[]={"Invoice #","Ref #","Order Date","Customer Name","Dealer Name","Net Amount","Spl Discount","Other Expance","Net Payable","Paid","Remaining"};
        ViewFormId11 v1=new ViewFormId11(assetCol,"instrtn");
        dialogInstRtn = styleDilogId11(dialogInstRtn,v1);
    }
     public static void disposeViewInstRtnWin(){  
        dialogInstRtn.dispose();
    }
    //InstRtn End
    //***************************************SalesOrder***************************************
    // Start
    private static JDialog dialogSalesOrder=new JDialog();
    public static String codeSalesOrder="",SalesOrder="";
    public static void createViewSalesOrderWin() throws SQLException{  
        String assetCol[]={"Invoice #","Ref #","Order Date","Customer Name","Dealer Name","Gross Amount","Discount Rs","Tax Rs","Net Amount","Spl Discount","Other Expance","Net Payable","Paid","Remaining"};
        ViewFormId11 v1=new ViewFormId11(assetCol,"salesorder");
        dialogSalesOrder = styleDilogId11(dialogSalesOrder,v1);
    }
     public static void disposeViewSalesOrderWin(){  
        dialogSalesOrder.dispose();
    }
    //SalesOrder End
    
    //***************************************UserRec***************************************
    // Start
    private static JDialog dialogUserRec=new JDialog();
    public static String codeUserRec="";
    public static void createViewUserRecWin() throws SQLException{  
        String assetCol[]={"Code","Name","Pass","Role"};
        ViewForm1 v=new ViewForm1(assetCol,"user");
        dialogUserRec = styleDilog1(dialogUserRec,v);
    }
     public static void disposeUserRecWin(){  
        dialogUserRec.dispose();
    }
    //UserRec End
    //***************************************Quotation***************************************
    // Start
    private static JDialog dialogQuotation=new JDialog();
    public static String codeQuotation="",Quotation="";
    public static void createViewQuotationWin() throws SQLException{  
        String assetCol[]={"Invoice #","Ref #","Order Date","Customer Name","Dealer Name","Gross Amount","Discount Rs","Tax Rs","Net Amount","Spl Discount","Other Expance","Net Payable","Paid","Remaining"};
        ViewFormId11 v1=new ViewFormId11(assetCol,"quotation");
        dialogQuotation = styleDilogId11(dialogQuotation,v1);
    }
     public static void disposeViewQuotationWin(){  
        dialogQuotation.dispose();
    }
    //Quotation End
    //***************************************SalesRtn***************************************
    // Start
    private static JDialog dialogSalesRtn=new JDialog();
    public static String codeSalesRtn="",SalesRtn="";
    public static void createViewSalesRtnWin() throws SQLException{  
        String assetCol[]={"Invoice #","Ref #","Order Date","Customer Name","Dealer Name","Gross Amount","Discount Rs","Tax Rs","Net Amount","Spl Discount","Other Expance","Net Payable","Paid","Remaining"};
        ViewFormId11 v1=new ViewFormId11(assetCol,"salesrtn");
        dialogSalesRtn = styleDilogId11(dialogSalesRtn,v1);
    }
     public static void disposeViewSalesRtnWin(){  
        dialogSalesRtn.dispose();
    }
    //SalesRtn End
    //***************************************IssueRtn***************************************
    // Start
    private static JDialog dialogIssueRtn=new JDialog();
    public static String codeIssueRtn="",IssueRtn="";
    public static void createViewIssueRtnWin() throws SQLException{  
        String assetCol[]={"Invoice #","Ref #","Order Date","Customer Name","Dealer Name","Gross Amount","Discount Rs","Tax Rs","Net Amount","Spl Discount","Other Expance","Net Payable","Paid","Remaining"};
        ViewFormId11 v1=new ViewFormId11(assetCol,"issuertn");
        dialogIssueRtn = styleDilogId11(dialogIssueRtn,v1);
    }
     public static void disposeViewIssueRtnWin(){  
        dialogIssueRtn.dispose();
    }
    //IssueRtn End
    //***************************************Vouchers***************************************
    // Start
    private static JDialog dialogVouchers=new JDialog();
    public static String codeVouchers="",Vouchers="";
    public static void createViewVouchersWin() throws SQLException{  
//        DOCNO,ODATE,REFNO,DESCR,TD,TC
        String assetCol[]={"Invoice #","Order Date","Refrance No","Description","Debit","Credit"};
        ViewForm1 v1=new ViewForm1(assetCol,"vouchers");
        dialogVouchers = styleDilog1(dialogVouchers,v1);
    }
     public static void disposeViewVouchersWin(){  
        dialogVouchers.dispose();
    }
    //Vouchers End
    //***************************************PaySeller***************************************
    // Start
    private static JDialog dialogPaySeller=new JDialog();
    public static String codePaySeller="",PaySeller="";
    public static void createViewPaySellerWin() throws SQLException{  
//        DOCNO,ODATE,REFNO,DESCR,TD,TC
        String assetCol[]={"Invoice #","Order Date","Refrance No","Description","Debit","Credit"};
        ViewForm1 v1=new ViewForm1(assetCol,"payseller");
        dialogPaySeller = styleDilog1(dialogPaySeller,v1);
    }
     public static void disposeViewPaySellerWin(){  
        dialogPaySeller.dispose();
    }
    //PaySeller End
    //***************************************STTYPEREC***************************************
    // Start
    private static JDialog dialogStTypeRec=new JDialog();
    public static String codeStTypeRec="",stTypeRec="";
    public static void createViewStTypeRecWin() throws SQLException{  
        String assetCol[]={"Code","Stock Type"};
        ViewForm v=new ViewForm(assetCol,"sttyperec");
        dialogStTypeRec = styleDilog(dialogStTypeRec,v);
    }
     public static void disposeViewStTypeRecWin(){  
        dialogStTypeRec.dispose();
    }
    //StTypeRec End
    //***************************************SUBCATREC***************************************
    // Start
    private static JDialog dialogSubCatRec=new JDialog();
    public static String codeSubCatRec="",subCatRec="";
    public static void createViewSubCatRecWin() throws SQLException{  
        String assetCol[]={"Code","Sub Category"};
        ViewForm v=new ViewForm(assetCol,"subcatrec");
        dialogSubCatRec = styleDilog(dialogSubCatRec,v);
    }
     public static void disposeViewSubCatRecWin(){  
        dialogSubCatRec.dispose();
    }
    //StTypeRec End
    //***************************************ZONEREC***************************************
    // Start
    private static JDialog dialogZoneRec=new JDialog();
    public static String codeZoneRec="",zoneRec="";
    public static void createViewZoneRecWin() throws SQLException{  
        String assetCol[]={"Code","Zone Record"};
        ViewForm v=new ViewForm(assetCol,"zonerec");
        dialogZoneRec = styleDilog(dialogZoneRec,v);
    }
     public static void disposeViewZoneRecWin(){  
        dialogZoneRec.dispose();
    }
    //StTypeRec End
    //***************************************CATREC***************************************
    // Start
    private static JDialog dialogCatRec=new JDialog();
    public static String codeCatRec="",catRec="";
    public static void createViewCatRecWin() throws SQLException{  
        String assetCol[]={"Code","Category"};
        ViewForm v=new ViewForm(assetCol,"catrec");
        dialogCatRec = styleDilog(dialogCatRec,v);
    }
     public static void disposeViewCatRecWin(){  
        dialogCatRec.dispose();
    }
    //StTypeRec End
    //***************************************FINACREC***************************************
    // Start
    private static JDialog dialogFinRec=new JDialog();
    public static String codeFinRec="",finRec="",finRecDesc="";
    public static void createViewFinRecWin() throws SQLException{  
        String assetCol[]={"Code","Finance Record","     Description      "};
        ViewForm v=new ViewForm(assetCol,"finrec");
        dialogFinRec = styleDilog(dialogFinRec,v);
    }
     public static void disposeViewFinRecWin(){  
        dialogFinRec.dispose();
    }
    //FinRec End
    //***************************************VANREC***************************************
    // Start
    private static JDialog dialogVanRec=new JDialog();
    public static String codeVanRec="",vanRec="",vanRecDesc="",vanCapacity="";
    public static void createViewVanRecWin() throws SQLException{  
        String assetCol[]={"Code","Van ","Number","Capacity"};
        ViewForm v=new ViewForm(assetCol,"vanrec");
        dialogVanRec = styleDilog(dialogVanRec,v);
    }
     public static void disposeViewVanRecWin(){  
        dialogVanRec.dispose();
    }
    //VanRec End
    //***************************************FIRMREC/DSPCLIENT***************************************
    // Start
    private static JDialog dialogFirmRec=new JDialog();
    public static String codeFirmRec="",firmName="",firmAdd1="",firmAdd2="",firmCell="",firmNtn="";
    public static void createViewFirmRecWin() throws SQLException{  
        String assetCol[]={"Code","Firm Name","Add1","Add2","Cell#","NTN"};
        ViewForm1 v=new ViewForm1(assetCol,"firmrec");
        dialogFirmRec = styleDilog1(dialogFirmRec,v);
    }
     public static void disposeViewFirmRecWin(){  
        dialogFirmRec.dispose();
    }
    //FirmRec End
    //***************************************SUPREC***************************************
    // Start
    private static JDialog dialogSupRec=new JDialog();
    public static String codeSupRec="";//,supName="",supAdd1="",supAdd2="",supCell="",supDist="",supFather="";
    public static void createViewSupRecWin() throws SQLException{  
        String assetCol[]={"Code ","Name","Father Name","Address","Cell","CNIC","Refrance"};
        ViewForm11 v=new ViewForm11(assetCol,"suprec");
        dialogSupRec = styleDilog11(dialogSupRec,v);
    }
     public static void disposeViewSupRecWin(){  
        dialogSupRec.dispose();
    }
    //SupRec End
    //***************************************StLoc***************************************
    // Start
    private static JDialog dialogStLoc=new JDialog();
    public static String codeStLoc="",stLoc="";
    public static void createViewStLocWin() throws SQLException{  
        String assetCol[]={"Code","Block Name"};
        ViewForm v=new ViewForm(assetCol,"stloc");
        dialogStLoc = styleDilog(dialogStLoc,v);
    }
     public static void disposeViewStLocWin(){  
        dialogStLoc.dispose();
    }
    //stLoc End
    //***************************************POSTREC***************************************
    // Start
    private static JDialog dialogPostRec=new JDialog();
    public static String codePostRec="",postRec="";
    public static void createViewPostRecWin() throws SQLException{  
        String assetCol[]={"Code","Desigination / Post"};
        ViewForm v=new ViewForm(assetCol,"postrec");
    
        dialogPostRec = styleDilog(dialogPostRec,v);
    }
     public static void disposeViewPostRecWin(){  
        dialogPostRec.dispose();
    }
    //postRec End
    //***************************************AssetRec***************************************
    // Start
    private static JDialog dialogExpence=new JDialog();
    public static String codeExpence="",expence="";
    public static void createViewExpenceWin() throws SQLException{  
        String assetCol[]={"Code","Expence Name"};
        ViewForm v=new ViewForm(assetCol,"expence");
        dialogExpence = styleDilog(dialogExpence,v);
    }
     public static void disposeViewExpenceWin(){  
        dialogExpence.dispose();
    }
    //AssetRec End
    //***************************************DistRec***************************************
    // Start
    private static JDialog dialogDistRec=new JDialog();
    public static String codeDistRec="",distRec="";
    public static void createViewDistRecWin() throws SQLException{  
        String assetCol[]={"Code","District / Area Name"};
        ViewForm v=new ViewForm(assetCol,"distrec");
        dialogDistRec = styleDilog(dialogDistRec,v);
    }
     public static void disposeViewDistRecWin(){  
        dialogDistRec.dispose();
    }
    //AssetRec End
    //************************************CompRec******************************************
    // Start
   private static JDialog dialogCompRec=new JDialog();
    public static String codeComp="",nameComp="";
    public static void createViewCompWin() throws SQLException{  
        String assetCol[]={"Code","Socity / Project"};
        ViewForm v=new ViewForm(assetCol,"comp");
        dialogCompRec = styleDilog(dialogCompRec,v);
    }
     public static void disposeViewCompWin(){  
        dialogCompRec.dispose();
    }
    //*/
    //CompRec End
    //******************************CustType************************************************
    // Start
    private static JDialog dialogCustTypeRec=new JDialog();
    public static String codeCustType="",nameCustType="";
    public static void createViewCustTypeWin() throws SQLException{  
        String assetCol[]={"Code","Customer Type"};
        ViewForm v1=new ViewForm(assetCol,"custtype");
       dialogCustTypeRec = styleDilog(dialogCustTypeRec,v1);
    }
     public static void disposeViewCustTypeWin(){  
        dialogCustTypeRec.dispose();
    }
    //CompRec End
    //******************************CustType************************************************
    // Start
    private static JDialog dialogCashTypeRec=new JDialog();
    public static String codeCashType="",nameCashType="";
    public static void createViewCashTypeWin() throws SQLException{  
        String assetCol[]={"Code","Cash Type"};
        ViewForm v1=new ViewForm(assetCol,"cashtype");
       dialogCashTypeRec = styleDilog(dialogCashTypeRec,v1);
    }
     public static void disposeViewCashTypeWin(){  
        dialogCashTypeRec.dispose();
    }
    //CompRec End
    

    //******************************************************************************
    //******************************************************************************
    //******************************************************************************

    private static JDialog styleDilog(JDialog tempDialog,ViewForm v) {
        tempDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        tempDialog.setContentPane(v.getContentPane());
        tempDialog.setTitle(v.getTitle());
        tempDialog.setBounds(v.getBounds());
        tempDialog.setVisible(true);
        return tempDialog;
    }
    private static JDialog styleDilog11(JDialog tempDialog,ViewForm11 v) {
        tempDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        tempDialog.setContentPane(v.getContentPane());
        tempDialog.setTitle(v.getTitle());
        tempDialog.setBounds(v.getBounds());
        tempDialog.setVisible(true);
        return tempDialog;
    }
    private static JDialog styleDilog1(JDialog tempDialog,ViewForm1 v) {
        tempDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        tempDialog.setContentPane(v.getContentPane());
        tempDialog.setTitle(v.getTitle());
        tempDialog.setBounds(v.getBounds());
        tempDialog.setVisible(true);
        return tempDialog;
    }
    private static JDialog styleDilogId(JDialog tempDialog,ViewFormId v) {
        tempDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        tempDialog.setContentPane(v.getContentPane());
        tempDialog.setTitle(v.getTitle());
        tempDialog.setBounds(v.getBounds());
        tempDialog.setVisible(true);
        return tempDialog;
    }
    private static JDialog styleDilogId1(JDialog tempDialog,ViewFormId1 v) {
        tempDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        tempDialog.setContentPane(v.getContentPane());
        tempDialog.setTitle(v.getTitle());
        tempDialog.setBounds(v.getBounds());
        tempDialog.setVisible(true);
        return tempDialog;
    }
    private static JDialog styleDilogId11(JDialog tempDialog,ViewFormId11 v) {
        tempDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        tempDialog.setContentPane(v.getContentPane());
        tempDialog.setTitle(v.getTitle());
        tempDialog.setBounds(v.getBounds());
        tempDialog.setVisible(true);
        return tempDialog;
    }

    private static JDialog styleDilogId1(JDialog tempDialog, JasperViewer v) {
        tempDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        tempDialog.setContentPane(v.getContentPane());
        tempDialog.setTitle(v.getTitle());
        tempDialog.setBounds(v.getBounds());
        tempDialog.setVisible(true);
        return tempDialog;
    }

}
