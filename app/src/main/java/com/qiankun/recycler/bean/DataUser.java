package com.qiankun.recycler.bean;

/**
 * Created by Administrator on 2017/7/25.
 */

public class DataUser {
    private String name;



    private Boolean isClick;

    public DataUser(String name,Boolean isClick) {
        this.name = name;
        this.isClick = isClick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getClick() {
        return isClick;
    }

    public void setClick(Boolean click) {
        isClick = click;
    }
}
