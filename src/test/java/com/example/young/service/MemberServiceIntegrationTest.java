package com.example.young.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.young.model.User;
import com.example.young.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;


    @Test
    void 회원가입() {
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
}
