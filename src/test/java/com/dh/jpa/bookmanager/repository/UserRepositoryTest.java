package com.dh.jpa.bookmanager.repository;

import com.dh.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;


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

        // 전체 insert
        // User user1 = new User("jack", "jack@naver.com");
        // User user1 = new User("jack", "jack@naver.com");
        // userRepository.saveAll(Lists.newArrayList(user1, user2));
        // List<User> users = userRepository.findAll();
        // users.forEach(System.out::println);

        // userRepository.saveAndFlush(new User("new martin", "martin@fastcampus.com"));
        // userRepository.findAll().forEach(System.out::println);

        // long count = userRepository.count();
        // System.out.println(count);

        // boolean exists = userRepository.existsById(1L);
        // System.out.println(exists);

        // 삭제를 하면 hibernate가 실제 데이터가 있는지 조회하고 삭제한다.
        // userRepository.deleteById(1L);

        // deleteAll 메서드를 사용하면 성능이슈가 있다. findAll로 데이터를 다 가져온 후
        // for문으로 데이터를 삭제하기 때문이다 (만약 데이터가 천만개면 for문을 천만번 돈다.)
        // userRepository.deleteAll();

        // deleteAll에 성능 이슈 떄문에 사용하는 메서드는 deleteAllInBatch이다.
        // userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
        // userRepository.findAll().forEach(System.out::println);

        // 페이징

//        Page<User> users = userRepository.findAll(PageRequest.of(1, 3));
//        System.out.println("page : " + users);
//        System.out.println("totalElements : " + users.getTotalElements());
//        System.out.println("totalPages : " + users.getTotalPages());
//        System.out.println("numberOfElements : " + users.getNumberOfElements());
//        System.out.println("sort : " + users.getSort());
//        System.out.println("size : " + users.getSize());
//
//        users.getContent().forEach(System.out::println);


        // ExampleMatcher
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")
//                .withMatcher("email", endsWith());
//
//        Example<User> example = Example.of(new User("ma", "fastcampus.com"), matcher);
//
//        userRepository.findAll(example).forEach(System.out::println);

        userRepository.save(new User("david", "asd@naver.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-updated@naver.com");

        userRepository.save(user);

    }

    @Test
    void select(){
        System.out.println(userRepository.findByName("martin"));

        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("martin"));
        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));
    }

}
