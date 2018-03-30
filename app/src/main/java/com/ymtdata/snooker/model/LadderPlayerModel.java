package com.ymtdata.snooker.model;

/**
 * Created by zhangjifeng on 2018/3/30.
 * email : 414512194@qq.com
 * desc  :
 */

public class LadderPlayerModel {
    private String id;
    private String name;
    private String gender;
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGender() {

        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
