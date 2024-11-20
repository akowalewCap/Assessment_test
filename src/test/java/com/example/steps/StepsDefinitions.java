package com.example.steps;

import com.example.api.AddProduct;
import com.example.api.DeleteProduct;
import com.example.api.GetProduct;
import com.example.api.UpdateProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinitions {
    GetProduct GetProduct = new GetProduct();
    AddProduct AddProduct = new AddProduct();
    UpdateProduct UpdateProduct = new UpdateProduct();
    DeleteProduct DeleteProduct = new DeleteProduct();

    // steps for GET operations
    @When("Get all products")
    public void get_all_products() {
        GetProduct.getAllProducts();
    }

    @When("Get a single product with ID {int}")
    public void get_single_product(int id) {
        GetProduct.getSingleProduct(id);
    }

    @When("Get last added product")
    public void get_last_product() {
        GetProduct.getLastProduct();
    }

    @Then("Validate that all products are listed")
    public void validate_that_all_products_are_listed() {
        GetProduct.validateThatAllProductsAreListed();
    }

    @Then("Validate that product is listed")
    @And("It is validated that product is listed")
    public void validate_that_product_is_listed() {
        GetProduct.validateThatSingleProductIsListed();
    }

    @Then("Validate that product is not listed")
    public void validate_that_product_is_not_listed() {
        GetProduct.validateThatSingleProductIsNotListed();
    }

    // steps for POST operations
    @When("Add new product")
    @Given("New product has been added")
    public void add_new_product() {
        AddProduct.addNewProduct();
    }

    @When("Add new product with one missing field")
    public void add_new_product_with_one_missing_field() {
        AddProduct.addNewProductWithOneMissingField();
    }

    @When("Add new product with all missing fields")
    public void add_new_product_with_all_missing_fields() {
        AddProduct.addNewProductWithAllMissingFields();
    }

    @When("Add new product with incorrect fields values")
    public void add_new_product_with_incorrect_fields_values() {
        AddProduct.addNewProductWithIncorrectFieldsValues();
    }

    @Then("Validate that product has been added")
    @Given("It is validated that product has been added")
    public void validate_that_product_has_been_added() {
        AddProduct.validateThatProductHasBeenAdded();
    }

    @Then("Validate that product has not been added")
    public void validate_that_product_has_not_been_added() {
        AddProduct.validateThatProductHasNotBeenAdded();
    }

    // steps for PUT operations
    @When("Update product with ID {int}")
    public void update_product(int id) {
        UpdateProduct.updateProduct(id);
    }

    @When("Update last product")
    public void update_last_product() {
        UpdateProduct.updateLastProduct();
    }

    @When("Update product with ID {int} where field value is incorrect")
    public void update_product_with_incorrect_field_value(int id) {
        UpdateProduct.updateProductWithIncorrectFieldValue(id);
    }

    @Then("Validate that product has been updated")
    public void validate_that_product_has_been_updated() {
        UpdateProduct.validateThatProductHasBeenUpdated();
    }

    @Then("Validate that product has not been updated")
    public void validate_that_product_has_not_been_updated() {
        UpdateProduct.validateThatProductHasNotBeenUpdated();
    }

    // steps for PATCH operations
    @When("Partially update product with ID {int}")
    public void partially_update_product(int id) {
        UpdateProduct.partiallyUpdateProduct(id);
    }

    @When("Partially update last product")
    public void partially_update_last_product() {
        UpdateProduct.partiallyUpdateLastProduct();
    }

    @When("Partially update product with ID {int} where field value is incorrect")
    public void partially_update_product_with_incorrect_field_value(int id) {
        UpdateProduct.partiallyUpdateProductWithIncorrectFieldValue(id);
    }

    @Then("Validate that product has not been found")
    public void validate_that_product_has_not_been_found() {
        UpdateProduct.validateThatProductHasNotBeenFound();
    }

    // steps for DELETE operations
    @When("Delete existing product")
    @When("Delete last product")
    public void delete_product() {
        DeleteProduct.deleteProduct();
    }

    @Then("Delete non-existing product")
    public void delete_last_product() {
        DeleteProduct.deleteNonExistingProduct();
    }

    @Then("Validate that product has been deleted")
    public void validate_that_product_has_been_deleted() {
        DeleteProduct.validateThatProductsHasBeenDeleted();
    }

    @Then("Validate that product has not been deleted")
    public void validate_that_product_has_not_been_deleted() {
        DeleteProduct.validateThatProductsHasNotBeenDeleted();
    }
}
