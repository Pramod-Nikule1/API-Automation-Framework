package com.api.tests;

import com.api.base.AccountService;
import com.api.base.TestBase;
import com.api.models.request.Credentials;
import com.api.models.response.GenerateTokenResponse;
import com.api.models.response.UserNotFound;
import com.api.models.response.ResponseError;
import com.api.models.response.UserResponseSuccess;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class AccountServiceTest extends TestBase {

    private String username;

    @Test
    public void testAuthorizedWithValidUser() {
        Credentials credentials = new Credentials.Builder()
                .userName(properties.getProperty("username"))
                .password(properties.getProperty("password"))
                .build();
        Response response = new AccountService().authorized(credentials);
        Assert.assertTrue(response.getContentType().contains(ContentType.JSON.toString()));
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(Boolean.parseBoolean(response.getBody().asString()));
    }

    @Test
    public void testAuthorizedWithInvalidUser() {
        Response response = new AccountService().authorized(new Credentials(properties.getProperty("username") + "11", properties.getProperty("password")));
        Assert.assertTrue(response.getContentType().contains(ContentType.JSON.toString()));
        Assert.assertEquals(response.getStatusCode(), 404);
        UserNotFound userNotFound = response.as(UserNotFound.class);
        Assert.assertEquals(userNotFound.getCode(), "1207");
        Assert.assertEquals(userNotFound.getMessage(), "User not found!");
    }

    @Test
    public void testGenerateTokenValidUser() {
        Credentials credentials = new Credentials.Builder()
                .userName(properties.getProperty("username"))
                .password(properties.getProperty("password"))
                .build();
        Response response = new AccountService().generateToken(credentials);
        Assert.assertTrue(response.getContentType().contains(ContentType.JSON.toString()));
        Assert.assertEquals(response.getStatusCode(), 200);
        GenerateTokenResponse generateTokenResponse = response.as(GenerateTokenResponse.class);
        Assert.assertNotNull(generateTokenResponse.getToken());
        Assert.assertNotNull(generateTokenResponse.getExpires());
        Assert.assertEquals(generateTokenResponse.getStatus(), "Success");
        Assert.assertEquals(generateTokenResponse.getResult(), "User authorized successfully.");
    }

    @Test
    public void testGenerateTokenInvalidUser() {
        Response response = new AccountService().generateToken(new Credentials(properties.getProperty("username") + 11, properties.getProperty("password")));
        Assert.assertTrue(response.getContentType().contains(ContentType.JSON.toString()));
        Assert.assertEquals(response.getStatusCode(), 200);
        GenerateTokenResponse generateTokenResponse = response.as(GenerateTokenResponse.class);
        Assert.assertNull(generateTokenResponse.getToken());
        Assert.assertNull(generateTokenResponse.getExpires());
        Assert.assertEquals(generateTokenResponse.getStatus(), "Failed");
        Assert.assertEquals(generateTokenResponse.getResult(), "User authorization failed.");
    }

    @Test
    public void testCreateUser() {
        username = properties.getProperty("username")+(Math.random() * 100);
        Credentials credentials = new Credentials.Builder()
                .userName(username)
                .password(properties.getProperty("password"))
                .build();
        Response response = new AccountService().user(credentials);
        Assert.assertTrue(response.getContentType().contains(ContentType.JSON.toString()));
        Assert.assertEquals(response.getStatusCode(), 201);
        UserResponseSuccess responseSuccess = response.as(UserResponseSuccess.class);
        Assert.assertEquals(responseSuccess.getUsername(), username);
        Assert.assertNotNull(responseSuccess.getUserID());
    }

    @Test(dependsOnMethods = "testCreateUser")
    public void testCreateExistingUser() {
        Credentials credentials = new Credentials.Builder()
                .userName(username)
                .password(properties.getProperty("password"))
                .build();
        Response response = new AccountService().user(credentials);
        Assert.assertTrue(response.getContentType().contains(ContentType.JSON.toString()));
        Assert.assertEquals(response.getStatusCode(), 406);
        ResponseError responseError = response.as(ResponseError.class);
        Assert.assertEquals(responseError.getCode(), "1204");
        Assert.assertEquals(responseError.getMessage(), "User exists");
    }
}
