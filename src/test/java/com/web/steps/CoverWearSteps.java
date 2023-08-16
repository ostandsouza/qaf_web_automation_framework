package com.web.steps;

import com.common.utils.MiscUtils;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.ConveyorPage;
import com.web.pages.CoverWearPage;
import org.json.simple.parser.ParseException;

public class CoverWearSteps {

    CoverWearPage coverWearPage = new CoverWearPage();
    ConveyorPage conveyorPage = new ConveyorPage();

    @QAFTestStep(description="Add Cover Wear for conveyor {ConveyorName} and site {CustSiteName} with data {FullName} {PositionName} {TopCoverThickness} {BottomCoverThickness} {Durometer} {TopCoverCompound} {BottomCoverCompound}")
    public void createCoverWearMeasurement(String conveyorName, String custSiteName, String fullName, String positionName, String topCoverThickness, String bottomCoverThickness, String durometer, String topCoverCompound, String bottomCoverCompound){
        String conveyorId= coverWearPage.apiBase.getConveyorsAPI(conveyorName);
        String ultrasonicId=coverWearPage.apiBase.getUltrasonicId(coverWearPage.apiBase.getUltrasonicAPI(conveyorId));
        coverWearPage.apiBase.deleteUltrasonicAPI(ultrasonicId);
        coverWearPage.goToCoverWearScreen();
        coverWearPage.addNewMeasurement(conveyorName, custSiteName,positionName,topCoverThickness,bottomCoverThickness,durometer,topCoverCompound,bottomCoverCompound);
    }

    @QAFTestStep(description="Verify Cover wear measurement for conveyor {ConveyorName}")
    public void verifyCoverWearMeasurement(String conveyorName){
        coverWearPage.searchCoverWear(conveyorName);
    }

    @QAFTestStep(description="Add Cover wear position for conveyor {ConveyorName} with data {SegmentName} {TopBottom} {TonsCovered} {PositionDurometer}")
    public void addCoverWearPosition(String conveyorName, String segmentName, boolean topBottom, String tonsCovered, String positionDurometer){
        coverWearPage.goToCoverWearDetailScreen(conveyorName);
        coverWearPage.addPosition(segmentName,topBottom,tonsCovered,positionDurometer);
    }

    @QAFTestStep(description="Verify Cover wear position for conveyor {ConveyorName} and segment {SegmentName} with durometer as {PositionDurometer}")
    public void verifyCoverWearPositionForConveyorAndSegmentWithDurometer(String conveyorName, String segmentName, String positionDurometer){
        coverWearPage.goToCoverWearDetailScreen(conveyorName);
        coverWearPage.verifyPosition(segmentName, positionDurometer);
    }

    @QAFTestStep(description="Edit Cover wear position for conveyor {ConveyorName} with data {SegmentName} to {EditSegmentName}")
    public void editCoverWearPosition(String conveyorName, String segmentName, String editSegmentName){
        coverWearPage.goToCoverWearDetailScreen(conveyorName);
        coverWearPage.editPosition(segmentName, editSegmentName);
    }

    @QAFTestStep(description="Delete Cover wear position for conveyor {ConveyorName} with data {EditSegmentName}")
    public void deleteCoverWearPosition(String conveyorName, String segmentName){
        coverWearPage.goToCoverWearDetailScreen(conveyorName);
        coverWearPage.deletePosition(segmentName);
    }

    @QAFTestStep(description="Verify Delete Cover wear position for conveyor {ConveyorName} and segment {EditSegmentName}")
    public void verifyCoverWearPosition(String conveyorName, String segmentName){
        coverWearPage.goToCoverWearDetailScreen(conveyorName);
        coverWearPage.verifyDeletePosition(segmentName);
    }

    @QAFTestStep(description="Navigation to Cover Wear Details Screen for conveyor {ConveyorName}")
    public void verifyCoverWearSpecsNav(String conveyorName){
        coverWearPage.goToCoverWearDetailScreen(conveyorName);
    }

    @QAFTestStep(description="Edit Cover wear measurement for conveyor {ConveyorName}")
    public void editCoverWearMeasurement(String conveyorName){
        coverWearPage.editMeasurement(conveyorName);
    }

