package BooksAPI;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

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

    public static HashMap<String, Object> getBooksDataPayloadFromMap()
    {
        Faker faker = new Faker();
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("name", faker.name().firstName());
        payload.put("isbn", RandomStringUtils.randomAlphabetic(4));
        payload.put("aisle", faker.number().digits(4));
        payload.put("author", faker.name().lastName());
        return payload;
    }

    public static Books getBooksDataPayloadFromPojo()
    {
        Faker faker = new Faker();
        return Books.builder()
                .name(faker.name().firstName())
                .isbn(RandomStringUtils.randomAlphabetic(4))
                .aisle(faker.number().digits(4))
                .author(faker.name().lastName()).build();
    }
}