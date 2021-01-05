package com.spring.training.dayone.controller;

import com.spring.training.dayone.entity.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testWithoutName(){
        ResponseEntity<Greeting> entity = restTemplate.getForEntity("/greet", Greeting.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        assertEquals("hello, World", response.getMessage());
    }

    @Test
    void testName(){
        Greeting greeting = restTemplate.getForObject("/greet?name=sunil", Greeting.class);
        /*assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
        Greeting response = entity.getBody();*/
        assertEquals("hello, sunil", greeting.getMessage());
    }

}
