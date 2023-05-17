#// Emma2
Feature: Test WebShop API
  Scenario: WebShop API should respond with status code 200 on get request
    When User make GET-request to "https://fakestoreapi.com/"
  #  When User make GET-request to "https://produktapi.herokuapp.com/products"

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

