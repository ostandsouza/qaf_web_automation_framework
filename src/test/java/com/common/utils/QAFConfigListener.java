package com.common.utils;

import com.qmetry.qaf.automation.core.QAFConfigurationListener;
import com.qmetry.qaf.automation.util.PropertyUtil;
import org.apache.log4j.Logger;

@Deprecated
/*
This is not required and to be deleted in the future.
Functionality is merged in ExtendedQAFListener class by extending QAFListenerAdapter
*/
public class QAFConfigListener implements QAFConfigurationListener {
    private static final org.apache.log4j.Logger logger = Logger.getLogger(QAFConfigListener.class);

    @Override
    public void onLoad(PropertyUtil bundle) {

        try {
//      Resolving download location
            String downloadDirProp = bundle.getProperty("download.default.dir").toString();
            String chromeCaps = bundle.getProperty("chrome.additional.capabilities").toString();
            if (downloadDirProp.contains("user.dir")) {
                String curUserDir = System.getProperty("user.dir");
                downloadDirProp = downloadDirProp.replace("${user.dir}", curUserDir);
            }
//      Setting up resolved location in chrome
            bundle.setProperty("chrome.additional.capabilities",chromeCaps.replace("${download.default.dir}",downloadDirProp));

//      Repeat for other browsers as well
        } catch (Exception e) {
            logger.error("Unable to resolve download location");
            logger.error(e.getStackTrace());
        }

    }

    @Override
    public void onChange() {

    }
}
