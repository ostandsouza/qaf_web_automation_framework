package com.web.pages;




import com.common.utils.ClasspathResourceHelper;
import com.common.utils.MiscUtils;
import com.qmetry.qaf.automation.util.Validator;
import org.apache.poi.ss.util.ImageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import com.qmetry.qaf.automation.util.Reporter;
import org.testng.Assert;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.common.utils.MiscUtils.findMatches;

public class UsersPage extends BasePage{

//	public QAFWebDriver driver;

//	String noOfMasterSites;


	@FindBy(locator = "xpath=//span[text()='Users']")
	public CustomElement lnkUsers;

	@FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
	public CustomElement btAdd;

	@FindBy(locator = "xpath=//input[@name='full_name']")
	public CustomElement tbFullName;

	@FindBy(locator = "xpath=//input[@type='phone']")
	public CustomElement tbPhone;

	@FindBy(locator = "xpath=//input[@name='email']")
	public CustomElement tbEmail;

	@FindBy(locator = "xpath=//div[contains(@class,'conti-dropdown')]")
	public CustomElement ddlSelectprofiletype;

	@FindBy(locator = "xpath=//li[@aria-label='USERS.USER_INFO.PROFILE_TYPES_MASTER']")
	public CustomElement rdbSelectprofiletypeMaster;

	@FindBy(locator = "xpath=//li[@aria-label='USERS.USER_INFO.PROFILE_TYPES_MARKET_MANAGER']")
	public CustomElement rdbSelectprofiletypemarketmanager;

	@FindBy(locator = "xpath=//li[@aria-label='USERS.USER_INFO.PROFILE_TYPES_TERRITORY_MANAGER']")
	public CustomElement rdbSelectprofiletypeterritorymanager;

	@FindBy(locator = "xpath=//li[@aria-label='USERS.USER_INFO.PROFILE_TYPES_STANDARD_CONTINENTAL_USER']")
	public CustomElement rdbSelectprofiletypeStandardContinentalUser;
	
	@FindBy(locator="xpath=//li[@aria-label='USERS.USER_INFO.PROFILE_TYPES_DISTRIBUTOR_USER']")
	public CustomElement rdbSelectprofiletypeDistributorUser;
	
	@FindBy(locator="xpath=//li[@aria-label='USERS.USER_INFO.PROFILE_TYPES_CUSTOMER_USER']")
	public CustomElement rdbSelectprofiletypeCustomerUser;
	
	@FindBy(locator = "xpath=//p-password[@formcontrolname='password']//div//input")
	public CustomElement tbuserPassword;

	@FindBy(locator = "xpath=//p-password[@formcontrolname='confirmPassword']//div//input")
	public CustomElement tbRetypePassword;

	@FindBy(locator = "xpath=//span[text()='Generate password']")
	public CustomElement btGeneratePassword;

	@FindBy(locator = "xpath=//span[text()='Next']")
	public CustomElement btNext;

	@FindBy(locator = "xpath=//div[@aria-label='All']//button")
	public CustomElement eleArrowMT;

	@FindBy(locator = "xpath=//div[@aria-label='All']//div[contains(@class,'p-checkbox')]")
	public CustomElement eleCheckboxMT;

	@FindBy(locator = "xpath=//div[@aria-label='APAC']/div[contains(@class,'p-checkbox')]")
	public CustomElement cbCheckboxAPAC;

	@FindBy(locator = "xpath=//div[@aria-label='EMEA']/div[contains(@class,'p-checkbox')]")
	public CustomElement cbCheckboxEMEA;

	@FindBy(locator = "xpath=//div[@aria-label='South America']/div[contains(@class,'p-checkbox')]")
	public CustomElement cbCheckboxSA;

	@FindBy(locator = "xpath=//div[@aria-label='North America']/div[contains(@class,'p-checkbox')]")
	public CustomElement cbCheckboxNA;

	@FindBy(locator = "xpath=//span[text()='Australia']")
	public CustomElement cbCheckboxAustralia;

	@FindBy(locator = "xpath=//i[contains(@class,'pi-spinner')]")
	public CustomElement cbSpinner;
	@FindBy(locator = "xpath=//th[contains(text(),'Add')]/p-tristatecheckbox//div[@role='checkbox']")
	public CustomElement cbAllcheckboxAdd;

	@FindBy(locator = "//th[contains(text(),'Edit')]/p-tristatecheckbox//div[@role='checkbox']")
	public CustomElement cbAllcheckboxEdit;

	@FindBy(locator = "xpath=//th[contains(text(),'Delete')]/p-tristatecheckbox//div[@role='checkbox']")
	public CustomElement cbAllcheckboxDelete;

	@FindBy(locator = "xpath=//th[contains(text(),'View')]/p-tristatecheckbox//div[@role='checkbox']")
	public CustomElement cbAllcheckboxView;

	@FindBy(locator = "xpath=//th[contains(text(),'Download')]/p-tristatecheckbox//div[@role='checkbox']")
	public CustomElement cbAllcheckboxDownload;
	
	@FindBy(locator = "xpath=//span[text()='Save and Close']")
	public CustomElement btSaveandClose;

	@FindBy(locator = "xpath=//li[contains(@class,'user-profile')]")
	public CustomElement btprofile;

	@FindBy(locator = "xpath=//h6[text()='Logout']")
	public CustomElement btlogout;

	@FindBy(locator = "xpath=//p-dropdown[@datakey='companyId']//div[@aria-label='dropdown trigger']")
	public CustomElement ddlCorportaedropdown;
	
	@FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter p-inputtext')]")
	public CustomElement tbCorporateSearch;
	
	@FindBy(locator = "xpath=//p-dropdown[@formcontrolname='corporateRole']//div[@aria-label='dropdown trigger']")	
	public CustomElement ddlCorporateroledropdown;
	
	@FindBy(locator="xpath=//li[@aria-label='USERS.USER_INFO.CORPORATE_ROLE_MANAGER']")
	public CustomElement rdbManager;

	@FindBy(locator="xpath=//li[@aria-label='USERS.USER_INFO.CORPORATE_ROLE_SERVICE_ENGINEER']")
	public CustomElement rdbEngineer;
	
	@FindBy(locator="xpath=//p-multiselect[@formcontrolname='subscriptionType']//chevrondownicon")
//	@FindBy(locator="xpath=//p-multiselect//span[contains(@class,'pi-chevron-down')]")
	public CustomElement ddlSubscriptionType;

	@FindBy(locator="xpath=//div[@role='checkbox']")
	public CustomElement ddlCheckbox;

	@FindBy(locator="xpath=//div[text()=' Engineering ']")
	public CustomElement eleEngineering;
	
	@FindBy(locator="xpath=//div[text()=' Basics ']")
	public CustomElement eleBasics;
	
	@FindBy(locator="xpath=//tr[@class='ng-star-inserted']//td//p-tablecheckbox")
	public CustomElement cbTablecheckbox;
	
	@FindBy(locator="xpath=//button[@class='p-element p-splitbutton-menubutton p-button p-component p-button-icon-only']")
	public CustomElement ddlActions;
	
	@FindBy(locator="xpath=//span[text()='Edit']")
	public CustomElement btEdit;
	
