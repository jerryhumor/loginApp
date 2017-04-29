package com.hdu.chenpengfei.loginapp;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * Created by hanjianhao on 17/4/29.
 */

public class Student extends DataSupport {

    private int id;
    @Column(nullable = false, defaultValue = "default")
    private String name;
    @Column(nullable = false, defaultValue = "14051813")
    private String schoolNumber;
    @Column(nullable = false, defaultValue = "123456")
    private String password;
    @Column(nullable = false, defaultValue = "1995年1月1日")
    private String birthday;
    @Column(nullable = false, defaultValue = "男")
    private String sex;
    @Column(nullable = false, defaultValue = "计算机学院")
    private String college;
    @Column(nullable = false, defaultValue = "14051814")
    private String classNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }
}
