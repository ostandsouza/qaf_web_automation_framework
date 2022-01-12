package com.web.pages;

import org.openqa.selenium.WebElement;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;

public class DemoPage extends BasePage{
	

	
	@FindBy(locator = "xpath=(//a[@routerlinkactive='active-menuitem-routerlink'])[15]")
	public CustomElement lCorporates;
	
	@FindBy(locator = "xpath=//span[@class='p-button-icon ctp-icon-Add-circle']")
	public CustomElement btAdd;
	
	@FindBy(locator = "xpath=//input[@name='company_name']")
	public CustomElement tbCompanyName;
	
	@FindBy(locator = "xpath=(//div[@role='button'])[2]")
	public CustomElement drcountry;
	
	@FindBy(locator = "xpath=//span[text()='India']")
	public CustomElement drcountryvalue;
	
	@FindBy(locator = "xpath=(//div[@role='button'])[3]")
	public CustomElement drstate;

	@FindBy(locator = "xpath=//span[text()='Karnataka']")
	public CustomElement drstatevalue;
	
	@FindBy(locator = "xpath=//input[@name='street']")
	public CustomElement tbStreet;
	
	@FindBy(locator = "xpath=//span[text()='Save and Close']")
	public CustomElement btSaveandclose;
	
	@FindBy(locator = "xpath=(//div[@role='button'])[1]")
	public CustomElement drTypeofcompany;
	
	@FindBy(locator = "xpath=(//div[@ng-reflect-ng-class='[object Object]'])[13]")
	public CustomElement radioDistribtorshop;
	
	@FindBy(locator = "xpath=(//button[@ng-reflect-icon='pi pi-chevron-down'])[2]")
	public CustomElement drDistributorcorporate;
	
	@FindBy(locator = "xpath=//span[text()='Belt Associates Corp']")
	public CustomElement selectDistributorcorporatebelt;
	
	
	public void clickcorporates() {
		SyncUtil.waitFor(5000);
		lCorporates.click();
	}
	
	public void createcorportae(String companyname) {
		SyncUtil.waitFor(2000);
		btAdd.click();
		tbCompanyName.sendKeys(companyname);
		drcountry.click();
		drcountryvalue.click();
		drstate.click();
		drstatevalue.click();
		tbStreet.sendKeys("1234");
		btSaveandclose.click();
	}
	
	public void createdistribtorshop(String companyname1) {
		SyncUtil.waitFor(2000);
		btAdd.click();
		drTypeofcompany.click();
		radioDistribtorshop.click();
		drDistributorcorporate.click();
		selectDistributorcorporatebelt.click();
		tbCompanyName.sendKeys(companyname1);
		
	}
}
