package com.example.young.service;

import com.example.young.model.User;
import com.example.young.repository.MemoryUserRepository;
import com.example.young.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository = new MemoryUserRepository();


    /**
     * 회원 가입
     *
     * @param user
     * @return long
     */
    public Long join(User user) {
        // 같은 이름이 있는 중복 회원X
        validateDuplicateUser(user); //중복회원 검증

        userRepository.save(user);
        return user.getId();
    }


    private void validateDuplicateUser(User user) {
        userRepository.findByName(user.getName())
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     *
     * @return
     */
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> fineOne(long userId) {
        return userRepository.findById(userId);
    }


}
