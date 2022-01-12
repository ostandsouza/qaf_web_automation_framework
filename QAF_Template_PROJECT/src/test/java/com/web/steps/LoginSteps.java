package com.web.steps;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @QAFTestStep(description = "User is at Login page")
    public void verifyUserIsAtLoginPage() {
        loginPage.verifyTitle("Conti+");
    }

    @QAFTestStep(description = "Login with {UserName} and {Password}")   
     public void loginWithAnd(String UserName, String Password) {
        loginPage.loginToApp(UserName, Password);
    }
    
    @QAFTestStep(description="Verify Home page is displayed")
    public void verifyHomePageIsDisplayed(){
    	
    	if (loginPage.getCurrentURL().endsWith("/secure/dashboard/conveyors"))
            Reporter.log("Home page is displayed", MessageTypes.Pass);
        else
            Reporter.log("Home page is not displayed", MessageTypes.Fail);
    	SyncUtil.waitFor(3000);
    }


}
