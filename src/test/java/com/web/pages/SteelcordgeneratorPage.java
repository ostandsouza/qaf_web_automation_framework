package com.web.pages;

import com.common.component.CustomElement;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;

public class SteelcordgeneratorPage extends BasePage {


	@FindBy(locator = "xpath=//span[text()='Splice Design']")
	public CustomElement lspliceprint;

	@FindBy(locator = "xpath=//span[text()='Steel Cord']")
	public CustomElement lsteelcordlink;

	@FindBy(locator = "xpath=//span[@class='p-button-icon ctp-icon-Add-circle']")
	public CustomElement btAdd;

	@FindBy(locator = "xpath=//input[@name='designerName']")
	public CustomElement tbdesignerName;

	@FindBy(locator = "xpath= //p-dropdown[@ng-reflect-name='market']//div[2]")
	public CustomElement drchoosetyourmarket;

	@FindBy(locator = "xpath=//div[@ng-reflect-ng-class='p-dropdown-panel p-component']//input")
	public CustomElement tbinput;
	
	@FindBy(locator = "xpath= //p-dropdown[@ng-reflect-name='productionLocation']//div[2]")
	public CustomElement drproductionlocationofsplicekit;
	
	@FindBy(locator = "xpath= //p-dropdown[@ng-reflect-name='customer']//div[2]")
	public CustomElement drcustomername;
	
	@FindBy(locator = "xpath= //p-dropdown[@ng-reflect-name='conveyor']//div[2]")
	public CustomElement drconveyorname;
	
	@FindBy(locator = "xpath= //p-autocomplete[@ng-reflect-name='approver']//span//button")
	public CustomElement drapprovername;
	
	public String drapproverlist = "xpath= //ul[contains(@class,'p-autocomplete-items')]//li//div//span";
	
	@FindBy(locator = "xpath=  //p-dropdown[@ng-reflect-name='beltRating']//div[2]")
	public CustomElement drBeltrating;

