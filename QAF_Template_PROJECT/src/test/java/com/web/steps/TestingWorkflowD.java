package com.web.steps;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.FabricspliceAddPage;
import com.web.pages.LoginPage;

public class TestingWorkflowD {

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
	    	if (loginpage.getCurrentURL().endsWith("/secure/dashboard/conveyors"))
	            Reporter.log("Home page is displayed", MessageTypes.Pass);
	        else
	            Reporter.log("Home page is not displayed", MessageTypes.Fail);
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
	  	FSAPage.creationdate();
	  }
	  
	  @QAFTestStep(description="User should only see Approved status items at this stage")
	  public void userShouldOnlySeeApprovedStatusItemsAtThisStage(){
		  FSAPage.Status();
	  }
	  
	  @QAFTestStep(description="User should see Download button Next to Approved status Items")
	  public void userShouldSeeDownloadButtonNextToApprovedStatusItems(){
	  FSAPage.downloadicon();
	  }
	  
	  @QAFTestStep(description="User should use COLUMN SELECTION button to ensure the table is customizable")
	  public void userShouldUseCOLUMNSELECTIONButtonToEnsureTheTableIsCustomizable(){
		  SyncUtil.waitFor(3000);
		  FSAPage.clickcolumnselection();
	  }
	  
	  @QAFTestStep(description="User Should see Add button")
	  public void userShouldSeeAddButton(){
	  	FSAPage.Addbutton();
	  }

	  @QAFTestStep(description="Verify user navigate to input Page")
	  public void verifyUserNavigateToInputPage(){
		  if (loginpage.getCurrentURL().endsWith("#/secure/fabric-splice/add"))
	            Reporter.log("Input page is displayed", MessageTypes.Pass);
	        else
	            Reporter.log("Input page is not displayed", MessageTypes.Fail);
	  }
	  
	  @QAFTestStep(description="Designer Name should be Auto populated as Test Approver 2.FS")
	  public void designerNameShouldBeAutoPopulatedAsTestApprover2FS(){
	  	FSAPage.AutoDesignername();
	  }
	  
	  @QAFTestStep(description="Splice Drawing Number Should be Empty")
	  public void spliceDrawingNumberShouldBeEmpty(){
		FSAPage.SpliceDesignDrawingNo();
	  }

	  @QAFTestStep(description="Calculate button should be disabled")
	  public void calculateButtonShouldBeDisabled(){
	  FSAPage.calculatebuttondisable();
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
		  SyncUtil.waitFor(7000);
		
	  FSAPage.inputdata();
	  
	  }
	  
	  @QAFTestStep(description="Click on clear button")
	  public void clickOnClearButton(){
		  SyncUtil.waitFor(3000);
	  	FSAPage.clickonclear();
	  }
	  
	  @QAFTestStep(description="Click on No button on popup")
	  public void clickOnNoButtonOnPopup(){
		  SyncUtil.waitFor(3000);
		  FSAPage.clickonclearNO();
	  }
	  
	  @QAFTestStep(description="Click on Calculate button")
	  public void clickOnCalculateButton(){
		  FSAPage.clickoncalculate();
		  SyncUtil.waitFor(7000);
	  }
	  
	  @QAFTestStep(description="The output fields results should beÂ editableÂ ")
	  public void theOutputFieldsResultsShouldBeEditable(){
	      FSAPage.fieldsshouldbeeditable();
	  }
	  @QAFTestStep(description="Logout as TestApprover 2.FS")
	  public void logoutAsTestApproverFS(long l0){
	  	FSAPage.logout();
	  }
	  
}
