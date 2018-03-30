package com.ymtdata.snooker.model;

/**
 * Created by zhangjifeng on 2018/3/29.
 * email : 414512194@qq.com
 * desc  :
 */

public class SnookerBabyModel {

    private String id;
    private String name;
    private String wholeStandPrice;
    private String notWholeStandPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWholeStandPrice() {
        return wholeStandPrice;
    }

    public void setWholeStandPrice(String wholeStandPrice) {
        this.wholeStandPrice = wholeStandPrice;
    }

    public String getNotWholeStandPrice() {
        return notWholeStandPrice;
    }

    public void setNotWholeStandPrice(String notWholeStandPrice) {
        this.notWholeStandPrice = notWholeStandPrice;
    }
}
