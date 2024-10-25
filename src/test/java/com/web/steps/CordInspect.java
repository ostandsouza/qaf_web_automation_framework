package com.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.*;

public class CordInspect {

    LoginPage loginPage = new LoginPage();
    com.web.pages.CordInspect beltScanPage = new com.web.pages.CordInspect();
    CoverWearPage coverWearPage = new CoverWearPage();
    ConveyorPage conveyorPage = new ConveyorPage();
    UsersPage userPage = new UsersPage();


    @QAFTestStep(description = "Navigate to Add Belt Scan Page and verify navigation")
    public void verifyNavigationToAddBeltScan() {
        beltScanPage.goToAddBeltScans();
        Validator.assertTrue(beltScanPage.getCurrentURL().contains("/secure/belt-scans/add/general-info"), "User is not navigated to Add Belt Scan page!",
                "User is navigated to Add Belt Scan page!");
    }

    @QAFTestStep(description = "Add Belt Scan details with {DateOfScan} {DeviceType} {ReasonForScan} {SiteName} {ConveyorName} {NotifyCCM} {File1} and {File2}")
    public void addBeltScan(String dateOfScan, String deviceType, String reasonForScan, String siteName, String conveyorName, String notifyCcm, String file1, String file2) {
        beltScanPage.addBeltScanInfo(deviceType, reasonForScan, siteName, conveyorName, notifyCcm);
        coverWearPage.selectGivenDate(dateOfScan);
        beltScanPage.fileUpload(file1);
        beltScanPage.fileUpload(file2);
        conveyorPage.clickCreateBtn();

    }

    @QAFTestStep(description = "Add Belt Scan general Info with {DateOfScan} {DeviceType} {ReasonForScan} {SiteName} {ConveyorName} {NotifyCCM} {File1} and {File2}")
    public void addBeltScanGeneralInfo(String dateOfScan, String deviceType, String reasonForScan, String siteName, String conveyorName, String notifyCcm, String file1, String file2) {
        beltScanPage.addBeltScanInfo(deviceType, reasonForScan, siteName, conveyorName, notifyCcm);
        coverWearPage.selectGivenDate(dateOfScan);
//        beltScanPage.fileUpload(file1);
//        beltScanPage.fileUpload(file2);

    }

    @QAFTestStep(description = "Click on Belt Scan card and verify it navigates to BeltScan listing page")
    public void navigateToBeltScanListPage() {
        beltScanPage.clickCarouselNextBtn();
        beltScanPage.goToBeltScanListPage();
    }

    @QAFTestStep(description = "Click on add button and verify navigation to Add BeltScan page")
    public void navigateToAddBeltScanPage() {
        beltScanPage.addButtonClick();
        Validator.assertTrue(beltScanPage.getCurrentURL().contains("/secure/belt-scans/add/general-info"), "User is not navigated to Add Belt Scan page!",
                "User is navigated to Add Belt Scan page!");

    }

    @QAFTestStep(description = "Click on Next button and verify Add Scan details tab is displayed")
    public void clickNextButtonAndVerifyAddScanTabPage() {
        userPage.nextClick();
        beltScanPage.verifyAddScanPage();
    }

    @QAFTestStep(description = "Verify create button is disabled")
    public void verifyTheCreateBtnDisabled() {
        Validator.assertTrue(beltScanPage.verifyCreateBtnDisabled(), "Create button is enabled", "Create button is disabled because the rawCapture and Backup file is not uploaded");

    }

    @QAFTestStep(description = "Verify the Reason to scan dropdown list")
    public void verifyReasonForScanList() {
        beltScanPage.verifyReasonForScanDDL();
    }

    @QAFTestStep(description = "Add the Mandatory fields in the Belt Scan with {DateOfScan} {DeviceType} {ReasonForScan} {SiteName} {ConveyorName} {NotifyCCM} {File1} and {File2}")
    public void addTheManFieldsInBeltScan(String dateOfScan, String deviceType, String reasonForScan, String siteName, String conveyorName, String notifyCcm, String file1, String file2) {
        beltScanPage.addBeltScanInfo(deviceType, reasonForScan, siteName, conveyorName, notifyCcm);
        coverWearPage.selectGivenDate(dateOfScan);
        beltScanPage.fileUpload(file1);
        beltScanPage.fileUpload(file2);
    }

    @QAFTestStep(description = "Verify the mandatory fields in belt scan Add general details screen")
    public void verifyTheManFieldsInAddGeneralScreen() {
        beltScanPage.verifyManFieldsInAddGeneralScreen();
    }

    @QAFTestStep(description = "Click on Next button and verify Add Scanning files tab is displayed")
    public void clickNextButtonAndVerifyAddScanningFilesPage() {
        userPage.nextClick();
        beltScanPage.verifyAddScanningFilesPage();
    }

    @QAFTestStep(description = "Click on previous button and verify user is on Add Scan details page")
    public void clickAndVerifyPreviousBtn() {
        userPage.clickOnPreviousBtn();
        beltScanPage.verifyAddScanPage();
    }

    @QAFTestStep(description = "Click on previous button and verify user is on General Info details page")
    public void clickPreviousBtnAndVerifyGeneralInfoPage() {
        userPage.clickOnPreviousBtn();
        Validator.assertTrue(beltScanPage.getCurrentURL().contains("/secure/belt-scans/add/general-info"), "User is not navigated to Add Belt Scan page!",
                "User is navigated to Add Belt Scan page!");
    }
}