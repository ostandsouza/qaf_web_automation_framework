package com.mobile.flutter.app.steps;

import com.mobile.flutter.app.pages.ConveyorPage;
import com.mobile.flutter.app.pages.CorporatePage;
import com.mobile.flutter.app.pages.DashboardPage;
import com.mobile.flutter.app.pages.InspectionPage;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.mobile.nativectx.app.pages.InspectionNativePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

public class InspectionSteps {

    @QAFTestStep(description = "Add inspection with {InspectionName} {ConveyorName} {CustSiteName}")
    public void verifyAddInspection(String inspectionName, String conveyorName, String custSiteName) {
        Validator.assertTrue(InspectionPage.getInstance().addInspection(inspectionName, conveyorName, custSiteName),"New Inspection was not created","New Inspection was created successfully");
    }
    @QAFTestStep(description="Navigate to add inspection page via Home and verify navigation")
    public void navigateToTheAddInspectionPageViaHome(){
        DashboardPage.getInstance().goToInspection();
    }

    @QAFTestStep(description = "Add inspection custom distributor logo")
    public void verifyAddInspectionCustomDistributorlogo() {
        Validator.assertTrue(InspectionPage.getInstance().addInspectionCustomDistributorlogo(),"Inspection Custom Distributor logo was not filled","Inspection Custom Distributor log was filled");
    }

    @QAFTestStep(description = "Add inspection info with {InspectionName} {ConveyorName} {CustSiteName} {InspectorName}")
    public void verifyAddInspectionInfo(String inspectionName, String conveyorName, String custSiteName,String inspectorName) {
        Validator.assertTrue(InspectionPage.getInstance().addInspectionInfo(inspectionName, conveyorName, custSiteName,inspectorName),"Inspection Info was not filled","Inspection Info was filled");
    }

    @QAFTestStep(description = "Add inspection belt scan")
    public void verifyAddInspectionBeltScan() {
        Validator.assertTrue(InspectionPage.getInstance().addInspectionBeltScan(),"Inspection Belt Scan was not filled","Inspection Belt Scan was filled");
    }
    @QAFTestStep(description = "Click Add New Item and verify navigation to Add New Item page")
    public void clickAndVerifyTheAddNewItemPageDetails() {
        Validator.assertTrue(InspectionPage.getInstance().clickAndVerifyAddNewItemPageDetails(),"Inspection Custom Distributor logo was not filled","Inspection Custom Distributor log was filled");
    }
    @QAFTestStep(description = "Click on asset/component dropdown and select option {Asset} and verify based on the selected option rest of the dropdowns and fields are visible and enter data {Data} and {type} in respective field")
        public void selectAssetAndVerifyFields(String asset,String data,String type)
    {InspectionPage.getInstance().selectAssetAndVerifyDropDownDisplay(asset,data,type);}

    @QAFTestStep(description = "Select required details from the failure mode dropdown {failureMode} and enter value {Observation} in observation field")
    public void selectFailureModeAndEnterObs(String failureMode,String observationData)
    {
        InspectionPage.getInstance().selectAndVerifyFailureMode(failureMode);
        InspectionPage.getInstance().enterObsData(observationData);
    }

    @QAFTestStep(description = "Click on the condition dropdown and verify is able to select {Condition} condition of inspection")
    public void clickAndSelectInspectionCondition(String condition)
    {
        InspectionPage.getInstance().selectInspectionCondition();
    }
    @QAFTestStep(description = "Click the radio button to select the status and verify user is able to select the status")
    public void selectInspectionStatus()
    {InspectionPage.getInstance().selectAndVerifyInspectionStatus();}
    @QAFTestStep(description = "Enter the data in the recommendation field {Recommendation} and verify user is able to enter the recommendation")
    public void addRecommendation(String recommendation)
    {InspectionPage.getInstance().enterRecommendation(recommendation);}

    @QAFTestStep(description = "Click on save and close and verify user is navigated to inspection page and able to see the count {count} of added items")
    public void clickOnSaveInspection(String count)
    {InspectionPage.getInstance().clickSaveAndClose();
//    InspectionPage.getInstance().verifyNavToNewInspectionPage(count);
    }

