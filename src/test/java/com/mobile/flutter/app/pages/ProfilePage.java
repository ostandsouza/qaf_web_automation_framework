package com.mobile.flutter.app.pages;

import com.mobile.flutter.app.component.CustomFlutterElement;
import com.qmetry.qaf.automation.support.flutter.FlutterElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.web.pages.LoginPage;

public class ProfilePage extends FlutterBasePage {

    private static ProfilePage obj;

    public static ProfilePage getInstance(){
        if(obj==null)
            obj = new ProfilePage();
        return obj;
    }

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub
    }

    @FindBy(locator = "profile.title.text")
    public CustomFlutterElement profileName;

    @FindBy(locator = "profile.details.btn")
    public CustomFlutterElement detailsBtn;

    @FindBy(locator = "profile.settings.btn")
    public CustomFlutterElement settingsBtn;

    @FindBy(locator = "profile.logout.btn")
    public CustomFlutterElement logoutBtn;

    @FindBy(locator = "profile.delete.acct")
    public CustomFlutterElement deleteAcct;

    @FindBy(locator = "profile.back.btn")
    public CustomFlutterElement backBtn;

    @FindBy(locator = "information.name.field")
    public CustomFlutterElement fullNameField;

    @FindBy(locator = "information.phone.field")
    public CustomFlutterElement phoneField;

    @FindBy(locator = "information.email.field")
    public CustomFlutterElement emailField;

    @FindBy(locator = "information.type.field")
    public CustomFlutterElement typeField;

    @FindBy(locator = "information.success.msg")
    public CustomFlutterElement infoSuccessMsg;

    @FindBy(locator = "information.changePwd.btn")
    public CustomFlutterElement changePwd;

    @FindBy(locator = "information.save.btn")
    public CustomFlutterElement saveInfoBtn;

    @FindBy(locator = "pwd.current.field")
    public CustomFlutterElement currentPwdField;

    @FindBy(locator = "pwd.new.field")
    public CustomFlutterElement newPwdField;

    @FindBy(locator = "pwd.retype.field")
    public CustomFlutterElement retypePwdField;

    @FindBy(locator = "pwd.save.btn")
    public CustomFlutterElement savePwd;

    @FindBy(locator = "pwd.success.msg")
    public CustomFlutterElement savePwdSuccessMsg;

    @FindBy(locator = "settings.imperial.btn")
    public CustomFlutterElement imperialBtn;

    @FindBy(locator = "settings.metric.btn")
    public CustomFlutterElement metricBtn;

    public boolean isMyProfile() {
        return profileName.isVisible();
    }

    public boolean goToProfileDetails() {
        detailsBtn.click("Details Button");
        return fullNameField.isVisible("My Information page");
    }

    public boolean updatePhoneNumber(String phoneNumber) {
        phoneField.clear();
        phoneField.sendKeys("+91"+phoneNumber, "Send new phone");
        saveInfoBtn.click("Save info Button");
        return infoSuccessMsg.waitForTheElementToBeVisible(10, "Information save successfully message");
    }

    public String getPhoneNumber() {
        return phoneField.getText("Phone");
    }

    public void goBackToProfile(){
        backBtn.click();
    }

    public boolean goToChangePassword(){
        changePwd.click("Change Pwd button");
        return currentPwdField.isVisible("Current password field");
    }

    public boolean changePassword(String currentPwd, String newPwd) {
        currentPwdField.sendKeys(currentPwd,"Current Pwd");
        newPwdField.sendKeys(newPwd,"New Password Pwd");
        retypePwdField.sendKeys(newPwd,"Re-Type Pwd");
        savePwd.click("Save password");
        return savePwdSuccessMsg.waitForTheElementToBeVisible(10, "Password changed successfully message");
    }

    public boolean logoutUser(){
        logoutBtn.click("Logout button");
        return LandingPage.getInstance().isContinentalPage();
    }
}
