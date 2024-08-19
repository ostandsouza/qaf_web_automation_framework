package com.mobile.flutter.app.pages;

import com.common.utils.APIBase;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.support.flutter.ByFlutter;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;
import java.util.Set;

public class FlutterBasePage extends WebDriverBaseTestPage<WebDriverTestPage> {

    public APIBase apiBase = new APIBase();

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub

    }

    public AppiumDriver getAppiumDriver() {
        return (AppiumDriver) getTestBase().getDriver().getUnderLayingDriver();
    }

    public AndroidDriver getAndroidDriver() {
        return (AndroidDriver) getAppiumDriver();
        
    }

    /**
     * This method is used to get the context handles which can be used to iterate over context of the Driver
     * @return Set of Context handles that can iterate over available contexts
     * @author Ostan Dsouza
     */
    public Set<String> getAllContext() {
        if (getAppiumDriver() instanceof AndroidDriver)
            return ((AndroidDriver) getAppiumDriver()).getContextHandles();
        else
            return ((IOSDriver) getAppiumDriver()).getContextHandles();
    }


    /**
     * This method is used to navigate to the previous screen
     * @return Null
     * @author Ostan Dsouza
     */
    public void goBackToPreviousPage(){
        driver.findElement(new ByFlutter.PageBack()).click();
    }


    /**
     * This method is used to wait until the screen frame is loaded for the Flutter pages
     * @return Null
     * @author Ostan Dsouza
     */
    public void waitUntilAppLoads(){
        driver.executeScript("flutter:waitForFirstFrame");
    }

    /**
     * This method is used to get render tree of the current page
     * @return Null
     * @author Ostan Dsouza
     */
    public String getRenderTree(){
        return (String)driver.executeScript("flutter:getRenderTree");
    }

    /**
     * This method is used to wait until a particular element is loaded for the Native Pages
     * @param driver1: Appium driver object
     * @param ele: Flutter Element locator
     * @return Null
     * @author Ostan Dsouza
     */
    public void waitUntilAppLoads(AppiumDriver driver1, WebElement ele){
        WebDriverWait wwait = new WebDriverWait(driver1,Duration.ofSeconds(20));
        wwait.until(ExpectedConditions.visibilityOf(ele));
    }

    /**
     * This method is used to perform sleep for a particular amount of time
     * @param secs: Time in sec to wait
     * @return Null
     * @author Prasanjit Kar
     */
    public  void waitForSeconds(int secs){
        try {
            int timeout = secs * 1000;
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
