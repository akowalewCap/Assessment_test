Feature: DELETE PRODUCTS

  @SmokeTest
  Scenario: DELETE API Test 1 - delete product
    When Delete existing product
    Then Validate that product has been deleted
    
  @SmokeTest
  Scenario: DELETE API Test 2 - delete non-existing product
    When Delete non-existing product
    Then Validate that product has not been deleted