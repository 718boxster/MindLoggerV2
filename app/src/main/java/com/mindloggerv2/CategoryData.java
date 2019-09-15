package com.mindloggerv2;

public class CategoryData {
    String title;
    int res;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public CategoryData(String title, int res) {
        this.title = title;
        this.res = res;
    }
}
