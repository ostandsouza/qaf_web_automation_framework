package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;

public class FreeToolsPage extends BasePage{

    @FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
    public CustomElement home;

    @FindBy(locator = "xpath=(//li//span[text()='Free Tools'])[1]")
    public CustomElement freeTools;

    @FindBy(locator = "xpath=//span[text()='Capacity']")
    public CustomElement capacity;

    @FindBy(locator = "xpath=//span[text()='Troughability']")
    public CustomElement troughability;

    @FindBy(locator = "xpath=//ul[@role='tablist']//a/span[text()='Capacity']")
    public CustomElement capacityTab;
    @FindBy(locator = "//p-breadcrumb//nav[@data-pc-name=\"breadcrumb\"]")
    public CustomElement bcAddUserLink;
    @FindBy(locator = "xpath=//span[text()='Roll Length']")
    public CustomElement rollLength;

    @FindBy(locator = "xpath=//span[text()='Safety Factor Calculator']")
    public CustomElement safetyFactorCalculator;

    @FindBy(locator = "xpath=//span[text()='Unit Converter']")
    public CustomElement unitsConverter;

    @FindBy(locator = "xpath=//span[text()='Belt Revolution']")
    public CustomElement beltRevolution;

    @FindBy(locator = "xpath=//span[text()='Wrap Angle']")
    public CustomElement wrapAngle;

    @FindBy(locator = "xpath=//label[contains(text(),'Belt Width')]/..//input")
    public CustomElement beltWidthCapacity;

    @FindBy(locator = "xpath=//label[contains(text(),'Density')]/..//input")
    public CustomElement densityCapacity;

    @FindBy(locator = "xpath=//label[contains(text(),'Surcharge Angle')]/..//input")
    public CustomElement surchargeAngleCapacity;

    @FindBy(locator = "xpath=//label[contains(text(),'Belt Speed')]/..//input")
    public CustomElement beltSpeedCapacity;

    @FindBy(locator = "xpath=//label[contains(text(),'Tonnage')]/..//input")
    public CustomElement tonnageCapacity;

    @FindBy(locator = "xpath=//label[contains(text(),'Trough Angle')]/..//input")
    public CustomElement troughAngleCapacity;

    @FindBy(locator = "xpath=//label[contains(text(),'Conveyor Load')]/..//input")
    public CustomElement conveyorLoadCapacity;

    @FindBy(locator = "xpath=//span[text()='Clear']")
    public CustomElement clear;

    @FindBy(locator = "xpath=//span[text()='Calculate']")
    public CustomElement calculate;

    @FindBy(locator = "xpath=//ul[@role='tablist']//a/span[text()='Troughability']")
    public CustomElement troughabilityTab;

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

    @FindBy(locator = "xpath=//label[text()='Inclination of side idler rollers ']/parent::div//div[@role='button']")
    public CustomElement sideRollersTroughability;

    public String ListItem = "//ul[@role='listbox']//li//span";

    @FindBy(locator = "xpath=//label[contains(text(),'Min. value of ratio Deflection/Width')]/..//input")
    public CustomElement ratioTroughability;

    @FindBy(locator = "xpath=//label[text()='Reel Shape ']/parent::div//div[@role='button']")
    public CustomElement reelShapeRollLength;

    @FindBy(locator = "xpath=//label[contains(text(),'Inner Reel Diameter')]/..//input")
    public CustomElement innerDiameterRollLength;

    @FindBy(locator = "xpath=//label[contains(text(),'Race Track C-C')]/..//input")
    public CustomElement trackRollLength;

    @FindBy(locator = "xpath=//label[contains(text(),'Reel Weight')]/..//input")
    public CustomElement reelWeightRollLength;

    @FindBy(locator = "xpath=//label[contains(text(),'Belt Thickness')]/..//input")
    public CustomElement beltThicknessRollLength;

    @FindBy(locator = "xpath=//label[contains(text(),'Belt Length on Reel')]/..//input")
    public CustomElement beltLengthRollLength;

    @FindBy(locator = "xpath=//label[contains(text(),'Belt Weight')]/..//input")
    public CustomElement beltWeightRollLength;

