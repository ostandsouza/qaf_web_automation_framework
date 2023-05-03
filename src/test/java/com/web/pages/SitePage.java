package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;

import java.util.concurrent.TimeUnit;

public class SitePage  extends BasePage{

    @FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
    public CustomElement home;

    @FindBy(locator = "xpath=(//li//span[text()='Sites'])[1]")
    public CustomElement sites;

    @FindBy(locator="xpath=//input[@placeholder='Search']")
    public CustomElement btSearchinput;

    @FindBy(locator="xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement btCheckbox;

    @FindBy(locator="xpath=(//button[@icon='pi pi-chevron-down'])[2]")
    public CustomElement btActions;

    @FindBy(locator="xpath=//span[text()='Edit']")
    public CustomElement btEdit;

    @FindBy(locator="xpath=//span[text()='Delete']")
    public CustomElement btDelete;

    @FindBy(locator="xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
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

    @FindBy(locator="xpath=(//span[contains(@class,'p-panel-title')])[1]")
    public CustomElement siteHeader;

    public void goToSiteListScreen(){
        if(!sites.isVisible())
            home.click("Home");
        sites.click("Sites List");
        btSearchinput.isVisible("Site Page");
    }

    public void goToSiteListScreenAndWait() {
        goToSiteListScreen();
        scrollPageDown();
        String val="";
        for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(120); stop>System.nanoTime();) {
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
        waitForElementVisible(btDelete, 10000,500);
        btDelete.click("Delete");
        yesConfirmation.click("Confirm");
    }

    public void verifySiteDelete(String siteName) {
        searchSite(siteName);
        Validator.assertTrue(noList.isVisible("No Site"), "Site was not deleted successfully", "Site Deleted Successfully");
    }

}
