package com.example.young;

import com.example.young.repository.UserRepository;
import com.example.young.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final UserRepository userRepository;

    public SpringConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Bean
    public UserService userService() {
        return new UserService(userRepository);
    }

//    @Bean
//    public UserRepository userRepository() {
//        return new JpaUserRepository(em);
//    }



}
