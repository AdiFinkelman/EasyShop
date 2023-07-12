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

    public static boolean isPriceWithWeight(Item item) {
        if (item.getType() == getCategory_vegetables() ||
                item.getType() == getCategory_fruits() ||
                item.getType() == getCategory_butchery())
            return true;
        return false;
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
        initBakery();
        initDairy();
        initDryNCanned();
        initBeverages();
        initSnacks();
    }

    private static void initVegetables() {
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Tomato")
                .setPrice(7.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Cucumber")
                .setPrice(7.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Onion")
                .setPrice(6.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Pepper")
                .setPrice(11.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );

        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Potato")
                .setPrice(4.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Carrot")
                .setPrice(5.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Garlic")
                .setPrice(5.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Chilli")
                .setPrice(11.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Celery")
                .setPrice(6.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Lettuce")
                .setPrice(4.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Mushrooms")
                .setPrice(40.2)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Broccoli")
                .setPrice(9.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Beet")
                .setPrice(5.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Cabbage")
                .setPrice(29.5)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Zucchini")
                .setPrice(8.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_vegetables())
                .setName("Cauliflower")
                .setPrice(11.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.VEGETABLES)
        );
    }

    private static void initFruits() {
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Watermelon")
                .setPrice(4.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Melon")
                .setPrice(6.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Kiwi")
                .setPrice(14.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Strawberry")
                .setPrice(30)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Lemon")
                .setPrice(6.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Banana")
                .setPrice(6.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Apple")
                .setPrice(11.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Tangerine")
                .setPrice(6.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Orange")
                .setPrice(6.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Avocado")
                .setPrice(19.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Papaya")
                .setPrice(24.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Cherry")
                .setPrice(70)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Pear")
                .setPrice(14.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Palm Date")
                .setPrice(32.3)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Peach")
                .setPrice(16.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Grapefruit")
                .setPrice(5.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Pineapple")
                .setPrice(29.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_fruits())
                .setName("Grapes")
                .setPrice(20.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.FRUITS)
        );
    }

    private static void initButchery() {
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setName("Entrecote")
                .setPrice(129.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BUTCHERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setName("Ribs")
                .setPrice(69.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BUTCHERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setName("Picanha")
                .setPrice(140)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BUTCHERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setName("Sirloin")
                .setPrice(140)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BUTCHERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setName("Salmon")
                .setPrice(75)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BUTCHERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setName("Tilapia")
                .setPrice(30)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BUTCHERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setName("Tuna")
                .setPrice(45)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BUTCHERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setName("Chicken breast")
                .setPrice(45)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BUTCHERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setName("Chicken thighs")
                .setPrice(30)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BUTCHERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setName("Schnitzel")
                .setPrice(38)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BUTCHERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_butchery())
                .setName("Wings")
                .setPrice(13)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BUTCHERY)
        );
    }

    private static void initBakery() {
        category.add(new Item()
                .setType(DataManager.getCategory_bakery())
                .setName("White read")
                .setPrice(14.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BAKERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_bakery())
                .setName("Whole wheat bread")
                .setPrice(16.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BAKERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_bakery())
                .setName("Pita")
                .setPrice(4.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BAKERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_bakery())
                .setName("Baguette")
                .setPrice(5.3)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BAKERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_bakery())
                .setName("Bun")
                .setPrice(1.49)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BAKERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_bakery())
                .setName("Pretzels")
                .setPrice(3.73)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BAKERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_bakery())
                .setName("Burger buns")
                .setPrice(2.98)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BAKERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_bakery())
                .setName("Sweet challah")
                .setPrice(13.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BAKERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_bakery())
                .setName("Yeast cake")
                .setPrice(26.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BAKERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_bakery())
                .setName("Chocolate chip cookies")
                .setPrice(22.0)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BAKERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_bakery())
                .setName("Croissant")
                .setPrice(14.85)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BAKERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_bakery())
                .setName("Cheese Burekas")
                .setPrice(14.85)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BAKERY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_bakery())
                .setName("Potato Burekas")
                .setPrice(13.95)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BAKERY)
        );
    }

    private static void initDairy() {
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Yogurt")
                .setPrice(4.1)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Milk 3%")
                .setPrice(6.81)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Milk 1%")
                .setPrice(6.41)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Eggs")
                .setPrice(13.97)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Ricotta")
                .setPrice(20.7)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Cottage")
                .setPrice(5.7)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Cream cheese")
                .setPrice(5.43)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Mozzarella")
                .setPrice(4.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Gouda")
                .setPrice(11.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Yellow cheese")
                .setPrice(17.3)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Bulgarian cheese")
                .setPrice(25.3)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Goat feta")
                .setPrice(25.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Parmesan")
                .setPrice(25.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Cheddar")
                .setPrice(18.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dairy())
                .setName("Butter")
                .setPrice(12.5)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DAIRY)
        );
    }

    private static void initDryNCanned() {
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Pasta")
                .setPrice(5.0)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Lasagna")
                .setPrice(21.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Noodles")
                .setPrice(9.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Egg barley")
                .setPrice(7.4)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Rice")
                .setPrice(10.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Couscous")
                .setPrice(8.5)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Tomato sauce")
                .setPrice(6.5)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Canned tuna")
                .setPrice(19.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Sardines")
                .setPrice(5.3)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Corn")
                .setPrice(8.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Beans")
                .setPrice(9.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Pickle")
                .setPrice(6.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Olives")
                .setPrice(7.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Tehina")
                .setPrice(14.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Teriyaki")
                .setPrice(12.0)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Barbecue")
                .setPrice(12.0)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Soya")
                .setPrice(12.0)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Mayonnaise")
                .setPrice(12.7)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Ketchup")
                .setPrice(9.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Mustard")
                .setPrice(8.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Olive oil")
                .setPrice(36.0)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Oil")
                .setPrice(9.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Salt")
                .setPrice(4.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Sugar")
                .setPrice(10.8)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Flour")
                .setPrice(4.5)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Paprika")
                .setPrice(9.5)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_dry_and_canned())
                .setName("Black pepper")
                .setPrice(12.5)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.DRY_N_CANNED)
        );
    }

    private static void initBeverages() {
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Water")
                .setPrice(16.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Orange juice")
                .setPrice(6.0)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Sprite")
                .setPrice(6.7)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Coca cola")
                .setPrice(4.0)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Soda")
                .setPrice(2.5)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Carlsberg")
                .setPrice(31.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Gold star")
                .setPrice(29.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Heineken")
                .setPrice(27.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Red wine")
                .setPrice(54.0)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("White wine")
                .setPrice(54.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Rose wine")
                .setPrice(65.0)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Black coffee")
                .setPrice(15.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Nescafe")
                .setPrice(21.1)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Tea bags")
                .setPrice(34.0)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Whiskey")
                .setPrice(309.0)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Vodka")
                .setPrice(79.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_beverages())
                .setName("Whiskey Johnny Walker")
                .setPrice(309.0)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.BEVERAGES)
        );
    }

    private static void initSnacks() {
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Beasley")
                .setPrice(4.6)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Cheetos")
                .setPrice(3.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Fitness")
                .setPrice(5.2)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Doritos")
                .setPrice(4.0)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Apropos")
                .setPrice(5.2)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Bamba")
                .setPrice(4.3)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Potato chips")
                .setPrice(4.3)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Pringles")
                .setPrice(10.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Bagels")
                .setPrice(11.6)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Popcorn")
                .setPrice(15.5)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Gum")
                .setPrice(10.5)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Chocolate")
                .setPrice(5.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Dark chocolate")
                .setPrice(9.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Milka")
                .setPrice(7.9)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("White chocolate")
                .setPrice(5.6)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Snickers")
                .setPrice(4.3)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Twix")
                .setPrice(4.3)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
        category.add(new Item()
                .setType(DataManager.getCategory_snacks())
                .setName("Mars")
                .setPrice(4.3)
                .setQuantity(0)
                .setCategory(Item.CATEGORY.SNACKS)
        );
    }
}