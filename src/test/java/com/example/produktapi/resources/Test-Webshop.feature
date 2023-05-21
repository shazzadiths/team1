Feature: Test-Webshop

  Scenario: Webshop's webpage should work properly show correct title
    Given Chrome web driver in available
    When  User visits webpage
    Then  Title should be "Webbutiken"
