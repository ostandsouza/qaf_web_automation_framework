package com.web.steps;

import com.common.utils.APIBase;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.DashboardPage;
import com.web.pages.DemoPage;
import com.web.pages.LoginPage;
import com.web.pages.UsersPage;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class EditFlowSteps {

    APIBase api;
    LoginPage loginPage = new LoginPage();

    UsersPage userpage = new UsersPage();
    DemoPage demopage = new DemoPage();

    DashboardPage dashboardpage = new DashboardPage();

//    @QAFTestStep(description = "User is at Login page")
//    public void verifyUserIsAtLoginPage() {
//        loginPage.verifyTitle("Conti+");
//    }
//
//    @QAFTestStep(description = "Login with {UserName} and {Password}")
//    public void loginWithAnd(String UserName, String Password) {
//        loginPage.loginToApp(UserName, Password);
//        dashboardpage.handleCookiePopup();
//    }
//
//    @QAFTestStep(description="Check profile")
//    public void checkProfile(){
//        demopage.goToUserProfile();
//        if (loginPage.getCurrentURL().endsWith("#/secure/users/user-profile"))
//            Reporter.log("profile page is displayed", MessageTypes.Pass);
//        else
//            Reporter.log("profile page is not displayed", MessageTypes.Fail);
//    }
//
//    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with {CustCorpName} and {CustCorpAddress}")
//    public void showListOfCustomerCorporatesAndUsersAsAnAdmin(String CustCorpName, String CustCorpAddress){
//        demopage.showconveyorssitescorporatesandusers(CustCorpName,CustCorpAddress);
//    }
//
//    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Distributor Corporate with {DistCorpName} and {DistCorpAddress}")
//    public void showListOfDistCorporatesAndUsersAsAnAdmin(String DistCorpName, String DistCorpAddress){
//        demopage.showconveyorssitescorporatesandusers(DistCorpName,DistCorpAddress);
//    }
//
//    @QAFTestStep(description="Create a conveyor C2 Germany with {ConveyorNameGer} and {DistShopGerName} and {CustShopGerName}")
//    public void createAConveyorC2GermanyAtMiningCorpGermany(String ConveyorNameGer, String DistShopGerName, String CustShopGerName){
//        api = new APIBase();
//        String conveyorId = api.getConveyorAPI(ConveyorNameGer);
//        api.deleteConveyorAPI(conveyorId);
//        demopage.createConveyorGermany(ConveyorNameGer, DistShopGerName, CustShopGerName);
//    }
//
//    @QAFTestStep(description="Edit {ConveyorNameGer2} name to {ConveyorNameGer2Edit}")
//    public void editAConveyorC2GermanyAtMiningCorpGermany(String ConveyorNameGer1, String ConveyorNameGer1Edit){
//        demopage.editConveyorGermany(ConveyorNameGer1, ConveyorNameGer1Edit);
//    }
//
//    @QAFTestStep(description="Check {ConveyorNameGer2} at {CustCorpName}")
//    public void checkAConveyorC2GermanyAtMiningCorpGermany(String ConveyorNameGer2, String CustCorpName){
//        demopage.checkConveyorGermany(ConveyorNameGer2, CustCorpName);
//    }
//
//    @QAFTestStep(description="Check {ConveyorNameGer1} at {CustCorpName}")
//    public void editAConveyorCGermanyAtMiningCorpGermany(String ConveyorNameGer1, String ConveyorNameGer1Edit){
//        demopage.editConveyorGermany(ConveyorNameGer1, ConveyorNameGer1Edit);
//    }
//
//    @QAFTestStep(description="Edit {ConveyorNameGer1Edit} name to {ConveyorNameGer1}")
//    public void checkAConveyorCGermanyAtMiningCorpGermany(String ConveyorNameGer2, String CustCorpName){
//        demopage.checkConveyorGermany(ConveyorNameGer2, CustCorpName);
//    }

    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with {CustCorpName} and {CustCorpAddress}")
    public void showSitePageConveyorPage(){
//        api = new APIBase();
//        String userid = api.getUserProfileAPI((String) getBundle().getProperty("email.ind"));
//        api.deleteProfileAPI(userid);
//        api.deleteUserAPI(userid);
//        userid = api.getUserProfileAPI((String) getBundle().getProperty("email.ger"));
//        api.deleteProfileAPI(userid);
//        api.deleteUserAPI(userid);
    }
}