	@FindBy(locator="xpath=//span[text()='Update']")
	public CustomElement btUpdate;
	
	@FindBy(locator="//span[text()='Delete']")
	public CustomElement btDelete;
	
	@FindBy(locator="//span[text()='Yes']")
	public CustomElement btYes;

	@FindBy(locator = "xpath=//input[contains(@class,'p-inputtext')]")
	public CustomElement btSearch;

	@FindBy(locator="xpath=(//td//img)[1]")
	public CustomElement btImg;

	@FindBy(locator="xpath=(//td[3])[1]")
	public CustomElement btName;

	@FindBy(locator="xpath=(//td[4]/span)[1]")
	public CustomElement btProfile;

	@FindBy(locator="xpath=(//td[5])[1]")
	public CustomElement btCorporate;

	@FindBy(locator="xpath=(//td[6])[1]")
	public CustomElement btSubscription;

	@FindBy(locator="xpath=(//td[8]//p-chip/div)[1]")
	public CustomElement btTerritory;

	@FindBy(locator="xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
	public CustomElement btviewicon;

	@FindBy(locator="xpath=//span[text()='Edit']")
	public CustomElement editBtn;

	@FindBy(locator="xpath=//input[@placeholder='Search']")
	public CustomElement btSearchinput;

	@FindBy(locator="xpath=(//button/chevrondownicon)[2]")
//	@FindBy(locator="xpath=(//button/span[contains(@class,'pi-chevron-down')])[2]")
	public CustomElement btActions;

	@FindBy(locator="xpath=(//td//p-tablecheckbox)[1]")
	public CustomElement btCheckbox;

	@FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
	public CustomElement pagination;

	@FindBy(locator="xpath=//input[@class='p-tree-filter p-inputtext p-component']")
	public CustomElement tbSearch;

	@FindBy(locator="xpath=(//div[@aria-label='ALL']/div)[1]")
	public CustomElement distShopCheckbox;

	@FindBy(locator="xpath=(//div[@aria-label='ALL']/div)[2]")
	public CustomElement custShopCheckbox;

	@FindBy(locator = "xpath=//td[contains(text(),'No')]")
	public CustomElement noList;

	@FindBy(locator = "xpath=//span[text()='Bulk Import']")
	public CustomElement bulkImport;

	@FindBy(locator = "xpath=//h6[text()='Steps:']")
	public CustomElement importStepsHeader;

	@FindBy(locator = "xpath=//h6[text()='Import Form']")
	public CustomElement importFormHeader;

	@FindBy(locator = "xpath=//h6[text()='File Drop or Select']")
	public CustomElement fileDropHeader;

	@FindBy(locator = "xpath=//span[text()='Save']")
	public CustomElement saveBtn;

	@FindBy(locator = "xpath=//div[contains(@class,'loader-container')]")
	public CustomElement loaderUpload;

	@FindBy(locator = "xpath=//label[text()='Profile']/..//div[@role='button']")
	public CustomElement profileDropdown;

	@FindBy(locator = "xpath=//label[contains(text(),'Corporate')]/..//div[@role='button']")
	public CustomElement corporateDropdown;

	@FindBy(locator= "xpath=//input[contains(@class,'p-dropdown-filter')]")
	public CustomElement tbSearchDropdown;

	@FindBy(locator = "xpath=//div[text()=' Master ']")
	public CustomElement master;

	@FindBy(locator = "xpath=//div[text()=' Market manager ']")
	public CustomElement marketManager;

	@FindBy(locator = "xpath=//div[text()=' Territory manager ']")
	public CustomElement territoryManager;

	@FindBy(locator = "xpath=//div[text()=' Standard continental user ']")
	public CustomElement standardContinentalUser;

	@FindBy(locator = "xpath=//div[text()=' Distributor user ']")
	public CustomElement distributorUser;

	@FindBy(locator = "xpath=//div[text()=' Customer user ']")
	public CustomElement customerUser;

	@FindBy(locator = "xpath=//span[text()='Download Template']")
	public CustomElement downloadTemplate;

	@FindBy(locator = "xpath=//input[@type='file']")
	public CustomElement fileUpload;

	@FindBy(locator = "xpath=//div[text()='Upload successful. Click Save to proceed.']")
	public CustomElement uploadProceed;

	@FindBy(locator = "xpath=//i[contains(@class,'ctp-icon-Delete')]")
	public CustomElement deleteFile;

	@FindBy(locator = "xpath=//i[contains(@class,'ctp-icon-Delete')]/../../div[1]")
	public CustomElement uploadFileName;

	@FindBy(locator = "xpath=//label[text()='Analyzing Users']")
	public CustomElement analysingUsers;

	@FindBy(locator = "xpath=//span[text()='Back']")
	public CustomElement backBtn;

	@FindBy(locator = "xpath=//span[text()='Continue']")
	public CustomElement continueBtn;

	@FindBy(locator="xpath=//div[contains(@class,'font-bold')]/div[1]")
	public CustomElement totalUsers;

	@FindBy(locator="xpath=//div[contains(@class,'font-bold')]/div[2]")
	public CustomElement usersCreated;

	@FindBy(locator="xpath=//div[contains(@class,'font-bold')]/div[6]")
	public CustomElement usersError;

	@FindBy(locator = "xpath=//span[text()='Import']")
	public CustomElement importBtn;

	@FindBy(locator="xpath=//div[text()='Users has been imported successfully.']")
	public CustomElement userImportSuccessful;

	@FindBy(locator="xpath=//button[contains(@class,'p-button-loading')]")
	public CustomElement buttonLoader;

	@FindBy(locator="xpath=//div[contains(@class,'p-datatable-header')]//h4[text()='Users']")
	public CustomElement usersHeader;



	@FindBy(locator="//div[@class='conti-avatar-section']//img[@class='avatar-section-img default-image']")
	public CustomElement userDefaultImage;

	@FindBy(locator="//div[@class='icon']//img")
	public CustomElement cameraIcon;

	@FindBy(locator="//div[@role='dialog']")
	public CustomElement dialogBox;

	@FindBy(locator="//label[normalize-space()='Upload Image']")
	public CustomElement btUploadImg;

	@FindBy(locator="//button[@class='p-element p-button p-component ng-star-inserted']//span[normalize-space()='Cancel']")
	public CustomElement btCancelImg;

	@FindBy(locator="//div[contains(@class,'cropped-frame')]")
	public CustomElement imgPreview;

	@FindBy(locator="//span[@class='ngx-ic-resize ngx-ic-topright ng-star-inserted']")
	public CustomElement eleResize;

	@FindBy(locator="//span[normalize-space()='Cancel']")
	public CustomElement btnCancelUser;

	@FindBy(locator="//p-splitbutton[@icon='ctp-icon-Save']")
	public CustomElement btnTempSave;

	@FindBy(locator="//input[@id='templateName']")
	public CustomElement tbTempName;

	@FindBy(locator="//div[@aria-label='dropdown trigger']")
	public CustomElement ddlTempDropdown;

	@FindBy(locator="//p-splitbutton[@icon='ctp-icon-Edit']")
	public CustomElement btnTempEdit;

	@FindBy(locator="//p-splitbutton[@icon='ctp-icon-Delete']")
	public CustomElement btnTempDelete;

	@FindBy(locator ="//div[text()='Template Deleted']")
	public CustomElement altDeletedTemp;

	@FindBy(locator ="//div[text()='Template Created']")
	public CustomElement altCreatedTemp;

	@FindBy(locator ="//div[text()='Template Updated']")
	public CustomElement altUpdatedTemp;

	@FindBy(locator ="//span[text()='Yes']")
	public CustomElement btnYes;

	@FindBy(locator="xpath=//span[text()='Confirmation']")
	public CustomElement dialogBoxDelete;

//	@FindBy(locator="//div[not(@hidden)]/label/em[text()='*']/..")
//	public CustomElement manField;

	@FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
	public CustomElement home;

	@FindBy(locator = "xpath=//a[@routerlinkactive]//span[text()='Sites']")
	public CustomElement Site;

	@FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
	public CustomElement paginationEntry;

	@FindBy(locator = "xpath=//span[text()='Previous']")
	public CustomElement btnPrevious;

	@FindBy(locator = "xpath=//div[text()=' Personal information ']")
	public CustomElement txtPersonalInfo;

	@FindBy(locator="xpath=(//button[@type='button']//chevrondownicon)[2]")
	public CustomElement ddlUserActions;


	@FindBy(locator = "xpath=//td[text()='No users to list!']")
	public CustomElement txtNoResult;

	@FindBy(locator = "xpath=(//p-skeleton)[1]")
	public CustomElement userLoader;

	@FindBy(locator = "xpath=(//button[@icon='pi pi-refresh'])[2]")
	public CustomElement userRefresh;

	@FindBy(locator = "xpath=//span[text()='Assign']")
	public CustomElement btAssign;

	@FindBy(locator = "xpath=//label[text()='Profile']/..//p-dropdown")
	public CustomElement btDropDown;

	@FindBy(locator = "xpath=//label[text()='Profile']/..//p-dropdown//span//div")
	public CustomElement btDropDownInput;

	@FindBy(locator = "xpath=//p-radiobutton[@value='update']")
	public CustomElement rdbtnUpdate;
	@FindBy(locator = "xpath=//h6[text()='Analysis Results and Message']")
	public CustomElement txtAnalysisResult;
	@FindBy(locator = "xpath=//div[contains(text(),'Total Users: ')]")
	public CustomElement txtTotalUsers;
	@FindBy(locator = "xpath=//div[contains(text(),'Users to Create: ')]")
	public CustomElement txtUsersToCreate;
	@FindBy(locator = "xpath=//div[contains(text(),'Users to Update: ')]")
	public CustomElement txtUsersToUpdate;
	@FindBy(locator = "xpath=//div[contains(text(),'Users to Skip: ')]")
	public CustomElement txtUsersToSkip;
	@FindBy(locator = "xpath=//div[contains(text(),'Warnings: ')]")
	public CustomElement txtWarnings;
	@FindBy(locator = "xpath=//div[contains(text(),'Errors: ')]")
	public CustomElement txtErrors;

	@FindBy(locator = "xpath=//h6[text()='Import Report']")
	public CustomElement importReportHeader;

	@FindBy(locator = "xpath=//p[text()='Drop File to Import(format:xlsx)']")
	public CustomElement txtDropFile;

	@FindBy(locator ="//div[text()='Users has been imported successfully.']")
	public CustomElement altSuccessUserCreation;

	@FindBy(locator = "xpath=//div[text()='Please check the excel file or record count and try to upload again.']")
	public CustomElement uploadFailure;

	public void usersclick() {
		waitForElementVisible(lnkUsers, 10000,500);
		lnkUsers.jsClick();
		waitForPageLoad(10000);
		waitForElementVisible(usersHeader,5000,500);
	}

	public boolean searchUser(String searchtext) {
		waitForPageLoad(10000);
		waitForElementVisible(btSearchinput, 10000, 500);
		btSearchinput.type(searchtext);
		waitForElementToInvisible(userLoader,10000);
		waitForElementToInvisible(txtNoResult,20000);
		waitForElementVisible(btCheckbox,20000,500);
		waitForElementToDisplay(btCheckbox);
		return btCheckbox.isVisible("User Found");
	}

	public boolean searchUserEdit(String searchtext) {
		waitForPageLoad(10000);
//		SyncUtil.waitFor(10000);
		waitForElementVisible(btSearchinput, 10000, 500);
		btSearchinput.type(searchtext);
		SyncUtil.waitFor(10000);
//		waitForPageLoad(20000);
		waitForElementVisible(driver.findElement(By.xpath("//td[contains(text(),' "+searchtext+" ')]")),20000,1000);
		waitForElementVisible(btCheckbox,20000,500);
		waitForElementToDisplay(btCheckbox);
		return btCheckbox.isVisible("User Found");
	}

	public void addClick() {
		lnkUsers.jsClick();
		waitForElementToDisplay(btAdd);
		waitForElementToBeClickable(btAdd);
		btAdd.jsClick();
	}

	public void setfullname(String Fullname) {
		waitForPageLoad(5000);
		waitForElementVisible(tbFullName, 5000,500);
		tbFullName.type(Fullname, "Fullname");
	}
	
	public void setfullname1(String Fullname1) {
		tbFullName.type(Fullname1, "Fullname1");
	}

	public void setPhone(String code,String Phone) {
		waitForElementVisible(tbPhone, 5000,500);
		tbPhone.type(code+Phone, "Phone");
	}

	public void setemail(String email) {
		tbEmail.type(email,"email");
//		tbEmail.verifyText(email, "email");
	}
	
	

	public void setProfileType(String profileType) {

		ddlSelectprofiletype.click();

		WebElement listitem;

		if(profileType.equalsIgnoreCase("Master"))
		{
			listitem=rdbSelectprofiletypeMaster;
		}
		else if(profileType.equalsIgnoreCase("Market manager"))
		{
			listitem=rdbSelectprofiletypemarketmanager;
		}
		else if(profileType.equalsIgnoreCase("Territory Manager"))
		{
			listitem=rdbSelectprofiletypeterritorymanager;
		}
		else if(profileType.equalsIgnoreCase("Standard Continental User"))
		{
			listitem=rdbSelectprofiletypeStandardContinentalUser;
		}
		else if(profileType.equalsIgnoreCase("Distributor user"))
		{
			listitem=rdbSelectprofiletypeDistributorUser;
		}
		else if(profileType.equalsIgnoreCase("Customer user"))
		{
			listitem=rdbSelectprofiletypeCustomerUser;
		}
		else
			listitem=ddlSelectprofiletype;

		listitem.click();

	}

	public void setpassword(String userpassword) {
		tbuserPassword.type(userpassword,"Userpassword");		
	}

	public void setretypepassword(String retypepassword) {
		tbRetypePassword.type(retypepassword,"Retypepassword");		
	}

	public void Nextclick() {
		btNext.click();
	}

	public void setPermission() {
		waitForElementVisible(btNext, 5000,500);
		btNext.click();
		SyncUtil.waitFor(1000);
		waitForElementToInvisible(cbSpinner,10000);
		cbAllcheckboxAdd.click();
		cbAllcheckboxEdit.click();
		cbAllcheckboxDelete.click();
		cbAllcheckboxView.click();
		cbAllcheckboxDownload.click();
	}

	public void setPermission(String add, String edit, String delete, String view, String download) {
		waitForElementVisible(btNext, 5000,500);
		btNext.click();
		SyncUtil.waitFor(2000);
		waitForElementToInvisible(cbSpinner,25000);
		if(add.equalsIgnoreCase("true"))
			cbAllcheckboxAdd.click();
		if(edit.equalsIgnoreCase("true"))
			cbAllcheckboxEdit.click();
		if(delete.equalsIgnoreCase("true"))
			cbAllcheckboxDelete.click();
		if(view.equalsIgnoreCase("true"))
			cbAllcheckboxView.click();
		if(download.equalsIgnoreCase("true"))
			cbAllcheckboxDownload.click();
	}

	/**
	 *This method is used for selecting permission for particular sub module
	 * @param mainModule: Name of main module
	 * @param subModule: Name of sub module
	 * @param add: Add Permission flag
	 * @param edit: Edit Permission flag
	 * @param delete: Delete Permission flag
	 * @param view: View Permission flag
	 * @param download: Download Permission flag
	 *@return Null
	 *@author Ostan dsouza
	 */
	public void setPermission(String mainModule, String subModule, String add, String edit, String delete, String view, String download) {
		waitForElementVisible(btNext, 5000,500);
		btNext.click();
		SyncUtil.waitFor(1000);
		waitForElementToInvisible(cbSpinner,20000);
		driver.findElement(By.xpath("//span[contains(text(),'"+mainModule+"')]/..//button")).click();
		if(add.equalsIgnoreCase("true"))
			driver.findElement(By.xpath("(//span[contains(text(),'"+mainModule+"')]/../../..//tr/td//span[contains(text(),'"+subModule+"')]/../..//div[contains(@class,'p-checkbox ')])[1]")).click();
		if(edit.equalsIgnoreCase("true"))
			driver.findElement(By.xpath("(//span[contains(text(),'"+mainModule+"')]/../../..//tr/td//span[contains(text(),'"+subModule+"')]/../..//div[contains(@class,'p-checkbox ')])[2]")).click();
		if(delete.equalsIgnoreCase("true"))
			driver.findElement(By.xpath("(//span[contains(text(),'"+mainModule+"')]/../../..//tr/td//span[contains(text(),'"+subModule+"')]/../..//div[contains(@class,'p-checkbox ')])[3]")).click();
		if(view.equalsIgnoreCase("true"))
			driver.findElement(By.xpath("(//span[contains(text(),'"+mainModule+"')]/../../..//tr/td//span[contains(text(),'"+subModule+"')]/../..//div[contains(@class,'p-checkbox ')])[4]")).click();
		if(download.equalsIgnoreCase("true"))
			driver.findElement(By.xpath("(//span[contains(text(),'"+mainModule+"')]/../../..//tr/td//span[contains(text(),'"+subModule+"')]/../..//div[contains(@class,'p-checkbox ')])[5]")).click();
	}

	/**
	 *This method is used for selecting all permission under main module
	 * @param mainModule: Name of main module
	 * @param add: Add Permission flag
	 * @param edit: Edit Permission flag
	 * @param delete: Delete Permission flag
	 * @param view: View Permission flag
	 * @param download: Download Permission flag
	 *@return Null
	 *@author Ostan dsouza
	 */
	public void setPermission(String mainModule, String add, String edit, String delete, String view, String download) {
		waitForElementVisible(btNext, 5000,500);
		btNext.click();
		SyncUtil.waitFor(1000);
		waitForElementToInvisible(cbSpinner,20000);
		if(add.equalsIgnoreCase("true"))
			driver.findElement(By.xpath("(//span[contains(text(),'"+mainModule+"')]/../../..//div[contains(@class,'p-checkbox ')])[1]")).click();
		if(edit.equalsIgnoreCase("true"))
			driver.findElement(By.xpath("(//span[contains(text(),'"+mainModule+"')]/../../..//div[contains(@class,'p-checkbox ')])[2]")).click();
		if(delete.equalsIgnoreCase("true"))
			driver.findElement(By.xpath("(//span[contains(text(),'"+mainModule+"')]/../../..//div[contains(@class,'p-checkbox ')])[3]")).click();
		if(view.equalsIgnoreCase("true"))
			driver.findElement(By.xpath("(//span[contains(text(),'"+mainModule+"')]/../../..//div[contains(@class,'p-checkbox ')])[4]")).click();
		if(download.equalsIgnoreCase("true"))
			driver.findElement(By.xpath("(//span[contains(text(),'"+mainModule+"')]/../../..//div[contains(@class,'p-checkbox ')])[5]")).click();
	}

	public void setTerritory(String region) {
		waitForPageLoad(5000);
		waitForElementToDisplay(eleArrowMT);
		if(region.equalsIgnoreCase("APAC")){
			Reporter.log("isSelected: ="+cbCheckboxAPAC.getAttribute("aria-checked"));
			if(cbCheckboxAPAC.getAttribute("aria-checked").equalsIgnoreCase("false")){
				cbCheckboxAPAC.click();}
		}
		else if(region.equalsIgnoreCase("EMEA")) {
			Reporter.log("isSelected: ="+cbCheckboxEMEA.getAttribute("aria-checked"));
			if(cbCheckboxEMEA.getAttribute("aria-checked").equalsIgnoreCase("false"))
				cbCheckboxEMEA.click();
		}
		else if(region.equalsIgnoreCase("North America")) {
			Reporter.log("isSelected: ="+cbCheckboxNA.getAttribute("aria-checked"));
			if(cbCheckboxNA.getAttribute("aria-checked").equalsIgnoreCase("false"))
				cbCheckboxNA.click();
		}
		else if(region.equalsIgnoreCase("South America")) {
			Reporter.log("isSelected: ="+cbCheckboxSA.getAttribute("aria-checked"));
			if(cbCheckboxSA.getAttribute("aria-checked").equalsIgnoreCase("false"))
				cbCheckboxSA.click();
		}
		else eleCheckboxMT.click();
	}

	public void waitForTerritory() {
		waitForPageLoad(5000);
		waitForElementToDisplay(eleArrowMT);
	}
	
	public void setPermissions() {
		waitForPageLoad(5000);
		SyncUtil.waitFor(3000);
		btNext.click();
		SyncUtil.waitFor(10000);
		cbAllcheckboxView.click();
		SyncUtil.waitFor(2000);
		cbAllcheckboxDownload.click();

	}
	
	public void setpermissionmm1() {
		waitForPageLoad(5000);
		btNext.click();
		SyncUtil.waitFor(7000);
		cbAllcheckboxAdd.click();
		cbAllcheckboxEdit.click();
		cbAllcheckboxDelete.click();
		cbAllcheckboxView.click();
		cbAllcheckboxDownload.click();
	}

	public void Clicksaveandclose() {
		waitForPageLoad(3000);
		waitForElementVisible(btSaveandClose, 10000,500);
		waitForElementToBeClickable(btSaveandClose);
		btSaveandClose.click();
		waitForElementToBeClickable(btSaveandClose);
		SyncUtil.waitFor(15000);
		waitForElementToDisplay(btSearchinput);
		Reporter.log("User is created",MessageTypes.Pass);
	}

	
    public void clickOnLogout() {
    
    	btprofile.click();
    	btlogout.click();
    	
    }

    public void distributorInformation(String corporate, String role) {
    	dropdownSelectSearch(ddlCorportaedropdown, tbCorporateSearch, corporate);
    	ddlCorporateroledropdown.click();
		if(role.equalsIgnoreCase("manager"))
    		rdbManager.click();
		else
			rdbEngineer.click();
    	ddlSubscriptionType.click();
    	eleEngineering.click();
    	eleBasics.click();
		SyncUtil.waitFor(5000);
    }
    
    public void Customerinformation(String corporate) {
    	dropdownSelectSearch(ddlCorportaedropdown, tbCorporateSearch, corporate);
    	ddlCorporateroledropdown.click();
    	rdbManager.click();
    	ddlSubscriptionType.click();
    	eleEngineering.click();
    	eleBasics.click();
    }
   
    public void Edituser() {
    	cbTablecheckbox.click();
        ddlActions.click();
        btEdit.click();
        tbPhone.type("+919676734321");
        btUpdate.click();
        Reporter.log("User Updated Successfully",MessageTypes.Pass);
 	}
    
    public void Deleteuser() {
    	cbTablecheckbox.click();
    	ddlActions.click();
    	btDelete.click();
    	btYes.click();
    	Reporter.log("User deleted successfully",MessageTypes.Pass);
       
    }

	public void DistributorAssignment(String distCorp, String custCorp) {
		SyncUtil.waitFor(1000);
		waitForElementToInvisible(cbSpinner,45000);
		waitForElementToDisplay(tbSearch);
//		tbSearch.type(distCorp);
//		setImplicitWait(30000, TimeUnit.MILLISECONDS);
//		waitForPresenceOfElement(By.xpath("//span[text()='"+distCorp+"']"));
//		getTestBase().getDriver().findElement("//span[text()='"+distCorp+"']").click();
//		tbSearchCustomerSites.type(custCorp);
//		waitForPresenceOfElement(By.xpath("//span[text()='"+custCorp+"']"));
//		getTestBase().getDriver().findElement("//span[text()='"+custCorp+"']").click();
//		setImplicitWait(1000,TimeUnit.MILLISECONDS);
		distShopCheckbox.click();
		custShopCheckbox.click();
	}

	public void goToUserDetail(String userName) {
		Reporter.log("Image :="+btImg.isDisplayed());
		Reporter.log("Name :="+btName.getText());
		Validator.assertTrue(btName.getText().equalsIgnoreCase(userName),"User search result did not match", "User search result verification successful");
		Reporter.log("Profile :="+btProfile.getText());
		Reporter.log("Corp :="+btCorporate.getText());
		Reporter.log("SUbs :="+(btSubscription.getText()));
		Reporter.log("Territory :="+btTerritory.getText());
		btviewicon.click();
		waitForElementVisible(editBtn, 10000,500);
	}

	public void goToEditUserPage(String userName) {
		Reporter.log("Image :="+btImg.isDisplayed());
		Reporter.log("Name :="+btName.getText());
		Validator.assertTrue(btName.getText().equalsIgnoreCase(userName),"User search result did not match", "User search result verification successful");
		Reporter.log("Profile :="+btProfile.getText());
		Reporter.log("Corp :="+btCorporate.getText());
		Reporter.log("SUbs :="+(btSubscription.getText()));
		Reporter.log("Territory :="+btTerritory.getText());
		btviewicon.click();
		waitForElementToDisplay(editBtn);
		waitForElementToBeClickable(editBtn);
		SyncUtil.waitFor(25000);
		waitForElementToBeClickable(editBtn);
		editBtn.click();
	}

	public void clickOnNextBtn() {
		btNext.click();
	}

	public void clickOnUpdateBtn() {
		btUpdate.click();
		waitForElementToInvisible(btUpdate,5000);
		waitForPageLoad(5000);
	}

	public void goToUsers() {
		waitForElementVisible(lnkUsers, 10000,500);
		lnkUsers.click();
		SyncUtil.waitFor(5000);
	}

	public void goToUsersAndWait() {
		waitForElementVisible(lnkUsers, 10000,500);
		lnkUsers.click();
		SyncUtil.waitFor(5000);
		scrollPageDown();
		String val="";
		for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(120); stop>System.nanoTime();) {
			if (val.equalsIgnoreCase(pagination.getText())) {
				Reporter.log("Pagination: ="+pagination.getText());
				break;
			}
			val = pagination.getText();
			SyncUtil.waitFor(10000);
		}
	}

