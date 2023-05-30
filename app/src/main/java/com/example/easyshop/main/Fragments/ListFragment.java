package com.example.easyshop.main.Fragments;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyshop.R;
import com.example.easyshop.main.Adapters.CreatingAdapter;
import com.example.easyshop.main.Adapters.ListAdapter;
import com.example.easyshop.main.Interfaces.Spinner_Callback;
import com.example.easyshop.main.Logic.DataManager;
import com.example.easyshop.main.Models.CategoryList;
import com.example.easyshop.main.Models.CreatedList;
import com.example.easyshop.main.Models.Item;

import java.util.ArrayList;

public class ListFragment extends Fragment implements Spinner_Callback {

    private RecyclerView created_RV_LST;
    private CreatedList createdList;
    private AppCompatButton clear_BTN;
    private AppCompatButton save_BTN;
    private ArrayList<Item> newList = new ArrayList<>();
    private ListAdapter listAdapter = new ListAdapter(createdList);

//    Spinner_Callback spinner_callback = new Spinner_Callback() {
//        @Override
//        public void spinnerClicked(Item selectedItem) {
//            newList.add(selectedItem);
//        }
//    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        findViews(view);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        newList = new ArrayList<>();
        createdList = new CreatedList(newList);
        listAdapter = new ListAdapter(createdList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        created_RV_LST.setAdapter(listAdapter);
        created_RV_LST.setLayoutManager(linearLayoutManager);
    }

    private void findViews(View view) {
        created_RV_LST = view.findViewById(DataManager.getMyList_RV_list());
        clear_BTN = view.findViewById(DataManager.getCreation_BTN_clear());
        save_BTN = view.findViewById(DataManager.getCreation_btn_save());
    }

    public void addItem(Item selectedItem) {
        newList.add(selectedItem);
    }

    @Override
    public void spinnerClicked(Item selectedItem) {
        addItem(selectedItem);
    }
}