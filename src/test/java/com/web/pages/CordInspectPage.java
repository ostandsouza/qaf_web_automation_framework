package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;


public class CordInspectPage extends BasePage {


	CoverWearPage coverWearPage = new CoverWearPage();

	@FindBy(locator = "xpath=//span[text()='Add Belt Scan']")
	public CustomElement addBeltScan;
	@FindBy(locator = "xpath=//label[text()='Date Of Scan ']")
	public CustomElement tbDateOfScan;
	@FindBy(locator = "xpath=//p-dropdown[@formcontrolname=\"deviceType\"]")
	public CustomElement deviceTypeDdl;
	@FindBy(locator = "xpath=//p-dropdown[@formcontrolname=\"reasonForScan\"]")
	public CustomElement reasonForScanDdl;
	@FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
	public CustomElement home;
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
	@FindBy(locator="xpath=//p-progressspinner/div")
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
	@FindBy(locator = "xpath=//div[@class=\"p-carousel-items-content\"]//div[contains(@class, \"p-carousel-item\")]//app-card//div[contains(@class, \"header\") and normalize-space(text())=\"Belt Scans\"]")
	public CustomElement beltScanCard;
	@FindBy(locator = "xpath=//em[text()='Date of scan cannot be empty']")
	public CustomElement errorMsgDos;
	@FindBy(locator = "xpath=//em[text()='Select device type']")
	public CustomElement errorMsgDevType;
	@FindBy(locator = "xpath=//em[text()='Select reason']")
	public CustomElement errorMsgRos;
	@FindBy(locator = "xpath=//em[text()='Select site']")
	public CustomElement errorMsgSite;
	@FindBy(locator = "xpath=//em[text()='Select conveyor']")
	public CustomElement errorMsgConveyor;
	@FindBy(locator = "xpath=//em[text()='Select CCM']")
	public CustomElement errorMsgCCM;
	@FindBy(locator= "//span[text()='Create']/parent::button[@disabled]")
	public CustomElement btnCreateDisabled;
	@FindBy(locator= "//span[text()='Create']/parent::button[not(@disabled)]")
	public CustomElement btnCreateEnabled;
	@FindBy(locator = "xpath=//li//a[contains(@class,'p-menuitem-link-active')]//span[text()=' Add Scan Details']")
	public CustomElement addScanHeaderActive;
	@FindBy(locator = "xpath=//li//a[contains(@class,'p-menuitem-link-active')]//span[text()=' Add Scanning Files']")
	public CustomElement addScanningFilesHeaderActive;
	@FindBy(locator = "xpath=//label[text()='Upload Analysis File']/../div[text()=' To be uploaded by the CCM ']")
	public CustomElement uploadAnalysisFileCMMMsg;
	@FindBy(locator = "xpath=//label[text()='Upload Scanning Report']/../div[text()=' To be uploaded by the CCM ']")
	public CustomElement uploadScanningReportCCMMsg;
	@FindBy(locator = "xpath=//textarea[@formcontrolname='notes']")
	public CustomElement addScanningFilesNote;
	@FindBy(locator = "xpath=(//div//span//button[@icon='ctp-icon-Add-circle'])[2]")
	public CustomElement addIcon;
	@FindBy(locator = "xpath=//p-panel[@header='Belt Scans']//span[text()='Belt Scans']")
	public CustomElement beltScansListHeader;
	@FindBy(locator = "xpath=(//span[text()='Cancel'])")
	public CustomElement btnCancel;

	@FindBy(locator = "xpath=//input[@placeholder='Search']")
	public CustomElement btSearchinput;
	@FindBy(locator = "xpath=(//td//p-tablecheckbox)[1]")
	public CustomElement cbCheckbox;
	@FindBy(locator="xpath=(//button/chevrondownicon)[2]")
	public CustomElement ddlActions;
	@FindBy(locator = "xpath=//span[text()='Delete']")
	public CustomElement btnDelete;
	@FindBy(locator = "xpath=//span[text()='Yes']")
	public CustomElement btnYes;

    @FindBy(locator = "xpath=//td[contains(text(),'No')]")
    public CustomElement noList;
    @FindBy(locator = "xpath=//div[contains(text(),'deleted successfully')]")
    public CustomElement deleteSuccessMsg;
    @FindBy(locator = "xpath=//th//p-tableheadercheckbox")
    public CustomElement btCheckboxHeader;

