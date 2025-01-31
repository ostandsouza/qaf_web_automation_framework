package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.mobile.flutter.app.pages.DashboardPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.math.MathContext;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.testng.Assert.assertEquals;

public class MonitoringDevicePage extends BasePage {

	CoverWearPage coverWearPage = new CoverWearPage();
	@FindBy(locator = "xpath=//button//chevronlefticon")
	public CustomElement carouselLeftIcon;
	@FindBy(locator = "xpath=//button//chevronrighticon")
	public CustomElement carouselRightIcon;

	@FindBy(locator = "xpath=(//app-card//div[text()='Monitoring Devices'])[1]")
	public CustomElement monitoringDeviceCardHeader;
	@FindBy(locator = "xpath=(//i[@class='ctp-icon-Instaloled-Devices'])[1]")
	public CustomElement monitoringDeviceCardLogo;
	@FindBy(locator = "xpath=(//app-card//div[text()='Monitoring Devices'])[1]/../div/div/div/span")
	public CustomElement monitoringDeviceCardCount;

	@FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
	public CustomElement pagination;
	@FindBy(locator="xpath=//input[@placeholder='Search']")
	public CustomElement btSearchinput;

	@FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
	public CustomElement home;
	@FindBy(locator = "xpath=(//li//span[text()='Monitoring Devices'])[1]")
	public CustomElement monitoringDeviceList;
	@FindBy(locator="xpath=(//td//p-tablecheckbox)[1]")
	public CustomElement crCheckbox;
	@FindBy(locator="xpath=(//button/chevrondownicon)[2]")
	public CustomElement btActions;

	@FindBy(locator="xpath=//li//span[text()='Edit']")
	public CustomElement btEdit;

	@FindBy(locator="xpath=//span[text()='Delete']")
	public CustomElement btDelete;

	@FindBy(locator="xpath=//span[text()='Scan QR']")
	public CustomElement btScan;
	@FindBy(locator="xpath=//li//span[text()='Export PDF']")
	public CustomElement btExportPdf;
	@FindBy(locator="xpath=//li//span[text()='Export CSV']")
	public CustomElement btExportCsv;

	@FindBy(locator="xpath=//th[@id='site-col']")
	public CustomElement siteColumn;

	@FindBy(locator = "//button[contains(@class, \"p-column-filter-menu-button-active\")]")
	public CustomElement appliedFilter;

	@FindBy(locator = "xpath=(//button[@icon='ctp-icon-Clear-Filters'])[2]")
	public CustomElement clearFilterBtn;

	@FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
	public CustomElement paginationEntry;

	@FindBy(locator="xpath=//p-columnfilterformelement//input")
	public CustomElement filterText;
	@FindBy(locator="xpath=//span[text()='Apply']")
	public CustomElement applyBtn;
	@FindBy(locator="xpath=//button[@icon='ctp-icon-map-marker']")
	public CustomElement locationIcon;
	@FindBy(locator="xpath=//div[@role='dialog']")
	public CustomElement dialogBox;
	@FindBy(locator="xpath=//div[contains(@class,'p-dialog-header')]//span")
	public CustomElement locationPopHeader;
	@FindBy(locator="xpath=//div[contains(@class,'p-dialog-header')]//button")
	public CustomElement locationPopCloseBtn;
	@FindBy(locator="xpath=//button[text()='Map']")
	public CustomElement locationPopMapBtn;
	@FindBy(locator="xpath=//button[text()='Satellite']")
	public CustomElement locationPopSatelliteBtn;
	@FindBy(locator="xpath=//button[@aria-label='Toggle fullscreen view']")
	public CustomElement locationPopFullScreenBtn;
	@FindBy(locator="xpath=//button[@aria-label='Zoom in']")
	public CustomElement locationPopZoomInBtn;
	@FindBy(locator="xpath=//button[@aria-label='Zoom out']")
	public CustomElement locationPopZoomOutBtn;
	@FindBy(locator="xpath=//label[text()='Latitude']/..//input")
	public CustomElement locationPopLatBtn;
	@FindBy(locator="xpath=//label[text()='Longitude']/..//input")
	public CustomElement locationPopLonBtn;

	@FindBy(locator="xpath=//button[@aria-label='Drag Pegman onto the map to open Street View']/div")
	public CustomElement locationPopPegManBtn;
	@FindBy(locator="xpath=//button[@aria-label='Drag Pegman onto the map to open Street View']//img[3]")
	public CustomElement locationPopPegManImg;
	@FindBy(locator="xpath=//button[@aria-label='Exit the Street View']")
	public CustomElement streetViewExitBtn;
	@FindBy(locator="xpath=//div[@aria-label='Street View']")
	public CustomElement locationPopStreetView;
	@FindBy(locator="xpath=(//div[@title='wTest123']//img)[1]")
	public CustomElement monitoringDeviceIcon;

	@FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
	public CustomElement btAddMonitoringDevice;

	@FindBy(locator = "xpath=//div[@class='p-breadcrumb p-component' and contains(., \"Monitoring Devices\")]")
	public CustomElement monitoringDeviceBreadCrumb;

	@FindBy(locator = "xpath=//input[@formcontrolname='deviceName']")
	public CustomElement tbDeviceName;
	@FindBy(locator= "xpath=(//p-dropdown//div[contains(@class,\"master-data-dropdown\")])[1]")
	public CustomElement deviceTypeDropDown;
	@FindBy(locator= "xpath=//input[contains(@class,'p-dropdown-filter')]")
	public CustomElement tbDeviceTypedropdown;

	@FindBy(locator= "xpath=//p-calendar[@formcontrolname='installationDate']//input")
	public CustomElement tbInstallationDate;
	@FindBy(locator= "xpath=//google-map")
	public CustomElement mapGoogle;
	@FindBy(locator= "xpath=//div[@aria-label='Map']")
	public CustomElement mapContainer;

	@FindBy(locator ="//div[@class='map-container']//div[@class='gm-style']/div/div[2]")
	public CustomElement mapLocation;
	@FindBy(locator = "//div[@role='dialog']")
	public CustomElement positionDialog;
	@FindBy(locator = "//input[@formcontrolname='latitude' and contains(@class, 'p-filled')]")
	public CustomElement tbLatValue;
	@FindBy(locator = "//input[@formcontrolname='longitude' and contains(@class, 'p-filled')]")
	public CustomElement tbLongValue;

	@FindBy(locator="xpath=(//button/span[text()='Actions'])[2]")
	public CustomElement btActionsLabel;
	@FindBy(locator="xpath=//p-multiselect[@placeholder='Columns selection']")
	public CustomElement btColumnSelectionLabel;
	@FindBy(locator="xpath=(//button[@icon='pi pi-refresh'])[2]")
	public CustomElement btRefreshIcon;

	@FindBy(locator= "xpath=//span[contains(@class,\"p-steps-title\") and contains(text(),\"Add Location\")]")
	public CustomElement addLocationTitle;
	@FindBy(locator= "xpath=(//app-conveyor-picker//p-dropdown//div[contains(@class,\"p-dropdown\")])[1]")
	public CustomElement conveyorDDL;
	@FindBy(locator= "xpath=(//app-company-picker//p-dropdown//div[contains(@class,\"p-dropdown\")])[1]")
	public CustomElement associatedDistDDL;
	@FindBy(locator= "xpath=(//app-company-picker//p-dropdown//div[contains(@class,\"p-dropdown\")])[3]")
	public CustomElement siteDDL;
	@FindBy(locator= "xpath=//span[text()='Device Location']")
	public CustomElement deviceLocationLabel;
	@FindBy(locator = "xpath=(//span[text()='Cancel'])[2]")
	public CustomElement btnCancel;
	@FindBy(locator = "xpath=//span[text()='Create']")
	public CustomElement btnCreate;
	@FindBy(locator = "xpath=//div[@aria-label='New Device']")
	public CustomElement monitoringDeviceMapIcon;
	@FindBy(locator = "xpath=//div[@aria-label='Head']")
	public CustomElement monitoringDeviceMapHeadIcon;
	@FindBy(locator = "xpath=//div[@aria-label='Tail']")
	public CustomElement monitoringDeviceMapTailIcon;

