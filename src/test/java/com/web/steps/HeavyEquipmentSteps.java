package com.web.steps;

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


    @QAFTestStep(description = "Navigate to the Heavy Equipment list page")
    public void navigateToTheHeavyEquipmentListPage() {
        heavyEquipmentPage.navigateHeavyEquipmentListPage();
    }

    @QAFTestStep(description = "Navigate to the Heavy Equipment add page")
    public void navigateToTheHeavyEquipmentAddPage() {
        heavyEquipmentPage.navigateAddHeavyEquipmentPage();
    }

    @QAFTestStep(description = "Navigate to edit heavy equipment page")
    public void editFabricSplice() {
        fabricSplicePage.editRecord();
//        heavyEquipmentPage.verifyHeavyEquipmentEditPageNavigation();
    }

    @QAFTestStep(description = "Search for the heavy equipment {HeavyEquipmentName}")
    public void searchHeavyEquipment(String heavyEquipment) {
//        heavyEquipmentPage.goToHeavyEquipmentPageAndWait();
        Validator.assertTrue(fabricSplicePage.searchForTheRecord(heavyEquipment), "The heavy equipment created is not found ", "The heavy equipment created is found");

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
//        heavyEquipmentPage.goToHeavyEquipmentPageAndWait();
        SyncUtil.waitFor(40000);
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
        coverWearPage.btnSaveClick();
    }
    @QAFTestStep(description = "Verify the heavy equipment count with respect to pagination")
    public void validateTheHeavyEquipmentCountWrtPagination()
    {
        heavyEquipmentPage.validateHeavyEquipmentCountWrtPagination();
    }


}