	@FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
	public CustomElement paginationEntry;
	@FindBy(locator = "xpath=(//app-card//div[text()='Belt Scans'])/../div/div/div/span")
	public CustomElement beltScanCardCount;
	@FindBy(locator = "xpath=//span[text()=' Edit General Details']")
	public CustomElement editGeneralDetailsHeader;
	@FindBy(locator = "xpath=//span[text()=' Edit Scan Details']")
	public CustomElement editScanDetailsHeader;
	@FindBy(locator = "xpath=//span[text()=' Edit Scanning Files']")
	public CustomElement editScanningFilesHeader;
	@FindBy(locator = "xpath=//span[text()='Load Backup Data']/..")
	public CustomElement loadBackupData;
	@FindBy(locator = "xpath=//span[text()='Load Technical Data']/..")
	public CustomElement loadTechnicalData;
	@FindBy(locator= "xpath=//label[text()='Upload Analysis File']/..//app-any-file-uploader")
	public CustomElement uploadAnalysisFile;
	@FindBy(locator= "xpath=//label[text()='Upload Scanning Report']/..//app-any-file-uploader")
	public CustomElement uploadScanningReport;
	@FindBy(locator = "xpath=//textarea[@formcontrolname='notes']")
	public CustomElement ccmNotes;
	@FindBy(locator = "xpath=//label[text()='Belt Manufacturer ']/parent::div//div[@role='button']")
	public CustomElement ddlBeltManufacturer;
	@FindBy(locator = "xpath=//label[text()='Top Cover Compound ']/parent::div//div[@role='button']")
	public CustomElement ddlTopCoverCompound;
	@FindBy(locator = "xpath=//label[text()='Bottom Cover Compound ']/parent::div//div[@role='button']")
	public CustomElement ddlBottomCoverCompound;
	@FindBy(locator = "xpath=//label[text()='Sensor Segments Used / Sensor Width ']/parent::div//div[@role='button']")
	public CustomElement ddlSensorWidth;
	@FindBy(locator = "xpath=//label[text()='Is the CPU Box on the Left of the Belt ']/parent::div//div[@role='button']")
	public CustomElement ddlCpuLeftBelt;

	@FindBy(locator="xpath=//label[text()='Number of cords ']/parent::div//input")
	public CustomElement txtNumberOfCords;
	@FindBy(locator="xpath=//label[text()=' Cord Pitch ']/parent::div//input")
	public CustomElement txtCordPitch;
	@FindBy(locator="xpath=//label[text()='Cord Diameter ']/parent::div//input")
	public CustomElement txtCordDiameter;
	@FindBy(locator = "xpath=//label[text()='Belt Width ']/parent::div//input")
	public CustomElement txtBeltWidth;
	@FindBy(locator = "xpath=//label[text()='Belt Rating or Belt Rating Strength ']/parent::div//input")
	public CustomElement txtBeltRating;
	@FindBy(locator="xpath=//label[text()='Top Cover Thickness ']/parent::div//input")
	public CustomElement txtTopCoverThicknessInput;
	@FindBy(locator="xpath=//label[text()='Bottom Cover Thickness ']/parent::div//input")
	public CustomElement txtBottomCoverThicknessInput;
	@FindBy(locator = "xpath=//label[text()='Belt Length ']/parent::div//input")
	public CustomElement txtBeltLength;
	@FindBy(locator = "xpath=//label[text()='Splices Quantity ']/parent::div//input")
	public CustomElement txtSplicesQuantity;
	@FindBy(locator = "xpath=//label[text()='Belt Speed ']/parent::div//input")
	public CustomElement txtBeltSpeed;
	@FindBy(locator = "xpath=//label[text()='Splice Design ']/parent::div//input")
	public CustomElement txtSpliceDesign;
	@FindBy(locator = "xpath=//label[text()='Encoder Wheel Diameter ']/parent::div//input")
	public CustomElement txtEncoderWheelDiameter;
	@FindBy(locator = "xpath=//label[text()='Number of Counts Per Revolution ']/parent::div//input")
	public CustomElement txtNumberOfCountsPerRevolution;
	@FindBy(locator = "xpath=//label[text()='Distance of Sensor from Belt ']/parent::div//input")
	public CustomElement txtDistanceOfSensorFromBelt;
	@FindBy(locator = "xpath=//label[text()='Sensor-Belt Lateral Offset ']/parent::div//input")
	public CustomElement txtSensorBeltOffset;
	@FindBy(locator = "xpath=//label[text()='Technical Support Telephone Number ']/parent::div//input")
	public CustomElement txtTechnicalSupport;
	@FindBy(locator = "xpath=//label[text()='Customer Support Telephone Number ']/parent::div//input")
	public CustomElement txtCustomerSupport;
	@FindBy(locator = "xpath=//div[contains(text(),'updated successfully')]")
	public CustomElement updatedSuccessMsg;
	@FindBy(locator = "xpath=//textarea[@formcontrolname='notes']")
	public CustomElement noteField;

