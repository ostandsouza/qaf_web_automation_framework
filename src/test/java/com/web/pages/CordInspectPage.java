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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import com.common.utils.MiscUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.qmetry.qaf.automation.util.CSVUtil;


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
	@FindBy(locator = "xpath=//p-calendar//span//input")
	public CustomElement dateOfScan;
	@FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter p-inputtext')]")
	public CustomElement tbInput;
	@FindBy(locator = "xpath=(//input[@type='file'])[1]")
	public CustomElement crFileUpload;
	@FindBy(locator = "xpath=//p-progressspinner/div")
	public CustomElement btFileUploadingProgress;
	@FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Delete')])[1]")
	public CustomElement crDeleteFileUpload;
	@FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Delete')]/../../preceding-sibling::div)[1]")
	public CustomElement crUploadedFileName;
	@FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Delete')])[2]")
	public CustomElement crBackUpDeleteFileUpload;
	@FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Delete')]/../../preceding-sibling::div)[2]")
	public CustomElement crBackUUploadedFileName;
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
	@FindBy(locator = "//span[text()='Create']/parent::button[@disabled]")
	public CustomElement btnCreateDisabled;
	@FindBy(locator = "//span[text()='Create']/parent::button[not(@disabled)]")
	public CustomElement btnCreateEnabled;
	@FindBy(locator = "xpath=//label[text()='Load Conveyor Backup Data']")
	public CustomElement loadBackupDataLabel;
	@FindBy(locator = "xpath=//span[text()='Load Backup Data']/..")
	public CustomElement loadBackupData;
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
	@FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
	public CustomElement pagination;
	@FindBy(locator = "xpath=//p-panel[@header='Belt Scans']//span[text()='Belt Scans']")
	public CustomElement beltScansListHeader;
	@FindBy(locator = "xpath=(//span[text()='Cancel'])")
	public CustomElement btnCancel;
	@FindBy(locator = "xpath=(//td//p-tablecheckbox)[1]")
	public CustomElement cbCheckbox;
	@FindBy(locator = "xpath=(//button/chevrondownicon)[2]")
	public CustomElement ddlActions;
	@FindBy(locator = "xpath=//span[text()='Delete']")
	public CustomElement btnDelete;
	@FindBy(locator = "xpath=//span[text()='Yes']")
	public CustomElement btnYes;
 	@FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
	public CustomElement paginationEntry;
	@FindBy(locator = "xpath=(//app-card//div[text()='Belt Scans'])/../div/div/div/span")
	public CustomElement beltScanCardCount;
	@FindBy(locator = "xpath=//td[contains(text(),'No')]")
	public CustomElement noList;
	@FindBy(locator = "xpath=//input[@placeholder='Search']")
	public CustomElement btSearchinput;
	@FindBy(locator = "xpath=//th//p-tableheadercheckbox")
	public CustomElement btCheckboxHeader;
	@FindBy(locator = "xpath=//span[text()=' Edit General Details']")
	public CustomElement editGeneralDetailsHeader;
	@FindBy(locator = "xpath=//span[text()=' Edit Scan Details']")
	public CustomElement editScanDetailsHeader;
	@FindBy(locator = "xpath=//span[text()=' Edit Scanning Files']")
	public CustomElement editScanningFilesHeader;
	@FindBy(locator = "xpath=(//span[contains(text(),'Edit')])[1]")
	public CustomElement txtEdit;
	@FindBy(locator = "xpath=//span[text()='Save']")
	public CustomElement saveBtn;
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

	@FindBy(locator = "xpath=//label[text()='Number of cords ']/parent::div//input")
	public CustomElement txtNumberOfCords;
	@FindBy(locator = "xpath=//label[text()=' Cord Pitch ']/parent::div//input")
	public CustomElement txtCordPitch;
	@FindBy(locator = "xpath=//label[text()='Cord Diameter ']/parent::div//input")
	public CustomElement txtCordDiameter;
	@FindBy(locator = "xpath=//label[text()='Belt Width ']/parent::div//input")
	public CustomElement txtBeltWidth;
	@FindBy(locator = "xpath=//label[text()='Belt Rating or Belt Rating Strength ']/parent::div//input")
	public CustomElement txtBeltRating;
	@FindBy(locator = "xpath=//label[text()='Top Cover Thickness ']/parent::div//input")
	public CustomElement txtTopCoverThicknessInput;
	@FindBy(locator = "xpath=//label[text()='Bottom Cover Thickness ']/parent::div//input")
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
	@FindBy(locator = "xpath=//span[text()='Load Technical Data']/..")
	public CustomElement loadTechnicalData;
	@FindBy(locator = "xpath=//div[contains(text(),'updated successfully')]")
	public CustomElement updatedSuccessMsg;
	@FindBy(locator = "xpath=//div[contains(text(),'Success')]")
	public CustomElement successMsg;
	@FindBy(locator = "xpath=//textarea[@formcontrolname='notes']")
	public CustomElement noteField;
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
	@FindBy(locator = "xpath=(//p-button[@icon='ctp-icon-Arrow-Right'])[1]")
	public CustomElement btviewicon;
	@FindBy(locator = "xpath=//div[text()='Only one file can be uploaded']")
	public CustomElement uploadError;
	@FindBy(locator = "xpath=//span[text()='Upload Analysis Results']")
	public CustomElement btnUploadAnalysis;
	@FindBy(locator = "xpath=//div[@role='dialog']//span[text()='Upload Analysis Results']")
	public CustomElement uploadAnalysisDialog;
	@FindBy(locator = "xpath=(//span[text()='Upload'])")
	public CustomElement btnUpload;
	@FindBy(locator = "xpath=//p-button[@icon='ctp-icon-belt-scan-scanning-file']/button[@disabled]")
	public CustomElement scanningReportDisabledIcon;
	@FindBy(locator = "xpath=//button[contains(@class,'p-button-loading')]")
	public CustomElement buttonLoader;
	@FindBy(locator = "xpath=//label[text()='Upload Analysis File']/..//app-any-file-uploader")
	public CustomElement uploadAnalysisFile;
	@FindBy(locator = "xpath=//label[text()='Upload Scanning Report']/..//app-any-file-uploader")
	public CustomElement uploadScanningReport;
	@FindBy(locator = "xpath=(//li//span[text()='Belt Scans'])[1]")
	public CustomElement cordInspectList;
	@FindBy(locator = "xpath=//label[text()='Site ']/parent::div//span")
	public CustomElement inpSite;
	@FindBy(locator = "xpath=//label[text()='Conveyor ']/parent::div//span")
	public CustomElement inpConveyor;
	@FindBy(locator = "xpath=//label[text()='Top Cover Compound ']/parent::div//input")
	public CustomElement inpTopCoverCompound;
	@FindBy(locator = "xpath=//label[text()='Belt Width ']/parent::div//input")
	public CustomElement inpBeltWidth;
	@FindBy(locator="xpath=//span[text()='File is being scanned...']")
	public CustomElement txtScanningFile;
	@FindBy(locator="xpath=//p-toast//div[text()='Back up file loaded successfully']")
	public CustomElement txtScanningBackUpSuccessToast;
	@FindBy(locator="xpath=//span[text()='Add Scan Details']/..")
	public CustomElement headerAddScanDetails;

	@FindBy(locator="xpath=//p-button[@icon='ctp-icon-Instaloled-Devices']//button")
	public CustomElement btCordInspectIcon;
	@FindBy(locator="xpath=//div[@class='menu-cord']//span[text()='CordInspect']")
	public CustomElement cordInspectFloatingMenu;
	@FindBy(locator="xpath=//div[@class='belt-overview']")
	public CustomElement cordInspectViewPage;
	@FindBy(locator="xpath=(//p-button[@icon='ctp-icon-Download']/button)[1]")
	public CustomElement btScanFileDownload;
	@FindBy(locator="xpath=(//p-button[@icon='ctp-icon-Download']/button)[2]")
	public CustomElement btRawFileDownload;
	@FindBy(locator="xpath=//p-button[@icon='ctp-icon-belt-scan-scanning-file']/button")
	public CustomElement btScanningReportDownloadFile;
	@FindBy(locator="xpath=//p-dialog//p-button[@icon='ctp-icon-Download']/button")
	public CustomElement btScanningReportDownloadIcon;
	@FindBy(locator="xpath=(//p-toastitem)[1]")
	public CustomElement toastMsg;
	@FindBy(locator = "xpath=//span[text()=' View General Details']")
	public CustomElement viewGeneralDetailsHeader;
	@FindBy(locator = "xpath=//span[text()=' View Scan Details']")
	public CustomElement viewScanDetailsHeader;
	@FindBy(locator = "xpath=//span[text()=' View Scanning Files']")
	public CustomElement viewScanningFilesHeader;
	@FindBy(locator = "xpath=//div[contains(@class,'p-multiselect-trigger')]")
	public CustomElement filterDropdown;
	@FindBy(locator= "xpath=//div[contains(@class,'p-multiselect-filter-container')]//input[contains(@class,'p-multiselect-filter')]")
	public CustomElement tbMultipleSiteDropdown;

	@FindBy(locator = "xpath=//th/div[contains(text(),'Corporate')]")
	public CustomElement corporatesCol;
	@FindBy(locator = "xpath=(//div[@class='p-multiselect-items-wrapper']//div[contains(@class,'p-highlight')])[1]")
	public CustomElement filterSelectedValue;
	@FindBy(locator = "xpath=//div[@class='menu-cord']//div//span[text()='CordInspect']")
	public CustomElement menuList;
	@FindBy(locator = "xpath=(//div[@class='menu-cord']//div//i[contains(@class,'pi-angle-right')])[1]")
	public CustomElement floatingDownWardArrow;
	@FindBy(locator = "xpath=//div[@class='menu-cord']//div//span[text()='Main Page']")
	public CustomElement mainPageMenu;

	@FindBy(locator = "xpath=//textarea[@formcontrolname='notes']")
	public CustomElement ccmNotes;

	@FindBy(locator="xpath=//p-toast//div[text()='Back up file processing is in progress please try again after some time']")
	public CustomElement txtScanningBackUpWaitingToast;

	@FindBy(locator = "xpath=(//div[contains(text(),'Success')])[1]")
	public CustomElement deleteSuccessMsg;

	String[] menuListNames={"Main Page","Splices","Damages","Segments"};

	@FindBy(locator = "xpath= //th[@psortablecolumn=\"ccm.fullname\" and contains(@class,\"p-highlight\")]\n")
	public CustomElement ccmColHighlighted;


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
		deviceTypeDdl.isVisible(10000, "Device Type");
		deviceTypeDdl.click("Device Type");
		waitForElementVisible(driver.findElement(By.xpath("//p-dropdownitem//span[text()='" + deviceType + "']")), 10000, 500);
		driver.findElement(By.xpath("//p-dropdownitem//span[text()='" + deviceType + "']")).click();
		reasonForScanDdl.isVisible(10000, "reasonForScanDdl");
		reasonForScanDdl.click("reasonForScan");
		waitForElementVisible(driver.findElement(By.xpath("//p-dropdownitem//span[text()='" + reasonForScan + "']")), 10000, 500);
		driver.findElement(By.xpath("//p-dropdownitem//span[text()='" + reasonForScan + "']")).click();
		setImplicitWait(2000,TimeUnit.MILLISECONDS);
		dropdownSelectSearch(ddlSiteCustomername, tbInput, siteName);
		dropdownSelectSearch(ddlConveyorName, tbInput, conveyorName);
		dropdownSelectSearch(ddlNotifyCCM, tbInput, notifyCcm);
		dateOfScan.isVisible(10000, "dateOfScan");
		dateOfScan.click("Date of Scan");
	}
	public void fileUpload(String fileName) {
		String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_data").getAbsolutePath();
		crFileUpload.sendKeys(file_path, "File Path");
		waitForElementToInvisible(btFileUploadingProgress, 30000);
		SyncUtil.waitFor(15000);
		crDeleteFileUpload.assertVisible("Delete File upload");
		crUploadedFileName.assertVisible("File Uploaded Name");
	}
	public void verifyManErrorMsgWithEmptyVal(String siteName, String conveyorName) {
		dateOfScan.isVisible(10000, "dateOfScan");
		dateOfScan.click("Date of Scan");
		deviceTypeDdl.click("Device Type");
		waitForElementVisible(errorMsgDos, 5000, 1000);
		Validator.assertTrue(errorMsgDos.isVisible("Date of scan Error Msg"), "Date of scan Error Message is not visible", "Date of scan Error Message is visible");
		reasonForScanDdl.click("reasonForScan");
		waitForElementVisible(errorMsgDevType, 5000, 1000);
		Validator.assertTrue(errorMsgDevType.isVisible("Device Type Error Msg"), "Device Type Error Message is not visible", "Device Type Error Message is visible");
		ddlSiteCustomername.click("site");
		waitForElementVisible(errorMsgRos, 5000, 1000);
		Validator.assertTrue(errorMsgRos.isVisible("Reason of scan Error Msg"), "Reason of scan Error Message is not visible", "Reason of scan Error Message is visible");
		reasonForScanDdl.click("reasonForScan");
		waitForElementVisible(errorMsgSite, 5000, 1000);
		Validator.assertTrue(errorMsgSite.isVisible("Site Error Msg"), "Site Error Message is not visible", "Site Error Message is visible");
		dropdownSelectSearch(ddlSiteCustomername, tbInput, siteName);
		ddlConveyorName.click("conveyor");
		ddlConveyorName.click("conveyor");
		reasonForScanDdl.click("reasonForScan");
		waitForElementVisible(errorMsgConveyor, 5000, 1000);
		Validator.assertTrue(errorMsgConveyor.isVisible("Conveyor Error Msg"), "Conveyor Error Message is not visible", "Conveyor Error Message is visible");
		dropdownSelectSearch(ddlConveyorName, tbInput, conveyorName);
		ddlNotifyCCM.click("ccm");
		ddlNotifyCCM.click("ccm");
		ddlConveyorName.click("conveyor");
		waitForElementVisible(errorMsgCCM, 5000, 1000);
		Validator.assertTrue(errorMsgCCM.isVisible("CCM Error Msg"), "CCM Error Message is not visible", "CCM Error Message is visible");
	}
	public boolean verifyCreateBtnDisabled() {
		Validator.assertTrue(btnCreateDisabled.isDisplayed(), "Create button is not disabled", "Create button is disabled");
		return btnCreateDisabled.isDisplayed();
	}
	public boolean verifyCreateBtnEnabled() {
		Validator.assertTrue(btnCreateEnabled.isDisplayed(), "Create button is disabled", "Create button is enabled");
		return btnCreateEnabled.isDisplayed();
	}
	public void verifyAddScanPage() {
		Validator.assertTrue(addScanHeaderActive.isVisible(10000, "AddScanHeaderActive"), "User is navigated to Add Scan page on clicking next button", "User is not navigated to Add Scan page on clicking next button");
		Validator.assertTrue(driver.getCurrentUrl().contains("/belt-scans/add/scan-details"), "User is not navigated to Add Belt Scan page!", "User is navigated to Add Belt Scan page!");
		Validator.assertTrue(loadBackupDataLabel.isVisible(10000, "loadBackupDataLabel"), "Load Back up Data Label is not visible", "Load Back up Data Label is visible");
		Validator.assertTrue(loadBackupData.isVisible(10000, "loadBackupDataButton"), "Load Back up Data is not visible", "Load Back up Data is visible");
	}

	public void verifyAddScanningFilesPage() {
		Validator.assertTrue(addScanningFilesHeaderActive.isVisible(10000, "addScanningFilesHeaderActive"), "User is navigated to Add Scanning Files page on clicking next button", "User is not navigated to Add Scanning Files page on clicking next button");
		Validator.assertTrue(driver.getCurrentUrl().contains("/belt-scans/add/scanning-file"), "User is not navigated to Add Scanning Files page!", "User is navigated to Add Scanning Files page!");
	}

	public void verifyAddScanningFilesUploadMsg() {
		Validator.assertTrue(uploadAnalysisFileCMMMsg.isVisible(10000, "uploadAnalysisFileCMMMsg"), "To be uploaded by the CCM for Upload Analysis File is not visible", "To be uploaded by the CCM Upload Analysis File is visible");
		Validator.assertTrue(uploadScanningReportCCMMsg.isVisible(10000, "uploadScanningReportCCMMsg"), "To be uploaded by the CCM for Upload Scanning Report is not visible", "To be uploaded by the CCM for Upload Scanning Report is visible");
	}
	public void verifyUserCanAddNote(String note) {
		waitForElementVisible(addScanningFilesNote, 5000, 1000);
		Validator.assertTrue(addScanningFilesNote.isVisible("addScanningFilesNote"), "Note text box is not visible", "Note text box is visible");
		addScanningFilesNote.type(note);
		Validator.assertTrue(addScanningFilesNote.getAttribute("value").contains(note), "Note text box is not editable", "Note text box is editable");
	}

	public void clickCarouselNextBtn() {
		SyncUtil.waitFor(5000);
		carouselNextBtn.isVisible(10000, "Carousel Next Btn");
		carouselNextBtn.jsClick("Carousel Next Btn");
	}

	public void goToBeltScanListPageWithCard() {
        SyncUtil.waitFor(8000);
        beltScanCard.isVisible(10000, "BeltScan Card");
        beltScanCard.click("BeltScan Card");
        waitForPageLoad(10000);
        SyncUtil.waitFor(5000);
        Validator.assertTrue(driver.getCurrentUrl().contains("/belt-scans"), "User is not navigated to beltScan listing page", "User is not navigated to beltScan listing page");
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

	public void addButtonClick() {
		waitForElementVisible(addIcon, 10000, 500);
		waitForElementToBeClickable(addIcon);
		addIcon.click("AddIcon");
		SyncUtil.waitFor(5000);
	}
	public void verifyInBeltScanListPage() {
        waitForElementVisible(beltScansListHeader, 5000, 1000);
        Validator.assertTrue(beltScansListHeader.isVisible("beltScansListHeader"), "Belt scans header is not visible", "Belt scans header is visible");
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/dashboard/belt-scans"), "User is not navigated to beltScan listing page", "User is not navigated to beltScan listing page");
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

    public void cancelBtnClick() {
		waitForElementVisible(btnCancel, 10000, 500);
		waitForElementToBeClickable(btnCancel);
		Validator.assertTrue(btnCancel.isVisible("btnCancel"), "Cancel Button is not visible", "Cancel button is visible");
		btnCancel.jsClick("Cancel");
	}
    public void verifyClearFilter() {
        ccmColHighlighted.isVisible(10000, "CCM column highlighted");
		coverWearPage.clearFilterClick();
        Validator.assertTrue(ccmColHighlighted.isNotVisible(10000), "The applied filter is not removed", "The applied filter is removed");

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
        btSearchinput.clear();
        btSearchinput.type(item, "Search Item");
        waitForElementToDisplay(cbCheckbox);
        SyncUtil.waitFor(3000);
        cbCheckbox.click("Checkbox");
        Validator.assertTrue(coverWearPage.verifyActionBtnState(), "Action button is not enabled after selecting the record", "Action button is enabled");
        ddlActions.jsClick("Action");
        waitForElementToBeClickable(btnDelete);
        Validator.assertTrue(btnDelete.isVisible(), "Delete button is not visible", "Delete button is visible");
        btnDelete.click("Delete Item");
        btnYes.click("Confirm delete");
        SyncUtil.waitFor(3000);
        waitForElementToDisplay(noList);
        noList.isVisible("No Item Found");
//		waitForElementVisible(deleteSuccessMsg,10000,1000);
//		Validator.assertTrue(deleteSuccessMsg.isVisible("Delete pop up"),"Delete successfully is not visible","Deleted successfully is visible");
        btSearchinput.type(" ");
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

	public void verifyDeleteIsVisible() {
		waitForElementVisible(btnDelete, 10000, 500);
		Validator.assertTrue(btnDelete.isVisible(), "User is not able to see delete Symbol", "User is able to see delete Symbol");
	}
	public void verifySelectAllCheckbox() {
		waitForElementVisible(btCheckboxHeader, 10000, 500);
		Validator.assertTrue(btCheckboxHeader.isVisible("Select all checkbox"), "Select all checkbox is not visible", "Select all checkbox is visible");
		btCheckboxHeader.click();
	}
	public void verifyItemNotPresent(String item) {
		waitForElementToDisplay(btSearchinput);
		btSearchinput.type(item, "Item Search");
		waitForElementToDisplay(noList);
		noList.isVisible("No Item Found");
		Validator.assertTrue(noList.isVisible("No Item Found"), "No list is not visible", "No list is visible");
	}

	public void verifyItemPresent(String item) {
		waitForElementToDisplay(btSearchinput);
		btSearchinput.jsClick();
		SyncUtil.waitFor(10000);
		btSearchinput.sendKeys(item);
		waitForElementToDisplay(cbCheckbox);
		cbCheckbox.click("Checkbox");
		Validator.assertTrue(cbCheckbox.isVisible("Item Found"), "Item not visible", "Item is visible");
	}
	public void beltScanIsInEditMode() {
		SyncUtil.waitFor(15000);
		Validator.assertTrue(editGeneralDetailsHeader.isVisible("Edit General Details"), "Edit General Details not visible", "Edit General Details is visible");
		Validator.assertTrue(editScanDetailsHeader.isVisible("Edit Scan Details"), "Edit Scan Details not visible", "Edit Scan Details is visible");
		Validator.assertTrue(editScanningFilesHeader.isVisible("Edit Scanning Files"), "Edit Scanning Files not visible", "Edit Scanning Files is visible");
	}
	public void waitForEditPage() {
		waitForPageLoad(20000);
		SyncUtil.waitFor(5000);
		waitForElementVisible(txtEdit, 30000, 1000);
		Validator.assertTrue(txtEdit.isVisible(),"User is not on edit page","User is in edit page");
	}
	public void fileReUpload(String fieldName, String fileName) {
		driver.findElement("//label[text()='" + fieldName + "']/..//span[@class='ctp-icon-Delete']").click();
		String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_data").getAbsolutePath();
		crFileUpload.sendKeys(file_path, "File Path");
		waitForElementToInvisible(btFileUploadingProgress, 30000);
		SyncUtil.waitFor(10000);
		crDeleteFileUpload.assertVisible("Delete File upload");
		crUploadedFileName.assertVisible("File Uploaded Name");
	}
	public void clickOnTextSaveBtn() {
		waitForElementVisible(saveBtn, 5000, 1000);
		waitForElementToBeClickable(saveBtn);
		saveBtn.jsClick();
	}
	public void editBeltScanDetails(String beltManufacturer, String topCoverCompound, String numberOfCords, String cpuLeft, String sensorWidth, String phoneNumber) {
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
		driver.findElement(By.xpath("//p-dropdownitem//span[text()='" + cpuLeft + "']")).click();
		txtSensorBeltOffset.type(numberOfCords);
		ddlSensorWidth.click();
		driver.findElement(By.xpath("//p-dropdownitem//span[text()='" + sensorWidth + "']")).click();
		txtTechnicalSupport.type(phoneNumber);
		txtCustomerSupport.type(phoneNumber);
		SyncUtil.waitFor(60000);
		Validator.assertTrue(loadBackupData.isEnable() && loadTechnicalData.isEnable(), "Technical And BackupData is not loaded", "Technical And BackupData is loaded");
		dateOfScan.isVisible(10000, "dateOfScan");
		dateOfScan.click("Date of Scan");
	}
	public void editTheNote(String note) {
		waitForElementVisible(noteField, 5000, 1000);
		noteField.clear();
		SyncUtil.waitFor(8000);
		noteField.sendKeys(note);
		SyncUtil.waitFor(5000);
	}
	public void verifyUpdateSuccessfulMsg() {
		SyncUtil.waitFor(2000);
		waitForElementVisible(successMsg, 10000, 1000);
		Validator.assertTrue(updatedSuccessMsg.isDisplayed(), "Updated message is not visible", "Updated message is visible");
		SyncUtil.waitFor(3000);
	}

	public void verifyBeltScanTabHighlightFun() {
		SyncUtil.waitFor(10000);
		waitForElementVisible(firstHighlightedTab, 60000, 1000);
		Validator.assertTrue(firstHighlightedTab.isVisible(), "First tab is not highlighted", "First tab is highlighted");
		btNext.click();
		Validator.assertTrue(firstHighlightedTab.isVisible(), "First tab is not highlighted", "First tab is highlighted");
		Validator.assertTrue(secondHighlightedTab.isVisible(), "Second tab is not highlighted", "Second tab is highlighted");
		btNext.click();
		Validator.assertTrue(firstHighlightedTab.isVisible(), "First tab is not highlighted", "First tab is highlighted");
		Validator.assertTrue(secondHighlightedTab.isVisible(), "Second tab is not highlighted", "Second tab is highlighted");
		Validator.assertTrue(thirdHighlightedTab.isVisible(), "Third tab is not highlighted", "Third tab is highlighted");
		scrollPageup();
		addGeneralHeader.jsClick("Add General Details Header");
		waitForElementVisible(firstHighlightedTab, 5000, 1000);
		Validator.assertTrue(firstHighlightedTab.isVisible(), "First tab is not highlighted", "First tab is highlighted");
		addScanHeader.click();
		Validator.assertTrue(firstHighlightedTab.isVisible(), "First tab is not highlighted", "First tab is highlighted");
		Validator.assertTrue(secondHighlightedTab.isVisible(), "Second tab is not highlighted", "Second tab is highlighted");
		addScanningFilesHeader.click();
		Validator.assertTrue(firstHighlightedTab.isVisible(), "First tab is not highlighted", "First tab is highlighted");
		Validator.assertTrue(secondHighlightedTab.isVisible(), "Second tab is not highlighted", "Second tab is highlighted");
		Validator.assertTrue(thirdHighlightedTab.isVisible(), "Third tab is not highlighted", "Third tab is highlighted");
	}
	public void verifyAddScanningTabHighlightFun() {
		waitForElementVisible(firstHighlightedTab, 5000, 1000);
		Validator.assertTrue(firstHighlightedTab.isVisible(), "First tab is not highlighted", "First tab is highlighted");
		addScanningFilesHeader.click();
		waitForPageLoad(5000);
		Validator.assertTrue(firstHighlightedTab.isVisible(), "First tab is not highlighted", "First tab is highlighted");
		Validator.assertTrue(secondHighlightedTab.isVisible(), "Second tab is not highlighted", "Second tab is highlighted");
		Validator.assertTrue(thirdHighlightedTab.isVisible(), "Third tab is not highlighted", "Third tab is highlighted");
	}
	public void searchAndClickViewBtn(String item) {
		waitForElementToDisplay(btSearchinput);
		btSearchinput.jsClick();
		SyncUtil.waitFor(10000);
		btSearchinput.sendKeys(item);
		waitForElementToDisplay(cbCheckbox);
		waitForElementToDisplay(btviewicon);
		btviewicon.jsClick("Belt Scan Details");
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
		Validator.assertTrue(uploadError.isVisible(), "Error message is not visible", "Error message is visible");
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
		Validator.assertTrue(uploadError.isVisible(), "Error message is not visible", "Error message is visible");

	}
	public void clickUploadAnalysisFromActionBtn() {
		waitForElementToDisplay(cbCheckbox);
		SyncUtil.waitFor(2000);
		cbCheckbox.click("Checkbox");
		Validator.assertTrue(coverWearPage.verifyActionBtnState(), "Action button is not enabled after selecting the record", "Action button is enabled");
		ddlActions.jsClick("Action");
		SyncUtil.waitFor(2000);
		waitForElementToBeClickable(btnUploadAnalysis);
		Validator.assertTrue(btnUploadAnalysis.isVisible(), "Upload Analysis Result button is not visible", "Upload Analysis Result button is visible");
		btnUploadAnalysis.jsClick("Upload Analysis Result Item");
		waitForElementVisible(uploadAnalysisDialog, 10000, 1000);
		Validator.assertTrue(uploadAnalysisDialog.isVisible(), "Upload Analysis Result Dialog is not visible", "Upload Analysis Result Dialog is visible");
		waitForElementVisible(uploadAnalysisFile, 2000, 1000);
		Validator.assertTrue(uploadAnalysisFile.isVisible(), "Upload Analysis File is not visible", "Upload Analysis File is visible");
		Validator.assertTrue(uploadScanningReport.isVisible(), "Upload Scanning Report is not visible", "Upload Scanning Report is visible");
	}

	public void uploadBtnClick() {
		waitForElementVisible(btnUpload, 10000, 500);
		waitForElementToBeClickable(btnUpload);
		Validator.assertTrue(btnUpload.isVisible("Upload Btn"), "Upload Button is not visible", "Upload button is visible");
		btnUpload.jsClick("Upload");
		waitForElementToInvisible(buttonLoader, 5000);
	}

	public void verifyScanningReportIsDisabled() {
		waitForElementVisible(scanningReportDisabledIcon, 10000, 500);
		Validator.assertTrue(scanningReportDisabledIcon.isVisible("Scanning Disabled Icon"), "Scanning Report Icon is not disabled", "Scanning Report Icon is disabled");
	}
	public void verifySearchedItemIsPresent(String item) {
		waitForElementToDisplay(cbCheckbox);
		SyncUtil.waitFor(3000);
		Validator.assertTrue(cbCheckbox.isVisible(), "Checkbox is not visible", "Checkbox is visible");
		Validator.assertTrue(driver.findElement(By.xpath("//td[text()=' " + item + " ']")).isDisplayed(), "Search element is not visible", "Search element is visible");
	}
	public void goToCordInspectListScreen() {
		if (!cordInspectList.isVisible())
			home.click("Home");
		cordInspectList.click("Conveyor List");
		btSearchinput.isVisible("Conveyor List Page");
	}
	public void goToCordInspectListScreenAndWait() {
		goToCordInspectListScreen();
		scrollPageDown();
		String val = "";
		for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(250); stop > System.nanoTime(); ) {
			if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
				break;
			}
			val = pagination.getText();
			SyncUtil.waitFor(8000);
		}
	}
	public void validateCordInspectCountWrtPagination(){
		int deviceCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		Validator.assertTrue(apiBase.getCordInspectCount().get("count").equals(deviceCount),"Cord Inspect Pagination Count does not match","Cord Inspect Pagination Count matches");
		Validator.assertTrue(Integer.toString(deviceCount).equals(beltScanCardCount.getText()),"Cord Inspect Card Count does not match","Cord Inspect Card Count matches");

	}

	public void verifyDataAreEmptyInAddScanDetails(){
		Validator.assertTrue(ddlBeltManufacturer.getText().isEmpty(),"Belt Manufacturer is not empty","Belt Manufacturer is empty");
		Validator.assertTrue(ddlTopCoverCompound.getText().isEmpty(),"TopCoverCompound is not empty","TopCoverCompound is empty");
		Validator.assertTrue(ddlBottomCoverCompound.getText().isEmpty(),"BottomCoverCompound is not empty","BottomCoverCompound is empty");
		Validator.assertTrue(txtNumberOfCords.getText().isEmpty(),"NumberOfCords is not empty","NumberOfCords is empty");
		Validator.assertTrue(txtCordPitch.getText().isEmpty(),"CordPitch is not empty","CordPitch is not empty");
		Validator.assertTrue(txtCordDiameter.getText().isEmpty(),"CordDiameter is not empty","CordDiameter is not empty");
		Validator.assertTrue(txtBeltWidth.getText().isEmpty(),"BeltWidth is not empty","BeltWidth is empty");
		Validator.assertTrue(txtBeltRating.getText().isEmpty(),"BeltRating is not empty","BeltRating is empty");
		Validator.assertTrue(txtTopCoverThicknessInput.getText().isEmpty(),"TopCoverThicknessInput is not empty","TopCoverThicknessInput is empty");
		Validator.assertTrue(txtBottomCoverThicknessInput.getText().isEmpty(),"BottomCoverThicknessInput is not empty","BottomCoverThicknessInput is empty");
		Validator.assertTrue(txtBeltLength.getText().isEmpty(),"BeltLength is not empty","BeltLength is empty");
		Validator.assertTrue(txtSplicesQuantity.getText().isEmpty(),"SplicesQuantity is not empty","SplicesQuantity is empty");
		Validator.assertTrue(txtBeltSpeed.getText().isEmpty(),"BeltSpeed is not empty","BeltSpeed is empty");
		Validator.assertTrue(txtSpliceDesign.getText().isEmpty(),"SpliceDesign is not empty","SpliceDesign is empty");
		Validator.assertTrue(txtEncoderWheelDiameter.getText().isEmpty(),"EncoderWheelDiameter is not empty","EncoderWheelDiameter is empty");
		Validator.assertTrue(txtNumberOfCountsPerRevolution.getText().isEmpty(),"NumberOfCountsPerRevolution is not empty","NumberOfCountsPerRevolution is empty");
		Validator.assertTrue(txtDistanceOfSensorFromBelt.getText().isEmpty(),"DistanceOfSensorFromBelt is not empty","DistanceOfSensorFromBelt is empty");
		Validator.assertTrue(ddlCpuLeftBelt.getText().isEmpty(),"CpuLeftBelt is not empty","CpuLeftBelt is empty");
		Validator.assertTrue(txtSensorBeltOffset.getText().isEmpty(),"SensorBeltOffset is not empty","SensorBeltOffset is empty");
		Validator.assertTrue(ddlSensorWidth.getText().isEmpty(),"SensorWidth is not empty","SensorWidth is empty");
		Validator.assertTrue(txtTechnicalSupport.getText().isEmpty(),"TechnicalSupport is not empty","TechnicalSupport is empty");
		Validator.assertTrue(txtCustomerSupport.getText().isEmpty(),"CustomerSupport is not empty","CustomerSupport is empty");
		Validator.assertTrue(dateOfScan.getText().isEmpty(),"dateOfScan is not empty","dateOfScan is empty");
	}
	public void verifyDataForBeltScan(String siteName,String conveyorName,String topCoverCompound,String note){
		waitForPageLoad(10000);
		SyncUtil.waitFor(5000);
		waitForElementVisible(addGeneralHeader,10000,1000);
		Validator.assertTrue(inpSite.getText().contains(siteName),"Site Name does not match","Site Name does match");
		Validator.assertTrue(inpConveyor.getText().contains(conveyorName),"Conveyor Name does not match","Conveyor Name does match");
		btNext.click();
		System.out.println(topCoverCompound);
		Validator.assertTrue(inpTopCoverCompound.getAttribute("value").contains(topCoverCompound),"TopCoverCompound does not match","TopCoverCompound does match");
		btNext.click();
		Validator.assertTrue(addScanningFilesNote.getAttribute("value").contains(note),"Note does not match","Note does match");
		cancelBtnClick();
	}
	public void verifyLoadBackUpDataFun(){
		Validator.assertTrue(loadBackupData.isVisible(10000,"loadBackupDataButton"),"Load Back up Data is not visible","Load Back up Data is visible");
		waitForElementToInvisible(txtScanningFile,60000);
		SyncUtil.waitFor(100000);
		loadBackupData.jsClick();
		waitForElementToInvisible(buttonLoader,3000);
		waitForElementVisible(txtScanningBackUpSuccessToast,10000,1000);
		Validator.assertTrue(txtScanningBackUpSuccessToast.isVisible(),"Toast message is not visible","Toast message is visible");
	}
	public void verifyLoadTechnicalDataFun(String topCoverCompound,String beltWidth){
		Validator.assertTrue(loadTechnicalData.isVisible(10000,"loadTechnicalDataButton"),"Load Technical Data is not visible","Load Technical Data is visible");
		loadTechnicalData.click();
		waitForElementToInvisible(buttonLoader,10000);
		waitForElementVisible(inpTopCoverCompound,3000,1000);
		Validator.assertTrue(inpTopCoverCompound.getAttribute("value").contains(topCoverCompound),"TopCoverCompound does not match","TopCoverCompound does match");
		Validator.assertTrue(inpBeltWidth.getAttribute("value").contains(beltWidth),"Belt Width does not match","Belt Width does match");
	}
	public void sendFile(String fileName) {
		String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_data").getAbsolutePath();
		crFileUpload.sendKeys(file_path, "File Path");
	}
	public void validateNextBtnAndScanDetailsDisabled() {
		Validator.assertTrue(Boolean.parseBoolean(headerAddScanDetails.getAttribute("aria-disabled")),"Add Scan Details is not disabled","Add Scan Details is disabled");
		System.out.println(2000);
		Validator.assertTrue(btNext.isNotVisible(100),"Next Button is visible","Next Button is not visible");
		SyncUtil.waitFor(3000);
	}

	public void verifyCordInspectIconIsEnabled() {
		SyncUtil.waitFor(30000);
		Validator.assertTrue(btCordInspectIcon.isEnable(),"Cord Inspect Icon is not enabled","Cord Inspect Icon is enabled");
	}
	public void verifyNavigateToCordInspect() {
		btCordInspectIcon.click("Cord Inspect Icon");
		waitForPageLoad(5000);
		Validator.assertTrue(cordInspectFloatingMenu.isVisible(),"Cord Inspect floating menu is not visible","Cord Inspect floating menu is visible");
		Validator.assertTrue(cordInspectViewPage.isVisible(),"Cord Inspect Page is not visible","Cord Inspect Icon is visible");
	}
	public void verifyBeltScanListDownloadFunctionality(String beltInfo,String rawCapture,String scanningReport) {
		btScanFileDownload.click();
		Validator.assertTrue(MiscUtils.checkDownloadedFiles(beltInfo), "Belt Info Scan File report was not found", "Belt Info Scan File was downloaded successfully");
		MiscUtils.deleteDownloadedFiles(beltInfo);
		btRawFileDownload.jsClick();
		waitForPageLoad(2000);
		SyncUtil.waitFor(30000);
		Validator.assertTrue(MiscUtils.checkDownloadedFiles(rawCapture), "Raw Capture File report was not found", "Raw Capture File was downloaded successfully");
		MiscUtils.deleteDownloadedFiles(rawCapture);
		btScanningReportDownloadFile.jsClick();;
		waitForPageLoad(2000);
		SyncUtil.waitFor(2000);
		waitForElementVisible(btScanningReportDownloadIcon,5000,1000);
		btScanningReportDownloadIcon.click();
		SyncUtil.waitFor(5000);
		Validator.assertTrue(MiscUtils.checkDownloadedFiles(scanningReport), "Scanning Report File was not found", "Scanning Report File was downloaded successfully");
		MiscUtils.deleteDownloadedFiles(scanningReport);
	}
	public void clickDownloadAndVerifyFunForbeltScan(String download)
	{
		SyncUtil.waitFor(15000);
		waitForElementVisible(driver.findElement(By.xpath("//label[contains(text(),'"+download+"')]/..//span[@class='ctp-icon-Download']/../..")),5000,1000);
		driver.findElement(By.xpath("//label[contains(text(),'"+download+"')]/..//span[@class='ctp-icon-Download']/../..")).click();
		SyncUtil.waitFor(15000);
	}
	public void verifyCSVContentsForDefaultHeaderBeltScan(String file,String dateOfScan,String deviceType,String siteName,String conveyorName,String territory,String ccm,String beltInfoScan,String rawCaptureFile,String scanningReport) {
		Map<String, String> val = (Map<String, String>) (CSVUtil.getCSVDataAsMap(System.getProperty("user.dir") + System.getProperty("file.separator") + "target" + System.getProperty("file.separator") + "downloads" + System.getProperty("file.separator") + file)).get(0)[0];
		System.out.println(val);
		Validator.assertTrue(val.containsKey(dateOfScan),"Date of Scan Column is not displayed","Date of Scan Column is displayed");
		Validator.assertTrue(val.containsKey(deviceType),"Device Type Column is not displayed","Device Type Column is not displayed");
		Validator.assertTrue(val.containsKey(siteName),"Site Column is not displayed","Site Column is displayed");
		Validator.assertTrue(val.containsKey(conveyorName),"Conveyor Column is not displayed","Conveyor Column is displayed");
		Validator.assertTrue(val.containsKey(territory),"Territory Column is not displayed","Territory Column is displayed");
		Validator.assertTrue(val.containsKey(ccm),"CCM Column is not displayed","CCM Column is not displayed");
		Validator.assertTrue(val.containsKey(beltInfoScan),"Belt Info Scan Column is not displayed","Belt Info Scan Column is displayed");
		Validator.assertTrue(val.containsKey(rawCaptureFile),"Raw Capture Column is not displayed","Raw Capture Column is  displayed");
		Validator.assertTrue(val.containsKey(scanningReport),"Scanning Column is not displayed","Scanning Column is displayed");
		}
	public void waitForToastMessage() {
	waitForElementVisible(toastMsg,20000,1000);
	Validator.assertTrue(toastMsg.isVisible(),"Toast message is not visible","Toast message is visible");
}

	public void beltScanIsInViewMode() {
	SyncUtil.waitFor(20000);
	waitForElementVisible(viewGeneralDetailsHeader,20000,1000);
	Validator.assertTrue(viewGeneralDetailsHeader.isVisible("View General Details"),"View General Details not visible","View General Details is visible");
	Validator.assertTrue(viewScanDetailsHeader.isVisible("View Scan Details"),"View Scan Details not visible","View Scan Details is visible");
	Validator.assertTrue(viewScanningFilesHeader.isVisible("View Scanning Files"),"View Scanning Files not visible","View Scanning Files is visible");
	SyncUtil.waitFor(8000);
	}
	public boolean addColumnAFilter(String corporates) {
	waitForPageLoad(10000);
	SyncUtil.waitFor(10000);
	setImplicitWait(30000, TimeUnit.MILLISECONDS);
	waitForElementToBeClickable(filterDropdown);
	filterDropdown.jsClick();
	waitForElementToDisplay(tbMultipleSiteDropdown);
	waitForElementVisible(tbMultipleSiteDropdown,10000,1000);
	tbMultipleSiteDropdown.type(corporates);
	waitForPresenceOfElement(By.xpath("//li/span[contains(text(),'" + corporates + "')]"));
	driver.findElement("//li/span[contains(text(),'" + corporates + "')]").click();
	return corporatesCol.isEnable();
}
public void removeColumnFilter(String corporates) {
	waitForPageLoad(10000);
	SyncUtil.waitFor(5000);
	setImplicitWait(30000, TimeUnit.MILLISECONDS);
	waitForElementToBeClickable(filterDropdown);
	filterDropdown.click();
	waitForElementToDisplay(tbMultipleSiteDropdown);
	waitForElementVisible(tbMultipleSiteDropdown,10000,1000);
	tbMultipleSiteDropdown.type(corporates);
	waitForElementVisible(filterSelectedValue,5000,1000);
	filterSelectedValue.click();
}
	public void verifyMenuListItems(){
		for(String listName:menuListNames)    {
			Validator.assertTrue(driver.findElement(By.xpath("//div//ul[@class='cord-menu-layout']//a//span[text()='"+listName+"']")).isDisplayed(),"'"+listName+"' link is not visible","'"+listName+"' link is visible");
		}
	}
	public void clickAndVerifyFloatingMenuIconForCI(){
		menuList.isVisible(10000,"MenuList");
		waitForElementToBeClickable(menuList);
		menuList.click("menuList");
		verifyMenuListItems();
	}
	public void clickOnMenuDownwardArrow(){
		floatingDownWardArrow.isVisible(10000,"MenuList");
		waitForElementToBeClickable(floatingDownWardArrow);
		floatingDownWardArrow.click("menuList");
	}
	public void clickOnMainPageAndVerifyNav(){
		mainPageMenu.isVisible(10000,"Main Page");
		waitForElementToBeClickable(mainPageMenu);
		mainPageMenu.click("menuList");
		waitForPageLoad(10000);
		SyncUtil.waitFor(2000);
		Validator.assertTrue(driver.getCurrentUrl().contains("/main-page"),"Url mismatch for main page","Url matched for main page");
	}
	public void clickOnFloatingMenuAndVerifyNav(String menu){
		waitForElementVisible(driver.findElement(By.xpath("//div[@class='menu-cord']//div//span[text()='"+menu+"']")),10000,1000);
		driver.findElement(By.xpath("//div[@class='menu-cord']//div//span[text()='"+menu+"']")).click();
		waitForPageLoad(10000);
		SyncUtil.waitFor(2000);
		Validator.assertTrue(driver.findElement(By.xpath("//p-breadcrumb//li//span[contains(text(),'"+menu+"')]")).isDisplayed(),"Url mismatch for "+menu+ "page","Url matched for  "+menu+ " page");

	}
	public void clickOnFloatingMenuWithBCAndVerifyNav(String menu,String breadcrumb){
		waitForElementVisible(driver.findElement(By.xpath("//div[@class='menu-cord']//div//span[text()='"+menu+"']")),10000,1000);
		driver.findElement(By.xpath("//div[@class='menu-cord']//div//span[text()='"+menu+"']")).click();
		waitForPageLoad(10000);
		SyncUtil.waitFor(2000);
		Validator.assertTrue(driver.findElement(By.xpath("//p-breadcrumb//li//span[contains(text(),'"+breadcrumb+"')]")).isDisplayed(),"Url mismatch for "+menu+ "page","Url matched for  "+menu+ " page");

	}

}
