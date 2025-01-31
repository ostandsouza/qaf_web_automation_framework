package com.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.*;

import java.util.Arrays;
import java.util.List;

public class CordInspectSteps {

    LoginPage loginPage = new LoginPage();
    CordInspectPage cordInspectPage = new CordInspectPage();
    CoverWearPage coverWearPage = new CoverWearPage();
    ConveyorPage conveyorPage = new ConveyorPage();
    UsersPage userPage = new UsersPage();

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

    @QAFTestStep(description = "Click on Belt Scan card and verify it navigates to BeltScan listing page")
    public void navigateTheToBeltScanListPage() {
        cordInspectPage.clickCarouselNextBtn();
        cordInspectPage.goToBeltScanListPage();
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


    @QAFTestStep(description = "Click on add button and verify navigation to Add BeltScan page")
    public void navigateToAddBeltScanPage() {
        cordInspectPage.addButtonClick();
        Validator.assertTrue(cordInspectPage.getCurrentURL().contains("/secure/belt-scans/add/general-info"), "User is not navigated to Add Belt Scan page!",
                "User is navigated to Add Belt Scan page!");

    }

    @QAFTestStep(description = "Click on Next button and verify Add Scan details tab is displayed")
    public void clickNextButtonAndVerifyAddScanTabPage() {
        userPage.nextClick();
        cordInspectPage.verifyAddScanPage();
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
    public void navigateToBeltScanListPage(){
        cordInspectPage.clickCarouselNextBtn();
        cordInspectPage.goToBeltScanListPage();
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
        cordInspectPage.gotoBeltScanScreenWait();
    }
    @QAFTestStep(description = "Click on column header and verify sorting functionality")
    public void verifytheSortingFunctionality()
    {
        cordInspectPage.clickOnColumnsHeader(true,BeltScanColNames);
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
    @QAFTestStep(description = "Search for the device {device}")
    public void searchAndSelectScan(String conveyor) {
        cordInspectPage.searchBeltScan(conveyor);
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

    @QAFTestStep(description = "Edit all Belt Scan General details with {DateOfScan} {DeviceType} {ReasonForScan} {SiteName} {ConveyorName} {NotifyCCM} {File1} for {FieldName1} and {File2} for {FieldName2}")
    public void editAllTheBeltScanGeneralDetails(String dateOfScan,String deviceType,String reasonForScan,String siteName,String conveyorName,String notifyCcm,String file1,String fieldName1,String file2,String fieldName2){
        cordInspectPage.addBeltScanInfo(deviceType,reasonForScan,siteName,conveyorName,notifyCcm);
        coverWearPage.selectGivenDate(dateOfScan);
        cordInspectPage.fileReUpload(fieldName1,file1);
        cordInspectPage.fileReUpload(fieldName2,file2);
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
    @QAFTestStep(description = "Reupload the file {File} for {Field}")
    public void reUploadTheFile(String file,String fieldName){
        cordInspectPage.fileReUpload(fieldName,file);
    }
    @QAFTestStep(description = "Edit all Belt Scan Add Scanning files with the file {File3} for {Field3} and file {File4} for {Field4} and {Note}")
    public void editAllTheBeltScanAddScanningFiles(String file,String fieldName,String file2,String fieldName2,String note){
        cordInspectPage.fileReUpload(fieldName,file);
        cordInspectPage.fileReUpload(fieldName2,file2);
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
   @QAFTestStep(description = "Search for the record {siteName}")
    public void searchTheRecord(String record){
       coverWearPage.searchForItem(record);
    }
    @QAFTestStep(description = "Verify the scanning report is in disable mode")
    public void verifyTheScanningReportIsDisabled(){
        cordInspectPage.verifyScanningReportIsDisabled();
    }

}
