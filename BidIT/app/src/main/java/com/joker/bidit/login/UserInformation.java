package com.joker.bidit.login;

import com.joker.bidit.dashboard.Product;

import java.util.List;

public class UserInformation {

    private static UserInformation instance = null;

    public String name;
    public String surname;
    public String phoneNo;
    public List<Product> products;

    private UserInformation() {
    }

    public static UserInformation getInstance() {
        if (instance == null) {
            instance = new UserInformation();
        }

        return instance;
    }

    public String getUserName() {
        return name;
    }

    public String getUserSurname() {
        return surname;
    }

    public String getUserPhoneNo() {
        return phoneNo;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
