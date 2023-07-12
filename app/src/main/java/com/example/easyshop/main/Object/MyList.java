package com.example.easyshop.main.Object;

import java.util.ArrayList;

public class MyList {
    private String userEmail;
    private ArrayList<Item> list = new ArrayList<>();

    public MyList() {}

    public String getUserEmail() { return userEmail; }

    public MyList setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public ArrayList<Item> getList() { return list; }

    public MyList setList(ArrayList<Item> createdList) {
        this.list = createdList;
        return this;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "name='" + userEmail + '\'' +
                ", createdList=" + list +
                '}';
    }
}
