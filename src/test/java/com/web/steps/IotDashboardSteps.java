package com.web.steps;


import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.HeavyEquipmentPage;
import com.web.pages.IotDashboardPage;

public class IotDashboardSteps {
    IotDashboardPage iotDashboardPage=new IotDashboardPage();

    @QAFTestStep(description = "Navigate to iot dashboard list screen and wait to load data")
    public void verifyTheIotDashboardListNavAndWait() {
        iotDashboardPage.gotoIotDashboardScreenWait();
    }

    @QAFTestStep(description = "Navigate to iot dashboard list screen")
    public void verifyTheIotDashboardListNav() {
        iotDashboardPage.gotoIotDashboardScreen();
    }

    @QAFTestStep(description = "Navigate to iot dashboard list screen after card click")
    public void verifyTheIotDashboardCardNav() {
        iotDashboardPage.gotoIotDashboardFromCard();
    }

    @QAFTestStep(description = "Verify if the iot card is highlighted")
    public void verifyTheHighlightedCard() {
        Validator.assertTrue(iotDashboardPage.isIotCardHighlighted(),"IOT dashboard card is not highlighted","IOT dashboard card is highlighted");
    }

    @QAFTestStep(description = "Verify if the iot card is not highlighted")
    public void verifyTheNotHighlightedCard() {
        Validator.assertFalse(iotDashboardPage.isIotCardHighlighted(),"IOT dashboard card is highlighted","IOT dashboard card is not highlighted");
    }

    @QAFTestStep(description = "Verify the iot dashboard count with respect to pagination")
    public void validateTheIotDashboardCountWrtPagination() {
        iotDashboardPage.validateIotDashboardCountWrtPagination();
    }

    @QAFTestStep(description = "Verify the create new iot dashboard functionality")
    public void verifyCreateNewIotDashboardFunctionality() {
        iotDashboardPage.createNewDashboard();
    }

    @QAFTestStep(description = "Verify the add new iot dashboard functionality")
    public void verifyAddNewIotDashboardFunctionality() {
        iotDashboardPage.firstNewDashboard();
    }

    @QAFTestStep(description = "Verify the pagination limit functionality")
    public void verifyPaginationFunctionality() {
        iotDashboardPage.iotPaginationLimit();
    }

    @QAFTestStep(description = "Search for iot dashboard {DashboardName}")
    public void verifySearchFunctionality(String dashboardName) {
        Validator.assertTrue(iotDashboardPage.searchDashboard(dashboardName),"Dashboard search resulted in no result", "Dashboard search verified successfully");
    }

    @QAFTestStep(description="Select the iot dashboard {DashboardName}")
    public void selectingInspectionEvents(String dashboardName){
        iotDashboardPage.selectingDashboard(dashboardName);
    }

    @QAFTestStep(description="Verify the action button functionality for single selection")
    public void actionFunctionalitySingle(){
        Validator.assertTrue(iotDashboardPage.singleActionFunctionality(),"Action button functionality for single selection failed", "Action button functionality for single selection verified successfully");
    }

    @QAFTestStep(description="Verify the action button functionality for multi selection")
    public void actionFunctionalityMultiple(){
        Validator.assertTrue(iotDashboardPage.multiActionFunctionality(),"Action button functionality for multiple selection failed", "Action button functionality for multiple selection verified successfully");
    }

    @QAFTestStep(description="Verify the duplicate button functionality for {DashboardName}")
    public void duplicateButtonFunctionality(String dashboardName){
        Validator.assertTrue(iotDashboardPage.duplicateBtnFunctionality(dashboardName),"Duplicate button functionality failed", "Duplicate button functionality verified successfully");
    }

    @QAFTestStep(description="Create iot dashboard with {DashboardName} {SiteName}")
    public void createDefaultTypeIotDashboard(String dashboardName, String siteName){
        Validator.assertTrue(iotDashboardPage.createDefaultTypeIotDashboard(dashboardName, siteName),"Default type dashboard creation failed", "Default type dashboard creation verified successfully");
    }

    @QAFTestStep(description="Verify the list for iot dashboard {DashboardName}")
    public void verifyDefaultTypeIotDashboard(String dashboardName){
        Validator.assertTrue(iotDashboardPage.searchDashboard(dashboardName),"Newly create dashboard was not found", "Newly create dashboard creation verified successfully");
    }

    @QAFTestStep(description="Add widget for the first time {WidgetName} to {DashboardName}")
    public void verifyAddWidgetForFirstTimeFunctionality(String widgetName, String dashboardName){
        Validator.assertTrue(iotDashboardPage.goToDashboardOnViewMode(dashboardName),"Newly create dashboard was not found", "Newly create dashboard creation verified successfully");
        Validator.assertTrue(iotDashboardPage.isNewWidgetAdd(),"Newly create dashboard was not found", "Newly create dashboard creation verified successfully");
        Validator.assertTrue(iotDashboardPage.createWidget(widgetName), "Newly create dashboard was not found", "Newly create dashboard creation verified successfully");
    }


    @QAFTestStep(description="Add widget {WidgetName} to {DashboardName}")
    public void verifyAddWidgetFunctionality(String widgetName, String dashboardName){
        Validator.assertTrue(iotDashboardPage.goToDashboardOnViewMode(dashboardName),"Newly create dashboard was not found", "Newly create dashboard creation verified successfully");
//        Validator.assertTrue(iotDashboardPage.isNewWidgetAdd(),"Newly create dashboard was not found", "Newly create dashboard creation verified successfully");
        Validator.assertTrue(iotDashboardPage.createWidgetFromAddIcon(widgetName), "Newly create dashboard was not found", "Newly create dashboard creation verified successfully");
    }

