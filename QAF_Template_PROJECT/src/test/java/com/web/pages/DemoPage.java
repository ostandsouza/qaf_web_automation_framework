package com.web.pages;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.component.AddressComponent;
import com.web.component.DropDownListWithoutSearch;

public class DemoPage extends BasePage{
	

	
	@FindBy(locator = "xpath=(//a[@routerlinkactive='active-menuitem-routerlink'])[15]")
	public CustomElement lCorporates;
	
	@FindBy(locator = "xpath=(//a[@routerlinkactive='active-menuitem-routerlink'])[3]")
	public CustomElement lConveyors;
	
	@FindBy(locator = "xpath=//span[@class='p-button-icon ctp-icon-Add-circle']")
	public CustomElement btAdd;
	
	@FindBy(locator = "xpath=//input[@name='company_name']")
	public CustomElement tbCompanyName;
	
	@FindBy(locator = "xpath=(//div[@role='button'])[2]")
	public CustomElement drcountry;
	
	@FindBy(locator = "xpath=//button[@class='p-element p-button p-component ng-star-inserted']")
	public CustomElement btSaveandclose;
	
	@FindBy(locator = "xpath=(//div[@role='button'])[1]")
	public CustomElement drTypeofcompany;
	
	@FindBy(locator = "xpath=//div[text()=' Distributor Shop ']")
	public CustomElement radioDistribtorshop;

	@FindBy(locator = "xpath=(//div[@ng-reflect-ng-class='[object Object]'])[17]")
	public CustomElement radioCustomerCorportae;
	
	@FindBy(locator = "xpath=//div[text()=' Customer Site ']")
	public CustomElement radioCustomeSite;
	
	@FindBy(locator = "xpath=(//div[@role='button'])[3]")
	public CustomElement drDistributorcorporate;
	
	@FindBy(locator = "xpath=//span[text()='Belt Associates Corp']")
	public CustomElement drDistributorcorporatevalue;
	
	@FindBy(locator = "xpath=(.//button)[1]")
	public DropDownListWithoutSearch drTerritory;

	@FindBy(locator = "xpath=//p-autocomplete[@ng-reflect-name='territory']//span//button")
	public CustomElement drTerritorybutton;
	
	public String drTerritoryvalue = "xpath=//ul[contains(@class,'p-autocomplete-items')]//li//div//span";
	
	@FindBy(locator = "xpath=//p-autocomplete[@ng-reflect-name='territoryManager']//span//button")
	public CustomElement drTerritoryManagerbutton;
	
	public String drTerritoryManagervalue = "xpath=//ul[contains(@class,'p-autocomplete')]//li//div//span";
	
	
	@FindBy(locator = "xpath=//span[text()='Anna Mueller']")
	public DropDownListWithoutSearch drt;
	
	@FindBy(locator = "xpath=//input[@class='p-inputtext p-component p-element p-col-12 pac-target-input']")
	public CustomElement inAddress;
	
	@FindBy(locator = "xpath=//input[@class='p-inputtext p-component p-element p-col-12 pac-target-input p-filled']")
	public CustomElement inAddressfilled;
	
	@FindBy(locator = "xpath=//input[@id='autocomplete-address']")
	public AddressComponent tbAddress;
	
	@FindBy(locator = "xpath=//input[@id='firstname1']")
	public CustomElement tbConveyorname;
	
	@FindBy(locator= "xpath=//label[text()='Site']/following::span[1]")
	public CustomElement drSitedropdown;
	
	//public String drSitedropdownvalue = "xpath = //ul[contains(@class,'p-dropdown-items')]//li//span";
	public String drSitedropdownvalue = "xpath = //span";
	
	@FindBy(locator= "xpath=//input[contains(@class,'p-dropdown-filter')]")
	public CustomElement tbSitedropdown;
	
	@FindBy(locator= "xpath=//input[contains(@class,'p-dropdown-filter')]")
	public CustomElement tbAssociatedSitedropdown;
	
	@FindBy(locator= "xpath=//label[text()='Profile Conveyor']/following::div[6]")
	public CustomElement drprofileconveyordropdown;
	
