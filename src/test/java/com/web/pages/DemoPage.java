package com.web.pages;

import java.util.List;
import java.util.Optional;

import com.qmetry.qaf.automation.ui.annotations.UiElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.remote.RemoteWebDriver;
//import com.web.component.AddressComponent;
//import com.web.component.DropDownListWithoutSearch;

	public class DemoPage extends BasePage{
	

	@UiElement(
			fieldLoc= "xpath=//span[text()='Corporates']",
			viewLoc = "xpath=//span[text()='Corporates1']"
	)
	public CustomElement lCorporates1;

	@FindBy(locator = "xpath=//span[text()='Corporates']")
	public CustomElement lCorporates;
	
	@FindBy(locator = "xpath=//span[text()='Add Conveyor']")
	public CustomElement lConveyors;

	@FindBy(locator = "xpath=//span[@class='p-button-icon ctp-icon-Add-circle']")
	public CustomElement btAdd;

	@FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
	public CustomElement btAddCorp;
	
	@FindBy(locator = "xpath=//input[@name='company_name']")
	public CustomElement tbCompanyName;
	
	@FindBy(locator = "xpath=(//div[@role='button'])[2]")
	public CustomElement drcountry;
	
	@FindBy(locator = "xpath=//span[text()='Save and Close']")
	public CustomElement btSaveandclose;

	@FindBy(locator = "xpath=//span[@class='p-button-label']")
	public CustomElement btSaveandcloseCorp;

	@FindBy(locator = "xpath=//p-dropdown[@formcontrolname='companyType']/div/span[text()='Distributor Corporate']")
	public CustomElement drCompanyDropdownLoader;
	@FindBy(locator = "xpath=(//div[@role='button'])[1]")
	public CustomElement drTypeofcompany;
	
	@FindBy(locator = "xpath=//div[text()=' Distributor Shop ']")
	public CustomElement radioDistribtorshop;

	@FindBy(locator = "xpath=//li[@aria-label='Customer Corporate']")
	public CustomElement radioCustomerCorportae;
	
	@FindBy(locator = "xpath=//div[text()=' Customer Site ']")
	public CustomElement radioCustomeSite;
	
	@FindBy(locator = "xpath=(//div[@role='button'])[3]")
	public CustomElement drDistributorcorporate;
	
	@FindBy(locator = "xpath=//span[text()='Belt Associates Corp']")
	public CustomElement drDistributorcorporatevalue;
	
	@FindBy(locator = "xpath=(.//button)[1]")
	public CustomElement drTerritory;

	@FindBy(locator = "xpath=//label[text()='Territory ']/..//span[string-length(text()) > 0]")
	public CustomElement drTerritoryLoader;
	@FindBy(locator = "xpath=//p-dropdown[@datakey='territoryId']/div/div[2]")
	public CustomElement drTerritorybutton;

	@FindBy(locator = "xpath=//input[@aria-activedescendant='p-highlighted-option']")
	public CustomElement drTerritoryvalue;
	
	@FindBy(locator = "xpath=//p-autocomplete[@field='name']//input")
	public CustomElement drTerritoryManagerbutton;
	
	public String drTerritoryManagervalue = "xpath=//ul[contains(@class,'p-autocomplete')]//li//div//span";
	
	
	@FindBy(locator = "xpath=//span[text()='Anna Mueller']")
	public CustomElement drt;
	
	@FindBy(locator = "xpath=//input[@class='p-inputtext p-component p-element p-col-12 pac-target-input']")
	public CustomElement inAddress;
	
	@FindBy(locator = "xpath=//input[@class='p-inputtext p-component p-element p-col-12 pac-target-input p-filled']")
	public CustomElement inAddressfilled;
	
	@FindBy(locator = "xpath=//input[@id='autocomplete-address']")
	public CustomElement tbAddress;

	@FindBy(locator = "xpath=//div[contains(@class, 'pac-container')]/div[1]")
	public CustomElement tbMapFirstSearchOption;

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
	
	@FindBy(locator= "xpath=//p-dropdown[@datakey='companyId']/div/div[2]")
	public CustomElement drDistShopdropdown;
	
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
	
	@FindBy(locator="xpath=//input[@placeholder='Search']")
	public CustomElement btSearchinput;

	@FindBy(locator="xpath=(//button[@icon='pi pi-chevron-down'])[2]")
	public CustomElement btActions;

	@FindBy(locator="xpath=//span[text()='Edit']")
	public CustomElement btEdit;
	@FindBy(locator="xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
	public CustomElement btviewicon;

	@FindBy(locator="xpath=(//td//p-tablecheckbox)[1]")
	public CustomElement btCheckbox;

	@FindBy(locator="xpath=(//td//img)[1]")
	public CustomElement btImg;

	@FindBy(locator="xpath=(//td[3])[1]")
	public CustomElement btName;

	@FindBy(locator="xpath=(//td[4]/span)[1]")
	public CustomElement btType;

	@FindBy(locator="xpath=(//td[5]/span)[1]")
	public CustomElement btAddress;

	@FindBy(locator="xpath=(//td[6]/p-chip/div)[1]")
	public CustomElement btMarket1;

	@FindBy(locator="xpath=(//td[6]/p-chip/div/div)[1]")
	public CustomElement btMarket2;

	@FindBy(locator="xpath=//td[7]/div")
	public CustomElement btShopNumber;

	@FindBy(locator="xpath=(//app-card//span)[1]")
	public CustomElement btShopCardNo;

	@FindBy(locator="xpath=(//app-card//span)[2]")
	public CustomElement btConveyorCardNo;

	@FindBy(locator="xpath=(//app-card//span)[3]")
	public CustomElement btCOverWearCardNo;

	@FindBy(locator="xpath=(//app-card//span)[4]")
	public CustomElement btInspectionCardNo;

	@FindBy(locator="xpath=(//app-card//span)[5]")
	public CustomElement btConveyorInspectCardNo;

	@FindBy(locator="xpath=(//td//img)[1]")
	public CustomElement shopImg;

	@FindBy(locator="xpath=(//td[4])[1]")
	public CustomElement shopName;

	@FindBy(locator="xpath=(//td[5]/span)[1]")
	public CustomElement shopCorp;

	@FindBy(locator="xpath=(//td[6])[1]")
	public CustomElement shopAddress;

	@FindBy(locator="xpath=(//td[7])[1]")
	public CustomElement shopTerritory;

	@FindBy(locator="xpath=(//td[8])[1]")
	public CustomElement shopManager;

	@FindBy(locator="xpath=(//td[9]/div)[1]")
	public CustomElement shopSiteNumber;

	@FindBy(locator="xpath=(//td[9])[1]")
	public CustomElement siteDistributor;

	@FindBy(locator="xpath=(//td[10]/div)[1]")
	public CustomElement shopConveyorNumber;

	@FindBy(locator="xpath=(//td[11]/button)[1]")
	public CustomElement shopMoreButton;

	@FindBy(locator="xpath=(//td//img)[1]")
	public CustomElement conveyorImg;

	@FindBy(locator="xpath=(//td[4])[1]")
	public CustomElement conveyorName;

	@FindBy(locator="xpath=(//td[5])[1]")
	public CustomElement conveyorSite;

	@FindBy(locator="xpath=//app-image-upload[@class='profile-image']")
	public CustomElement profileIcon;

	@FindBy(locator="xpath=//i[@class='pi pi-user']/following-sibling::h6")
	public CustomElement profileOption;

	@FindBy(locator="xpath=//i[@class='pi pi-power-off']/following-sibling::h6")
	public CustomElement logoutOption;

	@FindBy(locator="xpath=//div[text()=' User information ']")
	public CustomElement userInfo;

	@FindBy(locator="xpath=(//div[contains(@class,'p-panel-header')]/span)[1]")
	public CustomElement conveyorTitle;

	@FindBy(locator="xpath=//button[@icon='pi pi-pencil']//span[2]")
	public CustomElement editConveyor;

	@FindBy(locator = "xpath=//span[text()='Update']")
	public CustomElement btyUpdate;

	@FindBy(locator = "xpath=//div[text()='Conveyor Updated Successfully.']")
	public CustomElement crUpdateMsg;

	@FindBy(locator="xpath=(//td[4])[1]")
	public CustomElement crName;

	@FindBy(locator="xpath=(//td[5])[1]")
	public CustomElement crSite;

	@FindBy(locator = "xpath=//span[@class='p-menuitem-text ng-star-inserted'][text()='Home']")
	public CustomElement breakcrumHome;

	@FindBy(locator = "xpath=(//span[@class='p-button-icon pi pi-refresh'])[2]")
	public CustomElement btRefresh;


		public void clickcorporates() {
		waitForPageLoad(4000);
		waitForElementVisible(lCorporates, 10000,500);
		lCorporates.click();
		waitForPageLoad(4000);
		SyncUtil.waitFor(2000);
	}

		public void goToCorporate() {
			scrollPageup();
			waitForPageLoad(4000);
			waitForElementToDisplay(btAddCorp);
			btAddCorp.click();
		}
	
	public void createcorporate(String companyname, String Address) {
		scrollPageup();
		waitForPageLoad(4000);
		waitForElementToDisplay(btAddCorp);
		btAddCorp.click();
		waitForElementToDisplay(drCompanyDropdownLoader);
		tbCompanyName.type(companyname);
		tbAddress.type(Address);
		waitForElementToDisplay(tbMapFirstSearchOption);
		tbMapFirstSearchOption.click();
		scrollPageDown();
		btSaveandclose.click();
		Reporter.log(companyname +"corporate is created" , MessageTypes.Pass);
	}
	
	public void createdistribtorshop(String companyname1, String Address1, String distCorp, String territory, String manager) {
		scrollPageup();
		waitForElementVisible(btAddCorp, 10000,500);
		btAddCorp.click();
//		SyncUtil.waitFor(1000);
		waitForElementToDisplay(drCompanyDropdownLoader);
		scrollPageup();
		waitForPageLoad(4000);
		drTypeofcompany.click();
		radioDistribtorshop.click();
		dropdownselectsearch(drDistributorcorporate, tbSitedropdown,distCorp);
		//drDistributorcorporate.click();
		//drDistributorcorporatevalue.click();
		tbCompanyName.sendKeys(companyname1);
		//waitForPageLoad(7000);
		waitForElementToDisplay(drTerritoryLoader);
		dropdownselectsearch(drTerritorybutton, drTerritoryvalue, territory);
		drTerritoryManagerbutton.type(manager);
		tbAddress.type(Address1);
		waitForElementToDisplay(tbMapFirstSearchOption);
		tbAddress.click();
		tbMapFirstSearchOption.click();
		scrollPageDown();
		btSaveandclose.click();
		Reporter.log(companyname1 + "distributorshop is created" , MessageTypes.Pass);
	}
	
	public void createdistribtorshop2(String companyname2, String Address2, String DistCorpName, String DistCorpGerTerritory, String manager) {
		scrollPageup();
		waitForElementVisible(btAddCorp, 10000,500);
		btAddCorp.click();
		waitForElementToDisplay(drCompanyDropdownLoader);
		scrollPageup();
		waitForPageLoad(4000);
		drTypeofcompany.click();
		radioDistribtorshop.click();
		dropdownselectsearch(drDistributorcorporate, tbSitedropdown,DistCorpName);
		//drDistributorcorporate.click();
		//drDistributorcorporatevalue.click();
		tbCompanyName.sendKeys(companyname2);
		//waitForPageLoad(7000);
		waitForElementToDisplay(drTerritoryLoader);
		dropdownselectsearch(drTerritorybutton, drTerritoryvalue, DistCorpGerTerritory);
		drTerritoryManagerbutton.type(manager);
		tbAddress.type(Address2);
		waitForElementToDisplay(tbMapFirstSearchOption);
		tbAddress.click();
		tbMapFirstSearchOption.click();
		scrollPageDown();
		btSaveandclose.click();	
		Reporter.log(companyname2 + "distributorshop is created" , MessageTypes.Pass);
	}
	
	public void createcustomercorporate(String ccCompanyname, String ccAddress) {
		scrollPageup();
		waitForElementVisible(btAddCorp, 10000,500);
		btAddCorp.click();
		waitForElementToDisplay(drCompanyDropdownLoader);
		scrollPageup();
		waitForPageLoad(4000);
		drTypeofcompany.click();
		radioCustomerCorportae.click();
		tbCompanyName.sendKeys(ccCompanyname);
		tbAddress.type(ccAddress);
		waitForElementToDisplay(tbMapFirstSearchOption);
		tbAddress.click();
		tbMapFirstSearchOption.click();
		scrollPageDown();
		btSaveandclose.click();			
		Reporter.log(ccCompanyname +" customercorporate is created", MessageTypes.Pass);
	}
	
	public void createcustomersiteIndia(String csCompanyname, String csAddress, String CustCorpName, String DistShopIndName, String DistCorpIndTerritory, String manager) {
		scrollPageup();
		waitForElementVisible(btAddCorp, 10000,500);
		btAddCorp.click();
		waitForElementToDisplay(drCompanyDropdownLoader);
		scrollPageup();
		waitForPageLoad(4000);
		drTypeofcompany.click();
		radioCustomeSite.click();
		dropdownselectsearch(drCustomerCorporate, tbSitedropdown, CustCorpName);
		dropdownselectsearch(drAssociatedCustomerCorporate, tbAssociatedSitedropdown, DistShopIndName);
		tbCompanyName.type(csCompanyname);
		waitForElementToDisplay(drTerritoryLoader);
		dropdownselectsearch(drTerritorybutton, drTerritoryvalue, DistCorpIndTerritory);
		drTerritoryManagerbutton.type(manager);
		tbAddress.type(csAddress);
		waitForElementToDisplay(tbMapFirstSearchOption);
		tbAddress.click();
		SyncUtil.waitFor(1000);
		waitForElementToDisplay(tbMapFirstSearchOption);
		tbMapFirstSearchOption.click();
		scrollPageDown();
		btSaveandclose.click();	
		Reporter.log(csCompanyname +" customersite is created", MessageTypes.Pass);
		
	}
	
	public void createcustomersiteGermany(String csGCompanyname, String csAGddress,String CustCorpName, String DistShopGerName, String DistShopTerritory, String manager) {
		scrollPageup();
		waitForElementVisible(btAddCorp, 10000,500);
		btAddCorp.click();
		waitForElementToDisplay(drCompanyDropdownLoader);
		scrollPageup();
		waitForPageLoad(4000);
		drTypeofcompany.click();
		radioCustomeSite.click();
		dropdownselectsearch(drCustomerCorporate, tbSitedropdown, CustCorpName);
		dropdownselectsearch(drAssociatedCustomerCorporate, tbAssociatedSitedropdown, DistShopGerName);
		tbCompanyName.type(csGCompanyname);
		waitForElementToDisplay(drTerritoryLoader);
		dropdownselectsearch(drTerritorybutton, drTerritoryvalue, DistShopTerritory);
		drTerritoryManagerbutton.type(manager);
		tbAddress.type(csAGddress);
		waitForElementToDisplay(tbMapFirstSearchOption);
		tbAddress.click();
		SyncUtil.waitFor(1000);
		waitForElementToDisplay(tbMapFirstSearchOption);
		tbMapFirstSearchOption.click();
		scrollPageDown();
		btSaveandclose.click();	
		Reporter.log(csGCompanyname +" customersite is created", MessageTypes.Pass);
	}
	
	public void createConveyorGermany(String conveyorname, String DistShopGerName, String CustShopGerName) {
		lConveyors.click();
		waitForPageLoad(7000);
		waitForElementVisible(tbConveyorname, 10000,500);
//		btAdd.click();
	    tbConveyorname.type(conveyorname);
		waitForElementVisible(drSitedropdown, 10000,500);
		dropdownselectsearch(drSitedropdown, tbSitedropdown, CustShopGerName);
		waitForElementVisible(drDistShopdropdown, 10000,500);
		dropdownselectsearch(drDistShopdropdown, tbSitedropdown, DistShopGerName);
		btSaveandclose.click();
		
	}

	public void checkConveyorGermany(String conveyorName, String custCorpName) {
		scrollPageup();
		breakcrumHome.click();
		waitForElementVisible(btSearchinput, 10000,500);
		btRefresh.click();
		btSearchinput.type(conveyorName);
		waitForPageLoad(10000);
		Reporter.log("Image :="+btImg.isDisplayed());
		Reporter.log("Name :="+crName.getText());
		Reporter.log("Site :="+crSite.getText());
	}

	public void editConveyorGermany(String oldConveyorName, String newConveyorName) {
		SyncUtil.waitFor(10000);
		waitForElementVisible(btRefresh, 10000,500);
		btRefresh.click();
		btSearchinput.type(oldConveyorName);
		waitForPageLoad(10000);
//		SyncUtil.waitFor(7000);
		Reporter.log("Image :="+btImg.isDisplayed());
		Reporter.log("Name :="+crName.getText());
		Reporter.log("Site :="+crSite.getText());
		btCheckbox.click();
		btActions.click();
		waitForElementVisible(btEdit, 10000,500);
		btEdit.click();
//		btviewicon.click();
//		SyncUtil.waitFor(15000);
//		waitForElementVisible(conveyorTitle, 10000,500);
//		Reporter.log("title :="+conveyorTitle.getText());
//		editConveyor.click();
		waitForElementToDisplay(tbConveyorname);
		tbConveyorname.type(newConveyorName);
		btyUpdate.click();
		waitForElementToDisplay(crUpdateMsg);
		Reporter.log("Toast :="+crUpdateMsg.isDisplayed());
	}
	
	public void createconveyorc1India(String conveyorname1, String DistShopIndName, String CustShopIndName) {
//		waitForElementVisible(btAddCorp, 10000,500);
		if(btAddCorp.isVisible())
			btAddCorp.click();
		else lConveyors.click();
		waitForPageLoad(7000);
		waitForElementVisible(tbConveyorname, 10000,500);
	    tbConveyorname.type(conveyorname1);
		waitForElementVisible(drSitedropdown, 10000,500);
		SyncUtil.waitFor(1000);
		dropdownselectsearch(drSitedropdown, tbSitedropdown, CustShopIndName);
		waitForElementVisible(drDistShopdropdown, 10000,500);
		SyncUtil.waitFor(1000);
		dropdownselectsearch(drDistShopdropdown, tbSitedropdown, DistShopIndName);

		btSaveandclose.click();
	}
	
	public void showconveyorssitescorporatesandusers(String searchtext, String DistCorpAddress){
		SyncUtil.waitFor(5000);
		waitForPageLoad(7000);
		lCorporates.click();
		SyncUtil.waitFor(50000);
		waitForElementVisible(btSearchinput, 10000,500);
		btSearchinput.type(searchtext);
		waitForPageLoad(10000);
		SyncUtil.waitFor(7000);
		Reporter.log("Image :="+btImg.isDisplayed());
		Reporter.log("Name :="+btName.getText());
		Reporter.log("Type :="+btType.getText());
		Reporter.log("Address :="+btAddress.getText());
		Reporter.log("Market :="+(btMarket2.isVisible()?btMarket2.getText():btMarket1.getText()));
		Reporter.log("Shop :="+btShopNumber.getText());
		btviewicon.click();
		SyncUtil.waitFor(5000);
		waitForElementToDisplay(btShopCardNo);
		Reporter.log("Shop :="+btShopCardNo.getText());
		waitForElementToDisplay(btConveyorCardNo);
		Reporter.log("Conveyor :="+btConveyorCardNo.getText());
		waitForElementToDisplay(btCOverWearCardNo);
		Reporter.log("Coverwear :="+btCOverWearCardNo.getText());
		waitForElementToDisplay(btInspectionCardNo);
		Reporter.log("Inspections :="+btInspectionCardNo.getText());
		scrollPageDown();
		waitForPageLoad(7000);
		waitForElementToDisplay(shopImg);
		Reporter.log("Shop img :="+shopImg.isDisplayed());
		waitForElementToDisplay(shopName);
		Reporter.log("site name :="+shopName.getText());
		Reporter.log("site img :="+shopCorp.getText());
		Reporter.log("site add :="+shopAddress.getText());
		Reporter.log("site territory :="+shopTerritory.getText());
		Reporter.log("site manager :="+shopManager.getText());
		Reporter.log("site distributor :="+siteDistributor.getText());
		Reporter.log("site conveyor count :="+shopConveyorNumber.getText());
		Reporter.log("site button :="+shopMoreButton.isDisplayed());
		scrollPageup();
		btConveyorCardNo.click();
		Reporter.log("conveyor image :="+conveyorImg.isDisplayed());
		Reporter.log("conveyor name :="+conveyorName.getText());
		Reporter.log("conveyor site :="+conveyorSite.getText());
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

	public boolean goToUserProfile() {
		waitForElementVisible(profileIcon, 15000,500);
		waitForPageLoad(4000);
		profileIcon.click();
		profileOption.click();
		return userInfo.isDisplayed();
	}

	public LoginPage logoutUser() {
		waitForElementVisible(profileIcon, 15000,500);
		waitForPageLoad(4000);
		profileIcon.click();
		logoutOption.click();
		return new LoginPage();
	}

	public void deleteConveyor() {
		waitForElementVisible(profileIcon, 15000,500);
		waitForPageLoad(4000);
		profileIcon.click();
		logoutOption.click();
	}

	public void deleteCustomerSie() {
		waitForElementVisible(profileIcon, 15000,500);
		waitForPageLoad(4000);
		profileIcon.click();
		logoutOption.click();
	}

	public void deleteDistributorShop() {
		waitForElementVisible(profileIcon, 15000,500);
		waitForPageLoad(4000);
		profileIcon.click();
		logoutOption.click();
	}

	public void deleteCustomerCorp() {
		waitForElementVisible(profileIcon, 15000,500);
		waitForPageLoad(4000);
		profileIcon.click();
		logoutOption.click();
	}

	public void deleteDistributorCorp() {
		waitForElementVisible(profileIcon, 15000,500);
		waitForPageLoad(4000);
		profileIcon.click();
		logoutOption.click();
	}

	public void deleteUser() {
		waitForElementVisible(profileIcon, 15000,500);
		waitForPageLoad(4000);
		profileIcon.click();
		logoutOption.click();
	}
}