    @QAFTestStep(description="Navigate to the iot dashboard {DashboardName}")
    public void navigateToIotDashboardDetails(String dashboardName){
        Validator.assertTrue(iotDashboardPage.goToDashboardOnViewMode(dashboardName),"Newly create dashboard was not found", "Newly create dashboard creation verified successfully");
    }

    @QAFTestStep(description="Verify create new widget is visible for newly created dashboard")
    public void verifyCreateNewWidgetIsVisibleForNewlyCreatedDashboard(){
        Validator.assertTrue(iotDashboardPage.isNewWidgetAdd(),"Newly create dashboard was not found", "Newly create dashboard creation verified successfully");
    }

    @QAFTestStep(description="Verify add new widget navigation")
    public void navigateToAddNewWidget(){
        Validator.assertTrue(iotDashboardPage.addWidgetNav(),"Newly create dashboard was not found", "Newly create dashboard creation verified successfully");
    }

    @QAFTestStep(description="Verify the different options available when creating widgets")
    public void verifyCreateWidgetOptions() {
        Validator.assertTrue(iotDashboardPage.createWidgetOptions(), "Widget options dashboard was not found", "Widget options dashboard creation verified successfully");
        Validator.assertTrue(iotDashboardPage.createWidgetButtons(), "Widget buttons dashboard was not found", "Widget buttons dashboard creation verified successfully");
    }

    @QAFTestStep(description="Verify the cancel functionality when creating widget")
    public void verifyTheCancelFunctionalityWhenCreatingWidget(){
        Validator.assertTrue(iotDashboardPage.verifyCancelButtons(), "Cancel create dashboard was not found", "Cancel create dashboard creation verified successfully");
    }

    @QAFTestStep(description="Add widget for {WidgetName}")
    public void cancelWidgetFunctionality(String widgetType){
        Validator.assertTrue(iotDashboardPage.createWidget(widgetType), "Newly create dashboard was not found", "Newly create dashboard creation verified successfully");
    }

    @QAFTestStep(description="Verify newly created widget {WidgetName}")
    public void verifyNewlyCreatedWidget(String widgetType){
        Validator.assertTrue(iotDashboardPage.getWidgetTitle().equalsIgnoreCase(widgetType), "Newly create widget was not found", "Newly create widget creation verified successfully");
    }

    @QAFTestStep(description="Verify field on add new widget")
    public void verifyUiForAddNewWidgets(){
        Validator.assertTrue(iotDashboardPage.addNewWidgetUI(), "Newly create widget was not found", "Newly create widget creation verified successfully");
    }

    @QAFTestStep(description="Verify add new widget subtext")
    public void verifyAddNewWidgetSubtext(){
        iotDashboardPage.verifyAddNewWidgetSubText();
    }

    @QAFTestStep(description="Verify the fields for unliked widget")
    public void verifyAddNewUnlikedWidget(){
        Validator.assertTrue(iotDashboardPage.unlikedWidgetUI(),"Unliked widget fields not matching","Unliked widget verified successfully");
    }


    @QAFTestStep(description="Configure a link widget from an unliked widget {Title} {Url} {Description}")
    public void configureLikedWidget(String title, String url, String description){
        Validator.assertTrue(iotDashboardPage.configureLinkWidget(title, url, description),"Widget configuration failed", "Widget configuration verified successfully");
    }


    @QAFTestStep(description="Configure a splice parameter for {MonitoringDevice} to an unliked widget with {SpliceNum}")
    public void configureSpliceWidget(String monitoringDevice, String spliceNum){
        Validator.assertTrue(iotDashboardPage.configureSpliceParameterWidget(monitoringDevice,spliceNum),"Widget configuration failed", "Widget configuration verified successfully");
    }

    @QAFTestStep(description="Configure a monitoring device {MonitoringDevice} to an unliked widget")
    public void configureUnlikedWidget(String monitoringDevice){
        Validator.assertTrue(iotDashboardPage.configureSummaryWidget(monitoringDevice),"Widget configuration failed", "Widget configuration verified successfully");
    }

    @QAFTestStep(description="Verify the monitoring device {MonitoringDevice} configured for widget")
    public void verifyMonitoringDeviceConfigured(String monitoringDevice){
        Validator.assertTrue(iotDashboardPage.getWidgetMonitoringDevice().equalsIgnoreCase(monitoringDevice),"Widget monitoring device configuration failed", "Widget monitoring device configuration verified successfully");
    }

    @QAFTestStep(description="Verify the expand widget functionality for {WidgetName} and {MonitoringDevice}")
    public void verifyExpandWidgetConfigured(String widgetType, String monitoringDevice){
        Validator.assertTrue(iotDashboardPage.verifyExpandFunctionality(widgetType, monitoringDevice),"Widget monitoring device configuration failed", "Widget monitoring device configuration verified successfully");
    }

    @QAFTestStep(description="Verify the info widget functionality for {WidgetName}")
    public void verifyInfoWidgetConfigured(String widgetType){
        Validator.assertTrue(iotDashboardPage.verifyInfoFunctionality(widgetType),"Widget monitoring device configuration failed", "Widget monitoring device configuration verified successfully");
    }

    @QAFTestStep(description="Verify the more widget functionality")
    public void verifyMoreWidgetConfigured(){
        Validator.assertTrue(iotDashboardPage.verifyMoreFunctionality(),"Widget monitoring device configuration failed", "Widget monitoring device configuration verified successfully");
    }

    @QAFTestStep(description="Verify the edit button functionality when widgets are unliked")
    public void verifyEditDashboardForUnlikedWidget(){
        Validator.assertTrue(!iotDashboardPage.isEditDashboard(), "Edit Dashboard should not be enabled for unlinked widget", "Edit Dashboard for unlinked widget verified successfully");
    }
}
