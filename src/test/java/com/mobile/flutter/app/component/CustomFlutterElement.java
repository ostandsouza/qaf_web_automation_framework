package com.mobile.flutter.app.component;

import com.mobile.utils.DIRECTION;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.support.flutter.ByFlutter;
import com.qmetry.qaf.automation.support.flutter.FlutterElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.util.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static java.lang.Integer.parseInt;

public class CustomFlutterElement extends FlutterElement {

    public CustomFlutterElement(FlutterElement parent, String locator) {
        super(parent, locator);
    }

    public CustomFlutterElement(String locator) {
        super(locator);
    }

    public CustomFlutterElement(ByFlutter by) {
        super(by);
    }

    public CustomFlutterElement(QAFExtendedWebDriver driver) {
        super(driver);
    }

    /**
     * @return AppiumDriver - Underlying appium driver
     */
    @SuppressWarnings("rawtypes")
    public AppiumDriver getAppiumDriver() {
        return (AppiumDriver) this.getWrappedDriver().getUnderLayingDriver();
    }

    /**
     *This method is used to perform click action on Flutter element if only present
     *@return Null
     *@author Ostan dsouza
     */
    @Override
    public void click() {
//        if(waitSecsForElement(getBundle().getInt("flutter.wait.timeout")))
            singleTap();
//        else throw new RuntimeException(this+" element for click not found");
    }
    /**
     *This method is used to perform click action on Flutter element if only present
     *@return Null
     */
    public void press() {
//        if(waitSecsForElement(getBundle().getInt("flutter.wait.timeout")))
        longPress();
//        else throw new RuntimeException(this+" element for click not found");
    }

