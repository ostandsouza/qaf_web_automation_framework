package com.web.steps;


import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.HeavyEquipmentPage;
import com.web.pages.MinutemanPage;

public class HeavyEquipmentSteps {
    HeavyEquipmentPage heavyEquipmentPage=new HeavyEquipmentPage();

    @QAFTestStep(description = "Navigate to the Heavy Equipment list page")
    public void navigateToTheHeavyEquipmentListPage() {
        heavyEquipmentPage.navigateHeavyEquipmentListPage();
    }

    @QAFTestStep(description = "Navigate to heavy equipment page and wait")
    public void navigateToHeavyEquipmentPageAndWait() {
        heavyEquipmentPage.goToHeavyEquipmentPageAndWait();
    }

    @QAFTestStep(description = "Verify the heavy equipment count with respect to pagination")
    public void validateTheHeavyEquipmentCountWrtPagination()
    {
        heavyEquipmentPage.validateHeavyEquipmentCountWrtPagination();
    }

}
