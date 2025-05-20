package com.common.utils;

import org.apache.log4j.Logger;

public class SyncUtil {
    private static final Logger logger = Logger.getLogger(JsonReader.class);

    public static void waitFor(long timeOut) {
        try {
            logger.info("Waiting for " + timeOut + " ms");
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            logger.error(e.getStackTrace());
        }
    }

}
