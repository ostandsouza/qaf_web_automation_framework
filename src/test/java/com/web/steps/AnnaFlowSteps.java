package com.web.steps;

import com.common.utils.APIBase;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.*;

public class AnnaFlowSteps {

    APIBase api;
    LoginPage loginPage = new LoginPage();

    UsermanagementPage uManagementPage = new UsermanagementPage();
    UsersPage userpage = new UsersPage();
    DemoPage demopage = new DemoPage();

    DashboardPage dashboardpage = new DashboardPage();
//
//    @QAFTestStep(description = "Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with {CustCorpName} and {CustCorpAddress}")
//    public void showListOfCustomerCorporatesAndUsersAsAnAdmin(String CustCorpName, String CustCorpAddress) {
//        demopage.showconveyorssitescorporatesandusers(CustCorpName, CustCorpAddress);
//    }
//
//    @QAFTestStep(description = "Show list of conveyors, sites, corporates and users as an admin for Distributor Corporate with {DistCorpName} and {DistCorpAddress}")
//    public void showListOfDistCorporatesAndUsersAsAnAdmin(String DistCorpName, String DistCorpAddress) {
//        demopage.showconveyorssitescorporatesandusers(DistCorpName, DistCorpAddress);
//    }
}