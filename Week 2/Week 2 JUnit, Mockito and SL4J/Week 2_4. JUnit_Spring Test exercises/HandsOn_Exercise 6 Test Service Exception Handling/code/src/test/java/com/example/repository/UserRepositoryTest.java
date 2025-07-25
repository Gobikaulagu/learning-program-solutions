package com.example.repository;

import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveAndFindUser() {
        // Save user
        User user = new User("Gobika");
        userRepository.save(user);

        // Fetch user
        User found = userRepository.findByName("Gobika");

        // Assert
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Gobika");
    }
}
