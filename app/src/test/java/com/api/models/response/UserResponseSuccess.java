package com.api.models.response;

import java.util.List;

public class UserResponseSuccess {
    private String userID;
    private String username;
    private List<Book> books;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "UserResponseSuccess{" +
                "userId='" + userID + '\'' +
                ", username='" + username + '\'' +
                ", books=" + books +
                '}';
    }
}
