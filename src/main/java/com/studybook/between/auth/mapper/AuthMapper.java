package com.studybook.between.auth.mapper;

import com.studybook.between.user.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthMapper {

    User getUser(@Param("email") String email);

    List<User> getUsersByCoupleEmail(@Param("coupleEmail") String coupleEmail);

    void createUser(@Param("user") User user);

    void updateUserActivate(@Param("email") String email);

    void deleteUserByEmails(@Param("emails") List<String> emails);

    void deleteNotMatchedUser(@Param("coupleEmail") String coupleEmail);
}