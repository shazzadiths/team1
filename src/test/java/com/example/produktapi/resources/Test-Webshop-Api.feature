Feature: Test Webshop API
#Emma
  Scenario: Webshop API should respond with status code 200 on get request
    When User make GET-request to "https://webshop-agil-testautomatiserare.netlify.app/"
    Then HTTP response status code should be 200
#Somayeh
  Scenario:Test get URL endpoint for products
    When user makes a GET request to "https://produktapi.herokuapp.com/products"
    Then HTTP response status code should be 200
    And user should see a list of all products with size=20


  Scenario: Test get URL endpoint for categories
    When user makes a GET request to "https://produktapi.herokuapp.com/products/categories"
    Then HTTP response status code should be 200
    And the response should contain 4 categories
    And the first category should be "electronics" and the last category should be "women's clothing"


  Scenario: Test get product by Id
    When user makes a GET request to "https://produktapi.herokuapp.com/products/18"
    Then HTTP response status code should be 200
    And it should contains the following attributes:
      | id          | 18                                                           |
      | title       | MBJ Women's SolShort Sleeve Boat Neck V                      |
      | price       | 9.85                                                         |
      | category    | women's clothing                                             |
      | description | Snygg och bara att sätta på sig om man har köpt rätt storlek |
      | image       | https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg      |


#Vijaya
  Scenario: Test get URL endpoint for all the electronics products by category
      When User make a GET-request to "http://localhost:8080/products/categories/electronics"
      Then the endpoin result should be "/products/categories/electronics"
      And page has to upload with 6 electronic products


  Scenario: Test get URL endpoint for all the men's clothing products by category
    When User make a GET-request to navigate Men's Clothing "http://localhost:8080/products/categories/men's clothing"
    Then the endpoint result should be "/products/categories/men's clothing"
    And page has to upload with 4 men's clothing products


  Scenario: Test get URL endpoint for all the women's clothing products by category
    When User make a GET-request to navigate women's Clothing "http://localhost:8080/products/categories/women's clothing"
    Then the endpoint result should be "/products/categories/women's clothing" for navigate women's clothing
    And page has to upload with 6 Women's clothing products

