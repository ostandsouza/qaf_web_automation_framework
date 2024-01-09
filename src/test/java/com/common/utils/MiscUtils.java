package com.common.utils;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.qmetry.qaf.automation.util.PoiExcelUtil;
import com.qmetry.qaf.automation.util.Reporter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.response.Response;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.google.common.collect.Lists.newArrayList;
import static java.io.File.separator;

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

    public static String regexExtractor(String text, String regex) {
        String val = null;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            val = matcher.group(1);
            System.out.println("match text: =" + matcher.groupCount());
        }
        System.out.println("After regex text:" + val.trim());
        return val.trim();
    }

    public static String getOtpfromMail(String body) {
        try {
            String val = null;
            Pattern pattern = Pattern.compile("([0-9]{6})\\s+");
            Matcher matcher = pattern.matcher(body);
            if (matcher.find()) {
                val = matcher.group(1);
                System.out.println("match text: =" + matcher.groupCount());
            }
            System.out.println("Mail OTP is:" + val.trim());
            return val.trim();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean isNewEmailTriggered(String email) {
        String[] extract_username = email.split("@");
        String username = extract_username[0];
        SyncUtil.waitFor(20000);
        if (email.contains("gmail"))
            return GmailHelper.getUnreadMails(GmailHelper.getGmailService(username),"is:unread").isEmpty();
        else if (email.contains("maildrop"))
            return MaildropHelper.getMaildropInbox(username).isEmpty();
        return false;
    }

    public static String getLatestEmailBody(String email) {
        String[] extract_username = email.split("@");
        String username = extract_username[0];
        String emailBody = null;
        SyncUtil.waitFor(10000);
        if (email.contains("gmail"))
            emailBody = GmailHelper.getMailBody(GmailHelper.getGmailService(username),"is:unread");
        else if (email.contains("maildrop"))
            emailBody = MaildropHelper.getInboxMsg(username, MaildropHelper.getLatestMailId(MaildropHelper.getMaildropInbox(username)));
        return emailBody;
    }

    public static Object[][] getDownloadedExcelData(String fileName, String sheetName) {
        String file_path = System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+fileName;
        Object[][] obj = PoiExcelUtil.getExcelDataAsMap(file_path,sheetName);
        System.out.println(Arrays.deepToString(obj));
        return obj;
    }

    public static List<String> getDownloadedExcelSheet(String fileName) {
        String file_path = System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+fileName;
        List<String> obj = PoiExcelUtil.getSheetNames(new File(file_path));
        System.out.println(obj);
        return obj;
    }

    public static boolean checkDownloadedFiles(String name){
        SyncUtil.waitFor(4000);
        File folder = new File(System.getProperty("user.dir")+separator+"target"+separator+"downloads");  //List the files on that folder
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        //Look for the file in the files
        // You should write smart REGEX according to the filename

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches(name)) {
                    found = true;
                }
            }
        }
        return found;
    }

    public static void deleteDownloadedFiles(String name){
        File folder = new File(System.getProperty("user.dir")+separator+"target"+separator+"downloads");  //List the files on that folder
        File[] listOfFiles = folder.listFiles();
        File f = null;
        //Look for the file in the files
        // You should write smart REGEX according to the filename

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches(name)) {
                    System.out.println("Delete File " + listOfFile.getName());
                    f = new File(folder.getAbsolutePath()+separator+fileName);
                    f.delete();
                }
            }
        }
    }

    public static Object[][] getExcelData(String fileName, String sheetName) {
        String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "excel_data").getAbsolutePath();
        Object[][] obj = PoiExcelUtil.getExcelDataAsMap(file_path,sheetName);
        return obj;
    }

    public static List<String> getExcelSheet(String fileName) {
        String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "excel_data").getAbsolutePath();
        List<String> obj = PoiExcelUtil.getSheetNames(new File(file_path));
        return obj;
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


    public static JSONObject parse(Response dataResponse) {
        JSONParser parser = new JSONParser();
        JSONObject data = null;
        try {
            String jsonData = dataResponse.body().asString();
            data = (JSONObject) parser.parse(jsonData);
        } catch (ParseException e) {
            Reporter.log(e.getMessage());
        }

        return data;
    }

    public static JSONArray parseArray(Response dataResponse) {
        JSONParser parser = new JSONParser();
        JSONArray data = null;
        try {
            String jsonData = dataResponse.body().asString();
            data = (JSONArray) parser.parse(jsonData);
        } catch (ParseException e) {
            Reporter.log(e.getMessage());
        }

        return data;
    }
}
