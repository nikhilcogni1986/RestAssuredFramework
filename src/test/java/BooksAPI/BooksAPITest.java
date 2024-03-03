package BooksAPI;

import RestUtils.RestUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class BooksAPITest extends BooksApi
{
    @Test
    public void add_book_using_post() throws IOException {

        HashMap<String, Object> requestPayload = Payload.getBooksDataPayloadFromMap("Selenium Book","ccv","223","Rahul");
        Response response = addBook(requestPayload);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void add_book_using_post_random_data() throws IOException {

        HashMap<String, Object> requestPayload = Payload.getBooksDataPayloadFromMap();
        Response response = addBook(requestPayload);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void add_book_using_post_using_pojo() throws IOException {

        Books requestPayload = Payload.getBooksDataPayloadFromPojo();
        Response response = addBook(requestPayload);
        Assert.assertEquals(response.statusCode(),200);
    }
}