package com.th.mybatisTest.po;

/**
 * Created by tianhui on 16/9/4.
 */
public class User {
    private long id;
    private String userName;
    private int age;
    private String sex;
    private String remark;

    public String getUserName() {
        return userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public User() {
    }

    public User(String userName, int age, String sex, String remark) {
        this.userName = userName;
        this.age = age;
        this.sex = sex;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
