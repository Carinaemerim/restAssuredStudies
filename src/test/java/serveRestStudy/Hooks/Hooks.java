package serveRestStudy.Hooks;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import kong.unirest.json.JSONObject;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class Hooks {

    public int responseCode;

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


    public String createUser() throws Exception {
        JSONObject jsonObj = new JSONObject()
                .put("nome","Kilua")
                .put("email","kilua@qa.com")
                .put("password","teste")
                .put("administrador","true");

        Response response = RestAssured.given()
                .contentType("application/json")  //another way to specify content type
                .body(jsonObj.toString())
                .when()
                .post("https://serverest.dev/usuarios");

        JsonPath jsonPath = response.jsonPath();
        responseCode = response.getStatusCode();
        if (responseCode == 200) {
            return jsonPath.getJsonObject("_id").toString();
        }
        throw new Exception(jsonPath.get("message").toString());
    }

}
