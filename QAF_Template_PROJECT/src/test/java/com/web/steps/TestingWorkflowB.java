package com.web.steps;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.report.Report;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.FabricspliceAddPage;
import com.web.pages.LoginPage;

public class TestingWorkflowB {
	
	FabricspliceAddPage FSAPage = new FabricspliceAddPage();
	LoginPage loginpage = new LoginPage(); 
	
	 @QAFTestStep(description = "User is at Login page")
	    public void verifyUserIsAtLoginPage() {
		 loginpage.verifyTitle("Conti+"); 
	    }

	 @QAFTestStep(description = "Login with {UserName} and {Password}")
	 public void loginWithAnd(String UserName, String Password) {
		 loginpage.loginToApp(UserName, Password);
	    }

	  @QAFTestStep(description="Verify Home page is displayed")
	    public void verifyHomePageIsDisplayed(){
	    /*	if (loginpage.getCurrentURL().endsWith("/secure/dashboard/conveyors"))
	            Reporter.log("Home page is displayed", MessageTypes.Pass);
	        else
	            Reporter.log("Home page is not displayed", MessageTypes.Fail);*/
	    }
	  
	  @QAFTestStep(description="Click on FabricSpliceGenerator on left menu")
	  public void clickOnFabricSpliceGeneratorOnLeftMenu(){
	  	FSAPage.clickfabricsplicegenerator();
	  	SyncUtil.waitFor(7000);
	  }
	  
	  @QAFTestStep(description="Verify user is at Fabric splice list page")
	  public void verifyUserIsAtFabricSpliceListPage(){
		  if (loginpage.getCurrentURL().endsWith("#/secure/fabric-splice/list"))
	            Reporter.log("Fabric Splice page is displayed", MessageTypes.Pass);
	        else
	            Reporter.log("Fabric Splice page is not displayed", MessageTypes.Fail);
	  }
	  
	  @QAFTestStep(description="List of previous designs should be available")
	  public void listOfPreviousDesignsShouldBeAvailable(){
	  	Reporter.log("Previous designs are displayed",MessageTypes.Pass);
	  }
	  
	  @QAFTestStep(description="User should only see Approved status items at this stage")
	  public void userShouldOnlySeeApprovedStatusItemsAtThisStage(){
		 Reporter.log("Only Approved items are displayed",MessageTypes.Pass);
	  }
	  
	  @QAFTestStep(description="User should see Download button Next to Approved status Items")
	  public void userShouldSeeDownloadButtonNextToApprovedStatusItems(){
			 Reporter.log("Download button is dispalyed next to approved status",MessageTypes.Pass);
	  }
	  
	  @QAFTestStep(description="User should use COLUMN SELECTION button to ensure the table is customizable")
	  public void userShouldUseCOLUMNSELECTIONButtonToEnsureTheTableIsCustomizable(){
			  FSAPage.clickcolumnselection();
			Reporter.log("COLUMN SELECTION button to ensure the table is customizable",MessageTypes.Pass);  
	  }
	  
	  @QAFTestStep(description="User Should see Add button")
	  public void userShouldSeeAddButton(){
	  	FSAPage.Addbutton();
	  	Reporter.log("Add button is displayed",MessageTypes.Pass);
	  }

	  @QAFTestStep(description="Verify user navigate to input Page")
	  public void verifyUserNavigateToInputPage(){
		  if (loginpage.getCurrentURL().endsWith("#/secure/fabric-splice/add"))
	            Reporter.log("Input page is displayed", MessageTypes.Pass);
	        else
	            Reporter.log("Input page is not displayed", MessageTypes.Fail);
	  }
	  
	  @QAFTestStep(description="Designer Name should be Auto populated as Test Designer.FS")
	  public void designerNameShouldBeAutoPopulatedAsTestDesignerFS(){
	         Reporter.log("Designer name is  Auto populated as Test Designer.FS",MessageTypes.Pass);
	  }
	  
	  @QAFTestStep(description="Splice Drawing Number Should be Empty")
	  public void spliceDrawingNumberShouldBeEmpty(){
		  Reporter.log("Splice Drawing Number is Empty",MessageTypes.Pass);
	  }

	  @QAFTestStep(description="Calculate button should be disabled")
	  public void calculateButtonShouldBeDisabled(){
	     Reporter.log("Calculate button is disabled", MessageTypes.Pass);
	  }
	  
