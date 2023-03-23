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

//    @QAFTestStep(description = "User is at Login page")
//    public void verifyUserIsAtLoginPage() {
//        loginPage.verifyTitle("Conti+");
//    }
//    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with {CustCorpName} and {CustCorpAddress}")
//    public void showListOfCustomerCorporatesAndUsersAsAnAdmin(String CustCorpName, String CustCorpAddress){
//        demopage.showconveyorssitescorporatesandusers(CustCorpName,CustCorpAddress);
//    }

}