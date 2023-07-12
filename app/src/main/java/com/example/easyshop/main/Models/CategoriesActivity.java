package com.example.easyshop.main.Models;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.easyshop.R;
import com.example.easyshop.main.Fragments.FragmentActivity;
import com.example.easyshop.main.Logic.DataManager;

public class CategoriesActivity extends AppCompatActivity {
    CardView vegetables_BTN;
    CardView fruits_BTN;
    CardView butchery_BTN;
    CardView bakery_BTN;
    CardView dairy_BTN;
    CardView dry_n_canned_BTN;
    CardView beverages_BTN;
    CardView snacks_BTN;
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
        onClickCategory(bakery_BTN, DataManager.getCategory_bakery());
        onClickCategory(dairy_BTN, DataManager.getCategory_dairy());
        onClickCategory(dry_n_canned_BTN, DataManager.getCategory_dry_and_canned());
        onClickCategory(beverages_BTN, DataManager.getCategory_beverages());
        onClickCategory(snacks_BTN, DataManager.getCategory_snacks());
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
        bakery_BTN = findViewById(DataManager.getCategory_bakery());
        dairy_BTN = findViewById(DataManager.getCategory_dairy());
        dry_n_canned_BTN = findViewById(DataManager.getCategory_dry_and_canned());
        beverages_BTN = findViewById(DataManager.getCategory_beverages());
        snacks_BTN = findViewById(DataManager.getCategory_snacks());
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