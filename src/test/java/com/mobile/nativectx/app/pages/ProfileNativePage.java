package com.mobile.nativectx.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.component.CustomMobileElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class ProfileNativePage extends NativeBasePage {

    private static ProfileNativePage obj;

    public static ProfileNativePage getInstance(){
        if(obj==null)
            obj = new ProfileNativePage();
        return obj;
    }

    @FindBy(locator = "profile.type.text")
    protected CustomMobileElement userProfileType;



    public boolean verifyProfileType(String profile)
    {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        SyncUtil.waitFor(20000);
        waitUntilElementIsVisible(userProfileType);
        System.out.println(userProfileType.getAttribute("content-desc")+"user type print");
        boolean flag=userProfileType.getAttribute("content-desc").contains(profile);
        switchContext("FLUTTER");
        return flag;
    }
}