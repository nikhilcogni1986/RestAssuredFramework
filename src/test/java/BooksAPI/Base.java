package BooksAPI;

import Utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Base
{
    public static Map<String, String> dataFromJsonFile;
    static
    {
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        try
        {
            dataFromJsonFile = JsonUtils.getJsonDataAsMap("/"+env+"/BooksApiData.json");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        String endpoint = dataFromJsonFile.get("AddBookEndpoint");
        String postUrl = dataFromJsonFile.get("AddBookPostUrl");

    }
}
