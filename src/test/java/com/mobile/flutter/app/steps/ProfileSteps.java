package com.mobile.flutter.app.steps;

import com.mobile.flutter.app.pages.ProfilePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.mobile.flutter.app.pages.DashboardPage;

public class ProfileSteps {

    @QAFTestStep(description = "Verify changing of phone number from {Phone} to {NewPhone}")
    public void verifyChangePhoneNumber(String currentPhone, String newPhone) {
        ProfilePage.getInstance().goToProfileDetails();
        Validator.assertTrue(ProfilePage.getInstance().updatePhoneNumber(newPhone), "Phone number update message not displayed", "Phone number update message displayed");
        Validator.assertTrue(ProfilePage.getInstance().getPhoneNumber().contains(newPhone), "Phone number was not updated", "Phone number was updated successfully");
    }

    @QAFTestStep(description = "Navigate back to My profile screen")
    public void navigateBackToMyProfile() {
        ProfilePage.getInstance().goBackToProfile();
    }

    @QAFTestStep(description = "Navigate back to My Information screen")
    public void navigateBackToMyInformation() {
        ProfilePage.getInstance().goBackToProfile();
    }

    @QAFTestStep(description = "Verify change update password from {Password} to {NewPassword}")
    public void verifyChangePassword(String currentPwd, String newPwd) {
        ProfilePage.getInstance().goToProfileDetails();
        ProfilePage.getInstance().goToChangePassword();
        Validator.assertTrue(ProfilePage.getInstance().changePassword(currentPwd, newPwd), "Change password update message not displayed", "Change password update message displayed");
    }

    @QAFTestStep(description = "Verify user is able to logout from app")
    public void verifyUserLogout() {
        Validator.assertTrue(ProfilePage.getInstance().logoutUser(), "Login page is not displayed after logout", "Login page is displayed after logout");
    }

    @QAFTestStep(description = "Click and Verify navigation to Settings Screen")
    public void clickAndVerifyTheNavigationToSettingPage() {
        ProfilePage.getInstance().clickAndVerifyNavigationToSettingPage();
    }

    @QAFTestStep(description = "Navigate back to Home screen from My Profile Page")
    public void navigateBackToTheHomePageFromProfile() {
        ProfilePage.getInstance().goBackToProfile();
        Validator.assertTrue(DashboardPage.getInstance().isHomePage(), "Not Redirected to Home Page", "Redirected to Home Page");
    }

    @QAFTestStep(description = "Verify change password from {Password} to {NewPassword} and {RetypeNewPassword}")
    public void verifyTheChangePasswordDetails(String currentPwd, String newPwd, String reNewPwd) {
        ProfilePage.getInstance().goToProfileDetails();
        ProfilePage.getInstance().goToChangePassword();
        ProfilePage.getInstance().changeThePassword(currentPwd, newPwd, reNewPwd);
    }

    @QAFTestStep(description = "Verify Retype password error message")
    public void verifyTheRetypeError() {
        ProfilePage.getInstance().verifyRetypePasswordErrorMessage();

    }
}
