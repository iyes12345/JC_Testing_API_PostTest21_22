package com.juaracoding.duadua;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Put_Patch {
    String endpoint = "https://mern-backend-8881.herokuapp.com/products/630504ef7207f2c541e470f3";

    @Test(priority = 1)
    public void testPut() {
        JSONObject request = new JSONObject();
        request.put("name", "NVIDIA");
        request.put("category", "VGA");
        request.put("price", 5000000);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("https://mern-backend-8881.herokuapp.com/products/630504ef7207f2c541e470f3")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 2)
    public void testvalidasiput() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("name", equalTo("NVIDIA"))
                .body("category", equalTo("VGA"))
                .body("price", equalTo(5000000));
    }

    @Test(priority = 3)
    public void testPatch() {
        JSONObject request = new JSONObject();
        request.put("name", "RTX 4090");
        request.put("category", "VGA");
        request.put("price", 30000000);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("https://mern-backend-8881.herokuapp.com/products/630504ef7207f2c541e470f3")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test(priority = 4)
    public void testvalidasipatch() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("name", equalTo("RTX 4090"))
                .body("category", equalTo("VGA"))
                .body("price", equalTo(30000000));
    }

}
