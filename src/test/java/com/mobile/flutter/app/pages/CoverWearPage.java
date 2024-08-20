package com.mobile.flutter.app.pages;

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
//        siteLabel.scroll(DIRECTION.UP,3500);
        siteLabel.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(siteLabel.getText().contains(siteName),"Default site name is not displayed","Default site name is displayed");
        conveyorLabel.waitForTheElementToBeVisible(10000);
        conveyorLabel.scrollToElement(conveyorLabel, DIRECTION.UP);
        Validator.assertTrue(conveyorLabel.getText().contains(conveyorName),"Default conveyor name is not displayed","Default conveyor name is displayed");
        beltWidthLabel.waitForTheElementToBeVisible(10000);
        beltWidthLabel.scrollToElement(beltWidthLabel, DIRECTION.DOWN);

        System.out.println(beltWidthLabel.getText()+"beltWidthLabel");
        Validator.assertTrue(beltWidthLabel.getText().contains(beltWidth),"Default beltWidth is not displayed","Default beltWidth is displayed");
//        beltLengthLabel.waitForTheElementToBeVisible(10000);
//        System.out.println(beltWidthLabel.getText()+"beltWidthLabel");

//        Validator.assertTrue(beltLengthLabel.getText().contains(siteName),"Default beltLength is not displayed","Default beltLength is displayed");
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

}
