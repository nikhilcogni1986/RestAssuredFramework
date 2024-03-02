package RestUtils;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestUtils {
    public static Response perform_post(String endpoint, String requestPayload, HashMap<String, String> headers,
                                        String postUrl) {
        Response response = RestAssured.given().
                contentType(ContentType.JSON)
                .baseUri(endpoint)
                .body(requestPayload)
                .log().all()
                .when()
                .post(postUrl)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response();
        return response;
    }

    public static Response perform_post(String endpoint, HashMap<String, Object> requestPayload,
                                        HashMap<String, String> headers, String postUrl) {
        Response response = RestAssured.given().
                contentType(ContentType.JSON)
                .baseUri(endpoint)
                .body(requestPayload)
                .log().all()
                .when()
                .post(postUrl)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response();
        return response;
    }
}
