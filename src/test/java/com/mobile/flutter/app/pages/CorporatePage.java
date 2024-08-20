package com.mobile.flutter.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.mobile.utils.DIRECTION;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.testng.Assert;

import java.time.Duration;

public class CorporatePage extends FlutterBasePage {

    private static CorporatePage obj;

    public static CorporatePage getInstance(){
        if(obj==null)
            obj = new CorporatePage();
        return obj;
    }

    @FindBy(locator = "dashboard.company.type")
    public CustomFlutterElement companyType;

    @FindBy(locator = "dashboard.distributor.corporate")
    public CustomFlutterElement distCorporate;

    @FindBy(locator = "dashboard.distributor.shop")
    public CustomFlutterElement distributorShop;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Ancestor\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"ListTile\\\"}\",\"of\":\"{\\\"finderType\\\":\\\"ByText\\\",\\\"text\\\": \\\"Customer Site\\\"}\"}")
    public CustomFlutterElement customerSite;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Ancestor\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"ListTile\\\"}\",\"of\":\"{\\\"finderType\\\":\\\"ByText\\\",\\\"text\\\": \\\"Customer Corporate\\\"}\"}")
    public CustomFlutterElement custCorporate;

    @FindBy(locator = "dashboard.company.field")
    public CustomFlutterElement companyName;

    @FindBy(locator = "dashboard.address.field")
    public CustomFlutterElement addressBar;

    @FindBy(locator = "corporate.address.field")
    public CustomFlutterElement addressField;

    @FindBy(locator = "dashboard.save.btn")
    public CustomFlutterElement saveBtn;

    @FindBy(locator = "corporate.edit.save")
    public CustomFlutterElement saveEditBtn;

    @FindBy(locator = "dashboard.coverWear.txt")
    public CustomFlutterElement coverWear;

    @FindBy(locator = "corporate.filter.search")
    public CustomFlutterElement searchField;

    @FindBy(locator = "dashboard.beltWidth.field")
    public CustomFlutterElement beltWidth;

    @FindBy(locator = "dashboard.beltLength.field")
    public CustomFlutterElement beltLength;

    @FindBy(locator = "dashboard.search.filter")
    public CustomFlutterElement search;

    @FindBy(locator = "dashboard.search.results")
    public CustomFlutterElement result;

    @FindBy(locator = "dashboard.topCoverThickness.field")
    public CustomFlutterElement topCoverThickness;

    @FindBy(locator = "dashboard.bottomCoverThickness.field")
    public CustomFlutterElement bottomCoverThickness;

    @FindBy(locator = "dashboard.durometer.field")
    public CustomFlutterElement durometer;

    @FindBy(locator = "dashboard.topCoverCompound.field")
    public CustomFlutterElement topCoverCompound;

    @FindBy(locator = "dashboard.bottomCoverCompound.field")
    public CustomFlutterElement bottomCoverCompound;

    @FindBy(locator = "dashboard.datePicker.field")
    public CustomFlutterElement dateOfInstallation;

    @FindBy(locator = "corporate.details.btn")
    public CustomFlutterElement corporateDetailsBtn;

    @FindBy(locator = "corporate.more.btn")
    public CustomFlutterElement corporateMoreBtn;

    @FindBy(locator = "corporate.details.header")
    public CustomFlutterElement corporateDetailsHeader;

    @FindBy(locator = "corporate.edit.name")
    public CustomFlutterElement corporateDetailsName;

    @FindBy(locator = "corporate.edit.companyType")
    public CustomFlutterElement corporateDetailsType;

    @FindBy(locator = "corporate.edit.count")
    public CustomFlutterElement corporateDetailsCount;

    @FindBy(locator = "corporate.details.count")
    public CustomFlutterElement corporateCardCount;

    @FindBy(locator = "corporate.details.back")
    public CustomFlutterElement corporateBackBtn;

    @FindBy(locator = "company.add.back")
    public CustomFlutterElement addCorporateBackBtn;


    @FindBy(locator = "corporate.edit.success")
    public CustomFlutterElement corporateEditSuccessMsg;

    @FindBy(locator = "corporate.create.success")
    public CustomFlutterElement corporateCreateSuccessMsg;

    @FindBy(locator = "corporate.filter.search")
    public CustomFlutterElement filterSearch;

    @FindBy(locator = "site.name.field")
    public CustomFlutterElement siteNameField;

    @FindBy(locator = "site.customer.dropdown")
    public CustomFlutterElement siteCustDropdown;

    @FindBy(locator = "shop.distributor.field")
    public CustomFlutterElement distributorCorpDropdown;

    @FindBy(locator = "site.dropdown.search")
    public CustomFlutterElement dropdownSearch;

    @FindBy(locator = "site.manager.dropdown")
    public CustomFlutterElement territoryManagerDropdown;

    @FindBy(locator = "corporate.edit.territoryManager")
    public CustomFlutterElement editTerritoryManagerDropdown;

    @FindBy(locator = "shop.name.field")
    public CustomFlutterElement shopNameField;

    @FindBy(locator = "site.shop.dropdown")
    public CustomFlutterElement shopDistributorDropdown;

    @FindBy(locator = "site.territory.dropdown")
    public CustomFlutterElement territoryDropdown;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Ancestor\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"ListView\\\"}\",\"of\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"SingleChildScrollView\\\"}\"}")
    public CustomFlutterElement corporateSiteListFirst;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"list_card_count\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Search\\\"}\"}")
    public CustomFlutterElement corporateSiteListCount;

    @FindBy(locator = "site.search.field")
    public CustomFlutterElement siteSearch;

    @FindBy(locator = "corporate.frame.screen")
    public CustomFlutterElement corporateFrame;

    @FindBy(locator = "corporate.corporateList.header")
    public CustomFlutterElement corporateHeader;

    @FindBy(locator = "corporate.view.header")
    public CustomFlutterElement companyHeading;

    @FindBy(locator = "company.company.card")
    public CustomFlutterElement companyCard;

    @FindBy(locator = "corporate.name.field")
    public CustomFlutterElement tbCompanyName;

    @FindBy(locator = "company.add.icon")
    public CustomFlutterElement addCompanyBtn;

    @FindBy(locator = "company.add.corporate")
    public CustomFlutterElement addCorporateBtn;

    @FindBy(locator = "company.add.header")
    public CustomFlutterElement addCorporateHeader;
    @FindBy(locator = "corporate.inspection.header")
    public CustomFlutterElement inspectionListHeader;

    @FindBy(locator = "corporate.tools.header")
    public CustomFlutterElement toolsListHeader;




    public boolean isCompanyPage() {
        waitForPageToLoad();
        return companyType.isPresent();
    }

    public void selectDistributorCorp() {
        companyType.waitForTheElementToBeVisible(30);
        companyType.click();
        distCorporate.click();
    }

    public void selectCustomerCorp() {
        companyType.waitForTheElementToBeVisible(30);
        companyType.click();
        custCorporate.click();
    }

    public void selectCustomerSite() {
        companyType.waitForTheElementToBeVisible(30);
        companyType.click();
        customerSite.click();
    }

    public void selectDistributorShop() {
        companyType.waitForTheElementToBeVisible(30);
        companyType.click();
        distributorShop.click();
    }

    public boolean addDistributorCorpDetails(String company, String address) {
        selectDistributorCorp();
        return addCorpDetails(company,address);
    }

    public boolean addCustomerCorpDetails(String company, String address) {
        selectCustomerCorp();
        return addCorpDetails(company,address);
    }

    public boolean addCorpDetails(String company, String address) {
//        DashboardNativePage.getInstance().imageUpload();
        companyName.sendKeys(company);
        addressBar.sendKeys(address);
        SyncUtil.waitFor(1000);
        addressBar.click();
        DashboardNativePage.getInstance().gMapSelection();
//        SyncUtil.waitFor(3000);
        saveBtn.click();
        return DashboardPage.getInstance().isHomePage();
    }

    public void goToCorporateDetails() {
        DashboardNativePage.getInstance().navigateInsideCorp();
        corporateDetailsBtn.click();
    }

    public boolean verifyEditStatus(){
        corporateMoreBtn.click();
        return DashboardNativePage.getInstance().isCorpEdit();
    }

    public void enterSearchQuery(String query){
        waitForPageToLoad();
        SyncUtil.waitFor(5000);
        driver.executeScript("flutter:setFrameSync",true, 5000);
//        SyncUtil.waitFor(2000);
        SyncUtil.waitFor(1000);
        System.out.println(query);
        searchField.sendKeys(query);
        SyncUtil.waitFor(2000);
        driver.executeScript("flutter:setFrameSync",false, 5000);
    }

    public boolean verifyCorpCreation(String company) {
        DashboardNativePage.getInstance().goToCorporateSearch();
        SyncUtil.waitFor(5000);
        enterSearchQuery(company);
        System.out.println(DashboardNativePage.getInstance().getSearchCount());
        System.out.println(DashboardNativePage.getInstance().getSearchResult());
        Assert.assertTrue(DashboardNativePage.getInstance().getSearchCount().equals("1"),"Search Result Count");
        return DashboardNativePage.getInstance().getSearchResult().equalsIgnoreCase(company);
    }

    public boolean goToCorporateEditScreen(String distShopName){
        corporateMoreBtn.click("More Button");
        DashboardNativePage.getInstance().clickEditBtn();
        SyncUtil.waitFor(1000);
        return corporateDetailsHeader.getText().contains("Edit-"+distShopName);
    }

    public boolean goBackToCorporateListScreen(){
        addCorporateBackBtn.click("Corporate Back Button");
        return DashboardNativePage.getInstance().isCorporateList();
    }


    public void goBackToCorporateCardScreen(){
        corporateBackBtn.click("Corporate Back Button");
    }

    public boolean updateCorporateName(String name, String address,String manager){
        corporateDetailsName.sendKeys(name);

        SyncUtil.waitFor(2000);
        editTerritoryManagerDropdown.click("Manager dropdown");
        dropdownSearch.sendKeys(manager, "Manager");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        addressBar.scrollToElement(corporateFrame, DIRECTION.DOWN, "Save Btn");
        addressField.sendKeys(address);
        SyncUtil.waitFor(1000);
        addressField.click();
        DashboardNativePage.getInstance().gMapSelection();
        saveEditBtn.scrollIntoView("Save changes");
        SyncUtil.waitFor(4000);
        saveEditBtn.click("save button");
        return corporateEditSuccessMsg.waitForTheElementToBeVisible(30);
    }

    public String getCorporateCount(){
        return corporateCardCount.getText("Card Count");
    }

    public void goToSiteShopDetails(){
        corporateDetailsBtn.click();
    }

    public void filterCorporateType(String corp){
        filterSearch.sendKeys(corp,"corporate search");
    }
    public void filterMarketType(String corp){
        filterSearch.sendKeys(corp,"market search");
        SyncUtil.waitFor(2000);
    }

    public boolean addSite(String siteName, String address, String customerCorp, String territory, String manager, String... shop){
        selectCustomerSite();
        siteNameField.sendKeys(siteName,"Shop Name");
//        SyncUtil.waitFor(10000);
        siteCustDropdown.waitForTheElementToBeVisible(45);

        siteCustDropdown.click("Customer Corporate dropdown");
        dropdownSearch.sendKeys(customerCorp, "Customer Corp");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        territoryDropdown.waitForTheElementToBeVisible(45);
        territoryDropdown.click("Territory dropdown");
        dropdownSearch.waitForTheElementToBeVisible(45);
        SyncUtil.waitFor(10000);
        dropdownSearch.clear();
        dropdownSearch.sendKeys(territory, "Territory");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        if(shop.length != 0){
            shopDistributorDropdown.click("Distributor Shop dropdown");
            dropdownSearch.sendKeys(shop[0], "Distibutor Shop");
            DashboardNativePage.getInstance().selectFirstSearchSiteScreen();
        }

        SyncUtil.waitFor(2000);
        territoryManagerDropdown.click("Manager dropdown");
        dropdownSearch.sendKeys(manager, "Manager");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        addressBar.scrollIntoView("Scroll to address bar");
        addressBar.sendKeys(address, "Address");
        SyncUtil.waitFor(2000);
        addressBar.click();
        DashboardNativePage.getInstance().gMapSelection();
        saveBtn.click();
        return DashboardPage.getInstance().isHomePage();
    }


    public void verifyMapFields(String siteName, String address, String customerCorp, String territory){
        selectCustomerSite();
        siteNameField.sendKeys(siteName,"Shop Name");
//        SyncUtil.waitFor(10000);

        siteCustDropdown.waitForTheElementToBeVisible(45);
        siteCustDropdown.click("Customer Corporate dropdown");
        dropdownSearch.sendKeys(customerCorp, "Customer Corp");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        territoryDropdown.waitForTheElementToBeVisible(45);
        territoryDropdown.click("Territory dropdown");
//        dropdownSearch.waitForTheElementToBeVisible(45);
        dropdownSearch.sendKeys(territory, "Territory");
        DashboardNativePage.getInstance().selectFirstSearchTerritorySiteScreen();


        addressBar.scrollIntoView("Scroll to address bar");
        addressBar.sendKeys(address, "Address");
        SyncUtil.waitFor(2000);
        addressBar.click();
        addressBar.click();
        DashboardNativePage.getInstance().gMapSelection();
        DashboardNativePage.getInstance().verifyMapLocationAndFields();
    }

    public boolean addShop(String shopName, String address, String distCorp, String territory, String manager){
//        selectDistributorShop();
        shopNameField.sendKeys(shopName,"Shop Name");

        distributorCorpDropdown.click("Distributor Corporate dropdown");
        dropdownSearch.sendKeys(distCorp, "Distributor Corp");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        territoryDropdown.click("Territory dropdown");
        dropdownSearch.sendKeys(territory, "Territory");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        SyncUtil.waitFor(2000);
        territoryManagerDropdown.click("Manager dropdown");
        dropdownSearch.sendKeys(manager, "Manager");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        addressBar.scrollIntoView("Scroll to address bar");
        addressBar.sendKeys(address, "Address");
        SyncUtil.waitFor(1000);
        addressBar.click();
        DashboardNativePage.getInstance().gMapSelection();
        saveBtn.click();
        return DashboardPage.getInstance().isHomePage();
    }

    public String goToSiteShopCard(String shopName){
        verifySiteShopList(shopName);
        return DashboardNativePage.getInstance().getNameFromCard();
    }

    public void siteShopNav(){
        corporateSiteListFirst.click("Associated Shop");
    }

    public void closeSearch(){
        if(siteSearch.isVisible())
            DashboardNativePage.getInstance().goToSearch();
    }

    public boolean verifySiteShopList(String shopName){
        DashboardNativePage.getInstance().goToSearch();
        SyncUtil.waitFor(8000);
        siteSearch.sendKeys(shopName);
        SyncUtil.waitFor(8000);
        return corporateSiteListFirst.isVisible("Associated Shop");
    }

