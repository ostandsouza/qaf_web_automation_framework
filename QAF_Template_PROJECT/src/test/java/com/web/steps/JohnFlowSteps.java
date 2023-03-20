package com.web.steps;

import com.common.utils.APIBase;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.DashboardPage;
import com.web.pages.DemoPage;
import com.web.pages.LoginPage;
import com.web.pages.UsersPage;

public class JohnFlowSteps {

    APIBase api;
    LoginPage loginPage = new LoginPage();

    UsersPage userpage = new UsersPage();
    DemoPage demopage = new DemoPage();

    DashboardPage dashboardpage = new DashboardPage();

    @QAFTestStep(description = "User is at Login page")
    public void verifyUserIsAtLoginPage() {
        loginPage.verifyTitle("Conti+");
    }

    @QAFTestStep(description = "Login with {UserName} and {Password}")
    public void loginWithAnd(String UserName, String Password) {
        loginPage.loginToApp(UserName, Password);
        dashboardpage.handleCookiePopup();
    }

    @QAFTestStep(description = "Check profile")
    public void checkProfile() {
        demopage.goToUserProfile();
        if (loginPage.getCurrentURL().endsWith("#/secure/users/user-profile"))
            Reporter.log("profile page is displayed", MessageTypes.Pass);
        else
            Reporter.log("profile page is not displayed", MessageTypes.Fail);
    }

    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with {CustCorpName} and {CustCorpAddress}")
    public void showListOfCustomerCorporatesAndUsersAsAnAdmin(String CustCorpName, String CustCorpAddress){
        demopage.showconveyorssitescorporatesandusers(CustCorpName,CustCorpAddress);
    }

    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Distributor Corporate with {DistCorpName} and {DistCorpAddress}")
    public void showListOfDistCorporatesAndUsersAsAnAdmin(String DistCorpName, String DistCorpAddress){
        demopage.showconveyorssitescorporatesandusers(DistCorpName,DistCorpAddress);
    }

    @QAFTestStep(description="Create a conveyor {ConveyorNameInd} at {DistShopIndName} and {CustSiteIndName}")
    public void createAConveyorC2GermanyAtMiningCorpGermany(String ConveyorNameInd, String DistShopIndName, String CustSiteIndName){
        demopage.createConveyorGermany(ConveyorNameInd, DistShopIndName, CustSiteIndName);
    }

    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with {CustCorpName} and {CustCorpAddress}")
    public void showListOfCustomerCorporatesAsAnAdmin(String CustCorpName, String CustCorpAddress){
        demopage.showconveyorssitescorporatesandusers(CustCorpName,CustCorpAddress);
    }
}