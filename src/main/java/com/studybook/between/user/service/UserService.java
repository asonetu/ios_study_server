package com.studybook.between.user.service;

import com.studybook.between.user.dao.UserDao;
import com.studybook.between.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void createUserProfile(User user) {
        userDao.createUserProfile(user);
    }

    public User getUserProfile(String userId) {
        return userDao.getUserProfile(userId);
    }
}
