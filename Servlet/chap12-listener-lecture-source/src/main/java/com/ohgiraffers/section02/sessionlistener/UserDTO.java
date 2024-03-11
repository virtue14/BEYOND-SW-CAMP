package com.ohgiraffers.section02.sessionlistener;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class UserDTO implements HttpSessionBindingListener {
    private String name;
    private int age;


    public UserDTO() {
    }

    public UserDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("UserDTO가 담김");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("UserDTO 제거됨");
    }
}
