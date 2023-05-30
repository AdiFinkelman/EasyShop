package com.example.easyshop.main.Models;

import java.util.ArrayList;

//First Fragment
public class CategoryList {
    private String name = "";
    private ArrayList<Item> itemsList = new ArrayList<>();

    public CategoryList(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public String getName() { return name; }

    public CategoryList setName(String name) {
        this.name = name;
        return this;
    }

    public ArrayList<Item> getCategory() { return itemsList; }

    public CategoryList setCategory(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
        return this;
    }

    @Override
    public String toString() {
        return "CategoryList{" +
                "name='" + name + '\'' +
                ", itemsList=" + itemsList +
                '}';
    }
}