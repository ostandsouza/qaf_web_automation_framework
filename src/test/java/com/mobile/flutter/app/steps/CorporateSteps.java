package com.mobile.flutter.app.steps;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.pages.CorporatePage;
import com.mobile.flutter.app.pages.DashboardPage;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

public class CorporateSteps {

    @QAFTestStep(description = "User navigates to add corporate screen with {CorpName} and {EditDistCorpName}")
    public void addCorpNavigation(String corpName, String editDistCorpName) {
        String companyId = DashboardPage.getInstance().apiBase.getCompanyID(DashboardPage.getInstance().apiBase.getCompanyAPI(corpName));
        DashboardPage.getInstance().apiBase.deleteCompanyAPI(companyId);
        companyId = DashboardPage.getInstance().apiBase.getCompanyID(DashboardPage.getInstance().apiBase.getCompanyAPI(editDistCorpName));
        DashboardPage.getInstance().apiBase.deleteCompanyAPI(companyId);
        DashboardNativePage.getInstance().refreshPage();
        Validator.assertTrue(DashboardPage.getInstance().goToAddCorp(),"Add corporate is not visible","Add corporate page is visible");
    }

    @QAFTestStep(description = "Add Distributor corporate with {CorpName} {Address}")
    public void verifyAddCorporateDistributor(String corpName, String address) {
        Validator.assertTrue(CorporatePage.getInstance().addDistributorCorpDetails(corpName, address),"New distributor corporate was not created","New distributor corporate was created successfully");
    }

    @QAFTestStep(description = "Navigate to corporate list and verify {CorpName} is present")
    public void verifyCorporateCreation(String corpName) {
        Validator.assertTrue(CorporatePage.getInstance().verifyCorpCreation(corpName),"Newly added corporate was not created","Newly added corporate was created successfully");
    }

    @QAFTestStep(description = "Verify user is able to edit corporate with {DistCorpName}")
    public void verifyCorporateEdit(String corpName) {
        CorporatePage.getInstance().goToCorporateDetails();
        Validator.assertTrue(!CorporatePage.getInstance().verifyEditStatus(),"Newly added corporate able to edit when no permission","Newly added not able corporate able to edit when no permission");
    }

    @QAFTestStep(description = "Verify user is able to edit corporate name {EditDistCorpName} and {EditDistCorpAddress}")
    public void verifyCorporateEditName(String editDistCorpName, String editDistCorpAddress) {
        CorporatePage.getInstance().goToCorporateDetails();
        Validator.assertTrue(CorporatePage.getInstance().goToCorporateEditScreen(),"Newly added corporate not able to edit with edit permission","Newly added corporate able to edit when edit permission");
        Validator.assertTrue(CorporatePage.getInstance().updateCorporateName(editDistCorpName,editDistCorpAddress),"Not able to update corporate name","Able to update corporate name");
    }

    @QAFTestStep(description = "Verify the corporate count")
    public void verifyCorporateCount() {
        Validator.assertTrue(CorporatePage.getInstance().getCorporateCount().equals( "0"),"Showing incorrect associated corporate site/shop count","Showing correct associated corporate site/shop count");
    }

    @QAFTestStep(description = "Go back from corporate details screen")
    public void verifyCorporateNavigation() {
        Validator.assertTrue(CorporatePage.getInstance().goBackToCorporateListScreen(),"Unable to navigate to corporate list screen from details screen","Able to navigate to corporate list screen from details screen");
    }

    @QAFTestStep(description = "Go back from corporate card screen")
    public void verifyCorporateCardNavigation() {
        CorporatePage.getInstance().goBackToCorporateCardScreen();
    }

    @QAFTestStep(description = "Apply filter with distributor corporate type as {EditDistCorpName}")
    public void verifyDistributorCorporateFilter(String editDistCorpName) {
        Validator.assertTrue(DashboardNativePage.getInstance().goToFilterScreen(),"Not able to open filter screen for corporate list page","Successfully able to navigate to corporate list screen");
        DashboardNativePage.getInstance().filterDescendingOrder();

        DashboardNativePage.getInstance().filterDistributorCorporate();
        Validator.assertTrue(DashboardNativePage.getInstance().filterCorporateFromDropdown(editDistCorpName),"Filter corporate multiselect not working as expected","Filter corporate multiselect is working as expected");
//        Validator.assertTrue(DashboardNativePage.getInstance().saveFilter(),"Unable to save filter changes in corporate screen","Able lto save filter changes in corporate screen");
    }

