package com.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.CoverWearPage;

public class CoverWearSteps {

    CoverWearPage coverWearPage = new CoverWearPage();

    @QAFTestStep(description="Add Cover Wear for conveyor {ConveyorName} and site {CustSiteName} with data {FullName} {PositionName} {TopCoverThickness} {BottomCoverThickness} {Durometer} {TopCoverCompound} {BottomCoverCompound}")
    public void createCoverWearMeasurement(String conveyorName, String custSiteName, String fullName, String positionName, String topCoverThickness, String bottomCoverThickness, String durometer, String topCoverCompound, String bottomCoverCompound){
        String conveyorId= coverWearPage.apiBase.getConveyorsAPI(conveyorName);
        String ultrasonicId=coverWearPage.apiBase.getUltrasonicAPI(conveyorId);
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
}
