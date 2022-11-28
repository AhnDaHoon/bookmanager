package com.dh.jpa.bookmanager.repository;

import com.dh.jpa.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    List<User> findFirst1ByName(String name);

    List<User> findTop1ByName(String name);

    List<User> findLast1ByName(String name);
}