    @QAFTestStep(description = "Apply filter with customer corporate type as {EditDistCorpName}")
    public void verifyCustomerCorporateFilter(String editDistCorpName) {
        Validator.assertTrue(DashboardNativePage.getInstance().goToFilterScreen(),"Not able to open filter screen for corporate list page","Successfully able to navigate to corporate list screen");
        DashboardNativePage.getInstance().filterDescendingOrder();
        DashboardNativePage.getInstance().filterCustomerCorporate();
        Validator.assertTrue(DashboardNativePage.getInstance().filterCorporateFromDropdown(editDistCorpName),"Filter corporate multiselect not working as expected","Filter corporate multiselect is working as expected");
//        Validator.assertTrue(DashboardNativePage.getInstance().saveFilter(),"Unable lto save filter changes in corporate screen","Able lto save filter changes in corporate screen");
    }


    @QAFTestStep(description = "Verify the corporate result count with filter")
    public void verifyCorporateSearchResultWithFilter() {
        Validator.assertTrue(DashboardNativePage.getInstance().getSearchCount().equals("1"),"After applying filter corporate list screen count is not impacted","After applying filter corporate list screen is showing filtered count");
    }

    @QAFTestStep(description = "Reset the filter")
    public void verifyResetFilter() {
        Validator.assertTrue(DashboardNativePage.getInstance().resetFilter(),"Unable to reset filter","Reset filter is working as expected");
    }

    @QAFTestStep(description = "Verify the corporate result count without filter")
    public void verifyCorporateSearchResultWithoutFilter() {
        Validator.assertTrue(!(DashboardNativePage.getInstance().getSearchCount().equals("1")),"After reset filter corporate list screen not showing all records","After reset filter corporate list screen showing all records");
    }

    @QAFTestStep(description = "Add Customer corporate with {CustCorpName} {CustCorpAddress}")
    public void verifyAddCorporateCustomer(String corpName, String address) {
        Validator.assertTrue(CorporatePage.getInstance().addCustomerCorpDetails(corpName, address),"New customer corporate was not created","New customer corporate was created successfully");
    }

    @QAFTestStep(description = "Add distributor shop with {DistShopName} {DistShopAddress} {DistCorpName} {Territory} {Manager}")
    public void verifyAddCDistributorShop(String shopName, String address, String distCorp, String territory, String manager) {
        Validator.assertTrue(CorporatePage.getInstance().addShop(shopName, address, distCorp, territory, manager),"New distributor shop was not created","New distributor shop was created successfully");
    }

    @QAFTestStep(description = "Add customer site with {CustSiteName} {CustSiteAddress} {CustCorpName} {DistShopName} {Territory} {Manager}")
    public void verifyAddCustomerSite(String siteName, String address, String customerCorp,  String shop, String territory, String manager) {
        Validator.assertTrue(CorporatePage.getInstance().addSite(siteName, address, customerCorp, territory, manager, shop),"New customer site was not created","New customer site was created successfully");
    }

    @QAFTestStep(description = "User navigates to add site/shop screen with {CustSiteName} and {EditCustSiteName}")
    public void addSiteShopNavigation(String custSiteName, String editCustSiteName) {
        String companyId = DashboardPage.getInstance().apiBase.getCompanyID(DashboardPage.getInstance().apiBase.getCompanyAPI(custSiteName));
        DashboardPage.getInstance().apiBase.deleteCompanyAPI(companyId);
        companyId = DashboardPage.getInstance().apiBase.getCompanyID(DashboardPage.getInstance().apiBase.getCompanyAPI(editCustSiteName));
        DashboardPage.getInstance().apiBase.deleteCompanyAPI(companyId);
        DashboardNativePage.getInstance().refreshPage();
        Validator.assertTrue(DashboardPage.getInstance().goToSiteShop(),"Add Site/Shop page is not visible","Add Site/Shop page is visible");
    }

