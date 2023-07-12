package com.example.easyshop.main.Models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.easyshop.R;
import com.example.easyshop.main.Logic.DataManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuActivity extends AppCompatActivity {
    FirebaseAuth auth;
    AppCompatImageButton button;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu);

        buttonsClicked();

        auth = FirebaseAuth.getInstance();
        findViews();
        user = auth.getCurrentUser();
        if (user == null) {
            openLoginActivity();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                openLoginActivity();
            }
        });
    }

    private void buttonsClicked() {
        AppCompatImageButton createBTN = findViewById(DataManager.getCreate_menu_BTN());
        createBTN.setOnClickListener(v -> openCategoriesActivity());

        AppCompatImageButton myListBTN = findViewById(DataManager.getMyList_menu_BTN());
        myListBTN.setOnClickListener(v -> openMyListActivity());

        AppCompatImageButton mapBTN = findViewById(DataManager.getMap_menu_BTN());
        mapBTN.setOnClickListener(v -> openMapActivity());
    }

    private void openMapActivity() {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
        finish();
    }

    private void openMyListActivity() {
        Intent intent = new Intent(this, MyListActivity.class);
        startActivity(intent);
        finish();
    }

    private void openCategoriesActivity() {
        Intent intent = new Intent(this, CategoriesActivity.class);
        startActivity(intent);
        finish();
    }

    private void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void findViews() {
        button = findViewById(DataManager.getLogoutBTN());
    }

}