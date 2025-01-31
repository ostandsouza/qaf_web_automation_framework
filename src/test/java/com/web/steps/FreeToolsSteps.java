package com.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.FreeToolsPage;

public class FreeToolsSteps {

    FreeToolsPage freeToolsPage = new FreeToolsPage();

    @QAFTestStep(description = "Navigate to free tools capacity and verify the fields")
    public void navigateToCapacityFreeTools() {
        freeToolsPage.goToCapacity();
        Validator.assertTrue(freeToolsPage.verifyCapacityFields(),"Verification failed for capacity fields","Capacity fields are verified successfully");
    }

    @QAFTestStep(description = "Navigate to free tools troughability and verify the fields")
    public void navigateToTroughabilityFreeTools() {
        freeToolsPage.goToTroughability();
        Validator.assertTrue(freeToolsPage.verifyTroughabilityFields(),"Verification failed for troughability fields","Troughability fields are verified successfully");
    }

    @QAFTestStep(description = "Navigate to free tools roll length and verify the fields")
    public void navigateToRollLengthFreeTools() {
        freeToolsPage.goToRollLength();
        Validator.assertTrue(freeToolsPage.verifyRollLengthFields(),"Verification failed for roll length fields","Roll length fields are verified successfully");
    }

    @QAFTestStep(description = "Navigate to free tools safety factor and verify the fields")
    public void navigateToSafetyFactorFreeTools() {
        freeToolsPage.goToSafetyFactor();
        Validator.assertTrue(freeToolsPage.verifySafetyFactorFields(),"Verification failed for safety factor fields","Safety factor fields are verified successfully");
    }

    @QAFTestStep(description = "Navigate to free tools units converter and verify the fields")
    public void navigateToUnitsConverterFreeTools() {
        freeToolsPage.goToUnitsConverter();
        Validator.assertTrue(freeToolsPage.verifyUnitConversion(),"Verification failed for units converter fields","Units converter fields are verified successfully");
        freeToolsPage.goToPIWConverter();
        Validator.assertTrue(freeToolsPage.verifyPIWConversion(),"Verification failed for PIW converter fields","PIW converter fields are verified successfully");
    }

    @QAFTestStep(description = "Navigate to free tools belt revolution and verify the fields")
    public void navigateToBeltRevolutionFreeTools() {
        freeToolsPage.goToBeltRevolution();
        Validator.assertTrue(freeToolsPage.verifyBeltRevolution(),"Verification failed for belt revolution fields","Belt revolution fields are verified successfully");
    }

    @QAFTestStep(description = "Navigate to free tools wrap angle and verify the fields")
    public void navigateToWrapAngleFreeTools() {
        freeToolsPage.goToWrapAngle();
        Validator.assertTrue(freeToolsPage.verifyWrapAngle(),"Verification failed for wrap angle fields","Wrap angle fields are verified successfully");
    }

    @QAFTestStep(description = "Verify all the calculated data for conveyor capacity for entered data {BeltWidth} {Density} {SurchrgeAngle} {BeltSpeed} {Tonnage} {TroughAngle} {ConveyorLoad}")
    public void verifyConveyorCapacityCalculations(String beltWidth, String density, String surchargeAngle, String beltSpeed, String tonnage, String troughAngle, String conveyorLoad) {
        Validator.assertTrue(freeToolsPage.verifyCapacityCalculations(beltWidth, density, surchargeAngle, beltSpeed, tonnage, troughAngle, conveyorLoad),"Capacity calculation is failing", "Capacity calculation verified successfully");
    }

    @QAFTestStep(description = "Verify all the calculated data for troughability for entered data {RollerInclination} {Ratio}")
    public void verifyTroughabilityCalculations(String rollerInclination, String ratio) {
        Validator.assertTrue(freeToolsPage.verifyTroughabilityCalculations(rollerInclination, ratio),"Troughability calculation is failing", "Troughability calculation verified successfully");
    }

    @QAFTestStep(description = "Verify all the calculated data for roll length for entered data {ReelShape} {InnerDiameter} {RaceTrack} {ReelWeight} {BeltThickness} {BeltLength} {BeltWeight} {ReelDiameter} {ReelLength} {Revolutions} {TotalWeight}")
    public void verifyRollLengthCalculations(String reelShape, String innerDiameter, String racetrack, String reelWeight, String beltThickness, String beltLength, String beltWeight,  String reelDiameter, String reelLength, String revolutions, String totalWeight) {
        Validator.assertTrue(freeToolsPage.verifyRollLengthCalculations(reelShape, innerDiameter, racetrack, reelWeight, beltThickness, beltLength, beltWeight, reelDiameter, reelLength, revolutions, totalWeight),"Roll length calculation is failing", "Roll length calculation verified successfully");
    }

    @QAFTestStep(description = "Verify all the calculated data for safety calculator for entered data {BeltType} {BeltWidth} {BreakingStrength} {BreakingForce} {BeltTension} {SafetyFactor} {SafetyFactorMinimum} {StartUpMinimum}")
    public void verifySafetyCalculatorCalculations(String beltType, String beltWidth, String breakingStrength, String breakingForce, String beltTension, String safetyFactor, String safetyFactorMinimum,  String startupMinimum) {
        Validator.assertTrue(freeToolsPage.verifySafetyFactorCalculations(beltType, beltWidth, breakingStrength, breakingForce, beltTension, safetyFactor, safetyFactorMinimum, startupMinimum),"Safety factor calculation is failing", "Safety factor calculation verified successfully");
    }

    @QAFTestStep(description = "Verify all the calculated data for PIW converter for entered data {SafetyFactor} {SafetyFactorPN} {SafetyFactorST} {BreakingStrength} {OperatingTension1} {BreakingStrength1} {OperatingTension}")
    public void verifyPIWCalculatorCalculations(String safetyFactor, String safetyFactorPN, String safetyFactorST, String breakingStrength, String operatingTension1, String breakingStrength1, String operatingTension) {
        Validator.assertTrue(freeToolsPage.verifyUnitsCalculations(safetyFactor, safetyFactorPN, safetyFactorST, breakingStrength, operatingTension1, breakingStrength1, operatingTension),"Unit calculation is failing", "Unit calculation verified successfully");
    }

    @QAFTestStep(description = "Verify all the calculated data for belt revolution for entered data {TapedLength} {BeltSpeed} {TimeRevolutions}")
    public void verifyBeltRevolutionsCalculations(String tapedLength, String beltSpeed, String timeRevolutions) {
        Validator.assertTrue(freeToolsPage.verifyBeltRevolution(tapedLength, beltSpeed, timeRevolutions),"Belt revolution calculation is failing", "Belt revolution calculation verified successfully");
    }

    @QAFTestStep(description = "Verify all the calculated data for wrap angle for entered data {Direction} {Point1} {Point2} {WrapAngle}")
    public void verifyWrapAngleCalculations(String direction, String point1, String point2, String wrapAngle) {
        Validator.assertTrue(freeToolsPage.verifyWrapAngle(direction, point1, point2, wrapAngle),"Wrap angle calculation is failing", "Wrap angle calculation verified successfully");
    }
}
