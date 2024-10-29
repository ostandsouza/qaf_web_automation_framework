package com.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.BeltFormsPge;
import com.web.pages.LoginPage;

public class BeltFormsSteps {
	
	LoginPage loginPage = new LoginPage();
	BeltFormsPge beltpage = new BeltFormsPge();
	
	 @QAFTestStep(description = "User is at Login page")
	    public void verifyUserIsAtLoginPage() {
	        loginPage.verifyTitle("Conti+");
	    }

	    @QAFTestStep(description = "Login with {UserName} and {Password}")   
	     public void loginWithAnd(String UserName, String Password) {
	        loginPage.loginToApp(UserName, Password);
	    }
	    
	    @QAFTestStep(description = "Select Belt textile on the Navigation Pane")   
	     public void selectBelttextileontheNavigationPane() {
	    	beltpage.SelectTextile();
	    }

	    @QAFTestStep(description = "Input Data")   
	     public void inputData() {
	    	beltpage.Input();
	    }
	    
	    @QAFTestStep(description="Generate PDF")
	    public void generatePDF(){
	    	beltpage.GeneratePDF();
	    }
	    
	    @QAFTestStep(description = "Select Belt Steel on the Navigation Pane")   
	     public void SelectBeltSteelontheNavigationPane() {
	    	beltpage.SelectSteel();
	    }
	    
	    @QAFTestStep(description = "Input Data Steel")   
	     public void inputDataSteel() {
	    	beltpage.InputSteel();
	    }
	    
}
