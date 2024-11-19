package com.example.api;

import org.junit.Assert;

import com.example.utilities.Globals;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetProduct extends Globals {
	// send GET response for all products
	public static void getAllProducts() {
		response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).when()
				.get("https://api.escuelajs.co/api/v1/products");
	}

	// send GET response for single product
	public void getSingleProduct(int id) {
		response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).when()
				.get("https://api.escuelajs.co/api/v1/products/" + String.valueOf(id));
	}

	public void getLastProduct() {
		Integer lastProductId = null;

		getAllProducts();
		productsIds = response.path("id");

		// if list of IDs is not empty, get last product
		try {
			lastProductId = productsIds.get(productsIds.size() - 1);
			getSingleProduct(lastProductId);
		} catch (Exception e) {
			System.err.println("List of products is empty.");
			e.printStackTrace();
		}
	}

	public void validateThatAllProductsAreListed() {
		// assert response code
		Assert.assertEquals(200, response.statusCode());

		// get the data from body
		productTitle = response.path("title");

		// assert that all products titles are not null
		productTitle.forEach(Assert::assertNotNull);

		for (String productTitle : productTitle) {
			Assert.assertNotNull(productTitle);
		}
	}

	public void validateThatSingleProductIsListed() {
		// assert response code
		Assert.assertEquals(200, response.statusCode());
	}

	public void validateThatSingleProductIsNotListed() {
		// assert response code
		Assert.assertEquals(400, response.statusCode());
	}
}
