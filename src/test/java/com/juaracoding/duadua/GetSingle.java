package com.juaracoding.duadua;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetSingle {
    String endpoint = "https://mern-backend-8881.herokuapp.com/products/63591637f3b6006945f67354";

    @Test(priority = 1)
    public void testStatusCode() {
        Response response = RestAssured.get(endpoint);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int actual = response.getStatusCode();
        Assert.assertEquals(actual, 200);
    }

    @Test(priority = 2)
    public void testGetSingle() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("name", equalTo("GTX 1660 Super"))
                .body("category", equalTo("Graphic card "))
                .body("price", equalTo(229));
    }

}