	@FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
	public CustomElement pagination;
	@FindBy(locator = "xpath=//span[text()='Save']")
	public CustomElement saveBtn;
	@FindBy(locator = "xpath=//li[@id='1']//span[contains(@style,'background: black')]")
	public CustomElement firstHighlightedTab;
	@FindBy(locator = "xpath=//li[@id='2']//span[contains(@style,'background: black')]")
	public CustomElement secondHighlightedTab;
	@FindBy(locator = "xpath=//li[@id='3']//span[contains(@style,'background: black')]")
	public CustomElement thirdHighlightedTab;
	@FindBy(locator = "xpath=//span[text()='Next']")
	public CustomElement btNext;
	@FindBy(locator = "xpath=//span[contains(text(),'General Details')]")
	public CustomElement addGeneralHeader;
	@FindBy(locator = "xpath=//span[contains(text(),'Scan Details')]")
	public CustomElement addScanHeader;
	@FindBy(locator = "xpath=//span[contains(text(),'Scanning Files')]")
	public CustomElement addScanningFilesHeader;

	@FindBy(locator="xpath=(//p-button[@icon='ctp-icon-Arrow-Right'])[1]")
	public CustomElement btviewicon;
	@FindBy(locator="xpath=//div[text()='Only one file can be uploaded']")
	public CustomElement uploadError;
	@FindBy(locator="xpath=(//span[contains(text(),'Edit')])[1]")
	public CustomElement txtEdit;
	@FindBy(locator = "xpath=//span[text()='Upload Analysis Results']")
	public CustomElement btnUploadAnalysis;
	@FindBy(locator = "xpath=//div[@role='dialog']//span[text()='Upload Analysis Results']")
	public CustomElement uploadAnalysisDialog;
	@FindBy(locator = "xpath=(//span[text()='Upload'])")
	public CustomElement btnUpload;
	@FindBy(locator = "xpath=//p-button[@icon='ctp-icon-belt-scan-scanning-file']/button[@disabled]")
	public CustomElement scanningReportDisabledIcon;

	@FindBy(locator = "xpath= //th[@psortablecolumn=\"ccm.fullname\" and contains(@class,\"p-highlight\")]\n")
	public CustomElement ccmColHighlighted;


	String[] reasonForScanList = {"Regular scheduled scan", "Belt mistracking", "Splice problem", "Pulley damage", "Idler damage", "Excessive wear", "Impact damage", "Other"};
	String[] generalInfoTextBoxList = {"Date Of Scan", "Device Type", "Reason For Scan", "Site", "Conveyor", "Notify CCM", "Upload Raw Capture File", "Upload Backup File"};

	public void goToAddBeltScans(){
		waitForElementVisible(addBeltScan,10000,500);
		waitForElementToBeClickable(addBeltScan);
		addBeltScan.click("Add Belt Scans");
		waitForPageLoad(10000);
		tbDateOfScan.isVisible("Date of Scan");
	}