	@FindBy(locator="xpath= //input[@class='p-dropdown-filter p-inputtext p-component ng-tns-c82-105']")
	public CustomElement tbinputsite;
	
	
	@FindBy(locator ="xpath = //li[@aria-label='Turnover unguided']")
	public CustomElement drProfileconveyorvalue;
	
	@FindBy(locator ="xpath =/html/body/app-root/app-layout/div/div[2]/div/app-add-conveyor/div/div[2]/div[2]/div/div[2]/div/button")
	public CustomElement btConveyorsaveandclose;
	
	@FindBy(locator="xpath=/html/body/app-root/app-layout/div/div[2]/div/app-add-conveyor/div/div[2]/div[2]/div/div[2]/div/button/span")
	public CustomElement btConsaveandclose;
	
	@FindBy(locator ="xpath = //p-autocomplete[@ng-reflect-name='territory']//span//button")
	public String btTerritorydown;
	
	@FindBy(locator ="xpath = //ul[@id='pr_id_21_list']//li//div//span")
	public String territorylist;

	@FindBy(locator="xpath=(//div[@role='button'])[2]")
	public CustomElement drCustomerCorporate;
	
	@FindBy(locator="xpath=//ul[contains(@class,'p-dropdown-items')]//li//span")
	public CustomElement drCustomerCorporatelist;
	
	@FindBy(locator ="xpath=(//div[@role='button'])[4]")
	public CustomElement drAssociatedCustomerCorporate;
	
	public String drAssociatedCustomerCorporatelist = "xpath = //ul[contains(@class,'p-dropdown-items')]//li//span";
	
	@FindBy(locator="xpath=(//div[@class='card-inner-wrapper'])[1]")
	public CustomElement btManagedSites;
	
	@FindBy(locator="xpath=//input[@class='p-inputtext p-component p-element']")
	public CustomElement btSearchinput;
	
	@FindBy(locator="xpath=//button[@icon='pi pi-eye']")
	public CustomElement btviewicon;

	 
	public void clickcorporates() {
		waitForPageLoad(4000);
		lCorporates.click();
	}
	
	public void createcorportae(String companyname, String Address) throws InterruptedException {
		waitForPageLoad(4000);
		btAdd.click();
		SyncUtil.waitFor(10000);
		tbCompanyName.type(companyname);		
	    tbAddress.selectAddress(Address);	    
     	/*String text;
		do
		{    
			inAddressfilled.sendKeys(Keys.ARROW_DOWN);
		    Thread.sleep(3000);
			text=inAddressfilled.getAttribute("value");
			if(text.equals("Paris Las Vegas, South Las Vegas Boulevard, Las Vegas, NV, USA"))
			{
				inAddressfilled.sendKeys(Keys.ENTER);
			break;
			}
			
		}while(!text.isEmpty());
		SyncUtil.waitFor(5000);*/
		btSaveandclose.click();		
		Reporter.log(companyname +"corporate is created" , MessageTypes.Pass);
	}
	
	public void createdistribtorshop(String companyname1, String Address1) {
	
		btAdd.click();
		waitForPageLoad(7000);
		drTypeofcompany.click();
		radioDistribtorshop.click();
		dropdownselectsearch(drDistributorcorporate, tbSitedropdown,"Belt Associates India 1");
		//drDistributorcorporate.click();
		//drDistributorcorporatevalue.click();
		tbCompanyName.sendKeys(companyname1);
		//waitForPageLoad(7000);
		dropdownselect(drTerritorybutton, drTerritoryvalue, "Spain");
		dropdownselect(drTerritoryManagerbutton, drTerritoryManagervalue, "Jhon Doe");
		tbAddress.selectAddress(Address1);
		btSaveandclose.click();		
		Reporter.log(companyname1 + "distributorshop is created" , MessageTypes.Pass);
	}
	
	public void createdistribtorshop2(String companyname2, String Address2) {
		
		btAdd.click();
		waitForPageLoad(7000);
		drTypeofcompany.click();
		radioDistribtorshop.click();
		dropdownselectsearch(drDistributorcorporate, tbSitedropdown,"Belt");
		//drDistributorcorporate.click();
		//drDistributorcorporatevalue.click();
		tbCompanyName.sendKeys(companyname2);
		//waitForPageLoad(7000);
		dropdownselect(drTerritorybutton, drTerritoryvalue, "Germany");
		dropdownselect(drTerritoryManagerbutton, drTerritoryManagervalue, "Jhon Doe");
		tbAddress.selectAddress(Address2);
		btSaveandclose.click();	
		Reporter.log(companyname2 + "distributorshop is created" , MessageTypes.Pass);
	}
	
