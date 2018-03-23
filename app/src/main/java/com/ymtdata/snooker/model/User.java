package com.ymtdata.snooker.model;

/**
 * Created by Administrator on 2016/2/28.
 */
public class User {

    private String name;
    private String avatar;
    private String age;

    private String title;

    public User(){

    }

    public User(String name, String avatar, String age) {
        this.name = name;
        this.avatar = avatar;
        this.age = age;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


}