    @FindBy(locator = "xpath=//label[text()='Reel Diameter ']/..//input")
    public CustomElement reelDiameterRollLength;

    @FindBy(locator = "xpath=//label[contains(text(),'Reel Length')]/..//input")
    public CustomElement reelLengthRollLength;

    @FindBy(locator = "xpath=//label[contains(text(),'Revolutions ')]/..//input")
    public CustomElement revolutionsRollLength;

    @FindBy(locator = "xpath=//label[text()='Total Reel Weight ']/..//input")
    public CustomElement totalReelWeightRollLength;

    @FindBy(locator = "xpath=//label[text()='Belt Type ']/parent::div//div[@role='button']")
    public CustomElement beltTypeSafetyFactor;

    @FindBy(locator = "xpath=//label[contains(text(),'Belt Width')]/..//input")
    public CustomElement beltWidthSafetyFactor;

    @FindBy(locator = "xpath=//label[contains(text(),'Breaking Strength')]/..//input")
    public CustomElement strengthSafetyFactor;

    @FindBy(locator = "xpath=//label[contains(text(),'Breaking Force')]/..//input")
    public CustomElement breakingForceSafetyFactor;

    @FindBy(locator = "xpath=//label[contains(text(),'Belt Tension')]/..//input")
    public CustomElement beltTensionSafetyFactor;

    @FindBy(locator = "xpath=//label[contains(text(),'SAFETY FACTOR DIN22101')]/..//input")
    public CustomElement safetyFactor;

    @FindBy(locator = "xpath=//label[contains(text(),'Safety Factor Minimum')]/..//input")
    public CustomElement minimumSafetyFactor;

    @FindBy(locator = "xpath=//label[contains(text(),'Safety Factor Start-Up Minimum')]/..//input")
    public CustomElement startUpSafetyFactor;

    @FindBy(locator = "xpath=//label[contains(text(),'Safety Factor')]/..//input")
    public CustomElement safetyFactorConverter;

    @FindBy(locator = "xpath=//label[contains(text(),'Safety Factor PN')]/..//input")
    public CustomElement safetyFactorPN;

    @FindBy(locator = "xpath=//label[contains(text(),'Safety Factor ST ')]/..//input")
    public CustomElement safetyFactorST;

    @FindBy(locator = "xpath=(//label[contains(text(),'Breaking Strength')]/..//input)[1]")
    public CustomElement breakingStrengthConverter;

    @FindBy(locator = "xpath=(//label[contains(text(),'Max. Operating Tension')]/..//input)[1]")
    public CustomElement maxOperatingTensionConverter;

    @FindBy(locator = "xpath=(//label[contains(text(),'Breaking Strength')]/..//input)[2]")
    public CustomElement breakingStrength;

    @FindBy(locator = "xpath=(//label[contains(text(),'Max. Operating Tension')]/..//input)[2]")
    public CustomElement maxOperatingTension;

    @FindBy(locator = "xpath=//label[text()='Physical parameter ']/parent::div//div[@role='button']")
    public CustomElement physicalParameterConverter;

    @FindBy(locator = "xpath=//label[text()='Metric Unit ']/parent::div//div[@role='button']")
    public CustomElement metricUnitConverter;

    @FindBy(locator = "xpath=//label[text()='Imperial Unit ']/parent::div//div[@role='button']")
    public CustomElement imperialUnitConverter;


    @FindBy(locator = "xpath=//label[contains(text(),'Taped Length')]/..//input")
    public CustomElement tapedLengthBeltRevolution;

    @FindBy(locator = "xpath=//label[contains(text(),'Belt Speed')]/..//input")
    public CustomElement beltSpeedRevolution;

    @FindBy(locator = "xpath=//label[contains(text(),'Time for 1 revolution')]/..//input")
    public CustomElement timeRevolution;

    @FindBy(locator = "xpath=//label[text()='Direction of belt travel ']/parent::div//div[@role='button']")
    public CustomElement beltTravelDirectionWrapAngle;

    @FindBy(locator = "xpath=//label[text()='Point 1 ']/parent::div//div[@role='button']")
    public CustomElement point1WrapAngle;

    @FindBy(locator = "xpath=//label[text()='Point 2 ']/parent::div//div[@role='button']")
    public CustomElement point2WrapAngle;

