package com.web.pages;

import com.common.component.CustomElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;

public class UserStatisticsPage extends BasePage{


    @FindBy(locator = "xpath=(//li//span[text()='Statistics'])[1]")
    public CustomElement userStatistics;

    @FindBy(locator = "xpath=//div[text()='Total Users']/..//span")
    public CustomElement totalUsers;

    @FindBy(locator = "xpath=//div[text()='Total Corporates']/..//span")
    public CustomElement totalCorporates;

    @FindBy(locator = "xpath=//div[text()='Total Distributor Shops']/..//span")
    public CustomElement totalShops;

    @FindBy(locator = "xpath=//div[text()='Total Customer Sites']/..//span")
    public CustomElement totalSites;

    @FindBy(locator = "xpath=//div[text()='Total Conveyors']/..//span")
    public CustomElement totalConveyors;

    @FindBy(locator = "xpath=//div[text()='Total Cover Wears']/..//span")
    public CustomElement totalCoverWear;

    @FindBy(locator = "xpath=//div[text()='Total Inspections']/..//span")
    public CustomElement totalInspections;

    @FindBy(locator = "xpath=//div[text()='Total Conveyor Inspects']/..//span")
    public CustomElement totalConveyorInspect;

    @FindBy(locator = "xpath=//div[text()='Total Belt Scans']/..//span")
    public CustomElement totalBeltScans;

    @FindBy(locator = "xpath=//div[text()='Total Monitoring Devices']/..//span")
    public CustomElement totalMonitoringDevices;

    @FindBy(locator = "xpath=//div[text()='Total Heavy Equipment']/..//span")
    public CustomElement totalHeavyEquipment;

    @FindBy(locator = "xpath=//div[text()='Total Minuteman Calculations']/..//span")
    public CustomElement totalMinuteman;


    public boolean goToUserStatistics() {
        waitForElementVisible(userStatistics, 10000,500);
        userStatistics.jsClick();
        waitForPageLoad(10000);
        waitForElementVisible(totalUsers,5000,500);
        return totalUsers.isVisible();
    }

    public String getTotalUsersCount() {
        return totalUsers.getText();
    }

    public String getTotalCorporatesCount() {
        return totalCorporates.getText();
    }

    public String getTotalShopsCount() {
        return totalShops.getText();
    }

    public String getTotalSitesCount() {
        return totalSites.getText();
    }

    public String getTotalConveyorCount() {
        return totalConveyors.getText();
    }

    public String getTotalCoverWearCount() {
        return totalCoverWear.getText();
    }

    public String getTotalInspectionCount() {
        return totalInspections.getText();
    }

    public String getTotalConveyorInspectCount() {
        return totalConveyorInspect.getText();
    }

    public String getTotalBeltScansCount() {
        return totalBeltScans.getText();
    }

    public String getTotalMonitoringDevicesCount() {
        return totalMonitoringDevices.getText();
    }

    public String getTotalHeavyEquipmentCount() {
        return totalHeavyEquipment.getText();
    }

    public String getTotalMinutemanCount() {
        return totalMinuteman.getText();
    }
}
