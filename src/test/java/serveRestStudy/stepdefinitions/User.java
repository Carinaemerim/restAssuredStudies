package serveRestStudy.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class User {

    public Response response;
    public int responseCode;

    @Given("the URL of get products endpoint is hit")
    public void theURLOfGetProductsEndpointIsHit() {
        RestAssured.baseURI = "http://fakestoreapi.com";

    }

    @When("the URL in the request is requested")
    public void theURLInTheRequestIsRequested() {
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.get("products");
    }

    @Then("a response code {int} should be received")
    public void aResponseCodeShouldBeReceived(int arg0) {
        responseCode = response.getStatusCode();
        assertEquals(responseCode, 200);
    }

    @Given("the base URL is passed")
    public void theBaseURLIsPassed() {
        RestAssured.baseURI = "https://serverest.dev";
    }

    @When("the get users endpoint is called")
    public void theGetUsersEndpointIsCalled() {
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.get("usuarios");
    }

    @Then("the quantity should be retrieved")
    public void theQuantityShouldBeRetrieved() {
        JsonPath jsonPath = response.jsonPath();

        List<Object> users = jsonPath.get("usuarios");
        Assert.assertFalse(users.isEmpty());
    }
}
