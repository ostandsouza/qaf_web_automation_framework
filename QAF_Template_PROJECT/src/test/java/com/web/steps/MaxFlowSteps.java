package com.web.steps;

import com.common.utils.APIBase;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.*;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class MaxFlowSteps {

    APIBase api;
    LoginPage loginPage = new LoginPage();

    UsermanagementPage uManagementPage = new UsermanagementPage();
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

    @QAFTestStep(description="Create a conveyor {ConveyorNameGer} at {DistShopGerName} and {CustSiteGerName}")
    public void createAConveyorC2GermanyAtMiningCorpGermany(String ConveyorNameGer, String DistShopGerName, String CustSiteGerName){
        demopage.createConveyorGermany(ConveyorNameGer, DistShopGerName, CustSiteGerName);
    }

    @QAFTestStep(description="Create a Distributor User for Germany {FullNameDistGer} and {Phone} and {EmailDistGer} and {ProfileType} and {UserPassword} and {RetypePassword}  and {CoporateRole} and {DistCorpName} and {DistShopGerName} and {CustSiteGerName}")
    public void createATerritoryManagerForIndiaJohnDoe(String FullNameInd,String Phone,String EmailInd, String ProfileType,String UserPassword,String RetypePassword, String CoporateRole, String DistCorpName, String DistShopGerName, String CustSiteGerName) {
        getBundle().setProperty("email.ind", EmailInd);
        userpage.usersclick();
        userpage.Addclick();
        userpage.setfullname(FullNameInd);
        userpage.setPhone("+91",Phone);
        userpage.setemail(EmailInd);
        userpage.setprofiletype(ProfileType);
        userpage.setpassword(UserPassword);
        userpage.setretypepassword(RetypePassword);
        userpage.distributorInformation(DistCorpName,CoporateRole);
        userpage.Nextclick();
        uManagementPage.DistributorAssignment(DistShopGerName,CustSiteGerName);
        userpage.setPermission();
        userpage.Clicksaveandclose();
    }

    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with {CustCorpName} and {CustCorpAddress}")
    public void showListOfCustomerCorporatesAsAnAdmin(String CustCorpName, String CustCorpAddress){
        demopage.showconveyorssitescorporatesandusers(CustCorpName,CustCorpAddress);
    }
}