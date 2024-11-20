Feature: OPERATIONS ON PRODUCTS

@E2eTest
Scenario: API CRUD OPERATIONS Test 1 - check if it possible to update last added product
  Given New product has been added
  When Get last added product
  And It is validated that product is listed
  Then Update last product
  And Validate that product has been updated

@E2eTest
Scenario: API CRUD OPERATIONS Test 2 - check if it possible to update and delete product
  Given New product has been added
  And It is validated that product has been added
  When Update last product
  And Validate that product has been updated
  Then Delete last product
  And Validate that product has been deleted

@E2eTest
Scenario: API CRUD OPERATIONS Test 3 - check if it possible to delete last added product
  Given New product has been added
  When Get last added product
  And It is validated that product is listed
  Then Delete last product
  And Validate that product has been deleted

@E2eTest
Scenario: API CRUD OPERATIONS Test 4 - verify that PATCH method is not implemented
  Given New product has been added
  When Get last added product
  And It is validated that product is listed
  Then Partially update last product
  And Validate that product has not been found

@E2eTest
Scenario: API CRUD OPERATIONS Test 5 - verify that PUT method is implemented but PATCH is not
  Given New product has been added
  When Get last added product
  And It is validated that product is listed
  Then Partially update last product
  And Validate that product has not been found
  Then Update last product
  And Validate that product has been updated