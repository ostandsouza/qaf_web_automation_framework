package com.mobile.android.app.comoponent;

import com.common.component.CustomElement;
import com.mobile.comoponent.CustomMobileElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AndroidMobileElement extends CustomMobileElement {

    public AndroidMobileElement(String locator) {
        super(locator);
    }

    protected AndroidMobileElement(QAFExtendedWebDriver driver) {
        super(driver);
    }

    public AndroidMobileElement(CustomMobileElement parent, String locator) {
        super(parent, locator);
    }

    /**
     * @return AndroidDriver - Underlying android driver
     */

    @SuppressWarnings("rawtypes")
    public AndroidDriver getAndroidDriver() {
        return (AndroidDriver) getAppiumDriver();
    }

    /**
     * Performs android back operation
     */
    public void goBack() {
        getAndroidDriver().pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }

}
