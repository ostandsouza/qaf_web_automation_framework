package com.mobile.flutter.app.pages;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.DashboardNativePage;
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

    @FindBy(locator = "dashboard.loading.animation")
    public CustomFlutterElement loadingDashboard;

    public boolean isContinentalPage() {
        return emailField.isVisible();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String pwd) {
        pwdField.sendKeys(pwd);
    }

    public boolean login(String email, String pwd) {
        apiBase.getLoginAPI(getBundle().getString("env.adminUsername"),getBundle().getString("env.adminPassword"));
        enterEmail(email);
        enterPassword(pwd);
        loginBtn.click();
        boolean flag =  DashboardPage.getInstance().isHomePage();
////        driver.executeScript("flutter:setFrameSync", true, 5);
//        if(flag)
            loadingDashboard.waitForTheElementToBeVisible(30);
        loadingDashboard.waitForTheElementToBeInvisible(70);
        return flag;
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

}
