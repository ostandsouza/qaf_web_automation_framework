package com.mobile.nativectx.app.component;

import com.mobile.utils.DIRECTION;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.util.Reporter;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class CustomIOSElement extends CustomMobileElement{

    public CustomIOSElement(String locator) {
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
            int startx = this.getRect().x+this.getRect().width/2;
            int endx = this.getRect().y+this.getRect().height/2;

            Map<String, Object> args1 = new HashMap<>();
            args1.put("x", startx);
            args1.put("y", endx);
            getAppiumDriver().executeScript("mobile: doubleTap", args1);

            Reporter.log("Taped on " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to tap due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs single tap on the android object
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void ScrollOniOS(String objName) {
        try {
            Map<String, Object> args0 = new HashMap<>();
            args0.put("direction", "down");
            getAppiumDriver().executeScript("mobile: scroll", args0);

            Reporter.log("Scroll direction " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to tap due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs scroll down to the iOS element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void scrollDownToiOSElement(String... objName) {
        try {
            Map<String, Object> args1 = new HashMap<>();
            args1.put("direction", "down");
            args1.put("element", ((RemoteWebElement) this).getId());
            getAppiumDriver().executeScript("mobile: scroll", args1);

            Reporter.log("Scroll on " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to scroll due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs scroll up to the iOS element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void scrollUpToiOSElement(String... objName) {
        try {
            Map<String, Object> args2 = new HashMap<>();
            args2.put("direction", "up");
            args2.put("element", ((RemoteWebElement) this).getId());
            getAppiumDriver().executeScript("mobile: swipe", args2);

            Reporter.log("Scroll direction " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to scroll due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs scroll up on the iOS
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void scrollUpOniOS(String... objName) {
        try {
            Map<String, Object> args0 = new HashMap<>();
            args0.put("direction", "up");
            getAppiumDriver().executeScript("mobile: scroll", args0);

            Reporter.log("Scroll direction " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to scroll due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs swipe left on the iOS element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void swipeLeftOniOSElement(String... objName) {
        try {

            Map<String, Object> args2 = new HashMap<>();
            args2.put("direction", "left");
            args2.put("element", ((RemoteWebElement) this).getId());
            getAppiumDriver().executeScript("mobile: swipe", args2);

            Reporter.log("Swipe direction " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to swipe due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs swipe right on the iOS element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void swipeRightOniOSElement(String... objName) {
        try {

            Map<String, Object> args3 = new HashMap<>();
            args3.put("direction", "right");
            args3.put("element", ((RemoteWebElement) this).getId());
            getAppiumDriver().executeScript("mobile: swipe", args3);

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
                swipeLeftOniOSElement(objName);
                break;

            case RIGHT:
                swipeRightOniOSElement(objName);
                break;

            case UP:
                scrollUpToiOSElement(objName);
                break;

            case DOWN:
                scrollDownToiOSElement(objName);

        }

        if (direction.equals("LEFT") || direction.equals("RIGHT"))
            Reporter.log("Swiped " + direction + " on element" + objName, MessageTypes.Info);
        else
            Reporter.log("Scroll " + direction, MessageTypes.Info);

    }

    /**
     * Performs long press on the iOS
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void longPressOniOS(String objName) {
        try {

            int start = this.getLocation().x+this.getSize().width/2;
            int end = this.getLocation().y+this.getSize().height/2;


            Map<String, Object> args1 = new HashMap<>();
            args1.put("x", start);
            args1.put("y", end);
            args1.put("duration", 5);
            getAppiumDriver().executeScript("mobile: touchAndHold", args1);

            Reporter.log("Long Press on " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to long press due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs long press on the iOS element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void longPress(String... objName) {
        try {

            Map<String, Object> args = new HashMap<>();
            args.put("element", ((RemoteWebElement) this).getId());
            args.put("duration", 5);
            getAppiumDriver().executeScript("mobile: touchAndHold", args);

            Reporter.log("Long Press on " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to long press due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs zoom in on the iOS element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void zoomIn(String... objName) {
        try {

            Map<String, Object> args1 = new HashMap<>();
            args1.put("element", ((RemoteWebElement) this).getId());
            args1.put("scale", 6);
            args1.put("velocity", 5);
            getAppiumDriver().executeScript("mobile: pinch", args1);

            Reporter.log("Zoom in on " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to zoom due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs zoom out on the iOS element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    @SuppressWarnings("rawtypes")
    public void zoomOut(String... objName) {
        try {

            Map<String, Object> args2 = new HashMap<>();
            args2.put("element", ((RemoteWebElement) this).getId());
            args2.put("scale", 0.25);
            args2.put("velocity", -0.5);
            getAppiumDriver().executeScript("mobile: pinch", args2);

            Reporter.log("Zoom out on " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to zoom due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }
}