    @FindBy(locator = "xpath=//label[contains(text(),'Wrap Angle')]/..//input")
    public CustomElement wrapAngleResult;

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

    public boolean verifyCapacityFields() {
        return beltWidthCapacity.isEnable("Belt Capacity") && densityCapacity.isEnable("Density Capacity") && surchargeAngleCapacity.isEnable("Surcharge Angle") && beltSpeedCapacity.isEnable("Belt Speed") && tonnageCapacity.isEnable("Tonnage") && troughAngleCapacity.isEnable("Trough Angle") && !conveyorLoadCapacity.isEnabled();
    }

    public boolean verifyTroughabilityFields(){
        return sideRollersTroughability.isEnabled() && !ratioTroughability.isEnabled();
    }

    public boolean verifyRollLengthFields() {
        return reelShapeRollLength.isEnable("Reel Shape") && innerDiameterRollLength.isEnable("Inner Diameter") && trackRollLength.isEnable("Race rack") && reelWeightRollLength.isEnable("Reel Weight") && beltThicknessRollLength.isEnable("Belt Thickness") && beltLengthRollLength.isEnable("Belt Length") && beltWeightRollLength.isEnable("Belt Weight") && !reelDiameterRollLength.isEnabled() && !reelLengthRollLength.isEnabled() && !revolutionsRollLength.isEnabled() && !totalReelWeightRollLength.isEnabled();
    }

    public boolean verifySafetyFactorFields() {
        return beltTypeSafetyFactor.isEnable("Belt Type") && beltWidthSafetyFactor.isEnable("Belt Width") && strengthSafetyFactor.isEnable("Breaking Strength") && !breakingForceSafetyFactor.isEnabled() && beltTensionSafetyFactor.isEnable("Belt Tension") && !safetyFactor.isEnabled() && !minimumSafetyFactor.isEnabled() && !startUpSafetyFactor.isEnabled();
    }

    public boolean verifyPIWConversion() {
        return safetyFactorConverter.isEnable("Safety Factor") && breakingStrengthConverter.isEnable("Breaking Strength") && maxOperatingTension.isEnable("Max operating Tension") && !safetyFactorPN.isEnabled() && !safetyFactorST.isEnabled() && !maxOperatingTensionConverter.isEnabled() && !breakingStrength.isEnabled();
    }

    public boolean verifyUnitConversion() {
        return physicalParameterConverter.isEnable("Physical Parameter") && metricUnitConverter.isEnable("Metric Unit") && imperialUnitConverter.isEnable("Imperial Unit");
    }

    public boolean verifyBeltRevolution() {
        return tapedLengthBeltRevolution.isEnable("Taped Length") && beltSpeedRevolution.isEnable("Belt Speed") && !timeRevolution.isEnabled();
    }

    public boolean verifyWrapAngle() {
        return beltTravelDirectionWrapAngle.isEnable("Belt Travel Direction") && point1WrapAngle.isEnable("Point 1") && point2WrapAngle.isEnable("Point 2") && !wrapAngleResult.isEnabled();
    }

    public boolean verifyCapacityCalculations(String beltWidth, String density, String surchargeAngle, String beltSpeed, String tonnage, String troughAngle, String conveyorLoad){
        beltWidthCapacity.type(beltWidth);
        densityCapacity.type(density);
        surchargeAngleCapacity.type(surchargeAngle);
        beltSpeedCapacity.type(beltSpeed);
        tonnageCapacity.type(tonnage);
        troughAngleCapacity.type(troughAngle);
        calculate.click();
        SyncUtil.waitFor(7000);
        return conveyorLoadCapacity.getAttribute("value").equalsIgnoreCase(conveyorLoad);
    }

    public boolean verifyTroughabilityCalculations(String rollerInclination, String ratio){
        dropdownSelect(sideRollersTroughability, ListItem, rollerInclination);
        calculate.click();
        SyncUtil.waitFor(5000);
        return ratioTroughability.getAttribute("value").equalsIgnoreCase(ratio);
    }

