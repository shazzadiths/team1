Feature: Test-Webshop
#Shazzad
  Scenario: Webshop's webpage should work properly show correct title
    Given User visits webpage with chrome driver
    Then  Title should be "Webbutiken"
    And Close browser
  Scenario: Webshop's Header should visible
    Given User visits webpage with chrome driver
    Then  Heading should be "🛍️ The Shop"
    And Close browser



  #Emma
  Scenario: Categories in shop should be 5
    Given User visits webpage with chrome driver
    When User navigates to all products page by shop button
    Then Number of categories should be 5
    And Close browser

   Scenario: Category link Men's clothing should show correct text
     Given User visits webpage with chrome driver
     When User navigates to all products page by shop button
     Then Category link text should be "Men's clothing"
     And Close browser
  Scenario: Category link Women's clothing should show correct text
    Given User visits webpage with chrome driver
    When User navigates to all products page by shop button
    Then Link text should be "Women's clothing"
    And Close browser
  Scenario: Verify that check out button works correct
    Given User visits webpage with chrome driver
    When User clicks on check out button
    Then Page would show text "Checkout form"
    And Close browser
  Scenario: Verify that Jewelry link text is displayed
    Given User visits webpage with chrome driver
    When  User navigates to all products page by shop button
    Then Jewelry link text should be displayed
    And Close browser

  Scenario: First name field should be enabled and displayed
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    Then First name field should be enabled
    Then First name field should be displayed
    And Close browser
  Scenario: Writing in first name field should work correct
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    When User writes name in first name field
    Then Text should be "Birgitta"
    And Close browser
  Scenario: Error message in first name field should be displayed
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    When User does not enter a name
    Then Error message should be displayed
    And Close browser
  Scenario: Credit check box should be enabled
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    Then Credit check box should be enabled
    And Close browser
  Scenario: Credit check box should be displayed
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    Then Credit check box should be displayed
    And Close browser
  Scenario: Credit check box should be selected
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    Then Credit check box should be selected
    And Close browser
  Scenario: Debit check box should be displayed
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    Then Debit check box should be displayed
    And Close browser
  Scenario: Paypal check box should be displayed
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    Then Paypal check box should be displayed
    And Close browser
  Scenario: Verifying writing in name of card field
    Given User visits webpage with chrome driver
    When User navigates to check out form by clicking on check out button
    When User writes name in name of card field
    Then The text should be "Name"
    And Close browser
   Scenario: Name of card field should be enabled
     Given User visits webpage with chrome driver
     When User navigates to check out form by clicking on check out button
     Then Name of card field should be enabled
     And Close browser
   Scenario: Name of card field should be displayed
     Given User visits webpage with chrome driver
     When User navigates to check out form by clicking on check out button
     Then Name of card field should be displayed
     And Close browser
   Scenario: Error message in name of card field should be displayed
     Given User visits webpage with chrome driver
     When User navigates to check out form by clicking on check out button
     When User does not write anything in name of card field
     Then Error message should be visible
     And Close browser

#Shazzad
  Scenario: Shop should navigate to All products page
    Given User visits webpage with chrome driver
    When User navigates to all products page by shop button
    Then Number of categories should be 5
    And By default it shows products from category "All"
    And Close browser
  Scenario: Should shows total list products
    Given User visits webpage with chrome driver
    When User navigates to all products page by shop button
    Then Number of categories should be 5
    And By default it shows products from category "All"
    Then Total products would be 20
    And Close browser
  Scenario: Home button should navigate to home page from other pages
    Given User visits webpage with chrome driver
    When User navigates to all products page by shop button
    And To back to home page user click Home
    Then User get back to home page the text should be in home page "This shop is all you need"
    And Close browser
  Scenario: Product category list should be verified
    Given User visits webpage with chrome driver
    When User navigates to all products page by shop button
    Then Number of categories should be 5
    And It's categories should be "All", "Men's clothing", "Women's clothing", "Jewelery","Electronics"
    And Close browser

#Vijaya
  Scenario: Verify the Add to cart button
    Given User visits webpage with chrome driver
    When User visits products page
    And user look for the add to cart button
    Then The add to cart button should be enabled and displayed
    And Close browser
  Scenario: Verify the Add to cart button
    Given User visits webpage with chrome driver
    When User visits products page
    And user look for the Checkout button
    Then The Checkout button should be enabled and displayed
    And Close browser
     #ändrat av shazzad
  Scenario: Verify the total count of Women's clothing products
    Given User visits webpage with chrome driver
    When User navigates to all products page by shop button
    And clicks on Women's clothing link
    Then User can verify the total count of women's clothing products are 6
    And Close browser
  Scenario: Verify the error message for the last name fields
    Given User visits webpage with chrome driver
    When User clicks on checkout button
    And User submit the last name field without entering any value
    Then User can see error message indicating the missing last name
    And Close browser
  Scenario: Verify the email id field is enabled and displayed
    Given User visits webpage with chrome driver
    When User clicks on checkout button
    Then User should see the email id Field enabled and display
    And Close browser

#Somayeh
  Scenario:Verify that logo in main page is visible
    Given User visits webpage with chrome driver
    Then user should see logo
    And Close browser
  Scenario:Verify that title of the homepage is correct
    Given User visits webpage with chrome driver
    Then Webpage title should be "🛍️ The Shop"
    And Close browser
  Scenario: Verify the four links on botten of page and the text should be visible
    Given User visits webpage with chrome driver
    Then User should see the four links "Home,Shop,Checkout,About"
    And Close browser
  Scenario: Text of link HOME should be visible and correct
    Given User visits webpage with chrome driver
    Then User should see the link "Home" with correct text
    And Close browser

    #ändrat av shazzad
  Scenario: Check the first title in category Jewelery
    Given User visits webpage with chrome driver
    When User navigates to all products page by shop button
    And User visits Jewelery page
    Then User should see the first product in jewelery with visible title "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet"
    And Close browser

  Scenario: ThisShopIsAllYouNeed should be correct and visible
    Given User visits webpage with chrome driver
    Then "This shop is all you need" should be shown and visible
    And Close browser
  Scenario: check if Shop link is clickable and works as expected
    Given User visits webpage with chrome driver
    When User click shop link and type in jewelery in search box
    Then The input should be the value user writes in the dialog box
    And Close browser

  Scenario: check if last description for last link is clickable and works as expected
    Given User visits webpage with chrome driver
    Then Description text should be "En lite böjd skär Men den funkar ändå!"
    And Close browser

