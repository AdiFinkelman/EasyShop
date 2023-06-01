package com.example.easyshop.main.Object;

import androidx.appcompat.app.AppCompatActivity;

public class Item extends AppCompatActivity {
    private int type;
    private String name;
    private double price;
    private int quantity;

    public Item() {
    }

    public int getType() { return type; }

    public String getName() {
        return name;
    }

    public double getPrice() { return price; }

    public int getQuantity() { return quantity; }

    public Item setType(int type) {
        this.type = type;
        return this;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public Item setPrice(double price) {
        this.price = price;
        return this;
    }

    public Item setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}