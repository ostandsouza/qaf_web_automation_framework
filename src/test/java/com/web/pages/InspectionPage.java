package com.web.pages;

import static java.io.File.separator;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import com.common.component.CustomElement;
import com.common.utils.PDFHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.apache.pdfbox.pdmodel.PDDocument;


public class InspectionPage extends BasePage {

	@FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
	public CustomElement lnkHome;

	@FindBy(locator = "xpath=//span[text()='Inspections']")
	public CustomElement lnkInspection;
	
	@FindBy(locator = "xpath=//h4[text()='Inspection Event']/parent::div//i[contains(@class,'ctp-icon-Inspection-Items-List p-fs-2 items-list')]")
	public CustomElement btnItemlist; 
	
	@FindBy(locator = "xpath=/html/body/app-root/app-layout/div/div[2]/div/app-edit-conveyors/div[1]/div/app-card-sllider/div/div/div[3]/app-card/div/div/div[3]")
	public CustomElement eleInspectiontile;
	
	@FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
	public CustomElement btnAddInspection;
	
	@FindBy(locator="xpath=//input[@formcontrolname='inspectionName']")
	public CustomElement tbInspectionName;
	
	@FindBy(locator = "xpath=//label[text()='Site/Customer Name']/parent::div//div[@role='button']")
	public CustomElement ddlSiteCustomername;
	
	@FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter p-inputtext')]")
	public CustomElement tbInput;

	@FindBy(locator = "xpath=//input[@placeholder='mm/dd/yyyy']")
	public CustomElement tbInspectionDate;
	
	@FindBy(locator = "xpath=//label[text()='Conveyor']/parent::div//div[@role='button']")
	public CustomElement ddlConveyor;
	
	@FindBy(locator = "xpath=//input[@formcontrolname='name']")
	public CustomElement ddlInspectorName;
	
	@FindBy(locator = "xpath=//p-multiselect[@optionlabel='name']//span")
	public CustomElement ddlCollaborators;
	
	public String ListItem = "xpath=//ul[@role='listbox']//li//span";
	
	@FindBy(locator = "xpath=//span[text()='Add new']")
	public CustomElement btnAddnew;

	@FindBy(locator = "xpath=//div[@class='jodit-wysiwyg']")
	public CustomElement eleSummary;
	
	@FindBy(locator="xpath=//label[text()='Asset']/parent::div//div[@role='button']")
	public CustomElement ddlAsset;

	@FindBy(locator="xpath=//label[text()='Detail']/parent::div//div[@role='button']")
	public CustomElement ddlAssetDetail;
	
	@FindBy(locator="xpath=//label[text()='Failure Mode']/parent::div//div[@role='button']")
	public CustomElement ddlFailureMode;

	@FindBy(locator="xpath=//label[text()='Condition']/parent::div//div[@role='button']")
	public CustomElement ddlCondition;

	@FindBy(locator="xpath=//label[text()='Status']/parent::div//div[@role='button']")
	public CustomElement ddlStatus;
	
	@FindBy(locator="xpath=//textarea[@formcontrolname='observation']")
	public CustomElement eleObservation;
	
	@FindBy(locator="xpath=//textarea[@formcontrolname='recommendation']")
	public CustomElement eleRecommendation;
	
	@FindBy(locator="xpath=//span[text()='Save']")
	public CustomElement btnSave;
	
	@FindBy(locator="xpath=//button[@icon='ctp-icon-Edit']")
	public CustomElement btnEdit;
	
	@FindBy(locator="xpath=//button[@icon='ctp-icon-Delete']")
	public CustomElement btnDelete;
	
	@FindBy(locator="xpath=//span[text()='Yes']")
	public CustomElement btnYes;
	
	@FindBy(locator="xpath=//div[@class='p-breadcrumb p-component']//li//a[contains(@ng-reflect-router-link,'/secure/inspections/')]")
	public CustomElement eleInspections;
	
	@FindBy(locator="xpath=//div[@class='p-breadcrumb p-component']//li//a[contains(@ng-reflect-router-link,'/secure/conveyor/')]")
	public CustomElement eleConveyordetails;
	
	@FindBy(locator="xpath=//div[@class='p-breadcrumb p-component']//li//a[contains(@ng-reflect-router-link,'/secure/sites/details/')]")
	public CustomElement eleSitedetails;
	
	@FindBy(locator="xpath=//div[@class='p-breadcrumb p-component']//li//a[contains(@ng-reflect-router-link,'/secure/companies/detail/')]")
	public CustomElement eleCompaniesDetails;
	
	@FindBy(locator="xpath=//div[@class='p-breadcrumb p-component']//li//a[contains(@ng-reflect-router-link,'/secure/companies/list')]")
	public CustomElement eleCompaniesList;

	@FindBy(locator="xpath=//input[@placeholder='Search']")
	public CustomElement btSearchinput;

	@FindBy(locator="xpath=(//td//p-tablecheckbox)[1]")
	public CustomElement cbCheckbox;

