package com.mobile.flutter.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.mobile.nativectx.app.pages.InspectionNativePage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;

public class InspectionPage extends FlutterBasePage {

    private static InspectionPage obj;

    public static InspectionPage getInstance(){
        if(obj==null)
            obj = new InspectionPage();
        return obj;
    }

    @FindBy(locator = "inspection.name.field")
    public CustomFlutterElement inspectionNameField;

    @FindBy(locator = "inspection.site.field")
    public CustomFlutterElement siteField;

    @FindBy(locator = "inspection.conveyor.field")
    public CustomFlutterElement conveyorField;

    @FindBy(locator = "inspection.next.btn")
    public CustomFlutterElement nextBtn;

    @FindBy(locator = "inspection.save.btn")
    public CustomFlutterElement saveBtn;

    @FindBy(locator = "inspection.search.dropdown")
    public CustomFlutterElement searchArea;

    @FindBy(locator = "inspection.addCustomerDistributorLogo.label")
    public CustomFlutterElement addCustomDistributorLogoHeader;
    @FindBy(locator = "inspection.uploadFile.label")
    public CustomFlutterElement uploadFile;

    @FindBy(locator = "inspection.beltWidth.field")
    public CustomFlutterElement beltWidth;
    @FindBy(locator = "inspection.beltSpecs.label")
    public CustomFlutterElement beltSpecsHeader;
    @FindBy(locator = "inspection.inspectorName.field")
    public CustomFlutterElement inspectorNameField;
    @FindBy(locator = "inspection.topCoverThickness.field")
    public CustomFlutterElement topCoverThickness;
    @FindBy(locator = "inspection.bottomCoverThickness.field")
    public CustomFlutterElement bottomCoverThickness;
    @FindBy(locator = "inspection.beltCarcass.field")
    public CustomFlutterElement beltCarcass;
    @FindBy(locator = "inspection.addNewItem.button")
    public CustomFlutterElement addNewItemBtn;
    @FindBy(locator = "inspection.addNewItem.header")
    public CustomFlutterElement addNewItemHeader;
    @FindBy(locator = "inspection.toBeCompleted.button")
    public CustomFlutterElement toBeCompletedStatusBtn;
    @FindBy(locator = "inspection.asset.dropdown")
    public CustomFlutterElement assetDropDown;
    @FindBy(locator = "inspection.beltRating.field")
    public CustomFlutterElement beltRating;
    @FindBy(locator = "inspection.items.label")
    public CustomFlutterElement addInspectionItemsHeader;

    @FindBy(locator = "inspection.assetOption.trackingFrames")
    public CustomFlutterElement ddlTrackingFrames;
    @FindBy(locator = "inspection.assetOption.rollerFrames")
    public CustomFlutterElement ddlRollerFrames;
    @FindBy(locator = "inspection.assetOption.driveMotors")
    public CustomFlutterElement ddlDriveMotors;
    @FindBy(locator = "inspection.assetOption.counterWeight")
    public CustomFlutterElement ddlCounterWeight;
    @FindBy(locator = "inspection.assetOption.conveyorStructure")
    public CustomFlutterElement ddlConveyorStructure;
    @FindBy(locator = "inspection.assetOption.chutes")
    public CustomFlutterElement ddlChutes;
    @FindBy(locator = "inspection.assetOption.cleaningEquipment")
    public CustomFlutterElement ddlCleaningEquipment;

    @FindBy(locator = "inspection.detail.dropdown")
    public CustomFlutterElement detailField;
    @FindBy(locator = "inspection.failure.dropdown")
    public CustomFlutterElement failureModeField;
    @FindBy(locator = "inspection.pullyNo.dropdown")
    public CustomFlutterElement pulleyNoField;
    @FindBy(locator = "inspection.type.dropdown")
    public CustomFlutterElement typeField;
    @FindBy(locator = "inspection.assetOption.conveyorBelt")
    public CustomFlutterElement ddlConveyorBelt;
    @FindBy(locator = "inspection.assetOption.pulley")
    public CustomFlutterElement ddlPulley;

    @FindBy(locator = "inspection.assetOption.rollerIdlers")
    public CustomFlutterElement ddlRollersIdlers;
    @FindBy(locator = "inspection.assetOption.other")
    public CustomFlutterElement ddlOther;

