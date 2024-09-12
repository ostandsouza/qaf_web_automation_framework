package com.mobile.flutter.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.CoverWearNativePage;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.mobile.utils.DIRECTION;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;
import org.testng.Assert;

public class CoverWearPage extends FlutterBasePage {

    private static CoverWearPage obj;

    public static CoverWearPage getInstance(){
        if(obj==null)
            obj = new CoverWearPage();
        return obj;
    }

    @FindBy(locator = "coverWear.coverWear.txt")
    public CustomFlutterElement coverWear;

    @FindBy(locator = "coverWear.search.field")
    public CustomFlutterElement searchField;

    @FindBy(locator = "coverWear.beltWidth.field")
    public CustomFlutterElement beltWidth;

    @FindBy(locator = "coverWear.beltLength.field")
    public CustomFlutterElement beltLength;

    @FindBy(locator = "coverWear.search.filter")
    public CustomFlutterElement search;

    @FindBy(locator = "coverWear.search.results")
    public CustomFlutterElement result;

    @FindBy(locator = "coverWear.topCoverThickness.field")
    public CustomFlutterElement topCoverThickness;

    @FindBy(locator = "coverWear.bottomCoverThickness.field")
    public CustomFlutterElement bottomCoverThickness;

    @FindBy(locator = "coverWear.durometer.field")
    public CustomFlutterElement durometer;

    @FindBy(locator = "coverWear.topCoverCompound.field")
    public CustomFlutterElement topCoverCompound;

    @FindBy(locator = "coverWear.bottomCoverCompound.field")
    public CustomFlutterElement bottomCoverCompound;

    @FindBy(locator = "coverWear.datePicker.field")
    public CustomFlutterElement dateOfInstallation;

    @FindBy(locator = "coverWear.success.msg")
    public CustomFlutterElement successMsgSpecs;

    @FindBy(locator = "dashboard.save.btn")
    public CustomFlutterElement saveBtn;

    @FindBy(locator = "coverWear.more.button")
    public CustomFlutterElement coverWearMoreBtn;

    @FindBy(locator = "coverWear.delete.text")
    public CustomFlutterElement coverWearDeleteBtn;

    @FindBy(locator = "coverWear.list.header")
    public CustomFlutterElement coverWearHeader;

    @FindBy(locator = "coverWear.position.header")
    public CustomFlutterElement positionHeader;

    @FindBy(locator = "coverWear.positions.count")
    public CustomFlutterElement positionCount;

    @FindBy(locator = "coverWear.first.Position")
    public CustomFlutterElement firstPosition;

    @FindBy(locator = "coverWear.remainingLife.value")
    public CustomFlutterElement remainingLifeValue;
    @FindBy(locator = "coverWear.durometer.value")
    public CustomFlutterElement durometerValue;
    @FindBy(locator = "coverWear.remainingCover.value")
    public CustomFlutterElement remainingCoverValue;

    @FindBy(locator = "coverWear.bottomCoverCompound.label")
    public CustomFlutterElement bottomCoverCompoundField;
    @FindBy(locator = "coverWear.topCoverCompound.label")
    public CustomFlutterElement topCoverCompoundField;

    @FindBy(locator = "coverWear.noOfSections.label")
    public CustomFlutterElement noOfSectionsField;
    @FindBy(locator = "coverWear.DateOfInstallation.label")
    public CustomFlutterElement dateOfInstallationField;
    @FindBy(locator = "coverWear.estimatedFailure.label")
    public CustomFlutterElement estimatedFailureField;
    @FindBy(locator = "coverWear.position.gaugeTile")
    public CustomFlutterElement positionGaugeTile;
    @FindBy(locator = "coverWear.position.top")
    public CustomFlutterElement topPositionField;

    @FindBy(locator = "coverWear.position.remainingLife")
    public CustomFlutterElement topRemainingLife;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_name\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_1_top\\\"}\"}")
    public CustomFlutterElement positionFirstName;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_remainingLife\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_1_top\\\"}\"}")
    public CustomFlutterElement positionFirstRemainingLife;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_durometer\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_1_top\\\"}\"}")
    public CustomFlutterElement positionDurometerLife;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_measurementCount\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_1_top\\\"}\"}")
    public CustomFlutterElement positionMeasurementCount;
    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_uploadStatus\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_1_top\\\"}\"}")
    public CustomFlutterElement positionUploadStatus;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_name\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_1_bottom\\\"}\"}")
    public CustomFlutterElement positionBottomName;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_remainingLife\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_1_bottom\\\"}\"}")
    public CustomFlutterElement positionBottomRemainingLife;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_durometer\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_1_bottom\\\"}\"}")
    public CustomFlutterElement positionBottomDurometerLife;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_measurementCount\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_1_bottom\\\"}\"}")
    public CustomFlutterElement positionBottomMeasurementCount;
    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_uploadStatus\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_1_bottom\\\"}\"}")
    public CustomFlutterElement positionBottomUploadStatus;
    @FindBy(locator = "coverWear.specification.header")
    public CustomFlutterElement SpecificationHeader;
    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Site\\\"}\"}")
    public CustomFlutterElement siteLabel;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Conveyor\\\"}\"}")
    public CustomFlutterElement conveyorLabel;
