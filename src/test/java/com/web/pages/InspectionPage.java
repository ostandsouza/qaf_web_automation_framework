package com.web.pages;

import static java.io.File.separator;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.PDFHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.By;


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
	
	@FindBy(locator = "xpath=//label[text()='Inspector Name']/..//input")
	public CustomElement ddlInspectorName;
	
	@FindBy(locator = "xpath=//p-multiselect[@optionlabel='name']//span")
	public CustomElement ddlCollaborators;
	
	public String ListItem = "//ul[@role='listbox']//li//span";
	
	@FindBy(locator = "xpath=//span[text()='Add new']/..")
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

	@FindBy(locator="xpath=//label[text()='Status']/parent::div//input")
	public CustomElement ddlStatusView;
	
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
	public CustomElement btnSelectFiles;

	@FindBy(locator="id=file-input")
	public CustomElement btnUpload;

	@FindBy(locator="id=autocomplete-address")
	public CustomElement eleAddress;
	
	@FindBy(locator="xpath=//input[@placeholder='Search']")
	public CustomElement eleSearch;
	
	public String eleNameOfInspection = "xpath=//tr[@Class='ng-star-inserted']//td[text()='Test Inspection 2']";
	
	@FindBy(locator="xpath=//a[@ng-reflect-router-link='dashboard/inspections']//span")
	public CustomElement lnkInspectionIcon;
	
	@FindBy(locator="xpath=//label[text()='Latitude']/parent::div//input")
	public CustomElement tbLat;
	
	@FindBy(locator="xpath=//label[text()='Longitude']/parent::div//input")
	public CustomElement tbLong;

	@FindBy(locator="xpath=//label[text()='Detail']/parent::div//div[@role='button']")
	public CustomElement ddlDetails;

	@FindBy(locator="xpath=//label[text()='Detail']/parent::div//input")
	public CustomElement ddlDetailInput;

	@FindBy(locator="xpath=//label[text()='Type']/parent::div//div[@role='button']")
	public CustomElement ddlTypes;

	@FindBy(locator="xpath=//label[text()='Status']/parent::div//div[@role='button']")
	public CustomElement ddlStatus1;

	@FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
	public CustomElement pagination;

	@FindBy(locator = "xpath=(//td//span[contains(@class,'pi-chevron-right')])[1]")
	public CustomElement detailIcon;

	@FindBy(locator="xpath=(//span[contains(@class,'ctp-icon-Arrow-Right')])[1]")
	public CustomElement ddViewicon;

	@FindBy(locator="xpath=(//span[contains(@class,'p-panel-title')])[1]")
	public CustomElement inspectionHeader;

	@FindBy(locator="xpath=//div[text()='Inspection updated.' or text()='Inspection created.']")
	public CustomElement inspectionUpdateMsg;

	@FindBy(locator = "xpath=//td[contains(text(),'No')]")
	public CustomElement noList;

	@FindBy(locator = "xpath=//span[contains(@class,'ctp-icon-Save')]")
	public CustomElement ddlSave;

	@FindBy(locator = "xpath=//div[text()='Inspection updated.']")
	public CustomElement inspectionUpdated;

	@FindBy(locator = "xpath=(//div[text()='Inspections']/..//div[contains(@class,'text-area')]/span)[3]")
	public CustomElement crInspections;

	@FindBy(locator = "xpath=//h4[text()='Inspection Event']")
	public CustomElement inspectionEventHeader;

	@FindBy(locator = "xpath=(//span[@class='clickable']/i[contains(@class,'ctp-icon-Inspection-Items-List')])[2]")
	public CustomElement inspectionGroupView;

	@FindBy(locator = "xpath=(//span[@class='clickable']/i[contains(@class,'ctp-icon-Inspection-Reports-List')])[2]")
	public CustomElement inspectionListView;

	@FindBy(locator = "xpath=//th/div[text()=' Name of Inspection ']")
	public CustomElement nameOfInspectionCol;

	@FindBy(locator = "xpath=//th/div[text()=' Inspection Date ']")
	public CustomElement inspectionDateCol;

	@FindBy(locator = "xpath=//th/div[text()=' Last Updated ']")
	public CustomElement lastUpdatedCol;

	@FindBy(locator = "xpath=//th/div[text()=' Corporate ']")
	public CustomElement corporatesCol;

	@FindBy(locator = "xpath=//th/div[text()=' Site ']")
	public CustomElement siteCol;

	@FindBy(locator = "xpath=//th/div[text()=' Conveyor ']")
	public CustomElement conveyorCol;

	@FindBy(locator = "xpath=//th/div[text()=' Inspector ']")
	public CustomElement inspectorCol;

	@FindBy(locator = "xpath=//th/div[text()=' Condition ']")
	public CustomElement conditionCol;

	@FindBy(locator = "xpath=//th/div[text()=' Status ']")
	public CustomElement statusCol;

	@FindBy(locator = "xpath=//th[text()='More']")
	public CustomElement moreCol;

	@FindBy(locator = "xpath=//th/div[text()=' Asset ']")
	public CustomElement assetCol;

	@FindBy(locator = "xpath=//th/div[text()=' Photo ']")
	public CustomElement photoCol;

	@FindBy(locator = "xpath=//th/div[text()=' Observations ']")
	public CustomElement observationCol;

	@FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
	public CustomElement btAddInspection;

	@FindBy(locator="xpath=//td[contains(@class,'p-datepicker-today')]")
	public CustomElement btTodayDate;

	@FindBy(locator= "xpath=//input[contains(@class,'p-multiselect-filter')]")
	public CustomElement tbMultipleDropdown;

	@FindBy(locator= "xpath=//span[@class='total-no']")
	public CustomElement totalEvent;

	@FindBy(locator= "xpath=//div[text()=' CRITICAL ']/following-sibling::div//span")
	public CustomElement criticalEvent;

	@FindBy(locator= "xpath=//div[text()=' POOR ']/following-sibling::div//span")
	public CustomElement poorEvent;

	@FindBy(locator= "xpath=//div[text()=' FAULT ']/following-sibling::div//span")
	public CustomElement faultEvent;

	@FindBy(locator= "xpath=//div[text()=' GOOD ']/following-sibling::div//span")
	public CustomElement goodEvent;

	@FindBy(locator= "xpath=//div[contains(@class,'ql-editor')]/p")
	public CustomElement summaryField;

	@FindBy(locator= "xpath=//span[contains(@class,'pi-window-maximize')]")
	public CustomElement summaryMaximize;

	@FindBy(locator= "xpath=//span[contains(@class,'pi-window-minimize')]")
	public CustomElement summaryMinimize;

	@FindBy(locator="xpath=//div[@class='p-progress-spinner']")
	public CustomElement btSpinner;

	@FindBy(locator="xpath=//p-galleriaitemslot/app-image-viewer")
	public CustomElement appImgViewer;

	@FindBy(locator="xpath=//li/a/span[text()='Edit']")
	public CustomElement editBreadCrumb;

	@FindBy(locator="xpath=(//td//img)[1]")
	public CustomElement imageAvatar;

	@FindBy(locator="xpath=//i[@class='ctp-icon-Photos']")
	public CustomElement photoIcon;

	@FindBy(locator="xpath=//img[contains(@class,'wrapper-image-item')]")
	public CustomElement imgPopup;

	@FindBy(locator="xpath=//button[contains(@class,'p-dialog-header-icon')]")
	public CustomElement closePopup;

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
		for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(120); stop>System.nanoTime();) {
			if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
				break;
			}
			val = pagination.getText();
			SyncUtil.waitFor(5000);
		}
	}

	public boolean searchInspection(String inspectionName){
		goToInspectionScreenAndWait();
		btSearchinput.type(inspectionName, "Inspection Search");
		waitForElementToDisplay(cbCheckbox);
		return cbCheckbox.isVisible("Inspection Found");
	}

	public boolean searchInspectionItem(String conveyorName){
		goToInspectionScreenAndWait();
		scrollPageup();
		if(inspectionGroupView.isVisible())
			inspectionGroupView.click("List View");
		btSearchinput.type(conveyorName, "Inspection Search");
		waitForElementToDisplay(cbCheckbox);
		return cbCheckbox.isVisible("Inspection Found");
	}
	
	public void verifyListPage() {
		btnItemlist.click();
	}

	public void addInspection(String inspectionName, String siteName, String fullName) {
		btnAddInspection.click("Add Inspection btn");
		tbInspectionName.type(inspectionName);
		dropdownSelectSearch(ddlSiteCustomername, tbInput, siteName);
//		dropdownselectsearch(ddlConveyor, tbInput, conveyorName);
//		ddlInspectorName.verifyText(fullName,"Inspector Name");
		Reporter.log("Inspection is created",MessageTypes.Pass);
	}
	
	
	public void saveInspectionItem() {
		waitForElementToBeClickable(btnSave);
		btnSave.click("Save");
		waitForElementToDisplay(inspectionUpdateMsg);
		Reporter.log("Inspection Item is created",MessageTypes.Pass);
	}

	public void addItemMandatoryField(String conveyorName, String assetName, String assetDetail, String failureMode, String condition, String status) {
		waitForElementToBeClickable(btnAddnew);
		SyncUtil.waitFor(2000);
		btnAddnew.click("Add New Inspection");
		waitForElementToDisplay(ddlAsset);
		dropdownSelectSearch(ddlConveyor, tbInput, conveyorName);
		dropdownSelectSearch(ddlAsset, tbInput, assetName);
		if(ddlDetails.isVisible())
			dropdownSelect(ddlDetails, ListItem, assetDetail);
		if(ddlTypes.isVisible())
			dropdownSelect(ddlTypes, ListItem, assetDetail);
		if(ddlDetailInput.isVisible())
			ddlDetailInput.type(assetDetail);
		dropdownSelectSearch(ddlFailureMode, tbInput, failureMode);
		dropdownSelect(ddlCondition, ListItem, condition);
		dropdownSelect(ddlStatus, ListItem, status);
	}

	public void addItemOptionalField(String lat, String longitude, String observation, String recommendation, String address, String img) {
		tbLong.type(lat,"Latitude");
		tbLat.type(longitude,"Longitude");
		eleObservation.type(observation,"Observation");
		eleRecommendation.type(recommendation,"Recommendation");
		if(eleAddress.isVisible())
			eleAddress.type(address,"Address");
		String file_path = ClasspathResourceHelper.getPropertyFile(img, "test_files").getAbsolutePath();
		btnUpload.sendKeys(file_path, "File Path");
		waitForElementToInvisible(btSpinner,30000);
		appImgViewer.isVisible("App Image Viewer");
	}

	public void goToInspectionDetailScreen(String inspectionName) {
		searchInspection(inspectionName);
		waitForElementToDisplay(detailIcon);
		ddViewicon.click("Inspection Detail");
		inspectionHeader.verifyText(inspectionName,"Inspection Header");
	}
	
	public void edit() {
		btnEdit.click();
		dropdownSelectSearch(ddlFailureMode, tbInput, "Broken");
		btnSave.click();
		Reporter.log("Inspection Item is updated",MessageTypes.Pass);
	}
	
	public void delete() {
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
		cbCheckbox.check("Inspection Checkbox");
		ddlActions.click("Actions");
		waitForElementVisible(btnDeleteInspection, 10000,500);
		btnDeleteInspection.click("Delete");
		btnYes.click("Confirm");
		waitForElementToDisplay(noList);
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
	
	public void verifyInspection(String inspectionName, String itemCount) {
		Validator.assertTrue(searchInspection(inspectionName),"Inspection event is not found","Inspection event is found");
		waitForElementToDisplay(detailIcon);
		ddViewicon.click("Inspection Detail");
		inspectionHeader.verifyText(inspectionName,"Inspection Header");
		Validator.assertTrue(pagination.getText("Inspection Item").contains(itemCount),"All Inspections Items are not listed","All Inspections Items are listed");
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

	public void editInspection(String inspectionName) {
		searchInspection(inspectionName);
		cbCheckbox.check("Select Checkbox");
		ddlActions.click("Actions");
		waitForElementVisible(btnEditInspection, 10000,500);
		btnEditInspection.click("Edit");
		ddlSave.isVisible("Edit save");
	}

	public void editInspectionName(String inspectionName, String newInspName) {
		editInspection(inspectionName);
		waitForElementToDisplay(tbInspectionName);
		SyncUtil.waitFor(1500);
		tbInspectionName.type(newInspName);
	}

	public void editInspectionItem(String inspectionItem, String newStatus) {
		btSearchinput.type(inspectionItem, "Inspection Search");
		waitForElementToDisplay(cbCheckbox);
		btnEdit.click("Edit Inspection Item");
		waitForElementToDisplay(ddlStatus);
		dropdownSelect(ddlStatus, ListItem, newStatus);
		btnSave.click("Save");
		waitForElementToDisplay(inspectionUpdateMsg);
		Reporter.log("Inspection Item is Updated",MessageTypes.Pass);
	}

	public void deleteInspectionItem(String inspectionItem) {
		btSearchinput.type(inspectionItem, "Inspection Search");
		waitForElementToDisplay(cbCheckbox);
		btnDelete.click("Delete Inspection Item");
		btnYes.click("Confirm delete");
		waitForElementToDisplay(noList);
		noList.isVisible("No Item Found");
	}

	public void saveInspectionEvent() {
		waitForElementToBeClickable(ddlSave);
		ddlSave.jsClick("Save Inspection Event");
//		waitForElementToDisplay(inspectionUpdated);
		SyncUtil.waitFor(1000);
		inspectionUpdated.isEnable("Inspection Update Toast");
	}

	public void goToInspectionsFromTile() {
		waitForElementToBeClickable(crInspections);
		crInspections.jsClick("Inspection Tile");
		inspectionEventHeader.isVisible("Inspection Event Header");
	}

	public boolean verifyDefaultViewSelection() {
		return inspectionGroupView.isVisible("Group View") && !inspectionListView.isVisible();
	}

	public boolean verifyDefaultViewColumns() {
		return nameOfInspectionCol.isEnable("Name Of inspection") && inspectionDateCol.isEnable("Inspection Date") && lastUpdatedCol.isEnable("Last Updated") && corporatesCol.isEnable("Corporates") && siteCol.isEnable("Site") && conveyorCol.isEnable("Conveyor") && inspectorCol.isEnable("Inspector") && conditionCol.isEnable("Condition") && statusCol.isEnable("Status") && moreCol.isEnable("More");
	}
	public boolean verifySwitchView() {
		inspectionGroupView.click("List View");
		return inspectionListView.isVisible("List View") && !inspectionGroupView.isVisible();
	}

	public boolean verifyListViewColumns() {
		return inspectionDateCol.isEnable("Inspection Date") && lastUpdatedCol.isEnable("Last Updated") && siteCol.isEnable("Site") && conveyorCol.isEnable("Conveyor") && inspectorCol.isEnable("Inspector") && conditionCol.isEnable("Condition") && statusCol.isEnable("Status") && moreCol.isEnable("More") && assetCol.isEnable("Asset") && photoCol.isEnable("Photo") && observationCol.isEnable("Observation");
	}

	public boolean verifyAddInspectionFromList() {
		btAddInspection.click("Add Inspection Icon");
		return inspectionHeader.isVisible("Inspection Header");
	}

	public boolean verifyPlaceHolderForInspectionName() {
		return ddlInspectorName.getAttribute("placeholder").equalsIgnoreCase("Type Inspection Name");
	}

	public boolean verifyDefaultDateField() {
		return tbInspectionDate.getAttribute("placeholder").equalsIgnoreCase("Type Inspection Name");
	}

	public boolean verifyDefaultInspectionDate() {
		tbInspectionDate.click("Inspection Date");
		return btTodayDate.isVisible("Today Date");
	}

	public void verifyConveyorSelection(String siteName) {
		dropdownSelectSearch(ddlSiteCustomername, tbInput, siteName);
	}

	public void verifyCollaboratorSelection(String collaboratorName) {
		ddlCollaborators.click();
		setImplicitWait(70000,TimeUnit.MILLISECONDS);
		waitForPresenceOfElement(By.xpath("//span[text()='"+collaboratorName+"']"));
		tbMultipleDropdown.sendKeys(collaboratorName);
		driver.findElement("//span[text()='"+collaboratorName+"']").click();
		setImplicitWait(1000,TimeUnit.MILLISECONDS);
	}

	public boolean verifyDefaultTileCount(String val) {
		return totalEvent.getText("Total Event").equalsIgnoreCase(val) && criticalEvent.getText("Critical Event").equalsIgnoreCase(val) && poorEvent.getText("Poor Event").equalsIgnoreCase(val) && faultEvent.getText("Fault Event").equalsIgnoreCase(val) && goodEvent.getText("Good Event").equalsIgnoreCase(val);
	}

	public boolean verifyInspectionCount(String total, String val) {
		return totalEvent.getText("Total Event").equalsIgnoreCase(val) && criticalEvent.getText("Critical Event").equalsIgnoreCase(val) && poorEvent.getText("Poor Event").equalsIgnoreCase(val) && faultEvent.getText("Fault Event").equalsIgnoreCase(val) && goodEvent.getText("Good Event").equalsIgnoreCase(val);
	}

	public boolean verifySummaryField(String val) {
		summaryField.sendKeys(val);
		SyncUtil.waitFor(5000);
		return summaryField.getText("Summary Field").equalsIgnoreCase(val);
	}

	public boolean verifyInspectorName(String val) {
		return ddlInspectorName.getAttribute("value").equalsIgnoreCase(val);
	}

	public boolean verifyMaximize() {
		summaryMaximize.click("Summary window Maximize");
		return !summaryMaximize.isVisible() && summaryMinimize.isVisible("Summary window Minimize");
	}

	public boolean verifyMinimize() {
		summaryMinimize.click("Summary window Minimize");
		return !summaryMinimize.isVisible() && summaryMaximize.isVisible("Summary window Maximize");
	}

	public boolean verifySaveBtn() {
		return !btnAddnew.isEnable();
	}

	public void selectInspection() {
		cbCheckbox.check("Checkbox");
	}
	public boolean verifyActionBtnState() {
		return ddlActions.isEnable();
	}

	public boolean verifyDropDown(){
		ddlActions.click("Actions");
		return btnEditInspection.isVisible("Edit Conveyor") && btnDeleteInspection.isVisible("Delete Conveyor");
	}

	public boolean verifyEditBreadcrumb(){
		btnEditInspection.click("Edit Inspection");
		return editBreadCrumb.isVisible("Edit Breadcrumb");
	}

	public void editInspectionName(String name){
		waitForElementToDisplay(tbInspectionName);
		tbInspectionName.type(name);
	}

	public void editInspectorName(String name){
		waitForElementToDisplay(ddlInspectorName);
		ddlInspectorName.type(name);
	}

	public boolean verifyEditChanges(String eventName, String inspectorName){
		return ddlInspectorName.getAttribute("value").equalsIgnoreCase(inspectorName);
	}

	public void editInspectionItemList(String conveyorName) {
		searchInspectionItem(conveyorName);
		cbCheckbox.check("Select Checkbox");
		ddlActions.click("Actions");
		waitForElementVisible(btnEditInspection, 10000,500);
		btnEditInspection.click("Edit");
		btnSave.isVisible("Edit save");
	}

	public void editInspectionIemStatus(String status){
		waitForElementToDisplay(ddlStatus);
		dropdownSelect(ddlStatus, ListItem, status);
		btnSave.click("Save");
		waitForElementToDisplay(inspectionUpdateMsg);
		Reporter.log("Inspection Item is Updated",MessageTypes.Pass);
	}

	public boolean verifyEditedItemChanges(String conveyorName, String status){
		goToInspection();
		verifySwitchView();
		searchInspection(conveyorName);
		ddViewicon.click("Inspection Detail");
		return ddlStatusView.getAttribute("value").equalsIgnoreCase(status);
	}

	public String verifyInspectionGroupedView(String inspectionName){
		searchInspection(inspectionName);
		detailIcon.click("Expand Inspection");
		return imageAvatar.getAttribute("src");
	}

	public void verifyImageViewerGrouped(){
		imageAvatar.click("photo");
		waitForElementToDisplay(imgPopup);
		imgPopup.isVisible("Image");
		closePopup.click();
	}

	public boolean verifyInspectionListView(String conveyor){
		searchInspectionItem(conveyor);
		return photoIcon.isVisible("Photo icon");
	}

	public void verifyImageViewerList(){
		photoIcon.click("photo");
		waitForElementToDisplay(imgPopup);
		imgPopup.isVisible("Image");
		closePopup.click();
	}

	public void verifyDeleteInspectionItem(String conveyor) {
		goToInspectionScreenAndWait();
		btSearchinput.type(conveyor, "Inspection Search");
		Validator.assertTrue(pagination.getText().contains("3"),"Inspection items were not deleted","Inspection item list was not found");
	}
}
