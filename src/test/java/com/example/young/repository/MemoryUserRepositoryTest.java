package com.example.young.repository;

import static org.assertj.core.api.Assertions.*;

import com.example.young.model.User;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemoryUserRepositoryTest {


    MemoryUserRepository repository = new MemoryUserRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        User user = new User();
        user.setName("youjin");

        repository.save(user);

        User result = repository.findById(user.getId()).get();

        assertThat(user).isEqualTo(result);

    }

    @Test
    public void findByName() {
        User user1 = new User();
        user1.setName("spring1");
        repository.save(user1);

        User user2 = new User();
        user2.setName("spring2");
        repository.save(user2);

        User result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(user1);
    }

    @Test
    public void findAll() {
        User user1 = new User();
        user1.setName("spring1");
        repository.save(user1);

        User user2 = new User();
        user2.setName("spring2");
        repository.save(user2);

        List<User> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
