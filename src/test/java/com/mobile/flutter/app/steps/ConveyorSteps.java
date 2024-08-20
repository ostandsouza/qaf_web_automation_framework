package com.mobile.flutter.app.steps;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.pages.ConveyorPage;
import com.mobile.flutter.app.pages.DashboardPage;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

public class ConveyorSteps {

    @QAFTestStep(description = "Add conveyor with {ConveyorName} {CustSiteName} {DistShopName}")
    public void verifyAddConveyor(String conveyorName, String custSiteName, String distShopName) {
        Validator.assertTrue(ConveyorPage.getInstance().addConveyor(conveyorName, custSiteName, distShopName),"New Conveyor was not created","New Conveyor was created successfully");
    }

    @QAFTestStep(description = "Add conveyor without conveyorName {CustSiteName} {DistShopName}")
    public void verifyAddConveyorWithoutName(String custSiteName, String distShopName) {
//        Validator.assertTrue(ConveyorPage.getInstance().addConveyorWithoutName(custSiteName, distShopName),"New Conveyor was not created","New Conveyor was created successfully");
        ConveyorPage.getInstance().addConveyorWithoutName(custSiteName, distShopName);
    }
    @QAFTestStep(description = "Navigate to conveyor list and verify {ConveyorName} is present")
    public void verifyConveyorCreation(String conveyorName) {
        Validator.assertTrue(ConveyorPage.getInstance().verifyConveyorCreation(conveyorName),"Newly added Conveyor was not created","Newly added Conveyor was created successfully");
    }

    @QAFTestStep(description = "Navigate to conveyor details screen")
    public void verifyConveyorDetailsNav() {
        Validator.assertTrue(ConveyorPage.getInstance().goToConveyorDetails(),"Conveyor details navigation failed","Successfully navigated to conveyor details screen");
    }

    @QAFTestStep(description = "Go back from conveyor details screen")
    public void verifyBackToConveyorList() {
        Validator.assertTrue(ConveyorPage.getInstance().goBackToConveyorList(),"Conveyor back navigation to list screen failed","Successfully navigated back to conveyor list screen");
    }

    @QAFTestStep(description = "Verify user is able to edit conveyor name {ConveyorName} to {EditConveyorName} {EditCustSiteName} and {EditDistShopName}")
    public void verifyConveyorEditName(String conveyorName, String editConveyorName, String editCustSiteName, String editDistShopName) {
        Validator.assertTrue(ConveyorPage.getInstance().goToEditConveyor(),"Newly added conveyor able to edit with edit permission","Newly added conveyor able to edit when edit permission");
        Validator.assertTrue(ConveyorPage.getInstance().updateConveyorName(editConveyorName,editCustSiteName,editDistShopName),"Not able to update conveyor name","Able to update conveyor name");
    }

    @QAFTestStep(description = "Verify user is able to delete conveyor name {EditConveyorName}")
    public void verifyConveyorDelete(String conveyorName) {
        ConveyorPage.getInstance().verifyConveyorCreation(conveyorName);
        Validator.assertTrue(ConveyorPage.getInstance().goToDeleteConveyor(),"Newly added conveyor able to delete with delete permission","Newly added conveyor able to delete when delete permission");
    }

    @QAFTestStep(description = "Verify the deleted conveyor {EditConveyorName}")
    public void verifyDeletedConveyor(String conveyorName) {
        Validator.assertTrue(ConveyorPage.getInstance().verifyConveyorDelete(conveyorName),"Deleted Conveyor was found in list screen","Unable to find deleted conveyor is list screen");
    }

    @QAFTestStep(description = "Navigate back to dashboard screen")
    public void goBackToDashboard() {
        DashboardNativePage.getInstance().goBackToDashboard();
    }

    @QAFTestStep(description="Close search box from list screen")
    public void closeSearchBoxFromListScreen(){
        DashboardNativePage.getInstance().goBackFromSearch();
    }

    @QAFTestStep(description = "Verify the conveyor filter result for {conveyor}")
    public void verifyFilterResult(String conveyor) {
        Validator.assertTrue(DashboardNativePage.getInstance().getConveyorSearchResult().contains(conveyor),"Conveyor name is not matching after applying filter","Conveyor name is verified successfully after applying filter");
    }

    @QAFTestStep(description = "Apply conveyor filter with corporate type as {EditDistCorpName}")
    public void verifyConveyorFilter(String editDistCorpName) {
        Validator.assertTrue(DashboardNativePage.getInstance().goToFilterScreen(),"Not able to open filter screen for corporate list page","Successfully able to navigate to corporate list screen");
        DashboardNativePage.getInstance().filterDescendingOrder();
        Validator.assertTrue(DashboardNativePage.getInstance().filterSiteFromDropdown(editDistCorpName),"Filter corporate multiselect not working as expected","Filter corporate multiselect is working as expected");
//        Validator.assertTrue(DashboardNativePage.getInstance().saveFilter(),"Unable lto save filter changes in corporate screen","Able lto save filter changes in corporate screen");
    }


    @QAFTestStep(description = "Verify that the conveyor tile is visible in home page and click on it")
    public void clickAndVerifyConveyorTile() {
            DashboardPage.getInstance().conveyorTileClick();
    }

    @QAFTestStep(description = "Click on add button in conveyor list page and verify it navigates to add conveyor page")
    public void clickOnAddBtnAndVerifyNavigation() {
        ConveyorPage.getInstance().addBtnClick();
        ConveyorPage.getInstance().isAddConveyorPage();

    }

    @QAFTestStep(description = "Navigate to the Add Conveyor Page with {ConveyorName}")
    public void addConveyorPageNavigation(String conveyorName) {
//        SyncUtil.waitFor(30000);
//        String conveyorId = DashboardPage.getInstance().apiBase.getConveyorsAPI(conveyorName);
//        DashboardPage.getInstance().apiBase.deleteConveyorAPI(conveyorId);
//        DashboardNativePage.getInstance().refreshPage();
        Validator.assertTrue(DashboardPage.getInstance().goToConveyor(),"Add conveyor page is not visible","Add conveyor page is visible");
    }

    @QAFTestStep(description = "Add Conveyor with distributor {ConveyorName} {DistShopName} {CustSiteName}")
    public void addConveyorWithDistributor(String conveyorName,String distName,String custSiteName) {
        Validator.assertTrue(ConveyorPage.getInstance().addConveyorWithDistShop(conveyorName,distName, custSiteName),"New Conveyor was not created","New Conveyor was created successfully");

    }

}

