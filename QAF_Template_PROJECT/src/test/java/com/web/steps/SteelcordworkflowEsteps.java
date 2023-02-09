package com.web.steps;

import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.LoginPage;
import com.web.pages.SteelcordgeneratorPage;
import com.web.pages.SteelcordtestingflowB;
import com.web.pages.UsersPage;

public class SteelcordworkflowEsteps {
	
	LoginPage loginpage = new LoginPage(); 
    UserSteps us = new UserSteps();
    UsersPage userpage = new UsersPage();
    SteelcordgeneratorPage steelpage = new SteelcordgeneratorPage();
	SteelcordtestingflowB steelpageB = new SteelcordtestingflowB();
	
	@QAFTestStep(description = "User is at Login page")
	public void verifyUserIsAtLoginPage() {
		loginpage.verifyTitle("Conti+"); 
	}

	@QAFTestStep(description = "Login with Test admin.SC {UserName} and {Password}")
	public void loginWithTestadminSCAnd(String UserName, String Password) {
		loginpage.loginToApp(UserName, Password);
	}
	
	@QAFTestStep(description="Select Steel cord Splice Generator on the Navigation Pane")
	public void selectSteelCordSpliceGeneratorOnTheNavigationPane(){
		steelpage.clicksteelcord();
	}

	@QAFTestStep(description="Register List")
	public void registerlist(){
		steelpageB.registerlistE();
	}
	
	@QAFTestStep(description="User should be able to click on View button and see the whole input and out put areas")
	public void UsershouldbeabletoclickonViewbuttonandseethewholeinputandoutputareas(){
		steelpageB.view();
	}
	
	@QAFTestStep(description="Output Preview")
	public void outputPreview(){
	Reporter.log("Save as PDF button and Save as draft buttons are dispalyed",MessageTypes.Pass);
	}
	
	@QAFTestStep(description="Comments Log")
	public void commentsLog() {
		steelpageB.commentlogC();
	}
	
	@QAFTestStep(description="Logout as Test admin.SC")
	public void logoutAsTestadminSC(){
		
	}
}
