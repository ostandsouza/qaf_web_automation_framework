package com.common.utils;

import com.sun.corba.se.impl.orbutil.concurrent.SyncUtil;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MailsacHelper {

    static RestAPIHelper restApiHelper = new RestAPIHelper();
    static Map<String, String> queryMaps = new HashMap<>();
    static Map<String, String> headersMap = new HashMap<>();

    public static ArrayList<HashMap<String, String>> getMailsacInbox(String email){
        String baseUrl = "https://mailsac.com/api/";
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("Mailsac-Key","k_mjd1XkXejgKy9dLuKZp9eFn9eWNAAKI1AH5PY00");
        Response inboxResponse =restApiHelper.makeGetRequest("/addresses/"+email+"/messages", queryMaps , headersMap);
        System.out.println("output---" +inboxResponse.getBody().as(JSONArray.class));
        return ((ArrayList<HashMap<String, String>>)inboxResponse.getBody().as(JSONArray.class));
    }

    public static String getLatestMailId(ArrayList<HashMap<String, String>> inbox) {
        System.out.println("search----"+inbox);
        if(!inbox.isEmpty())
            return (String)((HashMap<String, String>) inbox.get(0)).get("_id");
        return null;
    }

    public static String getInboxMsg(String email, String msgId){
        String baseUrl = "https://mailsac.com/api/";
        headersMap.put("Mailsac-Key","k_mjd1XkXejgKy9dLuKZp9eFn9eWNAAKI1AH5PY00");
        Response inboxResponse =restApiHelper.makeGetRequest("/text/"+email+"/"+msgId, queryMaps , headersMap);
        System.out.println(inboxResponse.getBody().prettyPrint());
        return (String) inboxResponse.getBody().prettyPrint();
    }

}
