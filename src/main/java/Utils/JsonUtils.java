package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, String> getJsonDataAsMap(String fileName) throws IOException {
        String completeJsonFilePath = System.getProperty("user.dir") + "/src/test/java/resources/" + fileName;
        Map<String, String> data = objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<>() {});
        return data;
    }
}