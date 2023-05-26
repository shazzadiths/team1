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