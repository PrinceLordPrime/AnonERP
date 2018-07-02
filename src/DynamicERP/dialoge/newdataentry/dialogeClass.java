/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.dialoge.newdataentry;

import ADMIN.ROLE;
import ADMIN.USERLOGINID;
import DB.PAK_DB;
import DynamicERP.REPORTPARAMETER.ExpiryTill;
import DynamicERP.REPORTPARAMETER.INVPRINTS;
import DynamicERP.REPORTPARAMETER.INVPRINTS_B;
import DynamicERP.REPORTPARAMETER.NSTOCKREPCAT;
import DynamicERP.REPORTPARAMETER.NStockRepType;
import DynamicERP.REPORTPARAMETER.NStockRepTypeCompCat;
import DynamicERP.REPORTPARAMETER.NstockRepComp;
import DynamicERP.REPORTPARAMETER.STKLoadSheet;
import DynamicERP.REPORTPARAMETER.STKLoadSheet_B;
import DynamicERP.REPORTPARAMETER.STOCKREPCATCOMP;
import DynamicERP.REPORTPARAMETER.STOCKREPCOMPCAT;
import java.awt.Dialog;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import DynamicERP.dialoge.viewforms.ViewFormccc.*;
import DynamicERP.dialoge.viewforms.ViewFormId.*;
import DynamicERP.frames.extra.ASSETREC;
import DynamicERP.frames.extra.ASSETTYPE;
import DynamicERP.frames.extra.CASHDEP;
import DynamicERP.frames.extra.CASHTYPE;
import DynamicERP.frames.extra.ROUTEREC;
import DynamicERP.frames.extra.SATELMENTTYPE;
import DynamicERP.frames.extra.VANREC;
import DynamicERP.frames.extra.ZONEREC;
import DynamicERP.frames.ledgers.CUSTOMERLEDGER;
import DynamicERP.frames.ledgers.SELLERSLEDGER;
import DynamicERP.frames.newdataentry.CATREC;
import DynamicERP.frames.newdataentry.CUSTTYPE;
import DynamicERP.frames.newdataentry.EXPENCE;
import DynamicERP.frames.newdataentry.FINACREC;
import DynamicERP.frames.newdataentry.FIRMREC;
import DynamicERP.frames.newdataentry.SUBCAT;
import DynamicERP.frames.newdataentry.POSTREC;
import DynamicERP.frames.newdataentry.COMPANY;
import DynamicERP.frames.newdataentry.CUSTTYPEDISC;
import DynamicERP.frames.newdataentry.DISTREC;
import DynamicERP.frames.newdataentry.EMPINCENTIVE;
import DynamicERP.frames.newdataentry.STTYPEREC;
import DynamicERP.frames.paySeller.PAYSELLER;
import DynamicERP.frames.relationalforms.CUSTREC;
import DynamicERP.frames.relationalforms.EMPREC;
import DynamicERP.frames.relationalforms.EMPTARGET;
import DynamicERP.frames.relationalforms.EXPDEP;
import DynamicERP.frames.relationalforms.PRODUCTREC;
import DynamicERP.frames.relationalforms.RECOVERY;
import DynamicERP.frames.relationalforms.SELLER;
import DynamicERP.frames.recordUpdates.SAILPAID;
import DynamicERP.frames.voucher.VOUCHERS;
/**
 *
 * @author DynamicSP
 */
public class dialogeClass {
     //***************************************ROLE REC***************************************
    // Start
    private static JDialog dialogRoleRec=new JDialog();
    public static void createRoleWin() throws SQLException{  
        ROLE role = new ROLE();
        dialogRoleRec = styleDilog(dialogRoleRec,role);
    }
     public static void disposeRoleWin(){  
        dialogRoleRec.dispose();
    }//ROLE REC End
     //***************************************VAN REC***************************************
    // Start
    private static JDialog dialogVANRec=new JDialog();
    public static void createVANWin() throws SQLException{  
        VANREC role = new VANREC();
        dialogVANRec = styleDilog(dialogVANRec,role);
    }
     public static void disposeVANWin(){  
        dialogVANRec.dispose();
    }//VAN REC End
     //***************************************Cash Type REC***************************************
    // Start
    private static JDialog dialogCashTypeRec=new JDialog();
    public static void createCashTYPEWin() throws SQLException{  
        CASHTYPE cashtype = new CASHTYPE();
        dialogCashTypeRec = styleDilog(dialogCashTypeRec,cashtype);
    }
     public static void disposeCashTypeWin(){  
        dialogCashTypeRec.dispose();
    }//Cash Type REC End
     //***************************************Asset REC***************************************
    // Start
    private static JDialog dialogAssetRec=new JDialog();
    public static void createAssetWin() throws SQLException{  
        ASSETREC asset = new ASSETREC();
        dialogAssetRec = styleDilog(dialogAssetRec,asset);
    }
     public static void disposeAssetWin(){  
        dialogAssetRec.dispose();
    }//ROLE REC End
    //***************************************USER LOGIN ID*************************************
    // Start
    private static JDialog dialogUserIDRec=new JDialog();
    public static void createUserIDWin() throws SQLException, Exception{  
        USERLOGINID userid = new USERLOGINID();
        dialogUserIDRec = styleDilog(dialogUserIDRec,userid);
    }
     public static void disposeUserIDWin(){  
        dialogUserIDRec.dispose();
    }//USER LOGIN ID End
   
