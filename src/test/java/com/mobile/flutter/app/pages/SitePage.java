package com.mobile.flutter.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.util.Validator;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import org.testng.Assert;

public class SitePage extends FlutterBasePage {

    private static SitePage obj;

    public static SitePage getInstance() {
        if (obj == null)
            obj = new SitePage();
        return obj;
    }

    @FindBy(locator = "corporate.add.site")
    public CustomFlutterElement addSiteBtn;

    @FindBy(locator = "corporate.add.icon")
    public CustomFlutterElement addCompanyBtn;

    @FindBy(locator = "company.addSite.back")
    public CustomFlutterElement addSiteBackBtn;

    @FindBy(locator = "company.addSite.header")
    public CustomFlutterElement addSiteHeader;

    @FindBy(locator = "sites.siteList.header")
    public CustomFlutterElement siteListHeader;

    @FindBy(locator = "sites.more.btn")
    public CustomFlutterElement siteMoreBtn;

    @FindBy(locator = "site.conveyor.action")
    public CustomFlutterElement siteConveyorAction;
    @FindBy(locator = "sites.conveyor.edit")
    public CustomFlutterElement editConveyorTxt;

    @FindBy(locator = "sites.conveyor.delete")
    public CustomFlutterElement deleteConveyorTxt;

    @FindBy(locator = "conveyor.name.field")
    public CustomFlutterElement conveyorNameField;
    @FindBy(locator = "corporate.add.corporate")
    public CustomFlutterElement addCorporateBtn;

    @FindBy(locator = "dashboard.loading.animation")
    public CustomFlutterElement loadingDashboard;
    @FindBy(locator = "dashboard.company.type")
    public CustomFlutterElement companyType;
    @FindBy(locator = "site.name.field")
    public CustomFlutterElement siteNameField;
    @FindBy(locator = "site.customer.dropdown")
    public CustomFlutterElement siteCustDropdown;
    @FindBy(locator = "site.shop.dropdown")
    public CustomFlutterElement shopDistributorDropdown;

    @FindBy(locator = "site.manager.dropdown")
    public CustomFlutterElement territoryManagerDropdown;
    @FindBy(locator = "site.territory.dropdown")
    public CustomFlutterElement territoryDropdown;
    @FindBy(locator = "dashboard.address.field")
    public CustomFlutterElement addressBar;

    @FindBy(locator = "dashboard.save.btn")
    public CustomFlutterElement saveBtn;
    @FindBy(locator = "site.dropdown.search")
    public CustomFlutterElement dropdownSearch;

    @FindBy(locator = "site.company.existingerror")
    public CustomFlutterElement msgAlreadyExist;

    @FindBy(locator = "site.company.successMsg")
    public CustomFlutterElement companySuccessMsg;
    @FindBy(locator = "corporate.details.header")
    public CustomFlutterElement corporateDetailsHeader;

    @FindBy(locator = "shop.name.field")
    public CustomFlutterElement shopNameField;
    @FindBy(locator = "corporate.view.header")
    public CustomFlutterElement companyHeading;
    @FindBy(locator = "shop.distributor.field")
    public CustomFlutterElement distributorCorpDropdown;



    public void addSiteBtnClick()
    {
        addCompanyBtn.click();
        addSiteBtn.click();
    }
    public boolean isAddSitePage() {
        Validator.assertTrue(addSiteHeader.isPresent(),"user navigated to Add Site page","user navigated to Add Site page");
        return addSiteHeader.isPresent();
    }
    public void verifyAddSiteBackBtnVisible()
    {
        addSiteBackBtn.waitForTheElementToBeVisible(20000,"back button");
        Validator.assertTrue(addSiteBackBtn.isVisible(),"back button is not visible next to Add Site heading","back button is  visible next to Add Site heading");
    }
    public void siteBackBtnClick()
    {
        addSiteBackBtn.click("Site Back Button");
    }

    public boolean isSitesPage() {
        Validator.assertTrue(siteListHeader.isPresent(),"user navigated to sites list page","user navigated to sites list page");
        return siteListHeader.isPresent();
    }

    public boolean verifySiteCreation(String company) {
        DashboardNativePage.getInstance().goToSearch();
        SyncUtil.waitFor(5000);
        CorporatePage.getInstance().enterSearchQuery(company);
        System.out.println(DashboardNativePage.getInstance().getSearchCount()+"count issss");
        System.out.println(DashboardNativePage.getInstance().getSearchSiteResult()+"serach result is");
        Assert.assertTrue(DashboardNativePage.getInstance().getSearchCount().equals("1"),"Search Result Count");
        return DashboardNativePage.getInstance().getSearchSiteResult().contains(company);
    }

    public void siteNameClick()
    {
        siteMoreBtn.waitForTheElementToBeVisible(30);
        siteMoreBtn.click();
    }

    public void btnEditDeleteClickAndVerify()
    {
        Validator.assertTrue(siteConveyorAction.isDisplayed(),"the three dots next to the conveyor list is not visible","the three dots next to the conveyor list is  visible");
        siteConveyorAction.click();
        editConveyorTxt.waitForTheElementToBeVisible(35);
        Validator.assertTrue(editConveyorTxt.isDisplayed() && deleteConveyorTxt.isDisplayed(),"Edit/Delete option is not visible","Edit/Delete option is visible");
    }
    public void editBtnClick()
    {
        editConveyorTxt.waitForTheElementToBeVisible(25);
        editConveyorTxt.click();
    }
    public boolean verifyIsConveyorEditPage()
    {
        return conveyorNameField.isVisible("Conveyor Name");
    }

