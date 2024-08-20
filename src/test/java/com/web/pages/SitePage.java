package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static java.lang.Integer.parseInt;

public class SitePage  extends BasePage {

    @FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
    public CustomElement home;

    @FindBy(locator = "xpath=(//li//span[text()='Sites'])[1]")
    public CustomElement sites;

    @FindBy(locator = "xpath=//input[@placeholder='Search']")
    public CustomElement btSearchinput;

    @FindBy(locator = "xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement btCheckbox;

    @FindBy(locator = "xpath=(//button/chevrondownicon)[2]")
//    @FindBy(locator="xpath=(//button/span[contains(@class,'pi-chevron-down')])[2]")
    public CustomElement btActions;

    @FindBy(locator = "xpath=//span[text()='Edit']")
    public CustomElement btEdit;

    @FindBy(locator = "xpath=//span[text()='Delete']")
    public CustomElement btDelete;

    @FindBy(locator = "xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
    public CustomElement btViewIcon;

    @FindBy(locator = "xpath=//span[text()='Update']")
    public CustomElement btUpdate;

    @FindBy(locator = "xpath=//span[text()='Yes']")
    public CustomElement yesConfirmation;

    @FindBy(locator = "xpath=//td[contains(text(),'No')]")
    public CustomElement noList;

    @FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
    public CustomElement pagination;

    @FindBy(locator = "xpath=(//app-card//div[text()='File Manager'])[1]")
    public CustomElement fileManager;

    @FindBy(locator = "xpath=(//span[contains(@class,'p-panel-title')])[1]")
    public CustomElement siteHeader;

    @FindBy(locator = "xpath=(//div[contains(@class,'p-carousel-item')]//app-card//div[@class='card-inner-wrapper' and contains(div, 'Sites')])[1]")
    public CustomElement siteCard;

    @FindBy(locator = "xpath=(//td//i[contains(@class,'ctp-icon-Favorite')])[1]")
    public CustomElement subscribePinIcon;

    @FindBy(locator = "xpath=(//td//i[contains(@class,'marker-icon-red')])[1]")
    public CustomElement subscribedPinIcon;
    @FindBy(locator = "xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement crCheckbox;
    @FindBy(locator = "xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
    public CustomElement crviewicon;
    @FindBy(locator = "xpath=(//button/chevrondownicon)[2]")
    public CustomElement crActions;

    @FindBy(locator = "xpath=//span[text()='Edit']")
    public CustomElement crEdit;

    @FindBy(locator = "//li[contains(@class,'topbar-item notification')]")
    public CustomElement bellIcon;

    @FindBy(locator = "//li[contains(@class,'notification-box')]")
    public CustomElement notificationPopup;
    @FindBy(locator = "//li[contains(@class,'topbar-item notification')]//span[contains(@class,'notification-count')]")
    public CustomElement notificationsCount;

    @FindBy(locator = "//a[@href='#/secure/notifications' and text()='View More']")
    public CustomElement viewMoreBtn;

    @FindBy(locator = "//p-multiselect[@placeholder='All']")
    public CustomElement ddlAll;

    @FindBy(locator = "//p-multiselect//div[@class='p-multiselect-trigger']")
    public CustomElement ddlFilterSelector;

    @FindBy(locator = "xpath=//p-multiselect//li[@aria-label='Inspection']")
    public CustomElement ddlInspection;

    @FindBy(locator = "xpath=//p-multiselect//li[@aria-label='Conveyor']")
    public CustomElement ddlConveyor;
    @FindBy(locator = "xpath=//p-multiselect//li[@aria-label='Belt Scans']")
    public CustomElement ddlBeltScans;
    @FindBy(locator = "xpath=//p-multiselect//li[@aria-label='Update Snapshot']")
    public CustomElement ddlUpdateSnapshot;
    @FindBy(locator = "xpath=//p-multiselect//li[@aria-label='Reset']")
    public CustomElement ddlReset;

    @FindBy(locator = "xpath=(//p-calendar[@placeholder='MM/DD/YYYY']//input)[1]")
    public CustomElement tbFromDate;
    @FindBy(locator = "xpath=(//p-calendar[@placeholder='MM/DD/YYYY']//input)[2]")
    public CustomElement tbToDate;
    @FindBy(locator = "xpath=//span[@class='p-button-icon pi pi-refresh']")
    public CustomElement btnRefresh;
    @FindBy(locator = "xpath=//button[@icon=\"ctp-icon-sort-icon-down\"]")
    public CustomElement btnSort;
    @FindBy(locator = "xpath=//div[contains(@class,\"p-panel-content\")]")
    public CustomElement notificationsList;

    @FindBy(locator = "xpath=//div[contains(@class,\"p-multiselect-panel\")]")
    public CustomElement notificationsListPopup;
    @FindBy(locator = "xpath=//div[contains(@class,\"p-multiselect-header\")]//div[@role=\"checkbox\"]\n")
    public CustomElement cbAll;
    @FindBy(locator = "xpath=//div[contains(@class,'p-multiselect-filter-container')]//input[contains(@class,'p-multiselect-filter')]")
    public CustomElement tbMultipleSiteDropdown;

    @FindBy(locator = "xpath=//div[contains(@class,'p-panel-content')]//div//p-skeleton")
    public CustomElement notificationListRefresh;


    public void goToSiteListScreen() {
        if (!sites.isVisible())
            home.click("Home");
        sites.click("Sites List");
        btSearchinput.isVisible("Site Page");
    }

    public void goToSiteListScreenAndWait() {
        goToSiteListScreen();
        scrollPageDown();
        String val = "";
        for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(120); stop > System.nanoTime(); ) {
            if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
                break;
            }
            val = pagination.getText();
            SyncUtil.waitFor(5000);
        }
    }

    public void searchSite(String siteName) {
        goToSiteListScreenAndWait();
        btSearchinput.type(siteName, "site Search");
    }

    public void goToSiteDetails(String siteName) {
        searchSite(siteName);
        waitForElementToDisplay(btCheckbox);
        btViewIcon.click("Site Details");
        waitForElementToDisplay(siteHeader);
        siteHeader.isEnable("File Manager");
    }

    public void deleteSite(String siteName) {
        searchSite(siteName);
        waitForElementToDisplay(btCheckbox);
        btCheckbox.check("Site/Shop Checkbox");
        btActions.click("Actions");
        waitForElementVisible(btDelete, 10000, 500);
        btDelete.click("Delete");
        yesConfirmation.click("Confirm");
    }

    public void verifySiteDelete(String siteName) {
        searchSite(siteName);
        Validator.assertTrue(noList.isVisible("No Site"), "Site was not deleted successfully", "Site Deleted Successfully");
    }

    public void verifySiteListPageNaviagtion() {
        waitForPageLoad(20000);
        waitForElementVisible(siteHeader, 20000, 500);
        Validator.assertTrue(siteHeader.isVisible(), "user is not navigated to site list page", "user is  navigated to site list page");
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/dashboard/sites"), "User is not navigated to site list page", "User is  navigated to site list page");

    }

    public void clickSiteCard() {

        waitForPageLoad(20000);
        waitForElementVisible(siteCard, 20000, 500);
        waitForElementToBeClickable(siteCard);
        siteCard.jsClick();
        waitForPageLoad(20000);
    }

    //    public void searchSite(String siteName)
//    {
//        btSiteSearchInput.type(siteName,"Site Search");
//        WebElement searchedSite=driver.findElement(By.xpath("//p-dropdownitem//li[@role='option' and contains(@aria-label, '"+siteName+"')]"));
//        waitForElementToDisplay(searchedSite);
//        searchedSite.click();
//    }
    public void subscribeSite(String siteName) {
        waitForElementVisible(subscribePinIcon, 10000, 500);
        subscribePinIcon.click();
        setImplicitWait(20000, TimeUnit.MILLISECONDS);
        waitForElementToDisplay(subscribedPinIcon);
        Validator.assertTrue(subscribedPinIcon.isDisplayed(), "The site is not subscribed", "The site is subscribed");

    }

    public void unSubscribe(String siteName) {
        btSearchinput.type(siteName, "site Search");
        waitForElementVisible(subscribedPinIcon, 10000, 500);
        subscribedPinIcon.click();
        waitForElementToDisplay(subscribePinIcon);
        Validator.assertTrue(subscribePinIcon.isDisplayed(), "subscription is not removed", "subscription is removed");

    }

    public void searchSiteAndNavigate(String siteName) {
        searchSite(siteName);
        waitForElementToDisplay(crviewicon);
        crviewicon.click("Site Detail");
        waitForPageLoad(10000);
        siteHeader.isEnable("Site Header");
    }

    public boolean searchConveyorSiteLevel(String conveyorName) {
        btSearchinput.type(conveyorName, "Conveyor Search");
//        SyncUtil.waitFor(10000);
        waitForElementVisible(crCheckbox, 20000, 1000);
        waitForElementToDisplay(crCheckbox);
        return crCheckbox.isVisible("Conveyor Found");
    }

    public void searchConveyorAndEdit(String conveyorName) {
        searchConveyorSiteLevel(conveyorName);
        crCheckbox.check("Conveyor Checkbox");
//        crActions.click("Actions");
//        crEdit.jsClick("Edit");
        SyncUtil.waitFor(5000);
    }

    public void bellIconClick() {
        waitForElementVisible(bellIcon, 10000, 500);
        bellIcon.click();
        Validator.assertTrue(notificationPopup.isDisplayed(), "Notification popup is not displayed", "Notification popup is displayed");

    }

    public void verifyNotificationOrder() {
        String updatedSite1 = "(//app-notification-item//div[contains(@class,\"notification\")])[4]//div[text()='C1 Common Automation Conveyor']";
        String updatedSite2 = "(//app-notification-item//div[contains(@class,\"notification\")])[2]//div[text()='CVA Common Regression']";
        Validator.assertTrue(driver.findElement(By.xpath(updatedSite1)).isDisplayed() && driver.findElement(By.xpath(updatedSite2)).isDisplayed(), "notificatio is not  in last in first out format", "notification in last in first out format");
    }

    public int extractNotificationCount() {
        waitForElementVisible(notificationsCount, 20000, 500);
        int notificationCount = parseInt(notificationsCount.getText());
        System.out.println(notificationCount + "notificationCount");
//        getBundle().setProperty("notificationCnt",notificationCount);
        return notificationCount;
    }

    public void extractNotificationCountBefore() {
        int beforeSubscriptionCount = extractNotificationCount();
        System.out.println(beforeSubscriptionCount + "beforeSubscriptionCount");
        getBundle().setProperty("notificationCntBefore", beforeSubscriptionCount);

    }

    public void extractNotificationCountAfter() {
        int afterSubscriptionCount = extractNotificationCount();
        System.out.println(afterSubscriptionCount + "afterSubscriptionCount");
        getBundle().setProperty("notificationCntAfter", afterSubscriptionCount);

    }

    public void verifyUserNotificationCount() {
        Validator.assertTrue(getBundle().getProperty("notificationCntBefore").equals(getBundle().getProperty("notificationCntAfter")), "User received new notification", "User has not received new notification");
    }

    public void viewMoreBtnClick() {
        waitForElementVisible(viewMoreBtn, 10000, 500);
        viewMoreBtn.jsClick("View More");

    }

    public void verifyNotificationListPageNavigation() {
        waitForPageLoad(20000);
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/notifications"), "User is not navigated to notifications list page", "User is  navigated to notifications list page");

    }

    public void verifyNotificationListFields() {
//        waitForPageLoad(20000);
//        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/notifications"),"User is not navigated to notifications list page","User is  navigated to notifications list page");
        verifyNotificationListPageNavigation();
        scrollPageup();
        waitForElementVisible(ddlAll, 20000, 500);
        waitForElementToBeClickable(ddlAll);
        ddlAll.click();
        setImplicitWait(20000, TimeUnit.MILLISECONDS);
        Validator.assertTrue(ddlInspection.isDisplayed() && ddlConveyor.isDisplayed() && ddlBeltScans.isDisplayed() && ddlUpdateSnapshot.isDisplayed() && ddlReset.isDisplayed(),
                "User cannot see all the values under All dropdown", "User can see all the values under All dropdown");
        Validator.assertTrue(tbFromDate.isDisplayed() && tbToDate.isDisplayed(), "From date and To date fields are not visible", "From date and To Date fields are  visible");
        Validator.assertTrue(btnRefresh.isDisplayed(), "Refresh button is not displayed", "Refresh button is displayed");
        Validator.assertTrue(btnSort.isDisplayed(), "Sort button is not displayed", "Sort button is displayed");
        Validator.assertTrue(notificationsList.isDisplayed(), "Notifications List is not displayed", "Notifications List is displayed");

    }

    public void selectNotificationListFilter(String notificationFilter) {
        scrollPageup();
        waitForElementVisible(ddlAll, 20000, 500);
        waitForElementToBeClickable(ddlAll);
        ddlAll.click();
        setImplicitWait(20000, TimeUnit.MILLISECONDS);
        waitForElementToDisplay(notificationsListPopup);
        Validator.assertTrue(notificationsListPopup.isDisplayed(), "notification filter list popup is not visible", "notification filter list popup is not visible");
        waitForElementVisible(cbAll, 20000, 500);
        waitForElementToBeClickable(cbAll);
        cbAll.jsClick();
        SyncUtil.waitFor(2000);
        waitForElementVisible(btnSort, 10000, 500);
        btnSort.click();
        waitForElementVisible(ddlFilterSelector, 20000, 500);
        waitForElementToBeClickable(ddlFilterSelector);

        ddlFilterSelector.click();
        waitForElementToDisplay(notificationsListPopup);
        waitForElementToDisplay(tbMultipleSiteDropdown);
        tbMultipleSiteDropdown.clear();
        tbMultipleSiteDropdown.sendKeys(notificationFilter);
        String filter = "//p-multiselect//li[@aria-label='" + notificationFilter + "']";
        waitForPresenceOfElement(By.xpath(filter));
        driver.findElement(By.xpath(filter)).click();
    }

    public void verifyListFilterApplied() {
        waitForPageLoad(10000);
        for (int i = 1; i <= 2; i++) {
            String filterList = "(//div[contains(@class,\"p-panel-content\")]//*//div//i[contains(@class,\"ctp-icon-Conveyors\")])['" + i + "']";
            waitForElementToDisplay(driver.findElement(By.xpath(filterList)));
            Validator.assertTrue(driver.findElement(By.xpath(filterList)).isDisplayed(), "The notification list is not rendered as per the selected filter", "The notification list is  rendered as per the selected filte");
        }
    }

    public void verifyUnableToAddToDateLesserFromDate(String toDate, String fromDate) {
        waitForElementToDisplay(tbFromDate);
        tbFromDate.type(fromDate);
        tbToDate.type(toDate);
        btnSort.click();
        Validator.assertTrue(tbToDate.getAttribute("value").isEmpty(), "User is able to add toDate less than from date", "User is not able to add toDate less than fromDate");
    }

    public void sortBtnClick() {
        scrollPageup();
        waitForElementToDisplay(btnSort);
        btnSort.click("sortBtn Click");
    }
    public void refreshBtnClick() {
        scrollPageup();
        waitForElementToDisplay(btnRefresh);
        btnRefresh.click("refreshBtn Click");
    }

    private List<String> getColumnData(int numberOfRows) {
        List<String> columnData = new ArrayList<>();
        for (int i = 1; i <= numberOfRows; i++) {
            String rowXPath = "(//div[contains(@class,'p-panel-content')]//div[" + i + "]//div)[3]";
            WebElement cell = driver.findElement(By.xpath(rowXPath));
            columnData.add(cell.getText().trim());
        }
        return columnData;
    }

    public void verifyIncreasingOrderSorting(int numberOfRows) {
        List<String> columnDataAfterSortingIncreasing = getColumnData(numberOfRows);
        List<String> expectedSortedDataIncreasing = new ArrayList<>(columnDataAfterSortingIncreasing);
        Collections.sort(expectedSortedDataIncreasing);
        Validator.assertTrue(
                columnDataAfterSortingIncreasing.equals(expectedSortedDataIncreasing),
                "Sorting in increasing order is not applied correctly",
                "Sorting is applied in increasing order"
        );
    }
    public void verifyPageRefreshed()
    {
        waitForElementToDisplay(notificationListRefresh);
        Validator.assertTrue(notificationListRefresh.isDisplayed(),"Notification list is not getting refreshed","Notification List is getting refreshed");

    }
}
