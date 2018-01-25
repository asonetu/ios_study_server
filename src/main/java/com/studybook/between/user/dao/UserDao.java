package com.studybook.between.user.dao;

import com.studybook.between.user.mapper.UserMapper;
import com.studybook.between.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public void createUserProfile(User user) {
        userMapper.createUserProfile(user);
    }

    public User getUserProfile(String userId) {
        return userMapper.getUserProfile(userId);
    }
}
