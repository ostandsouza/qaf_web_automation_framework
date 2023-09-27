package com.mobile.nativectx.app.pages;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Reporter;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

public class NativeBasePage extends WebDriverBaseTestPage<WebDriverTestPage> {

    public  long waitTime=90;

    public  String windowsPath="C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Local\\Android\\android-sdk\\platform-tools\\";
    public  String linuxPath="/home/"+"System.getProperty(\"user.name\")"+"/Android/android-sdk/platform-tools/";

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub

    }

    public AppiumDriver getAppiumDriver() {
        return (AppiumDriver) getTestBase().getDriver().getUnderLayingDriver();
    }
//    public AppiumDriver getFlutterDriver() {
//        
//    }
    public AndroidDriver getAndroidDriver() {
        return (AndroidDriver) getAppiumDriver();
    }
    public IOSDriver getIosDriver() {
        return (IOSDriver) getAppiumDriver();
    }

    public void hideKeyBoard() {
        this.getAndroidDriver().hideKeyboard();
    }

    @SuppressWarnings("rawtypes")
    public void refreshScreen() {
        Dimension currentWindow = driver.manage().window().getSize();
        int deviceWidth = currentWindow.getWidth();
        int deviceHeight = currentWindow.getHeight();
        int midX = (deviceWidth / 2);
        int midY = (deviceHeight / 2);
        int bottomEdge = (int) (deviceHeight * 0.85f);
        new TouchAction(this.getAndroidDriver()).press(PointOption.point(midX, midY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(midX, bottomEdge))
                .release().perform();
        Reporter.log("Refreshed screen", MessageTypes.Info);
    }


    /**
     *This method is used to wait until element is hidden from view
     *@param element: WebElement locator
     *@return Null
     *@author Ostan dsouza
     */
    public  void waitForElementToBeInvisible(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(waitTime));
        wait.until(invisibilityOfWebElementLocated(element));
    }

    /**
     *This method is used to wait until element is present in the view
     *@param element: WebElement locator
     *@return Null
     *@author Ostan dsouza
     */
    public  void waitUntilElementIsVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     *This method is used to wait until element has text in the view
     *@param element: WebElement locator
     *@param text: Text to be found
     *@return Null
     *@author Ostan dsouza
     */
    public  void waitUntilElementHasText(WebElement element, String text)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    /**
     *This private method is used to check invisibility of the webElement
     *@param element: WebElement locator
     *@return True if the Element is found.
     *@author Ostan dsouza
     */
    private ExpectedCondition<Boolean> invisibilityOfWebElementLocated(final WebElement element)
    {
        return new ExpectedCondition<Boolean>() {
            //@Override
            public Boolean apply(WebDriver driver) {
                try
                {
                    if (element.isDisplayed())
                        return false;
                    return true;
                }
                catch (Exception e)
                {
                    return true;
                }
            }
        };
    }

    public  void waitUntilElementsAttributeHasChanged(WebElement element, String attribute, String initialValue){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(attributeValueOfElementChanged(element,attribute,initialValue));
    }

    /**
     *This private method is used to check change in attribute of the webElement
     *@param element: WebElement locator
     *@param attribute: Final attribute
     *@param initialValue: Initial attribute
     *@return True if the Element is found.
     *@author Ostan dsouza
     */
    private  ExpectedCondition<Boolean> attributeValueOfElementChanged(final WebElement element, final String attribute, final String initialValue){
        return new ExpectedCondition<Boolean>() {
            //@Override
            public Boolean apply(WebDriver driver) {
                try
                {
                    if (element.getAttribute(attribute).equalsIgnoreCase(initialValue))
                        return false;
                    return true;
                }
                catch (Exception e)
                {
                    return true;
                }
            }
        };

    }

    /**
     *This method is used to check the platform of the test.
     *@return True if the platform is android
     * False if platform is iOS.
     *@author Ostan dsouza
     */
    public  boolean isAndroid(){
        HashMap<String, String> getProperties = (HashMap<String, String>)ConfigurationManager.getBundle().getObject(("config.properties"));
        String runOn = System.getenv("platform") == null ? getProperties.get("RUN_ON"): System.getenv("platform");
        if(runOn.contains("ANDROID_APP"))
            return true;
        return false;
    }

    /**
     *This method is used to naviagte back
     *@author Ostan dsouza
     */
    public  void navigateBack(){
        driver.navigate().back();
    }

    /**
     *This method is hide soft keyboard
     *@author Ostan dsouza
     */
    public  void hideKeyboard(){
        logger.debug("hide keyboard executed....");

        try{
            if (!isAndroid()){
                driver.findElement(MobileBy.AccessibilityId("Done")).click();
            }
            else{
                (getAppiumDriver() instanceof AndroidDriver? (AndroidDriver)getAppiumDriver() :(IOSDriver)getAppiumDriver()).hideKeyboard();
            }
        }
        catch (Exception e){
            logger.error("Keyboard Already Closed");
        }
    }

    /**
     *This method is hide soft keyboard iOS only
     *@author Ostan dsouza
     */
    public void hideKeyboardiOS(){
        try{
            driver.findElement(AppiumBy.accessibilityId( "Done")).click();
        }
        catch (Exception e){
            logger.error("Keyboard Already Closed");
        }
    }


    /**
     *This method is used to tap based on co-ordinates
     * @param x: x co-ordinates
     * @param y: y co-ordinates
     *@return null
     *@author Ostan dsouza
     */
    //Tap by coordinates
    public  void tapByCoordinates (int x,  int y) {
        new TouchAction(getAppiumDriver() instanceof AndroidDriver? (AndroidDriver)getAppiumDriver()  :(IOSDriver)getAppiumDriver())
                .tap(PointOption.point(x,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).perform();
    }


    /**
     *This method is used to slide the sikebar
     *@param fromElement: initial WebElement locator
     *@param toElement: target WebElement locator
     *@return null
     *@author Ostan dsouza
     */
    protected  void swipeFromElementToElement(WebElement fromElement, WebElement toElement)
    {
        logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " is executed");
        Point firstCoordinate,lastCoordinate;
        try
        {
            firstCoordinate = toElement.getLocation();
            lastCoordinate = fromElement.getLocation();

            new TouchAction(getAppiumDriver() instanceof AndroidDriver? (AndroidDriver)getAppiumDriver()  :(IOSDriver)getAppiumDriver()).press(PointOption.point(lastCoordinate.getX(),
                            lastCoordinate.getY())).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
                    .moveTo(PointOption.point(firstCoordinate.getX()
                            , firstCoordinate.getY())).release().perform();


        }catch(Exception e)
        {
            e.printStackTrace();
            logger.error("Swipe from element to element failed with exception ",e);
        }
    }
    public  void navigateRefresh(){
        driver.navigate().refresh();
    }

    public  void waitForSeconds(long timeout){
        try{
            Thread.sleep(timeout*1000);
        }
        catch (InterruptedException e){

        }
    }

    public  void executeCommand(String[] args) {
        ProcessBuilder pb = new ProcessBuilder(args);
        Process pc;
        try {
            pc = pb.start();
            pc.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *This method is used to turn wifi off onloy on android
     *@return null
     *@author Ostan dsouza
     */
    public  void turnOffWifi() {
        String path=checkOS();
        try {
            Runtime.getRuntime().exec(path + "adb.exe shell am broadcast -a io.appium.settings.wifi --es setstatus disable");
            SyncUtil.waitFor(3000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *This method is used to turn wifi on onloy on android
     *@return null
     *@author Ostan dsouza
     */
    public  void turnOnWifi() {
        String path=checkOS();
        try {
            Runtime.getRuntime().exec(path + "adb.exe shell am broadcast -a io.appium.settings.wifi --es setstatus enable");
            SyncUtil.waitFor(3000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    /**
//     *This method is used to perform sleep for a particular amount of time
//     *@param timeout: duration
//     *@return null
//     *@author Ostan dsouza
//     */
//    public void sleep(int timeout){
//        try {
//            Thread.sleep(timeout);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     *This method helps app run in background
     *@param time: duration
     *@return null
     *@author Ostan dsouza
     */
    public  void minimizeApplicationAndRestore(int time){
        SyncUtil.waitFor(3000);
        (getAppiumDriver() instanceof AndroidDriver? (AndroidDriver)getAppiumDriver()  :(IOSDriver)getAppiumDriver()).runAppInBackground(Duration.ofSeconds(time));
        SyncUtil.waitFor(3000);
    }

    /**
     *This method is return android SDK path based on platform OS
     *@return android sdk path for relevant platform
     *@author Ostan dsouza
     */
    public  String checkOS(){
        if (SystemUtils.IS_OS_WINDOWS) {
            return windowsPath;
        } else if (SystemUtils.IS_OS_MAC) {
            return null;
        } else if (SystemUtils.IS_OS_LINUX) {
            return linuxPath;
        } else{
            return null;
        }
    }

    /**
     *This method is used to get android version of the current device
     *@return android version of the device connected
     *@author Ostan dsouza
     */
    public  String getAndroidVersion(){
        String path=checkOS();
        try{
            java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(path+"adb shell getprop ro.build.version.release").getInputStream()).useDelimiter("\\A");
            return s.hasNext() ? s.next() : "";
        }catch (IOException e){
            return "";
        }
    }

    /**
     *This method is used to switch context between different views
     *@param ctx: Target context
     *@return Instance of the switched context
     *@author Ostan dsouza
     */
    public WebDriver switchContext(String ctx) {
        if (getAppiumDriver() instanceof AndroidDriver)
            return ((AndroidDriver) getAppiumDriver()).context(ctx);
        else
            return ((IOSDriver) getAppiumDriver()).context(ctx);
    }

    /** This method is used to get the context handles which can be used to iterate over context of the Driver
     * @return Set of Context handles that can iterate over available contexts
     * @author Ostan Dsouza
     */
    public Set<String> getAllContext() {
        if (getAppiumDriver() instanceof AndroidDriver)
            return ((AndroidDriver) getAppiumDriver()).getContextHandles();
        else
            return ((IOSDriver) getAppiumDriver()).getContextHandles();
    }
}
