package com.mobile.flutter.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.mobile.utils.DIRECTION;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;
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

    @FindBy(locator = "corporate.conveyorList.header")
    public CustomFlutterElement conveyorListHeader;

    @FindBy(locator = "conveyor.add.icon")
    public CustomFlutterElement addIcon;

    @FindBy(locator = "conveyor.add.header")
    public CustomFlutterElement addConveyorHeader;

    @FindBy(locator = "conveyor.toast.error")
    public CustomFlutterElement addConveyorNameError;



    @FindBy(locator = "dashboard.loading.animation")
    public CustomFlutterElement loadingDashboard;



    @FindBy(locator = "conveyor.distributor.fieldtext")
    public CustomFlutterElement distributorFieldText;




    public boolean isConveyorPage() {
        Validator.assertTrue(conveyorListHeader.isPresent(),"user navigated to conveyor list page","user navigated to conveyor list page");
        return conveyorListHeader.isPresent();
    }

    public boolean isAddConveyorPage() {
        Validator.assertTrue(addConveyorHeader.isPresent(),"user navigated to add conveyor page","user navigated to add conveyor  page");
        return addConveyorHeader.isPresent();
    }

    public boolean addConveyor(String conveyorName, String custSiteName, String distShopName) {
        waitForPageToLoad();
        conveyorNameField.sendKeys(conveyorName);
        customerField.click("Customer dropdown");
        searchDropdown.sendKeys(custSiteName, "Customer");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();
        SyncUtil.waitFor(5000);

        distributorField.click("Distributor dropdown");

        searchDropdown.sendKeys(distShopName, "Distributor");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

//        saveBtn.scrollIntoView("Save Btn");
        saveBtn.scrollToElement(conveyorFrame, DIRECTION.DOWN, "Save Btn");
        saveBtn.click();

        saveBtn.waitForTheElementToBeInvisible(5000);
        return !saveBtn.isVisible();
    }

    public boolean addConveyorWithDistShop(String conveyorName, String custSiteName, String distShopName) {

        conveyorNameField.sendKeys(conveyorName);

        distributorField.click("Distributor dropdown");
        searchDropdown.sendKeys(distShopName, "Distributor");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        customerField.click("Customer dropdown");
        DashboardNativePage.getInstance().verifyCustomerSite();
        searchDropdown.sendKeys(custSiteName, "Customer");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

//        saveBtn.scrollIntoView("Save Btn");
        saveBtn.scrollToElement(conveyorFrame, DIRECTION.DOWN, "Save Btn");
        saveBtn.click();

        saveBtn.waitForTheElementToBeInvisible(5000);
        return !saveBtn.isVisible();
    }


    public void addConveyorWithoutName(String custSiteName, String distShopName)
    {
        customerField.click("Customer dropdown");
        searchDropdown.sendKeys(custSiteName, "Customer");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        distributorField.click("Distributor dropdown");
        searchDropdown.sendKeys(distShopName, "Distributor");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

//        saveBtn.scrollIntoView("Save Btn");
        saveBtn.scrollToElement(conveyorFrame, DIRECTION.DOWN, "Save Btn");
        saveBtn.click();
        addConveyorNameError.waitForTheElementToBeVisible(45);
        Validator.assertTrue(addConveyorNameError.isVisible(),"error message is displayed when conveyor name is not entered","error message is displayed when conveyor name is not entered");

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

    public boolean editConveyorName(String conveyorName){
        conveyorNameField.clear();
        conveyorNameField.sendKeys(conveyorName);
        saveBtn.scrollToElement(conveyorFrame, DIRECTION.DOWN, "Save Btn");
        SyncUtil.waitFor(4000);
        saveBtn.click();

        saveBtn.waitForTheElementToBeInvisible(5000);
        return !saveBtn.isVisible();
    }

    public void addBtnClick()
    {
        addIcon.click();
    }

    public void verifyConveyorListPageNavigation()
    {
        SyncUtil.waitFor(40000);
        Validator.assertTrue(conveyorListHeader.isDisplayed(),"User is not navigated to conveyor list screen","User is not navigated to conveyor list screen");
//        SyncUtil.waitFor(5000);
    }
    public boolean goToAddConveyorViaConvList() {
        loadingDashboard.waitForTheElementToBeInvisible(45);
        addIcon.waitForTheElementToBeVisible(30);
        addIcon.click();
        return ConveyorPage.getInstance().isConveyorPage();
    }
    public void clickDistShopAndVerifySearch() {
        SyncUtil.waitFor(8000);
        distributorField.waitForTheElementToBeVisible(45);
        distributorField.click("Distributor dropdown");
        Validator.assertTrue(searchDropdown.isDisplayed(),"Search option is not displayed","Search option is displayed");
    }
    public void searchSelectDistributorShop(String distShop) {
        searchDropdown.sendKeys(distShop, "Distributor");
        SyncUtil.waitFor(10000);
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();
        System.out.println("until here");
        SyncUtil.waitFor(5000);
        System.out.println(distributorFieldText.getText());
        System.out.println("until here2");
        System.out.println(distributorFieldText.getText()+"   distribuorField   "+distShop);
        Validator.assertTrue(distributorFieldText.getText().contains(distShop),"Distributor Shop is not selected properly","Distributor Shop is selected properly");
    }

    public boolean verifyConveyorIsPresent(String company) {
        DashboardNativePage.getInstance().goToSearch();
        SyncUtil.waitFor(5000);
        DashboardNativePage.getInstance().enterSearchQuery(company);
        System.out.println(DashboardNativePage.getInstance().getSearchCount());
        System.out.println(DashboardNativePage.getInstance().getConveyorSearchResult());
        Assert.assertTrue(DashboardNativePage.getInstance().getSearchCount().equals("1"),"Search Result Count");
        return DashboardNativePage.getInstance().getConveyorSearchResult().contains(company);
    }
    public void fileManagerCardClick() {
        Validator.assertTrue(conveyorFileManagerDetails.isVisible(),"File Manager is not Visible","File Manager is visible");
        conveyorFileManagerDetails.click();
    }

}
