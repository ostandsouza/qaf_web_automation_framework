package com.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.BasePage;
import com.web.pages.LoginPage;
import com.web.pages.SteelcordgeneratorPage;
import com.web.pages.SteelcordtestingflowB;

public class SteelcordworkflowBSteps extends BasePage{
	
	SteelcordgeneratorPage steelpage = new SteelcordgeneratorPage();
	SteelcordtestingflowB steelpageB = new SteelcordtestingflowB();
	LoginPage loginpage = new LoginPage(); 
	
	@QAFTestStep(description="Login with Test Designer.SC {UserName} and {Password}")
	public void loginWithTestDesignerSCAnd(String UserName,String Password){
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
	
	@QAFTestStep(description="Input")
	public void input(){
		steelpageB.Input();
		steelpage.createsteelcord();
		
	}
	
	@QAFTestStep(description="Output Preview B")
	public void outputPreviewB() throws Throwable{
	 steelpageB.preview();
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
	
	@QAFTestStep(description="Logout as Test Designer.SC")
	public void logoutAsTestDesignerSC(){
		
	}
}