    @QAFTestStep(description = "User navigates to add conveyor with {ConveyorName} {EditConveyorName}")
    public void addConveyorNavigation(String conveyorName, String editConveyorName) {
        String conveyorId = DashboardPage.getInstance().apiBase.getConveyorsAPI(conveyorName);
        DashboardPage.getInstance().apiBase.deleteConveyorAPI(conveyorId);
        conveyorId = DashboardPage.getInstance().apiBase.getConveyorsAPI(editConveyorName);
        DashboardPage.getInstance().apiBase.deleteConveyorAPI(conveyorId);
        DashboardNativePage.getInstance().refreshPage();
        Validator.assertTrue(DashboardPage.getInstance().goToConveyor(),"Add Conveyor page is not visible","Add Conveyor page is visible");
    }

    @QAFTestStep(description = "User navigates to add inspection with {InspectionName} {EditInspectionName}")
    public void addInspectionNavigation(String inspectionName, String editInspectionName) {
        String inspectionId = DashboardPage.getInstance().apiBase.getInspectionAPI(inspectionName);
        DashboardPage.getInstance().apiBase.deleteInspectionAPI(inspectionId);
        inspectionId = DashboardPage.getInstance().apiBase.getInspectionAPI(editInspectionName);
        DashboardPage.getInstance().apiBase.deleteInspectionAPI(inspectionId);
        DashboardNativePage.getInstance().refreshPage();
        Validator.assertTrue(DashboardPage.getInstance().goToInspection(),"Add Inspection page is not visible","Add Conveyor page is visible");
    }

    @QAFTestStep(description = "Navigate to corporate details screen and verify {DistShopName} is present and associated count {count}")
    public void verifyCorporateDetailsScreen(String distShopName, String count) {
        DashboardNativePage.getInstance().navigateInsideCorp();
        System.out.println(count);
        System.out.println(CorporatePage.getInstance().getCorporateCount());
        Validator.assertTrue(CorporatePage.getInstance().getCorporateCount().equals(count),"Shop/Site count is not matching","Shop/Site count is verified successfully");
    }

    @QAFTestStep(description = "Verify user is able to edit shop name {DistShopName} to {EditDistShopName} and {EditDistShopAddress}")
    public void verifyShopEditName(String distShopName,String editDistCorpName, String editDistCorpAddress) {
        Validator.assertTrue(CorporatePage.getInstance().goToSiteShopCard(distShopName).equals(distShopName),"Site/Shop card name mismatch","Site/Shop card name verification successful");
        Validator.assertTrue(CorporatePage.getInstance().getCorporateCount().equals("0"),"Site/Shop count mismatch","Site/Shop count verification successful");
        CorporatePage.getInstance().goToSiteShopDetails();
        Validator.assertTrue(CorporatePage.getInstance().goToCorporateEditScreen(),"Newly added corporate shop/site able to edit with edit permission","Newly added corporate shop/site able to edit when edit permission");
        Validator.assertTrue(CorporatePage.getInstance().updateCorporateName(editDistCorpName,editDistCorpAddress),"Not able to update corporate shop/site name","Able to update corporate shop/site name");
    }

    @QAFTestStep(description = "Close search box from site/shop screen")
    public void closeSearch() {
        CorporatePage.getInstance().closeSearch();
    }


    @QAFTestStep(description="Verify the site filter result for {0}")
    public void verifyTheSiteFilterResultFor(String distShopName){
        Validator.assertTrue(DashboardNativePage.getInstance().getFirstSearchSiteShop().contains(distShopName),"Shop/Site name is not matching after applying filter","Shop/Site name is verified successfully after applying filter");
    }

    @QAFTestStep(description = "Apply filter with corporate type as {EditDistCorpName}")
    public void verifyCorporateFilter(String editDistCorpName) {
        Validator.assertTrue(DashboardNativePage.getInstance().goToFilterScreen(),"Not able to open filter screen for corporate list page","Successfully able to navigate to corporate list screen");
        DashboardNativePage.getInstance().filterDescendingOrder();

        Validator.assertTrue(DashboardNativePage.getInstance().saveFilter(),"Unable to save filter changes in corporate screen","Able lto save filter changes in corporate screen");
    }


}
