package com.juaracoding.duadua;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetList {
    String endpoint = "https://mern-backend-8881.herokuapp.com/products";

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
    public void testGetlist() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("_id[17]", equalTo("630504187207f2c541e470e3"));
    }
}