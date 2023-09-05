package com.mobile.android.app.steps;

import com.common.utils.MiscUtils;
import com.mobile.android.app.pages.MobileBasePage;
import com.mobile.utils.PerfectoLabUtils;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CommonMobileSteps {
    MobileBasePage app = new MobileBasePage();

    String appName = ConfigurationManager.getBundle().getString("aut.appName");
    boolean isUsingPerfecto = ConfigurationManager.getBundle().getString("remote.server").contains("perfecto");

    @QAFTestStep(description = "Application is installed")
    public void InstallMobileApplication() throws URISyntaxException, IOException {
        boolean updateAppFlag = Boolean.parseBoolean(ConfigurationManager.getBundle().getString("aut.updateApp"));
        String artifactLocator = ConfigurationManager.getBundle().getString("appium.capabilities.app");
        if (updateAppFlag && isUsingPerfecto) {
            String cloudName = ConfigurationManager.getBundle().getString("perfecto.cloud");
            String source = MiscUtils.getAbsolutePath(ConfigurationManager.getBundle().getString("aut.path"));
            String token = (String) app.getAppiumDriver().getCapabilities().getCapability("accessToken");
            PerfectoLabUtils.uploadMedia_NewAPI(cloudName, token, source, artifactLocator);

        }

        if (updateAppFlag && (app.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)app.getAppiumDriver() : (IOSDriver)app.getAppiumDriver()).isAppInstalled(appName))
            (app.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)app.getAppiumDriver() : (IOSDriver)app.getAppiumDriver()).removeApp(appName);

        if (!(app.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)app.getAppiumDriver() : (IOSDriver)app.getAppiumDriver()).isAppInstalled(appName)) {
            if (isUsingPerfecto) {
                Map<String, Object> params = new HashMap<>();
                params.put("file", artifactLocator);
                params.put("instrument", "instrument");
                app.getAppiumDriver().executeScript("mobile:application:install", params);
            } else
                (app.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)app.getAppiumDriver() : (IOSDriver)app.getAppiumDriver()).installApp(MiscUtils.getAbsolutePath(ConfigurationManager.getBundle().getString("aut.path")));
        }

        if ((app.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)app.getAppiumDriver() : (IOSDriver)app.getAppiumDriver()).isAppInstalled(appName)) {
            ConfigurationManager.getBundle().setProperty("android.apk.updateApp", false);
            Reporter.log("Application is Installed : " + appName, MessageTypes.Info);
        }
    }

    @QAFTestStep(description = "Application is launched")
    public void launchMobileApplication() {
        try {
            (app.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)app.getAppiumDriver() : (IOSDriver)app.getAppiumDriver()).terminateApp(appName);
            if (ConfigurationManager.getBundle().getBoolean("aut.clearCache"))
                app.clearCache(appName);
            (app.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)app.getAppiumDriver() : (IOSDriver)app.getAppiumDriver()).activateApp(appName);
            app.getAndroidDriver().configuratorSetKeyInjectionDelay(Duration.ofMillis(ConfigurationManager.getBundle().getLong("android.apk.keyInjectionDelay")));
            app.getAndroidDriver().configuratorSetWaitForIdleTimeout(Duration.ofMillis(ConfigurationManager.getBundle().getLong("android.apk.waitForIdleTimeout")));
            app.getAndroidDriver().configuratorSetWaitForSelectorTimeout(Duration.ofMillis(ConfigurationManager.getBundle().getLong("android.apk.waitForSelectorTimeout")));
            app.getAndroidDriver().ignoreUnimportantViews(false);
            Reporter.log("Application Launched : " + appName, MessageTypes.Info);
        } catch (Exception ex) {
            Reporter.log("Failed to launch Application " + appName + " with underlying exception : " + ex.getLocalizedMessage(), MessageTypes.Fail);
            throw ex;
        }

    }

    @QAFTestStep(description = "Launch application without reset")
    public void launchAppWithoutReset() {
        try {
            (app.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)app.getAppiumDriver() : (IOSDriver)app.getAppiumDriver()).terminateApp(appName);
            (app.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)app.getAppiumDriver() : (IOSDriver)app.getAppiumDriver()).activateApp(appName);
            app.getAndroidDriver().configuratorSetKeyInjectionDelay(Duration.ofMillis(ConfigurationManager.getBundle().getLong("android.apk.keyInjectionDelay")));
            app.getAndroidDriver().configuratorSetWaitForIdleTimeout(Duration.ofMillis(ConfigurationManager.getBundle().getLong("android.apk.waitForIdleTimeout")));
            app.getAndroidDriver().configuratorSetWaitForSelectorTimeout(Duration.ofMillis(ConfigurationManager.getBundle().getLong("android.apk.waitForSelectorTimeout")));
            app.getAndroidDriver().ignoreUnimportantViews(false);
            Reporter.log("Application is launched : " + appName, MessageTypes.Info);

        } catch (Exception ex) {
            Reporter.log("Failed to launch Application " + appName + " with underlying exception : " + ex.getLocalizedMessage(), MessageTypes.Fail);
            throw ex;
        }

    }

    @QAFTestStep(description = "Close application")
    public void closeMobileApplication() {
        try {
            (app.getAppiumDriver() instanceof AndroidDriver ? (AndroidDriver)app.getAppiumDriver() : (IOSDriver)app.getAppiumDriver()).terminateApp(appName);
            Reporter.log("Application Closed : " + appName, MessageTypes.Info);
        } catch (Exception ex) {
            Reporter.log("Failed to close Application " + appName + " with underlying exception : " + ex.getLocalizedMessage(), MessageTypes.Fail);
            throw ex;
        }

    }

}
