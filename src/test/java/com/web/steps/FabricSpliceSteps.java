package com.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.FabricSplicePage;

public class FabricSpliceSteps {

    FabricSplicePage fabricSplicePage = new FabricSplicePage();

    @QAFTestStep(description = "User is at Add Fabric splice Screen")
    public void userAtFabricSplicePage() {
        fabricSplicePage.gotoAddFabricSpliceScreen();
    }

    @QAFTestStep(description = "Add a design with {DesignerName} {Market} {SpliceKit} {CustomerName} {ConveyorName} {ApproverName} {BeltConstruction}")
    public void addFabricSplice(String designerName, String market, String spliceKit, String customerName, String conveyorName, String approverName, String beltConstruction) {
        fabricSplicePage.addFabricSpliceDesign(designerName, market, spliceKit, customerName, conveyorName, approverName, beltConstruction);
    }

    @QAFTestStep(description = "Add the design details {BeltWidth} {BeltType} {TopCoverCompound} {BottomCoverCompound} {TopCoverThickness} {BottomCoverThickness} {OverAllBeltThickness} {BiasAngle}")
    public void addFabricSpliceDetails(String beltWidth, String beltType, String topCoverCompound, String bottomCoverCompound, String topCoverThickness, String bottomCoverThickness, String overallThickess, String biasAngle) {
        fabricSplicePage.addFabricSpliceDesignDetails(beltWidth, beltType, topCoverCompound, bottomCoverCompound, topCoverThickness, bottomCoverThickness, overallThickess, biasAngle);
    }

    @QAFTestStep(description = "Select Splice Type {SpliceType}")
    public void selectSpliceType(String spliceType) {
        fabricSplicePage.selectAndVerifySpliceType(spliceType);
    }

    @QAFTestStep(description = "Click on calculate button and verify preview tab is displayed")
    public void calculateAndVerifyPreviewTab() {
        fabricSplicePage.calculateBtnClick();
        fabricSplicePage.verifyFabricSplicePreviewTab();
    }

    @QAFTestStep(description = "Verify the Preview Design tab with calculations {NoOfSteps} {BeltWidth} {OverAllBeltThickness} {StepLength} {SpliceLength} {CoverStripeTop} {CoverStripeBottom} {BiasLength} {CoatedBreakerStrip} {BeltType} {TopCoverThickness} {BottomCoverThickness} {TopCoverCompoundName}")
    public void verifyPreviewDimensions(String noOfSteps, String beltWidth, String overallThickness, String stepLength, String spliceLength, String coverStripTop, String coverStripBottom, String biasLength, String coatedBreakerStrip, String beltType, String topCoverThickness, String bottomCoverThickness, String topCoverCompoundName) {
        fabricSplicePage.verifyFabricPreviewDesignDescription(noOfSteps, beltWidth, overallThickness, stepLength, spliceLength, coverStripTop, coverStripBottom, biasLength, coatedBreakerStrip, beltType, topCoverThickness, bottomCoverThickness, topCoverCompoundName);
    }

    @QAFTestStep(description = "Verify the Preview Design Notes with calculations {CureTemperature} {CurePressure} {CureTime} {DimensionUnit}")
    public void verifyPreviewNotes(String cureTemp, String curePressure, String cureTime, String dimensionUnit) {
        fabricSplicePage.verifyPreviewNotesValues(cureTemp, curePressure, cureTime, dimensionUnit);
    }

    @QAFTestStep(description = "Click on Splice kit BOM tab and verify")
    public void verifySpliceKitBom() {
        fabricSplicePage.clickAndVerifySpliceKitBOM();
    }

    @QAFTestStep(description = "Click on Comments Log tab and add comments {comments} and send For Review")
    public void verifyCommentsLog(String comments) {
        fabricSplicePage.clickAndVerifyCommentsLog(comments);
        fabricSplicePage.btnReviewClick();
    }

    @QAFTestStep(description = "Navigate to edit the fabric splice design")
    public void editTheFabricSplice() {
        fabricSplicePage.editRecord();
        fabricSplicePage.verifyEditPageNavigation();
    }

    @QAFTestStep(description = "Click on Comments log and save as draft")
    public void clickCommentsLogAndSaveAsDraft() {
        fabricSplicePage.commentLogClick();
        fabricSplicePage.saveDraftBtnClick();
    }

    @QAFTestStep(description = "Search for fabric-splice design and verify the status of the design {Status}")
    public void addCommentsAndSendForReview(String status) {
        fabricSplicePage.goToFabricListScreenAndWait();
        fabricSplicePage.verifyDesignStatus(status);
    }


    @QAFTestStep(description = "Click on view icon")
    public void clickOnTheViewBtn() {
        fabricSplicePage.clickViewBtn();
    }

    @QAFTestStep(description = "Click on Comments Log tab and add approve comments {ApproveComments} and approve")
    public void verifyTheApproveCommentsLogFun(String comments) {
        fabricSplicePage.clickAndVerifyApproverCommentsLog(comments);
        fabricSplicePage.btnApproveClick();
    }

    @QAFTestStep(description = "Verify pdf download functionality for Splice Design with {CustomerName} {ConveyorName}")
    public void verifyThePdfDownloadForSpliceDesign(String siteName, String conveyorName) {
        fabricSplicePage.verifyDownloadPDFSpliceDesign(siteName, conveyorName);
    }

    @QAFTestStep(description = "Verify delete functionality for Splice Design")
    public void verifyTheDeleteFunForSpliceDesign() {
        fabricSplicePage.verifyDeleteFunForSpliceDesign();
    }
}

