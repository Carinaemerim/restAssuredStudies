Feature: Create Users using the API

  Scenario: Verify that it is possible to create a new user using the API
    Given the base URL is passed
    When nome is passed on endpoint body
    And email is passed on endpoint body
    And password is passed on endpoint body
    And administrador is passed on endpoint body
    And the endpoint post usuarios is called
    Then it should return the message "Cadastro realizado com sucesso"
    And it should return the user ID


  Scenario: Verify that it is not possible to create a new user using the same email
    Given the base URL is passed
    When nome is passed on endpoint body
    And email is passed on endpoint body
    And password is passed on endpoint body
    And administrador is passed on endpoint body
    And the endpoint post usuarios is called
    Then it should return the message "Este email já está sendo utilizado"

  Scenario: Verify that it is possible to create a new user using the API and for search it
    Given the base URL is passed
    When nome is passed on endpoint body
    And email is passed on endpoint body
    And password is passed on endpoint body
    And administrador is passed on endpoint body
    And the endpoint post usuarios is called
    And the user ID is returned
    And the base URL is passed
    And a userID is passed on get users by ID endpoint
    Then the user informations should be retrieved