//    public void verifyCorpListPage(){
//        DashboardNativePage.getInstance().goToCorporatePage();
//    }
    public void verifyCorpListPageNavigation()
    {
        Validator.assertTrue(DashboardNativePage.getInstance().isCorporateList(),"User is not navigated to corporate list screen","User is not navigated to corporate list screen");
    }

    public void verifyDefaultCompField(){
        companyType.waitForTheElementToBeVisible(30);
        Validator.assertTrue(companyType.getText().contains("j"),"Default Text is not present","Default Text is present");
    }
    public void verifyDefaultSiteField(String value){
        companyType.waitForTheElementToBeVisible(30);
        Validator.assertTrue(companyType.getText().contains(value),"Default Text is not present","Default Text is present");
    }


    public boolean verifyConveyorList(String shopName){
        DashboardNativePage.getInstance().goToSearch();
        SyncUtil.waitFor(8000);
        siteSearch.sendKeys(shopName);
        SyncUtil.waitFor(5000);
        return DashboardNativePage.getInstance().getFirstConveyor().contains(shopName);
    }

    public void verifyCorporateHeader()
    {
        corporateHeader.waitForTheElementToBeVisible(20);
        Validator.assertTrue(corporateHeader.isVisible(),"Corporates header is not visible in corporate list page","Corporates header is visible in corporate list page");

    }

    public void verifyBackBtnVisible()
    {
        addCorporateBackBtn.waitForTheElementToBeVisible(20000,"back button");
        Validator.assertTrue(addCorporateBackBtn.isVisible(),"back button is not visible next to add corporate heading","back button is  visible next to add corporate heading");
    }


    public void companyTypeClick()
    {
//        companyType.waitForTheElementToBeVisible(30);
        companyType.click();
    }

    public void verifyCompanyTypeDdl()
    {
//        distCorporate.waitForTheElementToBeVisible(30);
        Validator.assertTrue(distCorporate.isDisplayed(),"Distributor corporate is not visible on the dropdown","Distributor corporate is  visible on the dropdown");
//        custCorporate.waitForTheElementToBeVisible(30);
        Validator.assertTrue(custCorporate.isDisplayed(),"Customer corporate is not visible on the dropdown","Customer corporate is  visible on the dropdown");
    }

    public void selectDistCorporate()
    {
        distCorporate.waitForTheElementToBeVisible(30);
        distCorporate.click();
    }

    public boolean createDistributorCorp(String company,String address,String imageName)
    {
//        DashboardNativePage.getInstance().imageUpload();
        companyName.sendKeys(company);
        addressBar.sendKeys(address);
        SyncUtil.waitFor(1000);
        addressBar.click();
        DashboardNativePage.getInstance().gMapSelection();
//        SyncUtil.waitFor(3000);
        saveBtn.waitForTheElementToBeVisible(30);
        saveBtn.click();
        return DashboardPage.getInstance().isHomePage();
    }
    public void companyNameClick()
    {
        corporateMoreBtn.waitForTheElementToBeVisible(30);
        corporateMoreBtn.click();

    }
    public boolean verifyCompanyHeading(String corporateHeading)
    {
        companyHeading.waitForTheElementToBeVisible(45);
//        companyHeading.getText().equalsIgnoreCase(corporateHeading)
        Validator.assertTrue(companyHeading.isDisplayed(),"User is not navigated to corporate detail page","User is navigated to corporate detail page");
        Validator.assertTrue(companyHeading.getText().contains(corporateHeading),"Header of the page is not same as company name","Header of the page is  same as company name");
        return companyHeading.getText().equalsIgnoreCase(corporateHeading+" - Sites");

    }
    public void companyCardClick()
    {
        companyCard.waitForTheElementToBeVisible(45);
        companyCard.click();

    }
    public void verifyIsDetailPage()
    {
        corporateDetailsHeader.waitForTheElementToBeVisible(45);
        System.out.println(corporateDetailsHeader.getText()+"corporateheader");
        Validator.assertTrue(corporateDetailsHeader.isVisible(),"user is not on corporate detail page","User is on corporate detail oage");
    }

    public void verifyCompanyDetails(String companyName)
    {
        tbCompanyName.waitForTheElementToBeVisible(45);
        Validator.assertTrue(tbCompanyName.getText().equalsIgnoreCase(companyName),"company name is not same as user filled value", "company name is same as user filled valu");
    }
    public void addCompanyBtnClick()
    {
        addCompanyBtn.click();
        addCorporateBtn.click();

    }

    public boolean isAddCompanyPage() {
        Validator.assertTrue(addCorporateHeader.isPresent(),"user navigated to add company page","user navigated to add company  page");
        return addCorporateHeader.isPresent();
    }

    public void verifyCorporateSearch(String corpName)
    {
        Assert.assertTrue(DashboardNativePage.getInstance().getSearchCount().equals("1"),"Search Result Count");
        System.out.println(DashboardNativePage.getInstance().getSearchResult()+"search result____________________-");
        Validator.assertTrue(DashboardNativePage.getInstance().getSearchResult().contains(corpName),"Search result does not match the entered string","Search result matches the entered string");

    }
    public void verifyCorpListScreen()
    {
        DashboardNativePage.getInstance().verifyCorpListFields();
        Validator.assertTrue(corporateMoreBtn.isDisplayed(),"Arrow icon is not displayed","Arrow icon is displayed");
    }
    public boolean isInspectionListPage() {
        return inspectionListHeader.isPresent();}
    public boolean isToolListPage() {
        return toolsListHeader.isPresent();}


    public void verifyLinksNavigation()
    {
        DashboardNativePage.getInstance().btnHomeIconClick();
        DashboardPage.getInstance().isHomePage();
        DashboardNativePage.getInstance().btnConveyorIconClick();
        ConveyorPage.getInstance().isConveyorPage();
        DashboardNativePage.getInstance().btnInspectionIconClick();
        Validator.assertTrue(isInspectionListPage(),"User is not navigated to inspection page","User is navigated to inspection page");
        DashboardNativePage.getInstance().btnToolIconClick();
        Validator.assertTrue(isToolListPage(),"User is not navigated to Tools page","User is navigated to Tools page");
    }
    public void getCount()
    {
        SyncUtil.waitFor(5000);
        System.out.println(corporateSiteListCount.getText()+"count is");
        Validator.assertTrue(corporateSiteListCount.getText().equalsIgnoreCase("0"),"Count of sites/Shops is not displayed","Count of sites/Shops is  displayed");
    }


}
