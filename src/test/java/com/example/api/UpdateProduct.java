package com.example.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import com.example.utilities.ConfigurationReader;
import com.example.utilities.Globals;
import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateProduct extends Globals {
	private Faker faker = new Faker();

	public void updateProduct(int id) {
		// create fake data for new product
		ConfigurationReader.set("title", faker.commerce().productName());
		ConfigurationReader.set("price", faker.number().digits(3).toString());
		ConfigurationReader.set("description", faker.commerce().color() + faker.commerce().material());
		ConfigurationReader.set("images", faker.internet().image());
		ConfigurationReader.set("categoryId", String.valueOf(faker.number().numberBetween(1, 5)));

		// create JSON body map based on fake data
		Map<String, Object> bodyMap = new HashMap<>();
		bodyMap.put("title", ConfigurationReader.get("title"));
		bodyMap.put("price", Integer.parseInt(ConfigurationReader.get("price")));
		bodyMap.put("description", ConfigurationReader.get("description"));
		bodyMap.put("categoryId", Integer.parseInt(ConfigurationReader.get("categoryId")));
		bodyMap.put("images", Collections.singletonList(ConfigurationReader.get("images")));

		// send PUT response
		response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(bodyMap).when()
				.put("https://api.escuelajs.co/api/v1/products/" + String.valueOf(id));
	}

	public void updateProductWithIncorrectFieldValue(int id) {
		// create fake data for new product
		ConfigurationReader.set("price", String.valueOf(faker.number().numberBetween(-100, -1)));

		// create JSON body map based on fake data
		Map<String, Object> bodyMap = new HashMap<>();
		bodyMap.put("title", ConfigurationReader.get("title"));
		bodyMap.put("price", Integer.parseInt(ConfigurationReader.get("price")));
		bodyMap.put("description", ConfigurationReader.get("description"));
		bodyMap.put("categoryId", Integer.parseInt(ConfigurationReader.get("categoryId")));
		bodyMap.put("images", Collections.singletonList(ConfigurationReader.get("images")));

		// send PUT response
		response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(bodyMap).when()
				.put("https://api.escuelajs.co/api/v1/products/" + String.valueOf(id));
	}

	public void partiallyUpdateProduct(int id) {
		// create fake data for new product
		ConfigurationReader.set("title", faker.commerce().productName());
		ConfigurationReader.set("price", faker.number().digits(3).toString());

		// create JSON body map based on fake data
		Map<String, Object> bodyMap = new HashMap<>();
		bodyMap.put("title", ConfigurationReader.get("title"));
		bodyMap.put("price", Integer.parseInt(ConfigurationReader.get("price")));

		// send PUT response
		response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(bodyMap).when()
				.patch("https://api.escuelajs.co/api/v1/products/" + String.valueOf(id));
	}

	public void partiallyUpdateProductWithIncorrectFieldValue(int id) {
		// create fake data for new product
		ConfigurationReader.set("price", String.valueOf(faker.number().numberBetween(-100, -1)));

		// create JSON body map based on fake data
		Map<String, Object> bodyMap = new HashMap<>();
		bodyMap.put("price", Integer.parseInt(ConfigurationReader.get("price")));

		// send PUT response
		response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(bodyMap).when()
				.patch("https://api.escuelajs.co/api/v1/products/" + String.valueOf(id));
	}

	public void validateThatProductHasBeenUpdated() {
		// assert response code
		Assert.assertEquals(200, response.statusCode());
	}

	public void validateThatProductHasNotBeenUpdated() {
		// assert response code
		Assert.assertEquals(400, response.statusCode());
	}

}