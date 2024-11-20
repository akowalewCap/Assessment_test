Feature: GET PRODUCTS

  @RegressionTest
  Scenario: GET API Test 1 - get all products
    When Get all products
    Then Validate that all products are listed

  @RegressionTest
  Scenario: GET API Test 2 - get a single product
    When Get a single product with ID 41
    Then Validate that product is listed

  @RegressionTest
  Scenario: GET API Test 3 - get a single, non-existing product
    When Get a single product with ID 1000
    Then Validate that product is not listed