package com.mobile.nativectx.app.pages;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.mobile.flutter.app.pages.CorporatePage;
import com.mobile.nativectx.app.component.CustomMobileElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Rectangle;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class DashboardNativePage extends NativeBasePage {

    private static DashboardNativePage obj;

    public static DashboardNativePage getInstance(){
        if(obj==null)
            obj = new DashboardNativePage();
        return obj;
    }

//    DashboardPage dashboardPage = new DashboardPage();
//
//    @FindBy(locator = "accessibility id=Home")
//    protected CustomMobileElement home;
    
    @FindBy(locator = "dashboard.search.icon")
    protected CustomMobileElement searchIcon;

    @FindBy(locator = "dashboard.filter.icon")
    protected CustomMobileElement filterIcon;

    @FindBy(locator = "dashboard.refresh.icon")
    protected CustomMobileElement refreshIcon;
    
    @FindBy(locator = "dashboard.profile.icon")
    protected CustomMobileElement profileIcon;
    
    @FindBy(locator = "dashboard.home.icon")
    protected CustomMobileElement homeIcon;

    @FindBy(locator = "dashboard.conveyor.icon")
    protected CustomMobileElement conveyorIcon;

    @FindBy(locator = "dashboard.corporate.icon")
    protected CustomMobileElement corporateIcon;

    @FindBy(locator = "dashboard.tool.icon")
    protected CustomMobileElement toolIcon;

    @FindBy(locator = "dashboard.inspection.icon")
    protected CustomMobileElement inspectionIcon;

    @FindBy(locator = "dashboard.addImg.btn")
    protected CustomMobileElement addImage;

    @FindBy(locator = "dashboard.sites.card")
    protected CustomMobileElement sitesCard;

    @FindBy(locator = "dashboard.conveyors.card")
    protected CustomMobileElement conveyorsCard;

    @FindBy(locator = "dashboard.coverWear.card")
    protected CustomMobileElement coverWearCard;

    @FindBy(locator = "dashboard.inspections.card")
    protected CustomMobileElement inspectionsCard;

    @FindBy(locator = "dashboard.camera.icon")
    protected CustomMobileElement camera;

    @FindBy(locator = "dashboard.gallery.btn")
    protected CustomMobileElement gallery;

    @FindBy(locator = "dashboard.alert.popup")
    protected CustomMobileElement alertMsg;
    
    @FindBy(locator = "dashboard.permission.dismiss")
    protected CustomMobileElement dontAllow;

    @FindBy(locator = "dashboard.ok.btn")
    protected CustomMobileElement ok;

    @FindBy(locator = "dashboard.firstSearch.map")
    protected CustomMobileElement firstMapSearch;

    @FindBy(locator = "coverWear.firstSearch.dropdown")
    protected CustomMobileElement firstSearchDropdown;

    @FindBy(locator = "dashboard.search.txt")
    protected CustomMobileElement searchResult;

    @FindBy(locator = "dashboard.firstSearch.list")
    protected CustomMobileElement firstSearchResult;

    @FindBy(locator = "dashboard.coverWear.Btn")
    protected CustomMobileElement coverWear;
    
    @FindBy(locator = "dashboard.coverWear.position")
    protected CustomMobileElement positionCoverWear;
    
    @FindBy(locator = "dashboard.coverWear.headerTxt")
    protected CustomMobileElement headerText;
    
    @FindBy(locator = "dashboard.coverWear.positions")
    protected List<CustomMobileElement> positions;

    @FindBy(locator = "corporate.edit.btn")
    protected CustomMobileElement corpEditBtn;

    @FindBy(locator = "company.search.back")
    protected CustomMobileElement searchBack;

    @FindBy(locator = "company.filter.icon")
    protected CustomMobileElement corporateFilterIcon;

    @FindBy(locator = "company.filter.close")
    protected CustomMobileElement corporateFilterClose;

    @FindBy(locator = "company.filter.ascending")
    protected CustomMobileElement corporateFilterAscending;

    @FindBy(locator = "company.filter.descending")
    protected CustomMobileElement corporateFilterDescending;

    @FindBy(locator = "company.filter.distributor")
    protected CustomMobileElement corporateFilterDistributor;

    @FindBy(locator = "company.filter.customer")
    protected CustomMobileElement corporateFilterCustomer;

    @FindBy(locator = "company.filter.market")
    protected CustomMobileElement corporateFilterMarket;

    @FindBy(locator = "company.filter.corporateType")
    protected CustomMobileElement corporateFilterType;

    @FindBy(locator = "company.filter.customerCorporate")
    protected CustomMobileElement customerFilterType;

    @FindBy(locator = "company.filter.site")
    protected CustomMobileElement siteFilterType;

    @FindBy(locator = "filter.first.result")
    protected CustomMobileElement corporateFilterFirstResult;

    @FindBy(locator = "company.filter.save")
    protected CustomMobileElement corporateFilterSave;

    @FindBy(locator = "filter.corporate.apply")
    protected CustomMobileElement filterCorporateApply;

    @FindBy(locator = "site.firstSearch.dropdown")
    protected CustomMobileElement siteFirstSearchDropdown;

    @FindBy(locator = "site.territory.firstSearch")
    protected CustomMobileElement territoryFirstSearchDropdown;

    @FindBy(locator = "corporate.details.search")
    protected CustomMobileElement corporateDetailsSearch;

    @FindBy(locator = "corporate.details.name")
    protected CustomMobileElement corporateDetailsName;

    @FindBy(locator = "site.search.firstResult")
    protected CustomMobileElement siteSearchFirstResult;

    @FindBy(locator = "dashboard.conveyor.firstSearch")
    protected CustomMobileElement conveyorFirstSearch;

    @FindBy(locator = "conveyor.delete.btn")
    protected CustomMobileElement conveyorDeleteBtn;

    @FindBy(locator = "conveyor.delete.txt")
    protected CustomMobileElement conveyorDeleteTxt;

    @FindBy(locator = "conveyor.details.TechnicalData")
    protected CustomMobileElement conveyorTechnicalDataDetails;

    @FindBy(locator = "conveyor.details.CoverWear")
    protected CustomMobileElement conveyorCoverWearDetails;

    @FindBy(locator = "conveyor.details.Inspection")
    protected CustomMobileElement conveyorInspectionDetails;

    @FindBy(locator = "conveyor.details.FileManager")
    protected CustomMobileElement conveyorFileManagerDetails;

    @FindBy(locator = "filter.dropdown.firstSearch")
    protected CustomMobileElement filterDropdownFirstSearch;

    @FindBy(locator = "filter.dropdown.save")
    protected CustomMobileElement filterDropdownSave;

    public void refreshPage() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        refreshScreen();
        switchContext("FLUTTER");
    }


    public void imageUpload() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        addImage.click();
        camera.click();
        if(alertMsg.isVisible("Alert message"))
            dontAllow.click();
        switchContext("FLUTTER");
    }

    public boolean isMap(){
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean flag = firstMapSearch.isDisplayed();
        switchContext("FLUTTER");
        return flag;
    }

    public void gMapSelection() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Rectangle rect = firstMapSearch.getRect();
        tapByCoordinates(rect.x + (rect.width / 2), rect.y + (rect.height / 3));
        switchContext("FLUTTER");
    }

    public void goToCorporateSearch() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        corporateIcon.click();
        searchIcon.click();
        switchContext("FLUTTER");
    }

    public void goToConveyorSearch() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        conveyorIcon.click();
        searchIcon.click();
        switchContext("FLUTTER");
    }

    public void goToSearch() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchIcon.click();
        switchContext("FLUTTER");
    }

    public void goBackFromSearch() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBack.click();
        switchContext("FLUTTER");
    }

    public void enterSearchQuery(String query){
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        corporateDetailsSearch.sendKeys(query);
        switchContext("FLUTTER");
    }

    public void goBackToDashboard() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBack.click();
        homeIcon.click();
        switchContext("FLUTTER");
    }

    public String getNameFromCard() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        siteSearchFirstResult.click("First result");
        SyncUtil.waitFor(500);
        String val = corporateDetailsName.getAttribute("content-desc");
        Reporter.log("corporate name:= "+val);
        switchContext("FLUTTER");
        return val;
    }

    public String getFirstSearchSiteShop() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String val = siteSearchFirstResult.getAttribute("content-desc");
        Reporter.log("corporate name:= "+val);
        switchContext("FLUTTER");
        return val;
    }

    public String getSearchCount() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String str;
        if(getAppiumDriver() instanceof AndroidDriver)
            str= MiscUtils.regexExtractor(searchResult.getAttribute("content-desc"),"(^[0-9]*)");
        else
            str=  searchResult.getText();
        switchContext("FLUTTER");
        return str;
    }

    public String getSearchText() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String str;
        if(getAppiumDriver() instanceof AndroidDriver)
            str= searchResult.getAttribute("content-desc");
        else
            str=  searchResult.getText();
        switchContext("FLUTTER");
        return str;
    }

    public String getSearchResult() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String str;
        if(getAppiumDriver() instanceof AndroidDriver)
            str=  firstSearchResult.getAttribute("content-desc");
        else
            str=  firstSearchResult.getText();
        switchContext("FLUTTER");
        return str;
    }

    public String getConveyorSearchResult() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String str;
        if(getAppiumDriver() instanceof AndroidDriver)
            str=  conveyorFirstSearch.getAttribute("content-desc");
        else
            str=  conveyorFirstSearch.getText();
        switchContext("FLUTTER");
        return str;
    }

    public void navigateInsideCorp() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        firstSearchResult.click();
        switchContext("FLUTTER");
    }

    public void navigateInsideConveyor() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        conveyorFirstSearch.click();
        switchContext("FLUTTER");
    }

    public boolean isCorpEdit() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean flag= corpEditBtn.isEnabled();
        switchContext("FLUTTER");
        return flag;
    }

    public void clickEditBtn() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        corpEditBtn.click("Corporate Edit");
        switchContext("FLUTTER");
    }

    public boolean isCorporateList() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean flag = searchResult.isDisplayed();
        switchContext("FLUTTER");
        return flag;
    }

    public boolean goToFilterScreen() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        filterIcon.click("Filter");
        return corporateFilterIcon.isDisplayed();
    }

    public void filterDescendingOrder() {
       corporateFilterDescending.click("descending order");
    }

    public void filterDistributorCorporate() {
        corporateFilterDistributor.click("distributor corporate");
    }

    public void filterCustomerCorporate() {
        corporateFilterCustomer.click("customer corporate");
    }

    public boolean filterCorporateFromDropdown(String corp) {
        corporateFilterType.click("Corporate dropdown");
        switchContext("FLUTTER");
        CorporatePage.getInstance().filterCorporateType(corp);
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        filterDropdownFirstSearch.click("first search");
        filterCorporateApply.click("Dropdown Apply");
        filterDropdownSave.click("Save");
       return !corporateFilterType.isVisible();
    }

    public boolean filterSiteFromDropdown(String corp) {
        siteFilterType.click("Corporate dropdown");
        switchContext("FLUTTER");
        CorporatePage.getInstance().filterCorporateType(corp);
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        filterDropdownFirstSearch.click("first search");
        filterCorporateApply.click("Dropdown Apply");
        filterDropdownSave.click("Save");
        return !siteFilterType.isVisible();
    }


    public boolean saveFilter() {
        corporateFilterSave.click("Apply filter changes");
        boolean flag = !corporateFilterIcon.isVisible();
        switchContext("FLUTTER");
        return flag;
    }

    public boolean resetFilter() {
        goToFilterScreen();
        corporateFilterIcon.click("Reset Filter");
        corporateFilterSave.click("Filter Save");
        return !corporateFilterIcon.isVisible();
    }

    public String goToConveyor(String conveyor){
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homeIcon.click();
        conveyorsCard.click();
        searchIcon.click();
        switchContext("FLUTTER");
//        dashboardPage.enterSearchQuery(conveyor);
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        firstSearchResult.click();
        String str=  headerText.getText();
        switchContext("FLUTTER");
        return str;
    }

    public boolean verifyConveyorDetails(){
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean flag = conveyorTechnicalDataDetails.isVisible("Technical Data") && conveyorCoverWearDetails.isVisible("Cover Wear") && conveyorInspectionDetails.isVisible("Inspection") && conveyorFileManagerDetails.isVisible("File Manager");
        switchContext("FLUTTER");
        return flag;
    }

    public void goToCoverWear(){
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        coverWear.click();
        positionCoverWear.click();
        switchContext("FLUTTER");
    }

    public void selectFirstSearch() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Rectangle rect = firstSearchDropdown.getRect();
        tapByCoordinates(rect.x + (rect.width / 2), rect.y + (rect.height / 3));
        switchContext("FLUTTER");
    }

    public void selectFirstSearchSiteScreen() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        siteFirstSearchDropdown.click("First result");
        switchContext("FLUTTER");
    }

    public void selectFirstSearchTerritorySiteScreen() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        territoryFirstSearchDropdown.click("First territory result");
        switchContext("FLUTTER");
    }

    public void selectCalenderDate() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ok.click();
        switchContext("FLUTTER");
    }

    public void verifyPositionCount() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(positions.size(), 2);
        switchContext("FLUTTER");
    }

    public void verifyPositionsValues() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(positions.get(0).getAttribute("content-desc"));
        if(getAppiumDriver() instanceof AndroidDriver) {
            Assert.assertTrue(positions.get(0).getAttribute("content-desc").contains("Top"), "Position name verification");
            Assert.assertTrue(positions.get(0).getAttribute("content-desc").contains("50"), "Durometer verification");
            Assert.assertTrue(positions.get(1).getAttribute("content-desc").contains("Bottom"), "Position name verification");
            Assert.assertTrue(positions.get(1).getAttribute("content-desc").contains("50"), "Durometer verification");
        }
        else{
            Assert.assertTrue(positions.get(0).getText().contains("Top"), "Position name verification");
            Assert.assertTrue(positions.get(0).getText().contains("50"), "Durometer verification");
            Assert.assertTrue(positions.get(1).getText().contains("Bottom"), "Position name verification");
            Assert.assertTrue(positions.get(1).getText().contains("50"), "Durometer verification");
        }
        switchContext("FLUTTER");
    }

    public void handlingPopup() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if(getAppiumDriver() instanceof AndroidDriver) {
            Assert.assertTrue(positions.get(0).getAttribute("content-desc").contains("Top"), "Position name verification");
            Assert.assertTrue(positions.get(0).getAttribute("content-desc").contains("50"), "Durometer verification");
            Assert.assertTrue(positions.get(1).getAttribute("content-desc").contains("Bottom"), "Position name verification");
            Assert.assertTrue(positions.get(1).getAttribute("content-desc").contains("50"), "Durometer verification");
        }
        else{
            Assert.assertTrue(positions.get(0).getText().contains("Top"), "Position name verification");
            Assert.assertTrue(positions.get(0).getText().contains("50"), "Durometer verification");
            Assert.assertTrue(positions.get(1).getText().contains("Bottom"), "Position name verification");
            Assert.assertTrue(positions.get(1).getText().contains("50"), "Durometer verification");
        }
        switchContext("FLUTTER");
    }

    public boolean deleteConveyor() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        conveyorDeleteBtn.click("Conveyor edit Btn");
        conveyorDeleteTxt.isVisible("Conveyor Name");
        conveyorDeleteBtn.click();
        boolean flag = !conveyorDeleteTxt.isVisible();
        switchContext("FLUTTER");
        return flag;
    }


}
