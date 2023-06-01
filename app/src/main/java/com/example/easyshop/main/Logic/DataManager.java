package com.example.easyshop.main.Logic;

import com.example.easyshop.R;
import com.example.easyshop.main.Object.Item;

import java.util.ArrayList;

public class DataManager {
    //Menu Buttons
    private static final int create_menu_BTN = R.id.create_menu_BTN;
    private static final int myList_menu_BTN = R.id.myList_menu_BTN;
    private static final int map_menu_BTN = R.id.map_menu_BTN;

    //Categories Activity Buttons
    private static final int category_vegetables = R.id.category_vegetables;
    private static final int category_butchery = R.id.category_butchery;
    private static final int category_dairy = R.id.category_dairy;
    private static final int category_beverages = R.id.category_beverages;
    private static final int category_fruits = R.id.category_fruits;
    private static final int category_bakery = R.id.category_bakery;
    private static final int category_dry_and_canned = R.id.category_dryncanned;
    private static final int category_snacks = R.id.category_snacks;

    //creationFragment
    private static final int creation_RV_list = R.id.creation_RV_list;
    private static final int creation_TXT_title = R.id.creation_TXT_title;
    private static ArrayList<Item> category = new ArrayList<>();

    //Category Item
    private static final int categoryItem_TXT_name = R.id.categoryItem_TXT_name;
    private static final int categoryItem_TXT_price = R.id.categoryItem_TXT_price;
    private static final int spinner_quantity = R.id.popup_Spinner_quantity;

    //My List Item
    private static final int myListItem_TXT_name = R.id.myListItem_TXT_name;
    private static final int myListItem_TXT_price = R.id.myListItem_TXT_price;
    private static final int myListItem_TXT_quantity = R.id.myListItem_TXT_quantity;
    private static final int myListItem_LAYOUT = R.id.myListItem_LAYOUT;

    //ListFragment
    private static final int toList_RV_list = R.id.toList_RV_list;
    private static final int toList_BTN_clear = R.id.toList_BTN_clear;
    private static final int toList_btn_save = R.id.toList_BTN_save;

    //MyList Activity
    private static final int myList_RV_list = R.id.myList_RV_list;
    private static final int myList_TXT_value = R.id.myList_TXT_value;
    private static ArrayList<Item> myList = new ArrayList<>();

    public static int getCreate_menu_BTN() { return create_menu_BTN; }

    public static int getMyList_menu_BTN() { return myList_menu_BTN; }

    public static int getMap_menu_BTN() { return map_menu_BTN; }

    public static int getCategory_vegetables() { return category_vegetables; }
    public static int getCategory_butchery() { return category_butchery; }
    public static int getCategory_dairy() { return category_dairy; }
    public static int getCategory_beverages() { return category_beverages; }
    public static int getCategory_fruits() { return category_fruits; }
    public static int getCategory_bakery() { return category_bakery; }
    public static int getCategory_dry_and_canned() { return category_dry_and_canned; }
    public static int getCategory_snacks() { return category_snacks; }

    public static int getCreation_RV_list() { return creation_RV_list; }
    public static int getCreation_TXT_title() { return creation_TXT_title; }

    public static int getCategoryItem_TXT_name() { return categoryItem_TXT_name; }

    public static int getCategoryItem_TXT_price() { return categoryItem_TXT_price; }

    public static int getSpinner_quantity() { return spinner_quantity; }

    public static int getToList_RV_list() { return toList_RV_list; }

    public static int getToList_BTN_clear() { return toList_BTN_clear; }

    public static int getToList_btn_save() { return toList_btn_save; }

    public static int getMyListItem_TXT_name() { return myListItem_TXT_name; }

    public static int getMyListItem_TXT_price() { return myListItem_TXT_price; }

    public static int getMyListItem_TXT_quantity() { return myListItem_TXT_quantity; }
    public static int getMyListItem_LAYOUT() { return  myListItem_LAYOUT; }

    public static int getMyList_RV_list() { return myList_RV_list; }

    public static int getMyList_TXT_value() { return  myList_TXT_value; }

    public static ArrayList<Item> getMyList() { return myList; }

    public static ArrayList<Item> getCategory() {
        initCategories();
        return category;
    }

    public static void initCategories() {
        category.clear();
        initVegetables();
        initFruits();
    }

    private static void initVegetables() {
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Tomato")
                .setPrice(2.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Cucumber")
                .setPrice(2.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Onion")
                .setPrice(2.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Pepper")
                .setPrice(3.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Potato")
                .setPrice(1.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Carrot")
                .setPrice(2.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Garlic")
                .setPrice(1.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Hot Chilli Pepper")
                .setPrice(3.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Celery")
                .setPrice(1.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Lettuce")
                .setPrice(1.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Mushrooms")
                .setPrice(1.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Broccoli")
                .setPrice(1.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Beet")
                .setPrice(2.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Cabbage")
                .setPrice(1.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Zucchini")
                .setPrice(2.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Cauliflower")
                .setPrice(3.0)
                .setQuantity(0)
        );
    }

    private static void initFruits() {
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Watermelon")
                .setPrice(1.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Melon")
                .setPrice(2.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Kiwi")
                .setPrice(4.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Strawberry")
                .setPrice(2.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Lemon")
                .setPrice(2.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Banana")
                .setPrice(4.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Apple")
                .setPrice(5.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Tangerine")
                .setPrice(4.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Orange")
                .setPrice(3.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Avocado")
                .setPrice(6.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Papaya")
                .setPrice(7.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Cherry")
                .setPrice(4.0)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Pear")
                .setPrice(4.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Palm Date")
                .setPrice(1.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Peach")
                .setPrice(4.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Grapefruit")
                .setPrice(2.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Pineapple")
                .setPrice(7.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Mango")
                .setPrice(3.5)
                .setQuantity(0)
        );
    }
}
