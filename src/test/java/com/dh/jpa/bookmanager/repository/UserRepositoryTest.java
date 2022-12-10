package com.dh.jpa.bookmanager.repository;

import com.dh.jpa.bookmanager.domain.Gender;
import com.dh.jpa.bookmanager.domain.User;
import com.dh.jpa.bookmanager.domain.UserHistory;
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

    @Autowired
    private UserHistoryRepository userHistoryRepository;

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
//        System.out.println("findFirstByName : " + userRepository.findFirstByName("martin", Sort.by(Sort.Order.desc("id"))));

        // 페이징
        System.out.println("findByNameWithPaging : " + userRepository.findByName("martin", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getContent());
    }

    @Test
    void insertAndUpdateTest(){
        User user = new User();

        user.setName("martin");
        user.setEmail("martin2@fastcampus.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrrrrrrrtin");

        userRepository.save(user2);
    }

    @Test
    void enumTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRawRecord().get("gender"));
    }

    @Test
    void listenerTest(){
        User user = new User();
        user.setEmail("martin@aa.com");
        user.setName("martin");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrr");

        userRepository.save(user2);

        userRepository.deleteById(4L);

    }

    @Test
    void prePersistTest(){
        User user = new User();
        user.setEmail("asd@naver.com");
        user.setName("martin");
//        user.setCreatedAt(LocalDateTime.now());
//        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("asd@naver.com"));
    }

    @Test
    void preUpdateTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("asdasd");
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));

    }

    @Test
    void userHistoryTest(){
        User user = new User();
        user.setEmail("asdsad@asd.com");
        user.setName("martin-new");

        userRepository.save(user);

        user.setName("asdsad");

        userRepository.save(user);

        userRepository.deleteById(1L);

        userHistoryRepository.findAll().forEach(System.out::println);
    }

    @Test
    void userTest(){
        User user = new User();
        user.setEmail("dh@naver.com");
        user.setName("dh-new");

        userRepository.save(user);
        System.out.println(userRepository.findByName("dh-new"));
    }

    @Test
    void userRelationTest(){
        User user = new User();
        user.setName("david");
        user.setEmail("david@fastcampus.com");
        user.setGender(Gender.MALE);
        userRepository.save(user);

        user.setName("dada");
        userRepository.save(user);

        user.setEmail("dada@naver.com");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);

//        List<UserHistory> result = userHistoryRepository.findByUserId(
//                userRepository.findByEmail("dada@naver.com").getId()
//        );

        List<UserHistory> result = userRepository.findByEmail("dada@naver.com").getUserHistories();
        result.forEach(System.out::println);

        System.out.println("userHistory.getUser() : " + userHistoryRepository.findAll().get(0).getUser());
    }

}