    //***************************************AssetTYPE***************************************
    // Start
    private static JDialog dialogBlockRec=new JDialog();
    public static void createAssetTypeWin() throws SQLException{  
        ASSETTYPE block = new ASSETTYPE();
        dialogBlockRec = styleDilog(dialogBlockRec,block);
    }
     public static void disposeAssetTypeWin(){  
        dialogBlockRec.dispose();
    }//BlockRec End
    //***************************************Route***************************************
    // Start
    private static JDialog dialogRouteRec=new JDialog();
    public static void createRouteWin() throws SQLException{  
        ROUTEREC block = new ROUTEREC();
        dialogRouteRec = styleDilog(dialogRouteRec,block);
    }
     public static void disposeRouteWin(){  
        dialogRouteRec.dispose();
    }//Route End
        
    //***************************************EMP_Target***************************************
    // EMP_Target*
    private static JDialog dialogEmpTargetRec=new JDialog();
    public static void createEmpTargetWin() throws SQLException{  
        EMPTARGET emptarget = new EMPTARGET();
        dialogEmpTargetRec = styleDilog(dialogEmpTargetRec,emptarget);
    }
     public static void disposeEmpTargetWin(){  
        dialogEmpTargetRec.dispose();
    }//EMP_Target* End
    //***************************************EMP_Target***************************************
    // EMP_Target*
    private static JDialog dialogEmpIncentive=new JDialog();
    public static void createEmpincentive() throws SQLException{  
        EMPINCENTIVE empincentive = new EMPINCENTIVE();
        dialogEmpIncentive = styleDilog(dialogEmpIncentive,empincentive);
    }
     public static void disposeEmpincentive(){  
        dialogEmpIncentive.dispose();
    }//EMP_Target* End
        
    //***************************************CatRec***************************************
    // Start
    private static JDialog dialogCatRec=new JDialog();
    public static void createCatRecWin() throws SQLException{  
        CATREC block = new CATREC();
        dialogCatRec = styleDilog(dialogCatRec,block);
    }
     public static void disposeCatRecWin(){  
        dialogCatRec.dispose();
    }//CatRec End
    //***************************************CustType***************************************
    // Start
    private static JDialog dialogCustType=new JDialog();
    public static void createCustTypeWin() throws SQLException{  
        CUSTTYPE block = new CUSTTYPE();
        dialogCustType = styleDilog(dialogCustType,block);
    }
     public static void disposeCustTypeWin(){  
        dialogCustType.dispose();
    }//CustType End
    //***************************************ZONE***************************************
    // Start
    private static JDialog dialogZone=new JDialog();
    public static void createZONEWin() throws SQLException{  
        ZONEREC block = new ZONEREC();
        dialogZone = styleDilog(dialogZone,block);
    }
     public static void disposeZONEWin(){  
        dialogZone.dispose();
    }//ZONE End
     
    //***************************************dist-area***************************************
    // Start
    private static JDialog dialogDistrec=new JDialog();
    public static void createDistRecWin() throws SQLException{  
        DISTREC block = new DISTREC();
        dialogDistrec = styleDilog(dialogDistrec,block);
    }
     public static void disposeDistrecWin(){  
        dialogDistrec.dispose();
    }//CustType End
     
    //***************************************STOCK REP PARAMETER***************************************
    // Start
    private static JDialog dialogStockREPRec=new JDialog();
    public static void createStockParameterWin() throws SQLException{  
        STOCKREPCOMPCAT block = new STOCKREPCOMPCAT();
        dialogStockREPRec = styleDilog(dialogStockREPRec,block);
    }
     public static void disposeStockParameterWin(){  
        dialogStockREPRec.dispose();
    }//STOCK REP PARAMETER End
    //***************************************STOCK REP Company PARAMETER***************************************
    // Start
    private static JDialog dialogStockREPTypeCompCatRec=new JDialog();
    public static void createNStockTypeCompCatWin() throws SQLException{  
        NStockRepTypeCompCat block = new NStockRepTypeCompCat();
        dialogStockREPTypeCompCatRec = styleDilog(dialogStockREPTypeCompCatRec,block);
    }
     public static void disposeNStockTypeCompCatWin(){  
        dialogStockREPTypeCompCatRec.dispose();
    }//STOCK REP PARAMETER End
     
