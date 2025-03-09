package com.web.steps;


import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.HeavyEquipmentPage;
import com.web.pages.IotDashboardPage;

public class IotDashboardSteps {
    IotDashboardPage iotDashboardPage=new IotDashboardPage();

    @QAFTestStep(description = "Navigate to iot dashboard list screen and wait to load data")
    public void verifyTheIotDashboardListNavAndWait() {
        iotDashboardPage.gotoIotDashboardScreenWait();
    }

    @QAFTestStep(description = "Verify the iot dashboard count with respect to pagination")
    public void validateTheIotDashboardCountWrtPagination()
    {
        iotDashboardPage.validateIotDashboardCountWrtPagination();
    }

}
