package com.web.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.*;

import java.util.Map;

import java.util.Map;


public class BeltMonitoringSteps {

    LoginPage loginPage = new LoginPage();
    MonitoringDevicePage monitoringDevicePage = new MonitoringDevicePage();
    ConveyorPage conveyorPage = new ConveyorPage();
    CoverWearPage coverWearPage = new CoverWearPage();
    UsersPage userPage = new UsersPage();
    HeavyEquipmentPage heavyEquipmentPage=new HeavyEquipmentPage();
    CorporatePage corporatePage=new CorporatePage();


    @QAFTestStep(description = "Navigate to Belt Monitoring List screen")
    public void verifyNavigationToMonitoringDeviceListScreen() {
        monitoringDevicePage.goToMonitoringDeviceListScreenAndWait();
    }

    @QAFTestStep(description = "Navigate to Belt Monitoring List page")
    public void verifyNavigationToMonitoringDeviceListPage() {
        monitoringDevicePage.goToMonitoringDeviceListScreen();
    }

    @QAFTestStep(description = "Navigate to Belt Monitoring List page for {Device}")
    public void verifyNavigationToMonitoringDeviceListPageWithDelete(String monitoringDevice) {
        Map<String, Object> obj = monitoringDevicePage.apiBase.getMonitoringDeviceAPI(monitoringDevice);
        if(obj != null)
            monitoringDevicePage.apiBase.deleteMonitoringDeviceAPI((String) obj.get("monitoringDeviceId"));
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

    @QAFTestStep(description = "Add the device details with mandatory field {DeviceName} {DeviceType} {Status} and {ConveyorName}")
    public void addDeviceDetailsWithMan(String deviceName, String deviceType, String status, String conveyorName) {
//        String companyId = monitoringDevicePage.apiBase.getCompanyID(monitoringDevicePage.apiBase.getCompanyAPI(deviceName));
//        monitoringDevicePage.apiBase.deleteCompanyAPI(companyId);
        monitoringDevicePage.addDeviceDetailsWithMandatoryFields(deviceName, deviceType,status);
        monitoringDevicePage.navigateToAddLocation();
        monitoringDevicePage.selectConveyor(conveyorName);
    }

    @QAFTestStep(description = "Add the non-mandatory fields for device with {Brand} {SerialNumber} {RemoteConnection} {CommisioningDate} and {BeltConveyorSaves} and {FirmWareVersion} {LastServiceDateField} {LastServiceDate} {Comment} {InstallationDate}")
    public void addNonMandatoryDeviceDetails(String brand, String serialNo, String remoteConnection, String comminsionDate, String beltConveyorSave, String firmwareVersion,String lastServiceDateField,String lastServiceDate,String comment,String installationDate) {
        conveyorPage.previousBtnClick();
        monitoringDevicePage.addDeviceDetailsWithNonMandatoryFields(brand, serialNo, remoteConnection, comminsionDate, beltConveyorSave, firmwareVersion,lastServiceDateField,lastServiceDate,comment);
        coverWearPage.selectGivenDate(installationDate);

    }

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
//        monitoringDevicePage.searchMonitoringDevice(deviceName);
        monitoringDevicePage.goToMonitoringDeviceEditScreen(deviceName);
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

    @QAFTestStep(description="Verify the monitoring device {Device} in list screen")
    public void searchMonitoringDevice(String device){
        Map<String, Object> obj = monitoringDevicePage.apiBase.getMonitoringDeviceAPI(device);
        if(obj != null)
            obj = monitoringDevicePage.apiBase.getMonitoringDeviceDetailsAPI((String) obj.get("monitoringDeviceId"));
        Validator.assertTrue(monitoringDevicePage.searchMonitoringDevice(device),"Monitoring Device was not found","Monitoring Device was found and verified successfully");
    }

    @QAFTestStep(description="Navigate to cord protect iot window")
    public void verifyCordProtectWindow(){
        Validator.assertTrue(monitoringDevicePage.navigateToCordProtect(),"IOT dashboard verification failed", "Iot dashboard verified successfully");
    }

    @QAFTestStep(description="Verify the cord protect details page")
    public void verifyCordProtectDetails(){
        Validator.assertTrue(monitoringDevicePage.verifyCordProtect(),"IOT dashboard verification failed", "Iot dashboard verified successfully");
    }
    @QAFTestStep(description="Click on floating menu icon and verify user can get list of links")
    public void clickFloatingMenuAndVerifyLinks(){
        monitoringDevicePage.clickAndVerifyFloatingMenuIcon();
    }
    @QAFTestStep(description="Click on Rip Insert thumbnails {RipInsert} {RipInsertThumbNails} and verify user is able to to see Rip Inserts")
    public void clickAndVerifyRipInsertsThumbnailsVisible(String listItem,String nestedItem){
        monitoringDevicePage.ripInsertListClick(listItem,nestedItem);
        monitoringDevicePage.verifyRipInsertThumbnailsList();
    }
    @QAFTestStep(description = "Click on a Rip Insert and verify Rip Insert detail page pf the selected Rip Insert is displayed")
    public void verifyRipInsertDetailPageNavigation()
    {monitoringDevicePage.clickAndVerifyRipInsertDetailPage();}

    @QAFTestStep(description = "Click on RipInsertTable  {RipInsert} {RipInsertTable} and verify user is able to navigate to rip insert table")
    public void clickAndVerifyRipInsertsTable(String listItem,String nestedItem)
    {
        monitoringDevicePage.clickAndVerifyFloatingMenuIcon();
        monitoringDevicePage.ripInsertListClick(listItem,nestedItem);
//        monitoringDevicePage.listItemClick(listItem,nestedItem);
        monitoringDevicePage.verifyRipInsertTableNavigation();
    }
    @QAFTestStep(description = "Click on AlarmHistory {RipInsert} {AlarmHistory} and verify user is able to see RIP Events")
    public void clickAndVerifyAlarmHistory(String listItem,String nestedItem)
    {
        monitoringDevicePage.clickAndVerifyFloatingMenuIcon();
        monitoringDevicePage.listItemClick(listItem,nestedItem);
        monitoringDevicePage.verifyAlarmHistoryNavigation();
    }

    @QAFTestStep(description = "Verify the Rip Insert data for the selected Rip Insert")
    public void verifyRipInsertPageData()
    {
        monitoringDevicePage.verifyRipInsertData();
    }
    @QAFTestStep(description = "Verify the number of Rip Inserts are visible under tabular view")
    public void verifyRipInsertDataVisibleUnderColumn()
    {
        monitoringDevicePage.verifyRipInsertDataInTabularColumn();
    }
    @QAFTestStep(description = "Verify the column names of Rip Insert Table")
    public void verifyRipInsertColNames()
    {
        heavyEquipmentPage.verifyHeavyEquipmentData();
    }
    @QAFTestStep(description = "Click on more button and verify rip insert image with all the options")
    public void clickOnMoreBtnAndVerifyRipInsertImage()
    {
        monitoringDevicePage.clickOnViewButton();
        monitoringDevicePage.verifyRipInsertData();
    }
    @QAFTestStep(description = "Verify user can navigate between rip inserts with forward arrow")
    public void verifyRipInsertNavigationWithForwardArrow()
    {
        monitoringDevicePage.clickAndVerifyForwardNavigation();
    }
    @QAFTestStep(description = "Verify user can navigate between rip inserts with backward arrow")
    public void verifyRipInsertNavigationWithBackwardArrow()
    {
        monitoringDevicePage.clickAndVerifyBackwardNavigation();
    }
    @QAFTestStep(description = "Verify the Latest alarm for this insert link is visible and is activated")
    public void verifyLatestAlarmLinkActivated()
    {
        monitoringDevicePage.clickAndVerifyLatestAlarmLink();
    }
    @QAFTestStep(description = "Navigate to edit page and verify user can edit the comment {EditComment}")
    public void editAndVerifyComment(String editComment)
    {
        monitoringDevicePage.goToCorporateEditScreen();
        monitoringDevicePage.editComment(editComment);
        corporatePage.btnSaveClick();
    }
    @QAFTestStep(description = "Verify user can view the comment {EditComment}")
    public void clickAndVerifyViewComment(String comment)
    {
        monitoringDevicePage.verifyViewComment(comment);
    }
    @QAFTestStep(description = "Click on any past installation date user should be able to select only past date")
    public void verifyPastInstallationDateSelection() {
        monitoringDevicePage.verifyRemoteConnectionDDL();
        monitoringDevicePage.clickInstallationDateCalendarPopup();
        monitoringDevicePage.verifyPastDatesSelection();
    }
    @QAFTestStep(description = "Verify user is able to manually enter input for date field {DateField} {Date} and is supported")
    public void verifyManualInputForDateField(String dateField,String date) {
        monitoringDevicePage.verifyRemoteConnectionDDL();
        monitoringDevicePage.verifyManualDateSelection(dateField,date);
    }

    @QAFTestStep(description="Edit monitoring device {Device} to {NewDevice}")
    public void editMonitoringDeviceTo(String device, String newdevice){
        monitoringDevicePage.editMonitoringDevice(device, newdevice);
    }

    @QAFTestStep(description="Delete monitoring device {Device}")
    public void deleteMonitoringDevice(String device){
        Validator.assertTrue(monitoringDevicePage.deleteMonitoringDevice(device),"Monitoring device was found after delete","Monitoring device was found and verified successfully");
    }

    @QAFTestStep(description="Verify the deleted monitoring device {Device} in list screen")
    public void verifyTheDeletedMonitoringDeviceInListScreen(String device){
        monitoringDevicePage.verifyDeletedMonitoringDevice(device);
    }

    @QAFTestStep(description = "Click on menu item {RipInsert} {RipInsertThumbNails} and verify breadcrumb for {DeviceName} with {RipInsertBreadCrumb}")
    public void verifyRipInsertBreadCrumb(String listItem,String nestedItem,String deviceName,String breadcrumb )
    {
        monitoringDevicePage.clickAndVerifyFloatingMenuIcon();
        monitoringDevicePage.ripInsertListClick(listItem,nestedItem);
        monitoringDevicePage.verifyDeviceBreadCrumb(deviceName,breadcrumb);
    }


}