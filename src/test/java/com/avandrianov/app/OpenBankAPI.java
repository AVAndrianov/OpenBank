package com.avandrianov.app;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.json.JsonException;
import org.testng.Assert;
import org.testng.annotations.Test;



public class OpenBankAPI {
    @Test
    public void testName()  throws JsonException {
        RestAssured.baseURI = "https://reqres.in";
        Response response = null;
        try {
            response = (Response) RestAssured.given()
                    .when()
                    .get("/api/users?page=2")
            ;}
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Assert.assertNotNull(response);
        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
    }
    }
