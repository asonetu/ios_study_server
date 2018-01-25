package com.studybook.between.post.dao;

import com.studybook.between.post.mapper.PostMapper;
import com.studybook.between.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDao {

    @Autowired
    private PostMapper postMapper;

    public List<Post> getPosts(String email) {
        return postMapper.getPosts(email);
    }

    public Post getPost(int postId) {
        return postMapper.getPost(postId);
    }

    public void createPost(Post post) {
        postMapper.createPost(post);
    }
}
