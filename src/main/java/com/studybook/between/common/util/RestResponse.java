package com.studybook.between.common.util;

public class RestResponse<T> extends GsonToString {

    private String responseCode;
    private String message;
    private T data;

    public RestResponse(ResponseCode responseCode, T data) {
        this.responseCode = responseCode.getCode();
        this.message = responseCode.name();
        this.data = data;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}