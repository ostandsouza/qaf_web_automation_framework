package com.common.utils;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

    public static JSONObject getUpdatedPayload(JSONObject obj, String finder, String replaceText) {
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


    private static final Configuration CONFIGURATION = Configuration
            .builder()
            .options(Option.SUPPRESS_EXCEPTIONS)
            .build();


}
