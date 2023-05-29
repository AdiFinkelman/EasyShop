package com.example.easyshop.main.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyshop.R;
import com.example.easyshop.main.Adapters.CreatingAdapter;
import com.example.easyshop.main.Logic.DataManager;
import com.example.easyshop.main.Models.CreationList;
import com.example.easyshop.main.Models.Item;

import java.util.ArrayList;

public class CreationFragment extends Fragment {

    private RecyclerView creation_RV_list;
    private AppCompatTextView creation_TXT_title;
    private CreationList creationList;
    private static ArrayList<Item> category = new ArrayList<>();
    private int categoryType;
    Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_creation, container, false);
        findViews(view);
        getCategoryType();
        initCategories();
        filterCategoryItems();
        initViews(view);

        return view;
    }

    private void initViews(View view) {
        creationList = new CreationList(category);
        creation_TXT_title.setText(getCategoryName(categoryType));
        CreatingAdapter creatingAdapter = new CreatingAdapter(creationList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        creation_RV_list.setAdapter(creatingAdapter);
        creation_RV_list.setLayoutManager(linearLayoutManager);
    }

    private String getCategoryName(int categoryType) {
        String categoryName = "";

        if (categoryType == DataManager.getCategory_vegetables())
                categoryName = "Vegetables";

        else if (categoryType == DataManager.getCategory_fruits())
            categoryName = "Fruits";

        return categoryName;
    }

    private void findViews(View view) {
        creation_RV_list = view.findViewById(DataManager.getCreation_rv_list());
        creation_TXT_title = view.findViewById(DataManager.getCreation_TXT_title());
        spinner = view.findViewById(R.id.popup_Spinner_quantity);
    }

    private void getCategoryType() {
        categoryType = getActivity().getIntent().getIntExtra("categoryType", 0);
    }

    public static void initCategories() {
        clearCategories();
        category = DataManager.getCategory();
    }

    public void filterCategoryItems() {
        ArrayList<Item> filteredCategory = new ArrayList<>();

        for (Item item : category) {
            if (item.getType() == categoryType) {
                filteredCategory.add(item);
            }
        }
        category = filteredCategory;
    }

    public static void clearCategories() {
        category.clear();
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }

}