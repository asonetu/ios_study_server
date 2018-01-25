package com.studybook.between.common.util;

import java.util.List;

public class PaginatedList<T> extends GsonToString {

    private List<T> itemList;
    private int itemCount;

    private int totalPage;

    public PaginatedList() {
        super();
    }

    public PaginatedList(List<T> itemList, int itemCount) {
        super();
        this.itemList = itemList;
        this.itemCount = itemCount;
    }

    public void paginate(SearchCondition condition) {
        int perPage = condition.getPerPage();
        totalPage = itemCount / perPage + 1;
    }

    public List<T> getItemList() {
        return itemList;
    }

    public void setItemList(List<T> itemList) {
        this.itemList = itemList;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
