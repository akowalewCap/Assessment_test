package com.test.steps;

import com.test.api.GetProduct;
import com.test.api.AddProduct;
import com.test.api.UpdateProduct;
import com.test.api.DeleteProduct;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Products_stepDefs {
	GetProduct GetProduct = new GetProduct();
	AddProduct AddProduct = new AddProduct();
	UpdateProduct UpdateProduct = new UpdateProduct();
	DeleteProduct DeleteProduct = new DeleteProduct();

	// steps for GET operations
	@When("Get All Products")
	public void get_all_products() {
		GetProduct.getAllProducts();
	}

	@When("Get A Single Product with ID {int}")
	public void get_single_product(int id) {
		GetProduct.getSingleProduct(id);
	}

	@Then("Validate that all products are listed")
	public void validate_that_all_products_are_listed() {
		GetProduct.validateThatAllProductsAreListed();
	}

	@Then("Validate that product is listed")
	public void validate_that_product_is_listed() {
		GetProduct.validateThatSingleProductIsListed();
	}

	@Then("Validate that product is not listed")
	public void validate_that_product_is_not_listed() {
		GetProduct.validateThatSingleProductIsNotListed();
	}

	// steps for POST operations
	@When("Add New Product")
	public void add_new_product() {
		AddProduct.addNewProduct();
	}

	@When("Add New Product With One Missing Field")
	public void add_new_product_with_one_missing_field() {
		AddProduct.addNewProductWithOneMissingField();
	}

	@When("Add New Product With All Missing Fields")
	public void add_new_product_with_all_missing_fields() {
		AddProduct.addNewProductWithAllMissingFields();
	}

	@When("Add New Product With Incorrect Fields Values")
	public void add_new_product_with_incorrect_fields_values() {
		AddProduct.addNewProductWithIncorrectFieldsValues();
	}

	@Then("Validate that product has been added")
	public void validate_that_product_has_been_added() {
		AddProduct.validateThatProductHasBeenAdded();
	}

	@Then("Validate that product has not been added")
	public void validate_that_product_has_not_been_added() {
		AddProduct.validateThatProductHasNotBeenAdded();
	}

	// steps for PUT operations
	@When("Update Product with ID {int}")
	public void update_product(int id) {
		UpdateProduct.updateProduct(id);
	}

	@When("Update Product with ID {int} Where Field Value Is Incorrect")
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
	@When("Partially Update Product with ID {int}")
	public void partially_update_product(int id) {
		UpdateProduct.partiallyUpdateProduct(id);
	}

	@When("Partially Update Product with ID {int} Where Field Value Is Incorrect")
	public void partially_update_product_with_incorrect_field_value(int id) {
		UpdateProduct.partiallyUpdateProductWithIncorrectFieldValue(id);
	}

	// steps for DELETE operations
	@When("Delete Product with ID {int}")
	public void delete_product(int id) {
		DeleteProduct.deleteProduct(id);
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
