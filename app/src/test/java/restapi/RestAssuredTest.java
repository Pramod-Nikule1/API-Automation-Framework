package restapi;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredTest {

    @Test
    public void getRequestWithNoParamsTest() {
        String baseUrl = "https://demoqa.com/BookStore/v1/Books";
        Response response = RestAssured.given()
                .when().get(baseUrl)
                .then().statusCode(200).extract().response();
        Headers headers = response.getHeaders();
        Assert.assertEquals(response.getStatusCode(), 200);
        String responseBody = response.getBody().toString();
    }

    @Test
    public void getRequestWithParamTest() {
        String baseUrl = "https://demoqa.com/BookStore/v1/Book";
        Response response = RestAssured.given().queryParam("ISBN", "9781449337711")
                .when().get(baseUrl)
                .then().statusCode(200).extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
        String responseBody = response.getBody().toString();
    }
}

