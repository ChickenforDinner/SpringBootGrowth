package com.bjfu.newsrecommendation.DAO;

import java.util.Date;
public class User {
    private String name;
    private Byte age;
    private Boolean gender;
    private Date createTime;
    private Date updateTime;

    public User() {
    }

    public User(String name, Byte age, Boolean gender, Date createTime, Date updateTime) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
