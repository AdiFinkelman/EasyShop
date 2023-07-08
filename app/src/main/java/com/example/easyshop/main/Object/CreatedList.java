package com.example.easyshop.main.Object;

import java.util.ArrayList;

//Second Fragment
public class CreatedList {
    private String name = "";
    private ArrayList<Item> createdList;

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

    @Override
    public String toString() {
        return "CreatedList{" +
                "name='" + name + '\'' +
                ", createdList=" + createdList +
                '}';
    }
}
