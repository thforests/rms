package com.bean;

import javax.management.relation.Role;

public class User {
    private Integer id;//登录ID
    private String name;//用户姓名
    private String password;//登录密码
    private Integer type;//级别
    private String tell;//联系方式
    private Role role;//职位

    public User(){

    }
    public User(String name,String password,Integer type,String tell){
//        this.id = id;
        this.name = name;
        this.password = password;
        this.type = type;
        this.tell = tell;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String phone) {
        this.tell = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", phone='" + tell + '\'' +
                '}';
    }
}
