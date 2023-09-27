package com.mobile.flutter.app.steps;

import com.common.utils.MiscUtils;
import com.mobile.flutter.app.pages.FlutterBasePage;
import com.mobile.utils.PerfectoLabUtils;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class CommonSteps {
    FlutterBasePage app = new FlutterBasePage();

    String appName = ConfigurationManager.getBundle().getString("aut.appName");
    boolean isUsingPerfecto = ConfigurationManager.getBundle().getString("remote.server").contains("perfecto");

    @QAFTestStep(description = "Application is installed")
    public void InstallMobileApplication() throws URISyntaxException, IOException {
    	app.getTestBase().getDriver().executeScript("flutter:terminateApp", appName);
    	
        boolean updateAppFlag = Boolean.parseBoolean(ConfigurationManager.getBundle().getString("aut.updateApp"));
        String artifactLocator = ConfigurationManager.getBundle().getString("appium.capabilities.app");
        if (updateAppFlag && isUsingPerfecto) {
            String cloudName = ConfigurationManager.getBundle().getString("perfecto.cloud");
            String source = MiscUtils.getAbsolutePath(ConfigurationManager.getBundle().getString("aut.path"));
            String token = (String) app.getAppiumDriver().getCapabilities().getCapability("accessToken");
            PerfectoLabUtils.uploadMedia_NewAPI(cloudName, token, source, artifactLocator);

        }

        if (updateAppFlag && app.getAndroidDriver().isAppInstalled(appName))
            app.getAndroidDriver().removeApp(appName);

        if (!app.getAndroidDriver().isAppInstalled(appName)) {
            if (isUsingPerfecto) {
                Map<String, Object> params = new HashMap<>();
                params.put("file", artifactLocator);
                params.put("instrument", "instrument");
                app.getAppiumDriver().executeScript("mobile:application:install", params);
            } else
                app.getAndroidDriver().installApp(MiscUtils.getAbsolutePath(ConfigurationManager.getBundle().getString("aut.path")));
        }

        if (app.getAndroidDriver().isAppInstalled(appName)) {
            ConfigurationManager.getBundle().setProperty("android.apk.updateApp", false);
            Reporter.log("Application is Installed : " + appName, MessageTypes.Info);
        }
    }


    @QAFTestStep(description = "Close application")
    public void closeMobileApplication() {
        try {
//            app.activateAppUnderTest();
            Reporter.log("Application Closed : " + appName, MessageTypes.Info);
        } catch (Exception ex) {
            Reporter.log("Failed to close Application " + appName + " with underlying exception : " + ex.getLocalizedMessage(), MessageTypes.Fail);
            throw ex;
        }

    }

}