	@FindBy(locator = "xpath=//input[@formcontrolname='deviceBrand']")
	public CustomElement tbDeviceBrand;
	@FindBy(locator = "xpath=//input[@formcontrolname='serialNumber']")
	public CustomElement tbSerialNo;
	@FindBy(locator = "xpath=//input[@formcontrolname='firmwareVersion']")
	public CustomElement tbFirmwareVersion;
	@FindBy(locator= "xpath=//p-calendar[@formcontrolname='commisioningDate']//input")
	public CustomElement tbcommisioningDate;
	@FindBy(locator= "xpath=//input[@formcontrolname='beltConveyorSaves']")
	public CustomElement tbBeltConveyorSaves;

	@FindBy(locator= "xpath=(//p-dropdown//div[contains(@class,'master-data-dropdown')])[2]")
	public CustomElement remoteConnectionDropDown;
	@FindBy(locator= "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"Local only\"]")
	public CustomElement ddlSelectLocalOnly;
	@FindBy(locator= "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"3G/4G router\"]")
	public CustomElement ddlSelect3G4GRouter;
	@FindBy(locator= "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"VPN through mine site\"]")
	public CustomElement ddlSelectVPNMineSite;

	@FindBy(locator = "xpath=//input[@formcontrolname='systemSoftwareLink']")
	public CustomElement tbSystemSoftwareLink;
	@FindBy(locator = "xpath=//button[@icon='ctp-icon-link' and @disabled]")
	public CustomElement disabledLinkIcon;
	@FindBy(locator = "xpath=//button[@icon='ctp-icon-link']")
	public CustomElement enabledLinkIcon;

	@FindBy(locator = "xpath=//button[@icon='ctp-icon-Instaloled-Devices']")
	public CustomElement iotIcon;

	@FindBy(locator = "xpath=(//div[@id='chartArea'])[1]")
	public CustomElement iotChart1;

	@FindBy(locator = "xpath=(//div[@id='chartArea'])[2]")
	public CustomElement iotChart2;

	@FindBy(locator = "xpath=(//div[@id='chartArea'])[3]")
	public CustomElement iotChart3;

	@FindBy(locator = "xpath=(//button[@disabled]//span[text()='Actions'])[1]")
	public CustomElement actionBtnDisabled;
	@FindBy(locator = "xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
	public CustomElement forwardNavBtn;
	@FindBy(locator="xpath=//angledoublerighticon")
	public CustomElement btPgDoubleForwardBtn;
	@FindBy(locator="xpath=//angledoublelefticon")
	public CustomElement btPgDoubleBackwardBtn;
	@FindBy(locator="xpath=//p-dropdown//span")
	public CustomElement paginationDropDownValue;

	@FindBy(locator="xpath=//p-paginator//button[contains(@class,'p-highlight')]")
	public CustomElement btPgHighlightedValue;
	@FindBy(locator="xpath=(//th[@psortablecolumn][3]//div)[1]")
	public CustomElement btxValue;
	@FindBy(locator="xpath=//div[@class='p-multiselect-label']")
	public CustomElement btyValue;

    @FindBy(locator="xpath=//span[text()='Edit']")
    public CustomElement editBtn;
    @FindBy(locator="xpath=//span[text()='Scan QR']")
    public CustomElement scanQRBtn;
    @FindBy(locator="xpath=//span[text()='Delete']")
    public CustomElement deleteBtn;

    @FindBy(locator = "xpath=//p-tieredmenusub//ul[@role=\"menu\"]")
    public CustomElement btActionsPopup;

    @FindBy(locator = "xpath=//p-multiselectitem//li[contains(., 'Belt Width') and .//div[contains(@class, 'p-checkbox')]]")
    public CustomElement cbBeltWidth;

    @FindBy(locator = "xpath=//p-multiselectitem//li[contains(., 'Belt/Conveyor Saves') and .//div[contains(@class, 'p-checkbox')]]")
    public CustomElement cbBeltSaves;

    @FindBy(locator="xpath=//div[contains(@class,\"p-dialog-header\")]//span")
    public CustomElement scanHeader;
    @FindBy(locator="xpath=//qrcode//div[@class=\"qrcode\"]")
    public CustomElement scannerImg;
    @FindBy(locator = "//button[contains(@class,\"p-dialog-header-close\")]")
    public CustomElement btnDialogClose;
    @FindBy(locator = "//button[@type=\"button\"]//span[text()=\"Download\"]")
    public CustomElement btnDownload;
    @FindBy(locator="xpath=(//span[contains(@class,'pi-spinner')])[2]")
    public CustomElement downloadSpinner;

	@FindBy(locator= "xpath=//p-calendar[@formcontrolname='installationDate']//input[@placeholder=\"MM/DD/YYYY\"]")
	public CustomElement tbInstallationDateFormat;
	@FindBy(locator= "xpath=//p-calendar[@formcontrolname='commisioningDate']//input[@placeholder=\"MM/DD/YYYY\"]")
	public CustomElement tbCommissioningDateFormat;

	@FindBy(locator= "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"LoadSense\"]")
	public CustomElement ddlSelectLoadSense;
	@FindBy(locator= "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"RipProtect\"]")
	public CustomElement ddlSelectRipProtect;
	@FindBy(locator= "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"MultiProtect\"]")
	public CustomElement ddlSelectMultiProtect;
	@FindBy(locator= "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"CordProtect\"]")
	public CustomElement ddlSelectCordProtect;
	@FindBy(locator= "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"Other\"]")
	public CustomElement ddlSelectOther;

    @FindBy(locator = "xpath=//span[contains(@class,\"p-steps-title\") and text()=\" Add Device\"]")
    public CustomElement addDeviceTitle;

    @FindBy(locator= "xpath=//span[contains(@class,\"p-steps-title\") and contains(text(),\"Update Device\")]")
    public CustomElement updateDeviceTitle;
    @FindBy(locator= "xpath=//button[@disabled]//span[text()=\"Create\"]")
    public CustomElement createBtnDisabled;
    @FindBy(locator="xpath=//div[contains(@class,\"p-confirm-dialog\")]")
    public CustomElement warningDialogBox;
    @FindBy(locator="xpath=//div[contains(@class,\"p-confirm-dialog\")]//div//button//span[text()=\"No\"]")
    public CustomElement btnNo;
    @FindBy(locator="xpath=//div[contains(@class,\"p-confirm-dialog\")]//div//button//span[text()=\"Yes\"]")
    public CustomElement btnYes;

    @FindBy(locator = "xpath=//span[text()='Next']")
    public CustomElement btNext;
    @FindBy(locator= "xpath=(//p-dropdown[@formcontrolname=\"status\"]//div[contains(@class,\"p-dropdown\")])[1]")
    public CustomElement statusDropDown;
    @FindBy(locator= "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li[text()=\" Running \"]")
    public CustomElement statusOptionRunning;
    @FindBy(locator= "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li[text()=\" Not in Operation \"]")
    public CustomElement statusOptionNotInOperation;
    @FindBy(locator= "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li[text()=\" Prior to Commissioning \"]")
    public CustomElement statusOptionPriorToCommissioning;
    @FindBy(locator= "xpath=//div[contains(@class,\"p-datepicker-group-container\")]")
    public CustomElement calendarPopup;
    @FindBy(locator= "xpath=//div//button[contains(@class,\"p-datepicker-month\")]\n")
    public CustomElement monthField;
    @FindBy(locator= "xpath=//div//div[contains(@class,\"p-monthpicker\")]")
    public CustomElement monthChart;
    @FindBy(locator= "xpath=//div//button[contains(@class,\"p-datepicker-prev\")]")
    public CustomElement prevBtn;
    @FindBy(locator= "xpath=//div//button[contains(@class,\"p-datepicker-next\")]")
    public CustomElement nextBtn;
    @FindBy(locator= "xpath=//div//button[contains(@class,\"p-datepicker-year\")]")
    public CustomElement yearField;
    @FindBy(locator= "xpath=//div//div[contains(@class,\"p-yearpicker\")]")
    public CustomElement yearChart;
    @FindBy(locator= "xpath=(//td//span[contains(@class, 'p-disabled')])[1]")
    public CustomElement disabledDate;
    @FindBy(locator = "xpath=//span[text()='Create']")
    public CustomElement btCreate;
    @FindBy(locator = "xpath=//button[contains(@class, 'p-button') and contains(@class, 'p-button-outlined')]")
    public CustomElement btCancelStyle;
    @FindBy(locator = "xpath=(//button[contains(@class,\"p-button\")])[4]")
    public CustomElement btCreateStyle;

    @FindBy(locator = "xpath=//button//span[text()=\"Save\"]")
    public CustomElement btSave;
    @FindBy(locator = "xpath=//div//span[contains(@class,\"title\")and contains(text(),\"Device Location\")]")
    public CustomElement deviceLocationHeader;
    @FindBy(locator="xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
    public CustomElement crViewIcon;
    @FindBy(locator="xpath=(//p-dropdown//div[contains(@class,\"master-data-dropdown\")])[1]//span")
    public CustomElement deviceTypeField;

	@FindBy(locator="xpath=//button[contains(@class,'p-button-loading')]")
	public CustomElement buttonLoader;

	@FindBy(locator = "xpath=//span[text()='Yes']")
	public CustomElement crYesConfirmation;

	@FindBy(locator = "xpath=//td[contains(text(),'No')]")
	public CustomElement noList;

	public void clickCarouselLeftIcon(){
		waitForElementVisible(carouselLeftIcon,5000,500);
		carouselLeftIcon.click("Carsouel Left");
	}
	public void clickCarouselRightIcon(){
		waitForElementVisible(carouselRightIcon,5000,500);
		carouselRightIcon.jsClick("Carsouel Right");
	}
	public void verifyBeltMonitoringCardDetails(){
		waitForPageLoad(5000);
		System.out.println("check");
		SyncUtil.waitFor(20000);
		waitForElementVisible(monitoringDeviceCardHeader,5000,500);
		Validator.assertTrue(monitoringDeviceCardHeader.isDisplayed(),"Monitoring Device Card is not visible","Monitoring Device Card is visible");
		Validator.assertTrue(monitoringDeviceCardLogo.isDisplayed(),"Monitoring Device Logo is not visible","Monitoring Device Logo is visible");
		System.out.println(apiBase.getMonitoringDeviceCount().get("count"));
		Validator.assertTrue(apiBase.getMonitoringDeviceCount().get("count").toString().equals(monitoringDeviceCardCount.getText()),"Monitoring Device Card Count does not match","Monitoring Device Card Count matches");
	}

    public void goToMonitoringDeviceListScreen() {
        if (!monitoringDeviceList.isVisible())
            home.click("Home");
        monitoringDeviceList.jsClick("Monitoring devices List");
        btSearchinput.isVisible("Monitoring devices List Page");
    }

    public void goToMonitoringDeviceListScreenAndWait() {
        goToMonitoringDeviceListScreen();
        scrollPageDown();
        String val = "";
        for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(180); stop > System.nanoTime(); ) {
            if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
                break;
            }
            val = pagination.getText();
            SyncUtil.waitFor(10000);
        }
    }

