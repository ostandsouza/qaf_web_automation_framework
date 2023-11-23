package com.mobile.flutter.app.steps;

import com.mobile.flutter.app.pages.ConveyorPage;
import com.mobile.flutter.app.pages.InspectionPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

public class InspectionSteps {

    @QAFTestStep(description = "Add inspection with {InspectionName} {ConveyorName} {CustSiteName}")
    public void verifyAddInspection(String inspectionName, String conveyorName, String custSiteName) {
        Validator.assertTrue(InspectionPage.getInstance().addInspection(inspectionName, conveyorName, custSiteName),"New Inspection was not created","New Inspection was created successfully");
    }
}
