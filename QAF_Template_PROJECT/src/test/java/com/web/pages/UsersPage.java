package com.web.pages;


import org.openqa.selenium.WebElement;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;

public class UsersPage extends BasePage{

	public QAFWebDriver driver;



	@FindBy(locator = "xpath=//span[text()='Users']")
	public CustomElement lUsers;

	@FindBy(locator = "xpath=//span[@class='p-button-icon ctp-icon-Add-circle']")
	public CustomElement btAdd;

	@FindBy(locator = "xpath=//input[@name='full_name']")
	public CustomElement tbFullName;

	@FindBy(locator = "xpath=//input[@type='phone']")
	public CustomElement tbPhone;

	@FindBy(locator = "xpath=//input[@name='email']")
	public CustomElement tbEmail;

	@FindBy(locator = "xpath=/html/body/app-root/app-layout/div/div[2]/div/app-user-add/div[2]/app-user-info/div/div[2]/form[1]/div/div[6]/div/div/p-dropdown/div/span")
	public CustomElement Selectprofiletype;

	@FindBy(locator = "xpath=//p-radiobutton[@ng-reflect-value='Master']")
	public CustomElement SelectprofiletypeMaster;

	@FindBy(locator = "xpath=//p-radiobutton[@ng-reflect-value='Market manager']")
	public CustomElement Selectprofiletypemarketmanager;

	@FindBy(locator = "xpath=//p-radiobutton[@ng-reflect-value='Territory Manager']")
	public CustomElement Selectprofiletypeterritorymanager;

	@FindBy(locator = "xpath=//p-radiobutton[@ng-reflect-value='Standard Continental User']")
	public CustomElement SelectprofiletypeStandardContinentalUser;

	@FindBy(locator = "xpath=(//input[@ng-reflect-ng-class='[object Object]'])[1]")
	public CustomElement tbuserPassword;

	@FindBy(locator = "xpath=(//input[@ng-reflect-ng-class='[object Object]'])[2]")
	public CustomElement tbRetypePassword;

	@FindBy(locator = "xpath=//span[text()='Generate password']")
	public CustomElement btGeneratePassword;

	@FindBy(locator = "xpath=//button[@class='btn-next p-button p-component ng-star-inserted']")
	public CustomElement btNext;

	@FindBy(locator = "xpath=(//span[@class='p-tree-toggler-icon pi pi-fw pi-chevron-right'])[1]")
	public CustomElement ArrowMT;

	@FindBy(locator = "xpath=(//div[@class='p-checkbox-box'])[3]")
	public CustomElement CheckboxAPAC;

	@FindBy(locator = "xpath=(//span[@class='p-tree-toggler-icon pi pi-fw pi-chevron-right'])[2]")
	public CustomElement ArrowDistributors;

	@FindBy(locator = "xpath=(//span[@class='p-tree-toggler-icon pi pi-fw pi-chevron-right'])[3]")
	public CustomElement ArrowCustomers;
	
	@FindBy(locator = "xpath=(//div[@class='p-checkbox-box'])[1]")
	public CustomElement AllcheckboxMarkets;

	@FindBy(locator = "xpath=(//div[@class='p-checkbox-box'])[3]")
	public CustomElement AllcheckboxDistributors;
	
	@FindBy(locator = "xpath=(//div[@class='p-checkbox-box'])[1]")
	public CustomElement AllcheckboxDistributors1;

	@FindBy(locator = "xpath=(//div[@class='p-checkbox-box'])[4]")
	public CustomElement AllcheckboxCustomers;
	
	@FindBy(locator = "xpath=(//div[@class='p-checkbox-box'])[1]")
	public CustomElement AllcheckboxCustomers1;

	@FindBy(locator = "xpath=(//div[@class='p-checkbox-box'])[1]")
	public CustomElement AllcheckboxAdd;

	@FindBy(locator = "xpath=(//div[@class='p-checkbox-box'])[1]")
	public CustomElement AllcheckboxEdit;

	@FindBy(locator = "xpath=(//div[@class='p-checkbox-box'])[1]")
	public CustomElement AllcheckboxDelete;

	@FindBy(locator = "xpath=(//div[@class='p-checkbox-box'])[1]")
	public CustomElement AllcheckboxView;
	
