#// Emma2
Feature: Test WebShop API
  Scenario: WebShop API should respond with status code 200 on get request
   # When User make GET-request to "https://fakestoreapi.com/"
  When User make GET-request to "https://produktapi.herokuapp.com/products"

    Then HTTP respons status code should be 200

  #// Somayeh


Scenario:Test get URL endpoint for products
  Given the API is running
  When user do a Get-request to "http://localhost:8080/products"
  Then the endpoint should be "/products" and user should see a list of all products

  Scenario: Test get URL endpoint for categories
    Given the API is running
    When user do a Get-request to "http://localhost:8080/products/categories"
    Then the endpoint should be "/products/categories"

    Scenario: Test get URL endpoint and all the jewelery products by category
      Given the API is running
      When user do a Get-request to "http://localhost:8080/products/categories/jewelery" to navigate to page jewelery
      Then the filtered endpoint result should be "/products/categories/jewelery"
      And user should see a list of 4 products in categories jewelery

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