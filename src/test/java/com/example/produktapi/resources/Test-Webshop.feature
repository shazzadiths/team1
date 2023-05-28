Feature: Test-Webshop

  Scenario: Webshop's webpage should work properly show correct title
    Given User visits webpage with chrome driver
    Then  Title should be "Webbutiken"

  Scenario: Webshop's Header should visible
    Given User visits webpage with chrome driver
    Then  Heading should be "🛍️ The Shop"



    #Somayeh
  Scenario:Verify that logo in main page is visible
    Given User visits webpage with chrome driver
    Then user should see logo

  Scenario:Verify that title of the homepage is correct
    Given User visits webpage with chrome driver
    Then Webpage title should be "🛍️ The Shop"

  Scenario: Verify the four links on botten of page and the text should be visible
    Given User visits webpage with chrome driver
    Then User should see the four links "Home,Shop,Checkout,About"

  Scenario: Text of link HOME should be visible and correct
    Given User visits webpage with chrome driver
    Then User should see the link "Home" with correct text

    Scenario: Check the first title in category Jewelery
      Given User visits webpage with chrome driver
      Then User should see the last product in jewelery with visible title "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet"

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





