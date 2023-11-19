package com.example.young.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.young.model.User;
import com.example.young.repository.MemoryUserRepository;
import java.util.Optional;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    UserService userService;
    MemoryUserRepository userRepository;


    @BeforeEach  //테스트를 실행 하기 전에
    public void beforeEach() {
        userRepository = new MemoryUserRepository();
        userService = new UserService(userRepository);
    }


    @AfterEach
    public void afterEach(){
        userRepository.clearStore();
    }

    @Test
    void join() {
        //given
        User user = new User();
        user.setName("hello");

        //when
        Long saveId = userService.join(user);

        //then
        User findUser = userService.fineOne(saveId).get();
        assertThat(user.getName()).isEqualTo(findUser.getName());

    }

    @Test
    public void 중복_회원_예외() {
        //given

        User user1 = new User();
        user1.setName("spring");

        User user2 = new User();
        user2.setName("spring");

        //when
        userService.join(user1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> userService.join(user2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then
    }


    @Test
    void findUsers() {
    }

    @Test
    void fineOne() {
    }
}