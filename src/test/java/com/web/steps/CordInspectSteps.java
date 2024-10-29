package com.web.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.*;

public class CordInspectSteps {
    CordInspectPage cordInspectPage = new CordInspectPage();
    ConveyorPage conveyorPage = new ConveyorPage();
    CoverWearPage coverWearPage = new CoverWearPage();
    UsersPage userPage= new UsersPage();
    @QAFTestStep(description = "Navigate to Add Belt Scan Page and verify navigation")
    public void verifyNavigationToAddBeltScan() {
        cordInspectPage.goToAddBeltScans();
        Validator.assertTrue(cordInspectPage.getCurrentURL().contains("/secure/belt-scans/add/general-info"),"User is not navigated to Add Belt Scan page!","User is navigated to Add Belt Scan page!");
    }
    @QAFTestStep(description = "Add Belt Scan details with {DateOfScan} {DeviceType} {ReasonForScan} {SiteName} {ConveyorName} {NotifyCCM} {File1} and {File2}")
    public void addBeltScan(String dateOfScan,String deviceType,String reasonForScan,String siteName,String conveyorName,String notifyCcm,String file1,String file2){
        cordInspectPage.addBeltScanInfo(deviceType,reasonForScan,siteName,conveyorName,notifyCcm);
        coverWearPage.selectGivenDate(dateOfScan);
        cordInspectPage.fileUpload(file1);
        cordInspectPage.fileUpload(file2);
        conveyorPage.clickCreateBtn();
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

    @QAFTestStep(description = "Add the Mandatory fields in the Belt Scan with {DateOfScan} {DeviceType} {ReasonForScan} {SiteName} {ConveyorName} {NotifyCCM} {File1} and {File2}")
    public void addTheManFieldsInBeltScan(String dateOfScan,String deviceType,String reasonForScan,String siteName,String conveyorName,String notifyCcm,String file1,String file2){
        cordInspectPage.addBeltScanInfo(deviceType,reasonForScan,siteName,conveyorName,notifyCcm);
        coverWearPage.selectGivenDate(dateOfScan);
        cordInspectPage.fileUpload(file1);
        cordInspectPage.fileUpload(file2);
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
    @QAFTestStep(description = "Click on add button and verify navigation to Add BeltScan page")
    public void navigateToAddBeltScanPage(){
        cordInspectPage.addButtonClick();
        Validator.assertTrue(cordInspectPage.getCurrentURL().contains("/secure/belt-scans/add/general-info"),"User is not navigated to Add Belt Scan page!","User is navigated to Add Belt Scan page!");
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



}
