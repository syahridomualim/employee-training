package com.example.employeetraining.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

//    @Test
    public void testLogin() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", "admin@mail.com");
        map.add("password", "password");
        map.add("grant_type", "password");
        map.add("client_id", "my-client-web");
        map.add("client_secret", "password");

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, httpHeaders);

        ResponseEntity<String> response = testRestTemplate.postForEntity("http://localhost:8080/oauth/token", httpEntity, String.class);
        System.out.println(response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