	@FindBy(locator="xpath=(//button[@icon='pi pi-chevron-down'])[2]")
	public CustomElement ddlActions;

	@FindBy(locator="xpath=//li//span[text()='Edit']")
	public CustomElement btnEditInspection;

	@FindBy(locator="xpath=//span[text()='Delete']")
	public CustomElement btnDeleteInspection;
	
	@FindBy(locator="xpath=(//button[contains(@class,'in p-button p-component p-button-icon-only')])[1]")
	public CustomElement eleArrow;
	
	@FindBy(locator="xpath=//td[@class='ng-star-inserted']//following::td//span//i[contains(@class,'marker')]")
	public CustomElement eleLocation;
	
	@FindBy(locator="xpath=/html/body/app-root/app-layout/div/div[2]/div/app-inspection-add/p-dialog/div/div/div[2]/div/div[1]/div/div/div/input")
	public CustomElement tbLabel;
	
	@FindBy(locator="xpath=//button[contains(@class,'p-dialog-header-close p-link ng-star-inserted')]")
	public CustomElement btnClose;

	@FindBy(locator="xpath=(//span[contains(@class,'ctp-icon-Download')])[1]")
	public CustomElement btnDownload;
	
	@FindBy(locator="xpath=(//span[@class='pi pi-search p-button-icon ng-star-inserted'])[1]")
	public CustomElement btnview;
	
	@FindBy(locator="xpath=/html/body/app-root/app-layout/div/div[2]/div/app-site-detail/div[1]/div/app-card-sllider/div/div/div[5]/app-card/div/div/div[3]/span")
	public CustomElement eleInspectionsite;
	
	@FindBy(locator="xpath=/html/body/app-root/app-layout/div/div[2]/div/app-company-detail/div[1]/div[5]/div/app-card/div/div/div[1]")
	public CustomElement eleInspectioncompany;
	
	@FindBy(locator="xpath=//a[@ng-reflect-router-link='/secure/dashboard']//span")
	public CustomElement eleHome;
	
	@FindBy(locator="xpath=//button[text()='Select Files']")
	public CustomElement btnSelectfiles;
	
	@FindBy(locator="xpath=//input[@placeholder='Search']")
	public CustomElement eleSearch;
	
	public String eleNameofInspection = "xpath=//tr[@Class='ng-star-inserted']//td[text()='Test Inspection 2']";
	
	@FindBy(locator="xpath=//a[@ng-reflect-router-link='dashboard/inspections']//span")
	public CustomElement lnkinspectionicon;
	
	@FindBy(locator="xpath=//input[@ng-reflect-name='lat']")
	public CustomElement tblat;
	
	@FindBy(locator="xpath=//input[@ng-reflect-name='long']")
	public CustomElement tblong;

	@FindBy(locator="xpath=//label[text()='Detail']/parent::div//div[@role='button']")
	public CustomElement ddlDetailitems;

	@FindBy(locator="xpath=//label[text()='Detail']/parent::div//div[@role='button']")
	public CustomElement ddlDetails;

	@FindBy(locator="xpath=//label[text()='Status']/parent::div//div[@role='button']")
	public CustomElement ddlStatus1;

	@FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
	public CustomElement pagination;

	@FindBy(locator = "xpath=(//span[contains(@class,'pi-chevron-right')])[1]")
	public CustomElement detailIcon;

	@FindBy(locator="xpath=(//span[contains(@class,'ctp-icon-Arrow-Right')])[1]")
	public CustomElement ddViewicon;

	@FindBy(locator="xpath=(//span[contains(@class,'p-panel-title')])[1]")
	public CustomElement inspectionHeader;

	@FindBy(locator="xpath=//div[text()='Inspection updated.' or text()='Inspection created.']")
	public CustomElement inspectionUpdateMsg;

	@FindBy(locator = "xpath=//td[contains(text(),'No')]")
	public CustomElement noList;


	public void goToInspection() {
		if(!lnkInspection.isVisible())
			lnkHome.click("Home");
		lnkInspection.jsClick("Inspection List");
		btSearchinput.isVisible("Inspection List Page");
	}

