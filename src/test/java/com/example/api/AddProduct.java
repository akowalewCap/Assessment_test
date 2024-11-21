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

public class AddProduct extends Globals {

	public void addNewProduct() {
		Faker faker = new Faker();

		// create fake data for new product
		ConfigurationReader.set("title", faker.commerce().productName());
		ConfigurationReader.set("price", faker.number().digits(3));
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

		// send POST response
		response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(bodyMap).when()
				.post("https://api.escuelajs.co/api/v1/products/");
	}

	public void addNewProductWithOneMissingField() {
		Faker faker = new Faker();

		// create fake data for new product with missing title
		ConfigurationReader.set("price", faker.number().digit());
		ConfigurationReader.set("description", faker.commerce().color() + faker.commerce().material());
		ConfigurationReader.set("images", faker.internet().image());
		ConfigurationReader.set("categoryId", faker.number().digit());

		// create JSON body map based on fake data
		Map<String, Object> bodyMap = new HashMap<>();
		bodyMap.put("price", Integer.parseInt(ConfigurationReader.get("price")));
		bodyMap.put("description", ConfigurationReader.get("description"));
		bodyMap.put("categoryId", Integer.parseInt(ConfigurationReader.get("categoryId")));
		bodyMap.put("images", Collections.singletonList(ConfigurationReader.get("images")));

		// send POST response
		response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(bodyMap).when()
				.post("https://api.escuelajs.co/api/v1/products/");
	}

	public void addNewProductWithIncorrectFieldsValues() {
		// create JSON body map based on fake data
		Map<String, Object> bodyMap = new HashMap<>();
		bodyMap.put("title", null);
		bodyMap.put("price", null);
		bodyMap.put("description", null);
		bodyMap.put("categoryId", null);
		bodyMap.put("images", null);

		// send POST response
		response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(bodyMap).when()
				.post("https://api.escuelajs.co/api/v1/products/");
	}

	public void addNewProductWithAllMissingFields() {
		Map<String, Object> bodyMap = new HashMap<>();

		// send POST response
		response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(bodyMap).when()
				.post("https://api.escuelajs.co/api/v1/products/");
	}

	public void validateThatProductHasBeenAdded() {
		// assert response code CREATED
		Assert.assertEquals(201, response.statusCode());
	}

	public void validateThatProductHasNotBeenAdded() {
		// assert response code
		Assert.assertEquals(400, response.statusCode());
	}
}
