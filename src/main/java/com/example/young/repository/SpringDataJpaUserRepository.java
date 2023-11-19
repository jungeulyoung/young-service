package com.example.young.repository;

import com.example.young.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaUserRepository  extends JpaRepository<User, Long>, UserRepository {

    @Override
    Optional<User> findByName(String name);
}