    /**
     *This method is used to perform click action on Flutter element if only present
     *@param objName : Name of object for reporting purpose. It's optional
     *@return Null
     *@author Ostan dsouza
     */
    public void click(String... objName) {
        try{
            if(waitSecsForElement(getBundle().getInt("flutter.wait.timeout"))) {
                this.click();
                Reporter.log("Clicked on " + objName, MessageTypes.Info);
            }
            else throw new RuntimeException(this+" element for click not found");
        } catch (Exception e) {
            Reporter.log("Failed to click on " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     *This method is used to get text from Flutter element if only present
     * @param objName : Name of object for reporting purpose
     *@return Null
     *@author Ostan dsouza
     */
    public String getText(String objName) {
        try {
            if (waitSecsForElement(getBundle().getInt("flutter.wait.timeout"))) {
                return this.getText();
            } else throw new RuntimeException(this + " element for sendkeys not found ");
        } catch (Exception e) {
            Reporter.log("Failed to get text from "+ objName + "due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     *This method is used to perform send keys action on Flutter element if only present
     *@param keysToSend : Text to be sent
     *@return Null
     *@author Ostan dsouza
     */
    @Override
    public void sendKeys(CharSequence... keysToSend) {
        if(waitSecsForElement(getBundle().getInt("flutter.wait.timeout"))) {
            singleTap();
            getAppiumDriver().executeScript("flutter: enterText", keysToSend);
        }
        else throw new RuntimeException(this+" element for sendkeys not found ");
    }

    /**
     *This method is used to perform send keys action on Flutter element if only present
     * @param value   : To be typed in object
     * @param objName : Name of object for reporting purpose
     *@return Null
     *@author Ostan dsouza
     */
    public void sendKeys(String value, String objName) {
        try {
            this.sendKeys(value);
            Reporter.log(value + " is typed in " + "'" + objName + "'", MessageTypes.Info);
        } catch (Exception e) {
            Reporter.log("Failed to type " + value + " in " + "'" + objName + "'" + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }

    }

    /**
     *This method is used to perform tap action on Flutter element
     * @param objName: Name of object for reporting purpose
     *@return Null
     *@author Ostan dsouza
     */
    public void singleTap(String... objName) {
        try {
            int val = getAppiumDriver() instanceof AndroidDriver ? 1: 1;
            getAppiumDriver().executeScript("flutter: longTap", this.getId(), new HashMap<String, Object>() {{
                put("durationMilliseconds", val);
                put("frequency", 1000);
            }});
            Reporter.log("Taped on " + objName, MessageTypes.Info);
        } catch (Exception e) {
            Reporter.log("Failed to tap due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * This method is used to perform multiple tap on the flutter element
     * @param objName: Name of object for reporting purpose
     * @return Null
     * @author Ostan dsouza
     */
    public void doubleTap(String... objName) {
        try {
            if(waitSecsForElement(getBundle().getInt("flutter.wait.timeout"))) {
                int val = getAppiumDriver() instanceof AndroidDriver ? 1 : 10;
                int count = 2;
                while (count > 0) {
                    getAppiumDriver().executeAsyncScript("flutter: longTap", this.getId(), new HashMap<String, Object>() {{
                        put("durationMilliseconds", val);
                        put("frequency", 1000);
                    }});
                    count--;
                }
                Reporter.log("Double taped on " + objName, MessageTypes.Info);
            }
            else throw new RuntimeException(this+" element for doubleTap not found");

        } catch (Exception e) {
            Reporter.log("Failed to double tap on " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }

    }

    /**
     * This method is used to perform action for the slider buttons
     * @param percentage: What percentage is required
     * @param objName: Name of object for reporting purpose
     * @author: Ostan Dsouza
     */
    public void slideSeekbar(int percentage, String... objName) {
        try {
            if(waitSecsForElement(getBundle().getInt("flutter.wait.timeout"))) {
                int val = getAppiumDriver() instanceof AndroidDriver ? 10 : 100;
                Map center = (Map) getAppiumDriver().executeScript("flutter:getBottomRight", this.getId());

                getAppiumDriver().executeScript("flutter: scroll", this.getId(), new HashMap<String, Object>() {{
                    put("dx", -((center.get("dx") instanceof Long ? (long) center.get("dx") : (double) center.get("dx")) * percentage / 100));
                    put("dy", 0);
                    put("durationMilliseconds", val);
                    put("frequency", 1000);
                }});
                Reporter.log("Slide gesture on " + objName, MessageTypes.Info);
            }
            else throw new RuntimeException(this+" element for Slide seekbar not found");

        } catch (Exception e) {
            Reporter.log("Failed to perform slide gesture on " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * This method is used to perform tap and hold action
     * @param objName: Name of object for reporting purpose
     * @return Null
     * @author Ostan dsouza
     */
    public void longPress(String... objName) {
        try {
            if(waitSecsForElement(getBundle().getInt("flutter.wait.timeout"))) {
                int val = getAppiumDriver() instanceof AndroidDriver ? 5000 : 5000;
                getAppiumDriver().executeScript("flutter: longTap", this.getId(), new HashMap<String, Object>() {{
                    put("durationMilliseconds", val);
                    put("frequency", 500);
                }});
                Reporter.log("Press gesture on " + objName, MessageTypes.Info);
            }
            else throw new RuntimeException(this+" element for long press not found");

        } catch (Exception e) {
            Reporter.log("Failed to perform press gesture on " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * This method is used to scroll to a specific Flutter Element
     * @param element: Target Flutter Element
     * @param dir: The DIRECTION need to be scrolled(Up,Down, Left, Right)
     * @param objName: Name of object for reporting purpose
     * @return Null
     * @author Ostan Dsouza
     */
    public void scrollToElement(CustomFlutterElement element, DIRECTION dir, String... objName) {
        try {
            if(element.waitSecsForElement(getBundle().getInt("flutter.wait.timeout"))) {
                boolean flag = this.isVisible();
                Map center = (Map) getAppiumDriver().executeScript("flutter:getCenter", element.getId());

                long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(5);
                while (!flag ? stop>System.nanoTime() : !flag) {

                    element.scroll(dir, center);

                    flag = this.isVisible();

                    if (flag && Double.compare(getElementPosition().get("dy") instanceof Long ? (long) ((Long) getElementPosition().get("dy")).doubleValue() : (double) getElementPosition().get("dy"), 650d) > 0)
                        element.scroll(dir, center);
                }
                Reporter.log("Scroll gesture on " + objName, MessageTypes.Info);
            }
            else throw new RuntimeException(this+" element for get center not found");

        } catch (Exception e) {
            Reporter.log("Failed to perform scroll gesture on " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * This method is used to slide to a specific Flutter Element
     * @param dir: The DIRECTION need to be scrolled(Up,Down, Left, Right)
     * @param objName: Name of object for reporting purpose
     * @return Null
     * @author Ostan Dsouza
     */
    public void slideToElement(DIRECTION dir, String... objName) {
        try {
            if(waitSecsForElement(getBundle().getInt("flutter.wait.timeout"))) {
                Map center = (Map) getAppiumDriver().executeScript("flutter:getCenter", this.getId());

                scroll(dir, center);
                Reporter.log("Slide gesture on " + objName, MessageTypes.Info);
            }
            else throw new RuntimeException(this+" element for slide not found");

        } catch (Exception e) {
            Reporter.log("Failed to perform slide gesture on " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }


    /**
     * This method is used to do Scroll
     * @param point: Center Cortinates of the flutter element
     * @param dir: The DIRECTION need to be scrolled(Up,Down, Left, Right)
     * @return Null
     * @author Ostan Dsouza
     */
    private void scroll(DIRECTION dir, Map point) {
        int val = getAppiumDriver() instanceof AndroidDriver? 10: 100;
        switch (dir) {
            case DOWN:
                getAppiumDriver().executeScript("flutter: scroll", this.getId(), new HashMap<String, Object>() {{
                    put("dx", 0);
                    put("dy", -(point.get("dy") instanceof Long ? (long) point.get("dy") : (double) point.get("dy")));
                    put("durationMilliseconds", val);
                    put("frequency", 1000);
                }});
                break;

            case UP:
                getAppiumDriver().executeScript("flutter: scroll", this.getId(), new HashMap<String, Object>() {{
                    put("dx", 0);
                    put("dy", point.get("dy") instanceof Long ? (long) point.get("dy") : (double) point.get("dy"));
//                put("dy", 50);
                    put("durationMilliseconds", val);
                    put("frequency", 1000);
                }});
                break;
            case LEFT:
                getAppiumDriver().executeScript("flutter: scroll", this.getId(), new HashMap<String, Object>() {{
                    put("dx", -(point.get("dx") instanceof Long ? (long) point.get("dx") : (double) point.get("dx")));
//                    put("dx", -100);
                    put("dy", 0);
                    put("durationMilliseconds", val);
                    put("frequency", 1000);
                }});
                break;
            case RIGHT:
                getAppiumDriver().executeScript("flutter: scroll", this.getId(), new HashMap<String, Object>() {{
                    put("dx", (point.get("dx") instanceof Long ? (long) point.get("dx") : (double) point.get("dx")));
//                    put("dx", -100);
                    put("dy", 0);
                    put("durationMilliseconds", val);
                    put("frequency", 1000);
                }});
                break;
        }
    }

    /**
     * This method is used to Scroll till the element can be viewed in the screen
     * @param objName: Name of object for reporting purpose
     * @return Null
     * @author Ostan Dsouza
     */
    public void scrollIntoView(String... objName) {
        try {
            if(waitSecsForElement(getBundle().getInt("flutter.wait.timeout"))) {
                getAppiumDriver().executeScript("flutter: scrollIntoView", this.getId(), new HashMap<String, Object>() {{
                    put("alignment", 0.1);
                }});
                Reporter.log("Scroll gesture on " + objName, MessageTypes.Info);
            }
            else throw new RuntimeException(this+" element for scroll not found");

        } catch (Exception e) {
            Reporter.log("Failed to perform scroll gesture on " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * This method is used to perform Tap and Drag action
     * @param elementTo: Flutter Element locator
     * @param objName: Name of object for reporting purpose
     * @return Null
     * @author Ostan Dsouza
     */
    public void dragGesture(CustomFlutterElement elementTo, String... objName) {
        try {
            if(waitSecsForElement(getBundle().getInt("flutter.wait.timeout")) && elementTo.waitSecsForElement(getBundle().getInt("flutter.wait.timeout"))) {
                int val = getAppiumDriver() instanceof AndroidDriver ? 10 : 100;
                Map point = (Map) getAppiumDriver().executeScript("flutter:getCenter", this.getId());
                Map point1 = (Map) getAppiumDriver().executeScript("flutter:getCenter", elementTo.getId());
                if (Double.compare((double) point.get("dy"), (double) point1.get("dy")) < 0) {
                    getAppiumDriver().executeScript("flutter: scroll", this.getId(), new HashMap<String, Object>() {{
                        put("dx", point1.get("dx") instanceof Long ? (long) point1.get("dx") : (double) point1.get("dx"));
                        put("dy", point1.get("dy") instanceof Long ? ((long) point1.get("dy") - (point.get("dy") instanceof Long ? (long) point.get("dy") : (double) point.get("dy"))) : (double) point1.get("dy") - (point.get("dy") instanceof Long ? (long) point.get("dy") : (double) point.get("dy")));
                        put("durationMilliseconds", val);
                        put("frequency", 1000);
                    }});
                } else {
                    getAppiumDriver().executeScript("flutter: scroll", this.getId(), new HashMap<String, Object>() {{
                        put("dx", point1.get("dx") instanceof Long ? (long) point1.get("dx") : (double) point1.get("dx"));
                        put("dy", point1.get("dy") instanceof Long ? -((long) point1.get("dy") - (point.get("dy") instanceof Long ? (long) point.get("dy") : (double) point.get("dy"))) : -((point.get("dy") instanceof Long ? (long) point.get("dy") : (double) point.get("dy")) - (double) point1.get("dy")));
                        put("durationMilliseconds", val);
                        put("frequency", 1000);
                    }});
                }
                Reporter.log("Drag gesture on " + objName, MessageTypes.Info);
            }
            else throw new RuntimeException(this+" element for drag n drop not found");

        } catch (Exception e) {
            Reporter.log("Failed to perform drag gesture on " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * This method is used to check element is visible or nor
     * @return True if found
     * @author Ostan dsouza
     */
    public boolean isVisible() {
        try {
            int val = getAppiumDriver() instanceof AndroidDriver? 3000: 3000;
            getAppiumDriver().executeScript("flutter:waitFor", this.getId(), val);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }


    /**
     * This method is used to check element is visible or nor
     * @param objName: Name of object for reporting purpose
     * @return True if found
     * @author Ostan dsouza
     */
    public boolean isVisible(String... objName) {
        try {
            int val = getAppiumDriver() instanceof AndroidDriver? 3000: 3000;
            getAppiumDriver().executeScript("flutter:waitFor", this.getId(), val);
            Reporter.log("'" + objName[0] + "'" + " is visible", MessageTypes.Info);
            return true;
        } catch (Exception ignored) {
            Reporter.log("'" + objName[0] + "'" + " is not visible", MessageTypes.Fail);
            return false;
        }
    }

    /**
     * This method is used to get the size of the element
     * @param objName: Name of object for reporting purpose
     * @return Height and width of the element
     * @author Ostan dsouza
     */
    public Map<Object, Object> getElementProperties(String... objName){
        try {
            Map<Object, Object> list;
            if(waitSecsForElement(getBundle().getInt("flutter.wait.timeout"))) {
                list = ((Map<Object, Object>) getAppiumDriver().executeScript(
                        "flutter:getRenderObjectDiagnostics",
                        this.getId(),
                        new HashMap<String, Object>() {{
                            put("includeProperties", true);
                            put("subtreeDepth", 1);
                        }}));
            }
            else throw new RuntimeException(this+" element for render props not found");

            return list;

        } catch (Exception e) {
            Reporter.log("Failed to get element size for " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    public ArrayList<Map<Object, Object>> getRenderObject(String... objName) {
        try {
            ArrayList<Map<Object, Object>> obj;
            if (waitSecsForElement(getBundle().getInt("flutter.wait.timeout"))) {
                obj = (ArrayList<Map<Object, Object>>) ((Map<Object, Object>) getAppiumDriver().executeScript(
                        "flutter:getRenderObjectDiagnostics",
                        this.getId(),
                        new HashMap<String, Object>() {{
                            put("includeProperties", true);
                            put("subtreeDepth", 0);
                        }})).get("properties");
            } else throw new RuntimeException(this + " element for render props not found");
            return obj;
        } catch (Exception e) {
            Reporter.log("Failed to get element size for " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }



    /**
     * This method is used to get the size of the element
     * @param objName: Name of object for reporting purpose
     * @return Height and width of the element
     * @author Ostan dsouza
     */
    public HashMap<String, Integer> getElementSize(String... objName){
        try {
            String str;
            if(waitSecsForElement(getBundle().getInt("flutter.wait.timeout"))) {
                str = (String) ((ArrayList<Map<Object, Object>>) ((Map<Object, Object>) getAppiumDriver().executeScript(
                        "flutter:getRenderObjectDiagnostics",
                        this.getId(),
                        new HashMap<String, Object>() {{
                            put("includeProperties", true);
                            put("subtreeDepth", 0);
                        }})).get("properties")).stream().filter(x -> ((String) x.get("name")).equalsIgnoreCase("size")).collect(Collectors.toList()).get(0).get("description");
            }
            else throw new RuntimeException(this+" element for render props not found");

            Pattern p = Pattern.compile("([0-9]+)[.]");
            Matcher m = p.matcher(str.split(",")[0]);
            HashMap<String, Integer> map = new HashMap<>();
            if (m.find())
                map.put("height", parseInt(m.group(1).replace(".", "")));
            m = p.matcher(str.split(",")[1]);
            if (m.find())
                map.put("width", parseInt(m.group(1).replace(".", "")));
            Reporter.log("Element size for " + objName, MessageTypes.Info);
            return map;

        } catch (Exception e) {
            Reporter.log("Failed to get element size for " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * This method is used to get the Position of the element is the screen
     * @param objName: Name of object for reporting purpose
     * @return The Top Left point of the element
     * @author Ostan Dsouza
     */
    public Map<String, Object> getElementPosition(String... objName){
        try {
            Map point;
            if(waitSecsForElement(getBundle().getInt("flutter.wait.timeout"))) {
                point = (Map) getAppiumDriver().executeScript("flutter:getTopLeft", this.getId());
            }
            else throw new RuntimeException(this+" element for coordinates not found");

            Reporter.log("Element position for " + objName, MessageTypes.Info);
            return point;

        } catch (Exception e) {
            Reporter.log("Failed to get element position for " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }


    /**
     * This method is used to call wait for an element to be loaded
     * @param secs: Time in sec to wait
     * @param objName: Name of object for reporting purpose
     * @return: True if the Element is found within the timeout
     * @author: Ostan Dsouza
     */
    public  boolean waitSecsForElement(int secs, String... objName){
        try {
            int timeout = secs * 1000;
            getAppiumDriver().executeScript("flutter:waitFor", this.getId(), timeout);
            Reporter.log("'" + objName + "'" + " is visible", MessageTypes.Info);
            return true;
        } catch (Exception ignored) {
            Reporter.log("'" + objName + "'" + " is not visible", MessageTypes.Info);
            return false;
        }
    }

    /**
     * This method is used to check element is visible or not
     * @param objName: Name of object for reporting purpose
     * @return True if found
     * @author Ostan dsouza
     */
    public boolean waitForTheElementToBeVisible(int timeout, String... objName) {
        try {
            boolean isVisible = false;
            for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(timeout); stop > System.nanoTime(); ) {
                if (!isVisible) {
                    int val = getAppiumDriver() instanceof AndroidDriver ? 3000 : 3000;
                    try {
                        getAppiumDriver().executeScript("flutter:waitFor", this.getId(), val);
                        isVisible = true;
                        break;
                    } catch (Exception ignored) {
                        isVisible = false;
                    }
                }
            }
            Reporter.log("'" + objName + "'" + " is visible", MessageTypes.Pass);
            return isVisible;

        } catch (Exception e) {
            Reporter.log("'" + objName + "'" + " is not visible", MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * This method is used to check element is invisible or not
     * @param objName: Name of object for reporting purpose
     * @return True if found
     * @author Ostan dsouza
     */
    public boolean waitForTheElementToBeInvisible(int timeout, String... objName) {
        try {
            boolean isInvisible = false;
            for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(timeout); stop > System.nanoTime(); ) {
                while (!isInvisible) {
                    int val = getAppiumDriver() instanceof AndroidDriver ? 3000 : 3000;
                    try {
                        getAppiumDriver().executeScript("flutter:waitFor", this.getId(), val);
                        isInvisible = false;
                    } catch (Exception ignored) {
                        isInvisible = true;
                    }
                }
                break;
            }
            Reporter.log("'" + objName + "'" + " is invisible", MessageTypes.Info);
            return isInvisible;

        } catch (Exception e) {
            Reporter.log("'" + objName + "'" + " is not invisible", MessageTypes.Info);
            throw e;
        }
    }
}
