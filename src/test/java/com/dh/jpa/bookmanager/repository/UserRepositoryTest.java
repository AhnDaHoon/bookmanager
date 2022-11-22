package com.dh.jpa.bookmanager.repository;

import com.dh.jpa.bookmanager.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {


    @Autowired
    UserRepository userRepository;

    void crud(){
        userRepository.save(new User());

        System.out.println(">>>" + userRepository.findAll());
    }

}