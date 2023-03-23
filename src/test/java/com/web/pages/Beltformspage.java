package com.web.pages;

import static org.testng.Assert.assertEquals;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;

public class Beltformspage extends BasePage{

	@FindBy(locator = "xpath=//span[text()='Belt Info']")
	public CustomElement lnkBeltinfo;
	
	@FindBy(locator = "xpath=//span[text()='Textile']")
	public CustomElement lnkTextile;
	
	@FindBy(locator = "xpath=//span[text()='Steel']")
	public CustomElement lnkSteel;
	
	@FindBy(locator = "xpath=//label[text()='Market ']/parent::div//div[@role='button']")
	public CustomElement ddlMarket;
	
	@FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter p-inputtext')]")
	public CustomElement tbinput;
	
	@FindBy(locator = "xpath=//label[text()='Std. Requested by Customer ']/parent::div//div[@role='button']")
	public CustomElement ddlStdRequestedbyCustomer;
	
	@FindBy(locator = "xpath=//label[text()='Belt Construction ']/parent::div//div[@role='button']")
	public CustomElement ddlBeltConstruction;
	
	@FindBy(locator = "xpath=//label[text()='Carcass Construction ']/parent::div//div[@role='button']")
	public CustomElement ddlCarcassConstruction;
	
	@FindBy(locator = "xpath=//label[text()='Top Cover Compound ']/parent::div//div[@role='button']")
	public CustomElement ddlTopCoverCompound;
	
	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='topCoverGauge']//div[@role='button']")
	public CustomElement ddlTopCoverGauge;
	
	@FindBy(locator = "xpath=//label[text()='Bottom Cover Compound ']/parent::div//div[@role='button']")
	public CustomElement ddlBottomCoverCompound;
	
	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='bottomCoverGauge']//div[@role='button']")
	public CustomElement ddlBottomCoverGauge;
	
	@FindBy(locator = "xpath=//input[contains(@class,'p-inputtext p-component p-element ng-st')]")
	public CustomElement tbBeltlength;
	
	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='width']//div[@role='button']")
	public CustomElement ddlBeltwidth;
	
	@FindBy(locator = "xpath=//label[text()='Edge ']/parent::div//div[@role='button' and contains(@class,'p-dropdown-trigger')]")
	public CustomElement ddlEdge;
	
	@FindBy(locator = "xpath=//label[text()='Breaker ']/parent::div//div[@role='button']")
	public CustomElement ddlBreaker;
	
	public String breakeritems = "xpath=//ul[@role='listbox']";
	
	@FindBy(locator = "xpath=//label[text()='Select Location Address ']/parent::div//div[@role='button']")
	public CustomElement ddlSelectLocationAddress;
	
	@FindBy(locator = "xpath=//label[text()='Overwrite Belt Thickness ? ']/parent::div//input")
	public CustomElement tbOverallbeltthickness;
	
	@FindBy(locator = "xpath=//p-radiobutton[@ng-reflect-label='Metric']//div[@class='p-radiobutton-box p-highlight']")
	public CustomElement rdbMetric;
	
	@FindBy(locator = "xpath=//p-radiobutton[@ng-reflect-label='Imperial']//div[@class='p-radiobutton-box']")
	public CustomElement rdbImperial;
	
	@FindBy(locator = "xpath=//textarea[contains(@class,'p-inputtextarea p-inputtext')]")
	public CustomElement textareaComment;
	
	@FindBy(locator = "xpath=//button[@label='Calculate']")
	public CustomElement btnCalculate;
	
	@FindBy(locator = "xpath=//button[@type='button' and contains(@label,'Generate')]")
	public CustomElement btnGeneratePDF;
	
	public void SelectTextile() {
		lnkBeltinfo.click();
		lnkTextile.click();
		Reporter.log("Textile link is clicked", MessageTypes.Pass);
	}
	
	public void Input() {
		dropdownselectsearch(ddlMarket, tbinput, "APAC");
		dropdownselectsearch(ddlStdRequestedbyCustomer, tbinput, "INDIA");
		dropdownselectsearch(ddlBeltConstruction, tbinput, "ContiTitan");
		dropdownselectsearch(ddlCarcassConstruction, tbinput, "2000/2");
		dropdownselectsearch(ddlTopCoverCompound, tbinput, "SHIELD KG");
		dropdownselectsearch(ddlTopCoverGauge, tbinput, "5");
		dropdownselectsearch(ddlBottomCoverCompound, tbinput, "GOLD PLUS");
		dropdownselectsearch(ddlBottomCoverGauge, tbinput, "4");
		//tbBeltlength.type("1500");
		dropdownselectsearch(ddlBeltwidth, tbinput, "1800");
		dropdownselect(ddlBreaker, breakeritems, "TC");
	    tbOverallbeltthickness.type("20");
		textareaComment.type("Added Comments");	
		waitForPageLoad(6000);
	}
	
	public void GeneratePDF()  {
		
		//SyncUtil.waitFor(7000);
		btnGeneratePDF.click();
		waitForPageLoad(15000);
		Reporter.log("PDF is generated",MessageTypes.Pass);
	}
	
	public void SelectSteel() {
		lnkBeltinfo.click();
		lnkSteel.click();
		Reporter.log("Steel link is clicked", MessageTypes.Pass);
	}
	
	public void InputSteel() {
		dropdownselectsearch(ddlMarket, tbinput, "APAC");
		dropdownselectsearch(ddlStdRequestedbyCustomer, tbinput, "AS 1333");
		dropdownselectsearch(ddlBeltConstruction, tbinput, "Flexsteel");
		dropdownselectsearch(ddlCarcassConstruction, tbinput, "1250");
		dropdownselectsearch(ddlTopCoverCompound, tbinput, "SHIELD KG");
		dropdownselectsearch(ddlTopCoverGauge, tbinput, "5");
		dropdownselectsearch(ddlBottomCoverCompound, tbinput, "GOLD PLUS");
		dropdownselectsearch(ddlBottomCoverGauge, tbinput, "4");
		dropdownselectsearch(ddlBeltwidth, tbinput, "1800");
		dropdownselectsearch(ddlBreaker, tbinput, "TC");
		textareaComment.type("Added comments");
	}
}
