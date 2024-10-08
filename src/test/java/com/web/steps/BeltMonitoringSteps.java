package com.web.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.*;

public class BeltMonitoringSteps {

    LoginPage loginPage = new LoginPage();
    MonitoringDevicePage monitoringDevicePage = new MonitoringDevicePage();
    ConveyorPage conveyorPage = new ConveyorPage();
    CoverWearPage coverWearPage=new CoverWearPage();
    UsersPage userPage=new UsersPage();


    @QAFTestStep(description = "Navigate to Belt Monitoring List screen")
    public void verifyNavigationToMonitoringDeviceListScreen() {
        monitoringDevicePage.goToMonitoringDeviceListScreenAndWait();
    }
    @QAFTestStep(description = "Navigate to Belt Monitoring List page")
    public void verifyNavigationToMonitoringDeviceListPage() {
        monitoringDevicePage.goToMonitoringDeviceListScreen();
    }
    @QAFTestStep(description = "Search for the MonitoringDevice {Device} and select the checkbox")
    public void searchAndSelectMonitoringDevice(String device) {
        monitoringDevicePage.searchMonitoringDevice(device);
        conveyorPage.selectConveyor();
    }
    @QAFTestStep(description = "Verify user is able to find the action button and is enabled by default")
    public void verifyActionBtn() {
        monitoringDevicePage.verifyActionBtnIsEnabled();
    }
    @QAFTestStep(description = "Click on action dropdown and verify edit and delete options are visible")
    public void clickActionBtnAndVerifyDropDown() {
        conveyorPage.actionBtnClick();
        monitoringDevicePage.verifyActionDropdownForSingleSelection();
    }
    @QAFTestStep(description = "Click on action dropdown and verify only delete option is visible")
    public void clickActionBtnAndVerifyDropDownForMultiple() {
        conveyorPage.actionBtnClick();
        monitoringDevicePage.verifyActionDropdownForMultipleSelection();
    }

    @QAFTestStep(description = "Enter the columnName {ColumnName} in searchBar and verify all columnName with search text is displayed in monitoring device")
    public void searchAndVerifyColumnNameForMonitoringDevice(String columnName) {
        conveyorPage.searchColumnName(columnName);
        monitoringDevicePage.verifySearchedColumnNames();
    }
    @QAFTestStep(description = "Click on action dropdown and verify Scan QR is visible")
    public void clickActionBtnAndVerifyScanQR() {
        conveyorPage.actionBtnClick();
        monitoringDevicePage.verifyScanQRIsVisibleAndClick();
    }
    @QAFTestStep(description = "Click on the scanner symbol and verify fields {DeviceName}")
    public void clickScanQRAndVerifyFields(String deviceName) {
        conveyorPage.actionBtnClick();
        monitoringDevicePage.clickScanQRAndVerify(deviceName);
    }
    @QAFTestStep(description = "Click on the download button and verify QR is downloaded with the proper name {Device1}")
    public void verifyQRDownloadFunctionality(String deviceName) {
        monitoringDevicePage.downloadButtonClick();
        SyncUtil.waitFor(5000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles(deviceName+"_QR_Code.png"),"QR Code was not found","QR Code was downloaded successfully");
    }
    @QAFTestStep(description ="Navigate to Add monitoring device screen")
    public void navigateToAddMonitoringDevice()
    {
        monitoringDevicePage.goToAddMonitoringDevice();
    }
    @QAFTestStep(description = "Verify the bread crumb of add monitoring device page")
    public void verifyBreadCrumbOfMonitoringDevice() {
        monitoringDevicePage.verifyMonitoringDeviceBreadCrumb();
    }
    @QAFTestStep(description = "Add the device details with mandatory field {DeviceName} {DeviceType} {InstallationDate} and {ConveyorName}")
    public void addDeviceDetailsWithMan(String deviceName,String deviceType,String date,String conveyorName)
    {
//        String companyId = monitoringDevicePage.apiBase.getCompanyID(monitoringDevicePage.apiBase.getCompanyAPI(deviceName));
//        monitoringDevicePage.apiBase.deleteCompanyAPI(companyId);
        monitoringDevicePage.addDeviceDetailsWithMandatoryFields(deviceName,deviceType);
        coverWearPage.selectGivenDate(date);
        monitoringDevicePage.navigateToAddLocation();
        monitoringDevicePage.selectConveyor(conveyorName);
    }
    @QAFTestStep(description = "Add the non-mandatory fields for device with {Brand} {SerialNumber} {RemoteConnection} {CommisioningDate} and {BeltConveyorSaves} and {FirmWareVersion}")
    public void addNonMandatoryDeviceDetails(String brand,String serialNo,String remoteConnection,String comminsionDate,String beltConveyorSave,String firmwareVersion)
    {monitoringDevicePage.addDeviceDetailsWithNonMandatoryFields(brand,serialNo,remoteConnection,comminsionDate,beltConveyorSave,firmwareVersion);}

