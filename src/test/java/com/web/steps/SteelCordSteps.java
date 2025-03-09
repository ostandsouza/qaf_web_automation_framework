package com.web.steps;

import com.common.utils.MiscUtils;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.BasePage;
import com.web.pages.InspectionPage;
import com.web.pages.SteelCordPage;
import com.web.pages.SteelcordgeneratorPage;

public class SteelCordSteps extends BasePage {
	
	SteelCordPage steelpage = new SteelCordPage();


	@QAFTestStep(description="Navigate to the Steel Cord Splice Generator list page")
	public void navigateToTheSteelCordGenListPage(){
		steelpage.navigateSteelCordListPage();

	}
	@QAFTestStep(description="Navigate to the Steel Cord Splice Generator add page")
	public void navigateToTheSteelCordGenAddPage(){
		steelpage.navigateAddSteelCordPage();

	}
	@QAFTestStep(description="Create and Calculate The Steel Cord Splice with values {Market} {SpliceKit} {CustomerName} {ConveyorName} {ApproverName} {BeltRating} {BeltWidth} {TopCoverCompound} {BottomCoverCompound} {TopCoverThickness} {BottomCoverThickness} {OverAllBeltThickness} {CordDiameter} {CordPitch} {NumberOfCords}")
	public void createAndCalculateTheSteelCordSplice(String market,String spliceKit,String customerName,String conveyorName,String approverName,String beltRating,String beltWidth,String topCoverCompound,String bottomCoverCompound,String topCoverThickness,String bottomCoverThickness,String overAllBeltThickness,String cordDiameter,String cordPitch,String numberOfCords){
		steelpage.createAndCalculateSteelCordSplice(market,spliceKit,customerName,conveyorName,approverName,beltRating,beltWidth,topCoverCompound,bottomCoverCompound,topCoverThickness,bottomCoverThickness,overAllBeltThickness,cordDiameter,cordPitch,numberOfCords);
	}

	@QAFTestStep(description = "Click on calculate button and verify preview tab is displayed")
	public void calculateAndVerifyPreviewTab() {
		steelpage.calculateBtnClick();
		steelpage.verifyPreviewTab();
	}

	@QAFTestStep(description = "Verify the Preview Design tab header with values for Steel Cord {BeltWidth} {BeltRating} {TopCoverThickness} {BottomCoverThickness} {TopCoverCompound}")
	public void verifyThePreviewHeaderForSteelCord(String beltWidth,String beltRating, String topCoverThickness, String bottomCoverThickness,String topCoverCompoundName) {
		steelpage.verifyPreviewDesignHeaderForSteelCord(beltWidth,beltRating, topCoverThickness, bottomCoverThickness,topCoverCompoundName);
	}
	@QAFTestStep(description = "Verify the Preview Design tab dimensions calculation values for Steel Cord {NoOfSteps} {BeltWidth} {OverAllBeltThickness} {SplicePattern} {SpliceType} {NumberOfRepeatsA} {NumberOfRepeatsB} {CoverCut} {CordButtGap} {TransitionLength} {BiasLength} {BiasAngle} {StepLength} {SpliceLength} {OverAllSpliceLength}")
	public void verifyThePreviewDimensionsForSteelCord(String noOfSteps,String beltWidth,String overallThickness,String splicePattern,String spliceType,String numberOfRepeatsA,String numberOfRepeatsB,String coverCut, String cordButtGap, String transitionLength, String biasLength, String biasAngle,String stepLength,String spliceLength,String overallSpliceLength) {
		steelpage.verifyPreviewDesignDimensionForSteelCord(noOfSteps,beltWidth,overallThickness,splicePattern,spliceType,numberOfRepeatsA,numberOfRepeatsB,coverCut,cordButtGap,transitionLength,biasLength,biasAngle,stepLength,spliceLength,overallSpliceLength);
	}
	@QAFTestStep(description = "Verify the Preview Design tab Table and Note values for Steel Cord {CordDiameterBelt} {CordDiameterSplice} {NoOfCordsBelt} {NoOfCordsSplice} {CordSpacingBelt} {CordSpacingSplice} {CordPitchBelt} {CordPitchSplice} {AllDimension}")
	public void verifyThePreviewDesignTableAndNoteForSteelCord(String cordDiameterBelt,String cordDiameterSplice,String noOfCordsBelt,String noOfCordsSplice,String cordSpacingBelt,String cordSpacingSplice,String cordPitchBelt,String cordPitchSplice,String allDimension){
		steelpage.verifyPreviewDesignTableAndNoteForSteelCord(cordDiameterBelt,cordDiameterSplice,noOfCordsBelt,noOfCordsSplice,cordSpacingBelt,cordSpacingSplice,cordPitchBelt,cordPitchSplice,allDimension);
	}
	@QAFTestStep(description = "Navigate to Vulcanization Chart Tab and verify calculation values {Temperature} {Pressure} {VulcanizationTime}")
	public void verifyThePreviewVulcanizationForSteelCord(String temperature,String pressure,String valcanizationTime){
		steelpage.verifyPreviewVulcanizationForSteelCord(temperature,pressure,valcanizationTime);
	}
	@QAFTestStep(description = "Navigate to Comment Log and verify calculation values")
	public void verifyThePreviewCommentLogForSteelCord(){
		steelpage.verifyPreviewCommentLogForSteelCord();
	}

	@QAFTestStep(description = "Click on Comments log and save as draft")
	public void clickCommentsLogAndSaveAsDraft() {
		steelpage.commentLogClick();
		steelpage.saveDraftBtnClick();
	}

	@QAFTestStep(description = "Search for steel cord design and verify the status of the design {Status}")
	public void addCommentsAndSendForReviewForSteelCord(String status) {
		steelpage.verifyDesignStatus(status);
	}

	@QAFTestStep(description = "Navigate to edit the Steel Cord Design")
	public void editTheSteelCord() {
		steelpage.editRecord();
		steelpage.verifyEditPageNavigationSteelCord();
	}

	@QAFTestStep(description = "Click on Comments Log tab and add comments {Comments} and send For Review")
	public void verifyCommentsLog(String comments) {
		steelpage.clickAndVerifyCommentsLog(comments);
		steelpage.btnReviewClick();
	}
	@QAFTestStep(description = "Click on view icon")
	public void clickOnTheViewIcon() {
		steelpage.clickViewIcon();
	}
	@QAFTestStep(description = "Click on Comments Log tab and add approve comments {ApproveComments} and approve")
	public void verifyTheApproveCommentsLogFun(String comments) {
		steelpage.clickAndVerifyApproverCommentsLog(comments);
		steelpage.btnApproveClick();
	}
	@QAFTestStep(description = "Verify pdf download functionality for Splice Design with {CustomerName} {ConveyorName}")
	public void verifyThePdfDownloadForSpliceDesign(String siteName,String conveyorName) {
		steelpage.verifyDownloadPDFSpliceDesign(siteName,conveyorName);
	}
	@QAFTestStep(description = "Verify delete functionality for Splice Design")
	public void verifyTheDeleteFunForSpliceDesign() {
		steelpage.verifyDeleteFunForSpliceDesign();
	}
	@QAFTestStep(description="Navigate to the Belt Info Steel list page")
	public void navigateToTheBeltInfoSteelGenListPage(){
		steelpage.navigateBeltInfoSteelListPage();
	}

}
