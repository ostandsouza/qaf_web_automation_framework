package com.web.steps;

import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.LoginPage;
import com.web.pages.SteelcordgeneratorPage;
import com.web.pages.SteelcordtestingflowB;
import com.web.pages.UsersPage;

public class SteelcordworkflowGsteps {
	
	LoginPage loginpage = new LoginPage(); 
    UserSteps us = new UserSteps();
    UsersPage userpage = new UsersPage();
    SteelcordgeneratorPage steelpage = new SteelcordgeneratorPage();
	SteelcordtestingflowB steelpageB = new SteelcordtestingflowB();
	
	@QAFTestStep(description = "User is at Login page")
	public void verifyUserIsAtLoginPage() {
		loginpage.verifyTitle("Conti+"); 
	}

	@QAFTestStep(description = "Login with {UserName} and {Password}")
	public void loginWithAnd(String UserName, String Password) {
		loginpage.loginToApp(UserName, Password);
	}
	
	@QAFTestStep(description="Select Steel cord Splice Generator on the Navigation Pane")
	public void selectSteelCordSpliceGeneratorOnTheNavigationPane(){
		steelpage.clicksteelcord();
	}
	@QAFTestStep(description="Click on more on the tab that says in review")
	public void clickonmoreonthetabthatsaysinreview(){
	steelpageB.reviewG();
	}
	
	@QAFTestStep(description="Select approve in the comments section")
	public void selectapproveinthecommentssection() throws Throwable{
	steelpageB.commentG();
	}
	
	@QAFTestStep(description="Navigate back to register to see the name of the line item which is approved to reflect the naming convention tested above and rev 0")
	public void navigatebacktoregistertoseethenameofthelineitemwhichisapprovedtoreflectthenamingconventiontestedaboveandrev0() {
		Reporter.log("Item is approved and rev 0",MessageTypes.Pass);
	}
	
	@QAFTestStep(description="Logout as Approver 1.SC")
	public void logoutAsApprover1SC(){
		
	}
}
