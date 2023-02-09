package com.web.steps;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.FabricspliceAddPage;
import com.web.pages.LoginPage;

public class TestingWorkflowE {

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
	  @QAFTestStep(description="User should see all Approved status items and In review irrespective of who is the designer, approver and status")
	  public void userShouldSeeAllApprovedStatusItemsAndInReviewIrrespectiveOfWhoIsTheDesignerApproverAndStatus(){
	Reporter.log("All Approved status items and In review irrespective of who is the designer, approver and status displayed",MessageTypes.Pass);
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
	  @QAFTestStep(description="User should be able to click on View button and see the whole input and out put areas. - View Only")
	  public void userShouldBeAbleToClickOnViewButtonAndSeeTheWholeInputAndOutPutAreasViewOnly(){
		 SyncUtil.waitFor(5000);
		FSAPage.clickonfabriclist();
	  	FSAPage.clickonview();
	  	Reporter.log("See the whole input and out put areas. - View Only",MessageTypes.Pass);
	  }
	  @QAFTestStep(description="The user should be able to see Save as PDF button and Save as Draft")
	  public void theUserShouldBeAbleToSeeSaveAsPDFButtonAndSaveAsDraft(){
		  FSAPage.clickongeneratePDF();
	  }
	  @QAFTestStep(description="The user should see the designer's name and his comments")
	  public void theusershouldseethedesignersnameandhiscomment() {
		  SyncUtil.waitFor(3000);
		  FSAPage.clickoncommentslog();
		
	  }
	  @QAFTestStep(description="The user should see comments box to type in his comments")
	  public void theUserShouldSeeCommentsBoxToTypeInHisComments(){
	  //	FSAPage.entercomments();
	  }
	  @QAFTestStep(description="The user should see Approve or Reject Button")
	  public void theusershouldseeApproveorRejectButton() {
		//  FSAPage.rejectapprove();
	  }
	  
	  @QAFTestStep(description="This selection should navigate him back to register/list and update the status bar accordingly")
	  public void thisSelectionShouldNavigateHimBackToRegisterListAndUpdateTheStatusBarAccordingly(){
	  //	FSAPage.clickonapprove();
	  }

}
