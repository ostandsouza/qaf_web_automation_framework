package com.mobile.flutter.app.steps;

import com.mobile.flutter.app.pages.DashboardPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

public class DashboardSteps {

    DashboardPage dashboardPage = new DashboardPage();

    @QAFTestStep(description = "User navigates to add corporate screen")
    public void addCorpNavigation() {
        Validator.assertTrue(dashboardPage.goToAddCorp(),"Add corporate is not visible","Add corporate page is visible");
    }

    @QAFTestStep(description = "Add Distributor corporate with {CorpName} {Address}")
    public void verifyAddCorporate(String corpName, String address) {
        Validator.assertTrue(dashboardPage.addCorpDetails("New_Company", "Manque Global - Luggage Storage In Mumbai Airport, Chhatrapati Shivaji Maharaj International Airport Road, Navpada, Vile Parle East, Vile Parle, Mumbai, Maharashtra, India"),"New corporate was not created","New corporate was created successfully");
    }

    @QAFTestStep(description = "Navigate to corporate list and verify {CorpName} is present")
    public void verifyCorporateCreation() {
        dashboardPage.verifyCorpCreation("New_Company");
    }
}
