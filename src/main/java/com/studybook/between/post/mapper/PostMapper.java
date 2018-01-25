package com.studybook.between.post.mapper;

import com.studybook.between.post.model.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostMapper {

    List<Post> getPosts(@Param("email") String email);

    Post getPost(@Param("postId") int postId);

    void createPost(@Param("post") Post post);
}
