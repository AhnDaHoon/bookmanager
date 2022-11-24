package com.dh.jpa.bookmanager.repository;

import com.dh.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud(){
        // 전체 조회 sort: name
        // List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));

        // 아이디로 조회 id: 1, 2, 5
        // List<Long> ids = new ArrayList<>();
        // List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 2L, 5L));

        User user1 = new User("jack", "jack@naver.com");
        User user2 = new User("jack2", "jack2@naver.com");

        userRepository.saveAll(Lists.newArrayList(user1, user2));

        List<User> users = userRepository.findAll();

        users.forEach(System.out::println);

    }
}
