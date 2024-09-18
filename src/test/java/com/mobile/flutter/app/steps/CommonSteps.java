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

    @QAFTestStep(description = "Create as customer user account from via with {UserName} {Email} {Password} {Phone} {SiteName} and {UserType}")
    public void createCustomerUserViaAPI(String userName, String email, String pwd, String phone, String siteName, String userType) {
        app.apiBase.getLoginAPI(getBundle().getString("env.adminUsername"),getBundle().getString("env.adminPassword"));
        String userid = app.apiBase.getUserProfileAPI(email);
        app.apiBase.deleteProfileAPI(userid);
        app.apiBase.deleteUserAPI(userid);
        ArrayList<HashMap<String, Object>> companyRes = ((ArrayList<HashMap<String, Object>>)(app.apiBase.getCompanyAPI(siteName).jsonPath().get("data")));
        String userId= app.apiBase.createUserAPI(email, pwd, phone, userName);
        app.apiBase.createProfileAPI(userType, userId, new JSONObject(companyRes.get(0)).toString());
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
    @QAFTestStep(description = "Launch the application through {url}")
    public void launchTheApplicationThrough(String url) {
//        loginPage.getTestBase().getDriver().manage().window().maximize();
        loginPage.getTestBase().getDriver().get(url);
        loginPage.apiBase.getLoginAPI(getBundle().getString("env.adminUsername"),getBundle().getString("env.adminPassword"));
        //loginPage.getTestBase().getDriver().get("https://Uie68917:Conti@2021@dev2.contiplus.net/#/auth/login:4444");
        Reporter.log("Application is launched using :" + url, MessageTypes.Pass);
    }
}
