package com.web.steps;

import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.LoginPage;
import com.web.pages.SteelcordgeneratorPage;
import com.web.pages.SteelcordtestingflowB;
import com.web.pages.SteelcordworkflowpageC;

public class SteelcordworkflowCsteps {
	
	LoginPage loginpage = new LoginPage(); 
	SteelcordtestingflowB steelpageB = new SteelcordtestingflowB();
	SteelcordworkflowpageC steelpagec = new SteelcordworkflowpageC();
	SteelcordgeneratorPage steelpage = new SteelcordgeneratorPage();
	
	@QAFTestStep(description="Login with Test Approver1.SC {UserName} and {Password}")
	public void loginWithTestApprover1SCAnd(String UserName,String Password){
		loginpage.loginToApp(UserName, Password);
	}
	
	@QAFTestStep(description="Select Steel cord Splice Generator on the Navigation Pane")
	public void selectSteelCordSpliceGeneratorOnTheNavigationPane(){
		steelpage.clicksteelcord();
	}
	
	@QAFTestStep(description="Register List")
	public void registerlist(){
		steelpageB.registerlist();
		steelpageB.columnselection();
		steelpageB.add();
	}

	@QAFTestStep(description="User should be able to click on View button and see the whole input and out put areas")
	public void UsershouldbeabletoclickonViewbuttonandseethewholeinputandoutputareas(){
		
		steelpageB.view();
	}
	
	@QAFTestStep(description="Output Preview C")
	public void outputPreviewC(){
	Reporter.log("Save as PDF button is dispalyed",MessageTypes.Pass);
	}
	
	@QAFTestStep(description="Comments Log C")
	public void commentsLogc() {
		steelpageB.commentlogC();
	}
	
}
