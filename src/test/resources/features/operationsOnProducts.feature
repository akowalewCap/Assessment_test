Feature: OPERATIONS ON PRODUCTS

@SmokeTest @E2eTest
Scenario: API CRUD OPERATIONS Test 1 - check last added product
  Given New product has been added
  When Get last added product
  And It is validated that product is listed
  Then Update last product
  And Validate that product has been updated