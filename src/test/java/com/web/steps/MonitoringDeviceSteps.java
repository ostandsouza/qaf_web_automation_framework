package com.web.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.ConveyorPage;
import com.web.pages.CoverWearPage;
import com.web.pages.MonitoringDevicePage;
import com.web.pages.UsersPage;

import java.util.Map;
import java.util.Optional;

public class MonitoringDeviceSteps {

    MonitoringDevicePage monitoringDevicePage = new MonitoringDevicePage();
    CoverWearPage coverWearPage = new CoverWearPage();
    UsersPage userPage = new UsersPage();
    ConveyorPage conveyorPage = new ConveyorPage();

    @QAFTestStep(description = "Click on carousel left icon")
    public void clickTheCarouselLeftIcon() {
        monitoringDevicePage.clickCarouselLeftIcon();
    }
    @QAFTestStep(description = "Click on carousel right icon")
    public void clickTheCarouselRightIcon() {
        monitoringDevicePage.clickCarouselRightIcon();
    }
    @QAFTestStep(description = "Verify Belt Monitoring card details")
    public void verifyTheBeltMonitoringCardDetails() {
        monitoringDevicePage.verifyBeltMonitoringCardDetails();
    }

    @QAFTestStep(description = "Navigate to Belt Monitoring List screen")
    public void verifyNavigationToMonitoringDeviceListScreen() {
        monitoringDevicePage.goToMonitoringDeviceListScreenAndWait();
        monitoringDevicePage.verifyMonDevInListView();
    }
    @QAFTestStep(description = "Search for the {MonitoringDevice} monitoring Device")
    public void searchTheMonitoringDevice(String monitoringDevice) {
        monitoringDevicePage.searchMonitoringDevice(monitoringDevice);
    }
    @QAFTestStep(description = "Click the checkbox in the row table")
    public void clickTheCheckBox() {
        monitoringDevicePage.clickCheckBox();
    }
    @QAFTestStep(description = "Verify Action button is enabled with delete edit and scan option available")
    public void verifyTheMonDevActionBtnFunOnSelection() {
        monitoringDevicePage.verifyMonDevActionBtnFuntionalityOnSelection();
    }
    @QAFTestStep(description = "Verify Action button is enabled without delete edit and scan option")
    public void verifyTheMonDevActionBtnFunDefault() {
        monitoringDevicePage.verifyMonDevActionBtnFuntionalityOnDefault();
    }
    ///
    @QAFTestStep(description="Verify that the filter is applied for {cloumnName} {filter}")
    public void verifyTheFilterOrSorting(String cloumnName,String filter){
        SyncUtil.waitFor(40000);
        int noOfCoverWears = Integer.parseInt(MiscUtils.regexExtractor(monitoringDevicePage.paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        monitoringDevicePage.verifyColumnFilterClick(noOfCoverWears,cloumnName,filter);
    }

    @QAFTestStep(description="Click on clear filter and verify filter {cloumnName} is removed")
    public void clearTheFilterAndVerify(String cloumnName){
        monitoringDevicePage.clearFilterClick();
        monitoringDevicePage.verifyFilterIsRemoved(cloumnName);
    }

    @QAFTestStep(description="Apply sorting or filter on column name {cloumnName} {filterName} {filter}")
    public void applyTheFilterOrSorting(String cloumnName,String filterName,String filter){
        System.out.println(cloumnName+filterName+filter);
        monitoringDevicePage.applyColumnFilterClick(cloumnName,filterName,filter);
    }
    @QAFTestStep(description = "Zoom in and out to reach conveyor location")
    public void clickOnZoomInAndOut() {
        monitoringDevicePage.clickOnZoomOut();
        monitoringDevicePage.clickOnZoomIn();
    }

    @QAFTestStep(description = "Add the non-mandatory fields for device with {Brand} {SerialNumber} {RemoteConnection} {CommisioningDate} and {BeltConveyorSaves} and {FirmWareVersion} {LastServiceDateField} {LastServiceDate} {Comment} {InstallationDate}")
    public void addNonMandatoryDeviceDetails(String brand, String serialNo, String remoteConnection, String comminsionDate, String beltConveyorSave, String firmwareVersion,String lastServiceDateField,String lastServiceDate,String comment,String installationDate) {
        conveyorPage.previousBtnClick();
        monitoringDevicePage.addDeviceDetailsWithNonMandatoryFields(brand, serialNo, remoteConnection, comminsionDate, beltConveyorSave, firmwareVersion,lastServiceDateField,lastServiceDate,comment);
        coverWearPage.selectGivenDate(installationDate);

    }

    ///
    @QAFTestStep(description="Click on location symbol and verify location pop up details for {MonitoringDevice}")
    public void clickAndVerifyTheLocationPopUp(String monitoringDevice){
        monitoringDevicePage.clickAndVerifyLocationPopUp(monitoringDevice);
    }
    @QAFTestStep(description="Verify Map and Satellite button selection")
    public void verifyTheMapAndSatelliteBtn(){
        monitoringDevicePage.verifyMapAndSatelliteBtn();
    }
    @QAFTestStep(description="Verify PegMan hover and drag functionality")
    public void verifyThePegManFunctionality(){
        monitoringDevicePage.verifyPegManFunctionality();
    }

    @QAFTestStep(description ="Navigate to Add monitoring device screen")
    public void navigateToAddMonitoringDevice()
    {
        monitoringDevicePage.goToAddMonitoringDevice();
    }

    @QAFTestStep(description = "Add the device details with mandatory field {DeviceName} {DeviceType} {Status} and {ConveyorName}")
    public void addDeviceDetailsWithMan(String deviceName,String deviceType,String status,String conveyorName)
    {
//        String companyId = monitoringDevicePage.apiBase.getCompanyID(monitoringDevicePage.apiBase.getCompanyAPI(deviceName));
//        monitoringDevicePage.apiBase.deleteCompanyAPI(companyId);
        monitoringDevicePage.addDeviceDetailsWithMandatoryFields(deviceName,deviceType,status);
        monitoringDevicePage.navigateToAddLocation();
        monitoringDevicePage.selectConveyor(conveyorName);
    }
    @QAFTestStep(description = "Add the device details with field {DeviceName} {DeviceType} {Status}")
    public void addTheDeviceDetailsFields(String deviceName,String deviceType,String status)
    {
        monitoringDevicePage.addDeviceDetailsWithMandatoryFields(deviceName,deviceType,status);
    }

    @QAFTestStep(description = "Verify the table header panel")
    public void verifyTheTableHeaderPanel()
    {
        monitoringDevicePage.verifyTableHeaderPanel();
    }
    @QAFTestStep(description = "Click on the Belt Monitoring card")
    public void clickOnTheBeltMonitoringCard()
    {
        monitoringDevicePage.clickOnBeltMonitoringCard();
    }
    @QAFTestStep(description = "Verify the add location page functionality for add monitoring device page with {AssociatedDistName} {SiteName} {Latitude} {Longitude}")
    public void verifyTheAddLocationPageFuncInMonDev(String associatedDistName,String siteName,String latitude,String longitude)
    {
        monitoringDevicePage.verifyContentsOfAddLocationPage();
        monitoringDevicePage.addContentsOfAddLocationPage(associatedDistName,siteName,latitude,longitude);
        monitoringDevicePage.verifyMapFunctionalityInMonDev();
    }
    @QAFTestStep(description = "Click on save button and verify device {DeviceName} is created successfully")
    public void verifyMonitoringDeviceCreation(String deviceName)
    {
        conveyorPage.clickCreateBtn();
        monitoringDevicePage.waitForPageLoad(10000);
        Validator.assertTrue(monitoringDevicePage.getCurrentURL().contains("/devices"),"User is notnavigated to monitoring device list page",
                "User is navigated to monitoring device list page");
        monitoringDevicePage.searchMonitoringDevice(deviceName);

    }
    @QAFTestStep(description = "Click on previous button  and verify navigation to Add Location page")
    public void clickOnThePreviousBtnLocPage()
    {
        userPage.clickOnPreviousBtn();
        monitoringDevicePage.validateAddDevicePage();
    }

    @QAFTestStep(description = "Click on next button and verify navigation to Add Location page")
    public void clickNxtBtnAndVerifyNavigationInAddLoc()
    {
        userPage.clickOnNextBtn();
        Validator.assertTrue(monitoringDevicePage.getCurrentURL().contains("/device/add/location"),"User is not navigated to add location page","User is navigated to add location page");
    }
    @QAFTestStep(description = "Validate Access Link Icon is enabled for Monitoring Device")
    public void validateAccessLinkEnabled()
    {
        monitoringDevicePage.validateLinkIsEnabledInMonDev();
    }
    @QAFTestStep(description = "Validate Access Link Icon is disabled for Monitoring Device")
    public void validateAccessLinkDisabled()
    {
        monitoringDevicePage.validateLinkIsDisabledInMonDev();
    }
    @QAFTestStep(description = "Validate the forward navigation symbol in each row")
    public void validateTheForwardNavInEachRow()
    {
        monitoringDevicePage.validateForwardNavInEachRow();
    }
    @QAFTestStep(description = "Verify the monitoring device count with respect to pagination")
    public void validateTheMonDevCountWrtPagination()
    {
        monitoringDevicePage.validateMonDevCountWrtPagination();
    }

    @QAFTestStep(description="Verify pagination double forward arrow button")
    public void verifyThePaginationForwardDoubleBtn(){
        monitoringDevicePage.verifyPaginationDoubleForwardArrowButton();
    }
    @QAFTestStep(description="Verify pagination double backward arrow button")
    public void verifyThePaginationBackwardDoubleBtn(){
        monitoringDevicePage.verifyPaginationDoubleBackwardArrowButton();
    }

    @QAFTestStep(description="Navigate to cord protect iot window")
    public void verifyCordProtectWindow(){
        Validator.assertTrue(monitoringDevicePage.navigateToCordProtect(),"IOT dashboard verification failed", "Iot dashboard verified successfully");
    }
    @QAFTestStep(description="Validate map and list icon in monitoring device list page")
    public void validateTheMapAndListIcon(){
        monitoringDevicePage.validateMapAndListIcon();
    }
    @QAFTestStep(description="Validate map and list icon are not visible")
    public void validateTheMapAndListIconAreNotPresent(){
        monitoringDevicePage.validateMapAndListIconAreNotPresent();
    }
    @QAFTestStep(description="Navigate and validate navigation to list view for monitoring device")
    public void navigateToTheListViewForMonDev(){
        monitoringDevicePage.navigateToListViewForMonDev();
    }
    @QAFTestStep(description="Verify monitoring device is in map view")
    public void verifyTheMonDevInMapView(){
        monitoringDevicePage.verifyMonDevInMapView();
    }
    @QAFTestStep(description="Verify monitoring device is in list view")
    public void verifyTheMonDevInListView(){
        monitoringDevicePage.verifyMonDevInListView();
    }
    @QAFTestStep(description="Validate monitoring device {DeviceName} is present in map view")
    public void verifyTheMonDevIsPresentInMapView(String device){
        monitoringDevicePage.verifyMonDevIsPresentInMapView(device);
    }
    @QAFTestStep(description="Edit the device name to {EditDeviceName} for monitoring device")
    public void editTheDeviceNameForMonDevice(String newDevice){
        monitoringDevicePage.editDeviceNameForMonDevice(newDevice);
    }
    @QAFTestStep(description="Validate Site as searchable field")
    public void validateTheSiteFieldIsPresent(){
        monitoringDevicePage.validateSiteFieldIsPresent();
    }
    @QAFTestStep(description="Verify warning pop up for monitoring device is displayed")
    public void validateTheWarningPopUpForMonDev(){
        monitoringDevicePage.validateWarningPopUpForMonDev();
    }
    @QAFTestStep(description="Verify warning pop up for monitoring device is not displayed")
    public void validateTheWarningPopUpNotPresentForMonDev(){
        monitoringDevicePage.validateWarningPopUpNotPresentForMonDev();
    }
    @QAFTestStep(description="Click on the Close Pop Up")
    public void clickOnTheClosePopUp(){
        monitoringDevicePage.clickOnClosePopUp();
    }
    @QAFTestStep(description="Click on cancel button for add location")
    public void cancelTheBtnClickForAddLoc(){
        monitoringDevicePage.cancelBtnClickForAddLoc();
    }
    @QAFTestStep(description="Click on monitoring device bread crumb")
    public void clickOnTheMonDevBreadCrumb(){
        monitoringDevicePage.clickOnMonDevBreadCrumb();
    }
    @QAFTestStep(description="Click on No button on popup")
    public void clickOnTheNoButtonOnPopup(){
        monitoringDevicePage.clickOnNoBtn();
    }
    @QAFTestStep(description="Click on Yes button on popup")
    public void clickOnTheYesButtonOnPopup(){
        monitoringDevicePage.clickOnYesBtn();
    }
    @QAFTestStep(description="Click on export Pdf and verify pdf contents for Monitoring device with {deviceName} {site} {conveyor}")
    public void clickTheExportAndVerifyContentsForMonDev(String name, String siteName, String conveyorName){
        coverWearPage.clickOnExportPDF();
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("device.pdf"), "PDF report was not found", "PDF report was downloaded successfully");
        monitoringDevicePage.verifyPDFContentsForMonDev(name,siteName,conveyorName);
        MiscUtils.deleteDownloadedFiles("device.pdf");
    }
    @QAFTestStep(description="Click on export Pdf and verify pdf contents for default header Monitoring device with default {deviceName} {deviceType} {serialNumber} {site} {conveyor} {carcass} {territory} {location} {status} {lastService} {beltSaves}")
    public void clickTheExportAndVerifyContentsForDefaultHeaderMonDev(String name,String deviceType,String serialNumber,String siteName,String conveyorName,String carcass,String territory,String location,String status,String lastService,String beltSaves){
        coverWearPage.clickOnExportPDF();
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("device.pdf"), "PDF report was not found", "PDF report was downloaded successfully");
        monitoringDevicePage.verifyPDFContentsForDefaultHeaderMonDev(name,deviceType,serialNumber,siteName,conveyorName,carcass,territory,location,status,lastService,beltSaves);
        MiscUtils.deleteDownloadedFiles("device.pdf");
    }
    @QAFTestStep(description="Click on export csv and verify csv contents for default header Monitoring device with default {deviceName} {deviceType} {serialNumber} {site} {conveyor} {carcass} {territory} {location} {status} {lastService} {beltSaves}")
    public void clickTheCsvAndVerifyContentsForDefaultHeaderMonDev(String name,String deviceType,String serialNumber,String siteName,String conveyorName,String carcass,String territory,String location,String status,String lastService,String beltSaves){
        coverWearPage.clickOnExportCSV();
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("download.csv"), "CSV report was not found", "CSV report was downloaded successfully");
        monitoringDevicePage.verifyCSVContentsForDefaultHeaderMonDev(name,deviceType,serialNumber,siteName,conveyorName,carcass,territory,location,status,lastService,beltSaves);
        MiscUtils.deleteDownloadedFiles("download.csv");
    }
    @QAFTestStep(description="Verify the territory data {territory} is displayed for Monitoring device")
    public void verifyTheTerritoryDataInMonDev(String territory){
        monitoringDevicePage.verifyTerritoryDataInMonDev(territory);
     }
     @QAFTestStep(description="Extract the monitoring device card count")
    public void extractTheMonitoringDeviceCount(){
        monitoringDevicePage.extractMonitoringDeviceCount();
     }
     @QAFTestStep(description="Validate the monitoring device card count after addition")
    public void verifyTheMonitoringDeviceCountAfterAddition(){
        monitoringDevicePage.verifyMonitoringDeviceCountAfterAddition();
     }
     @QAFTestStep(description="Verify table column and header names in the monitoring device")
    public void verifyTheTableColAndHeaderNamesForMonDev(){
        monitoringDevicePage.verifyTableColAndHeaderNamesForMonDev();
     }
     @QAFTestStep(description="Verify the device name {DeviceName} in view mode")
    public void verifyTheDeviceNameInViewMode(String device){
        monitoringDevicePage.verifyDeviceNameInViewMode(device);
     }
     @QAFTestStep(description="Wait for the list to load")
    public void waitForTheListToLoad(){
        monitoringDevicePage.waitForListToLoad();
     }
     @QAFTestStep(description="Add the status for the monitoring device as {Status}")
    public void addTheStatusForMonDev(String status){
        monitoringDevicePage.addStatusForMonDev(status);
     }
     @QAFTestStep(description="Verify navigation to File Manager page upon clicking File Manager Icon")
    public void verifyTheClickAndNavigationToFileManagerPage(){
        monitoringDevicePage.verifyClickAndNavigationToFileManagerPage();
     }
    @QAFTestStep(description = "Add the column filters {Brand} {Corporate} {FirmwareVersion} {Region}")
    public void addTheFilters(String brand, String corporate, String firmwareVersion, String region) {
        conveyorPage.addFilters(brand, corporate, firmwareVersion, region);
    }
    @QAFTestStep(description="Verify the cord protect details page")
    public void verifyCordProtectDetails(){
        Validator.assertTrue(monitoringDevicePage.verifyCordProtect(),"IOT dashboard verification failed", "Iot dashboard verified successfully");
    }
    @QAFTestStep(description="Click on the conveyor details page and verify navigation for floating menu")
    public void clickOnTheConveyorDetailsPageAndVerifyNav(){
        monitoringDevicePage.clickOnConveyorDetailsPageAndVerifyNav();
    }
    @QAFTestStep(description="Click on floating menu icon and verify user can get list of links for Cord Protect")
    public void clickAndVerifyTheFloatingMenuIconForCP(){
        monitoringDevicePage.clickAndVerifyFloatingMenuIconForCP();
    }
}