	public boolean searchMonitoringDevice(String monitoringDeviceName){
		goToMonitoringDeviceListScreenAndWait();
		btSearchinput.type(monitoringDeviceName, "Monitoring Device Name Search");
		waitForElementToDisplay(crCheckbox);
		return crCheckbox.isVisible("Conveyor Found");
	}

	public void editMonitoringDevice(String device, String newdevice){
		goToMonitoringDeviceEditScreen(device);
		waitForElementToDisplay(tbDeviceName);
		tbDeviceName.type(newdevice,"Device name");
		btSave.click();
		waitForElementToInvisible(buttonLoader,10000);
	}

	public boolean deleteMonitoringDevice(String calc){
		searchMonitoringDevice(calc);
		crCheckbox.check("Monitoring Checkbox");
		btActions.click("Actions");
		waitForElementVisible(deleteBtn, 20000,500);
		deleteBtn.click("Delete");
		crYesConfirmation.click("Confirm");
		waitForElementToDisplay(noList);
		return noList.isVisible();
	}

	public void verifyDeletedMonitoringDevice(String calc) {
		goToMonitoringDeviceListScreen();
		waitForPageLoad(10000);
		btSearchinput.type(calc, "Calc Search");
		Validator.assertTrue(noList.isVisible(),"Delete Monitoring Device was still found in list screen","Monitoring Device deleted successfully");
	}

	public void clickCheckBox(){
		waitForElementToDisplay(crCheckbox);
		crCheckbox.click();
	}
	public void verifyMonDevActionBtnFuntionalityOnSelection(){
		waitForElementToDisplay(btActions);
		btActions.click("Action Button");
		waitForElementToDisplay(btDelete);
		Validator.assertTrue(btExportPdf.isDisplayed(),"Export Pdf is not visible","Export Pdf is visible");
		Validator.assertTrue(btExportCsv.isDisplayed(),"Export Csv is not visible","Export Csv is visible");
		Validator.assertTrue(btDelete.isDisplayed(),"Delete is not visible","Delete is visible");
		Validator.assertTrue(btEdit.isDisplayed(),"Edit is not visible","Edit is visible");
		Validator.assertTrue(btScan.isDisplayed(),"Scan is not visible","Scan is visible");
	}
	public void verifyMonDevActionBtnFuntionalityOnDefault(){
		waitForElementToDisplay(btActions);
		btActions.click("Action Button");
		waitForElementToDisplay(btExportPdf);
		Validator.assertTrue(btExportPdf.isDisplayed(),"Export Pdf is not visible","Export Pdf is visible");
		Validator.assertTrue(btExportCsv.isDisplayed(),"Export Csv is not visible","Export Csv is visible");
	}