    //***************************************STOCK REP Company PARAMETER***************************************
    // Start
    private static JDialog dialogNStockREPTypepRec=new JDialog();
    public static void createNStockTypeWin() throws SQLException{  
        NStockRepType block = new NStockRepType();
        dialogNStockREPTypepRec = styleDilog(dialogNStockREPTypepRec,block);
    }
     public static void disposeNStockTypeWin(){  
        dialogNStockREPTypepRec.dispose();
    }//STOCK REP PARAMETER End
     
    //***************************************STOCK REP PARAMETER***************************************
    // Start
    private static JDialog dialogNstockRepCompRec=new JDialog();
    public static void createNstockRepCompWin() throws SQLException{  
        NstockRepComp block = new NstockRepComp();
        dialogNstockRepCompRec = styleDilog(dialogNstockRepCompRec,block);
    }
     public static void disposeNstockRepCompWin(){  
        dialogNstockRepCompRec.dispose();
    }//STOCK REP PARAMETER End
     
    //***************************************STOCK REP PARAMETER***************************************
    // Start
    private static JDialog dialogStockREPSubCatRec=new JDialog();
    public static void createStockSubCatWin() throws SQLException{  
        STOCKREPCATCOMP block = new STOCKREPCATCOMP();
        dialogStockREPSubCatRec = styleDilog(dialogStockREPSubCatRec,block);
    }
     public static void disposeStockSubCatWin(){  
        dialogStockREPSubCatRec.dispose();
    }//STOCK REP PARAMETER End
     
     
    //***************************************STOCK REP PARAMETER***************************************
    // Start
    private static JDialog dialogStockREPCatRec=new JDialog();
    public static void createNStockCatWin() throws SQLException{  
        NSTOCKREPCAT block = new NSTOCKREPCAT();
        dialogStockREPCatRec = styleDilog(dialogStockREPCatRec,block);
    }
     public static void disposeNStockCatWin(){  
        dialogStockREPCatRec.dispose();
    }//STOCK REP PARAMETER End
     
    //***************************************Expiry Till PARAMETER***************************************
    // Start
    private static JDialog dialogExpiryTillRec=new JDialog();
    public static void createExpiryTillWin() throws SQLException{  
        ExpiryTill block = new ExpiryTill();
        dialogExpiryTillRec = styleDilog(dialogExpiryTillRec,block);
    }
     public static void disposeExpiryTillWin(){  
        dialogExpiryTillRec.dispose();
    }//STOCK REP PARAMETER End
     
    //***************************************LoadSheet PARAMETER***************************************
    // Start
    private static JDialog dialogLoadSheetRec=new JDialog();
    public static void createLoadSheetWin() throws SQLException{  
        STKLoadSheet block = new STKLoadSheet();
        dialogLoadSheetRec = styleDilog(dialogLoadSheetRec,block);
    }
     public static void disposeLoadSheetWin(){  
        dialogLoadSheetRec.dispose();
    }//STOCK REP PARAMETER End
    //***************************************LoadSheetB PARAMETER***************************************
    // Start
    private static JDialog dialogLoadSheetBRec=new JDialog();
    public static void createLoadSheet_BWin() throws SQLException{  
        STKLoadSheet_B block = new STKLoadSheet_B();
        dialogLoadSheetBRec = styleDilog(dialogLoadSheetBRec,block);
    }
     public static void disposeLoadSheet_BWin(){  
        dialogLoadSheetBRec.dispose();
    }//STOCK REP PARAMETER End
    //***************************************Invoice Range Print PARAMETER***************************************
    // Start
    private static JDialog dialogInvoicePara_BRec=new JDialog();
    public static void createInvPrint_BWin() throws SQLException{  
        INVPRINTS_B block = new INVPRINTS_B();
        dialogInvoicePara_BRec = styleDilog(dialogInvoicePara_BRec,block);
    }
     public static void disposeInvPrint_BWin(){  
        dialogInvoicePara_BRec.dispose();
    }//STOCK REP PARAMETER End
    //***************************************Invoice  Print PARAMETER***************************************
    // Start
    private static JDialog dialogInvoiceParaRec=new JDialog();
    public static void createInvPrintWin() throws SQLException{  
        INVPRINTS block = new INVPRINTS();
        dialogInvoiceParaRec = styleDilog(dialogInvoiceParaRec,block);
    }
     public static void disposeInvPrintWin(){  
        dialogInvoiceParaRec.dispose();
    }//STOCK REP PARAMETER End
     
