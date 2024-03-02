package BooksAPI;

import java.util.HashMap;

public class Payload
{
    public static String getBooksDataPayloadFromString(String name, String isbn, String aisle, String author)
    {
        return "{\n" +
                "\n" +
                "\"name\":"+name+",\n" +
                "\"isbn\":"+isbn+",\n" +
                "\"aisle\":"+aisle+",\n" +
                "\"author\":"+author+"\n" +
                "}\n";
    }

    public static HashMap<String, Object> getBooksDataPayloadFromMap(String name, String isbn, String aisle,
                                                                     String author)
    {
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("name", name);
        payload.put("isbn", isbn);
        payload.put("aisle", aisle);
        payload.put("author", author);
        return payload;
    }
}