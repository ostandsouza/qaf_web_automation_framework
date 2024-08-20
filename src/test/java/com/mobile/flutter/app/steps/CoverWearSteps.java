package com.mobile.flutter.app.steps;

import com.mobile.flutter.app.pages.ConveyorPage;
import com.mobile.flutter.app.pages.CorporatePage;
import com.mobile.flutter.app.pages.CoverWearPage;
import com.mobile.flutter.app.pages.DashboardPage;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

public class CoverWearSteps {


    @QAFTestStep(description = "User navigates to cover wear from conveyor tile details with {ConveyorName} {CustCorpName} {CustSite}")
    public void verifyCoverWearNav(String conveyorName, String custCorp, String custSIte) {
        String conveyorId= CoverWearPage.getInstance().apiBase.getConveyorsAPI(conveyorName);
        if(conveyorId != null) {
            String ultrasonicId = CoverWearPage.getInstance().apiBase.getUltrasonicId(CoverWearPage.getInstance().apiBase.getUltrasonicAPI(conveyorId));
            CoverWearPage.getInstance().apiBase.deleteUltrasonicAPI(ultrasonicId);
        }
        CoverWearPage.getInstance().goToCoverWearViaConveyor(conveyorName);
    }

    @QAFTestStep(description = "Search for a conveyor {ConveyorName} and click on it and verify it navigates to conveyor home page")
    public void verifyCoverWearNavigation(String conveyorName) {
//        DashboardNativePage.getInstance().goToSearch();
//        DashboardNativePage.getInstance().enterSearchQuery(conveyorName);
        ConveyorPage.getInstance().conveyorDetailsNav(conveyorName);
//        ConveyorPage.getInstance().goToConveyorDetails();
    }

    @QAFTestStep(description = "Search for a conveyor {ConveyorName} and click on it and verify it navigates to position listing screen")
    public void searchCoverWearAndVerifyNavigation(String conveyorName) {
        DashboardNativePage.getInstance().goToSearch();
        DashboardNativePage.getInstance().enterSearchQuery(conveyorName);
        CoverWearPage.getInstance().goToCoverWearDetails();
    }

    @QAFTestStep(description = "Click on coverWear card in the home page")
    public void clickCoverWearTile() {
        DashboardPage.getInstance().coverWearTileClick();
    }

    @QAFTestStep(description = "Click on coverWear tile and verify user is navigated to Position listing screen of cover wear")
    public void clickAndVerifyCoverWearNav()
    {
        DashboardNativePage.getInstance().coverWearCardClick();
        CoverWearPage.getInstance().verifyCoverWearDetails();
    }

    @QAFTestStep(description = "Verify user is on home page by default")
    public void verifyIsHomePage() {
        DashboardPage.getInstance().isHomePage();
    }

    @QAFTestStep(description = "Fill Cover Wear specifications")
    public void verifyCoverWearSpecs() {
        CoverWearPage.getInstance().fillCoverWearSpecs();
    }

    @QAFTestStep(description = "Verify the default positions")
    public void verifyDefaultPositions() {
        DashboardNativePage.getInstance().verifyPositionCount();
        DashboardNativePage.getInstance().verifyPositionsValues();
    }
    @QAFTestStep(description = "Long press on the position {Position} and click on checkbox and verify it is selected")
    public void longPressAndClickCheckbox(String position) {
//        DashboardNativePage.getInstance().goToSearch();
//        DashboardNativePage.getInstance().enterSearchQuery(position);
        CoverWearPage.getInstance().longPressOnPosition();
        DashboardNativePage.getInstance().longPressAndClickcheckbox();
    }

    @QAFTestStep(description = "Click on three dots and select delete option and verify the position {Position} is deleted")
    public void clickAndVerifyPositionDeletion(String position) {
        CoverWearPage.getInstance().clickAndVerifyDeleteOption();
        DashboardNativePage.getInstance().goToSearch();
        DashboardNativePage.getInstance().enterSearchQuery(position);
        DashboardNativePage.getInstance().verifyPositionDeletion();
    }

    @QAFTestStep(description = "Look for the cover Wear tile and verify the count displayed")
    public void verifyCountInCoverWearCard()
    {
        DashboardNativePage.getInstance().verifyCoverWearCardCount();
        CoverWearPage.getInstance().verifyPositionCount();
    }
    @QAFTestStep(description = "Verify the gauge tile is present at the top and all the details are displayed in the tile")
    public void verifyGaugeTileAndDetails()
    {
       CoverWearPage.getInstance().verifyGaugeTileAndTileDetails();
    }
    @QAFTestStep(description = "Verify top/bottom position status and values displayed along the position")
    public void verifyTopBottomAndDetails()
    {
        CoverWearPage.getInstance().verifyTopPositionDetails();
        CoverWearPage.getInstance().verifyBottomPositionDetails();
    }
    @QAFTestStep(description = "Click on the gauge tile in the position screen and navigate to specification screen")
    public void clickAndNavigateToSpecification()
    {CoverWearPage.getInstance().goToCoverWearSpecification();}

    @QAFTestStep(description = "Verify that siteName {SiteName} conveyor {ConveyorName} beltWidth {BeltWidth} BeltLength {BeltLength} comes with default values and are non editable")
    public void verifyDefaultFieldsOfSpecification(String siteName,String conveyorName,String beltWidth,String beltLength)
    {
        //ask ostan abt validating
        CoverWearPage.getInstance().verifySpecificationDefaultValues(siteName,conveyorName,beltWidth,beltLength);}

    @QAFTestStep(description = "Click on any of the position {position} and verify it navigates to position details screen and verify the heading")
    public void  clickAndVerifyPositionDetailNav(String position)
    {
        CoverWearPage.getInstance().positionClick();
        CoverWearPage.getInstance().verifyIsPositionDetailScreen(position);
    }

    @QAFTestStep(description = "Verify temperature adjusted measurements header and default installation field with measurement date and edit link are visible")
    public void  verifyDefaultInstallation()
    {CoverWearPage.getInstance().verifyDefaultInstallationAndHeader();}

    @QAFTestStep(description = "Click on the edit button and verify user is able is edit installation {Instrument} {Velocity} {SurfaceTemperature} and verify user can delete measurement")
    public void editInstallationAndDeleteMeasurement(String instrument,String velocity,String surfaceTemperature)
    {
//        CoverWearPage.getInstance().editInstallation(String instrument,String velocity,surfaceTemperature)


    }

}