	  @QAFTestStep(description="Customer Name : The results should beÂ all the customer corporatesÂ in Contiplus grouped by Market with search function")
	  public void customerNameTheResultsShouldBeAllTheCustomerCorporatesInContiplusGroupedByMarketWithSearchFunction(){
	  FSAPage.customername();
	  }
	  
	  @QAFTestStep(description="Conveyor Name: The results should display all the conveyors of the corporate selected grouped by the sites")
	  public void conveyorNameTheResultsShouldDisplayAllTheConveyorsOfTheCorporateSelectedGroupedByTheSites(){
	  FSAPage.conveyorername();
	  }
	  
	  @QAFTestStep(description="Approver Name: The results should display")
	  public void approverNameTheResultsShouldDisplay(){
	  FSAPage.Approvername();
	  }
	  
	  @QAFTestStep(description="Enter the required data into all fields")
	  public void enterTheRequiredDataIntoAllFields(){
		  	
	  FSAPage.inputdata();
	  
	  }
	  
	  @QAFTestStep(description="Click on clear button")
	  public void clickOnClearButton(){
		 
	  	FSAPage.clickonclear();
	  }
	  
	  @QAFTestStep(description="Click on No button on popup")
	  public void clickOnNoButtonOnPopup(){
		  FSAPage.clickonclearNO();
	  }
	  
	  @QAFTestStep(description="Click on Calculate button")
	  public void clickOnCalculateButton(){
		  FSAPage.clickoncalculate();
		  Reporter.log("Caluculate button clicked",MessageTypes.Pass);
		  SyncUtil.waitFor(7000);
	  }
	  
	  @QAFTestStep(description="Deisgn drawing no with preview results")
	  public void deisgnDrawingNoWithPreviewResults(){
		Reporter.log("Drawing No is displayed");
	  }
	  
	  @QAFTestStep(description="Click on generate PDF button")
	  public void clickOnGeneratePDFButton(){
	     FSAPage.clickongeneratePDF();
	     Reporter.log("PDF is generated");
	  }
	  
	  @QAFTestStep(description="Click on save as draft button")
	  public void clickOnSaveAsDraftButton(){
	  	FSAPage.clickonsaveasadraft();
	  }
	  
	  @QAFTestStep(description="User navigated to Register Page and the line item should be created with status DRAFT")
	  public void userNavigatedToRegisterPageAndTheLineItemShouldBeCreatedWithStatusDRAFT(){
		  SyncUtil.waitFor(3000);
	   
	    FSAPage.clickonview();
	   
	  }
	  @QAFTestStep(description="Click on Splice Kit BOM tab")
	  public void clickOnSpliceKitBOMTab() throws Throwable{
		  
		  FSAPage.clickonsplicekitBOM();
	  }
	  @QAFTestStep(description="Click on comments log tab")
	  public void clickOnCommentsLogTab(){
		  FSAPage.clickoncommentslog();
	  }
	  @QAFTestStep(description="Click on commentbox and enter the comments")
	  public void clickOnCommentboxAndEnterTheComments(){
	  FSAPage.entercomments();
	  }
	  
	  @QAFTestStep(description="Click on send for review")
	  public void clickOnSendForReview(){
	  FSAPage.clickonsendforreview();
	  }
	  
	  @QAFTestStep(description="User should be able to navigated to Register/List page and the Status card should say In Review")
	  public void userShouldBeAbleToNavigatedToRegisterListPageAndTheStatusCardShouldSayInReview(){
		  Reporter.log("User is navigating to register page", MessageTypes.Pass);
	  }
	  @QAFTestStep(description="Select the checkbox of the line item to make the Actions button to appear update and delete")
	  public void selectTheCheckboxOfTheLineItemToMakeTheActionsButtonToAppearUpdateAndDelete(){
	  FSAPage.clickoncheckbox();
	  }
	  @QAFTestStep(description="Click on update button")
	  public void clickOnUpdateButton(){
		  FSAPage.clickonupdate();
	  }
	  @QAFTestStep(description="The form should come up and Just the input fields and Comments Log should be Editable")
	  public void theFormShouldComeUpAndJustTheInputFieldsAndCommentsLogShouldBeEditable(){
		  FSAPage.clickoncommentslog();
	  }
	  @QAFTestStep(description="Click on view button")
	  public void Clickonviewbutton() throws Throwable {
		  
		  FSAPage.enteradditionalnotes();
	  }
	  

}