	public void verifyTerritory(String region) {
		SyncUtil.waitFor(2000);
		if(region.equalsIgnoreCase("APAC"))
			Validator.assertTrue(cbCheckboxAPAC.getAttribute("aria-checked").equalsIgnoreCase("true"),"APAC region for this user was supposed to checked","APAC region for this user is checked as expected");
		else
			Validator.assertTrue(cbCheckboxAPAC.getAttribute("aria-checked").equalsIgnoreCase("false"),"APAC region for this user was supposed to unchecked","APAC region for this user is unchecked as expected");
		if(region.equalsIgnoreCase("EMEA"))
			Validator.assertTrue(cbCheckboxEMEA.getAttribute("aria-checked").equalsIgnoreCase("true"),"EMEA region for this user was supposed to checked","EMEA region for this user is checked as expected");
		else
			Validator.assertTrue(cbCheckboxEMEA.getAttribute("aria-checked").equalsIgnoreCase("false"),"EMEA region for this user was supposed to unchecked","EMEA region for this user is unchecked as expected");
		if(region.equalsIgnoreCase("South America"))
			Validator.assertTrue(cbCheckboxSA.getAttribute("aria-checked").equalsIgnoreCase("true"),"South America region for this user was supposed to checked","South America region for this user is checked as expected");
		else
			Validator.assertTrue(cbCheckboxSA.getAttribute("aria-checked").equalsIgnoreCase("false"),"South America region for this user was supposed to unchecked","South America region for this user is unchecked as expected");
		if(region.equalsIgnoreCase("North America"))
			Validator.assertTrue(cbCheckboxNA.getAttribute("aria-checked").equalsIgnoreCase("true"),"North America region for this user was supposed to checked","North America region for this user is checked as expected");
		else
			Validator.assertTrue(cbCheckboxNA.getAttribute("aria-checked").equalsIgnoreCase("false"),"North America region for this user was supposed to unchecked","North America region for this user is unchecked as expected");
		if(region.equalsIgnoreCase("All"))
			Validator.assertTrue(eleCheckboxMT.getAttribute("aria-checked").equalsIgnoreCase("true"),"All regions for this user was supposed to checked","All regions for this user is checked as expected");
		else
			Validator.assertTrue(eleCheckboxMT.getAttribute("aria-checked").equalsIgnoreCase("false"),"All regions for this user was supposed to unchecked","All regions for this user is unchecked as expected");
	}

