package com.mobile.flutter.app.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.mobile.flutter.app.pages.ConveyorInspectPage;
import com.mobile.flutter.app.pages.ConveyorPage;
import com.mobile.flutter.app.pages.CorporatePage;
import com.mobile.flutter.app.pages.CoverWearPage;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ConveyorInspectSteps {

    @QAFTestStep(description = "Verify navigation to conveyor inspect from conveyor details {ConveyorName}")
    public void verifyConveyorInspectNavigation(String conveyorName) {
        Validator.assertTrue(ConveyorInspectPage.getInstance().goToConveyorInspectFromConveyorDetails(),"Conveyor Inspect navigation failed","Conveyor Inspect navigation verified successfully");
    }

    @QAFTestStep(description="Navigate to conveyor inspect page")
    public void navigateToConveyorInspect() {
        Validator.assertTrue(ConveyorInspectPage.getInstance().navigateToConveyorInspect(),"Conveyor Inspect list page navigation failed","Conveyor Inspect list page navigation verified successfully");
    }


    @QAFTestStep(description="Navigate to conveyor inspect list and go to site level details {SiteName}")
    public void verifyConveyorInspectItem(String siteName) {
        navigateToConveyorInspect();
        DashboardNativePage.getInstance().goToSearch();
        CorporatePage.getInstance().enterSearchQuery(siteName);
        Validator.assertTrue(ConveyorInspectPage.getInstance().getFirstSearchResultSite().equalsIgnoreCase(siteName),"Search Conveyor Inspect not found","Conveyor Inspect search verified successfully");
        Validator.assertTrue(ConveyorInspectPage.getInstance().navigateToConveyorInspectDetails(),"Conveyor Inspect Site level navigation failed","Conveyor Inspect Site level navigation verified successfully");
    }

    @QAFTestStep(description="Navigate to inspection tab from site level")
    public void verifyInspectionSiteLevelNavigation() {
        Validator.assertTrue(ConveyorInspectPage.getInstance().goToInspectionConveyorInspect(),"Conveyor Inspect Site level inspection navigation failed","Conveyor Inspect Site level inspection navigation verified successfully");
    }

    @QAFTestStep(description="Navigate from inspection list to conveyor level inspect {ConveyorName}")
    public void verifyConveyorLevelNavigation(String conveyorName) {
        Validator.assertTrue(ConveyorInspectPage.getInstance().getFirstSearchResultConveyor().equalsIgnoreCase(conveyorName),"Conveyor inspect inspection not found","Conveyor inspect inspection verified successfully");
        Validator.assertTrue(ConveyorInspectPage.getInstance().goToConveyorLevelFromSite(),"Conveyor Inspect conveyor level navigation failed","Conveyor Inspect conveyor level navigation verified successfully");
    }

    @QAFTestStep(description="Verify user is on company site dashboard")
    public void verifyCompanySiteDashboard() {
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyCompanySiteDashboard(),"Conveyor Inspect Conveyor level dashboard navigation failed","Conveyor Inspect Conveyor level dashboard verified successfully");
    }

    @QAFTestStep(description="Verify last update date from company dashboard {Conveyor}")
    public void verifyLastUpdatedDate(String conveyor) {
        JSONObject response = ConveyorInspectPage.getInstance().apiBase.getConveyorAPI(conveyor);
        long epoc = (long)((HashMap<String, Object>) response.get("droneInspectData")).get("droneDataUploadDate");
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyLastUpdateStatus(MiscUtils.getDateFromEpoc(epoc)),"Conveyor Inspect last update date verification failed","Conveyor Inspect last update date verified successfully");
    }

    @QAFTestStep(description="Verify graph from company dashboard {Conveyor}")
    public void verifyDashboardGraph(String conveyor) {
        JSONObject response = ConveyorInspectPage.getInstance().apiBase.getConveyorAPI(conveyor);
        int crtical = ((ArrayList<HashMap<String, Integer>>)((HashMap<String, Object>) response.get("droneInspectData")).get("errorDetails")).get(0).get("percentage");
        int poor = ((ArrayList<HashMap<String, Integer>>)((HashMap<String, Object>) response.get("droneInspectData")).get("errorDetails")).get(1).get("percentage");
        int fault = ((ArrayList<HashMap<String, Integer>>)((HashMap<String, Object>) response.get("droneInspectData")).get("errorDetails")).get(2).get("percentage");
        int good = ((ArrayList<HashMap<String, Integer>>)((HashMap<String, Object>) response.get("droneInspectData")).get("errorDetails")).get(3).get("percentage");

        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyGraphFromDashboard(crtical, poor, fault, good),"Conveyor Inspect graph verification failed","Conveyor Inspect graph verified successfully");
    }

    @QAFTestStep(description="Verify temperature range from company dashboard {Conveyor}")
    public void verifyTemperatureRange(String conveyor) {
        JSONObject response = ConveyorInspectPage.getInstance().apiBase.getConveyorAPI(conveyor);
        int crtical = ((ArrayList<HashMap<String, Integer>>)((HashMap<String, Object>) response.get("customer")).get("temperatureRange")).get(0).get("minDifference");
        int poor = ((ArrayList<HashMap<String, Integer>>) ((HashMap<String, Object>) response.get("customer")).get("temperatureRange")).get(1).get("minDifference");
        int fault = ((ArrayList<HashMap<String, Integer>>)((HashMap<String, Object>) response.get("customer")).get("temperatureRange")).get(2).get("minDifference");
        int good = ((ArrayList<HashMap<String, Integer>>) ((HashMap<String, Object>) response.get("customer")).get("temperatureRange")).get(3).get("maxDifference");

        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyTemperatureFromDashboard(crtical, poor, fault, good),"Conveyor Inspect temperature verification failed","Conveyor Inspect temperature verified successfully");
    }

    @QAFTestStep(description="Verify trend analysis on second screen")
    public void verifyTrendAnalysis() {
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyTrendAnalysis(),"Conveyor Inspect trend analysis verification failed","Conveyor Inspect trend analysis verified successfully");
    }

    @QAFTestStep(description="Verify maintenance action on second screen")
    public void verifyMaintenanceAction() {
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyMaintenanceAction(),"Conveyor Inspect maintenance action verification failed","Conveyor Inspect maintenance action verified successfully");
    }

    @QAFTestStep(description="Verify maintenance action expand functionality")
    public void verifyMaintenanceActionExpand() {
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyMaintenanceAction(),"Conveyor Inspect maintenance action verification failed","Conveyor Inspect maintenance action verified successfully");
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyMaintenanceExpandFunctionality(),"Conveyor Inspect maintenance expand verification failed","Conveyor Inspect maintenance action expand verified successfully");
    }

    @QAFTestStep(description="Verify maintenance action max temperature functionality")
    public void verifyMaintenanceActionTemp() {
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyMaintenanceAction(),"Conveyor Inspect maintenance action verification failed","Conveyor Inspect maintenance action verified successfully");
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyMaxTemp(),"Conveyor Inspect maintenance action temperature verification failed","Conveyor Inspect maintenance action temperature verified successfully");
    }

    @QAFTestStep(description="Verify maintenance action got that fixed functionality")
    public void verifyMaintenanceActionGotFixed() {
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyMaintenanceAction(),"Conveyor Inspect maintenance action verification failed","Conveyor Inspect maintenance action verified successfully");
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyGotThatFixed(),"Conveyor Inspect maintenance action got fixed verification failed","Conveyor Inspect maintenance action got fixed verified successfully");
    }

    @QAFTestStep(description="Verify maintenance action ifr images functionality")
    public void verifyMaintenanceActionIfrImages() {
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyMaintenanceAction(),"Conveyor Inspect maintenance action verification failed","Conveyor Inspect maintenance action verified successfully");
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyIfrImages(),"Conveyor Inspect maintenance action ifr images verification failed","Conveyor Inspect maintenance action ifr images verified successfully");
    }

    @QAFTestStep(description="Verify upload files button navigation")
    public void verifyUploadBtnNav() {
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyUploadBtnNavigation(),"Conveyor Inspect Upload files nav verification failed","Conveyor Inspect Upload files nav verified successfully");
    }

    @QAFTestStep(description="Select site {SiteName} and verify it is selected")
    public void verifySiteNameSelection(String siteName) {
        ConveyorInspectPage.getInstance().siteSelection(siteName);
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifySiteSelection(siteName),"Conveyor Inspect Site selection verification failed","Conveyor Inspect Site selection verified successfully");
    }

    @QAFTestStep(description="Verify site {SiteName} is selected")
    public void verifySiteName(String siteName) {
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifySiteSelection(siteName),"Conveyor Inspect Site selection verification failed","Conveyor Inspect Site selection verified successfully");
    }

    @QAFTestStep(description="Select conveyor {ConveyorName} and verify it is selected")
    public void verifyConveyorNameSelection(String conveyorName) {
        ConveyorInspectPage.getInstance().conveyorSelection(conveyorName);
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyConveyorSelection(conveyorName),"Conveyor Inspect Conveyor selection verification failed","Conveyor Inspect Conveyor selection verified successfully");
    }

    @QAFTestStep(description="Verify conveyor {ConveyorName} is selected")
    public void verifyConveyorName(String conveyorName) {
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyConveyorSelection(conveyorName),"Conveyor Inspect Site selection verification failed","Conveyor Inspect Site selection verified successfully");
    }

    @QAFTestStep(description="Verify date of flight is selected")
    public void verifyDateOfFlight() {
        Validator.assertTrue(!ConveyorInspectPage.getInstance().verifyFlightDate().isBlank(),"Conveyor Inspect date selection verification failed","Conveyor Inspect date selection verified successfully");
    }

    @QAFTestStep(description="Verify time of flight is selected")
    public void verifyTimeOfFlight() {
        Validator.assertTrue(!ConveyorInspectPage.getInstance().verifyFlightTime().isBlank(),"Conveyor Inspect time selection verification failed","Conveyor Inspect time selection verified successfully");
    }

    @QAFTestStep(description="Verify side is selected")
    public void verifySideSelection() {
        Validator.assertTrue(!ConveyorInspectPage.getInstance().verifySideSelection().isBlank(),"Conveyor Inspect side selection verification failed","Conveyor Inspect side selection verified successfully");
    }

    @QAFTestStep(description="Verify color map is selected")
    public void verifyColorMapSelection() {
        Validator.assertTrue(!ConveyorInspectPage.getInstance().verifyColorSelection().isBlank(),"Conveyor Inspect color map selection verification failed","Conveyor Inspect color map selection verified successfully");
    }

    @QAFTestStep(description="Verify cancel button functionality")
    public void verifyCancelFunctionality() {
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyCancelFunctionality(),"Conveyor Inspect cancel upload verification failed","Conveyor Inspect cancel upload verified successfully");
    }

    @QAFTestStep(description="Upload {irImage} and {rgbImage} images")
    public void verifyImageUpload(String irFile, String rgbFile) {
        Validator.assertTrue(ConveyorInspectPage.getInstance().openUploadImage(irFile),"Conveyor Inspect img selection verification failed","Conveyor Inspect img selection verified successfully");
        SyncUtil.waitFor(2000);
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyUploadImage().contains("1"),"Conveyor Inspect img upload verification failed","Conveyor Inspect img upload verified successfully");
        Validator.assertFalse(ConveyorInspectPage.getInstance().openUploadImage(rgbFile),"Conveyor Inspect img selection verification failed","Conveyor Inspect img selection verified successfully");
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyUploadImage().contains("2"),"Conveyor Inspect img upload verification failed","Conveyor Inspect img upload verified successfully");
    }

    @QAFTestStep(description="Upload only {irImage} image")
    public void verifySingleImageUpload(String irFile) {
        Validator.assertTrue(ConveyorInspectPage.getInstance().openUploadImage(irFile),"Conveyor Inspect img selection verification failed","Conveyor Inspect img selection verified successfully");
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyUploadImage().contains("1"),"Conveyor Inspect img upload verification failed","Conveyor Inspect img upload verified successfully");
    }

    @QAFTestStep(description="Verify conveyor inspect upload image form saved successfully")
    public void verifyImageUploadSubmit() {
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyUploadSubmitSuccess(),"Conveyor Inspect img upload form submit verification failed","Conveyor Inspect img upload form submit verified successfully");
    }

    @QAFTestStep(description="Verify error message when incomplete form is submitted")
    public void verifyImageUploadError() {
        Validator.assertTrue(ConveyorInspectPage.getInstance().verifyUploadSubmitError(),"Conveyor Inspect img upload form error verification failed","Conveyor Inspect img upload form error verified successfully");
    }
}
