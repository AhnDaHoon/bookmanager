package com.dh.jpa.bookmanager.domain.listener;

import com.dh.jpa.bookmanager.domain.User;
import com.dh.jpa.bookmanager.domain.UserHistory;
import com.dh.jpa.bookmanager.repository.UserHistoryRepository;
import com.dh.jpa.bookmanager.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

// EntityListener는 Bean을 주입받지 못한다.
// 그래서 BeanUtils.class를 만들어 사용한다.
//@Component
public class UserEntityListener {

    @PostPersist
    @PostUpdate
    public void prePersistAndPreUpdate(Object o){
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        User user = (User)o;
        UserHistory userHistory = new UserHistory();
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        userHistory.setUser(user);

        userHistoryRepository.save(userHistory);
    }
}
