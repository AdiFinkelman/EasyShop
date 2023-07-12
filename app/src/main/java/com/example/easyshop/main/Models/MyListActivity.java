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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        myList = new MyList().setList(shopList).setUserEmail(LoginActivity.userEmail);
        loadFromFirebase(LoginActivity.userEmail, new Database_Callback() {
            @Override
            public void myListCallback(ArrayList<Item> shopList) {
                MyList temp = new MyList().setList(shopList).setUserEmail(LoginActivity.userEmail);
                myList_recyclerView.setLayoutManager(new LinearLayoutManager(MyListActivity.this));
                myList_recyclerView.setAdapter(new MyListAdapter(temp, MyListActivity.this));
                myListAdapter.notifyDataSetChanged();
            }
        });

        myListAdapter = new MyListAdapter(myList, this);
    }

    private void findViews() {
        myList_recyclerView = findViewById(DataManager.getMyList_RV_list());
        myList_TXT_value = findViewById(DataManager.getMyList_TXT_value());
    }

    public void calcValue(ArrayList<Item> createdList) {
        double value = 0;
        for (Item item : createdList) {
            value += item.getPrice();
        }

        myList_TXT_value.setText("Total value: " + DataManager.getDfFormat(value) + " ₪");
    }

    public void loadFromFirebase(String userEmail, final Database_Callback callback) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("lists");

        reference.orderByChild("userEmail").equalTo(userEmail).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                shopList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    MyList myList_db = dataSnapshot.getValue(MyList.class);
                    shopList = myList_db.getList();
                    myList.setList(shopList);
                    myListAdapter.notifyDataSetChanged();
                    calcValue(shopList);
                    Log.d("", "MY LIST: " + myList);
                }
                callback.myListCallback(shopList);
            }

            @Override
            public void onCancelled (@NonNull DatabaseError error){
                // Handle the error case
                Log.d("MyListActivity", "Failed to load data from Firebase: " + error.getMessage());
            }
        });
    }

    @Override
    public void onSaveClicked(ArrayList<Item> itemsList) {
        myList.setList(itemsList);
        myListAdapter.notifyDataSetChanged();
        calcValue(shopList);
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