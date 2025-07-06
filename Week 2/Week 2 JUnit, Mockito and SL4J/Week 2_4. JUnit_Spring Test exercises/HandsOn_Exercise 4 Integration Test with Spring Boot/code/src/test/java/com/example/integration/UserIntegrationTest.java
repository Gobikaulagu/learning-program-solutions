package com.example.integration;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort; 
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setup() {
        userRepository.deleteAll();
        userRepository.save(new User(1L, "Gobika"));
    }

    @Test
    void testGetUser() {
        ResponseEntity<User> response = restTemplate.getForEntity("http://localhost:" + port + "/users/1", User.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Gobika", response.getBody().getName());
    }

    @Test
    void testCreateUser() {
        User newUser = new User(2L, "Ulaganathan");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(newUser, headers);

        ResponseEntity<User> response = restTemplate.postForEntity("http://localhost:" + port + "/users", request, User.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Ulaganathan", response.getBody().getName());
    }
}
