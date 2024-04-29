Feature: Get all users from API

  Scenario: Verify the get users api return
    Given the base URL is passed
    When the get users endpoint is called
    Then a response code 200 should be received

  Scenario: Verify the get users api results quantity
    Given the base URL is passed
    When the get users endpoint is called
    Then the quantity should be retrieved




