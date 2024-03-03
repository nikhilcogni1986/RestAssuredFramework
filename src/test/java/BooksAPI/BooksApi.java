package BooksAPI;

import RestUtils.RestUtils;
import io.restassured.response.Response;

import java.util.HashMap;

public class BooksApi extends Base
{
    public Response addBook(HashMap<String, Object> requestPayload)
    {
        return  RestUtils.perform_post(Base.dataFromJsonFile.get("AddBookEndpoint"),
                requestPayload,new HashMap<>(),Base.dataFromJsonFile.get("AddBookPostUrl"));
    }

    public Response addBook(Books requestPayload)
    {
        return  RestUtils.perform_post(Base.dataFromJsonFile.get("AddBookEndpoint"),
                requestPayload,new HashMap<>(),Base.dataFromJsonFile.get("AddBookPostUrl"));
    }
}
