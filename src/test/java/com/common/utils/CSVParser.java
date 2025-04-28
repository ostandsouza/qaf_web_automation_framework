package com.common.utils;

import com.qmetry.qaf.automation.testng.DataProviderException;
import com.qmetry.qaf.automation.util.StringUtil;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVParser {
    private static final Logger logger = Logger.getLogger(CSVParser.class);

    public static List<Object[]> parseData(String strFile) {
        return parseData(strFile, ',');
    }

    public static List<Object[]> parseData(String strFile, char separatorChar) {
        ArrayList<Object[]> rows = new ArrayList<Object[]>();
        File csvFile = new File(strFile);
        Object[] headers = new Object[0];

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            logger.info("Loading csv data file: " + strFile);
            String strLine;
            int curRowNum = 0;

            while ((strLine = br.readLine()) != null) {
                curRowNum++;
                if (!strLine.trim().isEmpty() && !"#!".contains("" + strLine.trim().charAt(0))) {
                    if ("key".equalsIgnoreCase(strLine.substring(0, 3))) {
                        headers = StringUtil.parseCSV(strLine, separatorChar);
                    } else {
                        Object[] values = StringUtil.parseCSV(strLine, separatorChar);
                        if (headers.length == values.length)
                            rows.add(convertToMap(headers, values));
                        else
                            logger.error("Headers and Values count don't match. Row: [" + curRowNum + "] is skipped");
                    }
                }
            }

        } catch (IOException e) {
            logger.error("Exception while reading csv file: " + strFile + e);
            throw new DataProviderException("Error while fetching data from " + strFile, e);
        }
        return rows;
    }

    public static Object[] convertToMap(Object[] headers, Object[] values){
        Map<Object, Object> dataMap = new HashMap<>();
        Object[] arr = new Object[1];
        for (int i=0; i  < headers.length; i++){
            dataMap.put(headers[i], values[i]);
        }
        arr[0]=dataMap;
        return arr;
    }

}

