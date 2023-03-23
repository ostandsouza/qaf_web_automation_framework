package com.common.utils;

import com.qmetry.qaf.automation.util.Reporter;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class RestAPIHelper {
    private RequestSpecification requestSpec;
    private Map<String, String> queryParams;
    private Map<String, String> headers;
    //to store OAUTH2 token after generation
    private String oauth2Token;

    public static void configure() {
        Reporter.log("Configuring request/response logging");
    }
    /**
     * Getters and setters for oauth2Token
     *
     */

    public String getOauth2Token() {
        return this.oauth2Token;
    }

    public void setOauth2Token(String oauth2Token) {
        this.oauth2Token = oauth2Token;
    }

    /**
     * Sets Base URI. Before starting the test, we should set the
     * RestAssured.baseURI
     *
     * @param baseURI
     */
    public void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    /**
     * Resets Base URI. After the test, we should reset the RestAssured.baseURI
     */
    public void resetBaseURI() {
        RestAssured.baseURI = RestAssured.DEFAULT_URI;
    }

    /*
     * Sets base path. Before starting the test, we should set the
     * RestAssured.basePath
     *
     * @param basePathTerm
     */
    public void setBasePath(String basePath) {
        RestAssured.basePath = basePath;
    }

    /*
     * Resets base path. After the test, we should reset the RestAssured.basePath
     */
    public void resetBasePath() {
        RestAssured.basePath = RestAssured.DEFAULT_PATH;
    }

    /**
     * Prepares new rest assured for new request
     *
     * @param basePath
     */
    public RequestSpecification newRequest(String basePath) {
        setBasePath(basePath);
        requestSpec = RestAssured.given();
        queryParams = new HashMap<>();
        headers = new HashMap<>();

        return requestSpec;
    }

    /**
     * Delete the request
     *
     *
     * @return response
     */

    public Response deleteRequest() {
        Response response = null;
        if (requestSpec == null) {
            response = RestAssured.when().delete();
        } else {
            response = requestSpec.when().delete();
        }

        if (response != null) {
            response = response.then().extract().response();
        }

        return response;
    }

    /**
     * Get the response of RequestSpecification using PUT method
     *
     * @return response
     */

    public Response putRequest() {
        Response response = null;
        if (requestSpec == null) {
            response = RestAssured.when().put();
        } else {
            response = requestSpec.when().put();
        }
        if (response != null) {
            response = response.then().extract().response();
        }
        return response;
    }

    public RequestSpecification disableContentCharSet() {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }

        EncoderConfig encoderconfig = new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false);
        requestSpec.config(RestAssured.config().encoderConfig(encoderconfig));

        return requestSpec;
    }

    /**
     * Set the GET query parameters using Map
     *
     * @param queryMaps
     */
    @SafeVarargs
    public final RequestSpecification setQueryParameters(Map<String, String>... queryMaps) {
        for (Map<String, String> queryMap : queryMaps)
            queryParams.putAll(queryMap);

        if (requestSpec == null)
            requestSpec = RestAssured.given();

        requestSpec = requestSpec.queryParams(queryParams);
        return requestSpec;
    }

    /**
     * Set the Headers parameters using Map
     *
     * @param headersMap
     */
    public RequestSpecification setHeaders(Map<String, String> headersMap) {
        headers = headersMap;
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        requestSpec = requestSpec.headers(headers);

        return requestSpec;
    }

    /**
     * Get the response of RequestSpecification using GET method
     *
     * @return Response
     */
    public Response getResponse() {
        return getResponse("");
    }

    /**
     * Get the response of RequestSpecification using GET method
     *
     * @return Response
     */
    public Response getResponse(String path) {
        Response response = null;
        if (requestSpec == null) {
            response = RestAssured.get(path);
        } else {
            response = requestSpec.get(path);
        }

        return response;
    }

    /**
     * Get the response with headers and query Params
     *
     * @param headers
     * @param queryParams
     * @return
     */
    @SuppressWarnings("unchecked")
    public Response getResponse(Map<String, String> headers, Map<String, String>... queryParams) {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        setHeaders(headers);
        setQueryParameters(queryParams);
        Response response = getResponse();
        return response;
    }

    /* Get the response with headers */
    /**
     * @param headers
     * @param query
     * @return
     */
    public Response getResponse(Map<String, String> headers, Map<String, String> query) {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        setHeaders(headers);
        setQueryParameters(query);
        Response response = getResponse();
        return response;
    }

    public Response postRequest() {
        Response response = null;
        if (requestSpec == null) {
            response = RestAssured.when().post();
        } else {
            response = requestSpec.when().post();
        }

        if (response != null) {
            response = response.then().extract().response();
        }

        return response;
    }

    /**
     * Patch request
     *
     *
     * @return response
     */
    public Response patchRequest() {
        Response response = null;
        if (requestSpec == null) {
            response = RestAssured.when().patch();
        } else {
            response = requestSpec.when().patch();
        }

        if (response != null) {
            response = response.then().extract().response();
        }

        return response;
    }

    /**
     * Get the response of RequestSpecification using POST method
     *
     * @param requestBody
     * @return Response
     */
    public Response postJson(JSONObject requestBody) {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        requestSpec = requestSpec.contentType(ContentType.JSON).body(requestBody);
        Response response = postRequest();
        return response;
    }

    /**
     * Get the response of RequestSpecification using PUT method
     *
     * @param requestBody
     * @return Response
     */
    public Response putJson(JSONObject requestBody) {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        requestSpec = requestSpec.contentType(ContentType.JSON).body(requestBody);
        Response response = putRequest();
        return response;
    }

    /**
     * @param file
     * @return
     */
    public Response postJsonMultipart(File file) {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        requestSpec = requestSpec.multiPart("multipartFile", file, "application/json");
        Response response = postRequest();
        return response;
    }

    /**
     * This method is used for post request with valid headers
     *
     * @param headers
     * @param requestBody
     * @return
     */
    public Response postJson(Map<String, String> headers, JSONObject requestBody) {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        setHeaders(headers);
        Response response = postJson(requestBody);
        return response;
    }

    /**
     * Use this API to generate OAuth token. Make sure to setBaseURI and setBasePath
     * before calling this.
     *
     * @param username
     * @param password
     * @param clientID
     * @param clientSecret
     * @return accessToken
     */
    public String generateToken(String username, String password, String clientID, String clientSecret) {
        return generateToken("", username, password, clientID, clientSecret);
    }

    /**
     * Use this API to generate OAuth token.
     *
     * @param url
     * @param username
     * @param password
     * @param clientID
     * @param clientSecret
     * @return accessToken
     */
    public String generateToken(String url, String username, String password, String clientID, String clientSecret) {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        Response response = requestSpec.auth().preemptive().basic(clientID, clientSecret).contentType(ContentType.URLENC)
                .formParam("grant_type", "password").formParam("username", username).formParam("password", password).when().post(url);
        String accessToken = response.jsonPath().getString("access_token");
        return accessToken;
    }

    /**
     * Use this API to generate OAuth token using client_credentials grant type.
     *
     * @param url
     * @param clientID
     * @param clientSecret
     * @return accessToken
     */
    public String generateTokenUsingClientCredentials(String url, String clientID, String clientSecret) {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        Response response = requestSpec.auth().preemptive().basic(clientID, clientSecret).contentType(ContentType.URLENC)
                .formParam("grant_type", "client_credentials").post(url);
        String accessToken = response.jsonPath().getString("access_token");
        return accessToken;
    }

    /**
     * This get request will be used for Oauth 2.0
     *
     * @param oauthToken
     * @return Response
     */
    public Response getResponseWithOauth2(String oauthToken) {
        return getResponseWithOauth2(oauthToken, "");
    }

    /**
     * This get request will be used for Oauth 2.0
     *
     * @param oauthToken
     * @param path
     * @return Response
     */
    public Response getResponseWithOauth2(String oauthToken, String path) {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        Response response = requestSpec.auth().oauth2(oauthToken).when().get(path).then().extract().response();
        return response;
    }

    /**
     * This method is used for post request with valid headers
     *
     * @param RESTVerb
     * @return
     */
    public Response makeRequest(String RESTVerb) {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        Response response = null;

        switch (RESTVerb.toUpperCase()) {
            case "GET":
                response = getResponse();
                break;
            case "PUT":
                response = putRequest();
                break;
            case "POST":
                response = postRequest();
                break;
            case "DELETE":
                response = deleteRequest();
                break;
        }
        return response;
    }
    /**
     * wrapper for POST request with OAUTH2 (without body/payload)
     *
     * @param path
     * @return response - Restassured response
     */
    public Response postRequestWithOauth2(String path) {
        return postRequestWithOauth2(path, getOauth2Token());
    }

    /**
     * POST request with OAUTH2 (without body/payload)
     *
     * @param path
     * @param oauth2Token
     * @return response - Restassured response
     */
    public Response postRequestWithOauth2(String path, String oauth2Token) {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        requestSpec = requestSpec.auth().oauth2(oauth2Token).contentType(ContentType.JSON);
        Response response = postRequest(path);
        return response;
    }


    /**
     * wrapper for POST request with OAUTH2
     * @param requestBody - string / JsonObject
     * @param path
     * @return response - Restassured response
     */
    public Response postRequestWithOauth2(Object requestBody, String path) {
        return postRequestWithOauth2(requestBody, path, getOauth2Token());
    }

    /**
     * POST request with OAUTH2
     *
     * @param requestBody - string / JsonObject
     * @param path
     * @param oauth2Token
     * @return response - Restassured response
     */
    public Response postRequestWithOauth2(Object requestBody, String path, String oauth2Token) {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        requestSpec = requestSpec.auth().oauth2(oauth2Token).contentType(ContentType.JSON).body(requestBody.toString());
        Response response = postRequest(path);
        return response;
    }

    /**
     * wrapper for GET request with oauth2Token
     *
     * @param path
     * @return response
     */

    public Response getResponseWithOauth(String path) {
        return getResponseWithOauth2(getOauth2Token(), path);
    }
    /**
     * POST request with path
     *
     * @param path
     * @return response
     */

    public Response postRequest(String path) {
        Response response = null;
        if (requestSpec == null) {
            response = RestAssured.when().post(path);
        } else {
            response = requestSpec.when().post(path);
        }

        if (response != null) {
            response = response.then().extract().response();
        }

        return response;
    }

    /**
     * wrapper for PUT request with OAUTH2
     * @param requestBody - string / JsonObject / JSONArray
     * @param path - String
     * @return response - Restassured response
     */
    public Response putRequestWithOauth2(Object requestBody, String path) {
        return putRequestWithOauth2(requestBody, path, getOauth2Token());
    }

    /**
     * PUT request with OAUTH2
     *
     * @param requestBody - string / JsonObject / JSONArray
     * @param path - String
     * @param oauth2Token - String
     * @return response - Restassured response
     */
    public Response putRequestWithOauth2(Object requestBody, String path, String oauth2Token) {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        requestSpec = requestSpec.auth().oauth2(oauth2Token).contentType(ContentType.JSON).body(requestBody.toString());
        Response response = putRequest(path);
        return response;
    }
    /**
     * PUT request with path
     *
     * @param path - String
     * @return response
     */

    public Response putRequest(String path) {
        Response response = null;
        if (requestSpec == null) {
            response = RestAssured.when().put(path);
        } else {
            response = requestSpec.when().put(path);
        }

        if (response != null) {
            response = response.then().extract().response();
        }

        return response;
    }

    /**
     * wrapper for DELETE request with OAUTH2
     * @param path - String
     * @return response - Restassured response
     */
    public Response deleteRequestWithOauth2(String path) {
        return deleteRequestWithOauth2(path, getOauth2Token());
    }

    /**
     * DELETE request with OAUTH2
     * @param path - String
     * @param oauth2Token - String
     * @return response - Restassured response
     */
    public Response deleteRequestWithOauth2(String path, String oauth2Token) {
        if (requestSpec == null) {
            requestSpec = RestAssured.given();
        }
        requestSpec = requestSpec.auth().oauth2(oauth2Token).contentType(ContentType.JSON);
        Response response = deleteRequest(path);
        return response;
    }

    /**
     * DELETE request with path/URI
     *
     * @param path - String
     * @return response
     */

    public Response deleteRequest(String path) {
        Response response = null;
        if (requestSpec == null) {
            response = RestAssured.when().delete(path);
        } else {
            response = requestSpec.when().delete(path);
        }

        if (response != null) {
            response = response.then().extract().response();
        }

        return response;
    }

    /**
     * Makes a POST request with specified request body and request params
     *
     * @param basePath
     * @param requestBody
     * @param headerParams
     * @return response
     */
    protected Response makePostRequest(String basePath, JSONObject requestBody, Map<String, ? extends Object> headerParams) {
        // Get new RestAssured request using request path
        RequestSpecification newRequest = newRequest(basePath);
        disableContentCharSet();
        newRequest.contentType(ContentType.JSON).log();

        // set query string/body/params
        if (headerParams != null) {
            newRequest.headers(headerParams);
        }

        // Make a GET/POST request and get a response
        Response response;
        if (requestBody != null) {
            response = postJson(requestBody);
        } else {
            response = postRequest();
        }

        return response;
    }

    /**
     * Makes a GET request with specified params after removing params specified
     *
     * @param basePath
     * @param requestParams
     * @param headerParams
     * @return response
     */
    protected Response makeGetRequest(String basePath, Map<String, ? extends Object> requestParams, Map<String, ? extends Object> headerParams) {
        // Get new RestAssured request using request path
        RequestSpecification newRequest = newRequest(basePath);
        disableContentCharSet();
        newRequest.contentType(ContentType.JSON).log();

        // set query string/body/params
        if (headerParams != null) {
            newRequest.headers(headerParams);
        }

        if (requestParams != null) {
            newRequest.queryParams(requestParams);
        }

        // Make a GET/POST request and get a response
        Response response = getResponse();

        return response;
    }

    /**
     * Makes a GET request with specified request params
     *
     * @param basePath
     * @param requestParams
     * @return response
     */
    protected Response makeGetRequest(String basePath, Map<String, ? extends Object> requestParams) {
        return makeGetRequest(basePath, requestParams, null);
    }

    /**
     * Makes a POST request with specified request body and request params
     *
     * @param basePath
     * @param headerParams
     * @return response
     */
    protected Response makeDeleteRequest(String basePath, Map<String, ? extends Object> headerParams) {
        // Get new RestAssured request using request path
        RequestSpecification newRequest = newRequest(basePath);
        disableContentCharSet();
        newRequest.contentType(ContentType.JSON).log();

        // set query string/body/params
        if (headerParams != null) {
            newRequest.headers(headerParams);
        }

        // Make a GET/POST request and get a response
        Response response = deleteRequest();

        return response;
    }

    /**
     * Makes a POST request with specified request body and request params
     *
     * @param basePath
     * @param requestBody
     * @param headerParams
     * @return response
     */
    protected Response makePutRequest(String basePath, JSONObject requestBody, Map<String, ? extends Object> headerParams) {
        // Get new RestAssured request using request path
        RequestSpecification newRequest = newRequest(basePath);
        disableContentCharSet();
        newRequest.contentType(ContentType.JSON).log();

        // set query string/body/params
        if (headerParams != null) {
            newRequest.headers(headerParams);
        }

        // Make a GET/POST request and get a response
        Response response;
        if (requestBody != null) {
            response = putJson(requestBody);
        } else {
            response = putRequest();
        }

        return response;
    }
}