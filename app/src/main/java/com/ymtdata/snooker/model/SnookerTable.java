package com.ymtdata.snooker.model;

/**
 * Created by Administrator on 2016/2/28.
 */
public class SnookerTable {

    private String name;     // 球台名称
    private String status;  //球台状态
    private String id;       //球台ID

    public SnookerTable(){
    }

    public SnookerTable(String name, String id, String status) {
        this.name = name;
        this.status = status;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
