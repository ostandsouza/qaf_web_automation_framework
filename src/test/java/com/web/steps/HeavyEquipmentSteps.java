package com.web.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.*;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.HeavyEquipmentPage;
import com.web.pages.MinutemanPage;

public class HeavyEquipmentSteps extends BasePage {
    HeavyEquipmentPage heavyEquipmentPage = new HeavyEquipmentPage();
    FabricSplicePage fabricSplicePage = new FabricSplicePage();
    FileManagerPage fileManagerPage = new FileManagerPage();
    CoverWearPage coverWearPage = new CoverWearPage();
    MonitoringDevicePage monitoringDevicePage = new MonitoringDevicePage();
    ConveyorPage conveyorPage = new ConveyorPage();
    UsersPage userPage = new UsersPage();
    CordInspectPage cordInspectPage=new CordInspectPage();

    String[] heavyEquipmentColNames = {"Name", "Model", "Year of Manufacture", "Serial Number", "Distributor Shop", "Category"};

    @QAFTestStep(description = "Navigate to the Heavy Equipment list page")
    public void navigateToTheHeavyEquipmentListPage() {
        heavyEquipmentPage.navigateHeavyEquipmentListPage();
    }

    @QAFTestStep(description = "Navigate to the Heavy Equipment add page")
    public void navigateToTheHeavyEquipmentAddPage() {

        Validator.assertTrue(heavyEquipmentPage.navigateAddHeavyEquipmentPage(),"User does not permission to add a Heavy Equipment record","User has permission to add a Heavy Equipment record");
    }

    @QAFTestStep(description = "Navigate to edit heavy equipment page")
    public void editHeavyEquipmentSplice() {
        fabricSplicePage.editRecord();
        heavyEquipmentPage.verifyEditPage();
    }

    @QAFTestStep(description = "Search for the heavy equipment {HeavyEquipmentName}")
    public void searchHeavyEquipment(String heavyEquipment) {
//        heavyEquipmentPage.navigateAddHeavyEquipmentPage();
        heavyEquipmentPage.navigateHeavyEquipmentListPage();
        heavyEquipmentPage.goToHeavyEquipmentPageAndWait();
        Validator.assertTrue(fabricSplicePage.searchForTheRecord(heavyEquipment), "The heavy equipment created is not found ", "The heavy equipment created is found");

    }
    @QAFTestStep(description = "Navigate to heavy equipment page and wait")
    public void navigateToHeavyEquipmentPageAndWait() {
        heavyEquipmentPage.goToHeavyEquipmentPageAndWait();
    }

    @QAFTestStep(description = "Create a heavy equipment with {HeavyEquipmentName} {Category} {Model} {Year} {SerialNumber} {DistShopName} {ImageName} and click on cancel")
    public void addHeavyEquipmentAndClickOnCancel(String name, String category, String model, String year, String serialNumber, String distShopName, String imageName) {
        heavyEquipmentPage.createHeavyEquipment(name, category, model, year, serialNumber, distShopName, imageName);
        monitoringDevicePage.cancelBtnClick();
        Validator.assertTrue(this.getCurrentURL().contains("secure/dashboard/heavy-equipment"), "User is navigated not to heavy equipment list page", "User is navigated to heavy equipment list page");
    }


    @QAFTestStep(description = "Create a heavy equipment with {HeavyEquipmentName} {Category} {Model} {Year} {SerialNumber} {DistShopName} {ImageName}")
    public void createTheHeavyEquipment(String name, String category, String model, String year, String serialNumber, String distShopName, String imageName) {
        heavyEquipmentPage.createHeavyEquipment(name, category, model, year, serialNumber, distShopName, imageName);
        conveyorPage.clickCreateBtn();
        Validator.assertTrue(this.getCurrentURL().contains("secure/dashboard/heavy-equipment"), "User is navigated not to heavy equipment list page", "User is navigated to heavy equipment list page");

    }

    @QAFTestStep(description = "Edit the Heavy Equipment {editHeavyEquipmentName} {Category}")
    public void editHeavyEquipment(String editHeavyEquipment, String category) {
        heavyEquipmentPage.editHeavyEquipmentDetails(editHeavyEquipment, category);
    }

    @QAFTestStep(description = "Click on add Icon and upload the file {ImageName}")
    public void addDocument(String file1) {
        heavyEquipmentPage.uploadDocument(file1);
    }

    @QAFTestStep(description = "Verify and view the image uploaded {ImageName}")
    public void verifyImageDocument(String file1) {
        fileManagerPage.verifyFilePresent(file1);
        fileManagerPage.openImageDocument(file1);
    }

    @QAFTestStep(description = "Verify and view the pdf file uploaded {PdfFile}")
    public void verifyPDFDocument(String file1) {
        fileManagerPage.verifyFilePresent(file1);
        fileManagerPage.openPdfDocument(file1);
    }

    @QAFTestStep(description = "Click on save button and verify the Heavy Equipment {EditHeavyEquipmentName} is edited")
    public void saveAndVerifyTheHeavyEquipmentEdited(String editHeavyEquipmentName) {
        coverWearPage.btnSaveClick();
        heavyEquipmentPage.goToHeavyEquipmentPageAndWait();
//        SyncUtil.waitFor(40000);
        Validator.assertTrue(fabricSplicePage.searchForTheRecord(editHeavyEquipmentName), "The heavy equipment name is not edited", "The heavy equipment name is edited");

    }

