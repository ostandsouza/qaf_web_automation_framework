package com.common.utils;

import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.BasePage;
import com.web.pages.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Reporter.log("Method " +Thread.currentThread().getStackTrace()[1].getMethodName() );
        Reporter.log("Test Method Failed " + iTestResult.getMethod().getConstructorOrMethod().getName());
        //Allure ScreenShotRobot and SaveTestLog
        try
        {
            String scrFile = new BasePage().getTestBase().getDriver().getScreenshotAs(OutputType.BASE64);
            String val= "data:image/jpg;base64," + scrFile ;
            org.testng.Reporter.log("<a title ='click to download image' href='" + val + "' download>" +
                    " <img src='" + val + "' height='100' width='100' /> </a>");
            Reporter.log("Screenshot captured for test case: " + iTestResult.getMethod().getConstructorOrMethod().getName());
        } catch (Exception e) {
            Reporter.log("Failed to capture screenshot "+e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
