package com.common.utils;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

}
