package com.avandrianov.app;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class OpenBankAPI2 {
    @Test
    public void testName() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        String email = "george.bluth@reqres.in";
        String first_name = "George";
        String last_name = "Bluth";
        String avatar = "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg";
        JsonObject loginCredentials = new JsonObject();
        loginCredentials.addProperty("email", email);
        loginCredentials.addProperty("first_name", first_name);
        loginCredentials.addProperty("last_name", last_name);
        loginCredentials.addProperty("avatar", avatar);
        httpRequest.body(loginCredentials.toString());
        Response response = httpRequest.post("/api/users");
        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
    }
}
