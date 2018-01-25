package com.studybook.between.common.util;

import com.google.gson.Gson;

public class GsonToString {

    private static Gson gson = new Gson();

    @Override
    public String toString() {
        return gson.toJson(this).toString();
    }
}