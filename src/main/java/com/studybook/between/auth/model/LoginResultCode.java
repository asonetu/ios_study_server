package com.studybook.between.auth.model;

public enum LoginResultCode {
    SUCCESS("100"),

    WAITING("200"),

    INVALID_COUPLE_EMAIL("300"),
    ALREADY_EXIST_EMAIL("301"),
    INVALID_PASSWORD("302"),
    INVALID_ACCOUNT("303");

    private String code;

    LoginResultCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
