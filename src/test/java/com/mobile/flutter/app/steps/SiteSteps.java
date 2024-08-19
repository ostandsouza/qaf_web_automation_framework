package com.mobile.flutter.app.steps;

import com.mobile.flutter.app.pages.ConveyorPage;
import com.mobile.flutter.app.pages.CorporatePage;
import com.mobile.flutter.app.pages.DashboardPage;
import com.mobile.flutter.app.pages.SitePage;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

public class SiteSteps {

    CorporatePage corporatePage=new CorporatePage();
    SitePage sitePage=new SitePage();
    DashboardNativePage dashboardNativePage=new DashboardNativePage();

    @QAFTestStep(description="Navigate to Add Site Page")
    public void navigateToTheAddSitePage() {
      sitePage.addSiteBtnClick();
      sitePage.isAddSitePage();
    }

    @QAFTestStep(description="Verify back button is visible next to add site heading")
    public void verifySiteBackBtn(){
        sitePage.verifyAddSiteBackBtnVisible();
    }


    @QAFTestStep(description="Click on Add Site back button and verify it navigates to corporate list page")
    public void clickAndVerifyAddSiteBackBtnFunctionality(){
    sitePage.siteBackBtnClick();
    DashboardNativePage.getInstance().isCorporateList();
    }

    @QAFTestStep(description="Navigate to the site list and verify {CustSiteName} is present")
    public void clickAndVerifySiteCard(String siteName) {
        DashboardPage.getInstance().siteTileClick();
//        Validator.assertTrue(CorporatePage.getInstance().verifySiteShopList(siteName),"Site name is not present in the site list","Site name is  present in the site list" );
        Validator.assertTrue(SitePage.getInstance().verifySiteCreation(siteName),"Site name is not present in the site list","Site name is present in the site list");
    }

    @QAFTestStep(description="Click on {CustSiteName} site name and verify it navigates to details screen and verify the heading")
    public void clickAndVerifySiteHeading(String companyName){
        SitePage.getInstance().siteNameClick();
        corporatePage.verifyCompanyHeading(companyName);
    }

    @QAFTestStep(description="Click on site card and verify it navigates to company detail page")
    public void clickAndVerifyCompanyDetailPage(){
        corporatePage.companyCardClick();
        corporatePage.verifyIsDetailPage();
    }

    @QAFTestStep(description="Click on three dots next to conveyors {conveyorName} and verify edit/delete option is visible")
    public void clickOnEditDeleteConveyor(String conveyorName){
//        DashboardNativePage.getInstance().goToSearch();
        CorporatePage.getInstance().verifyConveyorList(conveyorName);
        SitePage.getInstance().btnEditDeleteClickAndVerify();
    }
    @QAFTestStep(description ="Click on edit button and verify it navigates to edit conveyor page")
    public void clickAndVerifyEditConveyorPage()
    {
        SitePage.getInstance().editBtnClick();
        Validator.assertTrue(SitePage.getInstance().verifyIsConveyorEditPage(),"User is not navigated to conveyor details page","User is navigated to conveyor details page");
    }

    @QAFTestStep(description ="Change the conveyor name {EditConveyorName} and save then verify user navigates to {CustSiteName} site details page")
    public void editConveyorName(String conveyorName,String siteName)
    {
        ConveyorPage.getInstance().editConveyorName(conveyorName);
        Validator.assertTrue(CorporatePage.getInstance().verifyCompanyHeading(siteName),"User is not in Site list page","User is in Site list page");
    }
    @QAFTestStep(description ="Verify updated conveyor name {EditConveyorName} is present in the list")
    public void verifyUpdatedConveyor(String conveyorName)
    {
        DashboardNativePage.getInstance().goToSearch();
        Validator.assertTrue(CorporatePage.getInstance().verifyConveyorList(conveyorName),"The conveyor name is not updated","The conveyor name is updated");

    }



}
