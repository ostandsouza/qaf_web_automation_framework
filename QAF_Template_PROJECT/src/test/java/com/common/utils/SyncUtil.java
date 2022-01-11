package com.common.utils;

public class SyncUtil {
    public static void waitFor(long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException ignore) {

        }
    }

}
