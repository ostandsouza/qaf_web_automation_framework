package com.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.LoginPage;
import com.web.pages.SteelcordgeneratorPage;
import com.web.pages.SteelcordtestingflowB;
import com.web.pages.UsersPage;

public class SteelcordworkflowFsteps {
	
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
	
	@QAFTestStep(description="Add input fields")
	public void  addinputfields() {
		steelpageB.add();
		steelpage.createsteelcordF();
		
	}
	@QAFTestStep(description="Logout as TestDesigner.SC")
	public void logoutAsTestDesignerSC(){
		
	}
}