	public void verifyPermission(String add, String edit, String delete, String view, String download) {
		if(add.equalsIgnoreCase("TRUE"))
			Validator.assertTrue(cbAllcheckboxAdd.getAttribute("aria-checked").equalsIgnoreCase("true"),"ADD permission for this user was supposed to checked","ADD permission  for this user is checked as expected");
		else
			Validator.assertTrue(cbAllcheckboxAdd.getAttribute("aria-checked").equalsIgnoreCase("false"),"ADD permission for this user was supposed to unchecked","ADD permission  for this user is unchecked as expected");
		if(edit.equalsIgnoreCase("TRUE"))
			Validator.assertTrue(cbAllcheckboxEdit.getAttribute("aria-checked").equalsIgnoreCase("true"),"EDIT permission for this user was supposed to checked","EDIT permission for this user is checked as expected");
		else
			Validator.assertTrue(cbAllcheckboxEdit.getAttribute("aria-checked").equalsIgnoreCase("false"),"EDIT permission for this user was supposed to unchecked","EDIT permission for this user is unchecked as expected");
		if(delete.equalsIgnoreCase("TRUE"))
			Validator.assertTrue(cbAllcheckboxDelete.getAttribute("aria-checked").equalsIgnoreCase("true"),"DELETE permission for this user was supposed to checked","DELETE permission for this user is checked as expected");
		else
			Validator.assertTrue(cbAllcheckboxDelete.getAttribute("aria-checked").equalsIgnoreCase("false"),"DELETE permission for this user was supposed to unchecked","DELETE permission for this user is unchecked as expected");
		if(view.equalsIgnoreCase("TRUE"))
			Validator.assertTrue(cbAllcheckboxView.getAttribute("aria-checked").equalsIgnoreCase("true"),"VIEW permission for this user was supposed to checked","VIEW permission for this user is checked as expected");
		else
			Validator.assertTrue(cbAllcheckboxView.getAttribute("aria-checked").equalsIgnoreCase("false"),"VIEW permission for this user was supposed to unchecked","VIEW permission for this user is unchecked as expected");
		if(download.equalsIgnoreCase("TRUE"))
			Validator.assertTrue(cbAllcheckboxDownload.getAttribute("aria-checked").equalsIgnoreCase("true"),"DOWNLOAD permission for this user was supposed to checked","DOWNLOAD permission for this user is checked as expected");
		else
			Validator.assertTrue(cbAllcheckboxDownload.getAttribute("aria-checked").equalsIgnoreCase("false"),"DOWNLOAD permission for this user was supposed to unchecked","DOWNLOAD permission for this user is unchecked as expected");
	}

