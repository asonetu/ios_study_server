package com.studybook.between.user.model;

import com.studybook.between.common.util.GsonToString;

import java.util.Date;

public class User extends GsonToString {

    private int userId;
    private String email;
    private String userName;
    private String password;
    private String coupleEmail;
    private String statusCode; // 01 : waiting, 02 : activate

    private Date createDate;
    private Date nowDate;
    private int profileFileId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCoupleEmail() {
        return coupleEmail;
    }

    public void setCoupleEmail(String coupleEmail) {
        this.coupleEmail = coupleEmail;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getNowDate() {
        return nowDate;
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }

    public int getProfileFileId() {
        return profileFileId;
    }

    public void setProfileFileId(int profileFileId) {
        this.profileFileId = profileFileId;
    }

}
