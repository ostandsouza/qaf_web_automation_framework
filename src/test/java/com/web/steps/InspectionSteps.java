package com.web.steps;

import com.common.utils.MiscUtils;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.InspectionPage;
import com.web.pages.LoginPage;

public class InspectionSteps {

	InspectionPage inspectionpage = new InspectionPage();
	
	@QAFTestStep(description="Select Inspection on the Navigation Pane")
	public void selectInspectionOnTheNavigationPane(){
		inspectionpage.goToInspection();
	}
	
	@QAFTestStep(description="Verify list page")
	public void verifyListPage(){
	   inspectionpage.verifyListPage();
	}
	
	@QAFTestStep(description="Add inspection Event for conveyor {ConveyorName} with {InspectionName} {CustSiteName} {FullName}")
	public void createAddInspection(String conveyorName, String inspectionName, String custSiteName, String fullName){
		String inspectionId = inspectionpage.apiBase.getInspectionAPI(inspectionName);
		inspectionpage.apiBase.deleteInspectionAPI(inspectionId);
		inspectionpage.goToInspection();
		inspectionpage.addInspection(conveyorName,inspectionName,custSiteName,fullName);
	}
	
	@QAFTestStep(description="Add inspection Item for conveyor for {InspectionName} with {AssetName} {AssetDetail} {FailureMode} {Condition} {Status}")
	public void createAddInspectionItem(String inspectionName, String assetName, String assetDetail, String failureMode, String condition, String status){
		inspectionpage.addInspectionItem(assetName, assetDetail, failureMode, condition, status);
	}

	@QAFTestStep(description="Verify And validate the changes for {InspectionName}")
	public void verifyInspectionItem(String inspectionName){
		inspectionpage.verifyInspection(inspectionName);
	}
	
	@QAFTestStep(description="Download inspection {InspectionName} from inspection list")
	public void downloadPDF(String inspectionName) {
		String inspectionId = inspectionpage.apiBase.getInspectionAPI(inspectionName);
		inspectionpage.searchInspection(inspectionName);
		inspectionpage.downloadPDF();
		Validator.assertTrue(MiscUtils.checkDownloadedFiles(inspectionId+".pdf"),"PDF report was not found","PDF report was downloaded successfully");
	}

	@QAFTestStep(description="Verify data displayed in report for {FullName} {CustSiteName} {ConveyorName} {InspectionName}")
	public void verifyDownloadPDF(String fullName, String custSIteName, String conveyorName, String inspectionName) {
		String inspectionId = inspectionpage.apiBase.getInspectionAPI(inspectionName);
		inspectionpage.verifyPDFContents(fullName, custSIteName, conveyorName,inspectionName,inspectionId);
		MiscUtils.deleteDownloadedFiles(inspectionId+".pdf");
	}

	@QAFTestStep(description="Delete inspection {InspectionName} from inspection list")
	public void InspectionDelete(String inspectionName) {
		inspectionpage.searchInspection(inspectionName);
	    inspectionpage.inspectionDelete();
	}

	@QAFTestStep(description="Verify inspection {InspectionName} is deleted from inspection list")
	public void verifyInspectionDelete(String inspectionName){
		inspectionpage.verifyDeleteInspection(inspectionName);
	}
}
