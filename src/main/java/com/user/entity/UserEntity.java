package com.user.entity;

import java.util.Arrays;
import java.util.Objects;

public class UserEntity {
    private String id;
    private String name;
    private int age;
    private String sex;
    private String address;
    private String email;
    private String[] addressName;
    private String region;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getAddressName() {
        return addressName;
    }

    public void setAddressName(String[] addressName) {
        this.addressName = addressName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", addressName=" + Arrays.toString(addressName) +
                ", region='" + region + '\'' +
                '}';
    }
}
