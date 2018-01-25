package com.studybook.between.user.controller;

import com.studybook.between.common.util.ResponseCode;
import com.studybook.between.common.util.RestResponse;
import com.studybook.between.user.model.User;
import com.studybook.between.user.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/v1")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/profile", method = RequestMethod.POST)
    public RestResponse createUserProfile(@RequestBody User user) {

        log.info("createUserProfile user : ");
        log.info(user);

        userService.createUserProfile(user);

        return new RestResponse(ResponseCode.SUCCESS, null);
    }

    @RequestMapping(value = "/user/profile/{userId}", method = RequestMethod.GET)
    public RestResponse getUserProfile(@PathVariable("userId") String userId) {

        log.info("getUserProfile userId : " + userId);

        User user = userService.getUserProfile(userId);

        return new RestResponse(ResponseCode.SUCCESS, user);
    }

    @RequestMapping(value = "/user/profile/image", method = RequestMethod.POST)
    public RestResponse uploadUserProfileImage(MultipartFile multipartFile, @RequestParam("userId") String userId) {

        log.info("uploadUserProfileImage userId : " + userId);

        // TODO [hongsik.kim] 이미지 업로드 처리 해야함.

        return new RestResponse(ResponseCode.SUCCESS, null);
    }

    @RequestMapping(value = "/user/profile/image/{imageId}", method = RequestMethod.GET)
    public RestResponse downloadUserProfileImage(@PathVariable("imageId") String imageId) {

        log.info("downloadUserProfileImage imageId : " + imageId);

        // TODO [hongsik.kim] 이미지 다운로드 처리 해야함.

        return new RestResponse(ResponseCode.SUCCESS, null);
    }
}
