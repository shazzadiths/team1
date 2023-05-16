Feature: Test Webshop API
  Scenario: Webshop API should respond with status code 200 on get request
    When User make GET-request to "https://webshop-agil-testautomatiserare.netlify.app/"
    Then HTTP respons status code should be 200