package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class MonitoringDevicePage extends BasePage {

    @FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
    public CustomElement pagination;
    @FindBy(locator = "xpath=//input[@placeholder='Search']")
    public CustomElement btSearchinput;

    @FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
    public CustomElement home;
    @FindBy(locator = "xpath=(//li//span[text()='Monitoring Devices'])[1]")
    public CustomElement monitoringDeviceList;

    @FindBy(locator = "xpath=(//button[@disabled]//span[text()=\"Actions\"])[1]")
    public CustomElement actionBtnDisabled;

    @FindBy(locator = "xpath=//span[text()='Edit']")
    public CustomElement editBtn;
    @FindBy(locator = "xpath=//span[text()='Scan QR']")
    public CustomElement scanQRBtn;
    @FindBy(locator = "xpath=//span[text()='Delete']")
    public CustomElement deleteBtn;

    @FindBy(locator = "xpath=(//button/chevrondownicon)[2]")
    public CustomElement btActions;
    @FindBy(locator = "xpath=//p-tieredmenusub//ul[@role=\"menu\"]")
    public CustomElement btActionsPopup;


    @FindBy(locator = "xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement crCheckbox;

    @FindBy(locator = "xpath=//p-multiselectitem//li[contains(., 'Belt Width') and .//div[contains(@class, 'p-checkbox')]]")
    public CustomElement cbBeltWidth;

    @FindBy(locator = "xpath=//p-multiselectitem//li[contains(., 'Belt/Conveyor Saves') and .//div[contains(@class, 'p-checkbox')]]")
    public CustomElement cbBeltSaves;

    @FindBy(locator = "xpath=//div[contains(@class,\"p-dialog-header\")]//span")
    public CustomElement scanHeader;
    @FindBy(locator = "xpath=//qrcode//div[@class=\"qrcode\"]")
    public CustomElement scannerImg;
    @FindBy(locator = "//button[contains(@class,\"p-dialog-header-close\")]")
    public CustomElement btnDialogClose;
    @FindBy(locator = "//button[@type=\"button\"]//span[text()=\"Download\"]")
    public CustomElement btnDownload;
    @FindBy(locator = "xpath=(//span[contains(@class,'pi-spinner')])[2]")
    public CustomElement downloadSpinner;
    @FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
    public CustomElement btAddMonitoringDevice;

    @FindBy(locator = "xpath=//p-breadcrumb//nav[@data-pc-name=\"breadcrumb\"  and contains(., \"Monitoring Devices\")]")
    public CustomElement monitoringDeviceBreadCrumb;
    @FindBy(locator = "xpath=//input[@formcontrolname='deviceName']")
    public CustomElement tbDeviceName;
    @FindBy(locator = "xpath=(//p-dropdown//div[contains(@class,\"master-data-dropdown\")])[1]")
    public CustomElement deviceTypeDropDown;
    @FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter')]")
    public CustomElement tbDeviceTypedropdown;

    @FindBy(locator = "xpath=//p-calendar[@formcontrolname='installationDate']//input")
    public CustomElement tbInstallationDate;
    @FindBy(locator = "xpath=//p-calendar[@formcontrolname='installationDate']//input[@placeholder=\"MM/DD/YYYY\"]")
    public CustomElement tbInstallationDateFormat;
    @FindBy(locator = "xpath=//p-calendar[@formcontrolname='commisioningDate']//input[@placeholder=\"MM/DD/YYYY\"]")
    public CustomElement tbCommissioningDateFormat;
    @FindBy(locator = "xpath=//input[@formcontrolname='deviceBrand']")
    public CustomElement tbDeviceBrand;
    @FindBy(locator = "xpath=//input[@formcontrolname='serialNumber']")
    public CustomElement tbSerialNo;
    @FindBy(locator = "xpath=//input[@formcontrolname='firmwareVersion']")
    public CustomElement tbFirmwareVersion;
    @FindBy(locator = "xpath=(//p-dropdown//div[contains(@class,\"master-data-dropdown\")])[2]")
    public CustomElement remoteConnectionDropDown;
    @FindBy(locator = "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"LoadSense\"]")
    public CustomElement ddlSelectLoadSense;
    @FindBy(locator = "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"RipProtect\"]")
    public CustomElement ddlSelectRipProtect;
    @FindBy(locator = "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"MultiProtect\"]")
    public CustomElement ddlSelectMultiProtect;
    @FindBy(locator = "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"CordProtect\"]")
    public CustomElement ddlSelectCordProtect;
    @FindBy(locator = "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"Other\"]")
    public CustomElement ddlSelectOther;

    @FindBy(locator = "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"Local only\"]")
    public CustomElement ddlSelectLocalOnly;
    @FindBy(locator = "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"3G/4G router\"]")
    public CustomElement ddlSelect3G4GRouter;
    @FindBy(locator = "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li//span[text()=\"VPN through mine site\"]")
    public CustomElement ddlSelectVPNMineSite;
    @FindBy(locator = "xpath=//p-calendar[@formcontrolname='commisioningDate']//input")
    public CustomElement tbcommisioningDate;
    @FindBy(locator = "xpath=//p-calendar[@formcontrolname='lastServiceDate']//input")
    public CustomElement tbLastServiceDate;
    @FindBy(locator = "xpath=//input[@formcontrolname=\"beltConveyorSaves\"]")
    public CustomElement tbBeltConveyorSaves;
    @FindBy(locator = "xpath=(//app-conveyor-picker//p-dropdown//div[contains(@class,\"p-dropdown\")])[1]")
    public CustomElement conveyorDDL;
    @FindBy(locator = "xpath=//span[contains(@class,\"p-steps-title\") and text()=\" Add Location\"]")
    public CustomElement addLocationTitle;
    @FindBy(locator = "xpath=//span[contains(@class,\"p-steps-title\") and text()=\" Add Device\"]")
    public CustomElement addDeviceTitle;

    @FindBy(locator = "xpath=//span[contains(@class,\"p-steps-title\") and text()=\" Update Device\"]")
    public CustomElement updateDeviceTitle;
    @FindBy(locator = "xpath=//button[@disabled]//span[text()=\"Create\"]")
    public CustomElement createBtnDisabled;
    @FindBy(locator = "xpath=//div[contains(@class,\"p-confirm-dialog\")]")
    public CustomElement warningDialogBox;
    @FindBy(locator = "xpath=//div[contains(@class,\"p-confirm-dialog\")]//div//button//span[text()=\"No\"]")
    public CustomElement btnNo;
    @FindBy(locator = "xpath=//div[contains(@class,\"p-confirm-dialog\")]//div//button//span[text()=\"Yes\"]")
    public CustomElement btnYes;
    @FindBy(locator = "xpath=//button[contains(@class,\"p-button-outlined\")]//span[text()='Cancel']")
    public CustomElement btnCancel;
    @FindBy(locator = "xpath=//span[text()='Next']")
    public CustomElement btNext;
    @FindBy(locator = "xpath=(//p-dropdown[@formcontrolname=\"status\"]//div[contains(@class,\"p-dropdown\")])[1]")
    public CustomElement statusDropDown;
    @FindBy(locator = "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li[text()=\" Running \"]")
    public CustomElement statusOptionRunning;
    @FindBy(locator = "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li[text()=\" Not in Operation \"]")
    public CustomElement statusOptionNotInOperation;
    @FindBy(locator = "xpath=//ul[@role=\"listbox\"]//p-dropdownitem//li[text()=\" Prior to Commissioning \"]")
    public CustomElement statusOptionPriorToCommissioning;
    @FindBy(locator = "xpath=//div[contains(@class,\"p-datepicker-group-container\")]")
    public CustomElement calendarPopup;
    @FindBy(locator = "xpath=//div//button[contains(@class,\"p-datepicker-month\")]\n")
    public CustomElement monthField;
    @FindBy(locator = "xpath=//div//div[contains(@class,\"p-monthpicker\")]")
    public CustomElement monthChart;
    @FindBy(locator = "xpath=//div//button[contains(@class,\"p-datepicker-prev\")]")
    public CustomElement prevBtn;
    @FindBy(locator = "xpath=//div//button[contains(@class,\"p-datepicker-next\")]")
    public CustomElement nextBtn;
    @FindBy(locator = "xpath=//div//button[contains(@class,\"p-datepicker-year\")]")
    public CustomElement yearField;
    @FindBy(locator = "xpath=//div//div[contains(@class,\"p-yearpicker\")]")
    public CustomElement yearChart;
    @FindBy(locator = "xpath=(//td//span[contains(@class, 'p-disabled')])[1]")
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
    @FindBy(locator = "xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
    public CustomElement crViewIcon;
    @FindBy(locator = "xpath=(//p-dropdown//div[contains(@class,\"master-data-dropdown\")])[1]//span")
    public CustomElement deviceTypeField;

    @FindBy(locator = "xpath=//button[@icon='ctp-icon-Instaloled-Devices']")
    public CustomElement iotIcon;

    @FindBy(locator = "xpath=(//div[@id='chartArea'])[1]")
    public CustomElement iotChart1;

    @FindBy(locator = "xpath=(//div[@id='chartArea'])[2]")
    public CustomElement iotChart2;

    @FindBy(locator = "xpath=(//div[@id='chartArea'])[3]")
    public CustomElement iotChart3;

    @FindBy(locator = "xpath=//div[@class=\"menu-cord\"]//div//span[text()=\"MultiProtect\"]")
    public CustomElement menuList;
    @FindBy(locator = "xpath=//p-breadcrumb//nav[@data-pc-name=\"breadcrumb\"]")
    public CustomElement breadCrumbText;

    @FindBy(locator = "xpath=(//app-rip-insert-thumbnail//div//p-card)[1]")
    public CustomElement ripInsertData;

    @FindBy(locator = "xpath=//div[contains(@class,\"p-panel-header\")]//div//div")
    public CustomElement ripInsertThumbnailHeader;
    @FindBy(locator = "xpath=//div//ul[@class='cord-menu-layout']//a//span[text()='Rip Inserts']")
    public CustomElement ripInsertList;
    @FindBy(locator = "xpath=//div//ul[@class='cord-menu-layout']//a//span[text()='Rip Inserts']/following-sibling::i[contains(@class,\"pi-angle-down\")]")
    public CustomElement ripInsertListExpanded;
    @FindBy(locator = "xpath=//p-tabview//li//a//span[contains(@class,\"tab-heading\") and text()=\"RIP Insert Image\" ]  ")
    public CustomElement ripInsertImageTab;
    @FindBy(locator = "xpath=//p-tabview//li//a//span[contains(@class,\"tab-heading\") and text()=\"Latest alarm for this Insert\" ]  ")
    public CustomElement ripInsertAlarmTab;
    @FindBy(locator = "xpath=//p-tabview//li[contains(@class,\"p-highlight\")]//a//span[contains(@class,\"tab-heading\") and text()=\"Latest alarm for this Insert\" ]  ")
    public CustomElement ripInsertAlarmTabActivated;

    @FindBy(locator = "xpath=(//div//h6[contains(text(),\"Position:\")])[1]")
    public CustomElement ripInsertPositionText;
    @FindBy(locator = "xpath=(//div//h6[contains(text(),\"Position:\")]/following-sibling::span[contains(text(),'Image generated')])[1]")
    public CustomElement ripInsertImgGeneratedTxt;
    @FindBy(locator = "xpath=(//div[@class=\"p-card-content\"]//div[contains(text(),\" Estimated width\")])[1]")
    public CustomElement ripInsertEstimatedWidth;
    @FindBy(locator = "xpath=(//div[@class=\"p-card-content\"]//app-image-viewer//span//img[contains(@class,\"p-image\")])[1]")
    public CustomElement ripInsertImageDisplayed;

    @FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
    public CustomElement paginationEntry;
    @FindBy(locator = "xpath=//tr[1]//td//div//p-button[@type=\"button\" and @icon=\"ctp-icon-Arrow-Right\"]")
    public CustomElement viewMoreBtn;
    @FindBy(locator = "xpath=//div[contains(@class,\"p-panel-header\")]//i[contains(@class,\"pi-arrow-right\")]")
    public CustomElement viewNextBtn;
    @FindBy(locator = "xpath=//div[contains(@class,\"p-panel-header\")]//i[contains(@class,\"pi-arrow-left\")]")
    public CustomElement viewPrevBtn;

    @FindBy(locator = "xpath=//textarea[@formcontrolname=\"comment\"]")
    public CustomElement tbComment;
    @FindBy(locator = "xpath=//td//span[contains(@class,\"p-highlight\") ]")
    public CustomElement selectedLastServiceDate;

    @FindBy(locator = "xpath=//td[contains(text(),'No')]")
    public CustomElement noList;


    CoverWearPage coverWearPage = new CoverWearPage();
    String[] menuListNames={"Main Page","Conveyor Details","Splices","Rip Inserts","Damages","Segments"};

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

    public boolean verifyActionBtnIsEnabled() {
        Validator.assertTrue(actionBtnDisabled.isNotVisible(5000), "Action button is disabled", "Action button is enabled");
        return actionBtnDisabled.isNotVisible(10000);
    }

    public boolean verifyActionBtnIsDisabled() {
        Validator.assertTrue(actionBtnDisabled.isVisible(5000), "Action button is enabled", "Action button is disabled");
        return actionBtnDisabled.isVisible(10000);
    }

    public void verifyActionDropdownForSingleSelection() {
        waitForElementVisible(btActions, 10000, 500);
        btActions.isVisible("Action");
        waitForElementToBeClickable(btActions);
        btActions.click("Action");
        btActions.click("Action");

//        SyncUtil.waitFor(3000);
        waitForElementVisible(btActionsPopup, 10000, 500);
        Validator.assertTrue(editBtn.isDisplayed() && deleteBtn.isDisplayed(), "Edit and delete options are not visible for single checkbox selection", "Edit and delete options are  visible for single checkbox selection");

    }

    public void verifyActionDropdownForMultipleSelection() {
        waitForElementVisible(btActions, 10000, 500);
        btActions.isVisible("Action");
        btActions.jsClick("Action");
        Validator.assertTrue(deleteBtn.isVisible(), "Only delete options is not visible for multiple checkbox selection", "Only delete options is visible for multiple checkbox selection");

    }

    public boolean searchMonitoringDevice(String device) {
        waitForPageLoad(20000);
        btSearchinput.type(device, "Monitoring Device Search");
        SyncUtil.waitFor(15000);
        waitForElementVisible(crCheckbox, 20000, 1000);
        waitForElementToDisplay(crCheckbox);
        return crCheckbox.isVisible("Monitoring Device Found");
    }

    public void verifySearchedColumnNames() {
        waitForElementVisible(cbBeltWidth, 10000, 500);
        Validator.assertTrue(cbBeltWidth.isVisible() && cbBeltSaves.isVisible(), "The column names with searched text  is not visible", "The column names with searched text is  visible");
    }

    public void verifyScanQRIsVisibleAndClick() {
        waitForElementVisible(btActions, 10000, 500);
        btActions.isVisible("Action");
        btActions.jsClick("Action");
        Validator.assertTrue(scanQRBtn.isVisible(), "Scan QR is not visible", "Scan QR is visible");
    }
    public void clickScanQR()
    {
        waitForElementVisible(scanQRBtn, 10000, 500);
        scanQRBtn.jsClick("Scan QR");
    }

    public void verifyScanQR(String deviceName) {
        waitForElementVisible(scanHeader, 10000, 500);
        System.out.println(scanHeader.getText() + "header");
        Validator.assertTrue(scanHeader.getText().contains(deviceName), "Scan QR does not contain the header", "Scan QR Contains the header");
        Validator.assertTrue(scannerImg.isVisible(10000, "scannerImg"), "Scan Img is not present", "Scan Img is present");
        Validator.assertTrue(btnDialogClose.isVisible(10000, "scannerImg"), "close button is not visible", "close button is visible");
        Validator.assertTrue(btnDownload.isVisible(10000, "download"), "download button is not present", "download button is  present");
    }

    public void downloadButtonClick() {
        waitForElementToBeClickable(btnDownload);
        btnDownload.click("Download QR Code");
        waitForElementToInvisible(downloadSpinner, 30000);
    }

    public void goToAddMonitoringDevice() {
        waitForPageLoad(10000);
        waitForElementVisible(btAddMonitoringDevice, 10000, 500);
        waitForElementToBeClickable(btAddMonitoringDevice);
        btAddMonitoringDevice.jsClick("Add icon");
        SyncUtil.waitFor(3000);
        waitForPageLoad(20000);
        waitForElementVisible(addDeviceTitle, 15000, 500);
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/device/add/basic-info"), "User is not navigated to Add monitoring device page", "User is navigated to Add monitoring device page");
    }

    public void verifyMonitoringDeviceBreadCrumb() {
        waitForPageLoad(15000);
        waitForElementVisible(monitoringDeviceBreadCrumb, 10000, 500);
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

    public void addDeviceDetailsWithMandatoryFields(String deviceName, String deviceType,String status) {
        waitForElementToDisplay(tbDeviceName);
        waitForElementToBeClickable(tbDeviceName);
        tbDeviceName.sendKeys(deviceName, "Device name");
        verifyDeviceTypeDDL();
        dropdownSelectSearch(deviceTypeDropDown, tbDeviceTypedropdown, deviceType);
        clickAndVerifyStatusDropDown();
        waitForElementVisible(driver.findElement(By.xpath("//ul[@role=\"listbox\"]//p-dropdownitem//li[contains(text(),'"+status+"')]")),10000,500);
//        statusOptionRunning.isVisible(10000,"Running");
//        statusOptionRunning.click("Running");
        driver.findElement(By.xpath("//ul[@role=\"listbox\"]//p-dropdownitem//li[contains(text(),'"+status+"')]")).click();
    }

    public void verifyRemoteConnectionDDL() {
        remoteConnectionDropDown.jsClick("Remote Connection");
        Validator.assertTrue(ddlSelectLocalOnly.isVisible(10000, "local only option") && ddlSelect3G4GRouter.isVisible(10000, "3G/4G Router option") &&
                ddlSelectVPNMineSite.isVisible(10000, "VPN Mine Site option"), "All the options of remote connection dropdown are not visible", "All the options of remote connection dropdown are visible");
        remoteConnectionDropDown.click("Remote Connection");

    }
    public void verifyManualCalenderDateSelection(String inputDate)
    {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        String formattedDate = date.format(outputFormatter);
        calendarPopup.isVisible(10000,"calender");
        Validator.assertTrue(selectedLastServiceDate.getAttribute("data-date").contains(formattedDate),"The manually entered date is not getting selected in the calender!","The manually entered date is getting selected in the calender!");

    }
    public void verifyManualDateSelection(String lastServiceDateField,String inputDate)
    {
        waitForElementVisible(driver.findElement(By.xpath("//p-calendar[@formcontrolname='"+lastServiceDateField+"']//input")),10000,500);
        driver.findElement(By.xpath("//p-calendar[@formcontrolname='"+lastServiceDateField+"']//input")).click();
        driver.findElement(By.xpath("//p-calendar[@formcontrolname='"+lastServiceDateField+"']//input")).sendKeys(inputDate);
        verifyManualCalenderDateSelection(inputDate);
    }
    public void addDeviceDetailsWithNonMandatoryFields(String brand, String serialNo, String remoteConnection, String comminsionDate, String beltConveyorSave, String firmwareVersion,String lastServiceDateField,String lastServiceDate,String comment) {
        waitForElementVisible(tbDeviceBrand, 10000, 500);
        tbDeviceBrand.sendKeys(brand, "Device brand");
        tbSerialNo.sendKeys(serialNo, "serialNumber");
        tbFirmwareVersion.sendKeys(firmwareVersion, "Firmware Version");
        verifyRemoteConnectionDDL();
        dropdownSelectSearch(remoteConnectionDropDown, tbDeviceTypedropdown, remoteConnection);
        waitForElementVisible(tbcommisioningDate, 10000, 500);
        tbcommisioningDate.click("commisioningDate");
        coverWearPage.selectGivenDate(comminsionDate);
        tbBeltConveyorSaves.sendKeys(beltConveyorSave, "Belt/Conveyor Saves");
        verifyManualDateSelection(lastServiceDateField,lastServiceDate);
        tbComment.sendKeys(comment);
        waitForElementVisible(tbInstallationDate, 10000, 500);
        tbInstallationDate.click("installation date");

    }

    public void navigateToAddLocation() {
        waitForElementVisible(addLocationTitle, 10000, 500);
        addLocationTitle.jsClick("Add Location");
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/device/add/location"), "User is not navigated to add location page", "User is navigated to add location page");

    }

    public void selectConveyor(String conveyorName) {
        waitForElementVisible(conveyorDDL, 10000, 500);
        dropdownSelectSearch(conveyorDDL, tbDeviceTypedropdown, conveyorName);
    }

    public void verifySaveBtnIsEnabled() {
        Validator.assertTrue(createBtnDisabled.isNotVisible(10000), "Create button is enabled", "Create button is enabled");
    }

    public void cancelBtnClick() {
        waitForElementVisible(btnCancel, 10000, 500);
        waitForElementToBeClickable(btnCancel);
        btnCancel.jsClick("Cancel");

    }

    public void verifyWarningPopupAndExit() {
        warningDialogBox.isVisible(10000, "Warning Dialog");
        SyncUtil.waitFor(5000);
        btnYes.isVisible(10000, "yes button");
        waitForElementToBeClickable(btnYes);
        btnYes.jsClick("Yes");
    }

    public void clickOnNextBtn() {
        btNext.click();
        waitForPageLoad(15000);
        SyncUtil.waitFor(5000);
        Validator.assertTrue(deviceLocationHeader.isVisible(10000, "Device Location Header"), "User is not navigated to device location page", "User is not navigated to device location page");
    }

    public void clickAndVerifyStatusDropDown() {
        statusDropDown.isVisible(10000, "Status Dropdown");
        statusDropDown.click("Status Dropdown");
        Validator.assertTrue(statusOptionRunning.isVisible(10000, "Running option") && statusOptionNotInOperation.isVisible(10000, "Not In Operation option") &&
                statusOptionPriorToCommissioning.isVisible(10000, "Prior to commissioning"), "All the options of status dropdown are not visible", "All the options of status dropdown  are visible");

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

    public String getPreviousMonth() {
        LocalDate currentDate = LocalDate.now();
        // Get previous month
        LocalDate previousMonthDate = currentDate.minusMonths(1);
        Month previousMonth = previousMonthDate.getMonth();
        return previousMonth.toString();
    }

    public String getNextMonth() {
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

    public void clickAndVerifyMonthChart() {
        monthField.isVisible(10000, "Month Field");
        prevBtn.isVisible(10000, "Previous button");
        prevBtn.jsClick("Previous button");
        Validator.assertTrue(monthField.getText().equalsIgnoreCase(getPreviousMonth()), "Previous month is not displayed", "Previous month is  displayed");
        SyncUtil.waitFor(5000);

        waitForElementVisible(nextBtn, 10000, 500);
        nextBtn.isVisible(10000, "Next button");
        nextBtn.jsClick("Next button");
        SyncUtil.waitFor(5000);
        waitForElementToBeClickable(nextBtn);
        nextBtn.click("Next button");
        Validator.assertTrue(monthField.getText().equalsIgnoreCase(getNextMonth()), "Next month is not displayed", "Next month is  displayed");

        monthField.click("Month");
        Validator.assertTrue(monthChart.isVisible(10000, "Month Chart"), "Month chart is not displayed", "Month chart is displayed");


    }

    public void verifyYearBtnFunctionality() {
        prevBtn.isVisible(10000, "Previous button");
        prevBtn.jsClick("Previous button");
        Validator.assertTrue(
                Integer.parseInt(yearField.getText()) == getPreviousYear(),
                "Previous year is not displayed",
                "Previous year is displayed"
        );
        SyncUtil.waitFor(5000);

        waitForElementVisible(nextBtn, 10000, 500);
        nextBtn.isVisible(10000, "Next button");
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

    public void clickAndVerifyYearChart() {
        yearField.isVisible(10000, "year field");
        yearField.jsClick("year field");
        Validator.assertTrue(yearChart.isVisible(10000, "year Chart"), "year chart is not displayed", "year chart is displayed");
    }

    // Get the previous date
    public int getPreviousDate() {
        LocalDate previousDate = LocalDate.now().minusDays(1);
        return previousDate.getDayOfMonth();
    }

    // Get the next date
    public int getNextDate() {
        LocalDate nextDate = LocalDate.now().plusDays(1);
        return nextDate.getDayOfMonth();
    }

    public void verifyPastDatesSelection() {
        int prevDate = getPreviousDate();
        System.out.println(getPreviousDate() + "getPreviousDate");

        Validator.assertTrue(driver.findElement(By.xpath("(//table[contains(@class,\"p-datepicker-calendar\")]//tr//td//span[text()='" + prevDate + "'])[1]")).isEnabled(), "Previous dates are disabled", "Previous dates are enabled");
        int nextDate = getNextDate();
        System.out.println(getNextDate() + "getNextDate");
        Validator.assertTrue(driver.findElement(By.xpath("(//table[contains(@class, 'p-datepicker-calendar')]//tr//td//span[contains(text(), '" + nextDate + "') and contains(@class, 'p-disabled')])[1]")).isDisplayed(), "Next dates are enabled", "Next dates are disabled");

    }

    public void verifyBeltConveyorSave() {
        waitForElementVisible(tbBeltConveyorSaves, 10000, 500);
        tbBeltConveyorSaves.sendKeys(Keys.ARROW_UP, "upward arrow");
        SyncUtil.waitFor(5000);
        Validator.assertTrue(tbBeltConveyorSaves.getAttribute("value").equalsIgnoreCase("1"), "User doesn't get positive values on clicking up arrow", "User gets positive values on clicking up arrow");
        tbBeltConveyorSaves.sendKeys(Keys.ARROW_DOWN, "upward arrow");
        SyncUtil.waitFor(3000);
        tbBeltConveyorSaves.sendKeys(Keys.ARROW_DOWN, "upward arrow");
        SyncUtil.waitFor(3000);
        Validator.assertTrue(tbBeltConveyorSaves.getAttribute("value").equalsIgnoreCase("-1"), "User doesn't get negative values on clicking up arrow", "User gets negative values on clicking up arrow");
        tbBeltConveyorSaves.sendKeys(Keys.ARROW_UP, "upward arrow");
        tbBeltConveyorSaves.sendKeys(Keys.ARROW_UP, "upward arrow");
        tbBeltConveyorSaves.sendKeys(Keys.ARROW_DOWN, "upward arrow");
        Validator.assertTrue(tbBeltConveyorSaves.getAttribute("value").equalsIgnoreCase("0"), "User doesn't get zero values between positive and negative numbers", "User gets zero values between positive and negative numbers");

    }

    public void verifyCreateAndCancelBtn() {
        Validator.assertTrue(createBtnDisabled.isVisible(10000, "Create"), "Create button is not disabled when the mandatory fields are not filled",
                "Create button is disabled when the mandatory fields are not filled");
        Validator.assertTrue(btnCancel.isVisible(10000, "Cancel"), "Cancel button is not displayed", "Cancel button is displayed");


    }

    public void verifySaveAndCancelBtn() {
        Validator.assertTrue(btSave.isVisible(10000, "Save"), "Save button is not disabled when the mandatory fields are not filled",
                "Save button is disabled when the mandatory fields are not filled");
        Validator.assertTrue(btnCancel.isVisible(10000, "Cancel"), "Cancel button is not displayed", "Cancel button is displayed");


    }

    public void verifyBtnColors() {
        Validator.assertTrue(btCancelStyle.isVisible(10000, "cancel button"), "Cancel button does not have orange border", "Cancel button has orange border");
        waitForElementVisible(btCreateStyle, 10000, 500);
        Validator.assertTrue(btCreateStyle.isEnabled(), "is disabled", "is enabled");

        String createBtnColor = btCreateStyle.getCssValue("background-color");
        String cancelBtnColor = btCancelStyle.getCssValue("background-color");

        String expectedCreateBtnColor = "rgba(255, 165, 0, 1)";  // Orange #FFA500 in rgba
        String expectedCancelBtnColor = "rgba(255, 255, 255, 1)";  // White #FFF in rgba

        Validator.assertTrue(createBtnColor.equalsIgnoreCase(expectedCreateBtnColor), "Create button background color is incorrect!", "Create button background color is correct!");
        Validator.assertTrue(cancelBtnColor.equalsIgnoreCase(expectedCancelBtnColor), "Cancel button background color is incorrect!", "Cancel button background color is correct!");

    }

    public boolean goToCorporateEditScreen() {
        waitForElementToDisplay(crCheckbox);
        crCheckbox.check("Select Device");
        btActions.click("Actions");
        waitForElementVisible(editBtn, 10000, 500);
        editBtn.click("Edit");
        waitForPageLoad(10000);
        return updateDeviceTitle.isVisible(10000, "Update Device title");
    }

    public void goToMonitoringDeviceDetailScreen() {
        waitForElementToDisplay(crViewIcon);
        crViewIcon.click("Conveyor Detail");
        waitForPageLoad(10000);
        tbDeviceName.isVisible(10000, "Device Name");
    }

    public void verifyDeviceTypeInViewMode(String deviceType) {
        deviceTypeField.isVisible(10000, "Device Type");
        Validator.assertTrue(deviceTypeField.getText("device type").equalsIgnoreCase(deviceType), "The device type dropdown value is incorrect!", "The device type dropdown value is correct!");
    }

    public boolean navigateToCordProtect(){
        iotIcon.isEnable("IoT icon");
        iotIcon.jsClick("cord Protect");
        return iotChart1.isNotVisible(5000);
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
    public void verifyMenuListItems()
    {
        for(String listName:menuListNames)
        {
            SyncUtil.waitFor(3000);
            Validator.assertTrue(driver.findElement(By.xpath("//div//ul[@class=\"cord-menu-layout\"]//a//span[text()='"+listName+"']")).isDisplayed(),"'"+listName+"' link is not visible","'"+listName+"' link is visible");
        }

    }
    public void clickAndVerifyFloatingMenuIcon()
    {
        menuList.isVisible(10000,"MenuList");
        waitForElementToBeClickable(menuList);
        menuList.click("menuList");
        verifyMenuListItems();
    }
    public void ripInsertListClick(String listItem, String nestedItem) {
        try {
            //  check if the expanded element is visible
            boolean isExpanded = isElementVisible(ripInsertListExpanded, 10000);

            if (isExpanded) {
                Reporter.log("Rip Insert menu item is already expanded.");
            } else {
                Reporter.log("Rip Insert menu item is not expanded. Expanding now...");
                waitForElementToBeClickable(ripInsertList);
                ripInsertList.click("Rip Insert");
                SyncUtil.waitFor(2000);
            }

            // Perform the list item click action
            listItemClick(listItem, nestedItem);
        } catch (Exception e) {
            Reporter.log("An unexpected exception occurred: " + e.getMessage());
        }
    }
    private boolean isElementVisible(WebElement element, int timeout) {
        try {
            if (element != null) {
                return element.isDisplayed();
            }
        } catch (NoSuchElementException e) {
            Reporter.log("Element not found or not visible: " + e.getMessage());
        } catch (Exception e) {
            Reporter.log("Unexpected exception while checking visibility: " + e.getMessage());
        }
        return false;
    }



    public void listItemClick(String listItem,String nestedItem)
    {
        SyncUtil.waitFor(1000);
        waitForElementVisible(driver.findElement(By.xpath("//div//ul[@class=\"cord-menu-layout\"]//a//span[text()='"+listItem+"']/../..//ul//li//a//span[text()='"+nestedItem+"']")),10000,500);
        waitForElementToBeClickable(driver.findElement(By.xpath("//div//ul[@class=\"cord-menu-layout\"]//a//span[text()='"+listItem+"']/../..//ul//li//a//span[text()='"+nestedItem+"']")));
        driver.findElement(By.xpath("//div//ul[@class=\"cord-menu-layout\"]//a//span[text()='"+listItem+"']/../..//ul//li//a//span[text()='"+nestedItem+"']")).click();
        SyncUtil.waitFor(5000);
        waitForPageLoad(10000);

    }
    public void verifyRipInsertThumbnailsList()
    {
        breadCrumbText.isVisible(10000,"BreadCrumb");
        SyncUtil.waitFor(3000);
        Validator.assertTrue(breadCrumbText.getText().contains("RIP Insert"),"User is not navigated to Rip Insert thumbnails!","User is navigated to Rip Insert thumbnails!");
        List<WebElement> elements=driver.findElements(By.xpath("//app-rip-insert-thumbnail//div//p-card"));
        for(int i=1;i<elements.size();i++)
        {
            Validator.assertTrue(driver.findElement(By.xpath("(//app-rip-insert-thumbnail//div//p-card)['"+i+"']")).isDisplayed(),"Rip Inserts are not visible","'"+i+"' rip insert is displayed in rip insert list");
        }

    }
    public void clickAndVerifyRipInsertDetailPage()
    {
        scrollPageup();
        ripInsertData.isVisible(10000,"Rip Insert Record");
        ripInsertData.click("Rip Insert Record");
        waitForPageLoad(10000);
        breadCrumbText.isVisible(10000,"Bread Crumb");
        Validator.assertTrue(ripInsertThumbnailHeader.isVisible(10000,"Thumbnails Header"),"User is not navigated to Rip Insert detail page!","User is  navigated to Rip Insert detail page!");
        waitForPageLoad(10000);
    }
    public void verifyRipInsertTableNavigation()
    {
        breadCrumbText.isVisible(10000,"BreadCrumb");
        Validator.assertTrue(breadCrumbText.getText().contains("Table of Rip Inserts"),"User is not navigated to Rip Insert table page!","User is  navigated to Rip Insert table page!");
    }

    public void verifyAlarmHistoryNavigation()
    {
        breadCrumbText.isVisible(10000,"BreadCrumb");
        Validator.assertTrue(breadCrumbText.getText().contains("RIP Events"),"User is not navigated to Alarm History page!","User is navigated to Alarm History page");
    }
    public void verifyRipInsertData()
    {
        Validator.assertTrue(ripInsertImageTab.isVisible(10000,"Rip Insert Image"),"Rip Insert image tab is not visible","Rip Insert image tab is visible");
        Validator.assertTrue(ripInsertAlarmTab.isVisible(10000,"Rip Insert Alarm"),"Rip Insert alarm tab is not visible","Rip Insert alarm tab is visible");
        Validator.assertTrue(ripInsertPositionText.isVisible(10000,"position"),"Rip Insert position is visible","Rip Insert position is visible");
        Validator.assertTrue(ripInsertImgGeneratedTxt.isVisible(10000,"generated Image"),"Rip Insert generated image tab is not visible","Rip Insert generated image tab is visible");
        Validator.assertTrue(ripInsertImageDisplayed.isVisible(10000,"Image"),"Rip Insert image is not visible","Rip Insert image is visible");
        Validator.assertTrue(ripInsertEstimatedWidth.isVisible(10000,"estimated width of rip insert"),"estimated width for rip insert is not visible","estimated width for rip insert is  visible");

    }
    public void verifyRipInsertDataInTabularColumn()
    {
        waitForPageLoad(10000);
        int paginationCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        for(int i=1;i<paginationCount;i++)
        {
            Validator.assertTrue(driver.findElement(By.xpath("//tr['"+i+"']//td")).isDisplayed(),"ripInsert Data found","ripInsert Data found");
        }
    }
    public void clickOnViewButton()
    {
        viewMoreBtn.isVisible(10000,"view more");
        viewMoreBtn.jsClick("View More");
        waitForPageLoad(10000);
    }
    public void clickAndVerifyForwardNavigation()
    {
        viewNextBtn.isVisible(10000,"Next Button");
        viewNextBtn.jsClick("next button");
        ripInsertThumbnailHeader.isVisible(10000,"Rip Insert Header");
        Validator.assertTrue(ripInsertThumbnailHeader.getText().contains("2"),"user cannot navigate between rip inserts with forward arrow","user can navigate between rip inserts with forward arrow");
    }
    public void clickAndVerifyBackwardNavigation()
    {
        viewPrevBtn.isVisible(10000,"Prev Button");
        viewPrevBtn.jsClick("prev button");
        ripInsertThumbnailHeader.isVisible(10000,"Rip Insert Header");
        Validator.assertTrue(ripInsertThumbnailHeader.getText().contains("1"),"user cannot navigate between rip inserts with backward arrow","user can navigate between rip inserts with backward arrow");
    }
    public void clickAndVerifyLatestAlarmLink()
    {
        ripInsertAlarmTab.isVisible(10000,"Latest alarm link");
        ripInsertAlarmTab.jsClick("Latest alarm link");
        Validator.assertTrue(ripInsertAlarmTabActivated.isVisible(10000,"RipInsertAlarmTabActivated"),"Latest alarm for this insert link is not activated","Latest alarm for this insert link is visible and is activated");
    }
    public void editComment(String editComment)
    {
        tbComment.isVisible(10000,"comments tab");
        tbComment.type(editComment);
    }
    public void verifyViewComment(String comment)
    {
        tbComment.isVisible(10000,"comments tab");
        System.out.println(tbComment.getAttribute("value")+"value is");
        Validator.assertTrue(tbComment.getAttribute("value").equalsIgnoreCase(comment),"User cannot view the updated comment!","User can view the updated comment!");

    }
    public void verifyDeviceBreadCrumb(String deviceName,String breadCrumb)
    {
        breadCrumbText.isVisible(10000,"BreadCrumb");
        SyncUtil.waitFor(3000);
        System.out.println(breadCrumbText.getText()+"bc text");
        Validator.assertTrue(breadCrumbText.getText().contains("Home\nMonitoring Devices\n"+deviceName+"\n"+breadCrumb),"User is not navigated to '"+breadCrumb+"'!","User is navigated to '"+breadCrumb+"'!");
    }

    public void splicesListClick(String listItem, String nestedItem) {
        try {
            //  check if the expanded element is visible
            boolean isExpanded = isElementVisible(ripInsertListExpanded, 10000);

            if (isExpanded) {
                Reporter.log("Rip Insert menu item is already expanded.");
            } else {
                Reporter.log("Rip Insert menu item is not expanded. Expanding now...");
                waitForElementToBeClickable(ripInsertList);
                ripInsertList.click("Rip Insert");
                SyncUtil.waitFor(2000);
            }

            // Perform the list item click action
            listItemClick(listItem, nestedItem);
        } catch (Exception e) {
            Reporter.log("An unexpected exception occurred: " + e.getMessage());
        }
    }

    public void verifyDeletedMonitoringDevice(String calc) {
        goToMonitoringDeviceListScreen();
        waitForPageLoad(10000);
        btSearchinput.type(calc, "Calc Search");
        Validator.assertTrue(noList.isVisible(),"Delete Monitoring Device was still found in list screen","Monitoring Device deleted successfully");
    }





}
