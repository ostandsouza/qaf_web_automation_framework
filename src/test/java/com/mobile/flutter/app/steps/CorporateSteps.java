package com.mobile.flutter.app.steps;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.pages.ConveyorPage;
import com.mobile.flutter.app.pages.CorporatePage;
import com.mobile.flutter.app.pages.DashboardPage;
import com.mobile.flutter.app.pages.SitePage;
import com.mobile.nativectx.app.pages.CorporateNativePage;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

import java.time.Duration;

public class CorporateSteps {

    DashboardNativePage dashboardNativePage = new DashboardNativePage();
    CorporatePage corporatePage = new CorporatePage();

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

    @QAFTestStep(description = "Verify user is able to edit corporate name {EditDistCorpName} and {EditDistCorpAddress} and {EditTerritoryManager}")
    public void verifyCorporateEditName(String editDistCorpName, String editDistCorpAddress,String editTerritoryManager) {
        CorporatePage.getInstance().goToCorporateDetails();
        Validator.assertTrue(CorporatePage.getInstance().goToCorporateEditScreen(editDistCorpName),"Newly added corporate not able to edit with edit permission","Newly added corporate able to edit when edit permission");
        Validator.assertTrue(CorporatePage.getInstance().updateCorporateName(editDistCorpName,editDistCorpAddress,editTerritoryManager),"Not able to update corporate name","Able to update corporate name");
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

    @QAFTestStep(description = "Click on the filter Icon and select the corporate type and territory {territory} from the dropdown")
    public void selectTerritoryAndCorporateTypeFilter(String territory)
    {
        Validator.assertTrue(DashboardNativePage.getInstance().goToFilterScreen(),"Not able to open filter screen for corporate list page","Successfully able to navigate to corporate list screen");
        DashboardNativePage.getInstance().filterCustomerCorporate();
//      Validator.assertTrue(DashboardNativePage.getInstance().filterTerritoryDropDown(territory),"Filter market multiselect not working as expected","Filter market multiselect is working as expected");
        DashboardNativePage.getInstance().filterTerritoryDropDown(territory);
    }
    @QAFTestStep(description = "Click on Corporate dropdown and verify only the corporates {corp1} and {corp2} that belongs to selected market's and  corporate types are visible")
    public void clickCorpDdlAndVerifyList(String corp1,String corp2)
    {
        DashboardNativePage.getInstance().corpFilterDdlClick();
        DashboardNativePage.getInstance().verifyDdlCorporates(corp1,corp2);
    }

    @QAFTestStep(description = "Select the corporates {CustCorp} and {CustCorp2}  via checkbox and save and verify redirection to Corporate list page")
    public void selectCorpFilterAndVerify(String corp1,String corp2)
    {
        Validator.assertTrue(DashboardNativePage.getInstance().multipleFilterCorporateFromDropdown(corp1,corp2),"Filter corporate multiselect not working as expected","Filter corporate multiselect is working as expected");
        SyncUtil.waitFor(2000);

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

    @QAFTestStep(description = "Add customer site with {CustSiteName} {CustSiteAddress} {CustCorpName} {Territory} and verify that selected address  is displayed in the map")
    public void verifyAddressOfCustomerSite(String siteName, String address, String customerCorp, String territory) {
        CorporatePage.getInstance().verifyMapFields(siteName, address, customerCorp, territory);
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

    @QAFTestStep(description = "User navigates to add site/shop screen with {CustSiteName}")
    public void addSiteShopPageNavigation(String custSiteName) {
        String companyId = DashboardPage.getInstance().apiBase.getCompanyID(DashboardPage.getInstance().apiBase.getCompanyAPI(custSiteName));
        DashboardPage.getInstance().apiBase.deleteCompanyAPI(companyId);
        DashboardNativePage.getInstance().refreshPage();
        Validator.assertTrue(DashboardPage.getInstance().goToSiteShop(),"Add Site/Shop page is not visible","Add Site/Shop page is visible");
    }

    @QAFTestStep(description = "User navigates to add conveyor with {ConveyorName} {EditConveyorName}")
    public void addConveyorNavigation(String conveyorName, String editConveyorName) {
        String conveyorId = DashboardPage.getInstance().apiBase.getConveyorID(DashboardPage.getInstance().apiBase.getConveyorsAPI(conveyorName));
        DashboardPage.getInstance().apiBase.deleteConveyorAPI(conveyorId);
        conveyorId = DashboardPage.getInstance().apiBase.getConveyorID(DashboardPage.getInstance().apiBase.getConveyorsAPI(editConveyorName));
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

    @QAFTestStep(description = "Verify user is able to edit shop name {DistShopName} to {EditDistShopName} and {EditDistShopAddress} and {EditTerritoryManager}")
    public void verifyShopEditName(String distShopName,String editDistCorpName, String editDistCorpAddress, String editTerritory) {
        Validator.assertTrue(CorporatePage.getInstance().goToSiteShopCard(distShopName).equals(distShopName),"Site/Shop card name mismatch","Site/Shop card name verification successful");
        Validator.assertTrue(CorporatePage.getInstance().getCorporateCount().equals("0"),"Site/Shop count mismatch","Site/Shop count verification successful");
        CorporatePage.getInstance().goToSiteShopDetails();
        Validator.assertTrue(CorporatePage.getInstance().goToCorporateEditScreen(distShopName),"Newly added corporate shop/site able to edit with edit permission","Newly added corporate shop/site able to edit when edit permission");
        Validator.assertTrue(CorporatePage.getInstance().updateCorporateName(editDistCorpName,editDistCorpAddress,editTerritory),"Not able to update corporate shop/site name","Able to update corporate shop/site name");
    }

    @QAFTestStep(description = "Close search box from site/shop screen")
    public void closeSearch() {
        CorporatePage.getInstance().closeSearch();
    }


    @QAFTestStep(description="Verify the site filter result for {EditCustSiteName}")
    public void verifyTheSiteFilterResultFor(String distShopName){
        Validator.assertTrue(DashboardNativePage.getInstance().getFirstSearchSiteShop().contains(distShopName),"Shop/Site name is not matching after applying filter","Shop/Site name is verified successfully after applying filter");
    }

    @QAFTestStep(description = "Apply filter with corporate type as {EditDistCorpName}")
    public void verifyCorporateFilter(String editDistCorpName) {
        Validator.assertTrue(DashboardNativePage.getInstance().goToFilterScreen(),"Not able to open filter screen for corporate list page","Successfully able to navigate to corporate list screen");
        DashboardNativePage.getInstance().filterDescendingOrder();

        Validator.assertTrue(DashboardNativePage.getInstance().saveFilter(),"Unable to save filter changes in corporate screen","Able lto save filter changes in corporate screen");
    }

    @QAFTestStep(description="Verify that the corporate symbol is visible in the footer")
    public void verifyCorporateSymbolIsVisible(){
//        corporatePage.verifyCorpSymbolVisible();
        dashboardNativePage.companyLogoIsVisible();
    }

    @QAFTestStep(description="Verify the heading of corporate list page")
    public void verifyCorporateListHeading(){
        corporatePage.verifyCorporateHeader();
    }

    @QAFTestStep(description="Verify the fields in the header of the corporate list page")
    public void verifyCorporateListFields(){
        dashboardNativePage.verifyCorporateListHeaderFields();
    }


    @QAFTestStep(description = "User navigates to the Add Corporate Page with {DistCorpName}")
    public void addCorporatePageNavigation(String corpName) {
        SyncUtil.waitFor(30000);
        String companyId = DashboardPage.getInstance().apiBase.getCompanyID(DashboardPage.getInstance().apiBase.getCompanyAPI(corpName));
        DashboardPage.getInstance().apiBase.deleteCompanyAPI(companyId);
        DashboardNativePage.getInstance().refreshPage();
        Validator.assertTrue(DashboardPage.getInstance().goToAddCorp(),"Add corporate is not visible","Add corporate page is visible");
    }

    @QAFTestStep(description="Verify back button is visible next to add corporate heading")
    public void verifyBackBtn(){
        corporatePage.verifyBackBtnVisible();
    }


    @QAFTestStep(description="Click on back button and verify it navigates to corporate list page")
    public void clickAndVerifyBackBtnFunctionality(){
        corporatePage.goBackToCorporateListScreen();
    }


    @QAFTestStep(description="Click on type of company and verify the dropdown")
    public void clickAndVerifyCompanyDdl(){
        corporatePage.companyTypeClick();
        corporatePage.verifyCompanyTypeDdl();
    }

    @QAFTestStep(description="Verify user is able to select distributor corporate from the dropdown")
    public void selectDistCorpCompany(){
        corporatePage.selectDistCorporate();
    }

    @QAFTestStep(description="Verify user is able to select customer corporate from the dropdown")
    public void selectCustCorpCompany(){
        corporatePage.selectCustomerCorp();
    }



    @QAFTestStep(description="Create a distributor corporate with {CompanyName} {Address} and logo {CompanyLogo}")
    public void createDistributorCorporateAndVerify(String companyName,String address, String imageName){
        corporatePage.createDistributorCorp(companyName,address,imageName);
    }

    @QAFTestStep(description="Click on {DistCorpName} company name and verify it navigates to details screen and verify the heading")
    public void clickAndVerifyCompanyHeading(String companyName){
        corporatePage.companyNameClick();
        corporatePage.verifyCompanyHeading(companyName);
    }

    @QAFTestStep(description="Click on corporate card and verify it navigates to company detail page")
    public void clickAndVerifyCompanyDetailPage(){
        corporatePage.companyCardClick();
        corporatePage.verifyIsDetailPage();
    }

    @QAFTestStep(description="Verify the user filled details in company page {DistCorpName}")
    public void verifyAddCompanyDetails(String companyName){
        corporatePage.verifyCompanyDetails(companyName);
    }

    @QAFTestStep(description="Click on search icon and verify the placeholder and back button")
    public void clickAndVerifySearchIcon(){

        DashboardNativePage.getInstance().goToSearch();
        DashboardNativePage.getInstance().verifySearchFields();
    }
    @QAFTestStep(description="Search for the corporate {CustCorpName} and verify matched string is displayed")
    public void verifySearchString(String corpName){
        CorporatePage.getInstance().enterSearchQuery(corpName);
        CorporatePage.getInstance().verifyCorporateSearch(corpName);
    }
    @QAFTestStep(description="Search for a corporate {CustCorpName} and verify the fields in corporate list screen")
    public void verifyCorporateListScreenFields(String corpName){
        DashboardNativePage.getInstance().goToSearch();
        CorporatePage.getInstance().enterSearchQuery(corpName);
        CorporatePage.getInstance().verifyCorpListScreen();
    }
    @QAFTestStep(description="Verify the links displayed in the footer")
        public void verifyLinksInFooter() {
            DashboardNativePage.getInstance().verifyLinksInCorpFooter();}

    @QAFTestStep(description="Click on the links in the footer and verify it navigates to respective pages")
    public void clickAndVerifyLinksNavigation() {
        CorporatePage.getInstance().verifyLinksNavigation();
    }
    @QAFTestStep(description="Click on {CustCorpName} corporate  and verify it navigates to corporate details screen")
    public void clickAndVerifyCorpDetailsPage(String companyName){
        DashboardNativePage.getInstance().verifyCorpFirstSearch();
        CorporatePage.getInstance().verifyCompanyHeading(companyName);

    }
    @QAFTestStep(description = "Look for the data in Corporate List page and verify it shows only filtered data {CustCorp} and {CustCorp2}")
    public void verifyFilteredDataDisplay(String corp1,String corp2)
    {
        DashboardNativePage.getInstance().verifyFilteredCorp(corp1,corp2);
    }

    @QAFTestStep(description="Click on corporate symbol and verify it navigates to corporate list page")
    public void clickAndVerifyCorpListNavigation(){
        dashboardNativePage.corporateSymbolClick();
        corporatePage.verifyCorpListPageNavigation();
    }

    @QAFTestStep(description="Verify default type of site field is '${CompanyField}'")
    public void verifyTheDefaultTypeOfSiteField(String value){
        CorporatePage.getInstance().verifyDefaultSiteField(value);
    }


    @QAFTestStep(description="Navigate to add site page from Corporate list page")
    public void navigateToTheAddSitePage(){
        CorporatePage.getInstance().goToAddSiteFromCorpList();
    }

    @QAFTestStep(description = "Verify add corporate heading")
    public void verifyTheAddCorporateHeading() {
        Validator.assertTrue(CorporatePage.getInstance().verifyAddCorporateHeading(),"Add Corporate is not visible","Add Corporate is visible");
    }
    @QAFTestStep(description = "Verify add corporate fields")
    public void verifyTheAddCorporateFields() {
        CorporatePage.getInstance().verifyAddCorporateFields();
    }

    @QAFTestStep(description = "Go back to corporate list screen")
    public void verifyBackToTheConveyorListScreen() {
        Validator.assertTrue(CorporatePage.getInstance().goBackToCorporateListScreenfromAddScreen(),"Unable to navigate to corporate list screen from details screen","Able to navigate to corporate list screen from details screen");
    }

    @QAFTestStep(description = "Add a Distributor corporate with {CorpName} {Address}")
    public void verifyTheAddCorporateDistributor(String corpName, String address) {
        CorporatePage.getInstance().addDistributorCorporateDetails(corpName, address);
    }
    @QAFTestStep(description = "Verify duplicate corporate creation")
    public void verifyTheDuplicateCorporateCreation() {
        CorporatePage.getInstance().verifyDuplicateCorporateCreation();
    }


    @QAFTestStep(description="Verify default type of company field for Corporate")
    public void verifyTheDefaultTypeOfCompanyField(){
        CorporatePage.getInstance().verifyDefaultCompField();
    }
    @QAFTestStep(description="Verify default type of company field for Site")
    public void verifyTheDefaultTypeOfSiteField(){
        CorporatePage.getInstance().verifyDefaultSiteField();
    }

    @QAFTestStep(description = "Verify navigation to corporate details screen for {CorpName}")
    public void verifyNavigationToCorpDetails(String corpName) {
        Validator.assertTrue(CorporatePage.getInstance().searchCorpAndVerifyCreation(corpName),"Corporate not found","Corporate found");
        CorporatePage.getInstance().goToCorporateDetails();
        SitePage.getInstance().verifyDetailPageHeader(corpName);
    }

    @QAFTestStep(description = "Verify data displayed in the Corporate list screen")
    public void verifyTheDataInCorpListScreen() {
        CorporateNativePage.getInstance().verifyDataInCorpListScreen();
    }
    @QAFTestStep(description = "Extract the site count from corporate list page")
    public void extractTheCountInCorpListPage() {
        CorporatePage.getInstance().extractCountInCorpList();
//        CorporateNativePage.getInstance().extractCountInCorpList();

    }
    @QAFTestStep(description = "Navigate to {CorpName} detail Page and verify the site count in the corporate detail page")
    public void verifyTheCountInCorpDetailPage(String corpName) {
        DashboardNativePage.getInstance().navigateInsideCorp();
        SitePage.getInstance().verifyInfoPageHeader(corpName);
        CorporatePage.getInstance().verifyCountInCorpDetailPage();
    }
    @QAFTestStep(description="Click on filter icon")
    public void clickTheFilterIcon(){
        Validator.assertTrue(DashboardNativePage.getInstance().goToFilterScreen(),"Not able to open filter screen for corporate list page","Successfully able to navigate to corporate list screen");
    }

    @QAFTestStep(description="Verify fields in the filter pop up for corporate list")
    public void verifyTheFilterFieldsInCorpList(){
        CorporateNativePage.getInstance().verifyFilterFieldsInCorpList();

    }
    @QAFTestStep(description="Add descending order filter")
    public void addDescDistFilter(){
        DashboardNativePage.getInstance().filterDescendingOrder();
        DashboardNativePage.getInstance().saveFilter();
    }
    @QAFTestStep(description="Verify filter is applied")
    public void verifyTheFilterApplied(){
        CorporateNativePage.getInstance().verifyClearFilterIsEnabled();
    }

    //    @QAFTestStep(description="Verify filter is not applied")
//    public void verifyTheFilterIsNotApplied(){
//        CorporateNativePage.getInstance().verifyFilterIsNotApplied();
//    }
    @QAFTestStep(description="Click clear filter")
    public void clickClearFilter(){
        CorporateNativePage.getInstance().applyClearFilter();
//        CorporateNativePage.getInstance().verifyClearFilterIsDisabled();
    }

    @QAFTestStep(description="Verify clear filter")
    public void verifyTheClearFilter(){
        CorporateNativePage.getInstance().verifyClearFilter();
    }







}