    //***************************************Type Discount***************************************
    // Start
    private static JDialog dialogTypeDisc=new JDialog();
    public static void createTypeDISC() throws SQLException{  
        CUSTTYPEDISC typedisc = new CUSTTYPEDISC();
        dialogDistrec = styleDilog(dialogDistrec,typedisc);
    }
     public static void disposeTypeDISC(){  
        dialogDistrec.dispose();
    }//CustType End
     
    //***************************************Settlement Type ***************************************
    // Start
    private static JDialog dialogSettlementType=new JDialog();
    public static void createSettlementType() throws SQLException{  
        SATELMENTTYPE typedisc = new SATELMENTTYPE();
        dialogDistrec = styleDilog(dialogDistrec,typedisc);
    }
     public static void disposeSettlementType(){  
        dialogDistrec.dispose();
    }//Settlement Type End
     
    //***************************************Expence***************************************
    // Start
    private static JDialog dialogExpence=new JDialog();
    public static void createExpenceWin() throws SQLException{  
        EXPENCE block = new EXPENCE();
        dialogExpence = styleDilog(dialogExpence,block);
    }
     public static void disposeExpenceWin(){  
        dialogExpence.dispose();
    }//Expence End
    //***************************************FinanRec***************************************
    // Start
    private static JDialog dialogFinanRec=new JDialog();
    public static void createFinanRecWin() throws SQLException{  
        FINACREC block = new FINACREC();
        dialogFinanRec = styleDilog(dialogFinanRec,block);
    }
     public static void disposeFinanRecWin(){  
        dialogFinanRec.dispose();
    }//FinanRec End
    //***************************************FirmRec***************************************
    // Start
    private static JDialog dialogFirmRec=new JDialog();
    public static void createFirmRecWin() throws SQLException{  
        FIRMREC block = new FIRMREC();
        dialogFirmRec = styleDilog(dialogFirmRec,block);
    }
     public static void disposeFirmRecWin(){  
        dialogFirmRec.dispose();
    }//FirmRec End
    //***************************************Sub Category***************************************
    // Start
    private static JDialog dialogLine=new JDialog();
    public static void createLineWin() throws SQLException{  
        SUBCAT block = new SUBCAT();
        dialogLine = styleDilog(dialogLine,block);
    }
    public static void disposeLineWin(){  
        dialogLine.dispose();
    }//Sub Category End
    //***************************************PostRec***************************************
    // Start
    private static JDialog dialogPostRec=new JDialog();
    public static void createPostRecWin() throws SQLException{  
        POSTREC block = new POSTREC();
        dialogPostRec = styleDilog(dialogPostRec,block);
    }
    public static void disposePostRecWin(){  
        dialogPostRec.dispose();
    }//FirmRec End
    //***************************************Scocity***************************************
    // Start
    private static JDialog dialogScocity=new JDialog();
    public static void createScocityWin() throws SQLException{  
        COMPANY block = new COMPANY();
        dialogScocity = styleDilog(dialogScocity,block);
    }
    public static void disposeScocityWin(){  
        dialogScocity.dispose();
    }//FirmRec End
     
    //***************************************StTypeRec***************************************
    // Start
    private static JDialog dialogStTypeRec=new JDialog();
    public static void createStTypeRecWin() throws SQLException{  
        STTYPEREC block = new STTYPEREC();
        dialogStTypeRec = styleDilog(dialogStTypeRec,block);
    }
    public static void disposeStTypeRecWin(){  
        dialogStTypeRec.dispose();
    }//FirmRec End
    //***************************************CustRec***************************************
    // Start
    private static JDialog dialogCustRec=new JDialog();
    public static void createCustRecWin() throws SQLException{  
        CUSTREC block = new CUSTREC();
        dialogCustRec = styleDilog(dialogCustRec,block);
    }
    public static void disposeCustRecWin(){  
        dialogCustRec.dispose();
    }//FirmRec End
    //***************************************EmpRec***************************************
    // Start
    private static JDialog dialogEmpRec=new JDialog();
    public static void createEmpRecWin() throws SQLException, Exception{  
        EMPREC b = new EMPREC();
        dialogEmpRec = styleDilog(dialogEmpRec,b);
    }
    public static void disposeEmpRecWin(){  
        dialogEmpRec.dispose();
    }//FirmRec End
    //***************************************Cash Deposit***************************************
    // Start
    private static JDialog dialogcashdepositRec=new JDialog();
    public static void createcashdepositWin() throws SQLException, Exception{  
        CASHDEP b = new CASHDEP();
        dialogcashdepositRec = styleDilog(dialogcashdepositRec,b);
    }
    public static void disposecashdepositWin(){  
        dialogcashdepositRec.dispose();
    }//Cash Deposit End
    //***************************************ExpDep***************************************
    // Start
    public static JDialog dialogExpDep=new JDialog();
    public static void setModelExpDepWin(boolean f){  
        dialogExpDep.setModal(f);
    }
    public static void createExpDepWin() throws SQLException, Exception{  
        EXPDEP block = new EXPDEP();
        dialogExpDep = styleDilog(dialogExpDep,block);
    }
    public static void disposeExpDepWin(){  
        dialogExpDep.dispose();
    }//FirmRec End
     
