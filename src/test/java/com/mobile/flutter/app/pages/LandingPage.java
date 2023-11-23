package com.mobile.flutter.app.pages;

import com.mobile.flutter.app.component.CustomFlutterElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;

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


    public boolean isContinentalPage() {
        continentalAcct.click();
        return continentalLoginPage.isContinentalPage();
    }

    public boolean goToContinentalAcct() {
        continentalAcct.waitForTheElementToBeVisible(30);
        continentalAcct.click();
        return continentalLoginPage.isContinentalPage();
    }

    public boolean goToGuestAcct() {
        guestAcct.click();
        return guestLoginPage.isGuestLoginPage();
    }

}
