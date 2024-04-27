Feature: Insert products using the API

  Scenario Outline: Verify that it is possible to insert products using the API
    Given the URL of POST product is hit
    When the URL of products is passed
    And the product <productTitle> POST request body is passed
    Then the response code should be 200

    Examples:
    | productTitle |
    | "Shoes" |