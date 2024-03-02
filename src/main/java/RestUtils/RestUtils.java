package RestUtils;

import java.util.HashMap;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestUtils
{
    public static void perform_post(String endpoint, String requestPayload, HashMap<String, String> headers,
                                    String postUrl)
    {
                RestAssured.given().
                contentType(ContentType.JSON)
                        .baseUri(endpoint)
                .body(requestPayload)
                .log().all()
                .when()
                .post(postUrl)
                .then().log().all()
                .assertThat().statusCode(200);
    }

    public static void perform_post(String endpoint, HashMap<String, Object> requestPayload,
                                    HashMap<String, String> headers,String postUrl)
    {
        RestAssured.given().
                contentType(ContentType.JSON)
                .baseUri(endpoint)
                .body(requestPayload)
                .log().all()
                .when()
                .post(postUrl)
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
