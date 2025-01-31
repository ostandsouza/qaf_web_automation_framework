package com.web.steps;

import com.common.utils.APIBase;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.ConveyorPage;
import com.web.pages.MonitoringDevicePage;
import com.web.pages.SitePage;

public class SiteSteps  {

    SitePage sitePage = new SitePage();
    ConveyorPage conveyorPage=new ConveyorPage();
    MonitoringDevicePage monitoringDevicePage=new MonitoringDevicePage();

    @QAFTestStep(description="Delete Customer site with {CustSiteName}")
    public void deleteCustomerSite(String custSiteName){
        sitePage.deleteSite(custSiteName);
    }

    @QAFTestStep(description="Verify Deleted Customer site with {CustSiteName}")
    public void verifyDeleteCustomerSite(String custSiteName){
        sitePage.verifySiteDelete(custSiteName);
    }

    @QAFTestStep(description = "Verify that site card is displayed in home page")
    public void verifySiteCardDisplay () {
        sitePage.clickSiteCard();
    }

    @QAFTestStep(description = "Click on the site card and verify it navigates to site list screen")
    public void verifyNavigationToSiteListPage () {
        sitePage.verifySiteListPageNaviagtion();
    }

    @QAFTestStep(description = "subscribe the sites for the user {Site1} and {Site2}")
    public void searchAndSubscribeTwoSites (String site1,String site2) {
        SyncUtil.waitFor(20000);
        sitePage.searchSite(site1);
        sitePage.subscribeSite(site1);
        sitePage.searchSite(site2);
        sitePage.subscribeSite(site2);
    }

    @QAFTestStep(description = "subscribe one site {Site1} for the user")
    public void searchAndSubscribeSite (String site1) {
        SyncUtil.waitFor(20000);
        sitePage.searchSite(site1);
        sitePage.subscribeSite(site1);
    }

    @QAFTestStep(description = "Edit the subscribed sites {Site1} and {ConveyorName}")
    public void editSubscribedSites(String site1,String conveyor1)
    {
        sitePage.searchSiteAndNavigate(site1);
        sitePage.searchConveyorAndEdit(conveyor1);
        conveyorPage.actionBtnClick();
        conveyorPage.selectEditOption();
        conveyorPage.verifyConveyorDetailPageNavigation();
        conveyorPage.editMapLocation();
        conveyorPage.saveButtonClick();

    }
    @QAFTestStep(description = "Verify user is getting site notification in last in first out format for {Value1} {Value2}")
    public void clickAndVerifyNotificationSiteOrder(String value1,String value2)
    {
        sitePage.bellIconClick();
        sitePage.verifyNotificationSiteOrder(value1,value2);
    }

    @QAFTestStep(description = "Unsubscribe the sites {Site1} and {Site2}")
    public void unsubscribeSites(String site1,String site2)
    {
        SyncUtil.waitFor(10000);
//        sitePage.searchSite(site1);
        sitePage.unSubscribe(site1);
//        sitePage.searchSite(site2);
        sitePage.unSubscribe(site2);

    }
    @QAFTestStep(description = "Unsubscribe the site {Site1}")
    public void unsubscribeSite(String site1)
    {
        sitePage.unSubscribe(site1);
    }

    @QAFTestStep(description = "Verify the notification count in bellIcon")
    public void verifyNotificationCount()
    {
//        sitePage.goToSiteListScreenAndWait();
        sitePage.waitForPageLoad(20000);
        sitePage.extractNotificationCountBefore();
    }

    @QAFTestStep(description = "Verify the notification count in bellIcon after subscription and verify user is not getting any notification")
    public void verifyNotificationCountAfterSubscription()
    {
        sitePage.extractNotificationCountAfter();
        sitePage.verifyUserNotificationCount();
    }

    @QAFTestStep(description = "Navigate to siteListPage and click on bellIcon")
    public void navigateToSitePageAndBellIconClick()
    {
        sitePage.goToSiteListScreenAndWait();
        sitePage.bellIconClick();
    }

    @QAFTestStep(description = "Navigate to siteListPage and wait")
    public void navigateToSitePageAndWait()
    {
        sitePage.goToSiteListScreenAndWait();
    }

    @QAFTestStep(description = "Click on View more button and verify the fields in notification list page")
    public void clickViewMoreAndVerifyNotificationListFields()
    {
        sitePage.viewMoreBtnClick();
        sitePage.verifyNotificationListFields();
    }

