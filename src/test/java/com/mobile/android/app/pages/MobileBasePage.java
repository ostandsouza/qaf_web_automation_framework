package com.mobile.android.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.utils.DIRECTION;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class MobileBasePage extends WebDriverBaseTestPage<WebDriverTestPage> {

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub

    }

    @SuppressWarnings("rawtypes")
    public AppiumDriver getAppiumDriver() {
        return (AppiumDriver) getTestBase().getDriver().getUnderLayingDriver();
    }

    @SuppressWarnings("rawtypes")
    public AndroidDriver getAndroidDriver() {
        return (AndroidDriver) getAppiumDriver();
    }

    public void hideKeyBoard() {
        (this.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)this.getAppiumDriver() : (IOSDriver)this.getAppiumDriver()).hideKeyboard();
    }

    @SuppressWarnings("rawtypes")
    public void refreshScreen() {
        Dimension currentWindow = driver.manage().window().getSize();
        int deviceWidth = currentWindow.getWidth();
        int deviceHeight = currentWindow.getHeight();
        int midX = (deviceWidth / 2);
        int midY = (deviceHeight / 2);
        int bottomEdge = (int) (deviceHeight * 0.85f);
        new TouchAction((this.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)this.getAppiumDriver() : (IOSDriver)this.getAppiumDriver())).press(PointOption.point(midX, midY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(midX, bottomEdge))
                .release().perform();
        Reporter.log("Refreshed screen", MessageTypes.Info);
    }

    @SuppressWarnings("rawtypes")
    public void Swipe(DIRECTION direction) {
        Dimension currentWindow = driver.manage().window().getSize();
        int deviceWidth = currentWindow.getWidth();
        int deviceHeight = currentWindow.getHeight();
        int startX = 0, startY = 0, endX = 0, endY = 0;

        switch (direction) {
            case LEFT:
                startX = (int) (deviceWidth * .85f);
                startY = (int) (deviceHeight * .5f);
                endX = (int) (deviceWidth * .15f);
                endY = startY;
                break;

            case RIGHT:
                startX = (int) (deviceWidth * .15f);
                startY = (int) (deviceHeight * .5f);
                endX = (int) (deviceWidth * .85f);
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
        new TouchAction((this.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)this.getAppiumDriver() : (IOSDriver)this.getAppiumDriver())).press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(endX, endY))
                .release().perform();
        SyncUtil.waitFor(1000);
        Reporter.log("Swiped " + direction + " on screen", MessageTypes.Info);

    }

    @SuppressWarnings("rawtypes")
    public void Swipe(int startX, int startY, int endX, int endY) {
        new TouchAction((this.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)this.getAppiumDriver() : (IOSDriver)this.getAppiumDriver())).press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(endX, endY))
                .release().perform();
        Reporter.log("Swiped from (" + startX + "," + startY + ") to (" + endX + "," + endY + ") on screen", MessageTypes.Info);

    }

    public void scrollToText(String text) {
        String locString = String.format("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"%s\"))", text);
        getAppiumDriver().findElement(MobileBy.AndroidUIAutomator(locString));
    }

    public void goBack() {
        getAndroidDriver().pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }

    public void activateAppUnderTest() {
        String appName = ConfigurationManager.getBundle().getString("android.apk.appName");
        ApplicationState currState = (this.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)this.getAppiumDriver() : (IOSDriver)this.getAppiumDriver()).queryAppState(appName);
        if (currState == ApplicationState.RUNNING_IN_FOREGROUND)
            Reporter.log(appName + " is active", MessageTypes.Pass);
        else if (currState == ApplicationState.RUNNING_IN_BACKGROUND) {
            (this.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)this.getAppiumDriver() : (IOSDriver)this.getAppiumDriver()).activateApp(appName);
            Reporter.log(appName + " is activated", MessageTypes.Pass);
        } else
            Reporter.log(appName + "App is not running", MessageTypes.Fail);
    }

    public void clearCache(String appPackage) {
        Map<String, Object> args = new HashMap<>();
        String command;
        if (!ConfigurationManager.getBundle().getString("remote.server").contains("perfecto")) {
            args.put("command", "pm");
            args.put("args", "clear " + appPackage);
            command = "mobile: shell";
            getAppiumDriver().executeScript(command, args);
        } else {
            try {
                args.put("identifier", appPackage);
                command = "mobile:application:clean";
                getAppiumDriver().executeScript(command, args);
            } catch (Exception ignore) {
            }
        }

    }
}