    @QAFTestStep(description = "Verify search and delete document {ImageName} functionality")
    public void searchAndDeleteDocument(String fileName) {
        fileManagerPage.verifyFilePresent(fileName);
        heavyEquipmentPage.deleteDoc(fileName);
    }

    @QAFTestStep(description = "Verify file download functionality for {UploadPdf}")
    public void verifyTheFileDownloadFun(String file) {
        heavyEquipmentPage.verifyFileDownloadFun(file);
    }

    @QAFTestStep(description = "Click on view more icon")
    public void clickOnTheViewMoreBtn() {
        heavyEquipmentPage.clickViewMoreBtn();
    }

    @QAFTestStep(description = "Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page")
    public void verifyNavigationToHeavyEquipmentPageViaCardClick()
    {
        heavyEquipmentPage.verifyHeavyEquipmentCardClick();
        Validator.assertTrue(this.getCurrentURL().contains("/heavy-equipment"), "User is navigated not to heavy equipment list page", "User is navigated to heavy equipment list page");
    }
    @QAFTestStep(description = "Verify the count of records linked to the Distributor Shops in the Heavy Equipment Listing page")
    public void verifyCountOfHeavyEquipmentRecords()
    {
        heavyEquipmentPage.goToHeavyEquipmentPageAndWait();
        heavyEquipmentPage.verifyHeavyEquipmentCount();
    }
    @QAFTestStep(description = "Verify Heavy Equipment card is not visible in customer corporate page")
    public void verifyHeavyEquipmentCardVisibilityForCustomerCorp()
    {
        heavyEquipmentPage.verifyHeavyEquipCardVisibility();
    }
    @QAFTestStep(description = "Edit the Internal Tools permission {EditAdd} {EditEdit} {EditDelete} {EditView} {EditDownload} and save")
    public void editInternalToolsPermission(String add,String edit, String delete, String view, String download)
    {
        userPage.editInternalToolsPermission(add,edit,delete,view,download);
    }
    @QAFTestStep(description = "Verify user does not have edit download delete rights")
    public void verifyPermissionRightsForHeavyEquipment()
    {
        Validator.assertTrue(fabricSplicePage.verifyActionBtnPermissions(),"User has  permission to edit,delete and download","User has no permission to edit,delete and download");
    }
    @QAFTestStep(description = "Verify only the records with searched year {Year} appears in the table")
    public void verifySearchedRecordVisibility(String year)
    {
        int noOfInspections = Integer.parseInt(MiscUtils.regexExtractor(heavyEquipmentPage.paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        heavyEquipmentPage.verifyHeavyEquipmentList(noOfInspections, year, 5);
    }
    @QAFTestStep(description = "Verify the header and all the column names in heavy equipment page")
    public void verifyHeavyEquipmentTableHeaders()
    {
       heavyEquipmentPage.verifyHeavyEquipmentData();
    }
    @QAFTestStep(description = "Verify the heavy equipment count with respect to pagination")
    public void validateTheHeavyEquipmentCountWrtPagination()
    {
        heavyEquipmentPage.validateHeavyEquipmentCountWrtPagination();
    }

    @QAFTestStep(description = "Click on column header and verify sorting functionality for heavy equipment list page")
    public void verifytheSortingFunctionality()
    {
        cordInspectPage.clickOnColumnsHeader(true,heavyEquipmentColNames,3);
    }

    @QAFTestStep(description = "Click on each column header of heavyEquipment list and verify filter icon fields")
    public void clickAndVerifyHeavyEquipmentFilterFunctionality() {
        conveyorPage.columnNameFilterBtnClick(heavyEquipmentColNames);
    }
    @QAFTestStep(description = "Click on Heavy equipment link in breadcrumb")
    public void clickHeavyEquipBreadCrumb()
    {
        heavyEquipmentPage.heavyEquipmentBreadCrumbClick();
    }
    @QAFTestStep(description = "Click on the  scanner icon in list and verify fields {EditHeavyEquipmentName}")
    public void clickOnScanQRInListAndVerify(String deviceName) {
        heavyEquipmentPage.clickScannerIcon();
        monitoringDevicePage.verifyScanQR(deviceName);
    }

    @QAFTestStep(description = "Click on the page number and verify it navigates to respective page")
    public void clickAndVerifyPaginationFunctionality() {
        heavyEquipmentPage.clickAndVerifyPaginationFunction();
    }
    @QAFTestStep(description = "Click on pagination dropdown and verify records")
    public void verifyNoOfRecords() {
        heavyEquipmentPage.verifyNoOfRecordsDisplayed();
        heavyEquipmentPage.clickDefaultPaginationCount();
    }
    @QAFTestStep(description = "Verify heavy equipment card visibility")
    public void verifyHeavyEquipCard() {
        heavyEquipmentPage.verifyHeavyEquipmentCardVisibility();
    }

    @QAFTestStep(description = "Refresh the screen")
    public void refreshPageFunctionality()
    {
        heavyEquipmentPage.browserRefresh();
    }


}