    @FindBy(locator = "inspection.locationAlongBelt.dropdown")
    public CustomFlutterElement locationAlongBeltOptions;
    @FindBy(locator = "inspection.frameNo.dropdown")
    public CustomFlutterElement frameNumberField;
    @FindBy(locator = "inspection.other.dropdown")
    public CustomFlutterElement otherFiled;
    @FindBy(locator = "inspection.observation.field")
    public CustomFlutterElement tbObservation;

    @FindBy(locator = "inspection.condition.dropdown")
    public CustomFlutterElement conditionDropDown;
    @FindBy(locator = "inspection.condition.criticalFlag")
    public CustomFlutterElement criticalFlag;
    @FindBy(locator = "inspection.condition.poorFlag")
    public CustomFlutterElement poorFlag;
    @FindBy(locator = "inspection.condition.goodFlag")
    public CustomFlutterElement goodFlag;
    @FindBy(locator = "inspection.condition.faultFlag")
    public CustomFlutterElement faultFlag;
    @FindBy(locator = "inspection.status.toBeCompleted")
    public CustomFlutterElement inspectionStatus;
    @FindBy(locator = "inspection.recommendation.field")
    public CustomFlutterElement tbRecommendation;
    @FindBy(locator = "inspection.saveAndClose.btn")
    public CustomFlutterElement btnSaveAbdClose;
    @FindBy(locator = "inspection.addNewItem.itemLength")
    public CustomFlutterElement addItemLength;
    @FindBy(locator = "inspection.list.addIcon")
    public CustomFlutterElement btnAddInspection;
    @FindBy(locator = "inspection.Info.label")
    public CustomFlutterElement inspectionInfoHeader;
    @FindBy(locator = "inspection.signOff.label")
    public CustomFlutterElement signOffHeader;
    @FindBy(locator = "inspection.saveAsDraft.label")
    public CustomFlutterElement saveAsDraftBtn;
    @FindBy(locator = "inspection.type.multiple")
    public CustomFlutterElement inspectionTypeMultiple;
    @FindBy(locator = "inspection.type.single")
    public CustomFlutterElement inspectionTypeSingle;

    @FindBy(locator = "inspection.previous.btn")
    public CustomFlutterElement prevBtn;

    @FindBy(locator = "inspection.detail.dropdown")
    public CustomFlutterElement detailDropDown;
    @FindBy(locator = "inspection.completed.button")
    public CustomFlutterElement completedStatusBtn;
    @FindBy(locator = "inspection.failure.dropdown")
    public CustomFlutterElement failureModeDropDown;



    @FindBy(locator = "inspection.datePicker.dropdown")
    public CustomFlutterElement datePickerDropDown;


    @FindBy(locator = "inspection.status.dropDown")
    public CustomFlutterElement statusDropDown;


    @FindBy(locator = "inspection.observation.field")
    public CustomFlutterElement observationField;
    @FindBy(locator = "inspection.recommendation.field")
    public CustomFlutterElement recommendationField;
    @FindBy(locator = "inspection.saveAndClose.btn")
    public CustomFlutterElement saveAndCloseBtn;
    @FindBy(locator = "inspection.signOff.summaryLabel")
    public CustomFlutterElement summaryLabel;
    @FindBy(locator = "dashboard.home.title")
    public CustomFlutterElement homeTitle;
    @FindBy(locator = "inspection.add.back")
    public CustomFlutterElement inspectionAddBackBtn;

    public boolean isInspectionPage() {
        return inspectionNameField.isPresent();
    }

    public boolean addInspection(String inspectionName, String conveyorName, String custSiteName) {
        inspectionNameField.sendKeys(inspectionName);
        SyncUtil.waitFor(2000);

        siteField.click("Customer dropdown");
        searchArea.sendKeys(custSiteName, "Customer");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        conveyorField.click("Conveyor dropdown");
        searchArea.sendKeys(conveyorName, "Conveyor");
        DashboardNativePage.getInstance().selectFirstSearchTerritorySiteScreen();

        nextBtn.click("next Btn");

        saveBtn.scrollIntoView("Save Btn");
        saveBtn.click();
        SyncUtil.waitFor(5000);
        return !saveBtn.isVisible();
    }

