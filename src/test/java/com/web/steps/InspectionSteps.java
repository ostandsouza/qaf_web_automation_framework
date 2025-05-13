package com.web.steps;

import com.common.component.Condition;
import com.common.component.InspectionItemSequencing;
import com.common.component.Item;
import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.*;
import io.cucumber.java.bs.I;
import org.testng.Assert;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class InspectionSteps {

	InspectionPage inspectionpage = new InspectionPage();

	CorporatePage corpPage = new CorporatePage();
	UsersPage userPage=new UsersPage();
	CorporatePage corporatePage=new CorporatePage();
	ConveyorPage conveyorPage=new ConveyorPage();
	CoverWearPage coverWearPage = new CoverWearPage();
	InspectionItemSequencing sortingInspectionItem = new InspectionItemSequencing();

	@QAFTestStep(description="Select Inspection on the Navigation Pane")
	public void selectInspectionOnTheNavigationPane(){
		inspectionpage.goToInspection();
	}

	@QAFTestStep(description="Verify list page")
	public void verifyListPage(){
		inspectionpage.verifyListPage();
	}

	@QAFTestStep(description="Add inspection Event for conveyor {ConveyorName} with {InspectionName} {CustSiteName} {FullName}")
	public void addInspectionEventForConveyorWith(String conveyorName, String inspectionName, String custSiteName, String fullName){
//		String inspectionId = inspectionpage.apiBase.getInspectionAPI(inspectionName);
//		inspectionpage.apiBase.deleteInspectionAPI(inspectionId);
//		inspectionId = inspectionpage.apiBase.getInspectionAPI(conveyorName);
//		inspectionpage.apiBase.deleteInspectionAPI(inspectionId);
		sortingInspectionItem.clearItems();
		inspectionpage.goToInspection();
		inspectionpage.	addInspection(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName,custSiteName,fullName);
	}

	@QAFTestStep(description="Add inspection Event for conveyor {ConveyorName} with {InspectionName}")
	public void createAddInspection(String conveyorName, String inspectionName){

//		String inspectionId = inspectionpage.apiBase.getInspectionAPI(inspectionName);
//		inspectionpage.apiBase.deleteInspectionAPI(inspectionId);
//		inspectionId = inspectionpage.apiBase.getInspectionAPI(conveyorName);
//		inspectionpage.apiBase.deleteInspectionAPI(inspectionId);
		sortingInspectionItem.clearItems();
		inspectionpage.addInspection(inspectionName);
	}

	@QAFTestStep(description="Fill inspection Item mandatory parameter for conveyor {ConveyorName} for {InspectionName} with {AssetName} {AssetDetail} {FailureMode} {Condition} {Status}")
	public void fillMandatoryParameterItemDefault(String conveyorName, String inspectionName,String assetName, String assetDetail, String failureMode, String condition, String status){
		inspectionpage.addItemMandatoryField(conveyorName,assetName, assetDetail, failureMode, condition, status);
	}

	@QAFTestStep(description="Fill inspection Item optional parameter for conveyor {ConveyorName} for {InspectionName} with {observation} {recommendation} {address} {img}")
	public void fillMandatoryOptionalItemDefault(String conveyorName, String inspectionName, String observation, String recommendation, String address, String img){
		inspectionpage.addItemOptionalField(observation,recommendation,address,img);
	}

	@QAFTestStep(description="Fill inspection Item mandatory parameter for VMC conveyor {ConveyorName} for {InspectionName} with {AssetName} {AssetDetail} {FailureMode} {Condition} {Status}")
	public void fillMandatoryParameterItemVMC(String conveyorName, String inspectionName,String assetName, String assetDetail, String condition, String status, String observation){
		inspectionpage.addItemMandatoryFieldVMC(conveyorName,assetName, assetDetail, condition, status, observation);
	}

	@QAFTestStep(description="Fill inspection Item optional parameter for VMC conveyor {ConveyorName} for {InspectionName} with {recommendation} {address} {img}")
	public void fillMandatoryOptionalItemVMC(String conveyorName, String inspectionName,String recommendation, String address, String img){
		inspectionpage.addItemOptionalFieldVMC(recommendation,address,img);
	}

	@QAFTestStep(description="Add inspection Item for conveyor {ConveyorName} for {InspectionName} with {AssetName} {AssetDetail} {FailureMode} {Condition} {Status}")
	public void createAddInspectionItemMandatoryFields(String conveyorName, String inspectionName,String assetName, String assetDetail, String failureMode, String condition, String status){
		sortingInspectionItem.addItem(conveyorName, assetName, condition, status.equalsIgnoreCase("completed"));
		inspectionpage.addItemMandatoryField(conveyorName,assetName, assetDetail, failureMode, condition, status);
		inspectionpage.createInspectionItem();
	}

	@QAFTestStep(description="Add inspection Item for VMC conveyor {ConveyorName} for {InspectionName} with {AssetName} {AssetDetail} {Condition} {Status} {observation}")
	public void createAddInspectionItemMandatoryFieldVMC(String conveyorName, String inspectionName,String assetName, String assetDetail, String condition, String status, String observation){
		sortingInspectionItem.addItem(conveyorName, assetName, condition, status.equalsIgnoreCase("completed"));
		inspectionpage.addItemMandatoryFieldVMC(conveyorName,assetName, assetDetail, condition, status, observation);
		inspectionpage.createInspectionItem();
	}

	@QAFTestStep(description="Add inspection Item for VMC conveyor {ConveyorName} for {InspectionName} with {AssetName1} {AssetDetail1} {Condition1} {Status} {observation} {recommendation} {address} {img}")
	public void createAddInspectionItemOptionalFieldsVMC(String conveyorName, String inspectionName,String assetName, String assetDetail, String condition, String status, String observation, String recommendation, String address, String img){
		sortingInspectionItem.addItem(conveyorName, assetName, condition, status.equalsIgnoreCase("completed"));
		inspectionpage.addItemMandatoryFieldVMC(conveyorName,assetName, assetDetail, condition, status, observation);
		inspectionpage.addItemOptionalFieldVMC(recommendation,address,img);
		inspectionpage.createInspectionItem();
	}

	@QAFTestStep(description="Add inspection Item for conveyor {ConveyorName} for {InspectionName} with {AssetName1} {AssetDetail1} {FailureMode1} {Condition1} {Status} {observation} {recommendation} {address} {img}")
	public void createAddInspectionItemOptionalFields(String conveyorName, String inspectionName,String assetName, String assetDetail, String failureMode, String condition, String status, String observation, String recommendation, String address, String img){
		sortingInspectionItem.addItem(conveyorName, assetName, condition, status.equalsIgnoreCase("completed"));
		inspectionpage.addItemMandatoryField(conveyorName,assetName, assetDetail, failureMode, condition, status);
		inspectionpage.addItemOptionalField(observation,recommendation,address,img);
		inspectionpage.createInspectionItem();
	}

	@QAFTestStep(description="Verify And validate the changes for {InspectionName} with {ItemCount}")
	public void verifyInspectionItem(String inspectionName, String itemCount){
		sortingInspectionItem.clearItems();
		inspectionpage.verifyInspection(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName,itemCount);
		SyncUtil.waitFor(1000);
		sortingInspectionItem.addItems(inspectionpage.getRowData());
	}

	@QAFTestStep(description="Download inspection {InspectionName} from inspection list with {CustSiteName} {ConveyorName}")
	public void downloadPDF(String inspectionName, String custSIteName, String conveyorName) {
//		String inspectionId = inspectionpage.apiBase.getInspectionAPI(inspectionName);
		inspectionpage.searchInspection(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
		inspectionpage.downloadPDF();
		Validator.assertTrue(MiscUtils.checkDownloadedFiles(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName+".pdf"),"PDF report was not found","PDF report was downloaded successfully");
	}

	@QAFTestStep(description="Verify data displayed in report for {FullName} {CustSiteName} {ConveyorName} {InspectionName}")
	public void verifyDownloadPDF(String fullName, String custSIteName, String conveyorName, String inspectionName) {
		inspectionpage.verifyPDFContents(fullName, custSIteName, conveyorName,LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
		MiscUtils.deleteDownloadedFiles(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"-"+custSIteName+"-Multiple-"+inspectionName+".pdf");
	}

	@QAFTestStep(description="Delete inspection {InspectionName} from inspection list")
	public void InspectionDelete(String inspectionName) {
		inspectionpage.searchInspection(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
		inspectionpage.inspectionDelete();
	}

	@QAFTestStep(description="Verify inspection {InspectionName} is deleted from inspection list")
	public void verifyInspectionDelete(String inspectionName){
		inspectionpage.verifyDeleteInspection(inspectionName);
	}

	@QAFTestStep(description="Edit inspection Event from {InspectionName} to {EditInspectionName}")
	public void editInspectionName(String inspectionName, String editInspectionName){
		inspectionpage.editInspectionName(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName,LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+editInspectionName);
	}

	@QAFTestStep(description="Edit inspection Item status for {ConveyorName} {Asset} to {EditStatus}")
	public void editInspectionItem(String conveyorName, String assetName, String editStatus){
		sortingInspectionItem.updateItem(conveyorName, assetName, null, editStatus.equalsIgnoreCase("Completed"));
		inspectionpage.editInspectionItem(assetName,editStatus);
	}

	@QAFTestStep(description="Delete inspection Item for {ConveyorName1}")
	public void deleteInspectionItem(String inspectionName){
		inspectionpage.deleteInspectionItem(inspectionName);
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
		SyncUtil.waitFor(2000);
	}

	@QAFTestStep(description="Verify if is able to switch from list view to group view")
	public void verifyGroupSwitchView(){
		inspectionpage.verifyGroupSwitchView();
		SyncUtil.waitFor(2000);
	}

	@QAFTestStep(description="Verify the columns under list view")
	public void verifyListViewColumn(){
		inspectionpage.verifyListViewColumns();
	}

	@QAFTestStep(description="Navigate to add inspection screen")
	public void verifyAddInspectionNav(){
		inspectionpage.goToInspection();
		inspectionpage.verifyAddInspectionFromList();
		sortingInspectionItem.clearItems();
	}

	@QAFTestStep(description="Navigate to Add Inspection screen from list screen")
	public void verifyToAddInspectionNav(){
		inspectionpage.verifyAddInspectionFromList();
		sortingInspectionItem.clearItems();
	}

	@QAFTestStep(description="Verify placeholder for inspection name")
	public void verifyPlaceHolder(){
		inspectionpage.verifyPlaceHolderForInspectionName();
	}

	@QAFTestStep(description="Verify default date in inspection date field")
	public void verifyInspectionDate(){
		inspectionpage.verifyDefaultInspectionDate();
	}

	@QAFTestStep(description="Verify Site {0} selection from dropdown for default template")
	public void verifySiteSelectionFromDropdownDefault(String siteName){
		Validator.assertTrue(inspectionpage.verifySiteSelectionForDefault(siteName),"One or more flag cards for default template are missing", "Flag cards verified successfully");
	}

	@QAFTestStep(description="Verify Site {0} selection from dropdown for VMC template")
	public void verifySiteSelectionFromDropdownVMC(String siteName){
		Validator.assertTrue(inspectionpage.verifySiteSelectionForVMC(siteName),"One or more flag cards for VMC template are missing", "Flag cards verified successfully");
	}


	@QAFTestStep(description="Verify the inspection name functionality for site {0}")
	public void verifyInspectionName(String siteName){
		inspectionpage.verifyInspectionName(siteName);
	}

	@QAFTestStep(description="Verify default Site selection {0}")
	public void verifyDefaultSiteSelection(String siteName){
		inspectionpage.verifyDefaultSite(siteName);
	}

	@QAFTestStep(description="Verify user is able to select collaborator {ConveyorName}")
	public void verifyCollaboratorSelection(String collaborator){
		inspectionpage.verifyCollaboratorSelection(collaborator);
	}

	@QAFTestStep(description="Verify all the default tile value displayed as {val}")
	public void verifyDefaultTitleCount(String val){
		Validator.assertTrue(inspectionpage.verifyDefaultTileCount(val),"Inspection default tile count is incorrect","Inspection default tile count verified successfully");
	}

	@QAFTestStep(description="Verify user is able to enter text {Text} in summary field")
	public void verifySummaryField(String val){
		Validator.assertTrue(inspectionpage.verifySummaryField(val),"Summary Field is not editable","Summary field is successfully edited");
	}

	@QAFTestStep(description="Verify user is able to maximize the summary window size")
	public void verifyMaximizeSummaryField(){
		Validator.assertTrue(inspectionpage.verifyMaximize(),"Summary field is not maximized","Summary field is maximised successfully");
		Validator.assertTrue(inspectionpage.verifyMinimize(),"Summary field is not minimized","Summary field is minimized successfully");

	}

	@QAFTestStep(description="Verify auto-population of inspector name {Inspector}")
	public void verifyAutoPopulationInspector(String val){
		Validator.assertTrue(inspectionpage.verifyInspectorName(val),"Inspector name is not auto-populated","IInspector name is auto-populated successfully");
	}

	@QAFTestStep(description="Verify the add new button is disabled")
	public void verifyAddNewBtn(){
		Validator.assertTrue(inspectionpage.verifySaveBtn(),"Inspection default tile count is incorrect","Inspection default tile count verified successfully");
	}

	@QAFTestStep(description="Navigate to the inspection details screen for {InspectionName}")
	public void verifyInspectionsDetails(String inspection){
		inspectionpage.goToInspectionDetailScreen(inspection);
	}

	@QAFTestStep(description="Verify tile count {TotalCount} for critical poor fault good and completed {Val}")
	public void verifyInspectionCount(String totalCount, String val){
		Validator.assertTrue(inspectionpage.verifyInspectionCount(totalCount, val),"Inspection tile count is incorrect","Inspection tile count verified successfully");
	}

	@QAFTestStep(description="Verify the actions button is disabled")
	public void verifyDefaultActionState(){
		inspectionpage.goToInspectionScreenAndWait();
//		Validator.assertFalse(inspectionpage.verifyActionBtnState(),"Inspection action button is not disabled","Inspection action button is disabled");
	}

	@QAFTestStep(description="Verify after select inspection {InspectionName} action button is enabled")
	public void verifyActionStateAfterSelection(String inspection){
		inspectionpage.searchInspection(inspection);
		inspectionpage.selectInspection();
		Validator.assertTrue(inspectionpage.verifyActionBtnState(),"Action button is not enabled after selecting the inspection","Inspection action button is enabled");
	}

	@QAFTestStep(description="Verify the contents of action dropdown")
	public void verifyActionsDropdown(){
		Validator.assertTrue(inspectionpage.verifyDropDown(),"Inspection action dropdown contents missing","inspection action dropdown verified successfully");
	}

	@QAFTestStep(description="Navigate to edit inspection Event and verify the breadcrumb")
	public void verifyInspectionsBreadcrumb(){
		Validator.assertTrue(inspectionpage.verifyEditBreadcrumb(),"After editing Inspection unable to see edit breadcrumb","Inspection edit breadcrumb is verified successfully");
	}

	@QAFTestStep(description="Edit Inspection event to {EditInspectionName} and inspector name to {EditInspectorName}")
	public void editInspection(String editInspection, String editInspector){
		inspectionpage.editInspectionName(editInspection);
		inspectionpage.editInspectorName(editInspector);
		inspectionpage.saveInspectionEvent();
	}

	@QAFTestStep(description="Verify the changes {0} for Inspection event {1}")
	public void verifyTheChangesForInspectionEvent(String inspectorName, String inspectionName){
		inspectionpage.goToInspectionDetailScreen(inspectionName);
		Validator.assertTrue(inspectionpage.verifyEditChanges(inspectionName,inspectorName),"After editing Inspection event new changes were not applied","Inspection edit changes were verified successfully");
	}

	@QAFTestStep(description="Edit inspection Item status for {ConveyorName} to {EditStatus} from list view")
	public void editInspectionItemFromList(String conveyorName, String editStatus){
		inspectionpage.editInspectionItemList(conveyorName);
		inspectionpage.editInspectionItemStatus(editStatus);
	}

	@QAFTestStep(description="Verify the status changes {EditStatus} for {EditInspectionName}")
	public void verifyEventItemChanges(String status, String inspectionName){
		Validator.assertTrue(inspectionpage.verifyEditedItemChanges(inspectionName,status),"After editing Inspection item new changes were not applied","Inspection Item edit changes were verified successfully");
	}

	@QAFTestStep(description="Verify the uploaded image in inspection grouped view for {EditInspectionName}")
	public void verifyGroupedViewImage(String inspectionName){
		Validator.assertFalse(inspectionpage.verifyInspectionGroupedView(inspectionName).equalsIgnoreCase("/assets/img/upload_default.png"), "New Image was not uploaded", "New Img was successfully added");
		inspectionpage.verifyImageViewerGrouped();
	}

	@QAFTestStep(description="Verify the uploaded image in inspection list view for {ConveyorName}")
	public void verifyListViewImage(String conveyor){
		Validator.assertTrue(inspectionpage.verifyInspectionListView(conveyor), "Image view icon was disabled ", "Image view icon verified successfully");
		inspectionpage.verifyImageViewerList();
	}

	@QAFTestStep(description="Delete inspection item {ConveyorName} from inspection list")
	public void InspectionItemDelete(String inspectionName) {
		inspectionpage.searchInspectionItem(inspectionName);
		inspectionpage.inspectionDelete();
	}

	@QAFTestStep(description="Verify inspection item {ConveyorName} is deleted from inspection list")
	public void verifyInspectionItemDelete(String inspectionName){
		inspectionpage.verifyDeleteItem(inspectionName);
	}

	@QAFTestStep(description="Enter inspection name as {InspectionName}")
	public void enterInspectionName(String inspectionName){
		inspectionpage.enterInspectionName(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
	}

	@QAFTestStep(description="Navigate to inspection list screen and wait for data load")
	public void navigateToInspectionPage(){
		inspectionpage.goToInspectionScreenAndWait();
	}
	@QAFTestStep(description="Verify inspection total count is displayed")
	public void verifyInspecTotalCount(){
		inspectionpage.verifyInspectionCount();
	}
	@QAFTestStep(description="Verify number of the to be completed inspection is displayed")
	public void verifyInspecToBeCompleteCount(){
		inspectionpage.verifyInspectionCompleteCount();
	}

	@QAFTestStep(description="Extract inspection item status value for {Inspection}")
	public void extractInspStatusValue(String inspection){
		inspectionpage.waitForPageLoad(10000);
		inspectionpage.searchInspectionItem(inspection);
//		inspectionpage.clickOnViewBtn();
		inspectionpage.extractStatusValue();
	}

	@QAFTestStep(description="Click on the view button")
	public void clickOnViewButton(){
		inspectionpage.clickOnViewBtn();
	}

	@QAFTestStep(description="Verify the inspection item status value")
	public void verifyInspectionStatusValue(){
		inspectionpage.verifyStatusValue();
	}

	@QAFTestStep(description="Extract inspection item condition value for {Inspection}")
	public void extractInspConditionValue(String inspection){
		inspectionpage.waitForPageLoad(10000);
		inspectionpage.searchInspectionItem(inspection);
		inspectionpage.extractConditionValue();
	}

	@QAFTestStep(description="Verify the inspection item condition value")
	public void verifyInspectionConditionValue(){
		inspectionpage.verifyConditionValue();
	}

	@QAFTestStep(description="Verify duplicate inspection event for {InspectionName}")
	public void verifyTheDulpicateInspection(String inspectionName){
		inspectionpage.verifyDulpicateInspection(inspectionName);
	}

	@QAFTestStep(description="Add the inspection Event for conveyor {ConveyorName} with {InspectionName} {CustSiteName} {FullName}")
	public void addInspectionEventForConveyor(String conveyorName, String inspectionName, String custSiteName, String fullName){
		inspectionpage.goToInspection();
		inspectionpage.addInspection(inspectionName,custSiteName,fullName);
		SyncUtil.waitFor(2000);
	}

	@QAFTestStep(description="Add duplicate inspection Item for conveyor {ConveyorName} for {InspectionName} with {AssetName} {AssetDetail} {FailureMode} {Condition} {Status}")
	public void createDulpicateInspectionItemMandatoryFields(String conveyorName, String inspectionName,String assetName, String assetDetail, String failureMode, String condition, String status){
		inspectionpage.addItemMandatoryField(conveyorName,assetName, assetDetail, failureMode, condition, status);
		inspectionpage.saveDulpicateInspectionItem();
	}

	@QAFTestStep(description = "Click on corporates and open corperate {Corporate}")
	public void navigateToCorporate(String corp) {
		corpPage.clickCorporates();
		corpPage.searchCorporate(corp);
		inspectionpage.viewAndVerifyCorporatePage();
	}


	@QAFTestStep(description = "Click on inspections and verify user is able to open inspections")
	public void verifyTheInspectionCardClick() {
		inspectionpage.verifyInspectionCardClick();
	}

	@QAFTestStep(description = "Navigate to inspection list from inspection card at home level")
	public void verifyInspectionCardNav() {
		inspectionpage.verifyInspectionCardClick();
	}

	@QAFTestStep(description="Navigate to inspection list page and wait")
	public void navigateToInspectionScreen()
	{
		inspectionpage.goToInspectionScreenAndWait();
	}


	@QAFTestStep(description="Verify the breadcrumb of the page")
	public void verifyInspectionBreadCrumb(){
		inspectionpage.verifyUserBreadCrumb();
	}

	@QAFTestStep(description="Click on add new button and verify that add files to upload section is visible")
	public void verifyAddFilesIsVisible(){
		inspectionpage.addNewBtnClick();
		inspectionpage.verifyAddFilesToUploadBtn();
	}

	@QAFTestStep(description="Click on select files to upload image")
	public void ClickOnSelectFiles(){
		inspectionpage.selectFilesBtnClick();
	}

	@QAFTestStep(description="Select the image {imgName} to upload and verify user is able to upload the image")
	public void UploadImageFromSystem(String imgName){
		userPage.imageUpload(imgName);
	}

	@QAFTestStep(description="Verify that the loader is visible and selected image is displayed in the section")
	public void VerifyTheUploadedImage(){
		inspectionpage.verifyLoader();
		inspectionpage.verifyUploadedImage();
	}

	@QAFTestStep(description="Verify delete button is visible and click on delete button")
	public void ClickAndVerifyDeleteBtn(){
		inspectionpage.verifyDeleteBtn();
		inspectionpage.deleteBtnClick();
	}

	@QAFTestStep(description="Verify that selected image is deleted")
	public void verifyImageDeletion(){
		inspectionpage.verifyImageDeletion();
	}

	@QAFTestStep(description="Navigate to Inspection detail page of the InspectionEvent {InspectionName}")
	public void navigateToInspectionDetailPage(String inspectionEvent){
		inspectionpage.goToInspectionDetailScreen(inspectionEvent);
	}

	@QAFTestStep(description="Search for the InspectionItem {ConveyorName}")
	public void searchInspectionItemAndClick(String conveyorName){
		inspectionpage.searchForInspectionItem(conveyorName);
	}

	@QAFTestStep(description="Click on Export Button of InspectionItem and verify user is able to download pdf")
	public void clickOnExportBtnAndVerifyDownload(){
//		inspectionpage.exportPDFConveyor(conveyorName);
		inspectionpage.selectInspection();
		inspectionpage.exportBtnClick();
		Validator.assertTrue(MiscUtils.checkDownloadedFiles("conveyor.pdf"),"PDF report was not found","PDF report was downloaded successfully");

	}

	@QAFTestStep(description="Click on view icon and verify the uploaded image is visible")
	public void verifyUploadedImage(){
		inspectionpage.viewInspectionItem();
		inspectionpage.verifyUploadedImage();
	}

	@QAFTestStep(description="Click on conveyor {ConveyorName} name in breadcrumb anf verify it navigates to conveyor technical data screen")
	public void clickOnConveyorBreadCrumbAndVerify(String conveyorName){
		inspectionpage.conveyorNameClick(conveyorName);
		inspectionpage.verifyConveyorPageNavigation();
	}

	@QAFTestStep(description="Click on Inspection tile and verify it displays only corresponding conveyor {ConveyorName} inspections")
	public void clickOnInspectionTileAndVerify(String conveyorName){
		inspectionpage.goToInspectionsFromTile();
		SyncUtil.waitFor(10000);
		int noOfInspections = Integer.parseInt(MiscUtils.regexExtractor(inspectionpage.paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		inspectionpage.verifyInspections(noOfInspections,conveyorName,8);
	}

	@QAFTestStep(description="Click on site name {CustSiteName} in breadcrumb anf verify it navigates to site page")
	public void clickOnSiteBreadCrumbAndVerify(String siteName){
		inspectionpage.siteNameClick(siteName);
		inspectionpage.verifySitePageNavigation(siteName);
	}

	@QAFTestStep(description="Click on Inspection tile and verify it displays only corresponding site {CustSiteName} inspections")
	public void clickOnInspectionTileAndVerifySiteInspection(String custSiteName){
		inspectionpage.goToInspectionsFromTile();
		SyncUtil.waitFor(10000);
		int noOfInspections = Integer.parseInt(MiscUtils.regexExtractor(inspectionpage.paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		inspectionpage.verifyInspections(noOfInspections,custSiteName,7);
	}

	@QAFTestStep(description="Click on corporate name {CustCorp} in inspection breadcrumb anf verify it navigates to corporate page")
	public void clickOnCorporateBreadCrumbAndVerify(String corpName){
		inspectionpage.corporateNameClick(corpName);
		inspectionpage.verifyCorporatePageNavigation(corpName);
	}

	@QAFTestStep(description="Click on Inspection tile and verify it displays only corresponding corporate {CustCorp} inspections")
	public void clickOnInspectionTileAndVerifyCorporateInspection(String custCorp){
		inspectionpage.goToInspectionsFromTile();
		SyncUtil.waitFor(10000);
		int noOfInspections = Integer.parseInt(MiscUtils.regexExtractor(inspectionpage.paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		inspectionpage.verifyInspections(noOfInspections,custCorp,6);
	}

	@QAFTestStep(description="Click on corporates breadcrumb and verify it navigates to corporate page")
	public void clickOnCorpAndVerify(){
		inspectionpage.corpBreadCrumbClick();
		inspectionpage.verifyCorporateListPageNavigation();
	}

	@QAFTestStep(description = "Click on inspection dashboard symbol and verify user is able to click on dashboard")
	public void clickAndVerifyInspectionDashboard() {
		inspectionpage.inspectionDashboardBtnClick();
	}

	@QAFTestStep(description = "Verify number of inpection items for {Total} {Critical} {Poor} {Fault} {Good}")
	public void verifyTheInspectionItemsCounts(String total, String critical,String poor,String fault,String good) {
		inspectionpage.verifyInspectionItemsCounts(total,critical,poor,fault,good);
	}

	@QAFTestStep(description = "Click on site dropdown and verify user is able to select multiple site {SiteName} {SiteName2}")
	public void clickAndVerifyMultipleSelectionInSiteDropDown(String siteName,String siteName2) {
		inspectionpage.siteDropDownClick();
		inspectionpage.verifyMultiSelInSiteDropDown(siteName,siteName2);
	}

	@QAFTestStep(description="Verify only view permission right for {ConveyorName} for {InspectionName} with {AssetName} {AssetDetail} {FailureMode} {Condition} {Status}")
	public void verifyViewPermissionRightForInspections(String conveyorName, String inspectionName,String assetName, String assetDetail, String failureMode, String condition, String status) {
		inspectionpage.verifyViewRights(conveyorName,inspectionName,assetName, assetDetail, failureMode, condition, status);
	}

	@QAFTestStep(description="Verify only view and edit permission right for {ConveyorName} for {InspectionName} with {AssetName} {AssetDetail} {FailureMode} {Condition} {Status}")
	public void verifyViewAndEditPermissionRightForInspections(String conveyorName, String inspectionName,String assetName, String assetDetail, String failureMode, String condition, String status) {
		inspectionpage.verifyViewAndEditRights(conveyorName,inspectionName,assetName, assetDetail, failureMode, condition, status);
	}

	@QAFTestStep(description="Verify only view and add permission right for {ConveyorName} for {InspectionName} with {AssetName} {AssetDetail} {FailureMode} {Condition} {Status}")
	public void verifyViewAndAddPermissionRightForInspections(String conveyorName, String inspectionName,String assetName, String assetDetail, String failureMode, String condition, String status) {
		inspectionpage.verifyViewAndAddRights(conveyorName,inspectionName,assetName, assetDetail, failureMode, condition, status);
	}

	@QAFTestStep(description="Verify only view and delete permission right for {ConveyorName} for {InspectionName} with {AssetName} {AssetDetail} {FailureMode} {Condition} {Status}")
	public void verifyViewAndDeletePermissionRightForInspections(String conveyorName, String inspectionName,String assetName, String assetDetail, String failureMode, String condition, String status) {
		inspectionpage.verifyViewAndDeleteRights(conveyorName,inspectionName,assetName, assetDetail, failureMode, condition, status);
	}

	@QAFTestStep(description = "Verify user is able to see the cards")
	public void verifyCardsOnInspectionDashboard() {
		inspectionpage.verifyInspectionDashboardCards();
	}

	@QAFTestStep(description = "Click on site dropdown and verify user is able to select a site {SiteName}")
	public void clickAndVerifySiteDropDown(String siteName) {
		inspectionpage.siteDropDownClick();
		inspectionpage.verifySiteDropDownClicked(siteName);
	}
	@QAFTestStep(description = "Verify actions button is present and is enabled by default")
	public void verifyActionsButtonEnabledByDefault() {
		inspectionpage.verifyActionBtnEnabled();
	}

	@QAFTestStep(description = "Click on actions dropdown button and verify 'export button' with PDF symbol is visible")
	public void clickActionBtnAndVerifyPDFfield() {
		conveyorPage.actionBtnClick();
		inspectionpage.verifyExportPDFIsVisible();
	}
	@QAFTestStep(description = "Click on Export PDF button and verify PDF is downloaded for company {Corporate}")
	public void clickOnExportButtonAndVerify(String corp) {
		inspectionpage.exportBtnClick();
		SyncUtil.waitFor(15000);
		Validator.assertTrue(MiscUtils.checkDownloadedFiles(corp+"-inspection-dashboard.pdf"),"PDF report was not found","PDF report was downloaded successfully");
		MiscUtils.deleteDownloadedFiles(corp+"-inspection-dashboard.pdf");

	}

	@QAFTestStep(description = "Verify that the selected site for {SiteName} and company {Corporate} is visible under downloaded PDF under Site Selection")
	public void verifySelectedSiteInReport(String siteName,String corp) {
		inspectionpage.verifyInspectionDashboardContents(siteName,corp);
		MiscUtils.deleteDownloadedFiles(corp+"-inspection-dashboard.pdf");
	}

	@QAFTestStep(description = "Verify grouped inspection is selected by default")
	public void verifyGroupedSelection() {
		Validator.assertTrue(inspectionpage.isGroupViewSelected(),"Grouped inspection is not selected by default","Grouped inspection verified successfully");
	}

	@QAFTestStep(description = "Verify list inspection is selected on click")
	public void verifyListSelection() {
		Validator.assertTrue(inspectionpage.isListViewSelected(),"List inspection is not selected even after click","List inspection verified successfully");
	}

	@QAFTestStep(description = "Verify navigation of group inspection {InspectionName}")
	public void verifyGroupedInspectionNav(String inspection) {
		Validator.assertTrue(inspectionpage.verifyGroupDetailsNav(inspection),"Grouped inspection navigation failed","Grouped inspection navigation verified successfully");
	}

	@QAFTestStep(description = "Verify navigation of list inspection {ConveyorName}")
	public void verifyListInspectionNav(String conveyor) {
		Validator.assertTrue(inspectionpage.verifyListDetailsNav(conveyor),"List inspection navigation failed","List inspection navigation verified successfully");
	}

	@QAFTestStep(description = "Verify inspection item detail popup screen")
	public void verifyInspectionItemDetails() {
		Validator.assertTrue(inspectionpage.verifyListItems(),"Inspection item detail verification failed","Inspection item detail screen verified successfully");
	}

	@QAFTestStep(description = "Verify summary field bold letter functionality")
	public void verifyBoldLetters() {
		Validator.assertTrue(inspectionpage.verifyBoldSummaryField(),"Summary bold button verification failed","Summary bold button verified successfully");
	}

	@QAFTestStep(description = "Verify summary field italics letter functionality")
	public void verifyItalicsLetters() {
		Validator.assertTrue(inspectionpage.verifyItalicsSummaryField(),"Summary italics button verification failed","Summary italics button verified successfully");
	}

	@QAFTestStep(description = "Verify summary field underline letter functionality")
	public void verifyUnderlineLetters() {
		Validator.assertTrue(inspectionpage.verifyUnderlineSummaryField(),"Summary underline button verification failed","Summary underline button verified successfully");
	}

	@QAFTestStep(description = "Verify summary field list letter functionality")
	public void verifyListLetters() {
		Validator.assertTrue(inspectionpage.verifyListSummaryField(),"Summary list button verification failed","Summary list button verified successfully");
	}

	@QAFTestStep(description="Add inspection Item for conveyor {ConveyorName} and verify inspector name {Inspector}")
	public void verifyInspectorNameItem(String conveyorName, String inspector){
		Validator.assertTrue(inspectionpage.getInspectorNameFromItem().equalsIgnoreCase(inspector),"Inspector name under item verification failed","Inspector name under item verified successfully");
	}

	@QAFTestStep(description="Add inspection Item for conveyor {ConveyorName} and verify Conveyor header name")
	public void verifyInspectorNameItem(String conveyorName){
		Validator.assertTrue(inspectionpage.getConveyorHeaderFromItem().equalsIgnoreCase(conveyorName),"Inspector item header verification failed","Inspector item header verified successfully");
	}

//	@QAFTestStep(description="Add inspection Item for conveyor {ConveyorName} and verify the coordinates")
//	public void verifyLatLongFromItem(String conveyorName){
//		inspectionpage.verifyLonLatFromItem();
//	}

	@QAFTestStep(description="Add inspection Item for conveyor {ConveyorName} and verify the map header for conveyor with location")
	public void verifyMapHeaderWithLocationFromItem(String conveyorName){
		Validator.assertTrue(inspectionpage.isMapHeader(),"Location head and tail is not shown in map","Location head and tail verified successfully");
	}

	@QAFTestStep(description="Add inspection Item for conveyor {ConveyorName} and verify the map header for conveyor without location")
	public void verifyMapHeaderWithoutLocationFromItem(String conveyorName){
		Validator.assertFalse(inspectionpage.isMapHeader(),"Location head and tail should not be shown in map","Location head and tail verified successfully");
	}

	@QAFTestStep(description="Add inspection Item for conveyor {ConveyorName} and and verify the location label")
	public void verifyLocationLabelFromItem(String conveyorName){
		Validator.assertFalse(inspectionpage.isLocationLabel(),"Location label is shown in map","Location label verified successfully");
	}

	@QAFTestStep(description="Verify view add edit delete permission right for {InspectionName}")
	public void verifyInspectionPermission(String inspectionName){
		inspectionpage.verifyViewAddEditDeleteRights(inspectionName);
	}

	@QAFTestStep(description="Verify tile count for total critical poor fault good and to be completed")
	public void verifyInspectionCounts(){
		Map<String, Object> response = inspectionpage.apiBase.getConveyorsInspectionCount();
		int totalInspections = (int) response.get("totalInspections");
		System.out.println(totalInspections);
		getBundle().setProperty("totalInspections",totalInspections);
		int toBeCompleted = (int) response.get("toBeCompleted");
		System.out.println(toBeCompleted);
		getBundle().setProperty("toBeCompleted",toBeCompleted);
		int good = (int) response.get("good");
		System.out.println(good);
		getBundle().setProperty("good",good);
		int fault = (int) response.get("fault");
		System.out.println(fault);
		getBundle().setProperty("fault",fault);
		int poor = (int) response.get("poor");
		System.out.println(poor);
		getBundle().setProperty("poor",poor);
		int critical = (int) response.get("critical");
		System.out.println(critical);
		getBundle().setProperty("critical",critical);
		inspectionpage.verifyInspectionCounts(totalInspections, toBeCompleted, good, fault, poor, critical);
	}


	@QAFTestStep(description="Extract the inspection card count")
	public void verifyInspectionCardCount(){
		int totalInspections = inspectionpage.getTotalInspectionCount();
		System.out.println(totalInspections);
		getBundle().setProperty("totalInspections",totalInspections);
		int toBeCompleted = inspectionpage.getToBeCompletedInspectionCount();
		System.out.println(toBeCompleted);
		getBundle().setProperty("toBeCompleted",toBeCompleted);
//		int good = inspectionpage.getInspectionGoodCount();
//		System.out.println(good);
//		getBundle().setProperty("good",good);
		int fault = inspectionpage.getInspectionFaultCount();
		System.out.println(fault);
		getBundle().setProperty("fault",fault);
		int poor = inspectionpage.getInspectionPoorCount();
		System.out.println(poor);
		getBundle().setProperty("poor",poor);
		int critical = inspectionpage.getInspectionCriticalCount();
		System.out.println(critical);
		getBundle().setProperty("critical",critical);
	}

	@QAFTestStep(description="Extract the inspection dashboard count for VMC")
	public void verifyInspectionDashboardCountVMC(){
		int totalInspections = inspectionpage.getDashboardTotalCount();
		System.out.println(totalInspections);
		getBundle().setProperty("totalInspections",totalInspections);
//		int good = inspectionpage.getDashboardGoodCount();
//		System.out.println(good);
//		getBundle().setProperty("good",good);
		int fault = inspectionpage.getDashboardFaultCount();
		System.out.println(fault);
		getBundle().setProperty("fault",fault);
		int critical = inspectionpage.getDashboardCriticalCount();
		System.out.println(critical);
		getBundle().setProperty("critical",critical);
	}

	@QAFTestStep(description="Extract the inspection dashboard count")
	public void verifyInspectionDashboardCount(){
		int totalInspections = inspectionpage.getDashboardTotalCount();
		System.out.println(totalInspections);
		getBundle().setProperty("totalInspections",totalInspections);
		int good = inspectionpage.getDashboardGoodCount();
		System.out.println(good);
		getBundle().setProperty("good",good);
		int fault = inspectionpage.getDashboardFaultCount();
		System.out.println(fault);
		getBundle().setProperty("fault",fault);
		int poor = inspectionpage.getDashboardPoorCount();
		System.out.println(poor);
		getBundle().setProperty("poor",poor);
		int critical = inspectionpage.getDashboardCriticalCount();
		System.out.println(critical);
		getBundle().setProperty("critical",critical);
	}

	@QAFTestStep(description="Verify the incremental tile count changes for {ChangeTotal},{ChangeTobeComplated},{ChangeGood},{ChangeFault},{ChangeCritical}")
	public void verifyInspectionCountChangeVMC(String changeTotal, String changeTobeComplated, String changeGood, String changeFault, String changeCritical){
		String totalInspections = String.valueOf((int) getBundle().getProperty("totalInspections") + Integer.parseInt(changeTotal));
		String toBeCompleted = String.valueOf((int) getBundle().getProperty("toBeCompleted") + Integer.parseInt(changeTobeComplated));
//		String good = String.valueOf((int) getBundle().getProperty("good") + Integer.parseInt(changeGood));
		String fault = String.valueOf((int) getBundle().getProperty("fault") + Integer.parseInt(changeFault));
		String critical = String.valueOf((int) getBundle().getProperty("critical") + Integer.parseInt(changeCritical));
		System.out.println(changeTotal);
		System.out.println(changeTobeComplated);
		System.out.println(changeGood);
		System.out.println(changeFault);
		System.out.println(changeCritical);
		getBundle().setProperty("totalInspections",Integer.parseInt(totalInspections));
		getBundle().setProperty("toBeCompleted",Integer.parseInt(toBeCompleted));
//		getBundle().setProperty("good",Integer.parseInt(good));
		getBundle().setProperty("fault",Integer.parseInt(fault));
		getBundle().setProperty("critical",Integer.parseInt(critical));
		inspectionpage.verifyInspectionCountChangeVMC(totalInspections, toBeCompleted, fault, critical);
	}

	@QAFTestStep(description="Verify the incremental tile count changes for {ChangeTotal},{ChangeTobeComplated},{ChangeGood},{ChangePoor},{ChangeFault},{ChangeCritical}")
	public void verifyInspectionCountChangeDefault(String changeTotal, String changeTobeComplated, String changeGood, String changePoor, String changeFault, String changeCritical){
		String totalInspections = String.valueOf((int) getBundle().getProperty("totalInspections") + Integer.parseInt(changeTotal));
		String toBeCompleted = String.valueOf((int) getBundle().getProperty("toBeCompleted") + Integer.parseInt(changeTobeComplated));
//		String good = String.valueOf((int) getBundle().getProperty("good") + Integer.parseInt(changeGood));
		String poor = String.valueOf((int) getBundle().getProperty("poor") + Integer.parseInt(changePoor));
		String fault = String.valueOf((int) getBundle().getProperty("fault") + Integer.parseInt(changeFault));
		String critical = String.valueOf((int) getBundle().getProperty("critical") + Integer.parseInt(changeCritical));
		System.out.println(changeTotal);
		System.out.println(changeTobeComplated);
		System.out.println(changeGood);
		System.out.println(changeFault);
		System.out.println(changePoor);
		System.out.println(changeCritical);
		getBundle().setProperty("totalInspections",Integer.parseInt(totalInspections));
		getBundle().setProperty("toBeCompleted",Integer.parseInt(toBeCompleted));
//		getBundle().setProperty("good",Integer.parseInt(good));
		getBundle().setProperty("poor",Integer.parseInt(poor));
		getBundle().setProperty("fault",Integer.parseInt(fault));
		getBundle().setProperty("critical",Integer.parseInt(critical));
		inspectionpage.verifyInspectionCountChange(totalInspections, toBeCompleted, poor, fault, critical);
	}

	@QAFTestStep(description="Verify the dashboard tile count changes for {ChangeTotal},{ChangeGood},{ChangePoor},{ChangeFault},{ChangeCritical}")
	public void verifyDashboardCountChangeDefault(String changeTotal, String changeGood, String changePoor, String changeFault, String changeCritical){
		String totalInspections = String.valueOf((int) getBundle().getProperty("totalInspections") + Integer.parseInt(changeTotal));
		String good = String.valueOf((int) getBundle().getProperty("good") + Integer.parseInt(changeGood));
		String poor = String.valueOf((int) getBundle().getProperty("poor") + Integer.parseInt(changePoor));
		String fault = String.valueOf((int) getBundle().getProperty("fault") + Integer.parseInt(changeFault));
		String critical = String.valueOf((int) getBundle().getProperty("critical") + Integer.parseInt(changeCritical));
		System.out.println(changeTotal);
		System.out.println(changeGood);
		System.out.println(changeFault);
		System.out.println(changePoor);
		System.out.println(changeCritical);
		getBundle().setProperty("totalInspections",Integer.parseInt(totalInspections));
		getBundle().setProperty("good",Integer.parseInt(good));
		getBundle().setProperty("poor",Integer.parseInt(poor));
		getBundle().setProperty("fault",Integer.parseInt(fault));
		getBundle().setProperty("critical",Integer.parseInt(critical));
		inspectionpage.verifyDashboardCountChange(totalInspections, good, poor, fault, critical);
	}

	@QAFTestStep(description="Verify the dashboard tile count changes for {ChangeTotal},{ChangeGood},{ChangeFault},{ChangeCritical}")
	public void verifyDashboardCountChangeVMC(String changeTotal, String changeGood, String changeFault, String changeCritical){
		String totalInspections = String.valueOf((int) getBundle().getProperty("totalInspections") + Integer.parseInt(changeTotal));
		String good = String.valueOf((int) getBundle().getProperty("good") + Integer.parseInt(changeGood));
		String fault = String.valueOf((int) getBundle().getProperty("fault") + Integer.parseInt(changeFault));
		String critical = String.valueOf((int) getBundle().getProperty("critical") + Integer.parseInt(changeCritical));
		System.out.println(changeTotal);
		System.out.println(changeGood);
		System.out.println(changeFault);
		System.out.println(changeCritical);
		getBundle().setProperty("totalInspections",Integer.parseInt(totalInspections));
		getBundle().setProperty("good",Integer.parseInt(good));
		getBundle().setProperty("fault",Integer.parseInt(fault));
		getBundle().setProperty("critical",Integer.parseInt(critical));
		inspectionpage.verifyDashboardCountChangeVMC(totalInspections, good, fault, critical);
	}

	@QAFTestStep(description="Verify the inspection count with list count")
	public void verifyTheInspectionCountWithListCount(){
		inspectionpage.verifyInspectionListCount();
	}

	@QAFTestStep(description="Verify the add new button functionality")
	public void verifyAddNewBtnFunctionality(){
		inspectionpage.verifyAddNewBtn();
	}

	@QAFTestStep(description="Verify inspection item without mandatory fields")
	public void verifyAddItemWithoutMandatoryFields(){
		inspectionpage.verifyAddItemWithoutMandatoryFields();
	}

	@QAFTestStep(description="Verify download and view icons in list screen")
	public void verifyDownloadViewIcons(){
		Validator.assertTrue(inspectionpage.verifyDownloadViewIcons(),"Download and view icons are not properly visible under list screen","Download and view icons are verified successfully");
	}

	@QAFTestStep(description="Verify image upload for inspection item {img}")
	public void verifyImgUploadInspectionItem(String img){
		Validator.assertTrue(inspectionpage.verifyImgUploadInspectionItem(img),"Uploaded images are not properly visible under inspection item","Uploaded images are verified successfully");
	}

	@QAFTestStep(description="Verify delete uploaded image")
	public void verifyDeleteUploadedImg(){
		Validator.assertTrue(inspectionpage.verifyDeleteUploadedImg(),"Images are not deleted properly under inspection item","Images deleted are verified successfully");
	}

	@QAFTestStep(description="Verify count from inspection item list")
	public void verifyInspectionItemCount() {
		Map<String, Object> response = inspectionpage.apiBase.getConveyorsInspectionCount();
		String totalInspectionItems = String.valueOf((int)response.get("totalInspectionItems"));
		System.out.println(totalInspectionItems);
		inspectionpage.verifySwitchView();
		inspectionpage.inspectionItemsListCount(totalInspectionItems);
	}

	@QAFTestStep(description="Verify whether the inspection event {InspectionName} is deleted from list view")
	public void inspectionEvent(String inspectionName) {
		inspectionpage.browserRefresh();
		Validator.assertFalse(inspectionpage.searchInspection(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName),"Inspection event is present in inspection event list","Inspection event is deleted from inspection list");
	}

	@QAFTestStep(description="Verify whether the inspection event {InspectionName} is present in list view")
	public void isInspectionEvent(String inspectionName) {
		Validator.assertTrue(inspectionpage.searchInspection(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName),"Inspection event is not present in inspection event list","Inspection event is present in inspection list");
	}

	@QAFTestStep(description = "Search and verify the {Value} is present")
	public void searchTheResult(String value) {
		inspectionpage.searchResult(value);
	}

	@QAFTestStep(description = "Click on Clear filter Icon")
	public void clickTheClickFilter() {
		inspectionpage.clickClearFilter();
	}

	@QAFTestStep(description = "Verify column filter with {ColumnName} and {ColumnNumber}")
	public void clickTheColumnFilter(String columnName, String columnNumber) {
		inspectionpage.verifyColumnFunctionality(columnName, columnNumber);
	}


	@QAFTestStep(description = "Verify the last modified date for newly created inspection {InspectionName}")
	public void clickLastModifiedDate(String InspName) {
		inspectionpage.verifyLastModifiedDate(InspName);
	}

	@QAFTestStep(description = "Verify the condition column filter {Condition} {ColumnNum}")
	public void verifyConditionFilter(String condition, String columnNum) {
		inspectionpage.verifyConditionFilter(condition,columnNum);
	}

	@QAFTestStep(description = "Verify the status column filter {Status}")
	public void verifyStatusFilter(String status) {
		inspectionpage.verifyStatusFilter(status);
	}

	@QAFTestStep(description = "Verify name filter functionality with {InspectionName} and {ColumnNumber}")
	public void verifyNameColumnFilter(String inspName, String columnNumber) {
		inspectionpage.verifyNameFilterFunctionality(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspName, columnNumber);
		inspectionpage.verifyPaginationCount(1);
	}

	@QAFTestStep(description="Verify the pagination count")
	public void verifyThePaginationCount(){
		inspectionpage.verifyPaginationCount(1);
	}

	@QAFTestStep(description = "Verify date filter functionality with {InspectionDate} and {ColumnNumber}")
	public void verifyDateColumnFilter(String inspDate, String columnNumber) {
		inspectionpage.verifyInspectionDateFilterFunctionality(inspDate, columnNumber);
	}

	@QAFTestStep(description = "Verify corporate filter functionality with {Corporate} and {ColumnNumber}")
	public void verifyCorpColumnFilter(String corp, String columnNumber) {
		inspectionpage.verifyInspectionCorporateFilterFunctionality(corp, columnNumber);
	}

	@QAFTestStep(description = "Verify site filter functionality with {Site} and {ColumnNumber}")
	public void verifySiteColumnFilter(String site, String columnNumber) {
		inspectionpage.verifyInspectionSiteFilterFunctionality(site, columnNumber);
	}

	@QAFTestStep(description = "Verify conveyor filter functionality with {Conveyor} and {ColumnNumber}")
	public void verifyConveyorColumnFilter(String conveyor, String columnNumber) {
		inspectionpage.verifyInspectionConveyorFilterFunctionality(conveyor, columnNumber);
	}

	@QAFTestStep(description = "Verify inspector filter functionality with {Inspector} and {ColumnNumber}")
	public void verifyInspectorColumnFilter(String inspector, String columnNumber) {
		inspectionpage.verifyInspectionInspectorFilterFunctionality(inspector, columnNumber);
	}

	@QAFTestStep(description = "Verify last modified filter functionality with {LastModified} and {ColumnNumber}")
	public void verifyLastModifiedColumnFilter(String lastModified, String columnNumber) {
		inspectionpage.verifyInspectionLastModifiedFilterFunctionality(lastModified, columnNumber);
	}

	@QAFTestStep(description="Verify the inspection creation with success message")
	public void verifyInspectionEventCreation(){
		sortingInspectionItem.clearItems();
		inspectionpage.verifyInspectionEventCreation();
	}

	@QAFTestStep(description="Verify the inspection items columns")
	public void verifyInspectionItemsColumn(){
		Validator.assertTrue(inspectionpage.verifyInspectionItemsColumns(), "Inspection item column for default template is failing", "Inspection item column for default template verified successfully");
	}

	@QAFTestStep(description="Verify the inspection items columns for VMC")
	public void verifyInspectionItemsColumnVMC(){
		Validator.assertTrue(inspectionpage.verifyInspectionItemsColumnsVMC(), "Inspection item column for VMC template is failing", "Inspection item column for default VMC verified successfully");
	}

	@QAFTestStep(description="Verify the add inspection item navigation")
	public void verifyAddInspectionItem(){
		Validator.assertTrue(inspectionpage.verifyAddInspectionItem(), "Inspection add item popup for default template is failing", "Inspection item add popup for default template verified successfully");
	}

	@QAFTestStep(description="Verify the close add inspection item popup")
	public void verifyCloseInspectionItem(){
		Validator.assertTrue(inspectionpage.verifyCloseInspectionItem(), "Inspection add item close popup for default template is failing", "Inspection add item close add popup for default template verified successfully");
	}

	@QAFTestStep(description="Verify the sorting order for inspection items")
	public void verifySortingInspectionItem(){
		inspectionpage.clickClearFilter();
		List<Item> items = sortingInspectionItem.getSortedItems();
		items.forEach(System.out::println);
		inspectionpage.verifyItemSequencingDefault(items);
	}

	@QAFTestStep(description="Verify the sorting order for inspection items for VMC")
	public void verifySortingInspectionItemVMC(){
		inspectionpage.clickClearFilter();
		sortingInspectionItem.switchComparator(true);
		List<Item> items = sortingInspectionItem.getSortedItems();
		items.forEach(System.out::println);
		inspectionpage.verifyItemSequencingVMC(items);
	}

	@QAFTestStep(description="Verify the column condition functionality from list screen for column {ColumnNum} and site {CustSiteName}")
	public void verifyColumnConditionItems(String columnNum, String siteName){
		inspectionpage.searchInspection(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+siteName);
		List<Item> items = sortingInspectionItem.getSortedItems();
		inspectionpage.verifyConditionFilter(items,columnNum);
		inspectionpage.clickClearFilter();
	}

	@QAFTestStep(description="Verify the column status functionality from list screen {Status1} for column {ColumnNum} and site {CustSiteName}")
	public void verifyColumnStatusItems(String status1, String columnNum, String siteName){
		inspectionpage.searchInspection(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+siteName);
		inspectionpage.verifyStatusFilter(status1,sortingInspectionItem.getNotCompletedItems().stream().count());
		inspectionpage.verifyPaginationCount(1);
		inspectionpage.clickClearFilter();
	}

	@QAFTestStep(description="Verify the column conveyor functionality from list screen for column {ColumnNum} and site {CustSiteName} {Count}")
	public void verifyColumnConveyorItems(String columnNum, String siteName, String count){
		inspectionpage.searchInspection(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+siteName);
		List<Item> items = sortingInspectionItem.getSortedItems();
		inspectionpage.verifyConveyorColumn(String.valueOf(items.stream().map(x -> x.conveyorName()).distinct().count()),columnNum);
		inspectionpage.clickClearFilter();
	}

	@QAFTestStep(description="Verify the edit button functionality in list view for inspection {CustName}")
	public void verifyTheEditButtonFunctionalityInInspectionListForInspection(String CustName){
		inspectionpage.editInspection(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+CustName);
	}

	@QAFTestStep(description="Verify the edit button functionality in inspection view mode for inspection {CustName}")
	public void verifyTheEditButtonFunctionalityInInspectionViewModeForInspection(String CustName){
		inspectionpage.editInspectionFromViewMode(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+CustName);
	}

	@QAFTestStep(description="Verify the site dropdown is disabled on edit mode")
	public void verifyTheSiteDropdownIsDisabledOnEditMode(){
		inspectionpage.isSiteDisabledOnEdit();
	}

	@QAFTestStep(description="Edit Inspection event name to {0}")
	public void editInspectionEventNameTo(String newInspectionName){
		inspectionpage.editInspectionName(newInspectionName);
		inspectionpage.saveInspectionEvent();
	}

	@QAFTestStep(description="Search inspection Item with conveyor {ConveyorName} {AssetName} {Condition}")
	public void searchInspectionItem(String conveyorName, String assetName, String condition){
		SyncUtil.waitFor(5000);
		sortingInspectionItem.clearItems();
		sortingInspectionItem.addItems(inspectionpage.getRowData());
		inspectionpage.searchInspectionItem(conveyorName, assetName, condition);
		SyncUtil.waitFor(5000);
	}

	@QAFTestStep(description="Search inspection Item from list view with conveyor {ConveyorName} {AssetName} {Condition}")
	public void searchInspectionItemFromList(String conveyorName, String assetName, String condition){
		sortingInspectionItem.clearItems();
//		sortingInspectionItem.addItems(inspectionpage.getRowData());
		inspectionpage.searchInspectionItem(conveyorName, assetName, condition);
		SyncUtil.waitFor(1000);
	}

	@QAFTestStep(description="Verify the conveyor and asset field are disabled on edit mode")
	public void verifyTheConveyorAndAssetFieldAreDisabledOnEditMode(){
		inspectionpage.goToEditInspectionItem();
	}

	@QAFTestStep(description="Edit inspection Item condition for conveyor {ConveyorName} and {AssetName} to {Condition}")
	public void editInspectionItemDefault(String conveyorName, String assetName, String newCondition){
		sortingInspectionItem.updateItem(conveyorName, assetName, newCondition, null);
		inspectionpage.editInspectionConditionItem(newCondition);
		inspectionpage.saveInspectionItem();
	}

	@QAFTestStep(description="Navigate to Inspection detail page of the Inspection event {CustSiteName}")
	public void navigateToInspectionEventDetailPage(String custSiteName){
		inspectionpage.goToInspectionDetailScreen(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+custSiteName);
	}

	@QAFTestStep(description="Delete default inspection Item for {ConveyorName} and {assetName}")
	public void verifyDeleteInspectionItem(String conveyorName, String assetName){
		sortingInspectionItem.deleteItem(conveyorName,assetName);
		inspectionpage.deleteBtnClick();
		Validator.assertFalse(inspectionpage.isDeleteBtn(),"The delete button is still visible","The delete button is not visible");
	}

	@QAFTestStep(description = "Verify asset filter functionality with {Asset} and {ColumnNumber}")
	public void verifyAssetColumnFilter(String asset, String columnNumber) {
		inspectionpage.verifyInspectionAssetFilterFunctionality(asset, columnNumber);
	}

	@QAFTestStep(description = "Clear filter for inspection items")
	public void clickClearFilter() {
		inspectionpage.clickClearFilter();
	}

	@QAFTestStep(description = "Verify the clear filter functionality {header}")
	public void verifyClearFilter(String header) {
		Validator.assertTrue(inspectionpage.getColumnFunctionality(header).equalsIgnoreCase("none"),"Clear filter functionality is not working as expected","Clear filter functionality verified successfully");
		inspectionpage.verifyResetPaginationCount(1);
	}

	@QAFTestStep(description = "Verify change column selection and disable {photo}")
	public void verifyColumnSelection(String column) {
		Validator.assertFalse(inspectionpage.columnSelection(column),"Column is visible even after column de-selection","Column selection verified successfully");
	}

	@QAFTestStep(description="Verify the search functionality of the inspection item with {searchTxt}")
	public void verifyTheSearchFunctionalityOfTheInspectionItemWith(String searchTxt){
		Validator.assertTrue(inspectionpage.searchForInspectionItem(searchTxt),"Search inspection type is not working as expected","Search inspection item verified successfully");
	}

	@QAFTestStep(description="Select the inspection item with conveyor {ConveyorName1}")
	public void selectingInspectionItems(String conveyorName){
		inspectionpage.	selectingInspection(conveyorName);
	}

	@QAFTestStep(description="Select the inspection event {InspectionName1}")
	public void selectTheInspectionEvent(String inspectionName){
		inspectionpage.selectingInspection(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
	}

	@QAFTestStep(description="Verify the action dropdown for multi event selection")
	public void verifyInspectionActionBtnMulti(){
		inspectionpage.verifyMultiEventActionBtn();
	}

	@QAFTestStep(description="Verify delete button for multi inspection events")
	public void verifyDeleteInspectionMulti(){
		inspectionpage.verifyDeleteBtnClick();
	}

	@QAFTestStep(description="Verify the action dropdown for single event selection")
	public void verifyInspectionActionBtnSingle(){
		inspectionpage.verifySingleEventActionBtn();
	}

	@QAFTestStep(description="Verify the export functionality of the multiple inspection item for inspection {InspectionName}")
	public void exportPDFReportMultiRecords(String inspectionName){
		inspectionpage.exportPDFForMultiRecordItems();
	}

	@QAFTestStep(description="Verify the export functionality of the single inspection item for inspection {InspectionName}")
	public void exportPDFReportSingleRecords(String inspectionName){
		inspectionpage.exportPDFForSingleRecordItems();
	}

	@QAFTestStep(description="Verify the pdf content of inspection report for inspection {InspectionName} with conveyor {ConveyorName1}")
	public void verifyPDFItemReportContents(String inspectionName, String conveyorName){
		inspectionpage.verifyPDFConveyor(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName, conveyorName);
	}

	@QAFTestStep(description="Delete inspection items record for inspection {InspectionName}")
	public void deleteInspectionItems(String inspectionName){
		inspectionpage.deleteInspectionItem();
	}

	@QAFTestStep(description="Verify the {InspectionName} is not visible in item list")
	public void verifyInspectionEventPresent(String inspectionName){
		inspectionpage.verifyDeleteInspectionItem(inspectionName);
	}

	@QAFTestStep(description="Verify the delete functionality of the inspection item for conveyor {ConveyorName1}")
	public void verifyInspectionItems(String conveyor){
		inspectionpage.verifyDeleteInspectionItem(conveyor);
	}

	@QAFTestStep(description="Verify the status when to be completed for {InspectionName} with {StatusCount}")
	public void verifyToBeCompletedStatus(String inspectionName, String statusCount){
		inspectionpage.verifyStatusForToBeCompleted(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName, statusCount);
	}

	@QAFTestStep(description="Verify the status when completed for {InspectionName}")
	public void verifyCompletedStatus(String inspectionName){
		inspectionpage.verifyStatusForCompleted(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
	}

	@QAFTestStep(description="Verify the conditions flag column for inspection {InspectionName} with {FlagCount}")
	public void verifyFlagColumn(String inspectionName, String flagCount){
		inspectionpage.searchInspection(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
		System.out.println(sortingInspectionItem.getSortedItems());
		inspectionpage.verifyFlagColumn(sortingInspectionItem.getSortedItems(),flagCount);
	}

	@QAFTestStep(description="Expand the inspection event to display inspection items for {InspectionName}")
	public void verifyExpandFunctionality(String inspectionName){
		inspectionpage.verifyInspectionExpand(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
	}

	@QAFTestStep(description="Verify the column displayed for expanded list table")
	public void verifyColumnsForExpandedListItem(){
		inspectionpage.verifyExpandedListViewColumns();
	}

	@QAFTestStep(description="Verify the all inspection items are present in expanded view")
	public void verifyAllExpandedListItem(){
		inspectionpage.verifyAllInspectionItems(sortingInspectionItem.getSortedItems());
	}

	@QAFTestStep(description="Verify the all inspection items are present in expanded view for VMC")
	public void verifyAllExpandedListItemVMC(){
		sortingInspectionItem.switchComparator(true);
		List<Item> items = sortingInspectionItem.getSortedItems();
		items.forEach(System.out::println);
		inspectionpage.verifyAllInspectionItemsVMC(items);
	}

	@QAFTestStep(description="Verify the location column for map popup in expanded view")
	public void verifyLocationExpandedListItem(){
		inspectionpage.verifyExpandedListMapLocation();
	}

	@QAFTestStep(description="Verify the inspection event pagination count")
	public void verifyPaginationCount(){
		Map<String, Object> response = inspectionpage.apiBase.getConveyorsInspectionCount();
		String totalInspectionEvents = String.valueOf((int)response.get("totalInspections"));
		System.out.println(totalInspectionEvents);
		inspectionpage.inspectionEventsListCount(totalInspectionEvents);
	}

	@QAFTestStep(description="Verify inspection event navigation to next pagination screen")
	public void verifyPaginationNavigation(){
		inspectionpage.inspectionPaginationFunctionality();
	}

	@QAFTestStep(description="Verify inspection event the page limit functionality")
	public void verifyPaginationLimit(){
		inspectionpage.inspectionPaginationLimit();
	}

	@QAFTestStep(description="Verify the search functionality of the inspection event with {SearchTxt}")
	public void searchInspectionEventAndClick(String searchTxt){
		Validator.assertTrue(inspectionpage.searchForInspectionEvent(searchTxt),"Search filter is failing", "Search filter verified successfully");
	}

	@QAFTestStep(description="Verify the search functionality of the dashboard event with {SearchTxt}")
	public void searchDashboardEventAndClick(String searchTxt){
		Validator.assertTrue(inspectionpage.searchForDashboardEvent(searchTxt),"Search filter is failing", "Search filter verified successfully");
	}

	@QAFTestStep(description="Verify the total inspection event count with list")
	public void verifyInspectionCardCountWithList(){
		inspectionpage.verifyInspectionListWithCardCount((int) getBundle().getProperty("totalInspections"));
	}

	@QAFTestStep(description="Add filter functionality with status {TobeCompleted}")
	public void AddFilterToBeCompleted(String status){
		inspectionpage.addItemStatusFilter(status);
	}

	@QAFTestStep(description="Add filter functionality with condition {val}")
	public void verifyFilterCondition(String condition){
		inspectionpage.addItemConditionFilter(condition);
	}

	@QAFTestStep(description="Verify the condition column item filter with {0} {1}")
	public void verifyTheConditionColumnItemFilterWith(String condition, String columnNumber){
		inspectionpage.verifyItemConditionFilter(condition,columnNumber);
	}

	@QAFTestStep(description="Verify the filter functionality with status {TobeCompleted}")
	public void verifyInspectionCountWithFilterToBeCompleted(String status){
		inspectionpage.addItemStatusFilter(status);
		System.out.println((int) getBundle().getProperty("toBeCompleted"));
		SyncUtil.waitFor(1000);
		inspectionpage.verifyInspectionListWithCardCount((int) getBundle().getProperty("toBeCompleted"));
	}

	@QAFTestStep(description="Verify the filter functionality with condition {val}")
	public void verifyInspectionCountWithFilterCondition(String condition){
		inspectionpage.addItemStatusFilter("to be completed");
		inspectionpage.addItemConditionFilter(condition);
		SyncUtil.waitFor(1000);
		inspectionpage.verifyInspectionListWithCardCount((int) getBundle().getProperty(condition.toLowerCase()));
	}

	@QAFTestStep(description="Verify all the column for inspection item list")
	public void verifyColumnsInspectionItems(){
		Validator.assertTrue(inspectionpage.verifyColumnInspectionItems(),"All columns are not present in inspection item list", "All columns in inspection item list verified successfully");
	}

	@QAFTestStep(description="Enable all columns from column selection")
	public void enableAllColumnSelection(){
		inspectionpage.enableAllColumnSelection();
	}

	@QAFTestStep(description="Verify edit inspection item from list {ConveyorName} to {EditStatus}")
	public void editInspectionItemFromItemList(String conveyorName, String newStatus){
		inspectionpage.verifyEditInspectionItemListNav(conveyorName, newStatus);
	}

	@QAFTestStep(description="Verify deleted inspection item from list {ConveyorName} for {Asset}")
	public void deleteInspectionItemFromItemList(String conveyorName, String asset){
		sortingInspectionItem.deleteItem(conveyorName, asset);
		inspectionpage.verifyDeleteInspectionItemListNav(asset);
	}

	@QAFTestStep(description="Add inspection event from api with file {FileName} for conveyor {CustSiteName} for {InspectionName}")
	public void addInspectionEventAPI(String fileName, String custSiteName, String inspectionName){
		inspectionpage.apiBase.deleteInspectionAPI(corpPage.apiBase.getInspectionAPI(inspectionName));
		inspectionpage.refreshTable();
		String companyId = inspectionpage.apiBase.getCompanyID(corpPage.apiBase.getCompanyAPI(custSiteName));
		Validator.assertTrue(inspectionpage.apiBase.createInspectionAPI(fileName, companyId, inspectionName) == 201,"Inspection event creation via api failed", "Inspection via api created successfully");
	}

	@QAFTestStep(description="Refresh the item table contents")
	public void refreshTable(){
		inspectionpage.refreshTable();
		SyncUtil.waitFor(2000);
	}

	@QAFTestStep(description="Verify data displayed in report header and footer for {FullName} {CustSiteName} {InspectionName}")
	public void verifyPDFHeader(String fullName, String custSIteName, String inspectionName) {
		inspectionpage.verifyPDFHeader(fullName, custSIteName, LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy")) + " " + inspectionName);
	}

	@QAFTestStep(description="Verify data displayed in inspection table for {Inspection}")
	public void verifyPDFInspectionDetails(String inspectionName) {
		List<Item> items = sortingInspectionItem.getSortedItems();
		items.forEach(System.out::println);
		String conveyor = items.get(0).conveyorName();
		String asset = items.get(0).asset();
		String detail = items.get(0).condition().toString();
		String status = items.get(0).isCompleted() ? "Completed": "To Be Completed";
		inspectionpage.verifyPDFInspection(conveyor,asset,detail,status,LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
		conveyor = items.get(1).conveyorName();
		asset = items.get(1).asset();
		detail = items.get(1).condition().toString();
		status = items.get(1).isCompleted() ? "Completed": "To Be Completed";
		inspectionpage.verifyPDFInspection(conveyor,asset,detail,status,LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
		MiscUtils.deleteDownloadedFiles(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName+".pdf");
	}

	@QAFTestStep(description="Verify data displayed in inspection table for {Inspection} for VMC")
	public void verifyPDFInspectionDetailsVMC(String inspectionName) {
		sortingInspectionItem.switchComparator(true);
		List<Item> items = sortingInspectionItem.getSortedItems();
		items.forEach(System.out::println);
		String conveyor = items.get(0).conveyorName();
		String asset = items.get(0).asset();
		String detail = items.get(0).condition().toString();
		String status = items.get(0).isCompleted() ? "Completed": "To Be Completed";
		inspectionpage.verifyPDFInspection(conveyor,asset,detail,status,LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
		conveyor = items.get(1).conveyorName();
		asset = items.get(1).asset();
		detail = items.get(1).condition().toString();
		status = items.get(1).isCompleted() ? "Completed": "To Be Completed";
		inspectionpage.verifyPDFInspection(conveyor,asset,detail,status,LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
		MiscUtils.deleteDownloadedFiles(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName+".pdf");
	}

	@QAFTestStep(description="Verify the inspection pdf report for metric for {InspectionName}")
	public void inspectionReportMetric(String inspectionName) {
		inspectionpage.verifyMetricUnitPDF(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
		MiscUtils.deleteDownloadedFiles(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName+".pdf");
	}

	@QAFTestStep(description="Verify the inspection pdf report for imperial for {InspectionName}")
	public void inspectionReportImperial(String inspectionName) {
		inspectionpage.verifyImperialUnitPDF(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
		MiscUtils.deleteDownloadedFiles(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName+".pdf");
	}

	@QAFTestStep(description="Switch the unit conversion to {imperial}")
	public void switchUnits(String units) {
		inspectionpage.switchUnits(units);
	}

	@QAFTestStep(description="Verify the asset display sequence for VMC")
	public void assetDisplaySequenceVMC() {
		Validator.assertTrue(inspectionpage.assetDisplaySequenceVMC(),"Asset display sequence is not correct for VMC", "Asset display sequence for VMC verified successfully");
	}

	@QAFTestStep(description="Verify the asset tail pulley detail sequence")
	public void assetDetailTailPulleyVMC() {
		Validator.assertTrue(inspectionpage.assetTailPulleyVMC(),"Asset details display sequence is not correct for asset tail pulley", "Asset details display sequence for tail pulley asset verified successfully");
	}

	@QAFTestStep(description="Verify the asset belt detail sequence")
	public void assetDetailBeltVMC() {
		Validator.assertTrue(inspectionpage.assetBeltVMC(),"Asset details display sequence is not correct for asset belt", "Asset details display sequence for belt asset verified successfully");
	}

	@QAFTestStep(description="Verify the asset other pulley detail sequence")
	public void assetDetailOtherPulleyVMC() {
		Validator.assertTrue(inspectionpage.assetOtherPulleyVMC(),"Asset details display sequence is not correct for asset other pulley", "Asset details display sequence for other pulley verified successfully");
	}

	@QAFTestStep(description="Verify the asset belt alignment detail sequence")
	public void assetDetailBeltAlignmentVMC() {
		Validator.assertTrue(inspectionpage.assetBeltAlignmentVMC(),"Asset details display sequence is not correct for asset belt alignment", "Asset details display sequence for belt alignment verified successfully");
	}

	@QAFTestStep(description="Verify the asset idlers detail sequence")
	public void assetDetailIdlersVMC() {
		Validator.assertTrue(inspectionpage.assetIdlersVMC(),"Asset details display sequence is not correct for asset idlers", "Asset details display sequence for idlers verified successfully");
	}

	@QAFTestStep(description="Verify the asset driver pulley detail sequence")
	public void assetDetailDriverPulleyVMC() {
		Validator.assertTrue(inspectionpage.assetDrivePulleyVMC(),"Asset details display sequence is not correct for asset driver pulley", "Asset details display sequence for driver pulley verified successfully");
	}

	@QAFTestStep(description="Verify the asset sequencing logic for default template")
	public void assetDisplaySequenceDefault() {
		Validator.assertTrue(inspectionpage.assetDefault(),"Asset display sequence is not correct for default template", "Asset display sequence for default template verified successfully");
	}

	@QAFTestStep(description="Verify the details field for selected asset {ConveyorName} {Asset}")
	public void assetDetailDisplaySequenceDefault(String conveyorName, String assetName) {
		if(assetName.equalsIgnoreCase("Chutes/Load Area"))
			Validator.assertTrue(inspectionpage.assetDetailsDefaultForChutes(conveyorName),"Asset details display sequence is not correct for for chute/load area", "Asset details display sequence for for chute/load area verified successfully");
		else if(assetName.equalsIgnoreCase("Counterweight"))
			Validator.assertTrue(inspectionpage.assetDetailsDefaultForCounterweight(conveyorName),"Asset details display sequence is not correct for counterweight", "Asset details display sequence for counterweight verified successfully");
		else Validator.assertTrue(inspectionpage.assetDetailsDefaultForConveyorStructure(conveyorName),"Asset details display sequence is not correct for conveyor structure", "Asset details display sequence for conveyor structure verified successfully");

	}

	@QAFTestStep(description="Verify the failure mode for selected asset {ConveyorName} {Asset}")
	public void assetFailureModeSequenceDefault(String conveyorName, String assetName) {
		if(assetName.equalsIgnoreCase("Chutes/Load Area"))
			Validator.assertTrue(inspectionpage.assetFailureModeDefaultForChutes(conveyorName),"Failure mode display sequence for chute/load area is not correct", "Failure mode sequence for for chute/load area verified successfully");
		else if(assetName.equalsIgnoreCase("Counterweight"))
			Validator.assertTrue(inspectionpage.assetFailureModeDefaultForCounterweight(conveyorName),"Failure mode display sequence is not correct for counterweight", "Failure mode display sequence for counterweight verified successfully");
		else Validator.assertTrue(inspectionpage.assetFailureModeDefaultForConveyorStructure(conveyorName),"Failure mode display sequence is not correct for conveyor structure", "Failure mode display sequence for conveyor structure verified successfully");

	}

	@QAFTestStep(description="Verify condition for asset {Asset} with {Details} and conveyor {ConveyorName} for default")
	public void verifyAssetDetailConditionDefault(String asset, String details, String conveyorName) {
		List<String> condition = List.of(Condition.Critical.toString(), Condition.Poor.toString(), Condition.Fault.toString(), Condition.Good.toString());
		Validator.assertTrue(inspectionpage.verifyDetailsWithConditionDefault(asset, details, conveyorName, condition),"Condition dropdown sequence is not correct for default template", "Condition dropdown display sequence for for default template verified successfully");
	}

	@QAFTestStep(description="Verify condition for asset {Asset} with {Details} and conveyor {ConveyorName} for VMC")
	public void verifyAssetDetailConditionVMC(String asset, String details, String conveyorName) {
		List<String> condition = List.of(Condition.Critical.toString(), Condition.Fault.toString(), Condition.Good.toString());
		Validator.assertTrue(inspectionpage.verifyDetailsWithConditionVMC(asset, details, conveyorName, condition),"Condition dropdown sequence is not correct for VMC template", "Condition dropdown display sequence for for VMC template verified successfully");
		if(asset.equalsIgnoreCase("Idlers"))
			Validator.assertTrue(inspectionpage.verifyGeneralMsg(),"General message not found", "General message verified successfully");
		else Validator.assertTrue(inspectionpage.verifyNoGeneralMsg(),"General message was found", "General message verified successfully");
	}

	@QAFTestStep(description="Verify condition for asset {Asset} with {Details} and conveyor {ConveyorName} for VMC belt overall")
	public void verifyAssetDetailConditionVMCOffOverall(String asset, String details, String conveyorName) {
		List<String> condition = List.of(Condition.Critical.toString(),Condition.Fault.toString(), Condition.Good.toString());
		Validator.assertTrue(inspectionpage.verifyDetailsWithConditionVMC(asset, details, conveyorName, condition),"Condition dropdown sequence is not correct for VMC template", "Condition dropdown display sequence for for VMC template verified successfully");
		Validator.assertTrue(inspectionpage.verifyBeltAlignmentMsgOverall(),"Belt alignment message not found", "Belt alignment message verified successfully");
	}

	@QAFTestStep(description="Verify condition for asset {Asset} with {Details} and conveyor {ConveyorName} for VMC belt")
	public void verifyAssetDetailConditionVMCOff(String asset, String details, String conveyorName) {
		List<String> condition = List.of(Condition.Fault.toString(), Condition.Good.toString());
		Validator.assertTrue(inspectionpage.verifyDetailsWithConditionVMC(asset, details, conveyorName, condition),"Condition dropdown sequence is not correct for VMC template", "Condition dropdown display sequence for for VMC template verified successfully");
		Validator.assertTrue(inspectionpage.verifyBeltAlignmentMsg(),"Belt alignment message not found", "Belt alignment message verified successfully");
	}

	@QAFTestStep(description="Verify for the condition {Critical} observation field is mandatory")
	public void verifyObservationMandatory(String condition) {
		Validator.assertTrue(inspectionpage.verifyObservationAsterisk(condition),"Observation asterisk was not found", "Observation as mandatory verified successfully");
		Validator.assertTrue(inspectionpage.verifyObservationMandatory(),"After entering observation field create btn is still disabled", "After entering observation field create btn verified successfully");

	}

	@QAFTestStep(description="Verify for the condition {Good} observation field is optional")
	public void verifyObservationOptional(String condition) {
		Validator.assertTrue(inspectionpage.verifyObservationNonMandatory(condition),"Observation was mandatory", "Observation as optional verified successfully");
	}

	@QAFTestStep(description="Verify the image zoom in capabilities")
	public void verifyImageZoomIn() {
		inspectionpage.imageZoomInFunctionality();
	}

	@QAFTestStep(description="Verify the image zoom out capabilities")
	public void verifyImageZoomOut() {
		inspectionpage.imageZoomOutFunctionality();
	}

	@QAFTestStep(description="Verify the site logo functionality in pdf report for {InspectionName}")
	public void verifyPDFReportSiteLogo(String inspectionName) throws IOException {
		inspectionpage.getPdfImages(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
	}

	@QAFTestStep(description="Verify the site and item logo functionality in pdf report for {InspectionName}")
	public void verifyPDFReportInspectionLogo(String inspectionName) throws IOException {
		inspectionpage.getPdfImages(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+inspectionName);
	}

	@QAFTestStep(description="Verify the duplicate inspection item for VMC {ConveyorName} with {AssetName1} {AssetDetails}")
	public void verifyDuplicateInspectionItems(String conveyorName, String assetName, String assetDetails) throws IOException {
		inspectionpage.verifyDuplicateItemRecordsVMC(conveyorName,assetName,assetDetails);
	}

	@QAFTestStep(description="Verify the export functionality of the inspection dashboard")
	public void exportPDFDashboard(){
		inspectionpage.exportPDFDashboard();
	}

	@QAFTestStep(description="Verify the pdf content of inspection report for coporate {CustCorpName} with conveyor {FullName}")
	public void verifyExportPDFDashboard(String corpName, String fullName){
		inspectionpage.verifyPDFDashboardContents(corpName, fullName);
	}

	@QAFTestStep(description="Verify the header of the inspection dashboard screen")
	public void verifyDashboardHeader(){
		Validator.assertTrue(inspectionpage.verifyDashboardHeader(),"Dashboard Header is not visible", "Dashboard header verified successfully");
	}

	@QAFTestStep(description="Verify the options available in inspection dashboard screen")
	public void verifyOptionsAvailableInDashboard(){
		Validator.assertTrue(inspectionpage.verifyDashboardOptions(),"Dashboard Header is not visible", "Dashboard header verified successfully");
	}

	@QAFTestStep(description="Verify the action dropdown for inspection dashboard")
	public void verifyActionDropdownDashboard(){
		Validator.assertTrue(inspectionpage.verifyActionDropdownDashbaord(),"Dashboard action export pdf is not visible", "Dashboard action export pdf verified successfully");
	}

	@QAFTestStep(description="Verify the event cards in dashboard screen")
	public void verifyEventCards(){
		Validator.assertTrue(inspectionpage.verifyConditionCards(),"Dashboard event cards is not visible", "Dashboard event cards verified successfully");
	}

	@QAFTestStep(description="Verify the event cards in dashboard screen for VMC")
	public void verifyEventCardsVMC(){
		Validator.assertTrue(inspectionpage.verifyConditionCardsVMC(),"Dashboard event cards is not visible", "Dashboard event cards verified successfully");
	}

	@QAFTestStep(description="Verify the item list table in dashboard screen")
	public void verifyEventTable(){
		Validator.assertTrue(inspectionpage.verifyDashboardTable(),"Dashboard event list table is not visible", "Dashboard event list table verified successfully");
	}

	@QAFTestStep(description="Verify the item list table in dashboard screen for VMC")
	public void verifyEventTableVMC(){
		Validator.assertTrue(inspectionpage.verifyDashboardTableVMC(),"Dashboard event list table is not visible", "Dashboard event list table verified successfully");
	}


	@QAFTestStep(description="Verify the site selection functionality for {CustSiteName}")
	public void verifyDashboardSiteSelection(String siteName){
		Validator.assertTrue(inspectionpage.verifySiteSelection(siteName).equalsIgnoreCase(siteName),"Dashboard site selection failed", "Dashboard site selection verified successfully");
	}

	@QAFTestStep(description="Verify the from field date functionality for {CustSiteName}")
	public void verifyDashboardFromDateSelection(String siteName){
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
		Validator.assertTrue(inspectionpage.verifyDateSelection(siteName).equalsIgnoreCase(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))),"Dashboard from date selection failed", "Dashboard from date selection verified successfully");
	}

	@QAFTestStep(description="Verify the to field date functionality for {CustSiteName}")
	public void verifyDashboardToDateSelection(String siteName){
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
		Validator.assertTrue(inspectionpage.verifyEndDateSelection(siteName).equalsIgnoreCase(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))),"Dashboard end date selection failed", "Dashboard end date selection verified successfully");
	}

	@QAFTestStep(description="Verify all the column for inspection dashboard event table list")
	public void verifyDashboardEventTable(){
		Validator.assertTrue(inspectionpage.verifyDashboardTable(),"Dashboard event table verification failed", "Dashboard event table verified successfully");
	}

	@QAFTestStep(description="Verify all the column for inspection dashboard event table list for VMC")
	public void verifyDashboardEventTableVMC(){
		Validator.assertTrue(inspectionpage.verifyDashboardTableVMC(),"Dashboard event table verification failed", "Dashboard event table verified successfully");
	}
}


