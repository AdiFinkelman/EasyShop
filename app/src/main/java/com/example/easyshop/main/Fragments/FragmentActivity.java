package com.example.easyshop.main.Fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.easyshop.R;
import com.example.easyshop.main.Logic.DataManager;
import com.example.easyshop.main.Models.CategoriesActivity;
import com.example.easyshop.main.Models.MenuActivity;

public class FragmentActivity extends AppCompatActivity {
    private CreationFragment creationFragment;
    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        initFragments();
        beginTransactions();
    }

    private void beginTransactions() {
        getSupportFragmentManager().beginTransaction().add(R.id.main_FRAME_creation, creationFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_FRAME_list, listFragment).commit();
    }

    private void initFragments() {
        creationFragment = new CreationFragment();
        listFragment = new ListFragment();
    }

    @Override
    public void onBackPressed() {
        openCategoriesActivity();
    }

    private void openCategoriesActivity() {
        Intent intent = new Intent(this, CategoriesActivity.class);
        startActivity(intent);
        finish();
    }
}