package com.mobile.flutter.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import org.testng.Assert;

public class DashboardPage extends FlutterBasePage {

    DashboardNativePage dashboardNativePage = new DashboardNativePage();

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub
    }

    @FindBy(locator = "dashboard.home.title")
    public CustomFlutterElement homeTitle;

    @FindBy(locator = "dashboard.add.icon")
    public CustomFlutterElement addIcon;

    @FindBy(locator = "dashboard.add.conveyor")
    public CustomFlutterElement addConveyor;

    @FindBy(locator = "dashboard.add.corporate")
    public CustomFlutterElement addCorporate;

    @FindBy(locator = "dashboard.company.type")
    public CustomFlutterElement companyType;

    @FindBy(locator = "dashboard.distributor.corporate")
    public CustomFlutterElement distCorporate;

    @FindBy(locator = "dashboard.customer.corporate")
    public CustomFlutterElement custCorporate;

    @FindBy(locator = "dashboard.company.field")
    public CustomFlutterElement companyName;

    @FindBy(locator = "dashboard.address.field")
    public CustomFlutterElement addressBar;

    @FindBy(locator = "dashboard.save.btn")
    public CustomFlutterElement saveBtn;

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

    public boolean isHomePage() {
        addIcon.waitForTheElementToBeVisible(60);
        return addIcon.isPresent();
    }

    public boolean goToAddCorp() {
        addIcon.waitForTheElementToBeVisible(60);
        addIcon.click();
        addCorporate.click();
        return companyType.isPresent();
    }

    public void selectDistributorCorp() {
        companyType.waitForTheElementToBeVisible(30);
        companyType.click();
        distCorporate.click();
    }

    public void selectCustomerCorp() {
        companyType.click();
        custCorporate.click();
    }

    public boolean addCorpDetails(String company, String address) {
        selectDistributorCorp();
        dashboardNativePage.imageUpload();
        companyName.sendKeys(company);
        addressBar.sendKeys(address);
        addressBar.click();
        dashboardNativePage.gMapSelection();
        SyncUtil.waitFor(3000);
        saveBtn.click();
        return isHomePage();
    }

    public void enterSearchQuery(String query){
        searchField.sendKeys(query);
        SyncUtil.waitFor(2000);
    }

    public void verifyCorpCreation(String company) {
        dashboardNativePage.goToCorporateSearch();
        enterSearchQuery(company);
        Assert.assertTrue(dashboardNativePage.getSearchCount().contains("1"),"Search Result Count");
        Assert.assertTrue(dashboardNativePage.getSearchResult().equalsIgnoreCase(company),"Search Result");
    }

    public void goToCoverWearViaConveyor(String conveyor) {
        Assert.assertEquals(dashboardNativePage.goToConveyor(conveyor),conveyor,"Conveyor Navigation");
        dashboardNativePage.goToCoverWear();
    }

    public void fillCoverWearSpecs(){
        beltWidth.sendKeys("8");
        beltLength.sendKeys("5");
        topCoverThickness.scrollIntoView();
        topCoverThickness.click();
        search.sendKeys("1");
        dashboardNativePage.selectFirstSearch();
        bottomCoverThickness.scrollIntoView();
        bottomCoverThickness.click();
        search.sendKeys("3");
        dashboardNativePage.selectFirstSearch();
        durometer.scrollIntoView();
        durometer.sendKeys("50");
        topCoverCompound.scrollIntoView();
        topCoverCompound.click();
        search.sendKeys("ALUMINA HOT");
        dashboardNativePage.selectFirstSearch();
        bottomCoverCompound.scrollIntoView();
        bottomCoverCompound.click();
        search.sendKeys("ALUMINA HOT");
        dashboardNativePage.selectFirstSearch();
        dateOfInstallation.click();
        dashboardNativePage.selectCalenderDate();
        saveBtn.click();
    }

}
