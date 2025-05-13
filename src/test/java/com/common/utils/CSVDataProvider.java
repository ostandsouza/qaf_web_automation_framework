package com.common.utils;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class CSVDataProvider {
    private static final Logger logger = Logger.getLogger(CSVDataProvider.class);

    @DataProvider(name = "CSV_DataProvider")
    public Object[][] createData() {
        logger.info("CSV_DataProvider invoked");
        Object csvFile = ConfigurationManager.getBundle().getProperty("cur.test.csvDataFile");
        if (csvFile != null && !csvFile.toString().isEmpty())
            return CSVParser.parseData(csvFile.toString(), '|').toArray(new Object[0][]);
        else
            return new Object[][]{{new HashMap<>()}};

    }
}



