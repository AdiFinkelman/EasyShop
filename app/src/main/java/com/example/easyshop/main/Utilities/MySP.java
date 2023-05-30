package com.example.easyshop.main.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.easyshop.main.Models.CreatedList;
import com.google.gson.Gson;

public class MySP {
    private static final String DB_FILE = "DB_FILE";
    private static MySP instance = null;
    private SharedPreferences sharedPreferences;

    private MySP(Context context) {
        sharedPreferences = context.getSharedPreferences(DB_FILE, Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new MySP(context);
        }
    }

    public static MySP getInstance() {
        return instance;
    }

    public String getString(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public int getInt(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    public void putInt(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public CreatedList loadFromJson() {
        String fromSP = getString("ObstacleRaceGame", "");
        Log.d("", fromSP);
        CreatedList customListFromJson = new Gson().fromJson(fromSP, CreatedList.class);
        Log.d("", "" + customListFromJson);
        if (customListFromJson == null)
            customListFromJson = new CreatedList(null);

        return customListFromJson;
    }

    public void saveToJason(int type, String name, double price, int quantity) {
        CreatedList createdList;
        createdList = loadFromJson();
        createdList.addItem(name, price, quantity);
        String jsonStr = new Gson().toJson(createdList);
        putString("ObstacleRaceGame", jsonStr);
        Log.d("jsonStr", jsonStr.toString());
    }
}
