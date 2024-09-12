package com.mobile.flutter.app.steps;

import com.mobile.flutter.app.pages.DashboardPage;
import com.mobile.flutter.app.pages.ProfilePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

public class DashboardSteps {

    @QAFTestStep(description = "Navigate to user My Profile screen")
    public void verifyNavigationToMyProfile() {
        DashboardPage.getInstance().goToProfilePage();
    }

//    @QAFTestStep(description="Navigate to user My Profile screen")
//    public void navigateToUserMyProfileScreen(){
//        DashboardPage.getInstance().goToProfilePage();
//    }


    @QAFTestStep(description="Verify user present in home screen")
    public void verifyTheHomeScreen(){
        DashboardPage.getInstance().isHomePage();
    }
    @QAFTestStep(description="Verify home screen details")
    public void verifyTheHomeScreenDetails(){
        DashboardPage.getInstance().verifyHomeScreenDetails();
    }

    @QAFTestStep(description="Verify home page Add Icon navigation")
    public void verifyTheHomePageAddIcon(){
        DashboardPage.getInstance().verifyHomePageAddIcon();
    }

    @QAFTestStep(description="Navigate to add conveyor page via Home and verify navigation")
    public void navigateToTheAddConveyorPageViaHome(){
        DashboardPage.getInstance().goToConveyor();
    }

    @QAFTestStep(description="Navigate to add site page via Home and verify navigation")
    public void navigateToTheAddSitePageViaHome(){
        DashboardPage.getInstance().goToSiteShop();
    }


    @QAFTestStep(description="Navigate to add corporate page via Home and verify navigation")
    public void navigateToTheAddCorporatePageViaHome(){
        DashboardPage.getInstance().goToAddCorp();
    }


    @QAFTestStep(description="Navigate to add inspection page via Home and verify navigation")
    public void navigateToTheAddInspectionPageViaHome(){
        DashboardPage.getInstance().goToInspection();
    }
    @QAFTestStep(description = "Navigate to user My Information screen")
    public void verifyNavigationToMyInformationScreen() {
        ProfilePage.getInstance().goToProfileDetails();
    }


}