    public boolean addInspectionCustomDistributorlogo() {
        SyncUtil.waitFor(3000);
        Validator.assertTrue(addCustomDistributorLogoHeader.isVisible(),"Add Custom Distributor Logo is not visible","Add Custom Distributor Logo is visible");
        Validator.assertTrue(uploadFile.isVisible(),"Upload File Button is not visible","Upload File Button is visible");

        InspectionNativePage.getInstance().clickInspectionCustomDistNextBtn();
        return inspectionNameField.isVisible();
    }
    public boolean addInspectionInfo(String inspectionName, String conveyorName, String custSiteName,String inspectorName) {
        SyncUtil.waitFor(3000);
        Validator.assertTrue(inspectionNameField.isVisible(),"Inspection Name field is not visible","Inspection Name field is visible");
        inspectionNameField.sendKeys(inspectionName);
        SyncUtil.waitFor(2000);

        Validator.assertTrue(siteField.isVisible(),"Site field is not visible","Site field is visible");
        siteField.click("Customer dropdown");
        searchArea.sendKeys(custSiteName, "Customer");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        Validator.assertTrue(conveyorField.isVisible(),"Conveyor field is not visible","Conveyor field is visible");
        conveyorField.click("Conveyor dropdown");
        searchArea.sendKeys(conveyorName, "Conveyor");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

//        Validator.assertTrue(datePickerDropDown.isVisible(),"Date Picker field is not visible","Date Picker field is visible");
//        datePickerDropDown.click();
//        InspectionNativePage.getInstance().validateInspectionCalenderPopUp();

        Validator.assertTrue(inspectorNameField.isVisible(),"Inspection Name field is not visible","Inspection Name field is visible");
        inspectorNameField.sendKeys(inspectorName);

        InspectionNativePage.getInstance().clickInspectionInfoBeltNextBtn(); Validator.assertTrue(beltSpecsHeader.isVisible(),"Belt Specs Header is not visible","Belt Specs Header is visible");
        Validator.assertTrue(beltWidth.isVisible(),"Belt Specs Fields are not visible","Belt Specs Fields are visible");
        return beltWidth.isVisible();
    }

