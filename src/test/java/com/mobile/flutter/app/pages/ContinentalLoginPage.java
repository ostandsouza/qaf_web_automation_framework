package com.mobile.flutter.app.pages;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.ContinentalLoginNativePage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.LoginPage;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class ContinentalLoginPage extends FlutterBasePage {

    private static ContinentalLoginPage obj;
    public static ContinentalLoginPage getInstance(){
        if(obj==null)
            obj = new ContinentalLoginPage();
        return obj;
    }

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub
    }

    @FindBy(locator = "continental.email.field")
    public CustomFlutterElement emailField;

    @FindBy(locator = "continental.pwd.field")
    public CustomFlutterElement pwdField;

    @FindBy(locator = "continental.login.btn")
    public CustomFlutterElement loginBtn;

    @FindBy(locator = "continental.forgot.btn")
    public CustomFlutterElement forgotPwdBtn;

    @FindBy(locator = "continental.activate.btn")
    public CustomFlutterElement activateAcctBtn;

    @FindBy(locator = "activate.email.field")
    public CustomFlutterElement activateEmailField;

    @FindBy(locator = "activate.code.field")
    public CustomFlutterElement activateCodeField;

    @FindBy(locator = "activate.verify.btn")
    public CustomFlutterElement activateVerifyBtn;

    @FindBy(locator = "activate.success.message")
    public CustomFlutterElement activateSuccessMsg;

    @FindBy(locator = "forgot.email.field")
    public CustomFlutterElement forgotEmailField;

    @FindBy(locator = "forgot.submit.btn")
    public CustomFlutterElement forgotSubmitBtn;

    @FindBy(locator = "continental.back.btn")
    public CustomFlutterElement backBtn;

    @FindBy(locator = "continental.error.message")
    public CustomFlutterElement continentalErrorMsg;

    @FindBy(locator = "continental.authenticationError.message")
    public CustomFlutterElement emailErrorMsg;
    @FindBy(locator = "continental.nullPasswordError.message")
    public CustomFlutterElement emptyPasswordErrorMsg;
    @FindBy(locator = "continental.welcome.header")
    public CustomFlutterElement continentalWelcomeHeader;

    @FindBy(locator = "continental.termsAndConditions.link")
    public CustomFlutterElement termsAndConditionsLink;
    @FindBy(locator = "continental.termsAndConditions.header")
    public CustomFlutterElement termsAndConditionsHeader;

    @FindBy(locator = "continental.forgot.page")
    public CustomFlutterElement forgotPwdPage;

    public boolean isContinentalPage() {
        return emailField.isPresent();
    }

    public void enterEmail(String email) {
        Validator.assertTrue(emailField.isVisible(),"Email field is not visible","Email field is visible");
        emailField.sendKeys(email);
    }

    public void enterPassword(String pwd) {
        Validator.assertTrue(pwdField.isVisible(),"Password field is not visible","Password field is visible");
        pwdField.sendKeys(pwd);
    }

    public boolean login(String email, String pwd) {
        apiBase.getLoginAPI(getBundle().getString("env.adminUsername"),getBundle().getString("env.adminPassword"));
        enterEmail(email);
        enterPassword(pwd);
        Validator.assertTrue(loginBtn.isVisible(),"Login button is not visible","Login button is visible");
        Validator.assertTrue(forgotPwdBtn.isVisible(),"Forgot Password button is not visible","Forgot Password  button is visible");
        Validator.assertTrue(activateAcctBtn.isVisible(),"Activate Account button is not visible","Activate Account button is visible");
        loginBtn.click();
        return DashboardPage.getInstance().isHomePage();
    }

    public boolean verifyUser(String email) {
        String otp;
        otp = MiscUtils.getOtpfromMail(MiscUtils.getLatestEmailBody(email));
        System.out.println(otp);
        activateAcctBtn.click("Activate Button");
        activateEmailField.sendKeys(email,"Activate Email Field");
        activateCodeField.sendKeys(otp,"Activate Code Field");
        activateVerifyBtn.click("Verify User Button");
        Validator.assertTrue(activateSuccessMsg.waitForTheElementToBeVisible(10,"Activate Success Message"),"Activate success message was not displayed","Activate success message verified successfully");
        return loginBtn.isVisible("Login Email Field");
    }

    public void goBackToContinentalLoginPage() {
        backBtn.click();
    }

    public void verifyUserNameAndPasswordFieldsExists() {
        emailField.waitForTheElementToBeVisible(5000);
        Validator.assertTrue(emailField.isVisible(),"Email field is not visible","Email field is visible");
        Validator.assertTrue(pwdField.isVisible(),"Password field is not visible","Password field is visible");
    }
    public void clickOnBackBtn() {
        backBtn.click();
    }

    public void loginWithEmailAndPassword(String email, String pwd) {
        apiBase.getLoginAPI(getBundle().getString("env.adminUsername"),getBundle().getString("env.adminPassword"));
        enterEmail(email);
        enterPassword(pwd);
        Validator.assertTrue(loginBtn.isVisible(),"Login button is not visible","Login button is visible");
        Validator.assertTrue(forgotPwdBtn.isVisible(),"Forgot Password button is not visible","Forgot Password  button is visible");
        Validator.assertTrue(activateAcctBtn.isVisible(),"Activate Account button is not visible","Activate Account button is visible");
        loginBtn.click();
    }
    public void verifyEmailErrorMsg() {
        Validator.assertTrue(emailErrorMsg.isVisible(),"Email Error Message is not visible","Email Error Message is visible");
    }
    public void clickForgotPasswordBtn() {
        Validator.assertTrue(forgotPwdBtn.isVisible(),"Forgot Password Button is not visible","Forgot Password Button is visible");
        forgotPwdBtn.click();
        Validator.assertTrue(forgotPwdPage.isVisible(),"Forgot Password Page is not visible","Forgot Password Page is visible");
        Validator.assertTrue(forgotEmailField.isVisible(),"Forgot Password Page Email field is not visible","Forgot Password Page Email field is visible");
    }
    public void enterTheEmailForForgotPassword(String email) {
        Validator.assertTrue(forgotEmailField.isVisible(),"Forgot Password Page Email field is not visible","Forgot Password Page Email field is visible");
        forgotEmailField.sendKeys(email);
        Validator.assertTrue(forgotEmailField.getText().contains(email),"Email cant be entered","Email can be enetered");
    }

    public void btnLoginClick()
    {
        Validator.assertTrue(loginBtn.isVisible(),"Login button is not visible","Login button is visible");
        loginBtn.click();
        SyncUtil.waitFor(3000);
    }

    public void loginBtnClickAndVerifyErrorMessage()
    {
        btnLoginClick();
        emailErrorMsg.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(emailErrorMsg.isVisible(),"User does not get an error message","User gets an error message");
    }
    public void loginWithBlankPwd(String email)
    {
        apiBase.getLoginAPI(getBundle().getString("env.adminUsername"),getBundle().getString("env.adminPassword"));
        enterEmail(email);
    }
    public void btnLoginClickAndVerifyBlankPwd()
    {
        btnLoginClick();
        emptyPasswordErrorMsg.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(emptyPasswordErrorMsg.isVisible(),"User does not get an error message for blank password","User gets  an error message for blank password");
    }
    public void termsAndConditionsClick()
    {
        termsAndConditionsLink.waitForTheElementToBeVisible(10000);
        termsAndConditionsLink.click("termsAndConditionsLink");
    }
    public void verifyTermsAndConditionsPage()
    {
        SyncUtil.waitFor(10000);
        termsAndConditionsHeader.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(termsAndConditionsHeader.isVisible(),"User is not navigated to the Terms and Conditions page","User is navigated to the Terms and Conditions page");
        ContinentalLoginNativePage.getInstance().verifyTermsAndConditionDetails();

    }
}
