package com.example.easyshop.main.Object;

import java.util.ArrayList;

public class MyList {
    private String name = "";
    private ArrayList<Item> myList = new ArrayList<>();
    private String userEmail;

    public MyList(ArrayList<Item> myList, String userEmail) {
        this.myList = myList;
        this.userEmail = userEmail;
    }

    public MyList() {}

    public String getName() { return userEmail; }

    public MyList setName(String name) {
        this.name = name;
        return this;
    }

    public ArrayList<Item> getList() { return myList; }

    public MyList setList(ArrayList<Item> createdList) {
        this.myList = createdList;
        return this;
    }

    public void addItem(String name, double price, double quantity) {
        myList.add(new Item()
                .setName(name)
                .setPrice(price)
                .setQuantity(quantity)
        );
    }

//    public String getUserEmail() {
//        return userEmail;
//    }
//
//    public void setUserEmail(String userID) {
//        this.userEmail = userID;
//    }

    @Override
    public String toString() {
        return "MyList{" +
                "name='" + name + '\'' +
                ", myList=" + myList +
                '}';
    }
}
