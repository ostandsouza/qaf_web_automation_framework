package com.mobile.flutter.app.steps;

import com.mobile.flutter.app.pages.DashboardPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

public class DashboardSteps {

    @QAFTestStep(description = "Navigate to user My Profile screen")
    public void verifyNavigationToMyProfile() {
        DashboardPage.getInstance().goToProfilePage();
    }

    @QAFTestStep(description="Navigate to user My Profile screen")
    public void navigateToUserMyProfileScreen(){
        DashboardPage.getInstance().goToProfilePage();
    }
}
