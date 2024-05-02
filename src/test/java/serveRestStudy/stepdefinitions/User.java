package serveRestStudy.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
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

    @Then("the userdata name should be displayed on the result list")
    public void theUserdataNameShouldBeDisplayedOnTheResultList() {
        JsonPath jsonPath = response.jsonPath();

        String userName = jsonPath.getJsonObject("usuarios[0].nome").toString();
        Assert.assertFalse(userName.isEmpty());
    }

    @And("the userdata email should be displayed on the result list")
    public void theUserdataEmailShouldBeDisplayedOnTheResultList() {
        JsonPath jsonPath = response.jsonPath();

        String userName = jsonPath.getJsonObject("usuarios[0].email").toString();
        Assert.assertFalse(userName.isEmpty());
    }

    @And("the userdata password should be displayed on the result list")
    public void theUserdataPasswordShouldBeDisplayedOnTheResultList() {
        JsonPath jsonPath = response.jsonPath();

        String userName = jsonPath.getJsonObject("usuarios[0].password").toString();
        Assert.assertFalse(userName.isEmpty());
    }

    @And("the userdata administrator should be displayed on the result list")
    public void theUserdataAdministratorShouldBeDisplayedOnTheResultList() {
        JsonPath jsonPath = response.jsonPath();

        String userName = jsonPath.getJsonObject("usuarios[0].administrador").toString();
        Assert.assertFalse(userName.isEmpty());
    }

    @And("the userdata _id should be displayed on the result list")
    public void theUserdata_idShouldBeDisplayedOnTheResultList() {
        JsonPath jsonPath = response.jsonPath();

        String userName = jsonPath.getJsonObject("usuarios[0]._id").toString();
        Assert.assertFalse(userName.isEmpty());
    }

    @When("a userID {string} is passed on get users by ID endpoint")
    public void aUserIDUserIDIsPassedOnGetUsersByIDEndpoint(String userID) {
        RequestSpecification httpRequest = RestAssured.given();

        response = httpRequest.get("usuarios/{_id}", userID);
    }

    @Then("the user {string} should be retrieved")
    public void theUserUserShouldBeRetrieved(String user) {
        JsonPath jsonPath = response.jsonPath();

        String userName = jsonPath.get("nome");
        assertEquals(userName, user);

    }

    @When("an inexistent userID is passed on get users by ID endpoint")
    public void anInexistentUserIDIsPassedOnGetUsersByIDEndpoint() {
        RequestSpecification httpRequest = RestAssured.given();

        response = httpRequest.get("usuarios/{_id}", "asgaygsyagsyags");
    }

    @Then("the an error message should be displayed on API")
    public void theAnErrorMessageShouldBeDisplayedOnAPI() {
        JsonPath jsonPath = response.jsonPath();
        responseCode = response.getStatusCode();

        String userName = jsonPath.get("message");
        assertEquals(userName, "Usuário não encontrado");
        assertEquals(responseCode, 400);
    }

    @When("an existent userID is passed on get users by ID endpoint delete")
    public void anExistentUserIDIsPassedOnGetUsersByIDEndpointDelete() {
        RequestSpecification httpRequest = RestAssured.given();

        response = httpRequest.get("usuarios/{_id}", "zjfnYe4KD9jUEc7L");
        responseCode = response.getStatusCode();
        assertEquals(responseCode, 200);
    }

    @Then("the existent user should be deleted")
    public void theExistentUserShouldBeDeleted() {
        RequestSpecification httpRequest = RestAssured.given();

        response = httpRequest.delete("usuarios/{_id}", "zjfnYe4KD9jUEc7L");
        responseCode = response.getStatusCode();
        assertEquals(responseCode, 200);

        JsonPath jsonPath = response.jsonPath();
        String successMessage = jsonPath.get("message");
        assertEquals(successMessage, "Registro excluído com sucesso");
    }
}
