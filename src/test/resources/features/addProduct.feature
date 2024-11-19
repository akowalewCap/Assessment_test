Feature: ADD PRODUCTS

  @SmokeTest
  Scenario: POST API Test 1 - add new product
    When Add New Product
    Then Validate that product has been added
    
  @SmokeTest
  Scenario: POST API Test 2 - add new product with missing field value
    When Add New Product With One Missing Field
    Then Validate that product has not been added
    
  @SmokeTest
  Scenario: POST API Test 3 - add new product with all missing fields
    When Add New Product With All Missing Fields
    Then Validate that product has not been added
    
  @SmokeTest
  Scenario: POST API Test 4 - add new product with incorrect fields values
    When Add New Product With Incorrect Fields Values
    Then Validate that product has not been added