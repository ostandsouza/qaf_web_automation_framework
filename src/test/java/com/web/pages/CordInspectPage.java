package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class CordInspectPage extends BasePage {
    CoverWearPage coverwearPage = new CoverWearPage();

    @FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
    public CustomElement home;
    @FindBy(locator = "xpath=//span[text()='Add Belt Scan']")
    public CustomElement addBeltScan;
    @FindBy(locator = "xpath=//label[text()=\"Date Of Scan \"]")
    public CustomElement tbDateOfScan;

    @FindBy(locator = "xpath=//p-dropdown[@formcontrolname=\"deviceType\"]")
    public CustomElement deviceTypeDdl;
    @FindBy(locator = "xpath=//p-dropdown[@formcontrolname=\"reasonForScan\"]")
    public CustomElement reasonForScanDdl;

    @FindBy(locator = "xpath=//p-dropdownitem//span[text()=\"CordInspect\"]")
    public CustomElement cordInspectOption;

    @FindBy(locator = "xpath=//p-dropdownitem//span[text()=\"Splice problem\"]")
    public CustomElement spliceProblemOption;
    @FindBy(locator = "xpath=//label[text()='Site ']/parent::div//div[@role='button']")
    public CustomElement ddlSiteCustomername;
    @FindBy(locator = "xpath=//label[text()='Conveyor ']/parent::div//div[@role='button']")
    public CustomElement ddlConveyorName;
    @FindBy(locator = "xpath=//label[text()='Notify CCM ']/parent::div//div[@role='button']")
    public CustomElement ddlNotifyCCM;
    @FindBy(locator = "xpath=//p-progressspinner/div")
    public CustomElement btFileUploadingProgress;

    @FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter p-inputtext')]")
    public CustomElement tbInput;
    @FindBy(locator = "xpath=(//input[@type='file'])[1]")
    public CustomElement crFileUpload;

    @FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Delete')])[1]")
    public CustomElement crDeleteFileUpload;

    @FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Delete')]/../../preceding-sibling::div)[1]")
    public CustomElement crUploadedFileName;
    @FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Delete')])[2]")
    public CustomElement crBackUpDeleteFileUpload;

    @FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Delete')]/../../preceding-sibling::div)[2]")
    public CustomElement crBackUUploadedFileName;

    @FindBy(locator = "xpath=//p-calendar//span//input")
    public CustomElement dateOfScan;
    @FindBy(locator = "xpath=//div[@class=\"p-carousel-items-content\"]/following-sibling::button[contains(@class,\"p-carousel-next \")]\n")
    public CustomElement carouselNextBtn;

    @FindBy(locator = "xpath=//div[@class=\"p-carousel-items-content\"]//div[contains(@class, \"p-carousel-item\")]//app-card//div/*//div[text()=\"Belt Scans\"]")
    public CustomElement beltScanCard;

    @FindBy(locator = "xpath=(//div//span//button[@icon=\"ctp-icon-Add-circle\"])[2]")
    public CustomElement addIcon;
    @FindBy(locator = "xpath=//li//a[contains(@class,\"p-menuitem-link-active\")]//span[text()=\" Add Scan Details\"]\n")
    public CustomElement addScanHeaderActive;
    @FindBy(locator = "//span[text()='Create']/parent::button[@disabled]")
    public CustomElement btnCreateDisabled;
    @FindBy(locator = "xpath=//li//a[contains(@class,'p-menuitem-link-active')]//span[text()=' Add Scanning Files']")
    public CustomElement addScanningFilesHeaderActive;

    @FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
    public CustomElement pagination;
    @FindBy(locator = "xpath= //th[@psortablecolumn=\"ccm.fullname\" and contains(@class,\"p-highlight\")]\n")
    public CustomElement ccmColHighlighted;

    @FindBy(locator = "xpath=//input[@placeholder='Search']")
    public CustomElement btSearchinput;

    @FindBy(locator = "xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement cbCheckbox;
    @FindBy(locator = "xpath=(//button/chevrondownicon)[2]")
    public CustomElement ddlActions;
    @FindBy(locator = "xpath=//span[text()='Delete']")
    public CustomElement btnDelete;
    @FindBy(locator = "xpath=//span[text()='Yes']")
    public CustomElement btnYes;
    @FindBy(locator = "xpath=//td[contains(text(),'No')]")
    public CustomElement noList;
    @FindBy(locator = "xpath=//p-toast//span//checkicon")
    public CustomElement deleteSuccessMsg;


    CoverWearPage coverWearPage = new CoverWearPage();

    String[] reasonForScanList = {"Regular scheduled scan", "Belt mistracking", "Splice problem", "Pulley damage", "Idler damage", "Excessive wear", "Impact damage", "Other"};
    String[] generalInfoTextBoxList = {"Date Of Scan", "Device Type", "Reason For Scan", "Site", "Conveyor", "Notify CCM", "Upload Raw Capture File", "Upload Backup File"};

    public void goToAddBeltScans() {
        waitForElementVisible(addBeltScan, 10000, 500);
        waitForElementToBeClickable(addBeltScan);
        addBeltScan.click("Add Belt Scans");
        waitForPageLoad(10000);
        tbDateOfScan.isVisible("Date of Scan");
    }

    public void addBeltScanInfo(String deviceType, String reasonForScan, String siteName, String conveyorName, String notifyCcm) {

//        dateOfScan.isVisible(10000,"dateOfScan");
//        dateOfScan.sendKeys("dateOfScan",date);
        deviceTypeDdl.isVisible(10000, "Device Type");
        deviceTypeDdl.click("Device Type");

        waitForElementVisible(driver.findElement(By.xpath("//p-dropdownitem//span[text()='" + deviceType + "']")), 10000, 500);
        driver.findElement(By.xpath("//p-dropdownitem//span[text()='" + deviceType + "']")).click();

        reasonForScanDdl.isVisible(10000, "reasonForScanDdl");
        reasonForScanDdl.click("reasonForScan");

        waitForElementVisible(driver.findElement(By.xpath("//p-dropdownitem//span[text()='" + reasonForScan + "']")), 10000, 500);
        driver.findElement(By.xpath("//p-dropdownitem//span[text()='" + reasonForScan + "']")).click();
        dropdownSelectSearch(ddlSiteCustomername, tbInput, siteName);
        dropdownSelectSearch(ddlConveyorName, tbInput, conveyorName);
        dropdownSelectSearch(ddlNotifyCCM, tbInput, notifyCcm);
        dateOfScan.isVisible(10000, "dateOfScan");
        dateOfScan.click("Date of Scan");
    }

    public void fileUpload(String fileName) {
        String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_data").getAbsolutePath();
        crFileUpload.sendKeys(file_path, "File Path");
        waitForElementToInvisible(btFileUploadingProgress, 10000);
        crDeleteFileUpload.isVisible(10000, "Delte file upload");
        crDeleteFileUpload.assertVisible("Delete File upload");
        Reporter.log("User is able to upload the file");
        crUploadedFileName.assertVisible("File Uploaded Name");
    }

    public void clickCarouselNextBtn() {
        SyncUtil.waitFor(5000);
        carouselNextBtn.isVisible(10000, "Carousel Next Btn");
        carouselNextBtn.jsClick("Carousel Next Btn");
        SyncUtil.waitFor(5000);

    }

    public void goToBeltScanListPage() {
        SyncUtil.waitFor(10000);
        beltScanCard.jsClick("BeltScan Card");
        waitForPageLoad(10000);
        SyncUtil.waitFor(5000);
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/dashboard/belt-scans"), "User is not navigated to beltScan listing page", "User is not navigated to beltScan listing page");

    }

    public void addButtonClick() {
        waitForElementVisible(addIcon, 10000, 500);
        waitForElementToBeClickable(addIcon);
//        addIcon.isVisible(10000,"AddIcon");
        addIcon.click("AddIcon");
        SyncUtil.waitFor(5000);
    }

    public void verifyAddScanPage() {
        Validator.assertTrue(addScanHeaderActive.isVisible(10000, "AddScanHeaderActive"), "User is not navigated to Add Scan page on clicking next button", "User is navigated to Add Scan page on clicking next button");
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/belt-scans/add/scan-details"), "User is not navigated to Add Belt Scan page!",
                "User is navigated to Add Belt Scan page!");
    }

    public boolean verifyCreateBtnDisabled() {
        Validator.assertTrue(btnCreateDisabled.isDisplayed(), "Create button is not disabled", "Create button is disabled");
        return btnCreateDisabled.isDisplayed();
    }

    public void verifyReasonForScanDDL() {
        reasonForScanDdl.isVisible(10000, "reasonForScanDdl");
        reasonForScanDdl.click("reasonForScan");
        for (String name : reasonForScanList) {
            waitForElementVisible(driver.findElement(By.xpath("//p-dropdownitem//span[text()='" + name + "']")), 10000, 500);
            Validator.assertTrue(driver.findElement(By.xpath("//p-dropdownitem//span[text()='" + name + "']")).isDisplayed(),
                    "'" + name + "' dropdown option is not displayed", "'" + name + "' dropdown option is displayed");
        }
    }

    public void verifyManFieldsInAddGeneralScreen() {
        for (String tbName : generalInfoTextBoxList) {
            waitForElementVisible(driver.findElement(By.xpath("//div//label[text()='" + tbName + " ']//em[text()=\"*\"]")), 10000, 500);
            Validator.assertTrue(driver.findElement(By.xpath("//div//label[text()='" + tbName + " ']//em[text()=\"*\"]")).isDisplayed(), "'" + tbName + "' is not a mandatory field", "'" + tbName + "' is a mandatory field");
        }

    }

    public void verifyAddScanningFilesPage() {
        Validator.assertTrue(addScanningFilesHeaderActive.isVisible(10000, "addScanningFilesHeaderActive"), "User is navigated to Add Scanning Files page on clicking next button", "User is not navigated to Add Scanning Files page on clicking next button");
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/belt-scans/add/scanning-file"), "User is not navigated to Add Scanning Files page!", "User is navigated to Add Scanning Files page!");
    }

    public void gotoBeltScanScreenWait() {
        goToBeltScanListPage();
        scrollPageDown();
        String val = "";
        for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(120); stop > System.nanoTime(); ) {
            if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
                break;
            }
            val = pagination.getText();
            SyncUtil.waitFor(5000);
        }
    }


    public void clickOnColumnsHeader(boolean isIncreasingOrder, String[] columnNames) {
        scrollPageup();

        // Initialize indices for both loops
        int outerIndex = 0;
        int innerIndex = 2;

        // Continue until either list is exhausted or a limit is reached
        while (outerIndex < columnNames.length && innerIndex <= 10) {
            String colName = columnNames[outerIndex];

            // Skip specific column
            if (colName.equalsIgnoreCase("Device Type")) {
                outerIndex++;
                innerIndex++;
                continue;
            }

            // Perform actions for the current column and index
            waitForElementVisible(driver.findElement(By.xpath("//div[normalize-space()='" + colName + "']")), 5000, 500);
            SyncUtil.waitFor(3000);
            waitForElementToBeClickable(driver.findElement(By.xpath("//div[normalize-space()='" + colName + "']")));
            driver.findElement(By.xpath("//div[normalize-space()='" + colName + "']")).click();

            if (isIncreasingOrder) {
                if (!colName.equalsIgnoreCase("Date Of Scan")) {
                    Validator.assertTrue(coverwearPage.verifyIncreasingOrderSorting(innerIndex),
                            "Sorting in increasing order is not applied correctly for '" + colName + "'",
                            "Sorting is applied in increasing order for '" + colName + "'");
                    driver.findElement(By.xpath("//div[normalize-space()='" + colName + "']")).click();
                    Validator.assertTrue(coverwearPage.verifyDecreasingOrderSorting(innerIndex),
                            "Sorting in decreasing order is not applied correctly for '" + colName + "'",
                            "Sorting is applied in decreasing order for '" + colName + "'");

                } else {
                    Validator.assertTrue(coverwearPage.verifyIncreasingOrderSortingForDates(innerIndex),
                            "Sorting in increasing order is not applied correctly for '" + colName + "'",
                            "Sorting is applied in increasing order for '" + colName + "'");
                    driver.findElement(By.xpath("//div[normalize-space()='" + colName + "']")).click();
                    Validator.assertTrue(coverwearPage.verifyDecreasingOrderSortingForDates(innerIndex),
                            "Sorting in decreasing order is not applied correctly for '" + colName + "'",
                            "Sorting is applied in decreasing order for '" + colName + "'");

                }
            }

            // Increment both indices
            outerIndex++;
            innerIndex++;
        }
    }

    public void verifyClearFilter() {
        ccmColHighlighted.isVisible(10000, "CCM column highlighted");
        coverwearPage.clearFilterClick();
        Validator.assertTrue(ccmColHighlighted.isNotVisible(10000), "The applied filter is not removed", "The applied filter is removed");

    }

    public boolean searchBeltScan(String conveyorName) {
        gotoBeltScanScreenWait();
        waitForPageLoad(10000);
        btSearchinput.type(conveyorName, "Conveyor Search");
        SyncUtil.waitFor(10000);
        waitForElementVisible(cbCheckbox, 20000, 1000);
        waitForElementToDisplay(cbCheckbox);
        return cbCheckbox.isVisible("Conveyor Found");
    }

    public String[] camelCaseConvertor(String[] columnArray) {
        String[] camelCaseColNames = Arrays.stream(columnArray)
                .map(str -> {
                    String[] words = str.split(" ");
                    return words[0].toLowerCase() +
                            Arrays.stream(words, 1, words.length)
                                    .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                                    .reduce("", String::concat);
                })
                .toArray(String[]::new);
        return camelCaseColNames;
    }

    public void deleteItem(String item) {
        waitForElementToDisplay(btSearchinput);
        btSearchinput.type(item, "Search Item");
        waitForElementToDisplay(cbCheckbox);
        SyncUtil.waitFor(3000);
        cbCheckbox.click("Checkbox");
        Validator.assertTrue(coverWearPage.verifyActionBtnState(), "Action button is not enabled after selecting the record", "Action button is enabled");
        ddlActions.click("Action");
        waitForElementToBeClickable(btnDelete);
        Validator.assertTrue(btnDelete.isVisible(), "Delete button is not visible", "Delete button is visible");
        btnDelete.click("Delete Item");
        btnYes.click("Confirm delete");
        waitForElementToDisplay(noList);
        noList.isVisible("No Item Found");
        Validator.assertTrue(deleteSuccessMsg.isVisible(10000, "Delete Toast"), "Delete successfully is not visible", "Deleted successfully is visible");
        btSearchinput.type(" ");
    }


}



