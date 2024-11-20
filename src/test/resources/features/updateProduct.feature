Feature: UPDATE PRODUCTS

  @RegressionTest
  Scenario: PUT API Test 1 - update product
    When Update product with ID 3
    Then Validate that product has been updated
    
  @RegressionTest
  Scenario: PUT API Test 2 - update the product with an invalid value
    When Update product with ID 128 where field value is incorrect
    Then Validate that product has not been updated
    
  @RegressionTest
  Scenario: PUT API Test 3 - update non-existing product
    When Update product with ID 3000
    Then Validate that product has not been updated
  
  @RegressionTest
  Scenario: PATCH API Test 4 - partially update the product with an invalid value
    When Partially update product with ID 125 where field value is incorrect
    Then Validate that product has not been found
  
  @RegressionTest
  Scenario: PATCH API Test 5 - partially update non-existing product
    When Partially update product with ID 3000
    Then Validate that product has not been found