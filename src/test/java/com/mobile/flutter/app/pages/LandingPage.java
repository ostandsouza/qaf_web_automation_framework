package com.mobile.flutter.app.pages;

import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import com.qmetry.qaf.automation.util.Validator;

public class LandingPage extends FlutterBasePage {

    GuestLoginPage guestLoginPage = new GuestLoginPage();
    ContinentalLoginPage continentalLoginPage = new ContinentalLoginPage();

    private static LandingPage obj;
    public static LandingPage getInstance(){
        if(obj==null)
            obj = new LandingPage();
        return obj;
    }

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub
    }

    @FindBy(locator = "landing.continentalAcct.btn")
    public CustomFlutterElement continentalAcct;

    @FindBy(locator = "landing.guestAcct.btn")
    public CustomFlutterElement guestAcct;

    @FindBy(locator = "landing.continental.img")
    public CustomFlutterElement continentalImg;

    @FindBy(locator = "landing.welcome.page")
    public CustomFlutterElement welcomePage;

    public boolean isContinentalPage() {
        continentalAcct.click();
        return continentalLoginPage.isContinentalPage();
    }

    public boolean goToContinentalAcct() {
        continentalAcct.waitForTheElementToBeVisible(30);
        Validator.assertTrue(welcomePage.isVisible(),"Welcome Page is not visible","Welcome Page button is visible");
        Validator.assertTrue(continentalAcct.isVisible(),"ContinentalAcct button is not visible","ContinentalAcct button is visible");
        continentalAcct.click();
        return continentalLoginPage.isContinentalPage();
    }

    public boolean goToGuestAcct() {
        guestAcct.click();
        return guestLoginPage.isGuestLoginPage();
    }
    public boolean isWelcomePage() {
        Validator.assertTrue(welcomePage.isVisible(),"Welcome Page is not visible","Welcome Page is visible");
        Validator.assertTrue(continentalImg.isVisible(),"Login Page is not visible","Login Page is visible");
        Validator.assertTrue(continentalAcct.isVisible(),"ContinentalAcct button is not visible","ContinentalAcct button is visible");
        return welcomePage.isVisible();
    }

}
