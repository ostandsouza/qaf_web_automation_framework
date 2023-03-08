package com.web.pages;




import org.openqa.selenium.WebElement;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import com.qmetry.qaf.automation.util.Reporter;

public class UsersPage extends BasePage{

	public QAFWebDriver driver;



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

	@FindBy(locator = "xpath=//div[@aria-label='APAC']//button")
	public CustomElement cbCheckboxAPAC;

	@FindBy(locator = "xpath=//span[text()='Australia']")
	public CustomElement cbCheckboxAustralia;

	@FindBy(locator = "xpath=//i[contains(@class,'pi-spinner')]")
	public CustomElement cbSpinner;
	@FindBy(locator = "xpath=//th[contains(text(),'Add')]/p-tristatecheckbox")
	public CustomElement cbAllcheckboxAdd;

	@FindBy(locator = "//th[contains(text(),'Edit')]/p-tristatecheckbox")
	public CustomElement cbAllcheckboxEdit;

	@FindBy(locator = "xpath=//th[contains(text(),'Delete')]/p-tristatecheckbox")
	public CustomElement cbAllcheckboxDelete;

	@FindBy(locator = "xpath=//th[contains(text(),'View')]/p-tristatecheckbox")
	public CustomElement cbAllcheckboxView;

	@FindBy(locator = "xpath=//th[contains(text(),'Download')]/p-tristatecheckbox")
	public CustomElement cbAllcheckboxDownload;
	
	@FindBy(locator = "xpath=//span[text()='Save and Close']")
	public CustomElement btSaveandClose;

	@FindBy(locator = "xpath=//span[text()='Admin']")
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
	
	@FindBy(locator="xpath=//p-multiselect[@formcontrolname='subscriptionType']")
	public CustomElement ddlSubscriptionType;

	@FindBy(locator="xpath=//div[text()=' Engineering ']")
	public CustomElement eleEngineering;
	
	@FindBy(locator="xpath=//div[text()=' Basics ']")
	public CustomElement eleBasics;
	
	@FindBy(locator="xpath=//tr[@class='p-selectable-row ng-star-inserted']//td//p-tablecheckbox")
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
	
	
	public void usersclick() {
		waitForElementVisible(lnkUsers, 10000,500);
		lnkUsers.click();
	}

	public void Addclick() {
		waitForElementToDisplay(btAdd);
		btAdd.click();
	}

	public void setfullname(String Fullname) {
		waitForElementVisible(tbFullName, 5000,500);
		tbFullName.type(Fullname, "Fullname");
	}
	
	public void setfullname1(String Fullname1) {
		tbFullName.type(Fullname1, "Fullname1");
	}

	public void setPhone(String Phone) {
		waitForElementVisible(tbPhone, 5000,500);
		tbPhone.type(Phone, "Phone");
	}

	public void setemail(String email) {
		tbEmail.type(email,"email");
		tbEmail.verifyText(email, "email");
	}
	
	

	public void setprofiletype(String profiletype) throws InterruptedException {

		ddlSelectprofiletype.click();

		WebElement listitem;

		if(profiletype.equals("Master"))
		{
			listitem=rdbSelectprofiletypeMaster;
		}
		else if(profiletype.equals("Market manager"))
		{
			listitem=rdbSelectprofiletypemarketmanager;
		}
		else if(profiletype.equals("Territory Manager"))
		{
			listitem=rdbSelectprofiletypeterritorymanager;
		}
		else if(profiletype.equals("Standard Continental User"))
		{
			listitem=rdbSelectprofiletypeStandardContinentalUser;
		}
		else if(profiletype.equals(" Distributor user "))
		{
			listitem=rdbSelectprofiletypeDistributorUser;
		}
		else if(profiletype.equals(" Customer user "))
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

	public void setpermission() {
		waitForPageLoad(5000);
		waitForElementVisible(eleArrowMT, 10000,500);
		eleCheckboxMT.click();
		cbCheckboxAPAC.click();
		cbCheckboxAustralia.click();
		//AllcheckboxDistributors.click();
	//	AllcheckboxCustomers.click();
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
	
	public void setpermissionsc() {
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
		btSaveandClose.click();
		SyncUtil.waitFor(10000);
		Reporter.log("User is created",MessageTypes.Pass);
	}

	
    public void clickonlogout() {
    
    	btprofile.click();
    	btlogout.click();
    	
    }

    public void Distributorinformation() {
    	dropdownselectsearch(ddlCorportaedropdown, tbCorporateSearch, "Sudheer India Distributor corporate");
    	ddlCorporateroledropdown.click();
    	rdbManager.click();
    	ddlSubscriptionType.click();
    	eleEngineering.click();
    	eleBasics.click();
    }
    
    public void Customerinformation() {
    	dropdownselectsearch(ddlCorportaedropdown, tbCorporateSearch, "sudheer custom corporate");
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


}
