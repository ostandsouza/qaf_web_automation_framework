package com.common.utils;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFListenerAdapter;
import com.qmetry.qaf.automation.step.client.TestNGScenario;
import com.qmetry.qaf.automation.testng.DataProviderException;
import com.qmetry.qaf.automation.util.PropertyUtil;
import org.apache.log4j.Logger;
import org.testng.ITestContext;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExtendedQAFListener extends QAFListenerAdapter {
    private static final Logger logger = Logger.getLogger(ExtendedQAFListener.class);

    @Override
    public void beforeFech(TestNGScenario scenario, ITestContext context) {
        ConfigurationManager.getBundle().setProperty("cur.test.csvDataFile", scenario.getMetaData().get("csvDataFile"));
    }

    @Override
    public List<Object[]> intercept(TestNGScenario scenario, ITestContext context, List<Object[]> testdata) {
        logger.info("Intercepting test data..");

        if (testdata.size() <= 1)
            return testdata;

        if (!scenario.getMetaData().containsKey("csvDataFile"))
            return testdata;

        if (!scenario.getMetaData().containsKey("key"))
            throw new DataProviderException("'@key' attribute is missing for scenario: " + scenario.getQualifiedName());

        String key = scenario.getMetaData().get("key").toString();


        List<Map<String, String>> itemsMatchingKey = testdata.stream()
                .map(objArray -> (Map<String, String>) objArray[0])
                .filter(map -> key.equalsIgnoreCase(map.get("key")))
                .collect(Collectors.toList());
        logger.info("Found "+itemsMatchingKey.size()+" row/s having key :"+key);
//        Object env = ConfigurationManager.getBundle().getProperty("env.name");
//        if (env != null) {
//            return Collections.singletonList(itemsMatchingKey.stream()
//                    .filter(map -> env.toString().equalsIgnoreCase(map.get("Env"))).toArray(Object[]::new));
//        } else {
            return Collections.singletonList(itemsMatchingKey.toArray(new Object[0]));
//        }

    }

    @Override
    public void onLoad(PropertyUtil bundle) {
        try {
//      Resolving download location
            String downloadDirProp = bundle.getProperty("download.default.dir").toString();
            String chromeCaps = bundle.getProperty("chrome.additional.capabilities").toString();
            if (downloadDirProp.contains("user.dir")) {
                String curUserDir = System.getProperty("user.dir");
//          This is required for setting user directory properly for chrome.
                downloadDirProp = downloadDirProp.replace("${user.dir}", curUserDir).replaceAll("\\\\","\\\\\\\\");
            }
//      Updating resolved location for chrome
            bundle.setProperty("chrome.additional.capabilities",chromeCaps.replace("${download.default.dir}",downloadDirProp));
//      To:Do
//      Repeat for other browsers as well
        } catch (Exception e) {
            logger.error("Unable to resolve download location");
            logger.error(e.getStackTrace());
        }
    }

}