	////
	public void verifyColumnFilterClick(int noOfCoverWears,String cloumnName,String filter)
	{
		waitForElementVisible(driver.findElement(By.xpath("//th[@id='"+cloumnName+"']")),5000,500);
		hoverOverElement(driver.findElement(By.xpath("//th[@id='"+cloumnName+"']")));
		waitForElementVisible(appliedFilter,10000,500);
		for (int i = 1; i <= noOfCoverWears; i++)
		{
			String tdText = driver.findElement(By.xpath("//table//tr["+ i +"]/td[3]")).getText(); // Get the text of the td element

			if (tdText.startsWith(filter)) // Check if the text starts with 'w'
			{
				// If the filter is applied, assert it for this row
				Validator.assertTrue(true, "Filter is not applied for row ","filter is applied");
			} else {
				// If the filter is not applied, assert it for this row
				System.out.println("No filter applied for row " + i);
				// Add your assertion code here
			}
		}
	}
	public void clearFilterClick()
	{
		waitForElementVisible(clearFilterBtn,10000,500);
		clearFilterBtn.click();
	}

	public void verifyFilterIsRemoved(String cloumnName)
	{
		waitForElementVisible(driver.findElement(By.xpath("//th[@id='"+cloumnName+"']")),5000,500);
		hoverOverElement(driver.findElement(By.xpath("//th[@id='"+cloumnName+"']")));
		Validator.assertTrue(appliedFilter.isNotVisible(10000),"filter is not removed","filter is removed");
	}
	public void applyColumnFilterClick(String cloumnName,String filterName,String filter)
	{
		waitForElementVisible(driver.findElement(By.xpath("//th[@id='"+cloumnName+"']")),5000,500);
		hoverOverElement(driver.findElement(By.xpath("//th[@id='"+cloumnName+"']")));
		waitForElementVisible(driver.findElement(By.xpath("//p-columnfilter[@field='"+filterName+"']")),5000,500);
		driver.findElement(By.xpath("//p-columnfilter[@field='"+filterName+"']")).click();
		waitForElementVisible(filterText,5000,500);
		filterText.type(filter);
		waitForElementVisible(applyBtn,5000,500);
		applyBtn.click();
	}

	public void clickOnZoomIn()
	{
		waitForElementVisible(locationPopZoomInBtn,5000,500);
		locationPopZoomInBtn.jsClick();

	}
	public void clickOnZoomOut()
	{
		waitForElementVisible(locationPopZoomOutBtn,5000,500);
		locationPopZoomOutBtn.jsClick();
	}
	public void addDeviceDetailsWithNonMandatoryFields(String brand,String serialNo,String remoteConnection,String comminsionDate,String beltConveyorSave,String firmwareVersion,String systemLink)
	{
		waitForElementVisible(tbDeviceBrand,10000,500);
		tbDeviceBrand.sendKeys(brand,"Device brand");
		tbSerialNo.sendKeys(serialNo,"serialNumber");
		tbFirmwareVersion.sendKeys(firmwareVersion,"Firmware Version");
		verifyRemoteConnectionDDL();
		dropdownSelectSearch(remoteConnectionDropDown, tbDeviceTypedropdown, remoteConnection);
		waitForElementVisible(tbcommisioningDate,10000,500);
		tbcommisioningDate.click("commisioningDate");
		coverWearPage.selectGivenDate(comminsionDate);
		tbBeltConveyorSaves.sendKeys(beltConveyorSave,"Belt/Conveyor Saves");
		Validator.assertTrue(tbSystemSoftwareLink.isDisplayed(),"Access to System Software is not visible","Access to System Software is visible");
		tbSystemSoftwareLink.sendKeys(systemLink,"Access to System Software");
	}

	/////
	public void clickAndVerifyLocationPopUp(String monitoringDevice)
	{
		waitForElementVisible(locationIcon,5000,500);
		locationIcon.click();
		waitForElementVisible(dialogBox,5000,1000);
		Validator.assertTrue(dialogBox.isDisplayed(),"Dialogbox is not displayed","Dialogbox is displayed");
		Validator.assertTrue(locationPopHeader.getText().equalsIgnoreCase(monitoringDevice),"Location Pop Up header mismatch","Location Pop Up header matched");
		Validator.assertTrue(locationPopCloseBtn.isDisplayed(),"Close Button is not visible","Close Button is visible");
		Validator.assertTrue(locationPopMapBtn.isDisplayed(),"Map Button is not visible","Map Button is visible");
		Validator.assertTrue(locationPopSatelliteBtn.isDisplayed(),"Satellite Button is not visible","Satellite Button is visible");
		Validator.assertTrue(locationPopFullScreenBtn.isDisplayed(),"Full Screen Button is not visible","Full Screen Button is visible");
		Validator.assertTrue(locationPopZoomInBtn.isDisplayed(),"Zoom In Button is not visible","Zoom In Button is visible");
		Validator.assertTrue(locationPopZoomOutBtn.isDisplayed(),"Zoom Out Button is not visible","Zoom Out Button is visible");
		Validator.assertTrue(locationPopPegManBtn.isDisplayed(),"PegMan Button is not visible","PegMan Button is visible");
		Map<String, Object> val = DashboardPage.getInstance().apiBase.getMonitoringDeviceAPI(monitoringDevice);
		Validator.assertTrue(locationPopLatBtn.isDisplayed(),"Latitude Button is not visible","Latitude Button is visible");
		Validator.assertTrue(locationPopLonBtn.isDisplayed(),"Longitude Button is not visible","Longitude Button is visible");

		BigDecimal displayedLatitudeRounded = new BigDecimal(locationPopLatBtn.getAttribute("value")).round(new MathContext(8, RoundingMode.HALF_UP));
		String formattedDisplayedLatitude = displayedLatitudeRounded.toPlainString();
		BigDecimal displayedLongitudeRounded = new BigDecimal(locationPopLonBtn.getAttribute("value")).round(new MathContext(8, RoundingMode.HALF_UP));
		String formattedDisplayedLongitude= displayedLongitudeRounded.toPlainString();

		String apiLatitude = String.valueOf(((Map<String, Object>) val.get("monitoringLocation")).get("latitude"));
		String apiLongitude = String.valueOf(((Map<String, Object>) val.get("monitoringLocation")).get("longitude"));

		String latitudeToVerify = formattedDisplayedLatitude.length() > 5 ? formattedDisplayedLatitude.substring(0, 5) : formattedDisplayedLatitude;
		String longitudeToVerify = formattedDisplayedLongitude.length() > 5 ? formattedDisplayedLongitude.substring(0, 5) : formattedDisplayedLongitude;
		String apiLatitudeToVerify = apiLatitude.length() > 5 ? apiLatitude.substring(0, 5) : apiLatitude;
		String apiLongitudeToVerify = apiLongitude.length() > 5 ? apiLongitude.substring(0, 5) : apiLongitude;

		Validator.assertTrue(
				latitudeToVerify.equals(apiLatitudeToVerify),
				"Latitude Button is not visible or the latitude value does not match",
				"Latitude Button is visible and the latitude value matches"
		);
		Validator.assertTrue(
				formattedDisplayedLongitude.contains(
						String.valueOf(((Map<String, Object>) val.get("monitoringLocation")).get("longitude"))
				),
				"Longitude Button is not visible or the Longitude value does not match",
				"Longitude Button is visible and the Longitude value matches"
		);


	}
	public void verifyMapAndSatelliteBtn()
	{
		waitForElementVisible(locationPopMapBtn,5000,500);
		locationPopMapBtn.click("Location Pop Map button");
		Validator.assertTrue(locationPopMapBtn.getAttribute("aria-checked").equalsIgnoreCase("true"),"Map Button is not checked","Map Button is checked");
		Validator.assertTrue(locationPopSatelliteBtn.getAttribute("aria-checked").equalsIgnoreCase("false"),"Map Button is not checked","Map Button is checked");
		locationPopSatelliteBtn.click("Location Pop Satellite button");
		Validator.assertTrue(locationPopSatelliteBtn.getAttribute("aria-checked").equalsIgnoreCase("true"),"Map Button is not checked","Map Button is checked");
		Validator.assertTrue(locationPopMapBtn.getAttribute("aria-checked").equalsIgnoreCase("false"),"Map Button is not checked","Map Button is checked");
	}
	public void verifyPegManFunctionality()
	{
		waitForElementVisible(locationPopPegManBtn,5000,500);
		hoverOverElement(locationPopPegManBtn);
//        Validator.assertTrue(locationPopPegManBtn.getAttribute("title").equalsIgnoreCase("Drag Pegman onto the map to open Street View"),"Map Button is not checked","Map Button is checked");
		System.out.println("check");
		SyncUtil.waitFor(2000);
//        Actions element = new Actions(driver);
//        element.moveToElement(locationPopPegManBtn)
//                .pause(Duration.ofSeconds(1))
//                .clickAndHold(locationPopPegManBtn).pause(Duration.ofSeconds(1))
////                .moveByOffset(locationPopPegManBtn.getLocation().x-(mapGoogle.getLocation().x+mapGoogle.getSize().width/2),locationPopPegManBtn.getLocation().y-(mapGoogle.getLocation().y+mapGoogle.getSize().height/2)) //change the x, y values to be applicable for your cases
////                .moveByOffset(locationPopPegManBtn.getLocation().x-(mapGoogle.getLocation().x+mapGoogle.getSize().width/2),locationPopPegManBtn.getLocation().y-(mapGoogle.getLocation().y+mapGoogle.getSize().height/2)) //change the x, y values to be applicable for your cases
//                .moveByOffset(300,10)
////                .moveByOffset(100,10)
//                .pause(Duration.ofSeconds(1))
//                .release().build().perform();
//
//        System.out.println(locationPopPegManBtn.getCoordinates().toString());
////        element.dragAndDrop(locationPopPegManBtn,monitoringDeviceIcon).perform();
////        element.dragAndDropBy(locationPopPegManBtn,-10,-100).perform();
////        element.dragAndDropBy(locationPopPegManBtn,mapGoogle.getCoordinates());
//        System.out.println(locationPopPegManBtn.getLocation().x);
//        System.out.println(locationPopPegManBtn.getLocation().y);
		System.out.println(mapGoogle.getLocation().x+mapGoogle.getSize().width/2);
		System.out.println(mapGoogle.getLocation().y+mapGoogle.getSize().height/2);
		System.out.println(driver.manage().window().getSize().width/2);
		System.out.println(driver.manage().window().getSize().height/2);
////        element.dragAndDropBy(locationPopPegManBtn,locationPopPegManBtn.getLocation().x-(mapGoogle.getLocation().x+mapGoogle.getSize().width/2),locationPopPegManBtn.getLocation().y-(mapGoogle.getLocation().y+mapGoogle.getSize().height/2)).perform();
//        System.out.println(locationPopPegManImg.getCoordinates().toString());
//        SyncUtil.waitFor(10000);
		locationPopPegManBtn.jsDragAndDrop(driver.manage().window().getSize().width/2,driver.manage().window().getSize().height/2);
		Validator.assertTrue(locationPopStreetView.isDisplayed(),"Street view is not displayed","Street view is displayed");
		clickOnZoomOut();
		clickOnZoomIn();
		streetViewExitBtn.click();
		Validator.assertTrue(locationPopMapBtn.isDisplayed(),"Map view is not displayed","Map view is displayed");
	}

