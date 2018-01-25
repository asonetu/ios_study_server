package com.studybook.between.common.util;

public enum ResponseCode {
    SUCCESS("200");

    private String code;

    ResponseCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}