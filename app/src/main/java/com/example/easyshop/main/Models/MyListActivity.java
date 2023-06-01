package com.example.easyshop.main.Models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.easyshop.R;
import com.example.easyshop.main.Adapters.MyListAdapter;
import com.example.easyshop.main.Fragments.ListFragment;
import com.example.easyshop.main.Interfaces.Save_Callback;
import com.example.easyshop.main.Logic.DataManager;
import com.example.easyshop.main.Object.Item;
import com.example.easyshop.main.Object.MyList;

import java.util.ArrayList;

public class MyListActivity extends AppCompatActivity implements Save_Callback {

    private RecyclerView myList_recyclerView;
    private AppCompatTextView myList_TXT_value;
    private MyListAdapter myListAdapter;
    private MyList myList;
    private ArrayList<Item> shopList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        findViews();
        initViews();
        calcValue(shopList);
    }

    private void initViews() {
        shopList = DataManager.getMyList();
        myList = new MyList(shopList);
        myListAdapter = new MyListAdapter(myList, this);
        myList_recyclerView.setAdapter(myListAdapter);
        myList_recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void findViews() {
        myList_recyclerView = findViewById(DataManager.getMyList_RV_list());
        myList_TXT_value = findViewById(DataManager.getMyList_TXT_value());
    }

    public void addToMyList(ArrayList<Item> createdList) {
        shopList.addAll(createdList);
        Log.d("", "SHOP LIST" + shopList);
        myListAdapter.notifyDataSetChanged();
        calcValue(shopList);
    }

    private void calcValue(ArrayList<Item> createdList) {
        double value = 0;
        for (Item item: createdList) {
            value += item.getPrice();
        }
        myList_TXT_value.setText("Total value: " + value);
    }

    @Override
    public void onSaveClicked(ArrayList<Item> itemsList) {
        addToMyList(itemsList);
    }

    @Override
    public void onBackPressed() {
        openMenuActivity();
    }

    private void openMenuActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }
}