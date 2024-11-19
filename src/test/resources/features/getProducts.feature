Feature: GET PRODUCTS

  @SmokeTest
  Scenario: GET API Test 1 - get all products
    When Get All Products
    Then Validate that all products are listed
    
  @SmokeTest
  Scenario: GET API Test 2 - get a single product
    When Get A Single Product with ID 41
    Then Validate that product is listed
    
  @SmokeTest
  Scenario: GET API Test 3 - get a single, non-existing product
    When Get A Single Product with ID 1000
    Then Validate that product is not listed