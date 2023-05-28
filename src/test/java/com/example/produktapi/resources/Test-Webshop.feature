Feature: Test-Webshop

  Scenario: Webshop's webpage should work properly show correct title
    Given User visits webpage with chrome driver
    Then  Title should be "Webbutiken"
  Scenario: Webshop's Header should visible
    Given User visits webpage with chrome driver
    Then  Heading should be "🛍️ The Shop"
  Scenario: Verify the Add to cart button
    Given User visits webpage with chrome driver
    When User visits products page
    And user look for the add to cart button
    Then The add to cart button should be enabled and displayed
  Scenario: Verify the Add to cart button
    Given User visits webpage with chrome driver
    When User visits products page
    And user look for the Checkout button
    Then The Checkout button should be enabled and displayed
 Scenario: Verify the total count of Women's clothing products
   Given User visits webpage with chrome driver
   When User visits products page
   When User clicks on Women's clothing link
   Then User can verify the total count of women's clothing products are 6
 Scenario: Verify the error message for the last name fiels
   Given User visits webpage with chrome driver
   When User clicks on checkout button
   And User sumit the last name field without entering any value
   Then User can see error message indicating the missing last name
 Scenario: Verify the email id field is enabled and displayed
   Given User visits webpage with chrome driver
   When User clicks on checkout button
   Then User should see the email id Field enabled and displayed





