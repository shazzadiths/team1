Feature: Test-Webshop

  Scenario: Webshop's webpage should work properly show correct title
    Given User visits webpage with chrome driver
    Then  Title should be "Webbutiken"
  Scenario: Webshop's Header should visible
    Given User visits webpage with chrome driver
    Then  Heading should be "🛍️ The Shop"