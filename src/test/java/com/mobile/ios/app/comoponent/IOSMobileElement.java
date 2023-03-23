package com.mobile.ios.app.comoponent;

import com.common.component.CustomElement;
import com.mobile.comoponent.CustomMobileElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import io.appium.java_client.ios.IOSDriver;

public class IOSMobileElement extends CustomMobileElement {

    public IOSMobileElement(String locator) {
        super(locator);
    }

    protected IOSMobileElement(QAFExtendedWebDriver driver) {
        super(driver);
    }

    public IOSMobileElement(CustomMobileElement parent, String locator) {
        super(parent, locator);
    }

    /**
     * @return iOSDriver - Underlying iOS driver
     */

    @SuppressWarnings("rawtypes")
    public IOSDriver getAndroidDriver() {
        return (IOSDriver) getAppiumDriver();
    }


}