	public void deleteUser(String user) {
		goToUsersAndWait();
		waitForElementToDisplay(btSearchinput);
		btSearchinput.type(user);
		waitForElementToDisplay(btCheckbox);
		btCheckbox.click();
		btActions.click();
		waitForElementToDisplay(btDelete);
		btDelete.click();
		btYes.click();
	}

	public boolean verifyUser(String user) {
		goToUsersAndWait();
		waitForElementToDisplay(btSearchinput);
		btSearchinput.type(user);
		return noList.isVisible();
	}

	public boolean goToUserBulkUpload() {
		goToUsers();
		addClick();
		waitForElementToDisplay(bulkImport);
		bulkImport.click("Bulk Import");
		return fileDropHeader.isVisible("File Upload");
	}

	public boolean verifyUploadSections() {
		return fileDropHeader.isVisible() && importStepsHeader.isVisible() && importFormHeader.isVisible() && saveBtn.isVisible();
	}

	public boolean verifyImportSection(String userType) {
		setProfileType(userType);
		if(userType.equalsIgnoreCase("Master") || userType.equalsIgnoreCase("Market manager") || userType.equalsIgnoreCase("Territory manager") && userType.equalsIgnoreCase("standard continental user"))
			return profileDropdown.isVisible() && downloadTemplate.isVisible();
		else if (userType.equalsIgnoreCase("Distributor user") || userType.equalsIgnoreCase("Customer user"))
			return profileDropdown.isVisible() && corporateDropdown.isVisible() && downloadTemplate.isVisible();
		else return false;
	}

