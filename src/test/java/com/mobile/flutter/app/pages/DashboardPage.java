package com.mobile.flutter.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import org.testng.Assert;

public class DashboardPage extends FlutterBasePage {

    private static DashboardPage obj;

    public static DashboardPage getInstance(){
        if(obj==null)
            obj = new DashboardPage();
        return obj;
    }

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub
    }

    @FindBy(locator = "dashboard.home.title")
    public CustomFlutterElement homeTitle;

    @FindBy(locator = "dashboard.loading.animation")
    public CustomFlutterElement loadingDashboard;

    @FindBy(locator = "dashboard.add.icon")
    public CustomFlutterElement addIcon;

    @FindBy(locator = "dashboard.profiles.icon")
    public CustomFlutterElement profileIcon;

    @FindBy(locator = "dashboard.add.conveyor")
    public CustomFlutterElement addConveyor;

    @FindBy(locator = "dashboard.add.corporate")
    public CustomFlutterElement addCorporate;

    @FindBy(locator = "dashboard.add.site")
    public CustomFlutterElement addSiteShop;

    @FindBy(locator = "dashboard.add.inspection")
    public CustomFlutterElement addInspection;


    public boolean isHomePage() {
        return homeTitle.isPresent();
    }

    public boolean goToProfilePage() {
        profileIcon.click();
        return ProfilePage.getInstance().isMyProfile();
    }

//    public boolean goToConveyorTile() {
//        profileIcon.click();
//        return ConveyorPage.getInstance().isMyProfile();
//    }

    public boolean goToAddCorp() {
        loadingDashboard.waitForTheElementToBeInvisible(45);
        addIcon.waitForTheElementToBeVisible(30);
        addIcon.click();
        addCorporate.click();
        return CorporatePage.getInstance().isCompanyPage();
    }

    public boolean goToSiteShop() {
        loadingDashboard.waitForTheElementToBeInvisible(45);
        addIcon.waitForTheElementToBeVisible(30);
        addIcon.click();
        addSiteShop.click();
        return CorporatePage.getInstance().isCompanyPage();
    }

    public boolean goToConveyor() {
        loadingDashboard.waitForTheElementToBeInvisible(45);
        addIcon.waitForTheElementToBeVisible(30);
        addIcon.click();
        addConveyor.click();
        return ConveyorPage.getInstance().isConveyorPage();
    }

    public boolean goToInspection() {
        loadingDashboard.waitForTheElementToBeInvisible(45);
        addIcon.waitForTheElementToBeVisible(30);
        addIcon.click();
        addInspection.click();
        return InspectionPage.getInstance().isInspectionPage();
    }


}
