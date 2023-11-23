package com.mobile.flutter.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.mobile.utils.DIRECTION;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import org.testng.Assert;

public class ConveyorPage extends FlutterBasePage {

    private static ConveyorPage obj;

    public static ConveyorPage getInstance(){
        if(obj==null)
            obj = new ConveyorPage();
        return obj;
    }

    @FindBy(locator = "conveyor.name.field")
    public CustomFlutterElement conveyorNameField;

    @FindBy(locator = "conveyor.distributor.field")
    public CustomFlutterElement distributorField;

    @FindBy(locator = "conveyor.customer.field")
    public CustomFlutterElement customerField;

    @FindBy(locator = "conveyor.search.dropdown")
    public CustomFlutterElement searchDropdown;

    @FindBy(locator = "conveyor.save.btn")
    public CustomFlutterElement saveBtn;

    @FindBy(locator = "conveyor.frame.screen")
    public CustomFlutterElement conveyorFrame;

    @FindBy(locator = "conveyor.details.back")
    public CustomFlutterElement conveyorBackBtn;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Ancestor\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"ListView\\\"}\",\"of\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Expanded\\\"}\"}")
    public CustomFlutterElement conveyorFirstResult;

    @FindBy(locator = "conveyor.details.technicalData")
    public CustomFlutterElement conveyorTechnicalDataDetails;

    @FindBy(locator = "conveyor.details.coverWear")
    public CustomFlutterElement conveyorCoverWearDetails;

    @FindBy(locator = "conveyor.details.inspection")
    public CustomFlutterElement conveyorInspectionDetails;

    @FindBy(locator = "conveyor.details.fileManager")
    public CustomFlutterElement conveyorFileManagerDetails;

    @FindBy(locator = "conveyor.list.download")
    public CustomFlutterElement conveyorDownloadBtn;

    @FindBy(locator = "conveyor.list.upload")
    public CustomFlutterElement conveyorUploadBtn;

    @FindBy(locator = "conveyor.list.more")
    public CustomFlutterElement conveyorMoreBtn;

    @FindBy(locator = "conveyor.more.edit")
    public CustomFlutterElement conveyorEditBtn;

    @FindBy(locator = "conveyor.more.delete")
    public CustomFlutterElement conveyorDeleteBtn;

    public boolean isConveyorPage() {
        return conveyorNameField.isPresent();
    }

    public boolean addConveyor(String conveyorName, String custSiteName, String distShopName) {
        conveyorNameField.sendKeys(conveyorName);

        customerField.click("Customer dropdown");
        searchDropdown.sendKeys(custSiteName, "Customer");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        distributorField.click("Distributor dropdown");
        searchDropdown.sendKeys(distShopName, "Distributor");
        DashboardNativePage.getInstance().selectFirstSearchTerritorySiteScreen();

//        saveBtn.scrollIntoView("Save Btn");
        saveBtn.scrollToElement(conveyorFrame, DIRECTION.DOWN, "Save Btn");
        saveBtn.click();

        saveBtn.waitForTheElementToBeInvisible(5000);
        return !saveBtn.isVisible();
    }

    public boolean verifyConveyorCreation(String company) {
        DashboardNativePage.getInstance().goToConveyorSearch();
        SyncUtil.waitFor(5000);
        DashboardNativePage.getInstance().enterSearchQuery(company);
//        CorporatePage.getInstance().enterSearchQuery(company);
        System.out.println(DashboardNativePage.getInstance().getSearchCount());
        System.out.println(DashboardNativePage.getInstance().getConveyorSearchResult());
        Assert.assertTrue(DashboardNativePage.getInstance().getSearchCount().equals("1"),"Search Result Count");
        return DashboardNativePage.getInstance().getConveyorSearchResult().contains(company);
    }

    public boolean verifyConveyorDelete(String company) {
        DashboardNativePage.getInstance().goToConveyorSearch();
        SyncUtil.waitFor(5000);
        CorporatePage.getInstance().enterSearchQuery(company);
        return DashboardNativePage.getInstance().getSearchText().contains("No");
    }

    public boolean conveyorDetailsNav(String company) {
        DashboardNativePage.getInstance().goToConveyorSearch();
        SyncUtil.waitFor(5000);
        DashboardNativePage.getInstance().enterSearchQuery(company);
        return goToConveyorDetails();
    }

    public boolean goToConveyorDetails() {
        DashboardNativePage.getInstance().navigateInsideConveyor();
        return  DashboardNativePage.getInstance().verifyConveyorDetails();
    }

    public boolean goBackToConveyorList() {
        DashboardNativePage.getInstance().goBackFromSearch();
        SyncUtil.waitFor(1000);
        return conveyorFirstResult.isVisible("Conveyor First Result");
    }

    public boolean clickOnConveyorMore() {
        SyncUtil.waitFor(2000);
        conveyorMoreBtn.click("Conveyor more Btn");
        return conveyorEditBtn.isVisible("Conveyor Edit Btn");
    }

    public boolean goToEditConveyor() {
        clickOnConveyorMore();
        conveyorEditBtn.click("Conveyor edit Btn");
        return conveyorNameField.isVisible("Conveyor Name");
    }

    public boolean goToDeleteConveyor() {
        clickOnConveyorMore();
        return DashboardNativePage.getInstance().deleteConveyor();
    }

    public boolean updateConveyorName(String conveyorName, String custSiteName, String distShopName){
        conveyorNameField.sendKeys(conveyorName);

        customerField.click("Customer dropdown");
        searchDropdown.sendKeys(custSiteName, "Customer");
        DashboardNativePage.getInstance().selectFirstSearchTerritorySiteScreen();

        distributorField.click("Distributor dropdown");

        searchDropdown.sendKeys(distShopName, "Distributor");
        DashboardNativePage.getInstance().selectFirstSearchTerritorySiteScreen();

//        saveBtn.scrollIntoView("Save Btn");
        saveBtn.scrollToElement(conveyorFrame, DIRECTION.DOWN, "Save Btn");
        SyncUtil.waitFor(4000);
        saveBtn.click();

        saveBtn.waitForTheElementToBeInvisible(5000);
        return !saveBtn.isVisible();
    }
}
