package com.web.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.DashboardPage;
import com.web.pages.LoginPage;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @QAFTestStep(description = "User is at Login page")
    public void verifyUserIsAtLoginPage() {
        loginPage.verifyTitle("Conti+");
    }

    @QAFTestStep(description = "Login with {UserName} and {Password}")   
     public void loginWithAnd(String UserName, String Password) {
        loginPage.loginToApp(UserName, Password);
        dashboardPage.handleCookiePopup();
    }

    @QAFTestStep(description="Verify Home page is displayed")
    public void verifyHomePageIsDisplayed(){
    	
    	if (loginPage.getCurrentURL().endsWith("/secure/dashboard/conveyors"))
            Reporter.log("Home page is displayed", MessageTypes.Pass);
        else
            Reporter.log("Home page is not displayed", MessageTypes.Fail);
    	SyncUtil.waitFor(3000);
    }

//    @QAFTestStep(description = "Login with normal user {UserName} and {Password}")
//    public void loginWith(String UserName, String Password) {
//        String otp;
//        String userid = loginPage.apiBase.getUserProfileAPI(UserName);
//        if(!loginPage.apiBase.getUserAPI(userid)) {
//            if (!MiscUtils.isNewEmailTriggered(UserName)) {
//                otp = MiscUtils.getOtpfromMail(MiscUtils.getLatestEmailBody(UserName));
//                if (loginPage.apiBase.secretVerifyAPI(UserName, otp) != 200) {
//                    loginPage.apiBase.resendVerifyAPI(UserName);
//                    if (!MiscUtils.isNewEmailTriggered(UserName)) {
//                        otp = MiscUtils.getOtpfromMail(MiscUtils.getLatestEmailBody(UserName));
//                        loginPage.apiBase.secretVerifyAPI(UserName, otp);
//                    }
//                }
//            } else {
//                loginPage.apiBase.resendVerifyAPI(UserName);
//                otp = MiscUtils.getOtpfromMail(MiscUtils.getLatestEmailBody(UserName));
//                loginPage.apiBase.secretVerifyAPI(UserName, otp);
//            }
//        }
//        loginPage.loginToApp(UserName, Password);
////        if(loginPage.apiBase.isFirstSignIn(UserName)){
////        }
//
//        dashboardPage.handleCookiePopup();
//    }

    @QAFTestStep(description = "Login with normal user {UserName} and {Password}")
    public void loginWith(String UserName, String Password) {
        String otp;
        String userid = loginPage.apiBase.getUserProfileAPI(UserName);
        if(!loginPage.apiBase.getUserAPI(userid)) {
            if (!MiscUtils.isNewEmailTriggered(UserName)) {
                otp = MiscUtils.getOtpfromMail(MiscUtils.getLatestEmailBody(UserName));
                if (loginPage.apiBase.secretVerifyAPI(UserName, otp) != 200) {
                    loginPage.apiBase.resendVerifyAPI(UserName);
                    if (!MiscUtils.isNewEmailTriggered(UserName)) {
                        otp = MiscUtils.getOtpfromMail(MiscUtils.getLatestEmailBody(UserName));
                        loginPage.apiBase.secretVerifyAPI(UserName, otp);
                    }
                }
            } else {
                loginPage.apiBase.resendVerifyAPI(UserName);
                otp = MiscUtils.getOtpfromMail(MiscUtils.getLatestEmailBody(UserName));
                loginPage.apiBase.secretVerifyAPI(UserName, otp);
            }
        }
        loginPage.loginToApp(UserName, Password);
        System.out.println("first login");
        if(loginPage.apiBase.isFirstSignIn(UserName)) {
            loginPage.changePassword(Password, Password, Password);//
//             loginPage.loginToApp(UserName, Password);
             }
             System.out.println("before handlecookiepopup");
             dashboardPage.handleCookiePopup();
             System.out.println("after handlecookiepopup");
    }



}
