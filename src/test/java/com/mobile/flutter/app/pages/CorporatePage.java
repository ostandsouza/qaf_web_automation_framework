package com.mobile.flutter.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.mobile.utils.DIRECTION;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
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

    @FindBy(locator = "dashboard.search.field")
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

    @FindBy(locator = "shop.name.field")
    public CustomFlutterElement shopNameField;

    @FindBy(locator = "site.shop.dropdown")
    public CustomFlutterElement shopDistributorDropdown;

    @FindBy(locator = "site.territory.dropdown")
    public CustomFlutterElement territoryDropdown;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Ancestor\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"ListView\\\"}\",\"of\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"SingleChildScrollView\\\"}\"}")
    public CustomFlutterElement corporateSiteListFirst;

    @FindBy(locator = "site.search.field")
    public CustomFlutterElement siteSearch;

    @FindBy(locator = "corporate.frame.screen")
    public CustomFlutterElement corporateFrame;

    public boolean isCompanyPage() {
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
        driver.executeScript("flutter:setFrameSync",true, 5000);
        SyncUtil.waitFor(2000);
//        SyncUtil.waitFor(3000);
        searchField.sendKeys(query);
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

    public boolean goToCorporateEditScreen(){
        corporateMoreBtn.click("More Button");
        DashboardNativePage.getInstance().clickEditBtn();
        SyncUtil.waitFor(1000);
        return corporateDetailsHeader.getText().contains("Edit");
    }

    public boolean goBackToCorporateListScreen(){
        corporateBackBtn.click("Corporate Back Button");
        return DashboardNativePage.getInstance().isCorporateList();
    }

    public void goBackToCorporateCardScreen(){
        corporateBackBtn.click("Corporate Back Button");
    }

    public boolean updateCorporateName(String name, String address){
        corporateDetailsName.sendKeys(name);
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

    public boolean addSite(String siteName, String address, String customerCorp, String territory, String manager, String... shop){
        selectCustomerSite();
        siteNameField.sendKeys(siteName,"Shop Name");

        siteCustDropdown.click("Customer Corporate dropdown");
        dropdownSearch.sendKeys(customerCorp, "Customer Corp");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        territoryDropdown.click("Territory dropdown");
        dropdownSearch.sendKeys(territory, "Territory");
        DashboardNativePage.getInstance().selectFirstSearchTerritorySiteScreen();

        if(shop.length != 0){
            shopDistributorDropdown.click("Distributor Shop dropdown");
            dropdownSearch.sendKeys(shop[0], "Distibutor Shop");
            DashboardNativePage.getInstance().selectFirstSearchTerritorySiteScreen();
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


    public boolean addShop(String shopName, String address, String distCorp, String territory, String manager){
        selectDistributorShop();
        shopNameField.sendKeys(shopName,"Shop Name");

        distributorCorpDropdown.click("Distributor Corporate dropdown");
        dropdownSearch.sendKeys(distCorp, "Distributor Corp");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        territoryDropdown.click("Territory dropdown");
        dropdownSearch.sendKeys(territory, "Territory");
        DashboardNativePage.getInstance().selectFirstSearchTerritorySiteScreen();

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
        siteSearch.sendKeys(shopName);
        return corporateSiteListFirst.isVisible("Associated Shop");
    }

}
