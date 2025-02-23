package com.web.pages;

import com.common.component.CustomElement;

import com.common.utils.ClasspathResourceHelper;
import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class HeavyEquipmentPage extends BasePage {
    @FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
    public CustomElement home;
    @FindBy(locator = "xpath=(//li//span[text()='Heavy Equipment'])[1]")
    public CustomElement heavyEquipment;
    @FindBy(locator = "xpath=//input[@placeholder='Search']")
    public CustomElement btSearchinput;
    @FindBy(locator = "xpath=//p-panel//span[text()='Heavy Equipment']")
    public CustomElement txtheavyEquipmentListHeader;
    @FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
    public CustomElement btAdd;
    @FindBy(locator = "xpath=//nav[@class='p-breadcrumb p-component']")
    public CustomElement bcAddHeavyEquipmentLink;
    @FindBy(locator = "xpath=//p-calendar//input")
    public CustomElement tbCreationDate;
    @FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
    public CustomElement pagination;
    @FindBy(locator = "xpath=//p-breadcrumb//nav[@data-pc-name=\"breadcrumb\"]")
    public CustomElement fabricSpliceBreadcrumb;

    @FindBy(locator = "xpath=(//p-dropdown[@formcontrolname='category']/div/div)[1]")
    public CustomElement drCategory;
    @FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter')]")
    public CustomElement tbFabricSpliceSearchInput;
    @FindBy(locator = "xpath=(//p-dropdown[@formcontrolname='category']/div/div)[1]")
    public CustomElement addButton;

    @FindBy(locator = "id=file-upload")
    public CustomElement upload;
    @FindBy(locator = "xpath=//p-progressspinner/div")
    public CustomElement btFileUploadingProgress;
    @FindBy(locator = "xpath=//span[text()='File Uploading']/following-sibling::div/button")
    public CustomElement btFileUploadingCloseBtn;
    @FindBy(locator = "xpath=//input[@formcontrolname='name']")
    public CustomElement tbName;
    @FindBy(locator = "xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement cbCheckbox;
    @FindBy(locator = "xpath=//button/chevrondownicon")
    public CustomElement ddlActions;
    @FindBy(locator = "xpath=//span[text()='Delete']")
    public CustomElement btnDelete;
    @FindBy(locator = "xpath=//span[text()='Yes']")
    public CustomElement btnYes;
    @FindBy(locator = "xpath=//td[contains(text(),'No')]")
    public CustomElement noList;
    @FindBy(locator = "xpath=//div[contains(text(),'Deleted Successfully')]")
    public CustomElement deleteSuccessMsg;
    @FindBy(locator = "xpath=//input[@formcontrolname='model']")
    public CustomElement tbModel;
    @FindBy(locator = "xpath=//input[@formcontrolname='serialNumber']")
    public CustomElement tbSerialNumber;
    @FindBy(locator = "xpath=//p-calendar[@formcontrolname='yearOfManufacture']")
    public CustomElement tbYearOfManufacture;
    @FindBy(locator = "xpath=//p-dropdown[@formcontrolname='distributorShop']/div/div")
    public CustomElement drDistShopDropdown;
    @FindBy(locator = "xpath=//p-dropdown[@formcontrolname='category']/div/div")
    public CustomElement drCategoryDropdown;
    @FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter')]")
    public CustomElement tbSearchDropdown;
    @FindBy(locator = "xpath=//span[text()='Create']")
    public CustomElement btCreate;
    @FindBy(locator = "xpath=//i[@class='ctp-icon-Arrow-Right']")
    public CustomElement btviewicon;
    @FindBy(locator = "xpath=(//i[contains(@class,'ctp-icon-Download')])[1]")
    public CustomElement btnDownload;
    @FindBy(locator = "xpath=//button[@disabled]//span[text()=\"Save\"]")
    public CustomElement btnSaveDisabled;
    @FindBy(locator = "xpath=//div[@class=\"p-carousel-items-content\"]//div[contains(@class, \"p-carousel-item\")]//app-card//div/*//div[text()=\"Heavy Equipment\"]")
    public CustomElement heavyEquipmentCard;
    //    @FindBy(locator = "xpath=(//app-card//div[text()='Sites' or text()='Heavy Equipment'] /..//span)[1]")
//    public CustomElement heavyEquipmentCardCount;
    @FindBy(locator = "xpath=(//app-card//div[text()='Sites' or text()='Heavy Equipment'] /..//span)[2]")
    public CustomElement heavyEquipmentCardCountShop;
    @FindBy(locator = "xpath=//p-carousel//div//button[contains(@class,\" p-carousel-next\") and @disabled]")
    public CustomElement carouselNextBtnDisabled;

    @FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
    public CustomElement paginationEntry;

    @FindBy(locator = "xpath=//button//anglerighticon")
    public CustomElement paginationNextBtn;
    @FindBy(locator = "xpath=//p-breadcrumb//ol//li//span[text()=\"Heavy Equipment\"]")
    public CustomElement heavyEquipmentLnk;
    @FindBy(locator = "xpath=//td//i[contains(@class,\"pi-qrcode\")]\n")
    public CustomElement scannerIcon;
    @FindBy(locator = "xpath=(//app-card//div[text()='Heavy Equipment'])[1]/../div/div/div/span")
    public CustomElement heavyEquipmentCardCount;

    @FindBy(locator = "xpath=//p-paginator//p-dropdown//div[@role=\"button\"]")
    public CustomElement btnPaginationCountDropdown;
    @FindBy(locator = "xpath=//p-dropdownitem//li[@role=\"option\"]//span[text()=\"10\"]")
    public CustomElement btnPaginationCountDropdownTen;
    @FindBy(locator = "xpath=//p-dropdownitem//li[@role=\"option\"]//span[text()=\"25\"]")
    public CustomElement btnPaginationCountDropdownTwentyFive;
    @FindBy(locator = "xpath=//p-dropdownitem//li[@role=\"option\"]//span[text()=\"50\"]")
    public CustomElement btnPaginationCountDropdownFifty;


    CorporatePage corporatePage = new CorporatePage();
    CoverWearPage coverWearPage = new CoverWearPage();
    CordInspectPage cordInspectPage = new CordInspectPage();

    String[] heavyEquipmentColNames = {"name", "model", "yearOfManufature", "serialNumber", "distributorShop", "category"};
    String[] ripInsertColumnNames = {"insertnumber", "position", "nextripdistance", "segment", "rfid", "width","insertbrand","insertdate","statustext","disabled"};


    public void navigateHeavyEquipmentListPage() {
        if (!heavyEquipment.isVisible()) home.click("Home");
        heavyEquipment.click("Heavy Equipment List");
        btSearchinput.isVisible("Site Page");
        waitForElementVisible(txtheavyEquipmentListHeader, 5000, 500);
        Validator.assertTrue(txtheavyEquipmentListHeader.isVisible(), "Page is not redirected to SteelCord-list page", "Redirected to SteelCord-list page");
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/dashboard/heavy-equipment"), "URL missMatch", "URL validation passed");
    }

    public void goToHeavyEquipmentPageAndWait() {
        scrollPageDown();
        String val = "";
        for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(300); stop > System.nanoTime(); ) {
            if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
                break;
            }
            val = pagination.getText();
            SyncUtil.waitFor(15000);
        }
    }

    public void verifyHeavyEquipmentCount() {
        SyncUtil.waitFor(10000);
        String cardCount;
        if (heavyEquipmentCardCount.getText().isEmpty())
            cardCount = heavyEquipmentCardCountShop.getText();
        else
            cardCount = heavyEquipmentCardCount.getText();
        String val = pagination.getText().split(" ")[5];
        System.out.println(val + "val isss");
        System.out.println(cardCount + "card count is");
        Validator.assertTrue(cardCount.equalsIgnoreCase(val), "The count of records linked to the Distributor Shops in the Heavy Equipment Listing page is incorrect", "the count of records linked to the Distributor Shops in the Heavy Equipment Listing page is correct");
    }

    public void clickViewMoreBtn() {
        waitForElementToDisplay(cbCheckbox);
        waitForElementToDisplay(btviewicon);
        btviewicon.jsClick("View Details");
        SyncUtil.waitFor(30000);
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/heavy-equipment/view/"), "User is not navigated to view heavy equipment page!", "User is not navigated to view heavy equipment page!");
    }

    public boolean navigateAddHeavyEquipmentPage() {
        btAdd.click();
        waitForPageLoad(5000);
        SyncUtil.waitFor(5000);
        waitForElementVisible(bcAddHeavyEquipmentLink, 5000, 500);
        System.out.println(bcAddHeavyEquipmentLink.getText());
        Validator.assertTrue(bcAddHeavyEquipmentLink.isVisible(), "Page is not redirected to SteelCord-Add page", "Redirected to SteelCord-Add page");
        assertEquals(bcAddHeavyEquipmentLink.getText(), "Home\nHeavy Equipment\nAdd Equipment", "Breadcrumb text does not match expected");
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/heavy-equipment/add"), "URL missMatch", "URL validation passed");
        return tbName.isVisible();
    }

    public void verifyEditPage() {
        setImplicitWait(40000, TimeUnit.MILLISECONDS);
        waitForPageLoad(10000);
        SyncUtil.waitFor(10000);
        waitForElementVisible(tbName, 15000, 500);
        waitForElementVisible(fabricSpliceBreadcrumb, 10000, 500);
        Validator.assertTrue(fabricSpliceBreadcrumb.getText().contains("Edit"), "User is not navigated to edit page", "User is  navigated to  edit page");
    }

    public void editHeavyEquipmentDetails(String name, String category) {
        btnSaveDisabled.isNotVisible(10000);
        tbName.isVisible(10000, "name");
        tbName.clear();
        tbName.type(name);
        SyncUtil.waitFor(10000);
        waitForElementVisible(drCategory, 10000, 500);
        dropdownSelectSearch(drCategory, tbFabricSpliceSearchInput, category);
    }

    public void uploadDocument(String fileName) {
        addButton.isVisible(10000, "addButton");
        String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_files").getAbsolutePath();
        upload.sendKeys(file_path, "img_upload");
        SyncUtil.waitFor(5000);
        waitForElementToInvisible(btFileUploadingProgress, 45000);
        SyncUtil.waitFor(1000);
        waitForElementToBeClickable(btFileUploadingCloseBtn);
        btFileUploadingCloseBtn.click("Upload Close Btn");

    }


    public void createHeavyEquipment(String name, String category, String model, String year, String serialNumber, String distShopName, String imageName) {
        waitForElementVisible(tbName, 5000, 1000);
        tbName.isVisible(10000, "Name");
        tbName.sendKeys(name);
        drCategoryDropdown.isVisible(10000, "Category");
        dropdownSelectSearch(drCategoryDropdown, tbSearchDropdown, category);
        tbModel.isVisible(10000, "Model");
        tbModel.type(model);
        tbYearOfManufacture.isVisible(10000, "YearOfManufacture");
        tbYearOfManufacture.click("YearOfManufacture");
        coverWearPage.selectYear(year);
        tbSerialNumber.isVisible(10000, "SerialNumber");
        tbSerialNumber.type(serialNumber);
        drDistShopDropdown.isVisible(10000, "DistributorDropdown");
        if(!distShopName.isEmpty())
            dropdownSelectSearch(drDistShopDropdown, tbSearchDropdown, distShopName);
        corporatePage.corporateImgUpload(imageName);
//        btCreate.isVisible(10000,"Create");
//        waitForElementToBeClickable(btCreate);
//        btCreate.jsClick();
//        SyncUtil.waitFor(6000);
//        Validator.assertTrue(this.getCurrentURL().contains("secure/dashboard/heavy-equipment"),"User is navigated not to heavy equipment list page","User is navigated to heavy equipment list page");
    }

    public void deleteDoc(String item) {
        waitForElementToDisplay(btSearchinput);
        btSearchinput.type(item, "Search Item");
        waitForElementToDisplay(cbCheckbox);
        SyncUtil.waitFor(3000);
        cbCheckbox.click("Checkbox");
        ddlActions.jsClick("Action");
        waitForElementToBeClickable(btnDelete);
        Validator.assertTrue(btnDelete.isVisible(), "Delete button is not visible", "Delete button is visible");
        btnDelete.click("Delete Item");
        btnYes.click("Confirm delete");
        waitForElementToDisplay(noList);
        noList.isVisible("No Item Found");
        waitForElementVisible(deleteSuccessMsg, 10000, 1000);
        Validator.assertTrue(deleteSuccessMsg.isVisible("Delete pop up"), "Delete successfully is not visible", "Deleted successfully is visible");
        btSearchinput.type(" ");
        SyncUtil.waitFor(3000);
    }

    public void downloadThePDF() {
        waitForElementVisible(btnDownload, 10000, 1000);
        btnDownload.click();
    }

    public void verifyFileDownloadFun(String file) {
        waitForPageLoad(10000);
        SyncUtil.waitFor(2000);
        downloadThePDF();
        SyncUtil.waitFor(3000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles(file), "File report was not found", "File report was downloaded successfully");
        MiscUtils.deleteDownloadedFiles(file);
    }

    public void verifyHeavyEquipmentCardClick() {
        while (heavyEquipmentCard.isNotVisible(3000)) {
            cordInspectPage.clickCarouselNextBtn();
        }
        SyncUtil.waitFor(10000);
        heavyEquipmentCard.jsClick("BeltScan Card");
        waitForPageLoad(10000);
        SyncUtil.waitFor(10000);
    }
    public void verifyHeavyEquipmentCardVisibility()
    {
        while (heavyEquipmentCard.isNotVisible(3000)) {
            cordInspectPage.clickCarouselNextBtn();
        }
    }

    public void verifyHeavyEquipCardVisibility() {
        while (carouselNextBtnDisabled.isNotVisible(50000))
            cordInspectPage.clickCarouselNextBtn();
        Reporter.log("The Heavy Equipment card is not visible for customer corporate");
    }

    public void verifyHeavyEquipmentList(int noOfData, String year, int row) {
        waitForPageLoad(10000);

        for (int i = 1; i <= noOfData; i++) {
            try {
                if (i > 10 && (i - 1) % 10 == 0) {
                    System.out.println("Navigating to the next page...");
                    paginationNextBtn.isVisible(10000, "NextButton");
                    paginationNextBtn.jsClick();

                    waitForPageLoad(5000);
                }

                int currentRow = (i - 1) % 10 + 1;
                WebElement locator = driver.findElement(By.xpath("//tr[" + currentRow + "]/td[" + row + "][contains(., '" + year + "')]"));

                waitForElementVisible(locator, 5000, 500);
                Validator.assertTrue(locator.isDisplayed(), "Heavy Equipment of " + year + " is not visible", "Heavy Equipment of " + year + " is visible");

            } catch (TimeoutException e) {
                Validator.assertTrue(false, "No Heavy Equipment found for " + year, " Heavy Equipment found for " + year);
                break;
            }
        }
    }

    public void verifyHeavyEquipmentData() {
        String[] columnNamesArray;
        if (this.getCurrentURL().contains("/secure/dashboard/heavy-equipment")) {
            columnNamesArray = heavyEquipmentColNames;
            Validator.assertTrue(txtheavyEquipmentListHeader.isVisible(10000, "HeavyEquipment"), "Heavy Equipment header is not visible", "Heavy Equipment header is visible");
        } else if (this.getCurrentURL().contains("/rip-insert/table")) {
            columnNamesArray = ripInsertColumnNames;
        }
        else
            columnNamesArray=heavyEquipmentColNames;
        for (String columnsArray : columnNamesArray) {
            setImplicitWait(20000, TimeUnit.MILLISECONDS);
            waitForElementVisible(driver.findElement(By.xpath("//thead//th[contains(@id,'" + columnsArray + "')]")), 10000, 500);
            Validator.assertTrue(driver.findElement(By.xpath("//thead//th[contains(@id,'" + columnsArray + "')]")).isDisplayed(), "The column header '" + columnsArray + "' is not visible", "The column header '" + columnsArray + "' is visible");
        }
    }

    public void heavyEquipmentBreadCrumbClick() {
        waitForElementVisible(heavyEquipmentLnk, 10000, 500);
        heavyEquipmentLnk.jsClick("Heavy equipment link");
    }

    public void clickScannerIcon() {
        waitForElementVisible(scannerIcon, 10000, 500);
        scannerIcon.jsClick("Scan QR");
    }

    public void validateHeavyEquipmentCountWrtPagination() {
        int deviceCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        System.out.println(deviceCount+"the pagination count");
        System.out.println(heavyEquipmentCardCount.getText()+"the card count from api");
//        Validator.assertTrue(apiBase.getHeavyEquipmentCount().get("count").equals(deviceCount), "Heavy Equipment Pagination Count does not match", "Heavy Equipment Pagination Count matches");
        Validator.assertTrue(Integer.toString(deviceCount).equals(heavyEquipmentCardCount.getText()), "Heavy Equipment Card Count does not match", "Heavy Equipment Card Count matches");
    }

    public void clickAndVerifyPaginationFunction() {
        int paginationEntryCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        scrollPageDown();
        for (int i = 2; i <= paginationEntryCount % 10; i++) {
            waitForElementVisible(driver.findElement(By.xpath("//p-paginator//span//button[text()=' " + i + " ']")), 10000, 500);
            driver.findElement(By.xpath("//p-paginator//span//button[text()=' " + i + " ']")).click();
            Validator.assertTrue(driver.findElement(By.xpath("//p-paginator//span//button[(text()=' " + i + " ' and @aria-current='page')]")).isDisplayed(), "User is not navigated to page number '" + i + "'", "User is navigated to page number '" + i + "'");
        }
    }

    public void clickPaginationDropdown() {
        btnPaginationCountDropdown.isVisible(10000,"10000");
        btnPaginationCountDropdown.click("paginationDropDown");
        btnPaginationCountDropdownTen.isVisible(10000, "Ten");
    }
    public void clickDefaultPaginationCount()
    {
        validatePagination(btnPaginationCountDropdownTen, "10");

    }

    public void verifyNoOfRecordsDisplayed() {
        int paginationEntryCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        System.out.println(paginationEntryCount+"paginationEntryCount iss");
        if (paginationEntryCount >=50) {
            // Validate for "10" records
            validatePagination(btnPaginationCountDropdownTen, "10");
            // Validate for "25" records
            validatePagination(btnPaginationCountDropdownTwentyFive, "25");
            // Validate for "50" records
            validatePagination(btnPaginationCountDropdownFifty, "50");
        }
        else if(paginationEntryCount>10 && paginationEntryCount<25)
        {
            // Validate for "10" records
            validatePagination(btnPaginationCountDropdownTen, "10");
            // Validate for "25" records
            validatePagination(btnPaginationCountDropdownTwentyFive, "25");
        }
        else if(paginationEntryCount>25 && paginationEntryCount<50)
        {
            validatePagination(btnPaginationCountDropdownTen, "10");
            validatePagination(btnPaginationCountDropdownTwentyFive, "25");
            clickPaginationDropdown();
            btnPaginationCountDropdownFifty.click("Fifty");
            // Additional validation when fewer than 50 records are displayed
            int paginationSelectedCountEntry = Integer.parseInt(
                    MiscUtils.regexExtractor(paginationEntry.getText(), "to\\s+(\\d+)\\s+of")
            );
                Validator.assertTrue(
                        paginationSelectedCountEntry == paginationEntryCount,
                        "Less than 50 records are not matching with the main count!",
                        "Less than 50 records are matching with the main count!"
                );

        }

    }

    /**
     * Reusable method to validate pagination entries.
     *
     * @param dropdownButton The WebElement representing the pagination dropdown option.
     * @param expectedText   The expected number of records to be displayed (e.g., "10", "25", "50").
     */
    private void validatePagination(WebElement dropdownButton, String expectedText) {
        scrollPageDown();
        clickPaginationDropdown();
        SyncUtil.waitFor(3000);
        dropdownButton.click();
        System.out.println(paginationEntry.getText()+"text is");
        int paginationSelectedRecordCount = Integer.parseInt(
                MiscUtils.regexExtractor(paginationEntry.getText(), "to\\s+(\\d+)\\s+of")
        );
        System.out.println(paginationSelectedRecordCount+"paginationSelectedRecordCount");
        System.out.println(expectedText+"expectedText");


        System.out.println(paginationSelectedRecordCount==Integer.parseInt(expectedText));
        Validator.assertTrue(
                paginationSelectedRecordCount==Integer.parseInt(expectedText),
                expectedText + " Records are not getting displayed in one go!",
                expectedText + " Records are getting displayed in one go!"
        );
    }


}
