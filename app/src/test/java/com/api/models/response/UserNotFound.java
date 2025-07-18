package com.api.models.response;

public class UserNotFound {
    private String code;
    private String message;

    public UserNotFound(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserNotFound{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
