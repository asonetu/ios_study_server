package com.studybook.between.auth.controller;

import com.studybook.between.auth.model.LoginResult;
import com.studybook.between.auth.service.AuthService;
import com.studybook.between.common.util.ResponseCode;
import com.studybook.between.common.util.RestResponse;
import com.studybook.between.user.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class AuthController {

    private static final Logger log = Logger.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/auth/signin", method = RequestMethod.POST)
    public RestResponse signin(@RequestBody User user) {

        log.info("signin user : ");
        log.info(user);

        LoginResult loginResult = authService.signin(user);

        return new RestResponse(ResponseCode.SUCCESS, loginResult);
    }

    @RequestMapping(value = "/auth/signup", method = RequestMethod.POST)
    public RestResponse signup(@RequestBody User user) {

        log.info("signin user : ");
        log.info(user);

        LoginResult loginResult = authService.signup(user);

        return new RestResponse(ResponseCode.SUCCESS, loginResult);
    }

}