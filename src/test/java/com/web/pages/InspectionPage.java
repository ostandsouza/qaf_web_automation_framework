package com.web.pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;



public class InspectionPage extends BasePage {
	
	@FindBy(locator = "xpath=/html/body/app-root/app-layout/div/div[1]/div/app-side-menu-left/div/ul/li[1]/ul/li[1]/a")
	public CustomElement lnkHome;

	@FindBy(locator = "xpath=//span[text()='Inspections']")
	public CustomElement lnkInspection;
	
	@FindBy(locator = "xpath=//h4[text()='Inspection Event']/parent::div//i[contains(@class,'ctp-icon-Inspection-Items-List p-fs-2 items-list')]")
	public CustomElement btnItemlist; 
	
	@FindBy(locator = "xpath=/html/body/app-root/app-layout/div/div[2]/div/app-edit-conveyors/div[1]/div/app-card-sllider/div/div/div[3]/app-card/div/div/div[3]")
	public CustomElement eleInspectiontile;
	
	@FindBy(locator="xpath=//div[@class='footer ng-star-inserted']//span[text()=' To be complete']")
	public CustomElement eleSiteInspectiontile;
	
	@FindBy(locator = "xpath=//button[@ng-reflect-icon='pi pi-plus-circle']")
	public CustomElement btnAddinspectoin;
	
	@FindBy(locator="xpath=//input[@ng-reflect-name='inspectionName']")
	public CustomElement tbInspectionName;
	
	@FindBy(locator = "xpath=//label[text()='Site/Customer Name']/parent::div//div[@role='button']")
	public CustomElement ddlSiteCustomername;
	
	@FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter p-inputtext')]")
	public CustomElement tbInput;
	
	@FindBy(locator = "xpath=//label[text()='Conveyor']/parent::div//div[@role='button']")
	public CustomElement ddlConveyor;
	
	@FindBy(locator = "xpath=//p-autocomplete[@ng-reflect-name='inspector']//span//button")
	public CustomElement ddlInspectorName;
	
	@FindBy(locator = "xpath=//p-multiselect[@optionlabel='name']//span")
	public CustomElement ddlCollaborators;
	
	public String ListItem = "xpath=//ul[@role='listbox']//li//span";
	
	@FindBy(locator = "xpath=(//span[text()='Territory Manager']//following::li//div)[2]")
	public CustomElement cbCollaborators;
	
	@FindBy(locator = "xpath=//div[@class='jodit-wysiwyg']")
	public CustomElement eleSummary;
	
	@FindBy(locator = "xpath=//span[text()='Add new']")
	public CustomElement btnAddnew;
	
	@FindBy(locator="xpath=//label[text()='Asset']/parent::div//div[@role='button']")
	public CustomElement ddlAsset;
	
	@FindBy(locator="xpath=//label[text()='Failure Mode']/parent::div//div[@role='button']")
	public CustomElement ddlFailureMode;
	
	
	@FindBy(locator="xpath=//textarea[@formcontrolname='observation']")
	public CustomElement eleObservation;
	
	@FindBy(locator="xpath=//textarea[@formcontrolname='recommendation']")
	public CustomElement eleRecommendation;
	
	@FindBy(locator="xpath=//button[@class='p-element p-button p-button-rounded p-component ng-star-inserted']")
	public CustomElement btnSave;
	
	@FindBy(locator="xpath=//button[@ng-reflect-icon='ctp-icon-Edit']")
	public CustomElement btnEdit;
	
	@FindBy(locator="xpath=//button[@ng-reflect-icon='ctp-icon-Delete']")
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
	
	@FindBy(locator="xpath=//button[@class='p-element p-splitbutton-menubutton p-button p-component p-button-icon-only']")
	public CustomElement ddlActions;
	
	@FindBy(locator="xpath=//span[text()='Edit']")
	public CustomElement btnEditInspection;
	
	@FindBy(locator="xpath=//span[text()='Delete']")
	public CustomElement btnDeleteInspection;
	
	@FindBy(locator="xpath=(//div[@class='p-checkbox p-component'])[2]")
	public CustomElement cbCheckbox;
	