	public void addBeltScanInfo(String deviceType,String reasonForScan,String siteName,String conveyorName,String notifyCcm)
	{
		        deviceTypeDdl.isVisible(10000,"Device Type");
				deviceTypeDdl.click("Device Type");
				waitForElementVisible(driver.findElement(By.xpath("//p-dropdownitem//span[text()='"+deviceType+"']")),10000,500);
				driver.findElement(By.xpath("//p-dropdownitem//span[text()='"+deviceType+"']")).click();
				reasonForScanDdl.isVisible(10000,"reasonForScanDdl");
				reasonForScanDdl.click("reasonForScan");
				waitForElementVisible(driver.findElement(By.xpath("//p-dropdownitem//span[text()='"+reasonForScan+"']")),10000,500);
				driver.findElement(By.xpath("//p-dropdownitem//span[text()='"+reasonForScan+"']")).click();
				dropdownSelectSearch(ddlSiteCustomername, tbInput, siteName);
				dropdownSelectSearch(ddlConveyorName, tbInput, conveyorName);
				dropdownSelectSearch(ddlNotifyCCM, tbInput, notifyCcm);
				dateOfScan.isVisible(10000,"dateOfScan");
				dateOfScan.click("Date of Scan");
	}
	public void fileUpload(String fileName) {
		String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_data").getAbsolutePath();
		crFileUpload.sendKeys(file_path, "File Path");
		waitForElementToInvisible(btFileUploadingProgress,30000);
		SyncUtil.waitFor(15000);
		crDeleteFileUpload.assertVisible("Delete File upload");
		crUploadedFileName.assertVisible("File Uploaded Name");
	}
	public void verifyManErrorMsgWithEmptyVal(String siteName,String conveyorName) {
		dateOfScan.isVisible(10000,"dateOfScan");
		dateOfScan.click("Date of Scan");
		deviceTypeDdl.click("Device Type");
		waitForElementVisible(errorMsgDos,5000,1000);
		Validator.assertTrue(errorMsgDos.isVisible("Date of scan Error Msg"),"Date of scan Error Message is not visible","Date of scan Error Message is visible");
		reasonForScanDdl.click("reasonForScan");
		waitForElementVisible(errorMsgDevType,5000,1000);
		Validator.assertTrue(errorMsgDevType.isVisible("Device Type Error Msg"),"Device Type Error Message is not visible","Device Type Error Message is visible");
		ddlSiteCustomername.click("site");
		waitForElementVisible(errorMsgRos,5000,1000);
		Validator.assertTrue(errorMsgRos.isVisible("Reason of scan Error Msg"),"Reason of scan Error Message is not visible","Reason of scan Error Message is visible");
		reasonForScanDdl.click("reasonForScan");
		waitForElementVisible(errorMsgSite,5000,1000);
		Validator.assertTrue(errorMsgSite.isVisible("Site Error Msg"),"Site Error Message is not visible","Site Error Message is visible");
		dropdownSelectSearch(ddlSiteCustomername, tbInput, siteName);
		ddlConveyorName.click("conveyor");
		ddlConveyorName.click("conveyor");
		reasonForScanDdl.click("reasonForScan");
		waitForElementVisible(errorMsgConveyor,5000,1000);
		Validator.assertTrue(errorMsgConveyor.isVisible("Conveyor Error Msg"),"Conveyor Error Message is not visible","Conveyor Error Message is visible");
		dropdownSelectSearch(ddlConveyorName, tbInput, conveyorName);
		ddlNotifyCCM.click("ccm");
		ddlNotifyCCM.click("ccm");
		ddlConveyorName.click("conveyor");
		waitForElementVisible(errorMsgCCM,5000,1000);
		Validator.assertTrue(errorMsgCCM.isVisible("CCM Error Msg"),"CCM Error Message is not visible","CCM Error Message is visible");
	}
	public boolean verifyCreateBtnDisabled() {
		Validator.assertTrue(btnCreateDisabled.isDisplayed(),"Create button is not disabled","Create button is disabled");
		return btnCreateDisabled.isDisplayed();
	}
	public boolean verifyCreateBtnEnabled() {
		Validator.assertTrue(btnCreateEnabled.isDisplayed(),"Create button is disabled","Create button is enabled");
		return btnCreateEnabled.isDisplayed();
	}
	public void verifyAddScanPage(){
		Validator.assertTrue( addScanHeaderActive.isVisible(10000,"AddScanHeaderActive"),"User is navigated to Add Scan page on clicking next button","User is not navigated to Add Scan page on clicking next button");
		Validator.assertTrue(driver.getCurrentUrl().contains("/secure/belt-scans/add/scan-details"),"User is not navigated to Add Belt Scan page!","User is navigated to Add Belt Scan page!");
	}
	public void verifyAddScanningFilesPage(){
		Validator.assertTrue( addScanningFilesHeaderActive.isVisible(10000,"addScanningFilesHeaderActive"),"User is navigated to Add Scanning Files page on clicking next button","User is not navigated to Add Scanning Files page on clicking next button");
		Validator.assertTrue(driver.getCurrentUrl().contains("/secure/belt-scans/add/scanning-file"),"User is not navigated to Add Scanning Files page!","User is navigated to Add Scanning Files page!");
	}
	public void verifyAddScanningFilesUploadMsg(){
		Validator.assertTrue(uploadAnalysisFileCMMMsg.isVisible(10000,"uploadAnalysisFileCMMMsg"),"To be uploaded by the CCM for Upload Analysis File is not visible","To be uploaded by the CCM Upload Analysis File is visible");
		Validator.assertTrue(uploadScanningReportCCMMsg.isVisible(10000,"uploadScanningReportCCMMsg"),"To be uploaded by the CCM for Upload Scanning Report is not visible","To be uploaded by the CCM for Upload Scanning Report is visible");
	}
	public void verifyUserCanAddNote(String note){
		waitForElementVisible(addScanningFilesNote,5000,1000);
		Validator.assertTrue(addScanningFilesNote.isVisible("addScanningFilesNote"),"Note text box is not visible","Note text box is visible");
		addScanningFilesNote.type(note);
		Validator.assertTrue(addScanningFilesNote.getAttribute("value").contains(note),"Note text box is not editable","Note text box is editable");
	}
	public void clickCarouselNextBtn(){
		SyncUtil.waitFor(5000);
		carouselNextBtn.isVisible(10000,"Carousel Next Btn");
		carouselNextBtn.click("Carousel Next Btn");
	}
	public void goToBeltScanListPage(){
		SyncUtil.waitFor(8000);
		beltScanCard.isVisible(10000,"BeltScan Card");
		beltScanCard.click("BeltScan Card");
		waitForPageLoad(10000);
		SyncUtil.waitFor(5000);
		Validator.assertTrue(driver.getCurrentUrl().contains("/secure/dashboard/belt-scans"),"User is not navigated to beltScan listing page","User is not navigated to beltScan listing page");
		waitForPageLoad(10000);
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
	public void addButtonClick()    {
		waitForElementVisible(addIcon,10000,500);
		waitForElementToBeClickable(addIcon);
		addIcon.click("AddIcon");
		SyncUtil.waitFor(5000);
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


    public void clickOnColumnsHeader(boolean isIncreasingOrder, String[] columnNames,int innerIndexVal) {
        scrollPageup();

        // Initialize indices for both loops
        int outerIndex = 0;
        int innerIndex = innerIndexVal;

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
                    Validator.assertTrue(coverWearPage.verifyIncreasingOrderSorting(innerIndex),
                            "Sorting in increasing order is not applied correctly for '" + colName + "'",
                            "Sorting is applied in increasing order for '" + colName + "'");
                    driver.findElement(By.xpath("//div[normalize-space()='" + colName + "']")).click();
                    Validator.assertTrue(coverWearPage.verifyDecreasingOrderSorting(innerIndex),
                            "Sorting in decreasing order is not applied correctly for '" + colName + "'",
                            "Sorting is applied in decreasing order for '" + colName + "'");

                } else {
                    Validator.assertTrue(coverWearPage.verifyIncreasingOrderSortingForDates(innerIndex),
                            "Sorting in increasing order is not applied correctly for '" + colName + "'",
                            "Sorting is applied in increasing order for '" + colName + "'");
                    driver.findElement(By.xpath("//div[normalize-space()='" + colName + "']")).click();
                    Validator.assertTrue(coverWearPage.verifyDecreasingOrderSortingForDates(innerIndex),
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
		coverWearPage.clearFilterClick();
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
        ddlActions.jsClick("Action");
        waitForElementToBeClickable(btnDelete);
        Validator.assertTrue(btnDelete.isVisible(), "Delete button is not visible", "Delete button is visible");
        btnDelete.jsClick("Delete Item");
        btnYes.click("Confirm delete");
        waitForElementToDisplay(noList);
        noList.isVisible("No Item Found");
        Validator.assertTrue(deleteSuccessMsg.isVisible(10000, "Delete Toast"), "Delete successfully is not visible", "Deleted successfully is visible");
        btSearchinput.type(" ");
    }


    public void verifyDeletedMonitoringDevice(String calc) {
        gotoBeltScanScreenWait();
        waitForPageLoad(10000);
        btSearchinput.type(calc, "Conveyor Search");
        Validator.assertTrue(noList.isVisible(),"Delete Belt Scan was still found in list screen","Belt Scan deleted successfully");
    }


    public void verifyInBeltScanListPage()    {
        waitForElementVisible(beltScansListHeader,5000,1000);
        Validator.assertTrue(beltScansListHeader.isVisible("beltScansListHeader"),"Belt scans header is not visible","Belt scans header is visible");
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/dashboard/belt-scans"),"User is not navigated to beltScan listing page","User is not navigated to beltScan listing page");

    }

    public void cancelBtnClick(){
        waitForElementVisible(btnCancel,10000,500);
        waitForElementToBeClickable(btnCancel);
        Validator.assertTrue(btnCancel.isVisible("btnCancel"),"Cancel Button is not visible","Cancel button is visible");
        btnCancel.jsClick("Cancel");
    }

    public void validateCordInspCountWrtPaginationAndTile(){
        SyncUtil.waitFor(20000);
        int deviceCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        System.out.println(deviceCount+"deviceCount");
        Validator.assertTrue(apiBase.getCordInspectCount().get("count").equals(deviceCount),"Belt Scan Card Count does not match","Belt Scan Card Count matches");
        Validator.assertTrue(apiBase.getCordInspectCount().get("count").toString().equals(beltScanCardCount.getText()),"Belt Scan Card Count does not match","Belt Scan Card Count matches");

    }

    public void validateBeltScanCountBeforeDel(){
        String deviceCount = apiBase.getCordInspectCount().get("count").toString();
        getBundle().setProperty("beltScanDeviceCount", deviceCount);
    }

    public void validateBeltScanCountAfterDel(){
        waitForPageLoad(10000);
        String extractedValue = getBundle().getProperty("beltScanDeviceCount").toString();
        int expectedValue = Integer.parseInt(extractedValue) - 1;
        System.out.println(expectedValue+"expectedValue");
        System.out.println(apiBase.getCordInspectCount().get("count")+"expectedValuecount");
        Validator.assertTrue(apiBase.getCordInspectCount().get("count").equals(expectedValue),"Belt Scan Card Count does not match","Belt Scan Card Count matches");
        Validator.assertTrue(apiBase.getCordInspectCount().get("count").toString().equals(beltScanCardCount.getText()),"Belt Scan Card Count does not match","Belt Scan Card Count matches");

    }
//	public void waitUntilBeltScanCountLoads(){
//		int apiCount = Integer.parseInt(apiBase.getCordInspectCount().get("count").toString());
//		for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(120); stop > System.nanoTime();) {
//			int elementCount = Integer.parseInt(beltScanCardCount.getText());
//			if (elementCount == apiCount) {
//				System.out.println("Counts match! Exiting loop.");
//				break;
//			}
//			System.out.println("Waiting for counts to match. Current element count: " + elementCount + ", API count: " + apiCount);
//
//			SyncUtil.waitFor(5000);
//		}
//
//	}

	public void verifyDeleteIsVisible()
	{
		waitForElementVisible(btnDelete, 10000,500);
		Validator.assertTrue(btnDelete.isVisible(),"User is not able to see delete Symbol","User is able to see delete Symbol");
	}
	public void verifySelectAllCheckbox()
	{
		waitForElementVisible(btCheckboxHeader, 10000,500);
		Validator.assertTrue(btCheckboxHeader.isVisible("Select all checkbox"),"Select all checkbox is not visible","Select all checkbox is visible");
		btCheckboxHeader.click();
	}

	public void verifyItemNotPresent(String item) {
		waitForElementToDisplay(btSearchinput);
		btSearchinput.type(item, "Item Search");
		waitForElementToDisplay(noList);
		noList.isVisible("No Item Found");
		Validator.assertTrue(noList.isVisible("No Item Found"),"No list is not visible","No list is visible");
	}

	public void verifyItemPresent(String item) {
		waitForElementToDisplay(btSearchinput);
		btSearchinput.jsClick();
		SyncUtil.waitFor(10000);
		btSearchinput.sendKeys(item);
		waitForElementToDisplay(cbCheckbox);
		cbCheckbox.click("Checkbox");
		Validator.assertTrue(cbCheckbox.isVisible("Item Found"),"Item not visible","Item is visible");
	}
	public void beltScanIsInEditMode() {
		SyncUtil.waitFor(15000);
		Validator.assertTrue(editGeneralDetailsHeader.isVisible("Edit General Details"),"Edit General Details not visible","Edit General Details is visible");
		Validator.assertTrue(editScanDetailsHeader.isVisible("Edit Scan Details"),"Edit Scan Details not visible","Edit Scan Details is visible");
		Validator.assertTrue(editScanningFilesHeader.isVisible("Edit Scanning Files"),"Edit Scanning Files not visible","Edit Scanning Files is visible");
	}
	public void fileReUpload(String fieldName,String fileName) {
		driver.findElement("//label[text()='"+fieldName+"']/..//span[@class='ctp-icon-Delete']").click();
		String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_data").getAbsolutePath();
		crFileUpload.sendKeys(file_path, "File Path");
		waitForElementToInvisible(btFileUploadingProgress,30000);
		SyncUtil.waitFor(10000);
		crDeleteFileUpload.assertVisible("Delete File upload");
		crUploadedFileName.assertVisible("File Uploaded Name");
	}
	public void editBeltScanDetails(String beltManufacturer,String topCoverCompound,String numberOfCords,String cpuLeft,String sensorWidth,String phoneNumber)
	{
		dropdownSelectSearch(ddlBeltManufacturer, tbInput, beltManufacturer);
		dropdownSelectSearch(ddlTopCoverCompound, tbInput, topCoverCompound);
		dropdownSelectSearch(ddlBottomCoverCompound, tbInput, topCoverCompound);
		txtNumberOfCords.type(numberOfCords);
		txtCordPitch.type(numberOfCords);
		txtCordDiameter.type(numberOfCords);
		txtBeltWidth.type(numberOfCords);
		txtBeltRating.type(numberOfCords);
		txtTopCoverThicknessInput.type(numberOfCords);
		txtBottomCoverThicknessInput.type(numberOfCords);
		txtBeltLength.type(numberOfCords);
		txtSplicesQuantity.type(numberOfCords);
		txtBeltSpeed.type(numberOfCords);
		txtSpliceDesign.type(numberOfCords);
		txtEncoderWheelDiameter.type(numberOfCords);
		txtNumberOfCountsPerRevolution.type(numberOfCords);
		txtDistanceOfSensorFromBelt.type(numberOfCords);
		ddlCpuLeftBelt.click();
		driver.findElement(By.xpath("//p-dropdownitem//span[text()='"+cpuLeft+"']")).click();
		txtSensorBeltOffset.type(numberOfCords);
		ddlSensorWidth.click();
		driver.findElement(By.xpath("//p-dropdownitem//span[text()='"+sensorWidth+"']")).click();
		txtTechnicalSupport.type(phoneNumber);
		txtCustomerSupport.type(phoneNumber);
		SyncUtil.waitFor(30000);
		Validator.assertTrue(loadBackupData.isEnable()&&loadTechnicalData.isEnable(),"Technical And BackupData is not loaded","Technical And BackupData is loaded");
		dateOfScan.isVisible(10000,"dateOfScan");
		dateOfScan.click("Date of Scan");
	}
	public void verifyUpdateSuccessfulMsg()
	{
		waitForElementVisible(updatedSuccessMsg,5000,1000);
		Validator.assertTrue(updatedSuccessMsg.isVisible(),"Updated message is not visible","Updated message is visible");
	}
	public void editTheNote(String note)
	{
		waitForElementVisible(noteField,5000,1000);
		noteField.sendKeys(note);
	}
	public void clickOnTextSaveBtn()
	{
		waitForElementVisible(saveBtn,5000,1000);
		saveBtn.click();
	}
	public void verifyBeltScanTabHighlightFun()
	{
		SyncUtil.waitFor(10000);
		waitForElementVisible(firstHighlightedTab,60000,1000);
		Validator.assertTrue(firstHighlightedTab.isVisible(),"First tab is not highlighted","First tab is highlighted");
		btNext.click();
		Validator.assertTrue(firstHighlightedTab.isVisible(),"First tab is not highlighted","First tab is highlighted");
		Validator.assertTrue(secondHighlightedTab.isVisible(),"Second tab is not highlighted","Second tab is highlighted");
		btNext.click();
		Validator.assertTrue(firstHighlightedTab.isVisible(),"First tab is not highlighted","First tab is highlighted");
		Validator.assertTrue(secondHighlightedTab.isVisible(),"Second tab is not highlighted","Second tab is highlighted");
		Validator.assertTrue(thirdHighlightedTab.isVisible(),"Third tab is not highlighted","Third tab is highlighted");
		scrollPageup();
		addGeneralHeader.jsClick("Add General Details Header");
		waitForElementVisible(firstHighlightedTab,5000,1000);
		Validator.assertTrue(firstHighlightedTab.isVisible(),"First tab is not highlighted","First tab is highlighted");
		addScanHeader.click();
		Validator.assertTrue(firstHighlightedTab.isVisible(),"First tab is not highlighted","First tab is highlighted");
		Validator.assertTrue(secondHighlightedTab.isVisible(),"Second tab is not highlighted","Second tab is highlighted");
		addScanningFilesHeader.click();
		Validator.assertTrue(firstHighlightedTab.isVisible(),"First tab is not highlighted","First tab is highlighted");
		Validator.assertTrue(secondHighlightedTab.isVisible(),"Second tab is not highlighted","Second tab is highlighted");
		Validator.assertTrue(thirdHighlightedTab.isVisible(),"Third tab is not highlighted","Third tab is highlighted");
	}
	public void verifyAddScanningTabHighlightFun()
	{
		waitForElementVisible(firstHighlightedTab,5000,1000);
		Validator.assertTrue(firstHighlightedTab.isVisible(),"First tab is not highlighted","First tab is highlighted");
		addScanningFilesHeader.click();
		waitForPageLoad(5000);
		Validator.assertTrue(firstHighlightedTab.isVisible(),"First tab is not highlighted","First tab is highlighted");
		Validator.assertTrue(secondHighlightedTab.isVisible(),"Second tab is not highlighted","Second tab is highlighted");
		Validator.assertTrue(thirdHighlightedTab.isVisible(),"Third tab is not highlighted","Third tab is highlighted");
	}

	public void searchAndClickViewBtn(String item) {
		waitForElementToDisplay(btSearchinput);
		btSearchinput.jsClick();
		SyncUtil.waitFor(10000);
		btSearchinput.sendKeys(item);
		waitForElementToDisplay(cbCheckbox);
		waitForElementToDisplay(btviewicon);
		btviewicon.click("Belt Scan Details");
		waitForPageLoad(20000);
	}

	public void unableFileUploadMultipleFiles(List<String> fileNames) {
//		System.out.println(file2+file1);
//		List<String> filesToUpload = Arrays.asList(file1, file2);
//		cordInspectPage.unableFileUploadMultipleFiles(filesToUpload);

	StringBuilder filePaths = new StringBuilder();
	for (String fileName : fileNames) {
		String filePath = ClasspathResourceHelper.getPropertyFile(fileName, "test_data").getAbsolutePath();
		filePaths.append(filePath).append("\n");
	}
	String allFilePaths = filePaths.toString().trim();
	crFileUpload.sendKeys(allFilePaths);
	Validator.assertTrue(uploadError.isVisible(),"Error message is not visible","Error message is visible");
	}


	public void unableFileReUploadMultipleFiles(String fieldName, List<String> fileNames) {
		driver.findElement("//label[text()='" + fieldName + "']/..//span[@class='ctp-icon-Delete']").click();
		StringBuilder filePaths = new StringBuilder();
		for (String fileName : fileNames) {
			String filePath = ClasspathResourceHelper.getPropertyFile(fileName, "test_data").getAbsolutePath();
			filePaths.append(filePath).append("\n");
		}
		String allFilePaths = filePaths.toString().trim();
		crFileUpload.sendKeys(allFilePaths);
		Validator.assertTrue(uploadError.isVisible(),"Error message is not visible","Error message is visible");

	}
	public void waitForEditPage() {
		waitForPageLoad(20000);
		SyncUtil.waitFor(5000);
       waitForElementVisible(txtEdit,30000,1000);
	}
	public void clickUploadAnalysisFromActionBtn() {
		waitForElementToDisplay(cbCheckbox);
		SyncUtil.waitFor(2000);
		cbCheckbox.click("Checkbox");
		Validator.assertTrue(coverWearPage.verifyActionBtnState(),"Action button is not enabled after selecting the record","Action button is enabled");
		ddlActions.click("Action");
		waitForElementToBeClickable(btnUploadAnalysis);
		Validator.assertTrue(btnUploadAnalysis.isVisible(),"Upload Analysis Result button is not visible","Upload Analysis Result button is visible");
		btnUploadAnalysis.click("Upload Analysis Result Item");
		Validator.assertTrue(uploadAnalysisDialog.isVisible(),"Upload Analysis Result Dialog is not visible","Upload Analysis Result Dialog is visible");
		waitForElementVisible(uploadAnalysisFile,2000,1000);
		Validator.assertTrue(uploadAnalysisFile.isVisible(),"Upload Analysis File is not visible","Upload Analysis File is visible");
		Validator.assertTrue(uploadScanningReport.isVisible(),"Upload Scanning Report is not visible","Upload Scanning Report is visible");
	}

	public void uploadBtnClick(){
		waitForElementVisible(btnUpload,10000,500);
		waitForElementToBeClickable(btnUpload);
		Validator.assertTrue(btnUpload.isVisible("Upload Btn"),"Upload Button is not visible","Upload button is visible");
		btnUpload.jsClick("Upload");
	}
	public void verifyScanningReportIsDisabled(){
		waitForElementVisible(scanningReportDisabledIcon,10000,500);
		Validator.assertTrue(scanningReportDisabledIcon.isVisible("Scanning Disabled Icon"),"Scanning Report Icon is not disabled","Scanning Report Icon is disabled");
	}
}