    @QAFTestStep(description="Delete Cover wear measurement for conveyor {ConveyorName}")
    public void deleteCoverWearMeasurement(String conveyorName){
        coverWearPage.deleteCoverWear(conveyorName);
    }

    @QAFTestStep(description="Verify Delete Cover wear measurement for conveyor {ConveyorName}")
    public void verifyDeleteCoverWearMeasurement(String conveyorName){
        coverWearPage.verifyCoverWearDelete(conveyorName);
    }

    @QAFTestStep(description="Navigate to cover wear listing screen and wait")
    public void verifyNavigationToCoverWearListingAndWait(){
        coverWearPage.goToCoverWearScreenAndWait();
        conveyorPage.goToConveyorListScreenAndWait();
        coverWearPage.goToCoverWearScreenAndWait();
    }

    @QAFTestStep(description="Navigate to cover wear listing screen")
    public void verifyNavigationToCoverWearListing(){
        coverWearPage.goToCoverWearScreen();
    }

    @QAFTestStep(description="Verify mandatory parameter for add measurement {ConveyorName}")
    public void verifyMandatoryParameters(String conveyorName){
        String conveyorId= coverWearPage.apiBase.getConveyorsAPI(conveyorName);
        String ultrasonicId=coverWearPage.apiBase.getUltrasonicId(coverWearPage.apiBase.getUltrasonicAPI(conveyorId));
        coverWearPage.apiBase.deleteUltrasonicAPI(ultrasonicId);
        coverWearPage.goToAddMeasurement();
        coverWearPage.verifyErrorMessage();
    }

    @QAFTestStep(description="Go to add measurement window")
    public void verifyAddMeasurementWindow(){
        coverWearPage.goToAddMeasurement();
    }

    @QAFTestStep(description="Select site from dropdown with {CustSiteName}")
    public void verifySiteSelection(String siteNmae){
        coverWearPage.selectSiteDropdown(siteNmae);
    }

    @QAFTestStep(description="Look for conveyor dropdown with {ConveyorName}")
    public void verifyConveyorSelection(String conveyorName){
        coverWearPage.verifyConveyorDropdown(conveyorName);
    }

    @QAFTestStep(description="Verify add position navigation for {Position} and {Count}")
    public void verifyAddPositionNavigation(String position,String count){
        coverWearPage.addPositionNavigation(position, count);
        coverWearPage.verifySpecificationScreen();
    }

    @QAFTestStep(description="Verify existing position for {Position} and {Count}")
    public void verifyExistingPositionSelection(String position,String count){
        coverWearPage.addPositionNavigation(position, count);
    }

    @QAFTestStep(description="Data point is select as {Standard}")
    public void dataPointSelection(String dataPoint){
        coverWearPage.selectDataPoint(dataPoint);
    }

    @QAFTestStep(description="Select Inspection date as {InspectionDate}")
    public void inspectionDateSelection(String date){
        coverWearPage.enterInspectionDate(date);
    }

    @QAFTestStep(description="Add measurement data {0} {1} {2} {3} {4} {5} {6}")
    public void addMeasurementData(String beltLength, String beltWidth, String topCoverThickness, String bottomCoverThickness, String positionDurometer, String topCoverCompound, String bottomCoverCompound){
        coverWearPage.addSpecification(beltLength,beltWidth,topCoverThickness,bottomCoverThickness,positionDurometer,topCoverCompound,bottomCoverCompound);
    }

    @QAFTestStep(description="Verify Inspector name is prefilled with {InspectorName}")
    public void verifyInspectorName(String inspectorName){
        coverWearPage.verifyInspectorField(inspectorName);
    }

    @QAFTestStep(description="Enter Temperature {Temperature} and verify")
    public void verifyTemperature(String temperature){
        coverWearPage.verifyTemperatureField(temperature);
    }

    @QAFTestStep(description="Enter measurement inspection date to current date")
    public void enterMeasurementDate(){
        coverWearPage.enterMeasurementDate();
    }

    @QAFTestStep(description="Verify the previous tons conveyor {TonsConveyedPreviously}")
    public void verifyPreviousTonConveyed(String tonsConveyedPreviously){
        coverWearPage.verifyPreviousTonsConveyed(tonsConveyedPreviously);
    }

