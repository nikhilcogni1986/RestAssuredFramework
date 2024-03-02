package BooksAPI;

import RestUtils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BooksAPITest
{
    @Test
    public void add_book_using_post()
    {
        String endpoint = "http://216.10.245.166";
        String postUrl = "/Library/Addbook.php";
        HashMap<String, Object> requestPayload = Payload.getBooksDataPayloadFromMap("Selenium Book","ccv","223","Rahul");
        RestUtils.perform_post(endpoint, requestPayload,new HashMap<>(),postUrl);
    }
}