	public void goToAddMonitoringDevice()
	{
		waitForElementVisible(btAddMonitoringDevice,20000,500);
		waitForElementToBeClickable(btAddMonitoringDevice);
		btAddMonitoringDevice.jsClick("Add icon");
		SyncUtil.waitFor(5000);
		waitForPageLoad(15000);
		Validator.assertTrue(driver.getCurrentUrl().contains("/secure/device/add/basic-info"), "User is not navigated to Add monitoring device page", "User is navigated to Add monitoring device page");
	}

	public void verifyTableHeaderPanel()
	{
		waitForElementToDisplay(btActionsLabel);
		Validator.assertTrue(btActionsLabel.isDisplayed(),"Action Button is not visible","Action button is visible");
		Validator.assertTrue(clearFilterBtn.isDisplayed(),"Clear Filter Button is not visible","Clear Filter button is visible");
		Validator.assertTrue(btColumnSelectionLabel.isDisplayed(),"Column Selection Button is not visible","Column Selection button is visible");
		Validator.assertTrue(btSearchinput.isDisplayed(),"Search Button is not visible","Search button is visible");
		Validator.assertTrue(btAddMonitoringDevice.isDisplayed(),"Add Button is not visible","Add button is visible");
		Validator.assertTrue(btRefreshIcon.isDisplayed(),"Refresh Button is not visible","Refresh button is visible");
	}
	public void clickOnBeltMonitoringCard()
	{
		waitForElementVisible(monitoringDeviceCardHeader,5000,500);
		monitoringDeviceCardHeader.click("Monitoring Card");
	}


