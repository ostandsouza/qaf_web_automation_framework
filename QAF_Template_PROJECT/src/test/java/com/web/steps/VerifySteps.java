package com.web.steps;

import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.VerifyPage;

public class VerifySteps {
	
	VerifyPage verifypage = new VerifyPage();
	
    @QAFTestStep(description = "User is at Login page")
    public void verifyUserIsAtLoginPage() {
    	verifypage.verifyTitle("Conti+");
    }
    
    @QAFTestStep(description = "Click on verify link")
    public void clickonverifylink() {
    	verifypage.verify();
    }

    @QAFTestStep(description = "Verify with {Randomemail} and {Secret}")
    public void LoginWebApp(String Randomemail, String Secret) {
    	verifypage.Verify(Randomemail, Secret);
    }
    
    @QAFTestStep(description="Verify Success message is displayed")
    public void verifysuccessmessgaeIsDisplayed(){
    	if (verifypage.getCurrentURL().endsWith("/#/auth/login"))
            Reporter.log("Home page is displayed", MessageTypes.Pass);
        else
            Reporter.log("Home page is not displayed", MessageTypes.Fail);
    }


}
