package com.test.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import com.test.utilities.Globals;

public class DeleteProduct extends Globals { 
	//send DELETE response
    public void deleteProduct(int id) {
        response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .delete("https://api.escuelajs.co/api/v1/products/" + String.valueOf(id))
                .prettyPeek();
    }

    public void validateThatProductsHasBeenDeleted() {
    	//assert response code
        Assert.assertEquals(200, response.statusCode());
    }
    
    public void validateThatProductsHasNotBeenDeleted() {
    	//assert response code
        Assert.assertEquals(400, response.statusCode());
    }
}
