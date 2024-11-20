package com.example.api;

import com.github.javafaker.Faker;
import org.junit.Assert;

import com.example.utilities.Globals;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteProduct extends Globals {
	// send DELETE response
	public void deleteProduct() {
		Integer lastProductId = null;

		GetProduct.getAllProducts();
		productsIds = response.path("id");

		// if list of IDs is not empty, get last product
		try {
			lastProductId = productsIds.get(productsIds.size() - 1);
			response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).when()
					.delete("https://api.escuelajs.co/api/v1/products/" + String.valueOf(lastProductId));
		} catch (Exception e) {
			System.err.println("List of products is empty.");
			e.printStackTrace();
		}
	}

	public void deleteNonExistingProduct() {
		Faker faker = new Faker();

		response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).when()
				.delete("https://api.escuelajs.co/api/v1/products/" + String.valueOf(faker.number().digits(3)));
	}

	public void validateThatProductsHasBeenDeleted() {
		// assert response code
		Assert.assertEquals(200, response.statusCode());
	}

	public void validateThatProductsHasNotBeenDeleted() {
		// assert response code
		Assert.assertEquals(400, response.statusCode());
	}
}