	public void createcustomercorporate(String ccCompanyname, String ccAddress) throws InterruptedException {
		btAdd.click();
		waitForPageLoad(7000);
		drTypeofcompany.click();
		radioCustomerCorportae.click();
		tbCompanyName.sendKeys(ccCompanyname);
		tbAddress.selectAddress(ccAddress);	
		btSaveandclose.click();			
		Reporter.log(ccCompanyname +" customercorporate is created", MessageTypes.Pass);
	}
	
	public void createcustomersiteIndia(String csCompanyname, String csAddress) {
		btAdd.click();
		waitForPageLoad(7000);
		drTypeofcompany.click();
		radioCustomeSite.click();
		dropdownselectsearch(drCustomerCorporate, tbSitedropdown, "Mining Corp");
		dropdownselectsearch(drAssociatedCustomerCorporate, tbAssociatedSitedropdown, "Belt Associates Ind");
		tbCompanyName.type(csCompanyname);
		dropdownselect(drTerritorybutton, drTerritoryvalue, "Italy");
		dropdownselect(drTerritoryManagerbutton, drTerritoryManagervalue, "Anna Mueller");
		tbAddress.selectAddress(csAddress);	
		btSaveandclose.click();	
		Reporter.log(csCompanyname +" customersite is created", MessageTypes.Pass);
		
	}
	
	public void createcustomersiteGermany(String csGCompanyname, String csAGddress) {
		btAdd.click();
		waitForPageLoad(7000);
		drTypeofcompany.click();
		radioCustomeSite.click();
		dropdownselectsearch(drCustomerCorporate, tbSitedropdown, "Mining Corp");
		dropdownselectsearch(drAssociatedCustomerCorporate, tbAssociatedSitedropdown, "Belt Associates Ind");
		tbCompanyName.type(csGCompanyname);
		dropdownselect(drTerritorybutton, drTerritoryvalue, "Italy");
		dropdownselect(drTerritoryManagerbutton, drTerritoryManagervalue, "Axel Eckmann");
		tbAddress.selectAddress(csAGddress);	
		btSaveandclose.click();	
		Reporter.log(csGCompanyname +" customersite is created", MessageTypes.Pass);
	}
	
	public void createconveyorc1Germany(String conveyorname ) {
		lConveyors.click();
		btAdd.click();
	    tbConveyorname.type(conveyorname);
		waitForPageLoad(5000);
		dropdownselectsearch(drSitedropdown, tbSitedropdown, "name");
		SyncUtil.waitFor(10000);
		dropdownselectsearch(drprofileconveyordropdown, tbSitedropdown, "Turnover guided");
		btConsaveandclose.click();
		waitForPageLoad(7000);
		
	}
	
	public void createconveyorc1India(String conveyorname1 ) {
		lConveyors.click();
		btAdd.click();
	    tbConveyorname.type(conveyorname1);
		waitForPageLoad(5000);
		dropdownselectsearch(drSitedropdown, tbSitedropdown, "Minining corp Ind");
		waitForPageLoad(5000);
		dropdownselectsearch(drprofileconveyordropdown, tbSitedropdown, "Type gravity");
		
		btConsaveandclose.click();
		waitForPageLoad(7000);
	}
	
	public void showconveyorssitescorporatesandusers(String searchtext) throws Throwable {
		waitForPageLoad(7000);
		btManagedSites.click();
		btSearchinput.type(searchtext);
		waitForPageLoad(10000);
		btviewicon.click();
		scrollPageDown();
		
	}
	
	public void dropdownselect() {
		driver.findElement(By.xpath("//p-autocomplete[@ng-reflect-name='territory']//span//button")).click();
		
		List<WebElement> Options = driver.findElements(By.xpath("//ul[contains(@class,'p-autocomplete-items')]//li//div//span"));
	
		for(WebElement ele:Options) {
		 String value = ele.getAttribute("innerText");
		 System.out.println(value);
			if(	value.equalsIgnoreCase("Spain")) {
				ele.click();
				break;
			}
		}
	}
}
