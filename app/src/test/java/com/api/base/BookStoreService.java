package com.api.base;

import io.restassured.response.Response;

public class BookStoreService extends BaseService {

    private static final String BASE_PATH = "/BookStore/v1/";

    public Response getBooks() {
        return getRequest(BASE_PATH + "Books");
    }

    public Response getBook(String isbn) {
        return requestSpecification.queryParam("ISBN", isbn).get(BASE_PATH + "Book");
    }

    public Response updateBook() {
        return putRequest("",BASE_PATH + "Book");
    }
}