	public void goToInspectionScreenAndWait() {
		goToInspection();
		scrollPageDown();
		String val="";
		for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(60); stop>System.nanoTime();) {
			if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
				break;
			}
			val = pagination.getText();
			SyncUtil.waitFor(6000);
		}
	}

	public boolean searchInspection(String inspectionName){
		goToInspectionScreenAndWait();
		btSearchinput.type(inspectionName, "Inspection Search");
		waitForElementToDisplay(cbCheckbox);
		return cbCheckbox.isVisible("Inspection Found");
	}
	
	public void verifyListPage() {
		btnItemlist.click();
	}

	public void addInspection(String conveyorName, String inspectionName, String siteName, String fullName) {
		btnAddInspection.click("Add Inspection btn");
		tbInspectionName.type(inspectionName);
		dropdownselectsearch(ddlSiteCustomername, tbInput, siteName);
		dropdownselectsearch(ddlConveyor, tbInput, conveyorName);
//		ddlInspectorName.verifyText(fullName,"Inspector Name");
		Reporter.log("Inspection is created",MessageTypes.Pass);
	}
	
	
	public void addInspectionItem(String assetName, String assetDetail, String failureMode, String condition, String status) {
		btnAddnew.click();
		waitForElementToDisplay(ddlAsset);
		dropdownselectsearch(ddlAsset, tbInput, assetName);
		dropdownSelect(ddlDetails, ListItem, assetDetail);
		dropdownselectsearch(ddlFailureMode, tbInput, failureMode);
		dropdownSelect(ddlCondition, ListItem, condition);
		dropdownSelect(ddlStatus, ListItem, status);
		btnSave.click();
		waitForElementToDisplay(inspectionUpdateMsg);
		Reporter.log("Inspection Item is created",MessageTypes.Pass);
	}

	public void goToConveyorDetailScreen(String inspectionName) {
		searchInspection(inspectionName);
		waitForElementToDisplay(detailIcon);
		ddViewicon.click("Inspection Detail");
		inspectionHeader.verifyText(inspectionName,"Inspection Header");
	}
	
	public void Edit() {
		btnEdit.click();
		dropdownselectsearch(ddlFailureMode, tbInput, "Broken");
		btnSave.click();
		Reporter.log("Inspection Item is updated",MessageTypes.Pass);
	}
	
	public void Delete() {
		waitForPageLoad(3000);
		btnDelete.click();
		btnYes.click();
		Reporter.log("Inspection Item is deleted",MessageTypes.Pass);
	}
	
	public void BreadCrumb() throws Throwable {
		//lnkInspection.click();
	//	btnview.click();
		//waitForPageLoad(3000);
	//eleInspections.click();
	    scrollPageup();
		eleConveyordetails.click();
		eleInspectiontile.click();
		eleSitedetails.click();
		eleInspectionsite.click();
		eleCompaniesDetails.click();
		eleInspectioncompany.click();
		eleCompaniesList.click();
		eleHome.click();
		Reporter.log("Bread Crumb is passed",MessageTypes.Pass);
	}
	
	public void inspectionDelete() {
		cbCheckbox.check("Conveyor Checkbox");
		ddlActions.click("Actions");
		waitForElementVisible(btnDeleteInspection, 10000,500);
		btnDeleteInspection.click("Delete");
		btnYes.click("Confirm");
		Reporter.log("Inspection Item is deleted",MessageTypes.Pass);
	}
	
	public void Location() {
		//eleArrow.click();
		cbCheckbox.click();
		ddlActions.click();
		btnEditInspection.click();
		eleLocation.click();
		tbLabel.type("Added label");
		btnClose.click();
		Reporter.log("Verified location",MessageTypes.Pass);
	}
	
	public void downloadPDF() {
		
		btnDownload.click();
		SyncUtil.waitFor(10000);
		Reporter.log("PDF is downloaded",MessageTypes.Pass);
	}
	
	public void imageupload() throws AWTException {
		Robot rb = new Robot();
		rb.delay(2000);
		
		StringSelection ss = new StringSelection("C:\\Users\\sudheerkumar.pola\\OneDrive - HCL Technologies Ltd\\Desktop\\IMG-4749.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
	    rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		SyncUtil.waitFor(10000);
		
		
	}
	
	public void verifyInspection(String inspectionName) {
		Validator.assertTrue(searchInspection(inspectionName),"Inspection event is not found","Inspection event is found");
		waitForElementToDisplay(detailIcon);
		ddViewicon.click("Inspection Detail");
		inspectionHeader.verifyText(inspectionName,"Inspection Header");
		Validator.assertTrue(pagination.getText("Inspection Item").contains("2"),"All Inspections Items are not listed","All Inspections Items are listed");
	}

	public void verifyPDFContents(String fullName, String custSiteName, String conveyorName, String inspectionName, String inspectionId) {
		PDDocument doc =  PDFHelper.getPDFData(System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+inspectionId+".pdf");
		try {
			String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
			Validator.assertTrue(val.contains(fullName),"PDF Report was generated for the wrong inspector","PDF Report was generated for the right inspector");
			Validator.assertTrue(val.contains(custSiteName),"PDF Report was generated for the wrong customer Site","PDF Report was generated for the right customer Site");
			Validator.assertTrue(val.contains(conveyorName),"PDF Report was generated for the wrong conveyor","PDF Report was generated for the right conveyor");
			Validator.assertTrue(val.contains(inspectionName),"PDF Report was generated for the wrong inspection","PDF Report was generated for the right inspection");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifyDeleteInspection(String inspectionName) {
		goToInspectionScreenAndWait();
		btSearchinput.type(inspectionName, "Inspection Search");
		Validator.assertTrue(noList.isVisible("No Inspection"),"Inspection list was found","Inspection list was not found");
		noList.isVisible("No Inspection List");
	}
}
