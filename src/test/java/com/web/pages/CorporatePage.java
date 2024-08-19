package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.annotations.UiElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class CorporatePage extends BasePage{

    @UiElement(
            fieldLoc= "xpath=//span[text()='Corporates']",
            viewLoc = "xpath=//span[text()='Corporates1']"
    )
    public CustomElement lCorporates1;

    @FindBy(locator = "xpath=//span[text()='Corporates']")
    public CustomElement lCorporates;

    @FindBy(locator="xpath=//div/span[text()='Corporates']")
    public CustomElement corporateHeader;

    @FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
    public CustomElement btAddCorp;

    @FindBy(locator = "xpath=//input[@name='company_name']")
    public CustomElement tbCompanyName;

    @FindBy(locator = "xpath=//span[text()='Save and Close']/..")
    public CustomElement btSaveandclose;

    @FindBy(locator = "xpath=//p-dropdown[@formcontrolname='companyType']/div/span")
    public CustomElement drCompanyDropdownLoader;

    @FindBy(locator = "xpath=(//div[@role='button'])[1]")
    public CustomElement drTypeofcompany;

    @FindBy(locator = "xpath=//div[text()=' Distributor Shop ']")
    public CustomElement radioDistribtorshop;

    @FindBy(locator = "xpath=//li[@aria-label='Customer Corporate']")
    public CustomElement radioCustomerCorportae;

    @FindBy(locator = "xpath=//div[text()=' Customer Site ']")
    public CustomElement radioCustomeSite;

    @FindBy(locator = "xpath=//div[text()=' Distributor Corporate ']")
    public CustomElement radioDistributorCorp;

    @FindBy(locator = "xpath=(//div[@role='button'])[3]")
    public CustomElement drDistributorcorporate;

    @FindBy(locator = "xpath=//li[text()=' No results found ']")
    public CustomElement drTerritoryLoader;

    @FindBy(locator = "xpath=//p-dropdown[@datakey='territoryId']/div/div[2]")
    public CustomElement drTerritorybutton;

    @FindBy(locator = "xpath=//input[@aria-activedescendant='p-highlighted-option']")
    public CustomElement drTerritoryvalue;

    @FindBy(locator = "xpath=//p-autocomplete[@field='name']//input")
    public CustomElement drTerritoryManagerbutton;

    @FindBy(locator = "xpath=//input[@id='autocomplete-address']")
    public CustomElement tbAddress;

    @FindBy(locator = "xpath=//div[contains(@class, 'pac-container')]/div[1]")
    public CustomElement tbMapFirstSearchOption;

    @FindBy(locator= "xpath=//input[contains(@class,'p-dropdown-filter')]")
    public CustomElement tbSitedropdown;

    @FindBy(locator= "xpath=//input[contains(@class,'p-dropdown-filter')]")
    public CustomElement tbAssociatedSitedropdown;

    @FindBy(locator= "xpath=//p-dropdown[@datakey='companyId']/div/div[2]")
    public CustomElement drDistShopdropdown;

    @FindBy(locator="xpath=(//div[@role='button'])[2]")
    public CustomElement drCustomerCorporate;

    @FindBy(locator ="xpath=(//div[@role='button'])[4]")
    public CustomElement drAssociatedCustomerCorporate;

    @FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
    public CustomElement pagination;

    @FindBy(locator="xpath=//input[@placeholder='Search']")
    public CustomElement btSearchinput;

    @FindBy(locator="xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement btCheckbox;

    @FindBy(locator="xpath=(//button/chevrondownicon)[2]")
//    @FindBy(locator="xpath=(//button/span[contains(@class,'pi-chevron-down')])[2]")
    public CustomElement btActions;

    @FindBy(locator="xpath=//li//span[text()='Edit']")
    public CustomElement btEdit;

    @FindBy(locator="xpath=//span[text()='Delete']")
    public CustomElement btDelete;

    @FindBy(locator="xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
    public CustomElement btviewicon;

    @FindBy(locator="xpath=(//button[@icon='ctp-icon-Arrow-Right'])[2]")
    public CustomElement btviewicon2;

    @FindBy(locator = "xpath=//span[text()='Update']")
    public CustomElement btUpdate;

    @FindBy(locator="xpath=//button[contains(@class,'p-button-loading')]")
    public CustomElement buttonLoader;

    @FindBy(locator = "xpath=//span[text()='Yes']")
    public CustomElement yesConfirmation;

    @FindBy(locator = "xpath=//input[@id='file-input']")
    public CustomElement fileUpload;

    @FindBy(locator = "xpath=//span[text()='Save']")
    public CustomElement btSave;

    @FindBy(locator = "xpath=(//img[contains(@class,'avatar-section-img')])[2]")
    public CustomElement imageAvatar;

    @FindBy(locator = "xpath=//div[@class='icon']/img")
    public CustomElement imageIcon;

    @FindBy(locator="xpath=(//td//img)[1]")
    public CustomElement btImg;

    @FindBy(locator="xpath=(//td[3])[1]")
    public CustomElement btName;

    @FindBy(locator="xpath=(//td[4]/span)[1]")
    public CustomElement btType;

    @FindBy(locator="xpath=(//td[5]/span)[1]")
    public CustomElement btAddress;

    @FindBy(locator="xpath=(//td[6]/p-chip/div)[1]")
    public CustomElement btMarket1;

    @FindBy(locator="xpath=(//td[6]/p-chip/div/div)[1]")
    public CustomElement btMarket;

    @FindBy(locator="xpath=//td[7]/div")
    public CustomElement btShopNumber;
    @FindBy(locator="xpath=(//app-card//div[text()='Sites' or text()='Shops'] /..//span)[1]")
    public CustomElement btSiteShopCardNo;

    @FindBy(locator="xpath=(//app-card//div[text()='Conveyors']/..//span)[1]")
    public CustomElement btConveyorCardNo;

    @FindBy(locator="xpath=(//app-card//div[text()='Cover Wear']/..//span)[1]")
    public CustomElement btCOverWearCardNo;

    @FindBy(locator="xpath=(//app-card//div[text()='Inspections']/..//span)[1]")
    public CustomElement btInspectionCardNo;

    @FindBy(locator="xpath=(//app-card//div[text()='Conveyor Inspect']/..//span)[1]")
    public CustomElement btConveyorInspectCardNo;

    @FindBy(locator="xpath=(//td//img)[1]")
    public CustomElement detailsImg;

    @FindBy(locator="xpath=(//td[4])[1]")
    public CustomElement detailsName;

    @FindBy(locator="xpath=(//td[5]/span)[1]")
    public CustomElement detailsCorp;

    @FindBy(locator="xpath=(//td[6])[1]")
    public CustomElement detailsAddress;

    @FindBy(locator="xpath=(//td[7])[1]")
    public CustomElement detailsTerritory;

    @FindBy(locator="xpath=(//td[8])[1]")
    public CustomElement detailsManager;

    @FindBy(locator="xpath=(//td[9]/div)[1]")
    public CustomElement detailsSiteNumber;

    @FindBy(locator="xpath=(//td[9])[1]")
    public CustomElement detailsDistributor;

    @FindBy(locator="xpath=(//td[10]/div)[1]")
    public CustomElement detailsConveyorNumber;

    @FindBy(locator="xpath=(//td[11]/button)[1]")
    public CustomElement detailsMoreButton;

    @FindBy(locator = "xpath=//td[contains(text(),'No')]")
    public CustomElement noList;

    @FindBy(locator = "xpath=(//label[text()='Type of Company']/../div//p-dropdown//span)[1]")
    public CustomElement typeOfCompanyLoader;

    @FindBy(locator = "xpath=(//div[contains(@id,'titlebar')]/span)[1]")
    public CustomElement siteNameLoader;

    @FindBy(locator = "xpath=//span[text()='Add Company']")
    public CustomElement addCompany;

    @FindBy(locator = "xpath=//h4[text()='New Company']")
    public CustomElement newCompany;

    @FindBy(locator = "xpath=//div/span[text()='Conveyors']")
    public CustomElement conveyorHeader;

    @FindBy(locator = "xpath=//span[text()='Conveyor Trails']")
    public CustomElement conveyorTrailsHeader;

    @FindBy(locator = "xpath=//input[@id='firstname1']")
    public CustomElement tbConveyorname;

    @FindBy(locator= "xpath=//label[text()='Site']/following::span[1]")
    public CustomElement drSitedropdown;

    @FindBy(locator= "//button[@class='p-ripple p-element p-button-rounded p-button-primary p-button p-component p-disabled']")
    public CustomElement btnSaveDisabled;

    @FindBy(locator= "//button[@class='p-ripple p-element p-button-rounded p-button-primary p-button p-component']")
    public CustomElement btnSaveEnabled;

    @FindBy(locator="//div[@class='p-breadcrumb p-component']")
    public CustomElement bcAddUserLink;

    @FindBy(locator="//div[@class='conti-avatar-section']//img[@class='avatar-section-img default-image']")
    public CustomElement addDefaultImgSrc;


    public void goToAddCompany() {
        addCompany.click("Add Company");
        newCompany.isVisible("New Company Header");
    }

    public void clickCorporates() {
        waitForElementVisible(lCorporates, 10000,500);
        lCorporates.click("Corporate");
        waitForPageLoad(10000);
        waitForElementVisible(corporateHeader,5000,500);
        Validator.assertTrue(corporateHeader.isDisplayed(),"Company List page has not loaded","Company List page has not loaded");
        waitForElementToDisplay(btAddCorp);
    }

    public void goToAddCorporate() {
//        scrollPageup();
        waitForElementToDisplay(btAddCorp);
        btAddCorp.click("Add Corp");
    }

    public void createDistributorCorporate(String companyName, String address) {
        selectDistributorCorp();
        addCorporateDetails(companyName, address);
        saveCorp();
        waitForElementToDisplay(corporateHeader);
        SyncUtil.waitFor(2000);
        corporateHeader.isEnable("Corporate List");
        Reporter.log(companyName +"corporate is created" , MessageTypes.Pass);
    }

    public void createDistributorShop(String companyName, String address, String distCorp, String territory, String manager) {
        scrollPageup();
        selectDistributorShop();
        dropdownSelectSearch(drDistributorcorporate, tbSitedropdown,distCorp);
        dropdownSelectSearch(drTerritorybutton, drTerritoryvalue, territory);
        drTerritoryManagerbutton.type(manager, "Territory");
        addCorporateDetails(companyName, address);
        saveCorp();
        waitForElementToDisplay(btSiteShopCardNo);
        btSiteShopCardNo.isVisible("Shop Details");
        Reporter.log(companyName + "distributor shop is created" , MessageTypes.Pass);
    }

    public void createCustomerCorporate(String companyName, String address) {
        scrollPageup();
        selectCustomerCorp();
        addCorporateDetails(companyName, address);
        saveCorp();
        waitForElementToDisplay(corporateHeader);
        SyncUtil.waitFor(2000);
        corporateHeader.isEnable("Corporate List");
        Reporter.log(companyName +" customer corporate is created", MessageTypes.Pass);
    }

    public void createCustomerSite(String companyName, String address, String CustCorpName, String DistShopIndName, String DistCorpIndTerritory, String manager) {
        scrollPageup();
        selectCustomerSite();
        dropdownSelectSearch(drCustomerCorporate, tbSitedropdown, CustCorpName);
        dropdownSelectSearch(drAssociatedCustomerCorporate, tbAssociatedSitedropdown, DistShopIndName);
        dropdownSelectSearch(drTerritorybutton, drTerritoryvalue, DistCorpIndTerritory);
        drTerritoryManagerbutton.type(manager);
        addCorporateDetails(companyName, address);
        saveCorp();
        waitForElementToDisplay(btSiteShopCardNo);
        waitForElementToDisplay(btSiteShopCardNo);
        btSiteShopCardNo.isVisible("Site Details");
        Reporter.log(companyName +" customer site is created", MessageTypes.Pass);

    }

    public void goToAddCorp() {
        scrollPageup();
        waitForElementToDisplay(btAddCorp);
        btAddCorp.click("Add Corp");
        waitForElementToDisplay(drCompanyDropdownLoader);
    }

    public void addCorporateDetails(String companyname, String Address) {
        tbCompanyName.type(companyname, "Company name");
        tbAddress.type(Address,"Address bar");
        waitForElementToDisplay(tbMapFirstSearchOption);
        tbAddress.click("Address bar");
        tbMapFirstSearchOption.click("Map search result");
    }

    public void saveCorp() {
        scrollPageDown();
        waitForElementToBeClickable(btSaveandclose);
        btSaveandclose.click("Save And Close");
    }

    public void updateCorp() {
        scrollPageDown();
        btUpdate.click("Update");
        waitForElementToInvisible(buttonLoader,10000);
        btSearchinput.isVisible("Corporate list screen");
    }

    public void selectDistributorShop() {
        drTypeofcompany.click("Corporate Type");
        waitForElementToDisplay(radioDistribtorshop);
        radioDistribtorshop.click("Distributor shop");
    }

    public void selectDistributorCorp() {
        waitForElementToDisplay(drTypeofcompany);
        waitForElementToBeClickable(drTypeofcompany);
        drTypeofcompany.click("Corporate Type");
        waitForElementToDisplay(radioDistributorCorp);
        radioDistributorCorp.click("Distributor Corp");
    }

    public void selectCustomerCorp() {
        drTypeofcompany.click("Corporate Type");
        waitForElementToDisplay(radioCustomerCorportae);
        radioCustomerCorportae.click("Distributor Corp");
    }

    public void selectCustomerSite() {
        drTypeofcompany.click("Corporate Type");
        waitForElementToDisplay(radioCustomeSite);
        radioCustomeSite.click("Customer Site");
    }

    public void goToCorporateEditScreen(String corpName) {
        waitForElementVisible(btSearchinput, 10000,500);
        btSearchinput.type(corpName, "Corporate Search");
        waitForElementToDisplay(btCheckbox);
        btCheckbox.check("Select Corporate");
        btActions.click("Actions");
        waitForElementVisible(btEdit, 10000,500);
        btEdit.click("Edit");
    }

    public void editCorporateName(String corpName, String editCorpName) {
        goToCorporate();
        goToCorporateEditScreen(corpName);
        setImplicitWait(10000, TimeUnit.MILLISECONDS);
        typeOfCompanyLoader.waitForText("Customer Corporate");
        setImplicitWait(5000, TimeUnit.MILLISECONDS);
        tbCompanyName.type(editCorpName, "Edit_companyName");
    }

    public void corporateImgUpload(String fileName) {
        imageIcon.jsClick("Img_Icon");
        String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_files").getAbsolutePath();
        fileUpload.sendKeys(file_path, "img_upload");
        btSave.click("Save_ImgUpload");
        waitForElementToInvisible(btSave, 30000);
    }

    public void verifyMarketType(String type) {
        if(btMarket.isVisible())
            btMarket.verifyText(type,"Market Type");
        else btMarket1.verifyText(type,"Market Type");
    }

    public void verifyCorporateNav() {
        lCorporates.click("Corporate Menu");
        btSearchinput.isVisible("Search");
    }

    public void goToCorporate() {
        lCorporates.click("Corporate Menu");
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


    public void editCustomerSite(String siteName, String editSiteName, String corp) {
        goToCorporateDetails(corp);
        btSearchinput.type(siteName, "Site name");
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        waitForElementToDisplay(btCheckbox);
        btCheckbox.click("Site Checkbox");
        setImplicitWait(5000,TimeUnit.MILLISECONDS);
        btActions.click("Actions");
        waitForElementToDisplay(btEdit);
        btEdit.jsClick("Edit");
        typeOfCompanyLoader.waitForText("Customer Site");
        tbCompanyName.type(editSiteName);
        scrollPageup();
        dropdownSelectSearch(drTerritorybutton, drTerritoryvalue, "India");
        drTerritoryManagerbutton.type("Territory India Automation", "Territory");
        scrollPageDown();
    }

    public void deleteSiteOrShop(String custCorp, String custSite) {
        goToDistCorporateDetails(custCorp);
        btSearchinput.type(custSite, "Site/Shop name");
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        btCheckbox.check("Site/Shop Checkbox");
        setImplicitWait(5000,TimeUnit.MILLISECONDS);
        btActions.jsClick("Actions");
        waitForElementVisible(btDelete, 10000,500);
        btDelete.jsClick("Delete");
        yesConfirmation.click("Confirm");
    }

    public void searchCorporate(String corpName) {
        goToCorporate();
        waitForElementToDisplay(btSearchinput);
        btSearchinput.type(corpName, "Corporate Search");
    }

    public void verifyImageUpload(){
        waitForElementToDisplay(imageAvatar);
        Validator.assertFalse(imageAvatar.getAttribute("src").equalsIgnoreCase("/assets/img/upload_default.png"), "New Image was not uploaded", "New Img was successfully added");
    }

    public void verifyCorporateEdit(String corpName) {
        searchCorporate(corpName);
        Validator.assertFalse(btImg.getAttribute("src").equalsIgnoreCase("/assets/img/upload_default.png"), "New Image was not uploaded", "New Img was successfully added");
        btName.verifyTextIgnoringNewLineChar(corpName, "Corporate name");
        btviewicon.check("Corp Details");
        verifyImageUpload();
    }

    public void goToCorporateDetails(String corpName) {
        searchCorporate(corpName);
        btviewicon.click("Corp Details");
        waitForElementToDisplay(btSiteShopCardNo);
    }

    public void goToDistCorporateDetails(String corpName) {
        searchCorporate(corpName);
        SyncUtil.waitFor(2000);
        if(btviewicon2.isEnable())
            btviewicon2.click("Dist Corp shop Details");
        else
            btviewicon.click("Corp Site Details");
        waitForElementToDisplay(btSiteShopCardNo);
    }

    public void verifySiteOrShopEdit(String corpName, String siteName) {
        goToCorporateDetails(corpName);
        btSearchinput.type(siteName, "Site/Shop name");
        Validator.assertFalse(detailsImg.getAttribute("src").equalsIgnoreCase("/assets/img/upload_default.png"), "New Image was not uploaded", "New Img was successfully added");
        detailsName.verifyTextIgnoringNewLineChar(siteName, "Site name");
        detailsMoreButton.click("Corp Details");
        siteNameLoader.waitForPartialText(siteName, 15000);
        Validator.assertFalse(imageAvatar.getAttribute("src").equalsIgnoreCase("/assets/img/upload_default.png"), "New Image was not uploaded", "New Img was successfully added");
    }

    public void verifySiteOrShopDelete(String corpName, String siteName) {
        goToDistCorporateDetails(corpName);
        btSearchinput.type(siteName, "Site/Shop name");
        Validator.assertTrue(noList.isVisible("No Site/Shop"), "Site/Shop found even after delete", "Site/Shop not found after delete");
    }

    public void verifyCardDetails(String siteName) {
        siteNameLoader.waitForPartialText(siteName, 15000);
        SyncUtil.waitFor(15000);
        Validator.assertTrue(btSiteShopCardNo.getText("Site Card").trim().equalsIgnoreCase("2"),"Site/Shop card count shown in corporate details screen is incorrect","Successfully verified Site/Shop card count shown in corporate details screen");
        Validator.assertTrue(btConveyorCardNo.getText("Conveyor Card").trim().equalsIgnoreCase("6"),"Conveyor card count shown in corporate details screen is incorrect","Successfully verified Conveyor card count shown in corporate details screen");
    }

    public void deleteCorporate(String corpName) {
        goToCorporate();
        waitForElementVisible(btSearchinput, 10000,500);
        btSearchinput.type(corpName);
        btCheckbox.click();
        btActions.click();
        waitForElementVisible(btDelete, 10000,500);
        btDelete.click();
        yesConfirmation.click();
    }

    public boolean verifyCorporate(String corpName) {
        goToCorporate();
        waitForElementVisible(btSearchinput, 10000,500);
        btSearchinput.type(corpName);
        return noList.isVisible();
    }

    public void goToShopSiteDetails(String siteName) {
        btSearchinput.type(siteName, "Site/Shop name");
        waitForElementToDisplay(btCheckbox);
        detailsMoreButton.click("Corp Details");
        siteNameLoader.waitForPartialText(siteName, 15000);
        SyncUtil.waitFor(2000);
        conveyorHeader.isEnable("Conveyor Header");
    }

    public void editDistributorShop(String siteName, String editSiteName, String corp) {
        goToCorporateDetails(corp);
        btSearchinput.type(siteName, "Site name");
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        waitForElementToDisplay(btCheckbox);
        btCheckbox.click("Site Checkbox");
        setImplicitWait(5000,TimeUnit.MILLISECONDS);
        btActions.click("Actions");
        waitForElementToDisplay(btEdit);
        btEdit.jsClick("Edit");
        typeOfCompanyLoader.waitForText("Distributor Shop");
        tbCompanyName.type(editSiteName);
        dropdownSelectSearch(drTerritorybutton, drTerritoryvalue, "India");
        drTerritoryManagerbutton.type("Market India Automation", "Territory");
    }

    public void verifyShopSiteCardCount(String count) {
        SyncUtil.waitFor(15000);
        Validator.assertTrue(btSiteShopCardNo.getText("Site Card").trim().equalsIgnoreCase(count),"Site/Shop card count shown in corporate details screen is incorrect","Successfully verified Site/Shop card count shown in corporate details screen");
    }

    public void verifyAddDistCorporateDropdown(String corp){
        scrollPageup();
        selectDistributorShop();
        dropdownSelectSearch(drDistributorcorporate, tbSitedropdown,corp);
    }

    public void verifyAddCustCorporateDropdown(String corp){
        scrollPageup();
        selectCustomerSite();
        dropdownSelectSearch(drCustomerCorporate, tbSitedropdown, corp);
    }

    public void goToAddConveyor() {
        scrollPageup();
        waitForElementToDisplay(btAddCorp);
        btAddCorp.click("Add Corp");
        waitForElementToDisplay(tbConveyorname);
    }

    public void createConveyor(String conveyorName,String custSiteName) {
        tbConveyorname.type(conveyorName,"Conveyor Name");
        dropdownSelectSearch(drSitedropdown, tbSitedropdown, custSiteName);
        btSaveandclose.click("Save & Close");
        waitForElementToInvisible(buttonLoader,10000);
        btSearchinput.isVisible("Conveyor list screen");
        Reporter.log(conveyorName +" conveyor is created", MessageTypes.Pass);
    }

    public void goToConveyorDetails(String conveyorName) {
        btSearchinput.type(conveyorName, "Conveyor name");
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        waitForElementToDisplay(btCheckbox);
        setImplicitWait(5000,TimeUnit.MILLISECONDS);
        detailsName.verifyTextIgnoringNewLineChar(conveyorName, "Conveyor name");
        detailsMoreButton.click("Conveyor Details");
        siteNameLoader.waitForPartialText(conveyorName, 15000);
        conveyorTrailsHeader.isVisible("Conveyor Header");
    }

    public void deleteConveyor(String conveyor) {
        btSearchinput.type(conveyor, "Conveyor name");
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        waitForElementToDisplay(btCheckbox);
        btCheckbox.check("conveyor Checkbox");
        setImplicitWait(5000,TimeUnit.MILLISECONDS);
        btActions.click("Actions");
        waitForElementVisible(btDelete, 10000,500);
        btDelete.click("Delete");
        yesConfirmation.click("Confirm");
    }

    public void verifyDeleteConveyor(String conveyor) {
        btSearchinput.type(conveyor, "Conveyor name");
        Validator.assertTrue(noList.isVisible("No Site/Shop"), "Conveyor found even after delete", "Conveyor not found after delete");
    }

    public void verifyMandatoryFields(){
        Validator.assertTrue(btnSaveDisabled.isDisplayed(),"Save button is not disabled","Cancel button is disabled");
        tbCompanyName.type("");
        Validator.assertTrue(btnSaveEnabled.isDisplayed(),"Cancel button is not enabled","Cancel button is enabled");
    }


    public void verifyUserBreadCrumb()
    {
        waitForPageLoad(15000);
        waitForElementVisible(addDefaultImgSrc,5000,500);
        waitForElementVisible(bcAddUserLink,10000,500);
        Validator.assertTrue(bcAddUserLink.isDisplayed(), "Breadcrumb element is not displayed","Breadcrumb element is displayed");
        assertEquals(bcAddUserLink.getText(), "Home\nCorporates\nAdd", "Breadcrumb text does not match expected");
    }

    public void verifyBlankField(){
        Validator.assertTrue(btnSaveDisabled.isDisplayed(),"Save button is not disabled","Cancel button is disabled");
        }

//    public void addBlankCompanyAndAddress(String Address) {
//        tbCompanyName.type("");
//        tbAddress.type(Address,"Address bar");
//        tbAddress.click();
//        waitForElementToDisplay(tbMapFirstSearchOption);
//        waitForElementToBeClickable(tbMapFirstSearchOption);
//        tbMapFirstSearchOption.click("Map search result");
//    }

    public void verifyManFields(int mandatoryCount){
       Assert.assertEquals(driver.findElements(By.xpath("//div[not(@hidden)]/label/em[text()='*']/..")).size(), mandatoryCount, "Expected count does not match actual count");
    }


}