    public boolean addInspectionBeltScan() {
        Validator.assertTrue(beltWidth.isVisible(),"Belt Width field is not visible","Belt Width field is visible");
        Validator.assertTrue(beltRating.isVisible(),"Belt Rating field is not visible","Belt Rating field is visible");
        Validator.assertTrue(topCoverThickness.isVisible(),"Top Cover Thickness field is not visible","Top Cover Thickness field is visible");
        Validator.assertTrue(bottomCoverThickness.isVisible(),"Bottom Cover Thickness field is not visible","Bottom Cover Thickness field is visible");
        Validator.assertTrue(beltCarcass.isVisible(),"Belt Carcass field is not visible","Belt Carcass field is visible");

        InspectionNativePage.getInstance().clickInspectionInfoBeltNextBtn();

        Validator.assertTrue(addInspectionItemsHeader.isVisible(),"Add Inspection Items Header is not visible","Add Inspection Items Header is visible");
        Validator.assertTrue(addNewItemBtn.isVisible(),"Add New Item Button is not visible","Add New Item Button is visible");

        return addNewItemBtn.isVisible();
    }
    public boolean clickAndVerifyAddNewItemPageDetails() {
        addNewItemBtn.click();
        SyncUtil.waitFor(3000);
        Validator.assertTrue(addNewItemHeader.isVisible(),"Add New Item Page is not visible","Add New item page is visible");
        Validator.assertTrue(toBeCompletedStatusBtn.isVisible(),"To Be Completed Status is not visible","To Be Completed Status is visible");
        Validator.assertTrue(assetDropDown.isVisible(),"Asset DropDown is not visible","Asset DropDown is visible");

        return addNewItemHeader.isVisible();
    }
    public void searchAsset(String asset) {
        searchArea.waitForTheElementToBeVisible(10000);
        searchArea.sendKeys(asset, "Asset");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();
    }
    public void selectAssetAndVerifyDropDownDisplay(String asset,String data,String type)
    {

        assetDropDown.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(assetDropDown.isVisible(),"Asset DropDown is not visible","Asset DropDown is visible");
        assetDropDown.click();
//        assetDropDown.click();
//        switch(asset)
        searchAsset(asset);


        if(ddlTrackingFrames.toString().contains(asset)||ddlChutes.toString().contains(asset)||ddlConveyorStructure.toString().contains(asset)||ddlConveyorStructure.toString().contains(asset)
                ||ddlCounterWeight.toString().contains(asset)||ddlDriveMotors.toString().contains(asset)||ddlRollerFrames.toString().contains(asset))
        {

                detailField.waitForTheElementToBeVisible(10000);
                detailField.click();
                searchAsset(data);
                 Validator.assertTrue(detailField.isVisible() && failureModeField.isVisible() ,"The respective dropdown for'"+asset+"is not visible","The respective dropdown for'"+asset+"' is visible");

        }
        else if(ddlConveyorBelt.toString().contains(asset))
        {
            locationAlongBeltOptions.waitForTheElementToBeVisible(10000);
            System.out.println(locationAlongBeltOptions.isVisible()+data+"locationAlongBeltOptions");
            Validator.assertTrue(locationAlongBeltOptions.isVisible() && failureModeField.isVisible() ,"The respective dropdown for'"+asset+"is not visible","The respective dropdown for'"+asset+"' is visible");
            locationAlongBeltOptions.click("locationAlongBelt");
            locationAlongBeltOptions.sendKeys(data,"locationAlongBelt");
            SyncUtil.waitFor(2000);
        }
        else if(ddlPulley.toString().contains(asset))
        {
            pulleyNoField.waitForTheElementToBeVisible(10000);
            Validator.assertTrue(pulleyNoField.isVisible() && typeField.isVisible() && failureModeField.isVisible() ,"The respective dropdown for'"+asset+"is not visible","The respective dropdown for'"+asset+"' is visible");
            pulleyNoField.sendKeys(data);
            typeField.click();
            searchAsset(type);

        }
        else if (ddlRollersIdlers.toString().contains(asset)){
            frameNumberField.waitForTheElementToBeVisible(10000);
            Validator.assertTrue(frameNumberField.isVisible() && typeField.isVisible() && failureModeField.isVisible() ,"The respective dropdown for'"+asset+"is not visible","The respective dropdown for'"+asset+"' is visible");
            frameNumberField.sendKeys(data);
            searchAsset(type);
        }
        else if(ddlCleaningEquipment.toString().contains(asset))
        {
            typeField.waitForTheElementToBeVisible(10000);
            Validator.assertTrue(typeField.isVisible() && failureModeField.isVisible() ,"The respective dropdown for'"+asset+"is not visible","The respective dropdown for'"+asset+"' is visible");
            typeField.click();
            searchAsset(type);
        }
        else{
            otherFiled.waitForTheElementToBeVisible(10000);
            Validator.assertTrue(otherFiled.isVisible() && failureModeField.isVisible() ,"The respective dropdown for'"+asset+"is not visible","The respective dropdown for'"+asset+"' is visible");
            otherFiled.sendKeys(data);
        }

    }
    public void selectAndVerifyFailureMode(String failureMode)
    {
        failureModeField.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(failureModeField.isVisible(),"Failure Mode is not visible","Failure Mode is visible");
        failureModeField.click();
        searchAsset(failureMode);
    }
    public void enterObsData(String enterObsData)
    {
        tbObservation.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(tbObservation.isVisible(),"Observation field is not visible","Observation field is visible");
        tbObservation.sendKeys(enterObsData);
    }
    public void selectInspectionCondition()
    {
        Validator.assertTrue(conditionDropDown.isVisible(),"Condition DropDown is not visible","Condition DropDown is visible");
        Validator.assertTrue(goodFlag.isVisible(),"Good Flag is not visible","Good Flag is visible");
        goodFlag.click();

        Validator.assertTrue(criticalFlag.isVisible(),"Critical Flag is not visible","Critical Flag is visible");
        Validator.assertTrue(faultFlag.isVisible(),"Fault Flag is not visible","Fault Flag is visible");
        Validator.assertTrue(poorFlag.isVisible(),"Poor Flag is not visible","Poor Flag is visible");
        Validator.assertTrue(goodFlag.isVisible(),"Good Flag is not visible","Good Flag is visible");

        faultFlag.click();

    }
    public void selectAndVerifyInspectionStatus()
    {
        inspectionStatus.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(inspectionStatus.isVisible(),"To be Completed status is not visible","To be Completed status is visible");
        inspectionStatus.click();
    }
    public void enterRecommendation(String recommendation)
    {
        tbRecommendation.waitForTheElementToBeVisible(10000);
//        Validator.assertTrue(tbRecommendation.isVisible(),"To be Completed status is not visible","To be Completed status is visible");
        tbRecommendation.sendKeys(recommendation,"recommendation");
    }
    public void clickSaveAndClose()
    {
        Validator.assertTrue(btnSaveAbdClose.isVisible(),"save and close is not visible","save and close is visible");
        btnSaveAbdClose.click();
        SyncUtil.waitFor(2000);
    }
    public void verifyNavToNewInspectionPage(String count)
    {
        SyncUtil.waitFor(3000);
        Validator.assertTrue(addNewItemBtn.isVisible(),"Add New Item Button is not visible","Add New Item Button is visible");
        Validator.assertTrue(addItemLength.isVisible(),"Add New Item Button is not visible","Add New Item Button is visible");
        Validator.assertTrue(addItemLength.getText().contains(count),"New Item Count mismatch","New Item matched");
    }
    public void addInspectionIconClick()
    {
        btnAddInspection.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(btnAddInspection.isVisible(),"Add Icon is visible in inspection list page","Add Icon is not visible in inspection list page");
        btnAddInspection.click("addIcon");

    }

