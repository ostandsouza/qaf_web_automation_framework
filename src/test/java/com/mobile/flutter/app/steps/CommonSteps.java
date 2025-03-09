package com.mobile.flutter.app.steps;

import com.common.utils.MiscUtils;
import com.mobile.flutter.app.pages.DashboardPage;
import com.mobile.flutter.app.pages.FlutterBasePage;
import com.mobile.utils.PerfectoLabUtils;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.LoginPage;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class CommonSteps {
    FlutterBasePage app = new FlutterBasePage();
    LoginPage loginPage = new LoginPage();

    String appName = ConfigurationManager.getBundle().getString("aut.appName");
    boolean isUsingPerfecto = ConfigurationManager.getBundle().getString("remote.server").contains("perfecto");
//    boolean isUsingAndriod = ConfigurationManager.getBundle().getString("env.resources").contains("android");
    boolean isUsingAndriod = true;

    @QAFTestStep(description = "Application is installed")
    public void InstallMobileApplication() throws URISyntaxException, IOException {
        boolean updateAppFlag = Boolean.parseBoolean(ConfigurationManager.getBundle().getString("aut.updateApp"));
        boolean clearAppCacheFlag = Boolean.parseBoolean(ConfigurationManager.getBundle().getString("aut.clearCache"));

        String source = MiscUtils.getAbsolutePath(ConfigurationManager.getBundle().getString("aut.path"));

        if (updateAppFlag)
            Reporter.log("Removing existing app as update flag is true.", MessageTypes.Info);

        try {
            if (isUsingAndriod) {
                app.getAndroidDriver().context("NATIVE_APP");
                if (updateAppFlag)
                    if(app.getAndroidDriver().removeApp(appName))
                        Reporter.log("Removed existing app for updating.", MessageTypes.Info);
                    else
                        Reporter.log("Failed to removed existing app.", MessageTypes.Fail);

                if (!app.getAndroidDriver().isAppInstalled(appName)) {
                    Reporter.log("Installing app : " + appName, MessageTypes.Info);
                    app.getAndroidDriver().installApp(source);
                }

            } else {
                app.getIOSDriver().context("NATIVE_APP");
                if (updateAppFlag) {
                    if(app.getIOSDriver().removeApp(appName))
                        Reporter.log("Removed existing app for updating.", MessageTypes.Info);
                    else
                        Reporter.log("Failed to removed existing app.", MessageTypes.Fail);
                }
                if (!app.getIOSDriver().isAppInstalled(appName)) {
                    Reporter.log("Installing app : " + appName, MessageTypes.Info);
                    app.getIOSDriver().installApp(source);

                }
            }
            ConfigurationManager.getBundle().setProperty("aut.updateApp", "false");
            Reporter.log("Application is installed : " + appName, MessageTypes.Info);
        } catch (Exception ex) {
            Reporter.log("Failed to launch Application " + appName + " with underlying exception : "
                    + ex.getLocalizedMessage(), MessageTypes.Fail);
            throw ex;
        }

    }

    @QAFTestStep(description = "Application is launched")
    public void launchMobileApplication() {
        boolean clearAppCacheFlag = Boolean.parseBoolean(ConfigurationManager.getBundle().getString("aut.clearCache"));

        String source = MiscUtils.getAbsolutePath(ConfigurationManager.getBundle().getString("aut.path"));
        try {
            if (isUsingAndriod) {
                app.getAndroidDriver().context("NATIVE_APP");
                app.getAndroidDriver().terminateApp(appName);
                if (clearAppCacheFlag)
                    app.clearAndroidAppCache(appName);
                app.getAndroidDriver().context("FLUTTER");
                app.getAndroidDriver().activateApp(appName);
                app.getAndroidDriver().configuratorSetKeyInjectionDelay(
                        Duration.ofMillis(ConfigurationManager.getBundle().getLong("android.apk.keyInjectionDelay")));
                app.getAndroidDriver().configuratorSetWaitForIdleTimeout(
                        Duration.ofMillis(ConfigurationManager.getBundle().getLong("android.apk.waitForIdleTimeout")));
                app.getAndroidDriver().configuratorSetWaitForSelectorTimeout(Duration
                        .ofMillis(ConfigurationManager.getBundle().getLong("android.apk.waitForSelectorTimeout")));
                app.getAndroidDriver().ignoreUnimportantViews(false);

            } else {
                app.getIOSDriver().context("NATIVE_APP");
                if (clearAppCacheFlag) {
                    if (app.getIOSDriver().isAppInstalled(appName)) {
                        app.getIOSDriver().terminateApp(appName);
                        app.getIOSDriver().removeApp(appName);
                        Reporter.log("Removed existing app for cache clearing.", MessageTypes.Info);
                        app.getIOSDriver().installApp(source);
                        Reporter.log("Re-Installed app : " + appName, MessageTypes.Info);
                    }
                }
                app.getIOSDriver().context("FLUTTER");
                app.getIOSDriver().activateApp(appName);

            }
            Reporter.log("Application Launched : " + appName, MessageTypes.Info);
        } catch (Exception ex) {
            Reporter.log("Failed to launch Application " + appName + " with underlying exception : "
                    + ex.getLocalizedMessage(), MessageTypes.Fail);
            throw ex;
        }

    }

    @QAFTestStep(description = "Launch application without reset")
    public void launchAppWithoutReset() {
        try {
            if (isUsingAndriod) {
                app.getAndroidDriver().context("NATIVE_APP");
                app.getAndroidDriver().terminateApp(appName);
                app.getAndroidDriver().context("FLUTTER");
                app.getAndroidDriver().activateApp(appName);
                app.getAndroidDriver().configuratorSetKeyInjectionDelay(
                        Duration.ofMillis(ConfigurationManager.getBundle().getLong("android.apk.keyInjectionDelay")));
                app.getAndroidDriver().configuratorSetWaitForIdleTimeout(
                        Duration.ofMillis(ConfigurationManager.getBundle().getLong("android.apk.waitForIdleTimeout")));
                app.getAndroidDriver().configuratorSetWaitForSelectorTimeout(Duration
                        .ofMillis(ConfigurationManager.getBundle().getLong("android.apk.waitForSelectorTimeout")));
                app.getAndroidDriver().ignoreUnimportantViews(false);

            } else {
                app.getIOSDriver().context("NATIVE_APP");
                app.getIOSDriver().terminateApp(appName);
                app.getIOSDriver().context("FLUTTER");
                app.getIOSDriver().activateApp(appName);
            }
            Reporter.log("Application is launched : " + appName, MessageTypes.Info);

        } catch (Exception ex) {
            Reporter.log("Failed to launch Application " + appName + " with underlying exception : "
                    + ex.getLocalizedMessage(), MessageTypes.Fail);
            throw ex;
        }

    }

    @QAFTestStep(description = "Close application")
    public void closeMobileApplication() {

        try {
            if (isUsingAndriod) {
                app.getAndroidDriver().context("NATIVE_APP");
                app.getAndroidDriver().terminateApp(appName);
                app.getAndroidDriver().context("FLUTTER");
            } else {
                app.getIOSDriver().context("NATIVE_APP");
                app.getIOSDriver().terminateApp(appName);
                app.getIOSDriver().context("FLUTTER");
            }
            // app.activateAppUnderTest();
            Reporter.log("Application Closed : " + appName, MessageTypes.Info);
        } catch (Exception ex) {
            Reporter.log("Failed to close Application " + appName + " with underlying exception : "
                    + ex.getLocalizedMessage(), MessageTypes.Fail);
            throw ex;
        }

    }

    @QAFTestStep(description = "Create as customer user account from via with {UserName} {Email} {Password} {Phone} {SiteName} and {UserType}")
    public void createCustomerUserViaAPI(String userName, String email, String pwd, String phone, String siteName, String userType) {
        app.apiBase.getLoginAPI(getBundle().getString("env.adminUsername"),getBundle().getString("env.adminPassword"));
        String userid = app.apiBase.getUserProfileAPI(email);
        app.apiBase.deleteProfileAPI(userid);
        app.apiBase.deleteUserAPI(userid);
        HashMap<String, Object> companyRes = ((HashMap<String, Object>)(app.apiBase.getCompanyAPI(siteName)));
        String userId= app.apiBase.createUserAPI(email, pwd, phone, userName);
        app.apiBase.createProfileAPI(userType, userId, new JSONObject(companyRes).toString());
    }

    @QAFTestStep(description = "Create as territory user account from via with {UserName} {Email} {Password} {Phone} and {UserType}")
    public void createTerritoryUserViaAPI(String userName, String email, String pwd, String phone, String userType) {
        app.apiBase.getLoginAPI(getBundle().getString("env.adminUsername"),getBundle().getString("env.adminPassword"));
        String userid = app.apiBase.getUserProfileAPI(email);
        app.apiBase.deleteProfileAPI(userid);
        app.apiBase.deleteUserAPI(userid);
        String userId= app.apiBase.createUserAPI(email, pwd, phone, userName);
        app.apiBase.createProfileAPI(userType, userId);
    }
}
