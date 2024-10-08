package com.web.steps;

import com.common.utils.APIBase;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.ConveyorPage;
import com.web.pages.SitePage;

public class SiteSteps  {

    SitePage sitePage = new SitePage();
    ConveyorPage conveyorPage=new ConveyorPage();

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
    @QAFTestStep(description = "Verify user is getting notification in last in first out format")
    public void clickAndVerifyNotificationOrder()
    {
        sitePage.bellIconClick();
        sitePage.verifyNotificationOrder();
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
    @QAFTestStep(description = "Verify Action button is visible under notification list page")
    public void verifyActionBtnForNotificationList()
    {sitePage.verifyNotificationsActionBtn();}
    @QAFTestStep(description = "Click on bellIcon and click on mark all as read")
    public void clickBellIconAndMarkAllRead()
    {
        sitePage.bellIconClick();
        sitePage.markAllAsReadLnkClick();
    }
    @QAFTestStep(description = "Click on the action button and verify user can see Mark all as read with eye symbol")
    public void actionBtnClickAndVerify()
    {
        sitePage.actionBtnClickAndVerifySymbol();
    }

}
