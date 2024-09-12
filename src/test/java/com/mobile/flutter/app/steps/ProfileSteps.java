package com.mobile.flutter.app.steps;

import com.mobile.flutter.app.pages.CoverWearPage;
import com.mobile.flutter.app.pages.ProfilePage;
import com.mobile.nativectx.app.pages.ProfileNativePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

public class ProfileSteps {

    @QAFTestStep(description = "Verify changing of phone number from {Phone} to {NewPhone}")
    public void verifyChangePhoneNumber(String currentPhone, String newPhone) {
        ProfilePage.getInstance().goToProfileDetails();
        Validator.assertTrue(ProfilePage.getInstance().updatePhoneNumber(newPhone),"Phone number update message not displayed","Phone number update message displayed");
        Validator.assertTrue(ProfilePage.getInstance().getPhoneNumber().contains(newPhone),"Phone number was not updated","Phone number was updated successfully");
    }

    @QAFTestStep(description = "Navigate back to My profile screen")
    public void navigateBackToMyProfile() {
        ProfilePage.getInstance().goBackToProfile();
        ProfilePage.getInstance().isMyProfile();

    }

    @QAFTestStep(description = "Navigate back to My Information screen")
    public void navigateBackToMyInformation() {
        ProfilePage.getInstance().goBackToProfile();
    }

    @QAFTestStep(description = "Verify change update password from {Password} to {NewPassword}")
    public void verifyChangePassword(String currentPwd, String newPwd) {
        ProfilePage.getInstance().goToProfileDetails();
        ProfilePage.getInstance().goToChangePassword();
        Validator.assertTrue(ProfilePage.getInstance().changePassword(currentPwd,newPwd),"Change password update message not displayed","Change password update message displayed");
    }

    @QAFTestStep(description = "Verify user is able to logout from app")
    public void verifyUserLogout() {
        Validator.assertTrue(ProfilePage.getInstance().logoutUser(),"Login page is not displayed after logout", "Login page is displayed after logout");
    }
    @QAFTestStep(description ="Click on the settings icon in the My Profile page and verify it navigates to Settings page" )
    public void clickOnSettingsAndVerify()
    {ProfilePage.getInstance().settingsIconClickAndVerifyNav();}

    @QAFTestStep(description ="Verify the profile type for user {UserName}")
    public void verifyProfile(String email)
    {
        String profile= CoverWearPage.getInstance().apiBase.getUserProfileType(email);
        Validator.assertTrue(ProfileNativePage.getInstance().verifyProfileType(profile),"The profile type of the user is not visible in the profile page","The profile type of the user is visible in the profile page");
    }

    @QAFTestStep(description ="Go to profile information page and click on change pwd button and verify navigation" )
    public void changePwdClickAndVerifyNav()
    {
        ProfilePage.getInstance().goToProfileDetails();
        Validator.assertTrue(ProfilePage.getInstance().goToChangePassword(),"User is not navigated to change password page","User is navigated to change password page");
    }

}
