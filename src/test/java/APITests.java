import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITests {

    @Test
    void testExample(){
        //reqres.in FakeAPI

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        response.getStatusCode();
        response.getBody();
        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println("Response: "+response.asString());
        System.out.println("Body: "+response.getBody());
        System.out.println("Time Taken: "+response.getTime());
        System.out.println("Header: "+response.getHeader("content-type"));

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void testBDDExample(){
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
    }
}
