package com.studybook.between.post.controller;

import com.studybook.between.common.util.ResponseCode;
import com.studybook.between.common.util.RestResponse;
import com.studybook.between.post.model.Post;
import com.studybook.between.post.service.PostService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class PostController {

    private static final Logger log = Logger.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public RestResponse getPosts(@RequestParam("email") String email) {

        log.info("getPosts email : " + email);

        // TODO [hongsik.kim] session 처리 전까지는 email param 일단 받음

        List<Post> postList = postService.getPosts(email);

        return new RestResponse(ResponseCode.SUCCESS, postList);
    }

    @RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
    public RestResponse getPost(@PathVariable("postId") String paramPostId) {

        log.info("getPost paramPostId : " + paramPostId);

        int postId = Integer.parseInt(paramPostId);
        Post post = postService.getPost(postId);

        return new RestResponse(ResponseCode.SUCCESS, post);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public RestResponse createPost(@RequestBody Post post) {

        log.info("createPost post : ");
        log.info(post);

        postService.createPost(post);

        return new RestResponse(ResponseCode.SUCCESS, null);
    }
}