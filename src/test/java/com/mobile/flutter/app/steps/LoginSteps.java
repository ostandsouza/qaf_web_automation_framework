package com.mobile.flutter.app.steps;


import com.mobile.flutter.app.pages.ContinentalLoginPage;
import com.mobile.flutter.app.pages.LandingPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import org.testng.Assert;

public class LoginSteps {
    ContinentalLoginPage contiPage=new ContinentalLoginPage();

    @QAFTestStep(description = "Login to the application with {UserName} and {Password}")
    public void loginToApplication(String userName, String password) {
//        ContinentalLoginPage.getInstance().login(userName,password);
        contiPage.login(userName,password);

        Validator.assertTrue(ContinentalLoginPage.getInstance().isContinentalPage(),"Continental login page is not visible","Continental login page is visible");
    }

    @QAFTestStep(description="Verify user is on continental login page")
    public void continentalLoginPageNav(){
        Validator.assertTrue(LandingPage.getInstance().goToContinentalAcct(),"User is not navigated to continental login page","User is navigated successfully to login page");
    }

    @QAFTestStep(description="Now verify the {UserName} user from mobile via Activate account flow")
    public void nowVerifyTheUserFromMobileViaActivateAccountFlow(String userName){
        Validator.assertTrue(ContinentalLoginPage.getInstance().verifyUser(userName),"User is not navigated back to continental login page after account activation","User is navigated successfully to login page after account activation");
    }

    @QAFTestStep(description="verify update user phone number")
    public void verifyUpdateUserPhoneNumber(){

    }

}
