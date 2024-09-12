package com.mobile.flutter.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.util.Validator;
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

    @FindBy(locator = "dashboard.card.conveyor")
    public CustomFlutterElement conveyorTile;

    @FindBy(locator = "corporate.conveyorList.header")
    public CustomFlutterElement conveyorListHeader;
    @FindBy(locator = "dashboard.filter.header")
    public CustomFlutterElement filterHeader;
    @FindBy(locator = "dashboard.filter.button")
    public CustomFlutterElement filterBtn;


    public boolean isHomePage() {
        Validator.assertTrue(homeTitle.isPresent(),"User is not navigated Home Page","User is navigated Home Page");
        return homeTitle.isPresent();
    }

    public boolean goToProfilePage() {
        SyncUtil.waitFor(000);
        profileIcon.click();
        return ProfilePage.getInstance().isMyProfile();
    }

//    public boolean goToConveyorTile() {
//        profileIcon.click();
//        return ConveyorPage.getInstance().isMyProfile();
//    }

    public void addIconClick()
    {
        loadingDashboard.waitForTheElementToBeInvisible(45);
        addIcon.waitForTheElementToBeVisible(30);
        Validator.assertTrue(addIcon.isDisplayed(),"Add Icon is not Visible","Add Icon is Visible");
        addIcon.click();
        Validator.assertTrue(addCorporate.isDisplayed(),"Add Corporate is not Visible","Add Corporate is Visible");
        Validator.assertTrue(addSiteShop.isDisplayed(),"Add Site is not Visible","Add Site is Visible");
    }



    public boolean goToSiteShop() {
        addIconClick();
        addSiteShop.click();
        return CorporatePage.getInstance().isCompanyPage();
    }

    public boolean goToConveyor() {
        addIconClick();
        addConveyor.click();
        return ConveyorPage.getInstance().isConveyorPage();
    }

    public boolean goToInspection() {
        addIconClick();
        addInspection.click();
        return InspectionPage.getInstance().isInspectionPage();
    }

    public void conveyorTileClick()
    {
        DashboardNativePage.getInstance().conveyorCardClick();
        ConveyorPage.getInstance().isConveyorPage();
    }
    public boolean addInspectionClick()
    {
        addInspection.waitForTheElementToBeVisible(10000);
        addInspection.click();
        return InspectionPage.getInstance().isInspectionPage();
    }

    public void inspectionTileClick()
    {
        DashboardNativePage.getInstance().inspectionCardClick();
        CorporatePage.getInstance().isInspectionListPage();
    }

    public void coverWearTileClick()
    {
        DashboardNativePage.getInstance().coverWearCardClick();
        CoverWearPage.getInstance().isCoverWearPage();
        waitForPageToLoad();
        SyncUtil.waitFor(40000);

    }

    public void siteTileClick()
    {
        DashboardNativePage.getInstance().siteCardClick();
        SitePage.getInstance().isSitesPage();
    }
   public void verifyHomeAddIconFields()
   {
       addCorporate.waitForTheElementToBeVisible(10000);
       Validator.assertTrue(addCorporate.isVisible()&&addConveyor.isVisible()&&addSiteShop.isVisible()&&addInspection.isVisible(),
               "Add Inspection Add Conveyor Add Site/Shop Add Corporate buttons are not visible","Add Inspection Add Conveyor Add Site/Shop Add Corporate buttons are not visible");

   }
    public void verifyHomeScreenDetails() {
        DashboardNativePage.getInstance().verifyHomeScreenDetailsNative();
        Validator.assertTrue(addIcon.isDisplayed(),"Add Icon is not Visible","Add Icon is Visible");
    }

    public boolean verifyHomePageAddIcon() {
        loadingDashboard.waitForTheElementToBeInvisible(15);
        addIcon.waitForTheElementToBeVisible(15);
        Validator.assertTrue(addIcon.isDisplayed(),"Add Icon is not Visible","Add Icon is Visible");
        addIcon.click();
        Validator.assertTrue(addCorporate.isDisplayed(),"Add Corporate is not Visible","Add Corporate is Visible");
        Validator.assertTrue(addSiteShop.isDisplayed(),"Add Site is not Visible","Add Site is Visible");
        Validator.assertTrue(addConveyor.isDisplayed(),"Add Conveyor is not Visible","Add Conveyor is Visible");
        Validator.assertTrue(addInspection.isDisplayed(),"Add Inspection is not Visible","Add Inspection is Visible");
        return addCorporate.isDisplayed();
    }

    public boolean goToAddCorp() {
        Validator.assertTrue(verifyHomePageAddIcon(),"Home Page Navigation is not valid","Home Page Navigation is valid");
        addCorporate.click();
        return CorporatePage.getInstance().isCompanyPage();
    }
    public void filterBtnClick()
    {
        filterBtn.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(filterBtn.isVisible(),"The filter icon is not visible","The filter icon is visible");
        filterBtn.click();
        filterHeader.waitForTheElementToBeVisible(10000);
        Validator.assertTrue(filterHeader.isVisible(),"The Filter header is not visible","The Filter header is visible");
    }





}
