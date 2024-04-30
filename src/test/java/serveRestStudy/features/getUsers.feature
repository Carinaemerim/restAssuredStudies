Feature: Get all users from API

  Scenario: Verify the get users api return
    Given the base URL is passed
    When the get users endpoint is called
    Then a response code 200 should be received

  Scenario: Verify the get users api results quantity
    Given the base URL is passed
    When the get users endpoint is called
    Then the quantity should be retrieved

  Scenario: Verify the get users api first email result
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
    | "2Og4zVhwsekYnFpP" | "Melissa Rinaldi" |
    #| "2TlPS6XZ1eni0CMl" | "Cece Rosso"      |

