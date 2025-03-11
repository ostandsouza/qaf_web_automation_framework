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

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;

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
            File scrFile = new BasePage().getTestBase().getDriver().getScreenshotAs(OutputType.FILE);
            BufferedImage originalImage = ImageIO.read(scrFile);
            int newWidth = originalImage.getWidth() / 4;
            int newHeight = originalImage.getHeight() / 4;
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
            g.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(resizedImage, "jpg", baos);
            byte[] imageBytes = baos.toByteArray();
            String val= "data:image/jpg;base64," + Base64.getEncoder().encodeToString(imageBytes);
//            String scrFile = new BasePage().getTestBase().getDriver().getScreenshotAs(OutputType.BASE64);
//            String val= "data:image/jpg;base64," + scrFile ;
            org.testng.Reporter.log("<a title ='click to download image' href='" + val + "' onclick='(function(){window.open().document.body.innerHTML = \" <img src=" + val +" height=100% width=100%/>  \"})();return false;'>" +
                    " <img src='" + val + "' height='100' width='100'/> </a>");
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
