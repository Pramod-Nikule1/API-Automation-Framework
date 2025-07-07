package com.api.base;

import com.api.listeners.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    public static final String BASE_URL = "https://demoqa.com";
    protected RequestSpecification requestSpecification;

    {
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService() {
        requestSpecification = RestAssured.given().baseUri(BASE_URL);
    }

    public void setAuthToken(String authToken) {
        requestSpecification.auth().oauth2("");
    }

    public Response getRequest(String endpoint) {
        return requestSpecification.get(endpoint);
    }

    public Response postRequest(Object payload, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }

    public Response putRequest(Object payload, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }
}
