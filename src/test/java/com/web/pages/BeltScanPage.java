package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class BeltScanPage extends BasePage{

    @FindBy(locator = "xpath=//span[text()='Belt Scans']")
    public CustomElement lnkBeltScan;

    @FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
    public CustomElement home;

    @FindBy(locator = "xpath=//p-panel//span[text()='Belt Scans']")
    public CustomElement beltScanHeader;

    @FindBy(locator="xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement crCheckbox;

    @FindBy(locator="xpath=(//button/chevrondownicon)[2]")
    public CustomElement btActions;

    @FindBy(locator="xpath=//li//span[text()='Edit']")
    public CustomElement btEdit;

    @FindBy(locator="xpath=//span[text()='Delete']")
    public CustomElement btDelete;

    @FindBy(locator="xpath=//li//span[text()='Export CSV']")
    public CustomElement btExportCsv;

    @FindBy(locator = "xpath=//span[text()='Yes']")
    public CustomElement crYesConfirmation;

    @FindBy(locator = "xpath=//td[contains(text(),'No')]")
    public CustomElement noList;

    @FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
    public CustomElement pagination;

    @FindBy(locator="xpath=//input[@placeholder='Search']")
    public CustomElement btSearchinput;

    @FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
    public CustomElement btnAdd;

    @FindBy(locator= "xpath=//p-calendar[@formcontrolname='dateOfScan']//input[@placeholder=\"dd/mmm/yyyy\"]")
    public CustomElement tbDateOfScan;

    @FindBy(locator= "xpath=(//p-dropdown[@formcontrolname=\"deviceType\"]//div[contains(@class,\"p-dropdown\")])[1]")
    public CustomElement tbDeviceType;

    @FindBy(locator= "xpath=(//p-dropdown[@formcontrolname=\"reasonForScan\"]//div[contains(@class,\"p-dropdown\")])[1]")
    public CustomElement tbScanReason;

    @FindBy(locator= "xpath=(//p-dropdown[@datakey=\"companyId\"]//div[contains(@class,\"p-dropdown\")])[1]")
    public CustomElement tbSite;

    @FindBy(locator= "xpath=//label[text()='Conveyor ']/..//input")
    public CustomElement tbConveyorInput;

    @FindBy(locator= "xpath=//label[text()='Notify CCM ']/..//input")
    public CustomElement tbCCMInput;

    @FindBy(locator= "xpath=(//p-dropdown[@datakey=\"conveyorId\"]//div[contains(@class,\"p-dropdown\")])[1]")
    public CustomElement tbConveyorDropdown;

    @FindBy(locator= "xpath=//label[text()='Notify CCM ']/..//p-dropdown")
    public CustomElement tbCCMDropdown;

    @FindBy(locator= "xpath=//label[text()='Upload Raw Capture File ']/..//app-any-file-uploader//input")
    public CustomElement uploadRawCapture;

    @FindBy(locator= "xpath=//label[text()='Upload Backup File ']/..//app-any-file-uploader//input")
    public CustomElement uploadBackupFile;

    @FindBy(locator = "xpath=//span[text()='Save']")
    public CustomElement btnSave;

    @FindBy(locator = "xpath=//span[text()='Create']")
    public CustomElement btnCreate;

    @FindBy(locator = "xpath=//span[text()='Next']")
    public CustomElement btnNext;

    @FindBy(locator = "xpath=//span[text()='Load Backup Data']/..")
    public CustomElement loadBackupData;

    @FindBy(locator = "xpath=//span[text()='Load Technical Data']/..")
    public CustomElement loadTechnicalData;

    @FindBy(locator= "xpath=//label[text()='Upload Analysis File']/..//app-any-file-uploader//input")
    public CustomElement uploadAnalysisFile;

    @FindBy(locator= "xpath=//label[text()='Upload Scanning Report']/..//app-any-file-uploader//input")
    public CustomElement uploadScanningReport;

    @FindBy(locator = "xpath=//textarea[@formcontrolname='notes']")
    public CustomElement ccmNotes;

    @FindBy(locator= "xpath=//div[contains(@class,\"p-datepicker-group-container\")]")
    public CustomElement calendarPopup;

    public String ListItem = "//ul[@role='listbox']//li//span";

    @FindBy(locator= "xpath=//input[contains(@class,'p-dropdown-filter')]")
    public CustomElement tbDeviceTypedropdown;

    @FindBy(locator="xpath=//button[contains(@class,'p-button-loading')]")
    public CustomElement buttonLoader;

    @FindBy(locator = "xpath=//span[text()='Add Belt Scan']") public CustomElement addBeltScan;
    @FindBy(locator = "xpath=//p-dropdown[@formcontrolname=\"deviceType\"]") public CustomElement deviceTypeDdl;
    @FindBy(locator = "xpath=//p-dropdown[@formcontrolname=\"reasonForScan\"]") public CustomElement reasonForScanDdl;
    @FindBy(locator = "xpath=//p-dropdownitem//span[text()=\"CordInspect\"]") public CustomElement cordInspectOption;
    @FindBy(locator = "xpath=//p-dropdownitem//span[text()=\"Splice problem\"]") public CustomElement spliceProblemOption;
    @FindBy(locator = "xpath=//label[text()='Site ']/parent::div//div[@role='button']") public CustomElement ddlSiteCustomername;
    @FindBy(locator = "xpath=//label[text()='Conveyor ']/parent::div//div[@role='button']") public CustomElement ddlConveyorName;
    @FindBy(locator = "xpath=//label[text()='Notify CCM ']/parent::div//div[@role='button']") public CustomElement ddlNotifyCCM;
    @FindBy(locator = "xpath=//p-progressspinner/div") public CustomElement btFileUploadingProgress;
    @FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter p-inputtext')]") public CustomElement tbInput;
    @FindBy(locator = "xpath=(//input[@type='file'])[1]") public CustomElement crFileUpload;
    @FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Delete')])[1]") public CustomElement crDeleteFileUpload;
    @FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Delete')]/../../preceding-sibling::div)[1]") public CustomElement crUploadedFileName;
    @FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Delete')])[2]") public CustomElement crBackUpDeleteFileUpload;
    @FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Delete')]/../../preceding-sibling::div)[2]") public CustomElement crBackUUploadedFileName;
    @FindBy(locator = "xpath=//p-calendar//span//input") public CustomElement dateOfScan; @FindBy(locator = "xpath=//div[@class=\"p-carousel-items-content\"]/following-sibling::button[contains(@class,\"p-carousel-next \")]\n") public CustomElement carouselNextBtn;
    @FindBy(locator = "xpath=(//div[@class=\"p-carousel-items-content\"]//div[contains(@class, \"p-carousel-item\")]//app-card//div[contains(@class, \"header\") and normalize-space(text())=\"Belt Scans\"])[2]") public CustomElement beltScanCard;
    @FindBy(locator = "xpath=(//div//span//button[@icon=\"ctp-icon-Add-circle\"])[2]") public CustomElement addIcon;
    @FindBy(locator = "xpath=//li//a[contains(@class,\"p-menuitem-link-active\")]//span[text()=\"Add Scan Details\"]\n") public CustomElement addScanHeaderActive;
    @FindBy(locator = "//span[text()='Create']/parent::button[@disabled]") public CustomElement btnCreateDisabled;
    @FindBy(locator = "xpath=//li//a[contains(@class,'p-menuitem-link-active')]//span[text()='Add Scanning Files']")
    public CustomElement addScanningFilesHeaderActive;
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
        dateOfScan.isVisible(10000,"dateOfScan");
        dateOfScan.sendKeys("dateOfScan","date");
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
        String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_files").getAbsolutePath();
        crFileUpload.sendKeys(file_path, "File Path");
        waitForElementToInvisible(btFileUploadingProgress, 10000);
        crDeleteFileUpload.assertVisible("Delete File upload");
        Reporter.log("User is able to upload the file");
        crUploadedFileName.assertVisible("File Uploaded Name");
    }

    public void clickCarouselNextBtn() {
        SyncUtil.waitFor(5000);
        carouselNextBtn.isVisible(10000, "Carousel Next Btn");
        carouselNextBtn.click("Carousel Next Btn");
    }

    public void goToBeltScanListPage() {
        SyncUtil.waitFor(8000);
        beltScanCard.isVisible(10000, "BeltScan Card");
        beltScanCard.click("BeltScan Card");
        waitForPageLoad(10000); SyncUtil.waitFor(5000);
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/dashboard/belt-scans"), "User is not navigated to beltScan listing page", "User is not navigated to beltScan listing page");
    }

    public void addButtonClick() {
        waitForElementVisible(addIcon, 10000, 500);
        waitForElementToBeClickable(addIcon);
        addIcon.isVisible(10000,"AddIcon");
        addIcon.click("AddIcon");
        SyncUtil.waitFor(5000);
    }

    public void verifyAddScanPage() {
        Validator.assertTrue(addScanHeaderActive.isVisible(10000, "AddScanHeaderActive"), "User is not navigated to Add Scan page on clicking next button", "User is navigated to Add Scan page on clicking next button");
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/belt-scans/add/scan-details"), "User is not navigated to Add Belt Scan page!", "User is navigated to Add Belt Scan page!");
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
            Validator.assertTrue(driver.findElement(By.xpath("//p-dropdownitem//span[text()='" + name + "']")).isDisplayed(), "'" + name + "' dropdown option is not displayed", "'" + name + "' dropdown option is displayed");
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

    public void gotoBeltScanScreen(){
        if(!lnkBeltScan.isVisible())
            home.click("Home");
        SyncUtil.waitFor(1000);
        lnkBeltScan.click("belt scan");
        waitForElementToDisplay(beltScanHeader);
        btSearchinput.isVisible("belt scan Page");
    }
    public void gotoBeltScanScreenWait(){
        gotoBeltScanScreen();
        scrollPageDown();
        String val="";
        for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(120); stop>System.nanoTime();) {
            if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
                break;
            }
            val = pagination.getText();
            SyncUtil.waitFor(5000);
        }
    }

    public void gotoAddBeltScan(){
        gotoBeltScanScreen();
        btnAdd.click("Add");
        btnCreate.isVisible("Belt Scan form");
    }

    public boolean addGeneralDetails(String scanDate, String reason, String site, String conveyor, String ccm, String rawFile, String backupFile){
        tbDateOfScan.click("installation date");
        calendarPopup.isVisible(10000,"Calendar Popup");
        new CoverWearPage().selectGivenDate(scanDate);
        dropdownSelect(tbDeviceType, ListItem, "CordInspect");
        dropdownSelect(tbScanReason, ListItem, reason);
        dropdownSelectSearch(tbSite, tbDeviceTypedropdown, site);
        dropdownSelectSearch(tbConveyorDropdown, tbDeviceTypedropdown, conveyor);
        fileUpload(rawFile);
        fileUpload(backupFile);
        dropdownSelectSearch(tbCCMDropdown, tbDeviceTypedropdown, ccm);
        SyncUtil.waitFor(1000);
        btnNext.click();
        return loadBackupData.isEnable() && loadTechnicalData.isEnable();
    }

    public boolean searchBeltScan(String conveyorName){
        gotoBeltScanScreenWait();
        btSearchinput.type(conveyorName, "Belt Scan conveyor Name Search");
        waitForElementToDisplay(crCheckbox);
        return crCheckbox.isVisible("Conveyor Found");
    }

    public boolean goToBeltScanEditScreen(String conveyorName) {
        searchBeltScan(conveyorName);
        waitForElementToDisplay(crCheckbox);
        crCheckbox.check("Select Belt Scan");
        btActions.click("Actions");
        waitForElementVisible(btEdit, 10000,500);
        btEdit.click("Edit");
        waitForPageLoad(10000);
        return dateOfScan.isVisible(10000,"Update Device title");
    }

    public void editBeltScan(String device, String newScanReason){
        goToBeltScanEditScreen(device);
        waitForElementToDisplay(tbScanReason);
        dropdownSelect(tbScanReason, ListItem, newScanReason);
        btnSave.click();
        waitForElementToInvisible(buttonLoader,10000);
    }

    public boolean deleteBeltScan(String conveyorName){
        searchBeltScan(conveyorName);
        crCheckbox.check("Belt Scan Checkbox");
        btActions.click("Actions");
        waitForElementVisible(btDelete, 20000,500);
        btDelete.click("Delete");
        crYesConfirmation.click("Confirm");
        waitForElementToDisplay(noList);
        return noList.isVisible();
    }

    public void verifyDeletedMonitoringDevice(String calc) {
        gotoBeltScanScreen();
        waitForPageLoad(10000);
        btSearchinput.type(calc, "Conveyor Search");
        Validator.assertTrue(noList.isVisible(),"Delete Belt Scan was still found in list screen","Belt Scan deleted successfully");
    }

}
