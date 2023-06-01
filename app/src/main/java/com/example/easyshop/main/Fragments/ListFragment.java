package com.example.easyshop.main.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyshop.R;
import com.example.easyshop.main.Adapters.ListAdapter;
import com.example.easyshop.main.Interfaces.Save_Callback;
import com.example.easyshop.main.Interfaces.Spinner_Callback;
import com.example.easyshop.main.Logic.DataManager;
import com.example.easyshop.main.Object.CreatedList;
import com.example.easyshop.main.Object.Item;

import java.util.ArrayList;

public class ListFragment extends Fragment implements Spinner_Callback {

    private RecyclerView created_RV_LST;
    private CreatedList createdList;
    private AppCompatButton clear_BTN;
    private AppCompatButton save_BTN;
    private ArrayList<Item> newList = new ArrayList<>();
    private ArrayList<Item> myList = DataManager.getMyList();
    private Save_Callback save_callback;
    private ListAdapter listAdapter = new ListAdapter(createdList, save_callback);

    public ListFragment(Save_Callback save_callback){
        this.save_callback = save_callback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        findViews(view);
        initViews(view);
        saveToMyList();
        clearCreatingList();
        return view;
    }

    private void initViews(View view) {
        newList = new ArrayList<>();
//        createdList = MySP.getInstance().loadFromJson();
        createdList = new CreatedList(newList);
        listAdapter = new ListAdapter(createdList, save_callback);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        created_RV_LST.setAdapter(listAdapter);
        created_RV_LST.setLayoutManager(linearLayoutManager);
    }

    private void findViews(View view) {
        created_RV_LST = view.findViewById(DataManager.getToList_RV_list());
        clear_BTN = view.findViewById(DataManager.getToList_BTN_clear());
        save_BTN = view.findViewById(DataManager.getToList_btn_save());
    }

    public void addItem(Item selectedItem) {
        if (newList.contains(selectedItem.getName())) {
            for (Item item : newList) {
                if (item.getName().equals(selectedItem.getName()))
                    item.setQuantity(selectedItem.getQuantity());
            }
        } else { newList.add(selectedItem); }
        listAdapter.notifyDataSetChanged();
        Log.d("" , "NEW LIST" + newList.toString());
    }

    public void saveToMyList() {
        save_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList.addAll(newList);
                newList.clear();
                initViews(v);

                if (save_callback != null) {
                    save_callback.onSaveClicked(myList);

                }
            }
        });
    }

    private void clearCreatingList() {
        clear_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newList.clear();
                initViews(v);
            }
        });
    }

    @Override
    public void spinnerClicked(Item selectedItem) {
        addItem(selectedItem);
    }

    public void setSave_callback(Save_Callback save_callback) {
        this.save_callback = save_callback;
    }
}