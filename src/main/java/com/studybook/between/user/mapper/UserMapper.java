package com.studybook.between.user.mapper;

import com.studybook.between.user.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    void createUserProfile(@Param("user") User user);

    User getUserProfile(@Param("userId") String userId);
}
