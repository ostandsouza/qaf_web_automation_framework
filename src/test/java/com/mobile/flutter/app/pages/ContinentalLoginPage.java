package com.mobile.flutter.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;

public class ContinentalLoginPage extends FlutterBasePage {

    DashboardPage dashboardPage = new DashboardPage();

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub
    }

    @FindBy(locator = "continental.email.field")
    public CustomFlutterElement emailField;

    @FindBy(locator = "continental.pwd.field")
    public CustomFlutterElement pwdField;

    @FindBy(locator = "continental.login.btn")
    public CustomFlutterElement loginBtn;

    @FindBy(locator = "continental.forgot.btn")
    public CustomFlutterElement forgotPwdBtn;

    @FindBy(locator = "continental.activate.btn")
    public CustomFlutterElement activateAcctBtn;


    public boolean isContinentalPage() {
        return emailField.isPresent();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String pwd) {
        pwdField.sendKeys(pwd);
    }

    public boolean login(String email, String pwd) {
        SyncUtil.waitFor(5000);
        enterEmail(email);
        enterPassword(pwd);
        loginBtn.click();
        return dashboardPage.isHomePage();
    }

}
