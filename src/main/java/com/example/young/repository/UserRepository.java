package com.example.young.repository;

import com.example.young.model.User;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(long id);
    Optional<User> findByName(String name);
    List<User> findAll();
}