	@FindBy(locator = "xpath=(//div[@class='p-checkbox-box'])[4]")
	public CustomElement AllcheckboxView1;

	@FindBy(locator = "xpath=(//div[@class='p-checkbox-box'])[1]")
	public CustomElement AllcheckboxDownload;
	
	@FindBy(locator = "xpath=(//div[@class='p-checkbox-box'])[4]")
	public CustomElement AllcheckboxDownload1;

	@FindBy(locator = "xpath=//button[@class='p-ripple p-button p-component']")
	public CustomElement btSaveandClose;

	@FindBy(locator = "xpath=(//span[text()='Admin'])[1]")
	public CustomElement btprofile;

	@FindBy(locator = "xpath=//h6[text()='Logout']")
	public CustomElement btlogout;

	

	public void usersclick() {
		SyncUtil.waitFor(3000);
		lUsers.click();
	}

	public void Addclick() {
		SyncUtil.waitFor(5000);
		btAdd.click();
	}

	public void setfullname(String Fullname) {
		tbFullName.type(Fullname, "Fullnmae");
	}
	
	public void setfullname1(String Fullname1) {
		tbFullName.type(Fullname1, "Fullname1");
	}

	public void setPhone(String Phone) {
		tbPhone.type(Phone, "Phone");
	}

	public void setemail(String email) {
		tbEmail.type(email,"email");		
	}
	
	

	public void setprofiletype(String profiletype) throws InterruptedException {

		Selectprofiletype.click();

		WebElement listitem;
		Thread.sleep(3000);

		if(profiletype.equals("Master"))
		{
			listitem=SelectprofiletypeMaster;
		}
		else if(profiletype.equals("Market manager"))
		{
			listitem=Selectprofiletypemarketmanager;
		}
		else if(profiletype.equals("Territory Manager"))
		{
			listitem=Selectprofiletypeterritorymanager;
		}
		else if(profiletype.equals("Standard Continental User"))
		{
			listitem=SelectprofiletypeStandardContinentalUser;
		}
		else
			listitem=Selectprofiletype;

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
		SyncUtil.waitFor(10000);
		ArrowMT.click();
		SyncUtil.waitFor(3000);
		CheckboxAPAC.click();
		SyncUtil.waitFor(3000);
		AllcheckboxCustomers.click();
		SyncUtil.waitFor(3000);
		AllcheckboxDistributors.click();
		btNext.click();
		SyncUtil.waitFor(7000);
		AllcheckboxAdd.click();
		SyncUtil.waitFor(2000);
		AllcheckboxEdit.click();
		SyncUtil.waitFor(2000);
		AllcheckboxDelete.click();
		SyncUtil.waitFor(2000);
		AllcheckboxView.click();
		SyncUtil.waitFor(2000);
		AllcheckboxDownload.click();

	}
	
	public void setpermissionsc() {
		SyncUtil.waitFor(10000);
		ArrowMT.click();
		SyncUtil.waitFor(3000);
		CheckboxAPAC.click();
		SyncUtil.waitFor(3000);
		AllcheckboxCustomers.click();
		SyncUtil.waitFor(3000);
		AllcheckboxDistributors.click();
		btNext.click();
		SyncUtil.waitFor(7000);
		SyncUtil.waitFor(2000);
		AllcheckboxView1.click();
		SyncUtil.waitFor(2000);
		AllcheckboxDownload1.click();

	}
	
	public void setpermissionmm1() {
		SyncUtil.waitFor(10000);
		AllcheckboxMarkets.click();
		SyncUtil.waitFor(3000);
		AllcheckboxCustomers1.click();
		SyncUtil.waitFor(3000);
		AllcheckboxDistributors1.click();
		btNext.click();
		SyncUtil.waitFor(7000);
		AllcheckboxAdd.click();
		SyncUtil.waitFor(2000);
		AllcheckboxEdit.click();
		SyncUtil.waitFor(2000);
		AllcheckboxDelete.click();
		SyncUtil.waitFor(2000);
		AllcheckboxView.click();
		SyncUtil.waitFor(2000);
		AllcheckboxDownload.click();
	}

	public void Clicksaveandclose() {
		btSaveandClose.click();
		SyncUtil.waitFor(8000);
	}

	
    public void clickonlogout() {
    	SyncUtil.waitFor(3000);
    	btprofile.click();
    	btlogout.click();
    	
    }



}