    public void verifyBreadCrumb(String moduleName)
    {
        bcAddUserLink.isVisible(10000,"breadcrumb");
        loaderSkeleton.isNotVisible(10000);
        System.out.println(bcAddUserLink.getText()+"breadcrumb value is");
        System.out.println("Home\n"+moduleName+"breadcrumb retieved is");

        Validator.assertTrue(bcAddUserLink.getText().contains("Home\n"+moduleName), "User is not navigated to '"+moduleName+"' page","User is  navigated to '"+moduleName+"' page");

    }

    public boolean verifyRollLengthCalculations(String reelShape, String innerDiameter, String racetrack, String reelWeight, String beltThickness, String beltLength, String beltWeight,  String reelDiameter, String reelLength, String revolutions, String totalWeight){
        dropdownSelect(reelShapeRollLength, ListItem, reelShape);
        innerDiameterRollLength.type(innerDiameter);
        trackRollLength.type(racetrack);
        reelWeightRollLength.type(reelWeight);
        beltThicknessRollLength.type(beltThickness);
        beltLengthRollLength.type(beltLength);
        beltWeightRollLength.type(beltWeight);
        calculate.click();
        SyncUtil.waitFor(5000);
        return reelDiameterRollLength.getAttribute("value").equalsIgnoreCase(reelDiameter) && reelLengthRollLength.getAttribute("value").equalsIgnoreCase(reelLength) && revolutionsRollLength.getAttribute("value").equalsIgnoreCase(revolutions) && totalReelWeightRollLength.getAttribute("value").equalsIgnoreCase(totalWeight);
    }

    public boolean verifySafetyFactorCalculations(String beltType, String beltWidth, String breakingStrength, String breakingForce, String beltTension, String safetyFactors, String safetyFactorMinimum,  String startupMinimum){
        dropdownSelect(beltTypeSafetyFactor, ListItem, beltType);
        beltWidthSafetyFactor.type(beltWidth);
        strengthSafetyFactor.type(breakingStrength);
        beltTensionSafetyFactor.type(beltTension);
        calculate.click();
        SyncUtil.waitFor(5000);
        return breakingForceSafetyFactor.getAttribute("value").equalsIgnoreCase(breakingForce) && safetyFactor.getAttribute("value").equalsIgnoreCase(safetyFactors) && minimumSafetyFactor.getAttribute("value").equalsIgnoreCase(safetyFactorMinimum) && startUpSafetyFactor.getAttribute("value").equalsIgnoreCase(startupMinimum);
    }

    public boolean verifyUnitsCalculations(String safetyFactor, String safetyFactorPNVal, String safetyFactorSTVal, String breakingStrengthVal, String operatingTension1, String breakingStrength1, String operatingTension){
        safetyFactorConverter.type(safetyFactor);
        breakingStrengthConverter.type(breakingStrengthVal);
        System.out.println("operatingTension: ="+operatingTension);
        maxOperatingTension.type(operatingTension);
        calculate.click();
        SyncUtil.waitFor(5000);
        return safetyFactorPN.getAttribute("value").equalsIgnoreCase(safetyFactorPNVal) && safetyFactorST.getAttribute("value").equalsIgnoreCase(safetyFactorSTVal) && maxOperatingTensionConverter.getAttribute("value").equalsIgnoreCase(operatingTension1) && breakingStrength.getAttribute("value").equalsIgnoreCase(breakingStrength1);
    }

    public boolean verifyBeltRevolution(String tapedLength, String beltSpeed, String timeRevolutions){
        tapedLengthBeltRevolution.type(tapedLength);
        beltSpeedRevolution.type(beltSpeed);
        calculate.click();
        SyncUtil.waitFor(5000);
        return timeRevolution.getAttribute("value").equalsIgnoreCase(timeRevolutions);
    }

    public boolean verifyWrapAngle(String direction, String point1, String point2, String wrapAngle) {
        dropdownSelect(beltTravelDirectionWrapAngle, ListItem, direction);
        dropdownSelect(point1WrapAngle, ListItem, point1);
        dropdownSelect(point2WrapAngle, ListItem, point2);
        calculate.click();
        SyncUtil.waitFor(5000);
        System.out.println(wrapAngleResult.getAttribute("value"));
        System.out.println(wrapAngle);
        return wrapAngleResult.getAttribute("value").equalsIgnoreCase(wrapAngle);
    }
}
