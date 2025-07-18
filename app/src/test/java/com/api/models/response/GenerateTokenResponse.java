package com.api.models.response;

public class GenerateTokenResponse {

    private String token;
    private String expires;
    private String status;
    private String result;

    public GenerateTokenResponse(String token, String expires, String status, String result) {
        this.token = token;
        this.expires = expires;
        this.status = status;
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "GenerateTokenResponse{" +
                "token='" + token + '\'' +
                ", expires='" + expires + '\'' +
                ", status='" + status + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
