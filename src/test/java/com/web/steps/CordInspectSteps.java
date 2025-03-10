package com.web.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class CordInspectSteps {

    LoginPage loginPage = new LoginPage();
    CordInspectPage cordInspectPage = new CordInspectPage();
    CoverWearPage coverWearPage = new CoverWearPage();
    ConveyorPage conveyorPage = new ConveyorPage();
    UsersPage userPage = new UsersPage();
    BeltScanPage beltScanPage = new BeltScanPage();

    String[] BeltScanColNames={"Date Of Scan","Device Type","Site","Conveyor","Territory","CCM"};

    @QAFTestStep(description = "Navigate to Add Belt Scan Page and verify navigation")
    public void verifyNavigationToAddBeltScan() {
        cordInspectPage.goToAddBeltScans();
        Validator.assertTrue(cordInspectPage.getCurrentURL().contains("/secure/belt-scans/add/general-info"), "User is not navigated to Add Belt Scan page!",
                "User is navigated to Add Belt Scan page!");
    }

    @QAFTestStep(description = "Add Belt Scan details with {DateOfScan} {DeviceType} {ReasonForScan} {SiteName} {ConveyorName} {NotifyCCM} {File1} and {File2}")
    public void addBeltScan(String dateOfScan, String deviceType, String reasonForScan, String siteName, String conveyorName, String notifyCcm, String file1, String file2) {
        cordInspectPage.addBeltScanInfo(deviceType, reasonForScan, siteName, conveyorName, notifyCcm);
        coverWearPage.selectGivenDate(dateOfScan);
        cordInspectPage.fileUpload(file1);
        cordInspectPage.fileUpload(file2);
        conveyorPage.clickCreateBtn();

    }

    @QAFTestStep(description = "Add Belt Scan general Info with {DateOfScan} {DeviceType} {ReasonForScan} {SiteName} {ConveyorName} {NotifyCCM} {File1} and {File2}")
    public void addBeltScanGeneralInfo(String dateOfScan, String deviceType, String reasonForScan, String siteName, String conveyorName, String notifyCcm, String file1, String file2) {
        cordInspectPage.addBeltScanInfo(deviceType, reasonForScan, siteName, conveyorName, notifyCcm);
        coverWearPage.selectGivenDate(dateOfScan);
//        cordInspectPage.fileUpload(file1);
//        cordInspectPage.fileUpload(file2);

    }
    @QAFTestStep(description = "Verify error message functionality when belt scan mandatory fields are filled with empty values {SiteName} {ConveyorName}")
    public void verifyTheManErrorMsgWithEmptyVal(String siteName,String conveyorName){
        cordInspectPage.verifyManErrorMsgWithEmptyVal(siteName,conveyorName);
    }
    @QAFTestStep(description = "Verify create button is disabled")
    public void verifyTheCreateBtnDisabled(){
        cordInspectPage.verifyCreateBtnDisabled();
    }
    @QAFTestStep(description = "Verify create button is enabled")
    public void verifyTheCreateBtnEnabled(){
        cordInspectPage.verifyCreateBtnEnabled();
    }

    @QAFTestStep(description = "Verify the Reason to scan dropdown list")
    public void verifyReasonForScanList() {
        cordInspectPage.verifyReasonForScanDDL();
    }

    @QAFTestStep(description = "Add the Mandatory fields in the Belt Scan with {DateOfScan} {DeviceType} {ReasonForScan} {SiteName} {ConveyorName} {NotifyCCM} {File1} and {File2}")
    public void addTheManFieldsInBeltScan(String dateOfScan,String deviceType,String reasonForScan,String siteName,String conveyorName,String notifyCcm,String file1,String file2){
        cordInspectPage.addBeltScanInfo(deviceType,reasonForScan,siteName,conveyorName,notifyCcm);
        coverWearPage.selectGivenDate(dateOfScan);
        cordInspectPage.fileUpload(file1);
        cordInspectPage.fileUpload(file2);
    }

    @QAFTestStep(description = "Verify the mandatory fields in belt scan Add general details screen")
    public void verifyTheManFieldsInAddGeneralScreen() {
        cordInspectPage.verifyManFieldsInAddGeneralScreen();
    }
    @QAFTestStep(description = "Click on Next button and verify Add Scan details tab is displayed")
    public void clickNextButtonAndVerifyAddScanTabPage(){
        userPage.nextClick();
        cordInspectPage.verifyAddScanPage();
    }
    @QAFTestStep(description = "Click on Next button and verify Add Scanning files tab is displayed")
    public void clickNextButtonAndVerifyAddScanningFilesPage(){
        userPage.nextClick();
        cordInspectPage.verifyAddScanningFilesPage();
    }

    @QAFTestStep(description = "Click on previous button and verify user is on Add Scan details page")
    public void clickAndVerifyPreviousBtn() {
        userPage.clickOnPreviousBtn();
        cordInspectPage.verifyAddScanPage();
    }

    @QAFTestStep(description = "Click on previous button and verify user is on General Info details page")
    public void clickPreviousBtnAndVerifyGeneralInfoPage() {
        userPage.clickOnPreviousBtn();
        Validator.assertTrue(cordInspectPage.getCurrentURL().contains("/secure/belt-scans/add/general-info"), "User is not navigated to Add Belt Scan page!",
                "User is navigated to Add Belt Scan page!");
    }

    @QAFTestStep(description = "Verify scanning message report message on Add Scanning files page")
    public void verifyTheAddScanningFilesUploadMsg(){
        cordInspectPage.verifyAddScanningFilesUploadMsg();
    }
    @QAFTestStep(description = "Verify user is able to add {Note} on note text box")
    public void verifyTheUserCanAddNote(String note){
        cordInspectPage.verifyUserCanAddNote(note);
    }
    @QAFTestStep(description = "Click on Belt Scan card and verify it navigates to BeltScan listing page")
    public void navigateToBeltScanListPageWithCard(){
        cordInspectPage.clickCarouselNextBtn();
        cordInspectPage.goToBeltScanListPageWithCard();
    }
    @QAFTestStep(description = "Click on add button and verify navigation to Add BeltScan page")
    public void navigateToAddBeltScanPage(){
        cordInspectPage.addButtonClick();
        Validator.assertTrue(cordInspectPage.getCurrentURL().contains("/belt-scans/add/general-info"),"User is not navigated to Add Belt Scan page!","User is navigated to Add Belt Scan page!");
    }

    @QAFTestStep(description = "Verify user is in Belt Scan list page")
    public void verifyInTheBeltScanListPage(){
        cordInspectPage.verifyInBeltScanListPage();
    }
    @QAFTestStep(description = "Click on cancel button")
    public void clickOnTheCancelBtn(){
        cordInspectPage.cancelBtnClick();
    }
    @QAFTestStep(description = "Verify search and delete {BeltScan} functionality")
    public void verifyTheSearchAndDeleteFunctionality(String item){
        cordInspectPage.deleteItem(item);
    }
    @QAFTestStep(description = "Validate the Belt Scan count before deletion")
    public void validateTheBeltScanCountBeforeDel(){
        cordInspectPage.validateBeltScanCountBeforeDel();
    }
    @QAFTestStep(description = "Validate the Belt Scan count after deletion")
    public void validateTheBeltScanCountAfterDel(){
        cordInspectPage.validateBeltScanCountAfterDel();
    }
    @QAFTestStep(description = "Verify the pagination and tile count for belt scan")
    public void validateTheCordInspCountWrtPaginationAndTile(){
        cordInspectPage.validateCordInspCountWrtPaginationAndTile();
    }

    @QAFTestStep(description = "Click on actions dropdown button and verify delete option is visible")
    public void clickActionBtnAndVerifyDeleteOption() {
        conveyorPage.actionBtnClick();
        cordInspectPage.verifyDeleteIsVisible();
    }
    @QAFTestStep(description = "Click on actions dropdown button")
    public void clickTheActionBtn() {
        conveyorPage.actionBtnClick();
    }
    @QAFTestStep(description = "Verify select all checkbox functionality")
    public void verifyTheSelectAllCheckbox() {
        cordInspectPage.verifySelectAllCheckbox();
    }
    @QAFTestStep(description = "Verify {item} is not present in the list")
    public void verifyTheItemNotPresent(String item) {
        cordInspectPage.verifyItemNotPresent(item);
    }

    @QAFTestStep(description = "Navigate to Belt Scan List screen and wait")
    public void verifyNavigationToBeltScreenListScreen() {
        beltScanPage.gotoBeltScanScreenWait();
    }
    @QAFTestStep(description = "Click on column header and verify sorting functionality")
    public void verifytheSortingFunctionality()
    {
        cordInspectPage.clickOnColumnsHeader(true,BeltScanColNames,2);
    }
    @QAFTestStep(description = "Click on clear filter button and verify filter is removed")
    public void verifyClearFilterFunctionality()
    {
        cordInspectPage.verifyClearFilter();
    }
    @QAFTestStep(description = "Click on each column header and verify filter functionality")
    public void verifyColumnFilterFunctionality()
    {
        conveyorPage.columnNameFilterBtnClick(BeltScanColNames);
    }

    @QAFTestStep(description = "Click on actions dropdown button and edit the {item}")
    public void clickActionBtnAndTheEdit(String item) {
        cordInspectPage.verifyItemPresent(item);
        conveyorPage.actionBtnClick();
        conveyorPage.selectEditOption();
        cordInspectPage.waitForEditPage();
    }
    @QAFTestStep(description = "Verify belt scan record is on edit mode")
    public void beltScanIsInTheEditMode() {
        cordInspectPage.beltScanIsInEditMode();
    }

    @QAFTestStep(description="Verify the deleted Belt Scan {Device} in list screen")
    public void verifyMonitoringDevice(String device){
        cordInspectPage.verifyDeletedMonitoringDevice(device);
    }

    @QAFTestStep(description = "Submit the belt scan form")
    public void submitTheBeltScanForm() {
        conveyorPage.clickCreateBtn();
    }

//    @QAFTestStep(description="Verify the belt scan for {ConveyorName} is present in list screen")
//    public void verifyBeltScanCreation(String conveyor){
//        Validator.assertTrue(cordInspectPage.searchBeltScan(conveyor),"Belt Scan was not found","Belt Scan was found and verified successfully");
//    }

    @QAFTestStep(description = "Edit all Belt Scan General details with {DateOfScan} {DeviceType} {ReasonForScan} {SiteName} {ConveyorName} {NotifyCCM} {File1} for {FieldName1} and {File2} for {FieldName2}")
    public void editAllTheBeltScanGeneralDetails(String dateOfScan,String deviceType,String reasonForScan,String siteName,String conveyorName,String notifyCcm,String file1,String fieldName1,String file2,String fieldName2) {
        cordInspectPage.addBeltScanInfo(deviceType, reasonForScan, siteName, conveyorName, notifyCcm);
        System.out.println(dateOfScan);
        coverWearPage.selectGivenDate(dateOfScan);
        System.out.println("date changed");
        cordInspectPage.fileReUpload(fieldName1, file1);
        cordInspectPage.fileReUpload(fieldName2, file2);
        cordInspectPage.clickOnTextSaveBtn();
    }
    @QAFTestStep(description = "Edit all Belt Scan Add Scan details with {BeltManufacturer} {TopCoverCompound} {NumberOfCords} {InstallationDate} {CpuLeft} {SensorWidth} {PhoneNumber}")
    public void editAllTheBeltScanDetails(String beltManufacturer,String topCoverCompound,String numberOfCords,String installationDate,String cpuLeft,String sensorWidth,String phoneNumber){
        userPage.clickOnNextBtn();
        cordInspectPage.editBeltScanDetails(beltManufacturer,topCoverCompound,numberOfCords,cpuLeft,sensorWidth,phoneNumber);
        coverWearPage.selectGivenDate(installationDate);
    }

    @QAFTestStep(description = "Click on the next button")
    public void clickOnTheNextButton(){
        userPage.clickOnNextBtn();
    }
    @QAFTestStep(description = "Click on the save button")
    public void clickOnTheSaveButton(){
        cordInspectPage.clickOnTextSaveBtn();
    }
    @QAFTestStep(description = "Reupload the file {File} for {Field}")
    public void reUploadTheFile(String file,String fieldName){
        cordInspectPage.fileReUpload(fieldName,file);
    }
    @QAFTestStep(description = "Edit all Belt Scan Add Scanning files with the file {File3} for {Field3} and file {File4} for {Field4} and {Note}")
    public void editAllTheBeltScanAddScanningFiles(String file,String fieldName,String file2,String fieldName2,String note){
        cordInspectPage.fileReUpload(fieldName,file);
        cordInspectPage.fileReUpload(fieldName2,file2);
        cordInspectPage.clickOnTextSaveBtn();
        cordInspectPage.editTheNote(note);

    }
    @QAFTestStep(description = "Add Belt Scan Scanning files with the file {File3} and file {File4} and {Note}")
    public void addTheBeltScamScanningFiles(String file,String file2,String note){
        cordInspectPage.fileUpload(file);
        cordInspectPage.fileUpload(file2);
        cordInspectPage.editTheNote(note);

    }
    @QAFTestStep(description = "Click save and Verify update message")
    public void clickSaveBeltScanVerifyUpdate(){
        cordInspectPage.clickOnTextSaveBtn();
        cordInspectPage.verifyUpdateSuccessfulMsg();
    }
    @QAFTestStep(description = "Verify belt scan tab highlight functionality")
    public void verifyTheBeltScanTabHighlightFun(){
        cordInspectPage.verifyBeltScanTabHighlightFun();

    }
    @QAFTestStep(description = "Click on Add scanning files tab and verify highlight functionality")
    public void verifyTheAddScanningTabHighlightFun(){
        cordInspectPage.verifyAddScanningTabHighlightFun();
    }
    @QAFTestStep(description = "Search the {item} and click on view icon")
    public void searchAndClickTheViewBtn(String item) {
        cordInspectPage.searchAndClickViewBtn(item);
    }

    @QAFTestStep(description = "Upload multiple files {File1} {File2} and verify user is unable to upload simultaneously")
    public void unableTheFileUploadMultipleFiles(String file1,String file2){
        List<String> filesToUpload = Arrays.asList(file1, file2);
		cordInspectPage.unableFileUploadMultipleFiles(filesToUpload);
    }
    @QAFTestStep(description = "ReUpload multiple files {File1} {File2} for field {FieldName} and verify user is unable to upload simultaneously")
    public void unableTheFileReUploadMultipleFiles(String file1,String file2,String field){
        List<String> filesToUpload = Arrays.asList(file1, file2);
		cordInspectPage.unableFileReUploadMultipleFiles(field,filesToUpload);
    }
    @QAFTestStep(description = "Upload the file {File1}")
    public void uploadTheFile(String file1){
        cordInspectPage.fileUpload(file1);
    }
    @QAFTestStep(description = "Perform upload analysis through action button for {siteName}")
    public void uploadAnalysisWithTheActionBtn(String siteName){
        coverWearPage.searchForItem(siteName);
        cordInspectPage.clickUploadAnalysisFromActionBtn();
    }
    @QAFTestStep(description = "Click on upload button")
    public void clickOnTheUploadBtn(){
        cordInspectPage.uploadBtnClick();
    }
   @QAFTestStep(description = "Search for the record {siteName} and verify item is present")
    public void searchTheRecord(String record){
       coverWearPage.searchForItem(record);
       cordInspectPage.verifySearchedItemIsPresent(record);
    }
    @QAFTestStep(description = "Verify the scanning report is in disable mode")
    public void verifyTheScanningReportIsDisabled(){
        cordInspectPage.verifyScanningReportIsDisabled();
    }
    @QAFTestStep(description = "Navigate to cord inspect list screen and wait to load data")
    public void verifyTheCordInspectListNavAndWait() {
        cordInspectPage.goToCordInspectListScreenAndWait();
    }

    @QAFTestStep(description = "Verify the belt Scan count with respect to pagination")
    public void validateTheBeltScanCountWrtPagination()
    {
        cordInspectPage.validateCordInspectCountWrtPagination();
    }
    @QAFTestStep(description = "Click on create button")
    public void clickOnTheCreateBtn(){
        conveyorPage.clickCreateBtn();
    }
    @QAFTestStep(description = "Verify all the data in add scan details screen is empty")
    public void verifyTheDataAreEmptyInAddScanDetails(){
        cordInspectPage.verifyDataAreEmptyInAddScanDetails();
    }
    @QAFTestStep(description = "Verify the data for belt scan {SiteName} {ConveyorName} {TopCoverCompound} {EditNote}")
    public void verifyTheDataForBeltScan(String siteName,String conveyorName,String topCoverCompound,String note){
        cordInspectPage.verifyDataForBeltScan(siteName,conveyorName,topCoverCompound,note);
    }
    @QAFTestStep(description = "Click on load back up data and verify the scanning toast message")
    public void verifyTheLoadBackUpDataFun(){
        cordInspectPage.verifyLoadBackUpDataFun();
    }
    @QAFTestStep(description = "Click on load technical data and verify the data values {TopCoverCompound} {BeltWidth}")
    public void verifyTheLoadTechnicalDataFun(String topCoverCompound,String beltWidth){
        cordInspectPage.verifyLoadTechnicalDataFun(topCoverCompound,beltWidth);
    }

    @QAFTestStep(description = "Add general details {DateOfScan} {DeviceType} {ReasonForScan} {SiteName} {ConveyorName} {NotifyCCM}")
    public void addTheBeltScanGeneralDetails(String dateOfScan,String deviceType,String reasonForScan,String siteName,String conveyorName,String notifyCcm){
        cordInspectPage.addBeltScanInfo(deviceType,reasonForScan,siteName,conveyorName,notifyCcm);
        coverWearPage.selectGivenDate(dateOfScan);
    }

    @QAFTestStep(description = "Verify while uploading {File1} and {File2} next button is disabled")
    public void beltScanNextBtnAndAddScanDisabled(String file1,String file2){
        cordInspectPage.sendFile(file1);
        cordInspectPage.validateNextBtnAndScanDetailsDisabled();
        cordInspectPage.sendFile(file2);
        cordInspectPage.validateNextBtnAndScanDetailsDisabled();
    }
    @QAFTestStep(description = "Verify Cord Inspect Icon is enabled")
    public void verifyTheCordInspectIconIsEnabled(){
        cordInspectPage.verifyCordInspectIconIsEnabled();
    }
    @QAFTestStep(description = "Verify navigation to the Cord Inspect page")
    public void verifyNavigateTheToCordInspectPage(){
        cordInspectPage.verifyNavigateToCordInspect();
    }
    @QAFTestStep(description = "Verify the Belt Scan List Download Functionality for {BeltInfo} {RawCapture} {ScanningReport}")
    public void verifyTheBeltScanListDownloadFunctionality(String beltInfo,String rawCapture,String scanningReport){
        cordInspectPage.verifyBeltScanListDownloadFunctionality(beltInfo,rawCapture,scanningReport);
    }
    @QAFTestStep(description = "Click on download button for {RawCaptureFile} and verify the functionality with {File1} for belt scan")
    public void downloadBtnAndVerifyFileForBeltScanViewMode(String download,String file){
        cordInspectPage.clickDownloadAndVerifyFunForbeltScan(download);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles(file), "Pdf report was not found", "Pdf report was downloaded successfully");
        MiscUtils.deleteDownloadedFiles(file);
    }

    @QAFTestStep(description="Click on export csv and verify csv contents for default header belt scan with default {dateOfScan} {deviceType} {site} {conveyor} {territory} {ccm} {beltInfoScan} {rawCaptureFile} {scanningReport}")
    public void clickTheCsvAndVerifyContentsForDefaultHeaderBeltScan(String dateOfScan,String deviceType,String siteName,String conveyorName,String territory,String ccm,String beltInfoScan,String rawCaptureFile,String scanningReport){
        coverWearPage.clickOnExportCSV();
        System.out.println("download - " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "T\\d+Z\\.csv");
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("download - " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "T\\d+Z\\.csv"), "CSV report was not found", "CSV report was downloaded successfully");
        String File = MiscUtils.getDownloadedFileName("download - " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "T\\d+Z\\.csv");
        System.out.println(File+"file");
        cordInspectPage.verifyCSVContentsForDefaultHeaderBeltScan(File,dateOfScan,deviceType,siteName,conveyorName,territory,ccm,beltInfoScan,rawCaptureFile,scanningReport);
        MiscUtils.deleteDownloadedFiles("download - " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "T\\d+Z\\.csv");
    }

    @QAFTestStep(description="Wait for the toast message to display")
    public void waitForTheToastMessage(){
        cordInspectPage.waitForToastMessage();
    }

    @QAFTestStep(description = "Verify belt scan record is on view mode")
    public void beltScanIsInTheViewMode() {
        cordInspectPage.beltScanIsInViewMode();
    }

    @QAFTestStep(description="Add column filter for header with {FilterName} for belt scan")
    public void addTheColumnAFilter(String filterName){
        cordInspectPage.addColumnAFilter(filterName);
    }
    @QAFTestStep(description="Remove column filter for header with {FilterName}")
    public void removeTheColumnFilter(String filterName){
        cordInspectPage.removeColumnFilter(filterName);
    }

    @QAFTestStep(description="Click on floating menu icon and verify user can get list of links for Cord Inspect")
    public void clickFloatingMenuAndVerifyLinksForCI(){
        cordInspectPage.clickAndVerifyFloatingMenuIconForCI();
    }
    @QAFTestStep(description="Click on the floating menu downward arrow")
    public void clickOnTheMenuDownwardArrow(){
       cordInspectPage.clickOnMenuDownwardArrow();
    }
    @QAFTestStep(description="Click on the main page and verify navigation for floating menu")
    public void clickOnTheMainPageAndVerifyNav(){
       cordInspectPage.clickOnMainPageAndVerifyNav();
    }
    @QAFTestStep(description="Click on menu item {MainPage} and verify navigation for floating menu")
    public void clickOnTheFloatingMenuAndVerifyNav(String menu){
       cordInspectPage.clickOnFloatingMenuAndVerifyNav(menu);
    }
    @QAFTestStep(description="Click on menu item {MainPage} and verify navigation for floating menu with breadcrumb {breadcrumb}")
    public void clickOnTheFloatingMenuWithBCAndVerifyNav(String menu,String breadCrumb){
       cordInspectPage.clickOnFloatingMenuWithBCAndVerifyNav(menu,breadCrumb);
    }



}