	@FindBy(locator = "xpath=//input[@formcontrolname='beltWidth']")
	public CustomElement tbBeltwidth;
	
	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='topCoverCompound']//div[2]")
	public CustomElement drTopcovercompound;
	
	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='bottomCoverCompound']//div[2]")
	public CustomElement drBottomcovercompound;
	
	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='topCoverThickness']//div[2]")
	public CustomElement drTopcoverthickness;
	
	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='bottomCoverThickness']//div[2]")
	public CustomElement drBottomcoverthickness;
	
	@FindBy(locator = "xpath=//input[@formcontrolname='overallThickness']")
	public CustomElement tbOverallthickness;
	
	@FindBy(locator = "xpath=//input[@formcontrolname='cordDiameter']")
	public CustomElement tbCorddaiameter;
	
	@FindBy(locator = "xpath=//input[@formcontrolname='cordPitch']")
	public CustomElement tbCordpitch;
	
	@FindBy(locator = "xpath=//input[@formcontrolname='numberOfCord']")
	public CustomElement tbNumberofcards;
	
	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='biasAngle']//div[2]")
	public CustomElement drBiasangle;
	
	@FindBy(locator = "xpath=(//p-radiobutton[@ng-reflect-name='spliceCategory']//div[2])[1]")
	public CustomElement radioRegularsplice;
	
	@FindBy(locator = "xpath=(//p-radiobutton[@ng-reflect-name='spliceCategory']//div[2])[3]")
	public CustomElement radioReduceServicesplice;
	
	@FindBy(locator = "xpath=(//p-checkbox[@name='reducedServiceReason'])[1]")
	public CustomElement checkboxreason;
	
	@FindBy(locator = "xpath=//span[text()='Save']")
	public CustomElement btSave;
	
    @FindBy(locator = "xpath=//button[@ng-reflect-label='Calculate']")
	public CustomElement btCalculate;
	
    @FindBy(locator = "xpath=//button[@ng-reflect-label='Clear']")
  	public CustomElement btClear;
   
    @FindBy(locator = "xpath=//button[@ng-reflect-label='No']")
  	public CustomElement btNo;
	
	public void clicksteelcord() {
		lspliceprint.click();
		lsteelcordlink.click();
		waitForPageLoad(5000);
	}

	public void createsteelcord() {
	//	tbdesignerName.type(Designername);
		dropdownSelectSearch(drchoosetyourmarket, tbinput, "APAC");
		dropdownSelectSearch(drproductionlocationofsplicekit, tbinput, "Kalyani");
		dropdownSelectSearch(drcustomername, tbinput, "SiteAsia");
		dropdownSelectSearch(drconveyorname, tbinput, "rfb1");
	    dropdownSelect(drapprovername, drapproverlist, "Test Approver 1.FS");
		dropdownSelectSearch(drBeltrating, tbinput, "ST 1000");
		tbBeltwidth.type("1200");
		dropdownSelectSearch(drTopcovercompound, tbinput, "ARCTIC GOLD");
		dropdownSelectSearch(drBottomcovercompound, tbinput, "ARCTIC GOLD PLUS");
		dropdownSelectSearch(drTopcoverthickness, tbinput, "4");
		dropdownSelectSearch(drBottomcoverthickness, tbinput, "2");
		tbOverallthickness.type("5");
		tbOverallthickness.type("8");
		tbCorddaiameter.type("20");
		tbCordpitch.type("10");
		tbNumberofcards.type("4");
		radioRegularsplice.click();
		btClear.click();
		btNo.click();
		btCalculate.click();
		Reporter.log("Splice Design Drawing No. is displayed",MessageTypes.Pass);	
		
	}
	
	public void createsteelcordD() {
		//	tbdesignerName.type(Designername);
			dropdownSelectSearch(drchoosetyourmarket, tbinput, "APAC");
			dropdownSelectSearch(drproductionlocationofsplicekit, tbinput, "Kalyani");
			dropdownSelectSearch(drcustomername, tbinput, "Miguel Site");
			dropdownSelectSearch(drconveyorname, tbinput, "conMex");
		    dropdownSelect(drapprovername, drapproverlist, "Test admin.SC");
			dropdownSelectSearch(drBeltrating, tbinput, "ST 1000");
			tbBeltwidth.type("1200");
			dropdownSelectSearch(drTopcovercompound, tbinput, "ARCTIC GOLD");
			dropdownSelectSearch(drBottomcovercompound, tbinput, "ARCTIC GOLD PLUS");
			dropdownSelectSearch(drTopcoverthickness, tbinput, "4");
			dropdownSelectSearch(drBottomcoverthickness, tbinput, "2");
			tbOverallthickness.type("5");
			tbOverallthickness.type("8");
			tbCorddaiameter.type("20");
			tbCordpitch.type("10");
			tbNumberofcards.type("4");
			radioRegularsplice.click();
			btClear.click();
			btNo.click();
			btCalculate.click();
			Reporter.log("Splice Design Drawing No. is displayed",MessageTypes.Pass);	
			
		}

	public void createsteelcordF() {
			dropdownSelectSearch(drchoosetyourmarket, tbinput, "APAC");
			dropdownSelectSearch(drproductionlocationofsplicekit, tbinput, "Kalyani");
			dropdownSelectSearch(drcustomername, tbinput, "SiteMex");
			dropdownSelectSearch(drconveyorname, tbinput, "rfbmex1");
		    dropdownSelect(drapprovername, drapproverlist, "Test Approver 1.FS");
			dropdownSelectSearch(drBeltrating, tbinput, "ST 1600");
			tbBeltwidth.type("1800");
			dropdownSelectSearch(drTopcovercompound, tbinput, "ARCTIC GOLD");
			dropdownSelectSearch(drBottomcovercompound, tbinput, "ARCTIC GOLD PLUS");
			dropdownSelectSearch(drTopcoverthickness, tbinput, "16");
			dropdownSelectSearch(drBottomcoverthickness, tbinput, "6");
			tbOverallthickness.type("5");
			tbOverallthickness.type("25");
			tbCorddaiameter.type("5.3");
			tbCordpitch.type("5.3");
			tbNumberofcards.type("153");
			radioReduceServicesplice.click();
			btCalculate.click();
			checkboxreason.click();
			Reporter.log("Chosen items is displayed in the additional comments sections in the preview area.",MessageTypes.Pass);
			btSave.click();
			Reporter.log("Splice Design Drawing No. is displayed",MessageTypes.Pass);	
		}






}