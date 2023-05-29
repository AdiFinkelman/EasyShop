package com.example.easyshop.main.Models;

import java.util.ArrayList;

public class CreationList {
    private String name = "";
    private ArrayList<Item> itemsList = new ArrayList<>();

    public CreationList(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public String getName() { return name; }

    public CreationList setName(String name) {
        this.name = name;
        return this;
    }

    public ArrayList<Item> getCategory() { return itemsList; }

    public CreationList setCategory(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
        return this;
    }

    public void addItem(String name, double price, int quantity) {
        itemsList.add(new Item()
                .setName(name)
                .setPrice(price)
                .setQuantity(quantity)
        );
    }

    @Override
    public String toString() {
        return "CreationList{" +
                "name='" + name + '\'' +
                ", itemsList=" + itemsList +
                '}';
    }
}
