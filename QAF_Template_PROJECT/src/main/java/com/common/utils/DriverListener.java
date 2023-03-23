package com.common.utils;

import com.qmetry.qaf.automation.ui.webdriver.CommandTracker;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriverCommandListener;
import com.qmetry.qaf.automation.util.Reporter;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverListener implements QAFWebDriverCommandListener {
    @Override
    public void beforeCommand(QAFExtendedWebDriver qafExtendedWebDriver, CommandTracker commandTracker) {

    }

    @Override
    public void afterCommand(QAFExtendedWebDriver qafExtendedWebDriver, CommandTracker commandTracker) {

    }

    @Override
    public void onFailure(QAFExtendedWebDriver qafExtendedWebDriver, CommandTracker commandTracker) {

    }

    @Override
    public void beforeInitialize(Capabilities capabilities) {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origin=*");
//        capabilities.merge(options);
    }

    @Override
    public void onInitialize(QAFExtendedWebDriver qafExtendedWebDriver) {
//        qafExtendedWebDriver.get("https://google.co.in");
    }

    @Override
    public void onInitializationFailure(Capabilities capabilities, Throwable throwable) {
        Reporter.log("list of cap: = "+capabilities);
        Reporter.log("throwable: = "+throwable.toString());
    }
}
