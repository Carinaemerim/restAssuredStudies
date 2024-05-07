import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITests {

    @Test
    void testExample() {
        //reqres.in FakeAPI

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        response.getStatusCode();
        response.getBody();
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.asString());
        System.out.println("Body: " + response.getBody());
        System.out.println("Time Taken: " + response.getTime());
        System.out.println("Header: " + response.getHeader("content-type"));

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void testBDDExample() {
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
    }

    @Test
    void testAuthenticationBasicExample() {
        given().auth().preemptive()
                .basic("foo", "bar")
                .when()
                .get("http://httpbin.org/basic-auth/foo/bar")
                .then()
                .log().body().statusCode(200);

    }

    //oauth2 client credential
    @Test
    void testAuthenticationOauth2Example() {

        HttpResponse<String> response = Unirest.post("https://dev-wnza4wg8jkyds74f.us.auth0.com/oauth/token")
                .header("content-type", "application/x-www-form-urlencoded")
                .body("grant_type=client_credentials&client_id=2CiGnmR70DfBkJcUNE0TNf5BDXEgvGqr&client_secret=zX_OIhkx21o1f5FSJ7WNZwA5pKukmlUy66hJ-HznHtsryDaxSf8tg32Uw9S6912B&audience=https://dev-wnza4wg8jkyds74f.us.auth0.com/api/v2/")
                .asString();

        System.out.println(response.getBody());
    }

    @Test
    public void getRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://dev-wnza4wg8jkyds74f.us.auth0.com/api/v2/users")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
    }
}