    //***************************************ProductRec***************************************
    // Start
    private static JDialog dialogProductRec=new JDialog();
    public static void createProductRecWin() throws SQLException, Exception{  
        PRODUCTREC block = new PRODUCTREC();
        dialogProductRec = styleDilog(dialogProductRec,block);
    }
    public static void disposeProductRecWin(){  
        dialogProductRec.dispose();
    }//FirmRec End
    //***************************************Recovery   ***************************************
    // Start
    private static JDialog dialogRecovery=new JDialog();
    public static void createRecoveryWin() throws SQLException, Exception{  
        RECOVERY block = new RECOVERY();
        dialogRecovery = styleDilog(dialogRecovery,block);
    }
    public static void disposeRecoveryWin(){  
        dialogRecovery.dispose();
    }//Recovery End
    //
    //***************************************   Customers Ledger   ***************************************
    // Start
    private static JDialog dialogCustLeg=new JDialog();
    public static void createCustLegWin() throws SQLException, Exception{  
        CUSTOMERLEDGER block = new CUSTOMERLEDGER();
        dialogCustLeg = styleDilog(dialogCustLeg,block);
        System.out.println("IN CUSTOMERLEDGER");
    }
    public static void disposeCustLegWin(){  
        dialogCustLeg.dispose();
    }//Customers Ledger End
    
    //***************************************Cash - Credit Entry   ***************************************
    // Start
    private static JDialog dialogCashCreditEntry=new JDialog();
    public static void createCashCreditWin() throws SQLException, Exception{  
        SAILPAID cashcredit = new SAILPAID();
        dialogCashCreditEntry = styleDilog(dialogCashCreditEntry,cashcredit);
    }
    public static void disposeCashCreditWin(){  
        dialogCashCreditEntry.dispose();
    }//Cash - Credit Entry End
    
    //***************************************Seller***************************************
    // Start
    private static JDialog dialogSeller=new JDialog();
    public static void createSellerWin() throws SQLException, Exception{  
        SELLER block = new SELLER();
        dialogSeller = styleDilog(dialogSeller,block);
    }
    public static void disposeSellerWin(){  
        dialogSeller.dispose();
    }//Seller End
    //***************************************Vouchers***************************************
    // Start
    private static JDialog dialogVouchers=new JDialog();
    public static void createVouchersWin() throws SQLException, Exception{  
        VOUCHERS block = new VOUCHERS();
        dialogVouchers = styleDilog(dialogVouchers,block);
    }
    public static void disposeVouchersWin(){  
        dialogVouchers.dispose();
    }//Vouchers End
    //***************************************Payseller***************************************
    // Start
    private static JDialog dialogPayseller=new JDialog();
    public static void createPaysellerWin() throws SQLException, Exception{  
        PAYSELLER block = new PAYSELLER();
        dialogPayseller = styleDilog(dialogPayseller,block);
    }
    public static void disposePaysellerWin(){  
        dialogPayseller.dispose();
    }//Payseller End
    
    //***************************************Payseller***************************************
    // Start
    private static JDialog dialogSellersLedgers=new JDialog();
    public static void createSellersLedgersWin() throws SQLException, Exception{  
        
        SELLERSLEDGER block = new SELLERSLEDGER();
        dialogSellersLedgers = styleDilog(dialogSellersLedgers,block);
    }
    public static void disposeSellersLedgersWin(){  
        dialogSellersLedgers.dispose();
    }//Payseller End
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
        private static JDialog styleDilog(JDialog tempDialog,javax.swing.JFrame v) {
        tempDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        tempDialog.setContentPane(v.getContentPane());
        tempDialog.setTitle(v.getTitle());
        tempDialog.setBounds(v.getBounds());
        tempDialog.setVisible(true);
        return tempDialog;
    }
}
