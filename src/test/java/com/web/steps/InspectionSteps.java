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
		inspectionId = inspectionpage.apiBase.getInspectionAPI(conveyorName);
		inspectionpage.apiBase.deleteInspectionAPI(inspectionId);
		inspectionpage.goToInspection();
		inspectionpage.addInspection(inspectionName,custSiteName,fullName);
	}
	
	@QAFTestStep(description="Add inspection Item for conveyor {ConveyorName} for {InspectionName} with {AssetName} {AssetDetail} {FailureMode} {Condition} {Status}")
	public void createAddInspectionItem(String conveyorName, String inspectionName,String assetName, String assetDetail, String failureMode, String condition, String status){
		inspectionpage.addInspectionItem(conveyorName,assetName, assetDetail, failureMode, condition, status);
	}

	@QAFTestStep(description="Verify And validate the changes for {InspectionName} with {ItemCount}")
	public void verifyInspectionItem(String inspectionName, String itemCount){
		inspectionpage.verifyInspection(inspectionName,itemCount);
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

	@QAFTestStep(description="Edit inspection Event from {InspectionName} to {EditInspectionName}")
	public void editInspectionName(String inspectionName, String editInspectionName){
		inspectionpage.editInspectionName(inspectionName,editInspectionName);
	}

	@QAFTestStep(description="Edit inspection Item status for {ConveyorName} to {EditStatus}")
	public void editInspectionItem(String inspectionName, String editStatus){
		inspectionpage.editInspectionItem(inspectionName,editStatus);
	}

	@QAFTestStep(description="Delete inspection Item for {ConveyorName1}")
	public void deleteInspectionItem(String inspectionName){
		inspectionpage.deleteInspectionItem(inspectionName);
		inspectionpage.saveInspectionEvent();
	}

	@QAFTestStep(description="Verify navigation to inspection tile")
	public void verifyInspectionTileNavigation(){
		inspectionpage.goToInspectionsFromTile();
	}

	@QAFTestStep(description="Navigate to inspection list screen")
	public void verifyInspectionListNavigation(){
		inspectionpage.goToInspection();
	}

	@QAFTestStep(description="Verify default view type is grouped view")
	public void verifyDefaultView(){
		inspectionpage.verifyDefaultViewSelection();
	}

	@QAFTestStep(description="Verify columns under group view")
	public void verifyGroupViewColumn(){
		inspectionpage.verifyDefaultViewColumns();
	}

	@QAFTestStep(description="Verify if is able to switch from group view to list view")
	public void verifySwitchView(){
		inspectionpage.verifySwitchView();
	}

	@QAFTestStep(description="Verify the columns under list view")
	public void verifyListViewColumn(){
		inspectionpage.verifyListViewColumns();
	}

	@QAFTestStep(description="Navigate to Add Inspection screen from list screen")
	public void verifyToAddInspectionNav(){
		inspectionpage.verifyAddInspectionFromList();
	}

	@QAFTestStep(description="Verify placeholder for inspection name")
	public void verifyPlaceHolder(){
		inspectionpage.verifyAddInspectionFromList();
	}

	@QAFTestStep(description="Verify default date in inspection date field")
	public void verifyInspectionDate(){
		inspectionpage.verifyDefaultInspectionDate();
	}

	@QAFTestStep(description="Verify conveyor {ConveyorName} selection from dropdown")
	public void verifyConveyorSelection(String conveyorName){
		inspectionpage.verifyConveyorSelection(conveyorName);
	}

	@QAFTestStep(description="Verify user is able to select collaborator {ConveyorName}")
	public void verifyCollaboratorSelection(String collaborator){
		inspectionpage.verifyCollaboratorSelection(collaborator);
	}

	@QAFTestStep(description="Verify all the default tile value displayed as '0'")
	public void verifyDefaultTitleCount(String val){
		Validator.assertTrue(inspectionpage.verifyDefaultTileCount(val),"Inspection default tile count is incorrect","Inspection default tile count verified successfully");
	}

	@QAFTestStep(description="Verify user is able to enter text in summary field")
	public void verifySummaryField(String val){
//		Validator.assertTrue(inspectionpage.verifySummaryField(val),"Inspection default tile count is incorrect","Inspection default tile count verified successfully");
	}

	@QAFTestStep(description="Verify user is able to maximize the summary window size")
	public void verifyMaximizeSummaryField(String val){
//		Validator.assertTrue(inspectionpage.verifySummaryField(val),"Inspection default tile count is incorrect","Inspection default tile count verified successfully");
	}

	@QAFTestStep(description="Verify the add new button is enabled/disabled")
	public void verifyAddNewBtn(String val){
//		Validator.assertTrue(inspectionpage.verifySummaryField(val),"Inspection default tile count is incorrect","Inspection default tile count verified successfully");
	}
}