	public void navigateToAddLocation()
	{
		waitForElementVisible(addLocationTitle,10000,500);
		addLocationTitle.jsClick("Add Location");
		Validator.assertTrue(driver.getCurrentUrl().contains("/secure/device/add/location"),"User is not navigated to add location page","User is navigated to add location page");
	}
	public void selectConveyor(String conveyorName)
	{
		waitForElementVisible(conveyorDDL,10000,500);
		dropdownSelectSearch(conveyorDDL,tbDeviceTypedropdown,conveyorName);
	}
	public void verifyContentsOfAddLocationPage()
	{
		waitForElementVisible(deviceLocationLabel,10000,500);
		Validator.assertTrue(deviceLocationLabel.isDisplayed(),"Device Location is not visible","Device Location is visible");
		Validator.assertTrue(associatedDistDDL.isDisplayed(),"Associated Distributor Field is not visible","Associated Distributor Field is visible");
		Validator.assertTrue(siteDDL.isDisplayed(),"Site Field is not visible","Site Field is visible");
		Validator.assertTrue(conveyorDDL.isDisplayed(),"Conveyor Field is not visible","Conveyor Field is visible");
		Validator.assertTrue(locationPopLatBtn.isDisplayed(),"Latitude Button is not visible","Latitude Button is visible");
		Validator.assertTrue(locationPopLonBtn.isDisplayed(),"Longitude Button is not visible","Longitude Button is visible");
		Validator.assertTrue(locationPopMapBtn.isDisplayed(),"Map Button is not visible","Map Button is visible");
		Validator.assertTrue(locationPopSatelliteBtn.isDisplayed(),"Satellite Button is not visible","Satellite Button is visible");
		Validator.assertTrue(locationPopFullScreenBtn.isDisplayed(),"Full Screen Button is not visible","Full Screen Button is visible");
		Validator.assertTrue(locationPopZoomInBtn.isDisplayed(),"Zoom In Button is not visible","Zoom In Button is visible");
		Validator.assertTrue(locationPopZoomOutBtn.isDisplayed(),"Zoom Out Button is not visible","Zoom Out Button is visible");
		Validator.assertTrue(locationPopPegManBtn.isDisplayed(),"PegMan Button is not visible","PegMan Button is visible");
		Validator.assertTrue(btnCreate.isDisplayed(),"Create Button is not visible","Create Button is visible");
		Validator.assertTrue(btnCancel.isDisplayed(),"Cancel Button is not visible","Cancel Button is visible");
	}
	public void clickOnMap()
	{
		waitForElementVisible(mapLocation,10000,500);
		waitForElementToBeClickable(mapLocation);
		System.out.println("click");
		mapLocation.jsClick();
//        Actions element = new Actions(driver);
//        element.click(mapLocation);
	}
	public void verifyPrefilledLatLongValuesDisplayed()
	{
		SyncUtil.waitFor(5000);
		waitForElementVisible(tbLatValue,10000,500);
		waitForElementVisible(tbLongValue,10000,500);
		Validator.assertTrue(tbLatValue.isVisible() && tbLongValue.isVisible(),"The prefilled values for lat and long is not visible","The prefilled values for lat and long is visible");
	}
	public void verifyMonitoringDeviceIcon()
	{
		System.out.println("check");
		waitForElementVisible(monitoringDeviceMapHeadIcon,20000,500);
		Validator.assertTrue(monitoringDeviceMapHeadIcon.isVisible(),"Monitoring Device Head Icon is not visible","Monitoring Device Head Icon is visible");
		Validator.assertTrue(monitoringDeviceMapTailIcon.isVisible(),"Monitoring Device Tail Icon is not visible","Monitoring Device Tail Icon is visible");
//       Validator.assertTrue(monitoringDeviceMapIcon.isVisible(),"Monitoring Device Icon is not visible","Monitoring Device Icon is visible");
	}
	public void addContentsOfAddLocationPage(String associatedDistName,String siteName,String latitude,String longitude)
	{
		dropdownSelectSearch(associatedDistDDL,tbDeviceTypedropdown,associatedDistName);
		waitForElementVisible(siteDDL,5000,1000);
		SyncUtil.waitFor(2000);
		dropdownSelectSearch(siteDDL,tbDeviceTypedropdown,siteName);
//        mapLocation.click();
		clickOnMap();
		verifyPrefilledLatLongValuesDisplayed();
		verifyMonitoringDeviceIcon();
		locationPopLatBtn.type(latitude);
		locationPopLonBtn.type(longitude);
	}
	public void verifyMapFunctionalityInMonDev()
	{
		verifyMapAndSatelliteBtn();
		locationPopFullScreenBtn.click("Map full screen Icon");
		clickOnZoomOut();
		clickOnZoomIn();
//        verifyPegManFunctionality();
		locationPopFullScreenBtn.click("Map full close screen Icon");
	}
	public void validateAddDevicePage()
	{
		waitForElementVisible(tbDeviceName,5000,1000);
		Validator.assertTrue(tbDeviceName.isDisplayed(),"Not Present in Add device page","Present in Add device page");
		Validator.assertTrue(driver.getCurrentUrl().contains("/secure/device/add/basic-info"), "User is not navigated to Add monitoring device page", "User is navigated to Add monitoring device page");
	}
	public void validateLinkIsEnabledInMonDev(){
		waitForElementVisible(enabledLinkIcon,5000,1000);
		Validator.assertTrue(enabledLinkIcon.isEnable(),"Link Icon is disabled","Link Icon is enabled");
	}
	public void validateLinkIsDisabledInMonDev(){
		waitForElementVisible(disabledLinkIcon,5000,1000);
		Validator.assertTrue(disabledLinkIcon.isDisplayed(),"Link Icon is enabled","Link Icon is disabled");
	}
	public boolean verifyActionBtnIsEnabled(){
		Validator.assertTrue(actionBtnDisabled.isNotVisible(5000),"Action button is disabled","Action button is enabled");
		return actionBtnDisabled.isNotVisible(10000);
	}
	public boolean verifyActionBtnIsDisabled(){
		Validator.assertTrue(actionBtnDisabled.isVisible(5000),"Action button is enabled","Action button is disabled");
		return actionBtnDisabled.isVisible(10000);
	}
	public void validateForwardNavInEachRow(){
		Validator.assertTrue(forwardNavBtn.isVisible(5000),"Forward button is not displayed","Forward button is displayed");
		int noOfViewIcon = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?=\\s+of)"));

