package serveRestStudy.Hooks;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import kong.unirest.json.JSONObject;
import org.testng.annotations.Test;


public class Hooks {

    @Test
    public void userLogin(){
        //should return token to be used by another methods
        //Token will need to be splitted
        JSONObject jsonObj = new JSONObject()
                .put("email","fulano@qa.com")
                .put("password","teste");

        ResponseBody response = RestAssured.given()
                .contentType("application/json")  //another way to specify content type
                .body(jsonObj.toString())
                .when()
                .post("https://serverest.dev/login");


        String responseBody = response.asString();
        System.out.println(responseBody);
    }

}
