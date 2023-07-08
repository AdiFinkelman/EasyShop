package com.example.easyshop.main.Models;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.easyshop.R;
import com.example.easyshop.main.Fragments.CreationFragment;
import com.example.easyshop.main.Fragments.FragmentActivity;
import com.example.easyshop.main.Logic.DataManager;

public class CategoriesActivity extends AppCompatActivity {
    CardView vegetables_BTN;
    CardView fruits_BTN;
    CardView butchery_BTN;
    private int categoryType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_categories);

        findViews();
        onClickCategory(vegetables_BTN, DataManager.getCategory_vegetables());
        onClickCategory(fruits_BTN, DataManager.getCategory_fruits());
        onClickCategory(butchery_BTN, DataManager.getCategory_butchery());
    }

    private void onClickCategory(CardView button, int category) {
        button.setOnClickListener(v -> {
            categoryType = category;
            openFragmentActivity();
        });
    }

    private void findViews() {
        vegetables_BTN = findViewById(DataManager.getCategory_vegetables());
        fruits_BTN = findViewById(DataManager.getCategory_fruits());
        butchery_BTN = findViewById(DataManager.getCategory_butchery());
    }

    private void openFragmentActivity() {
        Intent intent = new Intent(this, FragmentActivity.class);
        intent.putExtra("categoryType", categoryType);
        startActivity(intent);
        finish();
    }

    private void openMenuActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        openMenuActivity();
    }
}