package com.web.steps;



import com.common.utils.APIBase;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.LoginPage;
import org.openqa.selenium.Dimension;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class CommonSteps {

    LoginPage loginPage = new LoginPage();
    @QAFTestStep(description = "Launch the application through {url}")
    public void launchTheApplicationThrough(String url) {
        loginPage.getTestBase().getDriver().manage().window().maximize();
        loginPage.getTestBase().getDriver().get(url);
        loginPage.apiBase.getLoginAPI(getBundle().getString("env.adminUsername"),getBundle().getString("env.adminPassword"));
        //loginPage.getTestBase().getDriver().get("https://Uie68917:Conti@2021@dev2.contiplus.net/#/auth/login:4444");
        loginPage.getTestBase().getDriver().manage().window().setSize(new Dimension(1920,1080));
        Dimension windowSize = loginPage.getTestBase().getDriver().manage().window().getSize();
        int width = windowSize.getWidth();
        int height = windowSize.getHeight();

        // Print the resolution
        System.out.println("Browser resolution: " + width + "x" + height);
        Reporter.log("Application is launched using :" + url, MessageTypes.Pass);
    }
    
  
}
