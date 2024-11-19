Feature: UPDATE PRODUCTS

  @api1
  Scenario: PUT API Test 1 - update product
    When Update Product with ID 128
    Then Validate that product has been updated
    
  @api1
  Scenario: PUT API Test 2 - update the product with an invalid value
    When Update Product with ID 128 Where Field Value Is Incorrect
    Then Validate that product has not been updated
    
	@api2
  Scenario: PUT API Test 3 - update non-existing product
    When Update Product with ID 3000
    Then Validate that product has not been updated
    
 	@api3
  Scenario: PATCH API Test 4 - partially update product
    When Partially Update Product with ID 122
    Then Validate that product has been updated
  
    @api1
  Scenario: PATCH API Test 5 - partially update the product with an invalid value
    When Partially Update Product with ID 128 Where Field Value Is Incorrect
    Then Validate that product has not been updated
  
  @api4
  Scenario: PATCH API Test 6 - partially update non-existing product
    When Partially Update Product with ID 3000
    Then Validate that product has not been updated