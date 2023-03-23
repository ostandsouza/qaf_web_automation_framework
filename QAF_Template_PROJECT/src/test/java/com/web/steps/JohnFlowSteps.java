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

//    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with {CustCorpName} and {CustCorpAddress}")
//    public void showListOfCustomerCorporatesAndUsersAsTerritoryManager(String CustCorpName, String CustCorpAddress){
//        demopage.showconveyorssitescorporatesandusers(CustCorpName,CustCorpAddress);
//    }
//
//    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Distributor Corporate with {DistCorpName} and {DistCorpAddress}")
//    public void showListOfDistCorporatesAndUsersAsTerritoryManager(String DistCorpName, String DistCorpAddress){
//        demopage.showconveyorssitescorporatesandusers(DistCorpName,DistCorpAddress);
//    }
//
//    @QAFTestStep(description="Create a conveyor {ConveyorNameInd} at {DistShopIndName} and {CustSiteIndName}")
//    public void createAConveyorC2GermanyAtMiningCorpGermany(String ConveyorNameInd, String DistShopIndName, String CustSiteIndName){
//        demopage.createConveyorGermany(ConveyorNameInd, DistShopIndName, CustSiteIndName);
//    }
//
//    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with {CustCorpName} and {CustCorpAddress}")
//    public void showListOfCustomerCorporatesAsTerritoryManager(String CustCorpName, String CustCorpAddress){
//        demopage.showconveyorssitescorporatesandusers(CustCorpName,CustCorpAddress);
//    }
}