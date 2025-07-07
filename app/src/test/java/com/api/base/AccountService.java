package com.api.base;

import com.api.models.request.Credentials;
import io.restassured.response.Response;

public class AccountService extends BaseService {

    private static final String BASE_PATH = "/Account/v1/";

    public Response authorized(Credentials payload) {
        return postRequest(payload, BASE_PATH + "Authorized");
    }

    public Response generateToken(Credentials payload) {
        return postRequest(payload, BASE_PATH + "GenerateToken");
    }

    public Response user(Credentials payload) {
        return postRequest(payload, BASE_PATH + "User");
    }
}