    public void verifyAddNewInspectionPageDetails(){
        SyncUtil.waitFor(4000);
        Validator.assertTrue(addCustomDistributorLogoHeader.isVisible(),"Add Custom Distributor Logo is not visible","Add Custom Distributor Logo is visible");
        Validator.assertTrue(inspectionInfoHeader.isVisible(),"Inspection Info is not visible","Inspection Info is visible");
        Validator.assertTrue(beltSpecsHeader.isVisible(),"Belt Specs is not visible","Belt Specs is visible");
        Validator.assertTrue(addInspectionItemsHeader.isVisible(),"Add Inspection Item is not visible","Add Inspection Item is visible");
        Validator.assertTrue(signOffHeader.isVisible(),"Sign off is not visible","Sign off is visible");
        Validator.assertTrue(saveAsDraftBtn.isVisible(),"Save as Draft Button is not visible","Save as Draft Button is visible");
    }
    public void inspectionInfoClickAndVerifyTypes()
    {
        inspectionInfoHeader.waitForTheElementToBeVisible(10000);
        inspectionInfoHeader.click();
        SyncUtil.waitFor(3000);
        Validator.assertTrue(inspectionNameField.isVisible(),"Inspection Name field is not visible","Inspection Name field is visible");
        inspectionTypeSingle.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(inspectionTypeSingle.isVisible() && inspectionTypeMultiple.isVisible(),"Single and Multiple Inspection type is not visible","Single and Multiple Inspection type is not visible");
    }


    public void verifyAddInspectionItemsFields(){
        Validator.assertTrue(addNewItemBtn.isVisible(),"Add New Item Button is not visible","Add New Item Button is visible");
        Validator.assertTrue(nextBtn.isVisible(),"Next Button is not visible","Next Button is visible");
        Validator.assertTrue(prevBtn.isVisible(),"Previous Button is not visible","Previous Button is visible");
    }
    public void verifyConditionFlagsInAddInspectionItems(){
        Validator.assertTrue(conditionDropDown.isVisible(),"Condition DropDown is not visible","Condition DropDown is visible");
        Validator.assertTrue(goodFlag.isVisible(),"Good Flag is not visible","Good Flag is visible");
        goodFlag.click();

        Validator.assertTrue(criticalFlag.isVisible(),"Critical Flag is not visible","Critical Flag is visible");
        Validator.assertTrue(faultFlag.isVisible(),"Fault Flag is not visible","Fault Flag is visible");
        Validator.assertTrue(poorFlag.isVisible(),"Poor Flag is not visible","Poor Flag is visible");
        Validator.assertTrue(goodFlag.isVisible(),"Good Flag is not visible","Good Flag is visible");

        faultFlag.click();
    }
    public void verifyStatusInAddInspectionItems(){
        Validator.assertTrue(statusDropDown.isDisplayed(),"Status DropDown is not visible","Status DropDown is visible");
        Validator.assertTrue(toBeCompletedStatusBtn.isVisible(),"To Be Completed Status is not visible","To Be Completed Status is visible");
        Validator.assertTrue(completedStatusBtn.isVisible(),"Completed Status is not visible","Completed Status is visible");
    }

