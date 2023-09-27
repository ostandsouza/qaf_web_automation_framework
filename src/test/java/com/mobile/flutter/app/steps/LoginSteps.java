package com.mobile.flutter.app.steps;


import com.mobile.flutter.app.pages.ContinentalLoginPage;
import com.mobile.flutter.app.pages.LandingPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

public class LoginSteps {
    LandingPage landingPage = new LandingPage();
    ContinentalLoginPage continentalLoginPage = new ContinentalLoginPage();

    @QAFTestStep(description = "Login to the application with {UserName} and {Password}")
    public void loginToApplication(String userName, String password) {
        landingPage.goToContinentalAcct();
        continentalLoginPage.login("isolated@maildrop.cc","Test@12345");
        Validator.assertTrue(continentalLoginPage.isContinentalPage(),"Continental login page is not visible","Continental login page is visible");
    }

}
