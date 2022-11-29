package com.dh.jpa.bookmanager.repository;

import com.dh.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.time.LocalDateTime;
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
//        System.out.println(userRepository.findByName("martin"));
//
//        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));
//        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
//        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("martin"));
//        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));

//        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastcampus.com", "martin"));
//        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@fastcampus.com", "martin"));
//
//        // 숫자 날짜 비교 키워드
//        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
//        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1)));
//        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1)));
//        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1)));
//
//        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1)));
//        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
//        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

        // 빈값 조회 키워드
//        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());

        // findByIdIsNotEmpty는 컬렉션 타입의 NotEmpty를 검사함
//        System.out.println("findByAddressIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());

        // in절 만약 리스트에 값이 너무 많으면 성능저하가 일어난다 (in절과 or은 풀스캔을 하기 때문에 속도가 느려짐)
//        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin", "dennis")));

        // like
        System.out.println("findByNameLike : " + userRepository.findByNameLike("%art%"));
        // 위에서 like를 쓰려면 %를 사용해야 하지만 밑에 메서드를 이용하면 %를 안쓰고 사용할 수 있다.
        // mar%
        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
        // %tin
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("tin"));
        // %art%
        System.out.println("findByNameContains : " + userRepository.findByNameContains("art"));


    }

    @Test
    void pagingAndSortingTest(){
//        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
//        // findLast1ByName 이 메서드는 제대로 실행이 되지 않는다.
//        // Test는 통과하였지만 정상 작동은 아니다.
//        // Last 라는 Keyword는 JPA에서 감지하지 못하기 때문이다. 그래서 일반 select쿼리를 뱉어냈다.
//        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));
//        // 만약 마지막 1개의 데이터를 뽑고 싶으면 OrderByIdDesc 키워드를 붙여서 해서 역순으로 뽑으면 된다.
//        System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("martin"));
//
//        // id 정순 sort, email 역순 sort
//        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));

        // 파라미터로 sort를 받아서 사용
        System.out.println("findFirstByName : " + userRepository.findFirstByName("martin", Sort.by(Sort.Order.desc("id"))));
    }

}
