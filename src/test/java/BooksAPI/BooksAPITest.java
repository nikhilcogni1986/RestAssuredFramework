package BooksAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BooksAPITest
{
    @Test
    public void add_book_using_post()
    {
        RestAssured.baseURI = "http://216.10.245.166";
        given().
                contentType(ContentType.JSON)
                .body("{\n" +
                        "\n" +
                        "\"name\":\"Learn Appium Automation with Python\",\n" +
                        "\"isbn\":\"bcd\",\n" +
                        "\"aisle\":\"111\",\n" +
                        "\"author\":\"John Beadon\"\n" +
                        "}\n")
                .log().all()
                .when()
                .post("/Library/Addbook.php")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}