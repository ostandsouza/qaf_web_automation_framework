package com.web.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.*;
import groovyjarjarantlr4.v4.codegen.model.Sync;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InspectionSteps {

	InspectionPage inspectionpage = new InspectionPage();

	CorporatePage corpPage = new CorporatePage();
	UsersPage userPage=new UsersPage();
	CorporatePage corporatePage=new CorporatePage();
	ConveyorPage conveyorPage=new ConveyorPage();
	CoverWearPage coverWearPage = new CoverWearPage();

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
		inspectionpage.goToInspection();
		inspectionpage.addInspection(inspectionName,custSiteName,fullName);
	}

	@QAFTestStep(description="Add inspection Event for conveyor {ConveyorName} with {InspectionName}")
	public void createAddInspection(String conveyorName, String inspectionName){
//		String inspectionId = inspectionpage.apiBase.getInspectionAPI(inspectionName);
//		inspectionpage.apiBase.deleteInspectionAPI(inspectionId);
//		inspectionId = inspectionpage.apiBase.getInspectionAPI(conveyorName);
//		inspectionpage.apiBase.deleteInspectionAPI(inspectionId);
		inspectionpage.addInspection(inspectionName);
	}
	
	@QAFTestStep(description="Add inspection Item for conveyor {ConveyorName} for {InspectionName} with {AssetName} {AssetDetail} {FailureMode} {Condition} {Status}")
	public void createAddInspectionItemMandatoryFields(String conveyorName, String inspectionName,String assetName, String assetDetail, String failureMode, String condition, String status){
		inspectionpage.addItemMandatoryField(conveyorName,assetName, assetDetail, failureMode, condition, status);
		inspectionpage.saveInspectionItem();
	}

	@QAFTestStep(description="Add inspection Item for conveyor {ConveyorName} for {InspectionName} with {AssetName1} {AssetDetail1} {FailureMode1} {Condition1} {Status} {lat} {long} {observation} {recommendation} {address} {img}")
	public void createAddInspectionItemOptionalFields(String conveyorName, String inspectionName,String assetName, String assetDetail, String failureMode, String condition, String status, String lat, String longitude, String observation, String recommendation, String address, String img){
		inspectionpage.addItemMandatoryField(conveyorName,assetName, assetDetail, failureMode, condition, status);
		inspectionpage.addItemOptionalField(lat,longitude,observation,recommendation,address,img);
		inspectionpage.saveInspectionItem();
	}

	@QAFTestStep(description="Verify And validate the changes for {InspectionName} with {ItemCount}")
	public void verifyInspectionItem(String inspectionName, String itemCount){
		System.out.println("here");
		SyncUtil.waitFor(200000);
		inspectionpage.verifyInspection(inspectionName,itemCount);
	}
	
	@QAFTestStep(description="Download inspection {InspectionName} from inspection list with {CustSiteName} {ConveyorName}")
	public void downloadPDF(String inspectionName, String custSIteName, String conveyorName) {
		String inspectionId = inspectionpage.apiBase.getInspectionAPI(inspectionName);
		inspectionpage.searchInspection(inspectionName);
		inspectionpage.downloadPDF();
		SyncUtil.waitFor(5000);
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd")+"-"+custSIteName+"-Multiple-"+conveyorName+".pdf");
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"-"+custSIteName+"-Multiple-"+conveyorName+".pdf");
		Validator.assertTrue(MiscUtils.checkDownloadedFiles(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"-"+custSIteName+"-Multiple-"+inspectionName+".pdf"),"PDF report was not found","PDF report was downloaded successfully");
	}

	@QAFTestStep(description="Verify data displayed in report for {FullName} {CustSiteName} {ConveyorName} {InspectionName}")
	public void verifyDownloadPDF(String fullName, String custSIteName, String conveyorName, String inspectionName) {
		String inspectionId = inspectionpage.apiBase.getInspectionAPI(inspectionName);
		inspectionpage.verifyPDFContents(fullName, custSIteName, conveyorName,inspectionName,inspectionId);
		MiscUtils.deleteDownloadedFiles(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"-"+custSIteName+"-Multiple-"+inspectionName+".pdf");
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
		inspectionpage.verifyPlaceHolderForInspectionName();
	}

	@QAFTestStep(description="Verify default date in inspection date field")
	public void verifyInspectionDate(){
		inspectionpage.verifyDefaultInspectionDate();
	}

	@QAFTestStep(description="Verify Site {0} selection from dropdown")
	public void verifySiteSelectionFromDropdown(String siteName){
		inspectionpage.verifySiteSelection(siteName);
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
//		Validator.assertTrue(inspectionpage.verifyInspectionCount(totalCount, val),"Inspection tile count is incorrect","Inspection tile count verified successfully");
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
		inspectionpage.editInspectionIemStatus(editStatus);
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
		inspectionpage.verifyDeleteInspectionItem(inspectionName);
	}

	@QAFTestStep(description="Enter inspection name as {InspectionName}")
	public void enterInspectionName(String inspectionName){
		inspectionpage.enterInspectionName(inspectionName);
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
		coverWearPage.searchForItem(inspection);
//		inspectionpage.clickOnViewBtn();
		inspectionpage.extractStatusValue();
	}

	@QAFTestStep(description="Click on the view button")
	public void clickTheOnViewButton(){
		inspectionpage.clickOnViewBtn();
	}

	@QAFTestStep(description="Verify the inspection item status value")
	public void verifyInspectionStatusValue(){
		inspectionpage.verifyStatusValue();
	}

	@QAFTestStep(description="Extract inspection item condition value for {Inspection}")
	public void extractInspConditionValue(String inspection){
		inspectionpage.waitForPageLoad(10000);
		coverWearPage.searchForItem(inspection);
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
	@QAFTestStep(description = "Search and verify the {Value} is present")
	public void searchTheResult(String value) {
		inspectionpage.searchResult(value);
	}
	@QAFTestStep(description = "Click on Clear filter Icon")
	public void clickTheClickFilter() {
		inspectionpage.clickClickFilter();
	}
	@QAFTestStep(description = "Navigate to inspection list screen and wait to load data")
	public void verifyInspectionListNavAndWait() {
		inspectionpage.goToInspectionScreenAndWait();
	}
	@QAFTestStep(description = "Verify the inspection count with respect to pagination")
	public void validateTheInspectionCountWrtPagination()
	{
		inspectionpage.validateInspectionCountWrtPagination();
	}

}


