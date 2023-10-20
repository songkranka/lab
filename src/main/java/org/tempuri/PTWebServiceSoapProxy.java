package org.tempuri;

public class PTWebServiceSoapProxy implements org.tempuri.PTWebServiceSoap {
  private String _endpoint = null;
  private org.tempuri.PTWebServiceSoap pTWebServiceSoap = null;
  
  public PTWebServiceSoapProxy() {
    _initPTWebServiceSoapProxy();
  }
  
  public PTWebServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initPTWebServiceSoapProxy();
  }
  
  private void _initPTWebServiceSoapProxy() {
    try {
      pTWebServiceSoap = (new org.tempuri.PTWebServiceLocator()).getPTWebServiceSoap();
      if (pTWebServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)pTWebServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)pTWebServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (pTWebServiceSoap != null)
      ((javax.xml.rpc.Stub)pTWebServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.PTWebServiceSoap getPTWebServiceSoap() {
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap;
  }
  
  public java.lang.String AT_ModifyLupeGoodSale(org.tempuri.AT_ModifyLupeGoodSaleDt dt, java.lang.String sOLDComp) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_ModifyLupeGoodSale(dt, sOLDComp);
  }
  
  public org.tempuri.AT_OrderAutoCalMaxnetronDashboardResponseAT_OrderAutoCalMaxnetronDashboardResult AT_OrderAutoCalMaxnetronDashboard(int iTYPE, java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sDepotBrnName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_OrderAutoCalMaxnetronDashboard(iTYPE, sOLDComp, sDepotBrn, sDepotBrnName);
  }
  
  public org.tempuri.AT_OrderAutoCalCastrolDashboardResponseAT_OrderAutoCalCastrolDashboardResult AT_OrderAutoCalCastrolDashboard(int iTYPE, java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sDepotBrnName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_OrderAutoCalCastrolDashboard(iTYPE, sOLDComp, sDepotBrn, sDepotBrnName);
  }
  
  public org.tempuri.AT_GetLupeBrnNotSetResponseAT_GetLupeBrnNotSetResult AT_GetLupeBrnNotSet() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetLupeBrnNotSet();
  }
  
  public java.lang.String AT_SetlupeLPG(java.lang.String lpgCode, java.lang.String oilCode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_SetlupeLPG(lpgCode, oilCode);
  }
  
  public org.tempuri.AT_GetBrNameCodeLupeResponseAT_GetBrNameCodeLupeResult AT_GetBrNameCodeLupe(java.lang.String sOLDComp, java.lang.String sDepotBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetBrNameCodeLupe(sOLDComp, sDepotBrn);
  }
  
  public org.tempuri.AT_OrderAutoCalPowerDashboardResponseAT_OrderAutoCalPowerDashboardResult AT_OrderAutoCalPowerDashboard(int iTYPE, java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sDepotBrnName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_OrderAutoCalPowerDashboard(iTYPE, sOLDComp, sDepotBrn, sDepotBrnName);
  }
  
  public java.lang.String LDAP_VALIDATE_USER(java.lang.String userID) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.LDAP_VALIDATE_USER(userID);
  }
  
  public java.lang.String LDAP_ResetPassword(java.lang.String userID, java.lang.String oldPassword, java.lang.String newPassword) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.LDAP_ResetPassword(userID, oldPassword, newPassword);
  }
  
  public org.tempuri.ActionResult PTHR_EmployeeDataInsert(java.lang.String empcode_creator, org.tempuri.Pthr_EmployeeDataObj pthrEmpObj, org.tempuri.Ptref_EmpObj ptrefEmpObj) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.PTHR_EmployeeDataInsert(empcode_creator, pthrEmpObj, ptrefEmpObj);
  }
  
  public org.tempuri.ActionResult PTHR_EmployeeDataUpdate(java.lang.String empcode_modifier, org.tempuri.Pthr_EmployeeDataObj pthrEmpObj, org.tempuri.Ptref_EmpObj ptrefEmpObj) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.PTHR_EmployeeDataUpdate(empcode_modifier, pthrEmpObj, ptrefEmpObj);
  }
  
  public org.tempuri.Supply_GetFinanceResponseSupply_GetFinanceResult supply_GetFinance(java.lang.String sSupplier, java.lang.String sComp, java.lang.String sBrn, java.lang.String sDate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.supply_GetFinance(sSupplier, sComp, sBrn, sDate);
  }
  
  public boolean supply_UpdateAdjust(org.tempuri.Supply_UpdateAdjustDst dst, java.lang.String sSupplier, java.lang.String sComp, java.lang.String sBrn, java.lang.String sDate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.supply_UpdateAdjust(dst, sSupplier, sComp, sBrn, sDate);
  }
  
  public java.lang.String setupLoan(java.lang.String jsonText) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.setupLoan(jsonText);
  }
  
  public java.lang.String cancelSetupLoan(java.lang.String jsonText) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.cancelSetupLoan(jsonText);
  }
  
  public java.lang.String validateLoan(java.lang.String jsonText) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.validateLoan(jsonText);
  }
  
  public java.lang.String updateInfPaymentSuccess(java.lang.String flag, java.lang.String inBrn, java.lang.String inNo) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.updateInfPaymentSuccess(flag, inBrn, inNo);
  }
  
  public java.lang.String updateInfPaymentFailed(java.lang.String remark, java.lang.String inBrn, java.lang.String inNo) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.updateInfPaymentFailed(remark, inBrn, inNo);
  }
  
  public java.lang.String PUN_SELL_GET_GL_DATA(java.lang.String punSellDataInterfaceAxJSON) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.PUN_SELL_GET_GL_DATA(punSellDataInterfaceAxJSON);
  }
  
  public java.lang.String PUN_BUY_GET_GL_DATA(java.lang.String punBuyDataInterfaceAxJSON, java.lang.String countListPun, java.lang.String countDoc, java.lang.String payeeCode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.PUN_BUY_GET_GL_DATA(punBuyDataInterfaceAxJSON, countListPun, countDoc, payeeCode);
  }
  
  public java.lang.String PUN_BUY_InterfaceAX(java.lang.String periodDDMMYYYY, java.lang.String ledgerJournalTransImportJSON, java.lang.String flagVoucher, java.lang.String totalCredit, java.lang.String documentDateLast) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.PUN_BUY_InterfaceAX(periodDDMMYYYY, ledgerJournalTransImportJSON, flagVoucher, totalCredit, documentDateLast);
  }
  
  public java.lang.String PUN_SELL_InterfaceAX(java.lang.String periodDDMMYYYY, java.lang.String ledgerJournalTransImportJSON) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.PUN_SELL_InterfaceAX(periodDDMMYYYY, ledgerJournalTransImportJSON);
  }
  
  public java.lang.String LDAP_GET_ALL_USER() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.LDAP_GET_ALL_USER();
  }
  
  public java.lang.String LDAP_USER_AUTHEN(java.lang.String userID, java.lang.String password) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.LDAP_USER_AUTHEN(userID, password);
  }
  
  public java.lang.String LDAP_HRIS_USER_AUTHEN(java.lang.String userID, java.lang.String password) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.LDAP_HRIS_USER_AUTHEN(userID, password);
  }
  
  public java.lang.String LDAP_FIND_USER_BY_DISPLAYNAME(java.lang.String displayName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.LDAP_FIND_USER_BY_DISPLAYNAME(displayName);
  }
  
  public java.lang.String unitCode_PUN(java.lang.String userID, java.lang.String password) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.unitCode_PUN(userID, password);
  }
  
  public java.lang.String AR_PunTaxSale(java.lang.String jsonTextHD, java.lang.String jsonTextDtl) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AR_PunTaxSale(jsonTextHD, jsonTextDtl);
  }
  
  public boolean AT_CalDayForWebOrder(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sStationbrn, double dRotationPolicy, int iAverageSell, int iAheadago) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_CalDayForWebOrder(sOLDComp, sDepotBrn, sStationbrn, dRotationPolicy, iAverageSell, iAheadago);
  }
  
  public org.tempuri.AT_GetRotationdayResponseAT_GetRotationdayResult AT_GetRotationday(java.lang.String sOLDComp, java.lang.String sDepotBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetRotationday(sOLDComp, sDepotBrn);
  }
  
  public java.lang.String AT_EditRotationDay(org.tempuri.AT_EditRotationDayDt dt, java.lang.String sOLDComp, java.lang.String sDepotBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_EditRotationDay(dt, sOLDComp, sDepotBrn);
  }
  
  public org.tempuri.AT_GetDayAvgSellResponseAT_GetDayAvgSellResult AT_GetDayAvgSell(java.lang.String sOLDComp, java.lang.String sDepotBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetDayAvgSell(sOLDComp, sDepotBrn);
  }
  
  public java.lang.String AT_EditDayAvgSell(org.tempuri.AT_EditDayAvgSellDt dt, java.lang.String sOLDComp, java.lang.String sDepotBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_EditDayAvgSell(dt, sOLDComp, sDepotBrn);
  }
  
  public org.tempuri.AT_GetdayByBranchResponseAT_GetdayByBranchResult AT_GetdayByBranch(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sBranch) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetdayByBranch(sOLDComp, sDepotBrn, sBranch);
  }
  
  public org.tempuri.AT_GetdayByBranchLPGResponseAT_GetdayByBranchLPGResult AT_GetdayByBranchLPG(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sBranch) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetdayByBranchLPG(sOLDComp, sDepotBrn, sBranch);
  }
  
  public java.lang.String AT_EditDayByBranch(org.tempuri.AT_EditDayByBranchDt dt, java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sBranch) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_EditDayByBranch(dt, sOLDComp, sDepotBrn, sBranch);
  }
  
  public java.lang.String AT_EditDayByBranchLPG(org.tempuri.AT_EditDayByBranchLPGDt dt, java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sBranch) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_EditDayByBranchLPG(dt, sOLDComp, sDepotBrn, sBranch);
  }
  
  public java.lang.String AT_InsertDayByBranchLPG(org.tempuri.AT_InsertDayByBranchLPGDt dt, java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sBranch) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertDayByBranchLPG(dt, sOLDComp, sDepotBrn, sBranch);
  }
  
  public org.tempuri.AT_GetBrNameCodeResponseAT_GetBrNameCodeResult AT_GetBrNameCode(java.lang.String sOLDComp, java.lang.String sDepotBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetBrNameCode(sOLDComp, sDepotBrn);
  }
  
  public org.tempuri.AT_GetLPGBrNameCodeResponseAT_GetLPGBrNameCodeResult AT_GetLPGBrNameCode() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetLPGBrNameCode();
  }
  
  public org.tempuri.AT_LPGListResponseAT_LPGListResult AT_LPGList() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_LPGList();
  }
  
  public org.tempuri.AT_OrderAutoCalLPGResponseAT_OrderAutoCalLPGResult AT_OrderAutoCalLPG(int iTYPE) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_OrderAutoCalLPG(iTYPE);
  }
  
  public java.lang.String AT_InsertCompleteCalcLPG(java.lang.String sOLDComp, java.lang.String sDepotBrn, org.tempuri.AT_InsertCompleteCalcLPGODTB oDTB, java.lang.String sFileName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertCompleteCalcLPG(sOLDComp, sDepotBrn, oDTB, sFileName);
  }
  
  public org.tempuri.AT_BrowseAutoCalLPGResponseAT_BrowseAutoCalLPGResult AT_BrowseAutoCalLPG(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sStatus) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_BrowseAutoCalLPG(sOLDComp, sDepotBrn, sStatus);
  }
  
  public org.tempuri.AT_PrintToStationLPGResponseAT_PrintToStationLPGResult AT_PrintToStationLPG(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String dtRPTdate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_PrintToStationLPG(sOLDComp, sDepotBrn, dtRPTdate);
  }
  
  public boolean AT_CreateNewWebOrderLPG(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.util.Calendar dtRPTdate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_CreateNewWebOrderLPG(sOLDComp, sDepotBrn, dtRPTdate);
  }
  
  public org.tempuri.AT_OrderAutoCalMaxnetronResponseAT_OrderAutoCalMaxnetronResult AT_OrderAutoCalMaxnetron(int iTYPE, java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sType) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_OrderAutoCalMaxnetron(iTYPE, sOLDComp, sDepotBrn, sType);
  }
  
  public org.tempuri.AT_OrderAutoCalPowerJetResponseAT_OrderAutoCalPowerJetResult AT_OrderAutoCalPowerJet(int iTYPE, java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sType) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_OrderAutoCalPowerJet(iTYPE, sOLDComp, sDepotBrn, sType);
  }
  
  public org.tempuri.AT_GetBrnLupeConfigResponseAT_GetBrnLupeConfigResult AT_GetBrnLupeConfig(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String brnCode, java.lang.String sCommand) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetBrnLupeConfig(sOLDComp, sDepotBrn, brnCode, sCommand);
  }
  
  public org.tempuri.AT_GetLupeNameCodeResponseAT_GetLupeNameCodeResult AT_GetLupeNameCode(java.lang.String sCode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetLupeNameCode(sCode);
  }
  
  public java.lang.String AT_InsertAutoLupe(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String brnCode, java.lang.String brnName, java.lang.String lupeCode, java.lang.String lupeName, java.lang.String lupeType, java.lang.String sCmd) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertAutoLupe(sOLDComp, sDepotBrn, brnCode, brnName, lupeCode, lupeName, lupeType, sCmd);
  }
  
  public java.lang.String AT_ModifyAutoLupe(org.tempuri.AT_ModifyAutoLupeDt dt, java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sBranch) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_ModifyAutoLupe(dt, sOLDComp, sDepotBrn, sBranch);
  }
  
  public org.tempuri.AT_GetLupeNameCodeForEditResponseAT_GetLupeNameCodeForEditResult AT_GetLupeNameCodeForEdit(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sCode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetLupeNameCodeForEdit(sOLDComp, sDepotBrn, sCode);
  }
  
  public java.lang.String AT_ModifyAutoLupeDepot(org.tempuri.AT_ModifyAutoLupeDepotDt dt, java.lang.String sOLDComp, java.lang.String sDepotBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_ModifyAutoLupeDepot(dt, sOLDComp, sDepotBrn);
  }
  
  public org.tempuri.AT_OrderAutoCalCastrolResponseAT_OrderAutoCalCastrolResult AT_OrderAutoCalCastrol(int iTYPE, java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sType) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_OrderAutoCalCastrol(iTYPE, sOLDComp, sDepotBrn, sType);
  }
  
  public java.lang.String AT_InsertCompleteCalcCastrol(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sDepotBrnName, org.tempuri.AT_InsertCompleteCalcCastrolODTB oDTB, java.lang.String sFileName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertCompleteCalcCastrol(sOLDComp, sDepotBrn, sDepotBrnName, oDTB, sFileName);
  }
  
  public java.lang.String AT_InsertCompleteCalcPowerJet(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sDepotBrnName, org.tempuri.AT_InsertCompleteCalcPowerJetODTB oDTB, java.lang.String sFileName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertCompleteCalcPowerJet(sOLDComp, sDepotBrn, sDepotBrnName, oDTB, sFileName);
  }
  
  public java.lang.String AT_InsertCompleteCalcMaxnetron(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sDepotBrnName, org.tempuri.AT_InsertCompleteCalcMaxnetronODTB oDTB, java.lang.String sFileName, java.lang.String sVenderCode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertCompleteCalcMaxnetron(sOLDComp, sDepotBrn, sDepotBrnName, oDTB, sFileName, sVenderCode);
  }
  
  public org.tempuri.AT_PrintToStationConResponseAT_PrintToStationConResult AT_PrintToStationCon(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String dtRPTdate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_PrintToStationCon(sOLDComp, sDepotBrn, dtRPTdate);
  }
  
  public org.tempuri.AT_PrintToStationLPGConResponseAT_PrintToStationLPGConResult AT_PrintToStationLPGCon(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String dtRPTdate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_PrintToStationLPGCon(sOLDComp, sDepotBrn, dtRPTdate);
  }
  
  public org.tempuri.AT_PrintToStationCastrolConResponseAT_PrintToStationCastrolConResult AT_PrintToStationCastrolCon(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String dtRPTdate, java.lang.String sVendor) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_PrintToStationCastrolCon(sOLDComp, sDepotBrn, dtRPTdate, sVendor);
  }
  
  public org.tempuri.AT_PrintToStationCastrolSAPResponseAT_PrintToStationCastrolSAPResult AT_PrintToStationCastrolSAP(org.tempuri.AT_PrintToStationCastrolSAPODTB oDTB, java.lang.String sType, java.lang.String ptBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_PrintToStationCastrolSAP(oDTB, sType, ptBrn);
  }
  
  public org.tempuri.AT_PrintToStationPowerJetConResponseAT_PrintToStationPowerJetConResult AT_PrintToStationPowerJetCon(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String dtRPTdate, java.lang.String sVendor) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_PrintToStationPowerJetCon(sOLDComp, sDepotBrn, dtRPTdate, sVendor);
  }
  
  public org.tempuri.AT_PrintToStationPowerJetSAPResponseAT_PrintToStationPowerJetSAPResult AT_PrintToStationPowerJetSAP(org.tempuri.AT_PrintToStationPowerJetSAPODTB oDTB, java.lang.String sType, java.lang.String ptBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_PrintToStationPowerJetSAP(oDTB, sType, ptBrn);
  }
  
  public java.lang.String AT_TestToStag(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String dtRPTdate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_TestToStag(sOLDComp, sDepotBrn, dtRPTdate);
  }
  
  public org.tempuri.AT_PrintToStationMaxnetronConResponseAT_PrintToStationMaxnetronConResult AT_PrintToStationMaxnetronCon(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String dtRPTdate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_PrintToStationMaxnetronCon(sOLDComp, sDepotBrn, dtRPTdate);
  }
  
  public org.tempuri.AT_PrintToStationMaxnetronSAPResponseAT_PrintToStationMaxnetronSAPResult AT_PrintToStationMaxnetronSAP(org.tempuri.AT_PrintToStationMaxnetronSAPODTB oDTB, java.lang.String sType, java.lang.String ptBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_PrintToStationMaxnetronSAP(oDTB, sType, ptBrn);
  }
  
  public org.tempuri.AT_InsertCompleteCalcPrintResponseAT_InsertCompleteCalcPrintResult AT_InsertCompleteCalcPrint(java.lang.String sOLDComp, java.lang.String sDepotBrn, org.tempuri.AT_InsertCompleteCalcPrintODTB oDTB, java.lang.String sFileName, java.lang.String sBrnName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertCompleteCalcPrint(sOLDComp, sDepotBrn, oDTB, sFileName, sBrnName);
  }
  
  public org.tempuri.AT_InsertCompleteCalcLPGPrintResponseAT_InsertCompleteCalcLPGPrintResult AT_InsertCompleteCalcLPGPrint(java.lang.String sOLDComp, java.lang.String sDepotBrn, org.tempuri.AT_InsertCompleteCalcLPGPrintODTB oDTB, java.lang.String sFileName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertCompleteCalcLPGPrint(sOLDComp, sDepotBrn, oDTB, sFileName);
  }
  
  public org.tempuri.AT_InsertCompleteCalcPowerJetPrintResponseAT_InsertCompleteCalcPowerJetPrintResult AT_InsertCompleteCalcPowerJetPrint(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sDepotBrnName, org.tempuri.AT_InsertCompleteCalcPowerJetPrintODTB oDTB, java.lang.String sFileName, java.lang.String sVendorCode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertCompleteCalcPowerJetPrint(sOLDComp, sDepotBrn, sDepotBrnName, oDTB, sFileName, sVendorCode);
  }
  
  public org.tempuri.AT_InsertCompleteCalcCastrolPrintResponseAT_InsertCompleteCalcCastrolPrintResult AT_InsertCompleteCalcCastrolPrint(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sDepotBrnName, org.tempuri.AT_InsertCompleteCalcCastrolPrintODTB oDTB, java.lang.String sFileName, java.lang.String sVendorCode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertCompleteCalcCastrolPrint(sOLDComp, sDepotBrn, sDepotBrnName, oDTB, sFileName, sVendorCode);
  }
  
  public org.tempuri.AT_InsertCompleteCalcMaxnetronPrintResponseAT_InsertCompleteCalcMaxnetronPrintResult AT_InsertCompleteCalcMaxnetronPrint(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sDepotBrnName, org.tempuri.AT_InsertCompleteCalcMaxnetronPrintODTB oDTB, java.lang.String sFileName, java.lang.String sVenderCode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertCompleteCalcMaxnetronPrint(sOLDComp, sDepotBrn, sDepotBrnName, oDTB, sFileName, sVenderCode);
  }
  
  public org.tempuri.AT_GetLupeMasterResponseAT_GetLupeMasterResult AT_GetLupeMaster() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetLupeMaster();
  }
  
  public org.tempuri.AT_OrderAutoCalReviseResponseAT_OrderAutoCalReviseResult AT_OrderAutoCalRevise(int iTYPE, java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sType) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_OrderAutoCalRevise(iTYPE, sOLDComp, sDepotBrn, sType);
  }
  
  public org.tempuri.AT_InsertCompleteCalcRevisePrintResponseAT_InsertCompleteCalcRevisePrintResult AT_InsertCompleteCalcRevisePrint(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sDepotBrnName, org.tempuri.AT_InsertCompleteCalcRevisePrintODTB oDTB, java.lang.String sFileName, java.lang.String sVendorCode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertCompleteCalcRevisePrint(sOLDComp, sDepotBrn, sDepotBrnName, oDTB, sFileName, sVendorCode);
  }
  
  public org.tempuri.AT_PrintToStationReviseSAPResponseAT_PrintToStationReviseSAPResult AT_PrintToStationReviseSAP(org.tempuri.AT_PrintToStationReviseSAPODTB oDTB, java.lang.String sType, java.lang.String ptBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_PrintToStationReviseSAP(oDTB, sType, ptBrn);
  }
  
  public java.lang.String AT_GetLupeMaxType() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetLupeMaxType();
  }
  
  public java.lang.String AT_AddLupeMaster(java.lang.String sLupeCode, java.lang.String sLupeName, java.lang.String sCode, java.lang.String sName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_AddLupeMaster(sLupeCode, sLupeName, sCode, sName);
  }
  
  public java.lang.String AT_DeleteLupeMaster(java.lang.String sLupeCode, java.lang.String sCode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_DeleteLupeMaster(sLupeCode, sCode);
  }
  
  public org.tempuri.AT_GetLupeNameCodeForEditBResponseAT_GetLupeNameCodeForEditBResult AT_GetLupeNameCodeForEditB(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sCode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetLupeNameCodeForEditB(sOLDComp, sDepotBrn, sCode);
  }
  
  public org.tempuri.AT_GetLupeNameCodeOtherResponseAT_GetLupeNameCodeOtherResult AT_GetLupeNameCodeOther(java.lang.String sCode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetLupeNameCodeOther(sCode);
  }
  
  public org.tempuri.AT_GetBrnLupeConfigOtherResponseAT_GetBrnLupeConfigOtherResult AT_GetBrnLupeConfigOther(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String brnCode, java.lang.String sLupecode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetBrnLupeConfigOther(sOLDComp, sDepotBrn, brnCode, sLupecode);
  }
  
  public java.lang.String AT_EditDayTransfer(org.tempuri.AT_EditDayTransferDt dt, java.lang.String sOLDComp, java.lang.String sDepotBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_EditDayTransfer(dt, sOLDComp, sDepotBrn);
  }
  
  public org.tempuri.AT_GetDayTransferResponseAT_GetDayTransferResult AT_GetDayTransfer(java.lang.String sOLDComp, java.lang.String sDepotBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetDayTransfer(sOLDComp, sDepotBrn);
  }
  
  public org.tempuri.AT_OrderAutoCalCastrolSplitResponseAT_OrderAutoCalCastrolSplitResult AT_OrderAutoCalCastrolSplit(int iTYPE, java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sBrnGroup, java.lang.String sType) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_OrderAutoCalCastrolSplit(iTYPE, sOLDComp, sDepotBrn, sBrnGroup, sType);
  }
  
  public org.tempuri.AT_OrderAutoCalMaxnetronSplitResponseAT_OrderAutoCalMaxnetronSplitResult AT_OrderAutoCalMaxnetronSplit(int iTYPE, java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sBrnGroup, java.lang.String sType) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_OrderAutoCalMaxnetronSplit(iTYPE, sOLDComp, sDepotBrn, sBrnGroup, sType);
  }
  
  public org.tempuri.AT_OrderAutoCalPowerJetSplitResponseAT_OrderAutoCalPowerJetSplitResult AT_OrderAutoCalPowerJetSplit(int iTYPE, java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sBrnGroup, java.lang.String sType) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_OrderAutoCalPowerJetSplit(iTYPE, sOLDComp, sDepotBrn, sBrnGroup, sType);
  }
  
  public org.tempuri.AT_InquiryLupeBrnDepotResponseAT_InquiryLupeBrnDepotResult AT_InquiryLupeBrnDepot(java.lang.String sDepotBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InquiryLupeBrnDepot(sDepotBrn);
  }
  
  public org.tempuri.AT_GetLupeGoodSaleResponseAT_GetLupeGoodSaleResult AT_GetLupeGoodSale(java.lang.String sCode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetLupeGoodSale(sCode);
  }
  
  public void mailService1(java.lang.String sTo, java.lang.String sMessage) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    pTWebServiceSoap.mailService1(sTo, sMessage);
  }
  
  public void mailService2(java.lang.String sTo, java.lang.String sSubject, java.lang.String sMessage) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    pTWebServiceSoap.mailService2(sTo, sSubject, sMessage);
  }
  
  public void mailService3(java.lang.String sFrom, java.lang.String sTo, java.lang.String sSubject, java.lang.String sMessage) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    pTWebServiceSoap.mailService3(sFrom, sTo, sSubject, sMessage);
  }
  
  public void mailService4(java.lang.String sServer, java.lang.String sFrom, java.lang.String sTo, java.lang.String sSubject, java.lang.String sMessage) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    pTWebServiceSoap.mailService4(sServer, sFrom, sTo, sSubject, sMessage);
  }
  
  public void smsService() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    pTWebServiceSoap.smsService();
  }
  
  public boolean loWrite(java.lang.String sProject, java.util.Calendar dTime, java.lang.String sIp, java.lang.String sUser, java.lang.String sMessage) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.loWrite(sProject, dTime, sIp, sUser, sMessage);
  }
  
  public boolean loWritecus(java.lang.String sProject, java.util.Calendar dTime, java.lang.String sIp, java.lang.String sUser) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.loWritecus(sProject, dTime, sIp, sUser);
  }
  
  public org.tempuri.LoReadResponseLoReadResult loRead(java.lang.String sProject, java.util.Calendar dTime) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.loRead(sProject, dTime);
  }
  
  public org.tempuri.LoReadcusResponseLoReadcusResult loReadcus(java.lang.String sProject, java.util.Calendar dTime) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.loReadcus(sProject, dTime);
  }
  
  public boolean arUpdateAging(org.tempuri.ArUpdateAgingDts dts) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.arUpdateAging(dts);
  }
  
  public double arCheckLimitAging(java.lang.String sComp, java.lang.String sBrn, java.lang.String sCstno, java.lang.String sType) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.arCheckLimitAging(sComp, sBrn, sCstno, sType);
  }
  
  public boolean arCheckDisk8(java.lang.String sComp, java.lang.String sBrn, java.lang.String sCstno, java.lang.String sType) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.arCheckDisk8(sComp, sBrn, sCstno, sType);
  }
  
  public boolean WO_SetStatus(java.lang.String sOrderNo, int nStatus, java.lang.String sUser) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WO_SetStatus(sOrderNo, nStatus, sUser);
  }
  
  public int WO_AutoAllowCheck(java.lang.String sOrderNo, double dCustLimit) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WO_AutoAllowCheck(sOrderNo, dCustLimit);
  }
  
  public boolean WO_UpdateCenterStatus() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WO_UpdateCenterStatus();
  }
  
  public boolean WO_UpdateCenterStatus_Other() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WO_UpdateCenterStatus_Other();
  }
  
  public double WO_CheckLimitWebOrder(java.lang.String sCstno) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WO_CheckLimitWebOrder(sCstno);
  }
  
  public double WO_CheckLimitWebOrderWithOut(java.lang.String sCstno, java.lang.String sOrdno) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WO_CheckLimitWebOrderWithOut(sCstno, sOrdno);
  }
  
  public boolean AN_SuitableCalc(java.lang.String sComp, java.lang.String sBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AN_SuitableCalc(sComp, sBrn);
  }
  
  public boolean AN_SuitableAdjust(java.lang.String sComp, java.lang.String sBrn, int nSEQ) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AN_SuitableAdjust(sComp, sBrn, nSEQ);
  }
  
  public boolean AT_VersionControl(java.lang.String sMAC, java.lang.String sUSER, java.lang.String sIP, java.lang.String sVER) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_VersionControl(sMAC, sUSER, sIP, sVER);
  }
  
  public java.lang.String AT_VersionUpdateCheck(java.lang.String sMAC) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_VersionUpdateCheck(sMAC);
  }
  
  public boolean AT_VersionUpdateComplete(java.lang.String sMAC) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_VersionUpdateComplete(sMAC);
  }
  
  public org.tempuri.AT_DepotListResponseAT_DepotListResult AT_DepotList() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_DepotList();
  }
  
  public org.tempuri.AT_GetProductListResponseAT_GetProductListResult AT_GetProductList() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_GetProductList();
  }
  
  public org.tempuri.AT_StationNotSetLeadTimeResponseAT_StationNotSetLeadTimeResult AT_StationNotSetLeadTime() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_StationNotSetLeadTime();
  }
  
  public org.tempuri.AT_CustomerNotSetLeadTimeResponseAT_CustomerNotSetLeadTimeResult AT_CustomerNotSetLeadTime() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_CustomerNotSetLeadTime();
  }
  
  public org.tempuri.AT_CurrentPolicyResponseAT_CurrentPolicyResult AT_CurrentPolicy(java.lang.String sOLDComp, java.lang.String sDepotBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_CurrentPolicy(sOLDComp, sDepotBrn);
  }
  
  public boolean AT_LoginLDAP(java.lang.String sUsername, java.lang.String sPassword) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_LoginLDAP(sUsername, sPassword);
  }
  
  public boolean AT_UpdatePolicy(java.lang.String sDepotComp, java.lang.String sDepotBrn, double dRotateDay, int iDayAvgSell) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_UpdatePolicy(sDepotComp, sDepotBrn, dRotateDay, iDayAvgSell);
  }
  
  public org.tempuri.AT_StationConfigResponseAT_StationConfigResult AT_StationConfig(java.lang.String sOLDComp, java.lang.String sDepotBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_StationConfig(sOLDComp, sDepotBrn);
  }
  
  public org.tempuri.AT_ViewAllResponseAT_ViewAllResult AT_ViewAll(java.lang.String sOLDComp) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_ViewAll(sOLDComp);
  }
  
  public boolean AT_InsertStationConfig(org.tempuri.AT_InsertStationConfigODTB oDTB) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertStationConfig(oDTB);
  }
  
  public org.tempuri.AT_OrderAutoCalResponseAT_OrderAutoCalResult AT_OrderAutoCal(int iTYPE, java.lang.String sOLDComp, java.lang.String sDepotBrn) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_OrderAutoCal(iTYPE, sOLDComp, sDepotBrn);
  }
  
  public boolean AT_InsertAutoCalculate(org.tempuri.AT_InsertAutoCalculateODTB oDTB) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertAutoCalculate(oDTB);
  }
  
  public java.lang.String AT_InsertCompleteCalc(java.lang.String sOLDComp, java.lang.String sDepotBrn, org.tempuri.AT_InsertCompleteCalcODTB oDTB, java.lang.String sFileName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_InsertCompleteCalc(sOLDComp, sDepotBrn, oDTB, sFileName);
  }
  
  public boolean AT_CreateNewWebOrder(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.util.Calendar dtRPTdate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_CreateNewWebOrder(sOLDComp, sDepotBrn, dtRPTdate);
  }
  
  public org.tempuri.AT_BrowseAutoCalResponseAT_BrowseAutoCalResult AT_BrowseAutoCal(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.lang.String sStatus) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_BrowseAutoCal(sOLDComp, sDepotBrn, sStatus);
  }
  
  public org.tempuri.AT_PrintToStationResponseAT_PrintToStationResult AT_PrintToStation(java.lang.String sOLDComp, java.lang.String sDepotBrn, java.util.Calendar dtRPTdate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_PrintToStation(sOLDComp, sDepotBrn, dtRPTdate);
  }
  
  public org.tempuri.AT_PrintToStationSAPResponseAT_PrintToStationSAPResult AT_PrintToStationSAP(org.tempuri.AT_PrintToStationSAPODTB oDTB) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_PrintToStationSAP(oDTB);
  }
  
  public org.tempuri.AT_PrintToStationSAPNoShipmentResponseAT_PrintToStationSAPNoShipmentResult AT_PrintToStationSAPNoShipment(org.tempuri.AT_PrintToStationSAPNoShipmentODTB oDTB) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_PrintToStationSAPNoShipment(oDTB);
  }
  
  public org.tempuri.AT_PrintToStationSAPLPGResponseAT_PrintToStationSAPLPGResult AT_PrintToStationSAPLPG(org.tempuri.AT_PrintToStationSAPLPGODTB oDTB) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AT_PrintToStationSAPLPG(oDTB);
  }
  
  public boolean AN_MovePreOrder2Order(java.lang.String sComp, java.lang.String sBrn, int nSEQ, int nOrderStatus) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AN_MovePreOrder2Order(sComp, sBrn, nSEQ, nOrderStatus);
  }
  
  public boolean AN_MovePreOrder2Order_Split(java.lang.String sComp, java.lang.String sBrn, int nSEQ, int nOrderStatus) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AN_MovePreOrder2Order_Split(sComp, sBrn, nSEQ, nOrderStatus);
  }
  
  public boolean AN_UpdateOrderSplitNo() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AN_UpdateOrderSplitNo();
  }
  
  public org.tempuri.WebStationGetLotusResponseWebStationGetLotusResult webStationGetLotus(java.lang.String comp, java.lang.String brn, java.lang.String stkdate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.webStationGetLotus(comp, brn, stkdate);
  }
  
  public boolean WO_ReGenerateOthOrder() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WO_ReGenerateOthOrder();
  }
  
  public java.lang.String GPS_SendDriver(java.lang.String sDrcomp, java.lang.String sDrno) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.GPS_SendDriver(sDrcomp, sDrno);
  }
  
  public java.lang.String GPS_SendTruck(java.lang.String sTrcomp, java.lang.String sTrno) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.GPS_SendTruck(sTrcomp, sTrno);
  }
  
  public java.lang.String GPS_SendSite(java.lang.String sStcomp, java.lang.String sStno) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.GPS_SendSite(sStcomp, sStno);
  }
  
  public java.lang.String GPS_SendOil() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.GPS_SendOil();
  }
  
  public java.lang.String GPS_SendJobDr(java.lang.String sJhcomp, java.lang.String sJhbrn, java.lang.String sJhlocation, java.lang.String sJhrunno) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.GPS_SendJobDr(sJhcomp, sJhbrn, sJhlocation, sJhrunno);
  }
  
  public java.lang.String GPS_GetSiteFromGPS(java.lang.String sStrXml) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.GPS_GetSiteFromGPS(sStrXml);
  }
  
  public org.tempuri.WSA_GetEmployeeDataResponseWSA_GetEmployeeDataResult WSA_GetEmployeeData(java.lang.String sEmployeeData) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WSA_GetEmployeeData(sEmployeeData);
  }
  
  public org.tempuri.WSA_GetBranchGroupResponseWSA_GetBranchGroupResult WSA_GetBranchGroup(java.lang.String sEmployeeData) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WSA_GetBranchGroup(sEmployeeData);
  }
  
  public org.tempuri.WSA_GetSystemDataResponseWSA_GetSystemDataResult WSA_GetSystemData(java.lang.String sEmployeeData, java.lang.String sSystemName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WSA_GetSystemData(sEmployeeData, sSystemName);
  }
  
  public org.tempuri.WSA_GetSystemNameResponseWSA_GetSystemNameResult WSA_GetSystemName(java.lang.String sEmployeeData) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WSA_GetSystemName(sEmployeeData);
  }
  
  public org.tempuri.WSA_GetBranchDataResponseWSA_GetBranchDataResult WSA_GetBranchData(java.lang.String sEmployeeData, java.lang.String sSystemName, java.lang.String sBranchCode) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WSA_GetBranchData(sEmployeeData, sSystemName, sBranchCode);
  }
  
  public org.tempuri.WSA_GetBranchNameResponseWSA_GetBranchNameResult WSA_GetBranchName(java.lang.String sEmployeeData, java.lang.String sSystemName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WSA_GetBranchName(sEmployeeData, sSystemName);
  }
  
  public org.tempuri.WSA_GetModuleDataResponseWSA_GetModuleDataResult WSA_GetModuleData(java.lang.String sEmployeeData, java.lang.String sSystemName, java.lang.String sModuleName, java.lang.String sPermission) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WSA_GetModuleData(sEmployeeData, sSystemName, sModuleName, sPermission);
  }
  
  public org.tempuri.WSA_GetModuleNameResponseWSA_GetModuleNameResult WSA_GetModuleName(java.lang.String sEmployeeData, java.lang.String sSystemName, java.lang.String sModuleName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WSA_GetModuleName(sEmployeeData, sSystemName, sModuleName);
  }
  
  public org.tempuri.WSA_GetAcessControlResponseWSA_GetAcessControlResult WSA_GetAcessControl(java.lang.String sEmployeeData, java.lang.String sSystemName) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.WSA_GetAcessControl(sEmployeeData, sSystemName);
  }
  
  public boolean writeLog(java.lang.String IP, java.lang.String user, java.lang.String sys, java.lang.String event, java.lang.String modname, java.lang.String note) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.writeLog(IP, user, sys, event, modname, note);
  }
  
  public org.tempuri.PTG_ProductResponsePTG_ProductResult PTG_Product() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.PTG_Product();
  }
  
  public org.tempuri.POS_PROMOTION_GETResponsePOS_PROMOTION_GETResult POS_PROMOTION_GET(java.lang.String sBRN) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.POS_PROMOTION_GET(sBRN);
  }
  
  public boolean POS_PROMOTION_MARK(java.lang.String sBRN) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.POS_PROMOTION_MARK(sBRN);
  }
  
  public boolean POS_PROMOTION_SET(org.tempuri.POS_PROMOTION_SETODS oDS) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.POS_PROMOTION_SET(oDS);
  }
  
  public org.tempuri.PTG_StationOfDepotResponsePTG_StationOfDepotResult PTG_StationOfDepot(java.lang.String STATION) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.PTG_StationOfDepot(STATION);
  }
  
  public org.tempuri.PTG_AllStationOfDepotResponsePTG_AllStationOfDepotResult PTG_AllStationOfDepot() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.PTG_AllStationOfDepot();
  }
  
  public boolean AUTOMATION_ADDDATA(java.lang.String sString) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.AUTOMATION_ADDDATA(sString);
  }
  
  public boolean PTG_VersionControl(java.lang.String sSystem, java.lang.String sMAC, java.lang.String sUSER, java.lang.String sIP, java.lang.String sVER) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.PTG_VersionControl(sSystem, sMAC, sUSER, sIP, sVER);
  }
  
  public java.lang.String PTG_VersionUpdateCheck(java.lang.String sSystem, java.lang.String sMAC) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.PTG_VersionUpdateCheck(sSystem, sMAC);
  }
  
  public boolean PTG_VersionUpdateComplete(java.lang.String sSystem, java.lang.String sMAC) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.PTG_VersionUpdateComplete(sSystem, sMAC);
  }
  
  public org.tempuri.Supply_GetValueFinanceResponseSupply_GetValueFinanceResult supply_GetValueFinance(java.lang.String sSupplier, java.lang.String sComp, java.lang.String sBrn, java.lang.String sLocation, java.lang.String sDate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.supply_GetValueFinance(sSupplier, sComp, sBrn, sLocation, sDate);
  }
  
  public org.tempuri.Supply_GetValueOilSupplyResponseSupply_GetValueOilSupplyResult supply_GetValueOilSupply(java.lang.String sSupplier, java.lang.String sComp, java.lang.String sBrn, java.lang.String sLocation, java.lang.String sDate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.supply_GetValueOilSupply(sSupplier, sComp, sBrn, sLocation, sDate);
  }
  
  public boolean supply_SaveToSPfnbals(org.tempuri.Supply_SaveToSPfnbalsODT oDT, java.lang.String sSupplier, java.lang.String sComp, java.lang.String sBrn, java.lang.String sLocation, java.lang.String sDate, java.lang.String sUser) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.supply_SaveToSPfnbals(oDT, sSupplier, sComp, sBrn, sLocation, sDate, sUser);
  }
  
  public org.tempuri.Supply_CheckApMngPRResponseSupply_CheckApMngPRResult supply_CheckApMngPR(java.lang.String sSupplier, java.lang.String sComp, java.lang.String sLocation, java.lang.String sDate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.supply_CheckApMngPR(sSupplier, sComp, sLocation, sDate);
  }
  
  public org.tempuri.Supply_GetDataforProcessResponseSupply_GetDataforProcessResult supply_GetDataforProcess() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.supply_GetDataforProcess();
  }
  
  public org.tempuri.Supply_GetSuplysiteResponseSupply_GetSuplysiteResult supply_GetSuplysite() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.supply_GetSuplysite();
  }
  
  public org.tempuri.Supply_GetForcastValueResponseSupply_GetForcastValueResult supply_GetForcastValue(java.lang.String sComp, java.lang.String sBrn, java.lang.String sLocation, java.lang.String sSupplier, java.lang.String sStDate, java.lang.String sSpDate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.supply_GetForcastValue(sComp, sBrn, sLocation, sSupplier, sStDate, sSpDate);
  }
  
  public org.tempuri.Supply_GetMrPrFinanceResponseSupply_GetMrPrFinanceResult supply_GetMrPrFinance(java.lang.String sSupplier, java.lang.String sComp, java.lang.String sBrn, java.lang.String sLocation, java.lang.String sStDate, java.lang.String sSpDate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.supply_GetMrPrFinance(sSupplier, sComp, sBrn, sLocation, sStDate, sSpDate);
  }
  
  public java.lang.String supply_CheckApPR(java.lang.String sSupplier, java.lang.String sComp, java.lang.String sBrn, java.lang.String sLocation, java.lang.String sDate) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.supply_CheckApPR(sSupplier, sComp, sBrn, sLocation, sDate);
  }
  
  public org.tempuri.Supply_GetAllSupplierResponseSupply_GetAllSupplierResult supply_GetAllSupplier() throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.supply_GetAllSupplier();
  }
  
  public org.tempuri.Supply_GetSupplierResponseSupply_GetSupplierResult supply_GetSupplier(java.lang.String sSpcode, java.lang.String sSpname) throws java.rmi.RemoteException{
    if (pTWebServiceSoap == null)
      _initPTWebServiceSoapProxy();
    return pTWebServiceSoap.supply_GetSupplier(sSpcode, sSpname);
  }
  
  
}