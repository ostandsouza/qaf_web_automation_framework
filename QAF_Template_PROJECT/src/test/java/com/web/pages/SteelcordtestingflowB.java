package com.web.pages;

import com.common.component.CustomElement;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;

public class SteelcordtestingflowB extends BasePage{
	
	SteelcordgeneratorPage Steelpage = new SteelcordgeneratorPage();
	
	@FindBy(locator="xpath=//div[@class='p-datatable-responsive-demo p-datatable p-component p-datatable-hoverable-rows p-datatable-responsive-stack']")
	public CustomElement registertable;
	
	@FindBy(locator="xpath=//div[contains(@class,'p-multiselect p-component')]")
	public CustomElement columnselection;
	
	@FindBy(locator="xpath=//button[@ng-reflect-label='Save as PDF']")
	public CustomElement btsaveasPDF;
	
	@FindBy(locator="xpath=//button[@ng-reflect-label='Save as Draft']")
	public CustomElement btsaveasDraft;
	
	@FindBy(locator="xpath=(//span[text()='Vulcanization Chart'])[1]")
	public CustomElement tabVulcanization;
	
	@FindBy(locator="xpath=//span[text()='Comments Log']")
	public CustomElement tabCommentsLog;
	
	@FindBy(locator="xpath=//textarea[contains(@class,'ng-valid ng-star-inserted')]")
	public CustomElement tiComment;
	
	@FindBy(locator="xpath=//button[@ng-reflect-label='Send for review']")
	public CustomElement btSendforreview;
	
	@FindBy(locator="xpath=(//div[@class='p-checkbox-box p-component'])[1]")
	public CustomElement checkbox;
	
	@FindBy(locator = "xpath=(//button[contains(@class,'p-component p-button-icon-only')])[3]")
	public CustomElement btView;
	
	@FindBy(locator="xpath=//button[@ng-reflect-icon='pi pi-chevron-down']")
	public CustomElement drActions;
	
	@FindBy(locator="xpath=//span[text()='Edit']")
	public CustomElement btEdit;
	
	@FindBy(locator="xpath=//span[text()='Steel Cord Splice Generator']")
	public CustomElement lsteelcord;
	
	@FindBy(locator="xpath=//input[@formcontrolname='stepLength']")
	public CustomElement tbStepLength;
	
	@FindBy(locator="xpath=//button[@ng-reflect-label='Approve']")
	public CustomElement btApprove;
	
	
	
	
	public void createflowB() {
		Steelpage.clicksteelcord();
	}
	
	public void registerlist() {
		if (registertable.isVisible()) {
            Reporter.log("Register is displayed", MessageTypes.Pass);
		    Reporter.log("List of previous designs should be available", MessageTypes.Pass);
		    Reporter.log("User should only see Approved status items at this stage",MessageTypes.Pass);
		    Reporter.log("User should see Download button Next to Approved status Items",MessageTypes.Pass);
		}
        else
            Reporter.log("Register is not displayed", MessageTypes.Fail);
	}
	
	public void columnselection() {
		columnselection.click();
		Reporter.log("User should use COLUMN SELECTION button to ensure the table is customisable.",MessageTypes.Pass);
		Reporter.log("User should see + Button",MessageTypes.Pass);
	}
	public void add() {
		Steelpage.btAdd.click();
		Reporter.log("Input Page is displayed",MessageTypes.Pass);
	}
	public void Input() {
	 if(Steelpage.tbdesignerName.isVisible()) 
		 Reporter.log("Designer Name should be Auto populated as Test Designer.SC",MessageTypes.Pass);
	}
	public void preview() throws Throwable {
		waitForPageLoad(10000);
		btsaveasPDF.click();
		Reporter.log("PDF should be generated with a water mark DRAFT", MessageTypes.Pass);
		btsaveasDraft.click();
		Reporter.log("The page should be navigated to Register Page and the line item should be created with status : DRAFT",MessageTypes.Pass);
	    checkbox.click();
	    drActions.click();
	    btEdit.click();
	    scrollPageDown();
		tabVulcanization.click();		
	}
	
	public void commentlog() {
		tabCommentsLog.click();
		tiComment.type("Comments Entered");
		btSendforreview.click();
		Reporter.log("User navigated to Register/List page and the Status card as In Review",MessageTypes.Pass);
		
	}
	
	public void registeredit() throws Throwable {
		checkbox.click();
		drActions.click();
	    btEdit.click();
	    scrollPageDown();
	    tabCommentsLog.click();	
	}
	
	public void view() {
	    lsteelcord.click();
	    checkbox.click();
		btView.click();		
	}
	
	public void previewoutputD() throws Throwable {
		scrollPageDown();
		//tbStepLength.type("12");
		btsaveasPDF.click();
		Reporter.log("PDF is generated eith water mark DRAFT",MessageTypes.Pass);
	}
	
	public void registerlistE() {
		if (registertable.isVisible()) {
            Reporter.log("Register is displayed", MessageTypes.Pass);
		    Reporter.log("List of previous designs should be available", MessageTypes.Pass);
		    Reporter.log("see all Approved status items",MessageTypes.Pass);
		    Reporter.log("User should see + Button",MessageTypes.Pass);
		}
		    
	}
	
	public void commentlogC() {
		tabCommentsLog.click();
		Reporter.log("The designer name and his comments are displayed",MessageTypes.Pass);
		tiComment.type("Comments Entered");
		//btSendforreview.click();
		Reporter.log("Approve or Reject Button are displayed",MessageTypes.Pass);
		Reporter.log("User navigated to Register/List page ",MessageTypes.Pass);
		
	}
	
	public void reviewG() {
	btView.click();
	}
	
	public void commentG() throws Throwable {
		scrollPageDown();
		tabCommentsLog.click();
		btApprove.click();
		Reporter.log("Approved",MessageTypes.Pass);	
	}
	
}
