package com.mobile.nativectx.app.component;

import com.google.common.collect.ImmutableMap;
import com.mobile.utils.DIRECTION;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.util.Reporter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.Arrays;

public class CustomAndroidElement extends CustomMobileElement {

    public CustomAndroidElement(String locator) {
        super(locator);
    }

    /**
     * Performs single tap on the android object
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void doubleTap(String objName) {
        try {
            getAppiumDriver().executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) this).getId()));

            Reporter.log("Taped on " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to tap due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs scroll down on the android scree
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void scrollDownOnAndroid(String... objName) {
        String curObjName = Arrays.toString(objName);
        try {
            Dimension frame =getAppiumDriver().manage().window().getSize();
            int centerX = frame.width/2;
            int startY = (int) (frame.height*(0.90));
            int endY = (int) (frame.height*(0.50));

            getAppiumDriver().executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", centerX, "top", endY, "width", centerX, "height", startY,
                    "direction", "down",
                    "percent", 1
            ));

            Reporter.log("Scroll direction " + curObjName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to scroll due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs scroll down to the android element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void scrollDownToAndroidElement(String objName) {
        try {
            getAppiumDriver().executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) this).getId(),
                    "direction", "down",
                    "percent", 1
            ));

            Reporter.log("Scroll on " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to scroll due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs scroll up to the android element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void scrollUpToAndroidElement(String objName) {
        try {
            getAppiumDriver().executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) this).getId(),
                    "direction", "up",
                    "percent", 1
            ));

            Reporter.log("Scroll direction " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to scroll due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs scroll up on the android
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void scrollUpOnAndroid(String... objName) {
        String curObjName = Arrays.toString(objName);
        try {
            Dimension frame =getAppiumDriver().manage().window().getSize();
            int centerX = frame.width/2;
            int startY = (int) (frame.height*(0.90));
            int endY = (int) (frame.height*(0.50));
            getAppiumDriver().executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", centerX, "top", endY, "width", centerX, "height", startY,
                    "direction", "up",
                    "percent", 1
            ));

            Reporter.log("Scroll direction " + curObjName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to scroll due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs swipe left on the android
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void swipeLeftOnAndroid(String... objName) {
        String curObjName = Arrays.toString(objName);
        try {

            int centerY = this.getRect().y + (this.getSize().height/2);

            double startX = this.getRect().x + (this.getSize().width * 0.9);

            double endX = this.getRect().x + (this.getSize().width * 0.1);

            getAppiumDriver().executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "left", (int)startX, "top", centerY, "width", (int)endX, "height", centerY,
                    "direction", "left",
                    "percent", 0.75
            ));

            Reporter.log("Swipe direction " + curObjName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to swipe due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs swipe left on the android element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void swipeLeftOnAndroidElement(String objName) {
        try {

            getAppiumDriver().executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) this).getId(),
                    "direction", "left",
                    "percent", 1
            ));
            Reporter.log("Swipe direction " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to swipe due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs swipe right on the android
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void swipeRightOnAndroid(String... objName) {
        String curObjName = Arrays.toString(objName);
        try {

            int centerY = this.getRect().y + (this.getSize().height/2);

            double startX = this.getRect().x + (this.getSize().width * 0.9);

            double endX = this.getRect().x + (this.getSize().width * 0.1);

            getAppiumDriver().executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "left", (int)endX, "top", centerY, "width", (int)startX, "height", centerY,
                    "direction", "right",
                    "percent", 0.75
            ));

            Reporter.log("Swipe direction " + curObjName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to swipe due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs swipe right on the android element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void swipeRightOnAndroidElement(String objName) {
        try {

            getAppiumDriver().executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) this).getId(),
                    "direction", "right",
                    "percent", 1
            ));
            Reporter.log("Swipe direction " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to swipe due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Swipe on object in given direction
     *
     * @param direction : LEFT, RIGHT, UP, DOWN
     * @param objName   : Name of object for reporting purpose
     */
    public void swipe(DIRECTION direction, String... objName) {

        switch (direction) {
            case LEFT:
                swipeLeftOnAndroid(objName);
                break;

            case RIGHT:
                swipeRightOnAndroid(objName);
                break;

            case UP:
                scrollUpOnAndroid(objName);
                break;

            case DOWN:
                scrollDownOnAndroid(objName);

        }

        if (direction.equals("LEFT") || direction.equals("RIGHT"))
            Reporter.log("Swiped " + direction + " on element" + objName, MessageTypes.Info);
        else
            Reporter.log("Scroll " + direction, MessageTypes.Info);

    }

    /**
     * Performs long press on the android
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void longPressOnAndroid(String objName) {
        try {

            int start = this.getLocation().x+this.getSize().width/2;
            int end = this.getLocation().y+this.getSize().height/2;


            getAppiumDriver().executeScript("mobile: longClickGesture", ImmutableMap.of(
                    "x", start, "y", end, "duration", 5000));

            Reporter.log("Long Press on " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to long press due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs long press on the android element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void longPress(String... objName) {
        String curObjName = Arrays.toString(objName);
        try {

            getAppiumDriver().executeScript("mobile: longClickGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) this).getId()));
            Reporter.log("Long Press on " + curObjName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to long press due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs zoom in on the android element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void zoomIn(String... objName) {
        String curObjName = Arrays.toString(objName);
        try {

            getAppiumDriver().executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) this).getId(),
                    "percent", 1
            ));
            Reporter.log("Zoom in on " + curObjName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to zoom due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs zoom out on the android element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void zoomOut(String... objName) {
        String curObjName = Arrays.toString(objName);
        try {

            getAppiumDriver().executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) this).getId(),
                    "percent", 1
            ));
            Reporter.log("Zoom out on " + curObjName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to zoom due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }
}
