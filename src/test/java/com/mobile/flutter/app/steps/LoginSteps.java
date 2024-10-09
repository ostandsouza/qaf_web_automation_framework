package com.mobile.flutter.app.steps;


import com.mobile.flutter.app.pages.ContinentalLoginPage;
import com.mobile.flutter.app.pages.DashboardPage;
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
    @QAFTestStep(description ="Click on the login button and verify error message is displayed" )
    public void clickLoginAndVerifyErrorMessage()
    {
        contiPage.loginBtnClickAndVerifyErrorMessage();
        Validator.assertTrue(ContinentalLoginPage.getInstance().isContinentalPage(),"Continental login page is not visible","Continental login page is visible");
    }
    @QAFTestStep(description ="Login to the application with email-Id {UserName} and blank password" )
    public void loginWithBlankPassword(String email)
    {contiPage.loginWithBlankPwd(email);}

    @QAFTestStep(description ="Click on the login button and verify error message is displayed for blank password" )
    public void clickLoginAndVerifyErrorMessageForBlankPwd()
    {
        contiPage.btnLoginClickAndVerifyBlankPwd();
        Validator.assertTrue(ContinentalLoginPage.getInstance().isContinentalPage(),"Continental login page is not visible","Continental login page is visible");
    }
    @QAFTestStep(description ="Click on the terms and conditions and verify user is navigated to terms and conditions page and view the details" )
    public void clickOnTermsConditionsLinkAndVerify()
    {
        contiPage.termsAndConditionsClick();
        contiPage.verifyTermsAndConditionsPage();
    }
    @QAFTestStep(description="Click on site card and verify navigation to site list page")
    public void clickAndVerifySiteCardNav() {
        DashboardPage.getInstance().siteTileClick();
    }

    @QAFTestStep(description="Click on filter functionality and verify user is able to see the popup with header as filter")
    public void clickAndVerifyFilterFunctionality() {
        DashboardPage.getInstance().filterBtnClick();
    }

    @QAFTestStep(description="Verify userName and Password field is present")
    public void verifyTheUserNameAndPasswordFieldsExists(){
        ContinentalLoginPage.getInstance().verifyUserNameAndPasswordFieldsExists();
    }
    @QAFTestStep(description="Click on back button")
    public void clickOnTheBackBtn(){
        ContinentalLoginPage.getInstance().clickOnBackBtn();
    }
    @QAFTestStep(description="Verify user is in welcome page")
    public void verifyIsWelcomePage(){
        LandingPage.getInstance().isWelcomePage();
    }

    @QAFTestStep(description = "User login to the application with {UserName} and {Password}")
    public void userLoginToApplication(String userName, String password) {
        ContinentalLoginPage.getInstance().loginWithEmailAndPassword(userName,password);
    }
    @QAFTestStep(description = "Verify Email field error message")
    public void verifyTheEmailErrorMsg() {
        ContinentalLoginPage.getInstance().verifyEmailErrorMsg();
    }
    @QAFTestStep(description = "Click and Verify Forget Password button")
    public void clickTheForgotPasswordBtn() {
        ContinentalLoginPage.getInstance().clickForgotPasswordBtn();
    }
    @QAFTestStep(description = "Enter email {ForgottenEmail} for Forgot Password")
    public void enterTheEmailForForgotPassword(String email) {
        ContinentalLoginPage.getInstance().enterTheEmailForForgotPassword(email);
    }

}