//    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Belt Width\\\"}\"}")
//    public CustomFlutterElement beltWidthLabel;

    @FindBy(locator = "coverWear.beltWidth.field")
    public CustomFlutterElement beltWidthLabel;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Belt Length\\\"}\"}")
    public CustomFlutterElement beltLengthLabel;

    @FindBy(locator ="coverWear.position.bottom")
    public CustomFlutterElement positionBottom;
    @FindBy(locator ="coverWear.positionDetails.header")
    public CustomFlutterElement positionDetailsHeader;
    @FindBy(locator ="coverWear.tempAdjusted.header")
    public CustomFlutterElement tempAdjustedMeasureHeader;

    @FindBy(locator ="coverWear.default.installation")
    public CustomFlutterElement defaultInstallation;

//    @FindBy(locator = "coverWear.position.gaugeTile")
//    public CustomFlutterElement positionGaugeTile;
//
//    @FindBy(locator = "coverWear.specification.header")
//    public CustomFlutterElement SpecificationHeader;
//
//    @FindBy(locator = "coverWear.position.header")
//    public CustomFlutterElement positionHeader;
//    @FindBy(locator = "coverWear.list.header")
//    public CustomFlutterElement coverWearHeader;

//    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Site\\\"}\"}")
//    public CustomFlutterElement siteLabel;
//
//    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Conveyor\\\"}\"}")
//    public CustomFlutterElement conveyorLabel;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Number of Data Points\\\"}\"}")
    public CustomFlutterElement noOfDataPointsLabel;
    @FindBy(locator = "CoverWear.ddl.standard")
    public CustomFlutterElement standardDdlValue;
    @FindBy(locator = "CoverWear.ddl.every")
    public CustomFlutterElement everyDdlValue;

    @FindBy(locator = "CoverWear.ddl.custom")
    public CustomFlutterElement customDdlValue;

    @FindBy(locator = "coverWear.position.addBtn")
    public CustomFlutterElement addNewPosition;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_name\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"position_70_top\\\"}\"}")
    public CustomFlutterElement searchedPositionName;

    @FindBy(locator = "coverWear.addPosition.popHeader")
    public CustomFlutterElement addPositionHeader;
    @FindBy(locator = "coverWear.addPosition.segementName")
    public CustomFlutterElement addSegementName;
    @FindBy(locator = "coverWear.addPosition.topBtn")
    public CustomFlutterElement addPositonTop;
    @FindBy(locator = "coverWear.addPosition.bottomBtn")
    public CustomFlutterElement addPositonBottom;

    @FindBy(locator = "coverWear.addPosition.tonsConveyed")
    public CustomFlutterElement addTonsConveyed;

    @FindBy(locator = "coverWear.addPosition.shoreADuromater")
    public CustomFlutterElement addShoreADuromater;

    @FindBy(locator = "CoverWear.durometer.label")
    public CustomFlutterElement durometerLabel;

    @FindBy(locator = "CoverWear.priceOfBelt.label")
    public CustomFlutterElement priceOfBeltLabel;
    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Top Cover Compound\\\"}\"}")
    public CustomFlutterElement topCoverCompoundLabel;
    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Bottom Cover Compound\\\"}\"}")
    public CustomFlutterElement bottomCoverCompoundLabel;
    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Top Cover Thickness Nominal\\\"}\"}")
    public CustomFlutterElement topCoverThicknessLabel;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Bottom Cover Thickness Nominal\\\"}\"}")
    public CustomFlutterElement bottomCoverThicknessLabel;

    @FindBy(locator ="CoverWear.installation.deviceInfo")
    public CustomFlutterElement deviceInfoHeader;
    @FindBy(locator ="CoverWear.instrument.label")
    public CustomFlutterElement tbInstrument;
    @FindBy(locator ="CoverWear.velocity.label")
    public CustomFlutterElement tbVelocity;
    @FindBy(locator ="CoverWear.surfaceTemp.label")
    public CustomFlutterElement tbSurfaceTemperature;
    @FindBy(locator ="CoverWear.button.saveDraft")
    public CustomFlutterElement btnSaveDraft;

    @FindBy(locator = "CoverWear.addNewMeasurement.button")
    protected CustomFlutterElement addMeasurementButton;

    @FindBy(locator = "CoverWear.addNewMeasurement.header")
    protected CustomFlutterElement addMeasurementHeader;



    public void goToCoverWearViaConveyor(String conveyor) {
        ConveyorPage.getInstance().conveyorDetailsNav(conveyor);
        DashboardNativePage.getInstance().goToCoverWear();
    }

    public boolean isCoverWearPage() {
        Validator.assertTrue(coverWearHeader.isPresent(),"user navigated to coverWear list page","user navigated to coverWear list page");
        return coverWearHeader.isPresent();
    }

    public boolean fillCoverWearSpecs(){
        beltWidth.sendKeys("8");
        System.out.println(beltLength.getElementProperties());
        beltLength.sendKeys("5");
        topCoverThickness.scrollIntoView("Top cover");
        topCoverThickness.click();
        search.sendKeys("1");
        DashboardNativePage.getInstance().selectFirstSearch();
        bottomCoverThickness.scrollIntoView("Bottom cover");
        bottomCoverThickness.click();
        search.sendKeys("3");
        DashboardNativePage.getInstance().selectFirstSearch();
        durometer.scrollIntoView("Durometer");
        durometer.sendKeys("50");
        topCoverCompound.scrollIntoView("Top compound");
        topCoverCompound.click();
        search.sendKeys("ALUMINA HOT");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();
        bottomCoverCompound.scrollIntoView("Bottom compound");
        bottomCoverCompound.click();
        search.sendKeys("ALUMINA HOT");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();
        dateOfInstallation.click();
        DashboardNativePage.getInstance().selectCalenderDate();
        saveBtn.click();
        return successMsgSpecs.isVisible("Specs Message");
    }
   public void clickAndVerifyDeleteOption()
   {
       coverWearMoreBtn.waitForTheElementToBeVisible(10000);
       coverWearMoreBtn.click();
       coverWearDeleteBtn.click();

   }
    public void verifyCoverWearDetails(){
        positionHeader.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionHeader.isDisplayed(),"User is not navigated to position listing screen","User is not navigated to position listing screen");
    }

    public void goToCoverWearDetails() {
        DashboardNativePage.getInstance().navigateInsideConveyor();
        verifyCoverWearDetails();
    }
    public void verifyPositionCount()
    {
        positionCount.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionCount.isVisible(),"CoverWear count is not displayed in the home page card","CoverWear count is displayed in the home page coverWear card");
    }

    public void longPressOnPosition()
    {
        firstPosition.waitForTheElementToBeVisible(10000);
        firstPosition.longPress("position");
    }
    public void verifyGaugeTileAndTileDetails()
    {
        waitForPageToLoad();
        positionGaugeTile.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionGaugeTile.isVisible(),"Gauge tile is not visible in position listing screen","Gauge tile is  visible in position listing screen");