    @QAFTestStep(description = "Navigate to notifications List page")
    public void navigationToNotificationListPage()
    {
        sitePage.viewMoreBtnClick();
        sitePage.verifyNotificationListPageNavigation();
    }

    @QAFTestStep(description = "Verify the result after providing notification list value as conveyor/site {notificationFilter}")
    public void verifyNotificationListAfterSelectingListFilter(String filter)
    {
        sitePage.selectNotificationListFilter(filter);
        sitePage.verifyListFilterApplied();
    }
    @QAFTestStep(description="Verify user is unable to add toDate {ToDate} less than fromDate {FromDate}")
    public void verifyTheToDateIsLessThanFromDate(String toDate,String fromDate){
        sitePage.verifyUnableToAddToDateLesserFromDate(toDate,fromDate);
    }

    @QAFTestStep(description="Click on sort button and verify that user is able to get notification in ascending/descending order")
    public void clickAndVerifySorting(){
        sitePage.sortBtnClick();
        sitePage.verifyIncreasingOrderSorting(2);
    }

    @QAFTestStep(description="Click on refresh button and verify that data is getting refreshed")
    public void clickAndVerifyRefresh(){
        sitePage.refreshBtnClick();
        sitePage.verifyPageRefreshed();
    }

    @QAFTestStep(description = "Verify new link is avaiable for the latest updated site/conveyor {Site1}")
    public void verifyTheNewLinkInNotificationList(String site1)
    {
        sitePage.verifyNewLinkInNotificationList(site1);
    }
    @QAFTestStep(description = "Click on view icon for the new notification")
    public void clickOnTheViewForNewNotification()
    {
        sitePage.clickOnViewForNewNotification();
    }
    @QAFTestStep(description = "Navigate to site list screen")
    public void verifySiteListNav() {
        sitePage.goToSiteListScreenAndWait();
    }

    @QAFTestStep(description = "Verify the notification count is present in bellIcon")
    public void verifyTheNotificationCountIsPresent()
    {
        sitePage.verifyNotificationCountIsPresent();

    }
    @QAFTestStep(description = "Verify the notification count is zero in bellIcon")
    public void verifyTheNotificationCountIsZero()
    {
        sitePage.verifyNotificationCountIsZero();

    }
    @QAFTestStep(description = "Click on Mark all as Read for notification")
    public void clickTheMarkAsRead()
    {
        sitePage.clickMarkAsRead();
    }
    @QAFTestStep(description = "Verify Action button is visible under notification list page")
    public void verifyActionBtnForNotificationList(){
        sitePage.verifyNotificationsActionBtn();
    }

    @QAFTestStep(description = "Verify action button is enabled when user has new notification")
    public void verifyActionStatus(){
        Validator.assertTrue(monitoringDevicePage.verifyActionBtnIsEnabled(),"Action button is not enabled when user has new notification!","Action button is enabled when user has new notification!");
    }
    @QAFTestStep(description = "Click on the action button and verify user can see Mark all as read with eye symbol")
    public void actionBtnClickAndVerify(){
        sitePage.actionBtnClickAndVerifySymbol();
    }

    @QAFTestStep(description = "Verify action button is disabled when user has no new notification")
    public void verifyActionButtonDisabled(){
        Validator.assertTrue(monitoringDevicePage.verifyActionBtnIsDisabled(),"Action button is not enabled when user has new notification!","Action button is disabled when user has no new notification!");
    }
    @QAFTestStep(description = "Click on the action button mark all as read button")
    public void clickTheActionBtnMarkAllRead(){
        sitePage.clickActionBtnMarkAllRead();
    }

    @QAFTestStep(description = "Verify the notification count in bellIcon after subscription and verify user is getting any notification")
    public void verifyNotificationCountAfterSubscriptionForConveyor(){
        sitePage.extractNotificationCountAfter();
        sitePage.verifyUserNotificationCountAfterUpdate();
    }
    @QAFTestStep(description = "Verify all notifications are moved to read status")
    public void verifyAllTheNotificationAreRead(){
        sitePage.verifyAllNotificationAreRead();

    }

    @QAFTestStep(description = "Click on bellIcon and click on mark all as read")
    public void clickBellIconAndMarkAllRead()
    {
        sitePage.bellIconClick();
        sitePage.markAllAsReadLnkClick();
    }
}
