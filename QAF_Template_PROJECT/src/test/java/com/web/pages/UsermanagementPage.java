package com.web.pages;

import static org.testng.Assert.assertEquals;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;

public class UsermanagementPage extends UsersPage {
	
    UsersPage users = new UsersPage();
    
	@FindBy(locator="xpath=//div[@role='treeitem']//button")
	public CustomElement eleMarketarrow;
	
	@FindBy(locator="xpath=//ul[@role='tree']//following::span[text()='APAC']")
	public CustomElement eleAPAC;
	
	@FindBy(locator="xpath=//ul[@role='tree']//following::span[text()='EMEA']")
	public CustomElement eleEMEA;
	
	@FindBy(locator="xpath=//div[@class='p-col-12 p-md-2']//button")
	public CustomElement btnFilter;
	
	@FindBy(locator="xpath=//div[contains(@class,'p-overlaypanel-co')]//following::span[@class='p-tree-toggler-icon pi pi-fw pi-chevron-right']")
	public CustomElement btnMarketfilterarrow;
	
	@FindBy(locator="//div[contains(@class,'p-overlaypanel-co')]//following::span[contains(@class,'p-overlaypanel')]")
	public CustomElement btnMarketfilterclose;
	
	@FindBy(locator="xpath=//div[@class='p-col-12 p-md-7']//button")
	public CustomElement btnDistwributorFilter;
	
	@FindBy(locator="xpath=//input[@class='p-tree-filter p-inputtext p-component']")
	public CustomElement tbSearch;
	
	@FindBy(locator="xpath=//span[text()='Sudheer India Distributor corporate']")
	public CustomElement eleDistributorchecbox;
	
	@FindBy(locator="xpath=//button[@class='p-ripple p-element p-tree-toggler p-link']")
	public CustomElement eleCustomersitesArrow;
	
	@FindBy(locator="xpath=//span[text()='sudheer custom corporate']")
	public CustomElement eleCustomersitecheckbox;
	
	@FindBy(locator="xpath=//p-splitbutton[@icon='ctp-icon-Save']")
	public CustomElement btnTemplate;
	
	@FindBy(locator="xpath=//input[@id='templateName']")
	public CustomElement tbTemplatename;
	
	@FindBy(locator="xpath=//span[text()='Save']")
	public CustomElement btnTemplatesave;
	
	@FindBy(locator="xpath=//div[@aria-label='dropdown trigger']")
	public CustomElement ddlSelecttemplate;
	
	public String ddlSelecttemplatelist = "xpath=//ul[@role='listbox']//li//span";
	
	@FindBy(locator="xpath=//span[text()='Clear']")
	public CustomElement btnClear;
	
	@FindBy(locator="xpath=//p-splitbutton[@icon='ctp-icon-Delete']")
	public CustomElement btnDeleteicon;
	
	@FindBy(locator="xpath=//span[text()='Yes']")
	public CustomElement btnDeleteYes;
	
	@FindBy(locator="xpath=//div[contains(@class,'p-overlaypanel')]//input")
	public CustomElement tbSearchStandard;
	
	@FindBy(locator="xpath=//span[text()='sudheer distributor shop 2']")
	public CustomElement eledistributorshopcheckbox;
	
	@FindBy(locator="xpath=//div[text()='Customer Sites']//following::input[@class='p-tree-filter p-inputtext p-component']")
	public CustomElement tbSearchCustomerSites;
	
	@FindBy(locator="xpath=//span[text()='sudheer dist site']")
	public CustomElement eleCustomerSitescheckbox;
	
	@FindBy(locator="xpath=//input[@class='p-inputtext p-component p-element']")
	public CustomElement tbUsertablesearch;
	
	
	
	public void MarketsAssigmentmaster() {
		eleMarketarrow.click();
		eleAPAC.click();
		users.btNext.click();
	}
	
	public void setTerritory() {

		SyncUtil.waitFor(10000);
		cbAllcheckboxAdd.click();
		cbAllcheckboxEdit.click();
		cbAllcheckboxDelete.click();
		cbAllcheckboxView.click();
		cbAllcheckboxDownload.click();
	}
	
	public void Standardassignment() {
		btnFilter.click();
		//btnMarketfilterarrow.click();
		//eleAPAC.click();
		//eleEMEA.click();
		SyncUtil.waitFor(15000);
		tbSearchStandard.click();
		tbSearchStandard.type("APAC");
		eleAPAC.click();
		btnMarketfilterclose.click();
		btnDistwributorFilter.click();
		SyncUtil.waitFor(170000);
		tbSearchStandard.click();
		tbSearchStandard.type("Sudheer India Distributor corporate");
		eleDistributorchecbox.click();
		btnMarketfilterclose.click();
		eleCustomersitesArrow.click();
		eleCustomersitecheckbox.click();
	}
	
	public void Standardsetpermission() {
		cbAllcheckboxEdit.click();
		cbAllcheckboxDelete.click();
		cbAllcheckboxView.click();
	}
	
	public void Createtemplate(String Temaplatename) {
		btnTemplate.click();
		tbTemplatename.type(Temaplatename);
		btnTemplatesave.click();
		SyncUtil.waitFor(5000);
		dropdownselect(ddlSelecttemplate, ddlSelecttemplatelist, Temaplatename);
		btnClear.click();	
	}
	public void DeleteTemplate(String Temaplatename) {
		dropdownselect(ddlSelecttemplate, ddlSelecttemplatelist, Temaplatename);
		btnDeleteicon.click();
		btnDeleteYes.click();
	}
	public void CretaePermissiontemplate(String Temaplatename) {
		btnTemplate.click();
		tbTemplatename.type(Temaplatename);
		btnTemplatesave.click();
		
	}
	public void MasterAssignment() {
		SyncUtil.waitFor(15000);
		tbSearch.type("EMEA");
		eleEMEA.click();
	}
	public void MasterPermission() {
		SyncUtil.waitFor(5000);
		cbAllcheckboxAdd.click();
		cbAllcheckboxEdit.click();
		cbAllcheckboxDelete.click();
		cbAllcheckboxView.click();
		cbAllcheckboxDownload.click();
	}

	public void DistributorAssignment(String distCorp, String custCorp) {
		SyncUtil.waitFor(7000);
		tbSearch.type(distCorp);
		eledistributorshopcheckbox.click();
		SyncUtil.waitFor(5000);
		tbSearchCustomerSites.type(custCorp);
		eleCustomerSitescheckbox.click();	
	}
	public void CustomerAssignment() {
		SyncUtil.waitFor(15000);
		tbSearchCustomerSites.type("sudheer dist site");
		eleCustomerSitescheckbox.click();
	}
	
	public void verifyuser(String FullnameMaster) {
		tbUsertablesearch.type(FullnameMaster);
		tbUsertablesearch.verifyText(FullnameMaster, "Test Master 2");
		Reporter.log("Verified Successfully",MessageTypes.Pass);
	}
	
	
	
}
