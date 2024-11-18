package com.test.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import com.test.utilities.Globals;

public class GetProduct extends Globals {
	//send GET response for all products
    public void getAllProducts() {
        response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.escuelajs.co/api/v1/products");
    	}
       
   //send GET response for single product
    public void getSingleProduct(int id) {
        response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.escuelajs.co/api/v1/products/" + String.valueOf(id));
        }

    public void validateThatAllProductsAreListed() {
    	//assert response code
        Assert.assertEquals(200, response.statusCode());

        //get the data from body
        productTitle = response.path("title");

        //assert that all products titles are not null
        productTitle.forEach(number -> Assert.assertNotNull(number));
        productTitle.forEach(Assert::assertNotNull);

        for (String productTitle : productTitle) {
            Assert.assertNotNull(productTitle);
        }
    }
    
    public void validateThatSingleProductIsListed() {
    	//assert response code
        Assert.assertEquals(200, response.statusCode());
    }
    
    public void validateThatSingleProductIsNotListed() {
    	//assert response code
        Assert.assertEquals(400, response.statusCode());
    }
}
