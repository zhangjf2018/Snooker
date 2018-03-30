package com.ymtdata.snooker.model;

/**
 * Created by zhangjifeng on 2018/3/30.
 * email : 414512194@qq.com
 * desc  :
 */

public class StandListModel {
    private String id;
    private String name;
    private String startTime;
    private String standType;
    private String snookerTableName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSnookerTableName() {
        return snookerTableName;
    }

    public void setSnookerTableName(String snookerTableName) {
        this.snookerTableName = snookerTableName;
    }

    public String getStandType() {

        return standType;
    }

    public void setStandType(String standType) {
        this.standType = standType;
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
}
