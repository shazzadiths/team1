Feature: Test-Webshop

  Scenario: Webshop's webpage should work properly show correct title
    Given User visits webpage with chrome driver
    Then  Title should be "Webbutiken"
  Scenario: Webshop's Header should visible
    Given User visits webpage with chrome driver
    Then  Heading should be "🛍️ The Shop"
#Vijaya
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

  #Emma
  Scenario: Categories in shop should be 5
    Given User visits webpage with chrome driver
    When User navigates to all products page by shop button
    Then Number of categories should be 5

   Scenario: Category link Men's clothing should show correct text
     Given User visits webpage with chrome driver
     When User navigates to all products page by shop button
     Then Category link text should be "Men's clothing"

  Scenario: Category link Women's clothing should show correct text
    Given User visits webpage with chrome driver
    When User navigates to all products page by shop button
    Then Link text should be "Women's clothing"

  Scenario: Verify that check out button works correct
    Given User visits webpage with chrome driver
    When User clicks on check out button
    Then Page would show text "Checkout form"

  Scenario: Verify that Jewelry link text is displayed
    Given User visits webpage with chrome driver
    When  User navigates to all products page by shop button
    Then Jewelry link text should be displayed

  Scenario: Should work correct when user adds one item to cart
    Given User visits webpage with chrome driver
    When User navigates to all products page by shop button
    When User adds one item to cart
    Then Product in cart should be 1

  Scenario: Removing one product from cart should work correct
    Given User visits webpage with chrome driver
    When User navigates to all products page by shop button
    When User adds one item to cart
    And User removes item
    Then Item in cart should be 0

  Scenario: First name field should be enabled and displayed
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    Then First name field should be enabled
    Then First name field should be displayed

  Scenario: Writing in first name field should work correct
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    When User writes name in first name field
    Then Text should be "Birgitta"

  Scenario: Error message in first name field should be displayed
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    When User does not enter a name
    Then Error message should be displayed

  Scenario: Credit check box should be enabled
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    Then Credit check box should be enabled

  Scenario: Credit check box should be displayed
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    Then Credit check box should be displayed

  Scenario: Credit check box should be selected
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    Then Credit check box should be selected

  Scenario: Debit check box should be displayed
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    Then Debit check box should be displayed

  Scenario: Paypal check box should be displayed
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    Then Paypal check box should be displayed

  Scenario: Verifying writing in name of card field
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    When User writes name in name of card field
    Then The text should be "Name"

   Scenario: Name of card field should be enabled
     Given User visits webpage with chrome driver
     When User navigates to check out form by clicking on check out button
     Then Name of card field should be enabled

   Scenario: Name of card field should be displayed
     Given User visits webpage with chrome driver
     When User navigates to check out form by clicking on check out button
     Then Name of card field should be displayed

   Scenario: Error message in name of card field should be displayed
     Given User visits webpage with chrome driver
     When User navigates to check out form by clicking on check out button
     When User does not write anything in name of card field
     Then Error message should be visible






