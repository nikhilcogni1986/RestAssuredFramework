package BooksAPI;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class BooksAPITest extends BooksApi
{
    @Test
    public void add_book_using_post() {

        HashMap<String, Object> requestPayload = Payload.getBooksDataPayloadFromMap("Selenium Book","ccv","2113","Rahul");
        Response response = addBook(requestPayload);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void add_book_using_post_random_data() {

        HashMap<String, Object> requestPayload = Payload.getBooksDataPayloadFromMap();
        Response response = addBook(requestPayload);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void add_book_using_post_using_pojo() {

        Books requestPayload = Payload.getBooksDataPayloadFromPojo();
        Response response = addBook(requestPayload);
        Assert.assertEquals(response.statusCode(),200);
    }

//    @Test
//    public void add_book_using_post_using_defaultvalues_fromPojo() {
//
//        Books requestPayload = new Books();
//        Response response = addBook(requestPayload);
//        Assert.assertEquals(response.statusCode(),200);
//    }
    
}