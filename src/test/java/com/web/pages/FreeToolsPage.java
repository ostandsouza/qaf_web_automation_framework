package com.web.pages;

import com.common.component.CustomElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;

import static org.testng.Assert.assertEquals;

public class FreeToolsPage extends BasePage {

    @FindBy(locator = "xpath=(//li//span[text()='Free Tools'])[1]")
    public CustomElement freeTools;
    @FindBy(locator = "xpath=//span[text()='Capacity']")
    public CustomElement capacity;
    @FindBy(locator = "xpath=//ul[@role='tablist']//a/span[text()='Capacity']")
    public CustomElement capacityTab;
    @FindBy(locator = "//p-breadcrumb//nav[@data-pc-name=\"breadcrumb\"]")
    public CustomElement bcAddUserLink;
    @FindBy(locator = "xpath=//span[text()='Roll Length']")
    public CustomElement rollLength;

    @FindBy(locator = "xpath=//span[text()='Safety Factor Calculator']")
    public CustomElement safetyFactorCalculator;

    @FindBy(locator = "xpath=//span[text()='Units Converter']")
    public CustomElement unitsConverter;

    @FindBy(locator = "xpath=//span[text()='Belt Revolution']")
    public CustomElement beltRevolution;

    @FindBy(locator = "xpath=//span[text()='Wrap Angle']")
    public CustomElement wrapAngle;

    @FindBy(locator = "xpath=//span[text()='Clear']")
    public CustomElement clear;

    @FindBy(locator = "xpath=//span[text()='Calculate']")
    public CustomElement calculate;

    @FindBy(locator = "xpath=//ul[@role='tablist']//a/span[text()='Troughability']")
    public CustomElement troughabilityTab;

    @FindBy(locator = "xpath=//span[text()='Troughability']")
    public CustomElement troughability;
    @FindBy(locator = "xpath=//ul[@role='tablist']//a/span[text()='Safety Factor Calculator']")
    public CustomElement safetyFactorTab;
    @FindBy(locator = "xpath=//ul[@role='tablist']//a/span[text()='Belt Reel Dimensions']")
    public CustomElement rollLengthTab;

    @FindBy(locator = "xpath=//ul[@role='tablist']//a/span[text()='PIW PN ST Conversion']")
    public CustomElement PIWConverterTab;
    @FindBy(locator = "xpath=//ul[@role='tablist']//a/span[text()='Unit Converter']")
    public CustomElement unitConverterTab;
    @FindBy(locator = "xpath=//ul[@role='tablist']//a/span[text()='Belt Revolution']")
    public CustomElement beltRevolutionTab;
    @FindBy(locator = "xpath=//ul[@role='tablist']//a/span[text()='Wrap Angle']")
    public CustomElement wrapAngleTab;

    @FindBy(locator = "xpath=//p-skeleton//div[@data-pc-name=\"skeleton\"]")
    public CustomElement loaderSkeleton;


    public void goToCapacity() {
        if(!capacity.isVisible())
            freeTools.click("free tools");
        capacity.jsClick("Capacity");
        capacityTab.isVisible("Capacity Tab");
    }
    public void goToTroughability() {
        if(!troughability.isVisible())
            freeTools.click("free tools");
        troughability.jsClick("Troughability");
        troughabilityTab.isVisible("Troughability Tab");
    }

    public void goToRollLength() {
        if(!rollLength.isVisible())
            freeTools.click("free tools");
        rollLength.jsClick("Roll length");
        rollLengthTab.isVisible("Roll length");
    }

    public void goToSafetyFactor() {
        if(!safetyFactorCalculator.isVisible())
            freeTools.click("free tools");
        safetyFactorCalculator.jsClick("Safety factor calculator");
        safetyFactorTab.isVisible("Safety factor Tab");
    }

    public void goToPIWConverter() {
        if(!unitsConverter.isVisible())
            freeTools.click("free tools");
        unitsConverter.jsClick("Units Converter");
        PIWConverterTab.click();
        PIWConverterTab.isVisible("PIW Converter Tab");
    }

    public void goToUnitsConverter() {
        if(!unitsConverter.isVisible())
            freeTools.click("free tools");
        unitsConverter.jsClick("Units Converter");
        unitsConverter.click();
        unitConverterTab.isVisible("Units Converter Tab");
    }

    public void goToBeltRevolution() {
        if(!beltRevolution.isVisible())
            freeTools.click("free tools");
        beltRevolution.jsClick("Belt Revolution");
        beltRevolutionTab.isVisible("Belt Revolution Tab");
    }

    public void goToWrapAngle() {
        if(!wrapAngle.isVisible())
            freeTools.click("free tools");
        wrapAngle.jsClick("Wrap Angle");
        wrapAngleTab.isVisible("Wrap Angle Tab");
    }

    public void verifyBreadCrumb(String moduleName)
    {
        bcAddUserLink.isVisible(10000,"breadcrumb");
        loaderSkeleton.isNotVisible(10000);
        System.out.println(bcAddUserLink.getText()+"breadcrumb value is");
        System.out.println("Home\n"+moduleName+"breadcrumb retieved is");

        Validator.assertTrue(bcAddUserLink.getText().contains("Home\n"+moduleName), "User is not navigated to '"+moduleName+"' page","User is  navigated to '"+moduleName+"' page");

    }
}
