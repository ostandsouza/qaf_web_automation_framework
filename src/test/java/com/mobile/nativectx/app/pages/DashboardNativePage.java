package com.mobile.nativectx.app.pages;

import com.mobile.nativectx.app.component.CustomMobileElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import org.openqa.selenium.Rectangle;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class DashboardNativePage extends NativeBasePage {

//    DashboardPage dashboardPage = new DashboardPage();
//
//    @FindBy(locator = "accessibility id=Home")
//    protected CustomMobileElement home;
    
    @FindBy(locator = "dashboard.search.icon")
    protected CustomMobileElement searchIcon;
    
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

    @FindBy(locator = "dashboard.firstSearch.dropdown")
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

    public void imageUpload() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        addImage.click();
        camera.click();
        if(alertMsg.isVisible("Alert message"))
            dontAllow.click();
        switchContext("FLUTTER");
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

    public String getSearchCount() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String str=  searchResult.getText();
        switchContext("FLUTTER");
        return str;
    }

    public String getSearchResult() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String str=  firstSearchResult.getText();
        switchContext("FLUTTER");
        return str;
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
        Assert.assertTrue(positions.get(0).getText().contains("Top"),"Position name verification");
        Assert.assertTrue(positions.get(0).getText().contains("50"),"Durometer verification");
        Assert.assertTrue(positions.get(1).getText().contains("Bottom"),"Position name verification");
        Assert.assertTrue(positions.get(1).getText().contains("50"),"Durometer verification");
        switchContext("FLUTTER");
    }

    public void handlingPopup() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(positions.get(0).getText().contains("Top"),"Position name verification");
        Assert.assertTrue(positions.get(0).getText().contains("50"),"Durometer verification");
        Assert.assertTrue(positions.get(1).getText().contains("Bottom"),"Position name verification");
        Assert.assertTrue(positions.get(1).getText().contains("50"),"Durometer verification");
        switchContext("FLUTTER");
    }


}
