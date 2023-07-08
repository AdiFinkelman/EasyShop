package com.example.easyshop.main.Models;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.easyshop.R;
import com.example.easyshop.main.Adapters.MyListAdapter;
import com.example.easyshop.main.Interfaces.Database_Callback;
import com.example.easyshop.main.Interfaces.Save_Callback;
import com.example.easyshop.main.Logic.DataManager;
import com.example.easyshop.main.Object.Item;
import com.example.easyshop.main.Object.MyList;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyListActivity extends AppCompatActivity implements Save_Callback {

    private RecyclerView myList_recyclerView;
    private AppCompatTextView myList_TXT_value;
    private MyListAdapter myListAdapter;
    private MyList myList;
    private ArrayList<Item> shopList;
    FirebaseAuth firebaseAuth;

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
        //myList = new MyList(shopList, LoginActivity.userEmail);
        //myList = loadFromFirebase();  // line to handle

        myListAdapter = new MyListAdapter(myList, this);
        myList_recyclerView.setAdapter(myListAdapter);
        myList_recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myList_recyclerView.getAdapter();
    }

    private void findViews() {
        myList_recyclerView = findViewById(DataManager.getMyList_RV_list());
        myList_TXT_value = findViewById(DataManager.getMyList_TXT_value());
    }

    public void addToMyList(ArrayList<Item> createdList) {
        shopList.addAll(createdList);
        Log.d("", "SHOP LIST" + shopList);
        myList.setList(shopList);
        myListAdapter.notifyDataSetChanged();
        calcValue(shopList);
    }

    private void calcValue(ArrayList<Item> createdList) {
        double value = 0;
        for (Item item : createdList) {
            value += item.getPrice();
        }

        myList_TXT_value.setText("Total value: " + DataManager.getDfFormat(value) + " ₪");
    }

    private MyList loadFromFirebase(String userEmail, final Database_Callback database_callback) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("lists");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                shopList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    MyList myList = dataSnapshot.getValue(MyList.class);
                    if (myList != null && myList.getName().equals(userEmail)) {
                        shopList.addAll(myList.getList());
                        myListAdapter.notifyDataSetChanged();
                        calcValue(shopList);
                        break;
                    }
                }
                database_callback.myListCallback(shopList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle the error case
                Log.d("MyListActivity", "Failed to load data from Firebase: " + error.getMessage());
            }
        });
        return myList;
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