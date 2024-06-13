package com.common.utils;

import com.jayway.jsonpath.Configuration;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.DecimalFormat;
import java.util.*;

import static com.google.common.collect.Lists.newArrayList;
import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class APIBase {

    RestAPIHelper restApiHelper = new RestAPIHelper();
    Map<String, String> commonPaths;

    Map<String, String> headersMap = new HashMap<>();

    Map<String, String> queryMaps = new HashMap<>();
    Map<String, Object> requestBody = new HashMap<>();

    public static String accessToken;
    public static String refreshToken;

    public APIBase() {
        commonPaths = JsonReader.getMapTestData("service_url", getBundle().getString("env.setup"));
    }

    public void configureRestAssured() {
        System.out.println("Configuring RestAssured");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAPIHelper.configure();
        headersMap.put("appclientid",getBundle().getString("env.appId"));
//      queryMaps.put(CoreConnectionPNames.CONNECTION_TIMEOUT, 1000)
//      queryMaps.put(CoreConnectionPNames.SO_TIMEOUT, 1000));
    }

    public void tearDown() {
        System.out.println("Resetting base uri and path after method");
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

    public String getUserDataAPI(String email) {
        configureRestAssured();
        String baseUrl = commonPaths.get("user_ms");
        restApiHelper.setBaseURI(baseUrl);
        if(email != null)
            queryMaps.put("email", email);
        headersMap.put("usertoken",accessToken);
        Map<String, String> profilePaths = JsonReader.getMapTestData("path", "user_controller");
        restApiHelper.makeGetRequest(profilePaths.get("user"),queryMaps,headersMap);
        Response profileResponse = restApiHelper.getResponse();
        String val = null;
        if(profileResponse.getStatusCode() == 200) {
            JsonPath jsnPath = profileResponse.jsonPath();
            val = (String) jsnPath.getMap("data[0]").get("userId");
        }
        tearDown();
        return val;
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
            System.out.println("user id was null");
        tearDown();
    }

    public boolean getUserAPI(String userId) {
        configureRestAssured();
        String baseUrl = commonPaths.get("user_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("usertoken",accessToken);
        Map<String, String> userPaths = JsonReader.getMapTestData("path", "user_controller");
        if(userId != null)
            restApiHelper.makeGetRequest(userPaths.get("user")+"/"+userId,queryMaps ,headersMap);
        else
            System.out.println("user id was null");
        Response userResponse = restApiHelper.getResponse();
        boolean val = false;
        if(userResponse.getStatusCode() == 200) {
            JsonPath jsnPath = userResponse.jsonPath();
            val = (boolean) jsnPath.get("verified");
        }
        tearDown();
        return val;
    }

    public String createUserAPI(String email, String password, String phone, String username) {
        String baseUrl = commonPaths.get("user_ms");
        restApiHelper.setBaseURI(baseUrl);
        requestBody.put("email", email);
        requestBody.put("locale", "en-US");
        requestBody.put("password", password);
        requestBody.put("phone", "+91"+phone);
        requestBody.put("username", "CTP"+(Math.floor(Math.random() * 9000000000000L) + 1000000000000L));
        headersMap.put("usertoken",accessToken);
        headersMap.put("appclientid",getBundle().getString("env.appId"));
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

    public void createProfileAPI(String userType, String userid, String... corpType) {
        String baseUrl = commonPaths.get("profile_ms");
        restApiHelper.setBaseURI(baseUrl);
        JSONObject obj = JsonReader.getJsonTestData(userType);
        if(corpType.length != 0)
            obj = MiscUtils.getFullUpdatedPayload(obj,"corporateType",corpType[0]);
        requestBody.putAll(MiscUtils.getFullUpdatedPayload(obj,"userId",userid));
        headersMap.put("usertoken",accessToken);
        headersMap.put("appclientid",getBundle().getString("env.appId"));
        Map<String, String> authPaths = JsonReader.getMapTestData("path", "profile_controller");
        Response userResponse =restApiHelper.makePostRequest(authPaths.get("profile"), new JSONObject(requestBody), headersMap);
        tearDown();
    }

    public Response getCompanyAPI(String companyName) {
        configureRestAssured();
        if(companyName != null)
            queryMaps.put("name", companyName);
        String baseUrl = commonPaths.get("company_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        Map<String, String> companyPaths = JsonReader.getMapTestData("path", "company_controller");
        restApiHelper.makeGetRequest(companyPaths.get("companies"),queryMaps, headersMap);
        Response companyResponse = restApiHelper.getResponse();
//        String val = null;
//        JsonPath jsnPath = companyResponse.jsonPath();
//        if((Integer) jsnPath.getMap("pagination").get("count") != 0) {
//            val = (String) jsnPath.getMap("data[0]").get("companyId");
//        }
        tearDown();
//        return val;
        return companyResponse;
    }
    public String getCompanyID(Response res){
        String val = null;
        JsonPath jsnPath = res.jsonPath();
        if((Integer) jsnPath.getMap("pagination").get("count") != 0) {
            val = (String) jsnPath.getMap("data[0]").get("companyId");
        }
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
            System.out.println("company id was null");
        tearDown();
    }

    public String getConveyorsAPI(String conveyorName) {
        configureRestAssured();
//        if(conveyorName != null)
//            queryMaps.put("name", conveyorName);
//        String baseUrl = commonPaths.get("conveyor_ms");
//        restApiHelper.setBaseURI(baseUrl);
//        headersMap.put("user-token",accessToken);
//        Map<String, String> conveyorPaths = JsonReader.getMapTestData("path", "conveyor_controller");
//        restApiHelper.makeGetRequest(conveyorPaths.get("conveyor"),queryMaps, headersMap);
//        Response companyResponse = restApiHelper.getResponse();
        String val = null;
//        JsonPath jsnPath = companyResponse.jsonPath();
//        if((Integer) jsnPath.getMap("pagination").get("count") != 0) {
//            val = (String) jsnPath.getMap("data[0]").get("conveyorId");
//        }
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
            System.out.println("conveyor id was null");
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
            System.out.println("conveyor id was null");
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
        System.out.println("payload: ="+MiscUtils.getSingleUpdatedPayload(payload,"name",newConveyorName));
        if(conveyorId != null)
            restApiHelper.makePutRequest(companyPaths.get("conveyor")+"/"+conveyorId, MiscUtils.getSingleUpdatedPayload(payload,"name",newConveyorName), headersMap);
        else
            System.out.println("conveyor id was null");
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

    public String getInspectionAPI(String inspectionName) {
        configureRestAssured();
        String baseUrl = commonPaths.get("inspection_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        queryMaps.put("inspectionName",inspectionName);
        Map<String, String> inspectionPaths = JsonReader.getMapTestData("path", "inspection_controller");
        Response inspectionResponse =restApiHelper.makeGetRequest(inspectionPaths.get("inspection"),queryMaps , headersMap);
        String val = null;
        JsonPath jsnPath = inspectionResponse.jsonPath();
        if((Integer) jsnPath.getMap("pagination").get("count") != 0) {
            val = (String) jsnPath.getMap("data[0]").get("inspectionId");
        }
        tearDown();
        return val;
    }

    public void deleteInspectionAPI(String inspectionId) {
        configureRestAssured();
        Response inspectionResponse;
        String baseUrl = commonPaths.get("inspection_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        Map<String, String> inspectionPaths = JsonReader.getMapTestData("path", "inspection_controller");
        if(inspectionId != null)
            inspectionResponse =restApiHelper.makeDeleteRequest(inspectionPaths.get("inspection")+"/"+inspectionId , headersMap);
        else
            System.out.println("inspection id was null");
        tearDown();
    }

    public Response getFilesListAPI(String type, String relatedId) {
        configureRestAssured();
        String baseUrl = commonPaths.get("file_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        queryMaps.put("relatedToType",type);
        queryMaps.put("relatedToId",relatedId);
        Map<String, String> filePaths = JsonReader.getMapTestData("path", "file_controller");
        Response fileManagerResponse =restApiHelper.makeGetRequest(filePaths.get("files"),queryMaps , headersMap);
        return fileManagerResponse;
    }

    public ArrayList<String> getRootFileID(Response res){
        ArrayList<String> val = new ArrayList<>();
        JsonPath jsnPath = res.jsonPath();
        int count = (Integer) jsnPath.getMap("pagination").get("count");
        if((Integer) jsnPath.getMap("pagination").get("count") != 0) {
            for(int i = 0; i<count; i++)
                val.add((String) jsnPath.getMap("data["+i+"]").get("fileId"));
        }
        return val;
    }

    public ArrayList<String> getMetaFileID(Response res){
        ArrayList<String> val = new ArrayList<>();
        JsonPath jsnPath = res.jsonPath();
        int count = (Integer) jsnPath.getMap("pagination").get("count");
        if((Integer) jsnPath.getMap("pagination").get("count") != 0) {
            for(int i = 0; i<count; i++)
                val.add(((HashMap<String, String>)jsnPath.getMap("data["+i+"]").get("fileMetaData")).get("fileId"));
        }
        return val;
    }

    public void deleteFilesAPI(String fileId) {
        configureRestAssured();
        Response fileResponse;
        String baseUrl = commonPaths.get("file_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        Map<String, String> filePaths = JsonReader.getMapTestData("path", "file_controller");
        if(fileId != null)
            fileResponse =restApiHelper.makeDeleteRequest(filePaths.get("files")+"/"+fileId , headersMap);
        else
            System.out.println("inspection id was null");
        tearDown();
    }

    public Response getUltrasonicAPI(String conveyorId) {
        configureRestAssured();
        if(conveyorId != null)
            queryMaps.put("conveyor.conveyorId", conveyorId);
        String baseUrl = commonPaths.get("ultrasonic_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        Map<String, String> ultrasonicsPaths = JsonReader.getMapTestData("path", "ultrasonic_controller");
        restApiHelper.makeGetRequest(ultrasonicsPaths.get("ultrasonics"),queryMaps, headersMap);
        Response ultrasonicResponse = restApiHelper.getResponse();
        tearDown();
        return ultrasonicResponse;
    }

    public String getUltrasonicId(Response res){
        JsonPath jsnPath = res.jsonPath();
        String val = null;
        if((Integer) jsnPath.getMap("pagination").get("count") != 0) {
            val = (String) jsnPath.getMap("data[0]").get("ultrasonicId");
        }
        return val;
    }

    public long getMinCalculatedDurometer(Response res) throws ParseException {
        JsonPath jsnPath = res.jsonPath();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(res.getBody().asString());
        if((Integer) jsnPath.getMap("pagination").get("count") != 0) {

            List<Long> durometerList = com.jayway.jsonpath.JsonPath
                    .using(Configuration.defaultConfiguration())
                    .parse(json)
                    .read("$..positions..calculatedDurometer", List.class);
            long min = durometerList.stream().mapToLong(v -> Long.parseLong(String.valueOf(v))).min().getAsLong();
            return min;
        }
        return 0;
    }

    public double getMinPercentage(Response res) throws ParseException {
        JsonPath jsnPath = res.jsonPath();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(res.getBody().asString());
        if((Integer) jsnPath.getMap("pagination").get("count") != 0) {

            List<Double> PercentageList = com.jayway.jsonpath.JsonPath
                    .using(Configuration.defaultConfiguration())
                    .parse(json)
                    .read("$..positions..percentage", List.class);
            double min = PercentageList.stream().mapToDouble(v -> (int)Double.parseDouble(String.valueOf(v))).min().orElse(0D);
            return min;
        }
        return 0;
    }

    public double getMinEstimatedTime(Response res) throws ParseException {
        JsonPath jsnPath = res.jsonPath();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(res.getBody().asString());
        if((Integer) jsnPath.getMap("pagination").get("count") != 0) {

            List<Double> EstimatedTimeList = com.jayway.jsonpath.JsonPath
                    .using(Configuration.defaultConfiguration())
                    .parse(json)
                    .read("$..positions..estimatedTime", List.class);
            double min = EstimatedTimeList.stream().mapToDouble(v -> Double.parseDouble(String.valueOf(v))).min().orElse(0D);
            return Double.parseDouble(new DecimalFormat("##.#").format(min/12));
        }
        return 0;
    }

    public void deleteUltrasonicAPI(String ultrasonicId) {
        configureRestAssured();
        Response ultrasonicResponse;
        String baseUrl = commonPaths.get("ultrasonic_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        Map<String, String> inspectionPaths = JsonReader.getMapTestData("path", "ultrasonic_controller");
        if(ultrasonicId != null)
            ultrasonicResponse =restApiHelper.makeDeleteRequest(inspectionPaths.get("ultrasonics")+"/"+ultrasonicId , headersMap);
        else
            System.out.println("ultrasonic id was null");
        tearDown();
    }

    public String createCustomerCorpAPI(String fileName) {
        String baseUrl = commonPaths.get("company_ms");
        restApiHelper.setBaseURI(baseUrl);
        JSONObject obj = JsonReader.loadJsonFile(ClasspathResourceHelper.getPropertyFileByLocale(fileName, ClasspathResourceHelper.FileType.JSON, "test_data"));
        System.out.println(obj);
        requestBody.putAll(obj);
        headersMap.put("user-token",accessToken);
        Map<String, String> companyPaths = JsonReader.getMapTestData("path", "company_controller");
        Response companyResponse =restApiHelper.makePostRequest(companyPaths.get("companies"), new JSONObject(requestBody), headersMap);
        String val = null;
        if(companyResponse.getStatusCode() == 201) {
            JsonPath jsnPath = companyResponse.jsonPath();
            val = (String) jsnPath.get("companyId");
        }
        tearDown();
        return val;
    }

    public String createCustomerSiteAPI(String fileName, String companyId) {
        String baseUrl = commonPaths.get("company_ms");
        restApiHelper.setBaseURI(baseUrl);
        JSONObject obj = JsonReader.loadJsonFile(ClasspathResourceHelper.getPropertyFileByLocale(fileName, ClasspathResourceHelper.FileType.JSON, "test_data"));
        System.out.println(obj.toJSONString());
        requestBody.putAll(MiscUtils.getSingleUpdatedPayload(obj,"customerCorporate.companyId",companyId));
        headersMap.put("user-token",accessToken);
        Map<String, String> companyPaths = JsonReader.getMapTestData("path", "company_controller");
        Response companyResponse =restApiHelper.makePostRequest(companyPaths.get("companies"), new JSONObject(requestBody), headersMap);
        String val = null;
        if(companyResponse.getStatusCode() == 201) {
            JsonPath jsnPath = companyResponse.jsonPath();
            val = (String) jsnPath.get("companyId");
        }
        tearDown();
        return val;
    }

    public void createConveyorAPI(String fileName, String companyId, String siteCompanyId, String... conveyorName) {
        String baseUrl = commonPaths.get("conveyor_ms");
        restApiHelper.setBaseURI(baseUrl);
        JSONObject obj = JsonReader.loadJsonFile(ClasspathResourceHelper.getPropertyFileByLocale(fileName, ClasspathResourceHelper.FileType.JSON, "test_data"));
        requestBody.putAll(MiscUtils.getSingleUpdatedPayload(obj,"customer.customerCorporate.companyId",companyId));
        requestBody.putAll(MiscUtils.getSingleUpdatedPayload(obj,"customer.companyId",siteCompanyId));
        if(conveyorName.length != 0)
            requestBody.putAll(MiscUtils.getSingleUpdatedPayload(obj,"name", conveyorName[0]));
        headersMap.put("user-token",accessToken);
        Map<String, String> conveyorPaths = JsonReader.getMapTestData("path", "conveyor_controller");
        Response conveyorResponse =restApiHelper.makePostRequest(conveyorPaths.get("conveyor"), new JSONObject(requestBody), headersMap);
        tearDown();
    }

    public String getPreferenceAPI(String userId, String tableName) {
        configureRestAssured();
        String baseUrl = commonPaths.get("user_preference_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        Map<String, String> preferencePaths = JsonReader.getMapTestData("path", "preference_controller");
        if(userId != null)
            restApiHelper.makeGetRequest(preferencePaths.get("preference")+"/"+userId,queryMaps ,headersMap);
        else
            System.out.println("user id was null");
        Response userResponse = restApiHelper.getResponse();
        ArrayList<HashMap<Object,Object>> stats;
        String val = null;
        if(userResponse.getStatusCode() == 200) {
            JsonPath jsnPath = userResponse.jsonPath();
            stats = (ArrayList<HashMap<Object,Object>>) jsnPath.getJsonObject("data");
            for(HashMap<Object,Object>statsObject:stats){
                System.out.println(((HashMap<String,Object>)(statsObject.get("preferences"))).get("tableName"));
                System.out.println(tableName);
                if(((HashMap<String,Object>)(statsObject.get("preferences"))).containsKey("tableName") && ((String)((HashMap<String,Object>)(statsObject.get("preferences"))).get("tableName")).equalsIgnoreCase(tableName)){
                    val= ((String)((HashMap<String,Object>)(statsObject.get("preferences"))).get("preferenceId"));
                }
            }
        }
        tearDown();
        return val;
    }

    public void deletePreferencesAPI(String userID, String prefID) {
        configureRestAssured();
        Response preferenceResponse;
        String baseUrl = commonPaths.get("user_preference_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        Map<String, String> inspectionPaths = JsonReader.getMapTestData("path", "preference_controller");
        if(userID != null && prefID!= null)
            preferenceResponse =restApiHelper.makeDeleteRequest(inspectionPaths.get("preference")+"/"+userID+"/"+prefID , headersMap);
        else
            System.out.println("Pref id was null");
        tearDown();
    }

    public HashMap<String, Object> getFindingsAPI(String conveyorID) {
        configureRestAssured();
        String baseUrl = commonPaths.get("inspection_findings_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        queryMaps.put("conveyorId",conveyorID);
        queryMaps.put("limit","1000");
        Map<String, String> inspectionFindingPaths = JsonReader.getMapTestData("path", "findings_controller");
        Response inspectionResponse =restApiHelper.makeGetRequest(inspectionFindingPaths.get("finding"),queryMaps , headersMap);
        HashMap<String, Object> val = new HashMap<>();
        JsonPath jsnPath = inspectionResponse.jsonPath();
        int count = (Integer) jsnPath.getMap("pagination").get("count")-1;
        System.out.println("count= "+count);
        if((Integer) jsnPath.getMap("pagination").get("count") != 0) {
            for (int i = count; i>0 ; i--) {
                if (((ArrayList<HashMap<String, String>>) jsnPath.getMap("data[" + i + "]").get("findings")).size() != 0) {
                    System.out.println(jsnPath.getMap("data["+i+"]").get("findings"));
                    val.put("status", ((HashMap<String, String>) ((ArrayList<HashMap<String, String>>) jsnPath.getMap("data[" + i + "]").get("findings")).get(0)).get("status"));
                    val.put("distance", ((HashMap<String, String>) ((ArrayList<HashMap<String, String>>) jsnPath.getMap("data[" + i + "]").get("findings")).get(0)).get("distanceFromBeginning"));
                    val.put("inspectionDate", ((HashMap<String, String>) ((ArrayList<HashMap<String, String>>) jsnPath.getMap("data[" + i + "]").get("findings")).get(0)).get("inspectionDate"));
                    val.put("name", ((HashMap<String, String>) ((ArrayList<HashMap<String, String>>) jsnPath.getMap("data[" + i + "]").get("findings")).get(0)).get("name"));
                    val.put("idler_temp", ((HashMap<String, HashMap<String, String>>) ((ArrayList<HashMap<String, HashMap<String, String>>>) jsnPath.getMap("data[" + i + "]").get("findings")).get(0)).get("observation").get("idlerTemperature"));
                    val.put("env_temp", ((HashMap<String, HashMap<String, String>>) ((ArrayList<HashMap<String, HashMap<String, String>>>) jsnPath.getMap("data[" + i + "]").get("findings")).get(0)).get("observation").get("environmentalTemperature"));
                    val.put("long", ((HashMap<String, HashMap<String, String>>) ((ArrayList<HashMap<String, HashMap<String, String>>>) jsnPath.getMap("data[" + i + "]").get("findings")).get(0)).get("geoLocation").get("longitude"));
                    val.put("lat", ((HashMap<String, HashMap<String, String>>) ((ArrayList<HashMap<String, HashMap<String, String>>>) jsnPath.getMap("data[" + i + "]").get("findings")).get(0)).get("geoLocation").get("latitude"));
                    break;
                }
            }
        }
        tearDown();
        return val;
    }

    public String getMinutemanAPI(String minutemanName) {
        configureRestAssured();
        String baseUrl = commonPaths.get("minuteman_ms");
        restApiHelper.setBaseURI(baseUrl);
        headersMap.put("user-token",accessToken);
        queryMaps.put("name",minutemanName);
        Map<String, String> inspectionPaths = JsonReader.getMapTestData("path", "minuteman_controller");
        Response inspectionResponse =restApiHelper.makeGetRequest(inspectionPaths.get("minuteman"),queryMaps , headersMap);
        String val = null;
        JsonPath jsnPath = inspectionResponse.jsonPath();
        if((Integer) jsnPath.getMap("pagination").get("count") != 0) {
            val = (String) jsnPath.getMap("data[0]").get("minutemanId");
        }
        tearDown();
        return val;
    }
}
