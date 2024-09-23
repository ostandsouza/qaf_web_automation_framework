package com.common.utils;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.StringUtils;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.ModifyMessageRequest;
import com.qmetry.qaf.automation.util.Reporter;
import org.apache.commons.codec.binary.Base64;

import org.json.JSONObject;
import org.jsoup.Jsoup;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.*;

public class GmailHelper {

    private static final String APPLICATION_NAME = "Gmail API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String user = "me";
    static Map<String, String> val;
    private static File filePath;

    public static Gmail getGmailService(String email) {
        Gmail service = null;
        Properties systemProperties = System.getProperties();
        systemProperties.setProperty("http.proxyHost","cias.geoaws.com");
        systemProperties.setProperty("http.proxyPort","8080");
        systemProperties.setProperty("https.proxyHost","cias.geoaws.com");
        systemProperties.setProperty("https.proxyPort","8080");
        try {
            val = JsonReader.getMap(email + "_credentials", "web", "gmail_data");
            filePath = ClasspathResourceHelper.getPropertyFileByLocale(email + "_credentials", ClasspathResourceHelper.FileType.JSON, "gmail_data");
            InputStream in = new FileInputStream(filePath); // Read credentials.json
            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
            // Credential builder

            Credential authorize = new GoogleCredential.Builder().setTransport(GoogleNetHttpTransport.newTrustedTransport())
                    .setJsonFactory(JSON_FACTORY)
                    .setClientSecrets(clientSecrets.getDetails().getClientId().toString(),
                            clientSecrets.getDetails().getClientSecret().toString())
                    .build().setAccessToken(getAccessToken()).setRefreshToken(
                            val.get("refresh_token"));//Replace this

            // Create Gmail service
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, authorize)
                    .setApplicationName(APPLICATION_NAME).build();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return service;
    }

    public static List<Message> getUnreadMails(Gmail service, String searchString) {
        List<Message> unreadMsg = new ArrayList<>();
        try {
            // Access Gmail inbox

            Gmail.Users.Messages.List request = service.users().messages().list(user).setQ(searchString);

            ListMessagesResponse messagesResponse = request.execute();
            request.setPageToken(messagesResponse.getNextPageToken());
            unreadMsg.addAll(messagesResponse.getMessages());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Get ID of the email you are looking for
        return unreadMsg;
    }

    public static String getMailBody(Gmail service, String searchString)  {
        String emailBody ="";
        try{
        // Access Gmail inbox

        Gmail.Users.Messages.List request = service.users().messages().list(user).setQ(searchString);

        ListMessagesResponse messagesResponse = request.execute();
        request.setPageToken(messagesResponse.getNextPageToken());
            // Get ID of the email you are looking for
            if(messagesResponse.getMessages() != null) {
                String messageId = messagesResponse.getMessages().get(0).getId();

                Message message = service.users().messages().get(user, messageId).execute();

                // Print email body

                emailBody = Jsoup.parse(StringUtils
                        .newStringUtf8(Base64.decodeBase64(message.getPayload().getParts().get(0).getBody().getData()))).text();

                Reporter.log("Email body : " + emailBody);

                ModifyMessageRequest mods =
                        new ModifyMessageRequest()
                                .setAddLabelIds(Collections.singletonList("INBOX"))
                                .setRemoveLabelIds(Collections.singletonList("UNREAD"));
                service.users().messages().modify(user, messageId, mods).execute();
            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
        return emailBody;
    }

    private static String getAccessToken() {

        try {
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("grant_type", "refresh_token");
            params.put("client_id", val.get("client_id"));
            params.put("client_secret", val.get("client_secret"));
            params.put("refresh_token", val.get("refresh_token"));

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            URL url = new URL("https://accounts.google.com/o/oauth2/token");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setRequestMethod("POST");
            con.getOutputStream().write(postDataBytes);

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuffer buffer = new StringBuffer();
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                buffer.append(line);
            }

            JSONObject json = new JSONObject(buffer.toString());
            String accessToken = json.getString("access_token");
            return accessToken;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
