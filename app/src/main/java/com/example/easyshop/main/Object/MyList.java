package com.example.easyshop.main.Object;

import java.util.ArrayList;

public class MyList {
    private String name = "";
    private ArrayList<Item> myList = new ArrayList<>();

    public MyList(ArrayList<Item> myList) {
        this.myList = myList;
    }

    public String getName() { return name; }

    public MyList setName(String name) {
        this.name = name;
        return this;
    }

    public ArrayList<Item> getList() { return myList; }

    public MyList setList(ArrayList<Item> createdList) {
        this.myList = createdList;
        return this;
    }

    public void addItem(String name, double price, int quantity) {
        myList.add(new Item()
                .setName(name)
                .setPrice(price)
                .setQuantity(quantity)
        );
    }

    @Override
    public String toString() {
        return "MyList{" +
                "name='" + name + '\'' +
                ", myList=" + myList +
                '}';
    }
}
