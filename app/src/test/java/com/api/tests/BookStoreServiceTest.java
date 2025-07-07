package com.api.tests;

import com.api.base.BookStoreService;
import com.api.base.TestBase;
import com.api.models.response.Book;
import com.api.models.response.BooksResponse;
import com.api.models.response.ResponseError;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookStoreServiceTest extends TestBase {

    @Test
    public void testBooks() {
        Response response = new BookStoreService().getBooks();
        BooksResponse booksResponse = response.as(BooksResponse.class);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(booksResponse.getBooks());
    }

    @Test
    public void testBookDetailsValidIsbn() {
        Response response = new BookStoreService().getBook("9781449337711");
        Book bookResponse = response.as(Book.class);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(bookResponse.getIsbn(), "9781449337711");
        Assert.assertEquals(bookResponse.getTitle(), "Designing Evolvable Web APIs with ASP.NET");
        Assert.assertEquals(bookResponse.getPages(), 238);
    }

    @Test
    public void testBookDetailsInvalidIsbn() {
        Response response = new BookStoreService().getBook("97814493377113");
        ResponseError responseError = response.as(ResponseError.class);
        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(responseError.getMessage(), "ISBN supplied is not available in Books Collection!");
        Assert.assertEquals(responseError.getCode(), "1205");
    }

    @Test
    public void testBookUpdate() {
        BookStoreService bookStoreService = new BookStoreService();
        bookStoreService.setAuthToken("sdfgdfbdfkmn");
        bookStoreService.updateBook();
    }
}
