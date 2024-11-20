Feature: ADD PRODUCTS

  @SmokeTest
  Scenario: POST API Test 1 - add new product
    When Add new product
    Then Validate that product has been added
    
  @SmokeTest
  Scenario: POST API Test 2 - add new product with missing field value
    When Add new product with one missing field
    Then Validate that product has not been added
    
  @SmokeTest
  Scenario: POST API Test 3 - add new product with all missing fields
    When Add new product with all missing fields
    Then Validate that product has not been added
    
  @SmokeTest
  Scenario: POST API Test 4 - add new product with incorrect fields values
    When Add new product with incorrect fields values
    Then Validate that product has not been added