	public void checkDownloadTemplate(String userType, String corp) {
		setProfileType(userType);
		if (userType.equalsIgnoreCase("Distributor user") || userType.equalsIgnoreCase("Customer user"))
			dropdownSelectSearch(corporateDropdown, tbSearchDropdown, corp);
		downloadTemplate.click("Download Template");
	}

	public boolean userFileUpload(String fileName) {
		String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "excel_data").getAbsolutePath();
		fileUpload.sendKeys(file_path, "File Path");
		deleteFile.assertVisible("Delete File upload");
		return uploadProceed.isVisible();
	}

	public void userFileImport(String fileName) {
		String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "excel_data").getAbsolutePath();
		fileUpload.sendKeys(file_path, "File Path");
		deleteFile.assertVisible("Delete File upload");
		uploadFileName.assertText(fileName,"Upload file name");
		loaderUpload.waitForNotVisible(15000);
		saveBtn.click("Save File Upload");
		Reporter.log("User Import file uploaded",MessageTypes.Pass);
	}

	public void acknowledgeImport(int count){
		waitForElementToInvisible(analysingUsers,10000);
		continueBtn.click("Continue");
		Validator.assertTrue(totalUsers.getText().contains(String.valueOf(count)),"Total users count incorrect","All users are verified successfully");
		System.out.println(usersCreated.getText());
		System.out.println(count);
		Validator.assertTrue(usersCreated.getText().contains(String.valueOf(count)),"Total Imported users count incorrect","All user imported successfully");
		Validator.assertTrue(usersError.getText().contains(String.valueOf(0)),"Total error users incorrect","All error user count is verfied successfully");
	}

	public void verifyMsg(){
		waitForElementToInvisible(analysingUsers,10000);
		continueBtn.click("Continue");
	}
	public boolean importUsers(){
		waitForElementToInvisible(analysingUsers,10000);
		continueBtn.click("Continue");
		importBtn.click("Import");
		waitForElementToInvisible(buttonLoader,15000);
		return btSearchinput.isVisible();
	}

	public void verifyTemplateFields(String fileName, String sheetName){
		Object[][] obj = MiscUtils.getDownloadedExcelData(fileName,sheetName);
		Set<String> expected = new HashSet<>(Arrays.asList(new String[]{"Fullname", "EmailId", "Phone Number", "Assignment Template", "Permission Template"}));
		for( int i = obj.length-1;i>0;i--)
			Validator.assertTrue(expected.contains((((Map<String,String>)obj[0][i]).keySet())),"Template column mismatch","Template column verified successfully");
	}

	public void verifyUploadedUsers(String sheetName, String fileName) {
		Object[][] obj = MiscUtils.getExcelData(fileName,sheetName);
		for( int i = obj.length-1;i>0;i--)
			Validator.assertTrue(searchUser(((Map<String,String>)obj[i][0]).get("Fullname")),"Imported User was not created successfully","Imported User created successfully");
	}

	public void verifyTemplateSheet(String siteName, String fileName) {
		List<String> obj = MiscUtils.getDownloadedExcelSheet(fileName);
		Validator.assertTrue(obj.contains(siteName),"Template was downloaded for incorrect user type","Template was downloaded for right user type successfully");
	}

	public void usersClick() {
		waitForElementVisible(lnkUsers, 5000,1000);
		waitForElementToBeClickable(lnkUsers);
		lnkUsers.click();
		waitForPageLoad(20000);
		waitForElementVisible(usersHeader,5000,500);
	}

	public void addIconClick() {
		waitForElementToDisplay(btAdd);
		waitForElementVisible(btAdd,20000,1000);
		waitForElementToBeClickable(btAdd);
		waitForPageLoad(5000);
		btAdd.jsClick();
	}

	public void verifyDefaultImage()
	{
		waitForElementVisible(userDefaultImage,5000,500);
		Validator.assertTrue(userDefaultImage.isDisplayed(), "Default image is not displayed","Default Image is Displayed");
		hoverOverElement(userDefaultImage);
		waitForElementVisible(cameraIcon,5000,500);
		Validator.assertTrue(cameraIcon.isDisplayed(), "cameraIcon is not visible on the page","cameraIcon is  visible on the page");

	}

	public void verifyOptionInImagePanel(){
		waitForElementVisible(cameraIcon,5000,500);
		cameraIcon.click();
		waitForElementVisible(dialogBox, 10000,500);
		Validator.assertTrue(dialogBox.isDisplayed(),"Dialog box is not visible","Dialog box is visible");
		Validator.assertTrue(btUploadImg.isDisplayed(),"Upload button is not visible","Upload button is visible");
		Validator.assertTrue(imgPreview.isDisplayed(),"Image Preview is not visible","Image Preview is visible");
		Validator.assertTrue(saveBtn.isDisplayed(),"Save Button is not visible","Save Button is visible");
		Validator.assertTrue(btCancelImg.isDisplayed(),"Cancel Button is not visible","Cancel Button is visible");
	}

	public void uploadImageClick()
	{
		waitForElementVisible(btUploadImg,5000,500);
		waitForElementToBeClickable(btUploadImg);
		btUploadImg.click();
	}

	public void imageUpload(String fileName){
		String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_files").getAbsolutePath();
		fileUpload.sendKeys(file_path, "img_upload");
	}


	public void cropOrMoveImage()
	{
		waitForElementVisible(eleResize,5000,500);
		cropImage(eleResize);
	}

	public void clickSave(){
		saveBtn.click();
		waitForElementToInvisible(saveBtn,10000);
		String expectedSrc = "/assets/img/upload_default.png";
		Assert.assertNotEquals(userDefaultImage.getAttribute("src"), expectedSrc, "The src attribute of the addDefaultImg element is not as expected");
	}

	public void verifyCancel(){
		waitForElementVisible(btnCancelUser,5000,500);
		Validator.assertTrue(btnCancelUser.isDisplayed(),"Cancel button is not visible","Cancel button is visible");
		btnCancelUser.click();
	}

	public void verifyUserTablePage()
	{
		waitForPageLoad(5000);
		Validator.assertTrue(driver.getCurrentUrl().contains("secure/users/list"),"URL missMatch","URL validation passed");

	}
	public void nextClick() {
		btNext.click();
	}

	public void createTemplate(String templateName){
		waitForElementToBeClickable(btnTempSave);
		btnTempSave.click();
		waitForElementVisible(dialogBox, 10000,500);
		Validator.assertTrue(dialogBox.isDisplayed(),"Dialog box is not visible","Dailog box is visible");
		waitForElementVisible(tbTempName,5000,1000);
		tbTempName.type(templateName,"templateName");
		waitForElementVisible(saveBtn,10000,1000);
		waitForElementToBeClickable(saveBtn);
		saveBtn.click();
	}

	public void selectCustomTemplate(String templateName) {
		waitForElementToDisplay(ddlTempDropdown);
		waitForElementToBeClickable(ddlTempDropdown);
		ddlTempDropdown.click();
		waitForElementVisible(driver.findElement(By.xpath("//li[@aria-label='" + templateName + "']")),10000,1000);
		waitForElementToBeClickable(driver.findElement(By.xpath("//li[@aria-label='" + templateName + "']")));
		driver.findElement(By.xpath("//li[@aria-label='" + templateName + "']")).click();
	}
	public void verifyCustomTemplate(String templateName) {
		waitForElementToDisplay(ddlTempDropdown);
		waitForElementToBeClickable(ddlTempDropdown);
		ddlTempDropdown.click();
		waitForElementVisible(driver.findElement(By.xpath("//li[@aria-label='"+templateName+"'][@aria-selected='true']")), 5000, 500);
		Validator.assertTrue(driver.findElement(By.xpath("//li[@aria-label='"+templateName+"'][@aria-selected='true']")).isDisplayed(),"Template is not selected","Template is selected");
	}

	public void editTemplate(){
		btnTempEdit.click();
	}

	public void editPermission(String add, String edit, String delete, String view, String download) {
		if(!(cbAllcheckboxAdd.getAttribute("aria-checked").equals(add)))
			cbAllcheckboxAdd.click();
		if(!(cbAllcheckboxEdit.getAttribute("aria-checked").equals(edit)))
			cbAllcheckboxEdit.click();
		if(!(cbAllcheckboxDelete.getAttribute("aria-checked").equals(delete)))
			cbAllcheckboxDelete.click();
		if(!(cbAllcheckboxView.getAttribute("aria-checked").equals(view)))
			cbAllcheckboxView.click();
		if(!(cbAllcheckboxDownload.getAttribute("aria-checked").equals(download)))
			cbAllcheckboxDownload.click();
	}

	public void deleteTemplate(){
		btnTempDelete.click();
		waitForElementVisible(dialogBoxDelete,5000,500);
		btnYes.click();
	}
	public void verifyCreateTemplate(){
		waitForPageLoad(3000);
		SyncUtil.waitFor(3000);
		waitForElementVisible(altCreatedTemp,30000,1000);
		waitForElementToDisplay(altCreatedTemp);
		Validator.assertTrue(altCreatedTemp.isDisplayed(),"Create alert is not displayed","Create alert is displayed");
	}

	public void verifyDeleteTemplate(){
		waitForPageLoad(5000);
		SyncUtil.waitFor(3000);
		waitForElementVisible(altDeletedTemp,30000,1000);
		waitForElementToDisplay(altDeletedTemp);
		Validator.assertTrue(altDeletedTemp.isDisplayed(),"Delete alert is not displayed","Delete alert is displayed");
	}
	public void verifyUpdateTemplate(){
		waitForPageLoad(5000);
//		SyncUtil.waitFor(3000);
		waitForElementVisible(altUpdatedTemp,30000,1000);
		waitForElementToDisplay(altUpdatedTemp);
		Validator.assertTrue(altUpdatedTemp.isDisplayed(),"Create alert is not displayed","Create alert is displayed");
	}

	public void verifyAscOrder(){
		List<String> extraxtedList = driver.findElements(By.xpath("//p-chip//div")).stream().map(x->x.getText()).collect(Collectors.toList());
		String regex = "\\b(?<!\\d)([a-zA-Z]+(\\s+[a-zA-Z]+)*)\\b";
		List<String> textList = findMatches(regex, extraxtedList);
		boolean isAscending = IntStream.range(0, textList.size() - 1)
				.allMatch(i -> textList.get(i).compareTo(textList.get(i + 1)) <= 0);
		Validator.assertTrue(isAscending,"List Ascending Order Mismatch","List is in Ascending Order");
	}

	public void verifyNumberOfSites(String noOfMasterSites){
		String noOfUserSites=MiscUtils.regexExtractor(paginationEntry.getText(),"(\\d+)(?!.*\\d)");
		Assert.assertEquals(noOfMasterSites,noOfUserSites,"Number of sites matched");
	}

	public void clickOnPreviousBtn() {
		btnPrevious.click();
	}

	public void validateInfoPage(){
		waitForPageLoad(5000);
		waitForElementVisible(tbFullName,5000,1000);
		waitForElementVisible(tbEmail,5000,1000);
		waitForElementVisible(tbPhone,5000,1000);
		Validator.assertTrue(txtPersonalInfo.isDisplayed(),"Info Page yet to load","Info page loaded");
	};

	public void validateEditCorpInfo(String corpName){
	waitForElementVisible(ddlCorportaedropdown,5000,1000);
	waitForElementToBeClickable(ddlCorportaedropdown);
	ddlCorportaedropdown.click();
	waitForElementVisible(driver.findElement(By.xpath("//li[@aria-label='"+corpName+"'][@aria-selected='true']")), 5000, 500);
	Validator.assertTrue(driver.findElement(By.xpath("//li[@aria-label='"+corpName+"'][@aria-selected='true']")).isDisplayed(),"Corporate is not selected","Corporate is selected");
	};

	public void goToEditUserPageWithActions(String userName) {
		Reporter.log("Image :="+btImg.isDisplayed());
		Reporter.log("Name :="+btName.getText());
		Validator.assertTrue(btName.getText().equalsIgnoreCase(userName),"User search result did not match", "User search result verification successful");
		Reporter.log("Profile :="+btProfile.getText());
		waitForElementToBeClickable(cbTablecheckbox);
		cbTablecheckbox.click();
		waitForElementToBeClickable(ddlUserActions);
		ddlUserActions.click();
		waitForElementToDisplay(btEdit);
		waitForElementToBeClickable(btEdit);
		btEdit.click();
		waitForPageLoad(5000);
	}

	public void assignPageclick() {
		waitForElementToBeClickable(btAssign);
		btAssign.click();
	}
	public void verifyProfileDropDownInBulkUpload() {
	waitForElementVisible(btDropDown,5000,1000);
    Validator.assertTrue(btDropDown.isVisible(),"DropDown is not visible","DropDown is visible");
	}

	public void clickContinentalUserAndVerifyLabel() {
		waitForElementToBeClickable(btDropDown);
		btDropDown.click();
		waitForElementVisible(rdbSelectprofiletypeStandardContinentalUser,5000,1000);
		Validator.assertTrue(rdbSelectprofiletypeStandardContinentalUser.isVisible(),"Standard Continental User is not visible","Standard Continental User is visible");
		rdbSelectprofiletypeStandardContinentalUser.click();
		waitForElementVisible(btDropDown,5000,1000);
		Validator.assertTrue(btDropDownInput.getText().contains("Standard continental user"),"Standard Continental User is not present as dropdown label","Standard Continental User is present as dropdown label");
	}

	public void verifyAnalysisBar(){
		waitForPageLoad(5000);
		waitForElementVisible(analysingUsers,15000,1000);
		Validator.assertTrue(analysingUsers.isDisplayed(),"Analysis Bar is not displayed","Analysis Bar is displayed");
	}
	public void verifyUserUploadBackBtnFunctionality(){
		waitForPageLoad(5000);
		waitForElementVisible(backBtn,10000,1000);
		Validator.assertTrue(backBtn.isDisplayed(),"Back Button is not displayed","Back Button is displayed");
		backBtn.click();
		waitForPageLoad(5000);
		waitForElementVisible(importFormHeader,5000,1000);
		Validator.assertTrue(importFormHeader.isDisplayed(),"Import Form is not displayed","Import Form is displayed");

	}
	public void selectUpdateBtnInImportReportPage(){
		waitForPageLoad(5000);
		waitForElementVisible(rdbtnUpdate,5000,1000);
		rdbtnUpdate.click();
		Validator.assertTrue(rdbtnUpdate.isDisplayed(),"Update is not selected","Update is selected");
	}
	public void verifyContinueBtnInImportPage(){
		waitForElementVisible(continueBtn,5000,1000);
		continueBtn.click();
		waitForPageLoad(5000);
		waitForElementVisible(txtAnalysisResult,5000,1000);
		Validator.assertTrue(txtAnalysisResult.isDisplayed(),"Analysis Result is not selected","Analysis Result is selected");
	}
	public void verifyImportAnalysisPageData(){
		Validator.assertTrue(txtTotalUsers.isDisplayed(),"Total Users is not selected","Total Users is selected");
		Validator.assertTrue(txtUsersToCreate.isDisplayed(),"Users To Create is not selected","Users To Create is selected");
		Validator.assertTrue(txtUsersToUpdate.isDisplayed(),"Users to Update is not selected","Users to Update is selected");
		Validator.assertTrue(txtUsersToSkip.isDisplayed(),"Users to Skip is not selected","Users to Skip is selected");
		Validator.assertTrue(txtWarnings.isDisplayed(),"Warnings is not selected","Warnings is selected");
		Validator.assertTrue(txtErrors.isDisplayed(),"Errors is not selected","Errors is selected");
	}

	public void verifyUserUploadBackBtnInAnalysisPage(){
		waitForPageLoad(5000);
		waitForElementVisible(backBtn,10000,1000);
		Validator.assertTrue(backBtn.isDisplayed(),"Back Button is not displayed","Back Button is displayed");
		backBtn.click();
		waitForPageLoad(5000);
		waitForElementVisible(importReportHeader,5000,1000);
		Validator.assertTrue(importReportHeader.isDisplayed(),"Bulk Import is not displayed","Bulk Import is displayed");
	}
	public void clickDeleteAndVerifyRemoval(){
		waitForElementVisible(deleteFile,5000,1000);
		deleteFile.click();
		Validator.assertTrue(txtDropFile.isDisplayed(),"File is not deleted","File is deleted");
	}
	public void clickImportAndVerifyToastMsg(){
		waitForElementVisible(importBtn,5000,1000);
		importBtn.click();
		waitForElementVisible(altSuccessUserCreation,5000,1000);
		Validator.assertTrue(altSuccessUserCreation.isDisplayed(),"Unable to Import ","Import successful");
	}
	public void verifyUserCreationInListPage(String user){
		waitForPageLoad(5000);
		waitForElementVisible(usersHeader,5000,1000);
		Validator.assertTrue(searchUser(user),"User is not found","User was import Succesfully");
	}

	public boolean userWrongFileUpload(String fileName) {
		String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "excel_data").getAbsolutePath();
		fileUpload.sendKeys(file_path, "File Path");
		deleteFile.assertVisible("Delete File upload");
		return uploadFailure.isVisible();
	}
}
