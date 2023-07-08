package com.example.easyshop.main.Logic;

import com.example.easyshop.R;
import com.example.easyshop.main.Object.Item;

import java.text.DecimalFormat;
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
    //Map Activity
    private static final int myLocation_BTN_map = R.id.myLocation_BTN_map;
    public static DecimalFormat df = new DecimalFormat("#.##");
    //Register&Login
    private static final int editTextEmail = R.id.et_email;
    private static final int editTextPassword = R.id.et_password;
    private static final int regBTN = R.id.btn_register;
    private static final int loginBTN = R.id.btn_login;
    private static final int regProgressBar = R.id.progressBar;
    private static final int txtClickToLogin = R.id.loginNow;
    private static final int logoutBTN = R.id.menu_BTN_logout;

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
    public static int getMyLocation_BTN_map() { return myLocation_BTN_map; }
    public static String getDfFormat(double val) {
        return df.format(val);
    }

    public static int getEditTextEmail() { return editTextEmail; }
    public static int getEditTextPassword() { return editTextPassword; }
    public static int getRegBTN() { return regBTN; }
    public static int getLoginBTN() { return loginBTN; }
    public static int getRegProgressBar() { return regProgressBar; }
    public static int getTxtClickToLogin() { return txtClickToLogin; }
    public static int getLogoutBTN() {
        return logoutBTN;
    }

    public static ArrayList<Item> getCategory() {
        initCategories();
        return category;
    }

    public static void initCategories() {
        category.clear();
        initVegetables();
        initFruits();
        initButchery();
    }

    private static void initVegetables() {
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Tomato")
                .setPrice(7.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Cucumber")
                .setPrice(7.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Onion")
                .setPrice(6.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Pepper")
                .setPrice(11.9)
                .setQuantity(0)
        );

        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Potato")
                .setPrice(4.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Carrot")
                .setPrice(5.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Garlic")
                .setPrice(5.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Chilli")
                .setPrice(11.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Celery")
                .setPrice(6.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Lettuce")
                .setPrice(4.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Mushrooms")
                .setPrice(40.2)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Broccoli")
                .setPrice(9.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Beet")
                .setPrice(5.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Cabbage")
                .setPrice(29.5)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Zucchini")
                .setPrice(8.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setCategory(Item.CATEGORY.VEGETABLES)
                .setName("Cauliflower")
                .setPrice(11.9)
                .setQuantity(0)
        );
    }

    private static void initFruits() {
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Watermelon")
                .setPrice(4.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Melon")
                .setPrice(6.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Kiwi")
                .setPrice(14.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Strawberry")
                .setPrice(30)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Lemon")
                .setPrice(6.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Banana")
                .setPrice(6.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Apple")
                .setPrice(11.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Tangerine")
                .setPrice(6.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Orange")
                .setPrice(6.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Avocado")
                .setPrice(19.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Papaya")
                .setPrice(24.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Cherry")
                .setPrice(70)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Pear")
                .setPrice(14.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Palm Date")
                .setPrice(32.3)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Peach")
                .setPrice(16.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Grapefruit")
                .setPrice(5.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Pineapple")
                .setPrice(29.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setCategory(Item.CATEGORY.FRUITS)
                .setName("Grapes")
                .setPrice(20.9)
                .setQuantity(0)
        );
    }

    private static void initButchery() {
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setCategory(Item.CATEGORY.BUTCHERY)
                .setName("Entrecote")
                .setPrice(129.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setCategory(Item.CATEGORY.BUTCHERY)
                .setName("Ribs")
                .setPrice(69.9)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setCategory(Item.CATEGORY.BUTCHERY)
                .setName("Picanha")
                .setPrice(140)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setCategory(Item.CATEGORY.BUTCHERY)
                .setName("Sirloin")
                .setPrice(140)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setCategory(Item.CATEGORY.BUTCHERY)
                .setName("Salmon")
                .setPrice(75)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setCategory(Item.CATEGORY.BUTCHERY)
                .setName("Tilapia")
                .setPrice(30)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setCategory(Item.CATEGORY.BUTCHERY)
                .setName("Tuna")
                .setPrice(45)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setCategory(Item.CATEGORY.BUTCHERY)
                .setName("Chicken breast")
                .setPrice(45)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setCategory(Item.CATEGORY.BUTCHERY)
                .setName("Chicken thighs")
                .setPrice(30)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setCategory(Item.CATEGORY.BUTCHERY)
                .setName("Schnitzel")
                .setPrice(38)
                .setQuantity(0)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setCategory(Item.CATEGORY.BUTCHERY)
                .setName("Wings")
                .setPrice(13)
                .setQuantity(0)
        );
    }
}