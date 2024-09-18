package com.web.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.ConveyorPage;
import com.web.pages.CoverWearPage;
import com.web.pages.MonitoringDevicePage;
import com.web.pages.UsersPage;

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
    public void verifyTheBeltMonitoringDetails() {
        monitoringDevicePage.verifyBeltMonitoringDetails();
    }

    @QAFTestStep(description = "Navigate to Belt Monitoring List screen")
    public void verifyNavigationToMonitoringDeviceListScreen() {
        monitoringDevicePage.goToMonitoringDeviceListScreenAndWait();
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
    public void verifyFilterOrSorting(String cloumnName,String filter){
        SyncUtil.waitFor(40000);
        int noOfCoverWears = Integer.parseInt(MiscUtils.regexExtractor(monitoringDevicePage.paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        System.out.println("calling before verifyColumnFilterClick "+noOfCoverWears);
        monitoringDevicePage.verifyColumnFilterClick(noOfCoverWears,cloumnName,filter);
    }

    @QAFTestStep(description="Click on clear filter and verify filter {cloumnName} is removed")
    public void clearFilterAndVerify(String cloumnName){
        monitoringDevicePage.clearFilterClick();
        monitoringDevicePage.verifyFilterIsRemoved(cloumnName);
    }

    @QAFTestStep(description="Apply sorting or filter on column name {cloumnName} {filterName} {filter}")
    public void applyFilterOrSorting(String cloumnName,String filterName,String filter){
        System.out.println(cloumnName+filterName+filter);
        monitoringDevicePage.applyColumnFilterClick(cloumnName,filterName,filter);
    }
    @QAFTestStep(description = "Zoom in and out to reach conveyor location")
    public void clickOnZoomInAndOut() {
        monitoringDevicePage.clickOnZoomOut();
        monitoringDevicePage.clickOnZoomIn();
    }

    @QAFTestStep(description = "Add the non-mandatory fields for device with {Brand} {SerialNumber} {RemoteConnection} {CommisioningDate} and {BeltConveyorSaves} and {FirmWareVersion} and {SystemLink}")
    public void addNonMandatoryDeviceDetails(String brand,String serialNo,String remoteConnection,String comminsionDate,String beltConveyorSave,String firmwareVersion,String systemLink)
    {monitoringDevicePage.addDeviceDetailsWithNonMandatoryFields(brand,serialNo,remoteConnection,comminsionDate,beltConveyorSave,firmwareVersion,systemLink);}

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

    @QAFTestStep(description = "Verify the tabel header panel")
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
        Validator.assertTrue(monitoringDevicePage.getCurrentURL().contains("/secure/dashboard/devices"),"User is navigated to monitoring device list page",
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
        Validator.assertTrue(monitoringDevicePage.getCurrentURL().contains("/secure/device/add/location"),"User is not navigated to add location page","User is navigated to add location page");
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

}
