package com.juaracoding.duadua;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class DeleteData {
    String endpoint = "https://mern-backend-8881.herokuapp.com/products/63591637f3b6006945f67354";

    @Test(priority = 1)
    public void testStatusCode() {
        when()
                 .delete(endpoint);

    }

    @Test(priority = 2)
    public void testDelete() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200);
    }
}
