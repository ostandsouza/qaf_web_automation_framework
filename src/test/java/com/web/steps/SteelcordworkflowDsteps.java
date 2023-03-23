package com.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.BasePage;
import com.web.pages.LoginPage;
import com.web.pages.SteelcordgeneratorPage;
import com.web.pages.SteelcordtestingflowB;
import com.web.pages.UsersPage;

public class SteelcordworkflowDsteps extends BasePage{

	LoginPage loginpage = new LoginPage(); 
    UserSteps us = new UserSteps();
    UsersPage userpage = new UsersPage();
    SteelcordgeneratorPage steelpage = new SteelcordgeneratorPage();
	SteelcordtestingflowB steelpageB = new SteelcordtestingflowB();
	
	@QAFTestStep(description = "User is at Login page")
	public void verifyUserIsAtLoginPage() {
		loginpage.verifyTitle("Conti+"); 
	}
	
	@QAFTestStep(description="Login with Test Approver2.SC {UserName} and {Password}")
	public void loginWithTestApproverSCAnd(String UserName,String Password){
		loginpage.loginToApp(UserName, Password);
	}
	
	@QAFTestStep(description="Select Steel cord Splice Generator on the Navigation Pane")
	public void selectSteelCordSpliceGeneratorOnTheNavigationPane(){
		steelpage.clicksteelcord();
	}
	
	@QAFTestStep(description="Register List")
	public void registerList(){
	steelpageB.registerlist();
	steelpageB.columnselection();
	steelpageB.add();
	}
	
	@QAFTestStep(description="Input D")
	public void inputD(){
		steelpageB.Input();
		steelpage.createsteelcordD();
		
	}
	
	@QAFTestStep(description="Output Preview")
	public void outputPreview() throws Throwable{
	steelpageB.previewoutputD();
	}
	
	@QAFTestStep(description="Comments Log")
	public void commentsLog(){
		steelpageB.commentlog();
	}
	
	@QAFTestStep(description="Register Edit")
	public void registerEdit() throws Throwable{
	steelpageB.registeredit();
	}
	
	@QAFTestStep(description="Register View")
	public void registerView() throws Throwable{

	}
	
	@QAFTestStep(description="Logout as Test Approver {0}.SC")
	public void logoutAsTestApproverSC(long l0){
		
	}
}