    @QAFTestStep(description="Enter the current tons conveyor {TonsConveyed} and verify")
    public void verifyCurrentTonConveyed(String tonsConveyed){
        coverWearPage.verifyTonsConveyed(tonsConveyed);
    }

    @QAFTestStep(description="Verify dropdown behaviour with {Standard} and {Every} and {Custom}")
    public void verifyDataPointDropDown(String standard, String every, String custom){
        coverWearPage.verifyDataPointDropdownBehaviour(standard, every, custom);
    }

    @QAFTestStep(description="Verify file upload functionality with {0}")
    public void verifyFileUploadFunctionality(String fileName){
        coverWearPage.fileUploadMeasurement(fileName);
        coverWearPage.verifyImageUpload();
    }

    @QAFTestStep(description="Verify comments sections with {Comment}")
    public void verifyCommentsSection(String comment){
        coverWearPage.addAndVerifyComments(comment);
    }

    @QAFTestStep(description="Verify save functionality for new measurement")
    public void verifySaveMeasurement(){
        coverWearPage.verifySaveFunctionality();
    }

    @QAFTestStep(description="Verify measurement table for {InstallationDate} {PreviousMeasurementDate} {PreviousThickness}")
    public void verifyMeasurementTable(String installationDate, String previousMeasurementDate, String previousThickness){
        coverWearPage.verifyPreviousMeasurementTable(installationDate,previousMeasurementDate,previousThickness );
    }

    @QAFTestStep(description="Add new measurement for current date with {Thickness} and {Durometer}")
    public void verifyAddNewMeasurement(String thickness, String durometer){
        coverWearPage.verifyAdditionOfNewMeasurement(thickness, durometer);
    }

    @QAFTestStep(description="Verify Add and remove new measurement readings")
    public void verifyAddRemoveMeasurement(){
        coverWearPage.verifyAddNewReading();
        coverWearPage.verifyRemoveNewReading();
    }

    @QAFTestStep(description="Verify durometer shoreA score for {ConveyorName} in specification screen")
    public void verifyShoreAScoreSpecs(String conveyorName) throws ParseException {
        String conveyorId= coverWearPage.apiBase.getConveyorsAPI(conveyorName);
        long shoreA =coverWearPage.apiBase.getMinCalculatedDurometer(coverWearPage.apiBase.getUltrasonicAPI(conveyorId));
        coverWearPage.verifyShoreASpecs(shoreA);
    }

    @QAFTestStep(description="Verify remaining life by time for {ConveyorName} in specification screen")
    public void verifyRemainingLifeSpecs(String conveyorName) throws ParseException {
        String conveyorId= coverWearPage.apiBase.getConveyorsAPI(conveyorName);
        double val =coverWearPage.apiBase.getMinEstimatedTime(coverWearPage.apiBase.getUltrasonicAPI(conveyorId));
        coverWearPage.verifyRemainingLifeSpecs(val);
    }

    @QAFTestStep(description="Verify remaining cover percentage for {ConveyorName} in specification screen")
    public void verifyCoverPercentageSpecs(String conveyorName) throws ParseException {
        String conveyorId= coverWearPage.apiBase.getConveyorsAPI(conveyorName);
        double val =coverWearPage.apiBase.getMinPercentage(coverWearPage.apiBase.getUltrasonicAPI(conveyorId));
        coverWearPage.verifyRemainingCoverSpecs(val);
    }

    @QAFTestStep(description="Verify durometer shoreA score for {ConveyorName}")
    public void verifyShoreAScore(String conveyorName) throws ParseException {
        String conveyorId= coverWearPage.apiBase.getConveyorsAPI(conveyorName);
        long shoreA =coverWearPage.apiBase.getMinCalculatedDurometer(coverWearPage.apiBase.getUltrasonicAPI(conveyorId));
        coverWearPage.verifyShoreA(shoreA);
    }

    @QAFTestStep(description="Verify remaining life by time for {ConveyorName}")
    public void verifyRemainingLife(String conveyorName) throws ParseException {
        String conveyorId= coverWearPage.apiBase.getConveyorsAPI(conveyorName);
        double val =coverWearPage.apiBase.getMinEstimatedTime(coverWearPage.apiBase.getUltrasonicAPI(conveyorId));
        coverWearPage.verifyRemainingLife(val);
    }

