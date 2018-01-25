package com.studybook.between.post.service;

import com.studybook.between.post.dao.PostDao;
import com.studybook.between.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    public List<Post> getPosts(String email) {
        return postDao.getPosts(email);
    }

    public Post getPost(int postId) {
        return postDao.getPost(postId);
    }

    public void createPost(Post post) {
        postDao.createPost(post);
    }
}
