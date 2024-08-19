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

    @FindBy(locator = "company.add.site")
    public CustomFlutterElement addSiteBtn;

    @FindBy(locator = "company.add.icon")
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


}