    @QAFTestStep(description="Verify remaining cover percentage for {ConveyorName}")
    public void verifyCoverPercentage(String conveyorName) throws ParseException {
        String conveyorId= coverWearPage.apiBase.getConveyorsAPI(conveyorName);
        double val =coverWearPage.apiBase.getMinPercentage(coverWearPage.apiBase.getUltrasonicAPI(conveyorId));
        coverWearPage.verifyRemainingCover(val);
    }

    @QAFTestStep(description="Verify the download functionality in list screen for {FullName}")
    public void verifyDownloadAllRecords(String fullName) {
        coverWearPage.verifyDownloadFunctionality();
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("Cover_wear_summary_report.pdf"),"Cover wear summary report was not found","Cover wear summary report was downloaded successfully");
        coverWearPage.verifyPDFContents("Cover Wear - Conveyor Summary Report", fullName);
        MiscUtils.deleteDownloadedFiles("Cover_wear_summary_report.pdf");
    }

    @QAFTestStep(description="Verify after select cover wear record {0} action button is enabled")
    public void verifyAfterSelectingCoverWearActionButtonIsEnabled(String conveyorName){
        coverWearPage.searchCoverWear(conveyorName);
        coverWearPage.selectCoverWearRecord();
        Validator.assertTrue(coverWearPage.verifyActionBtnState(),"Action button is not enabled after selecting the cover wear record","Cover wear action button is enabled");
    }

    @QAFTestStep(description="Verify after selecting cover wear position {0} action button is enabled")
    public void verifyAfterSelectingCoverWearPositionActionButtonIsEnabled(String position){
        coverWearPage.searchPosition(position);
        coverWearPage.selectCoverWearRecord();
        Validator.assertTrue(coverWearPage.verifyActionBtnState(),"Action button is not enabled after selecting the cover wear record","Cover wear action button is enabled");
    }


    @QAFTestStep(description="Verify the contents of action dropdown for cover wear")
    public void verifyTheContentsOfActionDropdownForCoverWear(){
        Validator.assertTrue(coverWearPage.verifyActionDropDown(),"Cover Wear action dropdown contents missing","Cover Wear action dropdown verified successfully");
    }

    @QAFTestStep(description="Verify the contents of action dropdown for position")
    public void verifyActionsDropdownPosition(){
        Validator.assertTrue(coverWearPage.verifyActionDropDownForPosition(),"Position action dropdown contents missing","Position action dropdown verified successfully");
    }

    @QAFTestStep(description="Navigate to edit cover wear and verify navigation")
    public void verifyCoverWearEditNav(){
        Validator.assertTrue(coverWearPage.editCoverWearNavigation(),"After editing Cover Wear unable to see edit specifications","Cover Wear edit navigation is verified successfully");
    }

    @QAFTestStep(description="Edit durometer specification to {Durometer}")
    public void editSpecifications(String durometer){
        coverWearPage.editSpecifications(durometer);
    }

    @QAFTestStep(description="Verify the changes {Durometer} for cover wear {ConveyorName}")
    public void verifyEditChanges(String durometer, String conveyorName){
        coverWearPage.goToCoverWearDetailScreen(conveyorName);
        coverWearPage.verifyDurometerAfterEdit(durometer);
    }

    @QAFTestStep(description="Verify the changes {Durometer} for cover wear position {position}")
    public void verifyEditPosition(String durometer, String position){
        coverWearPage.searchPosition(position);
        coverWearPage.verifyPositionDurometerAfterEdit(durometer);
    }

    @QAFTestStep(description="Navigate to conveyor cover wear screen for {ConveyorName}")
    public void coverWearNavViaConveyor(String conveyorName){
        conveyorPage.goToConveyorDetailScreen(conveyorName);
        coverWearPage.verifyCoverWearViaConveyor();
    }

    @QAFTestStep(description="Download position report for date range {FromDate} to {ToDate}")
    public void downloadPositionReport(String fromDate, String toDate){
        coverWearPage.downloadPopup();
        coverWearPage.downloadPositionReport(fromDate,toDate);
    }

    @QAFTestStep(description="Verify the download functionality with {ConveyorName} and {CustSiteName} for {FullName}")
    public void verifyDownloadPositionReport(String conveyorName, String custSiteName, String fullName){
        Validator.assertTrue(MiscUtils.checkDownloadedFiles(conveyorName+"_"+custSiteName+".pdf"),"Cover wear position report was not found","Cover wear position report was downloaded successfully");
        coverWearPage.verifyPDFContents(conveyorName,custSiteName, fullName);
        coverWearPage.verifyPDFTopPosition(conveyorName,custSiteName);
        coverWearPage.verifyPDFBottomPosition(conveyorName,custSiteName);
        MiscUtils.deleteDownloadedFiles(conveyorName+"_"+custSiteName+".pdf");
    }

    @QAFTestStep(description="Verify whether the specifications is populated when no technical data is present for {ConveyorName} {CustSiteName}")
    public void verifySpecsWithNoTechnicalData(String conveyorName, String custSiteName){
        String conveyorId= coverWearPage.apiBase.getConveyorsAPI(conveyorName);
        String ultrasonicId=coverWearPage.apiBase.getUltrasonicId(coverWearPage.apiBase.getUltrasonicAPI(conveyorId));
        coverWearPage.apiBase.deleteUltrasonicAPI(ultrasonicId);
        conveyorPage.goToConveyorDetailScreen(conveyorName);
        coverWearPage.verifyCoverWearViaConveyor();
        Validator.assertTrue(coverWearPage.verifyCoverWearSpecs(conveyorName,custSiteName),"Incorrect default values are prefilled in specification screen","Correct default values are pre populated in specification page");
    }

    @QAFTestStep(description="Verify whether the specifications is populated when technical data is present for {ConveyorName} {CustSiteName} with {BeltLength} {BeltWidth} {TopCoverThickness} {BottomCoverThickness} {TopCoverCompound} {BottomCoverCompound}")
    public void verifySpecsWithTechnicalData(String conveyorName, String custSiteName, String beltLength, String beltWidth, String topCoverThickness, String bottomCoverThickness, String topCoverCompound, String bottomCoverCompound){
        conveyorPage.goToConveyorDetailScreen(conveyorName);
        coverWearPage.verifyCoverWearViaConveyor();
        Validator.assertTrue(coverWearPage.verifyCoverWearSpecs(conveyorName,custSiteName,beltLength,beltWidth,topCoverThickness,bottomCoverThickness,topCoverCompound,bottomCoverCompound),"Incorrect technical values are prefilled in specification screen","Correct technical values are pre populated in specification page");
    }

    @QAFTestStep(description="Navigate to position details screen for {Position}")
    public void verifyPositionDetailsNav(String position){
        coverWearPage.verifyPositionNav(position);
    }

    @QAFTestStep(description="Verify the download functionality with {ConveyorName} and {CustSiteName} for {FullName} from {FromDate} to {ToDate}")
    public void verifyDownloadPositionDetailReport(String conveyorName, String custSiteName, String fullName, String fromDate, String toDate){
        coverWearPage.verifyCloseDownloadWindow();
        coverWearPage.openDownloadPositionReportPopup();
        coverWearPage.dateRange(fromDate, toDate);
//        coverWearPage.verifyPositionDropdownContents();
        coverWearPage.verifyIncludeDropdownContents();
        coverWearPage.verifyCommentAndPhotos();
        coverWearPage.verifySaveBtn();
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("^"+conveyorName+"[a-zA-Z0-9_]+"+custSiteName+".pdf"),"Cover wear position report was not found","Cover wear position report was downloaded successfully");
        coverWearPage.verifyPDFContents(conveyorName,custSiteName, fullName);
        coverWearPage.verifyPDFTopPosition(conveyorName,custSiteName);
        MiscUtils.deleteDownloadedFiles("^"+conveyorName+"[a-zA-Z0-9_]+"+custSiteName+".pdf");
    }

    @QAFTestStep(description="Navigate to edit cover wear position and verify navigation")
    public void verifyPositionEditNav(){
        coverWearPage.editCoverWearPosNavigation();
    }

    @QAFTestStep(description="Edit durometer position to {Durometer}")
    public void verifyPositionEditDurometer(String durometer){
        coverWearPage.editPositionDurometer(durometer);
    }
}