    @QAFTestStep(description = "Navigate to add inspection page via clicking on Inspection tile and verify navigation")
    public void navigateToAddInspectionViaInspectionTile()
    {DashboardPage.getInstance().inspectionTileClick();}
    @QAFTestStep(description = "Click on the add icon button and verify user is navigated to new inspection page")
    public void clickAndVerifyAddInspectionNav()
    {
        InspectionPage.getInstance().addInspectionIconClick();
        InspectionPage.getInstance().isInspectionPage();
    }
    @QAFTestStep(description = "Navigate to add inspection page by clicking on Inspection button in the footer and verify navigation")
    public void clickInspectionButtonVerifyAddInspectionNav()
    {
        DashboardNativePage.getInstance().inspectionSymbolClick();
        CorporatePage.getInstance().isInspectionListPage();
    }

    @QAFTestStep(description = "Click on add icon in home page and verify Add Inspection Add Conveyor Add Site/Shop Add Corporate are visible")
    public void clickAndVerifyAddIconInHomePage()
    {
        DashboardPage.getInstance().addIconClick();
        DashboardPage.getInstance().verifyHomeAddIconFields();
    }
    @QAFTestStep(description = "Click on Add Inspection link and verify the fields in Add New Inspection page")
    public void clickAndVerifyAddNewInspectionPage()
    {
        Validator.assertTrue(DashboardPage.getInstance().addInspectionClick(),"User is not navigated to add inspection page","User is navigated to add inspection page");
        InspectionPage.getInstance().verifyAddNewInspectionPageDetails();
    }

    @QAFTestStep(description = "Click o Inspection info and verify single and multiple inspection types options are available")
    public void clickInspectionInfoAndVerifyTypes()
    {
        InspectionPage.getInstance().inspectionInfoClickAndVerifyTypes();

    }


    @QAFTestStep(description = "Verify add New Inspection page details")
    public void verifyTheAddNewInspectionPageDetails() {
        InspectionPage.getInstance().verifyAddNewInspectionPageDetails();
    }
    @QAFTestStep(description = "Verify add inspection items fields")
    public void verifyTheAddInspectionItemsFields() {
        InspectionPage.getInstance().verifyAddInspectionItemsFields();
    }
    @QAFTestStep(description = "Verify the condition flags in the add inspection item page")
    public void verifyTheConditionFlagsInAddInspectionItems() {
        InspectionPage.getInstance().verifyConditionFlagsInAddInspectionItems();
    }
    @QAFTestStep(description = "Verify the status options in the add inspection item page")
    public void verifyTheStatusInAddInspectionItems() {
        InspectionPage.getInstance().verifyStatusInAddInspectionItems();
    }
    @QAFTestStep(description = "Add {Asset} {Detail} {Failure} {Observation} {Recommnendation} {Length} for Add New Item Page")
    public void addTheInspectionAddNewItemPageDetails(String asset,String detail,String failure,String observation,String recommendation,String length) {
        InspectionPage.getInstance().addInspectionAddNewItemPageDetails(asset,detail,failure,observation,recommendation,length);
    }
    @QAFTestStep(description = "Verify and Add {Summary} for Sign Off Page")
    public void addTheInspectionSignOffPageDetails(String summary) {
        InspectionPage.getInstance().addInspectionSignOffPageDetails(summary);
    }
    @QAFTestStep(description = "Click Next Button for inspection Add Page")
    public void inspectionNextButtonClick() {
        InspectionNativePage.getInstance().clickInspectionInfoBeltNextBtn();
    }
    @QAFTestStep(description = "Click and verify save draft button and user is present in same page")
    public void verifySaveDraftBtnAndPresentInSamePage() {
        InspectionPage.getInstance().clickAndVerifySaveDraftBtn();
        InspectionPage.getInstance().verifyAddNewInspectionPageDetails();
    }
    @QAFTestStep(description = "Verify the data for inspection info with {InspectionName} {ConveyorName} {CustSiteName} {InspectorName}")
    public void verifyTheDataInAddInspectionInfo(String inspectionName, String conveyorName, String custSiteName,String inspectorName) {
        InspectionPage.getInstance().addDataInInspectionInfo(inspectionName, conveyorName, custSiteName,inspectorName);
    }



}
