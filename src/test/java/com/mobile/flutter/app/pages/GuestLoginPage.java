package com.mobile.flutter.app.pages;

import com.mobile.flutter.app.component.CustomFlutterElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;

public class GuestLoginPage extends FlutterBasePage {

    private static GuestLoginPage obj;
    public static GuestLoginPage getInstance(){
        if(obj==null)
            obj = new GuestLoginPage();
        return obj;
    }

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub
    }

    @FindBy(locator = "guest.skipIntro.btn")
    public CustomFlutterElement skipIntro;


    public boolean isGuestLoginPage() {
        return skipIntro.isPresent();
    }

}
