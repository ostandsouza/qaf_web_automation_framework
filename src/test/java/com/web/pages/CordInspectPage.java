package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;


public class CordInspectPage extends BasePage {
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
	@FindBy(locator = "xpath=//li//a[contains(@class,'p-menuitem-link-active')]//span[text()='Add Scan Details']")
	public CustomElement addScanHeaderActive;
	@FindBy(locator = "xpath=//li//a[contains(@class,'p-menuitem-link-active')]//span[text()='Add Scanning Files']")
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

	@FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
	public CustomElement paginationEntry;
	@FindBy(locator = "xpath=(//app-card//div[text()='Belt Scans'])/../div/div/div/span")
	public CustomElement beltScanCardCount;
	@FindBy(locator="xpath=//th//p-tableheadercheckbox")
	public CustomElement btCheckboxHeader;
	CoverWearPage coverWearPage = new CoverWearPage();

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
		waitForElementToInvisible(btFileUploadingProgress,10000);
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
		return btnCreateDisabled.isDisplayed();
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
	}
	public void addButtonClick()    {
		waitForElementVisible(addIcon,10000,500);
		waitForElementToBeClickable(addIcon);
		addIcon.click("AddIcon");
		SyncUtil.waitFor(5000);
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

	public void deleteItem(String item) {
		waitForElementToDisplay(btSearchinput);
		btSearchinput.type(item, "Search Item");
		waitForElementToDisplay(cbCheckbox);
		SyncUtil.waitFor(3000);
		cbCheckbox.click("Checkbox");
		Validator.assertTrue(coverWearPage.verifyActionBtnState(),"Action button is not enabled after selecting the record","Action button is enabled");
		ddlActions.click("Action");
		waitForElementToBeClickable(btnDelete);
		Validator.assertTrue(btnDelete.isVisible(),"Delete button is not visible","Delete button is visible");
		btnDelete.click("Delete Item");
		btnYes.click("Confirm delete");
		waitForElementToDisplay(noList);
		noList.isVisible("No Item Found");
		Validator.assertTrue(deleteSuccessMsg.isVisible("Delete pop up"),"Delete successfully is not visible","Deleted successfully is visible");
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

	public void verifyDeleteIsVisible()
	{
		waitForElementVisible(btnDelete, 10000,500);
		Validator.assertTrue(btnDelete.isVisible(),"User is not able to see delete Symbol","User is able to see delete Symbol");
	}
	public void verifySelectAllCheckbox()
	{
		waitForElementVisible(btCheckboxHeader, 10000,500);
		Validator.assertTrue(btCheckboxHeader.isVisible("Select all checkbox"),"Select all checkbox is not visible","Select all checkbox is visible");
		System.out.println("btCheckboxHeader clicked");
		btCheckboxHeader.click();
	}

	public void verifyItemNotPresent(String item) {
		waitForElementToDisplay(btSearchinput);
		btSearchinput.type(item, "Item Search");
		waitForElementToDisplay(noList);
		noList.isVisible("No Item Found");
		Validator.assertTrue(noList.isVisible("No Item Found"),"No list is not visible","No list is visible");
	}


}