	@FindBy(locator="xpath=(//button[contains(@class,'in p-button p-component p-button-icon-only')])[1]")
	public CustomElement eleArrow;
	
	@FindBy(locator="xpath=//td[@class='ng-star-inserted']//following::td//span//i[contains(@class,'marker')]")
	public CustomElement eleLocation;
	
	@FindBy(locator="xpath=/html/body/app-root/app-layout/div/div[2]/div/app-inspection-add/p-dialog/div/div/div[2]/div/div[1]/div/div/div/input")
	public CustomElement tbLabel;
	
	@FindBy(locator="xpath=//button[contains(@class,'p-dialog-header-close p-link ng-star-inserted')]")
	public CustomElement btnClose;

	@FindBy(locator="xpath=(//span[@class='ctp-icon-Download p-button-icon ng-star-inserted'])[1]")
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
	
	
	public void clickinspection() {
		lnkHome.click();
		lnkInspection.click();
	}
	
	public void verifylistpage() {
		btnItemlist.click();
	}

	public void addinspection(String Inspectionname) {
		btnAddinspectoin.click();
		tbInspectionName.type(Inspectionname);
		dropdownselectsearch(ddlSiteCustomername, tbInput, "SiteMex");
		dropdownselectsearch(ddlConveyor, tbInput, "mexInches");
		//dropdownselect(ddlInspectorName,ListItem , "testUser17");
		ddlCollaborators.click();
		cbCheckbox.click();
		//dropdownselectsearch(ddlCollaborators, tbInput, "TestLaksh");
		eleSummary.type("Added summary");
		Reporter.log("Inspection is created",MessageTypes.Pass);
	}
	
	
	@FindBy(locator="xpath=//label[text()='Detail']/parent::div//div[@role='button']")
	public CustomElement ddlDetailitems;
	
	@FindBy(locator="xpath=//label[text()='Detail']/parent::div//div[@role='button']")
	public CustomElement ddlDetails;
	
	@FindBy(locator="xpath=//label[text()='Condition']/parent::div//div[@role='button']")
	public CustomElement ddlCondition;
	
	@FindBy(locator="xpath=//label[text()='Status']/parent::div//div[@role='button']")
	public CustomElement ddlStatus;
	
	@FindBy(locator="xpath=//label[text()='Status']/parent::div//div[@role='button']")
	public CustomElement ddlStatus1;
	
	
	public void addinspectionitem() throws AWTException {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		btnAddnew.click();
		dropdownselectsearch(ddlAsset, tbInput, "Conveyor Structure");
		dropdownselect(ddlDetails, ListItem, "Support Beams");
		dropdownselectsearch(ddlFailureMode, tbInput, "Causing damage to the belt");
		dropdownselect(ddlCondition, ListItem, "Crtical");
		dropdownselect(ddlStatus1, ListItem, "To Be Completed");
		tblat.type("-0.42301408813967994");
		tblong.type("178.46784027758986");
		eleObservation.type("Added Observations");
		eleRecommendation.type("Added Recommendations");
		btnSelectfiles.click();
		imageupload();
		btnSave.click();
		waitForPageLoad(10000);
		Reporter.log("Inspection Item is created",MessageTypes.Pass);	
		SyncUtil.waitFor(4000);
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
	
	public void Inspectiondelete() {
		lnkInspection.click();
		cbCheckbox.click();
		ddlActions.click();
		btnDeleteInspection.click();
		btnYes.click();
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
	
	public void DownloadPDF() {
		
		btnDownload.click();
		waitForPageLoad(15000);
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
	
	public void verifyinspection(String Inspectionname) {
	waitForPageLoad(5000);
	lnkinspectionicon.click();
	SyncUtil.waitFor(10000);
	eleSearch.type(Inspectionname);
	if(Inspectionname == eleNameofInspection) {
		Reporter.log("Inspection event name is verified",MessageTypes.Pass);
	}
	else {
		Reporter.log("Inspection event name is not verified",MessageTypes.Fail);
	}
	}
}
