package com.common.utils;

import com.qmetry.qaf.automation.util.Reporter;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaildropHelper {
    static RestAPIHelper restApiHelper = new RestAPIHelper();
    static Map<String, String> headersMap = new HashMap<>();

    static Map<String, String> queryMaps = new HashMap<>();
    static Map<String, Object> requestBody = new HashMap<>();

    public static ArrayList<HashMap<String, String>> getMaildropInbox(String email){
            String baseUrl = "https://api.maildrop.cc";
            restApiHelper.setBaseURI(baseUrl);
            requestBody.put("operationName","GetInbox");
            requestBody.put("variables", Collections.singletonMap("mailbox", email));
            requestBody.put("query","query GetInbox($mailbox: String!) {\n  ping(message: \"Test\")\n  inbox(mailbox: $mailbox) {\n    id\n    subject\n    date\n    headerfrom\n    __typename\n  }\n  altinbox(mailbox: $mailbox)\n}\n");
            headersMap.put("content-type","application/json");
            Response inboxResponse =restApiHelper.makePostRequest("/graphql", new JSONObject(requestBody), headersMap);
            return ((ArrayList<HashMap<String, String>>)((HashMap<String, Object>)inboxResponse.getBody().as(JSONObject.class).get("data")).get("inbox"));
    }

    public static String getLatestMailId(ArrayList<HashMap<String, String>> inbox) {
        if(!inbox.isEmpty())
            return (String)((HashMap<String, String>) inbox.get(0)).get("id");
        return null;
    }

    public static String getInboxMsg(String email, String msgId){
        String baseUrl = "https://api.maildrop.cc";
        restApiHelper.setBaseURI(baseUrl);
        requestBody.put("operationName","GetMessage");
        requestBody.put("variables", new HashMap<String, String>() {{
            put("mailbox", email);
            put("id", msgId);
        }});
        requestBody.put("query", "query GetMessage($mailbox: String!, $id: String!) {\n  message(mailbox: $mailbox, id: $id) {\n    id\n    subject\n    date\n    headerfrom\n    data\n    html\n    __typename\n  }\n}\n");
        headersMap.put("content-type","application/json");
        Response inboxResponse =restApiHelper.makePostRequest("/graphql", new JSONObject(requestBody), headersMap);
        return Jsoup.parse((String)((HashMap<String, String>)((HashMap<String, Object>)inboxResponse.getBody().as(JSONObject.class).get("data")).get("message")).get("html")).text();
    }

}


