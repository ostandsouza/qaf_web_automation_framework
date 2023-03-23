package com.common.utils;

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
//        APIBase api = new APIBase();
//        String userid = api.getUserProfileAPI((String) getBundle().getProperty("email.ind"));
//        api.deleteProfileAPI(userid);
//        api.deleteUserAPI(userid);
//        userid = api.getUserProfileAPI((String) getBundle().getProperty("email.ger"));
//        api.deleteProfileAPI(userid);
//        api.deleteUserAPI(userid);
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
