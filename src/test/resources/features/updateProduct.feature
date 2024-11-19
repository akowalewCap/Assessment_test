Feature: UPDATE PRODUCTS

  @SmokeTest
  Scenario: PUT API Test 1 - update product
    When Update Product with ID 122
    Then Validate that product has been updated
    
  @SmokeTest
  Scenario: PUT API Test 2 - update the product with an invalid value
    When Update Product with ID 128 Where Field Value Is Incorrect
    Then Validate that product has not been updated
    
  @SmokeTest
  Scenario: PUT API Test 3 - update non-existing product
    When Update Product with ID 3000
    Then Validate that product has not been updated
  
  @SmokeTest
  Scenario: PATCH API Test 4 - partially update the product with an invalid value
    When Partially Update Product with ID 125 Where Field Value Is Incorrect
    Then Validate that product has not been found
  
  @SmokeTest
  Scenario: PATCH API Test 5 - partially update non-existing product
    When Partially Update Product with ID 3000
    Then Validate that product has not been found