//        Validator.assertTrue(remainingCoverValue.isVisible(),"Remaining cover % is not visible in gauge tile","Remaining cover % is  visible in gauge tile");
        Validator.assertTrue(durometerValue.isVisible(),"Durometer Reading  is not visible in gauge tile","Durometer Reading is  visible in gauge tile");
        Validator.assertTrue(remainingLifeValue.isVisible(),"Remaining life  is not visible in gauge tile","Remaining life  is not visible in gauge tile");
        bottomCoverCompoundField.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(bottomCoverCompoundField.isVisible(),"Bottom cover compound  is not visible in gauge tile","Bottom cover compound is  visible in gauge tile");
        Validator.assertTrue(topCoverCompoundField.isVisible(),"Top cover compound is not visible in gauge tile","Top cover compound is  visible in gauge tile");
        Validator.assertTrue(estimatedFailureField.isVisible(),"Estimated failure date is not visible in gauge tile","Estimated failure date is  visible in gauge tile");
        Validator.assertTrue(dateOfInstallationField.isVisible(),"Date of installation is not visible in gauge tile","Date of installation  is  visible in gauge tile");
        Validator.assertTrue(noOfSectionsField.isVisible(),"No. of sections is not visible in gauge tile","No. of sections is  visible in gauge tile");
    }

    public void verifyTopPositionDetails()
    {

        positionFirstName.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionFirstName.isVisible(),"Position name and installed date is not present","Position name and installed date is  present");
        positionFirstRemainingLife.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionFirstRemainingLife.isVisible(),"Position remainingLife and Cover thickness left/total cover thickness is not present","Position remainingLife and Cover thickness left/total cover thickness is  present");
        positionDurometerLife.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionDurometerLife.isVisible(),"Durometer reading  is not present","Durometer reading  is not present is  present");
        positionMeasurementCount.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionMeasurementCount.isVisible(),"Position measurement count  is not present","Position measurement count  is  present");
        positionUploadStatus.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionUploadStatus.isVisible(),"Position upload status is not present","Position upload status is  present");

    }

    public void verifyBottomPositionDetails()
    {
        positionBottomName.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionBottomName.isVisible(),"Bottom position name and installed date is not present","Bottom position  and installed date is  present");
        positionBottomRemainingLife.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionBottomRemainingLife.isVisible(),"Bottom position  remainingLife and Cover thickness left/total cover thickness is not present","Bottom position  remainingLife and Cover thickness left/total cover thickness is  present");
        positionBottomDurometerLife.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionBottomDurometerLife.isVisible(),"Bottom position durometer reading  is not present","Bottom position durometer reading  is not present is  present");
        positionBottomMeasurementCount.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionBottomMeasurementCount.isVisible(),"Bottom position  measurement count  is not present","Bottom position measurement count  is  present");
        positionBottomUploadStatus.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionBottomUploadStatus.isVisible(),"Bottom position upload status is not present","Bottom position upload status is  present");

    }

    public void goToCoverWearSpecification()
    {
        waitForPageToLoad();
        positionGaugeTile.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionGaugeTile.isVisible(),"Gauge tile is not visible in position listing screen","Gauge tile is  visible in position listing screen");
        positionGaugeTile.click();
        Validator.assertTrue(SpecificationHeader.isDisplayed(),"User is not navigated to coverWear specification screen","User is navigated to coverWear specification screen");
    }

    public void verifySpecificationDefaultValues(String siteName,String conveyorName,String beltWidth,String beltLength)
    {
        siteLabel.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(siteLabel.getText().contains(siteName),"Default site name is not displayed","Default site name is displayed");

        conveyorLabel.waitForTheElementToBeVisible(10000);
        conveyorLabel.scrollToElement(conveyorLabel, DIRECTION.UP);
        Validator.assertTrue(conveyorLabel.getText().contains(conveyorName),"Default conveyor name is not displayed","Default conveyor name is displayed");

//        beltWidthLabel.waitForTheElementToBeVisible(10000);
//        beltWidthLabel.scrollToElement(beltWidthLabel, DIRECTION.DOWN);
//        System.out.println(beltWidthLabel.getText()+"beltWidthLabel");
//        Validator.assertTrue(beltWidthLabel.getText().contains(beltWidth),"Default beltWidth is not displayed","Default beltWidth is displayed");

//      beltLengthLabel.waitForTheElementToBeVisible(10000);
//      System.out.println(beltWidthLabel.getText()+"beltWidthLabel");
//      Validator.assertTrue(beltLengthLabel.getText().contains(siteName),"Default beltLength is not displayed","Default beltLength is displayed");
    }
    public void positionClick()
    {
        positionBottomName.waitForTheElementToBeVisible(10000);
        positionBottomName.click();
        waitForPageToLoad();

    }
    public void verifyIsPositionDetailScreen(String position)
    {
        positionDetailsHeader.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(positionDetailsHeader.isVisible(),"User is navigated to the position details screen","User is navigated to the position details screen");
        Validator.assertTrue(positionDetailsHeader.getText().equalsIgnoreCase(position),"Position header is not displayed as expected","\"Position header is displayed as expected\"");
    }
    public void verifyDefaultInstallationAndHeader()
    {
        tempAdjustedMeasureHeader.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(tempAdjustedMeasureHeader.isVisible(),"Temperature adjusted measurement header is not visible","Temperature adjusted measurement header is not visible");
        defaultInstallation.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(defaultInstallation.isVisible(),"Default Installation is not visible","Default Installation header is  visible");
        Validator.assertTrue(CoverWearNativePage.getInstance().verifyEditButtonIsVisible(),"Edit button for installation is visible","Edit button for installation is visible");
    }

    public void verifyNoOfDataPointsDdl()
    {
        noOfDataPointsLabel.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(noOfDataPointsLabel.getText().contains("Standard(7)"),"No of data points ddl does not contains Standard(7) as default value","No of data points ddl contains Standard(7) as default value");
        noOfDataPointsLabel.click();
        standardDdlValue.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(standardDdlValue.isVisible() && everyDdlValue.isVisible() &&customDdlValue.isVisible(),
                "All the dropdown values for number of data points are not visible","All the dropdown values for number of data points are visible");
    }

    public void addDurometerAndPriceOfBeltValues(String durometer,String priceOfBelt)
    {
        durometerLabel.waitForTheElementToBeVisible(10000);
        durometerLabel.clear();
        durometerLabel.sendKeys(durometer,"durometer value");
        priceOfBeltLabel.clear();
        priceOfBeltLabel.sendKeys(priceOfBelt,"price of the belt");
    }

    public void verifyTopAndBottomCoverCompounds(String topCoverCompound,String bottomCoverCompound)
    {
        topCoverCompoundLabel.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(topCoverCompoundLabel.getText().contains(topCoverCompound),"Top Cover compound does not have default values","Top Cover compound has default values");
        bottomCoverCompoundLabel.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(bottomCoverCompoundLabel.getText().contains(topCoverCompound),"Bottom Cover compound does not have default values","Bottom Cover compound has default values");
    }
    public boolean enterDateOfInstallationandSave()
    {
        dateOfInstallation.waitForTheElementToBeVisible(10000);
        dateOfInstallation.click();
        DashboardNativePage.getInstance().selectCalenderDate();
        saveBtn.scrollToElement(dateOfInstallation, DIRECTION.DOWN, "Save Btn");
        saveBtn.waitForTheElementToBeVisible(10000);
        saveBtn.click();
        SyncUtil.waitFor(5000);
        return positionHeader.isVisible("Specs Message");
    }

    public void clickAddPositionBtn() {
        Validator.assertTrue(addNewPosition.isPresent(),"Add New Position Button is not visbile","Add New Position Button is visbile");
        addNewPosition.click();
    }
    public void clickAndVerifySearchPosition(String position) {
        DashboardNativePage.getInstance().goToSearch();
        DashboardNativePage.getInstance().enterSearchQuery(position);
        Validator.assertTrue(searchedPositionName.isVisible(),"Searched position is not visible","Searched position is visbile");
    }
    public void addNewPositionDetails(String segment,String tonsConveyed,String shoreADurometer) {
        addPositionHeader.waitForTheElementToBeVisible(5000);
        Validator.assertTrue(addPositionHeader.isVisible(),"Add Position Pop up is not visible","Add Position Pop up is visible");
        addSegementName.sendKeys(segment);
        addPositonTop.click();
        addTonsConveyed.sendKeys(tonsConveyed);
        addShoreADuromater.sendKeys(shoreADurometer);
        saveBtn.click();
    }
    public void saveDraftBtnClick()
    {
        btnSaveDraft.waitForTheElementToBeVisible(10000);
        btnSaveDraft.click();
        SyncUtil.waitFor(10000);

    }
    public void editDeviceInfoDetails(String instrument,String velocity,String surfaceTemperature)
    {
        deviceInfoHeader.waitForTheElementToBeVisible(10000);
        deviceInfoHeader.click();
        tbInstrument.waitForTheElementToBeVisible(10000);
        tbInstrument.sendKeys(instrument,"instrument/deviceType");
        tbVelocity.sendKeys(velocity,"velocity");
        tbSurfaceTemperature.sendKeys(surfaceTemperature,"surfaceTemperature");
        saveDraftBtnClick();
    }
    public void editInstallation(String instrument,String velocity,String surfaceTemperature)
    {
        Validator.assertTrue(CoverWearNativePage.getInstance().verifyEditButtonIsVisible(),"Edit button for installation is visible","Edit button for installation is visible");
        CoverWearNativePage.getInstance().editBtnClick();
        editDeviceInfoDetails(instrument,velocity,surfaceTemperature);
        DashboardNativePage.getInstance().backBtnClick();

    }
    public void deleteMeasurementConfirm()
    {
        SyncUtil.waitFor(10000);
        coverWearDeleteBtn.click();
        SyncUtil.waitFor(5000);
    }
    public void deleteMeasurement()
    {
        Validator.assertTrue(CoverWearNativePage.getInstance().verifyDeleteBtnIsVisible(),"Delete button is not visible","Delete button is visible");
        CoverWearNativePage.getInstance().deleteBtnClick();
        deleteMeasurementConfirm();
    }
    public void verifyAddNewMeasurementBtn()
    {
//        addMeasurementButton.waitForTheElementToBeVisible(10000);
        addMeasurementButton.click();
        waitForPageToLoad();
        Validator.assertTrue(addMeasurementHeader.isDisplayed(),"User is not in add new position page","User is in add new position page");

    }

}
