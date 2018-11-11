package com.lzc.demo.dto;


import java.util.HashMap;
import java.util.Map;

/**
 * @author 2018/11/11
 * 实体类
 */

public class User {
    private static final Map<Integer,User> users = new HashMap<>();
    static {
        users.put(1, new User(1, "liang1", 18, "北京"));
        users.put(2, new User(2, "liang2", 19, "上海"));
        users.put(3, new User(3, "liang3", 20, "广州"));
        users.put(4, new User(4, "liang4", 21, "深圳"));
        users.put(5, new User(5, "liang5", 22, "杭州"));
    }

    public User(Integer id, String username, Integer age, String address) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.address = address;
    }
    public User() {

    }
    public Integer id;
    public String username;
    public Integer age;
    public String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Map<Integer, User> getUsers() {
        return users;
    }
}