		for (int i = 1; i <= noOfViewIcon; i++) {
			Validator.assertTrue(driver.findElement(By.xpath("(//button[@icon='ctp-icon-Arrow-Right'])[" + i + "]")).isDisplayed(),
					"Forward button at position " + i + " is not displayed",
					"Forward button at position " + i + " is displayed");
		}
	}
	public void validateMonDevCountWrtPagination(){
		int deviceCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		Validator.assertTrue(apiBase.getMonitoringDeviceCount().get("count").equals(deviceCount),"Monitoring Device Count does not match","Monitoring Device  Count matches");
	}
	public void verifyPaginationDoubleForwardArrowButton(){
		waitForElementVisible(btPgDoubleForwardBtn,5000,1000);
		waitForElementToBeClickable(btPgDoubleForwardBtn);
		btPgDoubleForwardBtn.jsClick();
		int deviceCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		int multiple = Integer.parseInt(paginationDropDownValue.getText());
		double result = (double) deviceCount / multiple;
		int finalResult = (result % 1 > 0) ? (int) result + 1 : (int) result;
		Validator.assertTrue(btPgHighlightedValue.getText().contains(String.valueOf(finalResult)),"Pagination is not present at end","Pagination is present at end");
	}
	public void verifyPaginationDoubleBackwardArrowButton(){
		waitForElementVisible(btPgDoubleBackwardBtn,5000,1000);
		waitForElementToBeClickable(btPgDoubleBackwardBtn);
		btPgDoubleBackwardBtn.jsClick();
		Validator.assertTrue(btPgHighlightedValue.getText().contains("1"),"Pagination is not present at start","Pagination is present at start");
	}

	public void verifyActionDropdownForSingleSelection()
	{
		waitForElementVisible(btActions,10000,500);
		btActions.isVisible("Action");
		btActions.jsClick("Action");
		Validator.assertTrue(editBtn.isVisible() && deleteBtn.isVisible(),"Edit and delete options are not visible for single checkbox selection","Edit and delete options are  visible for single checkbox selection");

    }
    public void verifyActionDropdownForMultipleSelection()
    {
        waitForElementVisible(btActions,10000,500);
        btActions.isVisible("Action");
        btActions.jsClick("Action");
        Validator.assertTrue(deleteBtn.isVisible(),"Only delete options is not visible for multiple checkbox selection","Only delete options is visible for multiple checkbox selection");

    }

    public void verifySearchedColumnNames() {
        waitForElementVisible(cbBeltWidth, 10000, 500);
        Validator.assertTrue(cbBeltWidth.isVisible() && cbBeltSaves.isVisible(), "The column names with searched text  is not visible", "The column names with searched text is  visible");
    }
    public void verifyScanQRIsVisibleAndClick()
    {
            waitForElementVisible(btActions,10000,500);
            btActions.isVisible("Action");
            btActions.jsClick("Action");
            Validator.assertTrue(scanQRBtn.isVisible(),"Scan QR is not visible","Scan QR is visible");
    }
    public void clickScanQRAndVerify(String deviceName)
    {
        waitForElementVisible(scanQRBtn,10000,500);
        scanQRBtn.jsClick("Scan QR");
        waitForElementVisible(scanHeader,10000,500);
        System.out.println(scanHeader.getText()+"header");
        Validator.assertTrue(scanHeader.getText().contains(deviceName),"Scan QR does not contain the header","Scan QR Contains the header");
        Validator.assertTrue(scannerImg.isVisible(10000,"scannerImg"),"Scan Img is not present","Scan Img is present");
        Validator.assertTrue(btnDialogClose.isVisible(10000,"scannerImg"),"close button is not visible","close button is visible");
        Validator.assertTrue(btnDownload.isVisible(10000,"download"),"download button is not present","download button is  present");
    }

    public void downloadButtonClick() {
        waitForElementToBeClickable(btnDownload);
        btnDownload.click("Download QR Code");
        waitForElementToInvisible(downloadSpinner, 30000);
    }

    public void verifyMonitoringDeviceBreadCrumb()
    {
        waitForPageLoad(15000);
        waitForElementVisible(monitoringDeviceBreadCrumb,10000,500);
        Assert.assertTrue(monitoringDeviceBreadCrumb.isDisplayed(), "Breadcrumb element is not displayed");
        assertEquals(monitoringDeviceBreadCrumb.getText(), "Home\nMonitoring Devices\nAdd", "Breadcrumb text does not match expected");
    }

    public void verifyDeviceTypeDDL() {
        deviceTypeDropDown.jsClick("Device Type");
        Validator.assertTrue(ddlSelectLoadSense.isVisible(10000, "LoadSense option") && ddlSelectCordProtect.isVisible(10000, "CordProtect option") && ddlSelectRipProtect.isVisible(10000, "RipProtect option") &&
                ddlSelectMultiProtect.isVisible(10000, "MultiProtect option") && ddlSelectOther.isVisible(10000, "Other option"), "All the options of device type are not visible", "All the options of device type are visible");
        deviceTypeDropDown.jsClick("Device Type");
        SyncUtil.waitFor(3000);
    }

    public void addDeviceDetailsWithMandatoryFields(String deviceName, String deviceType) {
        waitForElementToDisplay(tbDeviceName);
        waitForElementToBeClickable(tbDeviceName);
        tbDeviceName.sendKeys(deviceName, "Device name");
        verifyDeviceTypeDDL();
        dropdownSelectSearch(deviceTypeDropDown, tbDeviceTypedropdown, deviceType);
        waitForElementVisible(tbInstallationDate, 10000, 500);
        tbInstallationDate.click("installation date");
    }

    public void verifyRemoteConnectionDDL() {
        remoteConnectionDropDown.jsClick("Remote Connection");
        Validator.assertTrue(ddlSelectLocalOnly.isVisible(10000, "local only option") && ddlSelect3G4GRouter.isVisible(10000, "3G/4G Router option") &&
                ddlSelectVPNMineSite.isVisible(10000, "VPN Mine Site option"), "All the options of remote connection dropdown are not visible", "All the options of remote connection dropdown are visible");
        remoteConnectionDropDown.click("Remote Connection");
    }

    public void addDeviceDetailsWithNonMandatoryFields(String brand, String serialNo, String remoteConnection, String comminsionDate, String beltConveyorSave, String firmwareVersion) {
        waitForElementVisible(tbDeviceBrand, 10000, 500);
        tbDeviceBrand.sendKeys(brand, "Device brand");
        tbSerialNo.sendKeys(serialNo, "serialNumber");
        tbFirmwareVersion.sendKeys(firmwareVersion, "Firmware Version");
        verifyRemoteConnectionDDL();
        dropdownSelectSearch(remoteConnectionDropDown, tbDeviceTypedropdown, remoteConnection);
        waitForElementVisible(tbcommisioningDate,10000,500);
        tbcommisioningDate.click("commisioningDate");
        coverWearPage.selectGivenDate(comminsionDate);
        tbBeltConveyorSaves.sendKeys(beltConveyorSave,"Belt/Conveyor Saves");
    }

    public void verifySaveBtnIsEnabled()
    {Validator.assertTrue(createBtnDisabled.isNotVisible(10000),"Create button is enabled","Create button is enabled");}


    public void cancelBtnClick()
    {
        waitForElementVisible(btnCancel,10000,500);
        waitForElementToBeClickable(btnCancel);
        btnCancel.jsClick("Cancel");

    }

    public void verifyWarningPopupAndExit()
    {
        warningDialogBox.isVisible(10000,"Warning Dialog");
        SyncUtil.waitFor(5000);
        btnYes.isVisible(10000,"yes button");
        waitForElementToBeClickable(btnYes);
        btnYes.jsClick("Yes");
    }
    public void clickOnNextBtn() {
        btNext.click();
        waitForPageLoad(15000);
        SyncUtil.waitFor(5000);
        Validator.assertTrue(deviceLocationHeader.isVisible(10000,"Device Location Header"),"User is not navigated to device location page","User is not navigated to device location page");
    }
    public void clickAndVerifyStatusDropDown()
    {
        statusDropDown.isVisible(10000,"Status Dropdown");
        statusDropDown.click("Status Dropdown");
        Validator.assertTrue(statusOptionRunning.isVisible(10000,"Running option")&&statusOptionNotInOperation.isVisible(10000,"Not In Operation option")&&
                statusOptionPriorToCommissioning.isVisible(10000,"Prior to commissioning"),"All the options of status dropdown are not visible","All the options of status dropdown  are visible");

    }

    public void clickInstallationDateCalendarPopup() {

        waitForElementVisible(tbInstallationDate, 10000, 500);
        Validator.assertTrue(tbInstallationDateFormat.isVisible("installation date format"), "The installation date is not in the format MM/DD/YYYY", "The installation date is in the format MM/DD/YYYY");
        tbInstallationDate.jsClick("installation date");
        calendarPopup.isVisible(10000, "Calendar Popup");

    }

    public void clickCommissioningDateCalendarPopup() {

        waitForElementVisible(tbcommisioningDate, 10000, 500);
        Validator.assertTrue(tbCommissioningDateFormat.isVisible("installation date format"), "The installation date is not in the format MM/DD/YYYY", "The installation date is in the format MM/DD/YYYY");
        tbCommissioningDateFormat.jsClick("installation date");
        calendarPopup.isVisible(10000, "Calendar Popup");

    }
    public String getPreviousMonth()
    {
        LocalDate currentDate = LocalDate.now();
        // Get previous month
        LocalDate previousMonthDate = currentDate.minusMonths(1);
        Month previousMonth = previousMonthDate.getMonth();
        return previousMonth.toString();
    }
    public String getNextMonth()
    {
        LocalDate currentDate = LocalDate.now();
        // Get next month
        LocalDate nextMonthDate = currentDate.plusMonths(1);
        Month nextMonth = nextMonthDate.getMonth();
        return nextMonth.toString();
    }
    private int getPreviousYear() {
        return LocalDate.now().getYear() - 1;
    }
    private int getNextYear() {
        return LocalDate.now().getYear() + 1;
    }
    public void clickAndVerifyMonthChart()
    {
        monthField.isVisible(10000,"Month Field");
        prevBtn.isVisible(10000,"Previous button");
        prevBtn.jsClick("Previous button");
        Validator.assertTrue(monthField.getText().equalsIgnoreCase(getPreviousMonth()),"Previous month is not displayed","Previous month is  displayed");
        SyncUtil.waitFor(5000);

        waitForElementVisible(nextBtn,10000,500);
        nextBtn.isVisible(10000,"Next button");
        nextBtn.jsClick("Next button");
        SyncUtil.waitFor(5000);
        waitForElementToBeClickable(nextBtn);
        nextBtn.click("Next button");
        Validator.assertTrue(monthField.getText().equalsIgnoreCase(getNextMonth()),"Next month is not displayed","Next month is  displayed");

        monthField.click("Month");
        Validator.assertTrue(monthChart.isVisible(10000,"Month Chart"),"Month chart is not displayed","Month chart is displayed");


    }
    public void verifyYearBtnFunctionality()
    {
        prevBtn.isVisible(10000,"Previous button");
        prevBtn.jsClick("Previous button");
        Validator.assertTrue(
                Integer.parseInt(yearField.getText()) == getPreviousYear(),
                "Previous year is not displayed",
                "Previous year is displayed"
        );
        SyncUtil.waitFor(5000);

        waitForElementVisible(nextBtn,10000,500);
        nextBtn.isVisible(10000,"Next button");
        nextBtn.jsClick("Next button");
        SyncUtil.waitFor(5000);
        waitForElementToBeClickable(nextBtn);
        nextBtn.click("Next button");
        Validator.assertTrue(
                Integer.parseInt(yearField.getText()) == getNextYear(),
                "Next year is not displayed",
                "Next year is displayed"
        );
    }
    public void clickAndVerifyYearChart()
    {
        yearField.isVisible(10000,"year field");
        yearField.jsClick("year field");
        Validator.assertTrue(yearChart.isVisible(10000,"year Chart"),"year chart is not displayed","year chart is displayed");
    }
    // Get the previous date
    public  int getPreviousDate() {
        LocalDate previousDate = LocalDate.now().minusDays(1);
        return previousDate.getDayOfMonth();
    }

    // Get the next date
    public  int getNextDate() {
        LocalDate nextDate = LocalDate.now().plusDays(1);
        return nextDate.getDayOfMonth();
    }
    public void verifyPastDatesSelection()
    {
        int prevDate=getPreviousDate();
        System.out.println(getPreviousDate()+"getPreviousDate");

        Validator.assertTrue(driver.findElement(By.xpath("(//table[contains(@class,\"p-datepicker-calendar\")]//tr//td//span[text()='"+prevDate+"'])[1]")).isEnabled(),"Previous dates are disabled","Previous dates are enabled");
        int nextDate=getNextDate();
        System.out.println(getNextDate()+"getNextDate");
        Validator.assertTrue(driver.findElement(By.xpath("(//table[contains(@class, 'p-datepicker-calendar')]//tr//td//span[contains(text(), '"+nextDate+"') and contains(@class, 'p-disabled')])[1]")).isDisplayed(),"Next dates are enabled","Next dates are disabled");

    }
    public void verifyBeltConveyorSave()
    {
        waitForElementVisible(tbBeltConveyorSaves,10000,500);
        tbBeltConveyorSaves.sendKeys(Keys.ARROW_UP,"upward arrow");
        SyncUtil.waitFor(5000);
        Validator.assertTrue(tbBeltConveyorSaves.getAttribute("value").equalsIgnoreCase("1"),"User doesn't get positive values on clicking up arrow","User gets positive values on clicking up arrow");
        tbBeltConveyorSaves.sendKeys(Keys.ARROW_DOWN,"upward arrow");
        SyncUtil.waitFor(3000);
        tbBeltConveyorSaves.sendKeys(Keys.ARROW_DOWN,"upward arrow");
        SyncUtil.waitFor(3000);
        Validator.assertTrue(tbBeltConveyorSaves.getAttribute("value").equalsIgnoreCase("-1"),"User doesn't get negative values on clicking up arrow","User gets negative values on clicking up arrow");
        tbBeltConveyorSaves.sendKeys(Keys.ARROW_UP,"upward arrow");
        tbBeltConveyorSaves.sendKeys(Keys.ARROW_UP,"upward arrow");
        tbBeltConveyorSaves.sendKeys(Keys.ARROW_DOWN,"upward arrow");
        Validator.assertTrue(tbBeltConveyorSaves.getAttribute("value").equalsIgnoreCase("0"),"User doesn't get zero values between positive and negative numbers","User gets zero values between positive and negative numbers");

    }
    public void verifyCreateAndCancelBtn()
    {
        Validator.assertTrue(createBtnDisabled.isVisible(10000,"Create"),"Create button is not disabled when the mandatory fields are not filled",
                "Create button is disabled when the mandatory fields are not filled");
        Validator.assertTrue(btnCancel.isVisible(10000,"Cancel"),"Cancel button is not displayed","Cancel button is displayed");


    }
    public void verifySaveAndCancelBtn()
    {
        Validator.assertTrue(btSave.isVisible(10000,"Save"),"Save button is not disabled when the mandatory fields are not filled",
                "Save button is disabled when the mandatory fields are not filled");
        Validator.assertTrue(btnCancel.isVisible(10000,"Cancel"),"Cancel button is not displayed","Cancel button is displayed");


    }
    public void verifyBtnColors()
    {
        Validator.assertTrue(btCancelStyle.isVisible(10000,"cancel button"),"Cancel button does not have orange border","Cancel button has orange border");
        waitForElementVisible(btCreateStyle,10000,500);
        Validator.assertTrue(btCreateStyle.isEnabled(),"is disabled","is enabled");

        String createBtnColor = btCreateStyle.getCssValue("background-color");
        String cancelBtnColor = btCancelStyle.getCssValue("background-color");

        String expectedCreateBtnColor = "rgba(255, 165, 0, 1)";  // Orange #FFA500 in rgba
        String expectedCancelBtnColor = "rgba(255, 255, 255, 1)";  // White #FFF in rgba

        Validator.assertTrue(createBtnColor.equalsIgnoreCase(expectedCreateBtnColor),"Create button background color is incorrect!","Create button background color is correct!");
        Validator.assertTrue(cancelBtnColor.equalsIgnoreCase(expectedCancelBtnColor),"Cancel button background color is incorrect!","Cancel button background color is correct!");

    }

    public boolean goToMonitoringDeviceEditScreen(String device) {
        searchMonitoringDevice(device);
        waitForElementToDisplay(crCheckbox);
        crCheckbox.check("Select Device");
        btActions.click("Actions");
        waitForElementVisible(editBtn, 10000,500);
        editBtn.click("Edit");
        waitForPageLoad(10000);
        return updateDeviceTitle.isVisible(10000,"Update Device title");
    }

    public boolean goToCorporateEditScreen() {
        waitForElementToDisplay(crCheckbox);
        crCheckbox.check("Select Device");
        btActions.click("Actions");
        waitForElementVisible(editBtn, 10000,500);
        editBtn.click("Edit");
        waitForPageLoad(10000);
        return updateDeviceTitle.isVisible(10000,"Update Device title");
    }

    public void goToMonitoringDeviceDetailScreen() {
        waitForElementToDisplay(crViewIcon);
        crViewIcon.click("Conveyor Detail");
        waitForPageLoad(10000);
        tbDeviceName.isVisible(10000,"Device Name");
    }
    public void verifyDeviceTypeInViewMode(String deviceType)
    {
        deviceTypeField.isVisible(10000,"Device Type");
        Validator.assertTrue(deviceTypeField.getText("device type").equalsIgnoreCase(deviceType),"The device type dropdown value is incorrect!","The device type dropdown value is correct!");
    }

	public boolean navigateToCordProtect(){
		iotIcon.isEnable("IoT icon");
		iotIcon.click("cord Protect");
		return iotChart1.isVisible();
	}

	public boolean verifyCordProtect(){
		waitForElementToDisplay(iotChart1);
		waitForElementToDisplay(iotChart2);
		waitForElementToDisplay(iotChart3);
		SyncUtil.waitFor(3000);
		scrollPageDown();
		SyncUtil.waitFor(2000);
		return iotChart1.isVisible() && iotChart2.isVisible() && iotChart3.isVisible();
	}
}
