package com.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.FreeToolsPage;

public class FreeToolsSteps {
    FreeToolsPage freeToolsPage=new FreeToolsPage();

    @QAFTestStep(description = "Navigate to free tools capacity and verify the breadcrumb  for {moduleName}")
    public void navigateToCapacityFreeToolsAndVerifyBreadCrumb(String moduleName) {
        freeToolsPage.goToCapacity();
        freeToolsPage.verifyBreadCrumb(moduleName);
    }
    @QAFTestStep(description = "Navigate to free tools troughability and verify the breadcrumb for {moduleName}")
    public void navigateToTroughabilityAndVerifyBreadCrumb(String moduleName) {
        freeToolsPage.goToTroughability();
        freeToolsPage.verifyBreadCrumb(moduleName);
    }

    @QAFTestStep(description = "Navigate to free tools Roll Length and verify the breadcrumb for {moduleName}")
    public void navigateToRollLengthAndVerifyBreadCrumb(String moduleName) {
        freeToolsPage.goToRollLength();
        freeToolsPage.verifyBreadCrumb(moduleName);
    }
    @QAFTestStep(description = "Navigate to free tools Safety factor and verify the breadcrumb for {moduleName}")
    public void navigateToSafetyFactorAndVerifyBreadCrumb(String moduleName) {
        freeToolsPage.goToSafetyFactor();
        freeToolsPage.verifyBreadCrumb(moduleName);
    }
    @QAFTestStep(description = "Navigate to free tools Units Converter and verify the breadcrumb for {moduleName}")
    public void navigateToUnitsFactorAndVerifyBreadCrumb(String moduleName) {
        freeToolsPage.goToUnitsConverter();
        freeToolsPage.verifyBreadCrumb(moduleName);
    }
    @QAFTestStep(description = "Navigate to free tools Belt Revolution and verify the breadcrumb for {moduleName}")
    public void navigateToBeltRevolutionAndVerify(String moduleName) {
        freeToolsPage.goToBeltRevolution();
        freeToolsPage.verifyBreadCrumb(moduleName);
    }
    @QAFTestStep(description = "Navigate to free tools Wrap Angle and verify the breadcrumb for {moduleName}")
    public void navigateToWrapAngleAndVerifyBreadCrumb(String moduleName) {
        freeToolsPage.goToWrapAngle();
        freeToolsPage.verifyBreadCrumb(moduleName);
    }
}
