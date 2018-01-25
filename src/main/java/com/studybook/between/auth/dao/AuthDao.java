package com.studybook.between.auth.dao;

import com.studybook.between.auth.mapper.AuthMapper;
import com.studybook.between.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthDao {

    @Autowired
    private AuthMapper authMapper;

    public User getUser(String email) {
        return authMapper.getUser(email);
    }

    public List<User> getUsersByCoupleEmail(String coupleEmail) {
        return authMapper.getUsersByCoupleEmail(coupleEmail);
    }

    public void createUser(User user) {
        authMapper.createUser(user);
    }

    public void updateUserActivate(String email) {
        authMapper.updateUserActivate(email);
    }

    public void deleteUserByEmails(List<String> emails) {
        authMapper.deleteUserByEmails(emails);
    }

    public void deleteNotMatchedUser(String email) {
        authMapper.deleteNotMatchedUser(email);
    }
}
