package com.studybook.between.auth.service;

import com.studybook.between.auth.dao.AuthDao;
import com.studybook.between.auth.model.LoginResult;
import com.studybook.between.auth.model.LoginResultCode;
import com.studybook.between.auth.model.LoginStatusCode;
import com.studybook.between.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {

    @Autowired
    private AuthDao authDao;

    public LoginResult signin(User user) {
        LoginResult loginResult = new LoginResult();
        User existUser = authDao.getUser(user.getEmail());

        if(existUser == null) {
            loginResult.setLoginResultCode(LoginResultCode.INVALID_ACCOUNT);
        } else {
            // password check
            if(user.getPassword().equals(existUser.getPassword())) {
                if(LoginStatusCode.ACTIVATE.equals(existUser.getStatusCode())) {
                    loginResult.setLoginResultCode(LoginResultCode.SUCCESS);
                    loginResult.setUser(existUser);
                } else if(LoginStatusCode.WAITING.equals(existUser.getStatusCode())) {
                    loginResult.setLoginResultCode(LoginResultCode.WAITING);
                    loginResult.setUser(existUser);
                }
            } else {
                loginResult.setLoginResultCode(LoginResultCode.INVALID_PASSWORD);
            }
        }

        return loginResult;
    }

    public LoginResult signup(User user) {
        LoginResult loginResult = new LoginResult();
        User existUser = authDao.getUser(user.getEmail());

        if(existUser != null) {
            loginResult.setLoginResultCode(LoginResultCode.ALREADY_EXIST_EMAIL);

        } else {
            List<User> waitingUsers = authDao.getUsersByCoupleEmail(user.getEmail());
            if(waitingUsers.isEmpty()) {
                user.setStatusCode(LoginStatusCode.WAITING);
                authDao.createUser(user);
                loginResult.setLoginResultCode(LoginResultCode.WAITING);
            } else { // waitingUsers is not null
                int matchCount = (int) waitingUsers.stream().filter(waitingUser -> waitingUser.getEmail().equals(user.getCoupleEmail())).count();
                if(matchCount > 0) {
                    user.setStatusCode(LoginStatusCode.ACTIVATE);
                    authDao.createUser(user);
                    loginResult.setLoginResultCode(LoginResultCode.SUCCESS);

                    // 커플 계정도 활성화
                    authDao.updateUserActivate(user.getCoupleEmail());

                    // 커플 계정외 다른 계정은 삭제
                    authDao.deleteNotMatchedUser(user.getEmail());
                } else {
                    // 시간을 비교해서 24시간 이내인지 아닌지 확인
                    // 1. 24시간 초과이면 대기중이던 사용자 삭제
                    // 2. 24시간 이내인 사용자가 없으면 사용자 등록
                    // 3. 24시간 이내인 사용자가 있으면 등록 없이 종료

                    List<String> willDeleteUserEmails = waitingUsers.stream()
                            .filter(w -> w.getNowDate().getTime() - w.getCreateDate().getTime() > 1000 * 60 * 60 * 24)
                            .map(w -> w.getEmail())
                            .collect(Collectors.toList());

                    if(!willDeleteUserEmails.isEmpty()) {
                        authDao.deleteUserByEmails(willDeleteUserEmails);
                    }

                    int validWaitingUserCount = (int) waitingUsers.stream()
                            .filter(w -> w.getNowDate().getTime() - w.getCreateDate().getTime() <= 1000 * 60 * 60 * 24)
                            .count();

                    if(validWaitingUserCount < 0) {
                        user.setStatusCode(LoginStatusCode.WAITING);
                        authDao.createUser(user);
                        loginResult.setLoginResultCode(LoginResultCode.WAITING);
                    } else {
                        loginResult.setLoginResultCode(LoginResultCode.INVALID_COUPLE_EMAIL);
                    }
                }
            }
        }

        loginResult.setUser(user);
        return loginResult;
    }
}