package com.web.pages;


import com.common.component.CustomElement;
import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class IotDashboardPage extends BasePage {

	@FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
	public CustomElement paginationEntry;

	@FindBy(locator = "xpath=(//li//span[text()='IoT Dashboards'])[1]")
	public CustomElement iotDashboard;

	@FindBy(locator = "xpath=//span[text()='Create New Dashboard']")
	public CustomElement createNewDashboard;

	@FindBy(locator = "xpath=//span[text()='Create New Widget']/..")
	public CustomElement createNewWidget;

	@FindBy(locator = "xpath=//div/p[contains(text(),'first dashboard')]")
	public CustomElement createNewWidgetSubtext;

	@FindBy(locator = "xpath=(//app-card//div[text()='IoT Dashboards']/../../parent::app-card/..)[1]")
	public CustomElement txtDashboardHighlight;

	@FindBy(locator = "xpath=(//app-card//div[text()='IoT Dashboards']/..//span)[1]")
	public CustomElement txtDashboardCount;

	@FindBy(locator="xpath=//button[contains(@class,'p-carousel-next')]")
	public CustomElement btRightCarousel;

	@FindBy(locator = "xpath=//input[@placeholder='Search']")
	public CustomElement btSearchinput;

	@FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
	public CustomElement home;

	@FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
	public CustomElement pagination;

	@FindBy(locator = "xpath=(//app-card//div[text()='IoT Dashboards'])[1]/../div/div/div/span")
	public CustomElement iotDashboardCardCount;

	@FindBy(locator = "xpath=(//span[@class='p-button-icon pi pi-refresh'])[2]")
	public CustomElement btRefresh;

	@FindBy(locator = "xpath=(//span[@class='p-button-icon pi pi-refresh'])[1]")
	public CustomElement btRefreshWidget;

	@FindBy(locator="xpath=//div[contains(@class,'hidden-md')]//span[text()='Actions']/..")
	public CustomElement btnActions;

	@FindBy(locator="xpath=(//p-splitbutton//button/*[name()='svg']/..)[2]")
	public CustomElement crActions;

	@FindBy(locator = "xpath=//span[text()='Clear Filters']")
	public CustomElement clearFilterBtn;

	@FindBy(locator= "xpath=(//p-multiselect)[1]")
	public CustomElement columnSelectionBtn;

	@FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
	public CustomElement btnAddIot;

	@FindBy(locator = "xpath=//span[contains(@class,'p-dialog-title')]")
	public CustomElement dialogTitle;

	@FindBy(locator = "xpath=//p-radiobutton[@value='Time Focused']/div")
	public CustomElement timeFocused;

	@FindBy(locator = "xpath=//p-radiobutton[@value='Belt Focused']/div")
	public CustomElement beltFocused;

	@FindBy(locator = "id=dashboardName")
	public CustomElement dashboardField;

	@FindBy(locator = "xpath=//p-select[@datakey='companyId']//div[@role='button']")
	public CustomElement siteDropdown;

	@FindBy(locator= "xpath=//input[contains(@class,'p-select-filter') or contains(@class,'p-dropdown-filter')]")
	public CustomElement tbDropdownInput;

	@FindBy(locator="xpath=//button[contains(@class,'p-button-loading')]")
	public CustomElement buttonLoader;

	@FindBy(locator = "xpath=//p-select[@datakey='conveyorId']//div[@role='button']")
	public CustomElement conveyorDropdown;

	@FindBy(locator = "xpath=(//span[text()='Create']/..)[1]")
	public CustomElement createBtn;

	@FindBy(locator = "xpath=(//span[text()='Cancel']/..)[1]")
	public CustomElement cancelBtn;

	@FindBy(locator = "xpath=(//p-skeleton//div[@data-pc-name=\"skeleton\"])[1]")
	public CustomElement loaderSkeleton;

	@FindBy(locator="xpath=//div[@aria-label='dropdown trigger']/preceding-sibling::span")
	public CustomElement btPageLimit;

	public String ListItem = "//ul[@role='listbox']//li//span[not(@aria-hidden)]";

	@FindBy(locator="xpath=//div[@aria-label='dropdown trigger']")
	public CustomElement btPageDropdown;

	@FindBy(locator = "xpath=(//td//p-tablecheckbox)[1]")
	public CustomElement cbCheckbox;

	@FindBy(locator = "xpath=//li//span[text()='Edit']")
	public CustomElement btnEdit;

	@FindBy(locator = "xpath=//span[text()='Delete']")
	public CustomElement btnDelete;

	@FindBy(locator = "xpath=//li//span[text()='Duplicate']")
	public CustomElement btnDuplicate;

	@FindBy(locator = "xpath=//div[text()='New Dashboard saved']")
	public CustomElement successDashboardToast;

	@FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Arrow-Right')])[1]")
	public CustomElement ddViewicon;

	@FindBy(locator = "xpath=//span[contains(@class,'p-panel-title')]")
	public CustomElement iotHeader;

	@FindBy(locator = "xpath=//label[text()='Cord Damage Summary']/preceding-sibling::p-checkbox")
	public CustomElement cordDamageSummaryWidget;

	@FindBy(locator = "xpath=//label[text()='Link to another page']/preceding-sibling::p-checkbox")
	public CustomElement linkAnotherPageWidget;

	@FindBy(locator = "xpath=//label[text()='Splice Summary']/preceding-sibling::p-checkbox")
	public CustomElement spliceSummaryWidget;

	@FindBy(locator = "xpath=//label[text()='Segment Summary']/preceding-sibling::p-checkbox")
	public CustomElement segmentSummaryWidget;

	@FindBy(locator = "xpath=//label[text()='Damage Density']/preceding-sibling::p-checkbox")
	public CustomElement damageDensityWidget;

	@FindBy(locator = "xpath=//label[text()='Splice Parameter']/preceding-sibling::p-checkbox")
	public CustomElement spliceParameterWidget;

	@FindBy(locator = "xpath=//span[text()='Add Widget']/..")
	public CustomElement addWidget;

	@FindBy(locator = "xpath=//app-widget-card//div[@class='headerTitle']")
	public CustomElement widgetTitle;

	@FindBy(locator = "xpath=//div[contains(@class,'loader-state')]")
	public CustomElement widgetLoader;

	@FindBy(locator = "xpath=//app-widget-card//div[@class='headerTitle']/../following-sibling::div//div[contains(@class,'device-name')]/span")
	public CustomElement widgetMonitoringDevice;

	@FindBy(locator = "xpath=//button/span[text()='Edit']/..")
	public CustomElement widgetEdit;

	@FindBy(locator = "xpath=//p-datepicker")
	public CustomElement timeSelector;

	@FindBy(locator = "xpath=//button[text()=' Configure ']")
	public CustomElement configureWidget;

	@FindBy(locator = "xpath=//button[@icon='ctp-icon-expand']")
	public CustomElement widgetExpand;

	@FindBy(locator = "xpath=//button[@icon='ctp-icon-information']")
	public CustomElement widgetIcon;

	@FindBy(locator = "xpath=//button[@icon='pi pi-ellipsis-v']")
	public CustomElement widgetMore;

	@FindBy(locator = "xpath=//li//span[text()='Configure']")
	public CustomElement moreConfigure;

	@FindBy(locator = "xpath=//li//span[text()='Delete']")
	public CustomElement moreDelete;

	@FindBy(locator = "xpath=//p-select[@datakey='monitoringDeviceId']//div[@role='button']")
	public CustomElement monitoringDropdown;

	@FindBy(locator = "xpath=//input[contains(@class,'p-select-filter p-component p-inputtext')]")
	public CustomElement dropdownInput;

	@FindBy(locator = "xpath=//label[contains(text(),'Title')]/..//input")
	public CustomElement titleInput;

	@FindBy(locator = "xpath=//label[contains(text(),'Url')]/..//input")
	public CustomElement urlInput;

	@FindBy(locator = "xpath=//label[contains(text(),'Description')]/..//input")
	public CustomElement descriptionInput;

	@FindBy(locator = "xpath=//label[contains(text(),'Splice number')]/..//input")
	public CustomElement spliceNumInput;

	@FindBy(locator = "xpath=//p-multiselect")
	public CustomElement dataTypesDropdown;

	@FindBy(locator = "xpath=//div[@aria-label='All items selected']/checkicon")
	public CustomElement allDataTypes;

	@FindBy(locator = "xpath=//button[contains(@class,'p-dialog-header-icon')]")
	public CustomElement btnClose;

	@FindBy(locator = "xpath=//div[contains(@class,'p-dialog-content')]//div[@class='device-names']")
	public CustomElement monitoringDeviceTitle;

	@FindBy(locator = "xpath=//div[contains(@class,'p-dialog-content')]//p[contains(text(),'Describes')]")
	public CustomElement infoContentText;

	@FindBy(locator = "xpath=//div[contains(@class,'p-dialog-content')]//p/img")
	public CustomElement infoContentImg;

	@FindBy(locator = "xpath=//div[@data-pc-name='skeleton']")
	public CustomElement skeleton;

	public void gotoIotDashboardScreen(){
		SyncUtil.waitFor(1000);
		if(!iotDashboard.isVisible())
			home.click("Home");
		iotDashboard.click("Iot Dashboard");
		btSearchinput.isVisible("Io Dashboard Page");
	}

	public void gotoIotDashboardFromCard(){
		waitForPageLoad(5000);
		while(!txtDashboardCount.isVisible()){
			btRightCarousel.jsClick("Carousel right");
		}
		txtDashboardCount.jsClick();
		waitForPageLoad(5000);
		Validator.assertTrue(btSearchinput.isDisplayed(),"IOT dashboard Page is not loaded","IOT dashboard Page is loaded");
	}

	public boolean isIotCardHighlighted(){
		return txtDashboardHighlight.getAttribute("class").contains("conveyor-cards");
	}


	public void gotoIotDashboardScreenWait(){
		gotoIotDashboardScreen();
		scrollPageDown();
		String val="";
		for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(200); stop>System.nanoTime();) {
			if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
				break;
			}
			val = pagination.getText();
			SyncUtil.waitFor(10000);
		}
	}

	public void validateIotDashboardCountWrtPagination(){
		int deviceCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		System.out.println("deviceCount: ="+deviceCount);
		Validator.assertTrue(apiBase.getIotDashboardCount().get("count").equals(deviceCount),"Iot Dashboard Pagination Count does not match","Iot Dashboard Pagination Count matches");
		Validator.assertTrue(Integer.toString(deviceCount).equals(iotDashboardCardCount.getText()),"Iot Dashboard Card Count does not match","Iot Dashboard Card Count matches");

	}

	public void createNewDashboard(){
		if((int)apiBase.getIotDashboardCount().get("count") == 0) {
			waitForElementToInvisible(loaderSkeleton,30000);
			Validator.assertTrue(createNewDashboard.isVisible(),"Create new Iot Dashboard is not found","Create new Iot Dashboard found");
			Validator.assertTrue(verifyDashboardFieldsWithNoCount(),"Create new Iot Dashboard fields not found","Create new Iot Dashboard fields found");
		}

	}

	public boolean verifyDashboardFieldsWithNoCount(){
		return !btnActions.isEnabled() && columnSelectionBtn.isVisible("Column Selection") && clearFilterBtn.isVisible("Clear Button") &&
				btnAddIot.isVisible("Add IOT") && btSearchinput.isVisible("Search") && btRefresh.isVisible("Refresh");
	}

	public boolean verifyTimeFocussedFields(){
		timeFocused.click();
		return dashboardField.isVisible("Dashboard") && siteDropdown.isVisible("Site Dropdown") &&
				createBtn.isVisible("Create Btn") && cancelBtn.isVisible("Cancel Btn");
	}


	public boolean verifyBeltFocusedFields(){
		beltFocused.click();
		return dashboardField.isVisible("Dashboard") && siteDropdown.isVisible("Site Dropdown") &&
				conveyorDropdown.isVisible("Conveyor Dropdown") && createBtn.isVisible("Create Btn") && cancelBtn.isVisible("Cancel Btn");
	}


	public boolean verifyDashboardTypes(){
		return beltFocused.isVisible("Belt Focused") && timeFocused.isVisible("Time Focused");
	}

	public void firstNewDashboard(){
		if((int)apiBase.getIotDashboardCount().get("count") == 0) {
			waitForElementToInvisible(loaderSkeleton,30000);
			createNewDashboard.click("New Dashsboard");
			dialogTitle.verifyText("Add Dashboard");
			Validator.assertTrue(verifyDashboardTypes(),"All Dashboard types are not found","All Dashboard types found");
			Validator.assertTrue(timeFocused.getAttribute("class").contains("p-radiobutton-checked"),"Time focused type was not defaulted","Time focused type was defaulted");
			Validator.assertTrue(verifyTimeFocussedFields(),"All fields for time focussed dashboard is not found","All fields for time focussed dashboard found");
			Validator.assertTrue(verifyBeltFocusedFields(),"All fields for belt focussed dashboard is not found","All fields for belt focussed dashboard found");
		}

	}

	public void iotPaginationLimit(){
		Validator.assertTrue(btPageLimit.getText().equalsIgnoreCase(String.valueOf(driver.findElements(By.xpath("//tbody/tr")).size())),"Pagination initial page limit is incorrect", "Pagination for page limit is verified successfully");
		dropdownSelect(btPageDropdown, ListItem, "25");
		Validator.assertTrue(btPageLimit.getText().equalsIgnoreCase(String.valueOf(driver.findElements(By.xpath("//tbody/tr")).size())),"Pagination after change page limit is incorrect", "Pagination for page limit is verified successfully");
		dropdownSelect(btPageDropdown, ListItem, "50");
		Validator.assertTrue(btPageLimit.getText().equalsIgnoreCase(String.valueOf(driver.findElements(By.xpath("//tbody/tr")).size())),"Pagination after change page limit is incorrect", "Pagination for page limit is verified successfully");
	}

	public boolean searchDashboard(String dashboardName) {
		gotoIotDashboardScreenWait();
		btSearchinput.type(dashboardName, "Dashboard Search");
		waitForElementToDisplay(cbCheckbox);
		return cbCheckbox.isVisible("Dashboard Found");
	}

	public void selectingDashboard(String conveyorName) {
		SyncUtil.waitFor(500);
		waitForElementVisible(btSearchinput,5000,500);
		btSearchinput.type(conveyorName, "Dashboard Search");
		waitForElementToDisplay(cbCheckbox);
		cbCheckbox.click();
	}

	public boolean singleActionFunctionality() {
		crActions.click("Actions");
		waitForElementToDisplay(btnDuplicate);
		return btnEdit.isVisible("Edit") &&  btnDelete.isVisible("Delete") && btnDuplicate.isVisible("Duplicate");
	}


	public boolean multiActionFunctionality() {
		crActions.click("Actions");
		waitForElementToDisplay(btnDelete);
		return !btnEdit.isVisible() &&  btnDelete.isVisible("Delete") && !btnDuplicate.isVisible();
	}

	public boolean duplicateBtnFunctionality(String dashboardName) {
		selectingDashboard(dashboardName);
		crActions.click("Actions");
		waitForElementToDisplay(btnDuplicate);
		btnDuplicate.click("Duplicate");
		btRefresh.click("Refresh");
		return searchDashboard(dashboardName+" - copy");
	}

	public boolean createDefaultTypeIotDashboard(String dashboardName, String siteName) {
		SyncUtil.waitFor(5000);
		btnAddIot.click();
		Validator.assertTrue(timeFocused.getAttribute("class").contains("p-radiobutton-checked"),"Time focused type was not defaulted","Time focused type was defaulted");
		dashboardField.type(dashboardName);
		dropdownSelectSearch(siteDropdown, tbDropdownInput, siteName);
		createBtn.click("create");
		waitForElementToInvisible(buttonLoader,10000);
		return !dialogTitle.isVisible();
	}

	public boolean goToDashboardOnViewMode(String dashboard) {
		searchDashboard(dashboard);
		ddViewicon.click();
		waitForElementToInvisible(skeleton,30000);
		return iotHeader.getText().equalsIgnoreCase(dashboard);
	}

	public boolean isNewWidgetAdd() {
		return createNewWidget.isVisible("Create New Widget");
	}

	public boolean addWidgetNav() {
		createNewWidget.click("Create New Widget");
		return addWidget.isVisible();
	}

	public boolean createWidgetOptions() {
		return cordDamageSummaryWidget.isVisible("Cord Summary") && linkAnotherPageWidget.isVisible("Link Another widget") && spliceSummaryWidget.isVisible("Splice Summary") && segmentSummaryWidget.isVisible("Segment Summary")
				&& damageDensityWidget.isVisible("Damage Density") && spliceParameterWidget.isVisible("Splice Parameter");
	}

	public boolean createWidgetButtons() {
		return cancelBtn.isVisible("Cancel") && addWidget.isVisible("Add Widget");
	}

	public boolean addNewWidgetUI() {
		return createNewWidget.isVisible("create new widget") && createNewWidgetSubtext.isVisible("subText") && widgetEdit.isVisible("Widget Edit")
				&& timeSelector.isVisible("time selector") && btnAddIot.isVisible("Add IOT") && btRefreshWidget.isVisible("Refresh");
	}

	public void verifyAddNewWidgetSubText() {
		Validator.assertTrue(createNewWidgetSubtext.getText().equalsIgnoreCase("Let's create and configure your first dashboard"),"New Widget sub text is not matching", "New Widget sub text verified successfully");
	}

	public boolean verifyCancelButtons() {
		cancelBtn.click("Cancel");
		SyncUtil.waitFor(2000);
		System.out.println(addWidget.isVisible());
		return true;
	}

	public boolean createWidgetFromAddIcon(String widgetType) {
		btnAddIot.click("Add icon");
		selectWidget(widgetType);
		addWidget.click();
		waitForElementToInvisible(buttonLoader,10000);
		return !dialogTitle.isVisible();
	}

	public boolean createWidget(String widgetType) {
		addWidgetNav();
		selectWidget(widgetType);
		addWidget.click();
		waitForElementToInvisible(buttonLoader,10000);
		return !dialogTitle.isVisible();
	}

	public String getWidgetMonitoringDevice() {
		return widgetMonitoringDevice.getText();
	}

	public boolean verifyExpandFunctionality(String widgetType, String monitoringDevice) {
		widgetExpand.click();
		Validator.assertTrue(dialogTitle.getText().equalsIgnoreCase(widgetType), "Dialog title doesnt match", "Dialog title verified successfully");
		Validator.assertTrue(monitoringDeviceTitle.getText().equalsIgnoreCase(monitoringDevice), "Dialog title doesnt match", "Dialog title verified successfully");
		btnClose.click("Dialog close");
		return !dialogTitle.isVisible();
	}

	public boolean verifyInfoFunctionality(String widgetType) {
		widgetIcon.click();
		Validator.assertTrue(dialogTitle.getText().equalsIgnoreCase("Info: "+widgetType), "Dialog title doesnt match", "Dialog title verified successfully");
		Validator.assertTrue(infoContentText.isVisible(), "Info text not found under widget more", "Info text verified successfully");
		Validator.assertTrue(infoContentImg.isVisible(), "Info image button not found under widget more", "Info image verified successfully");
		btnClose.click("Dialog close");
		return !dialogTitle.isVisible();
	}

	public boolean verifyMoreFunctionality() {
		widgetMore.click();
		Validator.assertTrue(moreConfigure.isVisible(), "Configure button not found under widget more", "Configure button verified successfully");
		Validator.assertTrue(moreDelete.isVisible(), "Delete button not found under widget more", "DDelete button verified successfully");
		btnClose.click("Dialog close");
		return !dialogTitle.isVisible();
	}

	public String getWidgetTitle() {
		waitForElementToInvisible(widgetLoader,10000);
		System.out.println(widgetTitle.getText());
		return widgetTitle.getText();
	}

	public void selectWidget(String widgetType) {
		switch (widgetType) {
			case "Cord Damage Summary":
				cordDamageSummaryWidget.click();
				break;
			case "Link Another Widget":
				linkAnotherPageWidget.click();
				break;
			case "Splice Summary":
				spliceSummaryWidget.click();
				break;
			case "Segment Summary":
				segmentSummaryWidget.click();
				break;
			case "Damage Density":
				damageDensityWidget.click();
				break;
			case "Splice parameter":
				spliceParameterWidget.click();
				break;
			default:
				break;
		}
	}

	public boolean unlikedWidgetUI() {
		return configureWidget.isEnabled() && widgetTitle.isVisible("Widget title") && widgetExpand.isVisible("Expand")
				&& widgetIcon.isVisible("info Icon") && widgetMore.isVisible("More Icon");
	}

	public boolean configureSummaryWidget(String monitoringDevice) {
		configureWidget.click();
		dropdownSelectSearch(monitoringDropdown,dropdownInput,monitoringDevice);
		createBtn.click("create");
		waitForElementToInvisible(buttonLoader,10000);
		return !dialogTitle.isVisible();
	}


	public boolean configureLinkWidget(String title, String url, String description) {
		configureWidget.click();
		titleInput.type(title);
		urlInput.type(url);
		descriptionInput.type(description);
		createBtn.click("create");
		waitForElementToInvisible(buttonLoader,10000);
		return !dialogTitle.isVisible();
	}

	public boolean configureSpliceParameterWidget(String monitoringDevice, String spliceNum) {
		configureWidget.click();
		dropdownSelectSearch(monitoringDropdown,dropdownInput,monitoringDevice);
		spliceNumInput.type(spliceNum);
		dataTypesDropdown.click();
		allDataTypes.click();
		dataTypesDropdown.click();
		createBtn.click("create");
		waitForElementToInvisible(buttonLoader,10000);
		return !dialogTitle.isVisible();
	}

	public boolean isEditDashboard() {
		return widgetEdit.isEnabled();
	}
}
