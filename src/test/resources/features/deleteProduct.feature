Feature: DELETE PRODUCTS

  @DELETE_API
  Scenario: DELETE API Test 1 - delete product
    When Delete Product with ID 128
    Then Validate that product has been deleted
    
  @DELETE_API
  Scenario: DELETE API Test 2 - delete non-existing product
    When Delete Product with ID 5000
    Then Validate that product has not been deleted