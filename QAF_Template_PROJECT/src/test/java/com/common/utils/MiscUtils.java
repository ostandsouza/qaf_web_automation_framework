package com.common.utils;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static com.google.common.collect.Lists.newArrayList;

public class MiscUtils {
    public static String getAbsolutePath(String relativePath) {
        return Paths.get(relativePath).toAbsolutePath().toString();
    }

    public static String changeDateFormat(String date, String fromPattern, String toPattern) {
        return DateTimeFormatter.ofPattern(toPattern).format(LocalDate.parse(date, DateTimeFormatter.ofPattern(fromPattern)));
    }

    public static LocalDate parseDate(String date, String pattern) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    public static String getCurrentDateTime() {
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy:HH.mm.ss");
        return formatter.format(currentDate.getTime());
    }

    public static String convertTimeToString(long miliSeconds) {
        int hrs = (int) TimeUnit.MILLISECONDS.toHours(miliSeconds) % 24;
        int min = (int) TimeUnit.MILLISECONDS.toMinutes(miliSeconds) % 60;
        int sec = (int) TimeUnit.MILLISECONDS.toSeconds(miliSeconds) % 60;
        return String.format("%02d:%02d:%02d", hrs, min, sec);
    }

    public static JSONObject getFullUpdatedPayload(JSONObject obj, String finder, String replaceText) {
        try {
            JSONParser parser = new JSONParser();
            DocumentContext parsed = JsonPath.using(CONFIGURATION).parse(obj.toJSONString());
            newArrayList(
                    "$.." + finder
            ).forEach(path -> parsed.set(path, replaceText));
            String newStr = parsed.jsonString();
            return (JSONObject) parser.parse(newStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject getSingleUpdatedPayload(JSONObject obj, String finder, String replaceText) {
        try {
            JSONParser parser = new JSONParser();
            DocumentContext parsed = JsonPath.using(CONFIGURATION).parse(obj.toJSONString());
            newArrayList(
                    "$." + finder
            ).forEach(path -> parsed.set(path, replaceText));
            String newStr = parsed.jsonString();
            return (JSONObject) parser.parse(newStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static final Configuration CONFIGURATION = Configuration
            .builder()
            .options(Option.SUPPRESS_EXCEPTIONS)
            .build();


}
