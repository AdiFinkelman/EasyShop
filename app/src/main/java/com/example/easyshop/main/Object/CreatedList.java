package com.example.easyshop.main.Object;

import java.util.ArrayList;

//Second Fragment
public class CreatedList {
    private String name = "";
    private ArrayList<Item> createdList = new ArrayList<>();

    public CreatedList(ArrayList<Item> createdList) {
        this.createdList = createdList;
    }

    public String getName() { return name; }

    public CreatedList setName(String name) {
        this.name = name;
        return this;
    }

    public ArrayList<Item> getList() { return createdList; }

    public CreatedList setList(ArrayList<Item> createdList) {
        this.createdList = createdList;
        return this;
    }

    public void addItem(String name, double price, int quantity) {
        createdList.add(new Item()
                .setName(name)
                .setPrice(price)
                .setQuantity(quantity)
        );
    }

    @Override
    public String toString() {
        return "CreatedList{" +
                "name='" + name + '\'' +
                ", createdList=" + createdList +
                '}';
    }
}
