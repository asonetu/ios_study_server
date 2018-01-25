package com.studybook.between.common.util;

public class SearchCondition extends GsonToString {
    private int currentPage = 1;
    private int perPage = 10;
    private int startNum;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        this.startNum = currentPage * perPage;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
        this.startNum = currentPage * perPage;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }
}