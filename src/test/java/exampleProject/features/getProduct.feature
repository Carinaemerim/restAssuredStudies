Feature: Get all products from API

  Scenario: Verify the get api return
    Given the URL of get products endpoint is hit
    When the URL in the request is requested
    Then a response code 200 should be received

  Scenario Outline: Verify the rate of the first product
    Given the URL of get products endpoint is hit
    When the URL in the request is requested
    Then the product rate should be <rate>

    Examples:
    | rate   |
    | "3.9"  |




