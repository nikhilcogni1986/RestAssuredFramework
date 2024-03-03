package RestUtils;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

public class RestUtils
{
    private static RequestSpecification getRequest(String endpoint, Object requestPayload, HashMap<String, String> headers)
    {
        return RestAssured.given().
                contentType(ContentType.JSON)
                .baseUri(endpoint)
                .body(requestPayload)
                .when();
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification)
    {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is: "+queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is: "+queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are: "+queryableRequestSpecification.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Request Body is: ");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReport(Response response)
    {
        ExtentReportManager.logInfoDetails("Response Status code: "+response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are: "+response.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Response Body: ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }
    public static Response perform_post(String endpoint, String requestPayload, HashMap<String, String> headers,
                                        String postUrl)
    {
        RequestSpecification requestSpecification = getRequest(endpoint,requestPayload,headers);
        Response response = requestSpecification.post(postUrl);
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response perform_post(String endpoint, HashMap<String, Object> requestPayload,
                                        HashMap<String, String> headers, String postUrl)
    {
        RequestSpecification requestSpecification = getRequest(endpoint,requestPayload,headers);
        Response response = requestSpecification.post(postUrl);
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response perform_post(String endpoint, Object requestPayloadFromPojo,
                                        HashMap<String, String> headers, String postUrl)
    {
        RequestSpecification requestSpecification = getRequest(endpoint,requestPayloadFromPojo,headers);
        Response response = requestSpecification.post(postUrl);
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }
}