    @QAFTestStep(description = "Verify save button is enabled")
    public void verifySaveBtnEnabledForMandFields()
    {
        monitoringDevicePage.verifySaveBtnIsEnabled();
    }
    @QAFTestStep(description = "Click on Cancel button and verify warning popup is displayed and click on yes button")
    public void clickCancelBtnAndVerifyPopup()
    {
        monitoringDevicePage.cancelBtnClick();
        SyncUtil.waitFor(10000);
        monitoringDevicePage.verifyWarningPopupAndExit();
    }
    @QAFTestStep(description = "Verify user is navigated to monitoring device listing page")
    public void verifyMonitoringDeviceListPageNavigation()
    {
        monitoringDevicePage.waitForPageLoad(10000);
        Validator.assertTrue(monitoringDevicePage.getCurrentURL().contains("/secure/dashboard/devices"),"User is navigated to monitoring device list page",
                "User is navigated to monitoring device list page");
    }
    @QAFTestStep(description = "Click on save button and verify device {DeviceName} is created successfully")
    public void verifyMonitoringDeviceCreation(String deviceName)
    {
        conveyorPage.clickCreateBtn();
        monitoringDevicePage.waitForPageLoad(10000);
        Validator.assertTrue(monitoringDevicePage.getCurrentURL().contains("/secure/dashboard/devices"),"User is navigated to monitoring device list page",
                "User is navigated to monitoring device list page");
        monitoringDevicePage.searchMonitoringDevice(deviceName);

    }
    @QAFTestStep(description = "Click on next button and verify navigation to Add Location page")
    public void clickNxtBtnAndVerifyNavigation()
    {
        monitoringDevicePage.clickOnNextBtn();
    }
    @QAFTestStep(description = "Click on the status dropdown and verify the dropdown values")
    public void statusDropDownClickAndVerify()
    {monitoringDevicePage.clickAndVerifyStatusDropDown();}

    @QAFTestStep(description = "Verify the format of the installation date field and click on it and verify calendar popup is displayed")
    public void verifyCalendarPopUpDisplay()
    {monitoringDevicePage.clickInstallationDateCalendarPopup();}
    @QAFTestStep(description = "Verify the format of the commissioning date field and click on it and verify calendar popup is displayed")
    public void verifyCalendarPopUpDisplayForCommissioningDate()
    {monitoringDevicePage.clickCommissioningDateCalendarPopup();}

    @QAFTestStep(description = "Click on the month in calender and verify month chart is displayed and next and verify previous buttons functionality")
    public void clickOnMonthAndVerifyMonthChart()
    {
        monitoringDevicePage.clickAndVerifyMonthChart();
        monitoringDevicePage.verifyYearBtnFunctionality();
    }
    @QAFTestStep(description = "Click on the year in calender and verify year chart is displayed and next and verify previous buttons functionality")
    public void clickOnYearAndVerifyYearChart()
    {
        monitoringDevicePage.clickAndVerifyYearChart();
    }

    @QAFTestStep(description = "Click on any past commissioning date user should be able to select only past date")
    public void verifyPastDateSelection()
    {
        monitoringDevicePage.verifyRemoteConnectionDDL();
        monitoringDevicePage.clickCommissioningDateCalendarPopup();
        monitoringDevicePage.verifyPastDatesSelection();
    }

    @QAFTestStep(description = "Click on the belt/conveyor saves text field and verify the upward and downward functionality")
    public void verifyBeltConveyorSavesFunctionality()
    {
        monitoringDevicePage.verifyBeltConveyorSave();
    }
    @QAFTestStep(description = "Verify create and cancel buttons are displayed")
    public void verifyCreateCancelBtnDisplay()
    {
        monitoringDevicePage.verifyCreateAndCancelBtn();
    }
    @QAFTestStep(description = "Verify create and cancel button colors")
    public void verifyBtnStyles()
    {monitoringDevicePage.verifyBtnColors();}

    @QAFTestStep(description = "Search for the device {DeviceName} and navigate to edit device page")
    public void navigateToEditDevicePage(String deviceName)
    {
        Validator.assertTrue(monitoringDevicePage.getCurrentURL().contains("/secure/dashboard/devices"),"User is navigated to monitoring device list page",
                "User is navigated to monitoring device list page");
        monitoringDevicePage.searchMonitoringDevice(deviceName);
        monitoringDevicePage.goToCorporateEditScreen();
    }

    @QAFTestStep(description = "Verify save and cancel buttons are displayed")
    public void verifySaveCancelBtnDisplay()
    {monitoringDevicePage.verifySaveAndCancelBtn();}

    @QAFTestStep(description = "Verify the values under the device type dropdown")
    public void verifyTheDeviceTypeDdlVal()
    {monitoringDevicePage.verifyDeviceTypeDDL();}

    @QAFTestStep(description = "Click on cancel button and verify navigation to monitoring device list page")
    public void cancelBtnClickAndVerifyNavigation()
    {
        monitoringDevicePage.cancelBtnClick();
        monitoringDevicePage.waitForPageLoad(10000);
        Validator.assertTrue(monitoringDevicePage.getCurrentURL().contains("/secure/dashboard/devices"),"User is navigated to monitoring device list page",
                "User is navigated to monitoring device list page");

    }

    @QAFTestStep(description = "Search for the device {DeviceName} and navigate to view device page")
    public void navigateToViewDevicePage(String deviceName)
    {
        Validator.assertTrue(monitoringDevicePage.getCurrentURL().contains("/secure/dashboard/devices"),"User is navigated to monitoring device list page",
                "User is navigated to monitoring device list page");
        monitoringDevicePage.searchMonitoringDevice(deviceName);
        monitoringDevicePage.goToMonitoringDeviceDetailScreen();
    }

    @QAFTestStep(description = "Verify the deviceType {DeviceType} in monitoring device view page")
    public void verifyDeviceTypeInViewPage(String deviceType)
    {
        monitoringDevicePage.verifyDeviceTypeInViewMode(deviceType);
    }
    @QAFTestStep(description = "Verify user is able to see the column names selected by default")
    public void verifyDefaultCbxSelectedInMonitoringDeviceFilter()
    {
        conveyorPage.verifyCheckedColumnNames();
    }
    @QAFTestStep(description = "Select only two columns and verify the selected columns are visible in the table")
    public void selectTwoColumnsAndVerifyTable()
    {
        conveyorPage.selectTwoColumnsAndVerify();
        conveyorPage.verifySelectedColumnDisplay("multiple");
        conveyorPage.verifySelectedColumnDisplay("single");
    }




}