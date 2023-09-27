package com.mobile.nativectx.app.component;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.mobile.utils.DIRECTION;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.util.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

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
            //Type of Pointer Input
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
            //Creating Sequence object to add actions
            Sequence swipe = new Sequence(finger,1);
            //Move finger into starting position
            swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),this.getLocation().x+this.getSize().width/2,this.getLocation().y+this.getSize().height/2));
            //Finger comes down into contact with screen
            swipe.addAction(finger.createPointerDown(0));

            getAppiumDriver().perform(Arrays.asList(swipe));

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
            int startx = this.getRect().x+this.getRect().width/2;
            int endx = this.getRect().y+this.getRect().height/2;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");

            Sequence doubleT = new Sequence(finger,1)
                    .addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),startx,endx))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(finger.createPointerUp(0))
                    .addAction(new Pause(finger,Duration.ofMillis(200)))
                    .addAction(finger.createPointerMove(Duration.ofMillis(100),PointerInput.Origin.viewport(),startx,endx))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(finger.createPointerUp(0));

            getAppiumDriver().perform(Collections.singletonList(doubleT));

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
        Dimension frame =getAppiumDriver().manage().window().getSize();
        int startx = 0, endx = 0, starty = 0, endy = 0;

        switch (direction) {
            case LEFT:
                starty = this.getRect().y + (this.getSize().height/2);

                endy = this.getRect().y + (this.getSize().height/2);

                startx = (int) (this.getRect().x + (this.getSize().width * 0.9));

                endx = (int) (this.getRect().x + (this.getSize().width * 0.1));
                break;

            case RIGHT:
                starty = this.getRect().y + (this.getSize().height/2);

                endy = this.getRect().y + (this.getSize().height/2);

                endx = (int) (this.getRect().x + (this.getSize().width * 0.9));

                startx = (int) (this.getRect().x + (this.getSize().width * 0.1));
                break;

            case UP:
                startx = frame.width/2;

                endx = frame.width/2;

                starty = (int) (frame.height*(0.90));

                endy = (int) (frame.height*(0.50));
                break;

            case DOWN:
                startx = frame.width/2;

                endx = frame.width/2;

                endx = (int) (frame.height*(0.90));

                starty = (int) (frame.height*(0.50));

        }

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence act = new Sequence(finger,1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),startx,starty))
                .addAction(finger.createPointerDown(0))
                .addAction(new Pause(finger,Duration.ofMillis(500)))
                .addAction(finger.createPointerMove(Duration.ofMillis(500),PointerInput.Origin.viewport(),endx,endy))
                .addAction(finger.createPointerUp(0));

        getAppiumDriver().perform(Collections.singletonList(act));
        SyncUtil.waitFor(1000);
        if (direction.equals("LEFT") || direction.equals("RIGHT"))
            Reporter.log("Swiped " + direction + " on element" + objName, MessageTypes.Info);
        else
            Reporter.log("Scroll " + direction, MessageTypes.Info);

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

    /**
     *This method is used to slide the seekbar
     *@param position: position in percentage
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    public void slideSeekbar(int position, String... objName){
        System.out.println("Sliding");
        // get start co-ordinate of seekbar
        int start=this.getLocation().getX();
        //Get width of seekbar
        int end=this.getSize().getWidth();
        //get location of seekbar vertically
        int y=this.getLocation().getY();

        // Select till which position you want to move the seekbar
        TouchAction action=new TouchAction(getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)getAppiumDriver()  :(IOSDriver)getAppiumDriver());


        //Move it x%
        int moveTo=(int)(end*(position/100));
        action.press(PointOption.point(start,y)).moveTo(PointOption.point(moveTo,y)).release().perform();
        Reporter.log("Pointer moved to "+objName+" position on seekbar "+objName, MessageTypes.Info);
    }

    /**
     *This method is used to move to percentage without sliding
     *@param position: position in percentage
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    public void clickSeekbar(int position, String... objName){
        // get start co-ordinate of seekbar
        int start=this.getLocation().getX();
        //Get width of seekbar
        int end=this.getSize().getWidth();
        //get location of seekbar vertically
        int y=this.getLocation().getY();

        // Select till which position you want to move the seekbar
        TouchAction action=new TouchAction(getAppiumDriver() instanceof AndroidDriver? (AndroidDriver)getAppiumDriver()  :(IOSDriver)getAppiumDriver());


        //Move it x%
        int moveTo=(int)(end*(position/100));
        action.press(PointOption.point(moveTo,y)).release().perform();
        Reporter.log("Pointer moved to "+objName+" position on seekbar "+objName, MessageTypes.Info);
    }

    /**
     *This method is used to long press on element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    public void longPress(String... objName){
        int start = this.getLocation().x+this.getSize().width/2;
        int end = this.getLocation().y+this.getSize().height/2;

        PointerInput pointer = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longp = new Sequence(pointer,1)
                .addAction(pointer.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start,end))
                .addAction(pointer.createPointerDown(0))
                .addAction(new Pause(pointer,Duration.ofSeconds(5)))
                .addAction(pointer.createPointerUp(0));

        getAppiumDriver().perform(Collections.singletonList(longp));
        Reporter.log("Long pressed on element" + objName, MessageTypes.Info);
    }

    /**
     *This method is used to zoom in on element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    public void zoomIn(String... objName){
        int centerX =this.getLocation().x+this.getRect().width/2;
        int centerY =this.getLocation().y+this.getRect().height/2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence fig1 = new Sequence(finger,1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),centerX, (int) (centerY*0.85)))
                .addAction(finger.createPointerDown(0))
                .addAction(new Pause(finger,Duration.ofMillis(500)))
                .addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),centerX, (int) (centerY*0.95)))
                .addAction(finger.createPointerUp(0));

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger2");
        Sequence fig2 = new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),centerX, (int) (centerY*1.20)))
                .addAction(finger1.createPointerDown(0))
                .addAction(new Pause(finger1,Duration.ofMillis(500)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),centerX, (int) (centerY*1.10)))
                .addAction(finger1.createPointerUp(0));


        //Perform the actions
        getAppiumDriver().perform(Arrays.asList(fig1,fig2));
        Reporter.log("Zoom in on element" + objName, MessageTypes.Info);
    }

    /**
     *This method is used to zoom out on element
     *@param objName: Name of object for reporting purpose
     *@return null
     *@author Ostan dsouza
     */
    public void zoomOut(String... objName){
        int centerX =this.getLocation().x+this.getRect().width/2;
        int centerY =this.getLocation().y+this.getRect().height/2;

        PointerInput finger4 = new PointerInput(PointerInput.Kind.TOUCH,"finger4");
        Sequence fig1 = new Sequence(finger4,1)
                .addAction(finger4.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),centerX, (int) (centerY*0.95)))
                .addAction(finger4.createPointerDown(0))
                .addAction(new Pause(finger4,Duration.ofMillis(500)))
                .addAction(finger4.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),centerX, (int) (centerY*0.85)))
                .addAction(finger4.createPointerUp(0));

        PointerInput finger5 = new PointerInput(PointerInput.Kind.TOUCH,"finger5");
        Sequence fig2 = new Sequence(finger5,1)
                .addAction(finger5.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),centerX, (int) (centerY*1.10)))
                .addAction(finger5.createPointerDown(0))
                .addAction(new Pause(finger5,Duration.ofMillis(500)))
                .addAction(finger5.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),centerX, (int) (centerY*1.20)))
                .addAction(finger5.createPointerUp(0));


        //Perform the actions
        getAppiumDriver().perform(Arrays.asList(fig1,fig2));
        Reporter.log("Zoom out on element" + objName, MessageTypes.Info);
    }
}
