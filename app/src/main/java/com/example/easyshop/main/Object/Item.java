package com.example.easyshop.main.Object;


public class Item {
    public enum CATEGORY {
        VEGETABLES, FRUITS, BUTCHERY, BAKERY,
        DAIRY, DRY_N_CANNED, BEVERAGES, SNACKS
    }
    private int type;
    private String name;
    private double price;
    private double quantity;
    private CATEGORY category;

    public Item() {}

    public int getType() { return type; }

    public String getName() {
        return name;
    }

    public double getPrice() { return price; }

    public double getQuantity() { return quantity; }

    public CATEGORY getCategory() { return category; }

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

    public Item setQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public Item setCategory(CATEGORY category) {
        this.category = category;
        return this;
    }

    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}