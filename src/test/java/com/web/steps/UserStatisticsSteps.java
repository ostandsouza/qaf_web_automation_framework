package com.web.steps;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.UserStatisticsPage;
import groovyjarjarantlr4.v4.codegen.model.Sync;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class UserStatisticsSteps {

    UserStatisticsPage stats = new UserStatisticsPage();

    @QAFTestStep(description="Navigate to user statistics page and capture users count")
    public void captureUserCountFromUserStatistics(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalUsersCount().equalsIgnoreCase("0"))
                break;
        }
        System.out.println(stats.getTotalUsersCount());
        getBundle().setProperty("totalUserCount",stats.getTotalUsersCount());
    }

    @QAFTestStep(description="Verify the user statistics user count")
    public void getUserStatsUserCount(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalUsersCount().equalsIgnoreCase((String) getBundle().getProperty("totalUserCount")))
                break;
        }
        System.out.println(stats.getTotalUsersCount());
        Validator.assertTrue(stats.getTotalUsersCount().equalsIgnoreCase(String.valueOf((int)Integer.parseInt((String) getBundle().getProperty("totalUserCount"))+1)),"Total User Count is not matching", "Total User Count Count is matching");
    }

    @QAFTestStep(description="Navigate to user statistics page and capture corporates count")
    public void captureCorporatesCountFromUserStatistics(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalCorporatesCount().equalsIgnoreCase("0"))
                break;
        }
        System.out.println(stats.getTotalCorporatesCount());
        getBundle().setProperty("totalCorporatesCount",stats.getTotalCorporatesCount());
    }

    @QAFTestStep(description="Verify the user statistics corporates count")
    public void getUserStatsCorporateCount(){
        stats.goToUserStatistics();
        SyncUtil.waitFor(1000);
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalCorporatesCount().equalsIgnoreCase((String) getBundle().getProperty("totalCorporatesCount")))
                break;
        }
        System.out.println(stats.getTotalCorporatesCount());
        Validator.assertTrue(stats.getTotalCorporatesCount().equalsIgnoreCase(String.valueOf((int)Integer.parseInt((String)  getBundle().getProperty("totalCorporatesCount"))+ 1)),"Total Corporates Count is not matching", "Total Corporates Count Count is matching");
    }

    @QAFTestStep(description="Navigate to user statistics page and capture shops count")
    public void captureShopsCountFromUserStatistics(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalShopsCount().equalsIgnoreCase("0"))
                break;
        }
        System.out.println(stats.getTotalShopsCount());
        getBundle().setProperty("totalShopsCount",stats.getTotalShopsCount());
    }

    @QAFTestStep(description="Verify the user statistics shops count")
    public void getUserStatsShopsCount(){
        stats.goToUserStatistics();
        SyncUtil.waitFor(1000);
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalShopsCount().equalsIgnoreCase((String) getBundle().getProperty("totalShopsCount")))
                break;
        }
        System.out.println(stats.getTotalShopsCount());
        Validator.assertTrue(stats.getTotalShopsCount().equalsIgnoreCase(String.valueOf((int)Integer.parseInt((String)  getBundle().getProperty("totalShopsCount"))+ 1)),"Total Shops Count is not matching", "Total Shops Count Count is matching");
    }

    @QAFTestStep(description="Navigate to user statistics page and capture sites count")
    public void captureSitesCountFromUserStatistics(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalSitesCount().equalsIgnoreCase("0"))
                break;
        }
        System.out.println(stats.getTotalSitesCount());
        getBundle().setProperty("totalSitesCount",stats.getTotalSitesCount());
    }

    @QAFTestStep(description="Verify the user statistics sites count")
    public void getUserStatsSitesCount(){
        stats.goToUserStatistics();
        SyncUtil.waitFor(1000);
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalSitesCount().equalsIgnoreCase((String) getBundle().getProperty("totalSitesCount")))
                break;
        }
        System.out.println(stats.getTotalSitesCount());
        Validator.assertTrue(stats.getTotalSitesCount().equalsIgnoreCase(String.valueOf((int)Integer.parseInt((String)  getBundle().getProperty("totalSitesCount"))+ 1)),"Total sites Count is not matching", "Total sites Count Count is matching");
    }

    @QAFTestStep(description="Navigate to user statistics page and capture conveyors count")
    public void captureConveyorCountFromUserStatistics(){
        stats.goToUserStatistics();
        SyncUtil.waitFor(1000);
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalConveyorCount().equalsIgnoreCase("0"))
                break;
        }
        System.out.println(stats.getTotalConveyorCount());
        getBundle().setProperty("totalConveyorsCount",stats.getTotalConveyorCount());
    }

    @QAFTestStep(description="Verify the user statistics conveyors count")
    public void getUserStatsConveyorCount(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalConveyorCount().equalsIgnoreCase((String) getBundle().getProperty("totalConveyorsCount")))
                break;
        }
        System.out.println(stats.getTotalConveyorCount());
        Validator.assertTrue(stats.getTotalConveyorCount().equalsIgnoreCase(String.valueOf((int)Integer.parseInt((String)  getBundle().getProperty("totalConveyorsCount"))+ 1)),"Total conveyors Count is not matching", "Total conveyors Count Count is matching");
    }

    @QAFTestStep(description="Navigate to user statistics page and capture cover wear count")
    public void captureCoverWearCountFromUserStatistics(){
        stats.goToUserStatistics();
        SyncUtil.waitFor(1000);
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalCoverWearCount().equalsIgnoreCase("0"))
                break;
        }
        System.out.println(stats.getTotalCoverWearCount());
        getBundle().setProperty("totalCoverWearCount",stats.getTotalCoverWearCount());
    }

    @QAFTestStep(description="Verify the user statistics cover wear count")
    public void getUserStatsCoverWearCount(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalCoverWearCount().equalsIgnoreCase("0") && !stats.getTotalCoverWearCount().equalsIgnoreCase((String) getBundle().getProperty("totalCoverWearCount")))
                break;
        }
        System.out.println(getBundle().getProperty("totalCoverWearCount"));
        System.out.println(stats.getTotalCoverWearCount());
        Validator.assertTrue(stats.getTotalCoverWearCount().equalsIgnoreCase(String.valueOf((int)Integer.parseInt((String)  getBundle().getProperty("totalCoverWearCount"))+ 1)),"Total Cover Wear Count is not matching", "Total Cover Wear Count Count is matching");
    }

    @QAFTestStep(description="Navigate to user statistics page and capture inspection count")
    public void captureInspectionCountFromUserStatistics(){
        stats.goToUserStatistics();
        SyncUtil.waitFor(1000);
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalInspectionCount().equalsIgnoreCase("0"))
                break;
        }
        System.out.println(stats.getTotalInspectionCount());
        getBundle().setProperty("totalInspectionCount",stats.getTotalInspectionCount());
    }

    @QAFTestStep(description="Verify the user statistics inspection count")
    public void getUserStatsInspectionCount(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalInspectionCount().equalsIgnoreCase("0") && !stats.getTotalInspectionCount().equalsIgnoreCase((String) getBundle().getProperty("totalInspectionCount")))
                break;
        }
        System.out.println(stats.getTotalInspectionCount());
        Validator.assertTrue(stats.getTotalInspectionCount().equalsIgnoreCase(String.valueOf((int)Integer.parseInt((String)  getBundle().getProperty("totalInspectionCount"))+ 1)),"Total Inspections Count is not matching", "Total Inspections Count Count is matching");
    }

    @QAFTestStep(description="Navigate to user statistics page and capture conveyor inspect count")
    public void captureConveyorInspectCountFromUserStatistics(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalConveyorInspectCount().equalsIgnoreCase("0"))
                break;
        }
        System.out.println(stats.getTotalConveyorInspectCount());
        getBundle().setProperty("totalConveyorInspectCount",stats.getTotalConveyorInspectCount());
    }

    @QAFTestStep(description="Verify the user statistics conveyor inspect count")
    public void getUserStatsConveyorInspectCount(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalConveyorInspectCount().equalsIgnoreCase("0") && !stats.getTotalConveyorInspectCount().equalsIgnoreCase((String) getBundle().getProperty("totalConveyorInspectCount")))
                break;
        }
        System.out.println(stats.getTotalConveyorInspectCount());
        Validator.assertTrue(stats.getTotalConveyorInspectCount().equalsIgnoreCase(String.valueOf((int)Integer.parseInt((String)  getBundle().getProperty("totalConveyorInspectCount"))+ 1)),"Total Conveyor Inspect Count is not matching", "Total Conveyor Inspect Count Count is matching");
    }

    @QAFTestStep(description="Navigate to user statistics page and capture belt scan count")
    public void captureBeltScanCountFromUserStatistics(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalBeltScansCount().equalsIgnoreCase("0"))
                break;
        }
        System.out.println(stats.getTotalBeltScansCount());
        getBundle().setProperty("totalBeltScanCount",stats.getTotalBeltScansCount());
    }

    @QAFTestStep(description="Verify the user statistics belt scan count")
    public void getUserStatsBeltScanCount(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalBeltScansCount().equalsIgnoreCase("0") && !stats.getTotalBeltScansCount().equalsIgnoreCase((String) getBundle().getProperty("totalBeltScanCount")))
                break;
        }
        System.out.println(stats.getTotalBeltScansCount());
        Validator.assertTrue(stats.getTotalBeltScansCount().equalsIgnoreCase(String.valueOf((int)Integer.parseInt((String)  getBundle().getProperty("totalBeltScanCount"))+ 1)),"Total Belt Scan Count is not matching", "Total Belt Scan Count Count is matching");
    }

    @QAFTestStep(description="Navigate to user statistics page and capture monitoring device count")
    public void captureMonitoringDeviceCountFromUserStatistics(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalMonitoringDevicesCount().equalsIgnoreCase("0"))
                break;
        }
        System.out.println(stats.getTotalMonitoringDevicesCount());
        getBundle().setProperty("totalMonitoringDeviceCount",stats.getTotalMonitoringDevicesCount());
    }

    @QAFTestStep(description="Verify the user statistics monitoring device count")
    public void getUserStatsMonitoringDeviceCount(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalMonitoringDevicesCount().equalsIgnoreCase("0") && !stats.getTotalMonitoringDevicesCount().equalsIgnoreCase((String) getBundle().getProperty("totalMonitoringDeviceCount")))
                break;
        }
        System.out.println(stats.getTotalMonitoringDevicesCount());
        Validator.assertTrue(stats.getTotalMonitoringDevicesCount().equalsIgnoreCase(String.valueOf((int)Integer.parseInt((String)  getBundle().getProperty("totalMonitoringDeviceCount"))+ 1)),"Total monitoring device Count is not matching", "Total monitoring device Count Count is matching");
    }

    @QAFTestStep(description="Navigate to user statistics page and capture minuteman count")
    public void captureMinutemanCountFromUserStatistics(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalMinutemanCount().equalsIgnoreCase("0"))
                break;
        }
        System.out.println(stats.getTotalMinutemanCount());
        getBundle().setProperty("totalMinutemanCount",stats.getTotalMinutemanCount());
    }

    @QAFTestStep(description="Verify the user statistics minuteman count")
    public void getUserStatsMinutemanCount(){
        stats.goToUserStatistics();
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 25000; ) {
            if(!stats.getTotalMinutemanCount().equalsIgnoreCase("0") && !stats.getTotalMinutemanCount().equalsIgnoreCase((String) getBundle().getProperty("totalMinutemanCount")))
                break;
        }
        System.out.println(stats.getTotalMinutemanCount());
        Validator.assertTrue(stats.getTotalMinutemanCount().equalsIgnoreCase(String.valueOf((int)Integer.parseInt((String)  getBundle().getProperty("totalMinutemanCount"))+ 1)),"Total Minuteman Count is not matching", "Total Minuteman Count Count is matching");
    }
}
