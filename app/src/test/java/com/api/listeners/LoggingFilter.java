package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        // Log the request details
        logRequest(requestSpec);

        // Proceed with the request and get the response
        Response response = ctx.next(requestSpec, responseSpec);

        // Log the response details
        logResponse(response);
        return response;
    }   

    public void logRequest(FilterableRequestSpecification requestSpec) {
        logger.info("Request: " + requestSpec.getMethod() + " " + requestSpec.getURI());
        logger.info("Request Headers: " + requestSpec.getHeaders());
        logger.info("Request Body: " + requestSpec.getBody());
    }

    public void logResponse(Response response) {
        logger.info("Response Status: " + response.getStatusCode());
        logger.info("Response Headers: " + response.getHeaders());
        logger.info("Response Body: " + response.getBody().asPrettyString());
    }
}