    public boolean goToSiteShopFromCorpList() {
        loadingDashboard.waitForTheElementToBeInvisible(45);
        addCompanyBtn.waitForTheElementToBeVisible(30);
        addCompanyBtn.click();
        Validator.assertTrue(addCorporateBtn.isDisplayed(),"Add Corporate is not Visible","Add Corporate is Visible");
        Validator.assertTrue(addSiteBtn.isDisplayed(),"Add Site is not Visible","Add Site is Visible");
        addSiteBtn.click();
        return CorporatePage.getInstance().isCompanyPage();
    }
    public boolean verifyAddSiteHeading(){
        addSiteHeader.waitForTheElementToBeVisible(30);
        Validator.assertTrue(addSiteHeader.getText().contains("Add Site"),"Header Add Site is not present","Header Add Site is present");
        return addSiteHeader.getText().contains("Add Site");
    }
    public void verifyAddSiteFields(){
        Validator.assertTrue(companyType.isDisplayed(),"Type of Company is not present","Type of Company is present");
//        Validator.assertTrue(companyType.isDisplayed(),"Image Field is not present","Image Field is present");
        Validator.assertTrue(siteNameField.isDisplayed(),"Site Name is not present","Site Name is present");
        Validator.assertTrue(siteCustDropdown.isDisplayed(),"Customer Corporate is not present","Customer Corporate is present");
        Validator.assertTrue(shopDistributorDropdown.isDisplayed(),"Associated Distributor Shop is not present","Associated Distributor Shop is present");
        Validator.assertTrue(territoryDropdown.isDisplayed(),"Territory is not present","Territory Manager is present");
        Validator.assertTrue(territoryManagerDropdown.isDisplayed(),"Territory Manager is not present","Territory Manager is present");
        Validator.assertTrue(addressBar.isDisplayed(),"Address is not present","Address is present");
        Validator.assertTrue(saveBtn.isDisplayed(),"Save button is not present","Save button is present");
    }

    public void addSiteDetails(String siteName, String address, String customerCorp, String territory, String manager, String... shop){
        CorporatePage.getInstance().selectCustomerSite();
        SyncUtil.waitFor(5000);
        siteNameField.click();

        System.out.println(siteName+"sitename");
        siteNameField.sendKeys(siteName,"Shop Name");
        System.out.println(siteNameField.getText()+"name in the site");
        siteCustDropdown.click("Customer Corporate dropdown");
        SyncUtil.waitFor(10000);
        dropdownSearch.sendKeys(customerCorp, "Customer Corp");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        territoryDropdown.click("Territory dropdown");
        SyncUtil.waitFor(2000);
        System.out.println(dropdownSearch.isVisible()+"dropSearchFirst");
        SyncUtil.waitFor(5000);
        System.out.println(dropdownSearch.isVisible()+"dropSearchSecond");
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
        SyncUtil.waitFor(1000);
        addressBar.click();
        DashboardNativePage.getInstance().gMapSelection();
        saveBtn.click();
    }
    public boolean isSitePage() {
        Validator.assertTrue(siteNameField.isDisplayed(),"Site Add page is not present","Site Add page is present");
        return siteNameField.isPresent();
    }

    public void verifyDuplicateSiteCreation() {
        System.out.println(msgAlreadyExist.getText()+"Error message");
        Validator.assertTrue(msgAlreadyExist.isDisplayed(),"Error message not found","Error message found");
    }

    public void addDistShopSiteDetails(String shopName, String address, String customerCorp, String territory, String manager){
        CorporatePage.getInstance().selectDistributorShop();
        shopNameField.sendKeys(shopName,"Shop Name");
        distributorCorpDropdown.click("Distributor Corporate dropdown");
        dropdownSearch.sendKeys(customerCorp, "Customer Corp");
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
        SyncUtil.waitFor(2000);
        addressBar.click();
        DashboardNativePage.getInstance().gMapSelection();
        saveBtn.click();
    }

    public void verifySuccessMsgForCreation() {
        System.out.println(companySuccessMsg.getText()+"Success message");
        Validator.assertTrue(companySuccessMsg.isDisplayed(),"Success message not found","Success message found");
    }
    public void verifyDetailPageHeader(String shopName) {
        Validator.assertTrue(corporateDetailsHeader.getText().contains(shopName),"Site header is not visible","Site header is visible");
    }
    public void verifyInfoPageHeader(String shopName) {
        Validator.assertTrue(companyHeading.getText().contains(shopName),"Site header is not visible","Site header is visible");
    }
    public void verifyDataInSiteDetailPage(String shopName, String address, String manager) {
        Validator.assertTrue(shopNameField.getText().contains(shopName),"Shop Name field is not displayed","Shop Name field is not displayed");
        Validator.assertTrue(territoryManagerDropdown.getText().contains(manager),"Territory Manager field is not displayed","Territory Manager field is displayed");
        Validator.assertTrue(addressBar.getText().contains(address),"Address field is not displayed","Address field is displayed");
    }


}
