package com.ymtdata.snooker.model;

/**
 * Created by ai on 2018/3/31.
 */
public class LadderPlayerRecordModel {
    private String id;
    private String name;
    private String startTime;
    private String gender;
    private String price;
    private String snookerTableName;

    public String getSnookerTableName() {
        return snookerTableName;
    }

    public void setSnookerTableName(String snookerTableName) {
        this.snookerTableName = snookerTableName;
    }

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

    public String getStartTime() {

        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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