    public void addInspectionAddNewItemPageDetails(String asset,String detail,String failure,String observation,String recommendation,String length) {
        System.out.println(asset+detail+failure+observation+recommendation+length);
        addNewItemBtn.click();
        SyncUtil.waitFor(3000);
        Validator.assertTrue(addNewItemHeader.isVisible(),"Add New Item Page is not visible","Add New item page is visible");

        assetDropDown.waitForTheElementToBeVisible(5000);
        assetDropDown.click();
        searchArea.waitForTheElementToBeVisible(10000);
        searchArea.sendKeys(asset, "Asset");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        detailDropDown.click();
        searchArea.waitForTheElementToBeVisible(10000);
        searchArea.sendKeys(detail, "Detail");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        failureModeDropDown.click();
        searchArea.waitForTheElementToBeVisible(10000);
        searchArea.sendKeys(failure, "Detail");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        toBeCompletedStatusBtn.click();

        observationField.waitForTheElementToBeVisible(5000);
        observationField.sendKeys(observation);
        recommendationField.sendKeys(recommendation);

        saveAndCloseBtn.click();

        SyncUtil.waitFor(3000);
        Validator.assertTrue(addNewItemBtn.isVisible(),"Add New Item Button is not visible","Add New Item Button is visible");
        addItemLength.waitForTheElementToBeVisible(5000);
        Validator.assertTrue(addItemLength.isVisible(),"Add New Item Count is not visible","Add New Item Count is visible");
        Validator.assertTrue(addItemLength.getText().contains(length),"New Item Count mismatch","New Item matched");
    }

    public void addInspectionSignOffPageDetails(String summary) {
        signOffHeader.waitForTheElementToBeVisible(5000);
        Validator.assertTrue(signOffHeader.isVisible(),"Sign off is not visible","Sign off is visible");
        Validator.assertTrue(summaryLabel.isVisible(),"Summary Label is not visible","Summary Label is visible");
//        InspectionNativePage.getInstance().verifyInspectionSummaryField(summary);
        saveAndCloseBtn.click();
        homeTitle.waitForTheElementToBeVisible(5000);
        Validator.assertTrue(homeTitle.isDisplayed(),"New Inspection is not created","New Inspection is created");
    }
    //    public void validateAddMultipleInspItems(String ItemValue) {
//        SyncUtil.waitFor(3000);
//        Validator.assertTrue(addNewItemBtn.isVisible(),"Add New Item Button is not visible","Add New Item Button is visible");
//        addItemLength.waitForTheElementToBeVisible(5000);
//        Validator.assertTrue(addItemLength.isVisible(),"Add New Item Count is not visible","Add New Item Count is visible");
//        Validator.assertTrue(addItemLength.getText().contains(ItemValue),"New Item Count mismatch","New Item matched");
////        saveAndCloseBtn.click();
//    }
    public void clickAndVerifySaveDraftBtn() {
        saveAsDraftBtn.waitForTheElementToBeVisible(5000);
        saveAsDraftBtn.click();
        InspectionNativePage.getInstance().verifySaveAsDraftPopUp();
    }
    public void addDataInInspectionInfo(String inspectionName, String conveyorName, String custSiteName,String inspectorName) {
        inspectionInfoHeader.click();
        SyncUtil.waitFor(4000);
//        System.out.println(inspectionNameField.getText()+"inspectionNameField.getText()");
        System.out.println(inspectionNameField.getText()+"name in the site");
        System.out.println(inspectionNameField.getAttribute("value")+"inspectionNameField.getAttribute()");
        Validator.assertTrue(inspectionNameField.getText().contains(inspectionName),"Inspection Name field data misMatch","Inspection Name field data matched");
        Validator.assertTrue(siteField.getText().contains(custSiteName),"Site Name field data misMatch","Site Name field data matched");
        Validator.assertTrue(conveyorField.getText().contains(conveyorName),"Conveyor Name field data misMatch","Conveyor Name field data matched");
        Validator.assertTrue(inspectorNameField.getText().contains(inspectorName),"Inspector Name field data misMatch","Inspector Name field data matched");
    }
    public void verifyAddInspBackBtnToHomePage() {
        inspectionAddBackBtn.waitForTheElementToBeVisible(5000);
        inspectionAddBackBtn.click("Inspection Back Button");
        DashboardPage.getInstance().isHomePage();
    }

}


