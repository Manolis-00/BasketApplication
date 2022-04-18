package com.example.basketapplication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasketControllerTest {

    private static final String ROOT_URL = "http://localhost:8081";

    @Test
    public void contextLoads() {
    }

    @Test
    public void findLandingPage() {
        Response response = RestAssured.get(ROOT_URL);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        Assert.assertNotNull(response.getBody());
    }


}
