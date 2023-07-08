package com.example.easyshop.main.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyshop.R;
import com.example.easyshop.databinding.ActivityMenuBinding;
import com.example.easyshop.main.Adapters.ListAdapter;
import com.example.easyshop.main.Interfaces.Save_Callback;
import com.example.easyshop.main.Interfaces.Spinner_Callback;
import com.example.easyshop.main.Logic.DataManager;
import com.example.easyshop.main.Models.LoginActivity;
import com.example.easyshop.main.Models.RegisterActivity;
import com.example.easyshop.main.Object.CreatedList;
import com.example.easyshop.main.Object.Item;
import com.example.easyshop.main.Object.MyList;
import com.example.easyshop.main.Utilities.SignalGenerator;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        Log.d("" , "NEW LIST " + newList.toString());
    }

    public void saveToMyList() {
        save_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList.addAll(newList);

                String regEmail = RegisterActivity.userEmail;
                String loginEmail = LoginActivity.userEmail;
                String userEmail;
                if (regEmail != null)
                    userEmail = regEmail;
                else
                    userEmail = loginEmail;

                saveToFirebase(userEmail);

                SignalGenerator.getInstance().vibrate(400);
                SignalGenerator.getInstance().toast("You added " + newList.size() + " items", Toast.LENGTH_SHORT);
                newList.clear();
                initViews(v);

                if (save_callback != null) {
                    save_callback.onSaveClicked(myList);
                }
            }
        });
    }

    private void saveToFirebase(String userEmail) {
        MyList list = new MyList(myList, userEmail);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("lists");

        // Check if the list already exists based on a unique identifier
        reference.orderByChild("name").equalTo(userEmail).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // List already exists, update its data
                    for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                        String key = childSnapshot.getKey();
                        if (key != null) {
                            reference.child(key).setValue(list)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            SignalGenerator.getInstance().toast("My List updated successfully", Toast.LENGTH_SHORT);
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            SignalGenerator.getInstance().toast("Failed to update My List", Toast.LENGTH_SHORT);
                                        }
                                    });
                        }
                    }
                } else {
                    // List doesn't exist, create a new entry
                    String key = reference.push().getKey();
                    if (key != null) {
                        reference.child(key).setValue(list)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        SignalGenerator.getInstance().toast("My List created successfully", Toast.LENGTH_SHORT);
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        SignalGenerator.getInstance().toast("Failed to create My List", Toast.LENGTH_SHORT);
                                    }
                                });
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                SignalGenerator.getInstance().toast("Error retrieving My List data", Toast.LENGTH_SHORT);
            }
        });
    }


    private void clearCreatingList() {
        clear_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newList.clear();
                SignalGenerator.getInstance().vibrate(100);
                initViews(v);
            }
        });
    }

    @Override
    public void spinnerClicked(Item selectedItem) {
        addItem(selectedItem);
    }
}