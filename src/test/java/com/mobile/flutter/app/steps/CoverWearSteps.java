package com.mobile.flutter.app.steps;

import com.mobile.flutter.app.pages.ConveyorPage;
import com.mobile.flutter.app.pages.CoverWearPage;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

public class CoverWearSteps {

    @QAFTestStep(description = "User navigates to cover wear from conveyor tile details with {ConveyorName} {CustCorpName} {CustSite}")
    public void verifyCoverWearNav(String conveyorName, String custCorp, String custSIte) {
        String conveyorId= CoverWearPage.getInstance().apiBase.getConveyorsAPI(conveyorName);
        if(conveyorId != null) {
            String ultrasonicId = CoverWearPage.getInstance().apiBase.getUltrasonicId(CoverWearPage.getInstance().apiBase.getUltrasonicAPI(conveyorId));
            CoverWearPage.getInstance().apiBase.deleteUltrasonicAPI(ultrasonicId);
        }
        CoverWearPage.getInstance().goToCoverWearViaConveyor(conveyorName);
    }

    @QAFTestStep(description = "Fill Cover Wear specifications")
    public void verifyCoverWearSpecs() {
        CoverWearPage.getInstance().fillCoverWearSpecs();
    }

    @QAFTestStep(description = "Verify the default positions")
    public void verifyDefaultPositions() {
        DashboardNativePage.getInstance().verifyPositionCount();
        DashboardNativePage.getInstance().verifyPositionsValues();
    }
}
