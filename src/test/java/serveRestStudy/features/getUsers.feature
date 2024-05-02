Feature: Get all users from API

  Scenario: Verify the get users api success status code
    Given the base URL is passed
    When the get users endpoint is called
    Then a response code 200 should be received

  Scenario: Verify the get users api results quantity
    Given the base URL is passed
    When the get users endpoint is called
    Then the quantity should be retrieved

  Scenario: Verify the get users api by ID first email result
    Given the base URL is passed
    When the get users endpoint is called
    Then the userdata name should be displayed on the result list
    And the userdata email should be displayed on the result list
    And the userdata password should be displayed on the result list
    And the userdata administrator should be displayed on the result list
    And the userdata _id should be displayed on the result list

  Scenario Outline: Verify the get users api can search for a user ID
    Given the base URL is passed
    When a userID <userID> is passed on get users by ID endpoint
    Then the user <user> should be retrieved

  Examples:
    | userID             | user              |
    | "495jNWrfF3vj4Cdt" | "Maelle Moretti" |
    | "4a0eJuVrzSouSBe5" | "Fulano da Silva"      |

  Scenario: Verify get user API by ID return when there are no search results
    Given the base URL is passed
    When an inexistent userID is passed on get users by ID endpoint
    Then the an error message should be displayed on API

  Scenario: Verify the delete users api
    Given the base URL is passed
    When an existent userID is passed on get users by ID endpoint delete
    Then the existent user should be deleted