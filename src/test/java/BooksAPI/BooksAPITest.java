package BooksAPI;

import RestUtils.RestUtils;
import Utils.JsonUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BooksAPITest
{
    @Test
    public void add_book_using_post() throws IOException {
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        Map<String, String> jsonDataAsMap = JsonUtils.getJsonDataAsMap("/"+env+"/BooksApiData.json");

        String endpoint = jsonDataAsMap.get("AddBookEndpoint");
        String postUrl = jsonDataAsMap.get("AddBookPostUrl");

        HashMap<String, Object> requestPayload = Payload.getBooksDataPayloadFromMap("Selenium Book","ccv","223","Rahul");
        RestUtils.perform_post(endpoint, requestPayload,new HashMap<>(),postUrl);
    }
}