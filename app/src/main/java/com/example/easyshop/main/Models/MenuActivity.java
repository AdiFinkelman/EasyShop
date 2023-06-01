package com.example.easyshop.main.Models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.easyshop.R;
import com.example.easyshop.main.Logic.DataManager;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu);

        AppCompatImageButton createBTN = findViewById(DataManager.getCreate_menu_BTN());
        createBTN.setOnClickListener(v -> openCategoriesActivity());

        AppCompatImageButton myListBTN = findViewById(DataManager.getMyList_menu_BTN());
        myListBTN.setOnClickListener(v -> openMyListActivity());
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
}