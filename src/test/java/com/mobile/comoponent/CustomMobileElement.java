package com.mobile.comoponent;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.mobile.utils.DIRECTION;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.util.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class CustomMobileElement extends CustomElement {

    public CustomMobileElement(String locator) {
        super(locator);
    }

    protected CustomMobileElement(QAFExtendedWebDriver driver) {
        super(driver);
    }

    public CustomMobileElement(CustomElement parent, String locator) {
        super(parent, locator);
    }

    /**
     * @return AppiumDriver - Underlying appium driver
     */
    @SuppressWarnings("rawtypes")
    public AppiumDriver getAppiumDriver() {
        return (AppiumDriver) this.getWrappedDriver().getUnderLayingDriver();
    }


    /**
     * Performs single tap on the object
     *
     * @param objName : Name of object for reporting purpose	 *
     */
    public void singleTap(String objName) {
        this.singleTap();
        Reporter.log("Taped on " + objName, MessageTypes.Info);
    }

    /**
     * Performs single tap on the object
     */
    @SuppressWarnings("rawtypes")
    public void singleTap() {
        try {
            new TouchAction((PerformsTouchActions) this.getWrappedDriver().getUnderLayingDriver()).tap(new TapOptions().withElement(new ElementOption().withElement(this))).perform();
        } catch (Exception e) {
            Reporter.log("Failed to tap due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }

    }

    /**
     * Double taps on the object
     *
     * @param objName : Name of object for reporting purpose
     */
    @SuppressWarnings("rawtypes")
    public void doubleTap(String objName) {
        try {
            new TouchAction((PerformsTouchActions) this.getWrappedDriver().getUnderLayingDriver()).tap(new TapOptions().withElement(new ElementOption().withElement(this)).withTapsCount(2))
                    .perform();
            Reporter.log("Double taped on " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to double tap on " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }

    }

    /**
     * @return Assigned locator info for this object
     */
    public String getLocator() {
        return this.locator;
    }

    /**
     * Swipe on object in given direction
     *
     * @param direction : LEFT, RIGHT, UP, DOWN
     * @param objName   : Name of object for reporting purpose
     */
    @SuppressWarnings("rawtypes")
    public void swipe(DIRECTION direction, String... objName) {
        Dimension currentWindow = this.getSize();
        int deviceWidth = currentWindow.getWidth();
        int deviceHeight = currentWindow.getHeight();
        int startX = 0, startY = 0, endX = 0, endY = 0;

        switch (direction) {
            case LEFT:
                startX = (int) (deviceWidth * .75f);
                startY = (int) (deviceHeight * .5f);
                endX = (int) (deviceWidth * .15f);
                endY = startY;
                break;

            case RIGHT:
                startX = (int) (deviceWidth * .15f);
                startY = (int) (deviceHeight * .5f);
                endX = (int) (deviceWidth * .75f);
                endY = startY;
                break;

            case UP:
                startX = (int) (deviceWidth * .5f);
                startY = (int) (deviceHeight * .75f);
                endX = startX;
                endY = (int) (deviceHeight * .25f);
                break;

            case DOWN:
                startX = (int) (deviceWidth * .5f);
                startY = (int) (deviceHeight * .25f);
                endX = startX;
                endY = (int) (deviceHeight * .75f);

        }
        new TouchAction((PerformsTouchActions) this.getWrappedDriver().getUnderLayingDriver()).press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(endX, endY)).release().perform();
        SyncUtil.waitFor(1000);
        if (objName.length > 0)
            Reporter.log("Swiped " + direction + " on " + objName, MessageTypes.Info);
        else
            Reporter.log("Swiped " + direction + " on element", MessageTypes.Info);

    }

    /**
     * @return True if object is scrollable otherwise false
     */
    public boolean isScrollable() {
        boolean result = false;
        try {
            result = Boolean.parseBoolean(this.getAttribute("scrollable"));
        } catch (Exception ignore) {
        }
        return result;
    }

    /**
     * @return True if object is checked otherwise false
     */
    public boolean isChecked() {
        boolean result = false;
        try {
            result = Boolean.parseBoolean(this.getAttribute("checked"));
        } catch (Exception ignore) {
        }
        return result;
    }


}
