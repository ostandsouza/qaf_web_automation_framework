package com.web.pages;

import static org.testng.Assert.assertEquals;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class BeltInfoPage extends BasePage {

    @FindBy(locator = "xpath=//span[text()='Belt Info']")
    public CustomElement lnkBeltinfo;

    @FindBy(locator = "xpath=//span[text()='Textile']")
    public CustomElement lnkTextile;

    @FindBy(locator = "xpath=//span[text()='Steel']")
    public CustomElement lnkSteel;

    @FindBy(locator = "xpath=//label[text()='Market ']/parent::div//div[@role='button']")
    public CustomElement ddlMarket;

    @FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter p-inputtext')]")
    public CustomElement tbinput;

    @FindBy(locator = "xpath=//label[text()='Std. Requested by Customer ']/parent::div//div[@role='button']")
    public CustomElement ddlStdRequestedbyCustomer;

    @FindBy(locator = "xpath=//label[text()='Belt Construction ']/parent::div//div[@role='button']")
    public CustomElement ddlBeltConstruction;

    @FindBy(locator = "xpath=//label[text()='Carcass Construction ']/parent::div//div[@role='button']")
    public CustomElement ddlCarcassConstruction;

    @FindBy(locator = "xpath=//label[text()='Top Cover Compound ']/parent::div//div[@role='button']")
    public CustomElement ddlTopCoverCompound;

    @FindBy(locator = "xpath=(//label[text()=\"Top Cover Gauge \"]/following-sibling::div//p-dropdown//div[@role=\"button\"])[1]")
    public CustomElement ddlTopCoverGauge;

    @FindBy(locator = "xpath=//label[text()='Bottom Cover Compound ']/parent::div//div[@role='button']")
    public CustomElement ddlBottomCoverCompound;

    @FindBy(locator = "xpath=(//label[text()=\"Bottom Cover Gauge \"]/following-sibling::div//p-dropdown//div[@role=\"button\"])[1]")
    public CustomElement ddlBottomCoverGauge;

    @FindBy(locator = "xpath=//input[contains(@class,'p-inputtext p-component p-element ng-st')]")
    public CustomElement tbBeltlength;

    @FindBy(locator = "xpath=(//label[text()=\"Belt Width \"]/following-sibling::div//p-dropdown//div[@role=\"button\"])[1]")
    public CustomElement ddlBeltwidth;

    @FindBy(locator = "xpath=//label[text()='Edge ']/parent::div//div[@role='button' and contains(@class,'p-dropdown-trigger')]")
    public CustomElement ddlEdge;

    @FindBy(locator = "xpath=//label[text()='Breaker ']/parent::div//div[@role='button']")
    public CustomElement ddlBreaker;

    public String breakeritems = "//ul[@role='listbox']";


    @FindBy(locator = "xpath=//label[text()='Overwrite Belt Thickness ? ']/parent::div//input")
    public CustomElement tbOverallbeltthickness;

    @FindBy(locator = "xpath=//textarea[contains(@class,'p-inputtextarea p-inputtext')]")
    public CustomElement textareaComment;

    @FindBy(locator = "xpath=//button[@label='Calculate']")
    public CustomElement btnCalculate;

    @FindBy(locator = "xpath=//button//span[text()='Export as pdf']")
    public CustomElement btnExportPDF;

    @FindBy(locator = "xpath=//span[text()='Belt Info']")
    public CustomElement lsBeltInfo;
    @FindBy(locator = "xpath=//span[text()='Steel']")
    public CustomElement lsSteel;
    @FindBy(locator = "xpath=//span[text()='Steelcord Belt Specification']")
    public CustomElement txtBeltInfoSteelBreadCrumb;

    @FindBy(locator = "xpath=//span[text()='Textile']")
    public CustomElement lsTextile;
    @FindBy(locator = "xpath=//span[text()='Conveying Solutions Technical Data Sheet']")
    public CustomElement txtBeltInfoTextileBreadCrumb;
    @FindBy(locator = "xpath=//div[@class=\"p-tabview-nav-container\"]//span[text()='Preferences']")
    public CustomElement preferencesTab;

    @FindBy(locator = "xpath=//p-checkbox//div[contains(@class, 'p-checkbox-checked')]/following-sibling::label[text()=' CMPND Aging Data'])")
    public CustomElement cbAgingData;
    @FindBy(locator = "xpath=//p-checkbox//div[contains(@class, \"p-checkbox-checked\")]/following-sibling::label[text()=\" CMPND Resistance Properties\"]")
    public CustomElement cbResistanceProperties;
    @FindBy(locator = "xpath=//p-checkbox//div[contains(@class, \"p-checkbox-checked\")]/following-sibling::label[text()=\" Minimum Pulley Diameters\"]")
    public CustomElement cbPulleyDiameter;
    @FindBy(locator = "xpath=//p-checkbox//div[contains(@class, \"p-checkbox-checked\")]/following-sibling::label[text()=\" Transition\"]")
    public CustomElement cbTransition;
    @FindBy(locator = "xpath=//p-checkbox//div[contains(@class, \"p-checkbox-checked\")]/following-sibling::label[text()=\" Tolerance\"]")
    public CustomElement cbTolerance;


    public void navigateBeltInfoSteelListPage() {
        if (!lsSteel.isVisible())
            lsBeltInfo.click();
        lsSteel.click();
        waitForPageLoad(10000);
        SyncUtil.waitFor(5000);
        waitForElementVisible(txtBeltInfoSteelBreadCrumb, 5000, 500);
        Validator.assertTrue(txtBeltInfoSteelBreadCrumb.isVisible(), "Page is not redirected to Belt Info Steel page", "Redirected to  Belt Info Steel-list page");
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/form/belt-info-steel"), "URL missMatch", "URL validation passed");
    }

    public void navigateBeltInfoTextilePage() {
        if (!lsTextile.isVisible())
            lsBeltInfo.click();
        lsTextile.click();
        waitForPageLoad(10000);
        waitForElementVisible(txtBeltInfoTextileBreadCrumb, 10000, 500);
        Validator.assertTrue(txtBeltInfoTextileBreadCrumb.isVisible(), "Page is not redirected to Belt Info Textile page", "Redirected to  Belt Info Textile page");
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/form/belt-info-textile"), "URL missMatch", "URL validation passed");
    }

    public void addBeltInfoForm(String market, String customer, String beltConstruction, String carcassConstruction, String topCoverCompound, String topCoverGauge, String bottomCoverCompound, String bottomCoverGauge, String beltWidth, String breakerItem, String overallThickndess, String comment) {
        dropdownSelectSearch(ddlMarket, tbinput, market);
        dropdownSelectSearch(ddlStdRequestedbyCustomer, tbinput, customer);
        dropdownSelectSearch(ddlBeltConstruction, tbinput, beltConstruction);
        dropdownSelectSearch(ddlCarcassConstruction, tbinput, carcassConstruction);
        dropdownSelectSearch(ddlTopCoverCompound, tbinput, topCoverCompound);
        dropdownSelectSearch(ddlTopCoverGauge, tbinput, topCoverGauge);
        dropdownSelectSearch(ddlBottomCoverCompound, tbinput, bottomCoverCompound);
        dropdownSelectSearch(ddlBottomCoverGauge, tbinput, bottomCoverGauge);
//        tbBeltlength.type("1500");
        dropdownSelectSearch(ddlBeltwidth, tbinput, beltWidth);
        dropdownSelect(ddlBreaker, breakeritems, breakerItem);
        tbOverallbeltthickness.type(overallThickndess);
        textareaComment.type(comment);
        waitForPageLoad(6000);
    }

    public void verifyPreferencesTab() {
        preferencesTab.isVisible(10000, "PreferencesTab");
        preferencesTab.jsClick("Preferences");
        cbAgingData.isVisible(10000, "Aging Data");
        Validator.assertTrue(cbAgingData.isVisible() && cbResistanceProperties.isVisible() && cbPulleyDiameter.isVisible() && cbTransition.isVisible()
                && cbTolerance.isVisible(), "All the checkboxes of preferences tab are not checked by default", "All the checkboxes of preferences tab are checked by default");

    }

    public void generatePDF() {

        btnExportPDF.click();
        waitForPageLoad(15000);
        SyncUtil.waitFor(7000);
        Reporter.log("PDF is generated", MessageTypes.Pass);
    }


}



