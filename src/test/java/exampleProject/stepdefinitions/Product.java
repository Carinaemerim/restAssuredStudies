package exampleProject.stepdefinitions;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static org.testng.Assert.assertEquals;

public class Product {

    public Response response;
    public int responseCode;
    public ResponseBody body;
    public Response responsePost;
    public JsonObject requestParams;

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

    @Then("the product rate should be {string}")
    public void theProductRateShouldBeRate(String rate) {
        body = response.getBody();

        //Convert response body to string
        String responseBody = body.asString();

        //json representation from response body
        JsonPath jsonPath = response.jsonPath();
        String ratingJson = jsonPath.getJsonObject("rating[0].rate").toString();

        assertEquals(ratingJson, rate);
    }

    @Given("the URL of POST product is hit")
    public void theURLOfPOSTProductIsHit() {
        RestAssured.baseURI = "http://fakestoreapi.com";
    }

    @When("the URL of products is passed")
    public void theURLOfProductsIsPassed() {


    }

    @And("the product {string} POST request body is passed")
    public void theProductProductTitlePOSTRequestBodyIsPassed(String productTitle) {
        requestParams.add("title", productTitle);
        requestParams.add("price", 1.13);
        requestParams.add("description", "lorem ipsum");
        requestParams.add("image", "http://i.pravatar.cc");
        requestParams.add("category", "electronics");
        
    }

    @Then("the response code should be {int}")
    public void theResponseCodeShouldBe(int arg0) {
    }
}
