package com.studybook.between.auth.model;

import com.studybook.between.user.model.User;

public class LoginResult {
    private LoginResultCode loginResultCode;
    private User user;

    public LoginResultCode getLoginResultCode() {
        return loginResultCode;
    }

    public void setLoginResultCode(LoginResultCode loginResultCode) {
        this.loginResultCode = loginResultCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}