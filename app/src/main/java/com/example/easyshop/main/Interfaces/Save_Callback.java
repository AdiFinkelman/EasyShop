package com.example.easyshop.main.Interfaces;

import com.example.easyshop.main.Object.Item;

import java.util.ArrayList;

public interface Save_Callback {
    void onSaveClicked(ArrayList<Item> itemsList);
}
