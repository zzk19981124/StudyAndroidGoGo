package com.example.mystudygogo.bean;

import com.google.gson.annotations.Expose;

/**
 * @author hello word
 * @desc 作用描述
 * @date 2021/8/17
 */
public class User {
    private String userName;
    private String passWord;
    private boolean isStudent;
    private int age;

    private Job job;

    public User(String userName, String passWord, boolean isStudent, int age) {
        this.userName = userName;
        this.passWord = passWord;
        this.isStudent = isStudent;
        this.age = age;
    }

    //@Expose(serialize = false,deserialize = false)
    private int test1;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", isStudent=" + isStudent +
                ", age=" + age +
                ", job=" + job +
                ", test1=" + test1 +
                '}';
    }
}
