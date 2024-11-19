Feature: DELETE PRODUCTS

  @SmokeTest
  Scenario: DELETE API Test 1 - delete product
    When Delete Product with ID 40
    Then Validate that product has been deleted
    
  @SmokeTest
  Scenario: DELETE API Test 2 - delete non-existing product
    When Delete Product with ID 5000
    Then Validate that product has not been deleted