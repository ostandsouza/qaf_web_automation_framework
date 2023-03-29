package com.common.utils;

import com.qmetry.qaf.automation.util.Reporter;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class APIBase {

    RestAPIHelper restApiHelper = new RestAPIHelper();
    Map<String, String> commonPaths;

    Map<String, String> headersMap = new HashMap<>();

    Map<String, String> queryMaps = new HashMap<>();
    Map<String, Object> requestBody = new HashMap<>();

    String accessToken;
    String refreshToken;

    public APIBase() {
        commonPaths = JsonReader.getMapTestData("service_url", "dev2");
        getLoginAPI("contiplus_admin@maildrop.cc","Test@12345");
    }

    public void configureRestAssured() {
        Reporter.log("Configuring RestAssured");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAPIHelper.configure();
        headersMap.put("appclientid","pvr1dnvs0gntbsr95dvkdco8l");
    }

    public void tearDown() {
        Reporter.log("Resetting base uri and path after method");
        restApiHelper.resetBaseURI();
        restApiHelper.resetBasePath();
        headersMap.clear();
        queryMaps.clear();
        requestBody.clear();
    }

    public void getLoginAPI(String user, String pwd) {
        configureRestAssured();
        String baseUrl = commonPaths.get("auth_ms");
        restApiHelper.setBaseURI(baseUrl);
        requestBody.put("email", user);
        requestBody.put("password", pwd);
        Map<String, String> authPaths = JsonReader.getMapTestData("path", "auth_controller");
        Response loginResponse =restApiHelper.makePostRequest(authPaths.get("user_login"), new JSONObject(requestBody), headersMap);
        accessToken = loginResponse.getBody().as(JSONObject.class).get("accessToken").toString();
        refreshToken = loginResponse.getBody().as(JSONObject.class).get("refreshToken").toString();
        Reporter.log("accessToken, "+accessToken);
        Reporter.log("refreshToken, "+refreshToken);
        tearDown();
    }


    public String getUserProfileAPI(String email) {
        configureRestAssured();
        String baseUrl = commonPaths.get("profile_ms");
        restApiHelper.setBaseURI(baseUrl);
        if(email != null)
            queryMaps.put("email", email);
        headersMap.put("usertoken",accessToken);
        Map<String, String> profilePaths = JsonReader.getMapTestData("path", "profile_controller");
        restApiHelper.makeGetRequest(profilePaths.get("profile"),queryMaps,headersMap);
        Response profileResponse = restApiHelper.getResponse();
        String val = null;
        if(profileResponse.getStatusCode() == 200) {
            JsonPath jsnPath = profileResponse.jsonPath();
            val = (String) jsnPath.getMap("data[0]").get("userId");
        }
        tearDown();
        return val;
    }

    public void deleteProfileAPI(String userId) {
        configureRestAssured();
        String baseUrl = commonPaths.get("profile_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("usertoken",accessToken);
        Map<String, String> profilePaths = JsonReader.getMapTestData("path", "profile_controller");
        if(userId != null)
            restApiHelper.makeDeleteRequest(profilePaths.get("profile")+"/"+userId, headersMap);
        Response profileResponse = restApiHelper.getResponse();
        tearDown();
    }

    public void deleteUserAPI(String userId) {
        configureRestAssured();
        String baseUrl = commonPaths.get("user_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("usertoken",accessToken);
        Map<String, String> userPaths = JsonReader.getMapTestData("path", "user_controller");
        if(userId != null)
            restApiHelper.makeDeleteRequest(userPaths.get("user")+"/"+userId, headersMap);
        else
            Reporter.log("user id was null");
        Response profileResponse = restApiHelper.getResponse();
        tearDown();
    }

    public String createUserAPI(String email, String password, String phone, String username) {
        String baseUrl = commonPaths.get("user_ms");
        restApiHelper.setBaseURI(baseUrl);
        requestBody.put("email", email);
        requestBody.put("locale", "en-US");
        requestBody.put("password", password);
        requestBody.put("phone", phone);
        requestBody.put("username", username);
        headersMap.put("usertoken",accessToken);
        Map<String, String> authPaths = JsonReader.getMapTestData("path", "user_controller");
        Response userResponse =restApiHelper.makePostRequest(authPaths.get("user"), new JSONObject(requestBody), headersMap);
        String val = null;
        if(userResponse.getStatusCode() == 200) {
            JsonPath jsnPath = userResponse.jsonPath();
            val = (String) jsnPath.getString("userId");
        }
        tearDown();
        return val;
    }

    public void createProfileAPI(String userType, String userid) {
        String baseUrl = commonPaths.get("profile_ms");
        restApiHelper.setBaseURI(baseUrl);
        JSONObject obj = JsonReader.getJsonObject(userType, null);
        requestBody.putAll(MiscUtils.getFullUpdatedPayload(obj,"userid",userid));
        headersMap.put("usertoken",accessToken);
        Map<String, String> authPaths = JsonReader.getMapTestData("path", "profile_controller");
        Response userResponse =restApiHelper.makePostRequest(authPaths.get("profiles"), new JSONObject(requestBody), headersMap);
        tearDown();
    }

    public String getCompanyAPI(String companyName) {
        configureRestAssured();
        if(companyName != null)
            queryMaps.put("name", companyName);
        String baseUrl = commonPaths.get("company_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        Map<String, String> companyPaths = JsonReader.getMapTestData("path", "company_controller");
        restApiHelper.makeGetRequest(companyPaths.get("companies"),queryMaps, headersMap);
        Response companyResponse = restApiHelper.getResponse();
        String val = null;
        JsonPath jsnPath = companyResponse.jsonPath();
        if((Integer) jsnPath.getMap("pagination").get("count") != 0) {
            val = (String) jsnPath.getMap("data[0]").get("companyId");
        }
        tearDown();
        return val;
    }

    public void deleteCompanyAPI(String companyId) {
        configureRestAssured();
        String baseUrl = commonPaths.get("company_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        Map<String, String> companyPaths = JsonReader.getMapTestData("path", "company_controller");
        if(companyId != null)
            restApiHelper.makeDeleteRequest(companyPaths.get("companies")+"/"+companyId, headersMap);
        else
            Reporter.log("company id was null");
        Response profileResponse = restApiHelper.getResponse();
        tearDown();
    }

    public String getConveyorsAPI(String conveyorName) {
        configureRestAssured();
        if(conveyorName != null)
            queryMaps.put("name", conveyorName);
        String baseUrl = commonPaths.get("conveyor_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        Map<String, String> conveyorPaths = JsonReader.getMapTestData("path", "conveyor_controller");
        restApiHelper.makeGetRequest(conveyorPaths.get("conveyor"),queryMaps, headersMap);
        Response companyResponse = restApiHelper.getResponse();
        String val = null;
        JsonPath jsnPath = companyResponse.jsonPath();
        if((Integer) jsnPath.getMap("pagination").get("count") != 0) {
            val = (String) jsnPath.getMap("data[0]").get("conveyorId");
        }
        tearDown();
        return val;
    }

    public void deleteConveyorAPI(String conveyorId) {
        configureRestAssured();
        String baseUrl = commonPaths.get("conveyor_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        Map<String, String> companyPaths = JsonReader.getMapTestData("path", "conveyor_controller");
        if(conveyorId != null)
            restApiHelper.makeDeleteRequest(companyPaths.get("conveyor")+"/"+conveyorId, headersMap);
        else
            Reporter.log("conveyor id was null");
        Response profileResponse = restApiHelper.getResponse();
        tearDown();
    }

    public JSONObject getConveyorAPI(String conveyorId) {
        configureRestAssured();
        String baseUrl = commonPaths.get("conveyor_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        Map<String, String> companyPaths = JsonReader.getMapTestData("path", "conveyor_controller");
        if(conveyorId != null)
            restApiHelper.makeGetRequest(companyPaths.get("conveyor")+"/"+conveyorId,null, headersMap);
        else
            Reporter.log("conveyor id was null");
        Response profileResponse = restApiHelper.getResponse();
        tearDown();
        return profileResponse.getBody().as(JSONObject.class);
    }

    public void putConveyorAPI(String conveyorId, JSONObject payload, String newConveyorName) {
        configureRestAssured();
        String baseUrl = commonPaths.get("conveyor_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        Map<String, String> companyPaths = JsonReader.getMapTestData("path", "conveyor_controller");
        Reporter.log("payload: ="+MiscUtils.getSingleUpdatedPayload(payload,"name",newConveyorName));
        if(conveyorId != null)
            restApiHelper.makePutRequest(companyPaths.get("conveyor")+"/"+conveyorId, MiscUtils.getSingleUpdatedPayload(payload,"name",newConveyorName), headersMap);
        else
            Reporter.log("conveyor id was null");
        Response profileResponse = restApiHelper.getResponse();
        tearDown();
    }

    public void resendVerifyAPI(String email) {
        configureRestAssured();
        String baseUrl = commonPaths.get("user_ms");
        restApiHelper.setBaseURI(baseUrl);
        requestBody.put("email",email);
        headersMap.put("usertoken",accessToken);
        Map<String, String> authPaths = JsonReader.getMapTestData("path", "user_controller");
        Response verifyResponse =restApiHelper.makePostRequest(authPaths.get("verify"), new JSONObject(requestBody), headersMap);
        tearDown();
    }

    public int secretVerifyAPI(String email, String secret) {
        configureRestAssured();
        String baseUrl = commonPaths.get("user_ms");
        restApiHelper.setBaseURI(baseUrl);
        requestBody.put("email",email);
        requestBody.put("secret",secret);
        headersMap.put("usertoken",accessToken);
        Map<String, String> authPaths = JsonReader.getMapTestData("path", "user_controller");
        Response secretResponse =restApiHelper.makePostRequest(authPaths.get("secret"), new JSONObject(requestBody), headersMap);
        tearDown();
        return secretResponse.getStatusCode();
    }
}
