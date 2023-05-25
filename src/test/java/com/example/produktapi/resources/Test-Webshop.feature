Feature: Test-Webshop

  Scenario: Webshop's webpage should work properly show correct title
    Given User visits webpage with chrome driver
    Then  Title should be "Webbutiken"
  Scenario: Webshop's Header should visible
    Given User visits webpage with chrome driver
    Then  Heading should be "🛍️ The Shop"
  Scenario: Verify the Add to cart button
    Given User visits webpage with chrome driver
    And User visits products page
    When  user look for the add to cart button
    Then The add to cart button should be enabled and displayed
  Scenario: Verify the Add to cart button
    Given User visits webpage with chrome driver
    And User visits products page
    When user look for the Checkout button
    Then The Checkout button should be enabled and displayed
