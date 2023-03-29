package com.web.steps;



import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.LoginPage;

public class CommonSteps {

    LoginPage loginPage = new LoginPage();
    @QAFTestStep(description = "Launch the application through {url}")
    public void launchTheApplicationThrough(String url) {
        loginPage.getTestBase().getDriver().manage().window().maximize();
        loginPage.getTestBase().getDriver().get(url);
        //loginPage.getTestBase().getDriver().get("https://Uie68917:Conti@2021@dev2.contiplus.net/#/auth/login:4444");
        Reporter.log("Application is launched using :" + url, MessageTypes.Pass);
    }
    
  
}
