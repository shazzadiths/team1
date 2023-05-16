Feature: Test WebShop API
  Scenario: WebShop API should respond with status code 200 on get request
    When User make GET-request to "https://fakestoreapi.com/"
    Then HTTP respons status code should be 200

